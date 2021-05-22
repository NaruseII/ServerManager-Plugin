package fr.naruse.example.main;

import fr.naruse.example.packet.CustomPackets;
import fr.naruse.example.packet.PacketEditStatus;
import fr.naruse.example.status.CustomStatus;
import fr.naruse.servermanager.core.CoreServerType;
import fr.naruse.servermanager.core.ServerManager;
import fr.naruse.servermanager.core.server.Server;
import fr.naruse.servermanager.core.server.ServerList;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.List;
import java.util.stream.Collectors;

public class ExamplePlugin extends JavaPlugin {

    @Override
    public void onEnable() {
        getCommand("smCommands").setExecutor(this);

        ServerManager.get().getCurrentServer().getData().addStatus(CustomStatus.WAITING);

        CustomPackets.load();
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(args.length < 3){
            sender.sendMessage("§6/§7smCommands addStatus <Server Name> <Status>");
            sender.sendMessage("§6/§7smCommands removeStatus <Server Name> <Status>");
            return true;
        }
        Server server = ServerList.getByName(args[1]);
        if(server == null){
            sender.sendMessage("§cServer not found.");
            return false;
        }

        Server.Status status = Server.Status.valueOf(args[2]);
        if(status == null){
            sender.sendMessage("§cStatus not found.");
            return false;
        }

        server.sendPacket(new PacketEditStatus(args[0].equalsIgnoreCase("addStatus") ? PacketEditStatus.Action.ADD : PacketEditStatus.Action.REMOVE, status));

        sender.sendMessage("§aStatus edited. Execute /sm status to see '"+server.getName()+"' details");

        return true;
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
        if(args.length == 3){
            return Server.Status.getAll().stream().filter(status -> status.name().startsWith(args[args.length-1].toUpperCase())).map(status -> status.name()).collect(Collectors.toList());
        }
        return ServerList.findServer(CoreServerType.BUNGEE_MANAGER, CoreServerType.BUKKIT_MANAGER)
                .stream()
                .filter(server -> server.getName().startsWith(args[args.length-1]))
                .map(server -> server.getName())
                .collect(Collectors.toList());
    }
}
