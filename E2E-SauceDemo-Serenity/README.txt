INSTRUCCIONES DE EJECUCIÓN

Prerrequisitos:
1. JDK 21.
2. Maven.
3. IDE utilizado - IntelliJ IDEA.

Pasos para ejecutar la prueba automatizada:
1. Abrir la carpeta del proyecto en IntelliJ IDEA.
2. Ejecutar:
   mvn clean test serenity:aggregate
3. En caso de requerir reporte, este se encuentra en la ruta:
   target/site/serenity/index.html