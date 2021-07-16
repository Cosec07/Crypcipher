package application;

public class VigenereCipher {
	
	
	public String msg(String msg)
	{
		msg = msg.toUpperCase();
		return msg;
	}
	public String key(String key)
	{
		key = key.toUpperCase();
		return key;
	}
	public String map(String k,String msga)
	{
		 String keyMap = "";
	        for (int i = 0, j = 0; i < msga.length(); i++) {
	            if(msga.charAt(i) == (char)32){
	                //ignoring space
	                keyMap += (char)32;

	            } else {
	                //mapping letters of key with message
	                if(j < k.length()){
	                    keyMap += k.charAt(j);
	                    j++;
	                } else {
	                    //restarting the key from beginning once its length is complete
	                    // and its still not mapped to message
	                    j = 0;
	                    keyMap += k.charAt(j);
	                    j++; //without incrementing here, key's first letter will be mapped twice

	                }
	            } //if-else

	        } //for
	       String mappedKey = keyMap;
	       return mappedKey;
	}
	public int[][] createVigenereTable()
	{
		// creating 26x26 table containing alphabets
        int[][] tableArr = new int[26][26];
        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < 26; j++) {
                int temp;
                if((i+65)+j > 90){
                    temp = ((i+65)+j) -26;
                    tableArr[i][j] = temp;
                } else {
                    temp = (i+65)+j;
                    tableArr[i][j] = temp;
                }
            }
        }
        return tableArr;
	}
	public String cipherEncryption(String mappedKey,String msga)
	{
		int[][] table = createVigenereTable();
        String encryptedText = "";
        for (int i = 0; i < msga.length(); i++) {
            if(msga.charAt(i) == (char)32 && mappedKey.charAt(i) == (char)32){
                encryptedText += " ";
            } else {
                //accessing element at table[i][j] position to replace it with letter in message
                encryptedText += (char)table[(int)msga.charAt(i)-65][(int)mappedKey.charAt(i)-65];
            }
        }

      return encryptedText;
	}
	
	public int itrCount(int key,int msgi)
	{
		// this function will return the count which it takes from key's letter to reach cipher letter
        // and then this count will be used to calculate decryption of encrypted letter in message.
        int counter = 0;
        String result = "";
        for (int i = 0; i < 26; i++) {
            if(key+i > 90){
                //90 being ASCII of Z
                result += (char)(key+(i-26));

            } else {
                result += (char)(key+i);
            }
        }

        //counting from key's letter to cipher letter in vigenere table
        for (int i = 0; i < result.length(); i++) {
            if(result.charAt(i) == msgi){
                break; // letter found
            } else {
                counter++;
            }
        }
        return counter;
 
	}
	
	public String cipherDecryption(String mappedKey,String msga)
	{
		int[][] table = createVigenereTable();
        String decryptedText = "";

        for (int i = 0; i < msga.length(); i++) {
            if(msga.charAt(i) == (char)32 && mappedKey.charAt(i) == (char)32){
                decryptedText += " ";
            } else {
                decryptedText += (char)(65 + itrCount((int)mappedKey.charAt(i), (int)msga.charAt(i)));
            }
        }

		return decryptedText;	
	}
}