package dojo.overflow.mvc.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import dojo.overflow.mvc.models.Answer;
import dojo.overflow.mvc.models.Question;
import dojo.overflow.mvc.models.Tag;
import dojo.overflow.mvc.services.AnswerService;
import dojo.overflow.mvc.services.QuestionService;
import dojo.overflow.mvc.services.TagService;

@Controller
public class QuestionsController {
	private final QuestionService serv;
	private final TagService tagserv;
	private final AnswerService ansserv;
	
	
	 public QuestionsController(QuestionService serv, TagService tagserv, AnswerService ansserv) {
	     this.serv = serv;
	     this.tagserv = tagserv;
	     this.ansserv = ansserv;
	     }
	 
	 
	 @RequestMapping("/questions")
	 public String allQuestions(Model model) {
	     List<Question> questions = serv.allQuestions();
		 model.addAttribute("questions",questions);
		 return "/questions/dashboard.jsp";

	 }
	 
	 
	 @RequestMapping("/questions/new")
	 public String newcategory(@ModelAttribute("question") Question question) {
	     return "/questions/new.jsp";

	 }
	 
	 @RequestMapping(value="/questions", method=RequestMethod.POST)
	 public String create(@Valid @ModelAttribute("question") Question question, BindingResult result) {
	     if (result.hasErrors()) {
	         return "redirect:/questions/new";
	     } else {
	    	 serv.createQuestion(question);
	    	 String[] values =question.getTag_values().split(",", 0); 
	    	 for (int i=0; i<values.length; i++) {
	    		 String value = values[i].trim();
	    		 Tag t = new Tag();
	    		 if(tagserv.findTagName(value) == null) {
	    			 t = new Tag (value);
	    		 }
	    		 else {
	    			t = tagserv.findTagName(value);
	    			
	    		 }
	    		 
	    		 if(question.getTags() == null) {
	    			 List<Tag> taglist = new ArrayList<Tag>();
	    			 taglist.add(t);
	    			 question.setTags(taglist);
	    		 } else {
	    			 question.getTags().add(t);
	    		 }
	    		 
	    	 }
	         serv.createQuestion(question);
	         return "redirect:/questions";
	     }
	 }
	 
	 @RequestMapping("/questions/{id}")
	 public String getcategory(@PathVariable("id") Long id, 
			 Model model) {
		 Question question = serv.findQuestion(id);
		 model.addAttribute("question",question); 
	     return "/questions/show.jsp";

	 } 
	 
	 @RequestMapping(value="/questions/{id}/addAnswer", method=RequestMethod.POST)
	 public String create(@PathVariable("id") Long id, @RequestParam (value="content") String content) {
	     Answer answer = new Answer(content);
	     Question q = serv.findQuestion(id);
	     answer.setQuestion(q);
	     ansserv.createAnswer(answer);
		return String.format("redirect:/questions/%d",id); 
		 
	 }
	 
	 
}
