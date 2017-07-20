package com.generator.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class GeneratorTablesServlet extends HttpServlet {
//	public static ArrayList<String> Cache=new ArrayList<>(); 
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public GeneratorTablesServlet() {
		super();
	}
	@Override
	public void init() throws ServletException {
		super.init();
	}
	
	@Override
	public void destroy() {
//		if(Cache.size()==0){
//			Cache.clear();
//			Cache.addAll(tableNames);
//			return;
//			}
//		if(!Cache.containsAll(tableNames)){
//			for (String string : tableNames) {
//				if(!Cache.contains(string)){
//					Cache.add(string);
//				}
//			}
//		}
//		tableNames.clear();
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {
		String connect = request.getParameter("connection");
		String port = request.getParameter("port");
		String dataBase = request.getParameter("dataBase");
		String userId = request.getParameter("userId");
		String password = request.getParameter("userPass");
		StringBuffer url=new StringBuffer();
		url.append("jdbc:mysql://");
		url.append(connect);
		url.append(":"+port);
		url.append("/"+dataBase);
		ArrayList<String> tables = getTables(url.toString(), userId, password);
		String respStr = tables.toString();
		responseJson(resp,respStr);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		super.doGet(req, resp);
	}
	
	 public void responseJson(HttpServletResponse response,String zipName) throws IOException{
			response.setContentType("text/plain;charset=UTF-8");
			response.setCharacterEncoding("UTF-8");
			PrintWriter out = response.getWriter();
			out.write(zipName);
			out.flush();
	 }
	 
	public ArrayList<String> getTables(String url,String user,String password){
		ArrayList<String> tableNames=new ArrayList<>(); 
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		Connection connection;
		String mysqlSql="show tables";
		//String oracleSql="select distinct table_name from user_tab_privs";
		ResultSet resultSet;
		try {
			 connection=DriverManager.getConnection(url, user, password);
			 PreparedStatement prepareStatement = connection.prepareStatement(mysqlSql);
			  resultSet = prepareStatement.executeQuery();
			 while(resultSet.next()){
				 String tableName = resultSet.getString(1);
				
				 tableNames.add( "\""+ tableName+"\"");
			 }
		} catch (SQLException e) {
			e.printStackTrace();
			tableNames.clear();
			tableNames.add("出错了"+e.getMessage());
		}
		return tableNames;
	}
	
	public String filter(String str){
		if(str.indexOf('[')==-1||str.indexOf(']')==-1){
			return null;
		}
		return str.replace("[","{").replace("]","}");
	}
}
