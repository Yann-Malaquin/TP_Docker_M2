FROM node:16.13.1-alpine

RUN mkdir /usr/src/app && \
    npm install -g @angular/cli

WORKDIR /usr/src/app

RUN npm install

COPY . .

EXPOSE 4200

CMD ng serve --host 0.0.0.0 --disable-host-check
