package com.sist.dao;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.sist.vo.*;
import java.io.*;
import java.util.*;

public class FoodDAO {
	private static SqlSessionFactory ssf;
	
	static {
		try {
			Reader reader = Resources.getResourceAsReader("Config.xml");
			ssf = new SqlSessionFactoryBuilder().build(reader);
		}catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	
	public static List<FoodVO> foodFindData(Map map){
		SqlSession session = ssf.openSession();
		List<FoodVO> list = session.selectList("foodFindData", map);
		session.close();
		return list;
	}
	
	public static int foodFindCount(Map map){
		SqlSession session = ssf.openSession();
		int count = session.selectOne("foodFindCount", map);
		session.close();
		return count;
	}
	
}
