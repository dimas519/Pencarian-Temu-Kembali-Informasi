/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ptki1;

import java.util.ArrayList;

/**
 *
 * @author Kurni
 */
public class Merge {
    private Vector query;    
        
    public Merge(Vector Query){
        mergeSort(Query);
        this.query=Query;
    }
    
     @Deprecated
    private void mergeSort(Vector v) {
       MergeSort sorting= new MergeSort();
       sorting.sort(v.getVectorWeight());
    }
    
    @Deprecated
    public ArrayList<Double> cosineSimilarity(ArrayList<Vector> corpus){
        ArrayList<Double> similarity=new ArrayList();
        for(Vector doc1:corpus){
            mergeSort(doc1);
            int idxDoc=0;
            int idxQ=0;
            int sizeDoc=doc1.getVectorWeight().size();
            int sizeQuery=query.getVectorWeight().size();
            int atas=0;
            
            do{
                int komparasi=doc1.getVectorWeight().get(idxDoc).getKata().compareTo(query.getVectorWeight().get(idxQ).getKata());
                if(komparasi==0){
                    atas+=(doc1.getVectorWeight().get(idxDoc).getBobot()*query.getVectorWeight().get(idxQ).getBobot());
                    idxDoc++;
                    idxQ++;
                }else if(komparasi < 0){
                    idxDoc++;
                }else {
                    idxQ++;
                }
       }while(sizeDoc>idxDoc && sizeQuery>idxQ);
            
        double hasil= (atas*1.0)/(doc1.getPanjang()*query.getPanjang()) ;
        similarity.add(hasil);
        }
        return similarity;
    }
    
    
    
    
    
    
}
