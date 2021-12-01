import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
 
import javax.swing.JFrame;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.table.DefaultTableModel;


class info_Student_IU implements ActionListener {

    JFrame frame=new JFrame();
    JPanel mainPanel = new JPanel(new BorderLayout());
    JPanel topPnl = new JPanel();
    Box box = Box.createVerticalBox();
    JPanel btnPnl = new JPanel(new BorderLayout(8, 8));

    

    public int number;
    public ClassContainer Group;
    public Class obiekt;
  
    JButton button_2=new JButton("Powrot");

    info_Student_IU(Class obiekt, ClassContainer Group, int number)
    {
        this.obiekt = obiekt;
        this.Group = Group;
        this.number = number;

        InfoPanel(obiekt, number);
        prepareGUI(obiekt);
        buttonProperties();
    }
 
    public void InfoPanel(Class obiekt, int number)
    {
        Student uczen = obiekt.GetStudentFromList(number);

        // JTextArea Nazwisko = new JTextArea(5, 20);
        // JTextArea Data = new JTextArea(5, 20);
        // JTextArea Pkt = new JTextArea(5, 20);
        // JTextArea Przedmioty = new JTextArea(5, 20);
       
        JLabel label1 = new JLabel();
        label1.setText("<html><h2> Name: " + uczen.Name + "</html></h2> \n ");
        label1.setBounds(0, 0, 200, 50);
        JLabel label2 = new JLabel();
        label2.setText("<html><h2> Surname: " + uczen.Surname + "</html></h2> \n");
        label2.setBounds(0, 20, 200, 50);
        JLabel label3 = new JLabel();
        label3.setText("<html><h2> Points: " + uczen.PointsNumber + "</html></h2> \n");
        label3.setBounds(0, 40, 200, 50);
        JLabel label4 = new JLabel();
        label4.setText("<html><h2> Birth Year: " + uczen.BirthYear + "</html></h2> \n");
        label4.setBounds(0, 60, 200, 50);

        box.add(BorderLayout.CENTER,label1);
        box.add(BorderLayout.CENTER,label2);
        box.add(BorderLayout.CENTER,label3);
        box.add(BorderLayout.CENTER,label4);


    }

    public void prepareGUI(Class obiekt)
    {
        mainPanel.setSize(650,350);
        mainPanel.add(btnPnl, BorderLayout.EAST);
        mainPanel.add(box, BorderLayout.WEST);

        frame.setLocationRelativeTo(null);
        frame.setSize(700,400);
        frame.setTitle("My Window");
        frame.getContentPane().setLayout(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(mainPanel);

    }
    public void buttonProperties()
    {
       

        button_2.setPreferredSize(new Dimension(150, 200));
        btnPnl.add(button_2, BorderLayout.CENTER);
		button_2.addActionListener(this);
        

    }
 
    @Override
    public void actionPerformed(ActionEvent e) 
    {
		System.out.println("Powrot");
        frame.dispose();
        UIKlasa test2 = new UIKlasa(obiekt, Group);

    }

    

}