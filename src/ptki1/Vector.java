/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ptki1;

import java.util.ArrayList;

/**
 *
 * @author Kurni
 */
public class Vector {
    private ArrayList <VectorWeight> arr=new ArrayList<>();
    private double length;
    private String title;
    
    public Vector(String title,ArrayList <VectorWeight> input){
        this.arr=input;
        this.length=countPanjang();
        this.title=title;
        normalize();
    }
    
    private double countPanjang(){
        double panjang=0.0;
        for(VectorWeight x: this.arr){
            panjang+=(x.getBobot()*x.getBobot());
        }
        return Math.sqrt(panjang);
    }
    
    public ArrayList<VectorWeight> getVectorWeight(){
        return this.arr;
    }
    
    public double getPanjang(){
        return this.length;
    }
    
    public String getTitle(){
        return this.title;
    }
    
    public void setPanjang(double panjang){
        this.length=panjang;
    }
    
    private void normalize(){
       for(VectorWeight vw: getVectorWeight()){
           
           vw.setBobot(vw.getBobot()/this.length);
       }
    }
    
    
   
    
    
}
