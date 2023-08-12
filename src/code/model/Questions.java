package code.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.*;

@Entity
public class Questions {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int qId;

	private String questionName;
	@ManyToMany
	@JoinTable(name = "question_answer", joinColumns = @JoinColumn(name = "question_id"), inverseJoinColumns = @JoinColumn(name = "answer_id"))
	private Set<Answers> answer = new HashSet<>();

	public int getqId() {
		return qId;
	}

	public void setqId(int qId) {
		this.qId = qId;
	}

	public String getQuestionName() {
		return questionName;
	}

	public void setQuestionName(String questionName) {
		this.questionName = questionName;
	}

	public Set<Answers> getAnswer() {
		return answer;
	}

	public void setAnswer(Set<Answers> answer) {
		this.answer = answer;
	}

}
