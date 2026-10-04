package androidx.compose.foundation.text;

import androidx.compose.foundation.text.input.internal.CodepointTransformation;
import androidx.compose.p109ui.Modifier;
import androidx.compose.p109ui.focus.FocusChangedModifierKt;
import androidx.compose.p109ui.focus.FocusState;
import androidx.compose.runtime.State;
import androidx.compose.runtime.internal.StabilityInferred;
import com.samsung.android.app.sdk.deepsky.textextraction.languagepack.LangPackConfigConstants;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelKt;
import kotlinx.coroutines.channels.ChannelResult;
import kotlinx.coroutines.flow.FlowKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@StabilityInferred(parameters = 0)
@Metadata(m13885d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\f\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B\u0013\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005J\u000e\u0010\u0015\u001a\u00020\u0014H\u0086@¢\u0006\u0002\u0010\u0016J\b\u0010\u0017\u001a\u00020\u0014H\u0002R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u000e\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, m13886d2 = {"Landroidx/compose/foundation/text/SecureTextFieldController;", "", "obfuscationMaskState", "Landroidx/compose/runtime/State;", "", "(Landroidx/compose/runtime/State;)V", "codepointTransformation", "Landroidx/compose/foundation/text/input/internal/CodepointTransformation;", "getCodepointTransformation", "()Landroidx/compose/foundation/text/input/internal/CodepointTransformation;", "focusChangeModifier", "Landroidx/compose/ui/Modifier;", "getFocusChangeModifier", "()Landroidx/compose/ui/Modifier;", "passwordInputTransformation", "Landroidx/compose/foundation/text/PasswordInputTransformation;", "getPasswordInputTransformation", "()Landroidx/compose/foundation/text/PasswordInputTransformation;", "resetTimerSignal", "Lkotlinx/coroutines/channels/Channel;", "", "observeHideEvents", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "scheduleHide", "foundation_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
public final class SecureTextFieldController {
    public static final int $stable = 8;

    @NotNull
    private final State<Character> obfuscationMaskState;

    @NotNull
    private final PasswordInputTransformation passwordInputTransformation = new PasswordInputTransformation(new SecureTextFieldController$passwordInputTransformation$1(this));

    @NotNull
    private final CodepointTransformation codepointTransformation = new C1290a(this, 1);

    @NotNull
    private final Modifier focusChangeModifier = FocusChangedModifierKt.onFocusChanged(Modifier.INSTANCE, new Function1<FocusState, Unit>() { // from class: androidx.compose.foundation.text.SecureTextFieldController$focusChangeModifier$1
        {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(FocusState focusState) {
            invoke2(focusState);
            return Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(@NotNull FocusState focusState) {
            if (focusState.isFocused()) {
                return;
            }
            this.this$0.getPasswordInputTransformation().hide();
        }
    });

    @NotNull
    private final Channel<Unit> resetTimerSignal = ChannelKt.Channel$default(Integer.MAX_VALUE, null, null, 6, null);

    /* JADX INFO: renamed from: androidx.compose.foundation.text.SecureTextFieldController$observeHideEvents$2 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u008a@"}, m13886d2 = {"<anonymous>", "", LangPackConfigConstants.LANGUAGE_CODE_IT}, m13887k = 3, m13888mv = {1, 8, 0}, m13890xi = 48)
    @DebugMetadata(m14020c = "androidx.compose.foundation.text.SecureTextFieldController$observeHideEvents$2", m14021f = "BasicSecureTextField.kt", m14022i = {}, m14023l = {242}, m14024m = "invokeSuspend", m14025n = {}, m14026s = {})
    public static final class C12642 extends SuspendLambda implements Function2<Unit, Continuation<? super Unit>, Object> {
        int label;

        public C12642(Continuation<? super C12642> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return SecureTextFieldController.this.new C12642(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                if (DelayKt.delay(1500L, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            SecureTextFieldController.this.getPasswordInputTransformation().hide();
            return Unit.INSTANCE;
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        public final Object invoke(@NotNull Unit unit, @Nullable Continuation<? super Unit> continuation) {
            return ((C12642) create(unit, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    public SecureTextFieldController(@NotNull State<Character> state) {
        this.obfuscationMaskState = state;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int codepointTransformation$lambda$0(SecureTextFieldController secureTextFieldController, int i, int i2) {
        return i == secureTextFieldController.passwordInputTransformation.getRevealCodepointIndex$foundation_release() ? i2 : secureTextFieldController.obfuscationMaskState.getValue().charValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void scheduleHide() {
        if (ChannelResult.m23728isFailureimpl(this.resetTimerSignal.mo23705trySendJP2dKIU(Unit.INSTANCE))) {
            this.passwordInputTransformation.hide();
        }
    }

    @NotNull
    public final CodepointTransformation getCodepointTransformation() {
        return this.codepointTransformation;
    }

    @NotNull
    public final Modifier getFocusChangeModifier() {
        return this.focusChangeModifier;
    }

    @NotNull
    public final PasswordInputTransformation getPasswordInputTransformation() {
        return this.passwordInputTransformation;
    }

    @Nullable
    public final Object observeHideEvents(@NotNull Continuation<? super Unit> continuation) {
        Object objCollectLatest = FlowKt.collectLatest(FlowKt.consumeAsFlow(this.resetTimerSignal), new C12642(null), continuation);
        return objCollectLatest == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objCollectLatest : Unit.INSTANCE;
    }
}
