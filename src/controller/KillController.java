package controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class KillController {

	public KillController() {
		super();
	}
	
	private String os() {
        return System.getProperty("os.name");
    }

    public void listaProcessos() {
        try {
            String os = os();
            String proc = "";

            if (os.contains("Win")) {
                proc = "tasklist /fo table";
            } else if (os.contains("nux") || os.contains("mac")) {
                proc = "ps -ef";
            }

            Process process = Runtime.getRuntime().exec(proc);
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String linha;

            while ((linha = reader.readLine()) != null) {
                System.out.println(linha);
            }

            reader.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void mataPid(int pid) {
        try {
            String os = os();
            String proc = "";

            if (os.contains("Win")) {
            	proc = "taskkill /PID " + pid;
            } else if (os.contains("nux") || os.contains("mac")) {
            	proc = "kill -9 " + pid;
            }

            Process process = Runtime.getRuntime().exec(proc);
            process.waitFor(); 
            System.out.println("Processo com PID " + pid + " finalizado.");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void mataNome(String nome) {
        try {
            String os = os();
            String proc = "";

            if (os.contains("Win")) {
            	proc = "taskkill /IM " + nome;
            } else if (os.contains("nux") || os.contains("mac")) {
            	proc = "pkill -f " + nome;
            }

            Process process = Runtime.getRuntime().exec(proc);
            process.waitFor(); 
            System.out.println("Processo com nome " + nome + " finalizado.");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
