package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RedesController {

    private String os(){
        return System.getProperty("os.name");
    }

    public void ip() {
        String os = os();
        if (os.contains("Windows")) {

            try {
                Process process = Runtime.getRuntime().exec("IPCONFIG");
                BufferedReader buffer = new BufferedReader(new InputStreamReader(process.getInputStream()));
                String linha;
                while ((linha = buffer.readLine()) != null) {
                    if (linha.contains("IPv4")) {
                        System.out.println(linha);
                    }
                }
                buffer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else if (os.contains("Linux")) {
            try {
                Process process = Runtime.getRuntime().exec("ifconfig");
                BufferedReader buffer = new BufferedReader(new InputStreamReader(process.getInputStream()));
                String linha;
                while ((linha = buffer.readLine()) != null) {
                    if (linha.contains("inet ")) {
                        System.out.println(linha);
                    }
                }
                buffer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Sistema Operacional não suportado.");
        }
    }

        public void ping() {
        String os = os();
        if (os.contains("Windows")) {
            try {
                Process process = Runtime.getRuntime().exec("ping -4 -n 10 www.google.com.br");
                BufferedReader buffer = new BufferedReader(new InputStreamReader(process.getInputStream()));
                String linha;
                while ((linha = buffer.readLine()) != null) {
                    if (linha.contains("ms")) {
                        System.out.println(linha);
                    }
                }
                buffer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else if (os.contains("Linux")) {
            try {
                Process process = Runtime.getRuntime().exec("ping -4 -c 10 www.google.com.br");
                BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
                String line;
                while ((line = reader.readLine()) != null) {
                    if (line.contains("icmp_seq")) {
                        System.out.println(line);
                    }
                }
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Sistema Operacional não suportado.");
        }
    }
}
