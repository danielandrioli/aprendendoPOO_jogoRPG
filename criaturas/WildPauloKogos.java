package pacott.criaturas;
import pacott.Criaturas;

public class WildPauloKogos extends Criaturas{
    public WildPauloKogos(){
        setNome("Wild Paulo Kogos");
        setVidaTotal(130);
        setVida(getVidaTotal());
        setPoder(45);
        setGrunhidos("PARA TRÁS, INDITOSO ESQUERDISTA!","PARASITA DO CARALHO!!!","Deus vult!");
        setNumCriatura(40);
        setLootGold();
//Loot e exp calculados de acordo com o poder da criatura x numero aleatório
        setExpDada(); 
    }
}
