# User Services gRPC
Los servicios UserService y UserListService fueron desarrollados con gRPC en kotlin y Gradle.

# Requisitos previos
Antes de compilar y ejecutar la aplicación asegurese de tener instalado:

Java 17 o superior - se recomienda Java 22.0.1
Gradle - la version es opcional, se está usando ./gradlew

# Compilación
./gradlew build

# Ejecución
/gradlew run

# Pruebas
Para las pruebas se utilizó el cliente gRPC Evans en Linux Ubuntu 24.04

# Pregunta 1
La interfaz para el servicio gRPC UserService se define en UserService.proto en el directorio /src/main/kotlin/proto
El servidor UserService recibe las solicitudes y contruye UserResponse con los datos obtenidos.
El cliente recibe la respuesto del servicio.
{
    "user_id": "123",
    "name": "Juan Pérez",
    "email": "juan.perez@email.com"
}

Respuesta al cliente:
![Descripción de la imagen](images/pregunta1.png)


# Pregunta 2
En este ejercicio se crea un nuevo método de server streaming ListUsers
El método ListUsers en UserService2.proto permite la transmisión de múltiples usuarios como un stream.
El cliente recibe la respuesto del servicio.
{
    "user_id": "1",
    "name": "Juan Pérez",
    "email": "juan.perez@email.com"
},
{
    "user_id": "2",
    "name": "Ana López",
    "email": "ana.perez@email.com"
},
{
    "user_id": "3",
    "name": "Carlos Díaz",
    "email": "carlos.perez@email.com"
}

Respuesta al cliente:
![Descripción de la imagen](images/pregunta2.png)