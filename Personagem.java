package pacott;
public class Personagem {
    private int vida;
    private int vidaTotal;
    private int exp;
    private int expNivelAnterior; //Experiencia do nivel anterior
    private int nivel;
    private int habilidade;
    private float porcentHabilidade; //Quando chega em 100, a habilidade aumenta 1
    private float porcentNivel; //nova
    private String nome;
    private final int UPVIDA = 5; //A cada "up" de nível, esse número soma-se ao limite total de vida
    
    public Personagem(String nome){
        vidaTotal = 50;
        vida = vidaTotal;
        exp = 0;
        expNivelAnterior = 0;
        nivel = 1;
        habilidade = 1;
        porcentHabilidade = 0;
        this.nome = nome;
    }
    //VIDA
    public void setVida(int vida){
        this.vida = vida;
    }
    public int getVida(){
        return vida;
    }
    private void upVidaTotal(){
        vidaTotal = vidaTotal + UPVIDA;
        setVida(getVida() + UPVIDA);
    }
    public int getVidaTotal(){
        return vidaTotal;
    }
    //EXP
    public void setExp(int exp){
        this.exp = exp;
        if(exp - expNivelAnterior >= 100 * getNivel()){ //A cada nivel fica mais difícil de chegar ao próximo
            expNivelAnterior = 100 * getNivel(); //Setando a exp do nivel anterior antes de upar nivel
            setNivel(getNivel() + 1);
            System.out.println("Parabéns! Você avançou para o nível "+getNivel()+"!");
            upVidaTotal();
        }
    }
    public int getExp(){
        return exp;
    }
    //NIVEL
    private void setNivel(int nivel){
        this.nivel = nivel;
    }
    public int getNivel(){
        return nivel;
    }
    //PORCENTAGEM DO NÍVEL 
    public float getPorcentNiv(){
        porcentNivel = (float)(exp - expNivelAnterior)/(100 * getNivel()) * 100;
        return porcentNivel;
    }
    //HABILIDADE
    private void setHabilidade(int habil){
        this.habilidade = habil;
    }
    public int getHabilidade(){
        return habilidade;
    }
    //PORCENTAGEM DA HABILIDADE
    public void setPorcentHab(float porce){
        this.porcentHabilidade = porce;
        if(porcentHabilidade >= 100){
            setHabilidade(getHabilidade() +1);
            System.out.println("Parabéns! Você avançou a skill de arqueria! Seu skill: " + getHabilidade());
            porcentHabilidade = porcentHabilidade -100; //Retorna ao começo 
        }
    }
    public float getPorcentHab(){
        return porcentHabilidade;
    }
    //NOME
    public String getNome(){
        return nome;
    }
}
