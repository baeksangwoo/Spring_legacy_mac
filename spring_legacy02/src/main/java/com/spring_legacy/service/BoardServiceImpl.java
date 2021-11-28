package com.spring_legacy.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.spring_legacy.domain.BoardVO;
import com.spring_legacy.mapper.BoardMapper;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Log4j
@Service
@AllArgsConstructor
public class BoardServiceImpl implements BoardService{

	private BoardMapper mapper;
	
	@Override
	public void register(BoardVO board) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public BoardVO get(Long bno) {
		
		log.info("get...."+ bno);
		return mapper.read(bno);
	}

	@Override
	public boolean modify(BoardVO board) {
		
		log.info("modify..."+ board);
		return mapper.update(board) == 1 ;
	}

	@Override
	public boolean remove(Long bno) {
		log.info("delete..." +  bno);
		return mapper.delete(bno) == 1;
	}

	@Override
	public List<BoardVO> getList() {
		
		log.info("Getlist.......");
		
		return mapper.getList();
	}

}
