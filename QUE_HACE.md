# NoCommands Mod

NoCommands es un mod para NeoForge 1.21.5 que bloquea comandos peligrosos o abusables del servidor, incluso cuando los intenta usar un jugador con permisos de operador.

La idea es simple: cuando alguien escribe un comando, el mod intercepta la ejecución antes de que Minecraft lo procese. Si el comando está dentro de la lista de bloqueados, la acción se cancela y el jugador recibe un mensaje de advertencia en rojo con estilo personalizado.

## Qué hace exactamente

- Escucha eventos de comandos en el servidor.
- Detecta si el comando ingresado coincide con uno bloqueado.
- Cancela la ejecución del comando.
- Muestra un mensaje personalizado y aleatorio al jugador.
- Registra en consola qué comando fue bloqueado y quién lo intentó usar.

## Comandos bloqueados

El mod trae una lista amplia de comandos bloqueados por defecto. Entre ellos están:

- `/give`
- `/fill`
- `/summon`
- `/xp`
- `/experience`
- `/tp`
- `/teleport`
- `/kill`
- `/clear`
- `/gamemode`
- `/gm`
- `/setblock`
- `/gamerule`
- `/time`
- `/weather`

La lista está centralizada en la clase [ListaComandosBloqueado.java](src/main/java/com/nocommands/mod/ListaComandosBloqueado.java), así que agregar o quitar comandos es fácil.

## Cómo funciona internamente

1. El servidor detecta un intento de uso de comando.
2. [CommandBlocker.java](src/main/java/com/nocommands/mod/CommandBlocker.java) toma el texto escrito por el jugador.
3. Se limpia la barra inicial `/` si existe y se compara el comando en minúsculas.
4. Si coincide con uno de los comandos prohibidos, el evento se cancela.
5. Se envía un mensaje visual en rojo usando [MensajesPersonalizados.java](src/main/java/com/nocommands/mod/MensajesPersonalizados.java).

## Mensajes personalizados

En vez de mostrar siempre el mismo aviso, el mod usa una lista de frases para responder con un estilo más agresivo y variado. Algunas frases se asignan a comandos concretos, y otras se eligen al azar para dar más variedad.

## Dónde se registra el mod

La clase principal es [NoCommandsMod.java](src/main/java/com/nocommands/mod/NoCommandsMod.java). Ahí se registra el manejador de comandos en el bus de eventos de NeoForge.

## Resultado para el jugador

Cuando alguien intenta usar un comando bloqueado:

- el comando no se ejecuta,
- aparece una advertencia en rojo,
- y el servidor deja constancia del intento en el log.

## Uso esperado

Este mod sirve para servidores donde se quiere limitar el uso de comandos destructivos, de edición masiva o de abuso administrativo. Es útil para modos de juego competitivos, servidores privados o mundos donde se quiera mantener más control sobre el entorno.

## Si quieres ampliarlo

Puedes extenderlo fácilmente:

- agregando más comandos a la lista bloqueada,
- cambiando los mensajes de advertencia,
- o creando reglas diferentes según el tipo de jugador o permiso.

Si quieres, también puedo dejar este mismo contenido integrado y mejor formateado en el README principal.