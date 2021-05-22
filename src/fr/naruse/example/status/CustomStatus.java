package fr.naruse.example.status;

import fr.naruse.servermanager.core.server.Server;

public class CustomStatus {

    public static final Server.Status WAITING = Server.Status.registerNewStatus("WAITING");
    public static final Server.Status IN_GAME = Server.Status.registerNewStatus("IN_GAME");

}
