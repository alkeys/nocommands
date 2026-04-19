package com.nocommands.mod;

import net.minecraft.commands.CommandSourceStack;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Style;
import net.neoforged.bus.api.EventPriority;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.event.CommandEvent;

public class CommandBlocker {

    @SubscribeEvent(priority = EventPriority.HIGHEST)
    public void onCommand(CommandEvent event) {
        String input = event.getParseResults().getReader().getString().trim();

        // Quitar la barra inicial si existe
        if (input.startsWith("/")) {
            input = input.substring(1);
        }

        String lowerInput = input.toLowerCase();

        for (String blocked : ListaComandosBloqueado.BLOCKED_COMMANDS) {
            // Verificar si el comando es exactamente el bloqueado o empieza con él seguido de espacio
            if (lowerInput.equals(blocked) || lowerInput.startsWith(blocked + " ")) {
                // Cancelar el evento
                event.setCanceled(true);

                // Enviar mensaje de advertencia en rojo al jugador
                CommandSourceStack source = event.getParseResults().getContext().getSource();


                Component mensaje = 
                Component.literal(new MensajesPersonalizados().getMensajePersonalizado(blocked))
                    .setStyle(Style.EMPTY
                        .withColor(net.minecraft.ChatFormatting.RED)
                        .withBold(true));

                source.sendFailure(mensaje);

                NoCommandsMod.LOGGER.warn("[NoCommands] Comando bloqueado: /{} - intentado por: {}",
                    blocked, source.getTextName());

                return;
            }
        }
    }
}
