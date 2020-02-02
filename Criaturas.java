package pacott;
public class Criaturas {
    private int vida;
    private int vidaTotal;
    private String nome;
    private int poder;
    private String grunhidos[] = new String[3]; //Cada criatura terá 4 grunhidos
    private int lootGold; //LOOT GOLD SERÁ UM NUMERO. NA CLASSE FLORESTA, ASSIM Q A CRIATURA MORRER, ESSE NUMERO SERÁ MULTIPLICADO POR math.random*10 E DARA O EQUIVALENTE EM GOLD. MAIOR O NUMERO, MAIS CHANCES DE MAIS GOLD
    private int expDada;
    
    public Criaturas getCriatura(int numRand){/*Recebe um numero. Quanto maior, mais dificil a criatura
    Esse numero será calculado levando o nível do personagem em conta. Maior, mais facil aparecer criatura dificil! */
    // (Math.random() * 10) * nivel
    if(numRand <= 5){
        Criaturas rato = new Criaturas(); //DA PRA CRIAR CLASSE DA PROPRIA CLASSE?? SERA Q VAI DAR CERTO?
        rato.nome = "Rato";     //Se nao der, faço recorto esse metodo para a classe Floresta (q criarei)
        rato.vidaTotal = 15;
        rato.vida = rato.vidaTotal;
        rato.poder = 6;
        rato.grunhidos[0] = "Meeeeeep";
        rato.grunhidos[1] = "Meeep meep meep";
        rato.grunhidos[2] = "Meep"; //CRIAR UM IF ANIMAL.GRUNHIDOS !EQUALS A "", ENTAO MANDA ELE FALAR
        rato.lootGold = (int)(2 * ((float)Math.random() * 10));
        rato.expDada = 20;
        return rato;
    } else if(numRand <= 10){
        Criaturas troll = new Criaturas();
            troll.nome = "Troll";
            troll.vidaTotal = 25;
            troll.vida = troll.vidaTotal;
            troll.poder = 10;
            troll.grunhidos[0] = "Gruntzz";
            troll.grunhidos[1] = "Grooaarr";
            troll.grunhidos[2] = "hmmm, bug!";
            troll.lootGold = (int)(3 * ((float)Math.random() * 10));
            troll.expDada = 30;
            return troll;
        } else if(numRand <= 15){
            Criaturas orc = new Criaturas();
            orc.nome = "Orc";
            orc.vidaTotal = 35;
            orc.vida = orc.vidaTotal;
            orc.poder = 15;
            orc.grunhidos[0] = "Graaak zuurk!";
            orc.grunhidos[1] = "GgRaaaR arR ar!";
            orc.grunhidos[2] = "RAAAAAr";
            orc.lootGold = (int)(4 * ((float)Math.random() * 10));
            orc.expDada = 45;
            return orc;
        } else if(numRand <= 20){
            Criaturas dwarf = new Criaturas();
            dwarf.nome = "Dwarf";
            dwarf.vidaTotal = 40;
            dwarf.vida = dwarf.vidaTotal;
            dwarf.poder = 18;
            dwarf.grunhidos[0] = "Hail Durin!";
            dwarf.grunhidos[1] = "HgRoar!! Renda-se! Anões dominarão o mundo!";
            dwarf.grunhidos[2] = "GrAAah! Prepare-se para um golpe baixo!";
            dwarf.lootGold = (int)(5 * ((float)Math.random() * 10));
            dwarf.expDada = 60;
            return dwarf;
         } else if(numRand <= 25){
             Criaturas minotauro = new Criaturas();
             minotauro.nome = "Minotauro";
             minotauro.vidaTotal = 50;
             minotauro.vida = minotauro.vidaTotal;
             minotauro.poder = 22;
             minotauro.grunhidos[0] = "Kaplar!";
             minotauro.grunhidos[1] = "MUUUUUHhhhhh";
             minotauro.grunhidos[2] = "mmmmmmmMUUUUUUUUUUUH";
             minotauro.lootGold = (int)(7 * ((float)Math.random() * 10));
             minotauro.expDada = 80;
             return minotauro;
         } else 
            return null; //quando já ter criado criaturas o suficiente, apagar essa parte. O programa fica chiando até o último else ter return
    }

    public int getVida() {
        return vida;
    }
    public void setVida(int vida){
        this.vida = vida;
    }
    public int getVidaTotal() {
        return vidaTotal;
    }
    public String getNome() {
        return nome;
    }
    public int getPoder() {
        return poder;
    }
    public String getGrunhidos() {
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
    public int getLootGold() {
        return lootGold;
    }
    public int getExpDada() {
        return expDada;
    }
}


