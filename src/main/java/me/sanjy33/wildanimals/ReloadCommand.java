package me.sanjy33.wildanimals;

import io.papermc.paper.command.brigadier.BasicCommand;
import io.papermc.paper.command.brigadier.CommandSourceStack;
import net.kyori.adventure.text.Component;
import org.jspecify.annotations.NullMarked;
import org.jspecify.annotations.Nullable;

@NullMarked
public class ReloadCommand implements BasicCommand {

    private final WildAnimals plugin;

    public ReloadCommand(WildAnimals plugin) {
        this.plugin = plugin;
    }

    @Override
    public void execute(CommandSourceStack commandSourceStack, String[] args) {
        plugin.reloadConfig();
        commandSourceStack.getSender().sendMessage(Component.text("[WildAnimals] Config reloaded."));
    }

    @Override
    public @Nullable String permission() {
        return "wildanimals.reload";
    }
}
