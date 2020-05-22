Kopieren Sie das Projekt „UserManagement“ und nennen die Kopie „UserManagementAOP“.
Ergänzen Sie die Implementierung der Methode UserServiceImpl.getAllUsers() um eine zufällige Wartezeit, um den Effekt der späteren Performancemessung erkennen zu können:
try {
  Thread.sleep((long) (Math.random() * 5000));
} catch (InterruptedException e) {
}
Fügen Sie eine Spring Boot Starter Dependency für „Spring AOP“ in der Datei „build.gradle“ hinzu:
dependencies {
  compile('org.springframework.boot:spring-boot-starter-aop')
  …
}
Erstellen Sie das Eclipse-Projekt mit Hilfe von Gradle neu
Öffnen Sie hierzu eine Eingabeaufforderung und wechseln in das Projektverzeichnis
Führen Sie den Befehl „gradle cleanEclipse eclipse“ aus
Wechseln Sie zurück in die IDE und führen dort einen Refresh (F5) auf dem Projekt aus.
Erstellen Sie ein neues Paket „de.oio.fsboot.user.aop“.
Fügen Sie die Klasse „PerformanceMonitor“ in dieses neue Paket ein. Diese Klasse implementiert den Performance-Aspekt:

@Component
@Aspect
public class PerformanceMonitor {
  @Around("execution(* de.oio.fsboot.user.service..*.*(..))")
  public Object monitor(ProceedingJoinPoint pjp) throws Throwable {
    long start = System.currentTimeMillis();
    try {
      return pjp.proceed();
    } finally {
      long duration = System.currentTimeMillis() - start;
      System.out.println("The call of the method " + pjp.getTarget().getClass().getName() + "." + pjp.getSignature().getName() + " took " + duration + " ms");
    }
  }
}
Starten und testen Sie die Anwendung. 
