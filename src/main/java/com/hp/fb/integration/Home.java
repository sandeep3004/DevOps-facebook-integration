package com.hp.fb.integration;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Home
 */
public class Home extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String code=" ";
	private	String  accessToken1=" ";
    public Home() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
		
		// begin facebook code for getting access tokens
		code = request.getParameter("code");  
		if (code == null || code.equals(""))
		{
			throw new RuntimeException("ERROR: Didn't get code parameter in callback.");
		}
		System.getProperties().put("http.proxyHost", "proxy.sgp.hp.com");
		System.getProperties().put("http.proxyPort", "8080");
		FBConnection fbConnection = new FBConnection();
		String accessToken = fbConnection.getAccessToken(code);
		System.out.println("accessToken"+accessToken);
		FBGraph fbGraph = new FBGraph(accessToken);// get the user accessToken
		String graph = fbGraph.getFBGraph();
		//String graph = fbGraph.getUserInfo(accessToken);
		System.out.println("accessTokensss:"+graph);
		Map<String, String> fbProfileData = fbGraph.getGraphData(graph);
		
		//create an array to pass Personal Info to PersonalInfo.jsp
		ArrayList<String> array=new ArrayList<String>();
		array.add(fbProfileData.get("id"));
		array.add(fbProfileData.get("first_name"));
		array.add(fbProfileData.get("last_name"));
		array.add(fbProfileData.get("name"));
		array.add(fbProfileData.get("gender"));
		array.add(fbProfileData.get("email"));
		array.add(fbProfileData.get("locale"));
		HttpSession session=request.getSession();
		session.setAttribute("personalInfo", array);
		// end of PersonalInfo code
		
		//code to find friends
		
		//end of find friends code
		
		ServletOutputStream out = response.getOutputStream();
		out.println("<br><br><center>");
		out.println("<a href='CalculateFriends'>Calculate total number of friends</a>");
		out.println("<br><br>");
		out.println("<a href='PersonalInfo.jsp'>Show personal info</a>");
		out.println("<br><br>");
		out.println("<a href='Checkins'>Checkins</a>");
		out.println("<br><br>");
		out.println("<a href='Photos'>Photos</a>");
		out.println("</div>");
		out.println("</center>");
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
