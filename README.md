# A DINS QA(Platform) Test task  
## Task 1 
*Let imagine that we have system that holds and manages contact directory of many companies.*
*There is one of HTTP endpoints that responsible for retrieving user data by name:*  
`GET /company/%companyId%/users?name=%someName%`  
*Please write test scenarios for this endpoint, as many as you can.*  
>*Example: Request some_domain.com/company/777/users?name=Izergil where 777 is ID of company that does not exist, check that error is returned and HTTP status code is 404* 
  
**Answer:**  
Let's imagine that we only store 4 contacts of 2 companies:
Name | Company | Phone number
--- | --- | ---
Ivan | 1 | 123456789
Ann | 1 | 32145678
Denis | 2 | 987654321
Jane | 2 | 789654321  
  
Then I can offer you the folowing test-scenarios:  
1. `GET /company/1/users?name=Ivan` - 123456789  
2. `GET /company/2/users?name=Ivan` - A message that there is no Ivan in company 2 (HTTP Status code is 200)
3. `GET /company/1/users?name=Иван` - A message that there is no Иван in company 1 (HTTP Status code is 200)
3. `GET /company/2/` - error is returned and HTTP status code is 403
4. `GET /company/` - error is returned and HTTP status code is 403
5. `GET /company/2/users/` -  error is returned and HTTP status code is 403 
6. `GET /company/-1/users?name=Ivan` - error is returned and HTTP status code is 404
6. `GET /company/Ivan/users?name=1` - error is returned and HTTP status code is 404
6. `GET /company/1/users?salary=100000` - error is returned and HTTP status code is 404
7. `POST /company/1/users?name=Ivan` - error is returned and HTTP status code is 404  
  
## Task 2  
*Implement following scenario for this endpoint using java: Verify that user can search only member of his own company.*  
**Answer:**  
This is a maven app. I recommend to run it in the IntellijIDEA with `mvnw spring-boot:run` command.  
Firstly, you should visit [http://localhost:8080/](http://localhost:8080/). There are 2 users with logins Ivan and Denis. 
Both have the same password - `password`. 
Then, go to the [http://localhost:8080/create](http://localhost:8080/create). This is a blank page, which adds contacts to the base.  
There are 4 contacts in the base, the same as example in a first task. So, if you are logged in as Ivan, you can see his number 
with [http://localhost:8080/company/1/users?name=Ivan](http://localhost:8080/company/1/users?name=Ivan) and Ann's number with [http://localhost:8080/company/1/users?name=Ann](http://localhost:8080/company/1/users?name=Ann).
The same thing with Denis and Jane.  
  
 ## Conclusion
 Hope I understood the task right and was clear in my explanations. Always ready to answer your questions! 
