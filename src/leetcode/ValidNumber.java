package leetcode;

public class ValidNumber {
    
    public enum InputType{
        INVALID(0),    // 0
        SPACE(1),      // 1
        SIGN(2),       // 2
        DIGIT(3),      // 3
        DOT(4),        // 4
        EXPONENT(5),   // 5
        NUM_INPUTES(6); // 6
        
        private final int value;
        
        private InputType(final int newValue){
            value = newValue;
        }
        
        public int getValue() { return value; }
    }
    
    int transitionTable[][] = {
            {-1,  0,  3,  1,  2, -1},     // next states for state 0
            {-1,  8, -1,  1,  4,  5},     // next states for state 1
            {-1, -1, -1,  4, -1, -1},     // next states for state 2
            {-1, -1, -1,  1,  2, -1},     // next states for state 3
            {-1,  8, -1,  4, -1,  5},     // next states for state 4
            {-1, -1,  6,  7, -1, -1},     // next states for state 5
            {-1, -1, -1,  7, -1, -1},     // next states for state 6
            {-1,  8, -1,  7, -1, -1},     // next states for state 7
            {-1,  8, -1, -1, -1, -1}      // next states for state 8
        };
    
    public boolean isNumber(String s) {
        int state = 0;
        for(int i = 0; i < s.length(); i++){
            InputType inputType = InputType.INVALID;
            switch(s.charAt(i)){
                case ' ':
                    inputType = InputType.SPACE;
                    break;
                case '+':
                case '-':
                    inputType = InputType.SIGN;
                    break;
                case '0':
                case '1':
                case '2':
                case '3':
                case '4':
                case '5':
                case '6':
                case '7':
                case '8':
                case '9':
                    inputType = InputType.DIGIT;
                    break;
                case '.':
                    inputType = InputType.DOT;
                    break;
                case 'e':
                case 'E':
                    inputType = InputType.EXPONENT;
                    break;
            }
            
            // Get next state from current state and input symbol
            state = transitionTable[state][inputType.getValue()];
            // Invalid input
            if (state == -1) return false;
        }
        
         // If the current state belongs to one of the accepting (final) states,
         // then the number is valid
         return state == 1 || state == 4 || state == 7 || state == 8;
    }
    
    public static void main(String[] args) {
        double x = 4 * 1.0 / 5;
        System.out.println(x);
    }

}
