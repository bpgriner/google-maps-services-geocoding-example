# Google Maps Services Geocoding Example

This an example implementation that illustrates how to interact with the Google Maps Geocoding API.
Due to there being many GPS Coordinate combinations for every address, this example project implements a `LocationVerificationService` that has a `verifyMatch` method which will check if a given set of GPS Coordinates falls within a given Address (according to Google Maps, of course).

Pull requests are welcome if you see something that could be improved.

---

###### Built with:
* Java 1.8.0_77 SDK
  * http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html
* Maven 3.3.9
  * https://maven.apache.org/download.cgi

--

###### How to Run Integration Tests:
1. Fork this repository to your GitHub account
  * https://help.github.com/articles/fork-a-repo/
2. Clone your newly forked repository to your local environment
  * https://help.github.com/articles/cloning-a-repository/
3. Get a Google Maps API Server Key
  * https://developers.google.com/maps/documentation/geocoding/get-api-key
4. Replace `yourGoogleMapsApiServerKeyGoesHere` with your key inside the `LocationVerificationServiceImpl` public constructor
5. Change directory to `/your/path/to/google-maps-services-geocoding-parent` and run `mvn install` (via bash)
  * You should receive a `BUILD SUCCESS` message from Maven
6. Change directory to `../google-maps-services-geocoding-integration-tests` and run `mvn install` (via bash)
  * You should receive a `Tests run: 15, Failures: 0, Errors: 0, Skipped: 0` as well as a `BUILD SUCCESS` message from Maven 

--

##### Links:
* The Google Maps Geocoding API: https://developers.google.com/maps/documentation/geocoding/intro
* googlemaps/google-maps-services on GitHub: https://github.com/googlemaps/google-maps-services-java
