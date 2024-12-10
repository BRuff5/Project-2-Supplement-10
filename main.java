import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

/**
 * Hashed algorithms.
 */
enum HashAlgorithm {
    MD5, SHA1, SHA256
}

public class main {

    /**
     * Function to hash a given string given an enumerated hash algorithm.
     *
     * @param input   The string 
     * @param algorithm The hashing algorithm (MD5, SHA-1, or SHA-256)
     * @return value as a Base64-encoded 
     * @throws NoSuchAlgorithmException error
     */
    public static String hashString(String input, HashAlgorithm algorithm) throws NoSuchAlgorithmException {
        MessageDigest messageDigest = MessageDigest.getInstance(algorithm.name().replace("SHA", "SHA-"));
        byte[] hashBytes = messageDigest.digest(input.getBytes());
        return Base64.getEncoder().encodeToString(hashBytes);
    }

    

    public static void main(String[] args) {
        try {
            
            String input = "HelloWorld";

            // Hash the string
            String hashedValue = hashString(input, HashAlgorithm.SHA256);
            System.out.println("Hashed Value (SHA-256): " + hashedValue);

            
        } catch (NoSuchAlgorithmException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
