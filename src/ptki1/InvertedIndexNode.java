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
public class InvertedIndexNode {
     private ArrayList<DocumentWeight> contains;
    private InvertedIndexNode[] arr;
    
    public InvertedIndexNode(){
        this.contains= new ArrayList<>();
        this.arr=new InvertedIndexNode[26];
    }
    
    public InvertedIndexNode[] getArray(){
        return this.arr;
    }

    public ArrayList<DocumentWeight> getContains() {
        return contains;
    }

    public void putDocument(String Document,double bobot) {
        this.contains.add(new DocumentWeight(Document,bobot));
    }
}
