package dojo.overflow.mvc.services;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import dojo.overflow.mvc.models.Question;
import dojo.overflow.mvc.models.Tag;
import dojo.overflow.mvc.repositories.QuestionRepository;



@Service 
public class QuestionService {
	private final QuestionRepository repo;

    public QuestionService(QuestionRepository repo) {
        this.repo = repo;
    }
 
    public List<Question> allQuestions() {
        return repo.findAll();
    }
    
    public Question createQuestion(Question q) {
        return repo.save(q);
    }
    
    public Question findQuestion(Long id) {
        Optional<Question> opq = repo.findById(id);
        if(opq.isPresent()) {
            return opq.get();
        } else {
            return null;
        }
    }
    
    public Question updateQuestion(Long id, String content) {    	
    	Question q = new Question (id,content);
        return repo.save(q);
    }
    
  
    public void deleteQuestion(Long id) {
        Optional<Question> optionalQuestion = repo.findById(id);
        if(optionalQuestion.isPresent()) {
            repo.deleteById(id);
        } 
    }
    

    
}
