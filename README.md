MyRetailAPP

**Deployment**

**Befor starting any of the steps please move to the current directory of the project.**

Build Steps

_First Step is to build the War file of the application_

run the following commands
`mvn clean install` This should create the war file in the target directory


_Docker steps to run in order for the application to start_

Make sure again you are in the same directory like before to run the following command

`docker-compose up` -> This should start the container and also mongodb container and link both of it.

Use localhost:8085 which is the application container configured to expose

`ex: http://localhost:8085//products/{id}`

_DataLoading_

If you want to load the Data into MongoDb at the start up please do so by adding more value in the MangoDBConfig file. Already added an example value to start with

**_END POINTS AVAILABLE:_**

_id's here are the product Id you are trying to find_

1)/products/{id}[GET] -> reply back with a json 
2)/products/{id}[PUT] -> add json from the GET method with modified values
3)/getall[GET] -> to know all the data in the DB
