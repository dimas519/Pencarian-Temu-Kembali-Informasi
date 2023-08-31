/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ptki1;

import java.util.ArrayList;

/**
 *MEMBUAT VECTOR WEIGHT DENGAN BRUTE FORCE APAKAH ADA YG SAMA
 * @author Kurni
 */
public class BruteForceVW {
    private ArrayList <VectorWeight> kataFrek=new ArrayList();
    private void fill(String kata){
        int idx=isExist(kata);
        if(idx>-1){
           tambahFrekuensi(idx);
        }else {
            inputNewKata(kata);
        }
    }
  
    private int isExist(String key){ //digunakan -1 sebagai tanda kalau dia tidk ada
        int idx=-1;
        for(int i=0;i<kataFrek.size();i++){
            if(kataFrek.get(i).getKata().equals(key)){
                idx=i;
                break;
            }
        }
        return idx;
    }
    
    private void tambahFrekuensi(int index){
        this.kataFrek.get(index).incBobot(); //increment mksdnya
    }
    
    private void inputNewKata(String kata){
        this.kataFrek.add(new VectorWeight(kata));
    }
    
    public void fill(String arrKata[]){ //memmisahkan dan membersihkan kalimat
        for(int i=0;i<arrKata.length;i++){
            String kata=arrKata[i];
            if(!kata.equals("")){
                fill(kata);
            }
        }
    }
    
    public ArrayList<VectorWeight> getArrayList(){
        return this.kataFrek;
    }
}
