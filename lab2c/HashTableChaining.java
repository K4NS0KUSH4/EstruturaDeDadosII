/* NOME: Jônatas Garcia de Oliveira     TIA: 42181232
 * NOME: Pedro Henrique Araujo Farias   TIA: 32246994
 */

import java.util.LinkedList;

public class HashTableChaining implements HashTable {
    private int size;
    private LinkedList<Cell>[] table;

    public HashTableChaining(int argSize) {
        this.size = argSize;
        this.table = (LinkedList<Cell>[]) new LinkedList<?>[argSize]; // Não consegui arrumar esse warning =(
        for(int i = 0; i < argSize; i++) {
            table[i] = new LinkedList<Cell>();
        }
    }
    
    public int getSize() { return size; }
    
    public int hashFunction(int argKey) { return argKey % this.size; }
    
    @Override
    public String search(int argKey) {
        int hashKey = hashFunction(argKey);
        
        for(Cell c : table[hashKey]) {
            if(c.getKey() == argKey) {
                return c.getValue();   
            }  
        }

        return "Chave " + argKey + " não existe.";   
    }
    
    
    @Override
    public String insert(int argKey, String argValue) {
        int hashKey = hashFunction(argKey);
         
        if(table[hashKey].isEmpty()) { // Lista vazia??
            Cell newCell = new Cell(argKey,argValue);
            table[hashKey].add(newCell);
            return "Chave inserida -> " + table[hashKey]; 
        } else {
            //Pra cada elemento do indice do vetor
            if(!table[hashKey].isEmpty()) {
                for(Cell c : table[hashKey]) {
                    if(c.getKey() == argKey) {//Se a chave for igual atualiza
                        c.setValue(argValue);
                        return "Chave atualizada -> " + c;   
                    }
                    if(table[hashKey].getLast() == c) {
                        Cell newCell = new Cell(argKey,argValue);
                        table[hashKey].add(newCell);
                        return "Chave inserida -> " + table[hashKey];  
                    }
                }
            }
        }
           
        return "Nao foi possível inserir chave-valor.";
    }

    @Override
    public boolean remove(int argKey) {
        int hashKey = hashFunction(argKey);
        
        for(Cell c : table[hashKey]) {
            if(c.getKey() == argKey) {
               table[hashKey].remove(c);
               return true;
            }  
        }

        return false;
    }
    
    public void printTable() {
        for(int i = 0; i < size; i++) {
            if(table[i] != null) { System.out.println("[" + i + "] = " + table[i]); } 
        }
    }
}