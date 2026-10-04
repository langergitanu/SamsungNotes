package androidx.compose.foundation.text.input.internal;

import android.os.Build;
import android.os.CancellationSignal;
import android.view.KeyEvent;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.HandwritingGesture;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.PreviewableHandwritingGesture;
import androidx.annotation.VisibleForTesting;
import androidx.compose.foundation.content.TransferableContent;
import androidx.compose.foundation.content.internal.ReceiveContentConfiguration;
import androidx.compose.foundation.text.input.InputTransformation;
import androidx.compose.foundation.text.input.TextFieldCharSequence;
import androidx.compose.foundation.text.input.TextFieldState;
import androidx.compose.foundation.text.input.internal.AndroidTextInputSession_androidKt;
import androidx.compose.foundation.text.input.internal.undo.TextFieldEditUndoBehavior;
import androidx.compose.p109ui.platform.PlatformTextInputMethodRequest;
import androidx.compose.p109ui.platform.PlatformTextInputSession;
import androidx.compose.p109ui.platform.ViewConfiguration;
import androidx.compose.p109ui.text.TextRange;
import androidx.compose.p109ui.text.input.ImeAction;
import androidx.compose.p109ui.text.input.ImeOptions;
import com.samsung.android.support.senl.p148nt.base.common.constants.Constants;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.flow.MutableSharedFlow;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m13885d1 = {"\u0000d\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a \u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\u00022\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00020\rH\u0002\u001al\u0010\u000e\u001a\u00020\u000f*\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u00182\u0014\u0010\u0019\u001a\u0010\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\n\u0018\u00010\u001a2\u0006\u0010\u001c\u001a\u00020\u001d2\u000e\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u001f2\b\u0010 \u001a\u0004\u0018\u00010!H\u0081@¢\u0006\u0002\u0010\"\u001ah\u0010\u000e\u001a\u00020\u000f*\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u00182\u0014\u0010\u0019\u001a\u0010\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\n\u0018\u00010\u001a2\u0010\b\u0002\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u001f2\n\b\u0002\u0010 \u001a\u0004\u0018\u00010!H\u0080@¢\u0006\u0002\u0010#\"\u0016\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0003\"\u0016\u0010\u0004\u001a\u00020\u00058\u0000X\u0081T¢\u0006\b\n\u0000\u0012\u0004\b\u0006\u0010\u0007\"\u000e\u0010\b\u001a\u00020\u0002X\u0082T¢\u0006\u0002\n\u0000¨\u0006$"}, m13886d2 = {"ALL_MIME_TYPES", "", "", "[Ljava/lang/String;", "TIA_DEBUG", "", "getTIA_DEBUG$annotations", "()V", "TIA_TAG", "logDebug", "", "tag", "content", "Lkotlin/Function0;", "platformSpecificTextInputSession", "", "Landroidx/compose/ui/platform/PlatformTextInputSession;", "state", "Landroidx/compose/foundation/text/input/internal/TransformedTextFieldState;", "layoutState", "Landroidx/compose/foundation/text/input/internal/TextLayoutState;", "imeOptions", "Landroidx/compose/ui/text/input/ImeOptions;", "receiveContentConfiguration", "Landroidx/compose/foundation/content/internal/ReceiveContentConfiguration;", "onImeAction", "Lkotlin/Function1;", "Landroidx/compose/ui/text/input/ImeAction;", "composeImm", "Landroidx/compose/foundation/text/input/internal/ComposeInputMethodManager;", "stylusHandwritingTrigger", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "viewConfiguration", "Landroidx/compose/ui/platform/ViewConfiguration;", "(Landroidx/compose/ui/platform/PlatformTextInputSession;Landroidx/compose/foundation/text/input/internal/TransformedTextFieldState;Landroidx/compose/foundation/text/input/internal/TextLayoutState;Landroidx/compose/ui/text/input/ImeOptions;Landroidx/compose/foundation/content/internal/ReceiveContentConfiguration;Lkotlin/jvm/functions/Function1;Landroidx/compose/foundation/text/input/internal/ComposeInputMethodManager;Lkotlinx/coroutines/flow/MutableSharedFlow;Landroidx/compose/ui/platform/ViewConfiguration;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "(Landroidx/compose/ui/platform/PlatformTextInputSession;Landroidx/compose/foundation/text/input/internal/TransformedTextFieldState;Landroidx/compose/foundation/text/input/internal/TextLayoutState;Landroidx/compose/ui/text/input/ImeOptions;Landroidx/compose/foundation/content/internal/ReceiveContentConfiguration;Lkotlin/jvm/functions/Function1;Lkotlinx/coroutines/flow/MutableSharedFlow;Landroidx/compose/ui/platform/ViewConfiguration;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "foundation_release"}, m13887k = 2, m13888mv = {1, 8, 0}, m13890xi = 48)
public final class AndroidTextInputSession_androidKt {

