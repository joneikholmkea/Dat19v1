import model.Note;
import repo.NoteRepo;

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
   // private List<String> filNavne = new ArrayList<>(); // data liste
    private JButton saveButton;
    private int currentIndex = 0;
    public static void main(String[] args) {
	    new Main().setVisible(true);
    }

    public Main(){
        super("JavaNotes");
        setSize(500,500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // sørg for at sortere her, før vi laver GUI listen
        NoteRepo.init();
        setupComponents();
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
                return NoteRepo.getSize();
            }

            @Override
            public String getElementAt(int index) {
                return NoteRepo.getNoteAt(index).getNavn();
            }
        });
        fileList.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                currentIndex = fileList.getSelectedIndex();
                String txt = NoteRepo.getNoteAt(currentIndex).getTekst();
                jTextArea.setText(txt);
            }
        });
        add(fileList, BorderLayout.LINE_START);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Note aktuelNote = NoteRepo.getNoteAt(currentIndex); // kan også fås via jList
        aktuelNote.setTekst(jTextArea.getText());
        aktuelNote.setTid(new Date().getTime()); // getTime() giver os antal millisek. fra 1970.
        NoteRepo.updateNoteAt(currentIndex, aktuelNote);
    }
}
