package com.samsung.android.vexfwk.sdk.common;

import android.util.Log;
import com.samsung.android.scs.p140ai.sdkcommon.image.ImageConst;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import com.samsung.android.vexfwk.metadata.VexFwkMetadataKey;
import com.samsung.android.vexfwk.sdk.common.runtime.VexFwkProvider;
import com.samsung.android.vexfwk.sdk.common.runtime.VexFwkSession;
import com.samsung.android.vexfwk.sdk.common.runtime.VexFwkSessionConfigRequest;
import com.samsung.android.vexfwk.session.VexFwkUsecase;
import java.util.Collection;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.BuildersKt__BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.ExecutorsKt;
import kotlinx.coroutines.Job;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m13885d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b&\u0018\u0000 !2\u00020\u0001:\u0002!\"B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0013\u001a\u00020\u0014J\b\u0010\u0015\u001a\u00020\u0014H\u0016J)\u0010\u0016\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\b2\u0017\u0010\u0018\u001a\u0013\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u00140\u0019¢\u0006\u0002\b\u001bH\u0004J\u0010\u0010\u001c\u001a\u00020\t2\u0006\u0010\u0017\u001a\u00020\bH\u0004J0\u0010\u001d\u001a\u0002H\u001e\"\u0004\b\u0000\u0010\u001e*\u0002H\u001e2\u0017\u0010\u001f\u001a\u0013\u0012\u0004\u0012\u0002H\u001e\u0012\u0004\u0012\u00020\u00140\u0019¢\u0006\u0002\b\u001bH\u0004¢\u0006\u0002\u0010 R\u0016\u0010\u0003\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R$\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u000b8F@BX\u0086\u000e¢\u0006\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0011\u001a\u0010\u0012\f\u0012\n \u0012*\u0004\u0018\u00010\u000b0\u000b0\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006#"}, m13886d2 = {"Lcom/samsung/android/vexfwk/sdk/common/VexFwkSdkBase;", "Ljava/lang/AutoCloseable;", "()V", "awaitJob", "Ljava/util/concurrent/atomic/AtomicReference;", "Lkotlinx/coroutines/Job;", "sessionMap", "Ljava/util/concurrent/ConcurrentHashMap;", "Lcom/samsung/android/vexfwk/session/VexFwkUsecase;", "Lcom/samsung/android/vexfwk/sdk/common/runtime/VexFwkSession;", "value", "Lcom/samsung/android/vexfwk/sdk/common/VexFwkSdkBase$State;", "state", "getState", "()Lcom/samsung/android/vexfwk/sdk/common/VexFwkSdkBase$State;", "setState", "(Lcom/samsung/android/vexfwk/sdk/common/VexFwkSdkBase$State;)V", "stateAtomic", "kotlin.jvm.PlatformType", "awaitConfiguration", "", "close", ImageConst.ImageUpscaleConst.ARG_CREATE_SESSION, "usecase", "onConfigureSession", "Lkotlin/Function1;", "Lcom/samsung/android/vexfwk/sdk/common/runtime/VexFwkSessionConfigRequest$Builder;", "Lkotlin/ExtensionFunctionType;", "getSession", "configureWith", "T", "onConfigure", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "Companion", "State", "vexfwk_sdk_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nVexFwkSdkBase.kt\nKotlin\n*S Kotlin\n*F\n+ 1 VexFwkSdkBase.kt\ncom/samsung/android/vexfwk/sdk/common/VexFwkSdkBase\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,147:1\n1#2:148\n1855#3,2:149\n*S KotlinDebug\n*F\n+ 1 VexFwkSdkBase.kt\ncom/samsung/android/vexfwk/sdk/common/VexFwkSdkBase\n*L\n133#1:149,2\n*E\n"})
public abstract class VexFwkSdkBase implements AutoCloseable {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    private static final String TAG = "VexFwkSdkBase";

    @NotNull
    private final AtomicReference<State> stateAtomic = new AtomicReference<>(State.IDLE);

    @NotNull
    private final ConcurrentHashMap<VexFwkUsecase, VexFwkSession> sessionMap = new ConcurrentHashMap<>();

