package bensku.plugin.chatty;

import java.util.List;

import org.spongepowered.api.world.World;

/**
 * Chat channel with data for default parser. Does not contain any member
 * data, in case permission system is not enough.
 * @author bensku
 *
 */
public interface ChatChannel {
    
    /**
     * Gets list of blocked worlds. Has higher priority than allowed worlds.
     * @return Blocked worlds.
     */
    List<World> getBlockedWorlds();
    
    /**
     * Get's list of allowed worlds. If list is empty, all are allowed.
     * @return Allowed worlds, empty list if all.
     */
    List<World> getAllowedWorlds();
    
    /**
     * Permission requirement for channel, if any. Defaults to "chatty.chat".
     * If this channel needs invite, defaults instead to "chatty.admin".
     * @return Name of required permission.
     */
    String getPermissionReq();
    
    /**
     * Check if invite is normally needed to enter the channel. Only
     * checks invites provided by Chatty, admin may very well "invite"
     * by giving correct permission.
     * @return True if invite is needed, false otherwise.
     */
    boolean needsInvite();
}
