package pacott;
import java.util.Scanner;
public class TiroAoAlvo {
        private Arco a1;
        private Flechas f1;
        private Inventario i1;
        private Scanner teclado = new Scanner(System.in);
        public TiroAoAlvo(Arco a1, Inventario i1){
            this.a1 = a1;
            this.i1 = i1;
        }
        
        public void setArco(Arco a1){
            this.a1 = a1;
        }
        public void setFlechas(Flechas f1){
            this.f1 = f1;
        }
        
        public void tiro(){
            System.out.println("Bem-vindo ao stand de tiro ao alvo!");
            escolhaFlecha();
            int opc;
            System.out.println("[1] Armar o arco;\n[2] Atirar;\n[3] Desarmar o arco;\n[4] Trocar flechas;\n[5] Sair do stand");
            float pontuacao;
            int gp;
            do{
            opc = teclado.nextInt();
                switch(opc){
                    case 1://ARMAR O ARCO
                        if(f1.getQtdFlechas() < 1){
                            System.out.println("Não há flechas suficientes!");
                        } else{
                            a1.setCarregar(true);
                            System.out.println("Arco armado! Pronto para o tiro!");
                        }
                        break;
                    case 2://ATIRAR
                        if(!a1.isCarregado()){
                            System.out.println("Arme o arco primeiro!");
                        } else{
                            a1.atirar();
                            f1.setQtdFlechas(f1.getQtdFlechas() - 1);
                            pontuacao = (float)Math.random() * (a1.getForcaArco() + f1.getForcaFlecha());
                            gp = 2 * (int)pontuacao;
                            System.out.printf("%.2f pontos! %d gold coins adquiridos!", pontuacao, gp);
                            i1.ganharOuro(gp);
                        }
                        break;
                    case 3:
                        if(a1.isCarregado()){
                            a1.setCarregar(false);
                            System.out.println("Arco desarmado!");
                        } else{
                            System.out.println("O arco já está desarmado...");
                        }
                        break;
                    case 4:
                        escolhaFlecha();
                        break;
                    case 5://SAIR
                        System.out.println("Até logo! Volte sempre aqui no stand...");
                        break;
                    default:
                        System.out.println("Digito inválido!");
                }
            }while(opc != 5);
        }
        
        public void escolhaFlecha(){
            System.out.println("Escolha com qual flechas do seu inventário você quer atirar:\n"
                    + " TIPO  - QUANTIDADE\n[1] Madeira: "+i1.getFlechasMadeira().getQtdFlechas()+"\n[2] Vidro: "+
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
                    System.out.println("Obsidiana, hum... poderosissima!");
                    break;
            }
            System.out.println("Flecha escolhida! Você está usando a de " + f1.getModeloFlecha()+"!\n"
                    + "Já pode armar seu arco...");
        } 
}
