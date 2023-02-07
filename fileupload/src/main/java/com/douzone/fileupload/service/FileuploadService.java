package com.douzone.fileupload.service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Calendar;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FileuploadService {
	private static String SAVE_PATH = "/fileupload-files";
	private static String URL_PATH = "/images";
	
	public String restore(MultipartFile file) {
		String url = null;
		try {
			File uploadDirectory = new File(SAVE_PATH);
			if(!uploadDirectory.exists()) {
				//없으면 
				uploadDirectory.mkdir();
			}
			if(file.isEmpty()) {
				//사용자가 파일 업로드 안한 경우
				return url;
			}
			//사용자가 업로드했던 파일 이름
			String originFilename = file.getOriginalFilename();
			String extName = originFilename.substring(originFilename.lastIndexOf(".")+1);
			String saveFilename = generateSaveFilename(extName);
			Long fileSize = file.getSize();
			System.out.println("######"+originFilename+"######");
			System.out.println("######"+saveFilename+"######");
			System.out.println("######"+fileSize+"######");
			byte[] data = file.getBytes();
			OutputStream os = new FileOutputStream(SAVE_PATH+"/"+saveFilename);
			os.write(data);
			os.close();
			url = URL_PATH + "/" + saveFilename; 
		} catch (IOException ex) {
			throw new FileuploadServiceException(ex.toString());
		}
		return url;
	}

	private String generateSaveFilename(String extName) {
		String filename = "";
		
		Calendar calendar = Calendar.getInstance();
		filename += calendar.get(Calendar.YEAR);
		filename += calendar.get(Calendar.MONTH);
		filename += calendar.get(Calendar.DATE);
		filename += calendar.get(Calendar.HOUR);
		filename += calendar.get(Calendar.MINUTE);
		filename += calendar.get(Calendar.SECOND);
		filename += calendar.get(Calendar.MILLISECOND);
		filename += ("." + extName);
			
		return filename;
	}

}
