package pacott;
public abstract class Criaturas {
    private int vida;
    private int vidaTotal;
    private String nome;
    private int poder;
    private String grunhidos[] = new String[3]; //Cada criatura terá 4 grunhidos
    private int lootGold; //LOOT GOLD SERÁ UM NUMERO. NA CLASSE FLORESTA, ASSIM Q A CRIATURA MORRER, ESSE NUMERO SERÁ MULTIPLICADO POR math.random*10 E DARA O EQUIVALENTE EM GOLD. MAIOR O NUMERO, MAIS CHANCES DE MAIS GOLD
    private int expDada;
    private int numCriatura;
    
    /*
    public Criaturas getCriatura(int numRand){/*Recebe um numero. Quanto maior, mais dificil a criatura
    Esse numero será calculado levando o nível do personagem em conta. Maior, mais facil aparecer criatura dificil! 
    // (Math.random() * 10) * nivel
    if(numRand <= 5){
        Rato rato = new Rato(); 
        return rato;
    } else if(numRand <= 10){
        Criaturas troll = new Criaturas();
            troll.expDada = 30;
            return troll;
        } else if(numRand <= 15){
            Criaturas orc = new Criaturas();
            orc.expDada = 45;
            return orc;
        } else if(numRand <= 20){
            Criaturas dwarf = new Criaturas();
            dwarf.expDada = 60;
            return dwarf;
         } else if(numRand <= 25){
             Criaturas minotauro = new Criaturas();
             return minotauro;
         } else if(numRand <= 30){
             Criaturas demonhozinho = new Criaturas();
             return demonhozinho;
         } else if(numRand <= 35){
             Criaturas dragao = new Criaturas();
             return dragao;
         } else{
             Criaturas dragaoAnciao = new Criaturas();
             return dragaoAnciao;
         }
         
    }
*/
    public final int getVida() {
        return vida;
    }
    public final void setVida(int vida){
        this.vida = vida;
    }
    public final int getVidaTotal() {
        return vidaTotal;
    }
    public final void setVidaTotal(int vidaTotal){
        this.vidaTotal = vidaTotal;
    }
    public final String getNome() {
        return nome;
    }
    public final void setNome(String nome){
        this.nome = nome;
    }
    public final int getPoder() {
        return poder;
    }
    public final void setPoder(int poder){
        this.poder = poder;
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
    public final void setGrunhidos(String g1, String g2, String g3){
        this.grunhidos[0] = g1;
        this.grunhidos[1] = g2;
        this.grunhidos[2] = g3;
    }
    public final int getLootGold() {
        return lootGold;
    }
    public final  int getExpDada() {
        return expDada;
    }
    protected void setExpDada(){ //Experiência e gold calculados de acordo com o poder da criatura
        this.expDada = getPoder() * 4;
    }
    public int getNumCriatura(){
        return numCriatura;
    }
    protected void setNumCriatura(int numCriatura){
        this.numCriatura = numCriatura;
    }
    protected void setLootGold(){
        this.lootGold = (int)((this.getPoder() -2) * ((float)Math.random() * 5));
    }
}


