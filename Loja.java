package pacott;
import java.util.Scanner;
public class Loja {
        private Inventario i1;
        Scanner teclado = new Scanner(System.in);
        public Loja(Inventario i1){
            this.i1 = i1;
        }
        private final int PRECOarcoRecurvo = 70;
        private final int PRECOarcoComposto = 120;
        private final int PRECOflechasMadeira = 1;
        private final int PRECOflechasVidro = 2;
        private final int PRECOflechasInox = 3;
        private final int PRECOflechasObsidiana = 5;
        
        private final int PRECOvendaArcoArtesanal = 20;
        private final int PRECOvendaArcoRecurvo = PRECOarcoRecurvo/2 + 10;
        private final int PRECOvendaArcoComposto = PRECOarcoComposto/2 + 10; 
        public void entrarNaLoja(){
            System.out.println("Bem-vindo à Loja do Obi!");
            int opc, opc2, resp;
            do{
            System.out.println("O que você deseja?\n[1] Comprar;\n[2] Vender;\n[3] Sair da loja.");
               do{
                   opc2 = teclado.nextInt();
                   if(opc2 != 1 && opc2 != 2 && opc2 != 3){
                       System.out.print("Digito inválido! Responda novamente: ");
                   }
               } while(opc2 != 1 && opc2 != 2 && opc2 != 3);
               if(opc2 == 1){
                   do{
                       System.out.println("ITENS À VENDA:\n[1] Arco recurvo - $ 70,00;\n[2] Arvo composto - $ 120,00;\n"
                               + "[3] Flechas de madeira - $1,00/un;\n"
                               + "[4] Flechas de vidro - $2,00/un;\n[5] Flechas de Inox - $3,00/un;\n"
                               + "[6] Flechas de obsidiana - $5,00/un;\n[7] Sair."
                               + "\n\nDinheiro disponível: "+i1.getMoedasOuro()+" moedas de ouro.\nEscolha uma opcao:");
                        opc = teclado.nextInt();
                        switch(opc){
                            case 1: //ARCO RECURVO
                                if(i1.getArcoAtual() != null){
                                    System.out.println("Você tem o arco modelo " + i1.getArcoAtual().getModeloArco());
                                    System.out.println("Você só pode carregar um arco no invantário! Venda o seu primeiro!");
                                } else{
                                    if(i1.getMoedasOuro() >= PRECOarcoRecurvo){
                                        Arco a1 = new Arco();
                                        a1.setModeloArco("recurvo");
                                        i1.setArcoAtual(a1);
                                        i1.gastarOuro(PRECOarcoRecurvo);
                                        System.out.println("Arco recurvo comprado!\nVocê tem agora "+i1.getMoedasOuro()+
                                                " moedas de ouro disponíveis.");
                                    }else{
                                        System.out.println("Você não tem dinheiro suficiente!");
                                    }
                                }
                                if(!maisAlgumaCoisa()){ //Se retornar falso, opc valerá 7 e sairá do menu de compras
                                    opc = 7;
                                }
                                break;
                            case 2: //ARCO COMPOSTO
                                 if(i1.getArcoAtual() != null){
                                    System.out.println("Você tem o arco modelo " + i1.getArcoAtual().getModeloArco());
                                    System.out.println("Você só pode carregar um arco no invantário! Venda o seu primeiro!");
                                 }else{
                                     if(i1.getMoedasOuro() >= PRECOarcoComposto){
                                         Arco a2 = new Arco();
                                         a2.setModeloArco("composto");
                                         i1.setArcoAtual(a2);
                                         i1.gastarOuro(PRECOarcoComposto);
                                         System.out.println("Arco composto comprado!\nVocê tem agora " + i1.getMoedasOuro()
                                         + " moedas de ouro disponíveis.");
                                     } else{
                                         System.out.println("Você não tem dinheiro suficiente!");
                                     }
                                 }
                                 if(!maisAlgumaCoisa()){
                                    opc = 7;
                                 }
                                break;
                            case 3: //FLECHAS DE MADEIRA
                                System.out.println("Quantas flechas de madeira você gostaria de comprar?");
                                resp = teclado.nextInt();
                                if(i1.getMoedasOuro() < resp * PRECOflechasMadeira){
                                    System.out.println("Você não tem dinheiro suficiente!");
                                } else{
                                    i1.getFlechasMadeira().setQtdFlechas(i1.getFlechasMadeira().getQtdFlechas() + resp);
                                    i1.gastarOuro(resp * PRECOflechasMadeira);
                                    System.out.println("Você comprou " + resp + " flechas de madeira e gastou " + resp * PRECOflechasMadeira + " moedas.");
                                    System.out.println("Você tem agora " + i1.getMoedasOuro() + " moedas de ouro.");
                                }
                                if(!maisAlgumaCoisa()){
                                    opc = 7;
                                }
                                break;
                            case 4: //FLECHAS DE VIDRO
                                System.out.println("Quantas flechas de vidro você gostaria de comprar?");
                                resp = teclado.nextInt();
                                if(i1.getMoedasOuro() < resp * PRECOflechasVidro){
                                    System.out.println("Você não tem dinheiro suficiente!");
                                } else{
                                    i1.getFlechasVidro().setQtdFlechas(i1.getFlechasVidro().getQtdFlechas() + resp);
                                    i1.gastarOuro(resp * PRECOflechasVidro);
                                    System.out.println("Você comprou " + resp + " flechas de vidro e gastou " + resp * PRECOflechasVidro
                                    + " moedas. Você tem agora " + i1.getMoedasOuro() + " moedas de ouro.");
                                }
                                if(!maisAlgumaCoisa()){
                                    opc = 7;
                                }
                                break;
                            case 5: //FLECHAS INOX
                                System.out.println("Quantas flechas de inox você gostaria de comprar?");
                                resp = teclado.nextInt();
                                if(i1.getMoedasOuro() < resp * PRECOflechasInox){
                                    System.out.println("Você não tem dinheiro suficiente!");
                                } else{
                                    i1.getFlechasInox().setQtdFlechas(i1.getFlechasInox().getQtdFlechas() + resp);
                                    i1.gastarOuro(resp * PRECOflechasInox);
                                    System.out.println("Você comprou " + resp + " flechas de inox e gastou " + resp * PRECOflechasInox
                                    + " moedas. Você tem agora " + i1.getMoedasOuro() + " moedas de ouro.");
                                }
                                if(!maisAlgumaCoisa()){
                                    opc = 7;
                                }
                                break;
                            case 6: //FLECHAS OBSIDIANA
                                System.out.println("Quantas flechas de obsidiana você gostaria de comprar?");
                                resp = teclado.nextInt();
                                if(i1.getMoedasOuro() < resp * PRECOflechasObsidiana){
                                    System.out.println("Você não tem moedas suficiente! Essas flechas são caras!");
                                } else{
                                    i1.getFlechasObsidiana().setQtdFlechas(i1.getFlechasObsidiana().getQtdFlechas() + resp);
                                    i1.gastarOuro(resp * PRECOflechasObsidiana);
                                    System.out.println("Você comprou " + resp + " flechas de obsidiana e gastou " + resp *PRECOflechasObsidiana
                                    + " moedas. Você tem agora " + i1.getMoedasOuro() + " moedas de ouro.");
                                }
                                if(!maisAlgumaCoisa()){
                                    opc = 7;
                                }
                                break;
                            case 7:
                                System.out.println("Obi: Tudo bem!");
                                break;
                            default:
                                System.out.println("Digito inválido!");
                        }
                  }while(opc != 7); 
               }else if(opc2 == 2){//PARTE DAS VENDAS
                   do{
                        System.out.println("Obi: O que desejas me vender?:\n[1] Arco artesanal - $ " +PRECOvendaArcoArtesanal + 
                                ";\n[2] Arco recurvo - $ "+PRECOvendaArcoRecurvo+";\n[3] Arco composto - $ "+PRECOvendaArcoComposto
                        + ";\n[4] Sair;"); 
                        opc = teclado.nextInt();
                        switch(opc){
                            case 1:
                                if(!i1.getArcoAtual().getModeloArco().equals("artesanal")){
                                    System.out.println("Você não tem um arco artesanal!");
                                }else{
                                    i1.ganharOuro(PRECOvendaArcoArtesanal);
                                    System.out.println("Você ganhou "+PRECOvendaArcoArtesanal+" moedinhas de ouro nesse arco artesanal!\n"
                                            + "Você tem agora " + i1.getMoedasOuro() + " moedas de ouro.");
                                    i1.setArcoAtual(null);
                                };
                                break;
                            case 2:
                                if(!i1.getArcoAtual().getModeloArco().equals("recurvo")){
                                    System.out.println("Você não tem um arco recurvo!");
                                } else{
                                    i1.ganharOuro(PRECOvendaArcoRecurvo);
                                    System.out.println("Você ganhou "+PRECOvendaArcoRecurvo+" moedas de ouro no arco recurvo!"
                                    +"Você tem agora "+i1.getMoedasOuro()+" moedas de ouro.");
                                    i1.setArcoAtual(null);
                                }
                                break;
                            case 3:
                                if(!i1.getArcoAtual().getModeloArco().equals("composto")){
                                    System.out.println("Você não tem um arco composto!");
                                }else{
                                    i1.ganharOuro(PRECOvendaArcoComposto);
                                    System.out.println("Você vendeu um arco compostou e ganhou + "+PRECOvendaArcoComposto+" moedas"
                                            + "de ouro. Você tem agora "+i1.getMoedasOuro()+" moedas no inventário.");
                                    i1.setArcoAtual(null);
                                }
                                break;
                            case 4:
                                System.out.println("Obi: Ok!");
                                break;
                            default:
                                System.out.println("Digito inválido!");
                        }
                   }while(opc != 4);    
               }
            }while(opc2 != 3);   
        }
        public boolean maisAlgumaCoisa(){
            System.out.println("Gostaria de comprar mais alguma coisa? [S / N]");
            char respo;
            do{
               respo = teclado.next().charAt(0);
               if(respo != 's' && respo != 'S' && respo != 'n' && respo != 'N'){
                   System.out.println("Digito inválido!");
               } 
            } while(respo != 's' && respo != 'S' && respo != 'n' && respo != 'N');
            if(respo == 's' || respo == 'S'){
                return true;
            } else{
                return false;
            }
        }
}
