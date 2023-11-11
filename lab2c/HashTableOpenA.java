/* NOME: Jônatas Garcia de Oliveira     TIA: 42181232
 * NOME: Pedro Henrique Araujo Farias   TIA: 32246994
 */

public class HashTableOpenA implements HashTable {
    private int length;
    private Cell[] table;
    
    public HashTableOpenA(int argLength) {
        this.length = argLength;
        table = new Cell[argLength];
    }
    
    public int getLength() { return length; }
    
    int hashFunction(int argKey) { return argKey % this.length; }
    
    @Override
    public String search(int argKey) {
        int hashKey = hashFunction(argKey);
        int originalHashKey = hashKey;
        
        while(table[hashKey] != null){
            if(table[hashKey].getKey() == argKey) { return table[hashKey].getValue(); }
            
            hashKey = (hashKey + 1) % length;

            if(hashKey == originalHashKey) { break; }
        }

        return "[ELEMENTO NÃO EXISTE]";
    }
    
    @Override
    public String insert(int argKey, String argValue) {
        int hashKey = hashFunction(argKey);
        int originalHashKey = hashKey;

        while(table[hashKey] != null) {
            if(table[hashKey].getKey() == argKey) {
                table[hashKey].setValue(argValue);
                return "Chave atualizada -> " + "Chave: " + argKey + " | Data: " + argValue;
            }

            hashKey = (hashKey + 1) % length;

            if(hashKey == originalHashKey) { System.out.println("ERRO AO INSERIR A CHAVE"); }
        }

        Cell newCell = new Cell(argKey,argValue);
        table[hashKey] = newCell;
        return "Chave inserida -> " + newCell;
    }
    
    @Override
    public boolean remove(int argKey) {
        int hashKey = hashFunction(argKey);
        int originalHashKey = hashKey;

        while(table[hashKey] != null) {
            if(table[hashKey].getKey() == argKey ) {
                table[hashKey] = null;
                return true;
            }

            hashKey = (hashKey + 1) % length;
            
            if(hashKey == originalHashKey) {
                System.out.println("A chave informada não existe");
                return false;
            }
        }

        return false;
    }
    
    public void printTable() {
        for(int i = 0; i < length; i++) {
            if(table[i] != null) { System.out.println("[" + i + "] = " + table[i]); } 
        }
    }
}