package pacott.criaturas;
import pacott.Criaturas;

public class Demonhozinho extends Criaturas {
    public Demonhozinho(){
        setNome("Demonhozinho");
        setVidaTotal(70);
        setVida(getVidaTotal());
        setPoder(30);
        setGrunhidos("MuaHAhahAhaha","Vou puxar seu pé enquanto dorme!!","Salve Edir Macedo!");
        setNumCriatura(30);
        setLootGold();
//Loot e exp calculados de acordo com o poder da criatura x numero aleatório
        setExpDada(); 
    }
}
