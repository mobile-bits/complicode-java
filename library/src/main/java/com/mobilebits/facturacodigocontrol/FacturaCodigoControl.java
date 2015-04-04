package com.mobilebits.facturacodigocontrol;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by iluretar on 02-Apr-15.
 */


public class FacturaCodigoControl {
    public static void main(String[] args){

    }

    public static class Builder{

        private String nestedAuthorization;
        private int nestedNumber;
        private String nestedNit;
        private Date nestedDate;
        private Double nestedAmount;
        private String nestedKey;
        private CodeGenerator generator;

        public Builder(){

        }

        public Builder authorization(String newAuthorization)
        {
            this.nestedAuthorization = newAuthorization;
            return this;
        }

        public Builder nit(String newNit)
        {
            this.nestedNit = newNit;
            return this;
        }

        public Builder number(int newNumber)
        {
            this.nestedNumber = newNumber;
            return this;
        }

        public Builder date(Date newDate)
        {
            this.nestedDate = newDate;
            return this;
        }

        public Builder amount(Double newAmount)
        {
            this.nestedAmount = newAmount;
            return this;
        }

        public Builder key(String newKey)
        {
            this.nestedKey = newKey;
            return this;
        }

        public String build(){

            validate();

            generator= new CodeGenerator(nestedAuthorization,Integer.toString(nestedNumber),
                        nestedNit,new SimpleDateFormat("yyyyMMdd").format(nestedDate),String.valueOf(Math.round(nestedAmount)),nestedKey);

                return generator.generate();

        }

        private void validate(){

            if (nestedAuthorization == null) {
                throw new NullPointerException("Authorization may not be null.");
            }

            if (nestedNit == null) {
                nestedNit = "0";
            }

            if (nestedNumber == 0) {
                throw new NullPointerException("Number may not be 0");
            }

            if (nestedDate == null) {
                throw new NullPointerException("Date may not be null.");
            }

            if (nestedAmount == null) {
                throw new NullPointerException("Amount may not be null.");
            }

            if (nestedAmount < 0.5) {
                throw new NullPointerException("Amount may not 0.");
            }

            if (nestedKey == null) {
                throw new NullPointerException("Key may not be null.");
            }
        }
    }

}
