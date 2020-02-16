package pacott.criaturas;
import pacott.Criaturas;

public class GadoFurioso extends Criaturas {
    public GadoFurioso(){
        setNome("Gado Furioso");
        setVidaTotal(60);
        setVida(getVidaTotal());
        setPoder(25);
        setGrunhidos("Saudades da ditadura!!","Mas sem impostos, quem construiria as estradas??",
                "Olha só, um neo-liberalzinho! Toma essa!");
        setNumCriatura(25);
        setLootGold();
//Loot e exp calculados de acordo com o poder da criatura x numero aleatório
        setExpDada(); 
    }
}
