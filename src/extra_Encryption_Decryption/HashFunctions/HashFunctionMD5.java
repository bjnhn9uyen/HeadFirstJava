package extra_Encryption_Decryption.HashFunctions;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Scanner;

public class HashFunctionMD5 {

    private static byte[] hashToArray(String str) throws NoSuchAlgorithmException {
        // message digests are secure one-way hash functions (one-way means cannot decrypt)
        // MD5 is a message digest algorithm and it produces a hash value in decimal format
        MessageDigest md5 = MessageDigest.getInstance("MD5");
        md5.update(str.getBytes());
        byte[] hashArr = md5.digest();
        return hashArr;
    }

    private static BigInteger hashToBigInteger(String str) throws NoSuchAlgorithmException {
        MessageDigest md5 = MessageDigest.getInstance("MD5");
        md5.update(str.getBytes());
        byte[] hashArr = md5.digest();
        BigInteger hashbigInt = new BigInteger(hashArr);
        return hashbigInt;
    }

    // you better convert the hash to the hexadecimal format for more secure
    // producing a mix of letters, numbers (base 16) is more safer than only numbers (base 10)
    private static String hashToHexString(String str) throws NoSuchAlgorithmException {
        MessageDigest md5 = MessageDigest.getInstance("MD5");
        md5.update(str.getBytes());
        byte[] hashArr = md5.digest();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < hashArr.length; i++) {
            // assign 8 bits element ‘hashArr[i]’ in the lowest 8 bits integer for converting it to hex value
            int lowestInt = hashArr[i] & 0xff; // ‘&’ operator is used for adding bitwise numbers in Java
            String tempStr = Integer.toString(lowestInt + 0x100, 16); // hexadecimal base 16
            // every converted hexadecimal string starts with number 1
            // remove the first character (number ‘1’) to make our string more messy, more secure
            tempStr = tempStr.substring(1); // take from index 1 to the end of the string
            sb.append(tempStr);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.print("enter a string to hash: ");
        Scanner scanner = new Scanner(System.in);
        String inputStr = scanner.nextLine();
        scanner.close();
        try {
            byte[] hashArr = hashToArray(inputStr);
            System.out.println("\n‘" + inputStr + "’ is hashed to a byte array: " + Arrays.toString(hashArr));

            BigInteger hashbigInt = hashToBigInteger(inputStr);
            System.out.println("\n‘" + inputStr + "’ is hashed to a BigInteger: " + hashbigInt.toString());

            String hashHexString = hashToHexString(inputStr);
            System.out.println("\n‘" + inputStr + "’ is hashed to a hexadecimal string: " + hashHexString);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }

}
