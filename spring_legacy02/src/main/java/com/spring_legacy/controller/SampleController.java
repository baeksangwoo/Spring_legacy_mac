package com.spring_legacy.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.spring_legacy.domain.SampleDTO;
import com.spring_legacy.domain.SampleDTOList;
import com.spring_legacy.domain.TodoDTO;

import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping("/sample/*")
@Log4j
public class SampleController {

	@RequestMapping(value = "/basic", method = {RequestMethod.GET,RequestMethod.POST} )
	public void basic(){
		log.info("basic....");
	}
	
	@GetMapping("/basicOnlyGet")
	public void basicGet2() {
		log.info("basic Get Annotation");
	}
	
	@GetMapping("/dto")
	public String dto(SampleDTO dto) {
		
		log.info(" "+dto);
		return "DTO Test";
	}
	
	@GetMapping("/dtoArrayList")
	public String dtoArrayList(@RequestParam("ids")ArrayList<String> ids) {
		
		log.info("ids"+ ids);
		return "DTO ArrayList";
	}
	
	@GetMapping("/dtoArray")
	public String dtoArray(@RequestParam("ids") String[] ids) {
		
		log.info("array ids: " + Arrays.toString(ids));
		return "DTO Array";
	}
	
	@GetMapping("/dtoList")
	public String dtoList(SampleDTOList list) {
		
		log.info("list dtos"+ list);
		return "DTO list";
	}
	
//	@InitBinder
//	public void initBinder(WebDataBinder binder) {
//		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
//		binder.registerCustomEditor(java.util.Date.class, new CustomDateEditor(dateFormat,false));
//	}
	
	//많이 사용하는 방식은  DateTimeForma입니다,
	
	@GetMapping("/date")
	public String date(TodoDTO todo) {
		log.info("todo"+ todo);
		return "Date return";
	}
	
	@GetMapping("/jspDTO")
	public String jspDTO(SampleDTO dto, int page) {
		
		log.info("dto : "+ dto);
		log.info("page" + page);
		return "/legacyTest";
	}
	
	
	@GetMapping("/jspDTOModelAttribute")
	public String jspDTOModel(SampleDTO dto, @ModelAttribute("page") int page) {
		
		log.info("dto : "+ dto);
		log.info("page" + page);
		return "/legacyTest";
	}
	
	@GetMapping("/json")
	public @ResponseBody SampleDTO jsonreturn() {
		
		log.info("JSON TEST");
		SampleDTO dto = new SampleDTO();
		dto.setAge(20);
		dto.setName("둘리");
		return dto;
	}
	
	@GetMapping("/upload")
	public void exupload() {
		log.info("upload");
	}
	
	@PostMapping("/uploadPost")
	public void exuploadPost(ArrayList<MultipartFile> files) {
	
		files.forEach(file -> {
			
			log.info("--------------");
			log.info("name :" + file.getOriginalFilename());
			log.info("Size : " + file.getSize());
		});
	}
}
