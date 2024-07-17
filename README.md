# Hugger

[![github](https://cdn.jsdelivr.net/npm/@intergrav/devins-badges@3/assets/cozy/available/github_vector.svg)](https://github.com/Erb3/Hugger)
[![modrinth](https://cdn.jsdelivr.net/npm/@intergrav/devins-badges@3/assets/cozy/available/modrinth_vector.svg)](https://modrinth.com/mod/hugger)

<!--suppress HtmlDeprecatedAttribute -->
<img alt="Picture of a heart" align="right" width="100" height="100" src="https://raw.githubusercontent.com/Erb3/Hugger/main/assets/icon-rounded.png" title="Hugger Icon">

Hugger is a simple way to add hugs to your Spigot-based Minecraft server. It is highly configurable!

## Features

* Customizable translations
* Module-based customizable effects:
  * Chat message
  * Action bar
  * Title (and subtitle)
  * Chat broadcast
  * Sound
  * Particle
* Cooldown
* Useful help command, with clickable commands
* Config re-loader
* Record system (Player with most received hugs)
* Statistics system (Number of hugs sent / received)
* Permissions
* Open-Source on GitHub
* PlaceholderAPI support

## Requirements

To use Hugger you **need** the following:

* Spigot-based Minecraft server
* Admin access

For some optional features you also need:

* PlaceholderAPI (For PlaceholderAPI support)
* Permission manager (For giving people access to commands)

## Wiki

Much more information is on the wiki! [See here!](https://erb3.github.io/Hugger)

## Screenshots

**Coming soon**

## Placeholders

If you use PlaceholderAPI, you can use the following placeholders:

* `%hugger_total%`
* `%hugger_sent%`
* `%hugger_received%`

## Commands

* `/hug <player>`
* `/hugger <args>:`
  * `config reload`
  * `player [username]`
  * `record`
  * `help`

## Permission nodes

* `hugger.hug`
* `hugger.hug.self`
* `hugger.player`
* `hugger.player.others`
* `hugger.record`
* `hugger.config`