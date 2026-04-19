# NoCommands Mod — NeoForge 1.21.5

Bloquea `/give`, `/fill` y `/summon` para **todos** los jugadores,
incluso los que tienen OP. Al intentar usarlos aparece en rojo:

> ⚠ No lo hagas puerco ⚠

---

## Compilar el mod

### Requisitos
- Java 21 (JDK)
- Gradle (incluido con el wrapper)

### Pasos

```bash
# Clonar / descomprimir el proyecto
cd nocommands

# Compilar el .jar
./gradlew build
```

El `.jar` quedará en:
```
build/libs/nocommands-1.21.5.jar
```

---

## Instalar en el servidor

1. Copia `nocommands-1.21.5.jar` a la carpeta `mods/` de tu servidor NeoForge 1.21.5.
2. Reinicia el servidor.
3. Listo — los comandos quedan bloqueados automáticamente.

> **Nota:** El mod solo necesita estar en el servidor. No hace falta instalarlo en el cliente.

---

## Comandos bloqueados

| Comando  | ¿Bloqueado para OP? |
|----------|---------------------|
| `/give`  | ✅ Sí               |
| `/fill`  | ✅ Sí               |
| `/summon`| ✅ Sí               |

---

## Agregar más comandos bloqueados

Edita `CommandBlocker.java`, en la lista `BLOCKED_COMMANDS`:

```java
private static final List<String> BLOCKED_COMMANDS = List.of(
    "give",
    "fill",
    "summon",
    "gamemode",   // <-- agrega aquí más comandos
    "tp"
);
```

Luego recompila con `./gradlew build`.
