# Angular Hakathan Assessment - PlayerApp

## Objective

This is a simple web application, where, you can add the details of a CricketPlayer and display the details of all the added Players in a Table Format. Complete this PlayerApp application by adding the missing code wherever required and submit it within the alloted time.

## Things to do

1. The app is composed of 2 Components and 1 Service which are part of AppModule.

			- Components (AppComponent and HeaderComponent)
			- Service (PlayerService)  
	
2. Do the following in AppModule  

			- Add the module components to the Declarations list.
			- Add the Other modules required to the imports list.
			- Add the services to the providers list.
			- Add AppComponent to the Bootstrap list.

3. AppComponent is the RootComponent and should contain HeaderComponent

4. Header Component contain the 'Navbar' and should display the App Title, which is, "PlayerApp".

5. AppComponent should Display a Form, for getting the details of the Player to be added from the user, and a Table, which shows the details of the Player that are already added.

6. The form should contain the below input fileds:

			- Input of type text for getting the Player Name.

			- Input of type text for getting the Player Country.

			- Input of type text for getting the Total Matches Played.


-  Apply the appropriate validator to each of the Input fields, so that, the form should be valid only when all the field is containing the value.

- Bind the Input fields to the appropriate properties of the Player Model Object, using ngModel.

7. Table should display the details as follows.    

		-  Should display serial number, name, country and totalmatchesplayed  for each Player.
		- Each row should be dynamically created using approriate structural directive depending upon the number of Players, the component, received from the server.  
		- Use String Interpolation to bind the values of Player object to table data cell content.

8. Complete the below functions of AppComponent:  

			- getPlayersFromServer() - Subscribes to observable returned by getPlayers() and assign the received Players to the Players array.
			- newPlayer() - Called when the form is submitted. Adds the Player to the list by calling addPlayer().

9. Complete the Below functions of PlayerService.
 
			- getPlayers() - Performs the API call using HttpClient get() and returns the Observable of Player[].
			- addPlayer() - Performs the API call using HttpClient post() and returns the Observable of Player.  

10. Below is the available endpoints for Making API calls.

			- GET - http://localhost:3000/players - get all the Players
			- POST - http://localhost:3000/players - add a new  Player

11.  Also, Read the comments given in the files and add your code accordingly.
