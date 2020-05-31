# proyecto fin de grado creado por Lionel Sánchez


 
Índice de contenido:
INTRODUCCIÓN	2
ACERCA DEL PROYECTO	2
OBJETIVOS Y CUESTIÓN DE LA APP	3
EL DIAGRAMA DE GANTT	4
EL PRESUPUESTO	4
HERRAMIENTAS QUE SE VAN A UTILIZAR	5
LENGUAJES DE PROGRAMACIÓN	6
JAVA	6
PHP:	8
BASES DE DATOS:	11
MySQL	11
phpMyAdmin	12
SERVIDORES.	13
XAMPP	13
ANALISIS Y DESARROLLO DEL PROYECTO:	14
DISEÑO DE LA APLICACIÓN.	15
EL diagrama de casos de uso	15
El diagrama de clases	16
Diagramas de estado	17
DESARROLLO DE LA INTERFAZ DE LA APLICACIÓN	18
BASE DE DATOS	23
PhpMyAdmin:	23
Los Diagramas	24
Registros de las tablas	25
Usuarios en la BD.	27
FUNCIONAMIENTO DE LA APLICACIÓN:	28
ENTORNO DE DESARROLLO:	33
DOCUMENTACIÓN PARA EL/LA USUARIO/A	34
MANUAL DE INSTALACIÓN (INSTALLATION GUIDE):	34
MANUAL DE USUARIO (USER GUIDE)	35
BIBLIOGRAFÍA CONSULTADA:	35



Introducción
El proyecto consiste en un receptor de radio digital vía streaming, muy útil a la hora de escuchar sus emisoras de radio favoritas con un clic, así como, ver la caratula de la misma (logotipo), visitar su página web oficial para consultar su programación, ver el listado de canciones (playlists) que se emiten, los podcasts y comentarios de los suscriptores/as.
Un poco de historia: Durante la década de los años 20 del siglo pasado (1920), solo unos pocos afortunados podían escuchar la radio, la cual estaba compuesta por elementos muy simples, cuando las emisiones fueron a más allá, en cuanto a número de emisoras, potencia y cobertura, se fue abaratando los costes de producción de la misma, en cuanto las emisoras, solo emitían en AM (Onda Media)  y podía ser recibida con unos receptores muy simples llamados Radio de galena. 
A lo largo del siglo XX, los receptores se mejoraron en calidad y diseño , aumentó su producción, con receptores de radio a válvulas, aunque eran caros, podías escucharla mediante altavoces y una etapa de amplificación , y de ahí han evolucionado a los receptores de transistores, más baratos, portables y duraderos coincidiendo la llegada de la radio en FM, el actual modo de transmisión de radio, hasta nuestros días, durante el siglo XXI, el modo de recibir la radio ha cambiado de manera sustancial, coexistiendo varios modos de transmisión, DAB (Radio Digital), FM y radio por internet.
Acerca del proyecto
My Radio.es es Una aplicación creada por cuenta propia para atraer un público en general a la aplicación, la gestión se compone de las siguientes tareas: 
a)	Asegurarse de que el enlace de la emisora funcione correctamente.
b)	Planificación de actualizaciones.
c)	Buen diseño de la interfaz.
d)	Disponer una vía de comunicación eficiente entre usuarios y administrador.
e)	Organización de la base de datos. 
f)	Disposición de elementos de reproducción de la emisora seleccionada.
La curva de aprendizaje es simple y fácil, pero es un proceso de gran responsabilidad, sobre todo en la base de datos, cuya curva de aprendizaje es más elevada, problemas que se solucionan con la implementación automática y repartiendo el trabajo de la gestión entre todos los empleados y así repartir la carga de trabajo e información para todos, etc.
Objetivos y cuestión de la app
Este proyecto pretende y facilita la promoción del Streaming de radio estés donde estés, ya que utiliza la red de telefonía para su conexión, también, se otorga asistencia al usuario en caso de problemas de software o conexión, haciendo que dicha gestión sea lo más rápida y automática posible, otro objetivo de la empresa es en la publicación diaria de actualizaciones de diseño, seguridad y optimización de la aplicación. 
En este apartado se describe y analizan los sistemas gestores de bases de datos y los servidores web, así como los estándares más utilizados hoy en día según la naturaleza de su contenido, ya sea estático o dinámico y las estructuras que lo representan. Con esto se pretende explicar las decisiones que se han tomado acerca de las tecnologías utilizadas en el proyecto, esto incluye una breve explicación de los lenguajes de programación utilizados.
Existen sistemas similares como hasta ahora, en el principal sistema que se usa en la gestión del catálogo de emisoras en manual, lo que quiero decir, es que toda la responsabilidad cae sobre una persona, el administrador de la base de datos, como persona responsable de custodiar los datos personales, así como asegurarse de su seguridad e integridad y las copias de seguridad necesarias para evitar perdida de datos. También se encarga de crear un filtro antispam, planificar el flujo de comentarios, y su conexión con la BD desde el smartphone. 
Los requisitos de esta aplicación se basan una demanda de usuarios que quieren escuchar la radio de forma sencilla y sin publicidad invasiva, lo cual es bastante complicado a la hora de encontrar dicha app, para ello se dispondrá al usuario/a este programa, con los siguientes objetivos: 
•	Cada usuario podrá disfrutar de su emisora de radio en cualquier lugar.
•	Su escucha podrá realizarse tanto con una conexión de datos como en una red Wi-Fi.
•	El usuario podrá consultar la historia de la radio.
•	Se podrá visitar la web oficial de cada emisora y ver su contenido.
Por último, el usuario podrá realizar un comentario sobre la aplicación
El problema está en que todavía hay personas que no utilizan el servicio de radio por internet, si no la radio en FM, por lo que este tipo de emisiones no son populares (Streaming), pero en caso de que los medios tradicionales no estén disponibles como, mala cobertura, se puede recurrir en este tipo de recepción y problema resuelto.
El diagrama de Gantt es una tabla/cronología de tareas utilizada para describir el tiempo de realización de un proyecto por tiempos. Reflejado en la siguiente tabla:
 
