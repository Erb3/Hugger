# Config Options

All configuration options are documented here. All values are strings.

## Root

### `enabled`

The main toggle switch to Hugger. Disabling this will disable hugger, once config reloaded.

Values: `"true"` / `"false"`

### `usePlaceholderAPI`

If Placeholder API should be used.

Values: `"true"` / `"false"`

### `enableStatistics`

Toggles if statistics should be recorded.

Values: `"true"` / `"false"`

### `enableRecords`

Toggles if records should be recorded.

Values: `"true"` / `"false"`

### `selfhugCountsStatistics`

Toggles if hugging yourself counts for statistics.

Values: `"true"` / `"false"`

### `cooldown`

Sets the cooldown. Set in seconds

Values: `Seconds (in string)`

## Translations

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

## Effects

An array of effects.

Example:
````yml
effects:
  - chatMessage:
      gotHugged: "&3Hugger &8>> &7You got hugged by: &d%s"
      huggingPlayer: "&3Hugger &8>> &7Hugging: &d%s"
  - sound:
      sound: "BLOCK_NOTE_BLOCK_IRON_XYLOPHONE"
````

You can repeat the effect types if you want.

### chatMessage

Sends a chat message to the sender and receiver of a hug. 

Fields:
* `gotHugged`. Translation string that gets sent to the receiver
* `huggingPlayer`. Translation string that gets sent to the sender

### actionBar

Sends an action bar to the sender and receiver of a hug

Fields:
* `gotHugged`. Translation string that gets sent to the receiver
* `huggingPlayer`. Translation string that gets sent to the sender

### title

Sends a title to the sender and receiver of a hug

Fields:
* `gotHugged`. Translation string that gets sent to the receiver
* `huggingPlayer`. Translation string that gets sent to the sender

### broadcast

Sends a chat broadcast to everyone

Fields:
* `message`. Translation string that gets sent to everyone

### sound

Sends a sound to the sender and receiver of a hug

Fields:
* `sound`. The sound to play

### particle

Sends a particle effect to the sender and receiver of a hug

Fields:
* `particle`. The particle to play
