package com.samsung.android.sdk.composer.text;

import android.content.Context;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.Log;
import android.util.Pair;
import android.view.KeyEvent;
import android.view.View;
import com.samsung.android.sdk.pen.document.SpenObjectBase;
import com.samsung.android.sdk.pen.document.SpenObjectShape;
import com.samsung.android.sdk.pen.document.SpenObjectTable;
import com.samsung.android.sdk.pen.document.SpenObjectTextBox;
import com.samsung.android.sdk.pen.document.textspan.SpenObjectSpan;
import com.samsung.android.sdk.pen.text.SpenInputManager;
import com.samsung.android.sdk.pen.view.SpenConfiguration;
import com.samsung.android.sdk.pen.view.SpenDisplay;
import com.samsung.android.sdk.pen.widget.SpenTextManager;
import com.samsung.android.sdk.pen.worddoc.SpenWNote;
import com.samsung.android.sdk.pen.worddoc.SpenWPage;
import com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.vector.shape.elements.VElementFormulasCmd;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.util.Constants;
import com.samsung.android.support.senl.p148nt.data.common.constants.ExternalDataConstants;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Triple;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u0000Ø\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0010!\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u0094\u00012\u00020\u00012\u00020\u0002:\u0002\u0094\u0001B\u0011\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0012\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\nH\u0016J\u0010\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\bH\u0016J\b\u0010\u0012\u001a\u00020\u000eH\u0016J\u0010\u0010\u0017\u001a\u00020\u000e2\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J\b\u0010\u001a\u001a\u00020\u000eH\u0016J\b\u0010\u001b\u001a\u00020\u000eH\u0016J\b\u0010\u001c\u001a\u00020\u000eH\u0016J \u0010\u001d\u001a\u00020\f2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u001f2\u0006\u0010!\u001a\u00020\"H\u0016J\u001e\u0010\u001d\u001a\u00020\f2\f\u0010#\u001a\b\u0012\u0004\u0012\u00020\u001f0$2\u0006\u0010 \u001a\u00020\u001fH\u0016J\u0010\u0010%\u001a\u00020\f2\u0006\u0010&\u001a\u00020\u001fH\u0016J\u0018\u0010%\u001a\u00020\f2\u000e\u0010'\u001a\n\u0012\u0004\u0012\u00020\u001f\u0018\u00010$H\u0016J\u0012\u0010(\u001a\u0004\u0018\u00010)2\u0006\u0010&\u001a\u00020\u001fH\u0016J0\u0010*\u001a\u00020\f2\u0006\u0010&\u001a\u00020\u001f2\u0006\u0010+\u001a\u00020\u001f2\u0006\u0010!\u001a\u00020\"2\u0006\u0010,\u001a\u00020)2\u0006\u0010-\u001a\u00020\u001fH\u0016J.\u0010*\u001a\u00020\f2\u0006\u0010&\u001a\u00020\u001f2\f\u0010.\u001a\b\u0012\u0004\u0012\u00020/0$2\u0006\u0010,\u001a\u00020)2\u0006\u0010-\u001a\u00020\u001fH\u0016J \u0010*\u001a\u00020\u001f2\u0006\u00100\u001a\u00020\u001f2\u0006\u00101\u001a\u00020\f2\u0006\u0010,\u001a\u000202H\u0016J\u0018\u00103\u001a\u00020\u001f2\u0006\u0010&\u001a\u00020\u001f2\u0006\u00104\u001a\u00020/H\u0016J \u00105\u001a\u00020\f2\u0006\u0010&\u001a\u00020\u001f2\u0006\u0010+\u001a\u00020\u001f2\u0006\u0010!\u001a\u00020\"H\u0016J\u0010\u00106\u001a\u00020\f2\u0006\u00107\u001a\u00020\u001fH\u0016J\u0010\u00108\u001a\u00020\f2\u0006\u0010&\u001a\u00020\u001fH\u0016J\u0010\u00109\u001a\u00020\f2\u0006\u0010:\u001a\u00020\u001fH\u0016J\u0018\u0010;\u001a\u00020\u001f2\u0006\u0010<\u001a\u00020)2\u0006\u0010=\u001a\u00020/H\u0016J \u0010>\u001a\u00020\f2\u0006\u0010<\u001a\u00020)2\u0006\u0010?\u001a\u00020\u001f2\u0006\u0010+\u001a\u00020\u001fH\u0016J\u0018\u0010@\u001a\u00020\u000e2\u0006\u00107\u001a\u00020\u001f2\u0006\u0010A\u001a\u00020\u001fH\u0016J\u0018\u0010B\u001a\u00020\u000e2\u0006\u0010C\u001a\u0002022\u0006\u0010&\u001a\u00020\u001fH\u0016J\u0010\u0010D\u001a\u00020\u000e2\u0006\u0010E\u001a\u00020FH\u0016J\u0010\u0010G\u001a\u00020\u001f2\u0006\u00100\u001a\u00020\u001fH\u0016J\u0010\u0010H\u001a\u00020\u001f2\u0006\u00107\u001a\u00020\u001fH\u0016J\u0010\u0010I\u001a\u00020\u001f2\u0006\u0010&\u001a\u00020\u001fH\u0016J\u0010\u0010J\u001a\u00020\u001f2\u0006\u0010K\u001a\u00020LH\u0016J\u0010\u0010M\u001a\u00020\u001f2\u0006\u0010K\u001a\u00020LH\u0016J\u001a\u0010N\u001a\u0004\u0018\u00010O2\u0006\u00104\u001a\u00020/2\u0006\u0010P\u001a\u00020\"H\u0016J\u0010\u0010Q\u001a\u00020\u000e2\u0006\u0010R\u001a\u00020\fH\u0016J\u0010\u0010S\u001a\u00020\u000e2\u0006\u0010T\u001a\u00020\fH\u0016J\u0018\u0010[\u001a\u00020\u000e2\u0006\u0010\\\u001a\u00020\u001f2\u0006\u0010]\u001a\u00020\u001fH\u0016J\b\u0010^\u001a\u00020\u000eH\u0016J\b\u0010_\u001a\u00020\u000eH\u0016J\u000e\u0010d\u001a\b\u0012\u0004\u0012\u00020O0eH\u0002J\b\u0010f\u001a\u00020gH\u0002J\u0010\u0010h\u001a\u00020\u001f2\u0006\u0010&\u001a\u00020\u001fH\u0016J\u0010\u0010i\u001a\u00020\u001f2\u0006\u0010&\u001a\u00020\u001fH\u0016J\u0012\u0010j\u001a\u0004\u0018\u00010k2\u0006\u0010l\u001a\u00020OH\u0016J\u001e\u0010m\u001a\u0010\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020\u001f\u0018\u00010n2\u0006\u0010l\u001a\u00020OH\u0016J\u001a\u0010o\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010k\u0018\u00010e2\u0006\u0010l\u001a\u00020OH\u0016J \u0010p\u001a\n\u0012\u0004\u0012\u00020O\u0018\u00010e2\u0006\u0010q\u001a\u00020\u001f2\u0006\u0010r\u001a\u00020\u001fH\u0016J\u0010\u0010s\u001a\u00020O2\u0006\u0010t\u001a\u00020)H\u0016J\u0010\u0010u\u001a\u00020\u000e2\u0006\u0010v\u001a\u00020kH\u0016J\u0010\u0010w\u001a\u00020\u000e2\u0006\u0010x\u001a\u00020yH\u0016JZ\u0010z\u001a\u00020\u000e2P\u0010{\u001aL\u0012\u0014\u0012\u00120}¢\u0006\r\b~\u0012\t\b\u007f\u0012\u0005\b\b(\u0080\u0001\u0012\u0014\u0012\u00120\u001f¢\u0006\r\b~\u0012\t\b\u007f\u0012\u0005\b\b(\u0081\u0001\u0012\u0014\u0012\u00120\u001f¢\u0006\r\b~\u0012\t\b\u007f\u0012\u0005\b\b(\u0082\u0001\u0012\u0004\u0012\u00020\f\u0018\u00010|H\u0016J\u0012\u0010\u0083\u0001\u001a\u00020\u000e2\u0007\u0010\u0084\u0001\u001a\u00020\fH\u0016J%\u0010\u0085\u0001\u001a\u00020\u000e2\b\u0010\u0086\u0001\u001a\u00030\u0087\u00012\u0007\u0010\u0088\u0001\u001a\u00020\f2\u0007\u0010\u0089\u0001\u001a\u00020\fH\u0016J%\u0010\u008a\u0001\u001a\u00020\u000e2\b\u0010\u0086\u0001\u001a\u00030\u0087\u00012\u0007\u0010\u0088\u0001\u001a\u00020\f2\u0007\u0010\u0089\u0001\u001a\u00020\fH\u0016J6\u0010\u008b\u0001\u001a\u00020\u000e2\b\u0010\u008c\u0001\u001a\u00030\u008d\u00012\u0007\u0010\u008e\u0001\u001a\u00020\u001f2\u0007\u0010\u008f\u0001\u001a\u00020\u001f2\u0006\u0010t\u001a\u00020)2\u0007\u0010\u0088\u0001\u001a\u00020\fH\u0016J?\u0010\u0090\u0001\u001a\u00020\u000e2\b\u0010\u008c\u0001\u001a\u00030\u008d\u00012!\u0010\u0091\u0001\u001a\u001c\u0012\u0017\u0012\u0015\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020)0\u0093\u00010\u0092\u00012\u0007\u0010\u0088\u0001\u001a\u00020\fH\u0016R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0013\u001a\u0004\u0018\u00010\u00148VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016R$\u0010V\u001a\u00020\u001f2\u0006\u0010U\u001a\u00020\u001f8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\bW\u0010X\"\u0004\bY\u0010ZR\u0014\u0010`\u001a\u00020\u001f8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\ba\u0010XR\u0014\u0010b\u001a\u00020\u001f8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bc\u0010X¨\u0006\u0095\u0001"}, m13886d2 = {"Lcom/samsung/android/sdk/composer/text/SpenNoteTextManager;", "Lcom/samsung/android/sdk/pen/widget/SpenTextManager;", "Lcom/samsung/android/sdk/composer/text/ISpenNoteTextManager;", "view", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "mNativeNoteTextManager", "", "mDocument", "Lcom/samsung/android/sdk/pen/worddoc/SpenWNote;", "mIsShowSoftInputDisabled", "", "setDocument", "", "doc", "setNativeHandle", "handle", "close", "selectedObject", "Lcom/samsung/android/sdk/pen/document/SpenObjectBase;", "getSelectedObject", "()Lcom/samsung/android/sdk/pen/document/SpenObjectBase;", "sendKeyEvent", "event", "Landroid/view/KeyEvent;", "lockBodyTextPage", "unlockBodyTextPage", "updateBodyTextPage", "moveBodyTextTo", "srcPageIndex", "", "dstPageIndex", "documentPixel", "", "srcPageIndexList", "Ljava/util/ArrayList;", "removeBodyTextFrom", "pageIndex", "pageIndexList", "copyBodyTextFrom", "Lcom/samsung/android/sdk/pen/document/SpenObjectTextBox;", "insertBodyTextTo", "pageHeight", "insertObject", "textSizeDelta", "pageList", "Lcom/samsung/android/sdk/pen/worddoc/SpenWPage;", "cursorIndex", "newParagraph", "Lcom/samsung/android/sdk/pen/document/SpenObjectShape;", "calculateInsertedTextCountWhenInsertEmptyBodyTextTo", "page", "insertEmptyBodyTextTo", "insertPageBreakIntoBodyText", "textIndex", "clearBodyTextIn", "clearBodyTextByParagraphIndex", "paraIndex", "calculateOverflowPageCount", "objectText", "wpage", "reduceFontSizeToFitPage", "pageWidth", "updateBodyObjectSpanPosition", "count", "setCursorOnScreen", "objectShape", "setCursorObstacleRect", "obstacleRect", "Landroid/graphics/Rect;", "getPageIndexByCursorOfBodyText", "getPageIndexByTextOfBodyText", "getStartCursorIndexByPage", "getLineCountFromBodyTextBottom", "position", "Landroid/graphics/PointF;", "getCursorIndexToInsertIntoBodyText", "getLineRectOfBodyText", "Landroid/graphics/RectF;", "y", "setShowSoftInputDisabled", "disable", "onShowSoftInput", Constants.IntentExtraValue.SHOW, "value", "cursorSelectionMaxLength", "getCursorSelectionMaxLength", "()I", "setCursorSelectionMaxLength", "(I)V", "setSelectionRange", VElementFormulasCmd.FMIN, VElementFormulasCmd.FMAX, "startAiTextFormat", "stopAiTextFormat", "cursorSelectionStartOnScreenInBodyText", "getCursorSelectionStartOnScreenInBodyText", "cursorSelectionEndOnScreenInBodyText", "getCursorSelectionEndOnScreenInBodyText", "getCursorSelectionRectOnScreenInBodyText", "", "getCursorSelectionPathOnScreenInBodyText", "Landroid/graphics/Path;", "getTextStartByPage", "getTextCountByPage", "getTextByRectInBodytext", "", "rect", "getCursorRangeByRectInBodytext", "Landroid/util/Pair;", "getTextByRectInTextbox", "getTextContentRectsByCursorRangeInBodytext", "curStart", "curEnd", "getTextBoxMeasuredRect", ExternalDataConstants.Column.TEXT_BOX, "addPrivateImeSettings", "options", "setPreCommitRegex", "regex", "Lkotlin/text/Regex;", "setPreCommitCheckFunction", "func", "Lkotlin/Function3;", "", "Lkotlin/ParameterName;", "name", "text", "composingStart", "composingEnd", "setFixedContentHeightEnabled", "enable", "appendObjectSpan", "objectSpan", "Lcom/samsung/android/sdk/pen/document/textspan/SpenObjectSpan;", "animationEnabled", "commitHistory", "removeObjectSpan", "setTableCellContent", "objectTable", "Lcom/samsung/android/sdk/pen/document/SpenObjectTable;", "rowIndex", "columnIndex", "setTableCellsContent", "cellDataList", "", "Lkotlin/Triple;", "Companion", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final class SpenNoteTextManager extends SpenTextManager implements ISpenNoteTextManager {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final String TAG = "SpenNoteTextManager";

    @Nullable
    private SpenWNote mDocument;
    private boolean mIsShowSoftInputDisabled;
    private long mNativeNoteTextManager;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u009e\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0010!\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0007J\u0018\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0007H\u0007J\u0011\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0083 J\u0011\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0083 J\u0011\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0083 J)\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0016\u001a\u00020\u00072\u0006\u0010\u0017\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020\u0019H\u0083 J'\u0010\u001a\u001a\u00020\u00152\u0006\u0010\u0010\u001a\u00020\u00112\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00070\u001c2\u0006\u0010\u0017\u001a\u00020\u0007H\u0083 J\u0019\u0010\u001d\u001a\u00020\u00152\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u001e\u001a\u00020\u0007H\u0083 J!\u0010\u001f\u001a\u00020\u00152\u0006\u0010\u0010\u001a\u00020\u00112\u000e\u0010 \u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u001cH\u0083 J\u001b\u0010!\u001a\u0004\u0018\u00010\"2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u001e\u001a\u00020\u0007H\u0083 J9\u0010#\u001a\u00020\u00152\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u001e\u001a\u00020\u00072\u0006\u0010$\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020\u0007H\u0083 J9\u0010(\u001a\u00020\u00152\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u001e\u001a\u00020\u00072\u000e\u0010)\u001a\n\u0012\u0004\u0012\u00020*\u0018\u00010\u001c2\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020\u0007H\u0083 J)\u0010+\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010,\u001a\u00020\u00072\u0006\u0010-\u001a\u00020\u00152\u0006\u0010%\u001a\u00020&H\u0083 J)\u0010.\u001a\u00020\u00152\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u001e\u001a\u00020\u00072\u0006\u0010$\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020\u0019H\u0083 J9\u0010/\u001a\u00020\u00152\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u001e\u001a\u00020\u00072\u000e\u00100\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u001c2\u0006\u00101\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020\u0019H\u0083 J\u0019\u00102\u001a\u00020\u00152\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u00103\u001a\u00020\u0007H\u0083 J\u0019\u00104\u001a\u00020\u00152\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u001e\u001a\u00020\u0007H\u0083 J\u0019\u00105\u001a\u00020\u00152\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u00106\u001a\u00020\u0007H\u0083 J!\u00107\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u00108\u001a\u0002092\u0006\u0010\u001e\u001a\u00020\u0007H\u0083 J1\u0010:\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010;\u001a\u00020\u00072\u0006\u0010<\u001a\u00020\u00072\u0006\u0010=\u001a\u00020\u00072\u0006\u0010>\u001a\u00020\u0007H\u0083 J\u0019\u0010?\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010,\u001a\u00020\u0007H\u0083 J\u0019\u0010@\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u00103\u001a\u00020\u0007H\u0083 J\u0019\u0010A\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u001e\u001a\u00020\u0007H\u0083 J!\u0010B\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010C\u001a\u00020\u00192\u0006\u0010D\u001a\u00020\u0019H\u0083 J!\u0010E\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010C\u001a\u00020\u00192\u0006\u0010D\u001a\u00020\u0019H\u0083 J#\u0010F\u001a\u0004\u0018\u00010G2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010H\u001a\u00020*2\u0006\u0010D\u001a\u00020\u0019H\u0083 J!\u0010I\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u00103\u001a\u00020\u00072\u0006\u0010J\u001a\u00020\u0007H\u0083 J!\u0010K\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u001e\u001a\u00020\u00072\u0006\u0010H\u001a\u00020*H\u0083 J!\u0010L\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010%\u001a\u00020&2\u0006\u0010H\u001a\u00020*H\u0083 J\u0019\u0010M\u001a\u00020\u00072\u0006\u0010N\u001a\u00020\u00112\u0006\u0010O\u001a\u00020\u0007H\u0083 J)\u0010P\u001a\u00020\u00152\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010Q\u001a\u00020&2\u0006\u0010R\u001a\u00020\u00072\u0006\u0010$\u001a\u00020\u0007H\u0083 J\u0019\u0010S\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010T\u001a\u00020\u0007H\u0083 J\u0011\u0010U\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u0011H\u0083 J!\u0010V\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010W\u001a\u00020\u00072\u0006\u0010X\u001a\u00020\u0007H\u0083 J\u0019\u0010Y\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010Z\u001a\u00020\u0015H\u0083 J\u0011\u0010[\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u0011H\u0083 J\u0011\u0010\\\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u0011H\u0083 J\u0019\u0010]\u001a\n\u0012\u0004\u0012\u00020G\u0018\u00010^2\u0006\u0010\u0010\u001a\u00020\u0011H\u0083 J\u0019\u0010_\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u001e\u001a\u00020\u0007H\u0083 J\u0019\u0010`\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u001e\u001a\u00020\u0007H\u0083 J\u001b\u0010a\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010b\u001a\u00020GH\u0083 J)\u0010c\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007\u0018\u00010d2\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010b\u001a\u0004\u0018\u00010GH\u0083 J%\u0010e\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010^2\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010b\u001a\u0004\u0018\u00010GH\u0083 J)\u0010f\u001a\n\u0012\u0004\u0012\u00020G\u0018\u00010^2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010g\u001a\u00020\u00072\u0006\u0010h\u001a\u00020\u0007H\u0083 J\u0019\u0010i\u001a\u00020G2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010j\u001a\u00020&H\u0083 J)\u0010k\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010l\u001a\u00020m2\u0006\u0010n\u001a\u00020\u00152\u0006\u0010o\u001a\u00020\u0015H\u0083 J)\u0010p\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010l\u001a\u00020m2\u0006\u0010n\u001a\u00020\u00152\u0006\u0010o\u001a\u00020\u0015H\u0083 JA\u0010q\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010r\u001a\u00020s2\u001e\u0010t\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\"0v0u2\u0006\u0010n\u001a\u00020\u0015H\u0083 R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006w"}, m13886d2 = {"Lcom/samsung/android/sdk/composer/text/SpenNoteTextManager$Companion;", "", "<init>", "()V", SearchConstants.TargetContents.TAG, "", "getDefaultTextSizeDeltaByDevice", "", "context", "Landroid/content/Context;", "calculateTextSizeDelta", "display", "Lcom/samsung/android/sdk/pen/view/SpenDisplay;", "currentSizeDelta", "Native_updateTextRange", "", "nativeTextManager", "", "Native_lockBodyTextPage", "Native_unlockBodyTextPage", "Native_moveBodyTextTo", "", "srcPageIndex", "dstPageIndex", "documentPixel", "", "Native_moveBodyTextsTo", "srcPageIndexList", "Ljava/util/ArrayList;", "Native_removeBodyTextFrom", "pageIndex", "Native_removeBodyTextsFrom", "pageIndexList", "Native_copyBodyTextFrom", "Lcom/samsung/android/sdk/pen/document/SpenObjectTextBox;", "Native_insertBodyTextTo", "pageHeight", "insertObject", "Lcom/samsung/android/sdk/pen/document/SpenObjectBase;", "textSizeDelta", "Native_insertBodyTextsTo", "pageList", "Lcom/samsung/android/sdk/pen/worddoc/SpenWPage;", "Native_insertBodyTextToCursor", "cursorIndex", "newParagraph", "Native_insertEmptyBodyTextTo", "Native_insertEmptyBodyTextsTo", "pageHeights", "pageHeightCount", "Native_insertPageBreakIntoBodyText", "textIndex", "Native_clearBodyTextIn", "Native_clearBodyTextByParagraphIndex", "paraIndex", "Native_setCursorOnScreen", "objectShape", "Lcom/samsung/android/sdk/pen/document/SpenObjectShape;", "Native_setCursorObstacleRect", "left", "top", "right", "bottom", "Native_getPageIndexByCursorOfBodyText", "Native_getPageIndexByTextOfBodyText", "Native_getStartCursorIndexByPage", "Native_getLineCountFromBodyTextBottom", "x", "y", "Native_getCursorIndexToInsertIntoBodyText", "Native_getLineRectOfBodyText", "Landroid/graphics/RectF;", "page", "Native_updateObjectSpanPosition", "count", "Native_calculateInsertedTextCountWhenInsertEmptyBodyTextTo", "Native_calculateOverflowPageCount", "Native_calculateTextSizeDelta", "nativeDisplay", "currentTextSizeDelta", "Native_reduceFontSizeToFitPage", "obj", "pageWidth", "Native_setCursorSelectionMaxLength", "len", "Native_getCursorSelectionMaxLength", "Native_setSelectionRange", VElementFormulasCmd.FMIN, VElementFormulasCmd.FMAX, "Native_startAiTextFormat", "start", "Native_getCursorSelectionStartOnScreenInBodyText", "Native_getCursorSelectionEndOnScreenInBodyText", "Native_getCursorSelectionRectOnScreenInBodyText", "", "Native_getTextStartByPage", "Native_getTextCountByPage", "Native_getTextByRect", "rect", "Native_getCursorRangeByRectInBodytext", "Landroid/util/Pair;", "Native_getTextByRectInTextbox", "Native_getTextContentRectsByCursorRangeInBodytext", "curStart", "curEnd", "Native_getTextBoxMeasuredRect", ExternalDataConstants.Column.TEXT_BOX, "Native_appendObjectSpan", "objectSpan", "Lcom/samsung/android/sdk/pen/document/textspan/SpenObjectSpan;", "animationEnabled", "commitHistory", "Native_removeObjectSpan", "Native_setTableCellsContent", "objectTable", "Lcom/samsung/android/sdk/pen/document/SpenObjectTable;", "cellDataList", "", "Lkotlin/Triple;", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final void Native_appendObjectSpan(long nativeTextManager, SpenObjectSpan objectSpan, boolean animationEnabled, boolean commitHistory) {
            SpenNoteTextManager.Native_appendObjectSpan(nativeTextManager, objectSpan, animationEnabled, commitHistory);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final int Native_calculateInsertedTextCountWhenInsertEmptyBodyTextTo(long nativeTextManager, int pageIndex, SpenWPage page) {
            return SpenNoteTextManager.Native_calculateInsertedTextCountWhenInsertEmptyBodyTextTo(nativeTextManager, pageIndex, page);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final int Native_calculateOverflowPageCount(long nativeTextManager, SpenObjectBase insertObject, SpenWPage page) {
            return SpenNoteTextManager.Native_calculateOverflowPageCount(nativeTextManager, insertObject, page);
        }

        @JvmStatic
        private final int Native_calculateTextSizeDelta(long nativeDisplay, int currentTextSizeDelta) {
            return SpenNoteTextManager.Native_calculateTextSizeDelta(nativeDisplay, currentTextSizeDelta);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final boolean Native_clearBodyTextByParagraphIndex(long nativeTextManager, int paraIndex) {
            return SpenNoteTextManager.Native_clearBodyTextByParagraphIndex(nativeTextManager, paraIndex);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final boolean Native_clearBodyTextIn(long nativeTextManager, int pageIndex) {
            return SpenNoteTextManager.Native_clearBodyTextIn(nativeTextManager, pageIndex);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final SpenObjectTextBox Native_copyBodyTextFrom(long nativeTextManager, int pageIndex) {
            return SpenNoteTextManager.Native_copyBodyTextFrom(nativeTextManager, pageIndex);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final int Native_getCursorIndexToInsertIntoBodyText(long nativeTextManager, float x, float y2) {
            return SpenNoteTextManager.Native_getCursorIndexToInsertIntoBodyText(nativeTextManager, x, y2);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final Pair<Integer, Integer> Native_getCursorRangeByRectInBodytext(long nativeTextManager, RectF rect) {
            return SpenNoteTextManager.Native_getCursorRangeByRectInBodytext(nativeTextManager, rect);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final int Native_getCursorSelectionEndOnScreenInBodyText(long nativeTextManager) {
            return SpenNoteTextManager.Native_getCursorSelectionEndOnScreenInBodyText(nativeTextManager);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final int Native_getCursorSelectionMaxLength(long nativeTextManager) {
            return SpenNoteTextManager.Native_getCursorSelectionMaxLength(nativeTextManager);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final List<RectF> Native_getCursorSelectionRectOnScreenInBodyText(long nativeTextManager) {
            return SpenNoteTextManager.Native_getCursorSelectionRectOnScreenInBodyText(nativeTextManager);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final int Native_getCursorSelectionStartOnScreenInBodyText(long nativeTextManager) {
            return SpenNoteTextManager.Native_getCursorSelectionStartOnScreenInBodyText(nativeTextManager);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final int Native_getLineCountFromBodyTextBottom(long nativeTextManager, float x, float y2) {
            return SpenNoteTextManager.Native_getLineCountFromBodyTextBottom(nativeTextManager, x, y2);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final RectF Native_getLineRectOfBodyText(long nativeTextManager, SpenWPage page, float y2) {
            return SpenNoteTextManager.Native_getLineRectOfBodyText(nativeTextManager, page, y2);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final int Native_getPageIndexByCursorOfBodyText(long nativeTextManager, int cursorIndex) {
            return SpenNoteTextManager.Native_getPageIndexByCursorOfBodyText(nativeTextManager, cursorIndex);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final int Native_getPageIndexByTextOfBodyText(long nativeTextManager, int textIndex) {
            return SpenNoteTextManager.Native_getPageIndexByTextOfBodyText(nativeTextManager, textIndex);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final int Native_getStartCursorIndexByPage(long nativeTextManager, int pageIndex) {
            return SpenNoteTextManager.Native_getStartCursorIndexByPage(nativeTextManager, pageIndex);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final RectF Native_getTextBoxMeasuredRect(long nativeTextManager, SpenObjectBase textBox) {
            return SpenNoteTextManager.Native_getTextBoxMeasuredRect(nativeTextManager, textBox);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final String Native_getTextByRect(long nativeTextManager, RectF rect) {
            return SpenNoteTextManager.Native_getTextByRect(nativeTextManager, rect);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final List<String> Native_getTextByRectInTextbox(long nativeTextManager, RectF rect) {
            return SpenNoteTextManager.Native_getTextByRectInTextbox(nativeTextManager, rect);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final List<RectF> Native_getTextContentRectsByCursorRangeInBodytext(long nativeTextManager, int curStart, int curEnd) {
            return SpenNoteTextManager.Native_getTextContentRectsByCursorRangeInBodytext(nativeTextManager, curStart, curEnd);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final int Native_getTextCountByPage(long nativeTextManager, int pageIndex) {
            return SpenNoteTextManager.Native_getTextCountByPage(nativeTextManager, pageIndex);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final int Native_getTextStartByPage(long nativeTextManager, int pageIndex) {
            return SpenNoteTextManager.Native_getTextStartByPage(nativeTextManager, pageIndex);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final boolean Native_insertBodyTextTo(long nativeTextManager, int pageIndex, int pageHeight, float documentPixel, SpenObjectBase insertObject, int textSizeDelta) {
            return SpenNoteTextManager.Native_insertBodyTextTo(nativeTextManager, pageIndex, pageHeight, documentPixel, insertObject, textSizeDelta);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final int Native_insertBodyTextToCursor(long nativeTextManager, int cursorIndex, boolean newParagraph, SpenObjectBase insertObject) {
            return SpenNoteTextManager.Native_insertBodyTextToCursor(nativeTextManager, cursorIndex, newParagraph, insertObject);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final boolean Native_insertBodyTextsTo(long nativeTextManager, int pageIndex, ArrayList<SpenWPage> pageList, SpenObjectBase insertObject, int textSizeDelta) {
            return SpenNoteTextManager.Native_insertBodyTextsTo(nativeTextManager, pageIndex, pageList, insertObject, textSizeDelta);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final boolean Native_insertEmptyBodyTextTo(long nativeTextManager, int pageIndex, int pageHeight, float documentPixel) {
            return SpenNoteTextManager.Native_insertEmptyBodyTextTo(nativeTextManager, pageIndex, pageHeight, documentPixel);
        }

        @JvmStatic
        private final boolean Native_insertEmptyBodyTextsTo(long nativeTextManager, int pageIndex, ArrayList<Integer> pageHeights, int pageHeightCount, float documentPixel) {
            return SpenNoteTextManager.Native_insertEmptyBodyTextsTo(nativeTextManager, pageIndex, pageHeights, pageHeightCount, documentPixel);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final boolean Native_insertPageBreakIntoBodyText(long nativeTextManager, int textIndex) {
            return SpenNoteTextManager.Native_insertPageBreakIntoBodyText(nativeTextManager, textIndex);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final void Native_lockBodyTextPage(long nativeTextManager) {
            SpenNoteTextManager.Native_lockBodyTextPage(nativeTextManager);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final boolean Native_moveBodyTextTo(long nativeTextManager, int srcPageIndex, int dstPageIndex, float documentPixel) {
            return SpenNoteTextManager.Native_moveBodyTextTo(nativeTextManager, srcPageIndex, dstPageIndex, documentPixel);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final boolean Native_moveBodyTextsTo(long nativeTextManager, ArrayList<Integer> srcPageIndexList, int dstPageIndex) {
            return SpenNoteTextManager.Native_moveBodyTextsTo(nativeTextManager, srcPageIndexList, dstPageIndex);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final boolean Native_reduceFontSizeToFitPage(long nativeTextManager, SpenObjectBase obj, int pageWidth, int pageHeight) {
            return SpenNoteTextManager.Native_reduceFontSizeToFitPage(nativeTextManager, obj, pageWidth, pageHeight);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final boolean Native_removeBodyTextFrom(long nativeTextManager, int pageIndex) {
            return SpenNoteTextManager.Native_removeBodyTextFrom(nativeTextManager, pageIndex);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final boolean Native_removeBodyTextsFrom(long nativeTextManager, ArrayList<Integer> pageIndexList) {
            return SpenNoteTextManager.Native_removeBodyTextsFrom(nativeTextManager, pageIndexList);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final void Native_removeObjectSpan(long nativeTextManager, SpenObjectSpan objectSpan, boolean animationEnabled, boolean commitHistory) {
            SpenNoteTextManager.Native_removeObjectSpan(nativeTextManager, objectSpan, animationEnabled, commitHistory);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final void Native_setCursorObstacleRect(long nativeTextManager, int left, int top, int right, int bottom) {
            SpenNoteTextManager.Native_setCursorObstacleRect(nativeTextManager, left, top, right, bottom);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final void Native_setCursorOnScreen(long nativeTextManager, SpenObjectShape objectShape, int pageIndex) {
            SpenNoteTextManager.Native_setCursorOnScreen(nativeTextManager, objectShape, pageIndex);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final void Native_setCursorSelectionMaxLength(long nativeTextManager, int len) {
            SpenNoteTextManager.Native_setCursorSelectionMaxLength(nativeTextManager, len);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final void Native_setSelectionRange(long nativeTextManager, int min, int max) {
            SpenNoteTextManager.Native_setSelectionRange(nativeTextManager, min, max);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final void Native_setTableCellsContent(long nativeTextManager, SpenObjectTable objectTable, List<Triple<Integer, Integer, SpenObjectTextBox>> cellDataList, boolean animationEnabled) {
            SpenNoteTextManager.Native_setTableCellsContent(nativeTextManager, objectTable, cellDataList, animationEnabled);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final void Native_startAiTextFormat(long nativeTextManager, boolean start) {
            SpenNoteTextManager.Native_startAiTextFormat(nativeTextManager, start);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final void Native_unlockBodyTextPage(long nativeTextManager) {
            SpenNoteTextManager.Native_unlockBodyTextPage(nativeTextManager);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final void Native_updateObjectSpanPosition(long nativeTextManager, int textIndex, int count) {
            SpenNoteTextManager.Native_updateObjectSpanPosition(nativeTextManager, textIndex, count);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final void Native_updateTextRange(long nativeTextManager) {
            SpenNoteTextManager.Native_updateTextRange(nativeTextManager);
        }

        @JvmStatic
        public final int calculateTextSizeDelta(@NotNull SpenDisplay display, int currentSizeDelta) {
            Intrinsics.checkNotNullParameter(display, "display");
            return Native_calculateTextSizeDelta(display.handle, currentSizeDelta);
        }

        @JvmStatic
        public final int getDefaultTextSizeDeltaByDevice(@NotNull Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            return SpenConfiguration.INSTANCE.isTabletUX(context) ? -5 : 0;
        }

        private Companion() {
        }
    }

    public SpenNoteTextManager(@Nullable View view) {
        super(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native void Native_appendObjectSpan(long j, SpenObjectSpan spenObjectSpan, boolean z, boolean z2);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native int Native_calculateInsertedTextCountWhenInsertEmptyBodyTextTo(long j, int i, SpenWPage spenWPage);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native int Native_calculateOverflowPageCount(long j, SpenObjectBase spenObjectBase, SpenWPage spenWPage);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native int Native_calculateTextSizeDelta(long j, int i);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native boolean Native_clearBodyTextByParagraphIndex(long j, int i);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native boolean Native_clearBodyTextIn(long j, int i);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native SpenObjectTextBox Native_copyBodyTextFrom(long j, int i);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native int Native_getCursorIndexToInsertIntoBodyText(long j, float f, float f4);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native Pair<Integer, Integer> Native_getCursorRangeByRectInBodytext(long j, RectF rectF);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native int Native_getCursorSelectionEndOnScreenInBodyText(long j);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native int Native_getCursorSelectionMaxLength(long j);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native List<RectF> Native_getCursorSelectionRectOnScreenInBodyText(long j);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native int Native_getCursorSelectionStartOnScreenInBodyText(long j);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native int Native_getLineCountFromBodyTextBottom(long j, float f, float f4);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native RectF Native_getLineRectOfBodyText(long j, SpenWPage spenWPage, float f);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native int Native_getPageIndexByCursorOfBodyText(long j, int i);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native int Native_getPageIndexByTextOfBodyText(long j, int i);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native int Native_getStartCursorIndexByPage(long j, int i);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native RectF Native_getTextBoxMeasuredRect(long j, SpenObjectBase spenObjectBase);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native String Native_getTextByRect(long j, RectF rectF);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native List<String> Native_getTextByRectInTextbox(long j, RectF rectF);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native List<RectF> Native_getTextContentRectsByCursorRangeInBodytext(long j, int i, int i2);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native int Native_getTextCountByPage(long j, int i);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native int Native_getTextStartByPage(long j, int i);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native boolean Native_insertBodyTextTo(long j, int i, int i2, float f, SpenObjectBase spenObjectBase, int i4);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native int Native_insertBodyTextToCursor(long j, int i, boolean z, SpenObjectBase spenObjectBase);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native boolean Native_insertBodyTextsTo(long j, int i, ArrayList<SpenWPage> arrayList, SpenObjectBase spenObjectBase, int i2);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native boolean Native_insertEmptyBodyTextTo(long j, int i, int i2, float f);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native boolean Native_insertEmptyBodyTextsTo(long j, int i, ArrayList<Integer> arrayList, int i2, float f);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native boolean Native_insertPageBreakIntoBodyText(long j, int i);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native void Native_lockBodyTextPage(long j);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native boolean Native_moveBodyTextTo(long j, int i, int i2, float f);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native boolean Native_moveBodyTextsTo(long j, ArrayList<Integer> arrayList, int i);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native boolean Native_reduceFontSizeToFitPage(long j, SpenObjectBase spenObjectBase, int i, int i2);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native boolean Native_removeBodyTextFrom(long j, int i);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native boolean Native_removeBodyTextsFrom(long j, ArrayList<Integer> arrayList);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native void Native_removeObjectSpan(long j, SpenObjectSpan spenObjectSpan, boolean z, boolean z2);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native void Native_setCursorObstacleRect(long j, int i, int i2, int i4, int i5);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native void Native_setCursorOnScreen(long j, SpenObjectShape spenObjectShape, int i);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native void Native_setCursorSelectionMaxLength(long j, int i);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native void Native_setSelectionRange(long j, int i, int i2);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native void Native_setTableCellsContent(long j, SpenObjectTable spenObjectTable, List<Triple<Integer, Integer, SpenObjectTextBox>> list, boolean z);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native void Native_startAiTextFormat(long j, boolean z);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native void Native_unlockBodyTextPage(long j);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native void Native_updateObjectSpanPosition(long j, int i, int i2);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native void Native_updateTextRange(long j);

    @JvmStatic
    public static final int calculateTextSizeDelta(@NotNull SpenDisplay spenDisplay, int i) {
        return INSTANCE.calculateTextSizeDelta(spenDisplay, i);
    }

    private final Path getCursorSelectionPathOnScreenInBodyText() {
        List<RectF> cursorSelectionRectOnScreenInBodyText = getCursorSelectionRectOnScreenInBodyText();
        if (cursorSelectionRectOnScreenInBodyText.isEmpty()) {
            return new Path();
        }
        Path path = new Path();
        path.reset();
        Iterator<RectF> it = cursorSelectionRectOnScreenInBodyText.iterator();
        while (it.hasNext()) {
            path.addRect(it.next(), Path.Direction.CW);
        }
        path.close();
        return path;
    }

    private final List<RectF> getCursorSelectionRectOnScreenInBodyText() {
        List<RectF> listNative_getCursorSelectionRectOnScreenInBodyText = INSTANCE.Native_getCursorSelectionRectOnScreenInBodyText(this.mNativeNoteTextManager);
        return listNative_getCursorSelectionRectOnScreenInBodyText == null ? new ArrayList() : listNative_getCursorSelectionRectOnScreenInBodyText;
    }

    @JvmStatic
    public static final int getDefaultTextSizeDeltaByDevice(@NotNull Context context) {
        return INSTANCE.getDefaultTextSizeDeltaByDevice(context);
    }

    @Override // com.samsung.android.sdk.composer.text.ISpenNoteTextManager
    public void addPrivateImeSettings(@NotNull String options) {
        Intrinsics.checkNotNullParameter(options, "options");
        SpenInputManager mInputManager = getMInputManager();
        if (mInputManager != null) {
            mInputManager.setMAddPrivateImeSettings(options);
        }
    }

    @Override // com.samsung.android.sdk.composer.text.ISpenNoteTextManager
    public void appendObjectSpan(@NotNull SpenObjectSpan objectSpan, boolean animationEnabled, boolean commitHistory) {
        Intrinsics.checkNotNullParameter(objectSpan, "objectSpan");
        INSTANCE.Native_appendObjectSpan(this.mNativeNoteTextManager, objectSpan, animationEnabled, commitHistory);
    }

    @Override // com.samsung.android.sdk.composer.text.ISpenNoteTextManager
    public int calculateInsertedTextCountWhenInsertEmptyBodyTextTo(int pageIndex, @NotNull SpenWPage page) {
        Intrinsics.checkNotNullParameter(page, "page");
        return INSTANCE.Native_calculateInsertedTextCountWhenInsertEmptyBodyTextTo(this.mNativeNoteTextManager, pageIndex, page);
    }

    @Override // com.samsung.android.sdk.composer.text.ISpenNoteTextManager
    public int calculateOverflowPageCount(@NotNull SpenObjectTextBox objectText, @NotNull SpenWPage wpage) {
        Intrinsics.checkNotNullParameter(objectText, "objectText");
        Intrinsics.checkNotNullParameter(wpage, "wpage");
        return INSTANCE.Native_calculateOverflowPageCount(this.mNativeNoteTextManager, objectText, wpage);
    }

    @Override // com.samsung.android.sdk.composer.text.ISpenNoteTextManager
    public boolean clearBodyTextByParagraphIndex(int paraIndex) {
        SpenWNote spenWNote = this.mDocument;
        if (spenWNote != null) {
            finishComposingText(spenWNote.getBodyText());
        }
        return INSTANCE.Native_clearBodyTextByParagraphIndex(this.mNativeNoteTextManager, paraIndex);
    }

    @Override // com.samsung.android.sdk.composer.text.ISpenNoteTextManager
    public boolean clearBodyTextIn(int pageIndex) {
        SpenWNote spenWNote = this.mDocument;
        if (spenWNote != null) {
            finishComposingText(spenWNote.getBodyText());
        }
        return INSTANCE.Native_clearBodyTextIn(this.mNativeNoteTextManager, pageIndex);
    }

    @Override // com.samsung.android.sdk.pen.widget.SpenTextManager, com.samsung.android.sdk.pen.widget.SpenITextManager
    public void close() {
        if (this.mNativeNoteTextManager != 0) {
            this.mNativeNoteTextManager = 0L;
        }
        this.mDocument = null;
        super.close();
    }

    @Override // com.samsung.android.sdk.composer.text.ISpenNoteTextManager
    @Nullable
    public SpenObjectTextBox copyBodyTextFrom(int pageIndex) {
        return INSTANCE.Native_copyBodyTextFrom(this.mNativeNoteTextManager, pageIndex);
    }

    @Override // com.samsung.android.sdk.composer.text.ISpenNoteTextManager
    public int getCursorIndexToInsertIntoBodyText(@NotNull PointF position) {
        Intrinsics.checkNotNullParameter(position, "position");
        return INSTANCE.Native_getCursorIndexToInsertIntoBodyText(this.mNativeNoteTextManager, position.x, position.y);
    }

    @Override // com.samsung.android.sdk.composer.text.ISpenNoteTextManager
    @Nullable
    public Pair<Integer, Integer> getCursorRangeByRectInBodytext(@NotNull RectF rect) {
        Intrinsics.checkNotNullParameter(rect, "rect");
        return INSTANCE.Native_getCursorRangeByRectInBodytext(this.mNativeNoteTextManager, rect);
    }

    @Override // com.samsung.android.sdk.composer.text.ISpenNoteTextManager
    public int getCursorSelectionEndOnScreenInBodyText() {
        return INSTANCE.Native_getCursorSelectionEndOnScreenInBodyText(this.mNativeNoteTextManager);
    }

    @Override // com.samsung.android.sdk.composer.text.ISpenNoteTextManager
    public int getCursorSelectionMaxLength() {
        long j = this.mNativeNoteTextManager;
        if (j == 0) {
            return 0;
        }
        return INSTANCE.Native_getCursorSelectionMaxLength(j);
    }

    @Override // com.samsung.android.sdk.composer.text.ISpenNoteTextManager
    public int getCursorSelectionStartOnScreenInBodyText() {
        return INSTANCE.Native_getCursorSelectionStartOnScreenInBodyText(this.mNativeNoteTextManager);
    }

    @Override // com.samsung.android.sdk.composer.text.ISpenNoteTextManager
    public int getLineCountFromBodyTextBottom(@NotNull PointF position) {
        Intrinsics.checkNotNullParameter(position, "position");
        return INSTANCE.Native_getLineCountFromBodyTextBottom(this.mNativeNoteTextManager, position.x, position.y);
    }

    @Override // com.samsung.android.sdk.composer.text.ISpenNoteTextManager
    @Nullable
    public RectF getLineRectOfBodyText(@NotNull SpenWPage page, float y2) {
        Intrinsics.checkNotNullParameter(page, "page");
        return INSTANCE.Native_getLineRectOfBodyText(this.mNativeNoteTextManager, page, y2);
    }

    @Override // com.samsung.android.sdk.composer.text.ISpenNoteTextManager
    public int getPageIndexByCursorOfBodyText(int cursorIndex) {
        return INSTANCE.Native_getPageIndexByCursorOfBodyText(this.mNativeNoteTextManager, cursorIndex);
    }

    @Override // com.samsung.android.sdk.composer.text.ISpenNoteTextManager
    public int getPageIndexByTextOfBodyText(int textIndex) {
        return INSTANCE.Native_getPageIndexByTextOfBodyText(this.mNativeNoteTextManager, textIndex);
    }

    @Override // com.samsung.android.sdk.pen.widget.SpenTextManager, com.samsung.android.sdk.pen.widget.SpenITextManager
    @Nullable
    public SpenObjectBase getSelectedObject() {
        ArrayList<SpenObjectBase> selectedObject;
        SpenWNote spenWNote = this.mDocument;
        if (spenWNote != null && (selectedObject = spenWNote.getSelectedObject()) != null && !selectedObject.isEmpty()) {
            SpenObjectBase spenObjectBase = selectedObject.get(0);
            Intrinsics.checkNotNullExpressionValue(spenObjectBase, "get(...)");
            SpenObjectBase spenObjectBase2 = spenObjectBase;
            if (spenObjectBase2 != null && (spenObjectBase2 instanceof SpenObjectShape)) {
                return (SpenObjectShape) spenObjectBase2;
            }
        }
        return null;
    }

    @Override // com.samsung.android.sdk.composer.text.ISpenNoteTextManager
    public int getStartCursorIndexByPage(int pageIndex) {
        return INSTANCE.Native_getStartCursorIndexByPage(this.mNativeNoteTextManager, pageIndex);
    }

    @Override // com.samsung.android.sdk.composer.text.ISpenNoteTextManager
    @NotNull
    public RectF getTextBoxMeasuredRect(@NotNull SpenObjectTextBox textBox) {
        Intrinsics.checkNotNullParameter(textBox, "textBox");
        return INSTANCE.Native_getTextBoxMeasuredRect(this.mNativeNoteTextManager, textBox);
    }

    @Override // com.samsung.android.sdk.composer.text.ISpenNoteTextManager
    @Nullable
    public String getTextByRectInBodytext(@NotNull RectF rect) {
        Intrinsics.checkNotNullParameter(rect, "rect");
        return INSTANCE.Native_getTextByRect(this.mNativeNoteTextManager, rect);
    }

    @Override // com.samsung.android.sdk.composer.text.ISpenNoteTextManager
    @Nullable
    public List<String> getTextByRectInTextbox(@NotNull RectF rect) {
        Intrinsics.checkNotNullParameter(rect, "rect");
        return INSTANCE.Native_getTextByRectInTextbox(this.mNativeNoteTextManager, rect);
    }

    @Override // com.samsung.android.sdk.composer.text.ISpenNoteTextManager
    @Nullable
    public List<RectF> getTextContentRectsByCursorRangeInBodytext(int curStart, int curEnd) {
        return INSTANCE.Native_getTextContentRectsByCursorRangeInBodytext(this.mNativeNoteTextManager, curStart, curEnd);
    }

    @Override // com.samsung.android.sdk.composer.text.ISpenNoteTextManager
    public int getTextCountByPage(int pageIndex) {
        return INSTANCE.Native_getTextCountByPage(this.mNativeNoteTextManager, pageIndex);
    }

    @Override // com.samsung.android.sdk.composer.text.ISpenNoteTextManager
    public int getTextStartByPage(int pageIndex) {
        return INSTANCE.Native_getTextStartByPage(this.mNativeNoteTextManager, pageIndex);
    }

    @Override // com.samsung.android.sdk.composer.text.ISpenNoteTextManager
    public boolean insertBodyTextTo(int pageIndex, int pageHeight, float documentPixel, @NotNull SpenObjectTextBox insertObject, int textSizeDelta) {
        Intrinsics.checkNotNullParameter(insertObject, "insertObject");
        SpenWNote spenWNote = this.mDocument;
        if (spenWNote != null) {
            finishComposingText(spenWNote.getBodyText());
        }
        return INSTANCE.Native_insertBodyTextTo(this.mNativeNoteTextManager, pageIndex, pageHeight, documentPixel, insertObject, textSizeDelta);
    }

    @Override // com.samsung.android.sdk.composer.text.ISpenNoteTextManager
    public boolean insertEmptyBodyTextTo(int pageIndex, int pageHeight, float documentPixel) {
        SpenWNote spenWNote = this.mDocument;
        if (spenWNote != null) {
            finishComposingText(spenWNote.getBodyText());
        }
        return INSTANCE.Native_insertEmptyBodyTextTo(this.mNativeNoteTextManager, pageIndex, pageHeight, documentPixel);
    }

    @Override // com.samsung.android.sdk.composer.text.ISpenNoteTextManager
    public boolean insertPageBreakIntoBodyText(int textIndex) {
        SpenWNote spenWNote = this.mDocument;
        if (spenWNote != null) {
            finishComposingText(spenWNote.getBodyText());
        }
        return INSTANCE.Native_insertPageBreakIntoBodyText(this.mNativeNoteTextManager, textIndex);
    }

    @Override // com.samsung.android.sdk.composer.text.ISpenNoteTextManager
    public void lockBodyTextPage() {
        INSTANCE.Native_lockBodyTextPage(this.mNativeNoteTextManager);
    }

    @Override // com.samsung.android.sdk.composer.text.ISpenNoteTextManager
    public boolean moveBodyTextTo(int srcPageIndex, int dstPageIndex, float documentPixel) {
        SpenWNote spenWNote = this.mDocument;
        if (spenWNote != null) {
            finishComposingText(spenWNote.getBodyText());
        }
        return INSTANCE.Native_moveBodyTextTo(this.mNativeNoteTextManager, srcPageIndex, dstPageIndex, documentPixel);
    }

    @Override // com.samsung.android.sdk.pen.widget.SpenTextManager, com.samsung.android.sdk.pen.widget.SpenITextManager
    public void onShowSoftInput(boolean show) {
        if (this.mIsShowSoftInputDisabled) {
            Log.d(TAG, "[STT] skip onShowSoftInput on working STT");
        } else {
            super.onShowSoftInput(show);
        }
    }

    @Override // com.samsung.android.sdk.composer.text.ISpenNoteTextManager
    public boolean reduceFontSizeToFitPage(@NotNull SpenObjectTextBox objectText, int pageWidth, int pageHeight) {
        Intrinsics.checkNotNullParameter(objectText, "objectText");
        long j = this.mNativeNoteTextManager;
        if (j == 0) {
            return false;
        }
        return INSTANCE.Native_reduceFontSizeToFitPage(j, objectText, pageWidth, pageHeight);
    }

    @Override // com.samsung.android.sdk.composer.text.ISpenNoteTextManager
    public boolean removeBodyTextFrom(int pageIndex) {
        SpenWNote spenWNote = this.mDocument;
        if (spenWNote != null) {
            finishComposingText(spenWNote.getBodyText());
        }
        return INSTANCE.Native_removeBodyTextFrom(this.mNativeNoteTextManager, pageIndex);
    }

    @Override // com.samsung.android.sdk.composer.text.ISpenNoteTextManager
    public void removeObjectSpan(@NotNull SpenObjectSpan objectSpan, boolean animationEnabled, boolean commitHistory) {
        Intrinsics.checkNotNullParameter(objectSpan, "objectSpan");
        INSTANCE.Native_removeObjectSpan(this.mNativeNoteTextManager, objectSpan, animationEnabled, commitHistory);
    }

    @Override // com.samsung.android.sdk.composer.text.ISpenNoteTextManager
    public void sendKeyEvent(@NotNull KeyEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        SpenInputManager mInputManager = getMInputManager();
        if (mInputManager != null) {
            mInputManager.sendKeyEvent(event);
        }
    }

    @Override // com.samsung.android.sdk.composer.text.ISpenNoteTextManager
    public void setCursorObstacleRect(@NotNull Rect obstacleRect) {
        Intrinsics.checkNotNullParameter(obstacleRect, "obstacleRect");
        long j = this.mNativeNoteTextManager;
        if (j == 0) {
            return;
        }
        INSTANCE.Native_setCursorObstacleRect(j, obstacleRect.left, obstacleRect.top, obstacleRect.right, obstacleRect.bottom);
    }

    @Override // com.samsung.android.sdk.composer.text.ISpenNoteTextManager
    public void setCursorOnScreen(@NotNull SpenObjectShape objectShape, int pageIndex) {
        Intrinsics.checkNotNullParameter(objectShape, "objectShape");
        long j = this.mNativeNoteTextManager;
        if (j == 0) {
            return;
        }
        INSTANCE.Native_setCursorOnScreen(j, objectShape, pageIndex);
    }

    @Override // com.samsung.android.sdk.composer.text.ISpenNoteTextManager
    public void setCursorSelectionMaxLength(int i) {
        long j = this.mNativeNoteTextManager;
        if (j == 0) {
            return;
        }
        INSTANCE.Native_setCursorSelectionMaxLength(j, i);
    }

    @Override // com.samsung.android.sdk.composer.text.ISpenNoteTextManager
    public void setDocument(@Nullable SpenWNote doc) {
        this.mDocument = doc;
        SpenInputManager mInputManager = getMInputManager();
        if (mInputManager != null) {
            mInputManager.setDocument(doc);
        }
    }

    @Override // com.samsung.android.sdk.composer.text.ISpenNoteTextManager
    public void setFixedContentHeightEnabled(boolean enable) {
        SpenInputManager mInputManager = getMInputManager();
        if (mInputManager != null) {
            mInputManager.setFixedContentHeightEnabled(enable);
        }
    }

    @Override // com.samsung.android.sdk.pen.widget.SpenTextManager, com.samsung.android.sdk.pen.widget.SpenITextManager
    public void setNativeHandle(long handle) {
        super.setNativeHandle(handle);
        this.mNativeNoteTextManager = handle;
    }

    @Override // com.samsung.android.sdk.composer.text.ISpenNoteTextManager
    public void setPreCommitCheckFunction(@Nullable Function3<? super CharSequence, ? super Integer, ? super Integer, Boolean> func) {
        SpenInputManager mInputManager = getMInputManager();
        if (mInputManager != null) {
            mInputManager.setPreCommitCheckFunction(func);
        }
    }

    @Override // com.samsung.android.sdk.composer.text.ISpenNoteTextManager
    public void setPreCommitRegex(@NotNull Regex regex) {
        Intrinsics.checkNotNullParameter(regex, "regex");
        SpenInputManager mInputManager = getMInputManager();
        if (mInputManager != null) {
            mInputManager.setPreCommitRegex(regex);
        }
    }

    @Override // com.samsung.android.sdk.composer.text.ISpenNoteTextManager
    public void setSelectionRange(int min, int max) {
        long j = this.mNativeNoteTextManager;
        if (j == 0) {
            return;
        }
        INSTANCE.Native_setSelectionRange(j, min, max);
    }

    @Override // com.samsung.android.sdk.composer.text.ISpenNoteTextManager
    public void setShowSoftInputDisabled(boolean disable) {
        this.mIsShowSoftInputDisabled = disable;
    }

    @Override // com.samsung.android.sdk.composer.text.ISpenNoteTextManager
    public void setTableCellContent(@NotNull SpenObjectTable objectTable, int rowIndex, int columnIndex, @NotNull SpenObjectTextBox textBox, boolean animationEnabled) {
        Intrinsics.checkNotNullParameter(objectTable, "objectTable");
        Intrinsics.checkNotNullParameter(textBox, "textBox");
        INSTANCE.Native_setTableCellsContent(this.mNativeNoteTextManager, objectTable, CollectionsKt.listOf(new Triple(Integer.valueOf(rowIndex), Integer.valueOf(columnIndex), textBox)), animationEnabled);
    }

    @Override // com.samsung.android.sdk.composer.text.ISpenNoteTextManager
    public void setTableCellsContent(@NotNull SpenObjectTable objectTable, @NotNull List<Triple<Integer, Integer, SpenObjectTextBox>> cellDataList, boolean animationEnabled) {
        Intrinsics.checkNotNullParameter(objectTable, "objectTable");
        Intrinsics.checkNotNullParameter(cellDataList, "cellDataList");
        INSTANCE.Native_setTableCellsContent(this.mNativeNoteTextManager, objectTable, cellDataList, animationEnabled);
    }

    @Override // com.samsung.android.sdk.composer.text.ISpenNoteTextManager
    public void startAiTextFormat() {
        INSTANCE.Native_startAiTextFormat(this.mNativeNoteTextManager, true);
    }

    @Override // com.samsung.android.sdk.composer.text.ISpenNoteTextManager
    public void stopAiTextFormat() {
        INSTANCE.Native_startAiTextFormat(this.mNativeNoteTextManager, false);
    }

    @Override // com.samsung.android.sdk.composer.text.ISpenNoteTextManager
    public void unlockBodyTextPage() {
        INSTANCE.Native_unlockBodyTextPage(this.mNativeNoteTextManager);
    }

    @Override // com.samsung.android.sdk.composer.text.ISpenNoteTextManager
    public void updateBodyObjectSpanPosition(int textIndex, int count) {
        long j = this.mNativeNoteTextManager;
        if (j == 0) {
            return;
        }
        INSTANCE.Native_updateObjectSpanPosition(j, textIndex, count);
    }

    @Override // com.samsung.android.sdk.composer.text.ISpenNoteTextManager
    public void updateBodyTextPage() {
        INSTANCE.Native_updateTextRange(this.mNativeNoteTextManager);
    }

    @Override // com.samsung.android.sdk.composer.text.ISpenNoteTextManager
    public boolean insertBodyTextTo(int pageIndex, @NotNull ArrayList<SpenWPage> pageList, @NotNull SpenObjectTextBox insertObject, int textSizeDelta) {
        Intrinsics.checkNotNullParameter(pageList, "pageList");
        Intrinsics.checkNotNullParameter(insertObject, "insertObject");
        SpenWNote spenWNote = this.mDocument;
        if (spenWNote != null) {
            finishComposingText(spenWNote.getBodyText());
        }
        return INSTANCE.Native_insertBodyTextsTo(this.mNativeNoteTextManager, pageIndex, pageList, insertObject, textSizeDelta);
    }

    @Override // com.samsung.android.sdk.composer.text.ISpenNoteTextManager
    public boolean moveBodyTextTo(@NotNull ArrayList<Integer> srcPageIndexList, int dstPageIndex) {
        Intrinsics.checkNotNullParameter(srcPageIndexList, "srcPageIndexList");
        SpenWNote spenWNote = this.mDocument;
        if (spenWNote != null) {
            finishComposingText(spenWNote.getBodyText());
        }
        return INSTANCE.Native_moveBodyTextsTo(this.mNativeNoteTextManager, srcPageIndexList, dstPageIndex);
    }

    @Override // com.samsung.android.sdk.composer.text.ISpenNoteTextManager
    public boolean removeBodyTextFrom(@Nullable ArrayList<Integer> pageIndexList) {
        SpenWNote spenWNote = this.mDocument;
        if (spenWNote != null) {
            finishComposingText(spenWNote.getBodyText());
        }
        return INSTANCE.Native_removeBodyTextsFrom(this.mNativeNoteTextManager, pageIndexList);
    }

    @Override // com.samsung.android.sdk.composer.text.ISpenNoteTextManager
    public int insertBodyTextTo(int cursorIndex, boolean newParagraph, @NotNull SpenObjectShape insertObject) {
        Intrinsics.checkNotNullParameter(insertObject, "insertObject");
        SpenWNote spenWNote = this.mDocument;
        if (spenWNote != null) {
            finishComposingText(spenWNote.getBodyText());
        }
        return INSTANCE.Native_insertBodyTextToCursor(this.mNativeNoteTextManager, cursorIndex, newParagraph, insertObject);
    }
}
