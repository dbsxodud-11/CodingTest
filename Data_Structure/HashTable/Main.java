package Data_Structure.HashTable;

public class Main {
    
    public static void main(String[] args){
        
        //1.Hashmap with seperate chaining
        MyMap<String, Integer> hashmap = new MyHashMap<>(4);

        //Put Operation
        hashmap.put("Watermelon", 14);
        hashmap.put("Strawberry", 25);
        hashmap.put("Apple", 31);
        hashmap.put("Peach", 45);
        hashmap.put("Orange", 19);
        hashmap.put("Dragonfruit", 23);
        hashmap.put("Dragonfruit", 27);
        
        //Get Operation
        for(String key: hashmap.keySet()){
            System.out.println(key + "\t" + hashmap.get(key));
        }

        System.out.println("----------------------------------------");
        
        //Remove Operation
        hashmap.remove("Watermelon");
        hashmap.remove("Orange");

        //Get Operation
        for(String key: hashmap.keySet()){
            System.out.println(key + "\t" + hashmap.get(key));
        }
    }
}
