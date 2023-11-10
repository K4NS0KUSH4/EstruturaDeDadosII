

import java.util.LinkedList;


public class ChainHash implements HashTable{
    private int tamanho;
    //private ArrayList<Celula>[] tabela;
    private LinkedList<Celula>[] tabela;

    private ChainHash(){
    }
    
    public ChainHash(int tamanho) {
        this.tamanho = tamanho;
        tabela = new LinkedList[tamanho];
        for(int i = 0; i < tamanho;i++){
            tabela[i] = new LinkedList();
        }
    }
    
    public int getTamanho(){
        return tamanho;
    }
    
    public int funcaoHash(int chave){
        return chave % this.tamanho;
    }
    
    @Override
    public String busca(int chave){
        int hashKey = funcaoHash(chave);
        
        for(Celula c:tabela[hashKey]){
            if(c.getChave() == chave){
                return c.valor;   
            }  
        }    
        return "chave " + chave + " nao existe";   
    }
    
    
    @Override
    public String inserir(int chave,String valor){
        int hashKey = funcaoHash(chave);
         
        if(tabela[hashKey].isEmpty()){ //Lista vazia??
            Celula novo = new Celula(chave,valor);
            tabela[hashKey].add(novo);
            return "Chave inserida -> " + tabela[hashKey] ; 
        }else{
            //Pra cada elemento do indice do vetor
            if(!tabela[hashKey].isEmpty()){
                for(Celula c:tabela[hashKey]){
                    if(c.getChave() == chave){//Se a chave for igual atualiza
                        c.setValor(valor);
                        return "Chave atualizada -> " + c;   
                    }
                    if(tabela[hashKey].getLast() == c){
                        Celula novo = new Celula(chave,valor);
                        tabela[hashKey].add(novo);
                        return "Chave inserida -> " + tabela[hashKey];  
                    }
                }
            }
           
        return "Nao foi possível ";
    }
}
    @Override
    public boolean remover(int chave){
        
        int hashKey = funcaoHash(chave);
        
        for(Celula c:tabela[hashKey]){
            if(c.getChave() == chave){
               tabela[hashKey].remove(c);
               return true;
            }  
        }    
        return false;
    }
    
    public void imprimir(){
        for (int i=0; i < tamanho;i++){
            if(tabela[i] != null){
                System.out.println("[" + i + "] = " + tabela[i]);
            } 
        }
    }
    
}