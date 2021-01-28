public class Crypto {
    public static void main(String[] args) {
        String originalText = "Hello! My name's Siarhei";
        int key = 5;
        System.out.println(originalText);
        String cypherText = encryptString(originalText, key, 3);
        decryptString(ungroupify(cypherText), key);
    }

//*************************** encryptString ***************************

    public static String encryptString(String originalText, int key, int numberOfLetters) {
        return groupify(caesarify(normalizeText(originalText), key), numberOfLetters);
    }

//*************************** normalizeText ***************************

    public static String normalizeText(String sourceString) {
        String normalizeString = "";
        for (int i = 0; i < sourceString.length(); i++) {
            if (sourceString.charAt(i) != ' ' && sourceString.charAt(i) != '.' && sourceString.charAt(i) != ',' && sourceString.charAt(i) != ':' && sourceString.charAt(i) != ';' && sourceString.charAt(i) != '\''  && sourceString.charAt(i) != '"' && sourceString.charAt(i) != '!' && sourceString.charAt(i) != '?' && sourceString.charAt(i) != '(' && sourceString.charAt(i) != ')') {
                normalizeString += sourceString.charAt(i);
            }
        }
        normalizeString = normalizeString.toUpperCase();
        System.out.println(normalizeString);
        return normalizeString;
    }

//*************************** caesarfy ***************************

    public static String caesarify(String normalizeString, int key) {
        String cipheredString = "";
        for (int i = 0; i < normalizeString.length(); i++) {
            char currChar = normalizeString.charAt(i);
            currChar += key;
            if (currChar > 'Z') {
                currChar -= 26;
                cipheredString += currChar;
            } else if (currChar < 'A') {
                currChar += 26;
                cipheredString += currChar;
            } else {
                cipheredString += currChar;
            }
        }
        System.out.println(cipheredString);
        return cipheredString;
    }

//*************************** groupify ***************************

    public static String groupify (String groupedString, int numberOfLetters) {
        String resultString = "";
        String currString = groupedString;
        String delimiter = "";
        char currChar;
        int shiftNumber = numberOfLetters;
        int differentLengthChar = groupedString.length() % numberOfLetters;
        if (differentLengthChar != 0) {
            for (int i = 0; i < numberOfLetters - differentLengthChar; i++) {
                currString = String.join(delimiter, currString, "x");
            }
        }
        for (int i = 0; i < currString.length(); ) {
            for (int j = i; j < shiftNumber; j++) {
                currChar = currString.charAt(j);
                resultString += currChar;
            }
            if (shiftNumber < currString.length()) {
                resultString += ' ';
            }
            i += numberOfLetters;
            shiftNumber += numberOfLetters;
        }
        System.out.println(resultString);
        return resultString;
    }

//*************************** ungroupify ***************************

    public static String ungroupify (String cypherText) {
        String ungroupedText = "";
        for (int i = 0; i < cypherText.length(); i++) {
            if (cypherText.charAt(i) != ' ' && cypherText.charAt(i) != 'x') {
                ungroupedText += cypherText.charAt(i);
            }
        }
        System.out.println(ungroupedText);
        return ungroupedText;
    }

//*************************** decryptString ***************************

    public static String decryptString(String ungroupedText, int key) {
        String decipheredText = "";
        for (int i = 0; i < ungroupedText.length(); i++) {
            char currChar = ungroupedText.charAt(i);
            currChar -= key;
            if (currChar > 'Z') {
                currChar -= 26;
                decipheredText += currChar;
            } else if (currChar < 'A') {
                currChar += 26;
                decipheredText += currChar;
            } else {
                decipheredText += currChar;
            }
        }
        System.out.println(decipheredText);
        return decipheredText;
    }
}