import java.security.NoSuchAlgorithmException;

import org.junit.*;

public class mainTest {

    @Test
    public void testHashStringSHA256() throws NoSuchAlgorithmException {
        String input = "HelloWorld";
        String expectedHash = "wQNLnrAO+3xqKZa3TqZz2ZULtwDJ9KmUtDzV0H3yXK8="; // Precomputed SHA-256 hash
        String actualHash = main.hashString(input, HashAlgorithm.SHA256);
        
        assertEquals(expectedHash, actualHash);
    }

    @Test
    public void testHashStringSHA1() throws NoSuchAlgorithmException {
        String input = "HelloWorld";
        String expectedHash = "w6v7UUI6Vjh1YIJpmoWIMuN2lK8="; // Precomputed SHA-1 hash
        String actualHash = main.hashString(input, HashAlgorithm.SHA1);
        
        assertEquals(expectedHash, actualHash);
    }

    @Test
    public void testHashStringMD5() throws NoSuchAlgorithmException {
        String input = "HelloWorld";
        String expectedHash = "HW9NJ4iVZ3kzw+ifS4gGPg=="; // Precomputed MD5 hash
        String actualHash = main.hashString(input, HashAlgorithm.MD5);
        
        assertEquals(expectedHash, actualHash);
    }

    @Test
    public void testHashStringNullInput() {
        try {
            main.hashString(null, HashAlgorithm.SHA256);
        } catch (IllegalArgumentException e) {
            assertEquals("input cannot be null", e.getMessage());
        } 
    }
}