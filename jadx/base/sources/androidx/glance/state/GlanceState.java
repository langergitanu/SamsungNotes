package androidx.glance.state;

import android.content.Context;
import androidx.annotation.RestrictTo;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.datastore.core.DataStore;
import androidx.glance.oneui.common.GlanceLog;
import com.sun.imageio.plugins.jpeg.JPEG;
import java.io.File;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.sync.MutexKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@StabilityInferred(parameters = 0)
@Metadata(m13885d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J*\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\n\u0010\r\u001a\u0006\u0012\u0002\b\u00030\u000e2\u0006\u0010\u000f\u001a\u00020\u0005H\u0096@¢\u0006\u0002\u0010\u0010J8\u0010\u0011\u001a\b\u0012\u0004\u0012\u0002H\u00120\u0006\"\u0004\b\u0000\u0010\u00122\u0006\u0010\u000b\u001a\u00020\f2\f\u0010\r\u001a\b\u0012\u0004\u0012\u0002H\u00120\u000e2\u0006\u0010\u000f\u001a\u00020\u0005H\u0082@¢\u0006\u0002\u0010\u0010J2\u0010\u0013\u001a\u0002H\u0012\"\u0004\b\u0000\u0010\u00122\u0006\u0010\u000b\u001a\u00020\f2\f\u0010\r\u001a\b\u0012\u0004\u0012\u0002H\u00120\u000e2\u0006\u0010\u000f\u001a\u00020\u0005H\u0096@¢\u0006\u0002\u0010\u0010JV\u0010\u0014\u001a\u0002H\u0012\"\u0004\b\u0000\u0010\u00122\u0006\u0010\u000b\u001a\u00020\f2\f\u0010\r\u001a\b\u0012\u0004\u0012\u0002H\u00120\u000e2\u0006\u0010\u000f\u001a\u00020\u00052\"\u0010\u0015\u001a\u001e\b\u0001\u0012\u0004\u0012\u0002H\u0012\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00120\u0017\u0012\u0006\u0012\u0004\u0018\u00010\u00180\u0016H\u0096@¢\u0006\u0002\u0010\u0019R\u001e\u0010\u0003\u001a\u0012\u0012\u0004\u0012\u00020\u0005\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00060\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001a"}, m13886d2 = {"Landroidx/glance/state/GlanceState;", "Landroidx/glance/state/ConfigManager;", "()V", "dataStores", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Landroidx/datastore/core/DataStore;", "mutex", "Lkotlinx/coroutines/sync/Mutex;", "deleteStore", "", "context", "Landroid/content/Context;", "definition", "Landroidx/glance/state/GlanceStateDefinition;", "fileKey", "(Landroid/content/Context;Landroidx/glance/state/GlanceStateDefinition;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getDataStore", "T", "getValue", "updateValue", "updateBlock", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", "", "(Landroid/content/Context;Landroidx/glance/state/GlanceStateDefinition;Ljava/lang/String;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "glance_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
@SourceDebugExtension({"SMAP\nGlanceStateDefinition.kt\nKotlin\n*S Kotlin\n*F\n+ 1 GlanceStateDefinition.kt\nandroidx/glance/state/GlanceState\n+ 2 Mutex.kt\nkotlinx/coroutines/sync/MutexKt\n+ 3 CancellableContinuation.kt\nkotlinx/coroutines/CancellableContinuationKt\n+ 4 MapsJVM.kt\nkotlin/collections/MapsKt__MapsJVMKt\n+ 5 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,325:1\n120#2,8:326\n129#2:345\n120#2,8:346\n129#2:357\n314#3,11:334\n72#4,2:354\n1#5:356\n*S KotlinDebug\n*F\n+ 1 GlanceStateDefinition.kt\nandroidx/glance/state/GlanceState\n*L\n173#1:326,8\n173#1:345\n203#1:346,8\n203#1:357\n175#1:334,11\n211#1:354,2\n211#1:356\n*E\n"})
public final class GlanceState implements ConfigManager {

    @NotNull
    public static final GlanceState INSTANCE = new GlanceState();

    @NotNull
    private static final Mutex mutex = MutexKt.Mutex$default(false, 1, null);

    @NotNull
    private static final ConcurrentHashMap<String, DataStore<?>> dataStores = new ConcurrentHashMap<>();
    public static final int $stable = 8;

    /* JADX INFO: renamed from: androidx.glance.state.GlanceState$deleteStore$1 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13887k = 3, m13888mv = {1, 9, 0}, m13890xi = 48)
    @DebugMetadata(m14020c = "androidx.glance.state.GlanceState", m14021f = "GlanceStateDefinition.kt", m14022i = {0, 0, 0, 0, 1, 1, 1, 1, 1}, m14023l = {331, 334}, m14024m = "deleteStore", m14025n = {"context", "definition", "fileKey", "$this$withLock_u24default$iv", "context", "definition", "fileKey", "$this$withLock_u24default$iv", "$completion$iv"}, m14026s = {"L$0", "L$1", "L$2", "L$3", "L$0", "L$1", "L$2", "L$3", "L$4"})
    public static final class C35221 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        int label;
        /* synthetic */ Object result;

        public C35221(Continuation<? super C35221> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return GlanceState.this.deleteStore(null, null, null, this);
        }
    }

    /* JADX INFO: renamed from: androidx.glance.state.GlanceState$getDataStore$1 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13887k = 3, m13888mv = {1, 9, 0}, m13890xi = 48)
    @DebugMetadata(m14020c = "androidx.glance.state.GlanceState", m14021f = "GlanceStateDefinition.kt", m14022i = {0, 0, 0, 0, 1, 1, 1, 2, 2, 2}, m14023l = {331, 214, JPEG.SOI}, m14024m = "getDataStore", m14025n = {"context", "definition", "fileKey", "$this$withLock_u24default$iv", "fileKey", "$this$withLock_u24default$iv", "$this$getOrPut$iv", "fileKey", "$this$withLock_u24default$iv", "$this$getOrPut$iv"}, m14026s = {"L$0", "L$1", "L$2", "L$3", "L$0", "L$1", "L$2", "L$0", "L$1", "L$2"})
    public static final class C35231<T> extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        /* synthetic */ Object result;

        public C35231(Continuation<? super C35231> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return GlanceState.this.getDataStore(null, null, null, this);
        }
    }

    /* JADX INFO: renamed from: androidx.glance.state.GlanceState$getValue$1 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13887k = 3, m13888mv = {1, 9, 0}, m13890xi = 48)
    @DebugMetadata(m14020c = "androidx.glance.state.GlanceState", m14021f = "GlanceStateDefinition.kt", m14022i = {0, 0, 1, 1}, m14023l = {140, 140}, m14024m = "getValue", m14025n = {"definition", "fileKey", "definition", "fileKey"}, m14026s = {"L$0", "L$1", "L$0", "L$1"})
    public static final class C35241<T> extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        public C35241(Continuation<? super C35241> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return GlanceState.this.getValue(null, null, null, this);
        }
    }

    /* JADX INFO: renamed from: androidx.glance.state.GlanceState$updateValue$1 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13887k = 3, m13888mv = {1, 9, 0}, m13890xi = 48)
    @DebugMetadata(m14020c = "androidx.glance.state.GlanceState", m14021f = "GlanceStateDefinition.kt", m14022i = {0, 0, 0, 1, 1}, m14023l = {159, 159}, m14024m = "updateValue", m14025n = {"definition", "fileKey", "updateBlock", "definition", "fileKey"}, m14026s = {"L$0", "L$1", "L$2", "L$0", "L$1"})
    public static final class C35251<T> extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        public C35251(Continuation<? super C35251> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return GlanceState.this.updateValue(null, null, null, null, this);
        }
    }

    private GlanceState() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0107  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0108  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0019  */
    /* JADX WARN: Type inference failed for: r4v0, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r4v1 */
    /* JADX WARN: Type inference failed for: r4v18 */
    /* JADX WARN: Type inference failed for: r4v19 */
    /* JADX WARN: Type inference failed for: r4v2, types: [kotlinx.coroutines.sync.Mutex] */
    /* JADX WARN: Type inference failed for: r4v3 */
    /* JADX WARN: Type inference failed for: r4v4 */
    /* JADX WARN: Type inference failed for: r4v8, types: [kotlinx.coroutines.sync.Mutex] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final <T> Object getDataStore(Context context, GlanceStateDefinition<T> glanceStateDefinition, String str, Continuation<? super DataStore<T>> continuation) throws Throwable {
        C35231 c35231;
        GlanceStateDefinition glanceStateDefinition2;
        String str2;
        Context context2;
        Mutex mutex2;
        Object obj;
        Mutex mutex3;
        String str3;
        ConcurrentMap concurrentMap;
        Mutex mutex4;
        Mutex mutex5;
        Object objPutIfAbsent;
        if (continuation instanceof C35231) {
            c35231 = (C35231) continuation;
            int i = c35231.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c35231.label = i - Integer.MIN_VALUE;
            } else {
                c35231 = new C35231(continuation);
            }
        }
        Object dataStore = c35231.result;
        ?? coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = c35231.label;
        try {
        } catch (Throwable th) {
            th = th;
        }
        try {
            if (i2 == 0) {
                ResultKt.throwOnFailure(dataStore);
                Mutex mutex6 = mutex;
                c35231.L$0 = context;
                glanceStateDefinition2 = glanceStateDefinition;
                c35231.L$1 = glanceStateDefinition2;
                c35231.L$2 = str;
                c35231.L$3 = mutex6;
                c35231.label = 1;
                if (mutex6.lock(null, c35231) != coroutine_suspended) {
                    str2 = str;
                    context2 = context;
                    mutex2 = mutex6;
                }
                return coroutine_suspended;
            }
            if (i2 != 1) {
                if (i2 == 2) {
                    concurrentMap = (ConcurrentMap) c35231.L$2;
                    Mutex mutex7 = (Mutex) c35231.L$1;
                    str3 = (String) c35231.L$0;
                    ResultKt.throwOnFailure(dataStore);
                    mutex4 = mutex7;
                    obj = (DataStore) dataStore;
                    mutex5 = mutex4;
                    objPutIfAbsent = concurrentMap.putIfAbsent(str3, obj);
                    if (objPutIfAbsent != null) {
                    }
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type androidx.datastore.core.DataStore<T of androidx.glance.state.GlanceState.getDataStore$lambda$3>");
                    DataStore dataStore2 = (DataStore) obj;
                    coroutine_suspended.unlock(null);
                    return dataStore2;
                }
                if (i2 != 3) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                concurrentMap = (ConcurrentMap) c35231.L$2;
                Mutex mutex8 = (Mutex) c35231.L$1;
                str3 = (String) c35231.L$0;
                ResultKt.throwOnFailure(dataStore);
                mutex3 = mutex8;
                obj = (DataStore) dataStore;
                mutex5 = mutex3;
                objPutIfAbsent = concurrentMap.putIfAbsent(str3, obj);
                if (objPutIfAbsent != null) {
                    coroutine_suspended = mutex5;
                } else {
                    obj = objPutIfAbsent;
                    coroutine_suspended = mutex5;
                }
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type androidx.datastore.core.DataStore<T of androidx.glance.state.GlanceState.getDataStore$lambda$3>");
                DataStore dataStore22 = (DataStore) obj;
                coroutine_suspended.unlock(null);
                return dataStore22;
            }
            mutex2 = (Mutex) c35231.L$3;
            str2 = (String) c35231.L$2;
            glanceStateDefinition2 = (GlanceStateDefinition) c35231.L$1;
            context2 = (Context) c35231.L$0;
            ResultKt.throwOnFailure(dataStore);
            GlanceLog.Companion companion = GlanceLog.INSTANCE;
            ConcurrentHashMap<String, DataStore<?>> concurrentHashMap = dataStores;
            companion.m2301i("GWT:GlanceStateDefinition", "getDataStore: " + str2 + ", file exist: " + concurrentHashMap.keySet().contains(str2) + ", PreferenceStateDefinition type: " + (glanceStateDefinition2 instanceof PreferencesGlanceStateDefinition));
            obj = concurrentHashMap.get(str2);
            if (obj != null) {
                coroutine_suspended = mutex2;
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type androidx.datastore.core.DataStore<T of androidx.glance.state.GlanceState.getDataStore$lambda$3>");
                DataStore dataStore222 = (DataStore) obj;
                coroutine_suspended.unlock(null);
                return dataStore222;
            }
            if (glanceStateDefinition2 instanceof PreferencesGlanceStateDefinition) {
                c35231.L$0 = str2;
                c35231.L$1 = mutex2;
                c35231.L$2 = concurrentHashMap;
                c35231.L$3 = null;
                c35231.label = 2;
                dataStore = ((PreferencesGlanceStateDefinition) glanceStateDefinition2).getOrPutDataStore$glance_release(context2, str2, c35231);
                if (dataStore != coroutine_suspended) {
                    mutex4 = mutex2;
                    str3 = str2;
                    concurrentMap = concurrentHashMap;
                    obj = (DataStore) dataStore;
                    mutex5 = mutex4;
                    objPutIfAbsent = concurrentMap.putIfAbsent(str3, obj);
                    if (objPutIfAbsent != null) {
                    }
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type androidx.datastore.core.DataStore<T of androidx.glance.state.GlanceState.getDataStore$lambda$3>");
                    DataStore dataStore2222 = (DataStore) obj;
                    coroutine_suspended.unlock(null);
                    return dataStore2222;
                }
            } else {
                c35231.L$0 = str2;
                c35231.L$1 = mutex2;
                c35231.L$2 = concurrentHashMap;
                c35231.L$3 = null;
                c35231.label = 3;
                dataStore = glanceStateDefinition2.getDataStore(context2, str2, c35231);
                if (dataStore != coroutine_suspended) {
                    mutex3 = mutex2;
                    str3 = str2;
                    concurrentMap = concurrentHashMap;
                    obj = (DataStore) dataStore;
                    mutex5 = mutex3;
                    objPutIfAbsent = concurrentMap.putIfAbsent(str3, obj);
                    if (objPutIfAbsent != null) {
                    }
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type androidx.datastore.core.DataStore<T of androidx.glance.state.GlanceState.getDataStore$lambda$3>");
                    DataStore dataStore22222 = (DataStore) obj;
                    coroutine_suspended.unlock(null);
                    return dataStore22222;
                }
            }
            return coroutine_suspended;
        } catch (Throwable th2) {
            th = th2;
            coroutine_suspended = mutex2;
            coroutine_suspended.unlock(null);
            throw th;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // androidx.glance.state.ConfigManager
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object deleteStore(@NotNull Context context, @NotNull GlanceStateDefinition<?> glanceStateDefinition, @NotNull String str, @NotNull Continuation<? super Unit> continuation) throws Throwable {
        C35221 c35221;
        Mutex mutex2;
        Mutex mutex3;
        if (continuation instanceof C35221) {
            c35221 = (C35221) continuation;
            int i = c35221.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c35221.label = i - Integer.MIN_VALUE;
            } else {
                c35221 = new C35221(continuation);
            }
        }
        Object obj = c35221.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = c35221.label;
        try {
            if (i2 == 0) {
                ResultKt.throwOnFailure(obj);
                mutex2 = mutex;
                c35221.L$0 = context;
                c35221.L$1 = glanceStateDefinition;
                c35221.L$2 = str;
                c35221.L$3 = mutex2;
                c35221.label = 1;
                if (mutex2.lock(null, c35221) != coroutine_suspended) {
                }
                return coroutine_suspended;
            }
            if (i2 != 1) {
                if (i2 != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                mutex3 = (Mutex) c35221.L$3;
                try {
                    ResultKt.throwOnFailure(obj);
                    Unit unit = Unit.INSTANCE;
                    mutex3.unlock(null);
                    return Unit.INSTANCE;
                } catch (Throwable th) {
                    th = th;
                    mutex3.unlock(null);
                    throw th;
                }
            }
            Mutex mutex4 = (Mutex) c35221.L$3;
            str = (String) c35221.L$2;
            glanceStateDefinition = (GlanceStateDefinition) c35221.L$1;
            Context context2 = (Context) c35221.L$0;
            ResultKt.throwOnFailure(obj);
            mutex2 = mutex4;
            context = context2;
            c35221.L$0 = context;
            c35221.L$1 = glanceStateDefinition;
            c35221.L$2 = str;
            c35221.L$3 = mutex2;
            c35221.L$4 = c35221;
            c35221.label = 2;
            final CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(c35221), 1);
            cancellableContinuationImpl.initCancellability();
            dataStores.remove(str);
            File location = glanceStateDefinition.getLocation(context, str);
            cancellableContinuationImpl.invokeOnCancellation(new Function1<Throwable, Unit>() { // from class: androidx.glance.state.GlanceState$deleteStore$2$1$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Throwable th2) {
                    invoke2(th2);
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@Nullable Throwable th2) {
                    GlanceLog.INSTANCE.m2297d("GWT:GlanceStateDefinition", "Exception " + th2 + " at deleteStore");
                    CancellableContinuation<Unit> cancellableContinuation = cancellableContinuationImpl;
                    Result.Companion companion = Result.INSTANCE;
                    cancellableContinuation.resumeWith(Result.m22215constructorimpl(Unit.INSTANCE));
                }
            });
            location.delete();
            GlanceLog.INSTANCE.m2297d("GWT:GlanceStateDefinition", str + " State is deleted");
            if (glanceStateDefinition instanceof PreferencesGlanceStateDefinition) {
                ((PreferencesGlanceStateDefinition) glanceStateDefinition).cancelCoroutine$glance_release(context, str);
            }
            Result.Companion companion = Result.INSTANCE;
            cancellableContinuationImpl.resumeWith(Result.m22215constructorimpl(Unit.INSTANCE));
            Object result = cancellableContinuationImpl.getResult();
            if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                DebugProbesKt.probeCoroutineSuspended(c35221);
            }
            if (result != coroutine_suspended) {
                mutex3 = mutex2;
                Unit unit2 = Unit.INSTANCE;
                mutex3.unlock(null);
                return Unit.INSTANCE;
            }
            return coroutine_suspended;
        } catch (Throwable th2) {
            th = th2;
            mutex3 = mutex2;
            mutex3.unlock(null);
            throw th;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // androidx.glance.state.ConfigManager
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public <T> Object getValue(@NotNull Context context, @NotNull GlanceStateDefinition<T> glanceStateDefinition, @NotNull String str, @NotNull Continuation<? super T> continuation) throws Throwable {
        C35241 c35241;
        if (continuation instanceof C35241) {
            c35241 = (C35241) continuation;
            int i = c35241.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c35241.label = i - Integer.MIN_VALUE;
            } else {
                c35241 = new C35241(continuation);
            }
        }
        Object dataStore = c35241.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = c35241.label;
        try {
            if (i2 == 0) {
                ResultKt.throwOnFailure(dataStore);
                c35241.L$0 = glanceStateDefinition;
                c35241.L$1 = str;
                c35241.label = 1;
                dataStore = getDataStore(context, glanceStateDefinition, str, c35241);
                if (dataStore == coroutine_suspended) {
                }
            }
            if (i2 != 1) {
                if (i2 != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(dataStore);
                return dataStore;
            }
            str = (String) c35241.L$1;
            glanceStateDefinition = (GlanceStateDefinition) c35241.L$0;
            ResultKt.throwOnFailure(dataStore);
            Flow<T> data = ((DataStore) dataStore).getData();
            c35241.L$0 = glanceStateDefinition;
            c35241.L$1 = str;
            c35241.label = 2;
            Object objFirst = FlowKt.first(data, c35241);
            return objFirst == coroutine_suspended ? coroutine_suspended : objFirst;
        } catch (Exception e) {
            GlanceLog.INSTANCE.m2297d("GWT:GlanceStateDefinition", "Error " + e + " occurred while reading data from " + str + " DataStore");
            return glanceStateDefinition.getDefaultState();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0016  */
    @Override // androidx.glance.state.ConfigManager
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public <T> Object updateValue(@NotNull Context context, @NotNull GlanceStateDefinition<T> glanceStateDefinition, @NotNull String str, @NotNull Function2<? super T, ? super Continuation<? super T>, ? extends Object> function2, @NotNull Continuation<? super T> continuation) throws Throwable {
        C35251 c35251;
        if (continuation instanceof C35251) {
            c35251 = (C35251) continuation;
            int i = c35251.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c35251.label = i - Integer.MIN_VALUE;
            } else {
                c35251 = new C35251(continuation);
            }
        }
        Object dataStore = c35251.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = c35251.label;
        try {
            if (i2 == 0) {
                ResultKt.throwOnFailure(dataStore);
                GlanceLog.INSTANCE.m2297d("GWT:GlanceStateDefinition", "updateValue " + glanceStateDefinition + " " + str);
                c35251.L$0 = glanceStateDefinition;
                c35251.L$1 = str;
                c35251.L$2 = function2;
                c35251.label = 1;
                dataStore = getDataStore(context, glanceStateDefinition, str, c35251);
                if (dataStore == coroutine_suspended) {
                }
            }
            if (i2 != 1) {
                if (i2 != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(dataStore);
                return dataStore;
            }
            function2 = (Function2) c35251.L$2;
            str = (String) c35251.L$1;
            glanceStateDefinition = (GlanceStateDefinition) c35251.L$0;
            ResultKt.throwOnFailure(dataStore);
            c35251.L$0 = glanceStateDefinition;
            c35251.L$1 = str;
            c35251.L$2 = null;
            c35251.label = 2;
            Object objUpdateData = ((DataStore) dataStore).updateData(function2, c35251);
            return objUpdateData == coroutine_suspended ? coroutine_suspended : objUpdateData;
        } catch (Exception e) {
            GlanceLog.INSTANCE.m2297d("GWT:GlanceStateDefinition", "Error " + e + " occurred while update data from " + str + " DataStore");
            return glanceStateDefinition.getDefaultState();
        }
    }
}
