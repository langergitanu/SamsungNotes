package androidx.compose.foundation.text.input.internal;

import android.R;
import android.os.Build;
import android.os.Bundle;
import android.os.CancellationSignal;
import android.os.Handler;
import android.os.Parcelable;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.inputmethod.CompletionInfo;
import android.view.inputmethod.CorrectionInfo;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.ExtractedText;
import android.view.inputmethod.ExtractedTextRequest;
import android.view.inputmethod.HandwritingGesture;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputConnectionWrapper;
import android.view.inputmethod.InputContentInfo;
import android.view.inputmethod.PreviewableHandwritingGesture;
import androidx.collection.AbstractC0622a;
import androidx.compose.foundation.text.input.TextFieldCharSequence;
import androidx.compose.foundation.text.input.TextFieldCharSequenceKt;
import androidx.compose.p109ui.text.TextRange;
import androidx.compose.p109ui.text.input.ImeAction;
import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.core.view.inputmethod.InputConnectionCompat;
import androidx.core.view.inputmethod.InputContentInfoCompat;
import com.samsung.android.support.senl.p148nt.data.database.core.query.sqlbuilder.SQLKeyword;
import java.util.concurrent.Executor;
import java.util.function.IntConsumer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.apache.commons.beanutils.PropertyUtils;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@StabilityInferred(parameters = 0)
@Metadata(m13885d1 = {"\u0000¹\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b*\u0001\u0013\b\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J!\u0010\u0019\u001a\u00020\u00102\u0017\u0010\u001a\u001a\u0013\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00100\u000e¢\u0006\u0002\b\u0011H\u0002J\b\u0010\u001b\u001a\u00020\u001cH\u0016J\b\u0010\u001d\u001a\u00020\u001cH\u0002J\u0010\u0010\u001e\u001a\u00020\u001c2\u0006\u0010\u001f\u001a\u00020\bH\u0016J\b\u0010 \u001a\u00020\u0010H\u0016J\u0012\u0010!\u001a\u00020\u001c2\b\u0010\u0015\u001a\u0004\u0018\u00010\"H\u0016J\"\u0010#\u001a\u00020\u001c2\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\b2\b\u0010'\u001a\u0004\u0018\u00010(H\u0016J\u0012\u0010)\u001a\u00020\u001c2\b\u0010*\u001a\u0004\u0018\u00010+H\u0016J\u001a\u0010,\u001a\u00020\u001c2\b\u0010\u0015\u001a\u0004\u0018\u00010-2\u0006\u0010.\u001a\u00020\bH\u0016J\u0018\u0010/\u001a\u00020\u001c2\u0006\u00100\u001a\u00020\b2\u0006\u00101\u001a\u00020\bH\u0016J\u0018\u00102\u001a\u00020\u001c2\u0006\u00100\u001a\u00020\b2\u0006\u00101\u001a\u00020\bH\u0016J\b\u00103\u001a\u00020\u001cH\u0016J\b\u00104\u001a\u00020\u001cH\u0002J\b\u00105\u001a\u00020\u001cH\u0016J\u0010\u00106\u001a\u00020\b2\u0006\u00107\u001a\u00020\bH\u0016J\u001a\u00108\u001a\u0002092\b\u0010:\u001a\u0004\u0018\u00010;2\u0006\u0010&\u001a\u00020\bH\u0016J\n\u0010<\u001a\u0004\u0018\u00010=H\u0016J\u0012\u0010>\u001a\u0004\u0018\u00010-2\u0006\u0010&\u001a\u00020\bH\u0016J\u0018\u0010?\u001a\u00020-2\u0006\u0010@\u001a\u00020\b2\u0006\u0010&\u001a\u00020\bH\u0016J\u0018\u0010A\u001a\u00020-2\u0006\u0010@\u001a\u00020\b2\u0006\u0010&\u001a\u00020\bH\u0016J\u0010\u0010B\u001a\u00020\u00102\u0006\u0010C\u001a\u00020DH\u0002J\u0010\u0010E\u001a\u00020\u001c2\u0006\u0010F\u001a\u00020\bH\u0016J\u0010\u0010G\u001a\u00020\u001c2\u0006\u0010H\u001a\u00020\bH\u0016J$\u0010I\u001a\u00020\u00102\u0006\u0010J\u001a\u00020K2\b\u0010L\u001a\u0004\u0018\u00010M2\b\u0010N\u001a\u0004\u0018\u00010OH\u0016J\u001c\u0010P\u001a\u00020\u001c2\b\u0010Q\u001a\u0004\u0018\u00010D2\b\u0010R\u001a\u0004\u0018\u00010(H\u0016J\u001a\u0010S\u001a\u00020\u001c2\u0006\u0010J\u001a\u00020T2\b\u0010U\u001a\u0004\u0018\u00010VH\u0016J\u0010\u0010W\u001a\u00020\u001c2\u0006\u0010X\u001a\u00020\u001cH\u0016J\u0010\u0010Y\u001a\u00020\u001c2\u0006\u0010Z\u001a\u00020\bH\u0016J\u0010\u0010[\u001a\u00020\u001c2\u0006\u0010\\\u001a\u00020]H\u0016J\u0010\u0010^\u001a\u00020\u00102\u0006\u0010_\u001a\u00020\bH\u0002J\u0018\u0010`\u001a\u00020\u001c2\u0006\u0010a\u001a\u00020\b2\u0006\u0010b\u001a\u00020\bH\u0016J\u001a\u0010c\u001a\u00020\u001c2\b\u0010\u0015\u001a\u0004\u0018\u00010-2\u0006\u0010.\u001a\u00020\bH\u0016J\u0018\u0010d\u001a\u00020\u001c2\u0006\u0010a\u001a\u00020\b2\u0006\u0010b\u001a\u00020\bH\u0016R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\u00020\u0001X\u0082\u0004¢\u0006\b\n\u0000\u0012\u0004\b\n\u0010\u000bR%\u0010\f\u001a\u0019\u0012\u0015\u0012\u0013\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00100\u000e¢\u0006\u0002\b\u00110\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0014R\u0014\u0010\u0015\u001a\u00020\u00168BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018¨\u0006e"}, m13886d2 = {"Landroidx/compose/foundation/text/input/internal/StatelessInputConnection;", "Landroid/view/inputmethod/InputConnection;", "session", "Landroidx/compose/foundation/text/input/internal/TextInputSession;", "editorInfo", "Landroid/view/inputmethod/EditorInfo;", "(Landroidx/compose/foundation/text/input/internal/TextInputSession;Landroid/view/inputmethod/EditorInfo;)V", "batchDepth", "", "commitContentDelegateInputConnection", "getCommitContentDelegateInputConnection$annotations", "()V", "editCommands", "Landroidx/compose/runtime/collection/MutableVector;", "Lkotlin/Function1;", "Landroidx/compose/foundation/text/input/internal/EditingBuffer;", "", "Lkotlin/ExtensionFunctionType;", "terminalInputConnection", "androidx/compose/foundation/text/input/internal/StatelessInputConnection$terminalInputConnection$1", "Landroidx/compose/foundation/text/input/internal/StatelessInputConnection$terminalInputConnection$1;", "text", "Landroidx/compose/foundation/text/input/TextFieldCharSequence;", "getText", "()Landroidx/compose/foundation/text/input/TextFieldCharSequence;", "addEditCommandWithBatch", "editCommand", "beginBatchEdit", "", "beginBatchEditInternal", "clearMetaKeyStates", "states", "closeConnection", "commitCompletion", "Landroid/view/inputmethod/CompletionInfo;", "commitContent", "inputContentInfo", "Landroid/view/inputmethod/InputContentInfo;", "flags", "opts", "Landroid/os/Bundle;", "commitCorrection", "correctionInfo", "Landroid/view/inputmethod/CorrectionInfo;", "commitText", "", "newCursorPosition", "deleteSurroundingText", "beforeLength", "afterLength", "deleteSurroundingTextInCodePoints", "endBatchEdit", "endBatchEditInternal", "finishComposingText", "getCursorCapsMode", "reqModes", "getExtractedText", "Landroid/view/inputmethod/ExtractedText;", "request", "Landroid/view/inputmethod/ExtractedTextRequest;", "getHandler", "Landroid/os/Handler;", "getSelectedText", "getTextAfterCursor", "maxChars", "getTextBeforeCursor", "logDebug", "message", "", "performContextMenuAction", "id", "performEditorAction", "editorAction", "performHandwritingGesture", "gesture", "Landroid/view/inputmethod/HandwritingGesture;", "executor", "Ljava/util/concurrent/Executor;", "consumer", "Ljava/util/function/IntConsumer;", "performPrivateCommand", "action", "data", "previewHandwritingGesture", "Landroid/view/inputmethod/PreviewableHandwritingGesture;", "cancellationSignal", "Landroid/os/CancellationSignal;", "reportFullscreenMode", "enabled", "requestCursorUpdates", "cursorUpdateMode", "sendKeyEvent", "event", "Landroid/view/KeyEvent;", "sendSynthesizedKeyEvent", "code", "setComposingRegion", "start", "end", "setComposingText", "setSelection", "foundation_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nStatelessInputConnection.android.kt\nKotlin\n*S Kotlin\n*F\n+ 1 StatelessInputConnection.android.kt\nandroidx/compose/foundation/text/input/internal/StatelessInputConnection\n+ 2 MutableVector.kt\nandroidx/compose/runtime/collection/MutableVectorKt\n*L\n1#1,583:1\n1208#2:584\n1187#2,2:585\n*S KotlinDebug\n*F\n+ 1 StatelessInputConnection.android.kt\nandroidx/compose/foundation/text/input/internal/StatelessInputConnection\n*L\n100#1:584\n100#1:585,2\n*E\n"})
public final class StatelessInputConnection implements InputConnection {
    public static final int $stable = 8;
    private int batchDepth;

