package com.nocommands.mod;

import java.util.Random;

public class MensajesPersonalizados {

    private final String[] mensajePersonalizado = {
        "⚠ No lo hagas puerco, pd viva el fmln ⚠",
        "Ya te vi pedazo de persona tramposa, mejor juega bien",
        "No seas tramposo, juega limpio",
        "No hagas trampa, juega con honor basura",
        "Jajaja ahí va el tramposo del barrio otra vez",
        "Pura trampa y cero huevos, respeta el juego",
        "Te vi wey, no te hagas el pendejo",
        "Jugando como rata de alcantarilla 🐀",
        "Eso no es skill, eso es puro cheat pinche",
        "Verga, hasta mi abuela juega más limpio que vos",
        "Tramposo detectado, activando modo vergüenza",
        "Ahí va el rey de las trampas otra vez 😂",
        "Te cachamos rojo, no te hagas",
        "Jugá bien o te mando al chat de los cheaters",
        "Pura cara de inocente pero las manos sucias",
        "No seas sapo, jugá como hombre",
        "Pinche tramposo, ni en la lotería ganás así",
        "Eso no vale, jugá con huevos o no juguís",
        "Te estoy viendo con el ojo de halcón 🦅",
        "Trampa nivel FMLN: descarada y sin vergüenza"
    };

    private final Random random = new Random();

    /**
     * Devuelve un mensaje personalizado según el comando bloqueado
     */
    public String getMensajePersonalizado(String comando) {

        if (comando == null) {
            return getMensajeAleatorio();
        }

        String cmd = comando.toLowerCase().trim();

        switch (cmd) {
            case "gamemode":
            case "gm":
                return "Jugando como rata de alcantarilla 🐀";   // antes índice 7

            case "xp":
            case "experience":
                return "Eso no es skill, eso es puro cheat pinche wei"; // antes índice 8

            case "give":
            case "item":
                return "No hagas trampa, juega con honor basura";   // antes índice 3

            case "tp":
            case "teleport":
                return "Te vi wey, no te hagas el pendejo";

            case "kill":
                return "Pura trampa y cero huevos, respeta el juego";

            case "setblock":
            case "fill":
                return "No seas tramposo, juega limpio";

            default:
                // Para cualquier otro comando bloqueado → mensaje aleatorio
                return getMensajeAleatorio();
        }
    }

    /**
     * Devuelve un mensaje aleatorio del array
     */
    public String getMensajeAleatorio() {
        int index = random.nextInt(mensajePersonalizado.length);
        return mensajePersonalizado[index];
    }

    /**
     * (Opcional) Muestra todos los mensajes disponibles
     */
    public void mostrarTodos() {
        for (int i = 0; i < mensajePersonalizado.length; i++) {
            System.out.println((i + 1) + ". " + mensajePersonalizado[i]);
        }
    }
}