    @NotNull
    private static final String[] ALL_MIME_TYPES = {"*/*", Constants.MIME_IMAGE, "video/*"};
    public static final boolean TIA_DEBUG = false;

    @NotNull
    private static final String TIA_TAG = "AndroidTextInputSession";

    /* JADX INFO: renamed from: androidx.compose.foundation.text.input.internal.AndroidTextInputSession_androidKt$platformSpecificTextInputSession$1 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13887k = 3, m13888mv = {1, 8, 0}, m13890xi = 48)
    @DebugMetadata(m14020c = "androidx.compose.foundation.text.input.internal.AndroidTextInputSession_androidKt", m14021f = "AndroidTextInputSession.android.kt", m14022i = {}, m14023l = {59}, m14024m = "platformSpecificTextInputSession", m14025n = {}, m14026s = {})
    public static final class C12961 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        public C12961(Continuation<? super C12961> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return AndroidTextInputSession_androidKt.platformSpecificTextInputSession(null, null, null, null, null, null, null, null, this);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.text.input.internal.AndroidTextInputSession_androidKt$platformSpecificTextInputSession$2 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13887k = 3, m13888mv = {1, 8, 0}, m13890xi = 48)
    @DebugMetadata(m14020c = "androidx.compose.foundation.text.input.internal.AndroidTextInputSession_androidKt", m14021f = "AndroidTextInputSession.android.kt", m14022i = {}, m14023l = {82}, m14024m = "platformSpecificTextInputSession", m14025n = {}, m14026s = {})
    public static final class C12972 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        public C12972(Continuation<? super C12972> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return AndroidTextInputSession_androidKt.platformSpecificTextInputSession(null, null, null, null, null, null, null, null, null, this);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.text.input.internal.AndroidTextInputSession_androidKt$platformSpecificTextInputSession$3 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0001\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m13886d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m13887k = 3, m13888mv = {1, 8, 0}, m13890xi = 48)
    @DebugMetadata(m14020c = "androidx.compose.foundation.text.input.internal.AndroidTextInputSession_androidKt$platformSpecificTextInputSession$3", m14021f = "AndroidTextInputSession.android.kt", m14022i = {}, m14023l = {129}, m14024m = "invokeSuspend", m14025n = {}, m14026s = {})
    @SourceDebugExtension({"SMAP\nAndroidTextInputSession.android.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AndroidTextInputSession.android.kt\nandroidx/compose/foundation/text/input/internal/AndroidTextInputSession_androidKt$platformSpecificTextInputSession$3\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,211:1\n1#2:212\n*E\n"})
    public static final class C12983 extends SuspendLambda implements Function2<CoroutineScope, Continuation<?>, Object> {
        final /* synthetic */ ComposeInputMethodManager $composeImm;
        final /* synthetic */ ImeOptions $imeOptions;
        final /* synthetic */ TextLayoutState $layoutState;
        final /* synthetic */ Function1<ImeAction, Unit> $onImeAction;
        final /* synthetic */ ReceiveContentConfiguration $receiveContentConfiguration;
        final /* synthetic */ TransformedTextFieldState $state;
        final /* synthetic */ MutableSharedFlow<Unit> $stylusHandwritingTrigger;
        final /* synthetic */ PlatformTextInputSession $this_platformSpecificTextInputSession;
        final /* synthetic */ ViewConfiguration $viewConfiguration;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX INFO: renamed from: androidx.compose.foundation.text.input.internal.AndroidTextInputSession_androidKt$platformSpecificTextInputSession$3$1, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        @Metadata(m13885d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m13886d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m13887k = 3, m13888mv = {1, 8, 0}, m13890xi = 48)
        @DebugMetadata(m14020c = "androidx.compose.foundation.text.input.internal.AndroidTextInputSession_androidKt$platformSpecificTextInputSession$3$1", m14021f = "AndroidTextInputSession.android.kt", m14022i = {}, m14023l = {84}, m14024m = "invokeSuspend", m14025n = {}, m14026s = {})
        public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ ComposeInputMethodManager $composeImm;
            final /* synthetic */ TransformedTextFieldState $state;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass1(TransformedTextFieldState transformedTextFieldState, ComposeInputMethodManager composeInputMethodManager, Continuation<? super AnonymousClass1> continuation) {
                super(2, continuation);
                this.$state = transformedTextFieldState;
                this.$composeImm = composeInputMethodManager;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final void invokeSuspend$lambda$0(ComposeInputMethodManager composeInputMethodManager, TextFieldCharSequence textFieldCharSequence, TextFieldCharSequence textFieldCharSequence2, boolean z) {
                long selection = textFieldCharSequence.getSelection();
                long selection2 = textFieldCharSequence2.getSelection();
                TextRange composition = textFieldCharSequence.getComposition();
                TextRange composition2 = textFieldCharSequence2.getComposition();
                if (z && textFieldCharSequence.getComposition() != null && !textFieldCharSequence.contentEquals(textFieldCharSequence2)) {
                    composeInputMethodManager.restartInput();
                } else {
                    if (TextRange.m20449equalsimpl0(selection, selection2) && Intrinsics.areEqual(composition, composition2)) {
                        return;
                    }
                    composeInputMethodManager.updateSelection(TextRange.m20454getMinimpl(selection2), TextRange.m20453getMaximpl(selection2), composition2 != null ? TextRange.m20454getMinimpl(composition2.getPackedValue()) : -1, composition2 != null ? TextRange.m20453getMaximpl(composition2.getPackedValue()) : -1);
                }
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @NotNull
            public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
                return new AnonymousClass1(this.$state, this.$composeImm, continuation);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @Nullable
            public final Object invokeSuspend(@NotNull Object obj) {
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i = this.label;
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    TransformedTextFieldState transformedTextFieldState = this.$state;
                    final ComposeInputMethodManager composeInputMethodManager = this.$composeImm;
                    TextFieldState.NotifyImeListener notifyImeListener = new TextFieldState.NotifyImeListener() { // from class: androidx.compose.foundation.text.input.internal.b
                        @Override // androidx.compose.foundation.text.input.TextFieldState.NotifyImeListener
                        public final void onChange(TextFieldCharSequence textFieldCharSequence, TextFieldCharSequence textFieldCharSequence2, boolean z) {
                            AndroidTextInputSession_androidKt.C12983.AnonymousClass1.invokeSuspend$lambda$0(composeInputMethodManager, textFieldCharSequence, textFieldCharSequence2, z);
                        }
                    };
                    this.label = 1;
                    if (transformedTextFieldState.collectImeNotifications(notifyImeListener, this) == coroutine_suspended) {
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

            @Override // kotlin.jvm.functions.Function2
            @Nullable
            public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
                return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public C12983(MutableSharedFlow<Unit> mutableSharedFlow, TransformedTextFieldState transformedTextFieldState, TextLayoutState textLayoutState, ComposeInputMethodManager composeInputMethodManager, PlatformTextInputSession platformTextInputSession, ImeOptions imeOptions, ReceiveContentConfiguration receiveContentConfiguration, Function1<? super ImeAction, Unit> function1, ViewConfiguration viewConfiguration, Continuation<? super C12983> continuation) {
            super(2, continuation);
            this.$stylusHandwritingTrigger = mutableSharedFlow;
            this.$state = transformedTextFieldState;
            this.$layoutState = textLayoutState;
            this.$composeImm = composeInputMethodManager;
            this.$this_platformSpecificTextInputSession = platformTextInputSession;
            this.$imeOptions = imeOptions;
            this.$receiveContentConfiguration = receiveContentConfiguration;
            this.$onImeAction = function1;
            this.$viewConfiguration = viewConfiguration;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final InputConnection invokeSuspend$lambda$2(final TransformedTextFieldState transformedTextFieldState, ImeOptions imeOptions, final ReceiveContentConfiguration receiveContentConfiguration, final ComposeInputMethodManager composeInputMethodManager, final Function1 function1, final CursorAnchorInfoController cursorAnchorInfoController, final TextLayoutState textLayoutState, final ViewConfiguration viewConfiguration, EditorInfo editorInfo) {
            AndroidTextInputSession_androidKt.logDebug$default(null, new Function0<String>() { // from class: androidx.compose.foundation.text.input.internal.AndroidTextInputSession_androidKt$platformSpecificTextInputSession$3$3$1
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                @NotNull
                public final String invoke() {
                    return "createInputConnection(value=\"" + ((Object) transformedTextFieldState.getVisualText()) + "\")";
                }
            }, 1, null);
            TextInputSession textInputSession = new TextInputSession() { // from class: androidx.compose.foundation.text.input.internal.AndroidTextInputSession_androidKt$platformSpecificTextInputSession$3$3$textInputSession$1
                @Override // androidx.compose.foundation.text.input.internal.TextInputSession
                @NotNull
                public TextFieldCharSequence getText() {
                    return transformedTextFieldState.getVisualText();
                }

                @Override // androidx.compose.foundation.text.input.internal.TextInputSession
                public boolean onCommitContent(@NotNull TransferableContent transferableContent) {
                    ReceiveContentConfiguration receiveContentConfiguration2 = receiveContentConfiguration;
                    if (receiveContentConfiguration2 != null) {
                        return receiveContentConfiguration2.onCommitContent(transferableContent);
                    }
                    return false;
                }

                @Override // androidx.compose.foundation.text.input.internal.TextInputSession
                /* JADX INFO: renamed from: onImeAction-KlQnJC8, reason: not valid java name */
                public void mo16308onImeActionKlQnJC8(int imeAction) {
                    Function1<ImeAction, Unit> function12 = function1;
                    if (function12 != null) {
                        function12.invoke(ImeAction.m20617boximpl(imeAction));
                    }
                }

                @Override // androidx.compose.foundation.text.input.internal.TextInputSession
                public int performHandwritingGesture(@NotNull HandwritingGesture gesture) {
                    if (Build.VERSION.SDK_INT >= 34) {
                        return HandwritingGestureApi34.INSTANCE.performHandwritingGesture$foundation_release(transformedTextFieldState, gesture, textLayoutState, viewConfiguration);
                    }
                    return 2;
                }

                @Override // androidx.compose.foundation.text.input.internal.TextInputSession
                public boolean previewHandwritingGesture(@NotNull PreviewableHandwritingGesture gesture, @Nullable CancellationSignal cancellationSignal) {
                    if (Build.VERSION.SDK_INT >= 34) {
                        return HandwritingGestureApi34.INSTANCE.previewHandwritingGesture$foundation_release(transformedTextFieldState, gesture, textLayoutState, cancellationSignal);
                    }
                    return false;
                }

                @Override // androidx.compose.foundation.text.input.internal.TextInputSession
                public void requestCursorUpdates(int cursorUpdateMode) {
                    cursorAnchorInfoController.requestUpdates(cursorUpdateMode);
                }

                @Override // androidx.compose.foundation.text.input.internal.TextInputSession
                public void requestEdit(@NotNull Function1<? super EditingBuffer, Unit> block) {
                    TransformedTextFieldState transformedTextFieldState2 = transformedTextFieldState;
                    TextFieldState textFieldState = transformedTextFieldState2.textFieldState;
                    InputTransformation inputTransformation = transformedTextFieldState2.inputTransformation;
                    TextFieldEditUndoBehavior textFieldEditUndoBehavior = TextFieldEditUndoBehavior.MergeIfPossible;
                    textFieldState.getMainBuffer().getChangeTracker().clearChanges();
                    block.invoke(textFieldState.getMainBuffer());
                    textFieldState.commitEditAsUser(inputTransformation, false, textFieldEditUndoBehavior);
                }

                @Override // androidx.compose.foundation.text.input.internal.TextInputSession
                public void sendKeyEvent(@NotNull KeyEvent keyEvent) {
                    composeInputMethodManager.sendKeyEvent(keyEvent);
                }
            };
            EditorInfo_androidKt.m16315updatepLxbY9I(editorInfo, transformedTextFieldState.getVisualText(), transformedTextFieldState.getVisualText().getSelection(), imeOptions, receiveContentConfiguration != null ? AndroidTextInputSession_androidKt.ALL_MIME_TYPES : null);
            return new StatelessInputConnection(textInputSession, editorInfo);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            C12983 c12983 = new C12983(this.$stylusHandwritingTrigger, this.$state, this.$layoutState, this.$composeImm, this.$this_platformSpecificTextInputSession, this.$imeOptions, this.$receiveContentConfiguration, this.$onImeAction, this.$viewConfiguration, continuation);
            c12983.L$0 = obj;
            return c12983;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
                BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, CoroutineStart.UNDISPATCHED, new AnonymousClass1(this.$state, this.$composeImm, null), 1, null);
                MutableSharedFlow<Unit> mutableSharedFlow = this.$stylusHandwritingTrigger;
                if (mutableSharedFlow != null) {
                    BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new C1299x2b7eadeb(mutableSharedFlow, this.$composeImm, null), 3, null);
                }
                final CursorAnchorInfoController cursorAnchorInfoController = new CursorAnchorInfoController(this.$state, this.$layoutState, this.$composeImm, coroutineScope);
                PlatformTextInputSession platformTextInputSession = this.$this_platformSpecificTextInputSession;
                final TransformedTextFieldState transformedTextFieldState = this.$state;
                final ImeOptions imeOptions = this.$imeOptions;
                final ReceiveContentConfiguration receiveContentConfiguration = this.$receiveContentConfiguration;
                final ComposeInputMethodManager composeInputMethodManager = this.$composeImm;
                final Function1<ImeAction, Unit> function1 = this.$onImeAction;
                final TextLayoutState textLayoutState = this.$layoutState;
                final ViewConfiguration viewConfiguration = this.$viewConfiguration;
                PlatformTextInputMethodRequest platformTextInputMethodRequest = new PlatformTextInputMethodRequest() { // from class: androidx.compose.foundation.text.input.internal.a
                    @Override // androidx.compose.p109ui.platform.PlatformTextInputMethodRequest
                    public final InputConnection createInputConnection(EditorInfo editorInfo) {
                        return AndroidTextInputSession_androidKt.C12983.invokeSuspend$lambda$2(transformedTextFieldState, imeOptions, receiveContentConfiguration, composeInputMethodManager, function1, cursorAnchorInfoController, textLayoutState, viewConfiguration, editorInfo);
                    }
                };
                this.label = 1;
                if (platformTextInputSession.startInputMethod(platformTextInputMethodRequest, this) == coroutine_suspended) {
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

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<?> continuation) {
            return ((C12983) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    public static /* synthetic */ void logDebug$default(String str, Function0 function0, int i, Object obj) {
        if ((i & 1) != 0) {
            str = TIA_TAG;
        }
        logDebug(str, function0);
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x0016  */
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object platformSpecificTextInputSession(@NotNull PlatformTextInputSession platformTextInputSession, @NotNull TransformedTextFieldState transformedTextFieldState, @NotNull TextLayoutState textLayoutState, @NotNull ImeOptions imeOptions, @Nullable ReceiveContentConfiguration receiveContentConfiguration, @Nullable Function1<? super ImeAction, Unit> function1, @Nullable MutableSharedFlow<Unit> mutableSharedFlow, @Nullable ViewConfiguration viewConfiguration, @NotNull Continuation<?> continuation) {
        C12961 c12961;
        if (continuation instanceof C12961) {
            c12961 = (C12961) continuation;
            int i = c12961.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c12961.label = i - Integer.MIN_VALUE;
            } else {
                c12961 = new C12961(continuation);
            }
        }
        C12961 c129612 = c12961;
        Object obj = c129612.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = c129612.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            ComposeInputMethodManager ComposeInputMethodManager = ComposeInputMethodManager_androidKt.ComposeInputMethodManager(platformTextInputSession.getView());
            c129612.label = 1;
            if (platformSpecificTextInputSession(platformTextInputSession, transformedTextFieldState, textLayoutState, imeOptions, receiveContentConfiguration, function1, ComposeInputMethodManager, mutableSharedFlow, viewConfiguration, c129612) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        throw new KotlinNothingValueException();
    }

    public static /* synthetic */ Object platformSpecificTextInputSession$default(PlatformTextInputSession platformTextInputSession, TransformedTextFieldState transformedTextFieldState, TextLayoutState textLayoutState, ImeOptions imeOptions, ReceiveContentConfiguration receiveContentConfiguration, Function1 function1, MutableSharedFlow mutableSharedFlow, ViewConfiguration viewConfiguration, Continuation continuation, int i, Object obj) {
        if ((i & 32) != 0) {
            mutableSharedFlow = null;
        }
        if ((i & 64) != 0) {
            viewConfiguration = null;
        }
        return platformSpecificTextInputSession(platformTextInputSession, transformedTextFieldState, textLayoutState, imeOptions, receiveContentConfiguration, function1, mutableSharedFlow, viewConfiguration, continuation);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0015  */
    @VisibleForTesting
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object platformSpecificTextInputSession(@NotNull PlatformTextInputSession platformTextInputSession, @NotNull TransformedTextFieldState transformedTextFieldState, @NotNull TextLayoutState textLayoutState, @NotNull ImeOptions imeOptions, @Nullable ReceiveContentConfiguration receiveContentConfiguration, @Nullable Function1<? super ImeAction, Unit> function1, @NotNull ComposeInputMethodManager composeInputMethodManager, @Nullable MutableSharedFlow<Unit> mutableSharedFlow, @Nullable ViewConfiguration viewConfiguration, @NotNull Continuation<?> continuation) {
        C12972 c12972;
        if (continuation instanceof C12972) {
            c12972 = (C12972) continuation;
            int i = c12972.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c12972.label = i - Integer.MIN_VALUE;
            } else {
                c12972 = new C12972(continuation);
            }
        }
        Object obj = c12972.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = c12972.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            C12983 c12983 = new C12983(mutableSharedFlow, transformedTextFieldState, textLayoutState, composeInputMethodManager, platformTextInputSession, imeOptions, receiveContentConfiguration, function1, viewConfiguration, null);
            c12972.label = 1;
            if (CoroutineScopeKt.coroutineScope(c12983, c12972) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        throw new KotlinNothingValueException();
    }

    @VisibleForTesting
    public static /* synthetic */ void getTIA_DEBUG$annotations() {
    }

    private static final void logDebug(String str, Function0<String> function0) {
    }
}
