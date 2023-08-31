/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ptki1;

/**
 *
 * @author Kurni
 */
public class TrieNode {
    private int value;
    private TrieNode[] arr;
    public TrieNode(){
        this.arr=new TrieNode[26];
    }
    
    public int getValue(){
        return this.value;
    }
    
    public void setValue(int value){
        this.value=value;
    }
    
    public TrieNode[] getArray(){
        return this.arr;
    }
    
    public void setArray(TrieNode[] arr){
        this.arr=arr;
    }
    
    public void incValue(){
        this.value++;
    }
}
