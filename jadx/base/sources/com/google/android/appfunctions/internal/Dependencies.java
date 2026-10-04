package com.google.android.appfunctions.internal;

import com.google.android.appfunctions.internal.utils.KClassUtil;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(m13885d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bB\u0007¢\u0006\u0004\b\u0002\u0010\u0003R'\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058BX\u0082\u0084\u0002¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u0012\u0004\b\u0007\u0010\u0003\u001a\u0004\b\b\u0010\tR'\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\u00058BX\u0082\u0084\u0002¢\u0006\u0012\n\u0004\b\u0010\u0010\u000b\u0012\u0004\b\u000e\u0010\u0003\u001a\u0004\b\u000f\u0010\tR\u001b\u0010\u0011\u001a\u00020\u00128@X\u0080\u0084\u0002¢\u0006\f\n\u0004\b\u0015\u0010\u000b\u001a\u0004\b\u0013\u0010\u0014R\u001b\u0010\u0016\u001a\u00020\u00178@X\u0080\u0084\u0002¢\u0006\f\n\u0004\b\u001a\u0010\u000b\u001a\u0004\b\u0018\u0010\u0019¨\u0006\u001c"}, m13886d2 = {"Lcom/google/android/appfunctions/internal/Dependencies;", "", "<init>", "()V", "appFunctionInventoryRegistry", "Lcom/google/android/appfunctions/internal/ClassRegistry;", "Lcom/google/android/appfunctions/internal/AppFunctionInventory;", "getAppFunctionInventoryRegistry$annotations", "getAppFunctionInventoryRegistry", "()Lcom/google/android/appfunctions/internal/ClassRegistry;", "appFunctionInventoryRegistry$delegate", "Lkotlin/Lazy;", "appFunctionInvokerRegistry", "Lcom/google/android/appfunctions/internal/AppFunctionInvoker;", "getAppFunctionInvokerRegistry$annotations", "getAppFunctionInvokerRegistry", "appFunctionInvokerRegistry$delegate", "aggregateAppFunctionInventory", "Lcom/google/android/appfunctions/internal/AggregateAppFunctionInventory;", "getAggregateAppFunctionInventory$java_com_google_android_libraries_llm_appfunctions_appfunctions_appfunctions", "()Lcom/google/android/appfunctions/internal/AggregateAppFunctionInventory;", "aggregateAppFunctionInventory$delegate", "aggregateAppFunctionInvoker", "Lcom/google/android/appfunctions/internal/AggregateAppFunctionInvoker;", "getAggregateAppFunctionInvoker$java_com_google_android_libraries_llm_appfunctions_appfunctions_appfunctions", "()Lcom/google/android/appfunctions/internal/AggregateAppFunctionInvoker;", "aggregateAppFunctionInvoker$delegate", "Companion", "java.com.google.android.libraries.llm.appfunctions.appfunctions_appfunctions"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final class Dependencies {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @Nullable
    private static volatile Dependencies instance;

    /* JADX INFO: renamed from: appFunctionInventoryRegistry$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy appFunctionInventoryRegistry = LazyKt.lazy(new Function0<ClassRegistry<AppFunctionInventory>>() { // from class: com.google.android.appfunctions.internal.Dependencies$appFunctionInventoryRegistry$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final ClassRegistry<AppFunctionInventory> invoke() {
            Object objFindImpl = KClassUtil.findImpl(ClassRegistry.class, "_AppFunctionInventory");
            Intrinsics.checkNotNull(objFindImpl, "null cannot be cast to non-null type com.google.android.appfunctions.internal.ClassRegistry<com.google.android.appfunctions.internal.AppFunctionInventory>");
            return (ClassRegistry) objFindImpl;
        }
    });

    /* JADX INFO: renamed from: appFunctionInvokerRegistry$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy appFunctionInvokerRegistry = LazyKt.lazy(new Function0<ClassRegistry<AppFunctionInvoker>>() { // from class: com.google.android.appfunctions.internal.Dependencies$appFunctionInvokerRegistry$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final ClassRegistry<AppFunctionInvoker> invoke() {
            Object objFindImpl = KClassUtil.findImpl(ClassRegistry.class, "_AppFunctionInvoker");
            Intrinsics.checkNotNull(objFindImpl, "null cannot be cast to non-null type com.google.android.appfunctions.internal.ClassRegistry<com.google.android.appfunctions.internal.AppFunctionInvoker>");
            return (ClassRegistry) objFindImpl;
        }
    });

    /* JADX INFO: renamed from: aggregateAppFunctionInventory$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy aggregateAppFunctionInventory = LazyKt.lazy(new Function0<AggregateAppFunctionInventory>() { // from class: com.google.android.appfunctions.internal.Dependencies$aggregateAppFunctionInventory$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final AggregateAppFunctionInventory invoke() {
            return new AggregateAppFunctionInventory(this.this$0.getAppFunctionInventoryRegistry());
        }
    });

    /* JADX INFO: renamed from: aggregateAppFunctionInvoker$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy aggregateAppFunctionInvoker = LazyKt.lazy(new Function0<AggregateAppFunctionInvoker>() { // from class: com.google.android.appfunctions.internal.Dependencies$aggregateAppFunctionInvoker$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final AggregateAppFunctionInvoker invoke() {
            return new AggregateAppFunctionInvoker(this.this$0.getAppFunctionInvokerRegistry());
        }
    });

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0006\u001a\u00020\u0005R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0007"}, m13886d2 = {"Lcom/google/android/appfunctions/internal/Dependencies$Companion;", "", "<init>", "()V", "instance", "Lcom/google/android/appfunctions/internal/Dependencies;", "getInstance", "java.com.google.android.libraries.llm.appfunctions.appfunctions_appfunctions"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    @SourceDebugExtension({"SMAP\nDependencies.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Dependencies.kt\ncom/google/android/appfunctions/internal/Dependencies$Companion\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,33:1\n1#2:34\n*E\n"})
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final Dependencies getInstance() {
            Dependencies dependencies;
            Dependencies dependencies2 = Dependencies.instance;
            if (dependencies2 != null) {
                return dependencies2;
            }
            synchronized (this) {
                dependencies = Dependencies.instance;
                if (dependencies == null) {
                    dependencies = new Dependencies();
                    Dependencies.instance = dependencies;
                }
            }
            return dependencies;
        }

        private Companion() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ClassRegistry<AppFunctionInventory> getAppFunctionInventoryRegistry() {
        return (ClassRegistry) this.appFunctionInventoryRegistry.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ClassRegistry<AppFunctionInvoker> getAppFunctionInvokerRegistry() {
        return (ClassRegistry) this.appFunctionInvokerRegistry.getValue();
    }

    @NotNull
    /* JADX INFO: renamed from: getAggregateAppFunctionInventory$java_com_google_android_libraries_llm_appfunctions_appfunctions_appfunctions */
    public final AggregateAppFunctionInventory m3125x9661cda5() {
        return (AggregateAppFunctionInventory) this.aggregateAppFunctionInventory.getValue();
    }

    @NotNull
    /* JADX INFO: renamed from: getAggregateAppFunctionInvoker$java_com_google_android_libraries_llm_appfunctions_appfunctions_appfunctions */
    public final AggregateAppFunctionInvoker m3126x5b5f78c7() {
        return (AggregateAppFunctionInvoker) this.aggregateAppFunctionInvoker.getValue();
    }

    private static /* synthetic */ void getAppFunctionInventoryRegistry$annotations() {
    }

    private static /* synthetic */ void getAppFunctionInvokerRegistry$annotations() {
    }
}
