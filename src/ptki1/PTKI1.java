/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ptki1;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;


/**
 *
 * @author Kurni
 */




public class PTKI1 {
    



    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String path="C:\\Users\\Kurni\\Documents\\NetBeansProjects\\PTKI1\\src\\ptki1\\bbc";

        

 
        //TOKENIZING CORPUS
        InputOutput IO=new InputOutput();
        LinkedList<File> filePath=IO.getAllDoc(path);
        ArrayList<Vector> corpusTokenized=new ArrayList<>();
        
        
        
        
        //SIMPAN SEMUA VECTOR CORPUS
        for(File currFile:filePath){
            String kalimat=IO.process(currFile);
            buildVectorWeightWithTrie wcDoc=new WordCount();
            ArrayList <VectorWeight> processedDoc=wcDoc.getVectorWeightWithTrie(kalimat); 
            Vector document=new Vector(currFile.toString(),processedDoc);
            corpusTokenized.add(document);
        }
        
        
        //Hitung TF IDF untuk corpus
        TFIDFWeighting TFIDF =new TFIDFWeighting();
        ArrayList<Vector> TFxIDF=TFIDF.createTFIDFVector(corpusTokenized);
        
        
        for (VectorWeight  y: TFxIDF.get(0).getVectorWeight()){
            //System.out.println(y.getKata()+" "+y.getBobot());
        }
        
        
        //buat inverted Index corpusnya
        InvertedIndex ii=new InvertedIndex(TFxIDF);
        
        HashMap<String, Integer> kataUnik = ii.getUniqueKata(); // untuk vector Expansion
         System.out.println(kataUnik.size());
         
            //loop terus selama ada query baru
       while (sc.hasNextLine()){

           String query=sc.nextLine();
           
           int jumlahDokumenTerbaik=Integer.parseInt(sc.nextLine());
           
           //TOKENIZING TERHADAP QUERY
            buildVectorWeightWithTrie wcQuery=new WordCount();
            ArrayList<VectorWeight> processedQuery=wcQuery.getVectorWeightWithTrie(query);
            Vector queryVector=new Vector("Query",processedQuery);
           

            Vector vectorExpanded=VectorExpansion.expandWithLCS(kataUnik, queryVector);
           
            
           //cari similaritynya dengan invertedIndex
           Akumulator akumulator =ii.countAkumulator(vectorExpanded);

           SelectNBest selector=new SelectNBest(jumlahDokumenTerbaik);
           AkumulatorList result[]=selector.process(akumulator.getList());

           
           
           for(AkumulatorList curr:result){
               System.out.println(curr.getJudul()+" "+curr.getBobot());
           }
          

       }
        
        
        
    }

}


