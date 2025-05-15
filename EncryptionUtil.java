import java.util.Scanner;

public class EncryptionUtil {
    private static final String ENCRYPTION_KEY = "ijklmnop";

    public static String encrypt(String original) {

        StringBuilder encrypted = new StringBuilder();
        for (int i = 0; i < original.length(); i++) {
            encrypted.append
            			((char) (original.charAt(i) 
            						^ ENCRYPTION_KEY.charAt
            							(i % ENCRYPTION_KEY.length())));
        }
        return encrypted.toString();
    }


    public static void main(String[] args) {
    	Scanner scanner = new Scanner(System.in);
        System.out.print("Enter password : ");
        String password = scanner.nextLine();
        String encrypted = encrypt(password);
        System.out.println("Copy the encrypted password from below.");
        System.out.println(encrypted);
    }
}
