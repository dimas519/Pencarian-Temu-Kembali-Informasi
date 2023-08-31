/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ptki1;

import java.util.ArrayList;
import java.util.Stack;

/**
 *
 * @author Kurni
 */
public class Trie  {
    private TrieNode root;
    private ArrayList<VectorWeight> vw=new ArrayList<>();
    
    
    public Trie() {
        this.root = new TrieNode();
    }
    
    public void fill(String[] kumpulanKata){
        for(String kata:kumpulanKata){
            increment(kata);
        }
    }

    private void increment(String kata) {
        TrieNode current = root;
        int panjangKata = kata.length();
        for (int i = 0; i < panjangKata; i++) {
            char huruf = kata.charAt(i);
            int urut = Converter.toNumber(huruf);
            TrieNode[] arr = current.getArray();
            
            if (arr[urut] == null) {
                arr[urut]=new TrieNode();
            } 
            current=arr[urut];
        }
       current.incValue();
    }
    
    public ArrayList<VectorWeight> getArrayList(){
      TrieNode current=this.root;
      getAll(current,"");
      return this.vw;
    }
    
    
    private void getAll(TrieNode curr,String temp){
        TrieNode arr[]=curr.getArray();
        for(int i=0;i<26;i++){
            TrieNode x=arr[i];
            if(x!=null){
                getAll(x, temp+Converter.toChar(i));
                if(x.getValue()!=0){
                    String kata=temp+Converter.toChar(i);
                    VectorWeight baru=new VectorWeight(kata);
                    baru.setBobot(x.getValue());
                    vw.add(baru);
                }
            }
        }
          
    }


  

    

   
    

}