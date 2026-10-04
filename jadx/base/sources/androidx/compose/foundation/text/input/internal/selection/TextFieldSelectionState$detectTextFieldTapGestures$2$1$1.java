package androidx.compose.foundation.text.input.internal.selection;

import androidx.compose.foundation.gestures.PressGestureScope;
import androidx.compose.foundation.interaction.Interaction;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.interaction.PressInteraction;
import androidx.core.app.FrameMetricsAggregator;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m13885d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m13886d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m13887k = 3, m13888mv = {1, 8, 0}, m13890xi = 48)
@DebugMetadata(m14020c = "androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState$detectTextFieldTapGestures$2$1$1", m14021f = "TextFieldSelectionState.kt", m14022i = {}, m14023l = {504, FrameMetricsAggregator.EVERY_DURATION}, m14024m = "invokeSuspend", m14025n = {}, m14026s = {})
public final class TextFieldSelectionState$detectTextFieldTapGestures$2$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ PressGestureScope $$this$detectTapAndPress;
    final /* synthetic */ MutableInteractionSource $interactionSource;
    final /* synthetic */ long $offset;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ TextFieldSelectionState this$0;

    /* JADX INFO: renamed from: androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState$detectTextFieldTapGestures$2$1$1$1 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m13886d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m13887k = 3, m13888mv = {1, 8, 0}, m13890xi = 48)
    @DebugMetadata(m14020c = "androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState$detectTextFieldTapGestures$2$1$1$1", m14021f = "TextFieldSelectionState.kt", m14022i = {1}, m14023l = {496, 501}, m14024m = "invokeSuspend", m14025n = {"press"}, m14026s = {"L$0"})
    public static final class C13691 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ MutableInteractionSource $interactionSource;
        final /* synthetic */ long $offset;
        Object L$0;
        int label;
        final /* synthetic */ TextFieldSelectionState this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C13691(TextFieldSelectionState textFieldSelectionState, long j, MutableInteractionSource mutableInteractionSource, Continuation<? super C13691> continuation) {
            super(2, continuation);
            this.this$0 = textFieldSelectionState;
            this.$offset = j;
            this.$interactionSource = mutableInteractionSource;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return new C13691(this.this$0, this.$offset, this.$interactionSource, continuation);
        }

        /* JADX WARN: Removed duplicated region for block: B:20:0x005e  */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(@NotNull Object obj) {
            TextFieldSelectionState textFieldSelectionState;
            PressInteraction.Press press;
            MutableInteractionSource mutableInteractionSource;
            PressInteraction.Press press2;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                PressInteraction.Press press3 = this.this$0.pressInteraction;
                if (press3 != null) {
                    MutableInteractionSource mutableInteractionSource2 = this.$interactionSource;
                    TextFieldSelectionState textFieldSelectionState2 = this.this$0;
                    PressInteraction.Cancel cancel = new PressInteraction.Cancel(press3);
                    this.L$0 = textFieldSelectionState2;
                    this.label = 1;
                    if (mutableInteractionSource2.emit(cancel, this) != coroutine_suspended) {
                        textFieldSelectionState = textFieldSelectionState2;
                    }
                } else {
                    press = new PressInteraction.Press(this.$offset, null);
                    mutableInteractionSource = this.$interactionSource;
                    this.L$0 = press;
                    this.label = 2;
                    if (mutableInteractionSource.emit(press, this) != coroutine_suspended) {
                        press2 = press;
                        this.this$0.pressInteraction = press2;
                        return Unit.INSTANCE;
                    }
                }
                return coroutine_suspended;
            }
            if (i != 1) {
                if (i != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                press2 = (PressInteraction.Press) this.L$0;
                ResultKt.throwOnFailure(obj);
                this.this$0.pressInteraction = press2;
                return Unit.INSTANCE;
            }
            textFieldSelectionState = (TextFieldSelectionState) this.L$0;
            ResultKt.throwOnFailure(obj);
            textFieldSelectionState.pressInteraction = null;
            press = new PressInteraction.Press(this.$offset, null);
            mutableInteractionSource = this.$interactionSource;
            this.L$0 = press;
            this.label = 2;
            if (mutableInteractionSource.emit(press, this) != coroutine_suspended) {
            }
            return coroutine_suspended;
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
            return ((C13691) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TextFieldSelectionState$detectTextFieldTapGestures$2$1$1(PressGestureScope pressGestureScope, TextFieldSelectionState textFieldSelectionState, long j, MutableInteractionSource mutableInteractionSource, Continuation<? super TextFieldSelectionState$detectTextFieldTapGestures$2$1$1> continuation) {
        super(2, continuation);
        this.$$this$detectTapAndPress = pressGestureScope;
        this.this$0 = textFieldSelectionState;
        this.$offset = j;
        this.$interactionSource = mutableInteractionSource;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        TextFieldSelectionState$detectTextFieldTapGestures$2$1$1 textFieldSelectionState$detectTextFieldTapGestures$2$1$1 = new TextFieldSelectionState$detectTextFieldTapGestures$2$1$1(this.$$this$detectTapAndPress, this.this$0, this.$offset, this.$interactionSource, continuation);
        textFieldSelectionState$detectTextFieldTapGestures$2$1$1.L$0 = obj;
        return textFieldSelectionState$detectTextFieldTapGestures$2$1$1;
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0068, code lost:
    
        if (r3.emit(r12, r11) == r0) goto L21;
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
            BuildersKt__Builders_commonKt.launch$default((CoroutineScope) this.L$0, null, null, new C13691(this.this$0, this.$offset, this.$interactionSource, null), 3, null);
            PressGestureScope pressGestureScope = this.$$this$detectTapAndPress;
            this.label = 1;
            obj = pressGestureScope.tryAwaitRelease(this);
            if (obj != coroutine_suspended) {
            }
            return coroutine_suspended;
        }
        if (i != 1) {
            if (i != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            this.this$0.pressInteraction = null;
            return Unit.INSTANCE;
        }
        ResultKt.throwOnFailure(obj);
        boolean zBooleanValue = ((Boolean) obj).booleanValue();
        PressInteraction.Press press = this.this$0.pressInteraction;
        if (press != null) {
            MutableInteractionSource mutableInteractionSource = this.$interactionSource;
            Interaction release = zBooleanValue ? new PressInteraction.Release(press) : new PressInteraction.Cancel(press);
            this.label = 2;
        }
        this.this$0.pressInteraction = null;
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((TextFieldSelectionState$detectTextFieldTapGestures$2$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
