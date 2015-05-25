package com.mobilebits.complicode.samples;

/**
 * Created by iluretar on 03-Apr-15.
 */

import com.mobilebits.complicode.CompliCode;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static java.lang.System.out;

public class Sample {

    public static void main(String[] args) {

        Date date=null;
        try {
            date = new SimpleDateFormat("yyyyMMdd").parse("20070702");
        } catch (ParseException e) {
            e.printStackTrace();
        }

        String code = new CompliCode.Builder()
                .authorization("29040011007")
                .nit("4189179011")
                .number(1503)
                .date(date)
                .amount(2500.0)
                .key("9rCB7Sv4X29d)5k7N%3ab89p-3(5[A")
                .build();

        out.println(code);

    }
}
