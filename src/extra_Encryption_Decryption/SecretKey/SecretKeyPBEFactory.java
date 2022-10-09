package extra_Encryption_Decryption.SecretKey;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.PBEParameterSpec;

public class SecretKeyPBEFactory {

    private static SecretKey secretKeyGen(String rawPassword)
        throws Exception {
        // using key factory with 'PBEWithMD5AndTripleDES' algorithm
        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("PBEWithMD5AndDES");
        PBEKeySpec pbeKeySpec = new PBEKeySpec(rawPassword.toCharArray()); // convert to PBE key format
        SecretKey secretKey = keyFactory.generateSecret(pbeKeySpec); // generate a secret key
        return secretKey;
    }

    private static byte[] saltGen() {
        byte[] salt = null;
        try {
            // 'SHA1PRNG' is a random number generator algorithm
            SecureRandom sr = SecureRandom.getInstance("SHA1PRNG");
            salt = new byte[8];
            sr.nextBytes(salt); // read this secure random number into an array of bytes (salt)
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(SecretKeyPBEFactory.class.getName()).log(Level.SEVERE, null, ex);
        }
        return salt;
    }

    private static void doIt(File soucrceFile, File targetFile, SecretKey secretKey, byte[] salt,
                             int cipherMode) throws Exception {
        // FileOutputStream creates a new file if the file doesn’t exist, but FileInputStream cannot
        FileInputStream fis = new FileInputStream(soucrceFile);
        byte[] inputArr = new byte[fis.available()]; // new empty byte array with length ‘fis.available()’
        fis.read(inputArr); // read from this input stream into a byte array
        fis.close();

        // create PBEParameterSpec to store salt in PBE key format
        PBEParameterSpec pbeParamSpec = new PBEParameterSpec(salt, 100); // 100 is iteration count

        // Cipher needs to use the same SecretKey and PBEParameterSpec in both encryption and decryption
        Cipher cipher = Cipher.getInstance("PBEWithMD5AndDES");
        cipher.init(cipherMode, secretKey, pbeParamSpec);
        byte[] encryptedOrDecryptedArr = cipher.doFinal(inputArr);
        // if the file doesn’t exist, it will be created automatically
        FileOutputStream fos = new FileOutputStream(targetFile);
        fos.write(encryptedOrDecryptedArr);
        fos.close();
    }

    private static void encryptFile(SecretKey secretKey, byte[] salt, String fileLocation) throws Exception {
        File soucrceFile = new File(fileLocation + "/OriginalText.txt");
        File targetFile = new File(fileLocation + "/EncryptedText_PBEFactory.txt");
        doIt(soucrceFile, targetFile, secretKey, salt, Cipher.ENCRYPT_MODE);
    }

    private static void decryptFile(SecretKey secretKey, byte[] salt, String fileLocation) throws Exception {
        File soucrceFile = new File(fileLocation + "/EncryptedText_PBEFactory.txt");
        File targetFile = new File(fileLocation + "/DecryptedText_PBEFactory.txt");
        doIt(soucrceFile, targetFile, secretKey, salt, Cipher.DECRYPT_MODE);
    }

    public static void main(String[] args) {
        String fileLocation = "src/" + SecretKeyPBEFactory.class.getPackage().getName().replace(".", "/");
        Scanner scanner = new Scanner(System.in);
        try {
            byte[] salt = saltGen();

            System.out.print("enter password to encrypt the file: ");
            String password = scanner.nextLine();
            SecretKey secretKey = secretKeyGen(password);
            encryptFile(secretKey, salt, fileLocation);
            System.out.println("file encrypted successfully!");

            System.out.print("enter password you’ve used for encryption to decrypt the file: ");
            password = scanner.nextLine();
            secretKey = secretKeyGen(password);
            decryptFile(secretKey, salt, fileLocation);
            System.out.println("file decrypted successfully!");
        } catch (Exception e) {
            e.printStackTrace();
        }
        scanner.close();
    }

}
