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
public class InvertedIndexTrie {
    private InvertedIndexNode root;
    private HashMap<String,Integer> uniqueKata; // digunakan untuk vector expansion

    public InvertedIndexTrie() {
        this.root = new InvertedIndexNode();
        this.uniqueKata=new HashMap<>();
    }

    public void fill(ArrayList<Vector> arrVector){
        for(Vector vec:arrVector){
            String judul=vec.getTitle();
            ArrayList<VectorWeight> vwDoc=vec.getVectorWeight();
            for(VectorWeight vw : vwDoc){
                String kata=vw.getKata();
                double bobot=vw.getBobot();
                fill(kata,judul,bobot);
            }  
        }
    }
    

    private  void fill(String kata,String judul,double bobot) {
        InvertedIndexNode current = root;
        kata=kata.toUpperCase();
        int panjangKata = kata.length();
        for (int i = 0; i < panjangKata; i++) {
            char huruf = kata.charAt(i);
            int urut = Converter.toNumber(huruf);
            InvertedIndexNode[] arr = current.getArray();

            if (arr[urut] == null) {
                arr[urut]=new InvertedIndexNode();
            }
            current=arr[urut];
        }
        current.putDocument(judul,bobot);
        this.uniqueKata.put(kata, 1);
        
    }
    
    public HashMap getUniqueKata(){
        return this.uniqueKata;
    }
    
    
    
    public ArrayList<DocumentWeight> getInvertedIndex(String dari) {
        InvertedIndexNode current = root;
        int panjangKata = dari.length();
        for (int i = 0; i < panjangKata; i++) {
            char huruf = dari.charAt(i);
            int urut = Converter.toNumber(huruf);
            InvertedIndexNode[] arr = current.getArray();

            if (arr[urut] == null) {
                arr[urut]=new InvertedIndexNode();
            }
            current=arr[urut];
        }
       return current.getContains();
    }
    
    
}
