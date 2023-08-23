
public class CarroDePasseio extends VeiculoTerrestre {
    private int totalDePassageiros;
    
    public CarroDePasseio(){
        super(0,"");
        this.totalDePassageiros = 0;
    }
    
     public CarroDePasseio(int ano,String cor,int totalDePassageiros){
        super(ano,cor);
        this.totalDePassageiros = totalDePassageiros;
    }

    public int getTotalDePassageiros() {
        return totalDePassageiros;
    }

    public void setTotalDePassageiros(int totalDePassageiros) {
        this.totalDePassageiros = totalDePassageiros;
    }
     
     @Override
     public String toString(){
         return "Carro de passeio: " + super.toString() + "  |  Total de Passageiros " + totalDePassageiros;
         
     }
 
}
