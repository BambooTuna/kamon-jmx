import Dependencies.Kamon

/* =========================================================================================
 * Copyright © 2013-2016 the kamon project <http://kamon.io/>
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file
 * except in compliance with the License. You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the
 * License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND,
 * either express or implied. See the License for the specific language governing permissions
 * and limitations under the License.
 * =========================================================================================
 */

val kamonCore = "io.kamon" %% "kamon-core" % "0.6.7"
val akkaActor = "com.typesafe.akka" %% "akka-actor" % "2.5.23"
val akkaTestkit = "com.typesafe.akka" %% "akka-testkit" % "2.5.23" % Test
val scalatest = "org.scalatest" %% "scalatest" % "3.0.1"

val slf4jApi            = "org.slf4j" % "slf4j-api"        % "1.7.21"
val slf4jnop = "org.slf4j" % "slf4j-nop" % "1.7.21" % Test

lazy val sample = (project in file("sample"))
  .settings(
    name := "kamon-jmx-sample",
    version := "1.0.0-SNAPSHOT",
    scalaVersion := "2.11.8",
    crossScalaVersions := Seq("2.11.8", "2.12.8")
  )
  .settings(
    libraryDependencies ++= Seq(
      //kamonCore
    ) ++ Kamon.allDependencies
  )
  .dependsOn(root)

lazy val root = (project in file("."))
  .settings(
    name := "kamon-jmx",
    version := "1.0.9sbt publish-SNAPSHOT",
    scalaVersion := "2.11.8",
    crossScalaVersions := Seq("2.11.8", "2.12.8")
  )
  .settings(
        organization := "com.github.BambooTuna",
        publishTo := Some(Resolver.file("kamon-jmx",file("."))(Patterns(true, Resolver.mavenStyleBasePattern))),
        libraryDependencies ++=
          compileScope(kamonCore, akkaActor) ++
            testScope(scalatest, slf4jApi) ++
          Seq(
            akkaTestkit
        )
  )
