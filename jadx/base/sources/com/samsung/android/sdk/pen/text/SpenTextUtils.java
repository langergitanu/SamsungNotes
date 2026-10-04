package com.samsung.android.sdk.pen.text;

import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.RectF;
import android.text.Editable;
import android.text.Selection;
import android.text.method.TextKeyListener;
import android.util.Log;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.inputmethod.BaseInputConnection;
import android.view.inputmethod.CursorAnchorInfo;
import android.view.inputmethod.InputMethodManager;
import androidx.appcompat.widget.AbstractC0541b;
import androidx.collection.AbstractC0622a;
import com.samsung.android.app.notes.sync.coedit.sharecore.strategy.AbstractC6670b;
import com.samsung.android.sdk.pen.document.SpenObjectShape;
import com.samsung.android.sdk.pen.document.textspan.SpenBulletParagraph;
import com.samsung.android.sdk.pen.document.textspan.SpenIndentLevelParagraph;
import com.samsung.android.sdk.pen.document.textspan.SpenPredefinedStyleParagraph;
import com.samsung.android.sdk.pen.document.textspan.SpenTextParagraphBase;
import com.samsung.android.sdk.pen.text.inputmethod.SpenInputConnection;
import com.samsung.android.sdk.pen.worddoc.SpenWNote;
import com.samsung.android.spen.libwrapper.ViewWrapper;
import com.samsung.android.spen.libwrapper.utils.PlatformException;
import com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.vector.shape.pathdata.VPathDataCmd;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m13885d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\"\u0010\t\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u000eH\u0007J\"\u0010\t\u001a\u00020\u00072\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u0007H\u0007J\u001a\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0015\u001a\u00020\u0007H\u0007J\u001a\u0010\u0016\u001a\u0004\u0018\u00010\u00172\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0015\u001a\u00020\u0007H\u0007J\u001a\u0010\u0018\u001a\u0004\u0018\u00010\u00192\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0015\u001a\u00020\u0007H\u0007J4\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\u0006\u0010 \u001a\u00020\u00072\u0006\u0010!\u001a\u00020\u00072\u0006\u0010\"\u001a\u00020\u0007H\u0007J&\u0010#\u001a\u00020\u001b2\b\u0010$\u001a\u0004\u0018\u00010\u001d2\b\u0010%\u001a\u0004\u0018\u00010&2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0007J2\u0010'\u001a\u00020\u001b2\u0006\u0010$\u001a\u00020\u001d2\u0006\u0010%\u001a\u00020&2\b\u0010(\u001a\u0004\u0018\u00010\u001f2\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020,H\u0007J\u0012\u0010-\u001a\u00020.2\b\u0010/\u001a\u0004\u0018\u00010\u0005H\u0007J\u001a\u00100\u001a\u00020\u001b2\u0006\u0010\u000f\u001a\u00020\u00102\b\u00101\u001a\u0004\u0018\u00010\u0005H\u0007J$\u00102\u001a\u00020\u001b2\u0006\u0010\u000f\u001a\u00020\u00102\b\u00103\u001a\u0004\u0018\u00010\u00052\b\u00104\u001a\u0004\u0018\u00010\u0005H\u0007J\u0018\u00105\u001a\u00020\u001b2\u0006\u0010$\u001a\u00020\u001d2\u0006\u00106\u001a\u00020\u0007H\u0007J\u001a\u00107\u001a\u00020\u000e2\b\u00108\u001a\u0004\u0018\u00010\u001f2\u0006\u00109\u001a\u00020\u0007H\u0007J\u0010\u0010:\u001a\u00020\u000e2\u0006\u0010;\u001a\u00020<H\u0007J\u001a\u0010=\u001a\u00020\u001b2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0006\u0010>\u001a\u00020\u0007H\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000¨\u0006?"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/text/SpenTextUtils;", "", "<init>", "()V", SearchConstants.TargetContents.TAG, "", "LF_CHAR", "", "CR_CHAR", "getEnterCount", "objectShape", "Lcom/samsung/android/sdk/pen/document/SpenObjectShape;", "pos", "checkBefore", "", "editable", "Landroid/text/Editable;", "start", "end", "getBulletParagraph", "Lcom/samsung/android/sdk/pen/document/textspan/SpenBulletParagraph;", "paraIdx", "getIndentLevelParagraph", "Lcom/samsung/android/sdk/pen/document/textspan/SpenIndentLevelParagraph;", "getPredefinedStyleParagraph", "Lcom/samsung/android/sdk/pen/document/textspan/SpenPredefinedStyleParagraph;", "sendAccessibilityEventTypeViewTextChanged", "", VPathDataCmd.RCurveTo, "Landroid/view/View;", "beforeText", "", "fromIndex", "removedCount", "addedCount", "updateSelection", "view", "inputConnection", "Lcom/samsung/android/sdk/pen/text/inputmethod/SpenInputConnection;", "updateCursorAnchorInfo", "composingText", "viewPosition", "Landroid/graphics/PointF;", "cursorAnchorRect", "Landroid/graphics/RectF;", "getKeyListener", "Landroid/text/method/TextKeyListener;", "str", "updateEditable", "newStr", "initEditable", "strBefore", "strAfter", "performHapticFeedback", "pattern", "isEnter", "text", "index", "isUndoRedoIncompletely", "wNote", "Lcom/samsung/android/sdk/pen/worddoc/SpenWNote;", "insertLineFeed", "count", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final class SpenTextUtils {
    public static final int CR_CHAR = 13;

    @NotNull
    public static final SpenTextUtils INSTANCE = new SpenTextUtils();
    public static final int LF_CHAR = 10;

    @NotNull
    private static final String TAG = "SpenTextUtils";

    private SpenTextUtils() {
    }

    @JvmStatic
    @Nullable
    public static final SpenBulletParagraph getBulletParagraph(@NotNull SpenObjectShape objectShape, int paraIdx) {
        Intrinsics.checkNotNullParameter(objectShape, "objectShape");
        ArrayList<SpenTextParagraphBase> arrayListFindTextParagraph = objectShape.findTextParagraph(paraIdx, paraIdx + 1, 32);
        if (arrayListFindTextParagraph != null && !arrayListFindTextParagraph.isEmpty()) {
            SpenTextParagraphBase spenTextParagraphBase = arrayListFindTextParagraph.get(0);
            SpenBulletParagraph spenBulletParagraph = spenTextParagraphBase instanceof SpenBulletParagraph ? (SpenBulletParagraph) spenTextParagraphBase : null;
            if (spenBulletParagraph != null && (!spenBulletParagraph.getBulletTypeList().isEmpty() || spenBulletParagraph.getBulletType() != 0)) {
                return spenBulletParagraph;
            }
        }
        return null;
    }

    @JvmStatic
    public static final int getEnterCount(@Nullable SpenObjectShape objectShape, int pos, boolean checkBefore) {
        String text;
        if (objectShape != null && (text = objectShape.getText()) != null) {
            int length = text.length();
            if (checkBefore) {
                if (pos >= length) {
                    AbstractC0541b.m755A(pos, "getEnterCount() invalid pos : ", TAG);
                    pos = length;
                }
                int i = 0;
                for (int i2 = 0; i2 < pos; i2++) {
                    char cCharAt = text.charAt(i2);
                    if (cCharAt == '\n' || cCharAt == '\r') {
                        i++;
                    }
                }
                return i;
            }
            while (pos < length) {
                char cCharAt2 = text.charAt(pos);
                if (cCharAt2 == '\n' || cCharAt2 == '\r') {
                    return 1;
                }
                pos++;
            }
        }
        return 0;
    }

    @JvmStatic
    @Nullable
    public static final SpenIndentLevelParagraph getIndentLevelParagraph(@NotNull SpenObjectShape objectShape, int paraIdx) {
        Intrinsics.checkNotNullParameter(objectShape, "objectShape");
        ArrayList<SpenTextParagraphBase> arrayListFindTextParagraph = objectShape.findTextParagraph(paraIdx, paraIdx + 1, 4);
        if (arrayListFindTextParagraph != null && !arrayListFindTextParagraph.isEmpty()) {
            SpenTextParagraphBase spenTextParagraphBase = arrayListFindTextParagraph.get(0);
            SpenIndentLevelParagraph spenIndentLevelParagraph = spenTextParagraphBase instanceof SpenIndentLevelParagraph ? (SpenIndentLevelParagraph) spenTextParagraphBase : null;
            if (spenIndentLevelParagraph != null && spenIndentLevelParagraph.getIndentLevel() > 0) {
                return spenIndentLevelParagraph;
            }
        }
        return null;
    }

    @JvmStatic
    @NotNull
    public static final TextKeyListener getKeyListener(@Nullable String str) {
        if (str == null || str.length() == 0) {
            TextKeyListener textKeyListener = TextKeyListener.getInstance(false, TextKeyListener.Capitalize.SENTENCES);
            Intrinsics.checkNotNull(textKeyListener);
            return textKeyListener;
        }
        TextKeyListener textKeyListener2 = AbstractC0000a.m4a(1, str) != '\n' ? TextKeyListener.getInstance(false, TextKeyListener.Capitalize.NONE) : TextKeyListener.getInstance(false, TextKeyListener.Capitalize.SENTENCES);
        Intrinsics.checkNotNull(textKeyListener2);
        return textKeyListener2;
    }

    @JvmStatic
    @Nullable
    public static final SpenPredefinedStyleParagraph getPredefinedStyleParagraph(@NotNull SpenObjectShape objectShape, int paraIdx) {
        Intrinsics.checkNotNullParameter(objectShape, "objectShape");
        ArrayList<SpenTextParagraphBase> arrayListFindTextParagraph = objectShape.findTextParagraph(paraIdx, paraIdx + 1, 1024);
        if (arrayListFindTextParagraph != null && !arrayListFindTextParagraph.isEmpty()) {
            SpenTextParagraphBase spenTextParagraphBase = arrayListFindTextParagraph.get(0);
            SpenPredefinedStyleParagraph spenPredefinedStyleParagraph = spenTextParagraphBase instanceof SpenPredefinedStyleParagraph ? (SpenPredefinedStyleParagraph) spenTextParagraphBase : null;
            if (spenPredefinedStyleParagraph != null && spenPredefinedStyleParagraph.getStart() == paraIdx) {
                return spenPredefinedStyleParagraph;
            }
        }
        return null;
    }

    @JvmStatic
    public static final void initEditable(@NotNull Editable editable, @Nullable String strBefore, @Nullable String strAfter) {
        Intrinsics.checkNotNullParameter(editable, "editable");
        String strConcat = (strBefore == null || strBefore.length() <= 0) ? "" : strBefore;
        if (strAfter != null && strAfter.length() > 0) {
            strConcat = strConcat.concat(strAfter);
        }
        if (strConcat.length() <= 0) {
            editable.clear();
            Selection.setSelection(editable, 0);
            return;
        }
        AbstractC6670b.m4744e(editable.length(), strConcat.length(), "initEditable replace : ", " , ", TAG);
        editable.replace(0, editable.length(), strConcat);
        if (strBefore == null || editable.length() < strBefore.length()) {
            return;
        }
        Selection.setSelection(editable, strBefore.length());
    }

    @JvmStatic
    public static final void insertLineFeed(@Nullable Editable editable, int count) {
        if (editable == null || count <= 0) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        while (count > 0) {
            sb.append("\n");
            count--;
        }
        editable.append((CharSequence) sb);
    }

    @JvmStatic
    public static final boolean isEnter(@Nullable CharSequence text, int index) {
        if (text == null || index < 0 || index >= text.length()) {
            return false;
        }
        return text.charAt(index) == '\n' || text.charAt(index) == '\r';
    }

    @JvmStatic
    public static final boolean isUndoRedoIncompletely(@NotNull SpenWNote wNote) {
        Intrinsics.checkNotNullParameter(wNote, "wNote");
        return wNote.getUndoStatus() == 3 || wNote.getRedoStatus() == 7;
    }

    @JvmStatic
    public static final void performHapticFeedback(@NotNull View view, int pattern) {
        Intrinsics.checkNotNullParameter(view, "view");
        try {
            ViewWrapper.create(view.getContext(), view).performHapticFeedback(pattern);
        } catch (PlatformException unused) {
        }
    }

    @JvmStatic
    public static final void sendAccessibilityEventTypeViewTextChanged(@Nullable View v, @Nullable CharSequence beforeText, int fromIndex, int removedCount, int addedCount) {
        AccessibilityEvent accessibilityEventObtain = AccessibilityEvent.obtain(16);
        accessibilityEventObtain.setFromIndex(fromIndex);
        accessibilityEventObtain.setRemovedCount(removedCount);
        accessibilityEventObtain.setAddedCount(addedCount);
        accessibilityEventObtain.setBeforeText(beforeText);
        Intrinsics.checkNotNull(v);
        v.sendAccessibilityEventUnchecked(accessibilityEventObtain);
    }

    @JvmStatic
    public static final void updateCursorAnchorInfo(@NotNull View view, @NotNull SpenInputConnection inputConnection, @Nullable CharSequence composingText, @NotNull PointF viewPosition, @NotNull RectF cursorAnchorRect) {
        int composingSpanStart;
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(inputConnection, "inputConnection");
        Intrinsics.checkNotNullParameter(viewPosition, "viewPosition");
        Intrinsics.checkNotNullParameter(cursorAnchorRect, "cursorAnchorRect");
        Editable editable = inputConnection.getMEditable();
        if (editable != null) {
            CursorAnchorInfo.Builder builder = new CursorAnchorInfo.Builder();
            builder.setInsertionMarkerLocation(cursorAnchorRect.left, cursorAnchorRect.top, 0.0f, cursorAnchorRect.bottom, 0);
            builder.setSelectionRange(Selection.getSelectionStart(editable), Selection.getSelectionEnd(editable));
            if (composingText != null && (composingSpanStart = BaseInputConnection.getComposingSpanStart(editable)) >= 0) {
                builder.setComposingText(composingSpanStart, composingText);
            }
            float[] fArr = new float[9];
            fArr[2] = viewPosition.x;
            fArr[5] = viewPosition.y;
            Matrix matrix = new Matrix();
            matrix.setValues(fArr);
            builder.setMatrix(matrix);
            CursorAnchorInfo cursorAnchorInfoBuild = builder.build();
            Log.i(TAG, "updateCursorAnchorInfo view - " + fArr[2] + " / " + fArr[5]);
            Log.i(TAG, "updateCursorAnchorInfo cursor - " + cursorAnchorInfoBuild.getInsertionMarkerHorizontal() + " / " + cursorAnchorInfoBuild.getInsertionMarkerTop());
            Object systemService = view.getContext().getSystemService("input_method");
            Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
            ((InputMethodManager) systemService).updateCursorAnchorInfo(view, cursorAnchorInfoBuild);
        }
    }

    @JvmStatic
    public static final void updateEditable(@NotNull Editable editable, @Nullable String newStr) {
        Intrinsics.checkNotNullParameter(editable, "editable");
        editable.replace(0, editable.length(), newStr);
    }

    @JvmStatic
    public static final void updateSelection(@Nullable View view, @Nullable SpenInputConnection inputConnection, @Nullable Editable editable) {
        int composingSpanStart;
        int composingSpanEnd;
        Log.i(TAG, "updateSelection()");
        if (view == null || inputConnection == null || editable == null) {
            return;
        }
        Object systemService = view.getContext().getSystemService("input_method");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
        InputMethodManager inputMethodManager = (InputMethodManager) systemService;
        if (!inputMethodManager.isActive(view) || inputConnection.getBatchEditNesting() > 0) {
            return;
        }
        int selectionStart = Selection.getSelectionStart(editable);
        int selectionEnd = Selection.getSelectionEnd(editable);
        if (editable.length() > 0) {
            composingSpanStart = BaseInputConnection.getComposingSpanStart(editable);
            composingSpanEnd = BaseInputConnection.getComposingSpanEnd(editable);
        } else {
            composingSpanStart = -1;
            composingSpanEnd = -1;
        }
        StringBuilder sbM1173s = AbstractC0622a.m1173s(selectionStart, selectionEnd, "updateSelection() selStart : ", ", selEnd : ", ", candStart : ");
        sbM1173s.append(composingSpanStart);
        sbM1173s.append(", candEnd : ");
        sbM1173s.append(composingSpanEnd);
        Log.d(TAG, sbM1173s.toString());
        inputMethodManager.updateSelection(view, selectionStart, selectionEnd, composingSpanStart, composingSpanEnd);
    }

    @JvmStatic
    public static final int getEnterCount(@Nullable Editable editable, int start, int end) {
        int i = 0;
        if (editable != null && start >= 0 && end >= 0 && start != end) {
            int iMin = Integer.min(editable.length(), end);
            while (start < iMin) {
                char cCharAt = editable.charAt(start);
                if (cCharAt == '\n' || cCharAt == '\r') {
                    i++;
                }
                start++;
            }
        }
        return i;
    }
}
