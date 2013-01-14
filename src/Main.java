
import Parser.LoginParser;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 *
 * @author WaiToNZa
 */
public class main {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException, InterruptedException {
        LoginParser parser = new LoginParser("b5310XXXXXX", "password", "0");

        while (true) {
            try {
                Thread.sleep(10000);
                if (InternetChecker.getDefaultInstance().isConnectionPresent()) {
                } else {
                    parser.login();
                }
            } catch (Exception ex) {
                System.out.println("Connection Failed to login");
            }
        }
    }
}
