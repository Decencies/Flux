package club.decencies.flux;

import joptsimple.OptionParser;
import joptsimple.OptionSet;
import joptsimple.OptionSpec;

public class Main {

    public static void main(String[] args) {
        OptionParser optionparser = new OptionParser();
        optionparser.allowsUnrecognizedOptions();
        optionparser.accepts("debug");
        OptionSpec<String> version = optionparser.accepts("version").withOptionalArg();
        OptionSet set = optionparser.parse(args);
        new Flux(set.valueOf(version), set.has("debug"));
    }

}
