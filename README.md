# Hugger

<!--suppress HtmlDeprecatedAttribute -->
<img alt="Picture of a heart" align="right" width="100" height="100" src="https://raw.githubusercontent.com/Erb3/Hugger/main/assets/icon-rounded.png" title="Hugger Icon">

[![github](https://cdn.jsdelivr.net/npm/@intergrav/devins-badges@3/assets/cozy/available/github_vector.svg)](https://github.com/Erb3/Hugger)
[![modrinth](https://cdn.jsdelivr.net/npm/@intergrav/devins-badges@3/assets/cozy/available/modrinth_vector.svg)](https://modrinth.com/mod/hugger)

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

## Requirements

To use Hugger you **need** the following:

- Spigot-based server (including [PaperMC](https://papermc.io/))
- Admin access to the server
    * Ability to add plugins
    * Ability to modify configuration files

For some optional extra features you also need:

* [PlaceholderAPI](https://github.com/PlaceholderAPI/PlaceholderAPI) (For PlaceholderAPI support)
* Permission manager (For giving people access to commands)

## Installation

Installing depends a bit on how your server is set up.
If you have a GUI (Graphical User Interface) where you manager your server, please follow [Installation with a GUI].
Otherwise, please follow [Installation without a GUI].

### Installation with a GUI

There are three main scenarios when installing with a GUI.

1. You do not have a menu to add/remove plugins
2. Hugger is not in the catalogue
3. Hugger is in the catalogue

#### Scenario 1: You do not have a menu to add/remove plugins

If you do not have a menu to add or remove plugins, please continue to the section [Installation without a GUI].

#### Scenario 2: Hugger is not in the catalogue

If you have an interface for managing plugins,
but Hugger is not in its catalogue, you can either ask the administrator to add Hugger,
or follow the section on [Installation without a GUI].

#### Scenario 3: Hugger is in the catalogue

If you have an interface for managing plugins, and Hugger is in the catalogue, you can install it!

#### Scenario 4: None of the above

If you have a GUI, but none of the above applies, please continue to the section [Installation without a GUI].

### Installation without a GUI

If you don't have a simple GUI to manage plugins, you should install Hugger manually by uploading the .jar.
This process is different from server host to server host.
Start by getting the latest `.jar` from [Modrinth](https://modrinth.com/mod/hugger) or [GitHub releases](https://github.com/Erb3/Hugger/releases).
From here I can't help you more than saying that you should upload this .jar into your `/plugins` folder.
Unable to figure it out?
Don't hesitate with opening a [GitHub issue](https://github.com/Erb3/Hugger/issues).

## Configuration

All configuration options are documented here, and are strings.
Looking at the default config might help.

### Root

#### `enabled`

The main toggle switch to Hugger. Disabling this will disable hugger, once config reloaded.

Values: `"true"` / `"false"`

#### `enableStatistics`

Toggles if statistics should be recorded.

Values: `"true"` / `"false"`

#### `enableRecords`

Toggles if records should be recorded.

Values: `"true"` / `"false"`

#### `selfhugCountsStatistics`

Toggles if hugging yourself counts for statistics.

Values: `"true"` / `"false"`

#### `cooldown`

Sets the cooldown. Set in seconds

Values: `Seconds (in string)`

### Translations

Available translation strings:

* `hugSyntaxError`
* `playerNotFoundError` 
* `configReloaded` 
* `incorrectUsage` 
* `playerStatsHeader` 
* `hugsSentStat` 
* `hugsReceivedStat` 
* `newRecord` 
* `newRecordBroadcast` 
* `recordInfoTitle` 
* `recordInfo` 
* `permissionDenied` 
* `cooldownReached`

### Effects

An array of effects executed when you hug, or get hugged.

Example:

```yml
effects:
  - chatMessage:
      gotHugged: "&3Hugger &8>> &7You got hugged by: &d%s"
      huggingPlayer: "&3Hugger &8>> &7Hugging: &d%s"
  - sound:
      sound: "BLOCK_NOTE_BLOCK_IRON_XYLOPHONE"
```

You can repeat the effect types if you want.

#### `chatMessage`

Sends a chat message to the sender and receiver of a hug. 

Fields:
* `gotHugged` String that gets sent to the receiver
* `huggingPlayer` String that gets sent to the sender

#### `actionBar`

Sends an action bar to the sender and receiver of a hug

Fields:
* `gotHugged` String that gets sent to the receiver
* `huggingPlayer` String that gets sent to the sender

#### `title`

Sends a title to the sender and receiver of a hug

Fields:
* `gotHugged` String that gets sent to the receiver
* `huggingPlayer` String that gets sent to the sender

#### `broadcast`

Sends a chat broadcast to everyone

Fields:
* `message` String that gets sent to everyone

#### sound

Sends a sound to the sender and receiver of a hug

Fields:
* `sound` The sound to play

#### particle

Sends a particle effect to the sender and receiver of a hug

Fields:
* `particle` The particle to play