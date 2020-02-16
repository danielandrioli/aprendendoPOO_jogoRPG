package pacott.criaturas;
import pacott.Criaturas;

public class Minotauro extends Criaturas {
    public Minotauro(){
        setNome("Minotauro");
        setVidaTotal(50);
        setVida(getVidaTotal());
        setPoder(20);
        setGrunhidos("Kaplar!","MUUUUUHhhhh","mmmmmmmMUUUUUUUUUUUH");
        setNumCriatura(25);
        setLootGold();
//Loot e exp calculados de acordo com o poder da criatura x numero aleatório
        setExpDada(); 
    }
}
