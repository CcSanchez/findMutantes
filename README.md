

# Find Mutants



El siguiente microservicio esta construido con el fin de suplir la necesidad de encontrar mutantes con base a un dna y tener una estadistica de los mutantes encontrados

### Instalación 🔧
```

mvn clean

```



```

mvn install

```



## End Points

* /stats : Peticion GET, obteniene las estadisticas de cuantos adns corresponden a mutantes y cuantos a humanos.

```

  

```



* /mutants : Peticion POST, con base al adn ingresado determina si es mutante o no.

```

{

"dna": [

"ATGCGA",

"CAGTGC",

"TTATGT",

"AGAAGG",

"CCCCTA",

"TCACTG"

]

}

```



# Swagger

El proyecto cuenta con documentacion de open api con el fin de facilitar el consumo y testeo y documentar los atributos y endpoints.



* [Local](http://localhost:8080/swagger-ui/index.html#//) - link a swagger al desplegarlo

localmente(http://localhost:8080/swagger-ui/index.html#/)




## Construido con 🛠️



* [Git](http://www.dropwizard.io/1.0.2/docs/) - Manejo de versiones

* [Maven](https://maven.apache.org/) - Manejador de dependencias

* [SpringBoot](https://rometools.github.io/rome/) - Framework usado

* [Jacoco](https://rometools.github.io/rome/) - Dependencia usada para evaluar el coverage de unit test



## Versionado 📌



Version 1.0.0 Creacion proyecto inicial que cumple con los requerimientos



## Autor ✒️



*  **Cristian Camilo Sanchez Rozo** - *Challegue tecnico* - [csanchez](https://github.com/CcSanchez/pruebaMeli)



## Notas y Observaciones Tecnicas



Por cuestiones de tiempo se tomaron las siguientes decisiones para la construccion del proyecto:



1. Se uso una base de datos temporal (H2), como mejora se deberia desplegar una base de datos almacenada en cloud.

2. Con el fin de testear la carga o concurrencia se uso jmeter para realizar estas pruebas, donde evidenciamos que el cuello de botella se origina en el pool de base de datos como mejora se podria implementar una cola de mensajeria como un kafka o rabbit para generar ese desacoplamiento del proceso de insercion con el proceso maestro.




## Notas y Observaciones de Negocio



Para el funcionamiento se tomaron las siguientes decisiones de negocio de puntos que no estaban como tal estipulados en el challengue:



1. Se asume que que con solo encontrar una coincidencia en una fila sea vertical, horizonta o diagonal ya se excluye dicha fila para buscar mas secuencias repetidas

2. Como no estan claros los campos de la tabla a insertar se contemplaron las siguientes columnas


| Nombre Columna |  Descripcion|
|--|--|
| id  |  Identificador unico|
| combinaciones | Contienen la cantidad de secuencias encontradas por base (AAAA,CCCC.TTTT,GGGG)|
| fecha | Fecha en la cual se realizo la validacion |
| dna | Dna enviado para la validacion |
| isMutant | Indicador de si es mutante o no la persona |