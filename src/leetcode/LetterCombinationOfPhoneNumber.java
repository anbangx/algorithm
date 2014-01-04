package leetcode;
import java.util.ArrayList;


public class LetterCombinationOfPhoneNumber {
    
    public ArrayList<String> letterCombinations(String digits) {
        ArrayList<String> results = new ArrayList<String>();
        if(digits == null || digits.length() == 0){
            results.add("");
            return results;
        }
            
        // get first digit
        ArrayList<StringBuilder> combination = new ArrayList<StringBuilder>();
        int digit = Integer.parseInt(digits.substring(0, 1));
        ArrayList<String> letters = getLetters(digit);
        for(String letter : letters){
            StringBuilder sb = new StringBuilder("");
            sb.append(letter);
            combination.add(sb);
        }
        
        // iterate over the digits
        for(int i = 1; i < digits.length(); i++){
            digit = Integer.parseInt(digits.substring(i, i + 1));
            letters = getLetters(digit);
            ArrayList<StringBuilder> newCombination = new ArrayList<StringBuilder>();
            for(StringBuilder old : combination){
                for(String letter : letters){
                    StringBuilder sb = new StringBuilder(old.toString());
                    sb.append(letter);
                    newCombination.add(sb);
                }
            }
            combination = newCombination;
        }
        
        // covert StringBuilder to String
        for(StringBuilder sb : combination){
            results.add(sb.toString());
        }
        
        return results;
    }
    
    public static void main(String[] args) {
        LetterCombinationOfPhoneNumber lcop = new LetterCombinationOfPhoneNumber();
        System.out.println(lcop.letterCombinations("22"));
    }
    
    public ArrayList<String> getLetters(int digit){
        ArrayList<String> letters = new ArrayList<String>();
        switch(digit){
            case 2:
                letters.add("a");
                letters.add("b");
                letters.add("c");
                return letters;
            case 3:
                letters.add("d");
                letters.add("e");
                letters.add("f");
                return letters;
            case 4:
                letters.add("g");
                letters.add("h");
                letters.add("i");
                return letters;
            case 5:
                letters.add("j");
                letters.add("k");
                letters.add("l");
                return letters;
            case 6:
                letters.add("m");
                letters.add("n");
                letters.add("o");
                return letters;
            case 7:
                letters.add("p");
                letters.add("q");
                letters.add("r");
                letters.add("s");
                return letters;
            case 8:
                letters.add("t");
                letters.add("u");
                letters.add("v");
                return letters;
            case 9:
                letters.add("w");
                letters.add("x");
                letters.add("y");
                letters.add("z");
                return letters;
            default:
                return letters;
        }
    }

}
