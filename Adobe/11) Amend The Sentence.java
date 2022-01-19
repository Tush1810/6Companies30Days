/*
	https://practice.geeksforgeeks.org/problems/amend-the-sentence3235/1#
*/

class Solution {
	public String amendSentence(String s) {
		StringBuilder sb = new StringBuilder();
		int start = 0;
		if (s.charAt(0) - 'A' > -1 && s.charAt(0) - 'A' < 26) {
			sb.append(((char)(s.charAt(0) - 'A' + 'a')));
			start = 1;
		}
		for (int i = start; i < s.length(); i++) {
			if (s.charAt(i) - 'A' > -1 && s.charAt(i) - 'A' < 26) {
				sb.append(" ");
				sb.append(((char)(s.charAt(i) - 'A' + 'a')));
			} else {
				sb.append(s.charAt(i));
			}
		}
		return sb.toString();
	}
}
