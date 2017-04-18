package it.uniroma3.icr.model;

import java.io.IOException;
import javax.persistence.*;

import it.uniroma3.icr.insertImageInDb.InsertImageInDb;
import it.uniroma3.persistence.JPA.CrudRepositoryJPA;

public class Main {
	public static void main(String[] args) throws IOException{
		//String s="C:\\Users\\user\\Pictures\\new_webapp";
		String s="C:\\Users\\user\\Pictures\\manuscript";
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("icr-unit");
		EntityManager em = emf.createEntityManager();
		CrudRepositoryJPA<Image> imageCrudRepository = new CrudRepositoryJPA<>(em, Image.class); 
		InsertImageInDb db=new InsertImageInDb(imageCrudRepository);
		EntityTransaction tx=em.getTransaction();
		tx.begin();
		db.listFiles(s);
		tx.commit();
		em.close();
		emf.close();
		
	}
}
