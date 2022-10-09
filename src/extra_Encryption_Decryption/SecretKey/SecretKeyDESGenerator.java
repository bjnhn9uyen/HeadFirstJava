package extra_Encryption_Decryption.SecretKey;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Base64;
import java.util.Scanner;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

public class SecretKeyDESGenerator {

    private static void secretKeyGenerateAndSave(File fileSecretKey) throws Exception {
        // using key generator with DES algorithm
        SecretKey secretKey = KeyGenerator.getInstance("DES").generateKey();
        FileOutputStream fos = new FileOutputStream(fileSecretKey);
        fos.write(secretKey.getEncoded());
        fos.close();
    }

    private static String doIt(File fileSecretKey, String str, int cipherMode) throws Exception {
        // create secret key from the saved file
        FileInputStream fis = new FileInputStream(fileSecretKey);
        byte[] byteArr = new byte[fis.available()]; // new empty byte array with length ‘fis.available()’
        fis.read(byteArr); // read from this input stream into a byte array
        fis.close();

        // construct a secret key from the given byte array and a specified algorithm
        SecretKey secretKey = new SecretKeySpec(byteArr, "DES");
        // decrypt data using secret key
        Cipher cipher = Cipher.getInstance("DES");

        if (cipherMode == Cipher.ENCRYPT_MODE) {
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);
            byte[] encryptedArr = cipher.doFinal(str.getBytes()); // encrypt input data
            String encryptedStr = new String(Base64.getEncoder().encode(encryptedArr));
            return encryptedStr;
        }
        if (cipherMode == Cipher.DECRYPT_MODE) {
            cipher.init(Cipher.DECRYPT_MODE, secretKey);
            byte[] decryptedArr = cipher.doFinal(Base64.getDecoder().decode(str)); // decrypt input data
            String decryptedStr = new String(decryptedArr);
            return decryptedStr;
        }
        return "";
    }

    private static String encryptMessage(String inputStr, File fileSecretKey) throws Exception {
        return doIt(fileSecretKey, inputStr, Cipher.ENCRYPT_MODE);

    }

    private static String decryptMessage(String encryptedStr, File fileSecretKey) throws Exception {
        return doIt(fileSecretKey, encryptedStr, Cipher.DECRYPT_MODE);
    }

    public static void main(String[] args) {
        String path = "src/" + SecretKeyDESGenerator.class.getPackage().getName().replace(".", "/");
        File fileSecretKey = new File(path + "/SecretKey.bin");
        System.out.print("enter a string for encryption: ");
        Scanner scanner = new Scanner(System.in);
        String inputStr = scanner.nextLine();
        scanner.close();
        try {
            secretKeyGenerateAndSave(fileSecretKey);
            System.out.println("\nsecret key generated and saved successfully!");

            String encryptedStr = encryptMessage(inputStr, fileSecretKey);
            System.out.println("\n‘" + inputStr + "’ after encrypted: " + encryptedStr);

            String encryptedInt = decryptMessage(encryptedStr, fileSecretKey);
            System.out.println("\nafter decrypted: " + encryptedInt);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
