package androidx.compose.foundation.gestures;

import androidx.compose.p109ui.input.pointer.AwaitPointerEventScope;
import androidx.compose.p109ui.input.pointer.PointerEvent;
import androidx.compose.p109ui.input.pointer.PointerEventPass;
import androidx.compose.p109ui.input.pointer.PointerInputChange;
import androidx.compose.p109ui.input.pointer.PointerInputScope;
import java.util.List;
import java.util.concurrent.CancellationException;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.JobKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m13885d1 = {"\u0000.\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0000\u001a\u0012\u0010\u0003\u001a\u00020\u0004*\u00020\u0002H\u0080@¢\u0006\u0002\u0010\u0005\u001a\u0012\u0010\u0003\u001a\u00020\u0004*\u00020\u0006H\u0080@¢\u0006\u0002\u0010\u0007\u001a;\u0010\b\u001a\u00020\u0004*\u00020\u00062'\u0010\t\u001a#\b\u0001\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u000b\u0012\u0006\u0012\u0004\u0018\u00010\f0\n¢\u0006\u0002\b\rH\u0086@¢\u0006\u0002\u0010\u000e\u001a;\u0010\u000f\u001a\u00020\u0004*\u00020\u00062'\u0010\t\u001a#\b\u0001\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u000b\u0012\u0006\u0012\u0004\u0018\u00010\f0\n¢\u0006\u0002\b\rH\u0087@¢\u0006\u0002\u0010\u000e¨\u0006\u0010"}, m13886d2 = {"allPointersUp", "", "Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;", "awaitAllPointersUp", "", "(Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Landroidx/compose/ui/input/pointer/PointerInputScope;", "(Landroidx/compose/ui/input/pointer/PointerInputScope;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "awaitEachGesture", "block", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", "", "Lkotlin/ExtensionFunctionType;", "(Landroidx/compose/ui/input/pointer/PointerInputScope;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "forEachGesture", "foundation_release"}, m13887k = 2, m13888mv = {1, 8, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nForEachGesture.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ForEachGesture.kt\nandroidx/compose/foundation/gestures/ForEachGestureKt\n+ 2 CoroutineScope.kt\nkotlinx/coroutines/CoroutineScopeKt\n+ 3 ListUtils.kt\nandroidx/compose/ui/util/ListUtilsKt\n*L\n1#1,122:1\n329#2:123\n329#2:142\n101#3,2:124\n33#3,6:126\n103#3:132\n101#3,2:133\n33#3,6:135\n103#3:141\n*S KotlinDebug\n*F\n+ 1 ForEachGesture.kt\nandroidx/compose/foundation/gestures/ForEachGestureKt\n*L\n45#1:123\n100#1:142\n71#1:124,2\n71#1:126,6\n71#1:132\n87#1:133,2\n87#1:135,6\n87#1:141\n*E\n"})
public final class ForEachGestureKt {

    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.ForEachGestureKt$awaitAllPointersUp$2 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m13886d2 = {"<anonymous>", "", "Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;"}, m13887k = 3, m13888mv = {1, 8, 0}, m13890xi = 48)
    @DebugMetadata(m14020c = "androidx.compose.foundation.gestures.ForEachGestureKt$awaitAllPointersUp$2", m14021f = "ForEachGesture.kt", m14022i = {}, m14023l = {77}, m14024m = "invokeSuspend", m14025n = {}, m14026s = {})
    public static final class C08962 extends RestrictedSuspendLambda implements Function2<AwaitPointerEventScope, Continuation<? super Unit>, Object> {
        private /* synthetic */ Object L$0;
        int label;

        public C08962(Continuation<? super C08962> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            C08962 c08962 = new C08962(continuation);
            c08962.L$0 = obj;
            return c08962;
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        public final Object invoke(@NotNull AwaitPointerEventScope awaitPointerEventScope, @Nullable Continuation<? super Unit> continuation) {
            return ((C08962) create(awaitPointerEventScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                AwaitPointerEventScope awaitPointerEventScope = (AwaitPointerEventScope) this.L$0;
                this.label = 1;
                if (ForEachGestureKt.awaitAllPointersUp(awaitPointerEventScope, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.ForEachGestureKt$awaitAllPointersUp$3 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13887k = 3, m13888mv = {1, 8, 0}, m13890xi = 48)
    @DebugMetadata(m14020c = "androidx.compose.foundation.gestures.ForEachGestureKt", m14021f = "ForEachGesture.kt", m14022i = {0}, m14023l = {86}, m14024m = "awaitAllPointersUp", m14025n = {"$this$awaitAllPointersUp"}, m14026s = {"L$0"})
    public static final class C08973 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        public C08973(Continuation<? super C08973> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ForEachGestureKt.awaitAllPointersUp((AwaitPointerEventScope) null, this);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.ForEachGestureKt$awaitEachGesture$2 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m13886d2 = {"<anonymous>", "", "Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;"}, m13887k = 3, m13888mv = {1, 8, 0}, m13890xi = 48)
    @DebugMetadata(m14020c = "androidx.compose.foundation.gestures.ForEachGestureKt$awaitEachGesture$2", m14021f = "ForEachGesture.kt", m14022i = {0, 1, 2}, m14023l = {104, 107, 112}, m14024m = "invokeSuspend", m14025n = {"$this$awaitPointerEventScope", "$this$awaitPointerEventScope", "$this$awaitPointerEventScope"}, m14026s = {"L$0", "L$0", "L$0"})
    public static final class C08982 extends RestrictedSuspendLambda implements Function2<AwaitPointerEventScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function2<AwaitPointerEventScope, Continuation<? super Unit>, Object> $block;
        final /* synthetic */ CoroutineContext $currentContext;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public C08982(CoroutineContext coroutineContext, Function2<? super AwaitPointerEventScope, ? super Continuation<? super Unit>, ? extends Object> function2, Continuation<? super C08982> continuation) {
            super(2, continuation);
            this.$currentContext = coroutineContext;
            this.$block = function2;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            C08982 c08982 = new C08982(this.$currentContext, this.$block, continuation);
            c08982.L$0 = obj;
            return c08982;
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        public final Object invoke(@NotNull AwaitPointerEventScope awaitPointerEventScope, @Nullable Continuation<? super Unit> continuation) {
            return ((C08982) create(awaitPointerEventScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code restructure failed: missing block: B:26:0x0059, code lost:
        
            if (r8 != r0) goto L12;
         */
        /* JADX WARN: Code restructure failed: missing block: B:33:0x0070, code lost:
        
            if (r8 == r0) goto L34;
         */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:32:0x0068  */
        /* JADX WARN: Removed duplicated region for block: B:35:0x0073  */
        /* JADX WARN: Removed duplicated region for block: B:36:0x0074  */
        /* JADX WARN: Removed duplicated region for block: B:38:0x0043 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Type inference failed for: r1v0, types: [int] */
        /* JADX WARN: Type inference failed for: r1v1 */
        /* JADX WARN: Type inference failed for: r1v10 */
        /* JADX WARN: Type inference failed for: r1v11 */
        /* JADX WARN: Type inference failed for: r1v18 */
        /* JADX WARN: Type inference failed for: r1v19 */
        /* JADX WARN: Type inference failed for: r1v2, types: [androidx.compose.ui.input.pointer.AwaitPointerEventScope, java.lang.Object] */
        /* JADX WARN: Type inference failed for: r1v20 */
        /* JADX WARN: Type inference failed for: r1v21 */
        /* JADX WARN: Type inference failed for: r1v22 */
        /* JADX WARN: Type inference failed for: r1v3, types: [androidx.compose.ui.input.pointer.AwaitPointerEventScope, java.lang.Object] */
        /* JADX WARN: Type inference failed for: r1v7 */
        /* JADX WARN: Type inference failed for: r8v12 */
        /* JADX WARN: Type inference failed for: r8v5, types: [java.lang.Object] */
        /* JADX WARN: Type inference failed for: r8v8 */
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
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:26:0x0059 -> B:12:0x0028). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:33:0x0070 -> B:12:0x0028). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(@NotNull Object obj) {
            ?? r8;
            ?? r12;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            ?? r13 = this.label;
            try {
            } catch (CancellationException e) {
                e = e;
                if (JobKt.isActive(this.$currentContext)) {
                }
            }
            if (r13 == 0) {
                ResultKt.throwOnFailure(obj);
                r8 = (AwaitPointerEventScope) this.L$0;
                if (JobKt.isActive(this.$currentContext)) {
                }
            } else {
                if (r13 != 1) {
                    if (r13 == 2) {
                        AwaitPointerEventScope awaitPointerEventScope = (AwaitPointerEventScope) this.L$0;
                        ResultKt.throwOnFailure(obj);
                        r12 = awaitPointerEventScope;
                    } else {
                        if (r13 != 3) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        AwaitPointerEventScope awaitPointerEventScope2 = (AwaitPointerEventScope) this.L$0;
                        ResultKt.throwOnFailure(obj);
                        r12 = awaitPointerEventScope2;
                    }
                    r8 = r12;
                    if (JobKt.isActive(this.$currentContext)) {
                        return Unit.INSTANCE;
                    }
                    try {
                    } catch (CancellationException e2) {
                        r13 = r8;
                        e = e2;
                        if (JobKt.isActive(this.$currentContext)) {
                            throw e;
                        }
                        this.L$0 = r13;
                        this.label = 3;
                        Object objAwaitAllPointersUp = ForEachGestureKt.awaitAllPointersUp((AwaitPointerEventScope) r13, this);
                        r12 = r13;
                    }
                    Function2 function2 = this.$block;
                    this.L$0 = r8;
                    this.label = 1;
                    if (function2.invoke(r8, this) != coroutine_suspended) {
                        r13 = r8;
                        this.L$0 = r13;
                        this.label = 2;
                        Object objAwaitAllPointersUp2 = ForEachGestureKt.awaitAllPointersUp((AwaitPointerEventScope) r13, this);
                        r12 = r13;
                    }
                    return coroutine_suspended;
                }
                AwaitPointerEventScope awaitPointerEventScope3 = (AwaitPointerEventScope) this.L$0;
                ResultKt.throwOnFailure(obj);
                r13 = awaitPointerEventScope3;
                this.L$0 = r13;
                this.label = 2;
                Object objAwaitAllPointersUp22 = ForEachGestureKt.awaitAllPointersUp((AwaitPointerEventScope) r13, this);
                r12 = r13;
            }
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.ForEachGestureKt$forEachGesture$1 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13887k = 3, m13888mv = {1, 8, 0}, m13890xi = 48)
    @DebugMetadata(m14020c = "androidx.compose.foundation.gestures.ForEachGestureKt", m14021f = "ForEachGesture.kt", m14022i = {0, 0, 0, 1, 1, 1, 2, 2, 2}, m14023l = {48, 51, 56}, m14024m = "forEachGesture", m14025n = {"$this$forEachGesture", "block", "currentContext", "$this$forEachGesture", "block", "currentContext", "$this$forEachGesture", "block", "currentContext"}, m14026s = {"L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$0", "L$1", "L$2"})
    public static final class C08991 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        public C08991(Continuation<? super C08991> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ForEachGestureKt.forEachGesture(null, null, this);
        }
    }

    public static final boolean allPointersUp(@NotNull AwaitPointerEventScope awaitPointerEventScope) {
        List<PointerInputChange> changes = awaitPointerEventScope.getCurrentEvent().getChanges();
        int size = changes.size();
        boolean z = false;
        int i = 0;
        while (true) {
            if (i >= size) {
                break;
            }
            if (changes.get(i).getPressed()) {
                z = true;
                break;
            }
            i++;
        }
        return !z;
    }

    @Nullable
    public static final Object awaitAllPointersUp(@NotNull PointerInputScope pointerInputScope, @NotNull Continuation<? super Unit> continuation) {
        Object objAwaitPointerEventScope = pointerInputScope.awaitPointerEventScope(new C08962(null), continuation);
        return objAwaitPointerEventScope == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objAwaitPointerEventScope : Unit.INSTANCE;
    }

    @Nullable
    public static final Object awaitEachGesture(@NotNull PointerInputScope pointerInputScope, @NotNull Function2<? super AwaitPointerEventScope, ? super Continuation<? super Unit>, ? extends Object> function2, @NotNull Continuation<? super Unit> continuation) {
        Object objAwaitPointerEventScope = pointerInputScope.awaitPointerEventScope(new C08982(continuation.getContext(), function2, null), continuation);
        return objAwaitPointerEventScope == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objAwaitPointerEventScope : Unit.INSTANCE;
    }

    /* JADX WARN: Code restructure failed: missing block: B:32:0x0091, code lost:
    
        if (r10 != r1) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x00ab, code lost:
    
        if (r10 == r1) goto L40;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:38:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00ae  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00af  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0074 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Type inference failed for: r10v10 */
    /* JADX WARN: Type inference failed for: r10v6, types: [java.lang.Object, kotlin.coroutines.CoroutineContext] */
    /* JADX WARN: Type inference failed for: r10v8 */
    /* JADX WARN: Type inference failed for: r2v0, types: [int] */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v16 */
    /* JADX WARN: Type inference failed for: r2v17 */
    /* JADX WARN: Type inference failed for: r2v18 */
    /* JADX WARN: Type inference failed for: r2v19 */
    /* JADX WARN: Type inference failed for: r2v2, types: [androidx.compose.ui.input.pointer.PointerInputScope, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v20 */
    /* JADX WARN: Type inference failed for: r2v3, types: [androidx.compose.ui.input.pointer.PointerInputScope, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v6 */
    /* JADX WARN: Type inference failed for: r2v8 */
    /* JADX WARN: Type inference failed for: r2v9 */
    /* JADX WARN: Type inference failed for: r8v0, types: [androidx.compose.ui.input.pointer.PointerInputScope] */
    /* JADX WARN: Type inference failed for: r8v1 */
    /* JADX WARN: Type inference failed for: r8v17 */
    /* JADX WARN: Type inference failed for: r8v18 */
    /* JADX WARN: Type inference failed for: r8v19 */
    /* JADX WARN: Type inference failed for: r8v2, types: [java.lang.Object, kotlin.coroutines.CoroutineContext] */
    /* JADX WARN: Type inference failed for: r8v20 */
    /* JADX WARN: Type inference failed for: r8v21 */
    /* JADX WARN: Type inference failed for: r8v22 */
    /* JADX WARN: Type inference failed for: r8v3, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r8v4, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r8v5 */
    /* JADX WARN: Type inference failed for: r8v6 */
    /* JADX WARN: Type inference failed for: r8v8 */
    /* JADX WARN: Type inference failed for: r8v9 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:32:0x0091 -> B:18:0x0052). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:39:0x00ab -> B:18:0x0052). Please report as a decompilation issue!!! */
    @Deprecated(message = "Use awaitEachGesture instead. forEachGesture() can drop events between gestures.", replaceWith = @ReplaceWith(expression = "awaitEachGesture(block)", imports = {}))
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object forEachGesture(@NotNull PointerInputScope pointerInputScope, @NotNull Function2<? super PointerInputScope, ? super Continuation<? super Unit>, ? extends Object> function2, @NotNull Continuation<? super Unit> continuation) {
        C08991 c08991;
        ?? context;
        ?? r8;
        ?? r82;
        ?? r2;
        if (continuation instanceof C08991) {
            c08991 = (C08991) continuation;
            int i = c08991.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c08991.label = i - Integer.MIN_VALUE;
            } else {
                c08991 = new C08991(continuation);
            }
        }
        Object obj = c08991.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        ?? r22 = c08991.label;
        try {
        } catch (CancellationException e) {
            e = e;
            if (JobKt.isActive(pointerInputScope)) {
            }
        }
        if (r22 == 0) {
            ResultKt.throwOnFailure(obj);
            r8 = pointerInputScope;
            context = c08991.getContext();
            if (JobKt.isActive(context)) {
            }
        } else {
            if (r22 != 1) {
                if (r22 == 2) {
                    CoroutineContext coroutineContext = (CoroutineContext) c08991.L$2;
                    function2 = (Function2) c08991.L$1;
                    PointerInputScope pointerInputScope2 = (PointerInputScope) c08991.L$0;
                    ResultKt.throwOnFailure(obj);
                    r2 = pointerInputScope2;
                    r82 = coroutineContext;
                } else {
                    if (r22 != 3) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    CoroutineContext coroutineContext2 = (CoroutineContext) c08991.L$2;
                    function2 = (Function2) c08991.L$1;
                    PointerInputScope pointerInputScope3 = (PointerInputScope) c08991.L$0;
                    ResultKt.throwOnFailure(obj);
                    r2 = pointerInputScope3;
                    r82 = coroutineContext2;
                }
                context = r82;
                r8 = r2;
                if (JobKt.isActive(context)) {
                    return Unit.INSTANCE;
                }
                try {
                } catch (CancellationException e2) {
                    r22 = r8;
                    pointerInputScope = context;
                    e = e2;
                    if (JobKt.isActive(pointerInputScope)) {
                        throw e;
                    }
                    c08991.L$0 = r22;
                    c08991.L$1 = function2;
                    c08991.L$2 = pointerInputScope;
                    c08991.label = 3;
                    Object objAwaitAllPointersUp = awaitAllPointersUp((PointerInputScope) r22, c08991);
                    r2 = r22;
                    r82 = pointerInputScope;
                }
                c08991.L$0 = r8;
                c08991.L$1 = function2;
                c08991.L$2 = context;
                c08991.label = 1;
                if (function2.invoke(r8, c08991) != coroutine_suspended) {
                    r22 = r8;
                    pointerInputScope = context;
                    c08991.L$0 = r22;
                    c08991.L$1 = function2;
                    c08991.L$2 = pointerInputScope;
                    c08991.label = 2;
                    Object objAwaitAllPointersUp2 = awaitAllPointersUp((PointerInputScope) r22, c08991);
                    r2 = r22;
                    r82 = pointerInputScope;
                }
                return coroutine_suspended;
            }
            CoroutineContext coroutineContext3 = (CoroutineContext) c08991.L$2;
            function2 = (Function2) c08991.L$1;
            PointerInputScope pointerInputScope4 = (PointerInputScope) c08991.L$0;
            ResultKt.throwOnFailure(obj);
            r22 = pointerInputScope4;
            pointerInputScope = coroutineContext3;
            c08991.L$0 = r22;
            c08991.L$1 = function2;
            c08991.L$2 = pointerInputScope;
            c08991.label = 2;
            Object objAwaitAllPointersUp22 = awaitAllPointersUp((PointerInputScope) r22, c08991);
            r2 = r22;
            r82 = pointerInputScope;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x003c, code lost:
    
        if (allPointersUp(r6) == false) goto L16;
     */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0058  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:17:0x0048 -> B:19:0x004b). Please report as a decompilation issue!!! */
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object awaitAllPointersUp(@NotNull AwaitPointerEventScope awaitPointerEventScope, @NotNull Continuation<? super Unit> continuation) {
        C08973 c08973;
        if (continuation instanceof C08973) {
            c08973 = (C08973) continuation;
            int i = c08973.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c08973.label = i - Integer.MIN_VALUE;
            } else {
                c08973 = new C08973(continuation);
            }
        }
        Object objAwaitPointerEvent = c08973.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = c08973.label;
        if (i2 != 0) {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            awaitPointerEventScope = (AwaitPointerEventScope) c08973.L$0;
            ResultKt.throwOnFailure(objAwaitPointerEvent);
            List<PointerInputChange> changes = ((PointerEvent) objAwaitPointerEvent).getChanges();
            int size = changes.size();
            int i4 = 0;
            while (i4 < size) {
                if (changes.get(i4).getPressed()) {
                    PointerEventPass pointerEventPass = PointerEventPass.Final;
                    c08973.L$0 = awaitPointerEventScope;
                    c08973.label = 1;
                    objAwaitPointerEvent = awaitPointerEventScope.awaitPointerEvent(pointerEventPass, c08973);
                    if (objAwaitPointerEvent == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    List<PointerInputChange> changes2 = ((PointerEvent) objAwaitPointerEvent).getChanges();
                    int size2 = changes2.size();
                    int i42 = 0;
                    while (i42 < size2) {
                    }
                } else {
                    i42++;
                }
            }
            return Unit.INSTANCE;
        }
        ResultKt.throwOnFailure(objAwaitPointerEvent);
    }
}
