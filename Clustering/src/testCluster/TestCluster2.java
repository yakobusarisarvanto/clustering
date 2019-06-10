/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testCluster;

import java.util.ArrayList;
import model.Document;
import model.InvertedIndex;
import model.Posting;

/**
 *
 * @author admin
 */
public class TestCluster2 {

    public static void main(String[] args) {
        // seting dokumen
        Document doc1 = new Document(1, "Fahri Hamzah Usul Ibu Kota Pindah ke Kepulauan Seribu");
        Document doc2 = new Document(2, "Gaya Nyentrik Menteri Susi Saat Pimpin Penenggelaman 13 Kapal Vietnam di Kalbar");
        Document doc3 = new Document(3, "TNI AL: KRI Tjiptadi-381 Diprovokasi Kapal Pengawas Ikan Vietnam ");
        Document doc4 = new Document(4, "TNI AL: KRI Tjiptadi-381 Diprovokasi Kapal Pengawas Ikan Vietnam ");

        // buat object invertedIndex
        InvertedIndex index = new InvertedIndex();
        // lakukan stemming untuk semua dokumen
        doc1.IndonesiaStemming();
        doc2.IndonesiaStemming();
        doc3.IndonesiaStemming();
        doc4.IndonesiaStemming();
        // tmbahkan document ke index
        index.addNewDocument(doc1);
        index.addNewDocument(doc2);
        index.addNewDocument(doc3);
        index.addNewDocument(doc4);
        // bikin dictionary
        index.makeDictionaryWithTermNumber();
        // bikin preclustering
        index.preClustering();
        index.clustering(3);
//        String[][] tabel = new String[index.getListOfDocument().size()][1];
//        int a = 0;
        for (int i = 0; i < index.getListOfCluster().size(); i++) {
//            tabel[a][0] = "Id Cluster";
//            tabel[a][1] = String.valueOf(index.getListOfCluster().get(i).getIdCluster());
//            a++;
            System.out.println("Id Cluster = " + (index.getListOfCluster().get(i).getIdCluster()+1));
            ArrayList<Document> listDoc = index.getListOfCluster().get(i).getMember();
            for (int j = 0; j < listDoc.size(); j++) {
//                tabel[a][0] = String.valueOf(listDoc.get(j).getId());
//                tabel[a][1] = listDoc.get(j).getTitle();
//                a++;
                System.out.println(listDoc.get(j).getId() + " " + listDoc.get(j).getTitle());
            }

        }

    }
}
