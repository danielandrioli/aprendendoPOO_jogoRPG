package pacott;
public class Flechas {
    private String modeloFlecha; //bambu, inox, de vidro, de obsidiana...
    private float forcaFlecha; //vai depender do modelo da flecha;
    private int qtdFlechas = 0;

    //getters
    public int getQtdFlechas(){
        return qtdFlechas;
    }
    public String getModeloFlecha(){
        return modeloFlecha;
    }
    public float getForcaFlecha(){
        return forcaFlecha;
    }
    //setters
    public void setQtdFlechas(int qtdFlechas){ //Em outra classe, fazer o setQtdFlechas receber o get + a
        this.qtdFlechas = qtdFlechas;           //quantidade a ser comprada
    }
    public void setModeloFlecha(String modelo){ 
        this.modeloFlecha = modelo;
        setForcaFlecha(this.modeloFlecha);
    }
    private void setForcaFlecha(String modelo){
        switch(modelo){
            case "madeira":
                forcaFlecha = 1;
                break;
            case "vidro":
                forcaFlecha = 2;
                break;
            case "inox":
                forcaFlecha = 3;
                break;
            case "obsidiana":
                forcaFlecha = 5;
                break;
            default:
                break;
        }
    }
}
