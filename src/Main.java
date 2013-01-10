import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scn = new Scanner(System.in);
        System.out.println("Please enter your student ID");
        Connection.Response response = Jsoup.connect("https://login8.ku.ac.th/v2/").method(Connection.Method.GET).execute();
        Document document = response.parse();
        Element captcha = document.getElementsByTag("img").get(0);
        String captchaHash = captcha.attr("src").toString().substring(13, 13+32);
        System.out.println(captchaHash);
    }
}
