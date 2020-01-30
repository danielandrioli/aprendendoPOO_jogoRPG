package pacott;
import java.util.Scanner;
public class Stand {
        private Personagem p1;
        private Flechas f1; //Flechas na aljava
        private Inventario i1;
        private Scanner teclado = new Scanner(System.in);
        public Stand(Inventario i1, Personagem p1){//Metodo construtor
            this.i1 = i1;
            this.f1 = i1.getFlechasMadeira();
            this.p1 = p1;
        }
        public void tiro(){
            System.out.println("Bem-vindo ao stand de tiro ao alvo!\nAqui você pode praticar a vontade! "
                    + "Flechas de madeira por nossa conta!\n\nEscolha uma opção:");
            int opc;
            System.out.println("[1] Armar o arco;\n[2] Atirar;\n[3] Desarmar o arco;\n[4] Consultar status;\n[5] Sair do stand");
            float pontuacao;
            int gp;
            do{
            opc = teclado.nextInt();
                switch(opc){
                    case 1://ARMAR O ARCO
                        if(i1.getArcoAtual().isCarregado()){
                            System.out.println("O arco já está armado!");
                        } else{
                            f1.setQtdFlechas(f1.getQtdFlechas() + 1); //Flechas de graça
                            i1.getArcoAtual().setCarregar(true);
                            System.out.println("Arco armado! Pronto para o tiro!");
                        }
                        break;
                    case 2: //ATIRAR
                        if(!i1.getArcoAtual().isCarregado()){
                            System.out.println("Arme o arco primeiro!");
                        } else{
                            i1.getArcoAtual().atirar();
                            f1.setQtdFlechas(f1.getQtdFlechas() - 1);
                            pontuacao = (float)Math.random() * (i1.getArcoAtual().getForcaArco() +(float) p1.getHabilidade()); //DEIXAR ESSA FORMULA?
                            System.out.println("Pontuacao: " + pontuacao);
                            p1.setPorcentHab(p1.getPorcentHab() + 20/(p1.getHabilidade()));//TALVEZ TENHA QUE AJUSTAR ESSA FORMULA
                  //Quanto menos habilidoso, mais rápido a porcentHabilidade avança!
                        }
                        break;
                    case 3:
                        if(i1.getArcoAtual().isCarregado()){
                            i1.getArcoAtual().setCarregar(false);
                            System.out.println("Arco desarmado!");
                            f1.setQtdFlechas(f1.getQtdFlechas() - 1);
                        } else{
                            System.out.println("O arco já está desarmado...");
                        }
                        break;
                    case 4:
                        System.out.println("Skill " + p1.getHabilidade() + " em arqueria. Falta "+(100-p1.getPorcentHab())+"% para o "
                                    + "próximo nível.");
                        for(int c = 1; c <= p1.getPorcentHab()/2; c++){
                            System.out.print("|");
                        }
                        for(int g = (int)p1.getPorcentHab()/2; g <= 50; g++){
                            System.out.print(".");
                        }
                        break;
                    case 5://SAIR
                        if(i1.getArcoAtual().isCarregado()){
                            System.out.println("Desarme o arco primeiro antes de sair!!");
                            opc = 0;
                        } else{
                            System.out.println("Até logo! Volte sempre aqui no stand...");
                        }
                        break;
                    default:
                        System.out.println("Digito inválido!");
                }
            }while(opc != 5);
        }
}
