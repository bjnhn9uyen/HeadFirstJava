package extra_Encryption_Decryption.SecretKey;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Scanner;

import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;

public class SecretKeyDESFactory {

    private static SecretKey secretKeyGen(String rawKey) throws Exception {
        // using key factory with DES algorithm
        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
        DESKeySpec desKeySpec = new DESKeySpec(rawKey.getBytes()); // convert to DES key format
        SecretKey secretKey = keyFactory.generateSecret(desKeySpec);
        return secretKey;
    }

    private static void doIt(File sourceFile, File targetFile, SecretKey secretKey, int cipherMode) throws
        Exception {
        // if you don’t know which specified algorithm was used to generate the secret key,
        // you can use ‘DES/ECB/PKCS5Padding’ algorithm as method argument
        // if you know exactly that the ‘DES’ algorithm was used to generate the secret key,
        // use ‘DES’ as method argument instead of ‘DES/ECB/PKCS5Padding’
        Cipher cipher = Cipher.getInstance("DES/ECB/PKCS5Padding");
        cipher.init(cipherMode, secretKey);

        FileInputStream bis = new FileInputStream(sourceFile);
        CipherInputStream cis = new CipherInputStream(bis, cipher);
        FileOutputStream fos = new FileOutputStream(targetFile);
        int i;
        do {
            i = cis.read();
            if (i != -1) {
                fos.write(i);
            }
        } while (i > 0);
        cis.close();
        fos.close();
    }

    private static void encryptFile(SecretKey secretKey, String fileLocation) throws Exception {
        File soucrceFile = new File(fileLocation + "/OriginalText.txt");
        File targetFile = new File(fileLocation + "/EncryptedText_DESFactory.txt");
        doIt(soucrceFile, targetFile, secretKey, Cipher.ENCRYPT_MODE);
    }

    private static void decryptFile(SecretKey secretKey, String fileLocation) throws Exception {
        File soucrceFile = new File(fileLocation + "/EncryptedText_DESFactory.txt");
        File targetFile = new File(fileLocation + "/DecryptedText_DESFactory.txt");
        doIt(soucrceFile, targetFile, secretKey, Cipher.DECRYPT_MODE);
    }

    public static void main(String[] args) {
        String fileLocation = "src/" + SecretKeyPBEFactory.class.getPackage().getName().replace(".", "/");
        Scanner scanner = new Scanner(System.in);
        // secret key's size must be 8 bytes or higher for converting to DES key format
        // an ISO-8895-1 characters in ISO-8859-1 encoding is 8 bits (1 byte)
        // a Unicode character in UTF-8 encoding is between 8 bits (1 byte) and 32 bits (4 bytes)
        // a Unicode character in UTF-16 encoding is between 16 (2 bytes) and 32 bits (4 bytes)
        try {
            System.out.print("enter password to encrypt the file: ");
            String password = scanner.nextLine();
            SecretKey secretKey = secretKeyGen(password);
            encryptFile(secretKey, fileLocation);
            System.out.println("file encrypted successfully!");

            System.out.print("enter password you've used for encryption to decrypt the file: ");
            password = scanner.nextLine();
            secretKey = secretKeyGen(password);
            decryptFile(secretKey, fileLocation);
            System.out.println("file decrypted successfully!");
        } catch (Exception e) {
            e.printStackTrace();
        }
        scanner.close();
    }

}
