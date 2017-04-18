package it.uniroma3.icr.model;

import javax.persistence.*;

@Entity
public class Result {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String answer;
	@ManyToOne
	private Task task;
	@ManyToOne
	private Image image;
	
	public Result(){}

	public Result(String answer, Task task, Image image) {
		this.answer = answer;
		this.task = task;
		this.image = image;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public Task getTask() {
		return task;
	}

	public void setTask(Task task) {
		this.task = task;
	}

	public Image getImage() {
		return image;
	}

	public void setImage(Image image) {
		this.image = image;
	}
	
	
}
