import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Main extends JFrame implements ActionListener {

    private JTextArea jTextArea;
    private JList<String> fileList;
    private List<String> filNavne = new ArrayList<>(); // data liste
    private JButton saveButton;

    public static void main(String[] args) {
	    new Main().setVisible(true);
    }

    public Main(){
        super("JavaNotes");
        setSize(500,500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        lavDataListe();
        setupComponents();
    }

    private void lavDataListe() {
        filNavne.add("dagbog");
        filNavne.add("to-do");
        filNavne.add("gode film");
        filNavne.add("koncerter");
        filNavne.add("opskrifter");
    }

    private void setupComponents(){
        setLayout(new BorderLayout());
        jTextArea = new JTextArea(20, 30);//
        add(jTextArea, BorderLayout.CENTER);  // tilføj til GUI
        makeJList();
        saveButton = new JButton("Save");
        saveButton.addActionListener(this); // Main klassen har en actionPerformed() metode,
        // og Main implementerer ActionListener interfacet. DERFOR er det tilladt at angive
        // this som parameter.
        add(saveButton, BorderLayout.PAGE_END);

    }

    private void makeJList() {
        fileList = new JList<>(); // GUI liste
        fileList.setBackground(Color.LIGHT_GRAY);
        fileList.setModel(new AbstractListModel<String>() {
            @Override
            public int getSize() {
                return filNavne.size();
            }

            @Override
            public String getElementAt(int index) {
                return filNavne.get(index);
            }
        });
        fileList.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                jTextArea.setText(fileList.getSelectedValue());
            }
        });
        add(fileList, BorderLayout.LINE_START);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Date date = new Date(); // brug denne til at gemme en "timestamp" til den aktuelle note.
        System.out.println("klik modtaget " + date.getTime());

    }
}
