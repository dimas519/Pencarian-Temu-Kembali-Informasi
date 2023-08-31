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
public class MergeSort {
    
    public void  mergeSort(ArrayList arr,int left,int right){
         if (left < right ){
             int mid = (left+right)/2;
             mergeSort(arr, left, mid);
             mergeSort(arr, mid+1, right);
             merge(arr, left, mid, right);
         }
    }

    public void merge(ArrayList arr, int left, int mid, int right){        
    int lSize=mid-left+1;
    int rSize=right-mid;
    int i=0;    
    ArrayList <VectorWeight> tempL=new ArrayList();
    ArrayList <VectorWeight> tempR=new ArrayList();
    
    for(i=0;i<lSize;i++){
        tempL.add(i, (VectorWeight)arr.get(left+i));
                
    }
    
    for( i=0;i<rSize;i++){
        tempR.add(i,(VectorWeight)arr.get(mid+i+1));
    }    
    
    tempL.add(lSize,new VectorWeight("{")); //dipake { karena lebih besar dari z 
    tempR.add(rSize,new VectorWeight("{"));  
        
        
    int idxL=0;
    int idxR=0;
    i=left;
    for(i=left;i<=right;i++){
        if(tempL.get(idxL).getKata().compareTo(tempR.get(idxR).getKata())<0    ){
            arr.set(i, tempL.get(idxL));
            idxL++;
        }else{
            arr.set(i, tempR.get(idxR));
            idxR++;
        }
    }
    }
    
    public void sort(ArrayList<VectorWeight>  arr){
        mergeSort(arr,0,arr.size()-1);
    } 
}
