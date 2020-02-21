package pacott;
import pacott.criaturas.*; //Importando todas as classes do pacote de criaturas

import java.util.Scanner;
public class Floresta {
    private final int numTotalDeCriaturas = 10; //Esse numero pode mudar conforme mais forem criadas
    private Criaturas listaCriaturas[] = new Criaturas[numTotalDeCriaturas];
    private Personagem p1; 
    private Flechas f1;
    private Criaturas c1;//Objeto de uma super-classe abstrata. Será que recebe qualquer objeto de classe ancestral?
    private Inventario i1;
    Scanner teclado = new Scanner(System.in);
    
    
    public Floresta(Personagem p1, Inventario i1){ //FAZER A CHAMADA EM MAIN
        this.p1 = p1;
        this.i1 = i1;
        //Teste para reduzir o numero de if's na hora de escolher a criatura aleatória:
        listaCriaturas[0] = new Rato(); // E se a classe Rato ter mais que o q Criaturas tem? Poderei usar tais metodos?
        listaCriaturas[1] = new Troll();
        listaCriaturas[2] = new Orc();
        listaCriaturas[3] = new Dwarf();
        listaCriaturas[4] = new Minotauro();
        listaCriaturas[5] = new GadoFurioso();
        listaCriaturas[6] = new Demonhozinho();
        listaCriaturas[7] = new Dragao();
        listaCriaturas[9] = new WildPauloKogos();
        listaCriaturas[8] = new DragaoAnciao();
    }
    public void naFloresta(){
        System.out.println("Bem-vindo à floresta!");
        System.out.println("Ande esperto... escolha o tipo de flecha para armar o arco:");
        trocarFlechas();
        int resp;
        do{
            System.out.println("O que você fará agora?\n[1] Andar pela floresta...\n[2] Dar o fora!\n[3] Consultar status.");
            do{
               resp = teclado.nextInt();
               if(resp != 1 && resp != 2 && resp != 3){
                   System.out.println("Digito invalido! Responda novamente:");
               }
            }while(resp != 1 && resp != 2 && resp != 3);
            if(resp == 1){
                c1 = getCriatura();
                FlorestaBatalha batalha = new FlorestaBatalha(p1, f1, c1, i1);
                resp = batalha.batalha();
            }else if(resp == 3){
                System.out.println("Vida: "+p1.getVida()+"/"+p1.getVidaTotal()+"\nNivel: "+p1.getNivel()+" - Skill de arqueria: "+p1.getHabilidade()+
                        "\nFlechas de "+f1.getModeloFlecha()+" disponíveis: "+f1.getQtdFlechas()+
                        "\nPoções mágicas disponíveis: Comuns: "+i1.getPocaoMagica()+" - Super: "+i1.getSuperPocaoMagica());
            }
        }while(resp != 2);
    }
    private Criaturas getCriatura(){
        int numRand;
        numRand = (int)(p1.getNivel() * (10 * Math.random()));
        for(int c = 0; c < numTotalDeCriaturas; c++){
            if(numRand <= listaCriaturas[c].getNumCriatura()){
                listaCriaturas[c].setVida(listaCriaturas[c].getVidaTotal()); //Como vai utilizar sempre a mesma criatura, devo renovar a vida sempre
                return listaCriaturas[c];
            } 
        }
        //Se não retornar nada...
        listaCriaturas[numTotalDeCriaturas -1].setVida(listaCriaturas[numTotalDeCriaturas -1].getVidaTotal());
        return listaCriaturas[numTotalDeCriaturas - 1]; // a criatura mais poderosa, a última
        }
    
    private int acaoDoBicho(){
        int dano;
        dano = (int)(c1.getPoder() * (float)Math.random());
        System.out.println(c1.getNome()+": "+c1.getGrunhidos());
        p1.setVida(p1.getVida() - dano); //Ele te ataca
        if(p1.getVida() < 0){
            p1.setVida(0);
        }
        System.out.println("Você tomou "+dano+" de dano do "+c1.getNome()+".\nSua vida: "+p1.getVida()+"/"+p1.getVidaTotal());
        if(p1.getVida() <= 0){
            System.out.println("Você morreu!");
            if(p1.getNivel() > 1){ //Você perde exp apenas se for lvl maior que 1.
                int perdaExp;
                perdaExp = (p1.getNivel() * 100)/2; //Perdendo 60% da exp do nivel. Cada nivel precisa de 100*getNivel() para upar
                p1.setExp(p1.getExp() - perdaExp);
                if(p1.getExp() < p1.getExpDesseNivel()){
                    p1.quedaNivel(); //Cai de nivel
                    p1.downVidaTotal();
                    System.out.println("Você perdeu "+perdaExp+" pontos de experiência e caiu para o nível "+p1.getNivel()+".");
                } else{
                    System.out.println("Você perdeu "+perdaExp+" pontos de experiência e está no nível "+p1.getNivel()+".");
                }
            }
            p1.setVida(p1.getVidaTotal());
            System.out.println("Renascendo no templo...");
            return 0;
        }else{ //0 morto, 1 vivo
            return 1;
        }
    }
    private void trocarFlechas(){
        System.out.println(" TIPO  - QUANTIDADE\n[1] Madeira: "+i1.getFlechasMadeira().getQtdFlechas()+"\n[2] Vidro: "+
                    i1.getFlechasVidro().getQtdFlechas()+"\n[3] Inox: "+i1.getFlechasInox().getQtdFlechas()+"\n[4] Obsidiana: "+
                    i1.getFlechasObsidiana().getQtdFlechas());
            int opc;
            do{
                opc = teclado.nextInt();
                if(opc > 4 || opc < 1){
                    System.out.println("Digito inválido! Digite novamente:");
                }
            }while(opc > 4 || opc < 1);
            switch(opc){
                case 1:
                    f1 = i1.getFlechasMadeira();
                    break;
                case 2:
                    f1 = i1.getFlechasVidro();
                    break;
                case 3:
                    f1 = i1.getFlechasInox();
                    break;
                case 4:
                    f1 = i1.getFlechasObsidiana();
                    break;
            }
            if(f1.getQtdFlechas() < 1){
                System.out.println("Você não tem flechas de "+f1.getModeloFlecha()+" no seu inventário...");
            } else{
                System.out.println("Flecha escolhida! Você está usando a de " + f1.getModeloFlecha()+"!");
            }
    }
}
