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
public class WordCount implements bruteForceBuildVectorWeight, buildVectorWeightWithTrie  {

    private String[] splitDoc(String doc){
        doc=doc.toUpperCase();
        doc=doc.replaceAll("[^A-Z\\s\\n]",""); //menghilakan whitespace diawal
        String arrKata[]=doc.split(" ");
        return arrKata;
    }
        
    @Override
    public ArrayList<VectorWeight> getVectorWeight(String doc) { //pake teknik lama brute force
        BruteForceVW bf=new BruteForceVW();
        bf.fill(splitDoc(doc));
        return bf.getArrayList();
    }

    @Override
    public ArrayList<VectorWeight> getVectorWeightWithTrie(String doc) {
        Trie t=new Trie();
        t.fill(splitDoc(doc));
        return t.getArrayList();
    }
    
   

    
    
    
    
    
    
    
    
    
    
}
