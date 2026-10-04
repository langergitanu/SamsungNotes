package androidx.compose.foundation;

import androidx.collection.AbstractC0622a;
import androidx.compose.foundation.gestures.ForEachGestureKt;
import androidx.compose.foundation.gestures.TapGestureDetectorKt;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.p109ui.Alignment;
import androidx.compose.p109ui.ComposedModifierKt;
import androidx.compose.p109ui.Modifier;
import androidx.compose.p109ui.input.pointer.AwaitPointerEventScope;
import androidx.compose.p109ui.input.pointer.PointerEvent;
import androidx.compose.p109ui.input.pointer.PointerEventPass;
import androidx.compose.p109ui.input.pointer.PointerEventTimeoutCancellationException;
import androidx.compose.p109ui.input.pointer.PointerInputChange;
import androidx.compose.p109ui.input.pointer.PointerInputScope;
import androidx.compose.p109ui.input.pointer.PointerType;
import androidx.compose.p109ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.p109ui.layout.MeasurePolicy;
import androidx.compose.p109ui.node.ComposeUiNode;
import androidx.compose.p109ui.res.StringResources_androidKt;
import androidx.compose.p109ui.semantics.LiveRegionMode;
import androidx.compose.p109ui.semantics.SemanticsModifierKt;
import androidx.compose.p109ui.semantics.SemanticsPropertiesKt;
import androidx.compose.p109ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.p109ui.window.AndroidPopup_androidKt;
import androidx.compose.p109ui.window.PopupPositionProvider;
import androidx.compose.p109ui.window.PopupProperties;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableInferredTarget;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import com.sun.imageio.plugins.jpeg.JPEG;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m13885d1 = {"\u0000<\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\u001aa\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0011\u0010\u0004\u001a\r\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\b\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\f2\u0011\u0010\u000e\u001a\r\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\b\u0006H\u0007¢\u0006\u0002\u0010\u000f\u001a@\u0010\u0010\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u000b\u001a\u00020\f2\u0011\u0010\u000e\u001a\r\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\b\u0006H\u0003¢\u0006\u0002\u0010\u0013\u001a:\u0010\u0014\u001a\u00020\u00012\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\u0011\u0010\u000e\u001a\r\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\b\u0006H\u0003¢\u0006\u0002\u0010\u0015\u001a,\u0010\u0016\u001a\u00020\n*\u00020\n2\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u0012H\u0002\u001a\u001c\u0010\u001a\u001a\u00020\n*\u00020\n2\u0006\u0010\u0019\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\bH\u0002¨\u0006\u001b"}, m13886d2 = {"BasicTooltipBox", "", "positionProvider", "Landroidx/compose/ui/window/PopupPositionProvider;", "tooltip", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "state", "Landroidx/compose/foundation/BasicTooltipState;", "modifier", "Landroidx/compose/ui/Modifier;", "focusable", "", "enableUserInput", "content", "(Landroidx/compose/ui/window/PopupPositionProvider;Lkotlin/jvm/functions/Function2;Landroidx/compose/foundation/BasicTooltipState;Landroidx/compose/ui/Modifier;ZZLkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "TooltipPopup", "scope", "Lkotlinx/coroutines/CoroutineScope;", "(Landroidx/compose/ui/window/PopupPositionProvider;Landroidx/compose/foundation/BasicTooltipState;Lkotlinx/coroutines/CoroutineScope;ZLkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "WrappedAnchor", "(ZLandroidx/compose/foundation/BasicTooltipState;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "anchorSemantics", "label", "", "enabled", "handleGestures", "foundation_release"}, m13887k = 2, m13888mv = {1, 8, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nBasicTooltip.android.kt\nKotlin\n*S Kotlin\n*F\n+ 1 BasicTooltip.android.kt\nandroidx/compose/foundation/BasicTooltip_androidKt\n+ 2 Effects.kt\nandroidx/compose/runtime/EffectsKt\n+ 3 Composer.kt\nandroidx/compose/runtime/ComposerKt\n+ 4 Effects.kt\nandroidx/compose/runtime/EffectsKt$rememberCoroutineScope$1\n+ 5 Box.kt\nandroidx/compose/foundation/layout/BoxKt\n+ 6 Layout.kt\nandroidx/compose/ui/layout/LayoutKt\n+ 7 Composables.kt\nandroidx/compose/runtime/ComposablesKt\n+ 8 Composer.kt\nandroidx/compose/runtime/Updater\n*L\n1#1,222:1\n481#2:223\n480#2,4:224\n484#2,2:231\n488#2:237\n481#2:285\n480#2,4:286\n484#2,2:293\n488#2:299\n1225#3,3:228\n1228#3,3:234\n1225#3,6:279\n1225#3,3:290\n1228#3,3:296\n1225#3,6:340\n480#4:233\n480#4:295\n71#5:238\n67#5,7:239\n74#5:274\n78#5:278\n71#5:300\n68#5,6:301\n74#5:335\n78#5:339\n79#6,6:246\n86#6,4:261\n90#6,2:271\n94#6:277\n79#6,6:307\n86#6,4:322\n90#6,2:332\n94#6:338\n368#7,9:252\n377#7:273\n378#7,2:275\n368#7,9:313\n377#7:334\n378#7,2:336\n4034#8,6:265\n4034#8,6:326\n*S KotlinDebug\n*F\n+ 1 BasicTooltip.android.kt\nandroidx/compose/foundation/BasicTooltip_androidKt\n*L\n76#1:223\n76#1:224,4\n76#1:231,2\n76#1:237\n109#1:285\n109#1:286,4\n109#1:293,2\n109#1:299\n76#1:228,3\n76#1:234,3\n96#1:279,6\n109#1:290,3\n109#1:296,3\n129#1:340,6\n76#1:233\n109#1:295\n77#1:238\n77#1:239,7\n77#1:274\n77#1:278\n111#1:300\n111#1:301,6\n111#1:335\n111#1:339\n77#1:246,6\n77#1:261,4\n77#1:271,2\n77#1:277\n111#1:307,6\n111#1:322,4\n111#1:332,2\n111#1:338\n77#1:252,9\n77#1:273\n77#1:275,2\n111#1:313,9\n111#1:334\n111#1:336,2\n77#1:265,6\n111#1:326,6\n*E\n"})
public final class BasicTooltip_androidKt {

    /* JADX INFO: renamed from: androidx.compose.foundation.BasicTooltip_androidKt$handleGestures$1 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m13886d2 = {"<anonymous>", "", "Landroidx/compose/ui/input/pointer/PointerInputScope;"}, m13887k = 3, m13888mv = {1, 8, 0}, m13890xi = 48)
    @DebugMetadata(m14020c = "androidx.compose.foundation.BasicTooltip_androidKt$handleGestures$1", m14021f = "BasicTooltip.android.kt", m14022i = {}, m14023l = {152}, m14024m = "invokeSuspend", m14025n = {}, m14026s = {})
    public static final class C07791 extends SuspendLambda implements Function2<PointerInputScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ BasicTooltipState $state;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX INFO: renamed from: androidx.compose.foundation.BasicTooltip_androidKt$handleGestures$1$1, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        @Metadata(m13885d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m13886d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m13887k = 3, m13888mv = {1, 8, 0}, m13890xi = 48)
        @DebugMetadata(m14020c = "androidx.compose.foundation.BasicTooltip_androidKt$handleGestures$1$1", m14021f = "BasicTooltip.android.kt", m14022i = {}, m14023l = {153}, m14024m = "invokeSuspend", m14025n = {}, m14026s = {})
        public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ PointerInputScope $$this$pointerInput;
            final /* synthetic */ BasicTooltipState $state;
            private /* synthetic */ Object L$0;
            int label;

