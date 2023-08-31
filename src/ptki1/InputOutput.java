/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ptki1;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.LinkedList;






/**
 *
 * @author Kurni
 */
public class InputOutput {
    private String outputPath;

    
    public LinkedList<File> getAllDoc(String path){
        LinkedList <File> ll =new LinkedList();
         getAllDoc(ll,path);
         return ll;
    }
   
    public void getAllDoc(LinkedList<File> ll,String path){
        File folder=new File(path);
        File[] dir=folder.listFiles();
        LinkedList loc=new LinkedList();
         for(File a:dir){
             if(a.isDirectory()){
                 getAllDoc(ll,a+"");
                 
             }else{
                 ll.add(a);
             }
         }
    }
    
    public String process(File path){
            try {
                
               FileReader file=new FileReader(path+"");
                BufferedReader document=new BufferedReader (file);
                String kata="";
                String temp="";
                while ((kata=document.readLine())!=null){         
                    temp+=kata;
                }
                return temp;
                
            } catch (Exception e) {
                System.out.println("File: "+ path+" tidak ditemukan");
                return "fail";
            }
    }
}
