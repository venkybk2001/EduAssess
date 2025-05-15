package com.springboot.jpa.mvc.Service;

import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.jpa.mvc.Dao.GTOLogRepo;
import com.springboot.jpa.mvc.Dao.GTORepo;
import com.springboot.jpa.mvc.Dao.LinkRepo;
import com.springboot.jpa.mvc.Dao.LogRepo;
import com.springboot.jpa.mvc.Dao.MCQLogRepo;
import com.springboot.jpa.mvc.Dao.MCQRepo;
import com.springboot.jpa.mvc.Dao.QuestionRepo;
import com.springboot.jpa.mvc.Dao.TestRepo;
import com.springboot.jpa.mvc.Dao.UserRepo;
import com.springboot.jpa.mvc.Dao.VideoSessionRepo;
import com.springboot.jpa.mvc.Entity.GTOBean;
import com.springboot.jpa.mvc.Entity.GTOLog;
import com.springboot.jpa.mvc.Entity.LinkBean;
import com.springboot.jpa.mvc.Entity.Log;
import com.springboot.jpa.mvc.Entity.MCQBean;
import com.springboot.jpa.mvc.Entity.MCQLog;
import com.springboot.jpa.mvc.Entity.Question;
import com.springboot.jpa.mvc.Entity.Result;
import com.springboot.jpa.mvc.Entity.Test;
import com.springboot.jpa.mvc.Entity.User;
import com.springboot.jpa.mvc.Entity.VideoSession;
import com.springboot.jpa.mvc.Util.Encryption;

@Service
public class AppServiceImpl implements AppService{
	
	LogRepo logRepo;
	TestRepo testRepo;
	UserRepo userRepo;
	QuestionRepo questionRepo;
	LinkRepo linkRepo;
	MCQRepo mcqRepo;
	GTORepo gtoRepo;
	GTOLogRepo gtoLogRepo;
	MCQLogRepo mcqLogRepo;
	Encryption encryption;
	VideoSessionRepo videoSessionRepo;
	
	public static final String DATE_FORMAT = "MMM dd, yyyy";
	
	@Autowired
	public AppServiceImpl(LogRepo logRepo, TestRepo testRepo, UserRepo userRepo, QuestionRepo questionRepo,
			LinkRepo linkRepo, MCQRepo mcqRepo, GTORepo gtoRepo, GTOLogRepo gtoLogRepo, MCQLogRepo mcqLogRepo, Encryption encryption, VideoSessionRepo videoSessionRepo) {
		super();
		this.logRepo = logRepo;
		this.testRepo = testRepo;
		this.userRepo = userRepo;
		this.questionRepo = questionRepo;
		this.linkRepo = linkRepo;
		this.mcqRepo = mcqRepo;
		this.gtoRepo = gtoRepo;
		this.gtoLogRepo = gtoLogRepo;
		this.mcqLogRepo = mcqLogRepo;
		this.encryption = encryption;
		this.videoSessionRepo =videoSessionRepo;
		
	}

	@Override
	@Transactional
	public int acceptreject(int id, int verify) {
		try{
			Log log=logRepo.findById(id).get();
			log.verify=verify;
			logRepo.save(log);
			return 1;
		}catch (Exception e){
			e.printStackTrace();
			return 0;
		}
	}

	@Override
	public List<Log> getAllLogsForVerification() {
		return logRepo.findBySubmitAndVerify(1, 0);
	}

	@Override
	@Transactional
	public int submit(int id) {
		try{
			Log log= logRepo.findById(id).get();
			log.setSubmit(1);
			logRepo.save(log);
			return 1;
		}
		catch (Exception e){
			e.printStackTrace();
			return 0;
		}
	}

	@Override
	@Transactional
	public int update(int id, String answer) {
		try{
		Log log=logRepo.findById(id).get();
		log.answer=answer;
		logRepo.save(log);
		return 1;
		}
		catch (Exception e){
			e.printStackTrace();
			return 0;
		}
	}

	@Override
	public List<?> giveMeTestLogs(int userId, int testId, String category ) {
		
		if(StringUtils.equals("WRITTEN", category)) {
			return findWrittenTest(userId, testId, category);
		}else if(StringUtils.equals("MCQ", category)) {
			return findMCQTest(userId, testId, category);
		}else if(StringUtils.equals("GTO", category)) {
			return findGTOTest(userId, testId, category);
		}
		return null;
		 
	}

