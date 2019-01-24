FROM java
RUN apt-get update
COPY ./javaapp .
RUN  cd . 
RUN cd . && javac sample.java
CMD cd . && java sample
RUN install 
FROM ubuntu
WORKDIR /root/
RUN apt-get install xauth
RUN $xhost apt-get update && apt-get install -y firefox
CMD $xhost firefox CR-24.html
#RUN     bash -c 'echo "firefox" >> /.bashrc'
#RUN cd docker_app && firefox CR-24.htm

