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

public class SwingWindow extends JFrame implements ActionListener {
    
    private JLabel label;
	public JButton buttonA, buttonB;
    private JTextField TxtArea;
    private DefaultTableModel model;
    private javax.swing.JTable jTable1; 
    private JFrame frame = new JFrame();

    public ClassContainer Group;

    public SwingWindow(ClassContainer Group)
    {
        this.Group = Group;
        createInstances();
        addButtonListeners();
        addToFrame(Group);
    }
   

    private void createInstances()
	{
		label = new JLabel("Tekst", SwingConstants.CENTER);
        buttonA = new JButton("Dodaj Klase");
		buttonB = new JButton("Usun klase");
        TxtArea = new JTextField("Tu wpisz swój tekst...", 22);

       

	}

    private void addButtonListeners()
	{
		buttonA.addActionListener(this);
		buttonB.addActionListener(new ButtonBListener());

	}


    private javax.swing.JTable MakeTable(ClassContainer Group)
    {
        List<String> NamesGroups = Group.summaryNames();
        String[] array = new String[NamesGroups.size()];
        for(int i = 0; i < NamesGroups.size(); i++) array[i] = NamesGroups.get(i);

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
                    System.out.println(array[r]);
                    Class obiekt = Group.GetClass(array[r]);
                    
                    //frame.setVisible(false);
                    frame.dispose();
                    UIKlasa test2 = new UIKlasa(obiekt, Group);
                    


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


        model.addColumn("Klasa");
        for (String item:NamesGroups)
        {
            model.addRow(new Object[]{item});
        }

        return jTable1;
    }




    private void addToFrame(ClassContainer Group)
	{   
        

        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setSize(650,350);

        JPanel topPnl = new JPanel();
        topPnl.setLayout(new GridLayout(1,1));

        JPanel btnPnl = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        
        buttonA.setPreferredSize(new Dimension(115, 100));
        buttonB.setPreferredSize(new Dimension(115, 100));


        btnPnl.add(BorderLayout.CENTER, buttonA);
        btnPnl.add(BorderLayout.CENTER, buttonB);

        JScrollPane sp=new JScrollPane(MakeTable(Group));   
        topPnl.add(sp);

        mainPanel.add(topPnl, BorderLayout.WEST);
        mainPanel.add(btnPnl, BorderLayout.EAST);


        frame.setLocationRelativeTo(null);
        frame.setSize(700,400);
        frame.add(mainPanel);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

    



    @Override
	public void actionPerformed(ActionEvent e)
	{
		System.out.println("Dodaj klase");
        frame.dispose();
        DodajKlasa dodajd = new DodajKlasa(Group);
	}




	private class ButtonBListener implements ActionListener
	{
		@Override

		public void actionPerformed(ActionEvent e)
		{
			System.out.println("Usun klase");
            frame.dispose();
            usunKlasa testzz = new usunKlasa(Group);
		}
	}

   






}
