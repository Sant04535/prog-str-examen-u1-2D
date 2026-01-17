# Examen U1 — Git: ramas, conflicto y merge 

## Reglas obligatorias
1) Prohibido merge a `main`.
2) Ramas obligatorias (desde `main`):
- `nombre-apellido/develop`
- `nombre-apellido/merge`

> Ejemplo: `luis-garcia/develop` y `luis-garcia/merge`

## Línea objetivo (debe provocar el conflicto)
Editarás la **misma línea** en ambas ramas para provocar el conflicto.

**INSTRUCCIÓN IMPORTANTE:**
- **Edita SOLO esta línea**, no modifiques el resto del README.

**LÍNEA OBJETIVO (NO BORRAR):**
`MENSAJE_CLAVE: PENDIENTE`

## Pasos obligatorios
1) Clona el repo y ábrelo en IntelliJ.
2) Asegúrate de estar en `main`.
3) Crea y cambia a: `nombre-apellido/develop`
4) En `nombre-apellido/develop`:
   - Cambia la línea objetivo a: `MENSAJE_CLAVE: develop`
   - Commit: `develop: cambio para conflicto`
   - Push.
5) Regresa a `main`.
6) Crea y cambia a: `nombre-apellido/merge`
7) En `nombre-apellido/merge`:
   - Cambia la línea objetivo a: `MENSAJE_CLAVE: merge`
   - Commit: `merge: cambio para conflicto`
   - Push.
8) En `nombre-apellido/merge`, haz merge:
   - `nombre-apellido/develop` ➜ `nombre-apellido/merge`
9) Resuelve el conflicto dejando el resultado final EXACTO así:
   - `MENSAJE_CLAVE: RESUELTO (develop + merge)`
10) Finaliza el merge (commit si aplica) y push.

## Evidencias a entregar
1) Link del repo.
2) Evidencia de ramas `nombre-apellido/develop` y `nombre-apellido/merge` puede ser captura o link.
3) Evidencia del merge en la rama `nombre-apellido/merge` puede ser captura o link.
4) Evidencia de que `main` no recibió merges.
