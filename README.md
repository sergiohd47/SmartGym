# SmartGym
## Indice
- [Introduccion](#id1). 
- [Primera fase](#id2). 
    - [Segmentacion del acceso](#id3). 
    - [Entidades principales](#id4).
    - [Funcionalidad servicio interno](#id5). 
    - [Integrantes proyecto](#id6).
    
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

   - _Entidad Usuario Gimnasio:_ se trata del usuario apuntado al gimnasio. Este podra contactar con un entrenador para poder realizar un servicio de seguimiento personalizado. Ademas de este servicio, el usuario podra visualizar, valorar y comentar una serie de rutinas de entrenamiento y clases presenciales disponibles en el gimnasio.
   
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
