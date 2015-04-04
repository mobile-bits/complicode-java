package com.mobilebits.facturacodigocontrol.crypto;

/**
 * Created by iluretar on 30-Mar-15.
 */
public class Base64 {
    private static char[] DICTIONARY =
            {
                    '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
                    'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J',
                    'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T',
                    'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd',
                    'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n',
                    'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x',
                    'y', 'z', '+', '/'
            };

    public String generate(int value){

        int quotient = 1;
        int mod;
        String result = "";

        while(quotient > 0){
            quotient = value /64;
            mod = value % 64;
            result = DICTIONARY[mod]+result;
            value = quotient;
        }
        return result;

    }

}
