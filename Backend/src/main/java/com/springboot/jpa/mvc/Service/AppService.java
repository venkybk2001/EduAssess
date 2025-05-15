package com.springboot.jpa.mvc.Service;

import java.util.List;

import com.springboot.jpa.mvc.Entity.GTOBean;
import com.springboot.jpa.mvc.Entity.LinkBean;
import com.springboot.jpa.mvc.Entity.Log;
import com.springboot.jpa.mvc.Entity.MCQBean;
import com.springboot.jpa.mvc.Entity.Question;
import com.springboot.jpa.mvc.Entity.Result;
import com.springboot.jpa.mvc.Entity.Test;
import com.springboot.jpa.mvc.Entity.User;
import com.springboot.jpa.mvc.Entity.VideoSession;

public interface AppService {

	public int acceptreject(int id,int verify);
	public List<Log> getAllLogsForVerification();
	public int submit(int id);
	public int update( int id, String answer);
	public List<?> giveMeTestLogs( int userId, int testId, String category);
	public List<Test> giveActiveTests(String category);
	public Question addQuestion( String name);
	public List<Question> giveQuestion();
	public Test addTest(Test test);
	public List<Result> giveResultsByCategory(String category);
	public List<Result> giveTestsByCategoryAndId(String category, int studentId);
	public int[] login( String username, String password);
	public int register( User user);
	public int delete(int questionid);
	public List<User> getStudentList();
	public int deleteStudent(int studentId);
	public int deactiveStudent(int studentId);
	public int activateStudent(int studentId);
	public List<LinkBean> getAllLink();
	public int addMCQ(MCQBean mcqBean);
	public List<MCQBean> giveMCQQuestion();
	public int deleteMCQ(int mcqId);
	public int addGTO(GTOBean gtoBean);
	public List<GTOBean> giveGTOQuestion();
	public int deleteGTO(int gtoId);
	public int submitGto(int id, String answer);
	public int submitMcq(int id, String answer);
	public VideoSession addVideoSession(VideoSession videoSession);
	public VideoSession getVideoBy(int id);
	public List<VideoSession> getAllVideos();
	public int deleteVideo(int videoId);
}
