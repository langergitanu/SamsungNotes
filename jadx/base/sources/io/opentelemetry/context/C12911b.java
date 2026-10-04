package io.opentelemetry.context;

import io.opentelemetry.context.StrictContextStorage;
import java.util.function.Predicate;

/* JADX INFO: renamed from: io.opentelemetry.context.b */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public final /* synthetic */ class C12911b implements Predicate {
    @Override // java.util.function.Predicate
    public final boolean test(Object obj) {
        return StrictContextStorage.PendingScopes.lambda$drainPendingCallers$0((StrictContextStorage.CallerStackTrace) obj);
    }
}
