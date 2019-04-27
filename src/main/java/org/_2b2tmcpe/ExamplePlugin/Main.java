package org._2b2tmcpe.ExamplePlugin;

import cn.nukkit.command.Command;
import cn.nukkit.command.CommandSender;
import cn.nukkit.event.EventHandler;
import cn.nukkit.event.Listener;
import cn.nukkit.event.player.PlayerJoinEvent;
import cn.nukkit.event.player.PlayerQuitEvent;
import cn.nukkit.plugin.PluginBase;
import cn.nukkit.utils.TextFormat;

public class Main extends PluginBase implements Listener {

  @Override
  public void onLoad() {
    this.getLogger().info("Example Plugin loaded");
  }

  @Override
  public void onEnable() {
    this.getLogger().info("Example Plugin enabled");
    this.getServer().getPluginManager().registerEvents(this, this);
    // this, just means the listener is in this class
  }

  @Override
  public void onDisable() {
    this.getLogger().info("Example Plugin disabled");
  }

  @Override
  public boolean onCommand(CommandSender sender, Command command, String label, String[] Args) {
    if (command.equals("sayhi")) {
      sender.sendMessage("hi, " + sender.getName()); // even better, it will show the player name
      return true;
    }
    return false;
  }

  @EventHandler
  public void onPlayerJoin(PlayerJoinEvent event) {
    event.setJoinMessage(
        TextFormat.GREEN + "Welcome " + event.getPlayer().getName() + " to the server!");
    // This give the message a green color
  }

  @EventHandler
  public void onPlayerQuit(PlayerQuitEvent event) {
    event.setQuitMessage(
        TextFormat.RED + "Bye! " + event.getPlayer().getName() + " left the server!");
    // Appearently my settings doesn't allow a long line of code, but splitting lines doesn't affect the plugin
    // This give the message a red color
    // Forget the typo
  }

}
