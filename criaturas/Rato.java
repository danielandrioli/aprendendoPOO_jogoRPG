package pacott.criaturas;
import pacott.Criaturas;

public class Rato extends Criaturas{
    public Rato(){
        setNome("Rato");
        setVidaTotal(15);
        setVida(getVidaTotal());
        setPoder(4);
        setGrunhidos("Meeeeeep","Meeep meep meep","Meep");
        setNumCriatura(5);
        setLootGold();
//Loot e exp calculados de acordo com o poder da criatura x numero aleatório
        setExpDada(); 
    }
}