El presupuesto para esta aplicación, en el caso de que exista empresa, asciende 388 mil (388000) Euros necesarios para la implantación y son: pago de derechos de autor, alquiler de servidores, promoción de la app, cuota mensual atributiva a los empleados, distribución en smartphones, recambios de piezas para equipos informáticos, servicios de internet.
Dichos presupuestos quedan reflejados en este apartado.
i.	El alquiler de servidores oscilaría entre 10 y 20€ mensuales, según compañía y contrato. Aunque existen servers gratuitos, la mayoría de las empresas tiene un server dedicado a backups, de pago. Hasta 2TB.
ii.	La promoción de la app, está vinculada al boca-boca y a la publicidad, en caso de requerir la publicidad tiene un coste desde 500€/minuto hasta superara los 2mill €/minuto. La publicidad en radio es más económica, no alcanza los 150/min.
iii.	En materia de la retribución mensual, cada empleado tendrá un sueldo de 1500€/mensuales.
iv.	En cuanto a los servicios de internet, la tarifa más asequible rondaría los 250€ (internet empresarial) mensuales, que consiste en llamadas ilimitadas a todos los empleados, 3GB y 100 Mbps simétricos fibra óptica.
Al ser una aplicación creada por cuenta propia, solo se necesita un equipo, software necesario y la conexión a internet. Así como las herramientas necesarias que se detallan a continuación:
Herramientas que se van a utilizar 
Para llevar a cabo el proyecto y ver como se ha realizado, se utilizará como sistema operativo Microsoft Windows 10, como entornos de desarrollo Android Studio y la base de datos un servidor local XAMMP en equipos de sobremesa de gama media y, a continuación, se detallarán las siguientes herramientas:
1)	Lenguajes de programación:
a.	Java: Es el núcleo del proyecto, utilizado para el funcionamiento de la app. ANDROID STUDIO ES JAVA, pero interpretado.
b.	PHP: Utilizado para crear una conexión fiable entre Android Studio y la base de datos.
2)	Base de datos:
a.	MySQL: para la gestión de los datos que utiliza la aplicación.
b.	phpMyAdmin:  para gestionar fácilmente la base de datos.
3)	Servidor. 
a.	Apache (XAMMP): enlace entre la app y la base de datos
Lenguajes de programación
JAVA
La plataforma Java es el nombre de un entorno o plataforma de computación originaria de Sun Microsystems, capaz de ejecutar aplicaciones desarrolladas usando el lenguaje de programación Java u otros lenguajes que compilen a bytecode y un conjunto de herramientas de desarrollo.
Java es un lenguaje de programación y una plataforma informática que fue comercializada por primera vez en 1995 por Sun Microsystems. Hay muchas aplicaciones y sitios web que, probablemente, no funcionarán a menos que tenga Java instalado y cada día se crean más. Java es rápido, seguro y fiable. Desde portátiles hasta centros de datos, desde consolas para juegos hasta computadoras avanzadas, desde teléfonos móviles hasta Internet, Java está en todas partes, que es ejecutado en una plataforma no tiene que ser recompilado para correr en otra. Java es, a partir de 2012, uno de los lenguajes de programación más populares en uso, particularmente para aplicaciones de cliente-servidor de web, con unos diez millones de usuarios reportados.
Características de Java.
Las características principales que nos ofrece Java respecto a cualquier otro lenguaje de programación, serían:
•	Simple: Java ofrece toda la funcionalidad de un lenguaje potente, pero sin las características menos usadas y más confusas de éstos. Razón por la que Java se diseñó para ser parecido a C++ y así facilitar un rápido y fácil aprendizaje. Java elimina muchas de las características de otros lenguajes como C++, para mantener reducidas las especificaciones del lenguaje y añadir características muy útiles como el garbage collector (recolector de basura). No es necesario preocuparse de liberar memoria, el recolector se encarga de ello y como es de baja prioridad, cuando entra en acción, permite liberar bloques de memoria muy grandes, lo que limita en mucho la fragmentación de la memoria. 
•	Es un lenguaje orientado a objetos: Se refiere a un método de programación y al diseño del lenguaje. Aunque hay muchas interpretaciones para OO, una primera idea es diseñar el software de forma que los distintos tipos de datos que usen estén unidos a sus operaciones. Así, los datos y el código (funciones o métodos) se combinan en entidades llamadas objetos. Un objeto puede verse como un paquete que contiene el “comportamiento” (el código) y el “estado” (datos). El principio es separar aquello que cambia de las cosas que permanecen inalterables.
•	Es Seguro: ya que La seguridad en Java tiene dos facetas. En el lenguaje, características como los punteros o el casting implícito que hace el compilador de C y C++ se eliminan para prevenir el acceso ilegal a la memoria. Cuando se usa Java para crear un navegador, se combinan las características del lenguaje con protecciones de sentido común aplicadas al propio navegador.
•	Es Robusto: 
•	Es multihilo; ya que permite la herencia de clases
VENTAJAS DE PROGRAMAR EN JAVA:
i.	La principal característica de Java es que es independiente de la plataforma (multiplataforma). Esto significa que cuando estás programando en Java, no necesitas conocer a priori el tipo de ordenador o el sistema operativo para el que estás programando. Puedes ejecutar EL MISMO programa en un PC con Windows, otro con Linux, en un Servidor SUN con sistema operativo Solaris, o en un teléfono móvil de última generación.
ii.	El lenguaje Java es orientado a objetos. El paradigma de programación orientada a objetos supuso un gran avance en el desarrollo de aplicaciones, ya que es capaz de acercar la forma de programar a la forma de pensar del ser humano.
iii.	En java no existen problemas con la liberación de memoria en el sistema: En Java decidieron romper con el sistema tradicional de liberación de memoria, haciendo que el programador ya no fuese el responsable de esa tarea. Así, lo único que necesita hacer el programador es solicitar la memoria al sistema.
iv.	El lenguaje Java es relativamente fácil de aprender comparado con otros.
v.	Librerías Estándar: Una de las características que más potencia aporta al lenguaje Java es que viene acompañado de una serie de librerías estándar para realizar multitud de operaciones comunes a la hora de programar. Es el llamado Java API, que incluye tres bloques básicos. 
vi.	Hoy en día existen excelentes editores (IDE) que aportan multitud de ayudas a la programación, haciendo que el desarrollo sea más fluido y cómodo. 
vii.	Una de las soluciones más elegantes propuestas por el lenguaje Java a uno de los problemas recurrentes en otros lenguajes de programación es la gestión de errores a través de excepciones. en C o C++ no existe un mecanismo específico para la gestión de los errores que puedan producirse en el código.
DESVENTAJAS DE PROGRAMAR EN JAVA:
a)	Al tratarse de un lenguaje interpretado, el rendimiento en la ejecución de programas suele ser un poco menor.
b)	Al contrario que los programas compilados a código nativo, sólo podemos ejecutar un programa en Java si disponemos de una máquina virtual (JVM), sin este simulador no podremos ejecutar ningún programa escrito en Java.
c)	Aunque java es un lenguaje relativamente sencillo de manejar, no es recomendado implementarlo con personas que apenas se unen a este mundo, ya que Java se basa en una filosofía de programación (la orientación a objetos) que es una evolución de otras formas de entender la programación más sencilla de enseñar e implementar
d)	Su sintaxis comparada con C# o Python parece para algunos bastante engorrosa y al contrario que su semejante en .NET, C#, es un lenguaje que evoluciona muy lentamente.
PHP: Hypertext Preprocessor (preprocesador de hipertexto), es un lenguaje de programación de propósito general de código del lado del servidor originalmente diseñado para el preprocesador de texto plano en UTF-8. Posteriormente se aplicó al desarrollo web de contenido dinámico, dando un paso evolutivo en el concepto de aplicación en línea, por su carácter de servicio. 
Su implementación en los documentos HTML era aparentemente muy sencilla. Hay que decir, que, PHP no genera HTML, sino que ofrece una salida de texto con codificación UTF-8 compatible con los documentos HTML. El programador puede dotar a la salida de los tag's propios del HTML y los exploradores más comunes para navegar por internet, reconocerán muy rápidamente el formato UTF-8 y lo adaptarán ofreciendo una salida entendible. 
Fue uno de los primeros lenguajes de programación del lado del servidor que se podían incorporar directamente en un documento HTML en lugar de llamar a un archivo externo que procese los datos. El código es interpretado por un servidor web con un módulo de procesador de PHP que genera el texto plano en formato UTF-8, ampliamente reconocido por el estándar HTML, dando como resultado, en los exploradores, una salida al usuario perfectamente entendible. 
La sintaxis de PHP, se fundamenta en los principios de programación de C. El intérprete de PHP solo ejecuta el código que se encuentra entre sus delimitadores. ¿Los delimitadores más comunes son <?php para abrir una sección PHP y de, ?> para cerrarla.
Características que le dan ventajas frente a la competencia
•	Orientado al desarrollo de aplicaciones web dinámicas con acceso a información almacenada en una base de datos.
•	Es considerado un lenguaje fácil de aprender, ya que en su desarrollo se simplificaron distintas especificaciones, como es el caso de la definición de las variables primitivas, ejemplo que se hace evidente en el uso de php arrays.
•	El código fuente escrito en PHP es invisible al navegador web y al cliente, ya que es el servidor el que se encarga de ejecutar el código y enviar su resultado HTML al navegador.
•	Capacidad de conexión con la mayoría de los motores de base de datos que se utilizan en la actualidad, destaca su conectividad con MySQL y PostgreSQL.
•	Capacidad de expandir su potencial utilizando módulos (llamados ext's o extensiones).
•	Posee una amplia documentación en su sitio web oficial, entre la cual se destaca que todas las funciones del sistema están explicadas y ejemplificadas en un único archivo de ayuda.
•	Es libre, por lo que se presenta como una alternativa de fácil acceso para todos.
•	Permite aplicar técnicas de programación orientada a objetos.
•	No requiere definición de tipos de variables, aunque sus variables se pueden evaluar también por el tipo que estén manejando en tiempo de ejecución.
•	Tiene manejo de excepciones (desde PHP5).
•	El programador puede aplicar en su trabajo cualquier técnica de programación o de desarrollo que le permita escribir código ordenado, estructurado y manejable. Un ejemplo de esto son los desarrollos que en PHP se han hecho del patrón de diseño Modelo Vista Controlador (MVC), que permiten separar el tratamiento y acceso a los datos, la lógica de control y la interfaz de usuario en tres componentes independientes.
•	Debido a su flexibilidad ha tenido una gran acogida como lenguaje base para las aplicaciones WEB de manejo de contenido, y es su uso principal.
Inconvenientes 
•	Como es un lenguaje que se interpreta en ejecución, para ciertos usos puede resultar un inconveniente que el código fuente no pueda ser ocultado. La ofuscación es una técnica que puede dificultar la lectura del código, pero no necesariamente impide que el código sea examinado.
•	Debido a que es un lenguaje interpretado, un script en PHP suele funcionar considerablemente más lento que su equivalente en un lenguaje de bajo nivel, sin embargo, este inconveniente se puede minimizar con técnicas de caché tanto en archivos como en memoria.
•	En las versiones previas a la 7, las variables no son tipificadas, lo cual dificulta a los diferentes IDEs ofrecer asistencias para el tipificado del código, aunque esto no es realmente un inconveniente del lenguaje en sí. Esto es solventado por algunos IDEs añadiendo un comentario con el tipo a la declaración de la variable.
Bases de datos: 
MySQL es un sistema de gestión de bases de datos relacional desarrollado bajo licencia dual: Licencia pública general/Licencia comercial por Oracle y está considerada como la base datos de código abierto más popular del mundo.
 MySQL es muy utilizado en aplicaciones web, como Joomla, Drupal o phpBB, en plataformas (Linux/Windows-Apache-MySQL-PHP/Perl/Python), y por herramientas de seguimiento de errores como Bugzilla. Su popularidad como aplicación web está muy ligada a PHP, que a menudo aparece en combinación con MySQL. Y es una base de datos muy rápida en la lectura cuando utiliza el motor no transaccional MyISAM, pero puede provocar problemas de integridad en entornos de alta concurrencia en la modificación.
Características:
•	Uso de multihilos mediante hilos del kernel.
•	Usa tablas en disco b-tree para búsquedas rápidas con compresión de índice
•	Tablas hash en memoria temporales.
•	El código MySQL se prueba con Purify (un detector de memoria perdida comercial) así como con Valgrind, una herramienta GPL.
•	Completo soporte para operadores y funciones en cláusulas select y where.
•	Completo soporte para cláusulas group by y order by, soporte de funciones de agrupación.
•	Seguridad: ofrece un sistema de contraseñas y privilegios seguro.
•	Soporta gran cantidad de datos. MySQL Server tiene bases de datos de hasta 50 millones de registros.
•	Se permiten hasta 64 índices por tabla
MySQL posee grandes ventajas como: 
•	es un sistema de administración de bases de datos. 
•	Es un sistema de administración relacional de bases de datos. Una base de datos relacional archiva datos en tablas separadas en vez de colocar todos los datos en un gran archivo. 
•	permite velocidad y flexibilidad. Las tablas están conectadas por relaciones definidas que hacen posible combinar datos de diferentes tablas sobre pedido.
•	Y es software de fuente abierta. Fuente abierta significa que es posible para cualquier persona usarlo y modificarlo. 
•	Cualquier persona puede bajar el código fuente de MySQL y usarlo sin pagar. Por lo que el interesado puede estudiar el código fuente y ajustarlo a sus necesidades.
Como INCONVENIENTES: 
	La curva de aprendizaje es elevada y se necesita experiencia. 
	Utiliza el motor no transaccional, pero puede provocar problemas de integridad en entornos de alta concurrencia en la modificación
Componentes:
•	Tipos de columnas: Existen diversos tipos de columnas como:
o	Enteros con signos de 1,2,3,4 y 8bytes de longitud, FLOAT, DOUBLE, BLOB, DATE, TIME, DATETIME, TIMESTAP, YEAR, ENUM, SET y los espaciales OpenGIS.
o	Registros de longitudes fija y variable.
o	Sentencias y funciones.
o	Soporte completo para operadores y funciones de las cláusulas SELECT y WHERE.
o	Soporte para cláusulas de SQL, GROUP BY Y ORDER BY.
o	Soporte de funciones de agrupaciones (COUNT (), COUNT (Distinct ...), AVG (), SUM (), MAX (), Y MIN ().
o	Soporte para LEFT OUTER JOIN y RIGHT OUTER JOIN.
o	Soporte para alias en tablas y columnas como lo requiere el estándar SQL 
o	Sentencias anidadas
phpMyAdmin es una herramienta escrita en PHP con la intención de manejar la administración de MySQL a través de páginas web, utilizando Internet. Actualmente puede crear y eliminar Bases de Datos, crear, eliminar y alterar tablas, borrar, editar y añadir campos, ejecutar cualquier sentencia SQL, administrar claves en campos, administrar privilegios, exportar datos en varios formatos.
Las especificaciones proveídas por el programa incluyen:
1.	Interface Web para la gestión grafica
2.	Manejador de base de datos MySQL, MariaDB y Drizzle
3.	Importación de datos desde CSV y SQL
4.	Exporta datos a varios formatos: CSV, SQL, XML, PDF (vía la biblioteca TCPDF), ISO/IEC 26300 - OpenDocument Text y Spreadsheet, Word, Excel, LaTeX y otros
5.	Administración de múltiples servidores
6.	Crea gráficos PDF del diseño de la base de datos
7.	Crea consultas complejas usando Query-by-Example (QBE)
8.	Búsqueda global en una base de datos o un subconjunto de esta
9.	Es muy utilizado en todos los ámbitos.
Servidores.
XAMPP es un paquete de software libre (dicho en clase), que consiste principalmente en el sistema de gestión de bases de datos MySQL, el servidor web Apache y los intérpretes para lenguajes de script PHP y Perl.
Ventajas:
a.	Se puede descargar e instalar cada componente por separado y a crear o editar sus ficheros de configuración manualmente, 
b.	XAMPP sólo requiere una pequeña fracción de tiempo necesario para descargar y ejecutar un archivo ZIP, tar, exe o fkl.
c.	Puede encontrarse en versión completa o en una versión más ligera, que es portable, 
d.	Permite configurar los componentes necesarios del servidor web mediante una misma y sencilla interfaz web. 
e.	XAMPP se actualiza regularmente para incorporar las últimas versiones de Apache/MySQL/PHP y Perl.
Inconvenientes:
	Se requiere modificar ciertos ficheros para resolver el conflicto de puertos
ANALISIS y desarrollo del proyecto:
Antes de empezar con el diseño de la aplicación, se va a explicar, mejor y más detallado, que requisitos de usuario son necesarios para ser satisfactorios para el sistema. Todos y cada uno de ellos son esenciales, por lo que se debe poner énfasis para completarlos:
Estudiando las herramientas a disposición para llevar a cabo el almacenamiento y manipulación de los datos, así como su representación, se dispone una serie de objetivos más acordes a la realización del prototipo de la aplicación, de las cuales cumplirá el objetivo principal del proyecto:
a)	La presentación de las listas de las emisoras.
b)	Visualización de reproducción en curso.
c)	Acceso a una breve historia de la radiocomunicación y facilitar el acceso a más información.
d)	Acceso al tablón de comentarios, y envió de los mismos.
e)	Permitir al administrador el acceso a la gestión de los enlaces de streaming y al listado.
f)	Disfrutar de la radio en alta calidad de sonido.







