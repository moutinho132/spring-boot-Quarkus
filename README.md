# spring-boot-Quarkus
Este proyecto tiene como finalidad afinar mis conocimientos en Quarkus con spring booty


## Creare proyecto en Quarkus 

mvn io.quarkus:quarkus-maven-plugin:create \
-DprojectGroupId=com.example \
-DprojectArtifactId=quarkus-microservice \
-DclassName="com.example.GreetingResource" \
-Dpath="/greeting"


### Configurar la Base de Datos
quarkus.datasource.db-kind=h2
quarkus.datasource.jdbc.url=jdbc:h2:mem:tasks
quarkus.datasource.username=sa
quarkus.datasource.password=sa
quarkus.hibernate-orm.database.generation=drop-and-create

#### Dependency 

 <dependencies>
        <dependency>
            <groupId>io.quarkus</groupId>
            <artifactId>quarkus-resteasy</artifactId>
        </dependency>
        <dependency>
            <groupId>io.quarkus</groupId>
            <artifactId>quarkus-hibernate-orm</artifactId>
        </dependency>
        <dependency>
            <groupId>io.quarkus</groupId>
            <artifactId>quarkus-hibernate-orm-panache</artifactId>
        </dependency>
        <dependency>
            <groupId>io.quarkus</groupId>
            <artifactId>quarkus-jdbc-h2</artifactId>
        </dependency>
        <dependency>
            <groupId>io.quarkus</groupId>
            <artifactId>quarkus-resteasy-jsonb</artifactId>
        </dependency>
    </dependencies>



## CURls 

##GET
curl -X GET http://localhost:8080/tasks

### POST

curl -X POST http://localhost:8080/tasks \
-H "Content-Type: application/json" \
-d '{"title":"Learn Quarkus","description":"Understand the basics of Quarkus","completed":false}'


## UPDATE 

curl -X PUT http://localhost:8080/tasks/1 \
-H "Content-Type: application/json" \
-d '{"title":"Learn Quarkus","description":"Master Quarkus","completed":true}'


##Eliminar
curl -X DELETE http://localhost:8080/tasks/1


