package it.uniroma3.icr.model;

import java.util.List;
import javax.persistence.*;

@Entity
public class Job {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column(nullable = false)
	private String title;
	private String description;
	@Column(nullable = false)
	private Integer taskSize;
	@Column(nullable = false)
	private Integer numberOfImages;
	@Column(nullable = false)
	private Integer numberOfStudent;
	@Column(nullable = false)
	private String imageManuscript;
	private String difficulty;
	@OneToMany(mappedBy = "job")
	private List<Task> tasks;
	@ManyToOne
	private Symbol symbol;
	@ManyToMany
	private List<Image> images;

	public Job(){}

	public Job(String title, String description, Integer taskSize, Integer numberOfImages, Integer numberOfStudent,
			String imageManuscript, String difficulty, List<Task> tasks, Symbol symbol, List<Image> images) {
		this.title = title;
		this.description = description;
		this.taskSize = taskSize;
		this.numberOfImages = numberOfImages;
		this.numberOfStudent = numberOfStudent;
		this.imageManuscript = imageManuscript;
		this.difficulty = difficulty;
		this.tasks = tasks;
		this.symbol = symbol;
		this.images = images;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getTaskSize() {
		return taskSize;
	}

	public void setTaskSize(Integer taskSize) {
		this.taskSize = taskSize;
	}

	public Integer getNumberOfImages() {
		return numberOfImages;
	}

	public void setNumberOfImages(Integer numberOfImages) {
		this.numberOfImages = numberOfImages;
	}

	public Integer getNumberOfStudent() {
		return numberOfStudent;
	}

	public void setNumberOfStudent(Integer numberOfStudent) {
		this.numberOfStudent = numberOfStudent;
	}

	public String getImageManuscript() {
		return imageManuscript;
	}

	public void setImageManuscript(String imageManuscript) {
		this.imageManuscript = imageManuscript;
	}

	public String getDifficulty() {
		return difficulty;
	}

	public void setDifficulty(String difficulty) {
		this.difficulty = difficulty;
	}

	public List<Task> getTasks() {
		return tasks;
	}

	public void setTasks(List<Task> tasks) {
		this.tasks = tasks;
	}

	public Symbol getSimbol() {
		return symbol;
	}

	public void setSimbol(Symbol simbol) {
		this.symbol = simbol;
	}

	public List<Image> getImages() {
		return images;
	}

	public void setImages(List<Image> images) {
		this.images = images;
	}
	
}
