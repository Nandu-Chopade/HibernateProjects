package code.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Answers {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int aid;

	private String answerName;

	@ManyToMany(mappedBy = "answer")
	private Set<Questions> question = new HashSet<>();

	public int getAid() {
		return aid;
	}

	public void setAid(int aid) {
		this.aid = aid;
	}

	public String getAnswerName() {
		return answerName;
	}

	public void setAnswerName(String answerName) {
		this.answerName = answerName;
	}

	public Set<Questions> getQuestion() {
		return question;
	}

	public void setQuestion(Set<Questions> question) {
		this.question = question;
	}

}
