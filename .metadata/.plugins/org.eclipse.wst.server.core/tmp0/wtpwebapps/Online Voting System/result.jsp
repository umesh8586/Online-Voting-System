<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.PreparedStatement"%>
<!DOCTYPE html>
<html>
<head>
<%
   
    int a[] = new int[100];
	
 
    Class.forName("com.mysql.cj.jdbc.Driver");
	java.sql.Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/OnlineVotingDatabase","root","Kumar@1801");
	
	PreparedStatement preparedStatement = con.prepareStatement("select parties,count(parties) as c from votecount group by parties");
	ResultSet rs=((java.sql.Statement) preparedStatement).executeQuery("select parties,count(parties) as c from votecount group by parties");
	
	int i=0;
    while(rs.next()){
        int temp = Integer.valueOf(rs.getString("c"));
        a[i]=temp-1;
        i++;
    }
    %>
<meta charset="ISO-8859-1">
<link rel = "stylesheet" type = "text/css" href = "style.css">
<title>Result</title>
</head>
<body>
<%@include file="adminnav.jsp" %>
<div class="checkTable">
<table>
<tr>
<th>Parties</th>
<th>Names</th>
<th>Votes</th>
</tr>
<tr>
<td><img src="https://upload.wikimedia.org/wikipedia/commons/thumb/6/65/Aam_Aadmi_Party_logo_%28English%29.svg/1200px-Aam_Aadmi_Party_logo_%28English%29.svg.png" alt="AAP"></td>
<td>Aam Aadmi Party</td>
<td><%=a[0]%></td>
</tr>
<tr>
<td><img src="https://w0.peakpx.com/wallpaper/994/344/HD-wallpaper-bjp-bjp-logo.jpg" alt="BJP"></td>
<td>Bhartiye Janta Party</td>
<td><%=a[1]%></td>
</tr>
<tr>
<td><img src="http://www.pngimagesfree.com/LOGO/C/congress/round-congress-logo-png.png"alt="INC"></td>
<td>Indian National Congress</td>
<td><%=a[2]%></td>
</tr>
</table>
</div>
</body>
</html>