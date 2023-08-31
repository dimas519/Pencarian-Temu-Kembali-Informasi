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
public class DocumentWeight {

    private String namaDocument;
    private double bobot; //bobot

    public DocumentWeight(String kata) {
        this.namaDocument = kata;
        this.bobot = 1;
    }
    
     public DocumentWeight(String kata,double bobot) {
        this.namaDocument = kata;
        this.bobot = bobot;
    }

    public void setBobot(double angka) {
        this.bobot = angka;
    }

    public void incBobot() {
        this.bobot += 1.0;
    }

    public String getNamaDocument() {
        return this.namaDocument;
    }

    public double getBobot() {
        return this.bobot;
    }

}
