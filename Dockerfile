# Licensed to the Apache Software Foundation (ASF) under one or more
# contributor license agreements.  See the NOTICE file distributed with
# this work for additional information regarding copyright ownership.
# The ASF licenses this file to You under the Apache License, Version 2.0
# (the "License"); you may not use this file except in compliance with
# the License.  You may obtain a copy of the License at
#
#     http://www.apache.org/licenses/LICENSE-2.0
#
# Unless required by applicable law or agreed to in writing, software
# distributed under the License is distributed on an "AS IS" BASIS,
# WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
# See the License for the specific language governing permissions and
# limitations under the License.

# Build the functions code ...
FROM maven:3.8.5-openjdk-17 AS builder
WORKDIR /usr/src/app/

# Copiar solo el archivo de definición del proyecto (pom.xml) y descargar dependencias
COPY ./pom.xml /usr/src/app/pom.xml
RUN mvn -f /usr/src/app/pom.xml -B -Dmaven.test.skip=true dependency:go-offline

# Copiar el resto del código y compilar la aplicación
COPY ./src /usr/src/app/src
WORKDIR /usr/src/app
RUN mvn -B -Dmaven.test.skip=true package

# ... y ejecutar el servidor web
FROM openjdk:17
ARG JAR_FILE=/usr/src/app/target/movimientos-0.0.1-SNAPSHOT.jar
WORKDIR /
COPY --from=builder ${JAR_FILE} app.jar
EXPOSE 8080
CMD java -jar app.jar


