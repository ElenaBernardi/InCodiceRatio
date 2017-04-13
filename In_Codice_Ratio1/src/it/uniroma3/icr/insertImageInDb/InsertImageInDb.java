package it.uniroma3.icr.insertImageInDb;

import java.io.File;
import java.io.IOException;
import javax.persistence.*;

import org.apache.commons.io.FilenameUtils;


import it.uniroma3.icr.model.Image;

public class InsertImageInDb {
	private EntityManager em;

	public InsertImageInDb(EntityManager em){
		this.em=em;
	}

	public void listFiles(String path) throws IOException{
		File file=new File(path);
		File[] subFile =file.listFiles();
		if(!file.getName().equals("all_windows")){
			if(file.isDirectory()){
				for(int i=0;i<subFile.length;i++){
					listFiles(subFile[i].getPath());
				}
			}else{
				if(!file.isHidden()){
					String pathImg=file.getPath();
					String[] listPathRev=pathImg.split("\\\\");
					Image img=new Image();
					String[] listPath=this.reverse(listPathRev);
					img.setWord(listPath[2]); //parametrizzare?
					img.setRow(listPath[3]);
					img.setPage(listPath[4]);
					img.setManuscript(listPath[5]);
					img.setPath(file.getPath());

					String[] listType=FilenameUtils.getBaseName(file.getName()).split("\\_");
					img.setX(Integer.valueOf(listType[0]));
					img.setY(Integer.valueOf(listType[1]));
					img.setWidth(Integer.valueOf(listType[2]));
					img.setHeight(Integer.valueOf(listType[3]));
					this.insertImage(img);

				}
			}
		}
	}


	public void insertImage(Image image) {
		em.persist(image);
	}
	
	public String[] reverse(String[] s){
		int y=0;
		String[] rev=new String[s.length];
		for(int i=s.length-1; i>=0;i--){
			rev[y]=s[i];
			y++;
		}
		return rev;
	}

}
