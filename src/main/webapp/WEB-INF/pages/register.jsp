<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

 <html>
 <head>
 <title>
 Registration form
 </title>
 <style>
 .error
 {
 color:#ff0000;
 font-weight: bold;
 
 }
 </style>
 </head>
 <body>
 
  <form:form action="registerDo"  method="post" commandName="user" >
   <%-- <form:errors path="*" cssClass="error" /> --%>
   <table>
    <tr>
     <td>First name: </td>
     <td> <form:input path="name" /> </td>
     <td> <form:errors path="name" cssClass="error" /> </td>
    </tr>
    <tr> 
    <td>Last name: </td>
    <td> <form:input path="surname" /> </td>
    <td> <form:errors path="surname" cssClass="error"  /> </td>
    </tr>
      
    <tr>
      <td>Phone: </td>
      <td><form:input path="phone" /> </td>
      <td> <form:errors path="phone" cssClass="error" /> </td>
    </tr>
    <tr>
    <td>Address:</td>
    <td> <form:input path="address" /> </td>
    <td> <form:errors path="address" cssClass="error" /> </td>
    </tr>
    <tr>
    <td>Mail: </td>
    <td> <form:input path="mail" /> </td>
    <td> <form:errors path="mail" cssClass="error" /> </td>
    </tr>
    <tr>
    <td>Password</td>
     <td> <form:password  path="password" /> </td>
     <td> <form:errors path="password" cssClass="error" /> </td>
    </tr>
    <tr>
    <td colspan="3"> <input type="submit" name="btnSubmit" value="Submit"/> </td>
    </tr>
    
   
   </table>
  </form:form>
 
 </body>
 </html>