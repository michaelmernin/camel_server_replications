descriptions of project folders/components
# spring_boot_routes:
Spring boot app, leveraging camel routes to ensure /python_rest_api and /spring_boot_routes data remains synced.  
Camel components:

# python_rest_api:
Flask server, exposing a single post endpoint "/sync", that syncs existing data against the incoming request

# rest_assured:
Rest assured framework, testing python_rest_api's endpoint "sync" json response. 

# JenkinsFile:
A pipeline that:  
  clones project repo  
  pip installs python requirements  
    steps run in parralel:  
    builds(gradle) /spring_boot_routes server  
    starts /python_rest_api server  
    builds(gradle) /rest_assured jar, running tests against the servers running from previous steps
  
  
  
