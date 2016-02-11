package bensku.plugin.chatty;

import java.io.IOException;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import ninja.leaping.configurate.ConfigurationNode;
import ninja.leaping.configurate.loader.ConfigurationLoader;
import ninja.leaping.configurate.yaml.YAMLConfigurationLoader;

import org.spongepowered.api.Game;
import org.spongepowered.api.config.ConfigDir;
import org.spongepowered.api.event.Listener;
import org.spongepowered.api.event.game.state.GameStartedServerEvent;
import org.spongepowered.api.event.message.MessageChannelEvent;
import org.spongepowered.api.plugin.Plugin;

import com.google.inject.Inject;

@Plugin(id = "chatty", name = "Chatty", version = "dev-1")
public class ChattyPlugin {
    
    private static ChattyPlugin instance;
    
    public static ChattyPlugin getInstance() {
        return instance;
    }
    
    @Inject
    @ConfigDir(sharedRoot = false)
    private Path configDir;
    private Path channelDir;
    ConfigurationLoader<ConfigurationNode> channelLoader;
    
    private Map<String,String> formatters;
    
    @Inject
    private Game game;
    
    @Listener
    public void onChat(MessageChannelEvent.Chat event) {
        
    }
    
    @Listener
    public void onLoad(GameStartedServerEvent event) {
        channelDir = configDir.resolve("channels");
        channelLoader = YAMLConfigurationLoader.builder().setPath(configDir.resolve("channels.yaml")).build();
        loadConfig();
        
        instance = this;
    }
    
    /**
     * Load or reload configuration.
     */
    public void loadConfig() {
        formatters = new HashMap<String,String>();
        ConfigurationNode channels = null;
        try {
            channels = channelLoader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        for (Entry<Object, ? extends ConfigurationNode> entry : channels.getChildrenMap().entrySet()) {
            String name = (String) entry.getKey();
            ConfigurationNode data = entry.getValue();
            
            
        }
    }
    
    public Game getGame() {
        return game;
    }
}
