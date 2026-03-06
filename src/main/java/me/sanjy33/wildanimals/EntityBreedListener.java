package me.sanjy33.wildanimals;

import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Tameable;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityBreedEvent;

public class EntityBreedListener implements Listener {

    private final WildAnimals plugin;

    public EntityBreedListener(WildAnimals plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onEntityBreed(EntityBreedEvent event) {
        LivingEntity child = event.getEntity();
        if (!(child instanceof Tameable)) {
            return;
        }
        Tameable tameableChild = (Tameable) child;
        if (plugin.wildAnimalsOnBirth.contains(child.getType())) {
            tameableChild.setOwner(null);
        }

    }
}
