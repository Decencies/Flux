package club.decencies.flux;

public class Flux {

    protected Flux(String version, boolean debug) {
        if (version == null) {
            initGui();
        } else {
            System.out.println(version);
        }
    }

    protected void initGui() {
        LookAndFeel.init();
        LookAndFeel.setLookAndFeel();
        new FluxWindow(this).setVisible(true);
    }

    protected String getVersion() {
        return "1.0-SNAPSHOT";
    }

}
