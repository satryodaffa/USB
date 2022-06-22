package FinalProject;
// 2.5 Marley Word Converter

import java.util.LinkedList;
import java.util.Objects;
import java.util.Scanner;

/**
 *
 * @author Nayatama
 */
class Key {
    private Character key;
    public Key(Character k){
        key = k;
    }

    @Override
    public boolean equals(Object o){
        if(this == o) return true;
        if(o == null || getClass() != o.getClass()) return false;
        Key key1 = (Key) o;
        return  Objects.equals(key, key1.key);
    }

    @Override
    public int hashCode() {
        return Objects.hash(key);
    }

}

class Value {
    private Character value;
    public Value(Character v){
        value = v;
    }
    
    public Character getValue(){
        return value;
    }
    
    @Override
    public boolean equals(Object o){
        if(this == o) return true;
        if(o == null || getClass() != o.getClass()) return false;
        Value value1 = (Value) o;
        return value == value1.value;
    }
}

class Entry {
    public Key key;
    public Value value;
    public Entry(Key k, Value v){
        key = k;
        value = v;
    }
}

public class WordConverter {
    LinkedList<Entry>[] hashMap = new LinkedList[2];
    int size = 0;
    public WordConverter(){
        
    }
    
    public void put(Key key, Value value){
        if(size >= hashMap.length){
            resize();
        }
    
        int x = getIndex(key) % hashMap.length;
    
        if(hashMap[x] == null){
            hashMap[x] = new LinkedList<>();
            hashMap[x].add(new Entry(key, value));
            size++;
            return;
        }
        else{
            for(Entry entry : hashMap[x]){
                if(entry.key.equals(key)){
                    entry.value = value;
                    size++;
                    return;
                }
            }
            hashMap[x].add(new Entry(key, value));
            size++;
            return;
        }
    
    }
    
    public Value get(Key key){
        int x = getIndex(key) % hashMap.length;

        if(hashMap[x] == null) return null;

        for(Entry entry: hashMap[x]){
            if(entry.key.equals(key)){
                return entry.value;
            }
         }
         return null;
    }

    public void remove(Key key){
        if(key == null) return;
        
        int x = getIndex(key) % hashMap.length;

        if(hashMap[x] == null) return;

        Entry toRemove = null;

        for(Entry entry : hashMap[x]){
            if(entry.key.equals(key)){
                toRemove = entry;
            }
        }
        if(toRemove == null) return;
        
        hashMap[x].remove(toRemove);
    }

    public boolean containsKey(Key key){
        if(key == null) return false;

        int x = getIndex(key) % hashMap.length;

        if(hashMap[x] == null){
            return false;
        }
        for(Entry entry : hashMap[x]){
            if(entry.key.equals(key)){
                return true;
            }
        }
        return false;
    }

    public void resize(){
        LinkedList<Entry>[] oldHashMap = hashMap;
        hashMap = new LinkedList[size * 2];
        size = 0;
        
        for(int i = 0; i < oldHashMap.length; i++){
            if(oldHashMap[i] == null) continue;
            for(Entry entry: oldHashMap[i]){
                put(entry.key, entry.value);
            }
        }
    }
    
    public int getIndex(Key key){
        return key.hashCode();
    }
    
    public int size(){
        return size;
    }
    
}
class Converter {
    public static void convert() {
        WordConverter translater = new WordConverter();
        translater.put(new Key('a'), new Value('j'));
        translater.put(new Key('b'), new Value('c'));
        translater.put(new Key('c'), new Value('t'));
        translater.put(new Key('d'), new Value('a'));
        translater.put(new Key('e'), new Value('k'));
        translater.put(new Key('f'), new Value('z'));
        translater.put(new Key('g'), new Value('s'));
        translater.put(new Key('h'), new Value('i'));
        translater.put(new Key('i'), new Value('w'));
        translater.put(new Key('j'), new Value('x'));
        translater.put(new Key('k'), new Value('o'));
        translater.put(new Key('l'), new Value('n'));
        translater.put(new Key('m'), new Value('g'));
        translater.put(new Key('n'), new Value('b'));
        translater.put(new Key('o'), new Value('f'));
        translater.put(new Key('p'), new Value('h'));
        translater.put(new Key('q'), new Value('l'));
        translater.put(new Key('r'), new Value('d'));
        translater.put(new Key('s'), new Value('e'));
        translater.put(new Key('t'), new Value('y'));
        translater.put(new Key('u'), new Value('m'));
        translater.put(new Key('v'), new Value('v'));
        translater.put(new Key('w'), new Value('u'));
        translater.put(new Key('x'), new Value('p'));
        translater.put(new Key('y'), new Value('q'));
        translater.put(new Key('z'), new Value('r'));
        
        Scanner input = new Scanner(System.in);
        System.out.print("Enter Marley sentence : ");
        String marley = input.nextLine();
        
        StringBuilder word = new StringBuilder();
        for(int i = 0; i < marley.length(); i++){
            if(marley.charAt(i) >= 'a' && marley.charAt(i) <= 'z'){
                
                word.append(translater.get(new Key(marley.charAt(i))).getValue());
            }
            else if(marley.charAt(i) == '^'){
                i++;
                char upper = translater.get(new Key(marley.charAt(i))).getValue();
                String marleyUp = String.valueOf(upper);
                word.append(marleyUp.toUpperCase());
                
            }
            else if(marley.charAt(i) == '$'){  
                word.append(" ");
                
            }
            else if(marley.charAt(i) == ','){
                word.append(",");
                
            } 
            else{
                word.append(marley.charAt(i));

                
            }
        }
        String rev = word.toString();
        word.delete(0,word.length());
        for(int i = 0; i < rev.length(); i++){
            if(rev.charAt(i) == '('){
                int tmp = i;
                StringBuilder s = new StringBuilder();
                while(rev.charAt(tmp) != ')'){
                    tmp++;
                }
                    
                s.append(rev, i + 1, tmp);
                word.append(s.reverse().toString());
                i = tmp;
            }else{
                word.append(rev.charAt(i));
                }
        }
        System.out.println(word);
        
        logout();
    }
    
    public static void logout(){
        Scanner sc = new Scanner(System.in);
        System.out.println("");
        System.out.println("What would you like to do next? (Enter \"1\" to use the Word Converter again or \"0\" to go back to the Main Menu)/n");
        System.out.print("Input command: ");
        int in = sc.nextInt();
        if(in == 0){
            for (int i = 0; i < 30; ++i) 
                System.out.println();
            LoginPage.runLoginPage();
        }
        else if(in == 1){
            System.out.println();
            convert();
        }
        else{
            System.out.println();
            System.out.println("Please enter a valid command!");
            logout();
        }
        
    }
}
