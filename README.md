##README

* El programa se ejecuta desde el main. Desde allí se accede a la interface (en esta entrega se debe usar la consola) desde donde se puede hacer las funcionalidades pedidas.

* Las personas que ingresan deben identificarse como alumno o como administrador. Ambos tiene una clave para ingresar, sin embargo para esta entrega todavía no está implementada la verificación de la clave (siempre se autoriza el ingreso).

* Los administradores no son guardados en el sistema, ya que su información personal no resulta importante a la hora del funcionamiento -solo importa si tiene autorización para hacer cambios, no su información personal-.

* Los alumnos son guardados a través de una serialización en archivos de extensión .bin, en donde además de sus datos personales se almacena su carga académica con sus cursos respectivos. Cada archivo tiene el nombre del rut del alumno, debido a que es un indicador único. 

* Cualquier persona que acceda al programa puede crear un usuario, entregando la información que el programa le pide.

* El programa solo dejara acceder a usuarios que ya tengan una cuenta creada (es decir, un archivo con su información). Para entrar al sistema se debe crear una cuenta, o utilizar una ya existente (el rut 183949217 viene implementado).

* Cada curso tiene un indicador específico, llamado ID. De esta forma, se puede diferenciar entre un mismo curso dictado en años diferentes, o en secciones distintas. El objetivo de esto es simplemente facilitar el funcionamiento del sistema.

* Siempre que una persona agregue un nuevo curso, su nota será por defecto 0. Cuando una persona decide cerrar semestre, escribe la nota de los cursos que terminó de hacer y de esta forma la nota se convierte en una nota real -de rango desde el 1.0 hasta el 7.0-. De esta forma, si en el futuro necesitamos saber cuales ramos están cerrados o cuales fueron reprobados, basta con diferenciar entre las notas que están entre el 1.0 y el 3.9 (reprobadas), y aquellas que la nota es 0.0 (en curso).

* Si bien la gran mayoría de los input entregados por el usuario son verificados para evitar errores, además de manejar las distintas excepciones, se recomienda que para esta versión del programa se cumple con estricto rigor la forma especificada de entregar los valores. Por ejemplo, cuando la interfaz pide ingresar un id de un curso, este debe ser entregado de la forma "idxxx" (por ejemplo, id016).

* El catálogo de cursos se guarda en un archivo .txt, el cual puede ser modificado por un administrador, y puede ser leída por un alumno (para obtener información de los distintos cursos dictados).

* Cada malla es guardada como un archivo .txt en donde están escritas las siglas de los distintos ramos que tiene. Cuando un alumno quiere observar su malla, solo se la muestra si esta existe (si la carrera del alumno es ingeniería -malla que viene ya implementada- la interfaz mostrara los cursos respectivos).


