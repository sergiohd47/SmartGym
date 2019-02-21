# SmartGym
![Alt text](https://github.com/sergiohd47/SmartGym/blob/master/logoSmartGym.png)
## Indice
- [Introduccion](#id1). 
- [Primera fase](#id2). 
    - [Segmentacion del acceso](#id3). 
    - [Entidades principales](#id4).
    - [Funcionalidad servicio interno](#id5). 
    - [Integrantes proyecto](#id6).
- [Segunda fase](#id7).
    - [Diagrama de clases](#id8).
    - [Diagrama E/R](#id9). 
    - [Visualización de páginas](#id10).

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
   ![Alt text](https://github.com/sergiohd47/SmartGym/blob/master/ImagenesPaginaWeb/SmartGym1.png)
   
         - _Inicio:_	 
         ![Alt text](https://github.com/sergiohd47/SmartGym/blob/master/ImagenesPaginaWeb/SmartGym2.png)
		 
		 - _Trato Personalizado:_
		 ![Alt text](https://github.com/sergiohd47/SmartGym/blob/master/ImagenesPaginaWeb/SmartGym3.png)
		 
		 - _Servicios:_
		 ![Alt text](https://github.com/sergiohd47/SmartGym/blob/master/ImagenesPaginaWeb/SmartGym4.png)
		 
		 ![Alt text](https://github.com/sergiohd47/SmartGym/blob/master/ImagenesPaginaWeb/SmartGym5.png)
		 
		 - _Contacto:_
		 ![Alt text](https://github.com/sergiohd47/SmartGym/blob/master/ImagenesPaginaWeb/SmartGym6.png)

		 - _Registrarse:_
		 ![Alt text](https://github.com/sergiohd47/SmartGym/blob/master/ImagenesPaginaWeb/SmartGym7.png)
		 
		 - _Acceder:_
		 ![Alt text](https://github.com/sergiohd47/SmartGym/blob/master/ImagenesPaginaWeb/SmartGym8.png)
   
   - ***Página Usuario Básico***
   ![Alt text](https://github.com/sergiohd47/SmartGym/blob/master/ImagenesPaginaWeb/SmartGym9.png)
   
         - _Clases Presenciales:_
		 ![Alt text](https://github.com/sergiohd47/SmartGym/blob/master/ImagenesPaginaWeb/SmartGym10.png)
		 
		     - _Clases:_
			 ![Alt text](https://github.com/sergiohd47/SmartGym/blob/master/ImagenesPaginaWeb/SmartGym15.png)
			 
				 - _Visualizar Tipo de Clase:_
				 ![Alt text](https://github.com/sergiohd47/SmartGym/blob/master/ImagenesPaginaWeb/SmartGym16.png)
				 
				 - _Seleccionar Horario de Clase:_ 
				 ![Alt text](https://github.com/sergiohd47/SmartGym/blob/master/ImagenesPaginaWeb/SmartGym17.png)
				 
		 - _Entrenador Personal:_
		 ![Alt text](https://github.com/sergiohd47/SmartGym/blob/master/ImagenesPaginaWeb/SmartGym11.png)
		 
		 - _Rutinas Favoritas:_
		 ![Alt text](https://github.com/sergiohd47/SmartGym/blob/master/ImagenesPaginaWeb/SmartGym12.png)
		 
		 - _Editar Perfil:_
		 ![Alt text](https://github.com/sergiohd47/SmartGym/blob/master/ImagenesPaginaWeb/SmartGym13.png)
		 
		 - _Cerrar Sesion:_
		 ![Alt text](https://github.com/sergiohd47/SmartGym/blob/master/ImagenesPaginaWeb/SmartGym14.png)
		 
   - ***Página Usuario Entrenador***
   
         - _Cartera Clientes:_
		 ![Alt text](https://github.com/sergiohd47/SmartGym/blob/master/ImagenesPaginaWeb/SmartGym18.png)
		 
             - _Visualizar Cartera Clientes:_
		     ![Alt text](https://github.com/sergiohd47/SmartGym/blob/master/ImagenesPaginaWeb/SmartGym19.png)
		 
   
   