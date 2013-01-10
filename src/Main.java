
import Parser.LoginParser;
import java.io.IOException;

/**
 *
 * @author WaiToNZa
 */
public class main {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        LoginParser parser = new LoginParser("b5310545620", "wairungtonas12", "0");
        try {
            parser.login();
        } catch (IOException ex) {
            System.out.println("Connection Failed to login");
        }
    }
}
