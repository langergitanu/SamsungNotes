package com.samsung.android.sdk.composer.text;

import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.Pair;
import android.view.KeyEvent;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import com.samsung.android.sdk.pen.document.SpenObjectBase;
import com.samsung.android.sdk.pen.document.SpenObjectShape;
import com.samsung.android.sdk.pen.document.SpenObjectTable;
import com.samsung.android.sdk.pen.document.SpenObjectTextBox;
import com.samsung.android.sdk.pen.document.textspan.SpenObjectSpan;
import com.samsung.android.sdk.pen.widget.SpenITextManager;
import com.samsung.android.sdk.pen.worddoc.SpenWNote;
import com.samsung.android.sdk.pen.worddoc.SpenWPage;
import com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.vector.shape.elements.VElementFormulasCmd;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.util.Constants;
import com.samsung.android.support.senl.p148nt.data.common.constants.ExternalDataConstants;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Triple;
import kotlin.jvm.functions.Function3;
import kotlin.text.Regex;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u0000Ú\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010!\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u0000 \u008f\u00012\u00020\u0001:\u0002\u008f\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH&J\b\u0010\t\u001a\u00020\u0003H&J\u0010\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u0010H&J\b\u0010\u0011\u001a\u00020\u0003H&J\b\u0010\u0012\u001a\u00020\u0003H&J\b\u0010\u0013\u001a\u00020\u0003H&J \u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u001aH&J(\u0010\u0014\u001a\u00020\u00152\u0016\u0010\u001b\u001a\u0012\u0012\u0004\u0012\u00020\u00170\u001cj\b\u0012\u0004\u0012\u00020\u0017`\u001d2\u0006\u0010\u0018\u001a\u00020\u0017H&J\u0010\u0010\u001e\u001a\u00020\u00152\u0006\u0010\u001f\u001a\u00020\u0017H&J$\u0010\u001e\u001a\u00020\u00152\u001a\u0010 \u001a\u0016\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u001cj\n\u0012\u0004\u0012\u00020\u0017\u0018\u0001`\u001dH&J\u0012\u0010!\u001a\u0004\u0018\u00010\"2\u0006\u0010\u001f\u001a\u00020\u0017H&J0\u0010#\u001a\u00020\u00152\u0006\u0010\u001f\u001a\u00020\u00172\u0006\u0010$\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010%\u001a\u00020\"2\u0006\u0010&\u001a\u00020\u0017H&J8\u0010#\u001a\u00020\u00152\u0006\u0010\u001f\u001a\u00020\u00172\u0016\u0010'\u001a\u0012\u0012\u0004\u0012\u00020(0\u001cj\b\u0012\u0004\u0012\u00020(`\u001d2\u0006\u0010%\u001a\u00020\"2\u0006\u0010&\u001a\u00020\u0017H&J \u0010#\u001a\u00020\u00172\u0006\u0010)\u001a\u00020\u00172\u0006\u0010*\u001a\u00020\u00152\u0006\u0010%\u001a\u00020+H&J\u0018\u0010,\u001a\u00020\u00172\u0006\u0010\u001f\u001a\u00020\u00172\u0006\u0010-\u001a\u00020(H&J \u0010.\u001a\u00020\u00152\u0006\u0010\u001f\u001a\u00020\u00172\u0006\u0010$\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u001aH&J\u0010\u0010/\u001a\u00020\u00152\u0006\u00100\u001a\u00020\u0017H&J\u0010\u00101\u001a\u00020\u00152\u0006\u0010\u001f\u001a\u00020\u0017H&J\u0010\u00102\u001a\u00020\u00152\u0006\u00103\u001a\u00020\u0017H&J\u0018\u00104\u001a\u00020\u00172\u0006\u00105\u001a\u00020\"2\u0006\u00106\u001a\u00020(H&J \u00107\u001a\u00020\u00152\u0006\u00105\u001a\u00020\"2\u0006\u00108\u001a\u00020\u00172\u0006\u0010$\u001a\u00020\u0017H&J\u0018\u00109\u001a\u00020\u00032\u0006\u00100\u001a\u00020\u00172\u0006\u0010:\u001a\u00020\u0017H&J\u0018\u0010;\u001a\u00020\u00032\u0006\u0010<\u001a\u00020+2\u0006\u0010\u001f\u001a\u00020\u0017H&J\u0010\u0010=\u001a\u00020\u00032\u0006\u0010>\u001a\u00020?H&J\u0010\u0010@\u001a\u00020\u00172\u0006\u0010A\u001a\u00020\u0017H&J\u0010\u0010B\u001a\u00020\u00172\u0006\u00100\u001a\u00020\u0017H&J\u0010\u0010C\u001a\u00020\u00172\u0006\u0010\u001f\u001a\u00020\u0017H&J\u0010\u0010D\u001a\u00020\u00172\u0006\u0010E\u001a\u00020FH&J\u0010\u0010G\u001a\u00020\u00172\u0006\u0010E\u001a\u00020FH&J\u001a\u0010H\u001a\u0004\u0018\u00010I2\u0006\u0010-\u001a\u00020(2\u0006\u0010J\u001a\u00020\u001aH&J\u0010\u0010K\u001a\u00020\u00032\u0006\u0010L\u001a\u00020\u0015H&J\b\u0010M\u001a\u00020\u0015H&J\u0012\u0010N\u001a\u0004\u0018\u00010O2\u0006\u0010P\u001a\u00020QH&J\u0010\u0010R\u001a\u00020\u00032\u0006\u0010S\u001a\u00020\u0015H&J\u0018\u0010Y\u001a\u00020\u00032\u0006\u0010Z\u001a\u00020\u00172\u0006\u0010[\u001a\u00020\u0017H&J\b\u0010\\\u001a\u00020\u0003H&J\b\u0010]\u001a\u00020\u0003H&J\u0010\u0010b\u001a\u00020\u00172\u0006\u0010\u001f\u001a\u00020\u0017H&J\u0010\u0010c\u001a\u00020\u00172\u0006\u0010\u001f\u001a\u00020\u0017H&J\u0012\u0010d\u001a\u0004\u0018\u00010e2\u0006\u0010f\u001a\u00020IH&J\u001e\u0010g\u001a\u0010\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u0017\u0018\u00010h2\u0006\u0010f\u001a\u00020IH&J\u001a\u0010i\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010e\u0018\u00010j2\u0006\u0010f\u001a\u00020IH&J \u0010k\u001a\n\u0012\u0004\u0012\u00020I\u0018\u00010l2\u0006\u0010m\u001a\u00020\u00172\u0006\u0010n\u001a\u00020\u0017H&J\u0010\u0010o\u001a\u00020I2\u0006\u0010p\u001a\u00020\"H&J\u0010\u0010q\u001a\u00020\u00032\u0006\u0010r\u001a\u00020eH&J\u0010\u0010s\u001a\u00020\u00032\u0006\u0010t\u001a\u00020uH&JW\u0010v\u001a\u00020\u00032M\u0010w\u001aI\u0012\u0013\u0012\u00110y¢\u0006\f\bz\u0012\b\b{\u0012\u0004\b\b(|\u0012\u0013\u0012\u00110\u0017¢\u0006\f\bz\u0012\b\b{\u0012\u0004\b\b(}\u0012\u0013\u0012\u00110\u0017¢\u0006\f\bz\u0012\b\b{\u0012\u0004\b\b(~\u0012\u0004\u0012\u00020\u0015\u0018\u00010xH&J\u0011\u0010\u007f\u001a\u00020\u00032\u0007\u0010\u0080\u0001\u001a\u00020\u0015H&J%\u0010\u0081\u0001\u001a\u00020\u00032\b\u0010\u0082\u0001\u001a\u00030\u0083\u00012\u0007\u0010\u0084\u0001\u001a\u00020\u00152\u0007\u0010\u0085\u0001\u001a\u00020\u0015H&J%\u0010\u0086\u0001\u001a\u00020\u00032\b\u0010\u0082\u0001\u001a\u00030\u0083\u00012\u0007\u0010\u0084\u0001\u001a\u00020\u00152\u0007\u0010\u0085\u0001\u001a\u00020\u0015H&J6\u0010\u0087\u0001\u001a\u00020\u00032\b\u0010\u0088\u0001\u001a\u00030\u0089\u00012\u0007\u0010\u008a\u0001\u001a\u00020\u00172\u0007\u0010\u008b\u0001\u001a\u00020\u00172\u0006\u0010p\u001a\u00020\"2\u0007\u0010\u0084\u0001\u001a\u00020\u0015H&J>\u0010\u008c\u0001\u001a\u00020\u00032\b\u0010\u0088\u0001\u001a\u00030\u0089\u00012 \u0010\u008d\u0001\u001a\u001b\u0012\u0017\u0012\u0015\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\"0\u008e\u00010j2\u0007\u0010\u0084\u0001\u001a\u00020\u0015H&R\u0014\u0010\n\u001a\u0004\u0018\u00010\u000bX¦\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0018\u0010T\u001a\u00020\u0017X¦\u000e¢\u0006\f\u001a\u0004\bU\u0010V\"\u0004\bW\u0010XR\u0012\u0010^\u001a\u00020\u0017X¦\u0004¢\u0006\u0006\u001a\u0004\b_\u0010VR\u0012\u0010`\u001a\u00020\u0017X¦\u0004¢\u0006\u0006\u001a\u0004\ba\u0010V¨\u0006\u0090\u0001"}, m13886d2 = {"Lcom/samsung/android/sdk/composer/text/ISpenNoteTextManager;", "Lcom/samsung/android/sdk/pen/widget/SpenITextManager;", "setDocument", "", "doc", "Lcom/samsung/android/sdk/pen/worddoc/SpenWNote;", "setNativeHandle", "handle", "", "close", "selectedObject", "Lcom/samsung/android/sdk/pen/document/SpenObjectBase;", "getSelectedObject", "()Lcom/samsung/android/sdk/pen/document/SpenObjectBase;", "sendKeyEvent", "event", "Landroid/view/KeyEvent;", "lockBodyTextPage", "unlockBodyTextPage", "updateBodyTextPage", "moveBodyTextTo", "", "srcPageIndex", "", "dstPageIndex", "documentPixel", "", "srcPageIndexList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "removeBodyTextFrom", "pageIndex", "pageIndexList", "copyBodyTextFrom", "Lcom/samsung/android/sdk/pen/document/SpenObjectTextBox;", "insertBodyTextTo", "pageHeight", "insertObject", "textSizeDelta", "pageList", "Lcom/samsung/android/sdk/pen/worddoc/SpenWPage;", "cursorPos", "newParagraph", "Lcom/samsung/android/sdk/pen/document/SpenObjectShape;", "calculateInsertedTextCountWhenInsertEmptyBodyTextTo", "page", "insertEmptyBodyTextTo", "insertPageBreakIntoBodyText", "textIndex", "clearBodyTextIn", "clearBodyTextByParagraphIndex", "paraIndex", "calculateOverflowPageCount", "objectText", "wpage", "reduceFontSizeToFitPage", "pageWidth", "updateBodyObjectSpanPosition", "count", "setCursorOnScreen", "objectShape", "setCursorObstacleRect", "obstacleRect", "Landroid/graphics/Rect;", "getPageIndexByCursorOfBodyText", "cursorIndex", "getPageIndexByTextOfBodyText", "getStartCursorIndexByPage", "getLineCountFromBodyTextBottom", "position", "Landroid/graphics/PointF;", "getCursorIndexToInsertIntoBodyText", "getLineRectOfBodyText", "Landroid/graphics/RectF;", "y", "setShowSoftInputDisabled", "disable", "onCheckIsTextEditor", "onCreateInputConnection", "Landroid/view/inputmethod/InputConnection;", "outAttrs", "Landroid/view/inputmethod/EditorInfo;", "onShowSoftInput", Constants.IntentExtraValue.SHOW, "cursorSelectionMaxLength", "getCursorSelectionMaxLength", "()I", "setCursorSelectionMaxLength", "(I)V", "setSelectionRange", VElementFormulasCmd.FMIN, VElementFormulasCmd.FMAX, "startAiTextFormat", "stopAiTextFormat", "cursorSelectionStartOnScreenInBodyText", "getCursorSelectionStartOnScreenInBodyText", "cursorSelectionEndOnScreenInBodyText", "getCursorSelectionEndOnScreenInBodyText", "getTextStartByPage", "getTextCountByPage", "getTextByRectInBodytext", "", "rect", "getCursorRangeByRectInBodytext", "Landroid/util/Pair;", "getTextByRectInTextbox", "", "getTextContentRectsByCursorRangeInBodytext", "", "curStart", "curEnd", "getTextBoxMeasuredRect", ExternalDataConstants.Column.TEXT_BOX, "addPrivateImeSettings", "options", "setPreCommitRegex", "regex", "Lkotlin/text/Regex;", "setPreCommitCheckFunction", "func", "Lkotlin/Function3;", "", "Lkotlin/ParameterName;", "name", "text", "composingStart", "composingEnd", "setFixedContentHeightEnabled", "bool", "appendObjectSpan", "objectSpan", "Lcom/samsung/android/sdk/pen/document/textspan/SpenObjectSpan;", "animationEnabled", "commitHistory", "removeObjectSpan", "setTableCellContent", "objectTable", "Lcom/samsung/android/sdk/pen/document/SpenObjectTable;", "rowIndex", "columnIndex", "setTableCellsContent", "cellDataList", "Lkotlin/Triple;", "Companion", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public interface ISpenNoteTextManager extends SpenITextManager {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = Companion.$$INSTANCE;
    public static final int DEFAULT_TEXT_SIZE_DELTA_IN_PHONE = 0;
    public static final int DEFAULT_TEXT_SIZE_DELTA_IN_TABLET = -5;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, m13886d2 = {"Lcom/samsung/android/sdk/composer/text/ISpenNoteTextManager$Companion;", "", "<init>", "()V", "DEFAULT_TEXT_SIZE_DELTA_IN_PHONE", "", "DEFAULT_TEXT_SIZE_DELTA_IN_TABLET", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        public static final int DEFAULT_TEXT_SIZE_DELTA_IN_PHONE = 0;
        public static final int DEFAULT_TEXT_SIZE_DELTA_IN_TABLET = -5;

        private Companion() {
        }
    }

    void addPrivateImeSettings(@NotNull String options);

    void appendObjectSpan(@NotNull SpenObjectSpan objectSpan, boolean animationEnabled, boolean commitHistory);

    int calculateInsertedTextCountWhenInsertEmptyBodyTextTo(int pageIndex, @NotNull SpenWPage page);

    int calculateOverflowPageCount(@NotNull SpenObjectTextBox objectText, @NotNull SpenWPage wpage);

    boolean clearBodyTextByParagraphIndex(int paraIndex);

    boolean clearBodyTextIn(int pageIndex);

    @Override // com.samsung.android.sdk.pen.widget.SpenITextManager
    void close();

    @Nullable
    SpenObjectTextBox copyBodyTextFrom(int pageIndex);

    int getCursorIndexToInsertIntoBodyText(@NotNull PointF position);

    @Nullable
    Pair<Integer, Integer> getCursorRangeByRectInBodytext(@NotNull RectF rect);

    int getCursorSelectionEndOnScreenInBodyText();

    int getCursorSelectionMaxLength();

    int getCursorSelectionStartOnScreenInBodyText();

    int getLineCountFromBodyTextBottom(@NotNull PointF position);

    @Nullable
    RectF getLineRectOfBodyText(@NotNull SpenWPage page, float y2);

    int getPageIndexByCursorOfBodyText(int cursorIndex);

    int getPageIndexByTextOfBodyText(int textIndex);

    @Override // com.samsung.android.sdk.pen.widget.SpenITextManager
    @Nullable
    SpenObjectBase getSelectedObject();

    int getStartCursorIndexByPage(int pageIndex);

    @NotNull
    RectF getTextBoxMeasuredRect(@NotNull SpenObjectTextBox textBox);

    @Nullable
    String getTextByRectInBodytext(@NotNull RectF rect);

    @Nullable
    List<String> getTextByRectInTextbox(@NotNull RectF rect);

    @Nullable
    List<RectF> getTextContentRectsByCursorRangeInBodytext(int curStart, int curEnd);

    int getTextCountByPage(int pageIndex);

    int getTextStartByPage(int pageIndex);

    int insertBodyTextTo(int cursorPos, boolean newParagraph, @NotNull SpenObjectShape insertObject);

    boolean insertBodyTextTo(int pageIndex, int pageHeight, float documentPixel, @NotNull SpenObjectTextBox insertObject, int textSizeDelta);

    boolean insertBodyTextTo(int pageIndex, @NotNull ArrayList<SpenWPage> pageList, @NotNull SpenObjectTextBox insertObject, int textSizeDelta);

    boolean insertEmptyBodyTextTo(int pageIndex, int pageHeight, float documentPixel);

    boolean insertPageBreakIntoBodyText(int textIndex);

    void lockBodyTextPage();

    boolean moveBodyTextTo(int srcPageIndex, int dstPageIndex, float documentPixel);

    boolean moveBodyTextTo(@NotNull ArrayList<Integer> srcPageIndexList, int dstPageIndex);

    @Override // com.samsung.android.sdk.pen.widget.SpenITextManager
    boolean onCheckIsTextEditor();

    @Override // com.samsung.android.sdk.pen.widget.SpenITextManager
    @Nullable
    InputConnection onCreateInputConnection(@NotNull EditorInfo outAttrs);

    @Override // com.samsung.android.sdk.pen.widget.SpenITextManager
    void onShowSoftInput(boolean show);

    boolean reduceFontSizeToFitPage(@NotNull SpenObjectTextBox objectText, int pageWidth, int pageHeight);

    boolean removeBodyTextFrom(int pageIndex);

    boolean removeBodyTextFrom(@Nullable ArrayList<Integer> pageIndexList);

    void removeObjectSpan(@NotNull SpenObjectSpan objectSpan, boolean animationEnabled, boolean commitHistory);

    void sendKeyEvent(@NotNull KeyEvent event);

    void setCursorObstacleRect(@NotNull Rect obstacleRect);

    void setCursorOnScreen(@NotNull SpenObjectShape objectShape, int pageIndex);

    void setCursorSelectionMaxLength(int i);

    void setDocument(@Nullable SpenWNote doc);

    void setFixedContentHeightEnabled(boolean bool);

    @Override // com.samsung.android.sdk.pen.widget.SpenITextManager
    void setNativeHandle(long handle);

    void setPreCommitCheckFunction(@Nullable Function3<? super CharSequence, ? super Integer, ? super Integer, Boolean> func);

    void setPreCommitRegex(@NotNull Regex regex);

    void setSelectionRange(int min, int max);

    void setShowSoftInputDisabled(boolean disable);

    void setTableCellContent(@NotNull SpenObjectTable objectTable, int rowIndex, int columnIndex, @NotNull SpenObjectTextBox textBox, boolean animationEnabled);

    void setTableCellsContent(@NotNull SpenObjectTable objectTable, @NotNull List<Triple<Integer, Integer, SpenObjectTextBox>> cellDataList, boolean animationEnabled);

    void startAiTextFormat();

    void stopAiTextFormat();

    void unlockBodyTextPage();

    void updateBodyObjectSpanPosition(int textIndex, int count);

    void updateBodyTextPage();
}
