 package com.ict.db;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

public class DAO {
	private static SqlSession ss;
	private synchronized static SqlSession getSession() {
		if (ss == null) {
			ss= DBService.getFactory().openSession(false);
		}
	return ss;
	}
	
	public static List<BVO> getList(){
		List<BVO> list = new ArrayList<BVO>();
		list= getSession().selectList("list");
		return list;
		
	}
	// 총 게시물의 수 구하기
	public static int getCount() {
		int result=0;
		result= getSession().selectOne("count");
		return result;
	}
	// 페이징 기법을 사용할 리스트(시작번호 끝번호)
	public static List<BVO> getList(int begin,int end){
		List<BVO> list=new ArrayList<BVO>();
		Map<String , Integer> map= new HashMap<String, Integer>();
		map.put("begin", begin);
		map.put("end", end);
		list = getSession().selectList("list", map);
		return list;
	}
	
	public static int getInsert(BVO bvo) {
		int result=0;
		result=getSession().insert("insert", bvo);
		System.out.println(bvo);
		ss.commit();
		return result;
	}
	
	public static int getHitUp(String b_idx) {
		int result=0;
		result=getSession().update("hitup", b_idx);
		System.out.println(b_idx);
		ss.commit();
		
		return result;
	}
	
	public static BVO getOneList(String b_idx) {
		BVO bvo= new BVO();
		bvo=getSession().selectOne("onelist", b_idx);
		
		return bvo;
		
	}
	public static List<CVO> getcList(String b_idx){
		List<CVO> clist= new ArrayList<CVO>();
		clist=getSession().selectList("clist", b_idx);
		return clist;
		
	}
	
	public static int getC_insert(CVO cvo) {
		int result=0;
		result=getSession().insert("c_insert", cvo);
		ss.commit();
		return result;
	}
	
	public static int getUpdate(BVO bvo) {
		int result=0;
		result=getSession().update("update", bvo);
		ss.commit();
		return result;
	}
	public static int getC_delete(CVO cvo) {
		int result=0;
		result=getSession().delete("c_delete", cvo);
		ss.commit();
		return result;
	}
	//원글 삭제
	public static int getDelete(String b_idx) throws Exception{
		int result=0;
		result=getSession().delete("delete",b_idx);
		ss.commit();
		return result;
	}
	public static int getDeleteAll(String b_idx)throws Exception {
		int result=0;
		result=getSession().delete("c_deleteAll", b_idx);
		ss.commit();
		return result;
	}
	
}
