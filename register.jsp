<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
 pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registration Page</title>
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
    }
</style>
</head>
<body>
 <div align="center"><br/><br/>
  <h1>User Registration Form</h1>
  <form action="reg" id="registerform" method="POST">
   <table cellspacing="20">
       <tr>
           <td>Name </td><!-- comment -->
           <td><input type="text" name="name" required/></td>
       </tr>
       <tr>
           <td>Account Type</td><!-- comment -->
           <td>
           <input type="radio" id="type" name="type" value="Business">
           <label for="Business">Business</label><br>
           <input type="radio" id="type" name="type" value="Charity">
           <label for="Charity">Charity</label><br>
           </td>
       </tr>
       <tr>
        <td>Address </td>
        <td><input type="text" name="addr" required/></td> 
       </tr><!-- comment -->
       <tr>
        <td>Mobile.No: </td>
        <td><input type="text" size="10" name="ph" required/></td> 
       </tr>
       <tr>
           <td>Mail ID </td><!-- comment -->
           <td><input type="text" name="mail" required/></td>
       </tr>
       <tr>
         <td>Password</td>
         <td><input type="password" name="pwd" required/></td>
       </tr>  
   </table>
   <input type="submit" value="Register" id="s"/>
  </form>
 </div>
</body>
</html>