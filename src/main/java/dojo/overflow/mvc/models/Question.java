package dojo.overflow.mvc.models;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;




@Entity
@Table(name="questions")
public class Question {
 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 private Long id;
 @Lob 
 private String content;
 @Column(updatable=false)
 private Date createdAt;
 private Date updatedAt;
 @ManyToMany(fetch = FetchType.LAZY,cascade=CascadeType.ALL)
 @JoinTable(
     name = "questions_tags", 
     joinColumns = @JoinColumn(name = "question_id"), 
     inverseJoinColumns = @JoinColumn(name = "tag_id")
 )
 private List<Tag> tags;
 @OneToMany(mappedBy="question", fetch = FetchType.LAZY)
 private List<Answer> answers;
 @Transient
 private String tag_values;
 
 
 public Question() {
     
 }
 
 public Question(Long id, String content) {
     this.id = id;
	 this.content= content;
 }
 
 public Question(String content) {
     this.content= content;
 }
public Long getId() {
	return id;
}
public void setId(Long id) {
	this.id = id;
}
public String getContent() {
	return content;
}
public void setContent(String content) {
	this.content = content;
}
public Date getCreatedAt() {
	return createdAt;
}
public void setCreatedAt(Date createdAt) {
	this.createdAt = createdAt;
}
public Date getUpdatedAt() {
	return updatedAt;
}
public void setUpdatedAt(Date updatedAt) {
	this.updatedAt = updatedAt;
}
public List<Tag> getTags() {
	return tags;
}
public void setTags(List<Tag> tags) {
	this.tags = tags;
}
public List<Answer> getAnswers() {
	return answers;
}
public void setAnswers(List<Answer> answers) {
	this.answers = answers;
}

public String getTag_values() {
	return tag_values;
}

public void setTag_values(String tag_values) {
	this.tag_values = tag_values;
}

 

}
