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
public class TrieNodeInt {
    private ArrayList<VectorWeight> value;
    private TrieNodeInt[] arr;
    
    private int numOfDocument;
    
    
    public TrieNodeInt(){
        this.value=new ArrayList<>();
        this.arr=new TrieNodeInt[26];
        this.numOfDocument=0;
    }
    
    public ArrayList getValue(){
        return this.value;
    }
    
    public void addValue(String doc,double value){
        VectorWeight baru=new VectorWeight(doc);
        baru.setBobot(value);
        this.value.add(baru);
        this.numOfDocument++;
    }
    
    public TrieNodeInt[] getArray(){
        return this.arr;
    }
    
    public int getNumOfDocument(){
        return this.numOfDocument;
    }
    
    public void setArray(TrieNodeInt[] arr){
        this.arr=arr;
    }
    


}
