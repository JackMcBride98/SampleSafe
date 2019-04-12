import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ImportOptionFrame extends CustomPopUp {

    public ImportOptionFrame(ArrayList<Library> libs, JButton parent, ActionListener act) {
        super(160, 100, parent);

        this.setLayout(new BoxLayout( getContentPane(), BoxLayout.Y_AXIS));
        JPanel title = new JPanel();
        title.setLayout(new FlowLayout());
        title.add(new JLabel("Import to: "));
        this.add(title, BorderLayout.PAGE_START);

        JPanel buttons = new JPanel();
        buttons.setLayout(new BoxLayout(buttons, BoxLayout.Y_AXIS));

        for (Library lib : libs){
            JButton nb = new JButton(lib.getTitle());
            nb.setPreferredSize(new Dimension(150, 30));
            nb.addActionListener(act);
            JPanel p = new JPanel();
            p.add(nb);

            buttons.add(p);
        }

        JScrollPane jsp = new JScrollPane(buttons, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        jsp.getVerticalScrollBar().setUnitIncrement(0x0A);
        jsp.setPreferredSize(new Dimension(150, 100));
        this.add(jsp);

        JPanel newLibPanel = new JPanel();

        JButton btnNewLib  = new JButton("Create");
        btnNewLib.setEnabled(false);
        JTextField txtlib  = new JTextField(16);

        btnNewLib.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JButton newLibrary = new JButton(txtlib.getText());
                newLibrary.addActionListener(act);
                newLibrary.doClick();
            }
        });

        txtlib.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                changed();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                changed();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                changed();
            }

            public void changed(){
                    btnNewLib.setEnabled((txtlib.getText().length() > 0));
            }
        });

        newLibPanel.add(txtlib);
        newLibPanel.add(btnNewLib);
        this.add(newLibPanel);
        this.pack();
    }
}
