# Running the app

Install Dependencies `npm install`

Build the client `npm run build`

Copy the contents of build folder to backend project - under static folder
(This can be done via scripts as well)

Localhost App : http://localhost:8095

Deployed URL : https://csv-uploader.herokuapp.com/

This App has
1. Spring boot app As Backend Server
2. React App As UI Client
3. Heroku as deployment platform
4. Prime React as Data Table Lib

## Instructions

1. Open the https://csv-uploader.herokuapp.com/
2. Choose file and Click on Upload CSV
3. For larger size CSV file, time taken will be more if your connection is on low speed.
4. CSV file is parsed and data is populated in to UI using prime react data table
5. User can perform search on each column and also search globally which queries all the column data
6. User can sort the retail price and discounted price when even search is on
7. Pagination is available for the navigation between pages - page size set is 50 rows currently

## Refer Screenshots
