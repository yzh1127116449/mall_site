package com.atguigu.mall.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.atguigu.mall.beans.ModelObjectMallAttr;
import com.atguigu.mall.beans.ObjectMallAttr;
import com.atguigu.mall.service.AttrService;

@Controller
public class AttrController {
	
	@Autowired
	private AttrService attrService;

	@RequestMapping("/to_manager_attr")
	public String managerAttrIndex(HttpServletRequest request){
		request.getParameterMap();
		return "/backstage_manager/manager_attr";
	}
	/**
	 * 添加属性页面
	 * @return
	 */
	@RequestMapping("/to_attr_add")
	public String addAttrValue(String success,int class_2_id,String class_2_name,Map<String,Object> map){
		
		map.put("class_2_id", class_2_id);
		map.put("class_2_name", class_2_name);
		map.put("success", success);
		return "/backstage_manager/manager_attr_add";
	}
	/**
	 * 添加属性值
	 * @param class_2_id
	 * @param class_2_name
	 * @param map
	 * @return
	 */
	@RequestMapping("/save_attr")
	public ModelAndView saveAttr(int class_2_id,String class_2_name,ModelObjectMallAttr list_attr){
		
		attrService.addAttr(class_2_id, list_attr.getList_attr());
		
		ModelAndView mv = new ModelAndView("redirect:/manager_index.do");
		
		//用于加载对应的选项卡
		mv.addObject("url", "to_manager_attr.htm");
		mv.addObject("title", "分类属性信息");
		mv.addObject("class_2_id", class_2_id);
		mv.addObject("class_2_name", class_2_name);
		mv.addObject("success", "添加成功！！！");
		
		return mv;
	}
	/**
	 * 处理异步请求，返回内嵌页面
	 * @param class_2_id
	 * @param class_2_name
	 * @param map
	 * @return
	 */
	@RequestMapping("/to_attr_list_inner")
	public String attr_list_inner(int class_2_id,String class_2_name ,Map<String,Object> map){
		
		List<ObjectMallAttr> queryAttrByClass_2_id = attrService.queryAttrByClass_2_id(class_2_id);
 		map.put("attr_value_class_2", queryAttrByClass_2_id);
		map.put("class_2_id", class_2_id);
		map.put("class_2_name", class_2_name);
		return "/backstage_manager/manager_attr_list_inner";
	}
	
	/**
	 * 处理异步请求，返json字符串
	 * @param class_2_id
	 * @param class_2_name
	 * @param map
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/to_attr_list_inner_json")
	public List<ObjectMallAttr> attr_list_inner_json(int class_2_id,String class_2_name ,Map<String,Object> map){
		
		List<ObjectMallAttr> queryAttrByClass_2_id = attrService.queryAttrByClass_2_id(class_2_id);
 		
		return queryAttrByClass_2_id;
	}
}
