package pacott;
import java.util.Scanner;
import pacott.criaturas.*; //Importando todas as classes do pacote de criaturas

public class FlorestaBatalha {
    private Personagem p1; 
    private Flechas f1;
    private Criaturas c1;//Objeto de uma super-classe abstrata. Será que recebe qualquer objeto de classe ancestral?
    private Inventario i1;
    Scanner teclado = new Scanner(System.in);
    
    public FlorestaBatalha(Personagem p1, Flechas f1, Criaturas c1, Inventario i1){
        this.p1 = p1;
        this.f1 = f1;
        this.c1 = c1;
        this.i1 = i1;
    }
    public int batalha(){//Retorno: 1 vivo, 2 morto
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
                            return 2;
                        }//Se morreu durante a luta, retorna 2
                    }
                    break;
                case 2:
                    trocarFlechas(); //Apos trocar as flechas, seu turno passou e a criatura te ataca
                    if(acaoDoBicho() == 0){
                        return 2;
                    } 
                    break;
                case 3:
                    System.out.println("Qual você gostaria de usar?\n[1] Pocão mágica comum - [2] Super pocão mágica.");
                    int respoPocao;
                    do{
                        respoPocao = teclado.nextInt();
                        if(respoPocao != 1 && respoPocao != 2){
                            System.out.println("Digito invalido! Responda novamente!");
                        }
                    }while(respoPocao != 1 && respoPocao != 2);
                    if(respoPocao == 1){
                        if(i1.getPocaoMagica() > 0){//Se houver pocao magica no inventario...
                            tomarPocaoMagica();
                            if(acaoDoBicho() == 0){
                                return 2;
                            }
                        }else{
                            System.out.println("Você não tem poção mágica comum!"); //sem DanoDoBicho() aqui
                        }
                    }else{
                      if(i1.getSuperPocaoMagica() > 0){//Se houver pocao magica no inventario...
                          tomarSuperPocao();
                          if(acaoDoBicho() == 0){
                               return 2;
                            }
                        }else{
                            System.out.println("Você não tem super poção mágica!"); //sem DanoDoBicho() aqui
                        }  
                    }
                    break;
                case 4:
                    System.out.println("Cooooooorrre!");
                    if(acaoDoBicho() == 0){ //Se morrer, o retorno é 0 e já saio do switch e da Floresta.
                        return 2;
                    }else{
                       System.out.println("Você fugiu da criatura e está são e salvo!"); 
                    }
                    break;
                default:
                    System.out.println("Digito inválido!");
            }
        }while(opc != 4);
        return 1;
    }
    
    private int getFormulaSeuDano(){ //MUDAR?? VER SE ESTÁ OK...
        int formulaDano = (int)((float)Math.random()* (p1.getNivel() + p1.getHabilidade()) * (i1.getArcoAtual().getForcaArco() + f1.getForcaFlecha()));
        return formulaDano;
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
    private void tomarPocaoMagica(){
        i1.setPocaoMagica(i1.getPocaoMagica() -1);
        p1.setVida(p1.getVida() + (int)(20 + (float)Math.random()*10)); //Pocao magica comum recupera de 20 a 30 de vida (fazer a super)
        if(p1.getVida() > p1.getVidaTotal()){
            p1.setVida(p1.getVidaTotal());
        }
        System.out.println("Sente-se melhor? Sua vida agora: "+p1.getVida()+"/"+p1.getVidaTotal());
    }
    private void tomarSuperPocao(){
         i1.setSuperPocaoMagica(i1.getSuperPocaoMagica() -1);
        p1.setVida(p1.getVida() + (int)(40 + (float)Math.random()*15)); //Pocao magica comum recupera de 20 a 30 de vida (fazer a super)
        if(p1.getVida() > p1.getVidaTotal()){
            p1.setVida(p1.getVidaTotal());
        }
        System.out.println("Sente-se melhor? Sua vida agora: "+p1.getVida()+"/"+p1.getVidaTotal());
    }
}
