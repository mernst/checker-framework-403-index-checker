/*
 * @test
 * @summary Test for Issue 257
 *
 * @compile -XDrawDiagnostics -processor org.checkerframework.checker.nullness.NullnessChecker -AprintErrorStack Small.java
 *
 * @compile -XDrawDiagnostics -processor org.checkerframework.checker.nullness.NullnessChecker -AprintErrorStack ClientBuilder.java Module.java
 *
 * @compile -XDrawDiagnostics ClientBuilder.java
 */
class Module {
  void buildClient() {
    ClientBuilder<?> builder = ClientBuilder.newBuilder()
        .setThing()
        .setThing();
  }

  void smaller() {
    ClientBuilder<? extends ClientBuilder<? extends ClientBuilder<? extends ClientBuilder<?>>>> builder = ClientBuilder.newBuilder();
  }
}
