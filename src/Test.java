import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class Test extends JFrame {

    static HuffmanTrees generate = new HuffmanTrees();

    Container contentPane = getContentPane();
    JPanel displayPanel = new JPanel();
    JPanel topPanel = new JPanel();
    JPanel middlePanel = new JPanel();
    JPanel middleLowerPanel = new JPanel();
    JPanel bottomPanel = new JPanel();
    JLabel promptLabel = new JLabel("Text Compression: Huffman Coding");
    JTextField textField = new JTextField();
    JLabel outputLabel = new JLabel();
    JButton encodeTestButton = new JButton("Encode Test");
    JButton encodeButton = new JButton("Encode");
    JButton decodeButton = new JButton("Decode");
    JButton decodeTestButton = new JButton("Decode Test");

    // Constructor
    private Test() {
        // Setting up UI components
        displayPanel.setLayout(new BoxLayout(displayPanel, BoxLayout.PAGE_AXIS));

        //label
        promptLabel.setForeground(new Color(100, 173, 2));
        promptLabel.setFont(new Font("Helvetica", Font.BOLD, 24));

        //textField
        textField.setPreferredSize(new Dimension(350, 30));
        textField.setFont(new Font("Helvetica", Font.PLAIN, 16));

        //encodeTestButton
        encodeTestButton.setPreferredSize(new Dimension(150, 50));
        encodeTestButton.setFont(new Font("Helvetica", Font.BOLD, 18));
        encodeTestButton.setForeground(new Color(255, 99, 71));
        encodeTestButton.setBackground(new Color(173, 216, 230));

        //encodeButton
        encodeButton.setPreferredSize(new Dimension(150, 50));
        encodeButton.setFont(new Font("Helvetica", Font.BOLD, 18));
        encodeButton.setForeground(new Color(255, 99, 71));
        encodeButton.setBackground(new Color(173, 216, 230));

        //decodeButton
        decodeButton.setPreferredSize(new Dimension(150, 50));
        decodeButton.setFont(new Font("Helvetica", Font.BOLD, 18));
        decodeButton.setForeground(new Color(172, 216, 230));
        decodeButton.setBackground(new Color(255, 166, 77));

        //decodeTestButton
        decodeTestButton.setPreferredSize(new Dimension(150, 50));
        decodeTestButton.setFont(new Font("Helvetica", Font.BOLD, 18));
        decodeTestButton.setForeground(new Color(172, 216, 230));
        decodeTestButton.setBackground(new Color(255, 166, 77));

        //outputLabel
        outputLabel.setForeground(new Color(0, 128, 0));
        outputLabel.setFont(new Font("Helvetica", Font.BOLD, 18));


        // panels
        topPanel.setBackground(new Color(240, 248, 255));
        middlePanel.setBackground(new Color(240, 248, 255));
        middleLowerPanel.setBackground(new Color(240, 248, 255));
        bottomPanel.setBackground(new Color(240, 248, 255));


        // Adding components to panels
        topPanel.add(promptLabel);
        middlePanel.add(textField);
        middleLowerPanel.add(encodeTestButton, BorderLayout.EAST);
        middleLowerPanel.add(encodeButton, BorderLayout.EAST);
        middleLowerPanel.add(decodeButton, BorderLayout.WEST);
        middleLowerPanel.add(decodeTestButton, BorderLayout.WEST);
        bottomPanel.add(outputLabel);

        // Adding action listeners to buttons
        encodeTestButton.addActionListener(e -> {
            // Encode "Test"
            generate.setStringCode("");

            // Encode "Test"
            String isValidInput = "TEST";
            for (int i = 0; i < isValidInput.length(); i++) {
                generate.encoding(generate.getParentNode(), "", isValidInput.charAt(i));
            }

            String stringCode = generate.getStringCode();

            outputLabel.setText(stringCode);
            outputLabel.setForeground(new Color(0, 128, 0));
        });

        // Adding action listeners to buttons
        encodeButton.addActionListener(e -> {
            generate.setStringCode("");

            String isValidInput = textField.getText().toUpperCase();


            int inputLength = isValidInput.length();

            if (isValidInput.matches("[A-Z]+")) {
                for (int i = 0; i < inputLength; i++) {
                    generate.encoding(generate.getParentNode(), "", isValidInput.charAt(i));
                }

                String stringCode = generate.getStringCode();

                outputLabel.setText(stringCode);
                outputLabel.setForeground(new Color(0, 128, 0));
            } else {
                outputLabel.setText("Please enter only letters!");
                outputLabel.setForeground(new Color(255, 0, 0));
            }
        });

        decodeButton.addActionListener(e -> {
            String isValidInput = textField.getText();

            if (isValidInput.matches("[0-1]+")) {
                outputLabel.setText(generate.decoding(isValidInput));
                outputLabel.setForeground(new Color(0, 128, 0));
            } else {
                outputLabel.setText("Please enter only 0's and 1's!");
                outputLabel.setForeground(new Color(255, 0, 0));
            }
        });

        decodeTestButton.addActionListener(e -> {
            String isValidInput = "0000111001000";

            outputLabel.setText(generate.decoding(isValidInput));
            outputLabel.setForeground(new Color(0, 128, 0));
        });


        // Adding panels to the content pane
        contentPane.add(displayPanel);
        displayPanel.add(topPanel);
        displayPanel.add(middlePanel);
        displayPanel.add(middleLowerPanel);
        displayPanel.add(bottomPanel);

        // Setting up the frame
        setVisible(true);
        setSize(650, 450);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setTitle("Project");
    }

    // Method to set up buttons
    public static void main(String[] args) throws IOException {
        generate.generateHuffman();
        new Test();
    }
}
