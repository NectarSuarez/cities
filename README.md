# cities
Néctar Suárez 2022-03-11

Ejemplo de como consumir el servicio
Es del metodo GET:

https://cities-1647045507708.azurewebsites.net/Geo/suggestions?q=London&latitude=42.98339&longitude=-81.23304

Admite la entrada de 3 valores
por ejemplo:

q         = London
latitude  = 42.98339
longitude = -81.23304


El micro servicio esta alojado en Azure ya que en GCloud tenía muchos problemas para poder responder a las peticiones y de compatibilidad con el AppEngine.

Dentro del código hay comentarios explicando el funcionamiento del Micro Servicio.


Cuenta con otra función de prueba simple para saber que esta respondiendo correcamente.
https://cities-1647045507708.azurewebsites.net/Home
