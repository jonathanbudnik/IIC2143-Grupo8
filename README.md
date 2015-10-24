##README ENTREGA 4:

* El programa se corre desde la clase MainApp.

* Solo se pueden crear usuario de alumnos. Los usuarios de administrador vienen previamente creados. Para acceder a las funcionalidades del administrador, utilizar los siguientes datos:
Rut: 1234
Contraseña = 1234

* Luego de crear una cuenta, el usuario está obligado a agregar su primer semestre. Para esto, se abre automáticamente el buscador de curso. Cabe destacar que para agregar un curso, el usuario debe usar el ID de este. 

* La cantidad máxima de créditos por semestre depende del valor que le asignó el administrador. Por defecto es 60 créditos.

* Para escribir los id de cada curso, es importante que se incluyan los 0. Es decir, el curso 00001 no es lo mismo que el curso 1.

* El usuario para crear un nuevo semestre debe cerrar el último semestre agregado, escribiendo las distintas notas que obtuvo. Las notas decimales se deben escribir con puntos, no comas.

* Cuando un alumno es creado, la malla que se le adjudica por defecto es la de su carrera. Por ejemplo, si al crear mi usuario en carrera escribo “Ingeniería”, esta será la malla que tendrá asignada en un comienzo. La malla puede cambiarse fácilmente a través de la interfaz, escribiendo el nombre de la nueva malla.

* Si la malla elegida no existe, el usuario quedará con una malla “vacía” y no podrá ver si seguimiento curricular.

* En el programa vienen creadas las mallas de ingeniería, college, párvulo y agronomía. Se recomiendo utilizar la de ingeniería ya que los cursos que vienen agregados por defecto en el catalogo de cursos son de ingeniería (el administrador puede agregar más cursos).

* Cuando un alumno accede a su estado curricular, el sistema le mostrará cuantos créditos ha reprobado, y en base a esto mostrará si el alumno es todavía un alumno regular o ha sido expulsado. La cantidad por defecto de máximo de créditos reprobados es 50, pero puede ser modificado por el administrador. 