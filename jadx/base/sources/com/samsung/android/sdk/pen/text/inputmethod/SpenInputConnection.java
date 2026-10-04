package com.samsung.android.sdk.pen.text.inputmethod;

import android.os.Build;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.Editable;
import android.text.Selection;
import android.text.method.KeyListener;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.BaseInputConnection;
import android.view.inputmethod.CorrectionInfo;
import android.view.inputmethod.ExtractedText;
import android.view.inputmethod.ExtractedTextRequest;
import androidx.compose.foundation.layout.AbstractC1038a;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.samsung.android.app.notes.sync.coedit.sharecore.strategy.AbstractC6670b;
import com.samsung.android.sdk.pen.view.SpenDisplay;
import com.samsung.android.support.senl.p148nt.data.common.utils.AbstractC11014a;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.Regex;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m13885d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001a\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0019\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 h2\u00020\u0001:\u0002ghBt\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012M\u0010\u0006\u001aI\u0012\u0013\u0012\u00110\b¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0013\u0012\u00110\f¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\r\u0012\u0013\u0012\u00110\f¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u0007\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011¢\u0006\u0004\b\u0012\u0010\u0013J\u0006\u00101\u001a\u000202J\u000e\u00103\u001a\u0002022\u0006\u00104\u001a\u00020\u000fJ\u0006\u00105\u001a\u00020\u000fJ\u0010\u00106\u001a\u0002022\b\u00107\u001a\u0004\u0018\u00010,J\n\u00108\u001a\u0004\u0018\u00010,H\u0016J\u0010\u00109\u001a\u0002022\b\u0010\u0004\u001a\u0004\u0018\u00010.J\b\u0010<\u001a\u00020\u000fH\u0016J\b\u0010=\u001a\u00020\u000fH\u0016J\u0006\u0010>\u001a\u000202J\u0010\u0010?\u001a\u00020\u000f2\u0006\u0010@\u001a\u00020\fH\u0016J\u0018\u0010A\u001a\u00020\u000f2\u0006\u0010B\u001a\u00020\f2\u0006\u0010C\u001a\u00020\fH\u0016J\b\u0010D\u001a\u00020\u000fH\u0016J\u001a\u0010E\u001a\u00020\u000f2\b\u0010\u000b\u001a\u0004\u0018\u00010\b2\u0006\u0010F\u001a\u00020\fH\u0016J\u001a\u0010G\u001a\u00020\u000f2\b\u0010\u000b\u001a\u0004\u0018\u00010\b2\u0006\u0010F\u001a\u00020\fH\u0016J\u0018\u0010H\u001a\u00020\u000f2\u0006\u0010I\u001a\u00020\f2\u0006\u0010J\u001a\u00020\fH\u0016J\u001c\u0010K\u001a\u0004\u0018\u00010L2\b\u0010M\u001a\u0004\u0018\u00010N2\u0006\u0010O\u001a\u00020\fH\u0016J\u0010\u0010P\u001a\u00020\u000f2\u0006\u0010Q\u001a\u00020\fH\u0016J\u0006\u0010R\u001a\u000202J\u0006\u0010S\u001a\u00020\u000fJ\u0012\u0010T\u001a\u00020\u000f2\b\u0010\u000b\u001a\u0004\u0018\u00010\bH\u0002J\b\u0010U\u001a\u000202H\u0002J\b\u0010V\u001a\u000202H\u0002J\b\u0010W\u001a\u000202H\u0002J\u0006\u0010X\u001a\u000202J\u0006\u0010Y\u001a\u000202J\u0010\u0010Z\u001a\u0002022\u0006\u0010[\u001a\u00020\fH\u0002J\u001a\u0010\\\u001a\u0002022\b\u0010]\u001a\u0004\u0018\u00010^2\u0006\u0010_\u001a\u00020^H\u0002J\u0012\u0010`\u001a\u00020\u000f2\b\u0010a\u001a\u0004\u0018\u00010bH\u0016J\u001c\u0010c\u001a\u00020\u000f2\b\u0010d\u001a\u0004\u0018\u00010^2\b\u0010e\u001a\u0004\u0018\u00010fH\u0016R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0019\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001a\u0010\u001e\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u001b\"\u0004\b \u0010\u001dR\u001a\u0010!\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%Ra\u0010&\u001aI\u0012\u0013\u0012\u00110\b¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0013\u0012\u00110\f¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\r\u0012\u0013\u0012\u00110\f¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\u0010\u0010+\u001a\u0004\u0018\u00010,X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010-\u001a\u0004\u0018\u00010.X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010/\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00100\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010:\u001a\u00020\f8F¢\u0006\u0006\u001a\u0004\b;\u0010\u001b¨\u0006i"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/text/inputmethod/SpenInputConnection;", "Landroid/view/inputmethod/BaseInputConnection;", "mTextView", "Landroid/view/View;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/samsung/android/sdk/pen/text/inputmethod/SpenInputConnection$TextComposingListener;", "preCommitCheckFunction", "Lkotlin/Function3;", "", "Lkotlin/ParameterName;", "name", "text", "", "composingStart", "composingEnd", "", "preCommitRegex", "Lkotlin/text/Regex;", "<init>", "(Landroid/view/View;Lcom/samsung/android/sdk/pen/text/inputmethod/SpenInputConnection$TextComposingListener;Lkotlin/jvm/functions/Function3;Lkotlin/text/Regex;)V", "mDebugLevel", "mBatchEditNesting", "mIsCommitText", "mIsDeletedText", "mIsComposingText", "surroundingTextLength", "getSurroundingTextLength", "()I", "setSurroundingTextLength", "(I)V", "deletedSurroundingTextLength", "getDeletedSurroundingTextLength", "setDeletedSurroundingTextLength", "mPreCommitRegex", "getMPreCommitRegex", "()Lkotlin/text/Regex;", "setMPreCommitRegex", "(Lkotlin/text/Regex;)V", "mPreCommitCheckFunction", "getMPreCommitCheckFunction", "()Lkotlin/jvm/functions/Function3;", "setMPreCommitCheckFunction", "(Lkotlin/jvm/functions/Function3;)V", "mEditable", "Landroid/text/Editable;", "mKeyListener", "Landroid/text/method/KeyListener;", "mDisallowInputText", "mListener", "close", "", "requestDisallowInputText", "disallowInput", "canInputText", "setEditable", "editable", "getEditable", "setKeyListener", "batchEditNesting", "getBatchEditNesting", "beginBatchEdit", "endBatchEdit", "clearBatchEdit", "clearMetaKeyStates", "states", "deleteSurroundingText", "beforeLength", "afterLength", "finishComposingText", "commitText", "newCursorPosition", "setComposingText", "setSelection", "start", "end", "getExtractedText", "Landroid/view/inputmethod/ExtractedText;", "request", "Landroid/view/inputmethod/ExtractedTextRequest;", "flags", "performContextMenuAction", "id", "initialize", "isTextChanged", "beginCommit", "endCommit", "beginComposing", "endComposing", "beginDelete", "endDelete", "sendKeyEvent", "keyCode", "printLog", "tag", "", "msg", "commitCorrection", "correctionInfo", "Landroid/view/inputmethod/CorrectionInfo;", "performPrivateCommand", "action", "data", "Landroid/os/Bundle;", "TextComposingListener", "Companion", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nSpenInputConnection.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SpenInputConnection.kt\ncom/samsung/android/sdk/pen/text/inputmethod/SpenInputConnection\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,458:1\n1#2:459\n*E\n"})
public final class SpenInputConnection extends BaseInputConnection {
    private static final boolean DBG = Intrinsics.areEqual("eng", Build.TYPE);

    @NotNull
    private static final String EMPTY_STRING = "";

    @NotNull
    private static final String NULL_STRING = "\u0000";

    @NotNull
    private static final String TAG = "SpenInputConnection";
    private int deletedSurroundingTextLength;
    private int mBatchEditNesting;
    private int mDebugLevel;
    private boolean mDisallowInputText;

    @Nullable
    private Editable mEditable;
    private boolean mIsCommitText;
    private boolean mIsComposingText;
    private boolean mIsDeletedText;

    @Nullable
    private KeyListener mKeyListener;

    @Nullable
    private TextComposingListener mListener;

    @Nullable
    private Function3<? super CharSequence, ? super Integer, ? super Integer, Boolean> mPreCommitCheckFunction;

    @NotNull
    private Regex mPreCommitRegex;

    @Nullable
    private View mTextView;
    private int surroundingTextLength;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0012\u0010\b\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J \u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u0007H&J\u0010\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u0007H&J\u0018\u0010\u000f\u001a\u00020\u00102\u0006\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u0007H&J\b\u0010\u0011\u001a\u00020\u0003H&J\b\u0010\u0012\u001a\u00020\u0003H&J\b\u0010\u0013\u001a\u00020\u0010H&J\u0012\u0010\u0014\u001a\u00020\u00102\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H&J\u001c\u0010\u0017\u001a\u00020\u00032\b\u0010\u0018\u001a\u0004\u0018\u00010\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH&¨\u0006\u001c"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/text/inputmethod/SpenInputConnection$TextComposingListener;", "", "onComposingText", "", "text", "", "newCursorPosition", "", "onCommitText", "onDeleteSurroundingText", "start", "end", "after", "onPerformContextMenuAction", "id", "onSetSelection", "", "onBeginBatchEdit", "onEndBatchEdit", "onFinishComposingText", "onCommitCorrection", "info", "Landroid/view/inputmethod/CorrectionInfo;", "onPrivateIMECommand", "action", "", "data", "Landroid/os/Bundle;", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public interface TextComposingListener {
        boolean onBeginBatchEdit();

        void onCommitCorrection(@Nullable CorrectionInfo info);

        boolean onCommitText(@Nullable CharSequence text);

        boolean onComposingText(@Nullable CharSequence text, int newCursorPosition);

        boolean onDeleteSurroundingText(int start, int end, int after);

        boolean onEndBatchEdit();

        void onFinishComposingText();

        boolean onPerformContextMenuAction(int id);

        boolean onPrivateIMECommand(@Nullable String action, @Nullable Bundle data);

        void onSetSelection(int start, int end);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SpenInputConnection(@Nullable View view, @Nullable TextComposingListener textComposingListener, @Nullable Function3<? super CharSequence, ? super Integer, ? super Integer, Boolean> function3, @Nullable Regex regex) {
        super(view, true);
        Intrinsics.checkNotNull(view);
        this.mTextView = view;
        this.mPreCommitRegex = new Regex("(?s)^.{10,}$");
        if (textComposingListener != null) {
            this.mListener = textComposingListener;
        }
        if (function3 != null) {
            this.mPreCommitCheckFunction = function3;
        }
        if (regex != null) {
            this.mPreCommitRegex = regex;
        }
        this.mDisallowInputText = false;
        this.mDebugLevel = SpenDisplay.INSTANCE.getDebugLevel();
    }

    private final boolean beginCommit(CharSequence text) {
        TextComposingListener textComposingListener = this.mListener;
        if (textComposingListener != null && textComposingListener.onCommitText(text)) {
            return true;
        }
        this.mIsDeletedText = false;
        this.mIsCommitText = true;
        return false;
    }

    private final void beginComposing() {
        this.mIsDeletedText = false;
        this.mIsComposingText = true;
    }

    private final void endCommit() {
        this.mIsCommitText = false;
    }

    private final void endComposing() {
        this.mIsComposingText = false;
    }

    private final void printLog(String tag, String msg) {
        if (this.mDebugLevel > 0 || DBG) {
            Log.d(tag, msg);
        }
    }

    private final void sendKeyEvent(int keyCode) {
        long jUptimeMillis = SystemClock.uptimeMillis();
        sendKeyEvent(new KeyEvent(jUptimeMillis, jUptimeMillis, 0, keyCode, 0, 0, -1, 0, 22));
        sendKeyEvent(new KeyEvent(SystemClock.uptimeMillis(), jUptimeMillis, 1, keyCode, 0, 0, -1, 0, 22));
    }

    @Override // android.view.inputmethod.BaseInputConnection, android.view.inputmethod.InputConnection
    public boolean beginBatchEdit() {
        synchronized (this) {
            int i = this.mBatchEditNesting;
            if (i < 0) {
                Unit unit = Unit.INSTANCE;
                return false;
            }
            int i2 = i + 1;
            this.mBatchEditNesting = i2;
            Log.i(TAG, "beginBatchEdit() mBatchEditNesting : " + i2);
            TextComposingListener textComposingListener = this.mListener;
            return textComposingListener != null ? textComposingListener.onBeginBatchEdit() : true;
        }
    }

    public final void beginDelete() {
        this.mIsDeletedText = true;
    }

    public final boolean canInputText() {
        return !this.mDisallowInputText;
    }

    public final void clearBatchEdit() {
        synchronized (this) {
            Log.i(TAG, "clearBatchEdit() mBatchEditNesting : " + this.mBatchEditNesting);
            this.mBatchEditNesting = 0;
            Unit unit = Unit.INSTANCE;
        }
    }

    @Override // android.view.inputmethod.BaseInputConnection, android.view.inputmethod.InputConnection
    public boolean clearMetaKeyStates(int states) {
        KeyListener keyListener;
        Log.i(TAG, "clearMetaKeyStates()");
        Editable editable = getEditable();
        if (editable == null) {
            return false;
        }
        View view = this.mTextView;
        if (view == null || (keyListener = this.mKeyListener) == null) {
            return true;
        }
        try {
            keyListener.clearMetaKeyState(view, editable, states);
            return true;
        } catch (AbstractMethodError e) {
            e.printStackTrace();
            return true;
        }
    }

    public final void close() {
        this.mTextView = null;
        this.mListener = null;
        this.mKeyListener = null;
    }

    @Override // android.view.inputmethod.BaseInputConnection, android.view.inputmethod.InputConnection
    public boolean commitCorrection(@Nullable CorrectionInfo correctionInfo) {
        TextComposingListener textComposingListener = this.mListener;
        if (textComposingListener != null) {
            textComposingListener.onCommitCorrection(correctionInfo);
        }
        return super.commitCorrection(correctionInfo);
    }

    @Override // android.view.inputmethod.BaseInputConnection, android.view.inputmethod.InputConnection
    public boolean commitText(@Nullable CharSequence text, int newCursorPosition) {
        Function3<? super CharSequence, ? super Integer, ? super Integer, Boolean> function3;
        Editable editable = getEditable();
        if (editable != null && text != null) {
            CharSequence charSequence = this.mPreCommitRegex.matches(text) ? text : null;
            if (charSequence != null && (function3 = this.mPreCommitCheckFunction) != null) {
                if (!function3.invoke(charSequence, Integer.valueOf(BaseInputConnection.getComposingSpanStart(editable)), Integer.valueOf(BaseInputConnection.getComposingSpanEnd(editable))).booleanValue()) {
                    return false;
                }
            }
        }
        printLog(TAG, "commitText() : " + ((Object) text) + ", newCursorPosition : " + newCursorPosition);
        if (this.mDisallowInputText || text == null) {
            return false;
        }
        String strReplace = new Regex("\u0000").replace(text.toString(), "");
        int length = text.length() - strReplace.length();
        if (length > 0) {
            AbstractC11014a.m12328m(length, "Removed ", " null character(s)", TAG);
        }
        if (beginCommit(length == 0 ? text : strReplace)) {
            return false;
        }
        if (length != 0) {
            text = strReplace;
        }
        super.commitText(text, newCursorPosition);
        endCommit();
        return true;
    }

    @Override // android.view.inputmethod.BaseInputConnection, android.view.inputmethod.InputConnection
    public boolean deleteSurroundingText(int beforeLength, int afterLength) {
        Editable editable;
        AbstractC6670b.m4744e(beforeLength, afterLength, "deleteSurroundingText() beforeLength : ", ", afterLength : ", TAG);
        if (this.mDisallowInputText || (editable = getEditable()) == null) {
            return false;
        }
        int selectionStart = Selection.getSelectionStart(editable);
        int selectionEnd = Selection.getSelectionEnd(editable);
        if (selectionStart < 0 || selectionEnd < 0) {
            Log.e(TAG, "deleteSurroundingText() invalid cursor position. start : " + selectionStart + ", end : " + selectionEnd);
            return false;
        }
        if (selectionStart > selectionEnd) {
            selectionEnd = selectionStart;
            selectionStart = selectionEnd;
        }
        Log.i(TAG, "deleteSurroundingText() a : " + selectionStart + ", b : " + selectionEnd);
        if (beforeLength + afterLength > 0) {
            if (selectionStart == 0 && beforeLength > afterLength) {
                Log.i(TAG, "deleteSurroundingText() call sendKeyEvent(KeyEvent.KEYCODE_DEL)!!");
                sendKeyEvent(67);
                return true;
            }
            beginDelete();
        }
        int composingSpanStart = BaseInputConnection.getComposingSpanStart(editable);
        int composingSpanEnd = BaseInputConnection.getComposingSpanEnd(editable);
        if (composingSpanEnd < composingSpanStart) {
            composingSpanEnd = composingSpanStart;
            composingSpanStart = composingSpanEnd;
        }
        if (composingSpanStart != -1 && composingSpanEnd != -1) {
            if (composingSpanStart < selectionStart) {
                selectionStart = composingSpanStart;
            }
            if (composingSpanEnd > selectionEnd) {
                selectionEnd = composingSpanEnd;
            }
        }
        if (beforeLength > 0) {
            int i = selectionStart - beforeLength;
            i = i >= 0 ? i : 0;
            int i2 = selectionStart - i;
            this.deletedSurroundingTextLength = i2;
            TextComposingListener textComposingListener = this.mListener;
            if (textComposingListener != null && textComposingListener.onDeleteSurroundingText(i, selectionStart, afterLength)) {
                Log.i(TAG, "deleteSurroundingText() call onComposingText!!");
                endDelete();
                return true;
            }
            printLog(TAG, AbstractC1038a.m1214o(i, selectionStart, "deleteSurroundingText() ", " ~ "));
            beginBatchEdit();
            editable.delete(i, selectionStart);
            endBatchEdit();
            i = i2;
        }
        if (afterLength > 0) {
            int i4 = selectionEnd - i;
            int length = afterLength + i4;
            if (length > editable.length()) {
                length = editable.length();
            }
            printLog(TAG, AbstractC1038a.m1214o(i4, length, "deleteSurroundingText() ", " ~ "));
            beginBatchEdit();
            editable.delete(i4, length);
            endBatchEdit();
        }
        endDelete();
        return true;
    }

    @Override // android.view.inputmethod.BaseInputConnection, android.view.inputmethod.InputConnection
    public boolean endBatchEdit() {
        synchronized (this) {
            int i = this.mBatchEditNesting;
            if (i <= 0) {
                Unit unit = Unit.INSTANCE;
                return false;
            }
            int i2 = i - 1;
            this.mBatchEditNesting = i2;
            Log.i(TAG, "endBatchEdit() mBatchEditNesting : " + i2);
            TextComposingListener textComposingListener = this.mListener;
            return textComposingListener != null ? textComposingListener.onEndBatchEdit() : true;
        }
    }

    public final void endDelete() {
        this.mIsDeletedText = false;
    }

    @Override // android.view.inputmethod.BaseInputConnection, android.view.inputmethod.InputConnection
    public boolean finishComposingText() {
        Log.i(TAG, "finishComposingText()");
        TextComposingListener textComposingListener = this.mListener;
        if (textComposingListener != null) {
            textComposingListener.onFinishComposingText();
        }
        return super.finishComposingText();
    }

    public final int getBatchEditNesting() {
        int i;
        synchronized (this) {
            i = this.mBatchEditNesting;
        }
        return i;
    }

    public final int getDeletedSurroundingTextLength() {
        return this.deletedSurroundingTextLength;
    }

    @Override // android.view.inputmethod.BaseInputConnection
    @Nullable
    public Editable getEditable() {
        return this.mEditable;
    }

    @Override // android.view.inputmethod.BaseInputConnection, android.view.inputmethod.InputConnection
    @Nullable
    public ExtractedText getExtractedText(@Nullable ExtractedTextRequest request, int flags) {
        if (this.mTextView == null) {
            return null;
        }
        ExtractedText extractedText = new ExtractedText();
        extractedText.flags = 0;
        extractedText.partialStartOffset = -1;
        extractedText.partialEndOffset = -1;
        extractedText.startOffset = 0;
        extractedText.text = "";
        extractedText.selectionStart = 0;
        extractedText.selectionEnd = 0;
        Editable editable = getEditable();
        if (editable == null) {
            return null;
        }
        String string = editable.toString();
        if (string.length() > 0) {
            extractedText.text = string;
            extractedText.selectionStart = Selection.getSelectionStart(editable);
            extractedText.selectionEnd = Selection.getSelectionEnd(editable);
        }
        return extractedText;
    }

    @Nullable
    public final Function3<CharSequence, Integer, Integer, Boolean> getMPreCommitCheckFunction() {
        return this.mPreCommitCheckFunction;
    }

    @NotNull
    public final Regex getMPreCommitRegex() {
        return this.mPreCommitRegex;
    }

    public final int getSurroundingTextLength() {
        return this.surroundingTextLength;
    }

    public final void initialize() {
        Log.i(TAG, "initialize()");
        this.mIsCommitText = false;
        this.mIsDeletedText = false;
        this.mIsComposingText = false;
        this.surroundingTextLength = 0;
        this.deletedSurroundingTextLength = 0;
    }

    public final boolean isTextChanged() {
        return this.mIsCommitText | this.mIsComposingText | this.mIsDeletedText;
    }

    @Override // android.view.inputmethod.BaseInputConnection, android.view.inputmethod.InputConnection
    public boolean performContextMenuAction(int id) {
        TextComposingListener textComposingListener = this.mListener;
        if (textComposingListener != null) {
            textComposingListener.onPerformContextMenuAction(id);
        }
        return super.performContextMenuAction(id);
    }

    @Override // android.view.inputmethod.BaseInputConnection, android.view.inputmethod.InputConnection
    public boolean performPrivateCommand(@Nullable String action, @Nullable Bundle data) {
        TextComposingListener textComposingListener = this.mListener;
        return textComposingListener != null ? textComposingListener.onPrivateIMECommand(action, data) : super.performPrivateCommand(action, data);
    }

    public final void requestDisallowInputText(boolean disallowInput) {
        if (!disallowInput && this.mDisallowInputText) {
            finishComposingText();
        }
        this.mDisallowInputText = disallowInput;
    }

    @Override // android.view.inputmethod.BaseInputConnection, android.view.inputmethod.InputConnection
    public boolean setComposingText(@Nullable CharSequence text, int newCursorPosition) {
        TextComposingListener textComposingListener;
        printLog(TAG, "setComposingText() : " + ((Object) text) + ", newCursorPosition : " + newCursorPosition);
        if (this.mDisallowInputText) {
            return false;
        }
        beginComposing();
        super.setComposingText(text, newCursorPosition);
        Editable editable = this.mEditable;
        if (editable != null && (textComposingListener = this.mListener) != null) {
            textComposingListener.onComposingText(text, Selection.getSelectionStart(editable));
        }
        endComposing();
        return true;
    }

    public final void setDeletedSurroundingTextLength(int i) {
        this.deletedSurroundingTextLength = i;
    }

    public final void setEditable(@Nullable Editable editable) {
        if (editable != null) {
            this.mEditable = editable;
        }
    }

    public final void setKeyListener(@Nullable KeyListener listener) {
        if (listener != null) {
            this.mKeyListener = listener;
        }
    }

    public final void setMPreCommitCheckFunction(@Nullable Function3<? super CharSequence, ? super Integer, ? super Integer, Boolean> function3) {
        this.mPreCommitCheckFunction = function3;
    }

    public final void setMPreCommitRegex(@NotNull Regex regex) {
        Intrinsics.checkNotNullParameter(regex, "<set-?>");
        this.mPreCommitRegex = regex;
    }

    @Override // android.view.inputmethod.BaseInputConnection, android.view.inputmethod.InputConnection
    public boolean setSelection(int start, int end) {
        AbstractC6670b.m4744e(start, end, "setSelection() start : ", ", end : ", TAG);
        boolean selection = super.setSelection(start, end);
        TextComposingListener textComposingListener = this.mListener;
        if (textComposingListener != null) {
            textComposingListener.onSetSelection(start, end);
        }
        return selection;
    }

    public final void setSurroundingTextLength(int i) {
        this.surroundingTextLength = i;
    }
}
