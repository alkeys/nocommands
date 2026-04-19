package com.nocommands.mod;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.common.NeoForge;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(NoCommandsMod.MODID)
public class NoCommandsMod {

    public static final String MODID = "nocommands";
    public static final Logger LOGGER = LogManager.getLogger(MODID);

    public NoCommandsMod(IEventBus modEventBus) {
        NeoForge.EVENT_BUS.register(new CommandBlocker());
        LOGGER.info("[NoCommands] Mod cargado. Comandos bloqueados: /give, /fill, /summon");
    }
}
