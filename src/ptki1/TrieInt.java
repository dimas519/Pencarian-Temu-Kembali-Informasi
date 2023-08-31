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
public class TrieInt {
    private TrieNodeInt root;
    private ArrayList<VectorWeight> vw=new ArrayList<>();

    
    
    public TrieInt() {
        this.root = new TrieNodeInt();
    }
    
    public void fill( Vector document){
        ArrayList<VectorWeight> kataFrek=document.getVectorWeight();
        for(VectorWeight kata:kataFrek){
            insert(kata.getKata(),document.getTitle(),kata.getBobot());
        }

    }

    private void insert(String kata,String judul,double frekuensi) {
        TrieNodeInt current = root;
        int panjangKata = kata.length();
        for (int i = 0; i < panjangKata; i++) {
            char huruf = kata.charAt(i);
            int urut = Converter.toNumber(huruf);
            TrieNodeInt[] arr = current.getArray();
            
            if (arr[urut] == null) {
                arr[urut]=new TrieNodeInt();
            } 
            current=arr[urut];
        }
       current.addValue(judul,frekuensi);
    }
    
    
    public int getValue(String kata){
       TrieNodeInt current = root;
        int panjangKata = kata.length();
        for (int i = 0; i < panjangKata; i++) {
            char huruf = kata.charAt(i);
            int urut = Converter.toNumber(huruf);
            TrieNodeInt[] arr = current.getArray();
            
            if (arr[urut] == null) {
                return -1;
            } 
            current=arr[urut];
        }
       return current.getNumOfDocument();
    }
    
    

 
    
    
}
