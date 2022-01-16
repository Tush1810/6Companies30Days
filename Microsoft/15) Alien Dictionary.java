/*
    https://practice.geeksforgeeks.org/problems/alien-dictionary/1/#
*/

class Solution {
    private class Alphabet {
        char ch;
        boolean isBefore[];
        Alphabet(char ch) {
            this.ch = ch;
            this.isBefore = new boolean[26];
        }
        void addBefore(char c) {
            isBefore[getInt(c)] = true;
        }
        boolean containsBefore(Alphabet c) {
            if (isBefore[getInt(c.ch)]) return true;
            else return false;
        }
    }
    public String findOrder(String [] dict, int n, int k) {
        int maxLen = -1;
        for (int i = 0; i < n; i++) {
            maxLen = Math.max(maxLen, dict[i].length());
        }

        Alphabet[] ch = new Alphabet[k];
        for (int i = 0; i < k; i++) {
            ch[i] = new Alphabet(getChar(i));
        }

        for (int i = 0; i < maxLen; i++) {
            for (int j = 1; j < n; j++) {
                if (!(dict[j].length() > i && dict[j - 1].length() > i)) continue;
                if (!(dict[j].substring(0, i).equals(dict[j - 1].substring(0, i)))) continue;
                if (dict[j].charAt(i) != dict[j - 1].charAt(i)) {
                    ch[getInt(dict[j - 1].charAt(i))].addBefore(dict[j].charAt(i));
                }
            }
        }

        Arrays.sort(ch, (o1, o2)-> {
            if (o1.containsBefore(o2)) {
                return 1;
            }
            if (o2.containsBefore(o1)) {
                return -1;
            }
            return 0;
        });

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < ch.length; i++) {
            sb.append(ch[i].ch);
        }
        return sb.toString();
    }

    private int getInt(char ch) {
        return (int)(((int)ch) - ((int)'a'));
    }
    private char getChar(int ch) {
        return (char)(ch + ((int)'a'));
    }
}
