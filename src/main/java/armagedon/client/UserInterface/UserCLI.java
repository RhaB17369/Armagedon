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
        System.out.println();
        displayHelpMenu();
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

        // Sélectionner un logo au hasard
        Random random = new Random();
        Logo randomLogo = logos.get(random.nextInt(logos.size()));

        // Afficher le logo sélectionné
        String logoArt = randomLogo.getAsciiArt();
        String[] logoLines = logoArt.split("\n");

        // Calculer la largeur du logo pour centrer le texte GitHub
        int logoWidth = logoLines[0].length();

        // Afficher le texte "Conçu par RhaB17369" à droite du logo
        for (int i = 0; i < logoLines.length; i++) {
            String line = logoLines[i];
            if (i == 0) { // Place le texte en haut à droite
                System.out.println(ansi().fg(randomLogo.getColor()).a(line + "   Conçu par RhaB17369").reset());
            } else {
                System.out.println(ansi().fg(randomLogo.getColor()).a(line).reset());
            }
        }

        // Ajouter le texte GitHub centré sous le logo
        String infoBottomCenter = "GITHUB https://github.com/RhaB17369/Armagedon.git";
        int padding = (logoWidth - infoBottomCenter.length()) / 2;
        String centeredInfo = " ".repeat(padding) + infoBottomCenter;
        System.out.println(ansi().fg(randomLogo.getColor()).a(centeredInfo).reset());
    }

    private static void displayHelpMenu() {
        CommandHandler commandHandler = new CommandHandler();
        System.out.println(ansi().fg(Ansi.Color.GREEN).a(commandHandler.getUsage()).reset());
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
