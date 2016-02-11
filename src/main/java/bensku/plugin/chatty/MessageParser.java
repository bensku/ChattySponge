package bensku.plugin.chatty;

import org.spongepowered.api.text.Text;

/**
 * Parses chat messages.
 * @author bensku
 *
 */
public interface MessageParser {
    
    Text parse(Text old);
}