Diseño de la aplicación.
En este apartado se trata del diseño de la aplicación, describiendo todas las pantallas, así como su funcionamiento, rendimiento y como está estructurada, así como su proceso de desarrollo.
EL diagrama de casos de uso es el siguiente: En nuestro proyecto, al tratarse de un “Receptor de radio”, el tipo de usuario que existe es el de “Radioescucha”, por lo que para el manejo de la aplicación a nivel de usuario es la siguiente:
 
Mientras que, a nivel de Administrador, se encarga de realizar las tareas de depuración, depuración de errores, rediseño, y mejora de la app mediante inserción de nuevo código y actualizaciones: 
 
El diagrama de clases es un pantallazo, que se utiliza para describir el comportamiento del programa. El presente diagrama Muestra todas las clases de la aplicación y su relación con AppComact Activity, los métodos, variables y constructores. También se muestra un fragmento de código. 
  
Diagramas de estado 
Se usa para dar forma al comportamiento de una clase. Se representa la secuencia de estados que un objeto de la clase tiene durante su ciclo de vida, según las acciones que van sucediendo. Por ejemplo, el acceso a la base de datos, como de dibuja en la siguiente imagen: 
 
Este es el clásico diagrama de estados de una aplicación, que representa las acciones del usuario, como se aprecia en la imagen, el usuario entra en la app y tiene estas opciones:
1.	Accede, navega y entra en la pantalla de comentarios, dejando un comentario, por lo que, en caso positivo, envía un comentario, en caso contrario regresa al menú.
2.	El usuario puede acceder a la base de datos, si es sí, el acceso es autorizado, en caso contrario, se deniega el acceso y seguirá navegando.
3.	Si el acceso es autorizado, puede realizar tantas consultas como desee. 
4.	Por último, si el usuario sale de la aplicación, vuelta a empezar.
Desarrollo de la interfaz de la aplicación
Durante el desarrollo de la aplicación, se utiliza una serie de capturas para demostrar su funcionamiento, se han preparado las siguientes capturas. En todas existe un actionbar o menú superior. En toda la realización del proyecto se han utilizado las librerías por defecto del IDE Android Studio.
Las pantallas 1 y 2, representan las pantallas de inicio (Portada) y emisoras de radio, que en realidad está formado por un listview (Arraylist), cuatro botones, y un textview como texto de título. En la primera pantalla el botón “continuar”, te salta a la pantalla de listado de emisoras.
  