    @NotNull
    private final InputConnection commitContentDelegateInputConnection;

    @NotNull
    private final MutableVector<Function1<EditingBuffer, Unit>> editCommands = new MutableVector<>(new Function1[16], 0);

    @NotNull
    private final TextInputSession session;

    @NotNull
    private final StatelessInputConnection$terminalInputConnection$1 terminalInputConnection;

    /* JADX WARN: Type inference failed for: r3v2, types: [android.view.inputmethod.InputConnection, androidx.compose.foundation.text.input.internal.StatelessInputConnection$terminalInputConnection$1] */
    public StatelessInputConnection(@NotNull TextInputSession textInputSession, @NotNull EditorInfo editorInfo) {
        this.session = textInputSession;
        ?? r32 = new InputConnectionWrapper(this) { // from class: androidx.compose.foundation.text.input.internal.StatelessInputConnection$terminalInputConnection$1
            {
                super(this, false);
            }

            @Override // android.view.inputmethod.InputConnectionWrapper, android.view.inputmethod.InputConnection
            public boolean commitContent(@NotNull InputContentInfo inputContentInfo, int flags, @Nullable Bundle opts) {
                return false;
            }

            @Override // android.view.inputmethod.InputConnectionWrapper, android.view.inputmethod.InputConnection
            public boolean performPrivateCommand(@Nullable String action, @Nullable Bundle data) {
                return true;
            }
        };
        this.terminalInputConnection = r32;
        this.commitContentDelegateInputConnection = InputConnectionCompat.createWrapper((InputConnection) r32, editorInfo, new InputConnectionCompat.OnCommitContentListener() { // from class: androidx.compose.foundation.text.input.internal.StatelessInputConnection$commitContentDelegateInputConnection$1
            @Override // androidx.core.view.inputmethod.InputConnectionCompat.OnCommitContentListener
            public boolean onCommitContent(@NotNull InputContentInfoCompat inputContentInfo, int flags, @Nullable Bundle opts) {
                if ((flags & 1) != 0) {
                    try {
                        inputContentInfo.requestPermission();
                        Object objUnwrap = inputContentInfo.unwrap();
                        Intrinsics.checkNotNull(objUnwrap, "null cannot be cast to non-null type android.os.Parcelable");
                        Parcelable parcelable = (Parcelable) objUnwrap;
                        opts = opts == null ? new Bundle() : new Bundle(opts);
                        opts.putParcelable("EXTRA_INPUT_CONTENT_INFO", parcelable);
                    } catch (Exception e) {
                        this.this$0.logDebug("Can't insert content from IME; requestPermission() failed, " + e);
                        return false;
                    }
                }
                return this.this$0.session.onCommitContent(StatelessInputConnection_androidKt.toTransferableContent(inputContentInfo, opts));
            }
        });
    }

