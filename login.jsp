<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
 pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login Page</title>
<style>
    body{
        background-color: bisque;
                color:chocolate;
                font-family: arial;
                font-size: 22px;
    }
    table{
        width: 100px;
        padding: 25px;
        padding-bottom: 30px;
        font-family: verdana;
        font-size: 18px;
    }
    #s{
        background-color: sandybrown;
                border: brown;
                border-radius: 12px;
                color: brown;
                padding: 4px 20px;
                text-align: center;
                margin: none;
                cursor: pointer;
                align: right;
                font-family: verdana;
                font-size: 22px;
        font-family: Times New Roman;
       
    }
</style>
</head>
<body>
    <div align="center"><br><br>
  <h1>User Login Form</h1>
  <form action="login" method="post">
   <table cellspacing="20">
    <tr>
     <td>User ID</td>
<td><input type="text" name="username" required/></td>
    </tr>
    <tr>
     <td>Password</td>
     <td><input type="password" name="pwd" required/></td>
    </tr>

   </table>
   <input type="submit" value="Login" id="s"/>
  </form>
 </div>
</body>
</html>