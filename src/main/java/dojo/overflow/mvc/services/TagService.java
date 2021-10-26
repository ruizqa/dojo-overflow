package dojo.overflow.mvc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import dojo.overflow.mvc.models.Question;
import dojo.overflow.mvc.models.Tag;
import dojo.overflow.mvc.repositories.TagRepository;



@Service 
public class TagService {
private final TagRepository repo;
    
    public TagService(TagRepository repo) {
        this.repo = repo;
    }
 
    public List<Tag> allTags() {
        return repo.findAll();
    }
    
    public Tag createTag(Tag t) {
        return repo.save(t);
    }
    
    public Tag findTagName(String name) {
    	Optional<Tag> opTag = repo.findByName(name);
        if(opTag.isPresent()) {
            return opTag.get();
        } else {
            return null;
        }
    }
    
    public Tag findTag(Long id) {
        Optional<Tag> opTag = repo.findById(id);
        if(opTag.isPresent()) {
            return opTag.get();
        } else {
            return null;
        }
    }
    
    public Tag updateTag(Long id, String name) {    	
    	Tag t = new Tag (id, name);
        return repo.save(t);
    }
    
 
    public Tag updateTag(Tag t) {
        return repo.save(t);
    }
    
 
    public void deleteTag(Long id) {
        Optional<Tag> optionalTag = repo.findById(id);
        if(optionalTag.isPresent()) {
            repo.deleteById(id);
        } 
    }
	
    
}
