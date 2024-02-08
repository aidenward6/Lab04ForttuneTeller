import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Random;

public class FortuneTellerFrame extends JFrame {

    public FortuneTellerFrame() {
        JPanel mainPnl, topPnl, middlePnl, bottomPnl;


        //Icon Resizing
        ImageIcon icon;
        icon = new ImageIcon("src/icon.png");
        Image image = icon.getImage().getScaledInstance(80, 80, Image.SCALE_SMOOTH);
        ImageIcon resizedIcon = new ImageIcon(image);

        //arraylist
        ArrayList<Integer> check = new ArrayList<>();


        //JLabel with font modifications
        JLabel titleLbl = new JLabel("Fortune Teller", resizedIcon, JLabel.CENTER);
        Font titleFont = new Font("Arial", Font.BOLD, 36);
        titleLbl.setFont(titleFont);


        //Declaring textAra and JScrollPane w font mods
        TextArea textArea = new TextArea(35, 60);
        JScrollPane scroller = new JScrollPane(textArea);
        Font taFont = new Font("Serif", Font.BOLD, 12);
        textArea.setFont(taFont);


        //Creating ArrayList fortunes
        ArrayList<String> fortunes = new ArrayList<>();
        fortunes.add("Children should inherit debt");
        fortunes.add("You're adopted");
        fortunes.add("You have no lucky numbers");
        fortunes.add("Santa isn't real");
        fortunes.add("I hope you stub your toe");
        fortunes.add("You forgot to lock your front door");
        fortunes.add("Your fridge ran away");
        fortunes.add("I'm watching");
        fortunes.add("I cracked all of your eggs");
        fortunes.add("You definitely left your water running");
        fortunes.add("My haters won");
        fortunes.add("You're in a simulation");


        //Declaring Buttons for Bottom Panel w font mods
        JButton rmfBut = new JButton("Read My Fortune");
        JButton quitBut = new JButton("Quit");
        Font butFont = new Font("Helvetica", Font.ITALIC, 15);
        rmfBut.setFont(butFont);


        quitBut.setFont(butFont);





        mainPnl = new JPanel();
        topPnl = new JPanel();
        middlePnl = new JPanel();
        bottomPnl = new JPanel();

        add(mainPnl);

        mainPnl.setLayout(new BorderLayout());


        //Main Panel
        mainPnl.add(topPnl, BorderLayout.NORTH);
        topPnl.add(titleLbl);


        //Middle Panel
        mainPnl.add(middlePnl, BorderLayout.CENTER);
        middlePnl.add(scroller);


        //Bottom Panel
        mainPnl.add(bottomPnl, BorderLayout.SOUTH);
        //setting button layout
        bottomPnl.setLayout(new GridLayout(1, 2));

        bottomPnl.add(rmfBut);

        rmfBut.addActionListener((ActionEvent fe) -> {
            Random rnd = new Random();
            int previousNum;
            int x;

            if (check.size() < 1) {
                previousNum = 0;
            } else {
                previousNum = check.size() - 1;
            }
            do {
                x = rnd.nextInt(fortunes.size());
                check.add(x);
            } while (x == check.get(previousNum));

            textArea.append(fortunes.get(x) + "\n");
        });

        quitBut.addActionListener((ActionEvent ae) -> System.exit(0));







            bottomPnl.add(quitBut);


            setSize(600, 800);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setVisible(true);


        }

    }




