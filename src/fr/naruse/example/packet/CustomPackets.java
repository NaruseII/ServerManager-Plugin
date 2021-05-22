package fr.naruse.example.packet;

import fr.naruse.servermanager.core.connection.packet.Packets;

public class CustomPackets {

    public static void load() {
        Packets.registerPacket("EDIT_STATUS", PacketEditStatus.class);
    }
}
