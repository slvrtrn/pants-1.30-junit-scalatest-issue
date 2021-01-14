### PANTS 1.30 & ScalaTest 3.1.0+ minimal reproduction repo

Expected behavior: `./pants test ::` passes.

Actual behavior: `./pants test ::` throws an `initializationError`

```
14:44:15 00:01       [run]
                     .E
                     Time: 0.02
                     There was 1 failure:
                     1) initializationError(com.github.slvrtrn.TestHello)
                     java.lang.NullPointerException
                     	at __shaded_by_pants__.org.pantsbuild.tools.junit.impl.ScalaTestUtil.getJUnitRunner(ScalaTestUtil.java:62)
                     	at __shaded_by_pants__.org.pantsbuild.tools.junit.impl.CustomAnnotationBuilder$ScalaTestAnnotatedBuilder.runnerForClass(CustomAnnotationBuilder.java:52)
                     	at org.junit.runners.model.RunnerBuilder.safeRunnerForClass(RunnerBuilder.java:59)
                     	at org.junit.internal.builders.AllDefaultPossibilitiesBuilder.runnerForClass(AllDefaultPossibilitiesBuilder.java:26)
                     	at org.junit.runners.model.RunnerBuilder.safeRunnerForClass(RunnerBuilder.java:59)
                     	at __shaded_by_pants__.org.pantsbuild.tools.junit.impl.AnnotatedClassRequest.getRunner(AnnotatedClassRequest.java:41)
                     	at __shaded_by_pants__.org.pantsbuild.tools.junit.impl.CompositeRequestRunner.runChild(CompositeRequestRunner.java:53)
                     	at __shaded_by_pants__.org.pantsbuild.tools.junit.impl.ConcurrentCompositeRequestRunner$1$1.run(ConcurrentCompositeRequestRunner.java:37)
                     	at __shaded_by_pants__.org.pantsbuild.tools.junit.impl.ConcurrentRunnerScheduler.finished(ConcurrentRunnerScheduler.java:89)
                     	at __shaded_by_pants__.org.pantsbuild.tools.junit.impl.ConcurrentCompositeRequestRunner$1.evaluate(ConcurrentCompositeRequestRunner.java:46)
                     	at org.junit.runners.ParentRunner.run(ParentRunner.java:363)
                     	at org.junit.runner.JUnitCore.run(JUnitCore.java:137)
                     	at __shaded_by_pants__.org.pantsbuild.tools.junit.impl.ConsoleRunnerImpl.runLegacy(ConsoleRunnerImpl.java:613)
                     	at __shaded_by_pants__.org.pantsbuild.tools.junit.impl.ConsoleRunnerImpl.run(ConsoleRunnerImpl.java:503)
                     	at __shaded_by_pants__.org.pantsbuild.tools.junit.impl.ConsoleRunnerImpl.main(ConsoleRunnerImpl.java:790)
                     	at org.pantsbuild.tools.junit.ConsoleRunner.main(ConsoleRunner.java:12)

```

It will pass if `@RunWith(classOf[JUnitRunner])` annotation is uncommented in `com.github.slvrtrn.TestHello`.

Previously, with ScalaTest 3.0.8, the annotation was not required, as well as the explicit `junit` 3rdparty dependency. 

Now it is mandatory.