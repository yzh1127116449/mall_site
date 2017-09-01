package com.atguigu.mall.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.atguigu.mall.beans.MallProduct;
import com.atguigu.mall.service.SpuService;
import com.atguigu.mall.utils.UploadFileUtils;

@Controller
public class SpuController {
	
	@Autowired
	SpuService spuService;
	
	@RequestMapping("save_spu_info")
	public ModelAndView saveSpuInfo(MallProduct mallProduct,@RequestParam MultipartFile [] files){
		ModelAndView mv = new ModelAndView("redirect:/manager_index.do");
		//用于加载对应的选项卡
		mv.addObject("url", "to_manager_spu.htm");
		mv.addObject("title", "spu信息");
		
		List<String> imageNames = UploadFileUtils.upload_image(files);
		int saveSpuCount = spuService.saveSpuInfo(mallProduct);
		int saveSpuImageCount = spuService.saveSpuImage(mallProduct.getId(),imageNames);
	
		return mv;
	}
}
