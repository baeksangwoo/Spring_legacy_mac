package com.spring_legacy.mapper;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.spring_legacy.domain.BoardVO;
import com.spring_legacy.sample.Company;
import com.spring_legacy.sample.SampleTest;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class BoardMapperTests {
	
	@Autowired
	@Setter
	private BoardMapper boardmap;
	
//	@Test
//	public void testExist() {
//		boardmap.getList().forEach(board -> log.info(board));
//	}
//	
//	@Test
//	public void testInsert() {
//		
//		BoardVO board = new BoardVO();
//		board.setTitle("새로 작성하는 글");
//		board.setContent("새로 작성하는 내용");
//		board.setWriter("Newbie");
//	
//		boardmap.insert(board);
//		log.info(board);
//	}
//
//	@Test
//	public void testInsertSelectKey() {
//		
//		BoardVO board = new BoardVO();
//		board.setTitle("새로 작성하는 글");
//		board.setContent("새로 작성하는 내용");
//		board.setWriter("Newbie");
//	
//		boardmap.insertSelectKey(board);
//		log.info(board);
//	}
//	
//	@Test
//	public void testRead() {
//		
//		BoardVO board = boardmap.read(8L);
//		
//		log.info(board);
//	}
	
//	@Test
//	public void testDelete() {
//		log.info("삭제 테스트입니다."+boardmap.delete(8L));
//	}
	
	@Test
	public void testUpdate() {
		BoardVO board = new BoardVO();
		board.setBno(6L);
		
		int count = boardmap.update(board);
		log.info("업데이 테스트입니다."+boardmap.delete(8L));
	}
}
