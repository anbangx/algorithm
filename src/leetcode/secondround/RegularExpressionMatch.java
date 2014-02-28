package leetcode.secondround;

public class RegularExpressionMatch {

	public boolean isMatchUtil(String s, int startS, String p, int startP) {
		int sLen = s.length();
		int pLen = p.length();
		if (startS == sLen && startP == pLen)
			return true;
		if (startS == sLen || startP == pLen)
			return false;

		char cp = p.charAt(startP++);
		if (startP == pLen) {
			char cs = s.charAt(startS++);
			return (cp == '.' || cs == cp) && startS == sLen;
		}
		if (p.charAt(startP) != '*') {
			char cs = s.charAt(startS++);
			if (cp != '.' && cp != cs)
				return false;
			return isMatchUtil(s, startS, p, startP);
		} else {
			startP++;
			if (isMatchUtil(s, startS, p, startP))
				return true;
			char cs = s.charAt(startS++);
			while (cp == '.' || cs == cp) {
				if (isMatchUtil(s, startS, p, startP))
					return true;
				if (startS >= sLen)
					return false;
				cs = s.charAt(startS++);
			}
			return false;
		}

	}

	public boolean isMatch(String s, String p) {
		return isMatchUtil(s, 0, p, 0);
	}

	public static void main(String[] args) {
		RegularExpressionMatch rem = new RegularExpressionMatch();
		System.out.println(rem.isMatch("a", "."));
	}

}
