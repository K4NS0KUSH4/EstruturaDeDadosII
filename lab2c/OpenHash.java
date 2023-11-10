


public class OpenHash implements HashTable {
    private int tamanho;
    private Celula[] tabela;
    
    private OpenHash(){
    }
    
    public OpenHash(int tamanho) {
        this.tamanho = tamanho;
        tabela = new Celula[tamanho];
    }
    
    public int getTamanho(){
        return tamanho;
    }
    
    int hashFunction(int chave){
        return chave % this.tamanho;
    }
    
    
    @Override
    public String busca(int chave){
        int hashKey = hashFunction(chave);
        int originalHashKey = hashKey;
        
        while(tabela[hashKey] != null){
            if(tabela[hashKey].chave == chave){
                return tabela[hashKey].valor;
            }
            hashKey = (hashKey + 1)%tamanho;
            if(hashKey == originalHashKey){
                break;
            }
        }
        return "[ELEMENTO NAO EXISTE]";
    }
    
    
    @Override
    public String inserir(int chave,String valor){
        int hashKey = hashFunction(chave);
        int originalHashKey = hashKey;

        while (tabela[hashKey] != null){
            if (tabela[hashKey].chave == chave){
                tabela[hashKey].valor = valor;
                return  "Chave atualizada -> " + "Chave: " + chave + " | Data: " + valor  ;
            }
            hashKey = (hashKey + 1)%tamanho;
            if (hashKey == originalHashKey){
                System.out.println("ERRO AO INSERIR A CHAVE");
            }
        }
        Celula novo = new Celula(chave,valor);
        tabela[hashKey] = novo;
        return "Chave inserida -> " + novo ;
    }
    
    @Override
    public boolean remover(int chave){
        int hashKey = hashFunction(chave);
        int originalHashKey = hashKey;
        while (tabela[hashKey] != null){
            if(tabela[hashKey].chave == chave ){
                tabela[hashKey] = null;
                return true;
            }
            hashKey = (hashKey + 1)%tamanho;
            
            if (hashKey == originalHashKey){
                System.out.println("A chave solicitado não existe");
                return false;
            }
        }
        return false;
    }
    
    
    public void Imprimir(){
        for (int i=0; i < tamanho;i++){
            if(tabela[i] != null){
                System.out.println("[" + i + "] = " + tabela[i]);
            } 
        }
    }
    
   
}