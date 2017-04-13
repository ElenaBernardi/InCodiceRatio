package it.uniroma3.icr.model;

import java.util.List;
import javax.persistence.*;

@Entity
public class Job {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	@Column(nullable=false)
	private String title;
	private String description;
	@Column(nullable=false)
	private Integer taskSize;
	@Column(nullable=false)
	private Integer numberOfImages;
	@Column(nullable=false)
	private Integer numberOfStudent;
	@Column(nullable=false)
	private String imageManuscript;
	private String difficulty;
	@OneToMany(mappedBy="job")
	private List<Task> tasks;

	public Job(){}

}
