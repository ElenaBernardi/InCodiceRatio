package it.uniroma3.icr.model;

import java.util.List;

import javax.persistence.*;

@Entity
public class Symbol {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column(nullable = false)
	private String transcription;
	@Column(nullable = false)
	private String manuscript;
	@Column(nullable = false)
	private Integer width;
	@Column(nullable = false)
	private String page;
	@OneToMany(mappedBy = "symbol")
	private List<Job> jobs;
	@OneToMany(mappedBy = "symbol")
	private List<Sample> samples;
	@OneToMany(mappedBy = "symbol")
	private List<NegativeSample> negativeSamples;  
	
	public Symbol(){}

	public Symbol(String transcription, String manuscript, Integer width, String page, List<Job> jobs,
			List<Sample> samples, List<NegativeSample> negativeSamples) {
		this.transcription = transcription;
		this.manuscript = manuscript;
		this.width = width;
		this.page = page;
		this.jobs = jobs;
		this.samples = samples;
		this.negativeSamples = negativeSamples;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTranscription() {
		return transcription;
	}

	public void setTranscription(String transcription) {
		this.transcription = transcription;
	}

	public String getManuscript() {
		return manuscript;
	}

	public void setManuscript(String manuscript) {
		this.manuscript = manuscript;
	}

	public Integer getWidth() {
		return width;
	}

	public void setWidth(Integer width) {
		this.width = width;
	}

	public String getPage() {
		return page;
	}

	public void setPage(String page) {
		this.page = page;
	}

	public List<Job> getJobs() {
		return jobs;
	}

	public void setJobs(List<Job> jobs) {
		this.jobs = jobs;
	}

	public List<Sample> getSamples() {
		return samples;
	}

	public void setSamples(List<Sample> samples) {
		this.samples = samples;
	}

	public List<NegativeSample> getNegativeSamples() {
		return negativeSamples;
	}

	public void setNegativeSamples(List<NegativeSample> negativeSamples) {
		this.negativeSamples = negativeSamples;
	}
	
	
}