    @NotNull
    private AtomicReference<Job> awaitJob = new AtomicReference<>(null);

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0007R\u0016\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, m13886d2 = {"Lcom/samsung/android/vexfwk/sdk/common/VexFwkSdkBase$Companion;", "", "()V", SearchConstants.TargetContents.TAG, "", "kotlin.jvm.PlatformType", "isAvailable", "", "usecase", "Lcom/samsung/android/vexfwk/session/VexFwkUsecase;", "vexfwk_sdk_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
    @SourceDebugExtension({"SMAP\nVexFwkSdkBase.kt\nKotlin\n*S Kotlin\n*F\n+ 1 VexFwkSdkBase.kt\ncom/samsung/android/vexfwk/sdk/common/VexFwkSdkBase$Companion\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,147:1\n1#2:148\n*E\n"})
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final boolean isAvailable(@NotNull VexFwkUsecase usecase) {
            Object objM22215constructorimpl;
            Intrinsics.checkNotNullParameter(usecase, "usecase");
            try {
                Result.Companion companion = Result.INSTANCE;
                Boolean bool = (Boolean) VexFwkProvider.INSTANCE.fetchProperties(usecase).get(VexFwkMetadataKey.PROPERTY_IS_AVAILABLE.INSTANCE);
                objM22215constructorimpl = Result.m22215constructorimpl(Boolean.valueOf(bool != null ? bool.booleanValue() : false));
            } catch (Throwable th) {
                Result.Companion companion2 = Result.INSTANCE;
                objM22215constructorimpl = Result.m22215constructorimpl(ResultKt.createFailure(th));
            }
            Throwable thM22218exceptionOrNullimpl = Result.m22218exceptionOrNullimpl(objM22215constructorimpl);
            if (thM22218exceptionOrNullimpl != null) {
                Log.w(VexFwkSdkBase.TAG, "isAvailable : failed to fetch properties, maybe vexfwk is not supported on the device : " + usecase, thM22218exceptionOrNullimpl);
                objM22215constructorimpl = Boolean.FALSE;
            }
            Boolean bool2 = (Boolean) objM22215constructorimpl;
            boolean zBooleanValue = bool2.booleanValue();
            Log.d(VexFwkSdkBase.TAG, "isAvailable : " + usecase + " -> " + zBooleanValue);
            return bool2.booleanValue();
        }

        private Companion() {
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, m13886d2 = {"Lcom/samsung/android/vexfwk/sdk/common/VexFwkSdkBase$State;", "", "(Ljava/lang/String;I)V", "IDLE", "CONFIGURING", "CONFIGURE_SUCCEEDED", "CONFIGURE_FAILED", "CLOSED", "vexfwk_sdk_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
    public static final class State {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ State[] $VALUES;
        public static final State IDLE = new State("IDLE", 0);
        public static final State CONFIGURING = new State("CONFIGURING", 1);
        public static final State CONFIGURE_SUCCEEDED = new State("CONFIGURE_SUCCEEDED", 2);
        public static final State CONFIGURE_FAILED = new State("CONFIGURE_FAILED", 3);
        public static final State CLOSED = new State("CLOSED", 4);

        private static final /* synthetic */ State[] $values() {
            return new State[]{IDLE, CONFIGURING, CONFIGURE_SUCCEEDED, CONFIGURE_FAILED, CLOSED};
        }

        static {
            State[] stateArr$values = $values();
            $VALUES = stateArr$values;
            $ENTRIES = EnumEntriesKt.enumEntries(stateArr$values);
        }

        private State(String str, int i) {
        }

        @NotNull
        public static EnumEntries<State> getEntries() {
            return $ENTRIES;
        }

        public static State valueOf(String str) {
            return (State) Enum.valueOf(State.class, str);
        }

        public static State[] values() {
            return (State[]) $VALUES.clone();
        }
    }

    /* JADX INFO: renamed from: com.samsung.android.vexfwk.sdk.common.VexFwkSdkBase$configureWith$1 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u0003H\u008a@"}, m13886d2 = {"<anonymous>", "Lkotlinx/coroutines/Job;", "T", "Lkotlinx/coroutines/CoroutineScope;"}, m13887k = 3, m13888mv = {1, 9, 0}, m13890xi = 48)
    @DebugMetadata(m14020c = "com.samsung.android.vexfwk.sdk.common.VexFwkSdkBase$configureWith$1", m14021f = "VexFwkSdkBase.kt", m14022i = {}, m14023l = {}, m14024m = "invokeSuspend", m14025n = {}, m14026s = {})
    @SourceDebugExtension({"SMAP\nVexFwkSdkBase.kt\nKotlin\n*S Kotlin\n*F\n+ 1 VexFwkSdkBase.kt\ncom/samsung/android/vexfwk/sdk/common/VexFwkSdkBase$configureWith$1\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,147:1\n1#2:148\n*E\n"})
    public static final class C115721 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Job>, Object> {
        final /* synthetic */ Function1<T, Unit> $onConfigure;
        final /* synthetic */ T $this_configureWith;
        int label;
        final /* synthetic */ VexFwkSdkBase this$0;

        /* JADX INFO: renamed from: com.samsung.android.vexfwk.sdk.common.VexFwkSdkBase$configureWith$1$1, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        @Metadata(m13885d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u0003H\u008a@"}, m13886d2 = {"<anonymous>", "", "T", "Lkotlinx/coroutines/CoroutineScope;"}, m13887k = 3, m13888mv = {1, 9, 0}, m13890xi = 48)
        @DebugMetadata(m14020c = "com.samsung.android.vexfwk.sdk.common.VexFwkSdkBase$configureWith$1$1", m14021f = "VexFwkSdkBase.kt", m14022i = {}, m14023l = {}, m14024m = "invokeSuspend", m14025n = {}, m14026s = {})
        @SourceDebugExtension({"SMAP\nVexFwkSdkBase.kt\nKotlin\n*S Kotlin\n*F\n+ 1 VexFwkSdkBase.kt\ncom/samsung/android/vexfwk/sdk/common/VexFwkSdkBase$configureWith$1$1\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,147:1\n1#2:148\n*E\n"})
        public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ Function1<T, Unit> $onConfigure;
            final /* synthetic */ T $this_configureWith;
            private /* synthetic */ Object L$0;
            int label;
            final /* synthetic */ VexFwkSdkBase this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            public AnonymousClass1(Function1<? super T, Unit> function1, T t, VexFwkSdkBase vexFwkSdkBase, Continuation<? super AnonymousClass1> continuation) {
                super(2, continuation);
                this.$onConfigure = function1;
                this.$this_configureWith = t;
                this.this$0 = vexFwkSdkBase;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @NotNull
            public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$onConfigure, this.$this_configureWith, this.this$0, continuation);
                anonymousClass1.L$0 = obj;
                return anonymousClass1;
            }

            /* JADX WARN: Type inference fix 'apply assigned field type' failed
            java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
            	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
            	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
            	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
             */
            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @Nullable
            public final Object invokeSuspend(@NotNull Object obj) {
                Object objM22215constructorimpl;
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                Function1<T, Unit> function1 = this.$onConfigure;
                T t = this.$this_configureWith;
                try {
                    Result.Companion companion = Result.INSTANCE;
                    function1.invoke(t);
                    objM22215constructorimpl = Result.m22215constructorimpl(Unit.INSTANCE);
                } catch (Throwable th) {
                    Result.Companion companion2 = Result.INSTANCE;
                    objM22215constructorimpl = Result.m22215constructorimpl(ResultKt.createFailure(th));
                }
                VexFwkSdkBase vexFwkSdkBase = this.this$0;
                if (Result.m22222isSuccessimpl(objM22215constructorimpl)) {
                    if (vexFwkSdkBase.getState() == State.CONFIGURING) {
                        vexFwkSdkBase.setState(State.CONFIGURE_SUCCEEDED);
                    }
                }
                VexFwkSdkBase vexFwkSdkBase2 = this.this$0;
                Throwable thM22218exceptionOrNullimpl = Result.m22218exceptionOrNullimpl(objM22215constructorimpl);
                if (thM22218exceptionOrNullimpl != null) {
                    Log.e(VexFwkSdkBase.TAG, "configure failed", thM22218exceptionOrNullimpl);
                    vexFwkSdkBase2.setState(State.CONFIGURE_FAILED);
                }
                return Unit.INSTANCE;
            }

            @Override // kotlin.jvm.functions.Function2
            @Nullable
            public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
                return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public C115721(Function1<? super T, Unit> function1, T t, VexFwkSdkBase vexFwkSdkBase, Continuation<? super C115721> continuation) {
            super(2, continuation);
            this.$onConfigure = function1;
            this.$this_configureWith = t;
            this.this$0 = vexFwkSdkBase;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return new C115721(this.$onConfigure, this.$this_configureWith, this.this$0, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            ExecutorService executorServiceNewFixedThreadPool = Executors.newFixedThreadPool(1);
            Intrinsics.checkNotNullExpressionValue(executorServiceNewFixedThreadPool, "newFixedThreadPool(...)");
            Job jobLaunch$default = BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(ExecutorsKt.from(executorServiceNewFixedThreadPool)), null, null, new AnonymousClass1(this.$onConfigure, this.$this_configureWith, this.this$0, null), 3, null);
            this.this$0.awaitJob.set(jobLaunch$default);
            jobLaunch$default.start();
            return jobLaunch$default;
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Job> continuation) {
            return ((C115721) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    public VexFwkSdkBase() {
        Log.i(TAG, "VexFwkSdk is created : version(1.0.21)");
    }

    @JvmStatic
    public static final boolean isAvailable(@NotNull VexFwkUsecase vexFwkUsecase) {
        return INSTANCE.isAvailable(vexFwkUsecase);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setState(State state) {
        this.stateAtomic.set(state);
    }

    public final void awaitConfiguration() {
        Job job = this.awaitJob.get();
        if (job != null) {
            BuildersKt__BuildersKt.runBlocking$default(null, new VexFwkSdkBase$awaitConfiguration$1$1(job, null), 1, null);
            this.awaitJob.set(null);
        }
    }

    @Override // java.lang.AutoCloseable
    public synchronized void close() {
        try {
            Log.d(TAG, "close E");
            if ((getState() != State.IDLE) & (getState() != State.CLOSED)) {
                awaitConfiguration();
                Collection<VexFwkSession> collectionValues = this.sessionMap.values();
                Intrinsics.checkNotNullExpressionValue(collectionValues, "<get-values>(...)");
                for (VexFwkSession vexFwkSession : collectionValues) {
                    Log.d(TAG, "close session : usecase(" + vexFwkSession + ")");
                    vexFwkSession.flush();
                    vexFwkSession.close();
                }
                this.sessionMap.clear();
                setState(State.CLOSED);
            }
            Log.d(TAG, "close X");
        } catch (Throwable th) {
            throw th;
        }
    }

    public final <T> T configureWith(T t, @NotNull Function1<? super T, Unit> onConfigure) {
        Intrinsics.checkNotNullParameter(onConfigure, "onConfigure");
        String str = TAG;
        Log.d(str, "configureWith E");
        if (getState() == State.IDLE) {
            setState(State.CONFIGURING);
            BuildersKt__BuildersKt.runBlocking$default(null, new C115721(onConfigure, t, this, null), 1, null);
        }
        Log.d(str, "configureWith X");
        return t;
    }

    public final void createSession(@NotNull VexFwkUsecase usecase, @NotNull Function1<? super VexFwkSessionConfigRequest.Builder, Unit> onConfigureSession) {
        Object objM22215constructorimpl;
        Object objM22215constructorimpl2;
        Intrinsics.checkNotNullParameter(usecase, "usecase");
        Intrinsics.checkNotNullParameter(onConfigureSession, "onConfigureSession");
        try {
            Result.Companion companion = Result.INSTANCE;
            VexFwkSession vexFwkSessionRemove = this.sessionMap.remove(usecase);
            if (vexFwkSessionRemove != null) {
                Log.w(TAG, "createSession : remove old session with usecase(" + usecase + ")");
                vexFwkSessionRemove.close();
            }
            VexFwkSession vexFwkSession = new VexFwkSession();
            try {
                VexFwkSessionConfigRequest.Builder builder = new VexFwkSessionConfigRequest.Builder(usecase);
                onConfigureSession.invoke(builder);
                VexFwkSessionConfigRequest vexFwkSessionConfigRequestBuild = builder.build();
                vexFwkSession.configure(vexFwkSessionConfigRequestBuild);
                objM22215constructorimpl2 = Result.m22215constructorimpl(vexFwkSessionConfigRequestBuild);
            } catch (Throwable th) {
                Result.Companion companion2 = Result.INSTANCE;
                objM22215constructorimpl2 = Result.m22215constructorimpl(ResultKt.createFailure(th));
            }
            if (Result.m22222isSuccessimpl(objM22215constructorimpl2)) {
                this.sessionMap.put(usecase, vexFwkSession);
            }
            if (Result.m22218exceptionOrNullimpl(objM22215constructorimpl2) != null) {
                vexFwkSession.close();
            }
            ResultKt.throwOnFailure(objM22215constructorimpl2);
            objM22215constructorimpl = Result.m22215constructorimpl((VexFwkSessionConfigRequest) objM22215constructorimpl2);
        } catch (Throwable th2) {
            Result.Companion companion3 = Result.INSTANCE;
            objM22215constructorimpl = Result.m22215constructorimpl(ResultKt.createFailure(th2));
        }
        Throwable thM22218exceptionOrNullimpl = Result.m22218exceptionOrNullimpl(objM22215constructorimpl);
        if (thM22218exceptionOrNullimpl != null) {
            Log.e(TAG, "createSession : failed to create session with usecase(" + usecase + ")", thM22218exceptionOrNullimpl);
            setState(State.CONFIGURE_FAILED);
        }
    }

    @NotNull
    public final VexFwkSession getSession(@NotNull VexFwkUsecase usecase) {
        Intrinsics.checkNotNullParameter(usecase, "usecase");
        awaitConfiguration();
        Unit unit = Unit.INSTANCE;
        VexFwkSession vexFwkSession = this.sessionMap.get(usecase);
        if (vexFwkSession != null) {
            return vexFwkSession;
        }
        throw new IllegalArgumentException("no session with usecase(" + usecase + ")");
    }

    @NotNull
    public final State getState() {
        State state = this.stateAtomic.get();
        Intrinsics.checkNotNullExpressionValue(state, "get(...)");
        return state;
    }
}
