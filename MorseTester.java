public class MorseTester {
    public static void main(String[] args) {
        MorseTree morseTree = new MorseTree();

        // Print the preorder of the tree
        System.out.println("Preorder tree contents: " + morseTree.preOrder());

        // Print the postorder of the tree
        System.out.println("Postorder tree contents: " + morseTree.postOrder());

        // English text to Morse code
        String englishText = "The quick fox";
        String morseCode = morseTree.englishToMorse(englishText);
        System.out.println("English to Morse: " + morseCode);

        // Morse code back into English text
        String translatedText = morseTree.morseToEnglish(morseCode);
        System.out.println("Morse to English: " + translatedText);
    }
}