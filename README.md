## Building simple "Choose Region" app with Spring Boot for back end and Vue JS with Vuetify for front end.

### Prerequisite
  + MySQL version 8 or above or MariaDB version 10 or above
  + Java version 11
  + Node Js version 12 or above

## Steps to Setup the Spring Boot Back End app (regioin)
1. **Create MySQL or MariaDB database**

      ```bash
	    create database region
	    ```
      
2. **Clone The Application**

      ```bash
	    git clone https://github.com/ghemulyanto/spring-boot-vue-vuetify-chain-select.git
	    cd region
	    ```
    
3. **Change MySQL/MariaDB username and password according to your MySQL/MariaDB Installation**

      + open `src/main/resources/application.properties` file.
      + change `spring.datasource.username` and `spring.datasource.password` properties value.

4. **Run the app**

	You can run the spring boot app by typing the following command -

	    ```bash
	    mvn spring-boot:run
	    ```

	The server will start on port 8080.
  
## Steps to Setup the Vue with Vuetify Front End app (region-vuetify)

Go to the `region-vuetify` folder -

      ```bash
      cd region-vuetify
      ```
   
Then type the following command to install the dependencies and start the application -

      ```bash
      npm i && npm run serve
      ```

  The front-end server will start on port `8081`.