En esta segunda pantalla, al seleccionar un elemento del Arraylist, comienza la reproducción de la emisora seleccionada en una pantalla de reproducción, el botón inicio, retorna a la pantalla main, el botón historia de la radio, enlaza a otra pantalla, donde se encuentra un índice de contenido, y el botón comentar va a otra pantalla que esta enlazada con la base de datos.
Pantallas 3, y 4. Cuando se selecciona un elemento del Arraylist, automáticamente te dirigirá a una pantalla de reproducción, que consiste en una webview con la imagen de la emisora en marcha, una table layout que contiene los siguientes botones, (de izquierda a derecha): stop, para detener la reproducción, play para reanudar, retorno para volver al listado y un botón que sirve para ir a la web oficial de la emisora.
  
Este intent externo es muy útil a la hora de visitar la página web oficial de cada emisora (en este caso los40) para ver todo el contenido, como podcast, listado de canciones ya emitidas, noticias, programación, y novedades en el ámbito musical. Por defecto se abre en el navegador móvil Chrome. En este proyecto existen 8 pantallas radioplayer (replicas), una para cada emisora seleccionada, con el fin de evitar conflictos y posible cuelgue de la aplicación.
El botón de retroceder, vuelve al usuario a la pantalla de panel, el cual contiene un botón de enlace a la historia de la radio.

