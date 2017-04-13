package it.uniroma3.icr.model;

import java.util.Date;
import javax.persistence.*;

@Entity
public class Task {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	@Column(nullable = false)
	private int batch;
	@Temporal(TemporalType.TIMESTAMP)
	private Date startDate;
	@Temporal(TemporalType.TIMESTAMP)
	private Date endDate;
	@ManyToOne
	private Job job;
	
	
	public Task(){}
}
