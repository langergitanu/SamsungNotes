package org.junit.runner.notification;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import org.junit.runner.Description;
import org.junit.runner.Result;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes11.dex */
public class RunListener {

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Target({ElementType.TYPE})
    @Documented
    @Retention(RetentionPolicy.RUNTIME)
    public @interface ThreadSafe {
    }

    public void testAssumptionFailure(Failure failure) {
    }

    public void testFailure(Failure failure) {
    }

    public void testFinished(Description description) {
    }

    public void testIgnored(Description description) {
    }

    public void testRunFinished(Result result) {
    }

    public void testRunStarted(Description description) {
    }

    public void testStarted(Description description) {
    }

    public void testSuiteFinished(Description description) {
    }

    public void testSuiteStarted(Description description) {
    }
}
