package androidx.compose.foundation.text.input.internal;

import androidx.compose.foundation.text.handwriting.StylusHandwriting_androidKt;
import androidx.compose.foundation.text.input.internal.LegacyPlatformTextInputServiceAdapter;
import androidx.compose.p109ui.geometry.Rect;
import androidx.compose.p109ui.graphics.Matrix;
import androidx.compose.p109ui.layout.LayoutCoordinates;
import androidx.compose.p109ui.platform.PlatformTextInputSession;
import androidx.compose.p109ui.text.TextLayoutResult;
import androidx.compose.p109ui.text.input.EditCommand;
import androidx.compose.p109ui.text.input.ImeAction;
import androidx.compose.p109ui.text.input.ImeOptions;
import androidx.compose.p109ui.text.input.OffsetMapping;
import androidx.compose.p109ui.text.input.TextFieldValue;
import androidx.compose.runtime.MonotonicFrameClockKt;
import androidx.compose.runtime.internal.StabilityInferred;
import java.util.List;
import java.util.concurrent.CancellationException;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@StabilityInferred(parameters = 0)
@Metadata(m13885d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\r\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\b\u0010\u0010\u001a\u00020\u0005H\u0016J\u001e\u0010\u0010\u001a\u00020\u00052\u0014\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0012H\u0002JF\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0018\u0010\u0017\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00190\u0018\u0012\u0004\u0012\u00020\u00050\u00122\u0012\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u00050\u0012H\u0016J\b\u0010\u001c\u001a\u00020\u0005H\u0016J\b\u0010\u001d\u001a\u00020\u0005H\u0016J\u001a\u0010\u001e\u001a\u00020\u00052\b\u0010\u001f\u001a\u0004\u0018\u00010\u00142\u0006\u0010 \u001a\u00020\u0014H\u0016JD\u0010!\u001a\u00020\u00052\u0006\u0010\"\u001a\u00020\u00142\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&2\u0012\u0010'\u001a\u000e\u0012\u0004\u0012\u00020(\u0012\u0004\u0012\u00020\u00050\u00122\u0006\u0010)\u001a\u00020\u000f2\u0006\u0010*\u001a\u00020\u000fH\u0016R\u0016\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00048BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\f¨\u0006+"}, m13886d2 = {"Landroidx/compose/foundation/text/input/internal/AndroidLegacyPlatformTextInputServiceAdapter;", "Landroidx/compose/foundation/text/input/internal/LegacyPlatformTextInputServiceAdapter;", "()V", "backingStylusHandwritingTrigger", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "", "currentRequest", "Landroidx/compose/foundation/text/input/internal/LegacyTextInputMethodRequest;", "job", "Lkotlinx/coroutines/Job;", "stylusHandwritingTrigger", "getStylusHandwritingTrigger", "()Lkotlinx/coroutines/flow/MutableSharedFlow;", "notifyFocusedRect", "rect", "Landroidx/compose/ui/geometry/Rect;", "startInput", "initializeRequest", "Lkotlin/Function1;", "value", "Landroidx/compose/ui/text/input/TextFieldValue;", "imeOptions", "Landroidx/compose/ui/text/input/ImeOptions;", "onEditCommand", "", "Landroidx/compose/ui/text/input/EditCommand;", "onImeActionPerformed", "Landroidx/compose/ui/text/input/ImeAction;", "startStylusHandwriting", "stopInput", "updateState", "oldValue", "newValue", "updateTextLayoutResult", "textFieldValue", "offsetMapping", "Landroidx/compose/ui/text/input/OffsetMapping;", "textLayoutResult", "Landroidx/compose/ui/text/TextLayoutResult;", "textFieldToRootTransform", "Landroidx/compose/ui/graphics/Matrix;", "innerTextFieldBounds", "decorationBoxBounds", "foundation_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nLegacyPlatformTextInputServiceAdapter.android.kt\nKotlin\n*S Kotlin\n*F\n+ 1 LegacyPlatformTextInputServiceAdapter.android.kt\nandroidx/compose/foundation/text/input/internal/AndroidLegacyPlatformTextInputServiceAdapter\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,429:1\n1#2:430\n*E\n"})
public final class AndroidLegacyPlatformTextInputServiceAdapter extends LegacyPlatformTextInputServiceAdapter {
    public static final int $stable = 8;

