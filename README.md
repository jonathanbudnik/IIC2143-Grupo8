README

*El programa se ejectua desde el main. Desde allí se accede a la interface (en esta entrega se debe usar el terminal) desde donde se puede hacer las funcionalidades pedidas.

*Las personas que ingresan deben identificarse como alumno o como administrador. Ambos tiene una clave para ingresar, sin embargo para esta entrega todavía no está implementada la verificación de la clave (siempre se autoriza el ingreso).

*Los administradores no son guardados en el sistema, ya que su información personal no resulta importante a la hora del funcionamiento -solo importa si tiene autorizacion para hacer cambios, no su información personal-.

*Los alumnos son guardados a través de una serialización en archivos de extensión .bin, en donde además de sus datos personales se almacena su carga académica con sus cursos respectivos.

*Cada curso tiene un indicador específico, llamado ID. De esta forma, se puede diferenciar entre un mismo curso dictado en años diferentes, o en secciones distintas. El objetivo de esto es simplemente facilitar el funcionamiento del sistema.

*Siempre que una persona agregue un nuevo curso, si nota será por defecto 0. Cuando una persona decide cerrar semestre, escribe la nota de los cursos que terminó de hacer y de esta forma la nota se convierte en una nota real -de rango desde el 1.0 hasta el 7.0-. De esta forma, si en el futuro necesitamos saber cuales ramos están cerrados o cuales fueron reprobados, basta con diferenciar entre las notas que están entre el 1.0 y el 3.9 (reprobadas), y aquellas que la nota es 0.0 (en curso).

*Si bien la gran mayoría de los input entregados por el usuario son verificados para evitar errores, además de manejar las distintas excepciones, se recomienda que para esta versión del programa se cumple con estricto rigor la forma especificada de entregar los valores. Por ejemplo, cuando la interfaz pide ingresar un id de un curso, este debe ser entregado de la forma "idxxx" (por ejemplo, id016).

