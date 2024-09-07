package armagedon.client.UserInterface;

import java.util.HashMap;
import java.util.Map;

public class CommandHandler {
    public static final String USAGE = "Usage: armagedon [options]\n" +
            "-h, --help          show basic help message and exit\n" +
            "-hh                 show advanced help message and exit\n" +
            "--version           show program's version number and exit\n" +
            "-v                  verbose verbosity level 0-6 default 1\n" +
            "Target:\n" +
            "-u URL, --url=URL   Target URL (e.g. http://www.site.com)\n";

    private Map<String, String> commands;

    public CommandHandler() {
        commands = new HashMap<>();
    }

    public void handleCommand(String[] args) {
        if (args.length ==0) {
            printUsage();
            return;
        }

        for (String arg : args) {
            if (arg.startsWith("-")){
                processOption(arg);
            } else {
                processArgument(arg);
            }
        }
    }
    private void processOption(String option) {
        switch (option) {
            case "-h":
            case "--help":
                printUsage();
                break;
            case "-hh":
                printAdvancedHelp();
                break;
            case "--version":
                printVersion();
                break;
            case "-v":
                // handle verbose level, if followed by a number
                break;
            default:
                System.out.println("Unknown option: " + option);
                printUsage();
                break;
        }
    }

    private void processArgument(String arg) {
        if (arg.startsWith("-u") || arg.startsWith("--url")) {
            String[] parts = arg.split("=", 2);
            if (parts.length == 2) {
                String url = parts[1];
                if (isValidUrl(url)) {
                    commands.put("url", url);
                } else {
                    System.out.println("Invalid URL format: " + url);
                    printUsage();
                }
            } else {
                System.out.println("Missing URL after option: " + arg);
                printUsage();
            }
        } else {
            System.out.println("Unknown argument: " + arg);
            printUsage();
        }
    }

    private boolean isValidUrl(String url) {
        // Simple URL validation for demonstration purposes
        return url != null && url.matches("http(s)?://[\\w.-]+");
    }

    private void printUsage() {
        System.out.println(USAGE);
    }

    private void printAdvancedHelp() {
        System.out.println("Advanced help information goes here.");
    }

    private void printVersion() {
        System.out.println("Armagedon version 1.0.0");
    }

    public String getUsage() {
        return USAGE;
    }
}
