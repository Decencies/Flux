package club.decencies.flux;

import javax.swing.*;
import javax.swing.text.DefaultCaret;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class FluxWindow extends JFrame {

    Flux flux;

    public FluxWindow(Flux fluxInstance) {
        setTitle("Flux " + (flux = fluxInstance).getVersion());
        setQuitOnWindowClosing();
        setWindowPositionAndSize(368, 154);
        setResizable(false);

        JLabel label = new JLabel("Minecraft Version: ");
        label.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 14));
        label.setBounds(20, 20, 144, 20);
        add(label);

        JComboBox<MinecraftVersion> versionsComboBox = new JComboBox<>();
        Util.getVersions().forEach(versionsComboBox::addItem);
        versionsComboBox.setFocusable(false);
        versionsComboBox.setBounds(144, 16, 200, 28);
        add(versionsComboBox);


        label = new JLabel("Mappings Version: ");
        label.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 14));
        label.setBounds(20, 52, 144, 20);
        add(label);

        JComboBox<String> mappingsComboBox = new JComboBox<>();
        mappingsComboBox.setEnabled(false);
        mappingsComboBox.setFocusable(false);
        mappingsComboBox.setBounds(144, 48, 200, 28);
        add(mappingsComboBox);

        versionsComboBox.addActionListener(e -> {
            MinecraftVersion version = (MinecraftVersion) versionsComboBox.getSelectedItem();
            mappingsComboBox.removeAllItems();
            //mappingsComboBox.addItem(version.displayName);
        });

        JButton decompileButton = new JButton("Decompile");
        decompileButton.setFocusable(false);
        decompileButton.setBounds(20, 82, 90, 28);
        add(decompileButton);

        setLayout(new BorderLayout());

        JTextArea logs = new JTextArea();
        DefaultCaret caret = (DefaultCaret) logs.getCaret();
        caret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);
        logs.setBounds(20, 128, 324, 188);
        logs.setEditable(false);

        add(new JScrollPane(logs), BorderLayout.CENTER);

        decompileButton.addActionListener(e -> {
            setWindowPositionAndSize(368, 360);
            logs.append("Hello, World!\n");
        });

        setLayout(null);
    }

    private void setQuitOnWindowClosing() {
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent event) {
                System.exit(0);
            }
        });
    }

    /**
     * Sets the window's position and size according to the display size.
     */
    private void setWindowPositionAndSize(int width, int height) {
        final Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        final Dimension center = new Dimension(width, height);
        final int x = screenSize.width / 2 - center.width / 2;
        final int y = screenSize.height / 2 - center.height / 2;
        setBounds(x, y, center.width, center.height);
    }


}
