package com.hordeofgreg.hogtweaks.mixin.discordintegration;

import net.dv8tion.jda.api.JDABuilder;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

import com.hordeofgreg.hogtweaks.config.TweaksConfig;

import de.erdbeerbaerlp.dcintegration.common.Discord;

/**
 * This mixin class changes the default behavior of the common Discord Class used by all of ErdbeerbaerLP's discord
 * integration mods.
 * It allows the user to set the bot token using the system property "discord.botToken", instead of through the config.
 * This is useful for server owner who want to expose the files to the public, but don't want to expose their bot token.
 */
@Mixin(value = Discord.class, remap = false)
public abstract class DiscordMixin {

    @Redirect(
              method = "run",
              at = @At(
                       value = "INVOKE",
                       target = "Lnet/dv8tion/jda/api/JDABuilder;createDefault(Ljava/lang/String;)Lnet/dv8tion/jda/api/JDABuilder;"))
    private JDABuilder redirectCreateDefault(String originalToken) {
        String token = System.getProperty("discord.botToken");
        if (TweaksConfig.advanced.activateVerboseLogging && token != null && !token.isEmpty()) {
            System.out.println("Discord bot token received");
        }
        if (token == null || token.isEmpty()) {
            token = originalToken;
        }
        return JDABuilder.createDefault(token);
    }
}
