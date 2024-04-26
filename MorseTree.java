import java.util.HashMap;

class MorseTree {
    private TreeNode root;

    public MorseTree() {
        this.root = null;
        populateTree();
    }

    private void populateTree() {
        // Hardcoded creation of the Morse Tree

        // Level 1
        root = new TreeNode(' ');

        // Level 2
        root.left = new TreeNode('e');
        root.right = new TreeNode('t');

        // Level 3
        root.left.left = new TreeNode('i');
        root.left.right = new TreeNode('a');
        root.right.left = new TreeNode('n');
        root.right.right = new TreeNode('m');

        // Level 4
        root.left.left.left = new TreeNode('s');
        root.left.left.right = new TreeNode('u');
        root.left.right.left = new TreeNode('r');
        root.left.right.right = new TreeNode('w');
        root.right.left.left = new TreeNode('d');
        root.right.left.right = new TreeNode('k');
        root.right.right.left = new TreeNode('g');
        root.right.right.right = new TreeNode('o');

        // Level 5
        root.left.left.left.left = new TreeNode('h');
        root.left.left.left.right = new TreeNode('v');
        root.left.left.right.left = new TreeNode('f');
        root.left.left.right.right = new TreeNode(' ');
        root.left.right.left.left = new TreeNode('l');
        root.left.right.left.right = new TreeNode('p');
        root.left.right.right.left = new TreeNode('j');
        root.left.right.right.right = new TreeNode('b');
        root.right.left.left.left = new TreeNode('x');
        root.right.left.left.right = new TreeNode('c');
        root.right.left.right.left = new TreeNode('y');
        root.right.left.right.right = new TreeNode('z');
        root.right.right.left.left = new TreeNode('q');
        root.right.right.left.right = new TreeNode(' ');

        // The ' ' character represents space 
    }

    public String preOrder() {
        StringBuilder result = new StringBuilder();
        preOrderTraversal(root, result);
        return result.toString();
    }

    private void preOrderTraversal(TreeNode node, StringBuilder result) {
        if (node == null)
            return;
        result.append(node.data).append(" ");
        preOrderTraversal(node.left, result);
        preOrderTraversal(node.right, result);
    }

    public String postOrder() {
        StringBuilder result = new StringBuilder();
        postOrderTraversal(root, result);
        return result.toString();
    }

    private void postOrderTraversal(TreeNode node, StringBuilder result) {
        if (node == null)
            return;
        postOrderTraversal(node.left, result);
        postOrderTraversal(node.right, result);
        result.append(node.data).append(" ");
    }

    public String englishToMorse(String english) {
        StringBuilder morseCode = new StringBuilder();
        for (char c : english.toCharArray()) {
            if (Character.isLetter(c)) {
                char lowercaseChar = Character.toLowerCase(c);
                morseCode.append(englishToMorseMap.getOrDefault(lowercaseChar, " "));
                morseCode.append(" | ");
            }
        }
        return morseCode.toString().trim(); // Remove trailing space
    }

    public String morseToEnglish(String morse) {
        StringBuilder englishText = new StringBuilder();
        String[] morseWords = morse.split("\\|");
        for (String morseWord : morseWords) {
            String[] morseChars = morseWord.trim().split("\\s+");
            for (String morseChar : morseChars) {
                Character englishChar = morseToEnglishMap.get(morseChar);
                if (englishChar != null) {
                    englishText.append(englishChar);
                }
            }
            englishText.append(" ");
        }
        return englishText.toString().trim(); // Remove leading and trailing spaces
    }

    private static final HashMap<Character, String> englishToMorseMap = new HashMap<>() {{
        put('a', "o-");
        put('b', "-ooo");
        put('c', "-o-o");
        put('d', "-oo");
        put('e', "o");
        put('f', "oo-o");
        put('g', "--o");
        put('h', "oooo");
        put('i', "oo");
        put('j', "o---");
        put('k', "-o-");
        put('l', "o-oo");
        put('m', "--");
        put('n', "-o");
        put('o', "---");
        put('p', "o--o");
        put('q', "--o-");
        put('r', "o-o");
        put('s', "ooo");
        put('t', "-");
        put('u', "oo-");
        put('v', "ooo-");
        put('w', "o--");
        put('x', "-oo-");
        put('y', "-o--");
        put('z', "--oo");
        // Add digits and other characters
    }};

    private static final HashMap<String, Character> morseToEnglishMap = new HashMap<>() {{
        for (Entry<Character, String> entry : englishToMorseMap.entrySet()) {
            put(entry.getValue(), entry.getKey());
        }
    }};

    private static class TreeNode {
        char data;
        TreeNode left, right;

        public TreeNode(char data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }
}