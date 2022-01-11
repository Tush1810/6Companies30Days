/*
    https://practice.geeksforgeeks.org/problems/phone-directory4628/1/#
*/

class Solution {
    static ArrayList<ArrayList<String>> displayContacts(int n,
            String arr[], String s) {
        Trie t = new Trie();
        for (int i = 0; i < n; i++) {
            t.put(arr[i]);
        }

        ArrayList<ArrayList<String>> ans = new ArrayList<>();
        ArrayList<String> temp = new ArrayList<>();
        ArrayList<String> temp2 = new ArrayList<>();
        ans.add(t.fetchQueries(s.charAt(0)));

        for (int i = 1; i < s.length(); i++) {
            temp = ans.get(i - 1);
            temp2 = new ArrayList<>();
            for (int j = 0; j < temp.size(); j++) {
                if (temp.get(j).length() <= i) continue;
                if (temp.get(j).charAt(i) == s.charAt(i)) {
                    temp2.add(temp.get(j));
                }
            }
            if (temp2.size() == 0) {
                temp2.add("0");
            }
            ans.add(temp2);
        }
        return ans;
    }

    public static class Trie {
        private class Node {
            char data;
            Node[] next;

            Node(char ch) {
                this.data = ch;
                next = new Node[27];
            }
            Node() {
                this.data = '-';
                next = new Node[27];
            }
        }

        private Node root;
        Trie() {
            this.root = new Node();
        }
        public void put(String s) {
            Node temp = root;
            for (int i = 0; i < s.length(); i++) {
                if (temp.next[s.charAt(i) - 'a'] == null) {
                    temp.next[s.charAt(i) - 'a'] = new Node(s.charAt(i));
                }
                temp = temp.next[s.charAt(i) - 'a'];
            }
            temp.next[26] = new Node();
        }

        public ArrayList<String> fetchQueries(char ch) {
            ArrayList<String> ans = new ArrayList<>();
            if (root.next[ch - 'a'] == null) {
                ans.add("0");
                return ans;
            }
            Node temp = root.next[ch - 'a'];
            StringBuilder sb = new StringBuilder();
            sb.append(ch);
            dfs(ans, sb, temp);
            return ans;
        }

        public void dfs(ArrayList<String> ans, StringBuilder sb, Node root) {
            if (root.next[26] != null && sb.length() > 1) {
                ans.add(sb.toString());
            }
            for (int i = 0; i < 26; i++) {
                if (root.next[i] != null) {
                    sb.append(((char)((int)'a' + i)));
                    dfs(ans, sb, root.next[i]);
                    sb.deleteCharAt(sb.length() - 1);
                }
            }
        }
    }
}
