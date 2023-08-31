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
public class VectorWeight {

    private String kata;
    private double bobot; //bobot

    public VectorWeight(String kata) {
        this.kata = kata;
        this.bobot = 1.0;
    }
    
     public VectorWeight(String kata,double bobot) {
        this.kata = kata;
        this.bobot = bobot;
    }

    public void setBobot(double angka) {
        this.bobot = angka;
    }

    public void incBobot() {
        this.bobot += 1.0;
    }

    public String getKata() {
        return this.kata;
    }

    public double getBobot() {
        return this.bobot;
    }

}
