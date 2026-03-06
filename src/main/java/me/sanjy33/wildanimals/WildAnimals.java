package me.sanjy33.wildanimals;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Tameable;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

public final class WildAnimals extends JavaPlugin {

    public Set<EntityType> wildAnimalsOnBirth = new HashSet<>();
    @Override
    public void onEnable() {
        // Plugin startup logic
        saveDefaultConfig();
        registerCommands();
        reloadConfig();
        getServer().getPluginManager().registerEvents(new EntityBreedListener(this),this);
        getLogger().log(Level.INFO, "WildAnimals enabled.");

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        getLogger().log(Level.INFO, "WildAnimals disabled.");
    }

    private void registerCommands() {
        registerCommand("wildanimals", "Reload WildAnimals config", new ReloadCommand(this));
    }

    @Override
    public void reloadConfig() {
        super.reloadConfig();
        wildAnimalsOnBirth.clear();
        FileConfiguration config = getConfig();
        Logger logger = getLogger();
        List<String> animalNames = config.getStringList("wildonbirth");
        for (String name : animalNames) {
            try {
                EntityType entityType = EntityType.valueOf(name.toUpperCase());
                Class<? extends Entity> entityClass = entityType.getEntityClass();
                if (entityClass == null) {
                    logger.log(Level.WARNING,"Could not determine Entity Class from {0}",name);
                    continue;
                }
                if (Tameable.class.isAssignableFrom(entityClass)) {
                    wildAnimalsOnBirth.add(entityType);
                }else{
                    logger.log(Level.WARNING,"{0} ({1}) is not a tameable entity.", new String[]{name, entityType.toString()});
                }
            } catch (IllegalArgumentException e) {
                logger.log(Level.WARNING,"{0} is not a valid Entity.",name);
            } catch (NullPointerException npe) {
                logger.log(Level.WARNING,"Invalid entity type.");
            }
        }
        logger.log(Level.INFO,"Loaded {0} tameable mobs.",wildAnimalsOnBirth.size());

    }
}
