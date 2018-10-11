package com.example.sneha.quizme;


import android.text.TextUtils;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;


public class CSVWriter {

    private PrintWriter pp;


    public CSVWriter(Writer writer) {
        this.pp = new PrintWriter(writer);
    }



    public void writeNext(String[] nextLine) {
        String toWrite = TextUtils.join(",", nextLine);
        pp.write(toWrite + "\n");

        return ;

    }

    public void close() {
        pp.flush();
        pp.close();
    }
}
