package com.surajmaity1.languageapp;

import java.io.InputStream;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class SayHello {
    public static void main(String[] args) throws IOException{
        String language = args[0];

        InputStream is = SayHello.class.getClassLoader()
                .getResourceAsStream(language + ".txt");
        assert is != null;
        BufferedReader bf = new BufferedReader(new InputStreamReader(
                is, StandardCharsets.UTF_8
        ));
        System.out.println(bf.readLine());
    }
}