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

    /**
     * Function to return a Boolean indicating whether a given string matches a given
hash with a given algorithm.
     *
     * @param input     The input to check
     * @param hashedValue The hashed to compare
     * @param algorithm   The hashed use
     * @return True if the input matches false if not
     * @throws NoSuchAlgorithmException error
     */
    public static boolean verifyHash(String input, String hashedValue, HashAlgorithm algorithm) throws NoSuchAlgorithmException {
        String computedHash = hashString(input, algorithm);
        return computedHash.equals(hashedValue);
    }

    /**
     * generate a salted hash of a given string input, string salt, and enumerated hashing algorithm.
     *
     * @param input     The input hash.
     * @param salt      The salt to append
     * @param algorithm The hashing algorithm
     * @return The salted hash as a Base64-encoded 
     * @throws NoSuchAlgorithmException Error
     */
    public static String generateSaltedHash(String input, String salt, HashAlgorithm algorithm) throws NoSuchAlgorithmException {
        String saltedInput = input + salt;
        return hashString(saltedInput, algorithm);
    }

    public static void main(String[] args) {
        try {
            
            String input = "HelloWorld";
            String salt = "RandomSalt";

            // Hash 
            String hashedValue = hashString(input, HashAlgorithm.SHA256);
            System.out.println("Hashed Value (SHA-256): " + hashedValue);

            // Verify the hash
            boolean isVerified = verifyHash(input, hashedValue, HashAlgorithm.SHA256);
            System.out.println("Verification Result: " + isVerified);

            // Generate salted hash
            String saltedHash = generateSaltedHash(input, salt, HashAlgorithm.SHA256);
            System.out.println("Salted Hash (SHA-256): " + saltedHash);

            
        } catch (NoSuchAlgorithmException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
