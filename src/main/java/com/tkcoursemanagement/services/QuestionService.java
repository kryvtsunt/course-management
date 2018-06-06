package com.tkcoursemanagement.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tkcoursemanagement.models.Exam;
import com.tkcoursemanagement.models.Lesson;
import com.tkcoursemanagement.models.MultipleChoiceQuestion;
import com.tkcoursemanagement.models.Question;
import com.tkcoursemanagement.models.TrueFalseQuestion;
import com.tkcoursemanagement.models.Widget;
import com.tkcoursemanagement.repositories.ExamRepository;
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
	MultipleChoiceQuestionRepository mutiRepo;

	@GetMapping("/api/multi/{questionId}")
	public MultipleChoiceQuestion findMultiQuestionById(@PathVariable("questionId") int questionId) {
		Optional<MultipleChoiceQuestion> optional = mutiRepo.findById(questionId);
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
			int count = questions.size();
			return questions;
		}
		return null;
	}
}