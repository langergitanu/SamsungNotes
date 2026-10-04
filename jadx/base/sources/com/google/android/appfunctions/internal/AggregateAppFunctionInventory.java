package com.google.android.appfunctions.internal;

import com.google.android.appfunctions.AppFunctionMetadata;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Function;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(m13885d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R-\u0010\u0006\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b\u0012\u0004\u0012\u00020\n0\u00078VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000b\u0010\f¨\u0006\u000f"}, m13886d2 = {"Lcom/google/android/appfunctions/internal/AggregateAppFunctionInventory;", "Lcom/google/android/appfunctions/internal/AppFunctionInventory;", "classRegistry", "Lcom/google/android/appfunctions/internal/ClassRegistry;", "<init>", "(Lcom/google/android/appfunctions/internal/ClassRegistry;)V", "functionToMetadataMap", "", "Lkotlin/Function;", "", "Lcom/google/android/appfunctions/AppFunctionMetadata;", "getFunctionToMetadataMap", "()Ljava/util/Map;", "functionToMetadataMap$delegate", "Lkotlin/Lazy;", "java.com.google.android.libraries.llm.appfunctions.appfunctions_appfunctions"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final class AggregateAppFunctionInventory implements AppFunctionInventory {

    @NotNull
    private final ClassRegistry<AppFunctionInventory> classRegistry;

    /* JADX INFO: renamed from: functionToMetadataMap$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy functionToMetadataMap;

    public AggregateAppFunctionInventory(@NotNull ClassRegistry<AppFunctionInventory> classRegistry) {
        Intrinsics.checkNotNullParameter(classRegistry, "classRegistry");
        this.classRegistry = classRegistry;
        this.functionToMetadataMap = LazyKt.lazy(new Function0<Map<Function<? extends Object>, ? extends AppFunctionMetadata>>() { // from class: com.google.android.appfunctions.internal.AggregateAppFunctionInventory$functionToMetadataMap$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Map<Function<? extends Object>, ? extends AppFunctionMetadata> invoke() {
                List registered = this.this$0.classRegistry.getRegistered();
                ArrayList arrayList = new ArrayList(CollectionsKt.m13952k(registered));
                Iterator it = registered.iterator();
                while (it.hasNext()) {
                    arrayList.add(((AppFunctionInventory) it.next()).getFunctionToMetadataMap());
                }
                Iterator it2 = arrayList.iterator();
                if (!it2.hasNext()) {
                    throw new UnsupportedOperationException("Empty collection can't be reduced.");
                }
                Object next = it2.next();
                while (it2.hasNext()) {
                    next = MapsKt.plus((Map) next, (Map) it2.next());
                }
                return (Map) next;
            }
        });
    }

    @Override // com.google.android.appfunctions.internal.AppFunctionInventory
    @NotNull
    public Map<Function<Object>, AppFunctionMetadata> getFunctionToMetadataMap() {
        return (Map) this.functionToMetadataMap.getValue();
    }
}
