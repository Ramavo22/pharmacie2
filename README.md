# Pharmacie

## structure projet

Ao amin'ny src daholo ny zavatra rehetra no miseo

ao amin'ny src main misy dossier 3 

- java
  - AO daholo ny java no declare na
  - ressource ao daholo ny ressource comme les sql, META-INF
  - webapp
    - Ao ny .jsp rehetra no mande


## Compilation

mila maka maven zany aloha ela 

pour compiler le projet il faut executer

```bash
mvn clean package
```

pour executer un backoffice, il faut executer le jar avec la commande
```bash
java -cp target/pharmacie2.jar mg.itu.Main
```