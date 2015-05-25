package com.mobilebits.complicode;

/**
 * Created by iluretar on 03-Apr-15.
 */

import com.mobilebits.complicode.crypto.*;

import static com.mobilebits.complicode.Utils.*;


public class CodeGenerator {

    private String authorization;
    private String number;
    private String nit;
    private String date;
    private String amount;
    private String key;

    private int[] fiveVerhoeff,fiveVerhoeffPlusOne;
    private String controlCode;

    protected CodeGenerator(String authorization, String number, String nit, String date, String amount, String key) {
        this.authorization = authorization;
        this.number = number;
        this.nit = nit;
        this.date = date;
        this.amount = amount;
        this.key = key;
    }

    protected void stepOne(){

        Verhoeff verhoeff = new Verhoeff();
        fiveVerhoeff = new int[DEFAULT_ARRAY_LENGHT];

        for (int i=0; i < REPEAT_TWO; i++){
            number = number+verhoeff.generate(number);
            nit = nit+verhoeff.generate(nit);
            date = date+verhoeff.generate(date);
            amount = amount+verhoeff.generate(amount);
        }

        String  partialString = Long.toString(Integer.parseInt(number)+Long.parseLong(nit)
                +Integer.parseInt(date)+Integer.parseInt(amount));

        for(int i=0; i < REPEAT_FIVE; i++){
            fiveVerhoeff[i]= Integer.parseInt(verhoeff.generate(partialString));
            partialString = partialString+fiveVerhoeff[i];
        }

        stepTwo();

    }

    protected void stepTwo(){
        fiveVerhoeffPlusOne= addToArray(fiveVerhoeff, 1);
        String[] partialString = new String[DEFAULT_ARRAY_LENGHT];
        int startPosition = 0;

        for(int i=0; i < REPEAT_FIVE; i++){
            partialString[i] = key.substring(startPosition, arrayAdd(fiveVerhoeffPlusOne, i + 1));
            startPosition+=fiveVerhoeffPlusOne[i];
        }

        authorization = authorization + partialString[0];
        number = number + partialString[1];
        nit = nit + partialString[2];
        date = date + partialString[3];
        amount = amount + partialString[4];

        stepThree();
    }

    protected void stepThree(){

        ARC4 arc4 = new ARC4(key + arrayConcat(fiveVerhoeff, fiveVerhoeff.length));
        String partialString = arc4.generate(authorization + number + nit + date + amount);

        stepFour(partialString);
    }

    protected void stepFour(String arc4){

        char[] partialString = arc4.toCharArray();
        int total  = arrayAdd(partialString, partialString.length);
        int[] partialArray=new int[DEFAULT_ARRAY_LENGHT];

        for(int i=0; i < REPEAT_FIVE; i++){
            partialArray[i]= addAscii(arc4, i);
        }

        stepFive(partialArray,total);
    }

    protected void stepFive(int[] partialArray, int total){

        Base64 base64 = new Base64();
        ARC4 arc4 = new ARC4(key + arrayConcat(fiveVerhoeff, fiveVerhoeff.length));

        for(int i=0; i < REPEAT_FIVE; i++){
            partialArray[i] = partialArray[i] * total / fiveVerhoeffPlusOne[i];
        }

        total = arrayAdd(partialArray, partialArray.length);
        controlCode = arc4.generate(base64.generate(total));

    }

    protected String generate(){
        stepOne();
        return addDash(controlCode);
    }


}
