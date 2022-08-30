/*
    Created in April 2022 as part of the Null Core project by owner RT5Phantom. Subject to copy right under the Eclipse Public License, see https://github.com/RT5Phantom/NullCore/blob/master/LICENSE for more details.
*/

package net.rt5phantom.nullcore;

import net.md_5.bungee.api.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;

/**
 * An extended version of Spigot's default JavaPlugin class that creates additional methods and variables aimed at making plugin development easier.
 * This augmented version of the Java Plugin class adds the following features; plugin tags, console & player messengers, and debug logging ease of use.
 * @author RT5Phantom
 * @since v1.0.0
 */
public abstract class AugmentedJavaPlugin extends JavaPlugin
{
    // ===================================================== //
    // ============= Plugin Tag Administration ============= //
    // ===================================================== //
    /**
     * Stores the extending plugin's tag in order to use print it out. The plugin tag can include chat formatting codes signaled by an "&" sign.
     * Please note that the "§" sign, unicode character code 'U+00A7', is translated into color codes by default, so it can be used as well.
     * Refer to 'https://minecraft.fandom.com/el/wiki/Formatting_codes' for the full list of chat formatting codes that you can use in Minecraft's chat system.
     */
    private String PluginTag = "[" + getDescription().getPrefix() + "]";

    /**
     * Gets the extending plugin's tag. This tag is unprocessed and could contain chat codes, if they added by a plugin developer.
     * @return Returns an unprocessed code formatted plugin tag.
     */
    protected String getPluginTag()
    {
        return PluginTag;  // Return internal private PluginTag variable
    }

    /**
     * Sets the extending plugin's tag. This tag can contain chat codes signaled by "&" or "§".
     * @param PluginTag New version of the plugin tag that will be used to print, which can include chat codes.
     */
    protected void setPluginTag(String PluginTag)
    {
        this.PluginTag = PluginTag;  // Update internal private PluginTag variable
    }



    // ============================================== //
    // ============= Console Messengers ============= //
    // ============================================== //
    /**
     * Sends a message to the console from the plugin, which can include chat formatting codes signaled by an "&" sign without the plugin tag.
     * Please note that the "§" sign, unicode character code 'U+00A7', is translated into color codes by default, so it can also be used.
     * Refer to 'https://minecraft.fandom.com/el/wiki/Formatting_codes' for the full list of chat formatting codes that you can use in Minecraft's chat system.
     * @param message The message to be sent to the console.
     */
    public void messageConsoleRaw(@NotNull String message)
    {
        // Sends the message through the bukkit console sender after translating chat colors
        getServer().getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', message));
    }

    /**
     * Sends a message to the console from the plugin, which can include chat formatting codes signaled by an "&" sign.
     * Please note that the "§" sign, unicode character code 'U+00A7', is translated into color codes by default, so it can also be used.
     * Refer to 'https://minecraft.fandom.com/el/wiki/Formatting_codes' for the full list of chat formatting codes that you can use in Minecraft's chat system.
     * @param message The message to be sent to the console.
     */
    public void messageConsole(@NotNull String message)
    {
        getServer().getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', getPluginTag() + " " + message));
    }



    // ============================================ //
    // ============= Debug Messengers ============= //
    // ============================================ //
    /**
     * Sends debug info message to the console.
     * @param message Message to send.
     */
    public void debugInfo(@NotNull String message)
    {
        getLogger().info(message);
    }

    /**
     * Sends a debug warning message to the console.
     * @param message Message to send.
     */
    public void debugWarning(@NotNull String message)
    {
        getLogger().warning(message);
    }

    /**
     * Sends a debug error message to the console.
     * @param message Message to send.
     */
    public void debugError(@NotNull String message)
    {
        getLogger().severe(message);
    }



    // ============================================= //
    // ============= Player Messengers ============= //
    // ============================================= //
    /**
     * Sends a message to a player, which can include chat formatting codes.
     * @param player The player that is sent the message.
     * @param message The message sent to the player.
     */
    public void messagePlayer(@NotNull Player player, @NotNull String message)
    {
        // Sends the message to the player after translating chat colors
        player.sendMessage(ChatColor.translateAlternateColorCodes('&', message));
    }

    /**
     * Sends a message to a player, which can include chat formatting codes.
     * @param player The player that is sent the message.
     * @param message The message sent to the player.
     * @param pluginTag The plugin tag to attach to the message.
     */
    public void messagePlayer(@NotNull Player player, @NotNull String message, String pluginTag)
    {
        // If the pluginTag is not null send the message with the tag
        if (pluginTag != null)
        {
            // Sends the message with the pluginTag to the player after translating chat colors
            player.sendMessage(ChatColor.translateAlternateColorCodes('&', "[" + pluginTag + "] " + message));
        }
        // Otherwise, send to the messagePlayer method without the tag sender
        else
        {
            messagePlayer(player, message);  // Send to default messagePlayer
        }
    }
}