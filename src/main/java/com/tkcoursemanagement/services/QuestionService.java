package com.tkcoursemanagement.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tkcoursemanagement.models.EssayQuestion;
import com.tkcoursemanagement.models.Exam;
import com.tkcoursemanagement.models.FillBlanksQuestion;
import com.tkcoursemanagement.models.Lesson;
import com.tkcoursemanagement.models.MultipleChoiceQuestion;
import com.tkcoursemanagement.models.Question;
import com.tkcoursemanagement.models.TrueFalseQuestion;
import com.tkcoursemanagement.models.Widget;
import com.tkcoursemanagement.repositories.EssayQuestionRepository;
import com.tkcoursemanagement.repositories.ExamRepository;
import com.tkcoursemanagement.repositories.FillBlanksQuestionRepository;
import com.tkcoursemanagement.repositories.LessonRepository;
import com.tkcoursemanagement.repositories.MultipleChoiceQuestionRepository;
import com.tkcoursemanagement.repositories.TrueFalseQuestionRepository;
import com.tkcoursemanagement.repositories.WidgetRepository;

@RestController
@CrossOrigin(origins = "*")
public class QuestionService {
	@Autowired
	ExamRepository examRepository;
	@Autowired
	TrueFalseQuestionRepository trueFalseRepository;
	@Autowired
	MultipleChoiceQuestionRepository multipleChoiceRepository;
	@Autowired
	FillBlanksQuestionRepository fillBlanksRepository;
	@Autowired
	EssayQuestionRepository essayRepository;

	@GetMapping("/api/multi/{questionId}")
	public MultipleChoiceQuestion findMultiQuestionById(@PathVariable("questionId") int questionId) {
		Optional<MultipleChoiceQuestion> optional = multipleChoiceRepository.findById(questionId);
		if(optional.isPresent()) {
			return optional.get();
		}
		return null;
	}

	@GetMapping("/api/truefalse/{questionId}")
	public TrueFalseQuestion findTrueFalseQuestionById(@PathVariable("questionId") int questionId) {
		Optional<TrueFalseQuestion> optional = trueFalseRepository.findById(questionId);
		if(optional.isPresent()) {
			return optional.get();
		}
		return null;
	}
	
	@GetMapping("/api/exam/{examId}/question")
	public List<Question> findAllQuestionsForExam(@PathVariable("examId") int examId) {
		Optional<Exam> optionalExam = examRepository.findById(examId);
		if(optionalExam.isPresent()) {
			Exam exam = optionalExam.get();
			List<Question> questions = exam.getQuestions();
			return questions;
		}
		else return null;
	}
	
	
	@PostMapping("/api/exam/{examId}/questionTF")
	public TrueFalseQuestion  createTrueFalse(@PathVariable("examId") int examId, @RequestBody TrueFalseQuestion q) {
		Optional<Exam> optionalExam = examRepository.findById(examId);
		if(optionalExam.isPresent()) {
			Exam exam = optionalExam.get();
			q.setExam(exam);
			q.setType("TF");
			return trueFalseRepository.save(q);
		}
		else return null;
	}
	
	@PostMapping("/api/exam/{examId}/questionMC")
	public MultipleChoiceQuestion  createMultiple(@PathVariable("examId") int examId, @RequestBody MultipleChoiceQuestion q) {
		Optional<Exam> optionalExam = examRepository.findById(examId);
		if(optionalExam.isPresent()) {
			Exam exam = optionalExam.get();
			q.setExam(exam);
			q.setType("MC");
			return multipleChoiceRepository.save(q);
		}
		else return null;
	}
	
	@PostMapping("/api/exam/{examId}/questionFB")
	public FillBlanksQuestion  createFillBlanks(@PathVariable("examId") int examId, @RequestBody FillBlanksQuestion q) {
		Optional<Exam> optionalExam = examRepository.findById(examId);
		if(optionalExam.isPresent()) {
			Exam exam = optionalExam.get();
			q.setExam(exam);
			q.setType("FB");
			return fillBlanksRepository.save(q);
		}
		else return null;
	}
	
	@PostMapping("/api/exam/{examId}/questionFB")
	public EssayQuestion  createEssay(@PathVariable("examId") int examId, @RequestBody EssayQuestion q) {
		Optional<Exam> optionalExam = examRepository.findById(examId);
		if(optionalExam.isPresent()) {
			Exam exam = optionalExam.get();
			q.setExam(exam);
			q.setType("FB");
			return essayRepository.save(q);
		}
		else return null;
	}
	
	@DeleteMapping("/api/questionTF/{questionId}")
	public void deleteTrueFalse(@PathVariable("questionId") int questionId) {
		Optional<TrueFalseQuestion> optionalQuestion = trueFalseRepository.findById(questionId);
		if(optionalQuestion.isPresent()) {
			trueFalseRepository.deleteById(questionId);;
		}
	}
	
	@DeleteMapping("/api/questionMC/{questionId}")
	public void deleteMultipleChoice(@PathVariable("questionId") int questionId) {
		Optional<MultipleChoiceQuestion> optionalQuestion = multipleChoiceRepository.findById(questionId);
		if(optionalQuestion.isPresent()) {
			multipleChoiceRepository.deleteById(questionId);;
		}
	}
	@DeleteMapping("/api/questionFB/{questionId}")
	public void deleteFillBlanks(@PathVariable("questionId") int questionId) {
		Optional<FillBlanksQuestion> optionalQuestion = fillBlanksRepository.findById(questionId);
		if(optionalQuestion.isPresent()) {
			fillBlanksRepository.deleteById(questionId);;
		}
	}
	@DeleteMapping("/api/questionES/{questionId}")
	public void deleteEssay(@PathVariable("questionId") int questionId) {
		Optional<EssayQuestion> optionalQuestion = essayRepository.findById(questionId);
		if(optionalQuestion.isPresent()) {
			essayRepository.deleteById(questionId);;
		}
	}
}