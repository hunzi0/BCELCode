package com;

import org.apache.bcel.classfile.Utility;
import org.apache.commons.cli.*;

import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.nio.ByteBuffer;
import java.nio.file.Files;
import java.nio.file.Paths;

class DtOptions {

    public static Options generateOp() {
        final Options options = new Options();
        options.addOption(new Option("e", "encode", true, "Enter the path of the file to be encoded"));
        options.addOption(new Option("d", "decode", true, "Enter the path to the file to decode"));
        options.addOption(new Option("h", "help", false, "Show this help"));
        return options;
    }
}

public class main {

    public static void main(String[] args) throws Exception {
        CommandLineParser parser = new DefaultParser();
        Options options = DtOptions.generateOp();
        CommandLine line = parser.parse(options, args);
        if (line.hasOption("e")) {
            encode(line.getOptionValue("e"));
        } else if (line.hasOption("d")) {
            decode(line.getOptionValue("d"));
        } else {
            HelpFormatter formatter = new HelpFormatter();
            formatter.printHelp("h", options);
        }
    }

    public static void encode(String filepath) {
        String filename = filepath.trim();
        filename = filename.substring(filename.lastIndexOf("/") + 1).split("\\.")[0] + ".txt";
        try {

            byte[] data = Files.readAllBytes(Paths.get(filepath));
            String str = Utility.encode(data, true);
            str = "$$BCEL$$" + str;

            PrintWriter pw = new PrintWriter(filename);
            pw.println(str);
            pw.close();
            System.out.println("BCEL encoding is successful and saved to " + filename);
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }

    public static void decode(String filepath) {
        String filename = filepath.trim();
        filename = filename.substring(filename.lastIndexOf("/") + 1).split("\\.")[0] + ".class";
        try {

            byte[] data = Files.readAllBytes(Paths.get(filepath));
            String str = new String(data, "utf-8").split("\n")[0];
            if (str.startsWith("$$BCEL$$") || str.startsWith("$$bcel$$")) {
                str = str.substring(8);
            }
            byte[] b = Utility.decode(str, true);

            ByteBuffer buffer = ByteBuffer.wrap(b);
            File file = new File(filename);
            FileOutputStream os = new FileOutputStream(file);
            os.write(b);
            os.close();
            System.out.println("BCEL decoded successfully and saved to " + filename);

        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }
}
