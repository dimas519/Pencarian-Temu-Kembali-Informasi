/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ptki1;

import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author Kurni
 */
public class Akumulator {
    private HashMap<String,Double> hashmap;
    
    
    public Akumulator(){
        this.hashmap=new HashMap<>();
    }
    
    
    public void addAkumulator(String doc,double bobot){
        if(this.hashmap.containsKey(doc)){
            double bobotLama=this.hashmap.get(doc);
            this.hashmap.put(doc,bobotLama+bobot);
        }else{
            this.hashmap.put(doc, bobot);
        }  
    }
    
    
    
    public ArrayList<AkumulatorList> getList(){
        ArrayList<AkumulatorList> arr=new ArrayList<>();
        for(String title:this.hashmap.keySet()){
            double bobot=this.hashmap.get(title);
            AkumulatorList al=new AkumulatorList(title,bobot);
            arr.add(al);
        }
        return arr;
    }
}
