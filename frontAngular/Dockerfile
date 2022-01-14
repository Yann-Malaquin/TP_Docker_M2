FROM node:16.13.1

RUN mkdir /usr/src/app && \
    npm install -g @angular/cli

WORKDIR /usr/src/app

COPY . .

RUN npm uninstall @angular-devkit/build-angular &&\
    npm install --save-dev @angular-devkit/build-angular &&\
    ng update

CMD ng serve --host 0.0.0.0 --port 4200
