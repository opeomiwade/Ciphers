/**abstract class substitution which contains concrete implementation of
 * the encrypt and decrpt string methods from the cipher interface.
 * also contains two abstact classes.
 * @author Opeoluwa Omiwade.
 * @version 1.0
 */
public abstract class Substitution implements Cipher{

/**abstract classe which is overidden by the subclasses
 * @param c which is the character being encrypted by the various ciphers.
 * @return c encrypted char
 */
    public abstract char encrypt(char c);
/**abstract classe which is overidden by the subclasses
 * @param c which is the character being encrypted by the various ciphers.
 * @return c decrypted char.
 */
    public abstract char decrypt(char c);

/**declaration of public integer.
 */
    protected int pos;//variable that can only be accesed by the subclasses.

/**encrypt string method which encrypts the whole string inputted, by calling the encrypt char method
 * multiple times in the loop.
 *@param plainText which is the sting being encrypted.
 * @return encryptedText.
 */
    public String encrypt(String plainText){
        int i=0;
        int plainTextLength=plainText.length();
        StringBuilder encryptedText=new StringBuilder("");
        for(i=0;i<=plainTextLength-1;i++){
            pos=i;
            char c=plainText.charAt(i);
            char encryptedChar=encrypt(c);
            encryptedText.append(encryptedChar);
        }
         return encryptedText.toString();
    }

/**decrypt string method which decrypts the whole string inputted , by calling the decrypt char method
 * multiple times in the loop.
 * @param cipherText which is the text being deciphered.
 * @return decryptedText.
 */
    public String decrypt (String cipherText){
        int i=0;
        int cipherTextLength=cipherText.length();
        StringBuilder decryptedText=new StringBuilder("");
        for(i=0;i<=cipherTextLength-1;i++){
            pos=i;
            char c=cipherText.charAt(i);
            char decryptedChar=decrypt(c);
            decryptedText.append(decryptedChar);
        }
        return decryptedText.toString();
    }

}