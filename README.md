# Dropwizard Boilerplate

Boilerplate for base [Dropwizard](http://dropwizard.codahale.com) REST service.
Project uses [Gradle](http://www.gradle.org/) build tool.

## Runing base service

```
> gradlew run
```

Point your browser at `http://localhost:8080/base`

## Distribution build

```
> gradlew distZip
```

You would find distribution package in `build/distributions`. In order to run the service
you need to unzip the package and `cd` into it. Then run

```
> bin/crm-api server config/base-service-dev.yml
```

### Onejar build

```
> gradlew oneJar
```

You would find distribution package in `build/libs`. In order to run the service
`cd` into `build/libs` and run

```
> java -jar dropwizard-boilerplate-standalone.jar server ../../src/dist/config/base-service-dev.yml
```

## Database

[PostgreSql](http://www.postgresql.org/) database is used. Database connection details are defined in `src/dist/config/base-service-dev.yml`.
