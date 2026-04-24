package com.kotiki.luckybag;

import cn.nukkit.plugin.PluginBase;
import cn.nukkit.Server;

import java.util.Random;

public class LuckyBagPlugin extends PluginBase {

    private Random random = new Random();

    @Override
    public void onEnable() {
        getLogger().info("LuckyBag enabled");

        getServer().getScheduler().scheduleRepeatingTask(this, () -> {
            check();
        }, 20 * 10);
    }

    private void check() {

        String[] loot = {
            "give %player% diamond 3",
            "give %player% emerald 5",
            "give %player% iron_ingot 32",
            "give %player% golden_apple 2"
        };

        String cmd = loot[random.nextInt(loot.length)];

        Server.getInstance().dispatchCommand(
            Server.getInstance().getConsoleSender(),
            cmd
        );
    }
}