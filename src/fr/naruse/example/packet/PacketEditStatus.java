package fr.naruse.example.packet;

import fr.naruse.servermanager.core.ServerManager;
import fr.naruse.servermanager.core.connection.packet.IPacket;
import fr.naruse.servermanager.core.server.Server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class PacketEditStatus implements IPacket {

    public PacketEditStatus() {
    }

    private Action action;
    private Server.Status status;
    public PacketEditStatus(Action action, Server.Status status) {
        this.action = action;
        this.status = status;
    }

    @Override
    public void write(DataOutputStream dataOutputStream) throws IOException {
        dataOutputStream.writeUTF(this.action.name());
        dataOutputStream.writeUTF(this.status.name());
    }

    @Override
    public void read(DataInputStream dataInputStream) throws IOException {
        this.action = Action.valueOf(dataInputStream.readUTF());
        this.status = Server.Status.valueOf(dataInputStream.readUTF());
    }

    @Override
    public void process(ServerManager serverManager) {
        if(this.action == Action.ADD){
            serverManager.getCurrentServer().getData().addStatus(status);
        }else{
            serverManager.getCurrentServer().getData().removeStatus(status);
        }
    }


    public enum Action {

        ADD,
        REMOVE

    }
}
