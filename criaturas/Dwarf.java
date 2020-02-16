package pacott.criaturas;
import pacott.Criaturas;

public class Dwarf extends Criaturas {
    public Dwarf(){
        setNome("Dwarf");
        setVidaTotal(40);
        setVida(getVidaTotal());
        setPoder(15);
        setGrunhidos("Hail Durin!","HgRoar!! Renda-se! Anões dominarão o mundo!","GrAAah! Prepare-se para um golpe baixo!");
        setNumCriatura(20);
        setLootGold();
//Loot e exp calculados de acordo com o poder da criatura x numero aleatório
        setExpDada(); 
    }
}
