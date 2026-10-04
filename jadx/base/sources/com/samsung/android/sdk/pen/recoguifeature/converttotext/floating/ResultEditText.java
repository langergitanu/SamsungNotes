package com.samsung.android.sdk.pen.recoguifeature.converttotext.floating;

import android.content.Context;
import android.text.Editable;
import android.text.Layout;
import android.text.Spannable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.util.Log;
import android.view.DragEvent;
import android.view.KeyEvent;
import androidx.appcompat.widget.AppCompatEditText;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.samsung.android.sdk.pen.recoguifeature.converttotext.floating.ResultEditText;
import com.samsung.android.support.senl.p148nt.base.common.constants.Constants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 #2\u00020\u0001:\u0002\"#B\u0013\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u001d\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0004\u0010\bJ\u0010\u0010\u0018\u001a\u00020\u00132\u0006\u0010\u0019\u001a\u00020\u001aH\u0016J\b\u0010\u001b\u001a\u00020\u001cH\u0014J\b\u0010\u001d\u001a\u00020\u001cH\u0014J\u0010\u0010\u001e\u001a\u00020\u00132\u0006\u0010\u0019\u001a\u00020\u001fH\u0016J\u0010\u0010 \u001a\u00020\u001c2\b\u0010!\u001a\u0004\u0018\u00010\u0015R\u001a\u0010\t\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006$"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/recoguifeature/converttotext/floating/ResultEditText;", "Landroidx/appcompat/widget/AppCompatEditText;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attr", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "cursorIndex", "", "getCursorIndex", "()I", "setCursorIndex", "(I)V", "mBeforeText", "Landroid/text/Spannable;", "mBeforeCursorIndex", "mIsBlock", "", "mTextChangedListener", "Lcom/samsung/android/sdk/pen/recoguifeature/converttotext/floating/ResultEditText$TextChangedListener;", "textWatcher", "Landroid/text/TextWatcher;", "onDragEvent", "event", "Landroid/view/DragEvent;", "onAttachedToWindow", "", "onDetachedFromWindow", "dispatchKeyEventPreIme", "Landroid/view/KeyEvent;", "setTextChangedListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "TextChangedListener", "Companion", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final class ResultEditText extends AppCompatEditText {

    @NotNull
    private static final String TAG = "ResultEditText";
    private int cursorIndex;
    private int mBeforeCursorIndex;

    @Nullable
    private Spannable mBeforeText;
    private boolean mIsBlock;

    @Nullable
    private TextChangedListener mTextChangedListener;

    @NotNull
    private final TextWatcher textWatcher;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH&¨\u0006\t"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/recoguifeature/converttotext/floating/ResultEditText$TextChangedListener;", "", "onChanged", "", "textLength", "", "onOverflow", "isLine", "", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public interface TextChangedListener {
        void onChanged(int textLength);

        void onOverflow(boolean isLine);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ResultEditText(@Nullable Context context) {
        super(context);
        Intrinsics.checkNotNull(context);
        this.textWatcher = new TextWatcher() { // from class: com.samsung.android.sdk.pen.recoguifeature.converttotext.floating.ResultEditText$textWatcher$1
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable s) {
                Intrinsics.checkNotNullParameter(s, "s");
                Layout layout = this.this$0.getLayout();
                if (layout == null) {
                    return;
                }
                int length = s.length();
                ResultEditText.TextChangedListener textChangedListener = this.this$0.mTextChangedListener;
                if (textChangedListener != null) {
                    textChangedListener.onChanged(length);
                }
                int i = 0;
                for (int i2 = 0; i2 < length; i2++) {
                    if (s.charAt(i2) == '\n') {
                        i++;
                    }
                }
                if (i > 50) {
                    this.this$0.mIsBlock = true;
                    Log.d("ResultEditText", "ResultEditText.afterTextChanged Overflow (BEFORE lineCount : " + layout.getLineCount() + ")");
                    int i4 = this.this$0.mBeforeCursorIndex;
                    ResultEditText resultEditText = this.this$0;
                    resultEditText.setText(resultEditText.mBeforeText != null ? this.this$0.mBeforeText : "");
                    this.this$0.setSelection(i4);
                    Log.d("ResultEditText", "ResultEditText.afterTextChanged Overflow (AFTER lineCount : " + layout.getLineCount() + ")");
                    ResultEditText.TextChangedListener textChangedListener2 = this.this$0.mTextChangedListener;
                    if (textChangedListener2 != null) {
                        textChangedListener2.onOverflow(true);
                    }
                } else if (length > 3000) {
                    this.this$0.mIsBlock = true;
                    Log.d("ResultEditText", "ResultEditText.afterTextChanged Overflow (BEFORE length : " + length + ")");
                    int cursorIndex = this.this$0.getCursorIndex();
                    CharSequence charSequenceSubSequence = s.subSequence(0, 3000);
                    Intrinsics.checkNotNull(charSequenceSubSequence, "null cannot be cast to non-null type android.text.Spannable");
                    Spannable spannable = (Spannable) charSequenceSubSequence;
                    this.this$0.setText(spannable);
                    this.this$0.setSelection(cursorIndex <= 3000 ? cursorIndex : 3000);
                    Log.d("ResultEditText", "FloatingTextResult.afterTextChanged Overflow (AFTER length : " + spannable.length() + ")");
                    ResultEditText.TextChangedListener textChangedListener3 = this.this$0.mTextChangedListener;
                    if (textChangedListener3 != null) {
                        textChangedListener3.onOverflow(false);
                    }
                }
                this.this$0.mIsBlock = false;
                ResultEditText resultEditText2 = this.this$0;
                resultEditText2.setCursorIndex(resultEditText2.getSelectionStart());
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                Intrinsics.checkNotNullParameter(s, "s");
                if (s instanceof Spannable) {
                    ResultEditText resultEditText = this.this$0;
                    CharSequence charSequenceSubSequence = s.subSequence(0, s.length());
                    Intrinsics.checkNotNull(charSequenceSubSequence, "null cannot be cast to non-null type android.text.Spannable");
                    resultEditText.mBeforeText = (Spannable) charSequenceSubSequence;
                }
                this.this$0.mBeforeCursorIndex = start;
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                Intrinsics.checkNotNullParameter(s, "s");
                this.this$0.setCursorIndex(start + count);
            }
        };
    }

    @Override // android.view.View
    public boolean dispatchKeyEventPreIme(@NotNull KeyEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        if (!this.mIsBlock) {
            return super.dispatchKeyEventPreIme(event);
        }
        Log.i(TAG, "ResultEditText::dispatchKeyEventPreIme blocked!");
        return true;
    }

    public final int getCursorIndex() {
        return this.cursorIndex;
    }

    @Override // android.widget.TextView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        addTextChangedListener(this.textWatcher);
    }

    @Override // androidx.appcompat.widget.AppCompatEditText, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Log.i(TAG, "ResultEditText::onDetachedFromWindow");
        removeTextChangedListener(this.textWatcher);
    }

    @Override // androidx.appcompat.widget.AppCompatEditText, android.widget.TextView, android.view.View
    public boolean onDragEvent(@NotNull DragEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        return event.getAction() == 1 ? event.getClipDescription().hasMimeType("text/plain") || event.getClipDescription().hasMimeType("text/vnd.android.intent") || event.getClipDescription().hasMimeType(Constants.MIME_HTML) || event.getClipDescription().hasMimeType("text/uri-list") : super.onDragEvent(event);
    }

    public final void setCursorIndex(int i) {
        this.cursorIndex = i;
    }

    public final void setTextChangedListener(@Nullable TextChangedListener listener) {
        this.mTextChangedListener = listener;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ResultEditText(@Nullable Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNull(context);
        this.textWatcher = new TextWatcher() { // from class: com.samsung.android.sdk.pen.recoguifeature.converttotext.floating.ResultEditText$textWatcher$1
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable s) {
                Intrinsics.checkNotNullParameter(s, "s");
                Layout layout = this.this$0.getLayout();
                if (layout == null) {
                    return;
                }
                int length = s.length();
                ResultEditText.TextChangedListener textChangedListener = this.this$0.mTextChangedListener;
                if (textChangedListener != null) {
                    textChangedListener.onChanged(length);
                }
                int i = 0;
                for (int i2 = 0; i2 < length; i2++) {
                    if (s.charAt(i2) == '\n') {
                        i++;
                    }
                }
                if (i > 50) {
                    this.this$0.mIsBlock = true;
                    Log.d("ResultEditText", "ResultEditText.afterTextChanged Overflow (BEFORE lineCount : " + layout.getLineCount() + ")");
                    int i4 = this.this$0.mBeforeCursorIndex;
                    ResultEditText resultEditText = this.this$0;
                    resultEditText.setText(resultEditText.mBeforeText != null ? this.this$0.mBeforeText : "");
                    this.this$0.setSelection(i4);
                    Log.d("ResultEditText", "ResultEditText.afterTextChanged Overflow (AFTER lineCount : " + layout.getLineCount() + ")");
                    ResultEditText.TextChangedListener textChangedListener2 = this.this$0.mTextChangedListener;
                    if (textChangedListener2 != null) {
                        textChangedListener2.onOverflow(true);
                    }
                } else if (length > 3000) {
                    this.this$0.mIsBlock = true;
                    Log.d("ResultEditText", "ResultEditText.afterTextChanged Overflow (BEFORE length : " + length + ")");
                    int cursorIndex = this.this$0.getCursorIndex();
                    CharSequence charSequenceSubSequence = s.subSequence(0, 3000);
                    Intrinsics.checkNotNull(charSequenceSubSequence, "null cannot be cast to non-null type android.text.Spannable");
                    Spannable spannable = (Spannable) charSequenceSubSequence;
                    this.this$0.setText(spannable);
                    this.this$0.setSelection(cursorIndex <= 3000 ? cursorIndex : 3000);
                    Log.d("ResultEditText", "FloatingTextResult.afterTextChanged Overflow (AFTER length : " + spannable.length() + ")");
                    ResultEditText.TextChangedListener textChangedListener3 = this.this$0.mTextChangedListener;
                    if (textChangedListener3 != null) {
                        textChangedListener3.onOverflow(false);
                    }
                }
                this.this$0.mIsBlock = false;
                ResultEditText resultEditText2 = this.this$0;
                resultEditText2.setCursorIndex(resultEditText2.getSelectionStart());
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                Intrinsics.checkNotNullParameter(s, "s");
                if (s instanceof Spannable) {
                    ResultEditText resultEditText = this.this$0;
                    CharSequence charSequenceSubSequence = s.subSequence(0, s.length());
                    Intrinsics.checkNotNull(charSequenceSubSequence, "null cannot be cast to non-null type android.text.Spannable");
                    resultEditText.mBeforeText = (Spannable) charSequenceSubSequence;
                }
                this.this$0.mBeforeCursorIndex = start;
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                Intrinsics.checkNotNullParameter(s, "s");
                this.this$0.setCursorIndex(start + count);
            }
        };
    }
}
