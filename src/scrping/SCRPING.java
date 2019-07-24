/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scrping;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 *
 * @author Dhia Ben Slimen
 */
public class SCRPING {

    public static void main(String[] args) {
            String nomProduct ; 
            String prixproduct ; 
            
        try {
            // TODO code application logic here
            Document    doc = Jsoup.connect("https://www.jumia.com.tn/iphone/").get();
           Elements e1 =  doc.getElementsByClass("products") ;
           Elements t = e1.select(".sku");
           
           
           for (int i = 0; i<t.size();i++)
           {
           nomProduct = t.select("a .title .name").get(i).text();
            System.out.println("prix de  " +nomProduct);
           prixproduct = t.select("a .price-container .price-box .price").get(i).text();
            System.out.println("prix de cette produit  " +prixproduct);
            System.out.println("\n--------------\n");
           }
               } catch (IOException ex) {
            Logger.getLogger(SCRPING.class.getName()).log(Level.SEVERE, null, ex);
        }
    
}
}
