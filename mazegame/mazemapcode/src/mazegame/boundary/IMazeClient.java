package mazegame.boundary;

public interface IMazeClient {
    String getReply(String question);

    void playerMessage(String message);

    String getCommand();
}
