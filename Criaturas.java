package pacott;
public abstract class Criaturas {
    private int vida;
    private final int vidaTotal;
    private final String nome;
    private final int poder;
    private final String grunhidos[] = new String[3]; //Cada criatura terá 4 grunhidos
    private int lootGold; //LOOT GOLD SERÁ UM NUMERO. NA CLASSE FLORESTA, ASSIM Q A CRIATURA MORRER, ESSE NUMERO SERÁ MULTIPLICADO POR math.random*10 E DARA O EQUIVALENTE EM GOLD. MAIOR O NUMERO, MAIS CHANCES DE MAIS GOLD
    private int expDada;
    private final int numCriatura;
    
    public Criaturas(String nome,int vidaTotal,int poder,int numCriatura, String g1, String g2, String g3){
        this.nome = nome;
        this.vida = vidaTotal;
        this.vidaTotal = vidaTotal;
        this.poder = poder;
        this.numCriatura = numCriatura;
        this.grunhidos[0] = g1;
        this.grunhidos[1] = g2;
        this.grunhidos[2] = g3;
        setLootGold();
        setExpDada();
    }
    public final int getVida() {
        return vida;
    }
    public final void setVida(int vida){
        this.vida = vida;
    }
    public final int getVidaTotal() {
        return vidaTotal;
    }
    public final String getNome() {
        return nome;
    }
    public final int getPoder() {
        return poder;
    }
    public final String getGrunhidos() {
        float rando;
        rando = (float) (10 * Math.random());
        if(rando <=4){
            return grunhidos[0];
        } else if(rando <= 8){
            return grunhidos[1];
        }else{
            return grunhidos[2];
        }
    }
    public final int getLootGold() {
        return lootGold;
    }
    public final  int getExpDada() {
        return expDada;
    }
    private void setExpDada(){ //Experiência e gold calculados de acordo com o poder da criatura
        this.expDada = getPoder() * 4;
    }
    public int getNumCriatura(){
        return numCriatura;
    }
    private void setLootGold(){
        this.lootGold = (int)((this.getPoder() -2) * ((float)Math.random() * 5));
    }
}


