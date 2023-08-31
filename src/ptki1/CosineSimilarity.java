

package ptki1;

import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author Kurni
 */
public class CosineSimilarity implements MergeInterface{
    private Vector query;    
    
    public CosineSimilarity(Vector query){
        this.query=query;
    }
    
    
    
    //YANG MENGGUNAKAN TEKNIK LAMA (MERGING)
      @Override
    public ArrayList<Double> calculateSimilarity(ArrayList<Vector> arr) {
        Merge mergeAlgo=new Merge(query);
        ArrayList<Double> hasil=mergeAlgo.cosineSimilarity(arr);
        return hasil;
    }
   




    

    
    
    
    
    
    
    
   





    
    
    
    
    
    

    
}





