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
public class SelectNBest {
    private MinHeap heap;
    public SelectNBest(int n){
        this.heap=new MinHeap(n);
    }
    
    public AkumulatorList[] process(ArrayList<AkumulatorList> list){
        for(AkumulatorList curr:list){
            this.heap.insert(curr);
        }
        return heap.getHasil();
    } 
}
