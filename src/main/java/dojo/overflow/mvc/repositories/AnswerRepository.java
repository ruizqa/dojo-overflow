package dojo.overflow.mvc.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import dojo.overflow.mvc.models.Answer;
import dojo.overflow.mvc.models.Question;

public interface AnswerRepository extends CrudRepository<Answer, Long>{
	List<Answer> findAll();
	Optional <Answer> findById(Long id);
}
