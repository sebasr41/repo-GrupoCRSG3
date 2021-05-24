# Programación Visual - TP7: Conexión a Base de datos & Spring Data JPA

**Objetivo de aprendizaje:**

* Mapeo de relaciones @OneToOne.
* Creación de la capa repository.
* Uso de CrudRepository (Create, Read, Update, Delete).

## Integrantes del grupo RCGS: 

| Apellido y  nombre:      | LU   | Usuario GitHub |
| ------------------------ | ---- | -------------- |
| Benicio Roxana           | 3215 | @3215U         |
| Rojas Rafael Sebastian   | 4292 | @sebasr41      |
| Michel Orlando Cristian  | 4155 | @mike47k       |
| Mamani Gabriel Alejandro | 4148 | @gam98         |

## Puntos del trabajo práctico: 

1. A partir del proyecto del TP N°6, realice lo siguiente:

   Crear un nuevo repositorio donde se almacenará el proyecto del **TP N° 7.**

   Agregue una clase al paquete model denominada **Cuenta**, esta clase representa la cuenta (dentro del negocio) que se asigna a cada cliente y a través de ella puede realizar compras según el monto disponible.

   | **Nombre de clase** |                       **atributos**                       |
   | :-----------------: | :-------------------------------------------------------: |
   |       Cuenta        |                         id (Long)                         |
   |                     |                      saldo (double)                       |
   |                     | fechaCreacion (LocalDate) Se ingresa en el<br/>formulario |
   |                     |            estado(String) -> ACTIVA, INACTIVA             |

2. Realice el ORM (mapeo objeto relacional) para la nueva clase.

3. La característica de los objetos de esta nueva clase es que la persistencia se hace al momento de persistir el objeto cliente. Realice el mapeo de la relación entre Cliente y Cuenta, declare las propiedades necesarias para que la persistencia se realice en cascada. (OneToOne).

   **Nota: debe agregar a la clase Cliente un atributo cuenta con la anotación OneToOne.**

4. Realice todas las modificaciones necesarias para poder incorporar en las vistas los objetos involucrados en las nuevas relaciones.

5. Cree un nuevo paquete que represente la capa repository. En este paquete se agregaran todas las interfaces que a su vez extienden de **CrudRepository**.

6. Cree un nuevo implementador de Service y agregue en la capa de service la inyección de un objeto que implemente la interfaz del **repository**. A partir de esta inyección utilice los métodos para realizar la persistencia (por ejemplo **save**).

7. En la capa de la vista (**templates**) realice las modificaciones necesarias para disponer de opciones en las tablas que permitan **modificar** y **eliminar** objetos de la tabla.

8. En la capa **controller** agregue las peticiones necesarias para realizar las nuevas opciones.