    @Nullable
    private MutableSharedFlow<Unit> backingStylusHandwritingTrigger;

    @Nullable
    private LegacyTextInputMethodRequest currentRequest;

    @Nullable
    private Job job;

    /* JADX INFO: renamed from: androidx.compose.foundation.text.input.internal.AndroidLegacyPlatformTextInputServiceAdapter$startInput$2 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0001\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m13886d2 = {"<anonymous>", "", "Landroidx/compose/ui/platform/PlatformTextInputSession;"}, m13887k = 3, m13888mv = {1, 8, 0}, m13890xi = 48)
    @DebugMetadata(m14020c = "androidx.compose.foundation.text.input.internal.AndroidLegacyPlatformTextInputServiceAdapter$startInput$2", m14021f = "LegacyPlatformTextInputServiceAdapter.android.kt", m14022i = {}, m14023l = {123}, m14024m = "invokeSuspend", m14025n = {}, m14026s = {})
    public static final class C12942 extends SuspendLambda implements Function2<PlatformTextInputSession, Continuation<?>, Object> {
        final /* synthetic */ Function1<LegacyTextInputMethodRequest, Unit> $initializeRequest;
        final /* synthetic */ LegacyPlatformTextInputServiceAdapter.LegacyPlatformTextInputNode $node;
        private /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ AndroidLegacyPlatformTextInputServiceAdapter this$0;

        /* JADX INFO: renamed from: androidx.compose.foundation.text.input.internal.AndroidLegacyPlatformTextInputServiceAdapter$startInput$2$1, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        @Metadata(m13885d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0001\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m13886d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m13887k = 3, m13888mv = {1, 8, 0}, m13890xi = 48)
        @DebugMetadata(m14020c = "androidx.compose.foundation.text.input.internal.AndroidLegacyPlatformTextInputServiceAdapter$startInput$2$1", m14021f = "LegacyPlatformTextInputServiceAdapter.android.kt", m14022i = {}, m14023l = {146}, m14024m = "invokeSuspend", m14025n = {}, m14026s = {})
        public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<?>, Object> {
            final /* synthetic */ PlatformTextInputSession $$this$launchTextInputSession;
            final /* synthetic */ Function1<LegacyTextInputMethodRequest, Unit> $initializeRequest;
            final /* synthetic */ LegacyPlatformTextInputServiceAdapter.LegacyPlatformTextInputNode $node;
            private /* synthetic */ Object L$0;
            int label;
            final /* synthetic */ AndroidLegacyPlatformTextInputServiceAdapter this$0;

            /* JADX INFO: renamed from: androidx.compose.foundation.text.input.internal.AndroidLegacyPlatformTextInputServiceAdapter$startInput$2$1$1, reason: invalid class name and collision with other inner class name */
            /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
            @Metadata(m13885d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m13886d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m13887k = 3, m13888mv = {1, 8, 0}, m13890xi = 48)
            @DebugMetadata(m14020c = "androidx.compose.foundation.text.input.internal.AndroidLegacyPlatformTextInputServiceAdapter$startInput$2$1$1", m14021f = "LegacyPlatformTextInputServiceAdapter.android.kt", m14022i = {}, m14023l = {137, 138}, m14024m = "invokeSuspend", m14025n = {}, m14026s = {})
            public static final class C145391 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                final /* synthetic */ InputMethodManager $inputMethodManager;
                int label;
                final /* synthetic */ AndroidLegacyPlatformTextInputServiceAdapter this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public C145391(AndroidLegacyPlatformTextInputServiceAdapter androidLegacyPlatformTextInputServiceAdapter, InputMethodManager inputMethodManager, Continuation<? super C145391> continuation) {
                    super(2, continuation);
                    this.this$0 = androidLegacyPlatformTextInputServiceAdapter;
                    this.$inputMethodManager = inputMethodManager;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                @NotNull
                public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
                    return new C145391(this.this$0, this.$inputMethodManager, continuation);
                }

