package dojo.overflow.mvc.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import dojo.overflow.mvc.models.Question;
import dojo.overflow.mvc.models.Tag;

@Repository
public interface TagRepository extends CrudRepository<Tag, Long>{
	List<Tag> findAll();
	Optional <Tag> findById(Long id);
	Optional <Tag> findByName(String name);
}