Pantallas 5 y 6. La captura de la izquierda (Historia), se muestra un índice sobre la evolución histórica de la radio como medio de comunicación, en la cual se describe brevemente los periodos: inicios, evolución y futuro, este intent, está formado por: un textview, de título, una tabla con tres filas y dos columnas, cada fila contiene un botón y un textview, y un linear layout, que contiene: tres botones, retroceder (intent panel radio), mas info, (intent externo, enlace a la Wikipedia) y un botón de comentarios (intent comentarios). El primer intent de la historia es, inicios de la radio.
  
La pantalla inicios de la radio está compuesta por: un scrollview que contiene un botón (volver a índex historia), y texto. Describiendo brevemente los inicios de la radio y el tiempo de tecnología que se utilizaba en esa época. Ahora pasamos a la evolución de la radio.



Pantallas 7 y 8. Pertenecen a la historia de la radio y son: Evolución y futuro de la radio. Se trata de dos pantallas iguales a inicios de la radio, solo cambia la combinación de colores.
  
Pantalla 9: Al pulsar el botón +info del índice historia, te llevará a un intent externo para más información que enlaza con un artículo de la Wikipedia: y el menú superior.
   
Las dos ultimas pantallas son: Sección comentarios y acceso a datos, ambas están conectadas con la base de datos la primera consta de 4 edit text y de tres botones: de enviar, volver y otro de ver datos, la cual lleva a la pantalla acceso datos.
 