	@Override
	public List<Test> giveActiveTests(String category) {
		
		
		List<Test> tests=testRepo.findByCategory(category);
		List<Test> testsUi=new ArrayList<>();
		
		Date date=new Date();
		long now=date.getTime();
		
		for(Test test:tests){
			Date start=test.getStart();
			Date end=test.getEnd();
			long startMili=start.getTime();
			long endMili=end.getTime();
			
			if(now>startMili && now<endMili){
				testsUi.add(test);
			}
		}
		
		return testsUi;
	}

	@Override
	@Transactional
	public Question addQuestion(String name) {
		Question question=new Question();
		question.name=name;
		return questionRepo.save(question);
	}

	@Override
	public List<Question> giveQuestion() {
		return questionRepo.findAll();
	}


	@Override
	@Transactional
	public Test addTest(Test test) {
		return testRepo.save(test);
	}

	@Override
	public List<Result> giveResultsByCategory(String category) {
		List<Result> listOfResult;
		if(StringUtils.equals("WRITTEN",category)) {
			listOfResult = giveWrittenTestById(category, 0);
		}else if(StringUtils.equals("MCQ",category)) {
			listOfResult = giveMCQTestById(category, 0);
		}else if(StringUtils.equals("GTO",category)) {
			listOfResult = giveGTOTestsById(category, 0);
		}else {
			listOfResult=new ArrayList<>();
		}
		return listOfResult;		
	}

	@Override
	public int[] login(String username, String password){
		//index0 -loginStatus
		//index1 - userid
		//index2 - role
		try{
			int[] a=new int[3];
		
			int count=userRepo.countByUsername(username);
			if(count==0){
				a[0]=1;//wrong username
				return a;
			}
			if(count>1){
				a[0]=2;//multiple accounts
				return a;
			}
			User user=userRepo.findByUsername(username);
			if(isPasswordCorrect(password,user.getPassword())){
				//Check user Status 1=Active, 0=Inactive
				if(user.getActiveStatus()==0) {
					a[0]=4;//User inActive
				}else {
					a[0]=0;//success
				}
				a[1]=user.id;
				a[2]=user.role;
				return a;
			}else{
				a[0]=3;//wrong password
				return a;
			}
		}catch (Exception e){
			e.printStackTrace();
			return null;
		}
		
	}

	@Override
	@Transactional
	public int register(User user) {
		try {
			int count=userRepo.countByUsername(user.getUsername());
			if(count==0) { 
				userRepo.save
					(new User(user.getName(), 
								user.getUsername(), 
									encryptPassword(user.getPassword()), 
										user.getRole(), 1));
				return 1;
			}else {
				return 2; ///username already taken
			}
			
		} catch (Exception e) {
			return 0;
		}
	}

	@Override
	@Transactional
	public int delete(int questionid) {
	    try {
	    	if(logRepo.existsByQuestionId(questionid)) {
	    		logRepo.setQuestionIdToNull(questionid);	
	    	}
	        questionRepo.deleteById(questionid);
	        return 1;
	    } catch (Exception e) {
	        e.printStackTrace();
	        return -1;
	    }
	}

	@Override
	public List<User> getStudentList() {
		return userRepo.findByRole(1);
	}

	@Override
	@Transactional
	public int deleteStudent(int studentId) {
		try {
			if(logRepo.existsByUserId(studentId)) {
				logRepo.setUserIdToNull(studentId);
			}
			if(gtoLogRepo.existsByUserId(studentId)) {
				gtoLogRepo.setUserIdToNull(studentId);
			}
	    	if(mcqLogRepo.existsByUserId(studentId)) {
		    	mcqLogRepo.setUserIdToNull(studentId);
	    	}
	        userRepo.deleteById(studentId);
	        return 1;
	    } catch (Exception e) {
	        e.printStackTrace();
	        return -1;
	    }
	}

	@Override
	@Transactional
	public int deactiveStudent(int studentId) {
		try {
			User user=userRepo.findById(studentId).get();
			user.setActiveStatus(0);
			userRepo.save(user);
			return 1;  //Request for student deactivation is Successful
		}catch (Exception e) {
			e.printStackTrace();
			return 0; //Request for student deactivation is unSuccessful
		}
	}

