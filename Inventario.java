package pacott;
public class Inventario {
    private int moedasOuro =0;
    private Arco a1;
    private Flechas[] f1 = new Flechas[4]; 
//0 para flechas de madeira - 1 para de vidro - 2 inox - 3 obsidiana
    public Inventario(Arco a1) {
        this.a1 = a1;
        a1.setModeloArco("artesanal");  //Inicia-se com um arco artesanal
        for(int c = 0; c < 4; c++){
            f1[c] = new Flechas(); //Cada slot de objeto deve ser criado.
            f1[c].setQtdFlechas(0); //Todos slots de flechas iniciam com 0 quantidades
        }
        f1[0].setModeloFlecha("madeira");
        f1[1].setModeloFlecha("vidro");
        f1[2].setModeloFlecha("inox");
        f1[3].setModeloFlecha("obsidiana");
    }
    ////////OURO
    public void ganharOuro(int gold){
        moedasOuro += gold;
    }
    public void gastarOuro(int gold){
        moedasOuro -= gold;
    }
    public int getMoedasOuro(){
        return moedasOuro;
    }
    ////////ARCO
    public Arco getArcoAtual(){
        return a1;
    }
    public void setArcoAtual(Arco novoArco){
        a1 = novoArco;
    }
    ////////FLECHAS
    public void setFlechasAtuais(Flechas novaFlecha){
        
    }
    public Flechas getFlechasMadeira(){
        return f1[0]; 
    }
    public Flechas getFlechasVidro(){
        return f1[1];
    }
    public Flechas getFlechasInox(){
        return f1[2];
    }
    public Flechas getFlechasObsidiana(){
        return f1[3];
    }
}
