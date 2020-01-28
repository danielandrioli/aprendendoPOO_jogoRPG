package pacott;
public class Arco {
    private boolean carregado;
    private String modeloArco; //artesanal, recurvo ou composto
    private float forcaArco; //vai depender do modelo do arco;

    //getters
    public boolean isCarregado(){
        return carregado;
    }
    public String getModeloArco(){
        return modeloArco;
    }
    public float getForcaArco(){
        return forcaArco;
    }
    //setters
    public void setCarregar(boolean carregado){
        //FAZER SER IMPOSSIVEL DE CARREGAR SEM TER FLECHAS ok
        this.carregado = carregado;
    }
    public void atirar(){
            System.out.println("FFFfffiu.... PAH!!");
            //Fazer, na outra classe, o numero de flechas diminuir! OK
            carregado = false;
    }
    public void setModeloArco(String modelo){
        this.modeloArco = modelo; //Em main, fazer ele receber apenas artesanal, recurvo ou composto
        setForcaArco(this.modeloArco);
    }
    private void setForcaArco(String modelo){
        switch (modelo) {
            case "artesanal":
                forcaArco = 1; //POSSO MUDAR A FORCA. N SEI SE ESSA É A IDEAL
                break;
            case "recurvo":
                forcaArco = 4;
                break;
            case "composto":
                forcaArco = 6;
                break;
            default:
                break;
        }
    }
}