import java.security.NoSuchAlgorithmException;

import org.junit.*;

public class HashUtilTest {

    @Test
    void testHashString() throws NoSuchAlgorithmException {
        String input = "HelloWorld";
        String expectedHash = "C3MvmDD4eOBgpkOYAZ68FuChxeZZ9BAPYX4mrD9Ierog="; // Replace this with the actual expected hash output using your implementation

        String actualHash = main.hashString(input, HashAlgorithm.SHA256);
        assertEquals(expectedHash, actualHash);
    }

    @Test
    void testVerifyHash() throws NoSuchAlgorithmException {
        String input = "HelloWorld";
        String hashedValue = main.hashString(input, HashAlgorithm.SHA256);

        assertTrue(main.verifyHash(input, hashedValue, HashAlgorithm.SHA256));
        assertFalse(main.verifyHash("WrongInput", hashedValue, HashAlgorithm.SHA256));
    }

    @Test
    void testHashMD5() throws NoSuchAlgorithmException {
        String input = "HelloWorld";
        String expectedMD5Hash = "XrY7h5+G1Eeat7L1hDjbOQ=="; // Replace this with the actual expected MD5 hash output with your implementation

        String actualMD5Hash = main.hashString(input, HashAlgorithm.MD5);
        assertEquals(expectedMD5Hash, actualMD5Hash);
    }

    @Test
    void testHashSHA1() throws NoSuchAlgorithmException {
        String input = "HelloWorld";
        String expectedSHA1Hash = "Z29uZyB0byBpdGVyZXN0ZWQgdGhlIFJUSTUw"; // Replace this with the actual expected SHA1 hash output

        String actualSHA1Hash = main.hashString(input, HashAlgorithm.SHA1);
        assertEquals(expectedSHA1Hash, actualSHA1Hash);
    }
}