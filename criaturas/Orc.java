package pacott.criaturas;
import pacott.Criaturas;

public class Orc extends Criaturas {
    public Orc(){
        setNome("Orc");
        setVidaTotal(35);
        setVida(getVidaTotal());
        setPoder(12);
        setGrunhidos("Graaak zuurk!","GgRaaaR arR ar!","RAAAAAr!");
        setNumCriatura(15);
        setLootGold();
//Loot e exp calculados de acordo com o poder da criatura x numero aleatório
        setExpDada(); 
    }
}
