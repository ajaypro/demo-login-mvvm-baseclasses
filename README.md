## Login feature with abstract base classes

* Login viewmodel will call the validation logic for username, password, progressbar from the validation class
* validation data class you will have two arguments Field and Resource
   ```
     enum class Field{
	   EMAIL,
	   PASSWORD
	   ```
* Resource class if you have data in application and give status to it you use resource
* How to use Event that returns content if it is not handled
* Abstraction between network layer and data layer, separation of concern, usage of repository classes
* Leveraging material design that makes it easy to display error messages, validation parameters with less code, 
	
  ### User Repository
  
  * Usually the request and response should be below the repository level in the architecture.
  * Respository hides the details from caller and handles the business logic
  ```
      fun doUserLogin(email: String, password: String): Single<User> =
        networkService.doLoginCall(LoginRequest(email, password))
            .map {
                User(
                    it.userId,
                    it.userName,
                    it.userEmail,
                    it.accessToken,
                    it.profilePicUrl
                )
            }
	``` 
  * In the above code the networkservice is making the network call and the response that it gives we transform into `User` object in `UserRepository`
   as we only handle data in repository layer not the error or response codes.
