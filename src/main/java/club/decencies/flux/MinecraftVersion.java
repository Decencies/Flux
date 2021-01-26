package club.decencies.flux;

public class MinecraftVersion {

    public String displayName;
    public String url;

    public MinecraftVersion(String displayName) {
        this.displayName = displayName;
    }

    @Override
    public String toString() {
        return displayName;
    }
}
