package mazegame;

import mazegame.boundary.IMazeClient;

import java.util.Scanner;

public class SimpleConsoleClient implements IMazeClient {
    @Override
    public String getReply(String question) {
        System.out.println("\n" + question + " ");
        Scanner in = new Scanner(System.in);
        return in.nextLine();
    }

    @Override
    public void playerMessage(String message) {
        System.out.print(message);

    }

    @Override
    public String getCommand() {
        System.out.print("\n\n>>>\t");
        return new Scanner(System.in).nextLine();
    }
}
