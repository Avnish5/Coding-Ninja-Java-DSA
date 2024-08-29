package lecture_20_trie_and_huffman_coding;

import java.util.ArrayList;

class TrieNode{
    char data;
    boolean isTerminating;
    TrieNode children[];
    int childCount;

    public TrieNode(char data) {
        this.data = data;
        isTerminating = false;
        children = new TrieNode[26];
        childCount = 0;
    }
}


public class Trie {

    private TrieNode root;


    public Trie() {
        root = new TrieNode('\0');

    }

    //remove word
    public void remove(String word){
        remove(root, word);


    }


    private boolean remove(TrieNode root, String word) {
        if(word.length() == 0){
            if(root.isTerminating) {
                root.isTerminating = false;
                return true;
            }
            else {
                return false;
            }
        }
        int childIndex = word.charAt(0) - 'a';
        TrieNode child = root.children[childIndex];
        if(child == null){
            return false;
        }
        boolean ans = remove(child, word.substring(1));
        // We can remove child node only if it is non terminating and its number of children are 0

        if(!child.isTerminating && child.childCount == 0){
            root.children[childIndex] = null;
            child = null;
            root.childCount--;
        }
        return ans;
    }

    //add word
    private boolean add(TrieNode root, String word){
        if(word.length() == 0){
            if(root.isTerminating) {
                return false;
            }
            else {
                root.isTerminating = true;
                return true;
            }
        }
        int childIndex = word.charAt(0) - 'a';
        TrieNode child = root.children[childIndex];
        if(child == null){
            child = new TrieNode(word.charAt(0));
            root.children[childIndex] = child;
            root.childCount++;
        }
        return add(child, word.substring(1));
    }

    public void add(String word){
        add(root, word);


    }

    //search word
    public boolean search(String word){
        return search(root, word);
    }

    private boolean search(TrieNode root, String word) {
        if(word.length()==0)
        {
            return root.isTerminating?true:false;
        }
        int childIndex = word.charAt(0) - 'a';
        TrieNode child = root.children[childIndex];
        if(child == null) return false;
        return search(child,word.substring(1));


    }

    //count no of words
    public int countWords(TrieNode root)
    {
        int count=0;
        if(root.isTerminating) count++;

        for(int i=0;i<26;i++)
        {
            if(root.children[i]!=null)
            {
                count+=countWords(root.children[i]);
            }
        }

        return count;

    }
    public int countWords() {
        return countWords(root);
    }

    // auto complete
    /*
    Problem statement
Given n number of words and an incomplete word w. You need to auto-complete that word w.

That means, find and print all the possible words which can be formed using the incomplete word w.

Note : Order of words does not matter.

Detailed explanation ( Input/output format, Notes, Images )
Constraints:
0 <= n <= 10^5
Time Limit: 1 sec
Sample Input 1 :
7
do dont no not note notes den
no
Sample Output 1 :
no
not
note
notes
Sample Input 2 :
7
do dont no not note notes den
de
Sample Output 2 :
den
Sample Input 3 :
7
do dont no not note notes den
nom
Sample Output 3 :
(Empty) There is no word which starts with "nom"


     */
    private TrieNode findRoot(TrieNode root,String word)
    {
        if(word.length()==0)
        {
            return root;
        }

        int childIndex = word.charAt(0) - 'a';
        TrieNode child = root.children[childIndex];
        if(child == null) return null;
        return findRoot(child, word.substring(1));
    }

    public void path(TrieNode root,String word,String output)
    {
        if(root.isTerminating)
        {
            System.out.println(word+output);
        }

        for(int i=0;i<26;i++)
        {
            if(root.children[i]!=null)
            {
                String s=output+root.children[i].data;
                path(root.children[i],word,s);
            }
        }
    }
    public void autoComplete(ArrayList<String> input, String word) {

        for(String s:input)
        {
            add(s);
        }

        TrieNode node=findRoot(root, word);
        if(node==null || node.childCount==0) return;

        String output="";
        path(node,word,output);

    }
    //pattern matching
    /*
    Problem statement
Given a list of n words and a pattern p that we want to search. Check if the pattern p is present the given words or not. Return true if the pattern is present and false otherwise.

Detailed explanation ( Input/output format, Notes, Images )
Constraints:
0 <= n <= 10^5
Time Limit: 1 sec
Sample Input 1 :
4
abc def ghi cba
de
Sample Output 1 :
true
Sample Input 2 :
4
abc def ghi hg
hi
Sample Output 2 :
true
Sample Input 3 :
4
abc def ghi hg
hif
Sample Output 3 :
false
     */
    public boolean patternMatching(ArrayList<String> vect, String pattern) {

        for(String s:vect)
        {
            Trie suffixTree=new Trie();

            for(int i=0;i<s.length();i++)
            {
                suffixTree.add(s.substring(i));
            }

            if(suffixTree.search(pattern)) return true;
        }

        return false;
    }

}