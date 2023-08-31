/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ptki1;

/**
 *
 * @author Kurni
 */
public class AkumulatorList{
    private String titleDocument;
    private double similarity;
   
    public AkumulatorList(String title,double bobot){
        this.titleDocument=title;
        this.similarity=bobot;
    }
    
    public double getBobot(){
        return this.similarity;
    }
    
    public String getJudul(){
        return this.titleDocument;
    }
    
    
    
}
