package club.decencies.flux;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class FluxWindow extends JFrame {

    Flux flux;

    public FluxWindow(Flux fluxInstance) {
        setTitle("Flux " + (flux = fluxInstance).getVersion());
        setQuitOnWindowClosing();
        setWindowPositionAndSize();
        setResizable(false);

        JLabel label = new JLabel("Minecraft Version: ");
        label.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 14));
        label.setBounds(20, 20, 120, 20);
        add(label);

        JComboBox<String> comboBox = new JComboBox<>();
        Util.getVersions().forEach(v -> comboBox.addItem(v.displayName));
        comboBox.setFocusable(false);
        comboBox.setBounds(144, 16, 200, 28);
        add(comboBox);

        JButton decompileButton = new JButton("Decompile");
        decompileButton.setBounds(20, 52, 90, 28);
        add(decompileButton);

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
    private void setWindowPositionAndSize() {
        final Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        final Dimension center = new Dimension(520, 360);
        final int x = screenSize.width / 2 - center.width / 2;
        final int y = screenSize.height / 2 - center.height / 2;
        setBounds(x, y, center.width, center.height);
    }


}
