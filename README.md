# dotnet-maven-plugin

This project is a work in progress (the first release has not been done yet).

## Testing

* mvn clean install
* mvn io.makaro:dotnet-maven-plugin:test
* mvn io.makaro:dotnet-maven-plugin:build

## Original Setup Steps

<code>
mvn archetype:generate -DgroupId=io.makaro -DartifactId=dotnet-maven-plugin -DarchetypeGroupId=org.apache.maven.archetypes 
-DarchetypeArtifactId=maven-archetype-plugin
</code>

### References

* https://maven.apache.org/guides/plugin/guide-java-plugin-development.html
* https://github.com/spotify/docker-maven-plugin