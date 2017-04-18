package it.uniroma3.icr.model;

import javax.persistence.*;

@Entity
public class Sample {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column(nullable=false)
	private Integer x;
	@Column(nullable=false)
	private Integer y;
	@Column(nullable=false)
	private String path;
	@Column(nullable=false)
	private String manuscript;
	@Column(nullable=false)
	private String page;
	@Column(nullable=false)
	private String width;
	@Column(nullable=false)
	private String height;
	@ManyToOne
	private Symbol symbol;
	
	public Sample(){}

	public Sample(Integer x, Integer y, String path, String manuscript, String page, String width, String height, Symbol symbol) {
		this.x = x;
		this.y = y;
		this.path = path;
		this.manuscript = manuscript;
		this.page = page;
		this.width = width;
		this.height = height;
		this.symbol = symbol;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getX() {
		return x;
	}

	public void setX(Integer x) {
		this.x = x;
	}

	public Integer getY() {
		return y;
	}

	public void setY(Integer y) {
		this.y = y;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getManuscript() {
		return manuscript;
	}

	public void setManuscript(String manuscript) {
		this.manuscript = manuscript;
	}

	public String getPage() {
		return page;
	}

	public void setPage(String page) {
		this.page = page;
	}

	public String getWidth() {
		return width;
	}

	public void setWidth(String width) {
		this.width = width;
	}

	public String getHeight() {
		return height;
	}

	public void setHeight(String height) {
		this.height = height;
	}

	public Symbol getSymbol() {
		return symbol;
	}

	public void setSymbol(Symbol symbol) {
		this.symbol = symbol;
	}
	
	
}
