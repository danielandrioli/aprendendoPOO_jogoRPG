package pacott;
import java.util.Scanner;
public class MainMainMain {
        public static void main(String[] args) {
            Scanner teclado = new Scanner(System.in);
            Arco arc1 = new Arco();
            Inventario inv1 = new Inventario(arc1);
                inv1.ganharOuro(30); //Já sai ganhando 30 gold
            Loja loj1 = new Loja(inv1);
            TiroAoAlvo tir1 = new TiroAoAlvo(inv1);
            System.out.println("Bem vindo!");
            int opc;
            do{
                System.out.println("Escolha uma opção:\n[1] Acessar a loja;\n[2] Praticar tiro ao alvo;\n"
                        + "[3] Seu status;\n[4] Sair do jogo.");
                opc = teclado.nextInt();
                switch(opc){
                    case 1:
                        loj1.entrarNaLoja();
                        break;
                    case 2:
                        if(inv1.getArcoAtual()==null){
                            System.out.println("Você está sem arco para ir ao stand!");
                        }else{
                            tir1.tiro();
                        }
                        break;
                    case 3:
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
                    case 4:
                        System.out.println("Tem certeza que quer sair do jogo? [S / N]");
                        char sair;
                        do{
                            sair = teclado.next().charAt(0);
                            if(sair != 's' && sair != 'S' && sair != 'n' && sair != 'N'){
                                System.out.println("Digito inválido! Responda novamente:");
                            }
                        }while(sair != 's' && sair != 'S' && sair != 'n' && sair != 'N');
                        opc = (sair == 's' || sair == 'S')?4:0;
                        break;
                    default:
                        System.out.println("Digito inválido!");
                }
            }while(opc != 4);
            System.out.println("Até logo!");
        }
}
