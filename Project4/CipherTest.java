/**
 * Program to test Cipher
 * @author Jessica Fang
 */
public class CipherTest {

  public static void main(String[] args) {


    String encode = Cipher.encodeLine("Hello");
    System.out.println("Expected: Xueea \t Actual: " + encode);

    String encode1 = Cipher.encodeLine("ABCDEFGHIJKLM");
    System.out.println("Expected: CKDLURMXNWVEH \t Actual: " + encode1);

    String encode2 = Cipher.encodeLine("NOPQRSTUVWXYZ");
    System.out.println("Expected: BAYOIFGQZJSTP \t Actual: " + encode2);

    String encode3 = Cipher.encodeLine("zyxwvutsrqpon");
    System.out.println("Expected: ptsjzqgfioyab \t Actual: " + encode3);

    String encode4 = Cipher.encodeLine("mlkjihgfedcba");
    System.out.println("Expected: hevwnxmruldkc \t Actual: " + encode4);

    String encode5 = Cipher.encodeLine("the quick brown fox jumps over the lazy dog.");
    System.out.println("Expected: gxu oqndv kiajb ras wqhyf azui gxu ecpt lam. \t Actual: " + encode5);


    String decode = Cipher.decodeLine("Xueea");
    System.out.println("Expected: Hello \t Actual: " + decode);

    String decode1 = Cipher.decodeLine("hevwnxmruldkc");
    System.out.println("Expected: mlkjihgfedcba \t Actual: " + decode1);

    String decode2 = Cipher.decodeLine("ptsjzqgfioyab");
    System.out.println("Expected: zyxwvutsrqpon \t Actual: " + decode2);

    String decode3 = Cipher.decodeLine("BAYOIFGQZJSTP");
    System.out.println("Expected: NOPQRSTUVWXYZ \t Actual: " + decode3);

    String decode4 = Cipher.decodeLine("CKDLURMXNWVEH");
    System.out.println("Expected: ABCDEFGHIJKLM \t Actual: " + decode4);

    String decode5 = Cipher.decodeLine("GXU OQNDV KIAJB RAS WQHYF AZUI GXU ECPT LAM.");
    System.out.println("Expected: THE QUICK BROWN FOX JUMPS OVER THE LAZY DOG. \t Actual: " + decode5);
  }
}

