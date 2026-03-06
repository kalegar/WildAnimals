# WildAnimals Plugin

WildAnimals is a simple Minecraft Java plugin to make baby tameable animals like wolves not already tamed when born.

This is useful if you want others to be able to tame wolves that you breed instead of having them be automatically owned by one of the parent's owners.

## Installation

WildAnimals requires a Bukkit / Spigot / Paper server to run.

To install, simply drop the jar into your plugins folder.

## Configuration

After startup, a config.yml file will be created in the plugins/WildAnimals/ folder.

Here you can set which mob types will be 'unowned' when born. The default is wolves and cats.

On startup of the server, any invalid or non-tameable mob types in the config will show an error message and be skipped.

## Commands & Permissions

`/wildanimals` reloads the config file. You need the `wildanimals.reload` permission or need to be an operator to use the command.