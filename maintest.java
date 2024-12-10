import org.junit.Test;
import org.junit.Assert;
import java.security.NoSuchAlgorithmException;

public class maintest {

    @Test
    public void testHashString() throws NoSuchAlgorithmException {
        String input = "HelloWorld";
        String expectedHash = "XCYSTKx8K4zZ5b1UQf8K5dL4puhXvZJkh1MGjTsDDK8="; // Expected Base64 hash of input

        String actualHash = main.hashString(input, HashAlgorithm.SHA256);
        Assert.assertEquals(expectedHash, actualHash);
    }

    @Test
    public void testVerifyHash() throws NoSuchAlgorithmException {
        String input = "HelloWorld";
        String hashedValue = main.hashString(input, HashAlgorithm.SHA256);

        boolean isVerified = main.verifyHash(input, hashedValue, HashAlgorithm.SHA256);
        Assert.assertTrue(isVerified);
    }

    @Test
    public void testGenerateSaltedHash() throws NoSuchAlgorithmException {
        String input = "HelloWorld";
        String salt = "RandomSalt";
        String expectedSaltedHash = "pCM4goqHYNdkI/Gt/tz8w0+VEtgRif6lbzLst1I77I="; // Expected hash with salt

        String actualSaltedHash = main.generateSaltedHash(input, salt, HashAlgorithm.SHA256);
        Assert.assertEquals(expectedSaltedHash, actualSaltedHash);
    }

    @Test
    public void testVerifySaltedHash() throws NoSuchAlgorithmException {
        String input = "HelloWorld";
        String salt = "RandomSalt";
        String saltedHash = main.generateSaltedHash(input, salt, HashAlgorithm.SHA256);
        
        boolean isVerified = main.verifyHash(input + salt, saltedHash, HashAlgorithm.SHA256);
        Assert.assertTrue(isVerified);
    }

    @Test
    public void testVerifyHashWithDifferentInput() throws NoSuchAlgorithmException {
        String input1 = "HelloWorld";
        String input2 = "GoodbyeWorld";
        String hashedValue = main.hashString(input1, HashAlgorithm.SHA256);

        boolean isVerified = main.verifyHash(input2, hashedValue, HashAlgorithm.SHA256);
        Assert.assertFalse(isVerified);
    }
}