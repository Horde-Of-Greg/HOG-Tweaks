<h1 align="center">HOG-Tweaks</h1>
<p align="center"><i>Minecraft 1.12.2 tweaks, fixes, and utilities for Horde Of Greg.</i></p>
<p align="center">
    <a href="https://github.com/Horde-Of-Greg/HOG-Tweaks/blob/master/LICENSE"><img src="https://img.shields.io/github/license/Horde-Of-Greg/HOG-Tweaks" alt="License"></a>
</p>

## About

HOG-Tweaks is a Forge mod for Minecraft 1.12.2, built around the needs of Horde Of Greg. It adjusts other mods and provides utilities for running and maintaining the pack. Some changes use mixins to modify another mod's behavior; others are standalone utilities.

## Features and Configuration

General settings are stored in `config/hogtweaks.cfg`. Set `advanced.activateVerboseLogging` to `true` to enable additional logging (disabled by default; requires a restart).

### Discord Integration Bot Token

The Discord Integration tweak reads the bot token from the JVM system property `discord.botToken`. This lets server owners keep the token out of shared configuration files. If the property is missing or empty, Discord Integration uses the token from its config as usual.

To supply the token when launching a server on Linux or macOS:

1. Remove the real token from the Discord Integration config before sharing it.
2. Set an environment variable in the shell that launches the server:

   ```bash
   export DISCORD_API_TOKEN=your_api_token
   ```

3. Add the following JVM argument before `-jar` in the server launch command:

   ```bash
   -Ddiscord.botToken="${DISCORD_API_TOKEN}"
   ```

4. Restart the server.

The shell expands the environment variable into the JVM argument; the mod reads the system property, not the environment variable directly. Keep the token and launch environment private: this does not prevent exposure through process arguments or launch logs.

### OreDictionary Export

Set `oreDictExport.enableExport` to `true` to export registered OreDictionary names during mod initialization. Export is disabled by default.

`oreDictExport.outputPath` controls the destination, which defaults to `hogtweaks/storage/oredic_dump.txt`, relative to the Minecraft working directory. The export writes one name per line and overwrites the destination file each time it runs.

## Contributing

Development follows the needs of Horde Of Greg, with no fixed timeline for new features. Feature requests are not accepted. We will accept bug reports, as well as pull requests though, provided they are relevant.

## License

HOG-Tweaks is available under the [MIT license](LICENSE). This means you can do whatever you want with this code, just try to credit us if you can :).

## Credited Works

- README template by [GregTechCEu](https://github.com/GregTechCEu/GregTech)
- Code inspiration from [Nomi-Labs](https://github.com/Nomi-CEu/Nomi-Labs) and [ZBGT](https://github.com/Zorbatron/ZBGT)

Missing a credit? [Open an issue](https://github.com/Horde-Of-Greg/HOG-Tweaks/issues).