En la pantalla de acceso a datos, consta de un edittext y dos botones, volver a comentarios y buscar los datos seleccionados, dichos datos consultados, se muestran en un arrayList.
 
Base de datos: 
En esta base de datos se utiliza un gestor llamado phpMyAdmin, cuyos lenguajes de programación orientados a bases de datos son, MySQL y PHP. Su acceso se realiza mediante localhost: puerto apache/phpMyAdmin.
PhpMyAdmin: 
Aunque ya se ha explicado al principio, cabe mencionar que este Sistema Gestor de Base de Datos, es una herramienta que nos permite, aparte de tener a nuestra disposición un panel de control, modificar, borrar y añadir bases de datos, pero que es importante no perder la clave de root. En la captura se muestra las tabas en la BD.
 





Los Diagramas
 El diagrama entidad-relación, o cuadro de relaciones entre entidades (Tablas) de una base de datos, se utiliza para simplificar tablas y evitar redundancias, conectando una clave primaria de una entidad con una clave ajena del mismo nombre de otra. 
 
Y su transformación al modelo relacional.
 
Registros de las tablas
Captura de los registros de la tabla usuarios (Procede de la pantalla comentarios):
 
Captura de pantalla de los registros de la tabla emisoras:
 
Captura de pantalla de los registros de la tabla, datos de emisora:
 
