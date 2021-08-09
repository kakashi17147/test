package cryptography;

public class Main 
{
    
    public static void main(String[] args) 
    {
        String original = "This is a long sentence. It stores important information.";
        String secured, regained;
        String key = KeyManager.generateKey("Birthday 2019");
        secured = Encryptor.encrypt(original, key);
        regained = Decryptor.decrypt(secured, key);
        System.out.println("Original: " + original);
        System.out.println("Secured: " + secured);
        System.out.println("Regained: " + regained);
    }
    
}
