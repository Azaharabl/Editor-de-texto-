# Editor-de-texto-
Ejercicio de la realización desde 0 de un editor de texto 

## Explicación
Bloc de notas utilizando las herramientas proporcionadas por
NetBeans para el desarrollo visual de Interfaces gráficas.

El bloc de notas debe tener el mismo aspecto y funcionalidad de una
típica aplicación de Notepad de tu sistema operativo:

    Sistema de Menús:
        Archivo
            Nuevo - validar si el usuario quiere guardar los cambios antes de crear un nuevo archivo
            Abrir - utilizar JFileChooser para abrir un nuevo archivo, validar si quiere guardar cambios
            Guardar - guardar cambios en un archivo existente o crearlo si todavía no existe
            Guardar cono - guardar los cambios en un nuevo archivo
            Imprimir - imprimir con el cuadro de dialogo proporcionado por la librería Swing
        Edición
            Deshacer - habilitar la opción de rehacer o deshacer los cambios mediante UndoManager
            Copiar - copiar texto seleccionado (Toolkit de awt, getSystemClipboard)
            Cortar - cortar texto seleccionado (Toolkit de awt, getSystemClipboard)
            Pegar - pegar texto del portapapeles en la posición o selección del cursor (Toolkit y datatransfer de awt)
            Eliminar - sustitución de la funcionalidad de la tecla Suprimir.
        Formato (Opcional)
            Fuente - utilizar un JDialog para crear una ventana que permita seleccionar tipo, estilo y tamaño de la fuente
            Color de fondo - utilizar un JColorChooser para modificar el color de fondo del area de texto
        Ver
            Barra de Estado - Indicar la fila y columna en la que se encuentra el cursor
        Ayuda
            Acerca de - mostrar la información de autoría del bloc de notas en un JOptionPane o JDialog modal
            Ver ayuda - Redirigir a una URL con la ayuda de la aplicación (puede ser cualquier página web)

        Otras mejoras (Opcional):
            mejora el sistema de menús para que las opciones que no están disponibles (pegar cuando no hay nada en el portapapeles, copiar cuando no hay texto seleccionado...) aparezcan deshabilitadas.
            Implementa la funcionalidad de Ajuste de línea del bloc de notas.
            PopupMenu o menú contextual, para que al pulsar con el botón derecho se puedan realizar las operaciones básicas sobre el portapapeles.
