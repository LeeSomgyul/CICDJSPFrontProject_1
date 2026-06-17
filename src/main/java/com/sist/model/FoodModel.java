package com.sist.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.sist.controller.Controller;
import com.sist.controller.RequestMapping;
import com.sist.dao.FoodDAO;
import com.sist.vo.FoodVO;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Controller
public class FoodModel {
	@RequestMapping("food/find.do")
	public String food_find(HttpServletRequest request, HttpServletResponse response) {
		
		String page = request.getParameter("page");
		if(page==null)
			page="1";
		
		String column = request.getParameter("column");
		if(column == null)
			column = "address";
		
		String ss = request.getParameter("ss");
		if(ss==null)
			ss="마포";
		
		String[] types = request.getParameterValues("type");
		
		int curpage = Integer.parseInt(page);
		final int ROWSIZE = 12;
		int start = (curpage*ROWSIZE)-ROWSIZE;
		
		Map map = new HashMap();
		map.put("ss", ss);
		map.put("start", start);
		map.put("column", column);
		map.put("fdArr", types);
		
		List<FoodVO> list = FoodDAO.foodFindData(map);
		int count = FoodDAO.foodFindCount(map);
		
		int totalPage = (int)(Math.ceil(count/(double)ROWSIZE));
		
		final int BLOCK = 10;
		int startPage = ((curpage-1)/BLOCK*BLOCK)+1;
		int endPage = ((curpage-1)/BLOCK*BLOCK)+BLOCK;
		
		if(endPage > totalPage)
			endPage = totalPage;
		
		request.setAttribute("list", list);
		request.setAttribute("curpage", curpage);
		request.setAttribute("totalpage", totalPage);
		request.setAttribute("startPage", startPage);
		request.setAttribute("endPage", endPage);
		request.setAttribute("count", count);
		request.setAttribute("ss", ss);
	
		
		return "find.jsp";
	}
	
}
