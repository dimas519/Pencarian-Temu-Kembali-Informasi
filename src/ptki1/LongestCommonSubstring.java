/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ptki1;

/**
 *
 * @author Kurni
 */
public class LongestCommonSubstring {
    
    public static int counter(String kataSatu,String kataDua){
        
        if(kataSatu.length()<kataDua.length()){
            String temp=kataSatu;
            kataSatu=kataDua;
            kataDua=temp;
        }
        
        int LCSSuffix=suffix(kataSatu,kataDua);
        int LCSPrefix=prefix(kataSatu,kataDua);
        
        if(LCSSuffix<LCSPrefix){
            return LCSPrefix;
        }else{
            return LCSSuffix;
        }
        
        
        
        
    }
    
    
    private static int prefix(String kataSatu,String kataDua){//dipastikan dahulu 2 yang lebih pendek
        int jumlahKarakter=0;
        for (int i=0;i<=kataDua.length();i++){ //maks sepanjang yang pendek
            String dua=kataDua.substring(0,i); // panjang dari 0 sampai semua
            for(int j=0;j<=kataSatu.length()-i;j++){
                String satu=kataSatu.substring(j,j+i);
                if(satu.equals(dua)){
                    jumlahKarakter=i;
                    break;
                }
            }   
        } 
       return jumlahKarakter;
    }
    
    private static int suffix(String kataSatu,String kataDua){
        int lenDua=kataDua.length();
        int lenSatu=kataSatu.length();
        int jumlahKarakter=0;
        
        for (int i=lenDua;i>=0;i--){
             String dua=kataDua.substring(i,lenDua);
             for(int j=lenSatu;j>=0;j--){
                 String satu=kataSatu.substring(j,lenSatu);
                 if(satu.equals(dua)){
                    jumlahKarakter=i;
                    break;
                }
             }
        }
        return jumlahKarakter;
    }
    
    

    
    
    
    
}
