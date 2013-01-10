/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Parser;

import java.io.IOException;
import java.util.Random;
import org.jsoup.Connection;
import org.jsoup.Connection.Method;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

/**
 *
 * @author WaiToNZa
 */
public class LoginParser {
    private Connection.Response res;
    private String hash;
    private String username;
    private String password;
    private String zone;
    private int serv_no;
    
    public LoginParser(String username, String password, String zone) {
        this.username = username;
        this.password = password;
        this.zone = zone;
        Random rand = new Random();
        this.serv_no = rand.nextInt(13);
    }
    
    public boolean login() throws IOException {
        res = Jsoup.connect("https://login"+ this.serv_no +".ku.ac.th/v2/")
                .method(Connection.Method.GET)
                .timeout(10*1000).execute();
        Document doc = res.parse();
        hash = doc.getElementsByTag("img").get(0).attr("src").substring(13, 13+32);
            
        res = Jsoup.connect("https://login"+ this.serv_no +".ku.ac.th/v2/?action=login")
                    .method(Connection.Method.POST)
                    .data("hash", this.hash, 
                    "username", this.username, 
                    "password" , this.password,
                    "zone", this.zone, 
                    "targetip4", "", 
                    "targetip6", "", 
                    "answer0", "0", "answer1", "1", "answer2", "2", "answer3", "3", "answer4", "4", 
                    "answer5", "5", "answer6", "6", "answer7", "7", "answer8", "8", "answer9", "9", 
                    "answer10", "10", "answer11", "11", "answer12", "12", "answer13", "13", "answer14", "14", 
                    "answer15", "15", "answer16", "16", "answer17", "17", "answer18", "18", "answer19", "19", 
                    "answer20", "20", "answer21", "21", "answer22", "22", "answer23", "23", "answer24", "24", 
                    "answer25", "25", "answer26", "26", "answer27", "27", "answer28", "28", "answer29", "29", 
                    "answer30", "30", "answer31", "31", "answer32", "32", "answer33", "33", "answer34", "34", 
                    "answer35", "35", "answer36", "36", "answer37", "37", "answer38", "38", "answer39", "39", 
                    "answer40", "40", "answer41", "41", "answer42", "42", "answer43", "43", "answer44", "44", 
                    "answer45", "45", "answer46", "46", "answer47", "47", "answer48", "48", "answer49", "49", 
                    "answer50", "50", "answer51", "51", "answer52", "52", "answer53", "53", "answer54", "54", 
                    "answer55", "55", "answer56", "56", "answer57", "57", "answer58", "58", "answer59", "59", 
                    "answer60", "60", "answer61", "61", "answer62", "62", "answer63", "63", "answer64", "64", 
                    "answer65", "65", "answer66", "66", "answer67", "67", "answer68", "68", "answer69", "69", 
                    "answer70", "70", "answer71", "71", "answer72", "72", "answer73", "73", "answer74", "74", 
                    "answer75", "75", "answer76", "76", "answer77", "77", "answer78", "78", "answer79", "79", 
                    "answer80", "80", "answer81", "81", "answer82", "82", "answer83", "83", "answer84", "84", 
                    "answer85", "85", "answer86", "86", "answer87", "87", "answer88", "88", "answer89", "89", 
                    "answer90", "90", "answer91", "91", "answer92", "92", "answer93", "93", "answer94", "94", 
                    "answer95", "95", "answer96", "96", "answer97", "97", "answer98", "98", "answer99", "99")
                    .timeout(10*1000).execute();
        doc = res.parse();
        Elements check_e = doc.getElementsByTag("img");
        if (!check_e.isEmpty()) {
            return false;
        }
        return true;
    }
    
    public void logout() throws IOException {
        Jsoup.connect("https://login"+ this.serv_no +".ku.ac.th/v2/?action=Logout+this+IP")
             .method(Method.GET).execute().parse();
                
    }
    
    public String getUserBandwidthHTML() throws IOException {
        Document doc = Jsoup.connect("https://login"+ this.serv_no +".ku.ac.th/v2/keepalive.php")
             .method(Method.GET).execute().parse();
        return doc.toString();
    }
}
