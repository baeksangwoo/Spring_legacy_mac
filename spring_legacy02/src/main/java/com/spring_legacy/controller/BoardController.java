package com.spring_legacy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.spring_legacy.domain.BoardVO;
import com.spring_legacy.service.BoardService;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Controller
@Log4j
@RequestMapping("/board/*")
@AllArgsConstructor
public class BoardController {
	
	private BoardService service;
	
	@GetMapping("/list")
	public void list(Model model) {
		log.info(model);
		
		model.addAttribute("list",service.getList());
	}
	
	@PostMapping("/register")
	public String register(BoardVO board, RedirectAttributes rtts) {
		log.info(board);
		
		service.register(board);
		
		rtts.addFlashAttribute("result", board.getBno());
		
		return "redirect:/board/list";
	}
	
	@GetMapping("/get")
	public void get(@RequestParam("bno") Long bno, Model model) {
		log.info("/get");
		model.addAttribute("board",service.get(bno));
	}
	
	@PostMapping("/modify")
	public String modify(BoardVO board, RedirectAttributes attr) {
		
		log.info("modify" + board);
		if(service.modify(board)) {
			attr.addFlashAttribute("result","SUCCESS");
		}
		return "redirect:/borad/list";		
	}
	
	@PostMapping("/remove")
	public String remove(@RequestParam("bno") Long bno, RedirectAttributes attr) {
		
		log.info("remove" + bno);
		if(service.remove(bno)) {
			attr.addFlashAttribute("result","SUCCESS");
		}
		return "redirect:/borad/list";		
	}
	
	

}
