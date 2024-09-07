package armagedon.client.UserInterface;

import org.fusesource.jansi.Ansi;
import static org.fusesource.jansi.Ansi.ansi;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class UserCLI {

    public static void main(String[] args) {
        System.out.println(ansi().reset());
        displayRandomAsciiLogo();
        displayMenu();
    }

    private static void displayRandomAsciiLogo() {
        List<Logo> logos = Arrays.asList(
                new Logo(Ansi.Color.WHITE, "       ______  ______          ______ _______ _____    _____  ______  \n" +
                        "   /\\ (_____ \\|  ___ \\   /\\   / _____|_______|____ \\  / ___ \\|  ___ \\ \n" +
                        "  /  \\ _____) ) | _ | | /  \\ | /  ___ _____   _   \\ \\| |   | | |   | |\n" +
                        " / /\\ (_____ (| || || |/ /\\ \\| | (___)  ___) | |   | | |   | | |   | |\n" +
                        "| |__| |    | | || || | |__| | \\____/| |_____| |__/ /| |___| | |   | |\n" +
                        "|______|    |_|_||_||_|______|\\_____/|_______)_____/  \\_____/|_|   |_|\n"
                ),

                new Logo(Ansi.Color.RED, "     _    ____  __  __    _    ____ _____ ____   ___  _   _ \n" +
                        "    / \\  |  _ \\|  \\/  |  / \\  / ___| ____|  _ \\ / _ \\| \\ | |\n" +
                        "   / _ \\ | |_) | |\\/| | / _ \\| |  _|  _| | | | | | | |  \\| |\n" +
                        "  / ___ \\|  _ <| |  | |/ ___ \\ |_| | |___| |_| | |_| | |\\  |\n" +
                        " /_/   \\_\\_| \\_\\_|  |_/_/   \\_\\____|_____|____/ \\___/|_| \\_|\n"
                ),

                new Logo(Ansi.Color.YELLOW, "   _____ __________    _____      _____    ___________________________   ________    _______   \n" +
                        "  /  _  \\\\______   \\  /     \\    /  _  \\  /  _____/\\_   _____/\\______ \\  \\_____  \\   \\      \\  \n" +
                        " /  /_\\  \\|       _/ /  \\ /  \\  /  /_\\  \\/   \\  ___ |    __)_  |    |  \\  /   |   \\  /   |   \\ \n" +
                        "/    |    \\    |   \\/    Y    \\/    |    \\    \\_\\  \\|        \\ |    `   \\/    |    \\/    |    \\\n" +
                        "\\____|__  /____|_  /\\____|__  /\\____|__  /\\______  /_______  //_______  /\\_______  /\\____|__  /\n" +
                        "        \\/       \\/         \\/         \\/        \\/        \\/         \\/         \\/         \\/ \n"
                )
        );

        //         Select a logo at random
        Random random = new Random();
        Logo randomLogo = logos.get(random.nextInt(logos.size()));

        // Show selected logo
        System.out.println(ansi().fg(randomLogo.getColor()).a(randomLogo.getAsciiArt()).reset());
    }

    private static void displayMenu() {
        System.out.println("\n==== Menu Principal ====");
        System.out.println("1. Lancer une attaque");
        System.out.println("2. Voir les résultats");
        System.out.println("3. Aide");
        System.out.println("4. Quitter\n");
        System.out.print("Veuillez choisir une option : ");
    }

    private static class Logo {
        private final Ansi.Color color;
        private final String asciiArt;

        public Logo(Ansi.Color color, String asciiArt) {
            this.color = color;
            this.asciiArt = asciiArt;
        }

        public Ansi.Color getColor() {
            return color;
        }

        public String getAsciiArt() {
            return asciiArt;
        }
    }
}
