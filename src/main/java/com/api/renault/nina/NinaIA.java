package com.api.renault.nina;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class NinaIA {

    public static String run(String query) throws IOException {

        String pythonScriptPath = "ia_chat/chat.py";
        String[] command = {"python", pythonScriptPath, "-q", query};
        ProcessBuilder processBuilder = new ProcessBuilder(command);

        try {

            Process process = processBuilder.start();
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));

            return reader.readLine();

        } catch (IOException e) {
            throw e;
        }
    }
}

