# Laboratorio 2 - Programación III - Sistema de Biblioteca

**Equipo:** [NOMBRE DEL EQUIPO]

## Integrantes y participación (coevaluación, escala independiente 0%-100%)

| Integrante | Carnet | Participación | Concepto que defiende |
|---|---|---|---|
| Aldo Gabriel Portillo Martinez | PM-69686-25 | 25% | Herencia / superclase |
| [Nombre completo 2] | [carnet] | [__%] | Clase abstracta |
| [Nombre completo 3] | [carnet] | [__%] | Polimorfismo: sobrecarga |
| [Nombre completo 4] | [carnet] | [__%] | Polimorfismo: sobrescritura |
| [Nombre completo 5] | [carnet] | [__%] | Interfaz Prestable |

## Descripción

Sistema de gestión de biblioteca por consola (Java puro, patrón MVC).
Evolución desde el Laboratorio I: se agregó una jerarquía de herencia,
una clase abstracta, polimorfismo (sobrecarga y sobrescritura) y una interfaz propia.

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

## Cómo compilar y ejecutar (JDK 11 o superior)

Desde la carpeta raíz del proyecto:

```
javac -d out src/modelo/*.java src/vista/*.java src/controlador/*.java src/main/*.java
java -cp out main.Main
```

O desde el IDE: abrir la carpeta, marcar `src` como Sources Root y ejecutar la clase `main.Main`.

## Uso de herramientas de IA


