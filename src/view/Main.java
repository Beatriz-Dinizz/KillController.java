package view;

import javax.swing.JOptionPane;
import controller.KillController;

public class Main {

	public static void main(String[] args) {
		KillController controller = new KillController();
        int opc = 0;

        while (opc != 9) {
            opc = Integer.parseInt(JOptionPane.showInputDialog("Menu Principal\n"
                    + "1 - Listar processos ativos\n"
                    + "2 - Matar processo por PID\n"
                    + "3 - Matar processo por nome\n"
                    + "9 - Finalizar programa"));

            switch (opc) {
                case 1:
                    controller.listaProcessos();
                    break;
                case 2:
                    int pid = Integer.parseInt(JOptionPane.showInputDialog("Digite o PID do processo: "));
                    controller.mataPid(pid);
                    break;
                case 3:
                    String nome = JOptionPane.showInputDialog("Digite o nome do processo: ");
                    controller.mataNome(nome);
                    break;
                case 9:
                    JOptionPane.showMessageDialog(null, "Programa finalizado!");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opção inválida!");
                    break;
            }
        }
    }
}
