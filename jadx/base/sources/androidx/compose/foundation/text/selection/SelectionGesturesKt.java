package androidx.compose.foundation.text.selection;

import androidx.compose.foundation.gestures.DragGestureDetectorKt;
import androidx.compose.foundation.gestures.ForEachGestureKt;
import androidx.compose.foundation.text.TextDragObserver;
import androidx.compose.p109ui.Modifier;
import androidx.compose.p109ui.geometry.Offset;
import androidx.compose.p109ui.input.pointer.AwaitPointerEventScope;
import androidx.compose.p109ui.input.pointer.PointerEvent;
import androidx.compose.p109ui.input.pointer.PointerEventKt;
import androidx.compose.p109ui.input.pointer.PointerEventPass;
import androidx.compose.p109ui.input.pointer.PointerEvent_androidKt;
import androidx.compose.p109ui.input.pointer.PointerInputChange;
import androidx.compose.p109ui.input.pointer.PointerInputScope;
import androidx.compose.p109ui.input.pointer.PointerType;
import androidx.compose.p109ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.p109ui.platform.ViewConfiguration;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.sun.imageio.plugins.jpeg.JPEG;
import java.util.List;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m13885d1 = {"\u0000Z\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\u001a \u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH\u0002\u001a\u0012\u0010\f\u001a\u00020\u0004*\u00020\rH\u0082@¢\u0006\u0002\u0010\u000e\u001a*\u0010\u000f\u001a\u00020\u0010*\u00020\r2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0004H\u0082@¢\u0006\u0002\u0010\u0016\u001a*\u0010\u0017\u001a\u00020\u0010*\u00020\r2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0004H\u0082@¢\u0006\u0002\u0010\u0016\u001a\u001c\u0010\u0018\u001a\u00020\u0019*\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00122\u0006\u0010\u001b\u001a\u00020\u001cH\u0000\u001a\"\u0010\u001d\u001a\u00020\u0010*\u00020\u001e2\u0006\u0010\u001a\u001a\u00020\u00122\u0006\u0010\u001b\u001a\u00020\u001cH\u0080@¢\u0006\u0002\u0010\u001f\u001a\"\u0010 \u001a\u00020\u0010*\u00020\r2\u0006\u0010\u0011\u001a\u00020\u001c2\u0006\u0010\u0015\u001a\u00020\u0004H\u0082@¢\u0006\u0002\u0010!\u001a\"\u0010\"\u001a\u00020\u0010*\u00020\r2\u0006\u0010\u0011\u001a\u00020\u001c2\u0006\u0010#\u001a\u00020\u0004H\u0082@¢\u0006\u0002\u0010!\u001a\"\u0010$\u001a\u00020\u0010*\u00020\r2\u0006\u0010\u0011\u001a\u00020\u001c2\u0006\u0010#\u001a\u00020\u0004H\u0082@¢\u0006\u0002\u0010!\u001a \u0010%\u001a\u00020\u0019*\u00020\u00192\u0012\u0010&\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00100'H\u0000\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u0018\u0010\u0002\u001a\u00020\u0003*\u00020\u00048@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0002\u0010\u0005¨\u0006("}, m13886d2 = {"STATIC_KEY", "", "isPrecisePointer", "", "Landroidx/compose/ui/input/pointer/PointerEvent;", "(Landroidx/compose/ui/input/pointer/PointerEvent;)Z", "distanceIsTolerable", "viewConfiguration", "Landroidx/compose/ui/platform/ViewConfiguration;", "change1", "Landroidx/compose/ui/input/pointer/PointerInputChange;", "change2", "awaitDown", "Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;", "(Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "mouseSelection", "", "observer", "Landroidx/compose/foundation/text/selection/MouseSelectionObserver;", "clicksCounter", "Landroidx/compose/foundation/text/selection/ClicksCounter;", "down", "(Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;Landroidx/compose/foundation/text/selection/MouseSelectionObserver;Landroidx/compose/foundation/text/selection/ClicksCounter;Landroidx/compose/ui/input/pointer/PointerEvent;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "mouseSelectionBtf2", "selectionGestureInput", "Landroidx/compose/ui/Modifier;", "mouseSelectionObserver", "textDragObserver", "Landroidx/compose/foundation/text/TextDragObserver;", "selectionGesturePointerInputBtf2", "Landroidx/compose/ui/input/pointer/PointerInputScope;", "(Landroidx/compose/ui/input/pointer/PointerInputScope;Landroidx/compose/foundation/text/selection/MouseSelectionObserver;Landroidx/compose/foundation/text/TextDragObserver;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "touchSelection", "(Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;Landroidx/compose/foundation/text/TextDragObserver;Landroidx/compose/ui/input/pointer/PointerEvent;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "touchSelectionFirstPress", "downEvent", "touchSelectionSubsequentPress", "updateSelectionTouchMode", "updateTouchMode", "Lkotlin/Function1;", "foundation_release"}, m13887k = 2, m13888mv = {1, 8, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nSelectionGestures.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SelectionGestures.kt\nandroidx/compose/foundation/text/selection/SelectionGesturesKt\n+ 2 ListUtils.kt\nandroidx/compose/ui/util/ListUtilsKt\n*L\n1#1,444:1\n33#2,6:445\n33#2,6:451\n33#2,6:457\n33#2,6:463\n33#2,6:469\n33#2,6:475\n33#2,6:481\n86#2,2:487\n33#2,6:489\n88#2:495\n86#2,2:496\n33#2,6:498\n88#2:504\n*S KotlinDebug\n*F\n+ 1 SelectionGestures.kt\nandroidx/compose/foundation/text/selection/SelectionGesturesKt\n*L\n134#1:445,6\n165#1:451,6\n188#1:457,6\n247#1:463,6\n322#1:469,6\n358#1:475,6\n384#1:481,6\n426#1:487,2\n426#1:489,6\n426#1:495\n443#1:496,2\n443#1:498,6\n443#1:504\n*E\n"})
public final class SelectionGesturesKt {
    private static final int STATIC_KEY = 8675309;

    /* JADX INFO: renamed from: androidx.compose.foundation.text.selection.SelectionGesturesKt$awaitDown$1 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13887k = 3, m13888mv = {1, 8, 0}, m13890xi = 48)
    @DebugMetadata(m14020c = "androidx.compose.foundation.text.selection.SelectionGesturesKt", m14021f = "SelectionGestures.kt", m14022i = {0}, m14023l = {TypedValues.Cycle.TYPE_WAVE_PHASE}, m14024m = "awaitDown", m14025n = {"$this$awaitDown"}, m14026s = {"L$0"})
    public static final class C14131 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        public C14131(Continuation<? super C14131> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return SelectionGesturesKt.awaitDown(null, this);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.text.selection.SelectionGesturesKt$mouseSelection$1 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13887k = 3, m13888mv = {1, 8, 0}, m13890xi = 48)
    @DebugMetadata(m14020c = "androidx.compose.foundation.text.selection.SelectionGesturesKt", m14021f = "SelectionGestures.kt", m14022i = {0, 0, 1, 1}, m14023l = {158, 181}, m14024m = "mouseSelection", m14025n = {"$this$mouseSelection", "observer", "$this$mouseSelection", "observer"}, m14026s = {"L$0", "L$1", "L$0", "L$1"})
    public static final class C14141 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        public C14141(Continuation<? super C14141> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return SelectionGesturesKt.mouseSelection(null, null, null, null, this);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.text.selection.SelectionGesturesKt$mouseSelectionBtf2$1 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13887k = 3, m13888mv = {1, 8, 0}, m13890xi = 48)
    @DebugMetadata(m14020c = "androidx.compose.foundation.text.selection.SelectionGesturesKt", m14021f = "SelectionGestures.kt", m14022i = {0, 0, 1, 1}, m14023l = {351, 377}, m14024m = "mouseSelectionBtf2", m14025n = {"$this$mouseSelectionBtf2", "observer", "$this$mouseSelectionBtf2", "observer"}, m14026s = {"L$0", "L$1", "L$0", "L$1"})
    public static final class C14151 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        public C14151(Continuation<? super C14151> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return SelectionGesturesKt.mouseSelectionBtf2(null, null, null, null, this);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.text.selection.SelectionGesturesKt$selectionGestureInput$1 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m13886d2 = {"<anonymous>", "", "Landroidx/compose/ui/input/pointer/PointerInputScope;"}, m13887k = 3, m13888mv = {1, 8, 0}, m13890xi = 48)
    @DebugMetadata(m14020c = "androidx.compose.foundation.text.selection.SelectionGesturesKt$selectionGestureInput$1", m14021f = "SelectionGestures.kt", m14022i = {}, m14023l = {104}, m14024m = "invokeSuspend", m14025n = {}, m14026s = {})
    public static final class C14161 extends SuspendLambda implements Function2<PointerInputScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ MouseSelectionObserver $mouseSelectionObserver;
        final /* synthetic */ TextDragObserver $textDragObserver;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX INFO: renamed from: androidx.compose.foundation.text.selection.SelectionGesturesKt$selectionGestureInput$1$1, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        @Metadata(m13885d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m13886d2 = {"<anonymous>", "", "Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;"}, m13887k = 3, m13888mv = {1, 8, 0}, m13890xi = 48)
        @DebugMetadata(m14020c = "androidx.compose.foundation.text.selection.SelectionGesturesKt$selectionGestureInput$1$1", m14021f = "SelectionGestures.kt", m14022i = {0}, m14023l = {105, 111, 113}, m14024m = "invokeSuspend", m14025n = {"$this$awaitEachGesture"}, m14026s = {"L$0"})
        @SourceDebugExtension({"SMAP\nSelectionGestures.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SelectionGestures.kt\nandroidx/compose/foundation/text/selection/SelectionGesturesKt$selectionGestureInput$1$1\n+ 2 ListUtils.kt\nandroidx/compose/ui/util/ListUtilsKt\n*L\n1#1,444:1\n86#2,2:445\n33#2,6:447\n88#2:453\n*S KotlinDebug\n*F\n+ 1 SelectionGestures.kt\nandroidx/compose/foundation/text/selection/SelectionGesturesKt$selectionGestureInput$1$1\n*L\n109#1:445,2\n109#1:447,6\n109#1:453\n*E\n"})
        public static final class AnonymousClass1 extends RestrictedSuspendLambda implements Function2<AwaitPointerEventScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ ClicksCounter $clicksCounter;
            final /* synthetic */ MouseSelectionObserver $mouseSelectionObserver;
            final /* synthetic */ TextDragObserver $textDragObserver;
            private /* synthetic */ Object L$0;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass1(MouseSelectionObserver mouseSelectionObserver, ClicksCounter clicksCounter, TextDragObserver textDragObserver, Continuation<? super AnonymousClass1> continuation) {
                super(2, continuation);
                this.$mouseSelectionObserver = mouseSelectionObserver;
                this.$clicksCounter = clicksCounter;
                this.$textDragObserver = textDragObserver;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @NotNull
            public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$mouseSelectionObserver, this.$clicksCounter, this.$textDragObserver, continuation);
                anonymousClass1.L$0 = obj;
                return anonymousClass1;
            }

            @Override // kotlin.jvm.functions.Function2
            @Nullable
            public final Object invoke(@NotNull AwaitPointerEventScope awaitPointerEventScope, @Nullable Continuation<? super Unit> continuation) {
                return ((AnonymousClass1) create(awaitPointerEventScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            /* JADX WARN: Code restructure failed: missing block: B:26:0x0074, code lost:
            
                if (androidx.compose.foundation.text.selection.SelectionGesturesKt.mouseSelection(r1, r2, r4, r10, r9) == r0) goto L32;
             */
            /* JADX WARN: Code restructure failed: missing block: B:31:0x0087, code lost:
            
                if (androidx.compose.foundation.text.selection.SelectionGesturesKt.touchSelection(r1, r3, r10, r9) == r0) goto L32;
             */
            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @Nullable
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public final Object invokeSuspend(@NotNull Object obj) {
                AwaitPointerEventScope awaitPointerEventScope;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i = this.label;
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    awaitPointerEventScope = (AwaitPointerEventScope) this.L$0;
                    this.L$0 = awaitPointerEventScope;
                    this.label = 1;
                    obj = SelectionGesturesKt.awaitDown(awaitPointerEventScope, this);
                    if (obj != coroutine_suspended) {
                    }
                    return coroutine_suspended;
                }
                if (i != 1) {
                    if (i != 2 && i != 3) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                    return Unit.INSTANCE;
                }
                awaitPointerEventScope = (AwaitPointerEventScope) this.L$0;
                ResultKt.throwOnFailure(obj);
                PointerEvent pointerEvent = (PointerEvent) obj;
                if (SelectionGesturesKt.isPrecisePointer(pointerEvent) && PointerEvent_androidKt.m19699isPrimaryPressedaHzCxE(pointerEvent.getButtons())) {
                    List<PointerInputChange> changes = pointerEvent.getChanges();
                    int size = changes.size();
                    for (int i2 = 0; i2 < size; i2++) {
                        if (!changes.get(i2).isConsumed()) {
                        }
                    }
                    MouseSelectionObserver mouseSelectionObserver = this.$mouseSelectionObserver;
                    ClicksCounter clicksCounter = this.$clicksCounter;
                    this.L$0 = null;
                    this.label = 2;
                }
                if (!SelectionGesturesKt.isPrecisePointer(pointerEvent)) {
                    TextDragObserver textDragObserver = this.$textDragObserver;
                    this.L$0 = null;
                    this.label = 3;
                }
                return Unit.INSTANCE;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C14161(MouseSelectionObserver mouseSelectionObserver, TextDragObserver textDragObserver, Continuation<? super C14161> continuation) {
            super(2, continuation);
            this.$mouseSelectionObserver = mouseSelectionObserver;
            this.$textDragObserver = textDragObserver;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            C14161 c14161 = new C14161(this.$mouseSelectionObserver, this.$textDragObserver, continuation);
            c14161.L$0 = obj;
            return c14161;
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        public final Object invoke(@NotNull PointerInputScope pointerInputScope, @Nullable Continuation<? super Unit> continuation) {
            return ((C14161) create(pointerInputScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                PointerInputScope pointerInputScope = (PointerInputScope) this.L$0;
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$mouseSelectionObserver, new ClicksCounter(pointerInputScope.getViewConfiguration()), this.$textDragObserver, null);
                this.label = 1;
                if (ForEachGestureKt.awaitEachGesture(pointerInputScope, anonymousClass1, this) == coroutine_suspended) {
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

    /* JADX INFO: renamed from: androidx.compose.foundation.text.selection.SelectionGesturesKt$selectionGesturePointerInputBtf2$2 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m13886d2 = {"<anonymous>", "", "Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;"}, m13887k = 3, m13888mv = {1, 8, 0}, m13890xi = 48)
    @DebugMetadata(m14020c = "androidx.compose.foundation.text.selection.SelectionGesturesKt$selectionGesturePointerInputBtf2$2", m14021f = "SelectionGestures.kt", m14022i = {0}, m14023l = {JPEG.RST1, JPEG.EOI, 220, JPEG.DRI}, m14024m = "invokeSuspend", m14025n = {"$this$awaitEachGesture"}, m14026s = {"L$0"})
    @SourceDebugExtension({"SMAP\nSelectionGestures.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SelectionGestures.kt\nandroidx/compose/foundation/text/selection/SelectionGesturesKt$selectionGesturePointerInputBtf2$2\n+ 2 ListUtils.kt\nandroidx/compose/ui/util/ListUtilsKt\n*L\n1#1,444:1\n86#2,2:445\n33#2,6:447\n88#2:453\n*S KotlinDebug\n*F\n+ 1 SelectionGestures.kt\nandroidx/compose/foundation/text/selection/SelectionGesturesKt$selectionGesturePointerInputBtf2$2\n*L\n215#1:445,2\n215#1:447,6\n215#1:453\n*E\n"})
    public static final class C14172 extends RestrictedSuspendLambda implements Function2<AwaitPointerEventScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ ClicksCounter $clicksCounter;
        final /* synthetic */ MouseSelectionObserver $mouseSelectionObserver;
        final /* synthetic */ TextDragObserver $textDragObserver;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C14172(ClicksCounter clicksCounter, MouseSelectionObserver mouseSelectionObserver, TextDragObserver textDragObserver, Continuation<? super C14172> continuation) {
            super(2, continuation);
            this.$clicksCounter = clicksCounter;
            this.$mouseSelectionObserver = mouseSelectionObserver;
            this.$textDragObserver = textDragObserver;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            C14172 c14172 = new C14172(this.$clicksCounter, this.$mouseSelectionObserver, this.$textDragObserver, continuation);
            c14172.L$0 = obj;
            return c14172;
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        public final Object invoke(@NotNull AwaitPointerEventScope awaitPointerEventScope, @Nullable Continuation<? super Unit> continuation) {
            return ((C14172) create(awaitPointerEventScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code restructure failed: missing block: B:27:0x007c, code lost:
        
            if (androidx.compose.foundation.text.selection.SelectionGesturesKt.mouseSelectionBtf2(r1, r2, r3, r13, r12) == r0) goto L37;
         */
        /* JADX WARN: Code restructure failed: missing block: B:33:0x0093, code lost:
        
            if (androidx.compose.foundation.text.selection.SelectionGesturesKt.touchSelectionFirstPress(r1, r2, r13, r12) == r0) goto L37;
         */
        /* JADX WARN: Code restructure failed: missing block: B:36:0x00a0, code lost:
        
            if (androidx.compose.foundation.text.selection.SelectionGesturesKt.touchSelectionSubsequentPress(r1, r3, r13, r12) == r0) goto L37;
         */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(@NotNull Object obj) {
            AwaitPointerEventScope awaitPointerEventScope;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                awaitPointerEventScope = (AwaitPointerEventScope) this.L$0;
                this.L$0 = awaitPointerEventScope;
                this.label = 1;
                obj = SelectionGesturesKt.awaitDown(awaitPointerEventScope, this);
                if (obj != coroutine_suspended) {
                }
                return coroutine_suspended;
            }
            if (i != 1) {
                if (i != 2 && i != 3 && i != 4) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                return Unit.INSTANCE;
            }
            awaitPointerEventScope = (AwaitPointerEventScope) this.L$0;
            ResultKt.throwOnFailure(obj);
            PointerEvent pointerEvent = (PointerEvent) obj;
            this.$clicksCounter.update(pointerEvent);
            boolean zIsPrecisePointer = SelectionGesturesKt.isPrecisePointer(pointerEvent);
            if (zIsPrecisePointer && PointerEvent_androidKt.m19699isPrimaryPressedaHzCxE(pointerEvent.getButtons())) {
                List<PointerInputChange> changes = pointerEvent.getChanges();
                int size = changes.size();
                for (int i2 = 0; i2 < size; i2++) {
                    if (!changes.get(i2).isConsumed()) {
                    }
                }
                MouseSelectionObserver mouseSelectionObserver = this.$mouseSelectionObserver;
                ClicksCounter clicksCounter = this.$clicksCounter;
                this.L$0 = null;
                this.label = 2;
            }
            if (!zIsPrecisePointer) {
                if (this.$clicksCounter.getClicks() == 1) {
                    TextDragObserver textDragObserver = this.$textDragObserver;
                    this.L$0 = null;
                    this.label = 3;
                } else {
                    TextDragObserver textDragObserver2 = this.$textDragObserver;
                    this.L$0 = null;
                    this.label = 4;
                }
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.text.selection.SelectionGesturesKt$touchSelection$1 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13887k = 3, m13888mv = {1, 8, 0}, m13890xi = 48)
    @DebugMetadata(m14020c = "androidx.compose.foundation.text.selection.SelectionGesturesKt", m14021f = "SelectionGestures.kt", m14022i = {0, 0, 0, 1, 1}, m14023l = {124, 128}, m14024m = "touchSelection", m14025n = {"$this$touchSelection", "observer", "firstDown", "$this$touchSelection", "observer"}, m14026s = {"L$0", "L$1", "L$2", "L$0", "L$1"})
    public static final class C14181 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        public C14181(Continuation<? super C14181> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return SelectionGesturesKt.touchSelection(null, null, null, this);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.text.selection.SelectionGesturesKt$touchSelectionFirstPress$1 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13887k = 3, m13888mv = {1, 8, 0}, m13890xi = 48)
    @DebugMetadata(m14020c = "androidx.compose.foundation.text.selection.SelectionGesturesKt", m14021f = "SelectionGestures.kt", m14022i = {0, 0, 0, 1, 1}, m14023l = {JPEG.APP14, 241}, m14024m = "touchSelectionFirstPress", m14025n = {"$this$touchSelectionFirstPress", "observer", "firstDown", "$this$touchSelectionFirstPress", "observer"}, m14026s = {"L$0", "L$1", "L$2", "L$0", "L$1"})
    public static final class C14201 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        public C14201(Continuation<? super C14201> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return SelectionGesturesKt.touchSelectionFirstPress(null, null, null, this);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.text.selection.SelectionGesturesKt$touchSelectionSubsequentPress$1 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13887k = 3, m13888mv = {1, 8, 0}, m13890xi = 48)
    @DebugMetadata(m14020c = "androidx.compose.foundation.text.selection.SelectionGesturesKt", m14021f = "SelectionGestures.kt", m14022i = {0, 0, 0, 0, 0, 1, 1}, m14023l = {276, 315}, m14024m = "touchSelectionSubsequentPress", m14025n = {"$this$touchSelectionSubsequentPress", "observer", "firstDown", "overSlop", "pointerId", "$this$touchSelectionSubsequentPress", "observer"}, m14026s = {"L$0", "L$1", "L$2", "L$3", "J$0", "L$0", "L$1"})
    public static final class C14221 extends ContinuationImpl {
        long J$0;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        /* synthetic */ Object result;

        public C14221(Continuation<? super C14221> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return SelectionGesturesKt.touchSelectionSubsequentPress(null, null, null, this);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.text.selection.SelectionGesturesKt$updateSelectionTouchMode$1 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m13886d2 = {"<anonymous>", "", "Landroidx/compose/ui/input/pointer/PointerInputScope;"}, m13887k = 3, m13888mv = {1, 8, 0}, m13890xi = 48)
    @DebugMetadata(m14020c = "androidx.compose.foundation.text.selection.SelectionGesturesKt$updateSelectionTouchMode$1", m14021f = "SelectionGestures.kt", m14022i = {}, m14023l = {91}, m14024m = "invokeSuspend", m14025n = {}, m14026s = {})
    public static final class C14261 extends SuspendLambda implements Function2<PointerInputScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function1<Boolean, Unit> $updateTouchMode;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX INFO: renamed from: androidx.compose.foundation.text.selection.SelectionGesturesKt$updateSelectionTouchMode$1$1, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        @Metadata(m13885d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m13886d2 = {"<anonymous>", "", "Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;"}, m13887k = 3, m13888mv = {1, 8, 0}, m13890xi = 48)
        @DebugMetadata(m14020c = "androidx.compose.foundation.text.selection.SelectionGesturesKt$updateSelectionTouchMode$1$1", m14021f = "SelectionGestures.kt", m14022i = {0}, m14023l = {93}, m14024m = "invokeSuspend", m14025n = {"$this$awaitPointerEventScope"}, m14026s = {"L$0"})
        public static final class AnonymousClass1 extends RestrictedSuspendLambda implements Function2<AwaitPointerEventScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ Function1<Boolean, Unit> $updateTouchMode;
            private /* synthetic */ Object L$0;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            public AnonymousClass1(Function1<? super Boolean, Unit> function1, Continuation<? super AnonymousClass1> continuation) {
                super(2, continuation);
                this.$updateTouchMode = function1;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @NotNull
            public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$updateTouchMode, continuation);
                anonymousClass1.L$0 = obj;
                return anonymousClass1;
            }

            @Override // kotlin.jvm.functions.Function2
            @Nullable
            public final Object invoke(@NotNull AwaitPointerEventScope awaitPointerEventScope, @Nullable Continuation<? super Unit> continuation) {
                return ((AnonymousClass1) create(awaitPointerEventScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            /* JADX WARN: Removed duplicated region for block: B:11:0x002f A[RETURN] */
            /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x002d -> B:12:0x0030). Please report as a decompilation issue!!! */
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
            public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r5) {
                /*
                    r4 = this;
                    java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                    int r1 = r4.label
                    r2 = 1
                    if (r1 == 0) goto L1b
                    if (r1 != r2) goto L13
                    java.lang.Object r1 = r4.L$0
                    androidx.compose.ui.input.pointer.AwaitPointerEventScope r1 = (androidx.compose.p109ui.input.pointer.AwaitPointerEventScope) r1
                    kotlin.ResultKt.throwOnFailure(r5)
                    goto L30
                L13:
                    java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                    java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                    r5.<init>(r0)
                    throw r5
                L1b:
                    kotlin.ResultKt.throwOnFailure(r5)
                    java.lang.Object r5 = r4.L$0
                    androidx.compose.ui.input.pointer.AwaitPointerEventScope r5 = (androidx.compose.p109ui.input.pointer.AwaitPointerEventScope) r5
                    r1 = r5
                L23:
                    androidx.compose.ui.input.pointer.PointerEventPass r5 = androidx.compose.p109ui.input.pointer.PointerEventPass.Initial
                    r4.L$0 = r1
                    r4.label = r2
                    java.lang.Object r5 = r1.awaitPointerEvent(r5, r4)
                    if (r5 != r0) goto L30
                    return r0
                L30:
                    androidx.compose.ui.input.pointer.PointerEvent r5 = (androidx.compose.p109ui.input.pointer.PointerEvent) r5
                    kotlin.jvm.functions.Function1<java.lang.Boolean, kotlin.Unit> r3 = r4.$updateTouchMode
                    boolean r5 = androidx.compose.foundation.text.selection.SelectionGesturesKt.isPrecisePointer(r5)
                    r5 = r5 ^ r2
                    java.lang.Boolean r5 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r5)
                    r3.invoke(r5)
                    goto L23
                */
                throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text.selection.SelectionGesturesKt.C14261.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public C14261(Function1<? super Boolean, Unit> function1, Continuation<? super C14261> continuation) {
            super(2, continuation);
            this.$updateTouchMode = function1;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            C14261 c14261 = new C14261(this.$updateTouchMode, continuation);
            c14261.L$0 = obj;
            return c14261;
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        public final Object invoke(@NotNull PointerInputScope pointerInputScope, @Nullable Continuation<? super Unit> continuation) {
            return ((C14261) create(pointerInputScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                PointerInputScope pointerInputScope = (PointerInputScope) this.L$0;
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$updateTouchMode, null);
                this.label = 1;
                if (pointerInputScope.awaitPointerEventScope(anonymousClass1, this) == coroutine_suspended) {
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

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0044 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0052  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:16:0x0042 -> B:18:0x0045). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object awaitDown(AwaitPointerEventScope awaitPointerEventScope, Continuation<? super PointerEvent> continuation) {
        C14131 c14131;
        int size;
        int i;
        if (continuation instanceof C14131) {
            c14131 = (C14131) continuation;
            int i2 = c14131.label;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                c14131.label = i2 - Integer.MIN_VALUE;
            } else {
                c14131 = new C14131(continuation);
            }
        }
        Object objAwaitPointerEvent = c14131.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i4 = c14131.label;
        if (i4 == 0) {
            ResultKt.throwOnFailure(objAwaitPointerEvent);
            PointerEventPass pointerEventPass = PointerEventPass.Main;
            c14131.L$0 = awaitPointerEventScope;
            c14131.label = 1;
            objAwaitPointerEvent = awaitPointerEventScope.awaitPointerEvent(pointerEventPass, c14131);
            if (objAwaitPointerEvent == coroutine_suspended) {
            }
            PointerEvent pointerEvent = (PointerEvent) objAwaitPointerEvent;
            List<PointerInputChange> changes = pointerEvent.getChanges();
            size = changes.size();
            i = 0;
            while (i < size) {
            }
            return pointerEvent;
        }
        if (i4 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        awaitPointerEventScope = (AwaitPointerEventScope) c14131.L$0;
        ResultKt.throwOnFailure(objAwaitPointerEvent);
        PointerEvent pointerEvent2 = (PointerEvent) objAwaitPointerEvent;
        List<PointerInputChange> changes2 = pointerEvent2.getChanges();
        size = changes2.size();
        i = 0;
        while (i < size) {
            if (PointerEventKt.changedToDownIgnoreConsumed(changes2.get(i))) {
                i++;
            } else {
                PointerEventPass pointerEventPass2 = PointerEventPass.Main;
                c14131.L$0 = awaitPointerEventScope;
                c14131.label = 1;
                objAwaitPointerEvent = awaitPointerEventScope.awaitPointerEvent(pointerEventPass2, c14131);
                if (objAwaitPointerEvent == coroutine_suspended) {
                    return coroutine_suspended;
                }
                PointerEvent pointerEvent22 = (PointerEvent) objAwaitPointerEvent;
                List<PointerInputChange> changes22 = pointerEvent22.getChanges();
                size = changes22.size();
                i = 0;
                while (i < size) {
                }
            }
        }
        return pointerEvent22;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean distanceIsTolerable(ViewConfiguration viewConfiguration, PointerInputChange pointerInputChange, PointerInputChange pointerInputChange2) {
        return Offset.m18282getDistanceimpl(Offset.m18288minusMKHz9U(pointerInputChange.getPosition(), pointerInputChange2.getPosition())) < DragGestureDetectorKt.m15598pointerSlopE8SPZFQ(viewConfiguration, pointerInputChange.getType());
    }

    public static final boolean isPrecisePointer(@NotNull PointerEvent pointerEvent) {
        List<PointerInputChange> changes = pointerEvent.getChanges();
        int size = changes.size();
        for (int i = 0; i < size; i++) {
            if (!PointerType.m19798equalsimpl0(changes.get(i).getType(), PointerType.INSTANCE.m19803getMouseT8wyACA())) {
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x007f, code lost:
    
        if (r11 == r1) goto L42;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x00e7, code lost:
    
        if (r11 == r1) goto L42;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x00e9, code lost:
    
        return r1;
     */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object mouseSelection(AwaitPointerEventScope awaitPointerEventScope, final MouseSelectionObserver mouseSelectionObserver, ClicksCounter clicksCounter, PointerEvent pointerEvent, Continuation<? super Unit> continuation) {
        C14141 c14141;
        if (continuation instanceof C14141) {
            c14141 = (C14141) continuation;
            int i = c14141.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c14141.label = i - Integer.MIN_VALUE;
            } else {
                c14141 = new C14141(continuation);
            }
        }
        Object objM15595dragjO51t88 = c14141.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = c14141.label;
        int i4 = 0;
        if (i2 == 0) {
            ResultKt.throwOnFailure(objM15595dragjO51t88);
            clicksCounter.update(pointerEvent);
            PointerInputChange pointerInputChange = pointerEvent.getChanges().get(0);
            if (!TextFieldSelectionManager_androidKt.isShiftPressed(pointerEvent)) {
                int clicks = clicksCounter.getClicks();
                final SelectionAdjustment paragraph = clicks != 1 ? clicks != 2 ? SelectionAdjustment.INSTANCE.getParagraph() : SelectionAdjustment.INSTANCE.getWord() : SelectionAdjustment.INSTANCE.getNone();
                if (mouseSelectionObserver.mo16444onStart3MmeM6k(pointerInputChange.getPosition(), paragraph)) {
                    long id = pointerInputChange.getId();
                    Function1<PointerInputChange, Unit> function1 = new Function1<PointerInputChange, Unit>() { // from class: androidx.compose.foundation.text.selection.SelectionGesturesKt$mouseSelection$shouldConsumeUp$2
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(PointerInputChange pointerInputChange2) {
                            invoke2(pointerInputChange2);
                            return Unit.INSTANCE;
                        }

                        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(@NotNull PointerInputChange pointerInputChange2) {
                            if (mouseSelectionObserver.mo16441onDrag3MmeM6k(pointerInputChange2.getPosition(), paragraph)) {
                                pointerInputChange2.consume();
                            }
                        }
                    };
                    c14141.L$0 = awaitPointerEventScope;
                    c14141.L$1 = mouseSelectionObserver;
                    c14141.label = 2;
                    objM15595dragjO51t88 = DragGestureDetectorKt.m15595dragjO51t88(awaitPointerEventScope, id, function1, c14141);
                }
            } else if (mouseSelectionObserver.mo16442onExtendk4lQ0M(pointerInputChange.getPosition())) {
                long id2 = pointerInputChange.getId();
                Function1<PointerInputChange, Unit> function12 = new Function1<PointerInputChange, Unit>() { // from class: androidx.compose.foundation.text.selection.SelectionGesturesKt$mouseSelection$shouldConsumeUp$1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(PointerInputChange pointerInputChange2) {
                        invoke2(pointerInputChange2);
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(@NotNull PointerInputChange pointerInputChange2) {
                        if (mouseSelectionObserver.mo16443onExtendDragk4lQ0M(pointerInputChange2.getPosition())) {
                            pointerInputChange2.consume();
                        }
                    }
                };
                c14141.L$0 = awaitPointerEventScope;
                c14141.L$1 = mouseSelectionObserver;
                c14141.label = 1;
                objM15595dragjO51t88 = DragGestureDetectorKt.m15595dragjO51t88(awaitPointerEventScope, id2, function12, c14141);
            }
        } else if (i2 == 1) {
            mouseSelectionObserver = (MouseSelectionObserver) c14141.L$1;
            awaitPointerEventScope = (AwaitPointerEventScope) c14141.L$0;
            ResultKt.throwOnFailure(objM15595dragjO51t88);
            if (((Boolean) objM15595dragjO51t88).booleanValue()) {
                List<PointerInputChange> changes = awaitPointerEventScope.getCurrentEvent().getChanges();
                int size = changes.size();
                while (i4 < size) {
                    PointerInputChange pointerInputChange2 = changes.get(i4);
                    if (PointerEventKt.changedToUp(pointerInputChange2)) {
                        pointerInputChange2.consume();
                    }
                    i4++;
                }
            }
            mouseSelectionObserver.onDragDone();
        } else {
            if (i2 != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            mouseSelectionObserver = (MouseSelectionObserver) c14141.L$1;
            awaitPointerEventScope = (AwaitPointerEventScope) c14141.L$0;
            ResultKt.throwOnFailure(objM15595dragjO51t88);
            if (((Boolean) objM15595dragjO51t88).booleanValue()) {
                List<PointerInputChange> changes2 = awaitPointerEventScope.getCurrentEvent().getChanges();
                int size2 = changes2.size();
                while (i4 < size2) {
                    PointerInputChange pointerInputChange3 = changes2.get(i4);
                    if (PointerEventKt.changedToUp(pointerInputChange3)) {
                        pointerInputChange3.consume();
                    }
                    i4++;
                }
            }
            mouseSelectionObserver.onDragDone();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x00f5, code lost:
    
        if (r11 == r1) goto L52;
     */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0090 A[Catch: all -> 0x004f, TryCatch #1 {all -> 0x004f, blocks: (B:20:0x004b, B:31:0x0088, B:33:0x0090, B:35:0x009e, B:37:0x00aa, B:28:0x006e), top: B:66:0x0023 }] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object mouseSelectionBtf2(AwaitPointerEventScope awaitPointerEventScope, final MouseSelectionObserver mouseSelectionObserver, ClicksCounter clicksCounter, PointerEvent pointerEvent, Continuation<? super Unit> continuation) {
        C14151 c14151;
        if (continuation instanceof C14151) {
            c14151 = (C14151) continuation;
            int i = c14151.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c14151.label = i - Integer.MIN_VALUE;
            } else {
                c14151 = new C14151(continuation);
            }
        }
        Object objM15595dragjO51t88 = c14151.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = c14151.label;
        int i4 = 0;
        try {
            try {
                if (i2 == 0) {
                    ResultKt.throwOnFailure(objM15595dragjO51t88);
                    PointerInputChange pointerInputChange = pointerEvent.getChanges().get(0);
                    if (!TextFieldSelectionManager_androidKt.isShiftPressed(pointerEvent)) {
                        int clicks = clicksCounter.getClicks();
                        final SelectionAdjustment paragraph = clicks != 1 ? clicks != 2 ? SelectionAdjustment.INSTANCE.getParagraph() : SelectionAdjustment.INSTANCE.getWord() : SelectionAdjustment.INSTANCE.getNone();
                        if (mouseSelectionObserver.mo16444onStart3MmeM6k(pointerInputChange.getPosition(), paragraph)) {
                            pointerInputChange.consume();
                            long id = pointerInputChange.getId();
                            Function1<PointerInputChange, Unit> function1 = new Function1<PointerInputChange, Unit>() { // from class: androidx.compose.foundation.text.selection.SelectionGesturesKt$mouseSelectionBtf2$shouldConsumeUp$2
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Unit invoke(PointerInputChange pointerInputChange2) {
                                    invoke2(pointerInputChange2);
                                    return Unit.INSTANCE;
                                }

                                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2(@NotNull PointerInputChange pointerInputChange2) {
                                    if (mouseSelectionObserver.mo16441onDrag3MmeM6k(pointerInputChange2.getPosition(), paragraph)) {
                                        pointerInputChange2.consume();
                                    }
                                }
                            };
                            c14151.L$0 = awaitPointerEventScope;
                            c14151.L$1 = mouseSelectionObserver;
                            c14151.label = 2;
                            objM15595dragjO51t88 = DragGestureDetectorKt.m15595dragjO51t88(awaitPointerEventScope, id, function1, c14151);
                        }
                    } else if (mouseSelectionObserver.mo16442onExtendk4lQ0M(pointerInputChange.getPosition())) {
                        pointerInputChange.consume();
                        long id2 = pointerInputChange.getId();
                        Function1<PointerInputChange, Unit> function12 = new Function1<PointerInputChange, Unit>() { // from class: androidx.compose.foundation.text.selection.SelectionGesturesKt$mouseSelectionBtf2$shouldConsumeUp$1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(PointerInputChange pointerInputChange2) {
                                invoke2(pointerInputChange2);
                                return Unit.INSTANCE;
                            }

                            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(@NotNull PointerInputChange pointerInputChange2) {
                                if (mouseSelectionObserver.mo16443onExtendDragk4lQ0M(pointerInputChange2.getPosition())) {
                                    pointerInputChange2.consume();
                                }
                            }
                        };
                        c14151.L$0 = awaitPointerEventScope;
                        c14151.L$1 = mouseSelectionObserver;
                        c14151.label = 1;
                        objM15595dragjO51t88 = DragGestureDetectorKt.m15595dragjO51t88(awaitPointerEventScope, id2, function12, c14151);
                        if (objM15595dragjO51t88 == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        if (((Boolean) objM15595dragjO51t88).booleanValue()) {
                        }
                    }
                } else if (i2 == 1) {
                    mouseSelectionObserver = (MouseSelectionObserver) c14151.L$1;
                    awaitPointerEventScope = (AwaitPointerEventScope) c14151.L$0;
                    ResultKt.throwOnFailure(objM15595dragjO51t88);
                    if (((Boolean) objM15595dragjO51t88).booleanValue()) {
                        List<PointerInputChange> changes = awaitPointerEventScope.getCurrentEvent().getChanges();
                        int size = changes.size();
                        while (i4 < size) {
                            PointerInputChange pointerInputChange2 = changes.get(i4);
                            if (PointerEventKt.changedToUp(pointerInputChange2)) {
                                pointerInputChange2.consume();
                            }
                            i4++;
                        }
                    }
                } else {
                    if (i2 != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    mouseSelectionObserver = (MouseSelectionObserver) c14151.L$1;
                    awaitPointerEventScope = (AwaitPointerEventScope) c14151.L$0;
                    ResultKt.throwOnFailure(objM15595dragjO51t88);
                    if (((Boolean) objM15595dragjO51t88).booleanValue()) {
                        List<PointerInputChange> changes2 = awaitPointerEventScope.getCurrentEvent().getChanges();
                        int size2 = changes2.size();
                        while (i4 < size2) {
                            PointerInputChange pointerInputChange3 = changes2.get(i4);
                            if (PointerEventKt.changedToUp(pointerInputChange3)) {
                                pointerInputChange3.consume();
                            }
                            i4++;
                        }
                    }
                    mouseSelectionObserver.onDragDone();
                }
                return Unit.INSTANCE;
            } finally {
            }
        } finally {
        }
    }

    @NotNull
    public static final Modifier selectionGestureInput(@NotNull Modifier modifier, @NotNull MouseSelectionObserver mouseSelectionObserver, @NotNull TextDragObserver textDragObserver) {
        return SuspendingPointerInputFilterKt.pointerInput(modifier, mouseSelectionObserver, textDragObserver, new C14161(mouseSelectionObserver, textDragObserver, null));
    }

    @Nullable
    public static final Object selectionGesturePointerInputBtf2(@NotNull PointerInputScope pointerInputScope, @NotNull MouseSelectionObserver mouseSelectionObserver, @NotNull TextDragObserver textDragObserver, @NotNull Continuation<? super Unit> continuation) {
        Object objAwaitEachGesture = ForEachGestureKt.awaitEachGesture(pointerInputScope, new C14172(new ClicksCounter(pointerInputScope.getViewConfiguration()), mouseSelectionObserver, textDragObserver, null), continuation);
        return objAwaitEachGesture == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objAwaitEachGesture : Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x009e, code lost:
    
        if (r11 == r1) goto L32;
     */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object touchSelection(AwaitPointerEventScope awaitPointerEventScope, final TextDragObserver textDragObserver, PointerEvent pointerEvent, Continuation<? super Unit> continuation) {
        C14181 c14181;
        PointerInputChange pointerInputChange;
        if (continuation instanceof C14181) {
            c14181 = (C14181) continuation;
            int i = c14181.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c14181.label = i - Integer.MIN_VALUE;
            } else {
                c14181 = new C14181(continuation);
            }
        }
        Object objM15587awaitLongPressOrCancellationrnUCldI = c14181.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = c14181.label;
        try {
            if (i2 == 0) {
                ResultKt.throwOnFailure(objM15587awaitLongPressOrCancellationrnUCldI);
                pointerInputChange = (PointerInputChange) CollectionsKt.first((List) pointerEvent.getChanges());
                long id = pointerInputChange.getId();
                c14181.L$0 = awaitPointerEventScope;
                c14181.L$1 = textDragObserver;
                c14181.L$2 = pointerInputChange;
                c14181.label = 1;
                objM15587awaitLongPressOrCancellationrnUCldI = DragGestureDetectorKt.m15587awaitLongPressOrCancellationrnUCldI(awaitPointerEventScope, id, c14181);
                if (objM15587awaitLongPressOrCancellationrnUCldI == coroutine_suspended) {
                }
                return coroutine_suspended;
            }
            if (i2 != 1) {
                if (i2 != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                textDragObserver = (TextDragObserver) c14181.L$1;
                awaitPointerEventScope = (AwaitPointerEventScope) c14181.L$0;
                ResultKt.throwOnFailure(objM15587awaitLongPressOrCancellationrnUCldI);
                if (((Boolean) objM15587awaitLongPressOrCancellationrnUCldI).booleanValue()) {
                    List<PointerInputChange> changes = awaitPointerEventScope.getCurrentEvent().getChanges();
                    int size = changes.size();
                    for (int i4 = 0; i4 < size; i4++) {
                        PointerInputChange pointerInputChange2 = changes.get(i4);
                        if (PointerEventKt.changedToUp(pointerInputChange2)) {
                            pointerInputChange2.consume();
                        }
                    }
                    textDragObserver.onStop();
                } else {
                    textDragObserver.onCancel();
                }
                return Unit.INSTANCE;
            }
            PointerInputChange pointerInputChange3 = (PointerInputChange) c14181.L$2;
            textDragObserver = (TextDragObserver) c14181.L$1;
            AwaitPointerEventScope awaitPointerEventScope2 = (AwaitPointerEventScope) c14181.L$0;
            ResultKt.throwOnFailure(objM15587awaitLongPressOrCancellationrnUCldI);
            pointerInputChange = pointerInputChange3;
            awaitPointerEventScope = awaitPointerEventScope2;
            PointerInputChange pointerInputChange4 = (PointerInputChange) objM15587awaitLongPressOrCancellationrnUCldI;
            if (pointerInputChange4 != null && distanceIsTolerable(awaitPointerEventScope.getViewConfiguration(), pointerInputChange, pointerInputChange4)) {
                textDragObserver.mo16232onStartk4lQ0M(pointerInputChange4.getPosition());
                long id2 = pointerInputChange4.getId();
                Function1<PointerInputChange, Unit> function1 = new Function1<PointerInputChange, Unit>() { // from class: androidx.compose.foundation.text.selection.SelectionGesturesKt.touchSelection.2
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(PointerInputChange pointerInputChange5) {
                        invoke2(pointerInputChange5);
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(@NotNull PointerInputChange pointerInputChange5) {
                        textDragObserver.mo16231onDragk4lQ0M(PointerEventKt.positionChange(pointerInputChange5));
                        pointerInputChange5.consume();
                    }
                };
                c14181.L$0 = awaitPointerEventScope;
                c14181.L$1 = textDragObserver;
                c14181.L$2 = null;
                c14181.label = 2;
                objM15587awaitLongPressOrCancellationrnUCldI = DragGestureDetectorKt.m15595dragjO51t88(awaitPointerEventScope, id2, function1, c14181);
            }
            return Unit.INSTANCE;
        } catch (CancellationException e) {
            textDragObserver.onCancel();
            throw e;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x009e, code lost:
    
        if (r11 == r1) goto L32;
     */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object touchSelectionFirstPress(AwaitPointerEventScope awaitPointerEventScope, final TextDragObserver textDragObserver, PointerEvent pointerEvent, Continuation<? super Unit> continuation) {
        C14201 c14201;
        PointerInputChange pointerInputChange;
        if (continuation instanceof C14201) {
            c14201 = (C14201) continuation;
            int i = c14201.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c14201.label = i - Integer.MIN_VALUE;
            } else {
                c14201 = new C14201(continuation);
            }
        }
        Object objM15587awaitLongPressOrCancellationrnUCldI = c14201.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = c14201.label;
        try {
            if (i2 == 0) {
                ResultKt.throwOnFailure(objM15587awaitLongPressOrCancellationrnUCldI);
                pointerInputChange = (PointerInputChange) CollectionsKt.first((List) pointerEvent.getChanges());
                long id = pointerInputChange.getId();
                c14201.L$0 = awaitPointerEventScope;
                c14201.L$1 = textDragObserver;
                c14201.L$2 = pointerInputChange;
                c14201.label = 1;
                objM15587awaitLongPressOrCancellationrnUCldI = DragGestureDetectorKt.m15587awaitLongPressOrCancellationrnUCldI(awaitPointerEventScope, id, c14201);
                if (objM15587awaitLongPressOrCancellationrnUCldI == coroutine_suspended) {
                }
                return coroutine_suspended;
            }
            if (i2 != 1) {
                if (i2 != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                textDragObserver = (TextDragObserver) c14201.L$1;
                awaitPointerEventScope = (AwaitPointerEventScope) c14201.L$0;
                ResultKt.throwOnFailure(objM15587awaitLongPressOrCancellationrnUCldI);
                if (((Boolean) objM15587awaitLongPressOrCancellationrnUCldI).booleanValue()) {
                    List<PointerInputChange> changes = awaitPointerEventScope.getCurrentEvent().getChanges();
                    int size = changes.size();
                    for (int i4 = 0; i4 < size; i4++) {
                        PointerInputChange pointerInputChange2 = changes.get(i4);
                        if (PointerEventKt.changedToUp(pointerInputChange2)) {
                            pointerInputChange2.consume();
                        }
                    }
                    textDragObserver.onStop();
                } else {
                    textDragObserver.onCancel();
                }
                return Unit.INSTANCE;
            }
            PointerInputChange pointerInputChange3 = (PointerInputChange) c14201.L$2;
            textDragObserver = (TextDragObserver) c14201.L$1;
            AwaitPointerEventScope awaitPointerEventScope2 = (AwaitPointerEventScope) c14201.L$0;
            ResultKt.throwOnFailure(objM15587awaitLongPressOrCancellationrnUCldI);
            pointerInputChange = pointerInputChange3;
            awaitPointerEventScope = awaitPointerEventScope2;
            PointerInputChange pointerInputChange4 = (PointerInputChange) objM15587awaitLongPressOrCancellationrnUCldI;
            if (pointerInputChange4 != null && distanceIsTolerable(awaitPointerEventScope.getViewConfiguration(), pointerInputChange, pointerInputChange4)) {
                textDragObserver.mo16232onStartk4lQ0M(pointerInputChange4.getPosition());
                long id2 = pointerInputChange4.getId();
                Function1<PointerInputChange, Unit> function1 = new Function1<PointerInputChange, Unit>() { // from class: androidx.compose.foundation.text.selection.SelectionGesturesKt$touchSelectionFirstPress$dragCompletedWithUp$1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(PointerInputChange pointerInputChange5) {
                        invoke2(pointerInputChange5);
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(@NotNull PointerInputChange pointerInputChange5) {
                        textDragObserver.mo16231onDragk4lQ0M(PointerEventKt.positionChange(pointerInputChange5));
                        pointerInputChange5.consume();
                    }
                };
                c14201.L$0 = awaitPointerEventScope;
                c14201.L$1 = textDragObserver;
                c14201.L$2 = null;
                c14201.label = 2;
                objM15587awaitLongPressOrCancellationrnUCldI = DragGestureDetectorKt.m15595dragjO51t88(awaitPointerEventScope, id2, function1, c14201);
            }
            return Unit.INSTANCE;
        } catch (CancellationException e) {
            textDragObserver.onCancel();
            throw e;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x00dc, code lost:
    
        if (r15 == r1) goto L44;
     */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object touchSelectionSubsequentPress(AwaitPointerEventScope awaitPointerEventScope, final TextDragObserver textDragObserver, PointerEvent pointerEvent, Continuation<? super Unit> continuation) {
        C14221 c14221;
        PointerInputChange pointerInputChange;
        long id;
        Ref.LongRef longRef;
        Object objWithTimeoutOrNull;
        if (continuation instanceof C14221) {
            c14221 = (C14221) continuation;
            int i = c14221.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c14221.label = i - Integer.MIN_VALUE;
            } else {
                c14221 = new C14221(continuation);
            }
        }
        Object objM15595dragjO51t88 = c14221.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = c14221.label;
        try {
            if (i2 == 0) {
                ResultKt.throwOnFailure(objM15595dragjO51t88);
                pointerInputChange = (PointerInputChange) CollectionsKt.first((List) pointerEvent.getChanges());
                id = pointerInputChange.getId();
                longRef = new Ref.LongRef();
                longRef.element = Offset.INSTANCE.m18299getUnspecifiedF1C5BW0();
                long longPressTimeoutMillis = awaitPointerEventScope.getViewConfiguration().getLongPressTimeoutMillis();
                C1423xcb1d223 c1423xcb1d223 = new C1423xcb1d223(id, longRef, null);
                c14221.L$0 = awaitPointerEventScope;
                c14221.L$1 = textDragObserver;
                c14221.L$2 = pointerInputChange;
                c14221.L$3 = longRef;
                c14221.J$0 = id;
                c14221.label = 1;
                objWithTimeoutOrNull = awaitPointerEventScope.withTimeoutOrNull(longPressTimeoutMillis, c1423xcb1d223, c14221);
                if (objWithTimeoutOrNull == coroutine_suspended) {
                }
                return coroutine_suspended;
            }
            if (i2 != 1) {
                if (i2 != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                textDragObserver = (TextDragObserver) c14221.L$1;
                awaitPointerEventScope = (AwaitPointerEventScope) c14221.L$0;
                ResultKt.throwOnFailure(objM15595dragjO51t88);
                if (((Boolean) objM15595dragjO51t88).booleanValue()) {
                    List<PointerInputChange> changes = awaitPointerEventScope.getCurrentEvent().getChanges();
                    int size = changes.size();
                    for (int i4 = 0; i4 < size; i4++) {
                        PointerInputChange pointerInputChange2 = changes.get(i4);
                        if (PointerEventKt.changedToUp(pointerInputChange2)) {
                            pointerInputChange2.consume();
                        }
                    }
                    textDragObserver.onStop();
                } else {
                    textDragObserver.onCancel();
                }
                return Unit.INSTANCE;
            }
            long j = c14221.J$0;
            Ref.LongRef longRef2 = (Ref.LongRef) c14221.L$3;
            pointerInputChange = (PointerInputChange) c14221.L$2;
            TextDragObserver textDragObserver2 = (TextDragObserver) c14221.L$1;
            AwaitPointerEventScope awaitPointerEventScope2 = (AwaitPointerEventScope) c14221.L$0;
            try {
                ResultKt.throwOnFailure(objM15595dragjO51t88);
                longRef = longRef2;
                objWithTimeoutOrNull = objM15595dragjO51t88;
                id = j;
                textDragObserver = textDragObserver2;
                awaitPointerEventScope = awaitPointerEventScope2;
            } catch (CancellationException e) {
                e = e;
                textDragObserver = textDragObserver2;
                textDragObserver.onCancel();
                throw e;
            }
            DownResolution downResolution = (DownResolution) objWithTimeoutOrNull;
            if (downResolution == null) {
                downResolution = DownResolution.Timeout;
            }
            if (downResolution == DownResolution.Cancel) {
                return Unit.INSTANCE;
            }
            textDragObserver.mo16232onStartk4lQ0M(pointerInputChange.getPosition());
            if (downResolution == DownResolution.Up) {
                textDragObserver.onStop();
                return Unit.INSTANCE;
            }
            if (downResolution == DownResolution.Drag) {
                textDragObserver.mo16231onDragk4lQ0M(longRef.element);
            }
            Function1<PointerInputChange, Unit> function1 = new Function1<PointerInputChange, Unit>() { // from class: androidx.compose.foundation.text.selection.SelectionGesturesKt$touchSelectionSubsequentPress$dragCompletedWithUp$1
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(PointerInputChange pointerInputChange3) {
                    invoke2(pointerInputChange3);
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@NotNull PointerInputChange pointerInputChange3) {
                    textDragObserver.mo16231onDragk4lQ0M(PointerEventKt.positionChange(pointerInputChange3));
                    pointerInputChange3.consume();
                }
            };
            c14221.L$0 = awaitPointerEventScope;
            c14221.L$1 = textDragObserver;
            c14221.L$2 = null;
            c14221.L$3 = null;
            c14221.label = 2;
            objM15595dragjO51t88 = DragGestureDetectorKt.m15595dragjO51t88(awaitPointerEventScope, id, function1, c14221);
        } catch (CancellationException e2) {
            e = e2;
        }
    }

    @NotNull
    public static final Modifier updateSelectionTouchMode(@NotNull Modifier modifier, @NotNull Function1<? super Boolean, Unit> function1) {
        return SuspendingPointerInputFilterKt.pointerInput(modifier, Integer.valueOf(STATIC_KEY), new C14261(function1, null));
    }
}