	@Override
	public int activateStudent(int studentId) {
		try {
			User user=userRepo.findById(studentId).get();
			user.setActiveStatus(1);
			userRepo.save(user);
			return 1;  //Request for student activation is Successful
		}catch (Exception e) {
			e.printStackTrace();
			return 0; //Request for student activation is unSuccessful
		}
	}

	@Override
	public List<LinkBean> getAllLink() {
		return linkRepo.findAll();
	}

	@Override
	@Transactional
	public int addMCQ(MCQBean mcqBean) {
		try {
			mcqRepo.save(mcqBean);
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}
	
	@Override
	public List<MCQBean> giveMCQQuestion() {
		return mcqRepo.findAll();
	}

	@Override
	@Transactional
	public int deleteMCQ(int mcqId) {
		try {
			if(mcqLogRepo.existsByMCQId(mcqId)) {
				mcqLogRepo.setMCQIdToNull(mcqId);
			}
			mcqRepo.deleteById(mcqId);
			return 1;
		} catch (Exception e) {
	        e.printStackTrace();
	        return -1;
		}
	}
	
	@Override
	@Transactional
	public int addGTO(GTOBean gtoBean) {
		try {
			gtoRepo.save(gtoBean);
			return 1;
		} catch (Exception e) {
			return 0;
		}
	}
	
	@Override
	public List<GTOBean> giveGTOQuestion() {
		return gtoRepo.findAll();
	}

	@Override
	@Transactional
	public int deleteGTO(int gtoId) {
		try {
			if(gtoLogRepo.existsByGTOId(gtoId)) {
				gtoLogRepo.setGTOIdToNull(gtoId);
			}
			gtoRepo.deleteById(gtoId);
			return 1;
		} catch (Exception e) {
	        e.printStackTrace();
	        return -1;
	    }
	}
	
	////Utils Methods
	public String encryptPassword(String password) {
		return encryption.encrypt(password);
	}
	
	public String decryptPassword(String password) {
		return encryption.decrypt(password);
	}
	
	public boolean isPasswordCorrect(String givenPassword, String originalPassword) {
		return StringUtils.equals(givenPassword, decryptPassword(originalPassword));
	}

	@Override
	@Transactional
	public int submitGto(int id, String answer) {
		try{
			GTOLog gtoLog= gtoLogRepo.findById(id).get();
			GTOBean gtoBean = gtoLog.getGtoBean();
			if(StringUtils.equals(gtoBean.output, answer)) {
				gtoLog.setAnswer(answer);
				gtoLog.setSubmit(1);
				gtoLogRepo.save(gtoLog);
				return 1;
			}else {
				return 2;
			}
		}
		catch (Exception e){
			e.printStackTrace();
			return 0;
		}
	}

	@Override
	@Transactional
	public int submitMcq(int id, String answer) {
		try {
			MCQLog mcqLog = mcqLogRepo.findById(id).get();
			mcqLog.setAnswer(answer);
			mcqLog.setSubmit(1);
			mcqLogRepo.save(mcqLog);
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

	private List<?> findGTOTest(int userId, int testId, String category) {
		int count = gtoLogRepo.countByUserIdAndTestId(userId, testId);
	    if (count == 0) {
	        Test test = testRepo.findById(testId).orElse(null);
	        User user = userRepo.findById(userId).orElse(null);
	        
	        if (test != null && user != null) {
	            for (int i = 0; i < test.getQuestionCount(); i++) {
	            	
	            	GTOLog gtoLog=new GTOLog();
	            	gtoLog.setAnswer("");
	                Optional<GTOBean> gtoOptional = gtoRepo.findRandomGTO();
	                if (gtoOptional.isPresent()) {
	                    GTOBean gto = gtoOptional.get();
	                    gtoLog.setGtoBean(gto);
	                    gtoLog.setSubmit(0);
	                    gtoLog.setTest(test);
	                    gtoLog.setUser(user);
	                    gtoLogRepo.save(gtoLog);
	                } else {
	                    System.err.println("No random question found");
	                }
	            }
	        } else {
	            System.err.println("Test or user not found");
	        }
	    }
	    return gtoLogRepo.findByUserIdAndTestId(userId, testId);
	}

	private List<?> findMCQTest(int userId, int testId,  String category) {
		int count = mcqLogRepo.countByUserIdAndTestId(userId, testId);
	    if (count == 0) {
	        Test test = testRepo.findById(testId).orElse(null);
	        User user = userRepo.findById(userId).orElse(null);
	        
	        if (test != null && user != null) {
	            for (int i = 0; i < test.getQuestionCount(); i++) {
	            	
	            	MCQLog mcqLog=new MCQLog();
	                Optional<MCQBean> mcqOptional = mcqRepo.findRandomMCQ();
	                if (mcqOptional.isPresent()) {
	                    MCQBean mcq = mcqOptional.get();
	                    mcqLog.setMcqBean(mcq);
	                    mcqLog.setSubmit(0);
	                    mcqLog.setTest(test);
	                    mcqLog.setUser(user);
	                    mcqLogRepo.save(mcqLog);
	                } else {
	                    System.err.println("No random question found");
	                }
	            }
	        } else {
	            System.err.println("Test or user not found");
	        }
	    }
	    return mcqLogRepo.findByUserIdAndTestId(userId, testId);
	}

	private List<?> findWrittenTest(int userId, int testId, String category) {
		int count = logRepo.countByUserIdAndTestId(userId, testId);
	    if (count == 0) {
	        Test test = testRepo.findById(testId).orElse(null);
	        User user = userRepo.findById(userId).orElse(null);
	        
	        if (test != null && user != null) {
	            for (int i = 0; i < test.getQuestionCount(); i++) {
	                Log log = new Log();
	                log.setAnswer("");
	                Optional<Question> questionOptional = questionRepo.findRandomQuestion();
	                if (questionOptional.isPresent()) {
	                    Question question = questionOptional.get();
	                    log.setQuestion(question);
	                    log.setSubmit(0);
	                    log.setTest(test);
	                    log.setUser(user);
	                    log.setVerify(0);
	                    logRepo.save(log);
	                } else {
	                    System.err.println("No random question found");
	                }
	            }
	        } else {
	            System.err.println("Test or user not found");
	        }
	    }
	    return logRepo.findByUserIdAndTestId(userId, testId);
	}

	@Override
	@Transactional
	public VideoSession addVideoSession(VideoSession videoSession) {
		VideoSession videoSessionAdd;
		try {
			videoSessionAdd = videoSessionRepo.save(videoSession);
		} catch (Exception e) {
			videoSessionAdd = null;
		}
		return videoSessionAdd;
	}

	@Override
	public VideoSession getVideoBy(int id) {
		VideoSession videoSession = new VideoSession();
		try {
			videoSession = videoSessionRepo.findById(id).get();
		} catch (Exception e) {
			return null;
		}
		return videoSession;
	}

	@Override
	public List<VideoSession> getAllVideos() {
		List<VideoSession> listOfVideos;
		try {
			listOfVideos = videoSessionRepo.findAll();
		} catch (Exception e) {
			listOfVideos = null;
		}
		return listOfVideos;
	}


	@Override
	@Transactional
	public int deleteVideo(int videoId) {
		try {
			videoSessionRepo.deleteById(videoId);
		} catch (Exception e) {
			return 0;		}
		return 1;
	}

	@Override
	public List<Result> giveTestsByCategoryAndId(String category, int studentId) {
		
		List<Result> listOfResult;
		if(StringUtils.equals("WRITTEN",category)) {
			listOfResult = giveWrittenTestById(category, studentId);
		}else if(StringUtils.equals("MCQ",category)) {
			listOfResult = giveMCQTestById(category, studentId);
		}else if(StringUtils.equals("GTO",category)) {
			listOfResult = giveGTOTestsById(category, studentId);
		}else {
			listOfResult=new ArrayList<>();
		}
		return listOfResult;		
	}

	private List<Result> giveGTOTestsById(String category, int studentId) {
		List<Test> listOfTest = null;
		if(studentId<1) {
			listOfTest=testRepo.findByCategory(category);
		}else {
			listOfTest=testRepo.findGtoTestsByUserAndCategory(category, studentId);
		}
		List<Result> results = new ArrayList<>();
		for (Test test : listOfTest) {
			List<GTOLog> logs;
			if(studentId<1) {
				logs = gtoLogRepo.findByTest_Id(test.getId());
			}else {
				logs = gtoLogRepo.findByUserIdAndTestId(studentId, test.getId());
			}
			Map<Integer, Result> userResults = new HashMap<>();
			for (GTOLog log : logs) {
				int userId = -1;
				User user = log.getUser();
				if(user != null) {
					userId = user.getId();
				}else {
					continue;
				}
				Result result = userResults.getOrDefault(userId, new Result());
				result.setUserName(log.getUser().getUsername());
				result.setStudentName(log.getUser().getName());
				result.setId(test.getId());
				result.setName(test.getName());
				Date startDate = test.getStart();
				SimpleDateFormat formatter = new SimpleDateFormat(DATE_FORMAT);
				String formattedDate = formatter.format(startDate);
				result.setTestDate(formattedDate);
                int obtainMarks = result.getObtainMarks();
                int outOfMarks = test.getQuestionCount();
                if (StringUtils.equals(log.getAnswer(),log.getGtoBean().getOutput())) {
                    obtainMarks++;
                }
                result.setObtainMarks(obtainMarks);
                result.setOutOfMarks(outOfMarks);
                result.setResult(obtainMarks >= test.getPassingCount() ? 1 : 0);
                userResults.put(userId, result);
            }
			results.addAll(userResults.values());
		}
		return results;
	}

	private List<Result> giveMCQTestById(String category, int studentId) {
		List<Test> listOfTest = null;
		if(studentId<1) {
			listOfTest=testRepo.findByCategory(category);
		}else {
			listOfTest=testRepo.findmcqTestsByUserAndCategory(category, studentId);
		}
		List<Result> results = new ArrayList<>();
		for (Test test : listOfTest) {
			List<MCQLog> logs;
			if(studentId<1) {
				logs = mcqLogRepo.findByTest_Id(test.getId());
			}else {
				logs = mcqLogRepo.findByUserIdAndTestId(studentId, test.getId());
			}
			Map<Integer, Result> userResults = new HashMap<>();
			for (MCQLog log : logs) {
				int userId = -1;
				User user = log.getUser();
				if(user != null) {
					userId = user.getId();
				}else {
					continue;
				}
                Result result = userResults.getOrDefault(userId, new Result());
				result.setUserName(log.getUser().getUsername());
				result.setStudentName(log.getUser().getName());
				result.setId(test.getId());
				result.setName(test.getName());
				Date startDate = test.getStart();
				SimpleDateFormat formatter = new SimpleDateFormat(DATE_FORMAT);
				String formattedDate = formatter.format(startDate);
				result.setTestDate(formattedDate);
				int obtainMarks = result.getObtainMarks();
                int outOfMarks = test.getQuestionCount();
                if (StringUtils.equals(log.getAnswer(), log.getMcqBean().getAns()+"")) {
                    obtainMarks++;
                }
                result.setObtainMarks(obtainMarks);
                result.setOutOfMarks(outOfMarks);
                result.setResult(obtainMarks >= test.getPassingCount() ? 1 : 0);
                userResults.put(userId, result);
            }
			results.addAll(userResults.values());
		}
		return results;
	}

	private List<Result> giveWrittenTestById(String category, int studentId) {
		List<Test> listOfTest = null;
		if(studentId<1) {
			listOfTest=testRepo.findByCategory(category);
		}else {
			listOfTest=testRepo.findWrittenTestsByUserAndCategory(category, studentId);
		}
		List<Result> results = new ArrayList<>();
		for (Test test : listOfTest) {
			List<Log> logs;
			if(studentId<1) {
				logs = logRepo.findByTest_Id(test.getId());
			}else {
				logs = logRepo.findByUserIdAndTestId(studentId, test.getId());
			}
			Map<Integer, Result> userResults = new HashMap<>();
			for (Log log : logs) {
				int userId = -1;
				User user = log.getUser();
				if(user != null) {
					userId = user.getId();
				}else {
					continue;
				}
				Result result = userResults.getOrDefault(userId, new Result());
				result.setUserName(log.getUser().getUsername());
				result.setStudentName(log.getUser().getName());
				result.setId(test.getId());
				result.setName(test.getName());
				Date startDate = test.getStart();
				SimpleDateFormat formatter = new SimpleDateFormat(DATE_FORMAT);
				String formattedDate = formatter.format(startDate);
				result.setTestDate(formattedDate);
                int obtainMarks = result.getObtainMarks();
                int outOfMarks = test.getQuestionCount();
                if (log.getVerify() == 1) {
                    obtainMarks++;
                }
                result.setObtainMarks(obtainMarks);
                result.setOutOfMarks(outOfMarks);
                result.setResult(obtainMarks >= test.getPassingCount() ? 1 : 0);
                userResults.put(userId, result);
            }
			results.addAll(userResults.values());
		}
		return results;
	}

}