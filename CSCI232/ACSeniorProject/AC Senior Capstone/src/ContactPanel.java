import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JPanel;
import javax.swing.JTextArea;

/**
 * @author Daniel
 */
public class ContactPanel extends JPanel {

    public JTextArea firstNameField;
    //private AudioInputStream audioInputStream;
    public String lines;

    public ContactPanel() {

        int count = 0;

        setLayout(new GridLayout(1, 1));

        firstNameField = new JTextArea();
        add(firstNameField);

        firstNameField.setText("Hansel and Gretel");
        firstNameField.setEditable(false);
        firstNameField.setLineWrap(true);
        firstNameField.setWrapStyleWord(true);
        firstNameField.setBackground(Color.white);
        
        Font font1 = new Font("SansSerif", Font.BOLD, 70);
        firstNameField.setFont(font1);
        
    }

    public void clearFields(int count) throws IOException {

        BufferedReader in = null;
        Font font1 = new Font("SansSerif", Font.BOLD, 70);
        Font font2 = new Font("SansSerif", Font.PLAIN, 18);

        if (count < 1) {
            firstNameField.setText("Hansel and Gretel");
            firstNameField.setBackground(Color.white);
            firstNameField.setFont(font1);
        }
        if (count == 1) {
            firstNameField.setText("");
            firstNameField.setFont(font2);
            try {
                in = new BufferedReader(new FileReader("text1.txt"));
                String str;
                while ((str = in.readLine()) != null) {
                    firstNameField.append(str);
                    if (str.equals("")) {
                        firstNameField.append("\n");
                        firstNameField.append("\n");
                    }
                }
            } catch (IOException e) {
            } finally {
                try {
                    in.close();
                } catch (Exception ex) {
                }
            }
            firstNameField.setBackground(Color.white);
        } else if (count == 2) {
            firstNameField.setText("");
            firstNameField.setFont(font2);
            try {
                in = new BufferedReader(new FileReader("text2.txt"));
                String str;
                while ((str = in.readLine()) != null) {
                    firstNameField.append(str);
                    if (str.equals("")) {
                        firstNameField.append("\n");
                        firstNameField.append("\n");
                    }
                }
            } catch (IOException e) {
            } finally {
                try {
                    in.close();
                } catch (Exception ex) {
                }
            }
            firstNameField.setBackground(Color.white);
        } else if (count == 3) {
            firstNameField.setText("");
            firstNameField.setFont(font2);
            try {
                in = new BufferedReader(new FileReader("text3.txt"));
                String str;
                while ((str = in.readLine()) != null) {
                    firstNameField.append(str);
                    if (str.equals("")) {
                        firstNameField.append("\n");
                        firstNameField.append("\n");
                    }
                }
            } catch (IOException e) {
            } finally {
                try {
                    in.close();
                } catch (Exception ex) {
                }
            }
            firstNameField.setBackground(Color.white);
        } else if (count == 4) {
            firstNameField.setText("");
            firstNameField.setFont(font2);
            try {
                in = new BufferedReader(new FileReader("text4.txt"));
                String str;
                while ((str = in.readLine()) != null) {
                    firstNameField.append(str);
                    if (str.equals("")) {
                        firstNameField.append("\n");
                        firstNameField.append("\n");
                    }
                }
            } catch (IOException e) {
            } finally {
                try {
                    in.close();
                } catch (Exception ex) {
                }
            }
            firstNameField.setBackground(Color.white);
        } else if (count == 5) {
            firstNameField.setText("");
            firstNameField.setFont(font2);
            try {
                in = new BufferedReader(new FileReader("text5.txt"));
                String str;
                while ((str = in.readLine()) != null) {
                    firstNameField.append(str);
                    if (str.equals("")) {
                        firstNameField.append("\n");
                        firstNameField.append("\n");
                    }
                }
            } catch (IOException e) {
            } finally {
                try {
                    in.close();
                } catch (Exception ex) {
                }
            }
            firstNameField.setBackground(Color.white);
        } else if (count == 6) {
            firstNameField.setText("");
            firstNameField.setFont(font2);
            try {
                in = new BufferedReader(new FileReader("text6.txt"));
                String str;
                while ((str = in.readLine()) != null) {
                    firstNameField.append(str);
                    if (str.equals("")) {
                        firstNameField.append("\n");
                        firstNameField.append("\n");
                    }
                }
            } catch (IOException e) {
            } finally {
                try {
                    in.close();
                } catch (Exception ex) {
                }
            }
            firstNameField.setBackground(Color.white);
        } else if (count == 7) {
            firstNameField.setText("");
            firstNameField.setFont(font2);
            try {
                in = new BufferedReader(new FileReader("text7.txt"));
                String str;
                while ((str = in.readLine()) != null) {
                    firstNameField.append(str);
                    if (str.equals("")) {
                        firstNameField.append("\n");
                        firstNameField.append("\n");
                    }
                }
            } catch (IOException e) {
            } finally {
                try {
                    in.close();
                } catch (Exception ex) {
                }
            }
            firstNameField.setBackground(Color.white);
        } else if (count == 8) {
            firstNameField.setText("");
            firstNameField.setFont(font2);
            try {
                in = new BufferedReader(new FileReader("text8.txt"));
                String str;
                while ((str = in.readLine()) != null) {
                    firstNameField.append(str);
                    if (str.equals("")) {
                        firstNameField.append("\n");
                        firstNameField.append("\n");
                    }
                }
            } catch (IOException e) {
            } finally {
                try {
                    in.close();
                } catch (Exception ex) {
                }
            }
            firstNameField.setBackground(Color.white);
        } else if (count == 9) {
            firstNameField.setText("");
            firstNameField.setFont(font2);
            try {
                in = new BufferedReader(new FileReader("text9.txt"));
                String str;
                while ((str = in.readLine()) != null) {
                    firstNameField.append(str);
                    if (str.equals("")) {
                        firstNameField.append("\n");
                        firstNameField.append("\n");
                    }
                }
            } catch (IOException e) {
            } finally {
                try {
                    in.close();
                } catch (Exception ex) {
                }
            }
            firstNameField.setBackground(Color.white);
        } else if (count > 9) {
            firstNameField.setFont(font1);
            firstNameField.setText("The End");
        }
    }
}
