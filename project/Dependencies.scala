import sbt.{ExclusionRule, _}

object Dependencies {

  object Version {
    val kamon                = "0.6.7"
    val kamon_akka           = "0.6.8"
    val aspectj              = "1.8.10"
  }

  object Kamon {
    val core = "io.kamon" %% "kamon-core" % Version.kamon excludeAll (
      ExclusionRule(organization = "log4j"),
      ExclusionRule(organization = "org.slf4j"),
      ExclusionRule(organization = "com.typesafe.akka")
    )
    val systemMetrics = "io.kamon" %% "kamon-system-metrics" % Version.kamon excludeAll (
      ExclusionRule(organization = "log4j"),
      ExclusionRule(organization = "org.slf4j"),
      ExclusionRule(organization = "com.typesafe.akka")
    )
    val logReporter = "io.kamon" %% "kamon-log-reporter" % Version.kamon excludeAll (
      ExclusionRule(organization = "log4j"),
      ExclusionRule(organization = "org.slf4j"),
      ExclusionRule(organization = "com.typesafe.akka")
    )
    val jmx = "io.kamon" %% "kamon-jmx" % Version.kamon excludeAll (
      ExclusionRule(organization = "log4j"),
      ExclusionRule(organization = "org.slf4j"),
      ExclusionRule(organization = "com.typesafe.akka")
    )
    val scala = "io.kamon" %% "kamon-scala" % Version.kamon excludeAll (
      ExclusionRule(organization = "log4j"),
      ExclusionRule(organization = "org.slf4j"),
      ExclusionRule(organization = "com.typesafe.akka")
    )
    val akka24 = "io.kamon" %% "kamon-akka-2.4" % Version.kamon_akka excludeAll (
      ExclusionRule(organization = "log4j"),
      ExclusionRule(organization = "org.slf4j"),
      ExclusionRule(organization = "com.typesafe.akka")
    )

    val datadog = "io.kamon" %% "kamon-datadog" % Version.kamon excludeAll (
      ExclusionRule(organization = "log4j"),
      ExclusionRule(organization = "org.slf4j"),
      ExclusionRule(organization = "com.typesafe.akka")
    )
    val allDependencies = Seq(core, systemMetrics, /*jmx, */scala, akka24, datadog)
  }

  object Aspectj {
    val aspectjweaver = "org.aspectj" % "aspectjweaver" % Version.aspectj
  }
  
}
