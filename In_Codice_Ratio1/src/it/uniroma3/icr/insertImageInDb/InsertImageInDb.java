package it.uniroma3.icr.insertImageInDb;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FilenameUtils;
import it.uniroma3.icr.model.Image;
import it.uniroma3.icr.model.Job;
import it.uniroma3.icr.model.Result;
import it.uniroma3.icr.model.Task;
import it.uniroma3.persistence.JPA.CrudRepositoryJPA;


//come possiamo chiamarlo?
public class InsertImageInDb {
	private CrudRepositoryJPA<Image> crudRepository;

	public InsertImageInDb(CrudRepositoryJPA<Image> crudRepository){
		this.crudRepository = crudRepository;
	}

	public void listFiles(String path) throws IOException{
		File file = new File(path);
		File[] subFile = file.listFiles();
		if(!file.getName().equals("all_windows")){
			if(file.isDirectory()){
				for(int i = 0;i<subFile.length;i++){
					listFiles(subFile[i].getPath());
				}
			}else{
				if(!file.isHidden()){
					Image img = new Image();

					String pathImg = file.getPath();
					String[] listPathRev = pathImg.split("\\\\");
					String[] listPath = this.reverse(listPathRev);

					img.setWord(listPath[2]);
					img.setRow(listPath[3]);
					img.setPage(listPath[4]);
					img.setManuscript(listPath[5]);
					img.setPath(file.getPath());

					String[] listType = FilenameUtils.getBaseName(file.getName()).split("\\_");

					img.setX(Integer.valueOf(listType[0]));
					img.setY(Integer.valueOf(listType[1]));
					img.setWidth(Integer.valueOf(listType[2]));
					img.setHeight(Integer.valueOf(listType[3]));

					this.crudRepository.save(img);

				}
			}
		}
	}

	public void confirmJob(Job job){
		List<Image> jobImages = new ArrayList<>();
		List<Image> taskImages = new ArrayList<>(); //come va fatto? li usa facade
		List<Task> taskList=new ArrayList<>();
		for(int y=0;y<taskImages.size();y++) {
			Image image = taskImages.get(y);
			jobImages.add(image);
		}
		job.setImages(jobImages);
		int numberOfTask = job.getNumberOfImages()/job.getTaskSize();
		for(int i = 0; i<job.getNumberOfStudent();i++){
			int batchNumber = 0;
			for(int r=0;r<job.getImages().size();r++) {
				if ((r % job.getTaskSize())== 0) {
					Task task = new Task();
					task.setBatch(batchNumber);
					task.setJob(job);
					taskList.add(task);
					batchNumber++;
				}
				Image j = job.getImages().get(r);
				Result result = new Result();
				result.setImage(j);
				result.setTask(task); //come faccio a passarglielo?
			}
		}
		job.setTasks(taskList);
	}

	public String[] reverse(String[] s){
		int y=0;
		String[] rev = new String[s.length];
		for(int i = s.length-1; i>=0;i--){
			rev[y] = s[i];
			y++;
		}
		return rev;
	}

}
