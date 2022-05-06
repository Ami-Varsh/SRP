<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
 pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Business Home Page</title>
<style>
    body{
        background-color: bisque;
    }
    table{
        width: 600px;
        padding: 25px;
        padding-bottom: 30px;
        font-family: verdana;
        font-size: 18px;
        text-align: justify;
    }
    td{
        width: 300%;
        align-content: center;
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
    h{
        color:chocolate;
    }
</style>
</head>
<body>
 <div align="center">
  <form action="Add" method="post">
   <table cellspacing="20">
       <br><br>
   <h1>Food Donation Details</h1>
    <tr>
     <td>Total Food Cooked </td>
<td><input type="number" name="cooked" required/></td>
    </tr>
    <tr>
     <td>Wasted Food Quantity</td>
     <td><input type="number" name="wasted" required/></td>
    </tr>
    <tr>
     <td>Food Item</td>
     <td><input type="text" name="name" required/></td>
    </tr>
    <tr>
     <td>Food Package Date</td>
     <td><input type="Date" name="date" required/></td>
    </tr>
    <tr>
     <td>Food Package Time</td>
     <td><input type="time" name="time" required/></td>
    </tr>
    <tr>
     <td>Upload Food Photo</td>
     <td><input type="File" name="ph" required/></td>
    </tr>
   </table>
   <input type="submit" value="Post" id="s"/>
  </form>
 </div>
</body>
</html>