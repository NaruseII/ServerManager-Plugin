***See Hub.jar to have a little plugin that allows you to switch server thanks to an inventory***
***
***ServerManager Event list***
  * **Config**
    * ConfigurationLoadedEvent [Called when all configurations are loaded]
      * File getServerTemplateFolder
      * Configuration getConfig()
      * Map<String, Configuration> getServerTemplateSet()
  * **Packet**
    * AsyncPacketReceiveEvent [Called between a packet read and its process] (Cancellable event)
      * IPacket getPacket()
      * String getPacketName()
    * AsyncPacketSendEvent [Called before packet construction and send] (Cancellable event)
      * IPacket getPacket()
      * String getPacketName()
      * InetAddress getDestinationAddress()
      * int getDestinationPort()
    * PacketLoadEvent [Called after packet loading]
      * Map<Class<? extends IPacket>, String> getNameByPacket()
      * Map<String, Class<? extends IPacket>> getPacketByName()
  * **Server**
    * ServerDeleteEvent [Called before server deletion]
      * Server getServer()
    * ServerPostDeleteEvent [Called after server deletion]
      * Server getServer()
    * ServerRegisterEvent [Called before server registration] (Cancellable)
      * Server getServer()
    * ServerPostRegisterEvent [Called after server registration]
      * Server getServer()
  * **Global**
    * InitializationStartEvent [Called before ServerManager start]
    * InitializationEndedEvent [Called after ServerManager start]
    * ShutdownEvent [Called before ServerManager shutdown]
***
***Packet List***
  * PacketBroadcast [Send broadcast message] [Destination: Bungee]
    * String msg
  * PacketExecuteConsoleCommand [Execute command on console] [Destination: All]
    * String command
  * PacketShutdown [Shutdown targetted server] [Destination: All]
  * PacketSwitchServer [Switch a player from server] [Destination: Bungee]
    * Server destinationServer
    * String... playerNames


***

![](final_developer_server_list.png)
![](final_developer_status.png)
![](final_developer_packets.png)
![](final_developer_database_api.png)
![](final_developer_listeners.png)