Y por último los registros de la tabla relación usuario-emisora:
 
Usuarios en la BD. Esta es la captura con todos los usuarios registrados en el sistema gestor de la base de datos, cada usuario posee un rango definido, así como los permisos otorgados: 
Y los ficheros necesarios para la conexión android-mysql.
 
Funcionamiento de la aplicación:
En este punto se explicará cómo funciona la aplicación mostrando el código fuente de cada pantalla. Pantalla Main. Es la portada de la aplicación que al clicar el botón salta al panel de radios.
 
Pantalla Panel Radio. Este panel contiene un array adapter, que al clicar uno de sus ítems, empieza la reproducción de la emisora seleccionada, también es el punto de partida del resto de la aplicación, como el panel de historia o la sección de comentarios.
 
En el código se muestra las variables de Button, Mediaplayer y ProgressBar, los métodos inicializados dentro del método oncreate, inicializarComponentes (); e inicializarMedia Player (); y los métodos de acción /on clic para cada botón. son seis pantallas como esta.
 
En la pantalla “Historia de la radio”, es el índice de navegación por los distintos periodos de la historia, en el código se establece la acción de los botones a cada intent o pantalla mediante métodos, uno para cada botón, permitiendo así la navegación entre pantallas, Excepto en el botón +info que abre un navegador externo con un enlace a un articulo de la Wikipedia.
 
