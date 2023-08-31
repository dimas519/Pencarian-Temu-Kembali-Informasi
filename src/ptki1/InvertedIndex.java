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
public class InvertedIndex {
    private InvertedIndexTrie iit;
    
    public InvertedIndex(ArrayList<Vector> arrVector){
        this.iit=new InvertedIndexTrie();
        this.iit.fill(arrVector);
    }
    
    public HashMap getUniqueKata(){
        return this.iit.getUniqueKata();
    }
    
    
    
    
    public Akumulator countAkumulator( Vector query){        
        Akumulator akum=new Akumulator();
        for(VectorWeight vwCurrQuery : query.getVectorWeight()){
            ArrayList<DocumentWeight> inve=this.iit.getInvertedIndex(vwCurrQuery.getKata());
            
            
            //tiap isi dokumen yang mengandung kata
            for(DocumentWeight alldocIn:inve){
                String judul=alldocIn.getNamaDocument();
                double bobotQuery=vwCurrQuery.getBobot();
                double bobot=bobotQuery*alldocIn.getBobot();
                
                akum.addAkumulator(judul,bobot);
            }
        }
            return akum;
    }

    
}
