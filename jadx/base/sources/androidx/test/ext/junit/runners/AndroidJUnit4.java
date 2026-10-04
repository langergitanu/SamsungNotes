package androidx.test.ext.junit.runners;

import androidx.appcompat.widget.AbstractC0541b;
import com.microsoft.identity.common.java.telemetry.TelemetryEventStrings;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Iterator;
import java.util.List;
import org.apache.commons.lang3.SystemProperties;
import org.junit.runner.Description;
import org.junit.runner.Runner;
import org.junit.runner.manipulation.Filter;
import org.junit.runner.manipulation.Filterable;
import org.junit.runner.manipulation.Sortable;
import org.junit.runner.manipulation.Sorter;
import org.junit.runner.notification.RunNotifier;
import org.junit.runners.model.InitializationError;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
public final class AndroidJUnit4 extends Runner implements Filterable, Sortable {
    private static final String TAG = "AndroidJUnit4";
    private final Runner delegate;

    public AndroidJUnit4(Class<?> cls) {
        this.delegate = loadRunner(cls);
    }

    private static String getInitializationErrorDetails(Throwable th, Class<?> cls) {
        StringBuilder sb = new StringBuilder();
        Throwable cause = th.getCause();
        if (cause == null) {
            return "";
        }
        if (cause.getClass() == InitializationError.class) {
            List<Throwable> causes = ((InitializationError) cause).getCauses();
            sb.append("Test class " + cls + " is malformed. (" + causes.size() + " problems):\n");
            Iterator<Throwable> it = causes.iterator();
            while (it.hasNext()) {
                sb.append(it.next());
                sb.append("\n");
            }
        }
        return sb.toString();
    }

    private static String getRunnerClassName() {
        String property = System.getProperty("android.junit.runner", null);
        return property == null ? (System.getProperty(SystemProperties.JAVA_RUNTIME_NAME).toLowerCase().contains(TelemetryEventStrings.C6439Os.OS_NAME) || !hasClass("org.robolectric.RobolectricTestRunner")) ? "androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner" : "org.robolectric.RobolectricTestRunner" : property;
    }

    private static boolean hasClass(String str) {
        try {
            Class.forName(str);
            return true;
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }

    private static Runner loadRunner(Class<?> cls) {
        return loadRunner(cls, getRunnerClassName());
    }

    private static void throwInitializationError(String str, Throwable th) throws InitializationError {
        throw new InitializationError(new RuntimeException(str, th));
    }

    @Override // org.junit.runner.manipulation.Filterable
    public void filter(Filter filter) {
        ((Filterable) this.delegate).filter(filter);
    }

    @Override // org.junit.runner.Runner, org.junit.runner.Describable
    public Description getDescription() {
        return this.delegate.getDescription();
    }

    @Override // org.junit.runner.Runner
    public void run(RunNotifier runNotifier) {
        this.delegate.run(runNotifier);
    }

    @Override // org.junit.runner.manipulation.Sortable
    public void sort(Sorter sorter) {
        ((Sortable) this.delegate).sort(sorter);
    }

    private static Runner loadRunner(Class<?> cls, String str) throws InitializationError {
        Class<?> cls2;
        Constructor<?> constructor = null;
        try {
            cls2 = Class.forName(str);
        } catch (ClassNotFoundException e) {
            throwInitializationError(AbstractC0541b.m773o("Delegate runner ", str, " for AndroidJUnit4 could not be found.\n"), e);
            cls2 = null;
        }
        try {
            constructor = cls2.getConstructor(Class.class);
        } catch (NoSuchMethodException e2) {
            throwInitializationError(AbstractC0541b.m773o("Delegate runner ", str, " for AndroidJUnit4 requires a public constructor that takes a Class<?>.\n"), e2);
        }
        try {
            return (Runner) constructor.newInstance(cls);
        } catch (IllegalAccessException e3) {
            throwInitializationError(AbstractC0541b.m773o("Illegal constructor access for test runner ", str, "\n"), e3);
            throw new IllegalStateException("Should never reach here");
        } catch (InstantiationException e5) {
            throwInitializationError(AbstractC0541b.m773o("Failed to instantiate test runner ", str, "\n"), e5);
            throw new IllegalStateException("Should never reach here");
        } catch (InvocationTargetException e6) {
            throwInitializationError("Failed to instantiate test runner " + cls2 + "\n" + getInitializationErrorDetails(e6, cls) + "\n", e6);
            throw new IllegalStateException("Should never reach here");
        }
    }
}
