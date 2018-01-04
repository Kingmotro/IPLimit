package com.envyclient.iplimit.impl.events;

import com.envyclient.iplimit.IPLimit;
import com.envyclient.iplimit.util.Util;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class JoinEvent implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        String permission = "iplimit.bypass";

        if (player.hasPermission(permission))
            return;

        if (getAmount(getIP(player), permission) > Util.IP_LIMIT)
            player.kickPlayer(Util.PREFIX + " " + Util.KICK_MESSAGE);
    }

    private static String getIP(Player player) {
        return player.getAddress().getAddress().getHostAddress();
    }

    private int getAmount(String ip, String permission) {
        int count = 0;
        for (Player player : IPLimit.INSTANCE.getServer().getOnlinePlayers())
            if (getIP(player).equalsIgnoreCase(ip) && !player.hasPermission(permission))
                count++;
        return count;
    }


}
