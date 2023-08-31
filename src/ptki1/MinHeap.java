/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ptki1;

/**
 *
 * @author Kurni
 */
public class MinHeap {

    private AkumulatorList[] heap;
    private int size;
    private int curr;

    public MinHeap(int size) {
        this.size = size;
        this.heap = new AkumulatorList[size + 2];  // 1 mau dibuang diawal untuk speed getleft/right 
        this.curr = 1;
    }

    private int getRight(int curr) {
        return curr << 1;
    }

    private int getLeft(int curr) {
        return getRight(curr) + 1;
    }

    private int getParrent(int curr) {
        return (int) curr >> 1;
    }

    public void insert(AkumulatorList x) {
        if(this.curr<=size){
            this.heap[this.curr]=x;
            insertSort(this.curr);
            this.curr++;
        }else{
            //remove dulu baru add dibelakang
                this.heap[this.curr]=x;
                removeRoot();            
        }
    }

    private void insertSort(int curr) { //loop ke atas saat pengisian
        double currValue=this.heap[curr].getBobot();
        int parrentPos=getParrent(curr);
        if(parrentPos!=0){
            double parrValue=this.heap[parrentPos].getBobot();
            if(currValue<parrValue){
                swap(curr,parrentPos);
                insertSort(parrentPos);
            }
        }
    }
    
    
    private AkumulatorList removeRoot(){
         
         if(this.heap[1].getBobot()<this.heap[this.curr].getBobot()){
            swap(this.curr,1);
            sort(1);
            return this.heap[this.curr];
         }
         return this.heap[1];
    }
    
    private void sort(int curr){
        int left=getLeft(curr);
        int right=getRight(curr);
        double currValue=this.heap[curr].getBobot();
        
        
        if(left <= this.size && right <= this.size){
            
            
            double anakKiriValue=this.heap[left].getBobot();
            double anakKananValue=this.heap[right].getBobot();
            
            
            if(anakKananValue<anakKiriValue){
                if(currValue>=anakKananValue){  
                    swap(curr,right);
                    sort(right);
                }
                
                
            }else if(anakKananValue >= anakKiriValue){
                if(currValue>=anakKiriValue){
                    swap(curr,left);
                    sort(left);
                }
                
                
                
            } 
        } else if(left<=this.size){
            double anakKiri=this.heap[left].getBobot();
            if(currValue>=anakKiri){
                swap(curr,left);
                sort(left);
            }
            
            
            
        } else if(right<=this.size){
            double anakKanan=this.heap[right].getBobot();
            if(currValue>=anakKanan){
                swap(curr,right);
                sort(right);
            }
        }
    }
    
    
    
    
    

    private void swap(int a, int b) {
        AkumulatorList temp = this.heap[a];
        this.heap[a] = this.heap[b];
        this.heap[b] = temp;

    }


    public AkumulatorList[] getHasil(){
        AkumulatorList result[]=new AkumulatorList[this.size];
        for(int i=this.size-1;i>=0;i--){
            this.heap[this.curr]=new AkumulatorList("no-data",2.0);//weight diisi 2 karena akan menjadi leaf, karena bobot cosine terbesar 1, maka dia akan menjadi leaf
            result[i]=removeRoot();
        }
        
        return result;
        
    }

    
}