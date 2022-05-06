/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author amirt
 */
public class user {
 static String uid;
 static String pwd;
 public static void add(String u, String p)
 {
     uid=u;
     pwd=p;
 }
 public static String get_username()
 {
     return uid;
 }
 public static String get_pwd()
 {
     return pwd;
 }
}
