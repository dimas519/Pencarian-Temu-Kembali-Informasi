/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ptki1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;

/**
 *
 * @author Kurni
 */
public class TFIDFWeighting {
    TrieInt trieTFIDF;
    
    public TFIDFWeighting(){
        this.trieTFIDF=new TrieInt();
  
    }
    
    public ArrayList<Vector> createTFIDFVector(ArrayList<Vector>input){
        //isi Trienya
         for(Vector vector:input){
             fillTrie(vector);
         }
        
         
         
        ArrayList<Vector> VectorWithTFIDFWeight=new ArrayList<>();
        ArrayList <VectorWeight> x =new ArrayList<>();
         //untuk setiap dokument
        for(Vector vector:input){
             ArrayList<VectorWeight> VW=vector.getVectorWeight();
             
             //ambil semua kata
            ArrayList<VectorWeight> VWTFIDF=new ArrayList<>();
            for(VectorWeight kata:VW){
                int contains=this.trieTFIDF.getValue(kata.getKata());
                double IDF=this.IDF(input.size(),contains);
                double TF=this.TF(kata.getBobot()); 
                double bobot=TF*IDF;
                
                x.add(new VectorWeight(kata.getKata(),contains));
                
                VectorWeight baru=new VectorWeight(kata.getKata(),bobot);
                VWTFIDF.add(baru);
                }
            VectorWithTFIDFWeight.add(new Vector(vector.getTitle(),VWTFIDF));
            }
        
        Collections.sort(x, (VectorWeight o1, VectorWeight o2) -> (int)(o2.getBobot()-o1.getBobot()));
        HashMap<String,String> exist=new HashMap<>();
        for(VectorWeight y : x){
            if(exist.containsKey(y.getKata())){
            
            }else{
                System.out.println(y.getKata()+" "+y.getBobot());
                exist.put(y.getKata(), "haha");
            }
        }
        
        return VectorWithTFIDFWeight;
    }
    
    private void fillTrie(Vector Doc){
        this.trieTFIDF.fill(Doc);
    }
        
    
    @Deprecated
    private int countNumDocumentCountains(ArrayList<Vector>corpus,String cari){
        
        int counter=0;
        
        for(Vector vec:corpus){
            ArrayList<VectorWeight> VW=vec.getVectorWeight();
            for(VectorWeight kata:VW){
                if(kata.getKata().equals(cari)){
                    counter++;
                    break;
                }
            }
        }
        return counter--; //diminus 1 karena itu punya dia sendiri
    }
    
    private double IDF(int numOfAllDoc,int contains){
        double bagi=(numOfAllDoc/contains*1.0);
        double IDF=(Math.log(bagi)/Math.log(2));
        return IDF;
    }
    
    private double TF(double rawFrek){
        double TF=Math.log10(1+rawFrek);
        return TF;
    }
    
    
    
}
