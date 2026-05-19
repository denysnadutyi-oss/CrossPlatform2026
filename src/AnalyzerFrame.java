import javax.swing.*;
import java.awt.*;

public class AnalyzerFrame extends JFrame {

    private JTextField classField;

    private JTextArea resultArea;

    private JButton analyzeButton;

    private JButton clearButton;

    private JButton exitButton;

    public AnalyzerFrame() {

        setTitle("Аналізатор класів Java Reflection");

        setSize(900, 600);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLocationRelativeTo(null);

        initComponents();

        setVisible(true);
    }

    private void initComponents() {

        classField = new JTextField(30);

        resultArea = new JTextArea();

        resultArea.setEditable(false);

        resultArea.setFont(new Font("Monospaced", Font.PLAIN, 14));

        JScrollPane scrollPane = new JScrollPane(resultArea);

        analyzeButton = new JButton("Аналізувати");

        clearButton = new JButton("Очистити");

        exitButton = new JButton("Завершити");

        JPanel topPanel = new JPanel();

        topPanel.add(new JLabel("Ім'я класу: "));

        topPanel.add(classField);

        topPanel.add(analyzeButton);

        topPanel.add(clearButton);

        topPanel.add(exitButton);

        add(topPanel, BorderLayout.NORTH);

        add(scrollPane, BorderLayout.CENTER);

        analyzeButton.addActionListener(e -> analyzeClass());

        clearButton.addActionListener(e -> clearFields());

        exitButton.addActionListener(e -> exitProgram());
    }

    private void analyzeClass() {

        String className = classField.getText().trim();

        if (className.isEmpty()) {

            JOptionPane.showMessageDialog(
                    this,
                    "Введіть ім'я класу!",
                    "Помилка",
                    JOptionPane.ERROR_MESSAGE
            );

            return;
        }

        String result = ClassAnalyzer.analyzeClass(className);

        resultArea.setText(result);
    }

    private void clearFields() {

        classField.setText("");

        resultArea.setText("");
    }

    private void exitProgram() {

        int choice = JOptionPane.showConfirmDialog(
                this,
                "Ви дійсно хочете завершити програму?",
                "Підтвердження",
                JOptionPane.YES_NO_OPTION
        );

        if (choice == JOptionPane.YES_OPTION) {

            System.exit(0);
        }
    }
}