# Laboratorio 2 - Programación III - Sistema de Biblioteca

**Equipo:** IDK-TEAM

## Integrantes y participación (coevaluación, escala independiente 0%-100%)

| Integrante | Carnet | Participación | Concepto que defiende |
|---|---|---|---|
| Jonathan Remberto Mercado Monge | MM-69751-25 | 20% | Herencia / superclase |
| Aldo Gabriel Portillo Martinez | PM-69686-25  | 20% | Clase abstracta |
| Denys Fernando Garcia Alvarado | GA-69750-25 | 20% | Polimorfismo: sobrecarga |
| Jose Andres Estrada Martinez | EM-69723-25 | 20%  | Polimorfismo: sobrescritura |
| Chelsea Guadalupe Castellanos Hernandez | CH-69772-25 | 5% | Interfaz Prestable |
| William Alejandro Alfaro Videz | AV-69833-25 | 5% | Interfaz Prestable |

## Descripción

Sistema de gestión de biblioteca por consola (Java puro, patrón MVC).
Una clase abstracta, polimorfismo (sobrecarga y sobrescritura) y una interfaz propia.

| Concepto | Dónde está |
|---|---|
| Herencia | `Usuario` -> `Estudiante`, `Docente`; `Recurso` -> `Libro`, `Revista` |
| Clase abstracta | `Usuario` (método abstracto `getLimitePrestamos()`, métodos concretos) |
| Sobrecarga | `Usuario.puedePrestar()` / `puedePrestar(int)`; `ControladorBiblioteca.buscarRecurso(int)` / `buscarRecurso(String)` |
| Sobrescritura | `getLimitePrestamos()`, `Docente.presentarse()`, `toString()` en `Libro` y `Revista` |
| Interfaz | `Prestable`, implementada por `Libro` y `Revista`, usada como `ArrayList<Prestable>` |

## Estructura

```
src/
  modelo/        Usuario, Estudiante, Docente, Recurso, Libro, Revista, Prestable
  vista/         VistaConsola
  controlador/   ControladorBiblioteca
  main/          Main
```

## Cómo compilar y ejecutar (JDK 21)

Desde la carpeta raíz del proyecto:

```
Descargar la carpeta, luego abrir la carpeta en su IDE de preferencia y ejecutar el archivo llamado "Main"
```



## Uso de herramientas de IA
Qué herramientas se utilizaron:Gemini.

#Para qué se utilizaron: Exclusivamente como apoyo técnico para organizar la estructura de carpetas y paquetes del proyecto bajo el patrón arquitectónico MVC (Modelo-Vista-Controlador).

#Cómo se validó y corrigió el resultado: El equipo verificó manualmente que la distribución de las clases en los paquetes (modelo, vista, controlador, main) cumpliera con las convenciones de Java y garantizara la correcta compilación del sistema localmente.


