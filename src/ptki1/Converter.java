/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ptki1;

/**
 *
 * @author Kurni
 */
public class Converter {
    public static int toNumber(char x){
        if(x==' '){
            return 26;
        }else {
            int hasil = (int) x;
            hasil -= 65;
            return hasil;
        }
    }
    
    public static char toChar(int a){
        a=a+65;
        return (char)a;
    }
    
}
