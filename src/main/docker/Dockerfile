FROM openjdk:8-jdk-slim

ENV SPRING_PROFILES_ACTIVE ${SPRING_PROFILES_ACTIVE:-default}
ENV JAVA_OPTS ${JAVA_OPTS:-'-Xmx512m'}
ENV DEBUG_OPTS ${DEBUG_OPTS}
ENV PORT ${PORT:-8080}

COPY debs           /tmp/debs
COPY pt-BR/DEBS     /tmp/oo
COPY scripts/run.sh /run.sh

RUN adduser --disabled-password --disabled-login --system java
RUN chmod 0755 /run.sh
RUN mkdir -p /home/java/.config
RUN mkdir -p ~/.config

# INSTALL MISSING LIBS
RUN dpkg -i   /tmp/debs/*.deb; \
    rm   -rf  /tmp/debs;

# INSTALL OPEN OFFICE
RUN dpkg -i   /tmp/oo/*.deb; \
    rm   -rf  /tmp/oo;

COPY *.jar /app.jar

VOLUME /tmp

RUN sh -c 'touch /app.jar'

USER java

EXPOSE ${PORT}

CMD /run.sh