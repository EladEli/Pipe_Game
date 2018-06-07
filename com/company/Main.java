package com.company;

import GameServer.DataClasses.GameLevel;
import GameServer.InfraClasses.FileCacheManager;
import GameServer.InfraClasses.MyClientHandler;
import GameServer.InfraClasses.MyServer;
import GameServer.InfraClasses.PipeGameSolver;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws InterruptedException, IOException {
        FileCacheManager fileCacheManager = new FileCacheManager();
        PipeGameSolver pipeGameSolver = new PipeGameSolver();
        MyClientHandler myClientHandler = new MyClientHandler(fileCacheManager,pipeGameSolver);

        MyServer myServer = new MyServer(6666,myClientHandler);
        myServer.start();
        Thread.sleep(5000);
        myServer.stop();
    }
}
