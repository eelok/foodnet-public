
[![Build Status](https://travis-ci.com/arthurlerke/FoodNet.svg?token=xmdTwBBxAiFLXrZbf1Zv&branch=master)](https://travis-ci.com/arthurlerke/FoodNet)

## Setup environment variables
```nano ~/.bash_profile```

    export PGPORT=5432
    export PGUSER=postgres
    export PGPASSWORD=blank

```source .bash_profile```

## first step 
```npm install```

## run sass
```npm start```

## run cypress tests with UI
```npx cypress open```

## run cypress tests with NPM
```npm test```

## fix all problems
gradle clean build

## start postgres
docker-compose up

## kill postgres
docker-compose down

## list docker running docker containers
docker ps