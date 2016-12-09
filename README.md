# mutiny
Upstream Hackathon Project

## Init the database:

    $ mvn clean install -DskipTests -Dinit.database.skip=false -Ddb.host=rdbms -Ddb.port=5432 -Ddb.root.password=upstream -Ddb.module.password=upstream flyway:migrate

## Run flyway on an existing database:

    mvn clean install -DskipTests -Ddb.module.database.name=mutiny -Ddb.module.userId=mutiny -Ddb.host=rdbms -Ddb.port=5432 -Ddb.module.password=upstream flyway:migrate
