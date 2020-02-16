package pacott.criaturas;
import pacott.Criaturas;

public class Troll extends Criaturas{
    public Troll(){
        setNome("Troll");
        setVidaTotal(25);
        setVida(getVidaTotal());
        setPoder(6);
        setGrunhidos("Gruntzz","Grooaarr","hmmm, bug!");
        setNumCriatura(10);
        setLootGold();
//Loot e exp calculados de acordo com o poder da criatura x numero aleatório
        setExpDada(); 
    }
}
