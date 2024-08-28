package lecture_20_trie_and_huffman_coding;
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

}