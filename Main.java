package FinalProject;

/**
 *
 * @author Nayatama
 */

public class Main {
    public static void main(String[] args) {
        
        String filepath = "sasageyo.wav";
        
        Music musicObject = new Music();
        musicObject.playMusic(filepath);
        LoginPage.runLoginPage();        
    }
}
