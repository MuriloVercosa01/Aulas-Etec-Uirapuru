package psv;

public class CarroBean {

    private String placa;

    private String cor;

    private String descricao;

    public String getCor(){
        return this.cor;
    }

    public void setCor(String cor){
        this.cor = cor;
    }
    public String getDescricao(){
        return this.descricao;
    }
    public void setDescricao(String descricao){
        this.descricao = descricao;
    }

    public void setPlaca(String placa){
        this.placa = placa;
    }
    public String getPlaca(){
        return this.placa;
    }

}
