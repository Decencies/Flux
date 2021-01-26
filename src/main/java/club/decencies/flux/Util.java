package club.decencies.flux;

import java.io.File;
import java.io.FileFilter;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.CopyOnWriteArrayList;

public class Util {

    public static File getMinecraftFolder() {
        final String system = System.getProperty("os.name").toLowerCase();
        File file;
        if (!system.contains("win") || !(file = new File(new File(System.getenv("APPDATA")), ".minecraft")).exists()) {
            if (!system.contains("mac") || !(file = new File(new File(System.getProperty("user.home")), "Library/Application Support/minecraft")).exists()) {
                throw new RuntimeException("Failed to determine Minecraft directory");
            }
        }
        return file;
    }

    public static List<MinecraftVersion> getVersions() {
        List<MinecraftVersion> list = new CopyOnWriteArrayList<>();
        File file = new File(getMinecraftFolder(), "versions");
        for (File listFile : Objects.requireNonNull(file.listFiles(getVersionFilter()))) {
            list.add(new MinecraftVersion(listFile.getName()));
        }
        return list;
    }

    private static FileFilter getVersionFilter() {
        return (file) -> {
            boolean result = file.isDirectory();
            result = result && Objects.requireNonNull(file.listFiles()).length == 2;
            return result;
        };
    }

}
