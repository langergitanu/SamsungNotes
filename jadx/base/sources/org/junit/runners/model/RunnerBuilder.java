package org.junit.runners.model;

import androidx.appcompat.widget.AbstractC0541b;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.junit.internal.runners.ErrorReportingRunner;
import org.junit.runner.Description;
import org.junit.runner.OrderWith;
import org.junit.runner.Runner;
import org.junit.runner.manipulation.Ordering;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes11.dex */
public abstract class RunnerBuilder {
    private final Set<Class<?>> parents = new HashSet();

    private void configureRunner(Runner runner) {
        Description description = runner.getDescription();
        OrderWith orderWith = (OrderWith) description.getAnnotation(OrderWith.class);
        if (orderWith != null) {
            Ordering.definedBy(orderWith.value(), description).apply(runner);
        }
    }

    public Class<?> addParent(Class<?> cls) throws InitializationError {
        if (this.parents.add(cls)) {
            return cls;
        }
        throw new InitializationError(AbstractC0541b.m773o("class '", cls.getName(), "' (possibly indirectly) contains itself as a SuiteClass"));
    }

    public void removeParent(Class<?> cls) {
        this.parents.remove(cls);
    }

    public abstract Runner runnerForClass(Class<?> cls);

    public List<Runner> runners(Class<?> cls, Class<?>[] clsArr) throws InitializationError {
        addParent(cls);
        try {
            return runners(clsArr);
        } finally {
            removeParent(cls);
        }
    }

    public Runner safeRunnerForClass(Class<?> cls) {
        try {
            Runner runnerRunnerForClass = runnerForClass(cls);
            if (runnerRunnerForClass == null) {
                return runnerRunnerForClass;
            }
            configureRunner(runnerRunnerForClass);
            return runnerRunnerForClass;
        } catch (Throwable th) {
            return new ErrorReportingRunner(cls, th);
        }
    }

    public List<Runner> runners(Class<?> cls, List<Class<?>> list) {
        return runners(cls, (Class<?>[]) list.toArray(new Class[0]));
    }

    private List<Runner> runners(Class<?>[] clsArr) {
        ArrayList arrayList = new ArrayList();
        for (Class<?> cls : clsArr) {
            Runner runnerSafeRunnerForClass = safeRunnerForClass(cls);
            if (runnerSafeRunnerForClass != null) {
                arrayList.add(runnerSafeRunnerForClass);
            }
        }
        return arrayList;
    }
}
