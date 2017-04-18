package it.uniroma3.icr.model;

import java.util.Date;
import java.util.List;

import javax.persistence.*;

@Entity
public class Task {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column(nullable = false)
	private int batch;
	@Temporal(TemporalType.TIMESTAMP)
	private Date startDate;
	@Temporal(TemporalType.TIMESTAMP)
	private Date endDate;
	@ManyToOne
	private Job job;
	@ManyToOne
	private Student student;
	@OneToMany(mappedBy = "task")
	private List<Result> results;
		
	public Task(){}

	public Task(int batch, Date startDate, Date endDate, Job job, Student student, List<Result> results) {
		this.batch = batch;
		this.startDate = startDate;
		this.endDate = endDate;
		this.job = job;
		this.student = student;
		this.results = results;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getBatch() {
		return batch;
	}

	public void setBatch(int batch) {
		this.batch = batch;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public Job getJob() {
		return job;
	}

	public void setJob(Job job) {
		this.job = job;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public List<Result> getResults() {
		return results;
	}

	public void setResults(List<Result> results) {
		this.results = results;
	}
	
	
}
