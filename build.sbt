ThisBuild / scalaVersion := "2.13.1"
ThisBuild / organization := "com.loygorri"

// Set here the path to the selenium drivers
val pathToDrivers = "PATH TO DRIVERS"
val geckoDriverOpt = "-Dwebdriver.gecko.driver=" + pathToDrivers + "geckodriver"
val chromeDriverOpt = "-Dwebdriver.chrome.driver=" + pathToDrivers + "chromedriver"

lazy val hello = (project in file("."))
  .settings(
    name := "Tests with Selenium",
    libraryDependencies ++= Seq("org.scalatest" %% "scalatest" % "3.2.0" % "test",
              "org.seleniumhq.selenium" % "selenium-java" %  "3.141.59" % "test",
               "org.seleniumhq.selenium" % "htmlunit-driver" % "2.35.1" % "test",
               "org.scalatestplus" %% "selenium-3-141" % "3.2.2.0" % "test"),
    javaOptions in Test ++= Seq(geckoDriverOpt, chromeDriverOpt)
  )
   