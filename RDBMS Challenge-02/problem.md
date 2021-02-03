### Problem Statement

News-app is used to explore and read the news. It is also used to manage news in your watchlist to read later.
Create the necessary DB schema (MySQL) including tables, relationships and add sample data into each table.

### Expected solution

- The tables for News, UserProfile, User and Reminders should get created, as per the Database diagram image. 
- The records for these tables should get inserted as per the snapshot shared with the boilerplate.
- Design query statements as per the requirements given below

1. Retreive all the user profiles joined on or after 10-Dec-2019.
2. Retreive the details of user 'Jack' along with all the news created by him.
3. Retreive all details of the user who created the News with newsId=103.
4. Retreive the details of all the users who have not added any news yet.
5. Retreive the newsid and title of all the news having some reminder.
6. Retreive the total number of news added by each user.
7. Update the contact number of userId='John' to '9192939495'.
8. Update the title of the newsId=101 to 'IT industry growth can be seen in 2020'.
9. Remove all the reminders belonging to the news created by Jack.
10. Write a query to set a reminder for a particular news (Use Reminder and News tables - insert statement)

	
### Note

1. This assignment is based on RDBMS concepts using MSQL platform, All the queries will run inside MYSQL workbench therofore mysql is required to work.
2. Successful execution of queries locally inside MYSQL platform are mandatory to accept the solution of this assignment.