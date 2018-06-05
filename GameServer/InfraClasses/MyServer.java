package GameServer.InfraClasses;

import GameServer.Interfaces.ClientHandler;
import GameServer.Interfaces.Server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;

public class MyServer implements Server {


    private int _port;
    private ClientHandler _clientHandler;
    private volatile Boolean _stop;

    public MyServer(int port, ClientHandler clientHandler) {
        _port = port;
        _clientHandler = clientHandler;
        _stop = false;
    }

    @Override
    public void start() {
        new Thread(()-> {
            try {
                runServer();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }).start();
    }

    @Override
    public void stop() {
        _stop = true;
    }

    private void runServer() throws Exception {
        ServerSocket localServer= new ServerSocket(_port);
        localServer.setSoTimeout(1000);
        while(!_stop)
        {
            try{
                Socket clientSocket = localServer.accept();

                _clientHandler.handle(clientSocket.getInputStream(),clientSocket.getOutputStream());

                clientSocket.getInputStream().close();
                clientSocket.getOutputStream().close();
                clientSocket.close();
            }
            catch(SocketTimeoutException timeoutException) {
                System.out.println(timeoutException.getMessage());
            }
            catch(IOException ioException) {
                System.out.println(ioException.getMessage());
                System.out.println(ioException.getStackTrace());
            }
        }
        System.out.println("Stopped");
        localServer.close();
    }
}
