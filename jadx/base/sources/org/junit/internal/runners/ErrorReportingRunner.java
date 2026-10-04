package org.junit.internal.runners;

import com.samsung.android.support.senl.p148nt.data.database.core.query.sqlbuilder.SQLKeyword;
import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.junit.runner.Description;
import org.junit.runner.Runner;
import org.junit.runner.notification.Failure;
import org.junit.runner.notification.RunNotifier;
import org.junit.runners.model.InvalidTestClassError;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes11.dex */
public class ErrorReportingRunner extends Runner {
    private final List<Throwable> causes;
    private final String classNames;

    public ErrorReportingRunner(Class<?> cls, Throwable th) {
        this(th, (Class<?>[]) new Class[]{cls});
    }

    private Description describeCause() {
        return Description.createTestDescription(this.classNames, "initializationError", new Annotation[0]);
    }

    private List<Throwable> getCauses(Throwable th) {
        return th instanceof InvocationTargetException ? getCauses(th.getCause()) : th instanceof InvalidTestClassError ? Collections.singletonList(th) : th instanceof org.junit.runners.model.InitializationError ? ((org.junit.runners.model.InitializationError) th).getCauses() : th instanceof InitializationError ? ((InitializationError) th).getCauses() : Collections.singletonList(th);
    }

    private String getClassNames(Class<?>... clsArr) {
        StringBuilder sb = new StringBuilder();
        for (Class<?> cls : clsArr) {
            if (sb.length() != 0) {
                sb.append(SQLKeyword.COMMA);
            }
            sb.append(cls.getName());
        }
        return sb.toString();
    }

    private void runCause(Throwable th, RunNotifier runNotifier) {
        Description descriptionDescribeCause = describeCause();
        runNotifier.fireTestStarted(descriptionDescribeCause);
        runNotifier.fireTestFailure(new Failure(descriptionDescribeCause, th));
        runNotifier.fireTestFinished(descriptionDescribeCause);
    }

    @Override // org.junit.runner.Runner, org.junit.runner.Describable
    public Description getDescription() {
        Description descriptionCreateSuiteDescription = Description.createSuiteDescription(this.classNames, new Annotation[0]);
        for (Throwable th : this.causes) {
            descriptionCreateSuiteDescription.addChild(describeCause());
        }
        return descriptionCreateSuiteDescription;
    }

    @Override // org.junit.runner.Runner
    public void run(RunNotifier runNotifier) {
        Iterator<Throwable> it = this.causes.iterator();
        while (it.hasNext()) {
            runCause(it.next(), runNotifier);
        }
    }

    public ErrorReportingRunner(Throwable th, Class<?>... clsArr) {
        if (clsArr == null || clsArr.length == 0) {
            throw new NullPointerException("Test classes cannot be null or empty");
        }
        for (Class<?> cls : clsArr) {
            if (cls == null) {
                throw new NullPointerException("Test class cannot be null");
            }
        }
        this.classNames = getClassNames(clsArr);
        this.causes = getCauses(th);
    }
}
