package com.google.android.appfunctions.internal;

import androidx.appcompat.widget.AbstractC0541b;
import com.google.android.appfunctions.AppFunctionContext;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(m13885d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J6\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\b2\u0014\u0010\u0012\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\u0013H\u0096@¢\u0006\u0002\u0010\u0014R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R!\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00078VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\n¨\u0006\u0015"}, m13886d2 = {"Lcom/google/android/appfunctions/internal/AggregateAppFunctionInvoker;", "Lcom/google/android/appfunctions/internal/AppFunctionInvoker;", "classRegistry", "Lcom/google/android/appfunctions/internal/ClassRegistry;", "<init>", "(Lcom/google/android/appfunctions/internal/ClassRegistry;)V", "supportedFunctionIds", "", "", "getSupportedFunctionIds", "()Ljava/util/Set;", "supportedFunctionIds$delegate", "Lkotlin/Lazy;", "unsafeInvoke", "", "appFunctionContext", "Lcom/google/android/appfunctions/AppFunctionContext;", "functionIdentifier", "parameters", "", "(Lcom/google/android/appfunctions/AppFunctionContext;Ljava/lang/String;Ljava/util/Map;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "java.com.google.android.libraries.llm.appfunctions.appfunctions_appfunctions"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final class AggregateAppFunctionInvoker implements AppFunctionInvoker {

    @NotNull
    private final ClassRegistry<AppFunctionInvoker> classRegistry;

    /* JADX INFO: renamed from: supportedFunctionIds$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy supportedFunctionIds;

    public AggregateAppFunctionInvoker(@NotNull ClassRegistry<AppFunctionInvoker> classRegistry) {
        Intrinsics.checkNotNullParameter(classRegistry, "classRegistry");
        this.classRegistry = classRegistry;
        this.supportedFunctionIds = LazyKt.lazy(new Function0<Set<? extends String>>() { // from class: com.google.android.appfunctions.internal.AggregateAppFunctionInvoker$supportedFunctionIds$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Set<? extends String> invoke() {
                List registered = this.this$0.classRegistry.getRegistered();
                ArrayList arrayList = new ArrayList(CollectionsKt.m13952k(registered));
                Iterator it = registered.iterator();
                while (it.hasNext()) {
                    arrayList.add(((AppFunctionInvoker) it.next()).getSupportedFunctionIds());
                }
                Iterator it2 = arrayList.iterator();
                if (!it2.hasNext()) {
                    throw new UnsupportedOperationException("Empty collection can't be reduced.");
                }
                Object next = it2.next();
                while (it2.hasNext()) {
                    next = SetsKt.plus((Set) next, (Iterable) it2.next());
                }
                return (Set) next;
            }
        });
    }

    @Override // com.google.android.appfunctions.internal.AppFunctionInvoker
    @NotNull
    public Set<String> getSupportedFunctionIds() {
        return (Set) this.supportedFunctionIds.getValue();
    }

    @Override // com.google.android.appfunctions.internal.AppFunctionInvoker
    @Nullable
    public Object unsafeInvoke(@NotNull AppFunctionContext appFunctionContext, @NotNull String str, @NotNull Map<String, ? extends Object> map, @NotNull Continuation<Object> continuation) {
        for (AppFunctionInvoker appFunctionInvoker : this.classRegistry.getRegistered()) {
            if (appFunctionInvoker.getSupportedFunctionIds().contains(str)) {
                return appFunctionInvoker.unsafeInvoke(appFunctionContext, str, map, continuation);
            }
        }
        throw new IllegalArgumentException(AbstractC0541b.m773o("Function [", str, "] is not available."));
    }
}
