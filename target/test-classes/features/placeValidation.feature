Feature: Validating Place API's


Scenario Outline: Verify if the place is being added successfully using AddPlaceApi
     Given Add Place Playload with "<name>" "<language>""<address>"
     When user calls "AddPlaceAPI" with "Post" http request
     Then the API call got success with status code 200
     And "status" in response body is "OK"
     
     
  
  Examples:
      |name      |language|address           |
      |subhankar |English |world class center|  
      
      When user calls "getPlaceAPI" with "get" http request
      Then the API call got success with status code 200
     And "status" in response body is "OK"    