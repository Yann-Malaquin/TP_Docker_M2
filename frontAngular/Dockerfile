FROM node:16.13.1

RUN mkdir /usr/src/app && \
    npm install -g @angular/cli

WORKDIR /usr/src/app

COPY . .

RUN npm install && \
    npm install --save @angular-devkit/build-angular

CMD ng serve --host 0.0.0.0 --port 4200
