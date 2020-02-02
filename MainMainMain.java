package pacott;
import java.util.Scanner;
public class MainMainMain {
        public static void main(String[] args) {
            Scanner teclado = new Scanner(System.in);
            Arco arc1 = new Arco();
            Inventario inv1 = new Inventario(arc1);
                inv1.ganharOuro(30); //Já sai ganhando 30 gold
            Loja loj1 = new Loja(inv1);
            System.out.println("Qual é o seu nome?");
            String nome = teclado.nextLine();
            Personagem p1 = new Personagem(nome);
            Stand std1 = new Stand(inv1, p1);
            Floresta flo1 = new Floresta(p1, inv1);
            System.out.println("Bem vindo, " + p1.getNome() + "!");
            int opc;
            do{
                System.out.println("\nMENU  -  Escolha uma opção:\n[1] Acessar a loja;\n[2] Praticar tiro ao alvo;\n"+
               "[3] Ir caçar na floresta;\n[4] Seus itens;\n[5] Seu status;\n[6] Sair do jogo.");
                opc = teclado.nextInt();
                switch(opc){
                    case 1:
                        loj1.entrarNaLoja();
                        break;
                    case 2:
                        if(inv1.getArcoAtual()==null){
                            System.out.println("Você está sem arco para ir ao stand!");
                        }else if(inv1.getMoedasOuro() >= 50){
                            System.out.println("Taxa para treinar no stand: 50 moedas de ouro. Gostaria de entrar? [S / N]");
                            char opc2;
                            do{
                                opc2 = teclado.next().charAt(0);
                                if(opc2 != 'S' && opc2 != 's' && opc2 != 'N' && opc2 != 'n'){
                                    System.out.print("Digito inválido! Responda novamente: ");
                                }   
                            }while(opc2 != 's' && opc2 != 'S' && opc2 != 'n' && opc2 != 'N');
                            if(opc2 == 'S' || opc2 == 's'){
                                inv1.gastarOuro(50);
                                std1.tiro();
                            }
                        }else{
                            System.out.println("Taxa para treinar no stand: 50 moedas de ouro. Você não tem dinheiro suficiente!");
                        }
                        break;
                    case 3:
                        if(inv1.getArcoAtual() == null){
                            System.out.println("Você está sem arco para caçar!!");
                        }else{
                            flo1.naFloresta();
                        }
                        break;
                    case 4:
                        System.out.println("Você tem "+inv1.getMoedasOuro()+" moedas de ouro.");
                        if(inv1.getArcoAtual()==null){
                            System.out.println("Você está sem arco!");
                        } else{
                            System.out.println("Seu arco é do modelo "+inv1.getArcoAtual().getModeloArco());
                        }
                        System.out.println("Flechas: você tem\n"+ inv1.getFlechasMadeira().getQtdFlechas()+" flechas de madeira;\n"
                        +inv1.getFlechasVidro().getQtdFlechas()+" flechas de vidro;\n" + inv1.getFlechasInox().getQtdFlechas()+" flechas de Inox;\n"
                        +inv1.getFlechasObsidiana().getQtdFlechas()+" flechas de obsidiana;\n");
                        break;
                    case 5:
                        System.out.println("Você tem " + p1.getExp() + " de experiencia e é nível " + p1.getNivel()+"."+
                           " Falta "+(100 - p1.getPorcentNiv())+ "% para subir de nível.\nSeu skill com arco é " + p1.getHabilidade() + 
                                " e falta "+(100-p1.getPorcentHab())+"% para "
                        + "o próximo nível.\nVocê tem " + p1.getVida() + "/"+p1.getVidaTotal()+" de vida.");
                        break;
                    case 6:
                        System.out.println("Tem certeza que quer sair do jogo? [S / N]");
                        char sair;
                        do{
                            sair = teclado.next().charAt(0);
                            if(sair != 's' && sair != 'S' && sair != 'n' && sair != 'N'){
                                System.out.println("Digito inválido! Responda novamente:");
                            }
                        }while(sair != 's' && sair != 'S' && sair != 'n' && sair != 'N');
                        opc = (sair == 's' || sair == 'S')?6:0;
                        break;
                    default:
                        System.out.println("Digito inválido!");
                }
            }while(opc != 6);
            System.out.println("Até logo!");
        }
}
