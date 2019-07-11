lazy val root: Project = project.in(file(".")).dependsOn(latestSbtUmbrella)
lazy val latestSbtUmbrella = RootProject(uri("git://github.com/takeosuzuki/kamon-sbt-umbrella.git"))