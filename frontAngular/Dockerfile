FROM node:16.13.1

RUN mkdir /usr/src/app && \
    npm install -g @angular/cli

WORKDIR /usr/src/app

COPY . .

RUN rm "node_modules"

CMD ls
