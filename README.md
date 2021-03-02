# Stellar Coding Challenge
Author : Marisha Schumacher-Hodge

## Assumptions

* The user will pass in all variables appropriately
* The limitations of a snippet are that of a String.
* Expiration date is based on end user's local time zone


## Design Decisions
It was important to identify what the response, and RESTful requests that would be implemented in my solution. Also, I had to consider how to store the snippets in memory.

Response:
* name 
* url
* expires_at
* snippet

In Memory Storage:
* Use of a hashmap <name, Snippet>

Supported Requests:
* POST /snippets: Creates a new snippet. Returns 200
* Get /snippets/{name}: Retrieves an existing snippet (if found and not expired). Otherwise, returns a 404


## What we're not looking for

* Don't write your own HTTP implementation. You won't get extra points for it, and this will probably take time that could be spent elsewhere
* This is a simple problem. If your solution is complex, take a step back
* Do not reinvent the wheel. Make use of all the tools you know and like, as well as the knowledge you've built throughout your career


## Production concerns addressed and error handling
* Using `LocalDateTime` object in Java to account for different time zones when calculating expiration for snippets
* Making sure the application sends appropriate error when wrong path or data is in the request (handled by library logic)

## Next Steps
* Add authentication layer to API to verify request and set limitations on request
* Add more custom error handling to better inform users
* Write full testing coverage