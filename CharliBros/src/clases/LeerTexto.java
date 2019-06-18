
package clases;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;


public class LeerTexto {
    private BufferedReader archivo;
    private StringTokenizer tokenizer;
    private String linea;
    private int numLineas = 0;
    private String[] historia = new String[40];

    LeerTexto(String file) throws IOException {

        archivo = new BufferedReader(new FileReader(file));

        linea = archivo.readLine();

        while (linea != null) {

            historia[numLineas] = linea;
            ++numLineas;
            linea = archivo.readLine();
        }

        archivo.close();
    }

    public int getSize() {
        return numLineas;

    }

    public String[] getHistoria() {
        return historia;
    }
}
