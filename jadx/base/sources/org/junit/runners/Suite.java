package org.junit.runners;

import androidx.appcompat.widget.AbstractC0541b;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.Collections;
import java.util.List;
import org.junit.internal.builders.AllDefaultPossibilitiesBuilder;
import org.junit.runner.Description;
import org.junit.runner.Runner;
import org.junit.runner.notification.RunNotifier;
import org.junit.runners.model.InitializationError;
import org.junit.runners.model.RunnerBuilder;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes11.dex */
public class Suite extends ParentRunner<Runner> {
    private final List<Runner> runners;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Target({ElementType.TYPE})
    @Inherited
    @Retention(RetentionPolicy.RUNTIME)
    public @interface SuiteClasses {
        Class<?>[] value();
    }

    public Suite(Class<?> cls, RunnerBuilder runnerBuilder) {
        this(runnerBuilder, cls, getAnnotatedClasses(cls));
    }

    public static Runner emptySuite() {
        try {
            return new Suite((Class<?>) null, (Class<?>[]) new Class[0]);
        } catch (InitializationError unused) {
            throw new RuntimeException("This shouldn't be possible");
        }
    }

    private static Class<?>[] getAnnotatedClasses(Class<?> cls) throws InitializationError {
        SuiteClasses suiteClasses = (SuiteClasses) cls.getAnnotation(SuiteClasses.class);
        if (suiteClasses != null) {
            return suiteClasses.value();
        }
        throw new InitializationError(AbstractC0541b.m773o("class '", cls.getName(), "' must have a SuiteClasses annotation"));
    }

    @Override // org.junit.runners.ParentRunner
    public List<Runner> getChildren() {
        return this.runners;
    }

    public Suite(RunnerBuilder runnerBuilder, Class<?>[] clsArr) {
        this((Class<?>) null, runnerBuilder.runners((Class<?>) null, clsArr));
    }

    @Override // org.junit.runners.ParentRunner
    public Description describeChild(Runner runner) {
        return runner.getDescription();
    }

    @Override // org.junit.runners.ParentRunner
    public void runChild(Runner runner, RunNotifier runNotifier) {
        runner.run(runNotifier);
    }

    public Suite(Class<?> cls, Class<?>[] clsArr) {
        this(new AllDefaultPossibilitiesBuilder(), cls, clsArr);
    }

    public Suite(RunnerBuilder runnerBuilder, Class<?> cls, Class<?>[] clsArr) {
        this(cls, runnerBuilder.runners(cls, clsArr));
    }

    public Suite(Class<?> cls, List<Runner> list) {
        super(cls);
        this.runners = Collections.unmodifiableList(list);
    }
}
