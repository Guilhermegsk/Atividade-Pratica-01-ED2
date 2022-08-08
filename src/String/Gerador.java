package String;

import java.nio.charset.*;
import java.util.*;

public class Gerador {//site base para criação: https://www.baeldung.com/java-random-string

    public static String getStringRandom(int i) {// i eh o tamanho da string
        byte[] bytearray;
        String aux;
        StringBuffer buffer;

        bytearray = new byte[256];
        new Random().nextBytes(bytearray);

        aux = new String(bytearray, Charset.forName("UTF-8"));

        buffer = new StringBuffer();

        for (int m = 0; m < aux.length(); m++) {

            char n = aux.charAt(m);

            if (((n >= 'A' && n <= 'Z') //realiza a identificacao
                    || (n >= '0' && n <= '9'))
                    && (i > 0)) {

                buffer.append(n);
                i--;
            }
        }
        return buffer.toString();
    }
}
