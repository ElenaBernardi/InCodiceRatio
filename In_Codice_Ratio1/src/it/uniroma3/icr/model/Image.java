package it.uniroma3.icr.model;

import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.IOException;
import java.util.*;
import org.apache.commons.io.FilenameUtils;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.imageio.ImageIO;
import javax.persistence.*;

@Entity
public class Image {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private Integer x; 
	private Integer y;
	private Integer width;
	private Integer height;
	private String manuscript;
	private String page;
	private String row;
	private String word;
	private String path;
	

	public Image(){}

	public Image(String manuscript,String page, String row, String word, Integer x, Integer y, Integer width, Integer height, String path){
		this.manuscript=manuscript;
		this.page=page;
		this.row=row;
		this.word=word;
		this.x=x;
		this.y=y;
		this.height=height;
		this.width=width;
		this.path=path;
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

	public Integer getWidth() {
		return width;
	}

	public void setWidth(Integer width) {
		this.width = width;
	}

	public Integer getHeight() {
		return height;
	}

	public void setHeight(Integer height) {
		this.height = height;
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

	public String getRow() {
		return row;
	}

	public void setRow(String row) {
		this.row = row;
	}

	public String getWord() {
		return word;
	}

	public void setWord(String word) {
		this.word = word;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}
	
	@Override
	public String toString(){
		return "manoscritto= "+this.manuscript+" Pagina=" +this.getPage()+" Riga=" +this.getRow()+" Parola= "+this.getWord()+" x="+this.getX();
	}

}
