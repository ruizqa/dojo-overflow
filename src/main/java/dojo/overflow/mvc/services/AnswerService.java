package dojo.overflow.mvc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import dojo.overflow.mvc.models.Answer;
import dojo.overflow.mvc.repositories.AnswerRepository;





@Service
public class AnswerService {
    private final AnswerRepository repo;
    
    public AnswerService(AnswerRepository repo) {
        this.repo = repo;
    }
 
    
    public Answer createAnswer(Answer a) {
        return repo.save(a);
    }
    
    public Answer findAnswer(Long id) {
        Optional<Answer> opAnswer = repo.findById(id);
        if(opAnswer.isPresent()) {
            return opAnswer.get();
        } else {
            return null;
        }
    }
    
    public Answer updateAnswer(Long id, String content ) {    	
    	Answer a = new Answer(id, content);
        return repo.save(a);
    }
    
 
    public Answer updateAnswer(Answer a) {
        return repo.save(a);
    }
    
 
    public void deleteAnswer(Long id) {
        Optional<Answer> optionalAnswer = repo.findById(id);
        if(optionalAnswer.isPresent()) {
            repo.deleteById(id);
        } 
    }
    
    
    
}
