# SmartGym
![Alt text](https://github.com/sergiohd47/SmartGym/blob/master/logoSmartGym.png)
## Indice
- [Introduccion](#id1)
- [Primera fase](#id2) 
    - [Segmentacion del acceso](#id3) 
    - [Entidades principales](#id4)
    - [Funcionalidad servicio interno](#id5) 
    - [Integrantes proyecto](#id6)
- [Segunda fase](#id7)
    - [Diagrama de clases](#id8)
    - [Diagrama E/R](#id9) 
    - [Visualización de páginas](#id10)
	
### Introduccion<a name="id1"></a>
La pagina web SmartGym consiste en la pagina web de un gimnasio donde se facilita el seguimiento de rutinas para usuarios del gimnasio mediante monitores titulados.  

Por otro lado, los usuarios del gimnasio, podran descargar e imprimir sus rutinas personalizadas, ademas de llevar un control del horario de las diferentes clases disponibles que forman parte de su entrenamiento.

### Primera fase<a name="id2"></a>
#### Segmentacion del acceso<a name="id3"></a>
En la pagina web, segmentaremos el acceso a esta con dos partes bien distinguidas: una parte publica con acceso universal y una parte privada donde es necesario un registro.
   - ***Parte publica:*** se trata de una parte de acceso universal donde se puede ver una descripcion del gimnasio, mediante fotos, ubicacion y diferentes aspectos.  Ademas podremos ver un pequeño ejemplo de una serie entrenamientos generales y las diferentes clases a disposicion de los usuarios.
   - ***Parte privada:*** parte de acceso restringida.  Podemos encontrar dentro de esta parte dos perfiles:
       - _Perfil usuario gimnasio:_ cada usuario del gimnasio tendra una cuenta donde podran acceder a rutinas personalizadas, mediante la comunicacion con un entrenador personal, ademas de poder ver la disponibilidad y horarios de las diferentes clases ofertadas por el gimnasio.
       - _Perfil entrenador:_ usuario especial del gimnasio, el cual puede realizar diferentes rutinas de entrenamiento a los usuarios que demandan sus servicios.

#### Entidades principales<a name="id4"></a>
En cuanto a la estructura interna de la pagina web, podremos encontrar una serie entidades basicas. 

   - _Entidad Usuario Gimnasio:_ se trata del usuario apuntado al gimnasio. Este podra contactar con un entrenador para poder realizar un servicio de seguimiento personalizado. Ademas de este servicio, el usuario podra visualizar, valorar y comentar una serie de rutinas de entrenamiento y clases presenciales disponibles en el gimnasio. Puede guardar una lista con sus rutinas favoritas.
   
   - _Entidad Entrenador Personal:_ se trata de un usario del gimnasio con servicios especiales. Tiene la posibilidad de crear y compartir con sus clientes las rutinas de entrenamiento especificas. Añadidamente, este perfil podra comunicarse con los usuarios que hayan contratado sus servicios.
   
   - _Entidad Rutina Entrenamiento:_ rutina de ejercicios que componen el entrenamiento de un usuario. Estas rutinas pueden ser generales(disponibles desde la parte publica de la pagina web) y especificas(realizadas por los entrenadores personales).
    Ademas, es posible que sean valoradas por los usuarios, quedando almacenadas las favoritas en funcion de un usuario concreto.
   
   - _Entidad Retroalimentacion:_ posibilidad de los usuarios de puntuar o realizar un comentario a una rutina de entrenamiento o a un entrenador personal en concreto. 
   
   - _Entidad Clase:_ clases presenciales disponibles por el usuario. En concreto podra disponer de clases de Spinning, Crossfit o Zumba. En estas, el usuario podra reservar plaza, ya que son limitadas, y elegir horario que mejor le convenga.

#### Funcionalidad servicio interno<a name="id5"></a>
La funcionalidad principal del servicio interno de nuestra pagina web queda dividida fundamentalmente en tres pilares:
   - Comunicacion entre usuarios
   - Descargar rutina de entrenamiento en formato PDF
   - Descargar horario de las diferentes clases en formato PDF
   
#### Integrantes proyecto<a name="id6"></a>
El equipo de desarrollo de la pagina web es:
   - ***Borja Martin Alonso***
      - _Correo URJC:_ b.martinal@alumnos.urjc.es
      - _Usuario GitHub:_ [BorjaPiruXx](https://github.com/BorjaPiruXx)
   - ***Daniel Molina Ballesteros***
      - _Correo URJC:_ d.molinab@alumnos.urjc.es
      - _Usuario GitHub:_ [danyelmb](https://github.com/danyelmb)
   - ***Sergio Hernandez Dominguez***
      - _Correo URJC:_ s.hernandezdo@alumnos.urjc.es
      - _Usuario GitHub:_ [sergiohd47](https://github.com/sergiohd47)

### Segunda fase<a name="id7"></a>
#### Diagrama de clases<a name="id8"></a>
   - ***Parte Pública***
      - La entidad ***Usuario***, esté o no registrado en la página, puede realizar diferentes acciones dentro la interfaz de la clase _index.html_ (ver las rutinas, instalaciones y poder contactar con el propio gimnasio) mediante su respectivo controlador **Inicio**. Este controlador puede conectarse a su vez con otros dos controladores distintos, cuya función es que la entidad **Usuario** pueda registrarse o acceder a la página del gimnasio mediante los controladores **Registro** y **Acceso** respectivamente. Si el usuario se registra como un nuevo integrante de la página web, sea un usuario básico o un entrenador lo hará desde la interfaz _registro.html_ y se redirigirá a la interfaz _acceso.html_ para entrar en la parte privada de dicho usuario.
      ![Alt text](https://github.com/sergiohd47/SmartGym/blob/master/SmartGym_PartePublica.png)

   - ***Parte Privada(Usuario Básico)***
      - Al acceder como un usuario normal, la entidad ***UsuarioBasico*** tiene como jefe de tareas al controlador **Usuario** que, al saber que es un usuario básico del centro le ofrece la posibilidad de realizar diferentes acciones (ver clases presenciales o rutinas favoritas) mediante la interfaz de la clase _usuarioBasico.html_. Este controlador principal puede conectarse a otros cuatro controladores: **Clases** en el que su principal objetivo es indicar al usuario qué clases tiene disponibles para realizar en el gimnasio y se enlaza con un nuevo controlador denominado **ApuntarClase** cuya función será la de apuntar a dicho usuario a esa clase mediante _apuntarseClase.html_; **ContactarEntrenador** que tiene como objetivo que el propio usuario tenga la posibilidad de contactar con el entrenador que impartirá alguna de las clases del gimnasio; **EditarPerfil** en el que el propio usuario podrá editar sus datos personales si lo desea mediante la interfaz _editarPerfil.html_; **CierreSesion** permite al usuario, en caso de que no tenga ninguna acción más que realizar en su cuenta, la posibilidad de cerrar su sesión mediante la interfaz _cerrarSesion.html_ con la que regresará a la página principal del gimnasio.
      ![Alt text](https://github.com/sergiohd47/SmartGym/blob/master/SmartGym_PartePrivada(I).png) 
 
   - ***Parte Privada(Usuario Entrenador)***
      - Si el usuario accedió como entidad ***UsuarioEntrenador***, el controlador **Usuario** sabrá que es un entrenador del gimnasio y le ofrecerá ciertas acciones (ver clases presenciales, rutuinas favoritas,editar su perfil o cerrar sesión) idénticas que puede realizar un usuario normal pero con la variante de que el entrenador puede ojear las personas inscritas o que quieren reservar su clase mediante el controlador **CarteraClientes** cuya interfaz es _carteraClientes.html_.
      ![Alt text](https://github.com/sergiohd47/SmartGym/blob/master/SmartGym_PartePrivada(II).png)

#### Diagrama E/R<a name="id9"></a>
![Alt text](https://github.com/sergiohd47/SmartGym/blob/master/EntidadRelacion.png)

#### Visualización de páginas<a name="id10"></a>
   - ***Página Principal***   
   ![Alt text](https://github.com/sergiohd47/SmartGym/blob/master/ImagenesPaginaWeb/SmartGym1.PNG)
      - _Inicio:_ breve descripción del gimnasio y de sus integrantes para poder lograr la atención del usuario y se inscriba en ella 
	  ![Alt text](https://github.com/sergiohd47/SmartGym/blob/master/ImagenesPaginaWeb/SmartGym2.PNG)		 
	  - _Trato Personalizado:_ sevicio de seguimiento para el usuario, o bien mediante un entrenador personal o siguiendo una dieta y rutinas diarias 
	  ![Alt text](https://github.com/sergiohd47/SmartGym/blob/master/ImagenesPaginaWeb/SmartGym3.PNG)	 
	  - _Servicios:_ diferentes zonas de entrenamiento para el gusto de cada usuario 
	  ![Alt text](https://github.com/sergiohd47/SmartGym/blob/master/ImagenesPaginaWeb/SmartGym4.PNG)
	  ![Alt text](https://github.com/sergiohd47/SmartGym/blob/master/ImagenesPaginaWeb/SmartGym5.PNG)	 
	  - _Contacto:_ contactar con el gimnasio mediante su número de teléfono y correo electrónico 
	  ![Alt text](https://github.com/sergiohd47/SmartGym/blob/master/ImagenesPaginaWeb/SmartGym6.PNG)
	  - _Registrarse:_ opción de registro en el gimnasio cuando un usuario no esté inscrito en él. Puede hacerlo como usuario básico o entrenador 
	  ![Alt text](https://github.com/sergiohd47/SmartGym/blob/master/ImagenesPaginaWeb/SmartGym7.PNG) 
	  - _Acceder:_ opción de acceso para cualquier usuario del gimnasio, ya sea usuario básico o entrenador 
	  ![Alt text](https://github.com/sergiohd47/SmartGym/blob/master/ImagenesPaginaWeb/SmartGym8.PNG)
   
   - ***Página Usuario Básico***
   ![Alt text](https://github.com/sergiohd47/SmartGym/blob/master/ImagenesPaginaWeb/SmartGym9.PNG)
      - _Clases Presenciales:_ disponibilidad de las clases impartidas. A la hora de realizar click, se acceder a la pagina de la clase en concreto
	  ![Alt text](https://github.com/sergiohd47/SmartGym/blob/master/ImagenesPaginaWeb/SmartGymDAD1.PNG)
			- _Clases:_ pagina de clases presenciales
			![Alt text](https://github.com/sergiohd47/SmartGym/blob/master/ImagenesPaginaWeb/SmartGym15.PNG)
			- _Visualizar Tipo de Clase:_ explica al usuario las funcionalidades de cada clase (duracion, nivel de intensidad de cardio o de fuerza, sala y número total de plazas) 
			![Alt text](https://github.com/sergiohd47/SmartGym/blob/master/ImagenesPaginaWeb/SMDAD2.PNG) 
			- _Seleccionar Horario de Clase:_ posibilidad para el usuario de elegir su horario deseado para ejecutar dicho tipo de clase 
			![Alt text](https://github.com/sergiohd47/SmartGym/blob/master/ImagenesPaginaWeb/SmartGym17.PNG)			 
	  - _Entrenador Personal:_ el usuario puede seguir la rutina del entrenador personal que haya escogido. En caso de no tener entrenador, podrá contactar con alguno de ellos. El usuario escribira el objetivo de la rutina pedida y dara click a enviar, por el cual se contactara con entrenador.
	  ![Alt text](https://github.com/sergiohd47/SmartGym/blob/master/ImagenesPaginaWeb/SMDAD3.PNG)
	  - _Seguimiento Personalizado:_ una vez contactado con el entrenador, en esta seccion se almacenaran las rutinas personal.
	  ![Alt text](https://github.com/sergiohd47/SmartGym/blob/master/ImagenesPaginaWeb/SMDAD4.PNG)
	  - _Rutinas Favoritas:_ visualización de las rutinas favoritas elegidas por el usuario 
	  ![Alt text](https://github.com/sergiohd47/SmartGym/blob/master/ImagenesPaginaWeb/SMDAD5.PNG) 
	  - _Editar Perfil:_ el usuario podrá editar su perfil cuando él lo desee 
	  ![Alt text](https://github.com/sergiohd47/SmartGym/blob/master/ImagenesPaginaWeb/SmartGym13.PNG) 
	  - _Cerrar Sesion:_ el usuario podrá cerrar su sesión en cualquier momento 
	  ![Alt text](https://github.com/sergiohd47/SmartGym/blob/master/ImagenesPaginaWeb/SmartGym14.PNG)
		 
   - ***Página Usuario Entrenador***
	  Muchas de las funcionalidades básicas de un usuario básico también las proporciona un entrenador (ver clases presenciales o rutinas favoritas, editar perfil y cerrar sesión)
      - _Cartera Clientes:_ organización del trabajo para cada entrenador 
	  ![Alt text](https://github.com/sergiohd47/SmartGym/blob/master/ImagenesPaginaWeb/SmartGym18.PNG)
			- _Visualizar Cartera Clientes:_ el entrenador podrá ver la lista de clientes que se hayan puesto en contacto con él para solicitar sus servicios. Una vez seleccionado el archivo mediante el boton Seleccionar Archivo, se mandara esta al usuario.
			![Alt text](https://github.com/sergiohd47/SmartGym/blob/master/ImagenesPaginaWeb/SMDAD6.PNG)
			- _Clases Presenciales:_ un entrenador tendra disponible la opcion de añadir una clase nueva o editar el horario de una de ellas.
			![Alt text](https://github.com/sergiohd47/SmartGym/blob/master/ImagenesPaginaWeb/SMDAD9.PNG)
					- _Editar Horario:_ posibilidad de editar horario de una clase
					![Alt text](https://github.com/sergiohd47/SmartGym/blob/master/ImagenesPaginaWeb/SMDAD7.PNG)
					- _Añadir Clase:_ posibilidad de añadir una clase nueva
					![Alt text](https://github.com/sergiohd47/SmartGym/blob/master/ImagenesPaginaWeb/SMDAD8.PNG)
   
   
