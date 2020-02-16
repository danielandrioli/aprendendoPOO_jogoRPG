package pacott.criaturas;
import pacott.Criaturas;

public class Dragao extends Criaturas {
    public Dragao(){
        setNome("Dragao");
        setVidaTotal(90);
        setVida(getVidaTotal());
        setPoder(40);
        setGrunhidos("FFfChhhhhhhhh","GraAAAAAAAAArrr","Fchchhhhhhhhhhhhhhhhhhhhhhhhhhhhhhh");
        setNumCriatura(35);
        setLootGold();
//Loot e exp calculados de acordo com o poder da criatura x numero aleatório
        setExpDada(); 
    }
}
