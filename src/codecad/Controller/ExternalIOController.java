/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codecad.Controller;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Augustop
 */
public class ExternalIOController {
    
    public static int[][] getScannerTable(){
        int intTable[][] = null;
        InputStream is = null;
        try {
            is = new FileInputStream(new File("resources/Niflheimr_Table.txt"));
            intTable = new int[contarLinhas("resources/Niflheimr_Table.txt")][];
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            int row = 0;
            String linha;
            
            while ((linha = br.readLine()) != null){
                String[] l = linha.split(",");
                intTable[row] = new int[l.length];
                for (int col = 0; col < l.length; col++){
                    int n = Integer.parseInt(l[col]);
                    intTable[row][col] = n;
                }
                row++;
            }

            is.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ExternalIOController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ExternalIOController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return intTable;
    }
    
    public static int[][][] getParserTable(){
        int intTable[][][] = null;
        InputStream is = null;
        try {
            is = new FileInputStream(new File("resources/Muspelheim_Table.txt"));
            intTable = new int[contarLinhas("resources/Muspelheim_Table.txt")][][];
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            int row = 0;
            String linha;
            
            while((linha = br.readLine()) != null) {
                String[] l = linha.split(",");
                intTable[row] = new int[l.length / 2][2];
                
                for (int i = 0; i < l.length; i += 2) {
                    intTable[row][i / 2][0] = Integer.parseInt(l[i]);
                    intTable[row][i / 2][1] = Integer.parseInt(l[i + 1]);
                }
                row++;
            }

            is.close();
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ExternalIOController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex){
            Logger.getLogger(ExternalIOController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return intTable;
    }
    
    public static int contarLinhas(String fileName) throws IOException{
        InputStream is = new BufferedInputStream(new FileInputStream(fileName));
        try {
            byte[] c = new byte[1024];
            int count = 1;
            int readChars = 0;
            boolean empty = true;
            while ((readChars = is.read(c)) != -1) {
                empty = false;
                for (int i = 0; i < readChars; ++i) {
                    if (c[i] == '\n') {
                        count++;
                    }
                }
            }
            return (empty == true) ? 0 : count;
        } finally {
            is.close();
        }
    }
}
