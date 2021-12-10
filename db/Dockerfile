FROM postgres:buster

ENV POSTGRES_PASSWORD graphql-service
ENV POSTGRES_USER graphql-service
ENV POSTGRES_DB graphql-service

EXPOSE 5432:5432

ADD init.sql tables.sql /docker-entrypoint-initdb.d/