# Spring Boot CSV Parser Example

## Description

This application takes the csv file as the input and parses and displays the content in table form.

## Build the application

### To Build Backend
```
cd back-end
mvn clean install
```
### To Build Frontend
```
cd front-end
npm install
npm run build //Copy the contents of build folder to backend project - under static folder (This can be done via scripts as well)
```

## Run Spring Boot application
Note:- Front end has been built and has been copied to static folder in back-end project already
```
cd back-end
mvn spring-boot:run
```
## Instructions
1. Run the app locally and open http://localhost:8080/
2. Choose file and Click on Upload CSV
3. For larger size CSV file, time taken will be more if your connection is on low speed.
4. CSV file is parsed and data is populated in to UI using prime react data table
5. User can perform search on each column and also search globally which queries all the column data
6. User can sort the retail price and discounted price when even search is on
7. Pagination is available for the navigation between pages - page size set is 50 rows currently
