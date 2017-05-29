package com.hb.day002.Support;

import java.util.HashMap;
import java.util.Map;

import com.hb.day002.Controller.MyController;

public class HandlerMapping {
	
	private  static Map<String, String> map = new HashMap<String, String>();
	
	public static void setMap(String param1, String param2){
		map.put(param1, param2);
	}	
	
//	
//	public static void setMap(String key, String value) {
//		map.put(key, value);
//	}
		
		public static MyController mapping(String uri) {
			MyController controller = null;
			
			System.out.println(map.get(uri));
				try {
					Class clazz = Class.forName(map.get(uri));
					controller=(MyController)clazz.newInstance();
				} catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
					e.printStackTrace();
				}
				
//			switch(uri){
//			case "/day002/index.do":
//			case "/day002/list.do":
//    //				controller = new ListController();
//				try {
//					Class clazz = Class.forName("com.hb.day002.Controller.ListController");
//					try {
//						controller=(MyController)clazz.newInstance();
//					} catch (InstantiationException e) {
//						e.printStackTrace();
//					} catch (IllegalAccessException e) {
//						e.printStackTrace();
//					}
//				} catch (ClassNotFoundException e) {
//					e.printStackTrace();
//				}
//					break;
//			case "/day002/add.do":
//				controller = new AddController();
//					break;
//			case "/day002/insert.do":
//				controller = new InsertController();
//					break;
//			
//			default:
//				controller = null;
//					break;
//			}
				
			return controller;
			
		}

}
