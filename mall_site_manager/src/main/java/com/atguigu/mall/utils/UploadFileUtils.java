package com.atguigu.mall.utils;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.web.multipart.MultipartFile;

public class UploadFileUtils {
	
	public static List<String> upload_image(MultipartFile[] files){
		
		List<String> imageName = new ArrayList<String>();
		String uploadPath = MyProperties.getUploadPath("windows_path");
		
		for (int i = 0; i < files.length; i++) {
			if(files[i].getSize()>0){
				
				String imgName = files[i].getOriginalFilename();
				imgName = UUID.randomUUID().toString()+imgName;
				
				try {
					files[i].transferTo(new File(uploadPath+"\\"+imgName));
				} catch (Exception e) {
					e.printStackTrace();
				}
				imageName.add(imgName);
			}
		}
		return imageName;
	}
}
