FROM oracle/graalvm-ce:19.2.0.1 as graalvm
COPY . /home/app/github2todo-micronaut
WORKDIR /home/app/github2todo-micronaut
RUN gu install native-image
RUN native-image --no-server -cp build/libs/github2todo-micronaut-*-all.jar

FROM frolvlad/alpine-glibc
EXPOSE 8080
COPY --from=graalvm /home/app/github2todo-micronaut .
ENTRYPOINT ["./github2todo-micronaut"]
