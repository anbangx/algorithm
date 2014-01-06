package leetcode.string;

import java.util.ArrayList;

public class TextJustification {

    public ArrayList<String> fullJustify(String[] words, int L) {
        // base case
        ArrayList<String> results = new ArrayList<String>();
        if (words == null || words.length == 0 || (words.length == 1 && words[0] == "")) {
            StringBuilder sb = new StringBuilder("");
            while (L > 0) {
                sb.append(" ");
                L--;
            }
            results.add(sb.toString());
            return results;
        }
        // transform
        ArrayList<ArrayList<String>> t = new ArrayList<ArrayList<String>>();
        ArrayList<String> line = new ArrayList<String>();
        int lineLength = 0;
        for (String word : words) {
            if (lineLength + word.length() > L) {
                t.add(new ArrayList<String>(line));
                line.clear();
                lineLength = 0;
            }
            line.add(word);
            lineLength += word.length() + 1;
        }
        if (line.size() != 0)
            t.add(line);
        System.out.println(t);

        // add extra space
        for (int i = 0; i < t.size(); i++) {
            ArrayList<String> l = t.get(i);
            int size = l.size();
            lineLength = getLineLength(l);
            int extraSpace = L - lineLength;
            int numSlot = size - 1;
            StringBuilder sb = new StringBuilder("");
            if (i != t.size() - 1) {
                if (size == 1) {
                    sb.append(l.get(0));
                    int numSpace = L - lineLength;
                    while (numSpace > 0) {
                        sb.append(" ");
                        numSpace--;
                    }
                } else {
                    for (int j = 0; j < size; j++) {
                        sb.append(l.get(j));
                        if (j != size - 1) {
                            // space
                            int numSpace = extraSpace / numSlot + (j < extraSpace % numSlot ? 1 : 0);
                            while (numSpace > 0) {
                                sb.append(" ");
                                numSpace--;
                            }
                        }
                    }
                }
            } else { // last line
                for (int j = 0; j < size; j++) {
                    sb.append(l.get(j));
                    if (j != size - 1)
                        sb.append(" ");
                }
                int numSpace = L - lineLength - (size - 1);
                while (numSpace > 0) {
                    sb.append(" ");
                    numSpace--;
                }
            }
            results.add(sb.toString());
        }
        return results;
    }

    public int getLineLength(ArrayList<String> l) {
        int length = 0;
        for (String word : l) {
            length += word.length();
        }
        return length;
    }

    public static void main(String[] args) {
        TextJustification tj = new TextJustification();
        String[] words = { "Listen", "to", "many,", "speak", "to", "a", "few." };//{"This", "is", "an", "example", "of", "text", "justification."};
        System.out.println(tj.fullJustify(words, 6));
    }

}
