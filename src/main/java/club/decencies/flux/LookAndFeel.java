package club.decencies.flux;

import com.github.weisj.darklaf.LafManager;
import com.github.weisj.darklaf.theme.DarculaTheme;
import com.github.weisj.darklaf.theme.IntelliJTheme;
import com.github.weisj.darklaf.theme.Theme;
import com.github.weisj.darklaf.theme.info.DefaultThemeProvider;

import javax.swing.plaf.ColorUIResource;
import java.awt.*;

public class LookAndFeel {

    public static void init() {
        LafManager.setThemeProvider(new DefaultThemeProvider(new IntelliJTheme(), new DarculaTheme()));
    }

    public static void setLookAndFeel() {
        LafManager.enableLogging(true);
        LafManager.registerDefaultsAdjustmentTask((t, d) -> {
            if (Theme.isDark(t)) {
                Object p = d.get("backgroundContainer");
                if (p instanceof Color) {
                    d.put("backgroundContainer", new ColorUIResource(((Color) p).darker()));
                }
            }
        });
        LafManager.installTheme(LafManager.getPreferredThemeStyle());
    }

}

