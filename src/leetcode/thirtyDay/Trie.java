package leetcode.thirtyDay;

import java.util.List;

public class Trie {
    int count;
    Trie [] child;

    public static void main(String[] args) {

        Trie trie = new Trie();
        trie.insert("hello");
        System.out.println(trie.startsWith("hell"));

        System.out.println("Hey");
    }

    public Trie() {
        count=0;
        child = new Trie[26];
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public Trie[] getChild() {
        return child;
    }

    public void setChild(Trie[] child) {
        this.child = child;
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {

        if (word.length()==1) {
            if (child[word.charAt(0)-'a']!=null) {
                child[word.charAt(0)-'a'].count++;
            } else {
                child[word.charAt(0)-'a']=new Trie();
                child[word.charAt(0)-'a'].count++;
            }
            return;
        }

        if (child[word.charAt(0)-'a']==null) {
            child[word.charAt(0)-'a']=new Trie();
        }
        child[word.charAt(0)-'a'].insert(word.substring(1));
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        if (word.length()==1) {
          if (child!=null && child[word.charAt(0)-'a']!=null && child[word.charAt(0)-'a'].count!=0) {
              return true;
          } else {
              return false;
          }
        } else {
            if (child!=null && child[word.charAt(0)-'a']!=null) {
                return child[word.charAt(0)-'a'].search(word.substring(1));
            } else {
                return false;
            }
        }
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        if (prefix.length()==1) {
            if (child!=null && child[prefix.charAt(0)-'a']!=null) {
                return true;
            } else {
                return false;
            }
        } else {
            if (child!=null && child[prefix.charAt(0)-'a']!=null) {
                return child[prefix.charAt(0)-'a'].startsWith(prefix.substring(1));
            } else {
                return false;
            }
        }
    }
}
