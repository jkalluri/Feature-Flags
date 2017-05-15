name := "Feature Flags"

organization := "com.personal"

version := "1.0-SNAPSHOT"

description := "Feature Flag Standalone Jar - Java based"

publishMavenStyle := true

crossPaths := false

autoScalaLibrary := false

libraryDependencies ++= Seq (
	"org.springframework" % "spring-core" % "3.1.4.RELEASE",
	"org.springframework" % "spring-context" % "3.1.4.RELEASE",
	"org.springframework.data" % "spring-data-mongodb" % "1.2.0.RELEASE",
	"org.mongodb" % "mongo-java-driver" % "2.10.1",
	"org.slf4j" % "slf4j-api" % "1.7.22",
	"ch.qos.logback" % "logback-core" % "1.1.8",
	"ch.qos.logback" % "logback-classic" % "1.1.8"
)



