package pacott.criaturas;
import pacott.Criaturas;

public class DragaoAnciao extends Criaturas {
    public DragaoAnciao(){
        setNome("Dragão Ancião");
        setVidaTotal(140);
        setVida(getVidaTotal());
        setPoder(55);
        setGrunhidos("Sua alma é minha!","Hummm, chegou a janta!","FccHcchcHchhhhhhh");
        setNumCriatura(50);
        setLootGold();
//Loot e exp calculados de acordo com o poder da criatura x numero aleatório
        setExpDada(); 
    }
}
