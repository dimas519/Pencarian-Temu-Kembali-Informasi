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
public class VectorExpansion {
    public static Vector expandWithLCS(HashMap<String,Integer> uniqueKata,Vector query){
        
        ArrayList <VectorWeight> arrQuery=query.getVectorWeight();
        
        
        
        HashMap<String,Double> newExpanded=new HashMap<>(); //menjamin agar dia tidak double karena skor LCS Nya sama
        for(VectorWeight currQuery:arrQuery){
            String currKata=currQuery.getKata();
            double currBobot=currQuery.getBobot();
            for(String currUnique:uniqueKata.keySet()){
                
      
                int resLCS=LongestCommonSubstring.counter(currUnique,currKata);
                if(resLCS==currKata.length()){
                    newExpanded.put(currUnique,(currBobot/2.0));
                }

              newExpanded.put(currKata,currBobot);//masukan juga yang lama kalaupun tidak ada yg sama;
                
            }
            
        }
        ArrayList<VectorWeight> newVector =new ArrayList<>();
        for(String kata:newExpanded.keySet()){ //konvert kembali ke ArrayList
            newVector.add(new VectorWeight(kata,newExpanded.get(kata)));
        }
        
        Vector expanded=new Vector("QueryExpanded",newVector);
  
        return expanded;
    }
    
    
    
    
}