Este es el código fuente de la pantalla “inicios de la radio”, consta de un botón (volver a índice) y dos textview y el código del menú superior (se encuentra en todo el proyecto).
 
El código es muy similar a las pantallas de evolución y futuro. 
 
Llegando a la puerta de acceso del SGBD, Nos encontramos en la sección de los comentarios, en el código fuente, se ha creado las variables para los edittext, botones y una variable string para la dirección IP con el puerto y la ubicación del fichero PHP, el cual será de puente entre Android y MySQL como webservice, en método ejecutarServicio (); dentro del onclick de btnEnviar, se ubica el código necesario para la inserción de los datos a la BD desde la aplicación.
 
En cuanto la pantalla “Acceso datos” es igual, solo que realiza una consulta en vez de inserción.
 
Para que la aplicación pueda acceder a la base de datos y/o realizar un comentario y acceder a la red para escuchar la radio online, se debe escribir los permisos de usuario en el archivo AndroidManifest.xml, el código mostrado en la captura (permisos de internet).
 
Y también la implementación de la clase “com-Andorid.volley” en el fichero build. grade (Module: app).
 
Y para finalizar, esta es la estructura de ficheros del proyecto.
 

Entorno de desarrollo:
El entorno de desarrollo utilizado en su totalidad es Android Studio. 
 
Para el versionado de la aplicación se ha recurrido a un repositorio privado en GitHub, el cual dicha historia son commits que se han ido realizando a lo largo del desarrollo.
 
En mi caso he tenido problemas con el control de versiones en GitHub, ya que no podía conectar de manera coherente el repositorio con el IDE, y por ello aparecerán muchos commits realizados el día 25 de mayo, pero en realidad se ha ido ejecutando dicho control a lo largo del mes. 
El Auténtico control de versiones (VCS), se encuentra a pie del IDE Android Studio para acceder a dicho VCS, selecciona Versión Control Log y en él aparece el nombre del Commit, los archivos afectados y los cambios de código. Ordenado por fecha descendente.
 
Documentación para el/la Usuario/a
Manual de instalación (Installation Guide):
The following manual is intended for the end user. For the installation of the application it is simple, following these steps:
•	Download the app from the repository on GitHub or from the play Store.
 
•	Once downloaded proceed to install, execute the apk, in the case of Google play, it will install automatically.
•	In case of manual installation in the terminal, Go to SettingsSecurity and activate unknown sources.
 
•	 And install the app.
Manual de Usuario (User Guide)
En este manual para el usuario, se facilita la utilización de la app siguiendo los siguientes pasos.
	Instala la app en el smartphone.
	En la portada de la aplicación, pulse el botón continuar.
	Navegue por el directorio de emisoras, pulsando un elemento de la lista, sonara en tiempo real la radio seleccionada.
	En el navegador, selecciona “historia Radio” para ver la evolución del medio de comunicación.
	Desde el propio panel de “Historia” acceda a la sección de comentarios. 
	En la sección de comentarios, escriba su nombre, apellido, edad y un comentario.
	Y, por último, busque los datos de una emisora en concreto, escribiendo un nombre y pulsando el botón de buscar. Aparecerán los datos de dicha consulta.
In this user manual, the use of the app is facilitated, following the steps below.
1.	Install the application on the smartphone.
2.	On the cover of the application, press the Continue button.
3.	Browse the station directory by pressing an item in the list, the selected radio will sound in real time.
4.	In the browser, select "Radio story" to see the evolution of the media.
5.	From the "History" panel, access the comments section.
6.	In the comments section, write your first name, last name, age and a comment.
7.	And finally, search the data of a specific station, enter a name and press the search button. The data of said query will appear.
Bibliografía consultada:
Android Developer: Guía general de apoyo https://developer.android.com/guide
Datos generales Historia de la radio https://es.wikipedia.org/wiki/Historia_de_la_radio
Como manejar PHP  https://www.tutorialesprogramacionya.com/phpya/
GitHub comunity Base de datos - https://github.community/search?q=database
Mi repositorio de la aplicación  https://github.com/snLionel90/proyecto_Lionel
Mi repositorio de documentación y ficheros  https://github.com/snLionel90/Proyecto-Lionel-Documents 
 
  















