# Examen U1 — Git: ramas, conflicto y merge 


---

## Reglas obligatorias
1) **PROHIBIDO** hacer merge a `main`.
2) Debes crear exactamente estas ramas (desde `main`):
- `nombre-apellido/develop`
- `nombre-apellido/merge`

> Ejemplo: `juan-perez/develop` y `juan-perez/merge`

---

## Proyecto a crear (obligatorio)
Vas a crear un proyecto Java en IntelliJ con el nombre:

 **Nombre del proyecto:** `U1GitConflictoPlus`

El proyecto debe contener **2 archivos**:
- `Main.java`
- `Factura.java`

---

## Línea objetivo (provoca el conflicto)
Vas a modificar la **misma línea** en tus dos ramas para provocar el conflicto.

**INSTRUCCIÓN IMPORTANTE:**
- Edita **SOLO** esta línea (sin duplicarla y sin moverla de lugar).
- No cambies el texto alrededor, solo el valor (el texto entre comillas).
- Antes de comenzar, quita las credenciales de git desde el adminsitrador de credenciales (Como lo vimos en clase) y en la terminal configura tu usuario desde la terminal:
git config --global --unset user.name
git config --global --unset user.email

git config --global user.name "Tu Nombre Apellido"
git config --global user.email "tu-correo@ejemplo.com"

**LÍNEA OBJETIVO (NO BORRAR) — en `Factura.java`:**
```java
public static final String VERSION_OBJETIVO = "PENDIENTE";
```

---

## Pasos obligatorios

### 1) Clonar y abrir el repo
1. Clona el repositorio proporcionado por el docente.
2. Abre IntelliJ.
3. Selecciona **Open** y abre la carpeta del repositorio clonado.

### 2) Crear el proyecto `U1GitConflictoPlus` dentro del repo (en `main`)
> IMPORTANTE: El proyecto debe quedar **dentro** de la carpeta del repo clonado.

1. En IntelliJ ve a **File → New → Project**.
2. Tipo: **Java** (sin frameworks) y desmarca la opcion de create Git repository (IMPOTANTE).
3. **Name:** `U1GitConflictoPlus`
4. En **Location**, asegúrate de crearlo **dentro del repo clonado** (se creará una carpeta `U1GitConflictoPlus/` dentro del repo).
5. Crea/asegura que existan estos archivos:
   - `U1GitConflictoPlus/src/Main.java`
   - `U1GitConflictoPlus/src/Factura.java`

6. Pega este código base (obligatorio).

**Factura.java**
```java
public class Factura {

    public static final String VERSION_OBJETIVO = "PENDIENTE";

    private static final double IVA = 0.16;
    private static final double PRECIO_UNITARIO = 1200.0;

    public static double calcularTotal(int cantidad) {
        double subtotal = cantidad * PRECIO_UNITARIO;
        return subtotal + (subtotal * IVA);
    }
}
```

**Main.java**
```java
public class Main {

    public static void main(String[] args) {
        int cantidad = 3;

        double total = Factura.calcularTotal(cantidad);

        System.out.println("Version: " + Factura.VERSION_OBJETIVO);
        System.out.println("Total: " + total);
    }
}
```

7. Ejecuta el programa una vez para confirmar que compila y corre.
8. En `main`, realiza un commit inicial:
   - Mensaje: `init: proyecto U1GitConflictoPlus`
9. Haz **push** a tu repositorio remoto.

---

### 3) Crear rama develop y hacer cambio 1 (conflicto)
1. Verifica que estás en `main`.
2. Crea y cámbiate a: `nombre-apellido/develop`
3. En `Factura.java`, cambia la línea objetivo a:

```java
public static final String VERSION_OBJETIVO = "develop";
```

4. Commit con mensaje: `develop: cambio para conflicto`
5. Push de tu rama al remoto.

---

### 4) Crear rama merge y hacer cambio 2 (conflicto)
1. Regresa a `main`.
2. Crea y cámbiate a: `nombre-apellido/merge`
3. En `Factura.java`, cambia la línea objetivo a:

```java
public static final String VERSION_OBJETIVO = "merge";
```

4. Commit con mensaje: `merge: cambio para conflicto`
5. Push de tu rama al remoto.

---

### 5) Merge hacia la rama merge (NO main) y resolver conflicto
1. Asegúrate de estar en `nombre-apellido/merge`.
2. Haz merge de:
   - `nombre-apellido/develop` ➜ `nombre-apellido/merge`
3. Debe aparecer un conflicto. Resuélvelo y deja el resultado final **EXACTO** así (en `Factura.java`):

```java
public static final String VERSION_OBJETIVO = "RESUELTO (develop + merge)";
```

4. Asegúrate de que NO queden marcadores:
   - `<<<<<<<`, `=======`, `>>>>>>>`
5. Finaliza el merge (commit si aplica) y haz **push**.
6. Verifica en GitHub que:
   - El merge quedó en `nombre-apellido/merge`
   - `main` **NO** recibió merges.

---

## Evidencias a entregar
1) Link a tu repositorio (tu fork).
2) Evidencia de que existen tus ramas (puede ser con el comando git branch o desde la pagina de git, en donde se despliegan las ramas):
   - `nombre-apellido/develop`
   - `nombre-apellido/merge`
3) Evidencia del merge en `nombre-apellido/merge` (Sirve la captura de pantalla de la termianl en donde escribes el comando git merge, y se genera el conflicto).
4) Evidencia de que `main` NO recibió merges (desde la pagina de git en el historial de commits, es un simbolo de un reloj, buscalo abajo del boton verde ´code´).
5) Evidencia del archivo final `Factura.java` con el valor final exacto.
6) Evidencia de ejecución (captura del Run) mostrando:
   - `Version: RESUELTO (develop + merge)`
   - `Total: ...`

---

## Notas importantes
- El conflicto debe ocurrir en `Factura.java` (en la constante `VERSION_OBJETIVO`).
- No edites el README para provocar el conflicto.
- Si tienes errores de autenticación al hacer push, revisa tu sesión de GitHub en IntelliJ o credenciales.
