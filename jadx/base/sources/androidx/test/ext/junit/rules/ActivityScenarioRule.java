package androidx.test.ext.junit.rules;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.test.core.app.ActivityScenario;
import androidx.test.internal.util.Checks;
import org.junit.rules.ExternalResource;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
public final class ActivityScenarioRule<A extends Activity> extends ExternalResource {

    @Nullable
    private ActivityScenario<A> scenario;
    private final Supplier<ActivityScenario<A>> scenarioSupplier;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public interface Supplier<T> {
        T get();
    }

    public ActivityScenarioRule(final Class<A> cls) {
        final int i = 0;
        this.scenarioSupplier = new Supplier() { // from class: androidx.test.ext.junit.rules.b
            @Override // androidx.test.ext.junit.rules.ActivityScenarioRule.Supplier
            public final Object get() {
                switch (i) {
                    case 0:
                        return ActivityScenarioRule.lambda$new$0((Class) cls);
                    default:
                        return ActivityScenarioRule.lambda$new$2((Intent) cls);
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ ActivityScenario lambda$new$0(Class cls) {
        return ActivityScenario.launch((Class) Checks.checkNotNull(cls));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ ActivityScenario lambda$new$1(Class cls, Bundle bundle) {
        return ActivityScenario.launch((Class) Checks.checkNotNull(cls), bundle);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ ActivityScenario lambda$new$2(Intent intent) {
        return ActivityScenario.launch((Intent) Checks.checkNotNull(intent));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ ActivityScenario lambda$new$3(Intent intent, Bundle bundle) {
        return ActivityScenario.launch((Intent) Checks.checkNotNull(intent), bundle);
    }

    @Override // org.junit.rules.ExternalResource
    public void after() {
        this.scenario.close();
    }

    @Override // org.junit.rules.ExternalResource
    public void before() {
        this.scenario = this.scenarioSupplier.get();
    }

    public ActivityScenario<A> getScenario() {
        return (ActivityScenario) Checks.checkNotNull(this.scenario);
    }

    public ActivityScenarioRule(final Class<A> cls, @Nullable final Bundle bundle) {
        final int i = 0;
        this.scenarioSupplier = new Supplier() { // from class: androidx.test.ext.junit.rules.a
            @Override // androidx.test.ext.junit.rules.ActivityScenarioRule.Supplier
            public final Object get() {
                switch (i) {
                    case 0:
                        return ActivityScenarioRule.lambda$new$1((Class) cls, bundle);
                    default:
                        return ActivityScenarioRule.lambda$new$3((Intent) cls, bundle);
                }
            }
        };
    }

    public ActivityScenarioRule(final Intent intent) {
        final int i = 1;
        this.scenarioSupplier = new Supplier() { // from class: androidx.test.ext.junit.rules.b
            @Override // androidx.test.ext.junit.rules.ActivityScenarioRule.Supplier
            public final Object get() {
                switch (i) {
                    case 0:
                        return ActivityScenarioRule.lambda$new$0((Class) intent);
                    default:
                        return ActivityScenarioRule.lambda$new$2((Intent) intent);
                }
            }
        };
    }

    public ActivityScenarioRule(final Intent intent, @Nullable final Bundle bundle) {
        final int i = 1;
        this.scenarioSupplier = new Supplier() { // from class: androidx.test.ext.junit.rules.a
            @Override // androidx.test.ext.junit.rules.ActivityScenarioRule.Supplier
            public final Object get() {
                switch (i) {
                    case 0:
                        return ActivityScenarioRule.lambda$new$1((Class) intent, bundle);
                    default:
                        return ActivityScenarioRule.lambda$new$3((Intent) intent, bundle);
                }
            }
        };
    }
}
