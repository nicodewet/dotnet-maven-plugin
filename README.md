# dotnet-maven-plugin

This project is a *Work In Progress* (the first release has not been done yet) ...

## Why?

This plugin can be used to include .NET Core builds in [Maven](https://maven.apache.org/what-is-maven.html) centric pipelines allowing for the re-use of some Maven concepts and [features](https://maven.apache.org/maven-features.html) (e.g. the versioning scheme) and [plugins](https://maven.apache.org/plugins/index.html) (e.g. the spotify [docker-maven-plugin](https://github.com/spotify/docker-maven-plugin), the [release](http://maven.apache.org/maven-release/maven-release-plugin/) plugin).

As highlighted in [Maven: The Complete Reference](http://books.sonatype.com/mvnref-book/reference/index.html) Maven is not just a build tool. Rather it is a project
management tool offering a superset of the features tradionally found in a build tool. So in terms of why create this plugin, the reason is simply to
keep some, but not all (NuGet is used for dependency management), of the benefits that Maven offers.

> Maven is a project management tool which encompasses a project object model, a set of standards, a project lifecycle, a dependency management system, 
> and logic for executing plugin goals at defined phases in a lifecycle. 
> When you use Maven, you describe your project using a well-defined project object model, Maven can then apply cross-cutting logic from a set of shared
> (or custom) plugins.

### Alternatives

An alternative to using this plugin would be to write shell scripts to call the **dotnet** utility at appropriate Maven lifecycle phases. The benefit of using this plugin is that it saves you the time of writing these scripts and then calling them from the [Maven AntRun](http://maven.apache.org/plugins/maven-antrun-plugin/) plugin.

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
