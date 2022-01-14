FROM node:16.13.1

RUN mkdir /usr/src/app

WORKDIR /usr/src/app

RUN npm install -g @angular/cli

COPY . .

CMD npm install && ng serve --host 0.0.0.0 --port 4200

