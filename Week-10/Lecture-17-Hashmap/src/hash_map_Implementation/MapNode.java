package hash_map_Implementation;

public class MapNode<K,V> {
    K key;
    V value;
    MapNode<K,V> next;

    MapNode(K key,V value){
        this.key=key;
        this.value=value;
    }
}