            /* JADX INFO: renamed from: androidx.compose.foundation.BasicTooltip_androidKt$handleGestures$1$1$1, reason: invalid class name and collision with other inner class name */
            /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
            @Metadata(m13885d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m13886d2 = {"<anonymous>", "", "Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;"}, m13887k = 3, m13888mv = {1, 8, 0}, m13890xi = 48)
            @DebugMetadata(m14020c = "androidx.compose.foundation.BasicTooltip_androidKt$handleGestures$1$1$1", m14021f = "BasicTooltip.android.kt", m14022i = {0, 0, 0, 1, 1}, m14023l = {158, 164, 172}, m14024m = "invokeSuspend", m14025n = {"$this$awaitEachGesture", "pass", "longPressTimeout", "$this$awaitEachGesture", "pass"}, m14026s = {"L$0", "L$1", "J$0", "L$0", "L$1"})
            public static final class C145261 extends RestrictedSuspendLambda implements Function2<AwaitPointerEventScope, Continuation<? super Unit>, Object> {
                final /* synthetic */ CoroutineScope $$this$coroutineScope;
                final /* synthetic */ BasicTooltipState $state;
                long J$0;
                private /* synthetic */ Object L$0;
                Object L$1;
                int label;

                /* JADX INFO: renamed from: androidx.compose.foundation.BasicTooltip_androidKt$handleGestures$1$1$1$1, reason: invalid class name and collision with other inner class name */
                /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
                @Metadata(m13885d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\u008a@"}, m13886d2 = {"<anonymous>", "Landroidx/compose/ui/input/pointer/PointerInputChange;", "Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;"}, m13887k = 3, m13888mv = {1, 8, 0}, m13890xi = 48)
                @DebugMetadata(m14020c = "androidx.compose.foundation.BasicTooltip_androidKt$handleGestures$1$1$1$1", m14021f = "BasicTooltip.android.kt", m14022i = {}, m14023l = {165}, m14024m = "invokeSuspend", m14025n = {}, m14026s = {})
                public static final class C145271 extends RestrictedSuspendLambda implements Function2<AwaitPointerEventScope, Continuation<? super PointerInputChange>, Object> {
                    final /* synthetic */ PointerEventPass $pass;
                    private /* synthetic */ Object L$0;
                    int label;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    public C145271(PointerEventPass pointerEventPass, Continuation<? super C145271> continuation) {
                        super(2, continuation);
                        this.$pass = pointerEventPass;
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    @NotNull
                    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
                        C145271 c145271 = new C145271(this.$pass, continuation);
                        c145271.L$0 = obj;
                        return c145271;
                    }

                    @Override // kotlin.jvm.functions.Function2
                    @Nullable
                    public final Object invoke(@NotNull AwaitPointerEventScope awaitPointerEventScope, @Nullable Continuation<? super PointerInputChange> continuation) {
                        return ((C145271) create(awaitPointerEventScope, continuation)).invokeSuspend(Unit.INSTANCE);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    @Nullable
                    public final Object invokeSuspend(@NotNull Object obj) {
                        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                        int i = this.label;
                        if (i != 0) {
                            if (i != 1) {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            ResultKt.throwOnFailure(obj);
                            return obj;
                        }
                        ResultKt.throwOnFailure(obj);
                        AwaitPointerEventScope awaitPointerEventScope = (AwaitPointerEventScope) this.L$0;
                        PointerEventPass pointerEventPass = this.$pass;
                        this.label = 1;
                        Object objWaitForUpOrCancellation = TapGestureDetectorKt.waitForUpOrCancellation(awaitPointerEventScope, pointerEventPass, this);
                        return objWaitForUpOrCancellation == coroutine_suspended ? coroutine_suspended : objWaitForUpOrCancellation;
                    }
                }

                /* JADX INFO: renamed from: androidx.compose.foundation.BasicTooltip_androidKt$handleGestures$1$1$1$2, reason: invalid class name */
                /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
                @Metadata(m13885d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m13886d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m13887k = 3, m13888mv = {1, 8, 0}, m13890xi = 48)
                @DebugMetadata(m14020c = "androidx.compose.foundation.BasicTooltip_androidKt$handleGestures$1$1$1$2", m14021f = "BasicTooltip.android.kt", m14022i = {}, m14023l = {169}, m14024m = "invokeSuspend", m14025n = {}, m14026s = {})
                public static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                    final /* synthetic */ BasicTooltipState $state;
                    int label;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    public AnonymousClass2(BasicTooltipState basicTooltipState, Continuation<? super AnonymousClass2> continuation) {
                        super(2, continuation);
                        this.$state = basicTooltipState;
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    @NotNull
                    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
                        return new AnonymousClass2(this.$state, continuation);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    @Nullable
                    public final Object invokeSuspend(@NotNull Object obj) {
                        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                        int i = this.label;
                        if (i == 0) {
                            ResultKt.throwOnFailure(obj);
                            BasicTooltipState basicTooltipState = this.$state;
                            MutatePriority mutatePriority = MutatePriority.UserInput;
                            this.label = 1;
                            if (basicTooltipState.show(mutatePriority, this) == coroutine_suspended) {
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

                    @Override // kotlin.jvm.functions.Function2
                    @Nullable
                    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
                        return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                    }
                }

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public C145261(CoroutineScope coroutineScope, BasicTooltipState basicTooltipState, Continuation<? super C145261> continuation) {
                    super(2, continuation);
                    this.$$this$coroutineScope = coroutineScope;
                    this.$state = basicTooltipState;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                @NotNull
                public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
                    C145261 c145261 = new C145261(this.$$this$coroutineScope, this.$state, continuation);
                    c145261.L$0 = obj;
                    return c145261;
                }

                @Override // kotlin.jvm.functions.Function2
                @Nullable
                public final Object invoke(@NotNull AwaitPointerEventScope awaitPointerEventScope, @Nullable Continuation<? super Unit> continuation) {
                    return ((C145261) create(awaitPointerEventScope, continuation)).invokeSuspend(Unit.INSTANCE);
                }

                /* JADX WARN: Code restructure failed: missing block: B:24:0x0092, code lost:
                
                    if (r4.withTimeout(r10, r1, r16) == r6) goto L29;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:28:0x00b0, code lost:
                
                    if (r0 == r6) goto L29;
                 */
                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                @Nullable
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public final Object invokeSuspend(@NotNull Object obj) {
                    long longPressTimeoutMillis;
                    PointerEventPass pointerEventPass;
                    Object objAwaitFirstDown$default;
                    AwaitPointerEventScope awaitPointerEventScope;
                    PointerEventPass pointerEventPass2;
                    AwaitPointerEventScope awaitPointerEventScope2;
                    Object objAwaitPointerEvent;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    int i = this.label;
                    if (i == 0) {
                        ResultKt.throwOnFailure(obj);
                        AwaitPointerEventScope awaitPointerEventScope3 = (AwaitPointerEventScope) this.L$0;
                        longPressTimeoutMillis = awaitPointerEventScope3.getViewConfiguration().getLongPressTimeoutMillis();
                        pointerEventPass = PointerEventPass.Initial;
                        this.L$0 = awaitPointerEventScope3;
                        this.L$1 = pointerEventPass;
                        this.J$0 = longPressTimeoutMillis;
                        this.label = 1;
                        objAwaitFirstDown$default = TapGestureDetectorKt.awaitFirstDown$default(awaitPointerEventScope3, false, pointerEventPass, this, 1, null);
                        if (objAwaitFirstDown$default != coroutine_suspended) {
                            awaitPointerEventScope = awaitPointerEventScope3;
                        }
                        return coroutine_suspended;
                    }
                    if (i != 1) {
                        if (i == 2) {
                            pointerEventPass2 = (PointerEventPass) this.L$1;
                            awaitPointerEventScope2 = (AwaitPointerEventScope) this.L$0;
                            try {
                                ResultKt.throwOnFailure(obj);
                            } catch (PointerEventTimeoutCancellationException unused) {
                                BuildersKt__Builders_commonKt.launch$default(this.$$this$coroutineScope, null, null, new AnonymousClass2(this.$state, null), 3, null);
                                this.L$0 = null;
                                this.L$1 = null;
                                this.label = 3;
                                objAwaitPointerEvent = awaitPointerEventScope2.awaitPointerEvent(pointerEventPass2, this);
                            }
                            return Unit.INSTANCE;
                        }
                        if (i != 3) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        ResultKt.throwOnFailure(obj);
                        objAwaitPointerEvent = obj;
                        List<PointerInputChange> changes = ((PointerEvent) objAwaitPointerEvent).getChanges();
                        int size = changes.size();
                        for (int i2 = 0; i2 < size; i2++) {
                            changes.get(i2).consume();
                        }
                        return Unit.INSTANCE;
                    }
                    long j = this.J$0;
                    pointerEventPass = (PointerEventPass) this.L$1;
                    awaitPointerEventScope = (AwaitPointerEventScope) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    longPressTimeoutMillis = j;
                    objAwaitFirstDown$default = obj;
                    pointerEventPass2 = pointerEventPass;
                    int type = ((PointerInputChange) objAwaitFirstDown$default).getType();
                    PointerType.Companion companion = PointerType.INSTANCE;
                    if (PointerType.m19798equalsimpl0(type, companion.m19805getTouchT8wyACA()) || PointerType.m19798equalsimpl0(type, companion.m19804getStylusT8wyACA())) {
                        try {
                            C145271 c145271 = new C145271(pointerEventPass2, null);
                            this.L$0 = awaitPointerEventScope;
                            this.L$1 = pointerEventPass2;
                            this.label = 2;
                        } catch (PointerEventTimeoutCancellationException unused2) {
                            awaitPointerEventScope2 = awaitPointerEventScope;
                            BuildersKt__Builders_commonKt.launch$default(this.$$this$coroutineScope, null, null, new AnonymousClass2(this.$state, null), 3, null);
                            this.L$0 = null;
                            this.L$1 = null;
                            this.label = 3;
                            objAwaitPointerEvent = awaitPointerEventScope2.awaitPointerEvent(pointerEventPass2, this);
                        }
                    }
                    return Unit.INSTANCE;
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass1(PointerInputScope pointerInputScope, BasicTooltipState basicTooltipState, Continuation<? super AnonymousClass1> continuation) {
                super(2, continuation);
                this.$$this$pointerInput = pointerInputScope;
                this.$state = basicTooltipState;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @NotNull
            public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$$this$pointerInput, this.$state, continuation);
                anonymousClass1.L$0 = obj;
                return anonymousClass1;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @Nullable
            public final Object invokeSuspend(@NotNull Object obj) {
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i = this.label;
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
                    PointerInputScope pointerInputScope = this.$$this$pointerInput;
                    C145261 c145261 = new C145261(coroutineScope, this.$state, null);
                    this.label = 1;
                    if (ForEachGestureKt.awaitEachGesture(pointerInputScope, c145261, this) == coroutine_suspended) {
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

            @Override // kotlin.jvm.functions.Function2
            @Nullable
            public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
                return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C07791(BasicTooltipState basicTooltipState, Continuation<? super C07791> continuation) {
            super(2, continuation);
            this.$state = basicTooltipState;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            C07791 c07791 = new C07791(this.$state, continuation);
            c07791.L$0 = obj;
            return c07791;
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        public final Object invoke(@NotNull PointerInputScope pointerInputScope, @Nullable Continuation<? super Unit> continuation) {
            return ((C07791) create(pointerInputScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                AnonymousClass1 anonymousClass1 = new AnonymousClass1((PointerInputScope) this.L$0, this.$state, null);
                this.label = 1;
                if (CoroutineScopeKt.coroutineScope(anonymousClass1, this) == coroutine_suspended) {
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

    /* JADX INFO: renamed from: androidx.compose.foundation.BasicTooltip_androidKt$handleGestures$2 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m13886d2 = {"<anonymous>", "", "Landroidx/compose/ui/input/pointer/PointerInputScope;"}, m13887k = 3, m13888mv = {1, 8, 0}, m13890xi = 48)
    @DebugMetadata(m14020c = "androidx.compose.foundation.BasicTooltip_androidKt$handleGestures$2", m14021f = "BasicTooltip.android.kt", m14022i = {}, m14023l = {180}, m14024m = "invokeSuspend", m14025n = {}, m14026s = {})
    public static final class C07802 extends SuspendLambda implements Function2<PointerInputScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ BasicTooltipState $state;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX INFO: renamed from: androidx.compose.foundation.BasicTooltip_androidKt$handleGestures$2$1, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        @Metadata(m13885d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m13886d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m13887k = 3, m13888mv = {1, 8, 0}, m13890xi = 48)
        @DebugMetadata(m14020c = "androidx.compose.foundation.BasicTooltip_androidKt$handleGestures$2$1", m14021f = "BasicTooltip.android.kt", m14022i = {}, m14023l = {181}, m14024m = "invokeSuspend", m14025n = {}, m14026s = {})
        public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ PointerInputScope $$this$pointerInput;
            final /* synthetic */ BasicTooltipState $state;
            private /* synthetic */ Object L$0;
            int label;

            /* JADX INFO: renamed from: androidx.compose.foundation.BasicTooltip_androidKt$handleGestures$2$1$1, reason: invalid class name and collision with other inner class name */
            /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
            @Metadata(m13885d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m13886d2 = {"<anonymous>", "", "Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;"}, m13887k = 3, m13888mv = {1, 8, 0}, m13890xi = 48)
            @DebugMetadata(m14020c = "androidx.compose.foundation.BasicTooltip_androidKt$handleGestures$2$1$1", m14021f = "BasicTooltip.android.kt", m14022i = {0, 0}, m14023l = {185}, m14024m = "invokeSuspend", m14025n = {"$this$awaitPointerEventScope", "pass"}, m14026s = {"L$0", "L$1"})
            public static final class C145281 extends RestrictedSuspendLambda implements Function2<AwaitPointerEventScope, Continuation<? super Unit>, Object> {
                final /* synthetic */ CoroutineScope $$this$coroutineScope;
                final /* synthetic */ BasicTooltipState $state;
                private /* synthetic */ Object L$0;
                Object L$1;
                int label;

                /* JADX INFO: renamed from: androidx.compose.foundation.BasicTooltip_androidKt$handleGestures$2$1$1$1, reason: invalid class name and collision with other inner class name */
                /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
                @Metadata(m13885d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m13886d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m13887k = 3, m13888mv = {1, 8, 0}, m13890xi = 48)
                @DebugMetadata(m14020c = "androidx.compose.foundation.BasicTooltip_androidKt$handleGestures$2$1$1$1", m14021f = "BasicTooltip.android.kt", m14022i = {}, m14023l = {190}, m14024m = "invokeSuspend", m14025n = {}, m14026s = {})
                public static final class C145291 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                    final /* synthetic */ BasicTooltipState $state;
                    int label;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    public C145291(BasicTooltipState basicTooltipState, Continuation<? super C145291> continuation) {
                        super(2, continuation);
                        this.$state = basicTooltipState;
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    @NotNull
                    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
                        return new C145291(this.$state, continuation);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    @Nullable
                    public final Object invokeSuspend(@NotNull Object obj) {
                        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                        int i = this.label;
                        if (i == 0) {
                            ResultKt.throwOnFailure(obj);
                            BasicTooltipState basicTooltipState = this.$state;
                            MutatePriority mutatePriority = MutatePriority.UserInput;
                            this.label = 1;
                            if (basicTooltipState.show(mutatePriority, this) == coroutine_suspended) {
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

                    @Override // kotlin.jvm.functions.Function2
                    @Nullable
                    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
                        return ((C145291) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                    }
                }

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public C145281(CoroutineScope coroutineScope, BasicTooltipState basicTooltipState, Continuation<? super C145281> continuation) {
                    super(2, continuation);
                    this.$$this$coroutineScope = coroutineScope;
                    this.$state = basicTooltipState;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                @NotNull
                public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
                    C145281 c145281 = new C145281(this.$$this$coroutineScope, this.$state, continuation);
                    c145281.L$0 = obj;
                    return c145281;
                }

                @Override // kotlin.jvm.functions.Function2
                @Nullable
                public final Object invoke(@NotNull AwaitPointerEventScope awaitPointerEventScope, @Nullable Continuation<? super Unit> continuation) {
                    return ((C145281) create(awaitPointerEventScope, continuation)).invokeSuspend(Unit.INSTANCE);
                }

                /* JADX WARN: Removed duplicated region for block: B:11:0x0035 A[RETURN] */
                /* JADX WARN: Removed duplicated region for block: B:14:0x0053  */
                /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0033 -> B:12:0x0036). Please report as a decompilation issue!!! */
                /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
                    jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
                    	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
                    	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
                    	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
                    */
                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                @org.jetbrains.annotations.Nullable
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r13) {
                    /*
                        r12 = this;
                        java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                        int r1 = r12.label
                        r2 = 1
                        if (r1 == 0) goto L1f
                        if (r1 != r2) goto L17
                        java.lang.Object r1 = r12.L$1
                        androidx.compose.ui.input.pointer.PointerEventPass r1 = (androidx.compose.p109ui.input.pointer.PointerEventPass) r1
                        java.lang.Object r3 = r12.L$0
                        androidx.compose.ui.input.pointer.AwaitPointerEventScope r3 = (androidx.compose.p109ui.input.pointer.AwaitPointerEventScope) r3
                        kotlin.ResultKt.throwOnFailure(r13)
                        goto L36
                    L17:
                        java.lang.IllegalStateException r13 = new java.lang.IllegalStateException
                        java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                        r13.<init>(r0)
                        throw r13
                    L1f:
                        kotlin.ResultKt.throwOnFailure(r13)
                        java.lang.Object r13 = r12.L$0
                        androidx.compose.ui.input.pointer.AwaitPointerEventScope r13 = (androidx.compose.p109ui.input.pointer.AwaitPointerEventScope) r13
                        androidx.compose.ui.input.pointer.PointerEventPass r1 = androidx.compose.p109ui.input.pointer.PointerEventPass.Main
                        r3 = r13
                    L29:
                        r12.L$0 = r3
                        r12.L$1 = r1
                        r12.label = r2
                        java.lang.Object r13 = r3.awaitPointerEvent(r1, r12)
                        if (r13 != r0) goto L36
                        return r0
                    L36:
                        androidx.compose.ui.input.pointer.PointerEvent r13 = (androidx.compose.p109ui.input.pointer.PointerEvent) r13
                        java.util.List r4 = r13.getChanges()
                        r5 = 0
                        java.lang.Object r4 = r4.get(r5)
                        androidx.compose.ui.input.pointer.PointerInputChange r4 = (androidx.compose.p109ui.input.pointer.PointerInputChange) r4
                        int r4 = r4.getType()
                        androidx.compose.ui.input.pointer.PointerType$Companion r5 = androidx.compose.p109ui.input.pointer.PointerType.INSTANCE
                        int r5 = r5.m19803getMouseT8wyACA()
                        boolean r4 = androidx.compose.p109ui.input.pointer.PointerType.m19798equalsimpl0(r4, r5)
                        if (r4 == 0) goto L29
                        int r13 = r13.getType()
                        androidx.compose.ui.input.pointer.PointerEventType$Companion r4 = androidx.compose.p109ui.input.pointer.PointerEventType.INSTANCE
                        int r5 = r4.m19679getEnter7fucELk()
                        boolean r5 = androidx.compose.p109ui.input.pointer.PointerEventType.m19675equalsimpl0(r13, r5)
                        if (r5 == 0) goto L75
                        kotlinx.coroutines.CoroutineScope r6 = r12.$$this$coroutineScope
                        androidx.compose.foundation.BasicTooltip_androidKt$handleGestures$2$1$1$1 r9 = new androidx.compose.foundation.BasicTooltip_androidKt$handleGestures$2$1$1$1
                        androidx.compose.foundation.BasicTooltipState r13 = r12.$state
                        r4 = 0
                        r9.<init>(r13, r4)
                        r10 = 3
                        r11 = 0
                        r7 = 0
                        r8 = 0
                        kotlinx.coroutines.BuildersKt.launch$default(r6, r7, r8, r9, r10, r11)
                        goto L29
                    L75:
                        int r4 = r4.m19680getExit7fucELk()
                        boolean r13 = androidx.compose.p109ui.input.pointer.PointerEventType.m19675equalsimpl0(r13, r4)
                        if (r13 == 0) goto L29
                        androidx.compose.foundation.BasicTooltipState r13 = r12.$state
                        r13.dismiss()
                        goto L29
                    */
                    throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.BasicTooltip_androidKt.C07802.AnonymousClass1.C145281.invokeSuspend(java.lang.Object):java.lang.Object");
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass1(PointerInputScope pointerInputScope, BasicTooltipState basicTooltipState, Continuation<? super AnonymousClass1> continuation) {
                super(2, continuation);
                this.$$this$pointerInput = pointerInputScope;
                this.$state = basicTooltipState;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @NotNull
            public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$$this$pointerInput, this.$state, continuation);
                anonymousClass1.L$0 = obj;
                return anonymousClass1;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @Nullable
            public final Object invokeSuspend(@NotNull Object obj) {
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i = this.label;
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
                    PointerInputScope pointerInputScope = this.$$this$pointerInput;
                    C145281 c145281 = new C145281(coroutineScope, this.$state, null);
                    this.label = 1;
                    if (pointerInputScope.awaitPointerEventScope(c145281, this) == coroutine_suspended) {
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

            @Override // kotlin.jvm.functions.Function2
            @Nullable
            public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
                return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C07802(BasicTooltipState basicTooltipState, Continuation<? super C07802> continuation) {
            super(2, continuation);
            this.$state = basicTooltipState;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            C07802 c07802 = new C07802(this.$state, continuation);
            c07802.L$0 = obj;
            return c07802;
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        public final Object invoke(@NotNull PointerInputScope pointerInputScope, @Nullable Continuation<? super Unit> continuation) {
            return ((C07802) create(pointerInputScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                AnonymousClass1 anonymousClass1 = new AnonymousClass1((PointerInputScope) this.L$0, this.$state, null);
                this.label = 1;
                if (CoroutineScopeKt.coroutineScope(anonymousClass1, this) == coroutine_suspended) {
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

    /* JADX WARN: Removed duplicated region for block: B:100:0x013f  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x014b  */
    /* JADX WARN: Removed duplicated region for block: B:104:0x014f  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x0160  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x0171  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x0185  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x01ae  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x01dc  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x01de  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x01e5  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x01eb  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x0202  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x020e  */
    /* JADX WARN: Removed duplicated region for block: B:133:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x004a  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x004d  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0061  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x007c  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0081  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0099  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x009d  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00b4  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x00b9  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x00d5  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x00e3  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x00e5  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x00ea  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x00ec  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x00ef  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x00f6  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0108  */
    @Composable
    @ExperimentalFoundationApi
    @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable]]")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void BasicTooltipBox(@NotNull final PopupPositionProvider popupPositionProvider, @NotNull final Function2<? super Composer, ? super Integer, Unit> function2, @NotNull BasicTooltipState basicTooltipState, @Nullable Modifier modifier, boolean z, boolean z2, @NotNull final Function2<? super Composer, ? super Integer, Unit> function22, @Nullable Composer composer, final int i, final int i2) {
        PopupPositionProvider popupPositionProvider2;
        int i4;
        Function2<? super Composer, ? super Integer, Unit> function23;
        int i5;
        Modifier modifier2;
        int i6;
        boolean z3;
        int i7;
        boolean z4;
        Function2<? super Composer, ? super Integer, Unit> function24;
        int i8;
        Object objRememberedValue;
        Composer.Companion companion;
        Composer composerM18018constructorimpl;
        ComposeUiNode.Companion companion2;
        boolean z5;
        boolean z6;
        Object objRememberedValue2;
        final boolean z7;
        final boolean z8;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        final BasicTooltipState basicTooltipState2 = basicTooltipState;
        Composer composerStartRestartGroup = composer.startRestartGroup(-868234445);
        if ((i2 & 1) != 0) {
            i4 = i | 6;
            popupPositionProvider2 = popupPositionProvider;
        } else if ((i & 6) == 0) {
            popupPositionProvider2 = popupPositionProvider;
            i4 = (composerStartRestartGroup.changed(popupPositionProvider2) ? 4 : 2) | i;
        } else {
            popupPositionProvider2 = popupPositionProvider;
            i4 = i;
        }
        if ((i2 & 2) != 0) {
            i4 |= 48;
        } else {
            if ((i & 48) == 0) {
                function23 = function2;
                i4 |= composerStartRestartGroup.changedInstance(function23) ? 32 : 16;
            }
            if ((i2 & 4) == 0) {
                i4 |= 384;
            } else if ((i & 384) == 0) {
                i4 |= composerStartRestartGroup.changed(basicTooltipState2) ? 256 : 128;
            }
            i5 = i2 & 8;
            if (i5 == 0) {
                i4 |= 3072;
            } else {
                if ((i & 3072) == 0) {
                    modifier2 = modifier;
                    i4 |= composerStartRestartGroup.changed(modifier2) ? 2048 : 1024;
                }
                i6 = i2 & 16;
                if (i6 != 0) {
                    i4 |= 24576;
                } else {
                    if ((i & 24576) == 0) {
                        z3 = z;
                        i4 |= composerStartRestartGroup.changed(z3) ? 16384 : 8192;
                    }
                    i7 = i2 & 32;
                    if (i7 == 0) {
                        i4 |= 196608;
                    } else {
                        if ((196608 & i) == 0) {
                            z4 = z2;
                            i4 |= composerStartRestartGroup.changed(z4) ? 131072 : 65536;
                        }
                        if ((i2 & 64) == 0) {
                            if ((i & 1572864) == 0) {
                                function24 = function22;
                                i4 |= composerStartRestartGroup.changedInstance(function24) ? 1048576 : 524288;
                            }
                            i8 = i4;
                            if ((599187 & i8) == 599186 || !composerStartRestartGroup.getSkipping()) {
                                if (i5 != 0) {
                                    modifier2 = Modifier.INSTANCE;
                                }
                                boolean z9 = i6 == 0 ? true : z3;
                                if (i7 != 0) {
                                    z4 = true;
                                }
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-868234445, i8, -1, "androidx.compose.foundation.BasicTooltipBox (BasicTooltip.android.kt:74)");
                                }
                                objRememberedValue = composerStartRestartGroup.rememberedValue();
                                companion = Composer.INSTANCE;
                                if (objRememberedValue == companion.getEmpty()) {
                                    objRememberedValue = AbstractC0000a.m8e(EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, composerStartRestartGroup), composerStartRestartGroup);
                                }
                                CoroutineScope coroutineScope = ((CompositionScopedCoroutineScopeCanceller) objRememberedValue).getCoroutineScope();
                                Modifier.Companion companion3 = Modifier.INSTANCE;
                                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                                int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                                CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
                                Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, companion3);
                                ComposeUiNode.Companion companion4 = ComposeUiNode.INSTANCE;
                                Function0<ComposeUiNode> constructor = companion4.getConstructor();
                                if (composerStartRestartGroup.getApplier() == null) {
                                    ComposablesKt.invalidApplier();
                                }
                                composerStartRestartGroup.startReusableNode();
                                if (composerStartRestartGroup.getInserting()) {
                                    composerStartRestartGroup.useNode();
                                } else {
                                    composerStartRestartGroup.createNode(constructor);
                                }
                                composerM18018constructorimpl = Updater.m18018constructorimpl(composerStartRestartGroup);
                                Function2 function2M1177w = AbstractC0622a.m1177w(companion4, composerM18018constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy, composerM18018constructorimpl, currentCompositionLocalMap);
                                if (composerM18018constructorimpl.getInserting()) {
                                    companion2 = companion4;
                                    if (!Intrinsics.areEqual(composerM18018constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                                    }
                                    Updater.m18025setimpl(composerM18018constructorimpl, modifierMaterializeModifier, companion2.getSetModifier());
                                    BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                                    if (basicTooltipState.isVisible()) {
                                        composerStartRestartGroup.startReplaceGroup(136814616);
                                        int i9 = i8 >> 3;
                                        TooltipPopup(popupPositionProvider2, basicTooltipState, coroutineScope, z9, function23, composerStartRestartGroup, (i8 & 14) | (i9 & 112) | (i9 & 7168) | ((i8 << 9) & 57344));
                                        z5 = z9;
                                        composerStartRestartGroup = composerStartRestartGroup;
                                        composerStartRestartGroup.endReplaceGroup();
                                    } else {
                                        z5 = z9;
                                        composerStartRestartGroup.startReplaceGroup(137044295);
                                        composerStartRestartGroup.endReplaceGroup();
                                    }
                                    int i10 = i8 >> 3;
                                    int i11 = ((i8 >> 15) & 14) | (i10 & 112) | (i10 & 896) | ((i8 >> 9) & 7168);
                                    basicTooltipState2 = basicTooltipState;
                                    Modifier modifier3 = modifier2;
                                    boolean z10 = z4;
                                    WrappedAnchor(z10, basicTooltipState2, modifier3, function24, composerStartRestartGroup, i11, 0);
                                    composerStartRestartGroup.endNode();
                                    z6 = (i8 & 896) == 256;
                                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                                    if (z6 || objRememberedValue2 == companion.getEmpty()) {
                                        objRememberedValue2 = new Function1<DisposableEffectScope, DisposableEffectResult>() { // from class: androidx.compose.foundation.BasicTooltip_androidKt$BasicTooltipBox$2$1
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            @NotNull
                                            public final DisposableEffectResult invoke(@NotNull DisposableEffectScope disposableEffectScope) {
                                                final BasicTooltipState basicTooltipState3 = basicTooltipState2;
                                                return new DisposableEffectResult() { // from class: androidx.compose.foundation.BasicTooltip_androidKt$BasicTooltipBox$2$1$invoke$$inlined$onDispose$1
                                                    @Override // androidx.compose.runtime.DisposableEffectResult
                                                    public void dispose() {
                                                        basicTooltipState3.onDispose();
                                                    }
                                                };
                                            }
                                        };
                                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                                    }
                                    EffectsKt.DisposableEffect(basicTooltipState2, (Function1<? super DisposableEffectScope, ? extends DisposableEffectResult>) objRememberedValue2, composerStartRestartGroup, (i8 >> 6) & 14);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                    z7 = z10;
                                    modifier2 = modifier3;
                                    z8 = z5;
                                } else {
                                    companion2 = companion4;
                                }
                                AbstractC0622a.m1178x(currentCompositeKeyHash, function2M1177w, composerM18018constructorimpl, currentCompositeKeyHash);
                                Updater.m18025setimpl(composerM18018constructorimpl, modifierMaterializeModifier, companion2.getSetModifier());
                                BoxScopeInstance boxScopeInstance2 = BoxScopeInstance.INSTANCE;
                                if (basicTooltipState.isVisible()) {
                                }
                                int i102 = i8 >> 3;
                                int i112 = ((i8 >> 15) & 14) | (i102 & 112) | (i102 & 896) | ((i8 >> 9) & 7168);
                                basicTooltipState2 = basicTooltipState;
                                Modifier modifier32 = modifier2;
                                boolean z102 = z4;
                                WrappedAnchor(z102, basicTooltipState2, modifier32, function24, composerStartRestartGroup, i112, 0);
                                composerStartRestartGroup.endNode();
                                if ((i8 & 896) == 256) {
                                }
                                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                                if (z6) {
                                    objRememberedValue2 = new Function1<DisposableEffectScope, DisposableEffectResult>() { // from class: androidx.compose.foundation.BasicTooltip_androidKt$BasicTooltipBox$2$1
                                        {
                                            super(1);
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        @NotNull
                                        public final DisposableEffectResult invoke(@NotNull DisposableEffectScope disposableEffectScope) {
                                            final BasicTooltipState basicTooltipState3 = basicTooltipState2;
                                            return new DisposableEffectResult() { // from class: androidx.compose.foundation.BasicTooltip_androidKt$BasicTooltipBox$2$1$invoke$$inlined$onDispose$1
                                                @Override // androidx.compose.runtime.DisposableEffectResult
                                                public void dispose() {
                                                    basicTooltipState3.onDispose();
                                                }
                                            };
                                        }
                                    };
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                                    EffectsKt.DisposableEffect(basicTooltipState2, (Function1<? super DisposableEffectScope, ? extends DisposableEffectResult>) objRememberedValue2, composerStartRestartGroup, (i8 >> 6) & 14);
                                    if (ComposerKt.isTraceInProgress()) {
                                    }
                                    z7 = z102;
                                    modifier2 = modifier32;
                                    z8 = z5;
                                }
                            } else {
                                composerStartRestartGroup.skipToGroupEnd();
                                z8 = z3;
                                z7 = z4;
                            }
                            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                            if (scopeUpdateScopeEndRestartGroup == null) {
                                final BasicTooltipState basicTooltipState3 = basicTooltipState2;
                                final Modifier modifier4 = modifier2;
                                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.BasicTooltip_androidKt.BasicTooltipBox.3
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    /* JADX WARN: Multi-variable type inference failed */
                                    {
                                        super(2);
                                    }

                                    @Override // kotlin.jvm.functions.Function2
                                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                                        invoke(composer2, num.intValue());
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(@Nullable Composer composer2, int i12) {
                                        BasicTooltip_androidKt.BasicTooltipBox(popupPositionProvider, function2, basicTooltipState3, modifier4, z8, z7, function22, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                                    }
                                });
                                return;
                            }
                            return;
                        }
                        i4 |= 1572864;
                        function24 = function22;
                        i8 = i4;
                        if ((599187 & i8) == 599186) {
                            if (i5 != 0) {
                            }
                            if (i6 == 0) {
                            }
                            if (i7 != 0) {
                            }
                            if (ComposerKt.isTraceInProgress()) {
                            }
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            companion = Composer.INSTANCE;
                            if (objRememberedValue == companion.getEmpty()) {
                            }
                            CoroutineScope coroutineScope2 = ((CompositionScopedCoroutineScopeCanceller) objRememberedValue).getCoroutineScope();
                            Modifier.Companion companion32 = Modifier.INSTANCE;
                            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                            int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                            CompositionLocalMap currentCompositionLocalMap2 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                            Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, companion32);
                            ComposeUiNode.Companion companion42 = ComposeUiNode.INSTANCE;
                            Function0<ComposeUiNode> constructor2 = companion42.getConstructor();
                            if (composerStartRestartGroup.getApplier() == null) {
                            }
                            composerStartRestartGroup.startReusableNode();
                            if (composerStartRestartGroup.getInserting()) {
                            }
                            composerM18018constructorimpl = Updater.m18018constructorimpl(composerStartRestartGroup);
                            Function2 function2M1177w2 = AbstractC0622a.m1177w(companion42, composerM18018constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy2, composerM18018constructorimpl, currentCompositionLocalMap2);
                            if (composerM18018constructorimpl.getInserting()) {
                            }
                            AbstractC0622a.m1178x(currentCompositeKeyHash2, function2M1177w2, composerM18018constructorimpl, currentCompositeKeyHash2);
                            Updater.m18025setimpl(composerM18018constructorimpl, modifierMaterializeModifier2, companion2.getSetModifier());
                            BoxScopeInstance boxScopeInstance22 = BoxScopeInstance.INSTANCE;
                            if (basicTooltipState.isVisible()) {
                            }
                            int i1022 = i8 >> 3;
                            int i1122 = ((i8 >> 15) & 14) | (i1022 & 112) | (i1022 & 896) | ((i8 >> 9) & 7168);
                            basicTooltipState2 = basicTooltipState;
                            Modifier modifier322 = modifier2;
                            boolean z1022 = z4;
                            WrappedAnchor(z1022, basicTooltipState2, modifier322, function24, composerStartRestartGroup, i1122, 0);
                            composerStartRestartGroup.endNode();
                            if ((i8 & 896) == 256) {
                            }
                            objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                            if (z6) {
                            }
                        }
                        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup == null) {
                        }
                    }
                    z4 = z2;
                    if ((i2 & 64) == 0) {
                    }
                    function24 = function22;
                    i8 = i4;
                    if ((599187 & i8) == 599186) {
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                    }
                }
                z3 = z;
                i7 = i2 & 32;
                if (i7 == 0) {
                }
                z4 = z2;
                if ((i2 & 64) == 0) {
                }
                function24 = function22;
                i8 = i4;
                if ((599187 & i8) == 599186) {
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                }
            }
            modifier2 = modifier;
            i6 = i2 & 16;
            if (i6 != 0) {
            }
            z3 = z;
            i7 = i2 & 32;
            if (i7 == 0) {
            }
            z4 = z2;
            if ((i2 & 64) == 0) {
            }
            function24 = function22;
            i8 = i4;
            if ((599187 & i8) == 599186) {
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
            }
        }
        function23 = function2;
        if ((i2 & 4) == 0) {
        }
        i5 = i2 & 8;
        if (i5 == 0) {
        }
        modifier2 = modifier;
        i6 = i2 & 16;
        if (i6 != 0) {
        }
        z3 = z;
        i7 = i2 & 32;
        if (i7 == 0) {
        }
        z4 = z2;
        if ((i2 & 64) == 0) {
        }
        function24 = function22;
        i8 = i4;
        if ((599187 & i8) == 599186) {
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Composable
    @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable]]")
    public static final void TooltipPopup(final PopupPositionProvider popupPositionProvider, final BasicTooltipState basicTooltipState, final CoroutineScope coroutineScope, final boolean z, final Function2<? super Composer, ? super Integer, Unit> function2, Composer composer, final int i) {
        PopupPositionProvider popupPositionProvider2;
        int i2;
        Composer composerStartRestartGroup = composer.startRestartGroup(-73658727);
        if ((i & 6) == 0) {
            popupPositionProvider2 = popupPositionProvider;
            i2 = (composerStartRestartGroup.changed(popupPositionProvider2) ? 4 : 2) | i;
        } else {
            popupPositionProvider2 = popupPositionProvider;
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changed(basicTooltipState) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(coroutineScope) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i2 |= composerStartRestartGroup.changed(z) ? 2048 : 1024;
        }
        if ((i & 24576) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(function2) ? 16384 : 8192;
        }
        if ((i2 & 9363) == 9362 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-73658727, i2, -1, "androidx.compose.foundation.TooltipPopup (BasicTooltip.android.kt:124)");
            }
            final String strStringResource = StringResources_androidKt.stringResource(C0822R.string.tooltip_description, composerStartRestartGroup, 0);
            boolean zChangedInstance = ((i2 & 112) == 32) | composerStartRestartGroup.changedInstance(coroutineScope);
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function0<Unit>() { // from class: androidx.compose.foundation.BasicTooltip_androidKt$TooltipPopup$1$1

                    /* JADX INFO: renamed from: androidx.compose.foundation.BasicTooltip_androidKt$TooltipPopup$1$1$1 */
                    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
                    @Metadata(m13885d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m13886d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m13887k = 3, m13888mv = {1, 8, 0}, m13890xi = 48)
                    @DebugMetadata(m14020c = "androidx.compose.foundation.BasicTooltip_androidKt$TooltipPopup$1$1$1", m14021f = "BasicTooltip.android.kt", m14022i = {}, m14023l = {}, m14024m = "invokeSuspend", m14025n = {}, m14026s = {})
                    public static final class C07741 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                        final /* synthetic */ BasicTooltipState $state;
                        int label;

                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        public C07741(BasicTooltipState basicTooltipState, Continuation<? super C07741> continuation) {
                            super(2, continuation);
                            this.$state = basicTooltipState;
                        }

                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                        @NotNull
                        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
                            return new C07741(this.$state, continuation);
                        }

                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                        @Nullable
                        public final Object invokeSuspend(@NotNull Object obj) {
                            IntrinsicsKt.getCOROUTINE_SUSPENDED();
                            if (this.label != 0) {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            ResultKt.throwOnFailure(obj);
                            this.$state.dismiss();
                            return Unit.INSTANCE;
                        }

                        @Override // kotlin.jvm.functions.Function2
                        @Nullable
                        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
                            return ((C07741) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                        }
                    }

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Unit invoke() {
                        invoke2();
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2() {
                        if (basicTooltipState.isVisible()) {
                            BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new C07741(basicTooltipState, null), 3, null);
                        }
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            AndroidPopup_androidKt.Popup(popupPositionProvider2, (Function0) objRememberedValue, new PopupProperties(z, false, false, false, 14, (DefaultConstructorMarker) null), ComposableLambdaKt.rememberComposableLambda(-1147839433, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.BasicTooltip_androidKt.TooltipPopup.2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
                @Composable
                public final void invoke(@Nullable Composer composer2, int i4) {
                    if ((i4 & 3) == 2 && composer2.getSkipping()) {
                        composer2.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1147839433, i4, -1, "androidx.compose.foundation.TooltipPopup.<anonymous> (BasicTooltip.android.kt:135)");
                    }
                    Modifier.Companion companion = Modifier.INSTANCE;
                    boolean zChanged = composer2.changed(strStringResource);
                    final String str = strStringResource;
                    Object objRememberedValue2 = composer2.rememberedValue();
                    if (zChanged || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue2 = new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.foundation.BasicTooltip_androidKt$TooltipPopup$2$1$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                                invoke2(semanticsPropertyReceiver);
                                return Unit.INSTANCE;
                            }

                            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(@NotNull SemanticsPropertyReceiver semanticsPropertyReceiver) {
                                SemanticsPropertiesKt.m20284setLiveRegionhR3wRGc(semanticsPropertyReceiver, LiveRegionMode.INSTANCE.m20257getAssertive0phEisY());
                                SemanticsPropertiesKt.setPaneTitle(semanticsPropertyReceiver, str);
                            }
                        };
                        composer2.updateRememberedValue(objRememberedValue2);
                    }
                    Modifier modifierSemantics$default = SemanticsModifierKt.semantics$default(companion, false, (Function1) objRememberedValue2, 1, null);
                    Function2<Composer, Integer, Unit> function22 = function2;
                    MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                    int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                    CompositionLocalMap currentCompositionLocalMap = composer2.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer2, modifierSemantics$default);
                    ComposeUiNode.Companion companion2 = ComposeUiNode.INSTANCE;
                    Function0<ComposeUiNode> constructor = companion2.getConstructor();
                    if (composer2.getApplier() == null) {
                        ComposablesKt.invalidApplier();
                    }
                    composer2.startReusableNode();
                    if (composer2.getInserting()) {
                        composer2.createNode(constructor);
                    } else {
                        composer2.useNode();
                    }
                    Composer composerM18018constructorimpl = Updater.m18018constructorimpl(composer2);
                    Function2 function2M1177w = AbstractC0622a.m1177w(companion2, composerM18018constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy, composerM18018constructorimpl, currentCompositionLocalMap);
                    if (composerM18018constructorimpl.getInserting() || !Intrinsics.areEqual(composerM18018constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                        AbstractC0622a.m1178x(currentCompositeKeyHash, function2M1177w, composerM18018constructorimpl, currentCompositeKeyHash);
                    }
                    Updater.m18025setimpl(composerM18018constructorimpl, modifierMaterializeModifier, companion2.getSetModifier());
                    BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                    function22.invoke(composer2, 0);
                    composer2.endNode();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }, composerStartRestartGroup, 54), composerStartRestartGroup, (i2 & 14) | 3072, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.BasicTooltip_androidKt.TooltipPopup.3
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(@Nullable Composer composer2, int i4) {
                    BasicTooltip_androidKt.TooltipPopup(popupPositionProvider, basicTooltipState, coroutineScope, z, function2, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Composable
    @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable]]")
    public static final void WrappedAnchor(final boolean z, final BasicTooltipState basicTooltipState, Modifier modifier, final Function2<? super Composer, ? super Integer, Unit> function2, Composer composer, final int i, final int i2) {
        int i4;
        Composer composerStartRestartGroup = composer.startRestartGroup(1712976033);
        if ((i2 & 1) != 0) {
            i4 = i | 6;
        } else if ((i & 6) == 0) {
            i4 = (composerStartRestartGroup.changed(z) ? 4 : 2) | i;
        } else {
            i4 = i;
        }
        if ((i2 & 2) != 0) {
            i4 |= 48;
        } else if ((i & 48) == 0) {
            i4 |= composerStartRestartGroup.changed(basicTooltipState) ? 32 : 16;
        }
        int i5 = i2 & 4;
        if (i5 != 0) {
            i4 |= 384;
        } else if ((i & 384) == 0) {
            i4 |= composerStartRestartGroup.changed(modifier) ? 256 : 128;
        }
        if ((i2 & 8) != 0) {
            i4 |= 3072;
        } else if ((i & 3072) == 0) {
            i4 |= composerStartRestartGroup.changedInstance(function2) ? 2048 : 1024;
        }
        if ((i4 & 1171) == 1170 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (i5 != 0) {
                modifier = Modifier.INSTANCE;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1712976033, i4, -1, "androidx.compose.foundation.WrappedAnchor (BasicTooltip.android.kt:107)");
            }
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = AbstractC0000a.m8e(EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, composerStartRestartGroup), composerStartRestartGroup);
            }
            Modifier modifierAnchorSemantics = anchorSemantics(handleGestures(modifier, z, basicTooltipState), StringResources_androidKt.stringResource(C0822R.string.tooltip_label, composerStartRestartGroup, 0), z, basicTooltipState, ((CompositionScopedCoroutineScopeCanceller) objRememberedValue).getCoroutineScope());
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierAnchorSemantics);
            ComposeUiNode.Companion companion = ComposeUiNode.INSTANCE;
            Function0<ComposeUiNode> constructor = companion.getConstructor();
            if (composerStartRestartGroup.getApplier() == null) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor);
            } else {
                composerStartRestartGroup.useNode();
            }
            Composer composerM18018constructorimpl = Updater.m18018constructorimpl(composerStartRestartGroup);
            Function2 function2M1177w = AbstractC0622a.m1177w(companion, composerM18018constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy, composerM18018constructorimpl, currentCompositionLocalMap);
            if (composerM18018constructorimpl.getInserting() || !Intrinsics.areEqual(composerM18018constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                AbstractC0622a.m1178x(currentCompositeKeyHash, function2M1177w, composerM18018constructorimpl, currentCompositeKeyHash);
            }
            Updater.m18025setimpl(composerM18018constructorimpl, modifierMaterializeModifier, companion.getSetModifier());
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            function2.invoke(composerStartRestartGroup, Integer.valueOf((i4 >> 9) & 14));
            composerStartRestartGroup.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        final Modifier modifier2 = modifier;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.BasicTooltip_androidKt.WrappedAnchor.2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(@Nullable Composer composer2, int i6) {
                    BasicTooltip_androidKt.WrappedAnchor(z, basicTooltipState, modifier2, function2, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                }
            });
        }
    }

    private static final Modifier anchorSemantics(Modifier modifier, final String str, boolean z, final BasicTooltipState basicTooltipState, final CoroutineScope coroutineScope) {
        return z ? SemanticsModifierKt.semantics(modifier, true, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.foundation.BasicTooltip_androidKt.anchorSemantics.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                invoke2(semanticsPropertyReceiver);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull SemanticsPropertyReceiver semanticsPropertyReceiver) {
                String str2 = str;
                final CoroutineScope coroutineScope2 = coroutineScope;
                final BasicTooltipState basicTooltipState2 = basicTooltipState;
                SemanticsPropertiesKt.onLongClick(semanticsPropertyReceiver, str2, new Function0<Boolean>() { // from class: androidx.compose.foundation.BasicTooltip_androidKt.anchorSemantics.1.1

                    /* JADX INFO: renamed from: androidx.compose.foundation.BasicTooltip_androidKt$anchorSemantics$1$1$1, reason: invalid class name and collision with other inner class name */
                    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
                    @Metadata(m13885d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m13886d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m13887k = 3, m13888mv = {1, 8, 0}, m13890xi = 48)
                    @DebugMetadata(m14020c = "androidx.compose.foundation.BasicTooltip_androidKt$anchorSemantics$1$1$1", m14021f = "BasicTooltip.android.kt", m14022i = {}, m14023l = {JPEG.SOI}, m14024m = "invokeSuspend", m14025n = {}, m14026s = {})
                    public static final class C145251 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                        final /* synthetic */ BasicTooltipState $state;
                        int label;

                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        public C145251(BasicTooltipState basicTooltipState, Continuation<? super C145251> continuation) {
                            super(2, continuation);
                            this.$state = basicTooltipState;
                        }

                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                        @NotNull
                        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
                            return new C145251(this.$state, continuation);
                        }

                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                        @Nullable
                        public final Object invokeSuspend(@NotNull Object obj) {
                            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                            int i = this.label;
                            if (i == 0) {
                                ResultKt.throwOnFailure(obj);
                                BasicTooltipState basicTooltipState = this.$state;
                                this.label = 1;
                                if (BasicTooltipState.show$default(basicTooltipState, null, this, 1, null) == coroutine_suspended) {
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

                        @Override // kotlin.jvm.functions.Function2
                        @Nullable
                        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
                            return ((C145251) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                        }
                    }

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function0
                    @NotNull
                    public final Boolean invoke() {
                        BuildersKt__Builders_commonKt.launch$default(coroutineScope2, null, null, new C145251(basicTooltipState2, null), 3, null);
                        return Boolean.TRUE;
                    }
                });
            }
        }) : modifier;
    }

    private static final Modifier handleGestures(Modifier modifier, boolean z, BasicTooltipState basicTooltipState) {
        return z ? SuspendingPointerInputFilterKt.pointerInput(SuspendingPointerInputFilterKt.pointerInput(modifier, basicTooltipState, new C07791(basicTooltipState, null)), basicTooltipState, new C07802(basicTooltipState, null)) : modifier;
    }
}
