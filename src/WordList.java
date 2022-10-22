import java.io.*;
import java.util.Scanner;
 
public class WordList {
    public static String [] getWords( String filename) {
        String [] list = null;
       
        try {
            Scanner read = new Scanner( new File( filename) );
            int count = 0;  
            while ( read.hasNext() ){
                read.nextLine();
                count++;
            }        
            read.close();
            list = new String[ count ];
            read = new Scanner( new File( filename) );
            count = 0;
            while ( read.hasNext() ){
                list[count] = read.nextLine();
                count++;
          }
          read.close();
        }
        catch ( IOException e1 ) {
            System.out.println( "Problem reading file. The method will return null." );
        }
        return list;
    }
}