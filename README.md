Advertise Service REST APIs with Spring boot.

API Operations:

BasePath:/api/advertiser

1.)API to list of Advertisers: /api/advertiser


2.)API to retrieve a specific Advertiser: /api/advertiser/{name}


3.)API to POST a Advertiser: /api/advertiser
   Sample Request Body:
   {
       "advertiserName": "Advertiser20",
       "contactName": "Reddy20",
       "creditLimit": 10000
    }


4.)API to Update Advertiser: /api/advertiser
   Sample Request Body:
   {
       "advertiserName": "Advertiser20",
       "contactName": "ReddyUpdate20",
       "creditLimit": 1000
     }


5.)API to Delete Advertiser: /api/advertiser/{name}


6.)API to validate transactionAmount: /api/advertiser/checkTransaction/{name}/{transactionAmount}


7.)API to Deduct(POST Operation) credit limit from Advertiser: /api/advertiser/postTransaction/{name}/{transactionAmount}

GitHub: https://github.com/anirudhreddy6/advertiserservice

Swagger UI Endpoint: http://localhost:8080/swagger-ui.html#

Management Endpoint:
ManagementPort: 8090
BasePath: /api/advertiser
Management Info Endpoint: http://localhost:8090/api/advertiser/info
Response from Info Endpoint:

{"app":{"version":"1.0.0","description":"This Application supports all CRUD operations on the Advertiser service.","name":"Advertiser Service API Application"}}


Design:
1.)Model:Advertiser (advertiserName: String,contactName: String, creditLimit: double)

2.)Service: AdvertiserService

3.)Controllers:AdvertiserController(GET,POST,PUT,DELETE,GET All Advertisers,Check Transaction,Post Transaction to Deduct)

4.)exception:CustomException

5.)mapper:AdvertiserMapper

6.)configuration:SwaggerConfiguration

Running the APP Dockerway:
1.Ensure docker is running on your local machine

2.)navigate to folder where dockerfile is present

3.)Steps:
        gradle build
        docker build
        docker build -f Dockerfile -t advertisermicroservice .
        docker run -it  -p 8080:8080  advertisermicroservice

4.)Use the below swagger URL to test Endpoint:
    http://localhost:8080/swagger-ui.html#

5.)Use the below URL to test in any rest client
   http://localhost:8080/api/advertiser



Note: Tested all the above endpoints with swagger and postman.My test cases still need updates for better coverage.