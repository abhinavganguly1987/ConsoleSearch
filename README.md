# ConsoleSearch
=================

just a console app in Spring boot.. consuming 2 REST apis,  based on given arguments

1. Import the project in your IDE (i've used IntelliJ to develop this)
2. Run following command from your terminal window
      mvn package && java -jar -Dapi=imdb -DsearchTerm='star wars' target/ConsoleSearch-1.0.jar
      
And you'll see some nice output :)

3. -Dapi is currently serves to 'imdb' and 'album' values only
4. -DsearchTerm can be anything, just make sure if it is multiple words, they are within single inverted commas ('...')
5. Some examples to get you started with:
    -DsearchTerm for movies : 'star wars', 'hidalgo', 'dollars', 'james bond' 
    -DsearchTerm for albums : evolve, 'moves like jagger', 'On a day like today', 'pho'



Note: 
>if you don't provide -Dapi or -DsearchTerm, you'll get corresponding messages on terminal window as these are mandatory.
>APIs used are free from any API key or OauthTokens, 
>Movie details are restricted i.e. director details are not available from the consumed API.


