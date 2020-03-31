package encryptdecrypt;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;


abstract class Coder {
    String message;
    int key;
    String alphabetLower = "abcdefghijklmnopqrstuvwxyz";
    String alphabetUpper = alphabetLower.toUpperCase();

    Coder(String message, int key) {
        this.message = message;
        this.key = key;
    }

    public abstract String shift();

    public abstract String unicode();
}

class Encoder extends Coder {
    Encoder(String message, int key) {
        super(message, key);
    }

    @Override
    public String shift() {
        char[] charMessage = message.toCharArray();
        String alphabetLowerOffset = alphabetLower.substring(key) + alphabetLower.substring(0, key);
        String alphabetUpperOffset = alphabetUpper.substring(key) + alphabetUpper.substring(0, key);
        String encodedMessage = "";

        for (char c : charMessage) {
            if (alphabetLower.contains("" + c)){
                encodedMessage += alphabetLowerOffset.charAt(alphabetLower.indexOf(c));
            } else if (alphabetUpper.contains("" + c)) {
                encodedMessage += alphabetUpperOffset.charAt(alphabetUpper.indexOf(c));
            } else {
                encodedMessage += c;
            }
        }
        return encodedMessage;
    }

    @Override
    public String unicode() {
        char[] charMessage = message.toCharArray();
        String encodedMessage = "";
        for (char c : charMessage) {
            encodedMessage += String.valueOf((char)(c + key));
        }
        return encodedMessage;
    }
}

class Decoder extends Coder {
    Decoder(String message, int key) {
        super(message, key);
    }

    @Override
    public String shift() {
        char[] charMessage = this.message.toCharArray();
        String alphabetLowerOffset = alphabetLower.substring(key) + alphabetLower.substring(0, key);
        String alphabetUpperOffset = alphabetUpper.substring(key) + alphabetUpper.substring(0, key);
        String decodedMessage = "";

        for (char c : charMessage) {
            if (alphabetLower.contains("" + c)) {
                decodedMessage += alphabetLower.charAt(alphabetLowerOffset.indexOf(c));
            } else if (alphabetUpper.contains("" + c)) {
                decodedMessage += alphabetUpper.charAt(alphabetUpperOffset.indexOf(c));
            } else {
                decodedMessage += c;
            }
        }
        return decodedMessage;
    }

    @Override
    public String unicode() {
        char[] charMessage = this.message.toCharArray();
        String decodedMessage = "";
        for (char c : charMessage) {
            decodedMessage += String.valueOf((char)(c - key));
        }
        return decodedMessage;
    }
}

class CoderType {
    public static Coder choose(String mode, String message, int key){
        switch (mode) {
            case "enc":
                return new Encoder(message, key);
            case "dec":
                return new Decoder(message, key);
            default:
                return null;
        }
    }
}

class Output {
    public static void writeToFile(String data, String outputPath) {
        try (FileWriter printWriter = new FileWriter(outputPath)) {
            printWriter.write(data);
        } catch (Exception e) {
            System.out.println("Error while writing to file");
        }
    }

    public static void writeToTerminal(String data) {
        System.out.println(data);
    }
}
public class Main {
        public static void main(String[] args) throws IOException {
        int key = 0;
        String alg = "shift";
        String mode = "enc";
        String data = null;
        String inputPath = null;
        String outputPath = null;
        Boolean toFile = false;
        String messageData = "";

        for (int i = 0; i < args.length; i++) {
            switch (args[i]) {
                case "-mode":
                    mode = args[i + 1];
                    break;
                case "-key":
                    key = Integer.parseInt(args[i + 1]);
                    break;
                case "-data":
                    data = args[i + 1];
                    break;
                case "-in":
                    inputPath = args[i + 1];
                    break;
                case "-out":
                    outputPath = args[i + 1];
                    toFile = true;
                    break;
                case "-alg":
                    alg = args[i + 1];
                    break;
            }
        }

        if (data == null) {
            if (inputPath != null) {
                try {
                    messageData = new String(Files.readAllBytes(Paths.get(inputPath)));
                } catch (Exception e) {
                    System.out.println("Error");
                }
            }
        } else {
            messageData = data;
        }


        Coder coder = CoderType.choose(mode, messageData, key);

        switch (alg) {
            case "shift":
                if (toFile) {
                    Output.writeToFile(coder.shift(), outputPath);
                } else {
                    Output.writeToTerminal(coder.shift());
                }
            case "unicode":
                if (toFile) {
                    Output.writeToFile(coder.unicode(), outputPath);
                } else {
                    Output.writeToTerminal(coder.unicode());
                }
        }

//        Coder encoder = CoderType.choose("enc", "Welcome to hyperskill!", 5);
//        Coder decoderUnicode = CoderType.choose("dec", "|jqhtrj%yt%m~ujwxpnqq", 5);
//        Coder decoderShift = CoderType.choose("dec", "Bjqhtrj yt mdujwxpnqq!", 5);
//        System.out.println(encoder.shift());
//        System.out.println(encoder.unicode());
//        System.out.println(decoderShift.shift());
//        System.out.println(decoderUnicode.unicode());
    }
}
