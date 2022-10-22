/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author s31011
 */
public class WordFinder {
    public int wordFinder(String word){
        String[] dict = WordList.getWords("M:\\Documents\\NetBeansProjects\\ReadingFiles\\src\\words.txt");
        for(int i = 0; i<dict.length; i++){
            if(dict[i].equals(word)){
                return i++;
            }
        }
        return -1;
    }
    
    
}
