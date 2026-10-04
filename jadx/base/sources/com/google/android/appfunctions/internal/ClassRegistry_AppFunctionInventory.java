package com.google.android.appfunctions.internal;

import androidx.compose.runtime.internal.StabilityInferred;
import appfunctions_aggregated_deps.C4163xedbaad8;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
@StabilityInferred(parameters = 0)
@Metadata(m13885d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0003\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004R\u001a\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, m13886d2 = {"Lcom/google/android/appfunctions/internal/ClassRegistry_AppFunctionInventory;", "Lcom/google/android/appfunctions/internal/ClassRegistry;", "Lcom/google/android/appfunctions/internal/AppFunctionInventory;", "<init>", "()V", "registered", "", "getRegistered", "()Ljava/util/List;", "notes-4.4.37.35_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class ClassRegistry_AppFunctionInventory implements ClassRegistry<AppFunctionInventory> {
    public static final int $stable = 8;

    @NotNull
    private final List<AppFunctionInventory> registered = CollectionsKt.listOf(new C4163xedbaad8());

    @Override // com.google.android.appfunctions.internal.ClassRegistry
    @NotNull
    public List<AppFunctionInventory> getRegistered() {
        return this.registered;
    }
}
