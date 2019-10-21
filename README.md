descriptions of project folders/components
# spring_boot_routes:
Spring boot app, leveraging camel routes to ensure /python_rest_api and /spring_boot_routes data remains synced.  

# python_rest_api:
Flask server, exposing a single post endpoint "/sync", that syncs existing data against the incoming request

# rest_assured:
Rest assured framework, testing json responses from /python_rest_api and /spring_boot_routes

# JenkinsFile:
A pipeline that:  
  clones project repo  
  pip installs python requirements  
    steps run in parralel:  
    - builds(gradle) /spring_boot_routes server  
    - starts /python_rest_api server  
    - builds(gradle) /rest_assured jar, running tests against the servers running from previous steps
    
# camel_components_scratch:
Further EIPs and camel components:     
- Beans  
- ContentEnrichers  
- Processors  

  
  
  
