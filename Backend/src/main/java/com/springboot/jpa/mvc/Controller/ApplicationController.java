package com.springboot.jpa.mvc.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.jpa.mvc.Entity.GTOBean;
import com.springboot.jpa.mvc.Entity.LinkBean;
import com.springboot.jpa.mvc.Entity.Log;
import com.springboot.jpa.mvc.Entity.MCQBean;
import com.springboot.jpa.mvc.Entity.Question;
import com.springboot.jpa.mvc.Entity.Result;
import com.springboot.jpa.mvc.Entity.Test;
import com.springboot.jpa.mvc.Entity.User;
import com.springboot.jpa.mvc.Entity.VideoSession;
import com.springboot.jpa.mvc.Service.AppService;


@RestController
@CrossOrigin
public class ApplicationController {
	
	AppService appService;
	
	@Autowired
	public ApplicationController(AppService appService) {
		this.appService = appService;
	}

	@RequestMapping("acceptreject{id}")
	public int acceptreject(@PathVariable int id, @RequestBody int verify){
		return appService.acceptreject(id, verify);
	}
	
	@RequestMapping("getAllLogsForVerification")
	public List<Log> getAllLogsForVerification(){
		return appService.getAllLogsForVerification();
	}
	
	@RequestMapping("submit{id}")
	public int submit(@PathVariable int id){
		return appService.submit(id);
	}
	
	@RequestMapping("update{id}")
	public int update(@PathVariable int id, @RequestBody String answer){
		return appService.update(id, answer);
	}
	
	@RequestMapping("giveMeTestLogs{userId}and{testId}and{category}")
	public List<?> giveMeTestLogs(@PathVariable int userId, @PathVariable int testId, @PathVariable String category){
		return appService.giveMeTestLogs(userId, testId, category);
	}
	
	@RequestMapping("giveActiveTests{category}")
	public List<Test> giveActiveTests(@PathVariable String category){
		return appService.giveActiveTests(category);
	}
	
	@RequestMapping("addQuestion")
	public Question addQuestion(@RequestBody String name){
		return appService.addQuestion(name);
	}
	
	@RequestMapping("giveQuestion")
	public List<Question> giveQuestion(){
		return appService.giveQuestion();
	}
	
	@RequestMapping("addTest")
	public Test addTest(@RequestBody Test test){
		return appService.addTest(test);
	}

	@RequestMapping("giveResultsByCategory{category}")
	public List<Result> giveResultsByCategory(@PathVariable String category){
		return appService.giveResultsByCategory(category);
	}
	
	@RequestMapping("giveTestsByCategoryAndId{category}and{studentId}")
	public List<Result> giveTestsByCategoryAndId(@PathVariable String category, @PathVariable int studentId){
		return appService.giveTestsByCategoryAndId(category, studentId);
	}
	
	@RequestMapping("login{username}")
	public int[] login(@PathVariable String username, @RequestBody String password){
		return appService.login(username, password);
	}
	
	@RequestMapping("register")
	public int register(@RequestBody User user) {
		return appService.register(user);
	}
	
	@RequestMapping("delete{questionid}")
	public int delete(@PathVariable("questionid") int questionid) {
		return appService.delete(questionid);
	}
	
	@RequestMapping("studentList")
	public List<User> getStudentList(){
		return appService.getStudentList();
	}
	
	@RequestMapping("deleteStudent{studentId}")
	
	public int deleteStudent(@PathVariable("studentId") int studentId) {
		return appService.deleteStudent(studentId);
	}
	
	@RequestMapping("deactiveStudent{studentId}")
	public int deactiveStudent(@PathVariable("studentId") int studentId) {
		return appService.deactiveStudent(studentId);
	}
	
	@RequestMapping("activateStudent{studentId}")
	public int activateStudent(@PathVariable("studentId") int studentId) {
		return appService.activateStudent(studentId);
	}
	
	@RequestMapping("getAllLink")
	public List<LinkBean> getAllLink(){
		return appService.getAllLink();
	}
	
	@RequestMapping("addMCQ")
	public int addMCQ(@RequestBody MCQBean mcqBean) {
		return appService.addMCQ(mcqBean);
	}
	
	@RequestMapping("giveMCQ")
	public List<MCQBean> giveMCQQuestion(){
		return appService.giveMCQQuestion();
	}
	
	@RequestMapping("deleteMCQ{mcqId}")
	public int deleteMCQ(@PathVariable("mcqId") int mcqId) {
		return appService.deleteMCQ(mcqId);
	}
	
	@RequestMapping("addGTO")
	public int  addGTO(@RequestBody GTOBean gtoBean) {
		return appService.addGTO(gtoBean);
	}
	
	@RequestMapping("giveGTO")
	public List<GTOBean> giveGTOQuestion(){
		return appService.giveGTOQuestion();
	}
	
	@RequestMapping("deleteGTO{gtoId}")
	public int deleteGTO(@PathVariable("gtoId") int gtoId) {
		return appService.deleteGTO(gtoId);
	}
	
	@RequestMapping("submitGto{id}")
	public int submitGto(@PathVariable int id, @RequestBody String answer){
		return appService.submitGto(id, answer);
	}
	
	@RequestMapping("submitMcq{id}")
	public int submitMcq(@PathVariable int id, @RequestBody String answer){
		return appService.submitMcq(id, answer);
	}
	
	@RequestMapping("addVideo")
	public VideoSession addVideoSession(@RequestBody VideoSession videoSession) {
		return appService.addVideoSession(videoSession);
	}
	
	@RequestMapping("getVideoBy{id}")
	public VideoSession addVideoSession(@PathVariable int id) {
		return appService.getVideoBy(id);
	}
	
	@RequestMapping("getAllVideos")
	public List<VideoSession> getAllVideos() {
		return appService.getAllVideos();
	}
	
	@RequestMapping("deleteVideo{videoId}")
	public int deleteVideo(@PathVariable int videoId) {
		return appService.deleteVideo(videoId);
	}
	
	
	
	
	
}