import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class FirstGUI extends JFrame{
    private JPanel jpanel;
    private JButton clickMeForHotButton;
    private JTextField name_input;
    private JLabel enter_name;
    private JRadioButton rbMale;
    private JRadioButton rbFemale;
    private JRadioButton rbAttackHeli;
    private JTextArea textArea1;
    private JComboBox comboBox1;
    private JCheckBox cCheckBox;
    private JCheckBox JAVACheckBox;
    private JCheckBox cCheckBox1;
    private JProgressBar progressBar1;

    public FirstGUI() {
        FirstGUI a = this;
        clickMeForHotButton.addActionListener(e -> {
            progressBar1.setValue(progressBar1.getValue()+30);
            String name = name_input.getText();
            if(name.equals("") || comboBox1.getSelectedIndex()==0){
                if(comboBox1.getSelectedIndex()==0){
                    int opt = JOptionPane.showConfirmDialog(this, "No program? I will set to CS");
                            if(opt == JOptionPane.YES_OPTION){
                                comboBox1.setSelectedIndex(1);
                            }
                            else{
                                return;
                            }
                }
                JOptionPane.showMessageDialog(a, "INVALID");

            }
            if(name.equals("")){
                name = JOptionPane.showInputDialog("What is your name");
                name_input.setText(name);
                textArea1.append("\n");
            }

            else{
                textArea1.append("Hello my " + name + "\n");
                if(rbMale.isSelected()){
                    textArea1.append("You are male :)");
                }
                else if(rbFemale.isSelected()){
                    textArea1.append("You are female :)");
                }
                else if(rbAttackHeli.isSelected()){
                    textArea1.append("You are an attack helicopter :)");
                }
                textArea1.append("\n");
                String prog = (String) comboBox1.getSelectedItem();
                textArea1.append("Course is "+ prog);
                textArea1.append("\n");

                textArea1.append("You know ");
                if(cCheckBox.isSelected()){
                    textArea1.append("C++");
                }
                else if(JAVACheckBox.isSelected()){
                    textArea1.append("JAVA");
                }
                else if(cCheckBox1.isSelected()){
                    textArea1.append("C");
                }
                else{
                    textArea1.append("No languages");
                }
                textArea1.append("\n");
            }


        });
    }

    public static void main(String[] args) {
        FirstGUI app = new FirstGUI();

        app.setContentPane(app.jpanel);
        app.setSize(700,300);
        app.setDefaultCloseOperation(EXIT_ON_CLOSE);
        app.setVisible(true);
        app.setTitle("Hot Videos Downloader");
    }
}
