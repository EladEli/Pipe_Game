package GameServer.Interfaces;

import java.io.InputStream;
import java.io.OutputStream;

public interface ClientHandler {
    void handle(InputStream inputStream, OutputStream out);
}
