package com.battleasya.staffchat;

import com.battleasya.staffchat.command.Msg;
import com.battleasya.staffchat.command.Reload;
import com.battleasya.staffchat.command.Toggle;
import com.battleasya.staffchat.handler.Config;
import com.battleasya.staffchat.handler.Event;
import com.battleasya.staffchat.handler.Util;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashMap;

public class StaffChat extends JavaPlugin {

    public HashMap<String, Integer> staffList;

    public HashMap<String, Integer> chatToggleList;

    public Config config;

    public Util util;

    @Override
    public void onEnable() {

        /* generate default config if not exists */
        saveDefaultConfig();

        /* initialise config */
        config = new Config(this);

        /* fetch config */
        config.fetchConfig();

        /* initialise util */
        util = new Util(this);

        /* initialise hashmaps */
        staffList = new HashMap<>();
        chatToggleList = new HashMap<>();

        /* register command */
        getCommand("sc").setExecutor(new Msg(this));
        getCommand("sct").setExecutor(new Toggle(this));
        getCommand("screload").setExecutor(new Reload(this));

        /* register listener */
        getServer().getPluginManager().registerEvents(new Event(this), this);

    }

}