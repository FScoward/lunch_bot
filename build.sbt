name := "lunch_bot"

version := "1.0"

scalaVersion := "2.11.7"
    
libraryDependencies ++= Seq(
  "com.github.gilbertw1" %% "slack-scala-client" % "0.1.2"
  ,"com.h2database" % "h2" % "1.4.188"
  ,"com.google.http-client" % "google-http-client" % "1.20.0"
)