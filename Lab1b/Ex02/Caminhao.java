
public class Caminhao extends VeiculoTerrestre {
    private int totalDeEixos;
    
    public Caminhao(int ano,String cor,int totalDeEixos){
        super(ano,cor);
        this.totalDeEixos = totalDeEixos;
    }

    public int getTotalDeEixos() {
        return totalDeEixos;
    }

    public void setTotalDeEixos(int totalDeEixos) {
        this.totalDeEixos = totalDeEixos;
    }
    
    @Override
    public String toString(){
        return "Caminhao: " + super.toString() + "  | Total de Eixos:" + totalDeEixos;
    }
}
