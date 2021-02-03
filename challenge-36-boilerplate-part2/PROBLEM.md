## Challenge – Part 2

**Task 5**  
Notice that when the MusicItem is an album, we are not capturing the details of the individual songs. Design a class called Song for storing the details of individual songs. The class should be able to store at least the following attributes:

-	Name of the Song
-	Duration of the song in hh:mm:ss

Implement this class with appropriate constructors as well as getter and setter methods.
Now enhance the design of your MusicItem class so that it contains an additional attribute called songList[] which can be used to store the details of all the songs in the album in case the music item is an album.

Please update the constructors of the MusicItem class so that the size of the array songList[] is instantiated according to the number of songs in the album.

Finally, since the song list may not be updated immediately at the time the music album is added in the music catalog use a control variable in the MusicItem class to track this status. 

    boolean isSongListUpdated; 
    // false by default; set to true when song list is updated


**Task 6** – Now update your main method to give an option to the user to update the song list for albums where the song list is missing. Allow the user to specify the name of a file which contains the details of all the songs in the corresponding album. For example, the file “thriller.txt” contains the following data:

    1.	Wanna Be Startin’ Somethin’, 00:06:02
    2.	Baby Be Mine, 00:04:20
    3.	The Girl is Mine (with Paul McCartney), 00:03:41
    4.	Thriller, 00:05:57
    5.	Beat It, 00:04:18
    6.	Billie Jean, 00:04:54
    7.	Human Nature, 00:04:05
    8.	P.Y.T. (Pretty Young Thing), 00:03:58
    9.	The Lady In My Life, 00:04:58

and the file “brothers-in-arms.txt” contains the following data:

    1.	So Far Away, 00:05:08
    2.	Money for Nothing, 00:08:30
    3.	Walk of Life, 00:04:09
    4.	Your Latest Trick, 00:06:33
    5.	Why Worry?, 00:08:29
    6.	Ride across the River, 00:07:04
    7.	The Man’s Too Strong, 00:04:38
    8.	One World, 00:03:38
    9.	Brothers in Arms, 00:07:04

Read the file specified by the user and load the data about individual files in the array songList[] of the corresponding music item.

**Task 7** – Now go and update the showDetails() method in the MusicItem class so that it also shows the songList[] for albums where the list of songs is available.

Now let’s revisit the main method that you wrote in Task 4. In option 3 the user had a choice to mention the album name or a song name. You were comparing this only with the “name” attribute of the music item. Which means only if the name matched the album name or the name of a single, would the search be successful. Now update this search so that wherever a songList[] is available the search is also done for the corresponding list of songs.
