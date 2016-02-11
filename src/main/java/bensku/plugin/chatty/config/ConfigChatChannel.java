package bensku.plugin.chatty.config;

import java.util.List;
import java.util.Optional;

import org.spongepowered.api.Game;
import org.spongepowered.api.world.World;

import bensku.plugin.chatty.ChatChannel;
import bensku.plugin.chatty.ChattyPlugin;
import ninja.leaping.configurate.objectmapping.Setting;
import ninja.leaping.configurate.objectmapping.serialize.ConfigSerializable;

@ConfigSerializable
public class ConfigChatChannel implements ChatChannel {
    
    private Game game;
    
    public ConfigChatChannel() {
        this.game = ChattyPlugin.getInstance().getGame();
    }
    
    @Setting
    private List<String> blockedWorlds;
    @Setting
    private List<String> allowedWorlds;
    @Setting
    private String permission = "chatty.chat";
    @Setting
    private boolean needsInvite = false;;
    
    private List<World> bwObjs;
    private List<World> awObjs;

    public List<World> getBlockedWorlds() {
        if (bwObjs == null) {
            for (String name : blockedWorlds) {
                Optional<World> opt = game.getServer().getWorld(name);
                if (opt.isPresent()) {
                    bwObjs.add(opt.get());
                }
            }
        }
        
        return bwObjs;
    }

    public List<World> getAllowedWorlds() {
        if (awObjs == null) {
            for (String name : allowedWorlds) {
                Optional<World> opt = game.getServer().getWorld(name);
                if (opt.isPresent()) {
                    awObjs.add(opt.get());
                }
            }
        }
        
        return awObjs;
    }

    public String getPermissionReq() {
        return permission;
    }

    public boolean needsInvite() {
        return needsInvite;
    }
    
    
}
