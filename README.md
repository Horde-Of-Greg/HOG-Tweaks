<h1 align="center">Tao's 1.12 Mixins</h1>
<p align="center"><i>A simple mod to fix/tweak mod behaviors to what I want them to be like.</i></p>
<h1 align="center">
    <a href="https://github.com/D-Alessian/Taos-1-12-Tweaks/blob/master/LICENSE"><img src="https://img.shields.io/github/license/D-Alessian/Taos-1-12-Tweaks" alt="License"></a>
    <a href="https://github.com/D-Alessian/Taos-1-12-Tweaks/graphs/commit-activity"><img src="https://img.shields.io/badge/Maintained%3F-no-red.svg" alt="Maintained Status"></a>
</h1>

## Welcome to Taos 1.12 Tweaks!
### What is This?
This is a mod for Minecraft 1.12.2 that adds mixins to other mods. It is not a standalone mod, and it requires other mods to work. It is not a replacement for the original mod, and it does not add any new features to the game. It is just a way to modify the behavior of other mods.
### Why Did I Make This?
A lot of mods in 1.12.2 are outdated and no longer maintained. Some of them have bugs that are never going to be fixed, and some of them have features that I don't like. This mod is a way to fix those bugs and change those features without having to wait for the original mod to be updated.

This also can implement features that I want, but the original mod doesn't have. This is not a replacement for the original mod, and it does not add any new features to the game. It is just a way to modify the behavior of other mods.
### What is a Mixin?
A mixin is a way to modify the behavior of other mods without modifying the original mod's code. This allows to fix bugs for a mod that isn't being maintained anymore, or to add features that the original mod doesn't have.

## List of Mixins and How to Use Them
### Discord Integration API Fix:
This mixin changes how the mod deals with API tokens. It uses systemProperties to expose the API token to the mod instead of using a config file. This allows server owners to share the server files without sharing the API token.

For security reasons, **always pass the token as an environment variable** in your JVM arguments. This way, you don't have to worry about the token being exposed in logs or in the terminal.

How to use (Linux/MacOS):
1. Remove the API token from the config file. You can put whatever you want instead, doesn't matter.
2. Set your API token as an environment variable. You can do this by running the following command in your terminal:
```bash
export DISCORD_API_TOKEN=your_api_token
```
Replace `your_api_token` with your actual API token. `DISCORD_API_TOKEN` is the name of the environment variable, and it can be anything you want. Just make sure to use the same name in the next step.
3. Add this argument to your JVM arguments:
```bash
-Ddiscord.token=${DISCORD_API_TOKEN}
```
4. Restart your server and the mod should work as intended.

## Contribution
### Current State of Project
This project is currently in active development. I will only implement features I need though. So don't expect a clear timeline for new features.
I am working on this alone, and I'm not looking for any help at the moment. I will accept pull requests though, and will fix bugs if you submit them.
### How to Contribute
Found a bug? Please let me know by creating an Issue.
Reminder: no feature requests please. I will only spend time implementing features I need, and fixing them if they don't work.
### How Can you Use my Code?
You can use it however you want. Just make sure to credit me if you use my code in your own project.
Fork it, modify it, do whatever you want. Just make sure to mention me.
## Credited Works
- README template by [GregTechCEu](https://github.com/GregTechCEu/GregTech)
- For code inspiration [Nomi-Labs](https://github.com/Nomi-CEu/Nomi-Labs) & [ZBGT](https://github.com/Zorbatron/ZBGT)

See something I forgot to credit? Open an issue and ask for appropriate credit, I will happily mark it here
