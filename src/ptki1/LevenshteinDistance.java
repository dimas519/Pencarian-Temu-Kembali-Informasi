/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ptki1;

/**
 *
 * @author Kurni
 */
public class LevenshteinDistance {

    /**
     * 
     * @param kataSatu
     * @param kataDua
     * @return
     * @deprecated "need fixed, bug if kataSatu.length()!=kataDua.length()"
     */
    @Deprecated 
    public static int counter(String kataSatu,String kataDua){
        
        kataSatu="-"+kataSatu;
        kataDua="-"+kataDua;
        int baris,kolom;
        String kataAtas,kataSamping;
        if(kataSatu.length() <= kataDua.length()){
            baris=kataSatu.length();
            kolom=kataDua.length();
            kataAtas=kataSatu;
            kataSamping=kataDua;
            
            
        }else{
            baris=kataDua.length();
            kolom=kataSatu.length();
            kataAtas=kataDua;
            kataSamping=kataSatu;
            
        }
        
        
        
        
        
        
        int arr[][]=new int[baris][kolom];
        
        
        
        //bikin  Atas dulu
        for (int i=0;i<kolom;i++){
            arr[0][i]=i;
        }
        
        //bikin  samping kiri
        for (int i=0;i<baris;i++){
            arr[i][0]=i;
        }
        
        
        for(int i=1;i<baris;i++){
            char currAtas=kataAtas.charAt(i);
            for (int k=1;k<kolom;k++){
                
                int terkecil=Math.min(Math.min(arr[i][k-1], arr[i-1][k]),arr[i-1][k-1]);
                
                char currSamping=kataSamping.charAt(k);
                if(currAtas==currSamping && i==k){
                    
                }else{
                    terkecil++;
                }
                
                arr[i][k]=terkecil;
            }
        }
        
        System.out.println();
        System.out.println(kataAtas+" "+baris);
        System.out.println(kataSamping+" "+kolom);
        for(int i=0;i<baris;i++){
            for (int k=0;k<kolom;k++){
                System.out.print(arr[i][k]);
            }
            System.out.println();
        }
        
        
        
        
        return arr[baris-1][kolom-1];
        
    }
}
