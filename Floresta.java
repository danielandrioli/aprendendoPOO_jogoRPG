package pacott;
import java.util.Scanner;
public class Floresta {
    private Personagem p1;
    private Flechas f1;
    private Criaturas c1;
    private Inventario i1;
    Scanner teclado = new Scanner(System.in);
    
    public Floresta(Personagem p1, Inventario i1){ //FAZER A CHAMADA EM MAIN
        this.p1 = p1;
        this.i1 = i1;
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
                c1 = new Criaturas().getCriatura((int)(p1.getNivel() * (10 * Math.random())));
                int opc;
                System.out.println("Você está andando pela floresta, e de repente...\nUm "+c1.getNome()+" aparece na sua frente!");
            //mostrar status dele e as opcoes q o personagem tem
                System.out.println(c1.getVida()+"/"+c1.getVidaTotal()+" de vida.");
                System.out.println(c1.getNome()+": "+c1.getGrunhidos());
                System.out.println("O que você deseja fazer?\n");
                do{
                    System.out.println("Flechas de "+f1.getModeloFlecha()+": "+f1.getQtdFlechas());
                    System.out.println("[1] Atacar - [2] Trocar flechas - [3] Usar pocao magica - [4] Fugir.");
                    do{
                        opc = teclado.nextInt();
                        if(opc < 1 || opc > 4){
                            System.out.println("Digito inválido! Responda novamente:");
                        }
                    } while(opc < 1 || opc > 4);
                    switch(opc){
                        case 1:
                            int seuDano;
                            //FAZER
                            //Formula de dano com arco + flecha + skill + nivel

                            if(f1.getQtdFlechas() > 0){
                                i1.getArcoAtual().setCarregar(true);
                                i1.getArcoAtual().atirar();
                                f1.setQtdFlechas(f1.getQtdFlechas() - 1);
                                seuDano = getFormulaSeuDano();
                                p1.setPorcentHab();//EVOLUINDO SKILL A CADA TIRO
                                c1.setVida(c1.getVida() - seuDano);
                                if(c1.getVida() < 0){
                                    c1.setVida(0);
                                }
                                System.out.println("Você causou "+seuDano+" de dano no "+c1.getNome()+". Vida: "+c1.getVida()+"/"+c1.getVidaTotal());
                                p1.setPorcentHab(); //Avança um pouco de skill a cada pancada no bicho!
                            }else{
                                System.out.println("Você não tem flechas de "+f1.getModeloFlecha()+" suficientes! Escolha outra ou fuja!");
                            }                    
                            if(c1.getVida() <= 0){
                                System.out.println("Você matou o "+c1.getNome()+" e recebeu "+c1.getExpDada()+" de experiência!");
                                p1.setExp(p1.getExp() + c1.getExpDada());
                                System.out.println("Sua experiência agora: "+p1.getExp());
                                System.out.println("Loot: "+c1.getLootGold()+" moedas de ouro.");
                                i1.ganharOuro(c1.getLootGold());
                                opc = 4; //Aí sai da batalha
                            }else{
                                if(acaoDoBicho() == 0){
                                    opc = 4;
                                    resp = 2;
                                }//Se morreu durante a luta, opc recebe 4 e entao sai da floresta
                            }
                            break;
                        case 2:
                            trocarFlechas(); //Apos trocar as flechas, seu turno passou e a criatura te ataca
                            if(acaoDoBicho() == 0){
                                opc = 4;
                                resp = 2;
                            } 
                            break;
                        case 3:
                            if(i1.getPocaoMagica() > 0){//Se houver pocao magica no inventario...
                                //fazer a formula para aumento de vida
                                if(acaoDoBicho() == 0){
                                    opc = 4;
                                    resp = 2;
                                }
                            }else{
                                System.out.println("Você não tem poção mágica!"); //sem DanoDoBicho() aqui
                            }
                            break;
                        case 4:
                            System.out.println("Cooooooorrre!");
                            if(acaoDoBicho() == 0){
                                opc = 4;
                                resp = 2;
                            }else{
                               System.out.println("Você fugiu da criatura e está são e salvo!"); 
                            }
                            break;
                        default:
                            System.out.println("Digito inválido!");
                    }
                }while(opc != 4);
            }else if(resp == 3){
                System.out.println("Vida: "+p1.getVida()+"/"+p1.getVidaTotal()+"\nSkill de arqueria: "+p1.getHabilidade()+
                        "\nFlechas de "+f1.getModeloFlecha()+" disponíveis: "+f1.getQtdFlechas()+
                        "\nPoções mágicas disponíveis: FAZER");
            }
        }while(resp != 2);
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
                    setFlechas(i1.getFlechasMadeira());
                    break;
                case 2:
                    setFlechas(i1.getFlechasVidro());
                    break;
                case 3:
                    setFlechas(i1.getFlechasInox());
                    break;
                case 4:
                    setFlechas(i1.getFlechasObsidiana());
                    break;
            }
            if(f1.getQtdFlechas() < 1){
                System.out.println("Você não tem flechas de "+f1.getModeloFlecha()+" no seu inventário...");
            } else{
                System.out.println("Flecha escolhida! Você está usando a de " + f1.getModeloFlecha()+"!");
            }
    }
    private void setFlechas(Flechas f1){
        this.f1 = f1;
    }
    private int getFormulaSeuDano(){ //MUDAR?? VER SE ESTÁ OK...
        int formulaDano = (int)((float)Math.random()* (p1.getNivel() + p1.getHabilidade()) * (i1.getArcoAtual().getForcaArco() + f1.getForcaFlecha()));
        return formulaDano;
    }
}