    private final void addEditCommandWithBatch(Function1<? super EditingBuffer, Unit> editCommand) {
        beginBatchEditInternal();
        try {
            this.editCommands.add(editCommand);
        } finally {
            endBatchEditInternal();
        }
    }

    private final boolean beginBatchEditInternal() {
        this.batchDepth++;
        return true;
    }

    private final boolean endBatchEditInternal() {
        int i = this.batchDepth - 1;
        this.batchDepth = i;
        if (i == 0 && this.editCommands.isNotEmpty()) {
            this.session.requestEdit(new Function1<EditingBuffer, Unit>() { // from class: androidx.compose.foundation.text.input.internal.StatelessInputConnection.endBatchEditInternal.1
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(EditingBuffer editingBuffer) {
                    invoke2(editingBuffer);
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@NotNull EditingBuffer editingBuffer) {
                    MutableVector mutableVector = StatelessInputConnection.this.editCommands;
                    int size = mutableVector.getSize();
                    if (size > 0) {
                        Object[] content = mutableVector.getContent();
                        int i2 = 0;
                        do {
                            ((Function1) content[i2]).invoke(editingBuffer);
                            i2++;
                        } while (i2 < size);
                    }
                }
            });
            this.editCommands.clear();
        }
        return this.batchDepth > 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final TextFieldCharSequence getText() {
        return this.session.getText();
    }

    private final void sendSynthesizedKeyEvent(int code) {
        sendKeyEvent(new KeyEvent(0, code));
        sendKeyEvent(new KeyEvent(1, code));
    }

    @Override // android.view.inputmethod.InputConnection
    public boolean beginBatchEdit() {
        logDebug("beginBatchEdit()");
        return beginBatchEditInternal();
    }

    @Override // android.view.inputmethod.InputConnection
    public boolean clearMetaKeyStates(int states) {
        logDebug(AbstractC0622a.m1167m("clearMetaKeyStates(", states, PropertyUtils.MAPPED_DELIM2));
        return false;
    }

    @Override // android.view.inputmethod.InputConnection
    public void closeConnection() {
        logDebug("closeConnection()");
        this.editCommands.clear();
        this.batchDepth = 0;
    }

    @Override // android.view.inputmethod.InputConnection
    public boolean commitCompletion(@Nullable CompletionInfo text) {
        StringBuilder sb = new StringBuilder("commitCompletion(");
        sb.append((Object) (text != null ? text.getText() : null));
        sb.append(PropertyUtils.MAPPED_DELIM2);
        logDebug(sb.toString());
        return false;
    }

    @Override // android.view.inputmethod.InputConnection
    public boolean commitContent(@NotNull InputContentInfo inputContentInfo, int flags, @Nullable Bundle opts) {
        logDebug("commitContent(" + inputContentInfo + SQLKeyword.COMMA + flags + SQLKeyword.COMMA + opts + PropertyUtils.MAPPED_DELIM2);
        return Api25CommitContentImpl.INSTANCE.commitContent(this.commitContentDelegateInputConnection, inputContentInfo, flags, opts);
    }

    @Override // android.view.inputmethod.InputConnection
    public boolean commitCorrection(@Nullable CorrectionInfo correctionInfo) {
        return true;
    }

    @Override // android.view.inputmethod.InputConnection
    public boolean commitText(@Nullable final CharSequence text, final int newCursorPosition) {
        logDebug("commitText(\"" + ((Object) text) + "\", " + newCursorPosition + PropertyUtils.MAPPED_DELIM2);
        addEditCommandWithBatch(new Function1<EditingBuffer, Unit>() { // from class: androidx.compose.foundation.text.input.internal.StatelessInputConnection.commitText.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(EditingBuffer editingBuffer) {
                invoke2(editingBuffer);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull EditingBuffer editingBuffer) {
                EditCommandKt.commitText(editingBuffer, String.valueOf(text), newCursorPosition);
            }
        });
        return true;
    }