                /* JADX WARN: Code restructure failed: missing block: B:16:0x0041, code lost:
                
                    if (r5.collect(r1, r4) == r0) goto L17;
                 */
                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                @Nullable
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public final Object invokeSuspend(@NotNull Object obj) {
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    int i = this.label;
                    if (i == 0) {
                        ResultKt.throwOnFailure(obj);
                        C145401 c145401 = new Function1<Long, Unit>() { // from class: androidx.compose.foundation.text.input.internal.AndroidLegacyPlatformTextInputServiceAdapter.startInput.2.1.1.1
                            public final void invoke(long j) {
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(Long l) {
                                invoke(l.longValue());
                                return Unit.INSTANCE;
                            }
                        };
                        this.label = 1;
                        if (MonotonicFrameClockKt.withFrameMillis(c145401, this) != coroutine_suspended) {
                        }
                        return coroutine_suspended;
                    }
                    if (i != 1) {
                        if (i != 2) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        ResultKt.throwOnFailure(obj);
                        throw new KotlinNothingValueException();
                    }
                    ResultKt.throwOnFailure(obj);
                    MutableSharedFlow stylusHandwritingTrigger = this.this$0.getStylusHandwritingTrigger();
                    if (stylusHandwritingTrigger == null) {
                        return Unit.INSTANCE;
                    }
                    final InputMethodManager inputMethodManager = this.$inputMethodManager;
                    FlowCollector flowCollector = new FlowCollector() { // from class: androidx.compose.foundation.text.input.internal.AndroidLegacyPlatformTextInputServiceAdapter.startInput.2.1.1.2
                        @Override // kotlinx.coroutines.flow.FlowCollector
                        public /* bridge */ /* synthetic */ Object emit(Object obj2, Continuation continuation) {
                            return emit((Unit) obj2, (Continuation<? super Unit>) continuation);
                        }

                        @Nullable
                        public final Object emit(@NotNull Unit unit, @NotNull Continuation<? super Unit> continuation) {
                            inputMethodManager.startStylusHandwriting();
                            return Unit.INSTANCE;
                        }
                    };
                    this.label = 2;
                }

                @Override // kotlin.jvm.functions.Function2
                @Nullable
                public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
                    return ((C145391) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            public AnonymousClass1(PlatformTextInputSession platformTextInputSession, Function1<? super LegacyTextInputMethodRequest, Unit> function1, AndroidLegacyPlatformTextInputServiceAdapter androidLegacyPlatformTextInputServiceAdapter, LegacyPlatformTextInputServiceAdapter.LegacyPlatformTextInputNode legacyPlatformTextInputNode, Continuation<? super AnonymousClass1> continuation) {
                super(2, continuation);
                this.$$this$launchTextInputSession = platformTextInputSession;
                this.$initializeRequest = function1;
                this.this$0 = androidLegacyPlatformTextInputServiceAdapter;
                this.$node = legacyPlatformTextInputNode;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @NotNull
            public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$$this$launchTextInputSession, this.$initializeRequest, this.this$0, this.$node, continuation);
                anonymousClass1.L$0 = obj;
                return anonymousClass1;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @Nullable
            public final Object invokeSuspend(@NotNull Object obj) {
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i = this.label;
                try {
                    if (i == 0) {
                        ResultKt.throwOnFailure(obj);
                        CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
                        InputMethodManager inputMethodManagerInvoke = LegacyPlatformTextInputServiceAdapter_androidKt.getInputMethodManagerFactory().invoke(this.$$this$launchTextInputSession.getView());
                        LegacyTextInputMethodRequest legacyTextInputMethodRequest = new LegacyTextInputMethodRequest(this.$$this$launchTextInputSession.getView(), new C1295x8f2ae8f3(this.$node), inputMethodManagerInvoke);
                        if (StylusHandwriting_androidKt.isStylusHandwritingSupported()) {
                            BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new C145391(this.this$0, inputMethodManagerInvoke, null), 3, null);
                        }
                        Function1<LegacyTextInputMethodRequest, Unit> function1 = this.$initializeRequest;
                        if (function1 != null) {
                            function1.invoke(legacyTextInputMethodRequest);
                        }
                        this.this$0.currentRequest = legacyTextInputMethodRequest;
                        PlatformTextInputSession platformTextInputSession = this.$$this$launchTextInputSession;
                        this.label = 1;
                        if (platformTextInputSession.startInputMethod(legacyTextInputMethodRequest, this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    } else {
                        if (i != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        ResultKt.throwOnFailure(obj);
                    }
                    throw new KotlinNothingValueException();
                } catch (Throwable th) {
                    this.this$0.currentRequest = null;
                    throw th;
                }
            }

            @Override // kotlin.jvm.functions.Function2
            @Nullable
            public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<?> continuation) {
                return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public C12942(Function1<? super LegacyTextInputMethodRequest, Unit> function1, AndroidLegacyPlatformTextInputServiceAdapter androidLegacyPlatformTextInputServiceAdapter, LegacyPlatformTextInputServiceAdapter.LegacyPlatformTextInputNode legacyPlatformTextInputNode, Continuation<? super C12942> continuation) {
            super(2, continuation);
            this.$initializeRequest = function1;
            this.this$0 = androidLegacyPlatformTextInputServiceAdapter;
            this.$node = legacyPlatformTextInputNode;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            C12942 c12942 = new C12942(this.$initializeRequest, this.this$0, this.$node, continuation);
            c12942.L$0 = obj;
            return c12942;
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        public final Object invoke(@NotNull PlatformTextInputSession platformTextInputSession, @Nullable Continuation<?> continuation) {
            return ((C12942) create(platformTextInputSession, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                AnonymousClass1 anonymousClass1 = new AnonymousClass1((PlatformTextInputSession) this.L$0, this.$initializeRequest, this.this$0, this.$node, null);
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
            throw new KotlinNothingValueException();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final MutableSharedFlow<Unit> getStylusHandwritingTrigger() {
        MutableSharedFlow<Unit> mutableSharedFlow = this.backingStylusHandwritingTrigger;
        if (mutableSharedFlow != null) {
            return mutableSharedFlow;
        }
        if (!StylusHandwriting_androidKt.isStylusHandwritingSupported()) {
            return null;
        }
        MutableSharedFlow<Unit> mutableSharedFlowMutableSharedFlow$default = SharedFlowKt.MutableSharedFlow$default(1, 0, BufferOverflow.DROP_LATEST, 2, null);
        this.backingStylusHandwritingTrigger = mutableSharedFlowMutableSharedFlow$default;
        return mutableSharedFlowMutableSharedFlow$default;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void startInput$localToScreen(LegacyPlatformTextInputServiceAdapter.LegacyPlatformTextInputNode legacyPlatformTextInputNode, float[] fArr) {
        LayoutCoordinates layoutCoordinates = legacyPlatformTextInputNode.getLayoutCoordinates();
        if (layoutCoordinates != null) {
            if (!layoutCoordinates.isAttached()) {
                layoutCoordinates = null;
            }
            if (layoutCoordinates == null) {
                return;
            }
            layoutCoordinates.mo19871transformToScreen58bKbWc(fArr);
        }
    }

    @Override // androidx.compose.p109ui.text.input.PlatformTextInputService
    public void notifyFocusedRect(@NotNull Rect rect) {
        LegacyTextInputMethodRequest legacyTextInputMethodRequest = this.currentRequest;
        if (legacyTextInputMethodRequest != null) {
            legacyTextInputMethodRequest.notifyFocusedRect(rect);
        }
    }

    @Override // androidx.compose.p109ui.text.input.PlatformTextInputService
    public void startInput(@NotNull final TextFieldValue value, @NotNull final ImeOptions imeOptions, @NotNull final Function1<? super List<? extends EditCommand>, Unit> onEditCommand, @NotNull final Function1<? super ImeAction, Unit> onImeActionPerformed) {
        startInput(new Function1<LegacyTextInputMethodRequest, Unit>() { // from class: androidx.compose.foundation.text.input.internal.AndroidLegacyPlatformTextInputServiceAdapter.startInput.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(LegacyTextInputMethodRequest legacyTextInputMethodRequest) {
                invoke2(legacyTextInputMethodRequest);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull LegacyTextInputMethodRequest legacyTextInputMethodRequest) {
                legacyTextInputMethodRequest.startInput(value, this.getTextInputModifierNode(), imeOptions, onEditCommand, onImeActionPerformed);
            }
        });
    }

    @Override // androidx.compose.foundation.text.input.internal.LegacyPlatformTextInputServiceAdapter
    public void startStylusHandwriting() {
        MutableSharedFlow<Unit> stylusHandwritingTrigger = getStylusHandwritingTrigger();
        if (stylusHandwritingTrigger != null) {
            stylusHandwritingTrigger.tryEmit(Unit.INSTANCE);
        }
    }

    @Override // androidx.compose.p109ui.text.input.PlatformTextInputService
    public void stopInput() {
        Job job = this.job;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        this.job = null;
        MutableSharedFlow<Unit> stylusHandwritingTrigger = getStylusHandwritingTrigger();
        if (stylusHandwritingTrigger != null) {
            stylusHandwritingTrigger.resetReplayCache();
        }
    }

    @Override // androidx.compose.p109ui.text.input.PlatformTextInputService
    public void updateState(@Nullable TextFieldValue oldValue, @NotNull TextFieldValue newValue) {
        LegacyTextInputMethodRequest legacyTextInputMethodRequest = this.currentRequest;
        if (legacyTextInputMethodRequest != null) {
            legacyTextInputMethodRequest.updateState(oldValue, newValue);
        }
    }

    @Override // androidx.compose.p109ui.text.input.PlatformTextInputService
    public void updateTextLayoutResult(@NotNull TextFieldValue textFieldValue, @NotNull OffsetMapping offsetMapping, @NotNull TextLayoutResult textLayoutResult, @NotNull Function1<? super Matrix, Unit> textFieldToRootTransform, @NotNull Rect innerTextFieldBounds, @NotNull Rect decorationBoxBounds) {
        LegacyTextInputMethodRequest legacyTextInputMethodRequest = this.currentRequest;
        if (legacyTextInputMethodRequest != null) {
            legacyTextInputMethodRequest.updateTextLayoutResult(textFieldValue, offsetMapping, textLayoutResult, innerTextFieldBounds, decorationBoxBounds);
        }
    }

    @Override // androidx.compose.p109ui.text.input.PlatformTextInputService
    public void startInput() {
        startInput(null);
    }

    private final void startInput(Function1<? super LegacyTextInputMethodRequest, Unit> initializeRequest) {
        LegacyPlatformTextInputServiceAdapter.LegacyPlatformTextInputNode textInputModifierNode = getTextInputModifierNode();
        if (textInputModifierNode == null) {
            return;
        }
        this.job = textInputModifierNode.launchTextInputSession(new C12942(initializeRequest, this, textInputModifierNode, null));
    }
}
