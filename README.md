# Reto Kleverness
Api Rest para hub y devices aplicaciones para vacante java

# Herramientas necesarias:
* Java JDK 8
* SpringBoot
* PostgreSQL 10
* AWS Elastic Beanstalk
* IDE

# Endpoints

# HUB

Local:
  Endpoint: /hubs GET:
    GET: localhost:8080/hub
  Endpoint: /hubs/{mac address} GET:
    GET: localhost:8080/hub/00-17-4F-08-5D-69
  Endpoint: /hubs POST
    POST: localhost:8080/hub
    BODY:
      {
        "type": "DEVICE",
        "macAddress": "00-17-4F-08-5D-20",
        "qrCode": "D2AB123CDEF4",
        "status": "Assigned"
      }
    
Remoto:
   Endpoint: /hubs GET:
    GET: http://reto-env.eba-32q3mbpr.us-east-2.elasticbeanstalk.com/hub
  Endpoint: /hubs/{mac address} GET:
    GET: http://reto-env.eba-32q3mbpr.us-east-2.elasticbeanstalk.com/hub/00-17-4F-08-5D-69
  Endpoint: /hubs POST
    POST: http://reto-env.eba-32q3mbpr.us-east-2.elasticbeanstalk.com/hub

# DEVICES
Local:
  Endpoint: /devices GET
    GET: localhost:8080/devices
  Endpoint: /devices/{deviceId} GET
    GET: localhost:8080/devices/1
  Endpoint: /devices POST
    POST: localhost:8080/devices