    @Override // android.view.inputmethod.InputConnection
    public boolean deleteSurroundingText(final int beforeLength, final int afterLength) {
        logDebug(AbstractC0622a.m1168n("deleteSurroundingText(", beforeLength, SQLKeyword.COMMA, afterLength, PropertyUtils.MAPPED_DELIM2));
        addEditCommandWithBatch(new Function1<EditingBuffer, Unit>() { // from class: androidx.compose.foundation.text.input.internal.StatelessInputConnection.deleteSurroundingText.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(EditingBuffer editingBuffer) {
                invoke2(editingBuffer);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull EditingBuffer editingBuffer) {
                EditCommandKt.deleteSurroundingText(editingBuffer, beforeLength, afterLength);
            }
        });
        return true;
    }

    @Override // android.view.inputmethod.InputConnection
    public boolean deleteSurroundingTextInCodePoints(final int beforeLength, final int afterLength) {
        logDebug(AbstractC0622a.m1168n("deleteSurroundingTextInCodePoints(", beforeLength, SQLKeyword.COMMA, afterLength, PropertyUtils.MAPPED_DELIM2));
        addEditCommandWithBatch(new Function1<EditingBuffer, Unit>() { // from class: androidx.compose.foundation.text.input.internal.StatelessInputConnection.deleteSurroundingTextInCodePoints.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(EditingBuffer editingBuffer) {
                invoke2(editingBuffer);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull EditingBuffer editingBuffer) {
                EditCommandKt.deleteSurroundingTextInCodePoints(editingBuffer, beforeLength, afterLength);
            }
        });
        return true;
    }

    @Override // android.view.inputmethod.InputConnection
    public boolean endBatchEdit() {
        logDebug("endBatchEdit()");
        return endBatchEditInternal();
    }

    @Override // android.view.inputmethod.InputConnection
    public boolean finishComposingText() {
        logDebug("finishComposingText()");
        addEditCommandWithBatch(new Function1<EditingBuffer, Unit>() { // from class: androidx.compose.foundation.text.input.internal.StatelessInputConnection.finishComposingText.1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(EditingBuffer editingBuffer) {
                invoke2(editingBuffer);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull EditingBuffer editingBuffer) {
                EditCommandKt.finishComposingText(editingBuffer);
            }
        });
        return true;
    }

    @Override // android.view.inputmethod.InputConnection
    public int getCursorCapsMode(int reqModes) {
        logDebug(AbstractC0622a.m1167m("getCursorCapsMode(", reqModes, PropertyUtils.MAPPED_DELIM2));
        return TextUtils.getCapsMode(getText(), TextRange.m20454getMinimpl(getText().getSelection()), reqModes);
    }

    @Override // android.view.inputmethod.InputConnection
    @NotNull
    public ExtractedText getExtractedText(@Nullable ExtractedTextRequest request, int flags) {
        logDebug("getExtractedText(" + request + SQLKeyword.COMMA + flags + PropertyUtils.MAPPED_DELIM2);
        return StatelessInputConnection_androidKt.toExtractedText(getText());
    }

    @Override // android.view.inputmethod.InputConnection
    @Nullable
    public Handler getHandler() {
        logDebug("getHandler()");
        return null;
    }

    @Override // android.view.inputmethod.InputConnection
    @Nullable
    public CharSequence getSelectedText(int flags) {
        String string = TextRange.m20450getCollapsedimpl(getText().getSelection()) ? null : TextFieldCharSequenceKt.getSelectedText(getText()).toString();
        logDebug("getSelectedText(" + flags + "): " + ((Object) string));
        return string;
    }

    @Override // android.view.inputmethod.InputConnection
    @NotNull
    public CharSequence getTextAfterCursor(int maxChars, int flags) {
        String string = TextFieldCharSequenceKt.getTextAfterSelection(getText(), maxChars).toString();
        StringBuilder sbM1173s = AbstractC0622a.m1173s(maxChars, flags, "getTextAfterCursor(", SQLKeyword.COMMA, "): ");
        sbM1173s.append(string);
        logDebug(sbM1173s.toString());
        return string;
    }

    @Override // android.view.inputmethod.InputConnection
    @NotNull
    public CharSequence getTextBeforeCursor(int maxChars, int flags) {
        String string = TextFieldCharSequenceKt.getTextBeforeSelection(getText(), maxChars).toString();
        StringBuilder sbM1173s = AbstractC0622a.m1173s(maxChars, flags, "getTextBeforeCursor(", SQLKeyword.COMMA, "): ");
        sbM1173s.append(string);
        logDebug(sbM1173s.toString());
        return string;
    }

    @Override // android.view.inputmethod.InputConnection
    public boolean performContextMenuAction(int id) {
        logDebug(AbstractC0622a.m1167m("performContextMenuAction(", id, PropertyUtils.MAPPED_DELIM2));
        switch (id) {
            case R.id.selectAll:
                addEditCommandWithBatch(new Function1<EditingBuffer, Unit>() { // from class: androidx.compose.foundation.text.input.internal.StatelessInputConnection.performContextMenuAction.1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(EditingBuffer editingBuffer) {
                        invoke2(editingBuffer);
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(@NotNull EditingBuffer editingBuffer) {
                        editingBuffer.setSelection(0, StatelessInputConnection.this.getText().length());
                    }
                });
                break;
            case R.id.cut:
                sendSynthesizedKeyEvent(277);
                break;
            case R.id.copy:
                sendSynthesizedKeyEvent(278);
                break;
            case R.id.paste:
                sendSynthesizedKeyEvent(279);
                break;
        }
        return false;
    }

    @Override // android.view.inputmethod.InputConnection
    public boolean performEditorAction(int editorAction) {
        int iM20633getDefaulteUduSuo;
        logDebug(AbstractC0622a.m1167m("performEditorAction(", editorAction, PropertyUtils.MAPPED_DELIM2));
        if (editorAction != 0) {
            switch (editorAction) {
                case 2:
                    iM20633getDefaulteUduSuo = ImeAction.INSTANCE.m20635getGoeUduSuo();
                    break;
                case 3:
                    iM20633getDefaulteUduSuo = ImeAction.INSTANCE.m20639getSearcheUduSuo();
                    break;
                case 4:
                    iM20633getDefaulteUduSuo = ImeAction.INSTANCE.m20640getSendeUduSuo();
                    break;
                case 5:
                    iM20633getDefaulteUduSuo = ImeAction.INSTANCE.m20636getNexteUduSuo();
                    break;
                case 6:
                    iM20633getDefaulteUduSuo = ImeAction.INSTANCE.m20634getDoneeUduSuo();
                    break;
                case 7:
                    iM20633getDefaulteUduSuo = ImeAction.INSTANCE.m20638getPreviouseUduSuo();
                    break;
                default:
                    logDebug(AbstractC0000a.m11h(editorAction, "IME sent an unrecognized editor action: "));
                    iM20633getDefaulteUduSuo = ImeAction.INSTANCE.m20633getDefaulteUduSuo();
                    break;
            }
        } else {
            iM20633getDefaulteUduSuo = ImeAction.INSTANCE.m20633getDefaulteUduSuo();
        }
        this.session.mo16308onImeActionKlQnJC8(iM20633getDefaulteUduSuo);
        return true;
    }

    @Override // android.view.inputmethod.InputConnection
    public void performHandwritingGesture(@NotNull HandwritingGesture gesture, @Nullable Executor executor, @Nullable IntConsumer consumer) {
        logDebug("performHandwritingGesture(" + gesture + SQLKeyword.COMMA + executor + SQLKeyword.COMMA + consumer + PropertyUtils.MAPPED_DELIM2);
        if (Build.VERSION.SDK_INT < 34) {
            return;
        }
        Api34PerformHandwritingGestureImpl.INSTANCE.performHandwritingGesture(this.session, gesture, executor, consumer);
    }

    @Override // android.view.inputmethod.InputConnection
    public boolean performPrivateCommand(@Nullable String action, @Nullable Bundle data) {
        logDebug("performPrivateCommand(" + action + SQLKeyword.COMMA + data + PropertyUtils.MAPPED_DELIM2);
        return this.commitContentDelegateInputConnection.performPrivateCommand(action, data);
    }

    @Override // android.view.inputmethod.InputConnection
    public boolean previewHandwritingGesture(@NotNull PreviewableHandwritingGesture gesture, @Nullable CancellationSignal cancellationSignal) {
        logDebug("previewHandwritingGesture(" + gesture + SQLKeyword.COMMA + cancellationSignal + PropertyUtils.MAPPED_DELIM2);
        if (Build.VERSION.SDK_INT < 34) {
            return false;
        }
        return Api34PerformHandwritingGestureImpl.INSTANCE.previewHandwritingGesture(this.session, gesture, cancellationSignal);
    }

    @Override // android.view.inputmethod.InputConnection
    public boolean reportFullscreenMode(boolean enabled) {
        logDebug("reportFullscreenMode(" + enabled + PropertyUtils.MAPPED_DELIM2);
        return false;
    }

    @Override // android.view.inputmethod.InputConnection
    public boolean requestCursorUpdates(int cursorUpdateMode) {
        logDebug(AbstractC0622a.m1167m("requestCursorUpdates(", cursorUpdateMode, PropertyUtils.MAPPED_DELIM2));
        this.session.requestCursorUpdates(cursorUpdateMode);
        return true;
    }

    @Override // android.view.inputmethod.InputConnection
    public boolean sendKeyEvent(@NotNull KeyEvent event) {
        logDebug("sendKeyEvent(" + event + PropertyUtils.MAPPED_DELIM2);
        this.session.sendKeyEvent(event);
        return true;
    }

    @Override // android.view.inputmethod.InputConnection
    public boolean setComposingRegion(final int start, final int end) {
        logDebug(AbstractC0622a.m1168n("setComposingRegion(", start, SQLKeyword.COMMA, end, PropertyUtils.MAPPED_DELIM2));
        addEditCommandWithBatch(new Function1<EditingBuffer, Unit>() { // from class: androidx.compose.foundation.text.input.internal.StatelessInputConnection.setComposingRegion.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(EditingBuffer editingBuffer) {
                invoke2(editingBuffer);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull EditingBuffer editingBuffer) {
                EditCommandKt.setComposingRegion(editingBuffer, start, end);
            }
        });
        return true;
    }

    @Override // android.view.inputmethod.InputConnection
    public boolean setComposingText(@Nullable final CharSequence text, final int newCursorPosition) {
        logDebug("setComposingText(\"" + ((Object) text) + "\", " + newCursorPosition + PropertyUtils.MAPPED_DELIM2);
        addEditCommandWithBatch(new Function1<EditingBuffer, Unit>() { // from class: androidx.compose.foundation.text.input.internal.StatelessInputConnection.setComposingText.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(EditingBuffer editingBuffer) {
                invoke2(editingBuffer);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull EditingBuffer editingBuffer) {
                EditCommandKt.setComposingText(editingBuffer, String.valueOf(text), newCursorPosition);
            }
        });
        return true;
    }

    @Override // android.view.inputmethod.InputConnection
    public boolean setSelection(final int start, final int end) {
        logDebug(AbstractC0622a.m1168n("setSelection(", start, SQLKeyword.COMMA, end, PropertyUtils.MAPPED_DELIM2));
        addEditCommandWithBatch(new Function1<EditingBuffer, Unit>() { // from class: androidx.compose.foundation.text.input.internal.StatelessInputConnection.setSelection.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(EditingBuffer editingBuffer) {
                invoke2(editingBuffer);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull EditingBuffer editingBuffer) {
                editingBuffer.setSelection(start, end);
            }
        });
        return true;
    }

    private static /* synthetic */ void getCommitContentDelegateInputConnection$annotations() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void logDebug(String message) {
    }
}
