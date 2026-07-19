package hash_table;

import oop_basics.Node;

public class HashTable {
    public static void main(String[] args) {
    Node[] table = new Node[10];
    
    int random = hash_function("example", table.length);
    int random1 = hash_function("example1", table.length);
        
    }
    
    public static int hash_function(String key, int tableSize) {
        int hash = 0;
        for (int i = 0; i < key.length(); i++) {
            hash += key.charAt(i);
        }
        int hashIndex = hash % tableSize;
        System.out.println("Hash index for key '" + key + "': " + hashIndex);
        return hashIndex;
}
}
