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


public class UIKlasa implements ActionListener {

    JFrame frame=new JFrame();

    JButton button_1=new JButton("Dodaj ucznia");
    JButton button_2=new JButton("Usun ucznia");
    JButton button_3=new JButton("Powrot");
    JButton button_4=new JButton("Sortuj");

    JPanel mainPanel = new JPanel(new BorderLayout());
    JPanel topPnl = new JPanel();
    Box box = Box.createVerticalBox();
    JPanel btnPnl = new JPanel(new BorderLayout(8, 8));

    DefaultTableModel model = new DefaultTableModel();
    javax.swing.JTable jTable1 = new javax.swing.JTable(model);


    public ClassContainer Group;
    public Class obiekt;

       
    UIKlasa(Class obiekt, ClassContainer Group)
    {
        this.Group = Group;
        this.obiekt = obiekt;
        prepareGUI(obiekt);
        buttonProperties();
    }

    

    

 
    public javax.swing.JTable prepareTable(Class obiekt)
    {
        String[][] dane = obiekt.GUI_Output();

        model = new DefaultTableModel();
        jTable1 = new javax.swing.JTable(model); 
        jTable1.setDefaultEditor(Object.class, null);




        jTable1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                int r = jTable1.rowAtPoint(e.getPoint());
                if (r >= 0 && r < jTable1.getRowCount()) 
                {
                    jTable1.setRowSelectionInterval(r, r);
                    System.out.println(r);
                    
                    frame.dispose();
                    info_Student_IU test = new info_Student_IU(obiekt, Group, r);
                    

                } else {
                    jTable1.clearSelection();
                }
        
                int rowindex = jTable1.getSelectedRow();
                if (rowindex < 0)
                    return;
                if (e.isPopupTrigger() && e.getComponent() instanceof JTable ) 
                {
                    //JPopupMenu popup = createYourPopUp();
                    //popup.show(e.getComponent(), e.getX(), e.getY());
                }
            }
        });





        model.addColumn("Imie");
        model.addColumn("Nazwisko");
        model.addColumn("Obecnosc");

        for (int i = 0; i < dane.length; i++) 
        {
    
            model.addRow(new Object[]{dane[i][0], dane[i][1], dane[i][2]});
            
        }

        return jTable1;
    }

    public void prepareGUI(Class obiekt)
    {
        mainPanel.setSize(650,350);

        topPnl.setLayout(new GridLayout(1,1));

        JScrollPane sp=new JScrollPane(prepareTable(obiekt));   
        topPnl.add(sp);

        mainPanel.add(topPnl, BorderLayout.WEST);
        mainPanel.add(box, BorderLayout.EAST);

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
        button_1.setSize(200, 200);
        box.add(button_1);
        button_1.addActionListener(this);

        button_2.setSize(200, 200);
        box.add(button_2);
		button_2.addActionListener(new ButtonBListener());
        
        button_3.setSize(200, 200);
        box.add(button_3);
		button_3.addActionListener(new ButtonCListener());

        button_4.setSize(200, 200);
        box.add(button_4);
		button_4.addActionListener(new ButtonDListener());


    }
 
    @Override
    public void actionPerformed(ActionEvent e) 
    {
		System.out.println("Dodaj ucznia");
        frame.dispose();
        DodajUcznia zxc = new DodajUcznia(obiekt, Group);
    }

    private class ButtonBListener implements ActionListener
	{
		@Override

		public void actionPerformed(ActionEvent e)
		{
			System.out.println("Usun ucznia");


            frame.dispose();
            usun test = new usun(obiekt, Group);  

		}
	}

    private class ButtonCListener implements ActionListener
	{
		@Override

		public void actionPerformed(ActionEvent e)
		{
			System.out.println("Powrot");

            frame.dispose();
            SwingWindow test = new SwingWindow(Group);
		}
	}

    private class ButtonDListener implements ActionListener
	{
		@Override

		public void actionPerformed(ActionEvent e)
		{
			System.out.println("Sortowanko");

            // aktualizacja listy stud
            obiekt.SetStudentsList(obiekt.sortByNameUI(obiekt.students));

            frame.dispose();
            UIKlasa test = new UIKlasa(obiekt, Group);
		}
	}
}