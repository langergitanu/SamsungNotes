package com.samsung.android.sdk.composer.document.sdoc;

import androidx.annotation.ColorInt;
import com.samsung.android.scs.p140ai.sdkcommon.text.TextConst;
import com.samsung.android.sdk.composer.document.sdoc.textspan.SpenTextSpan;
import com.samsung.android.sdk.pen.SpenError;
import com.samsung.android.sdk.pen.document.SpenAlreadyClosedException;
import java.util.ArrayList;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.apache.xmlbeans.XmlErrorCodes;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b/\u0018\u0000 g2\u00020\u0001:\u0001gB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J0\u00105\u001a\u001a\u0012\u0006\u0012\u0004\u0018\u00010\r\u0018\u00010\fj\f\u0012\u0006\u0012\u0004\u0018\u00010\r\u0018\u0001`\u000e2\u0006\u00106\u001a\u00020\u00052\u0006\u00107\u001a\u00020\u0005H\u0016J\u0012\u00108\u001a\u0002092\b\u0010\u000f\u001a\u0004\u0018\u00010\rH\u0016J\u0012\u0010:\u001a\u0002092\b\u0010\u000f\u001a\u0004\u0018\u00010\rH\u0016J\u0018\u0010;\u001a\u0002092\b\u0010\u0018\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u0014\u001a\u00020\u0005J\u0010\u0010<\u001a\u0002092\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019J\u0016\u0010=\u001a\u0002092\u0006\u00106\u001a\u00020\u00052\u0006\u0010>\u001a\u00020\u0005J \u0010?\u001a\u0002092\b\u0010\u0018\u001a\u0004\u0018\u00010\u00192\u0006\u00106\u001a\u00020\u00052\u0006\u0010>\u001a\u00020\u0005J\u0006\u0010@\u001a\u000209J\u0012\u0010A\u001a\u0002092\b\u0010B\u001a\u0004\u0018\u00010\u0001H\u0016J\b\u0010C\u001a\u000209H\u0007J\u000e\u0010D\u001a\u0002092\u0006\u0010E\u001a\u00020/J\u0010\u0010F\u001a\u0002092\u0006\u0010G\u001a\u00020\u0005H\u0002J\u0011\u0010H\u001a\u00020/2\u0006\u0010I\u001a\u00020\u0005H\u0082 J\u0019\u0010J\u001a\u00020/2\u0006\u0010I\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0005H\u0082 J\u0011\u0010K\u001a\u00020\u00052\u0006\u0010I\u001a\u00020\u0005H\u0082 J-\u0010L\u001a\u00020/2\u0006\u0010I\u001a\u00020\u00052\u001a\u0010\u000b\u001a\u0016\u0012\u0004\u0012\u00020\r\u0018\u00010\fj\n\u0012\u0004\u0012\u00020\r\u0018\u0001`\u000eH\u0082 J!\u0010M\u001a\u0012\u0012\u0004\u0012\u00020\r0\fj\b\u0012\u0004\u0012\u00020\r`\u000e2\u0006\u0010I\u001a\u00020\u0005H\u0082 J9\u0010N\u001a\u001a\u0012\u0006\u0012\u0004\u0018\u00010\r\u0018\u00010\fj\f\u0012\u0006\u0012\u0004\u0018\u00010\r\u0018\u0001`\u000e2\u0006\u0010I\u001a\u00020\u00052\u0006\u00106\u001a\u00020\u00052\u0006\u00107\u001a\u00020\u0005H\u0082 J\u001b\u0010O\u001a\u00020/2\u0006\u0010I\u001a\u00020\u00052\b\u0010\u000f\u001a\u0004\u0018\u00010\rH\u0082 J\u001b\u0010P\u001a\u00020/2\u0006\u0010I\u001a\u00020\u00052\b\u0010\u000f\u001a\u0004\u0018\u00010\rH\u0082 J#\u0010Q\u001a\u00020/2\u0006\u0010I\u001a\u00020\u00052\b\u0010\u0018\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u0014\u001a\u00020\u0005H\u0082 J\u001b\u0010R\u001a\u00020/2\u0006\u0010I\u001a\u00020\u00052\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0082 J!\u0010S\u001a\u00020/2\u0006\u0010I\u001a\u00020\u00052\u0006\u00106\u001a\u00020\u00052\u0006\u0010>\u001a\u00020\u0005H\u0082 J+\u0010T\u001a\u00020/2\u0006\u0010I\u001a\u00020\u00052\b\u0010\u0018\u001a\u0004\u0018\u00010\u00192\u0006\u00106\u001a\u00020\u00052\u0006\u0010>\u001a\u00020\u0005H\u0082 J\u0011\u0010U\u001a\u00020/2\u0006\u0010I\u001a\u00020\u0005H\u0082 J\u0019\u0010V\u001a\u00020/2\u0006\u0010I\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u0005H\u0082 J\u0011\u0010W\u001a\u00020\u00052\u0006\u0010I\u001a\u00020\u0005H\u0082 J\u001b\u0010X\u001a\u00020/2\u0006\u0010I\u001a\u00020\u00052\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0082 J\u0011\u0010Y\u001a\u00020\u00192\u0006\u0010I\u001a\u00020\u0005H\u0082 J\u0019\u0010Z\u001a\u00020/2\u0006\u0010I\u001a\u00020\u00052\u0006\u0010\u001f\u001a\u00020\u0005H\u0082 J\u0011\u0010[\u001a\u00020\u00052\u0006\u0010I\u001a\u00020\u0005H\u0082 J\u0019\u0010\\\u001a\u00020/2\u0006\u0010I\u001a\u00020\u00052\u0006\u0010#\u001a\u00020\u0005H\u0082 J\u0011\u0010]\u001a\u00020\u00052\u0006\u0010I\u001a\u00020\u0005H\u0082 J\u0019\u0010^\u001a\u00020/2\u0006\u0010I\u001a\u00020\u00052\u0006\u0010'\u001a\u00020(H\u0082 J\u0011\u0010_\u001a\u00020(2\u0006\u0010I\u001a\u00020\u0005H\u0082 J\u0019\u0010`\u001a\u00020/2\u0006\u0010I\u001a\u00020\u00052\u0006\u0010.\u001a\u00020/H\u0082 J\u0011\u0010a\u001a\u00020/2\u0006\u0010I\u001a\u00020\u0005H\u0082 J#\u0010b\u001a\u00020/2\u0006\u0010I\u001a\u00020\u00052\u0006\u0010c\u001a\u00020\u00052\b\u0010B\u001a\u0004\u0018\u00010\u0001H\u0082 J\u0011\u0010d\u001a\u00020/2\u0006\u0010I\u001a\u00020\u0005H\u0082 J\u0011\u0010e\u001a\u0002092\u0006\u0010I\u001a\u00020\u0005H\u0082 J\u0019\u0010f\u001a\u0002092\u0006\u0010I\u001a\u00020\u00052\u0006\u0010E\u001a\u00020/H\u0082 R$\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u00058F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nRL\u0010\u000f\u001a\u0016\u0012\u0004\u0012\u00020\r\u0018\u00010\fj\n\u0012\u0004\u0012\u00020\r\u0018\u0001`\u000e2\u001a\u0010\u000b\u001a\u0016\u0012\u0004\u0012\u00020\r\u0018\u00010\fj\n\u0012\u0004\u0012\u00020\r\u0018\u0001`\u000e8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R$\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u00058F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0016\u0010\b\"\u0004\b\u0017\u0010\nR(\u0010\u001a\u001a\u0004\u0018\u00010\u00192\b\u0010\u0018\u001a\u0004\u0018\u00010\u00198F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR$\u0010 \u001a\u00020\u00052\u0006\u0010\u001f\u001a\u00020\u00058G@FX\u0086\u000e¢\u0006\f\u001a\u0004\b!\u0010\b\"\u0004\b\"\u0010\nR$\u0010$\u001a\u00020\u00052\u0006\u0010#\u001a\u00020\u00058F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b%\u0010\b\"\u0004\b&\u0010\nR$\u0010)\u001a\u00020(2\u0006\u0010'\u001a\u00020(8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R$\u00100\u001a\u00020/2\u0006\u0010.\u001a\u00020/8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b0\u00101\"\u0004\b2\u00103R\u0011\u00104\u001a\u00020/8F¢\u0006\u0006\u001a\u0004\b4\u00101¨\u0006h"}, m13886d2 = {"Lcom/samsung/android/sdk/composer/document/sdoc/SpenContentText;", "Lcom/samsung/android/sdk/composer/document/sdoc/SpenContentBase;", "<init>", "()V", TextConst.KEY_PARAM_NUMBER, "", "paragraphNumber", "getParagraphNumber", "()I", "setParagraphNumber", "(I)V", XmlErrorCodes.LIST, "Ljava/util/ArrayList;", "Lcom/samsung/android/sdk/composer/document/sdoc/textspan/SpenTextSpan;", "Lkotlin/collections/ArrayList;", "span", "getSpan", "()Ljava/util/ArrayList;", "setSpan", "(Ljava/util/ArrayList;)V", "position", "cursorPosition", "getCursorPosition", "setCursorPosition", "text", "", "hintText", "getHintText", "()Ljava/lang/String;", "setHintText", "(Ljava/lang/String;)V", "color", "hintTextColor", "getHintTextColor", "setHintTextColor", "style", "hintTextStyle", "getHintTextStyle", "setHintTextStyle", "size", "", "hintTextSize", "getHintTextSize", "()F", "setHintTextSize", "(F)V", "enable", "", "isHintTextEnabled", "()Z", "setHintTextEnabled", "(Z)V", "isParsedText", "findSpan", TextConst.KEY_START_INDEX, TextConst.KEY_END_INDEX, "removeSpan", "", "appendSpan", "insertText", "insertTextAtCursor", "removeText", "length", "replaceText", "removeAllText", "copy", "source", "doneParsingText", "setParsingState", "isParsed", "throwUncheckedException", "errno", "ContentText_init", "handle", "ContentText_setParagraphNumber", "ContentText_getParagraphNumber", "ContentText_setSpan", "ContentText_getSpan", "ContentText_findSpan", "ContentText_removeSpan", "ContentText_appendSpan", "ContentText_insertText", "ContentText_insertTextAtCursor", "ContentText_removeText", "ContentText_replaceText", "ContentText_removeAllText", "ContentText_setCursorPosition", "ContentText_getCursorPosition", "ContentText_setHintText", "ContentText_getHintText", "ContentText_setHintTextColor", "ContentText_getHintTextColor", "ContentText_setHintTextStyle", "ContentText_getHintTextStyle", "ContentText_setHintTextSize", "ContentText_getHintTextSize", "ContentText_setHintTextEnabled", "ContentText_isHintTextEnabled", "ContentText_copy", "sourceHandle", "ContentText_isParsedText", "ContentText_doneParsingText", "ContentText_setParsingState", "Companion", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final class SpenContentText extends SpenContentBase {
    public static final int STYLE_BOLD = 1;
    public static final int STYLE_ITALIC = 2;
    public static final int STYLE_NONE = 0;
    public static final int STYLE_UNDERLINE = 4;

    public SpenContentText() {
        super(1);
    }

    private final native boolean ContentText_appendSpan(int handle, SpenTextSpan span);

    private final native boolean ContentText_copy(int handle, int sourceHandle, SpenContentBase source);

    private final native void ContentText_doneParsingText(int handle);

    private final native ArrayList<SpenTextSpan> ContentText_findSpan(int handle, int startIndex, int endIndex);

    private final native int ContentText_getCursorPosition(int handle);

    private final native String ContentText_getHintText(int handle);

    private final native int ContentText_getHintTextColor(int handle);

    private final native float ContentText_getHintTextSize(int handle);

    private final native int ContentText_getHintTextStyle(int handle);

    private final native int ContentText_getParagraphNumber(int handle);

    private final native ArrayList<SpenTextSpan> ContentText_getSpan(int handle);

    private final native boolean ContentText_init(int handle);

    private final native boolean ContentText_insertText(int handle, String text, int position);

    private final native boolean ContentText_insertTextAtCursor(int handle, String text);

    private final native boolean ContentText_isHintTextEnabled(int handle);

    private final native boolean ContentText_isParsedText(int handle);

    private final native boolean ContentText_removeAllText(int handle);

    private final native boolean ContentText_removeSpan(int handle, SpenTextSpan span);

    private final native boolean ContentText_removeText(int handle, int startIndex, int length);

    private final native boolean ContentText_replaceText(int handle, String text, int startIndex, int length);

    private final native boolean ContentText_setCursorPosition(int handle, int position);

    private final native boolean ContentText_setHintText(int handle, String text);

    private final native boolean ContentText_setHintTextColor(int handle, int color);

    private final native boolean ContentText_setHintTextEnabled(int handle, boolean enable);

    private final native boolean ContentText_setHintTextSize(int handle, float size);

    private final native boolean ContentText_setHintTextStyle(int handle, int style);

    private final native boolean ContentText_setParagraphNumber(int handle, int number);

    private final native void ContentText_setParsingState(int handle, boolean isParsed);

    private final native boolean ContentText_setSpan(int handle, ArrayList<SpenTextSpan> list);

    private final void throwUncheckedException(int errno) {
        if (errno != 19) {
            SpenError.ThrowUncheckedException(errno);
            return;
        }
        throw new SpenAlreadyClosedException("SpenContentText(" + this + ") is already closed");
    }

    @Override // com.samsung.android.sdk.composer.document.sdoc.SpenContentBase
    public void appendSpan(@Nullable SpenTextSpan span) {
        if (ContentText_appendSpan(getMHandle(), span)) {
            return;
        }
        throwUncheckedException(SpenError.getError());
    }

    @Override // com.samsung.android.sdk.composer.document.sdoc.SpenContentBase
    public void copy(@Nullable SpenContentBase source) {
        if (source == null || source.getType() != 1) {
            SpenError.ThrowUncheckedException(7);
        }
        int mHandle = getMHandle();
        Intrinsics.checkNotNull(source);
        if (ContentText_copy(mHandle, source.getMHandle(), source)) {
            return;
        }
        throwUncheckedException(SpenError.getError());
    }

    @Deprecated(message = "")
    public final void doneParsingText() {
        ContentText_doneParsingText(getMHandle());
    }

    @Override // com.samsung.android.sdk.composer.document.sdoc.SpenContentBase
    @Nullable
    public ArrayList<SpenTextSpan> findSpan(int startIndex, int endIndex) {
        return ContentText_findSpan(getMHandle(), startIndex, endIndex);
    }

    public final int getCursorPosition() {
        return ContentText_getCursorPosition(getMHandle());
    }

    @Nullable
    public final String getHintText() {
        return ContentText_getHintText(getMHandle());
    }

    @ColorInt
    public final int getHintTextColor() {
        return ContentText_getHintTextColor(getMHandle());
    }

    public final float getHintTextSize() {
        return ContentText_getHintTextSize(getMHandle());
    }

    public final int getHintTextStyle() {
        return ContentText_getHintTextStyle(getMHandle());
    }

    public final int getParagraphNumber() {
        return ContentText_getParagraphNumber(getMHandle());
    }

    @Override // com.samsung.android.sdk.composer.document.sdoc.SpenContentBase
    @Nullable
    public ArrayList<SpenTextSpan> getSpan() {
        return ContentText_getSpan(getMHandle());
    }

    public final void insertText(@Nullable String text, int position) {
        if (ContentText_insertText(getMHandle(), text, position)) {
            return;
        }
        throwUncheckedException(SpenError.getError());
    }

    public final void insertTextAtCursor(@Nullable String text) {
        if (ContentText_insertTextAtCursor(getMHandle(), text)) {
            return;
        }
        throwUncheckedException(SpenError.getError());
    }

    public final boolean isHintTextEnabled() {
        return ContentText_isHintTextEnabled(getMHandle());
    }

    public final boolean isParsedText() {
        return ContentText_isParsedText(getMHandle());
    }

    public final void removeAllText() {
        if (ContentText_removeAllText(getMHandle())) {
            return;
        }
        throwUncheckedException(SpenError.getError());
    }

    @Override // com.samsung.android.sdk.composer.document.sdoc.SpenContentBase
    public void removeSpan(@Nullable SpenTextSpan span) {
        if (ContentText_removeSpan(getMHandle(), span)) {
            return;
        }
        throwUncheckedException(SpenError.getError());
    }

    public final void removeText(int startIndex, int length) {
        if (ContentText_removeText(getMHandle(), startIndex, length)) {
            return;
        }
        throwUncheckedException(SpenError.getError());
    }

    public final void replaceText(@Nullable String text, int startIndex, int length) {
        if (ContentText_replaceText(getMHandle(), text, startIndex, length)) {
            return;
        }
        throwUncheckedException(SpenError.getError());
    }

    public final void setCursorPosition(int i) {
        if (ContentText_setCursorPosition(getMHandle(), i)) {
            return;
        }
        throwUncheckedException(SpenError.getError());
    }

    public final void setHintText(@Nullable String str) {
        if (ContentText_setHintText(getMHandle(), str)) {
            return;
        }
        throwUncheckedException(SpenError.getError());
    }

    public final void setHintTextColor(int i) {
        if (ContentText_setHintTextColor(getMHandle(), i)) {
            return;
        }
        throwUncheckedException(SpenError.getError());
    }

    public final void setHintTextEnabled(boolean z) {
        if (ContentText_setHintTextEnabled(getMHandle(), z)) {
            return;
        }
        throwUncheckedException(SpenError.getError());
    }

    public final void setHintTextSize(float f) {
        if (ContentText_setHintTextSize(getMHandle(), f)) {
            return;
        }
        throwUncheckedException(SpenError.getError());
    }

    public final void setHintTextStyle(int i) {
        if (ContentText_setHintTextStyle(getMHandle(), i)) {
            return;
        }
        throwUncheckedException(SpenError.getError());
    }

    public final void setParagraphNumber(int i) {
        if (ContentText_setParagraphNumber(getMHandle(), i)) {
            return;
        }
        throwUncheckedException(SpenError.getError());
    }

    public final void setParsingState(boolean isParsed) {
        ContentText_setParsingState(getMHandle(), isParsed);
    }

    @Override // com.samsung.android.sdk.composer.document.sdoc.SpenContentBase
    public void setSpan(@Nullable ArrayList<SpenTextSpan> arrayList) {
        if (ContentText_setSpan(getMHandle(), arrayList)) {
            return;
        }
        throwUncheckedException(SpenError.getError());
    }
}
