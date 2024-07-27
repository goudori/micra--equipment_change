package plugin.micra_twentytwo;

import static org.bukkit.Bukkit.getPluginManager;

import java.net.http.WebSocket.Listener;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;
import plugin.micra_twentytwo.command.EnemyDownCommand;


public final class Main extends JavaPlugin implements Listener, org.bukkit.event.Listener {

  private Player player;


  @Override
  public void onEnable() {
    // Plugin startup logic
    Bukkit.getPluginManager().registerEvents(this, this);

    getCommand("enemyDown").setExecutor(new EnemyDownCommand(this));
  }

  //  プレイヤーがマイクラサーバーに参加した時のイベント
  @EventHandler
  public void onPlayerJoin(PlayerJoinEvent e) {
    Player player = e.getPlayer();
    player.sendTitle("装備を同じにする", "", 10, 70, 20);
  }


}