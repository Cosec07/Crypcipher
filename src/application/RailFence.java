package application;

public class RailFence {
	
	public String encrypt(String message,int key)
	{
		message = message.replaceAll("\\s","");
		char[][] rail = new char[key][message.length()];
        // matrix
        for (int i = 0; i < key; i++){
            for (int j = 0; j < message.length(); j++) {
                rail[i][j] = '.';
            }
        }
        // putting letters in the matrix in zig-zag
        int row = 0;
        int check = 0;
        for (int i = 0; i < message.length(); i++) {
            if (check == 0){
                rail[row][i] = message.charAt(i);
                row++;
                if (row == key){
                    check = 1;
                    row--;
                }
            } else if(check == 1){
                row--;
                rail[row][i] = message.charAt(i);
                if (row == 0){
                    check = 0;
                    row = 1;
                }
            } // if-else
        } // for

        String encrypText = "";
        for (int i = 0; i < key; i++) {
            for (int j = 0; j < message.length(); j++) {
                encrypText += rail[i][j];
                encrypText = encrypText.replaceAll("\\.","");
	}
            }
        		return encrypText;
	}
	public String decrypt(String message,int key) {
		char[][] rail = new char[key][message.length()];
        // matrix
        for (int i = 0; i < key; i++){
            for (int j = 0; j < message.length(); j++) {
                rail[i][j] = '.';
            }
        } // for

        // putting letters in the matrix in zig-zag
        int row = 0;
        int check = 0;
        for (int i = 0; i < message.length(); i++) {
            if (check == 0){
                rail[row][i] = message.charAt(i);
                row++;
                if (row == key){
                    check = 1;
                    row--;
                }
            } else if(check == 1){
                row--;
                rail[row][i] = message.charAt(i);
                if (row == 0){
                    check = 0;
                    row = 1;
                }
            } // if-else
        } // for

        // changing order of rails
        int ordr = 0;
        for (int i = 0; i < key; i++) {
            for (int j = 0; j < message.length(); j++) {
                String temp = rail[i][j] + "";
                if (temp.matches("\\.")){
                    // skipping in case of '.'
                    continue;
                } else {
                    // adding cipher letters one by one diagonally
                    rail[i][j] = message.charAt(ordr);
                    ordr++;
                } // if-else
            } // inner for
        } // for

        // checking message reorder on rails
        System.out.println("Reorder");
        for (int i = 0; i < key; i++) {
            for (int j = 0; j < message.length(); j++) {
                System.out.print(rail[i][j]);
            }
            System.out.println();
        }

        String decrypText = "";
        check = 0;
        row = 0;
        // converting rails back into a single line message
        for (int i = 0; i < message.length(); i++) {
            if (check == 0){
                decrypText += rail[row][i];
                row++;
                if(row == key){
                    check = 1;
                    row--;
                }
            } else if (check == 1){
                row--;
                decrypText += rail[row][i];
                if(row == 0){
                    check = 0;
                    row = 1;
                }
            } // if-else
        } // for
        	return decrypText;
	}
	}
