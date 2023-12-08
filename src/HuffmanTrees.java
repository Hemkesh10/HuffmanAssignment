import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
public class HuffmanTrees {
    // initialize list
    ListArrayBased huffmanTable = new ListArrayBased();

    TreeNode parentNode;

    String stringCode = " ";

    // main method that generates/creates the tree
    public void generateHuffman() throws FileNotFoundException, IOException {

        // read from a file
        File inputFile = new File("src/LetterCountAscending.txt");


        try (BufferedReader myBufferedReader = new BufferedReader(new FileReader(inputFile));) {

            // read the file line by line
            String line;

            int i = 1;

            while ((line = myBufferedReader.readLine()) != null) {

                String[] parts = line.split("\t");

                // add the values from the file into the freqTable List array
                huffmanTable.add(i,
                        new TreeNode(new HuffmanObjects(Integer.parseInt(parts[1]), parts[0].charAt(0))));

                i++;
            }

        }


        // while the size of the list is greater than 1
        while (huffmanTable.size() > 1) {

            // get the top 2 nodes of the array list
            TreeNode leftChild = (TreeNode) huffmanTable.get(1);
            TreeNode rightChild = (TreeNode) huffmanTable.get(2);


            // remove the first 2 nodes
            huffmanTable.remove(1);
            huffmanTable.remove(1);



            // Add the left and right node in order to get their parent and get the sum
            parentNode = new TreeNode(
                    new HuffmanObjects(leftChild.getItem().getFreq() + rightChild.getItem().getFreq(), '*'),
                    leftChild, rightChild);


            // add the parent back into the list
            huffmanTable.add(huffmanTable.size() + 1, parentNode);

            // the sort method from the list array based class to put the parent back in
            huffmanTable.bubbleSortTree();


        }
    }


    public void encoding(TreeNode treeNode, String code, char sym) {

        // if the node is not null
        if (treeNode != null) {

            // call encoding with the left child
            encoding(treeNode.getLeft(), code + "0", sym);
            // call encoding with the right child
            encoding(treeNode.getRight(), code + "1", sym);

            // check if the symbol is == to argument passed sym
            if (treeNode.getItem().getSymbol() == sym) {
                // set the string code to the code
                stringCode += code;
            }
        }
    }




    public String decoding(String code) {

        // initialize the current node to the parent node
        TreeNode currentNode = parentNode;
        // variable to store the character below
        String stringChar = "";


        // for loop to go through the code
        for (int i = 0; i <= code.length(); i++) {
            // check if the current node is not null
            if (currentNode != null) {
                // check if it is a leaf
                if (((HuffmanObjects) currentNode.getItem()).getSymbol() != '*') {
                    stringChar = stringChar + ((HuffmanObjects) currentNode.getItem()).getSymbol();
                    currentNode = parentNode;
                }

                // check if i is less than the code length
                if (i < code.length()) {
                    // check if the code at i is equal to 0
                    if (code.charAt(i) == '0') {
                        // go to the left
                        currentNode = currentNode.getLeft();
                        // check if the code at i is equal to 1
                    } else if (code.charAt(i) == '1'){
                        // go to the right
                        currentNode = currentNode.getRight();
                    }
                }

            }
        }
        // return the string
        return stringChar;
    }

    // getters and setters
    public TreeNode getParentNode() {
        return parentNode;
    }

    public String getStringCode() {
        return stringCode;
    }

public void setStringCode(String stringCode) {
        this.stringCode = stringCode;
    }




}
