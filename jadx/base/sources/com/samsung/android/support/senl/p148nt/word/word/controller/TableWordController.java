package com.samsung.android.support.senl.p148nt.word.word.controller;

import android.graphics.Color;
import android.graphics.RectF;
import androidx.annotation.ColorInt;
import androidx.constraintlayout.motion.widget.AbstractC2322a;
import com.samsung.android.sdk.composer.text.SpenBodyTextContext;
import com.samsung.android.sdk.pen.document.SpenObjectBase;
import com.samsung.android.sdk.pen.document.SpenObjectTable;
import com.samsung.android.sdk.pen.document.SpenObjectTextBox;
import com.samsung.android.sdk.pen.worddoc.SpenWPage;
import com.samsung.android.support.senl.p148nt.word.base.OfficeView;
import com.samsung.android.support.senl.p148nt.word.base.controller.ItemController;
import com.samsung.android.support.senl.p148nt.word.common.ConvertUtils;
import com.samsung.android.support.senl.p148nt.word.data.OfficeParams;
import com.samsung.android.support.senl.p148nt.word.word.WordView;
import com.samsung.android.support.senl.p148nt.word.word.data.WordParams;
import com.samsung.android.support.senl.p148nt.word.word.utils.ParagraphAttrToWordHelper;
import java.math.BigInteger;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.math.MathKt;
import kotlin.text.StringsKt__StringsKt;
import org.apache.poi.xwpf.usermodel.IRunBody;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.poi.xwpf.usermodel.XWPFTableCell;
import org.apache.poi.xwpf.usermodel.XWPFTableRow;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTBorder;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTHeight;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRow;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTbl;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblBorders;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblGrid;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblGridCol;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblPr;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblWidth;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTcBorders;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTcMar;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTcPr;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTrPr;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STBorder;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STTblWidth;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(m13885d1 = {"\u0000ª\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001BC\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u000e\u0010\u0007\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\f\u001a\u00020\r¢\u0006\u0004\b\u000e\u0010\u000fJ\b\u0010\u0010\u001a\u00020\u0011H\u0016J\u0010\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u0014H\u0002J\u0014\u0010\u0015\u001a\u00020\u0016*\u00020\u00172\u0006\u0010\u000b\u001a\u00020\u0002H\u0002J\u0018\u0010\u0018\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0019\u001a\u00020\u0016H\u0002J\u001c\u0010\u001a\u001a\u00020\u0011*\u00020\u00162\u000e\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u001d\u0018\u00010\u001cH\u0002J\f\u0010\u001e\u001a\u00020\u0011*\u00020\u001fH\u0002J\u001c\u0010 \u001a\u00020\u0011*\u00020\u001f2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$H\u0002J\f\u0010%\u001a\u00020&*\u00020\u001fH\u0002J\f\u0010'\u001a\u00020&*\u00020\u001fH\u0002J\f\u0010(\u001a\u00020&*\u00020\u001fH\u0002J\f\u0010)\u001a\u00020&*\u00020\u001fH\u0002J\f\u0010*\u001a\u00020&*\u00020\u001fH\u0002J\f\u0010+\u001a\u00020&*\u00020\u001fH\u0002J\u0018\u0010,\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0019\u001a\u00020\u0016H\u0002J\u0018\u0010-\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0019\u001a\u00020\u0016H\u0002J\u0014\u0010.\u001a\u00020\u0011*\u00020/2\u0006\u00100\u001a\u000201H\u0002J\u001c\u00106\u001a\u00020\"2\b\b\u0001\u00107\u001a\u00020\"2\b\b\u0001\u00108\u001a\u00020\"H\u0003J\u0014\u00109\u001a\u00020\u0011*\u00020/2\u0006\u0010:\u001a\u00020;H\u0002J\u0014\u0010.\u001a\u00020\u0011*\u00020<2\u0006\u0010=\u001a\u00020>H\u0002J\u001c\u0010\u001a\u001a\u00020\u0011*\u00020/2\u000e\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u001d\u0018\u00010\u001cH\u0002J\u0018\u0010?\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0019\u001a\u00020\u0016H\u0002J\u0014\u0010@\u001a\u00020\u0011*\u00020\u00172\u0006\u0010\u000b\u001a\u00020\u0002H\u0002J\f\u0010\u001e\u001a\u00020\u0011*\u00020AH\u0002J\u001c\u0010 \u001a\u00020\u0011*\u00020A2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$H\u0002J\u001e\u0010 \u001a\u00020\u0011*\u00020&2\u0006\u0010=\u001a\u00020>2\b\u0010B\u001a\u0004\u0018\u000103H\u0002J&\u0010 \u001a\u00020\u0011*\u00020&2\u0006\u00100\u001a\u0002012\u0006\u0010#\u001a\u00020C2\b\u0010B\u001a\u0004\u0018\u000103H\u0002J\f\u0010%\u001a\u00020&*\u00020AH\u0002J\f\u0010'\u001a\u00020&*\u00020AH\u0002J\f\u0010(\u001a\u00020&*\u00020AH\u0002J\f\u0010)\u001a\u00020&*\u00020AH\u0002J\f\u0010*\u001a\u00020&*\u00020AH\u0002J\f\u0010+\u001a\u00020&*\u00020AH\u0002J\u0014\u0010D\u001a\u00020E*\u00020\u00162\u0006\u0010F\u001a\u00020\"H\u0002J\u0014\u0010G\u001a\u00020/*\u00020E2\u0006\u0010F\u001a\u00020\"H\u0002J\u0014\u0010H\u001a\u00020\u0002*\u00020/2\u0006\u0010F\u001a\u00020\"H\u0002R\u001b\u00102\u001a\u0004\u0018\u000103*\u00020\"8Â\u0002X\u0082\u0004¢\u0006\u0006\u001a\u0004\b4\u00105¨\u0006I"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/word/word/controller/TableWordController;", "Lcom/samsung/android/support/senl/nt/word/base/controller/ItemController;", "Lorg/apache/poi/xwpf/usermodel/XWPFParagraph;", "bodyTextContext", "Lcom/samsung/android/sdk/composer/text/SpenBodyTextContext;", "objectBase", "Lcom/samsung/android/sdk/pen/document/SpenObjectBase;", "view", "Lcom/samsung/android/support/senl/nt/word/base/OfficeView;", "spenWPage", "Lcom/samsung/android/sdk/pen/worddoc/SpenWPage;", "paragraph", "isObjectSpan", "", "<init>", "(Lcom/samsung/android/sdk/composer/text/SpenBodyTextContext;Lcom/samsung/android/sdk/pen/document/SpenObjectBase;Lcom/samsung/android/support/senl/nt/word/base/OfficeView;Lcom/samsung/android/sdk/pen/worddoc/SpenWPage;Lorg/apache/poi/xwpf/usermodel/XWPFParagraph;Z)V", "processItem", "", "paragraphOf", "sTable", "Lcom/samsung/android/sdk/pen/document/SpenObjectTable;", "insertTableBefore", "Lorg/apache/poi/xwpf/usermodel/XWPFTable;", "Lorg/apache/poi/xwpf/usermodel/XWPFDocument;", "copyTable", "wTable", "setBorders", "borders", "", "Lcom/samsung/android/sdk/pen/document/SpenObjectTable$BorderPath;", "clearBorders", "Lorg/openxmlformats/schemas/wordprocessingml/x2006/main/CTTblBorders;", "setBorder", "position", "", "style", "Lcom/samsung/android/sdk/pen/document/SpenObjectTable$BorderStyle;", "getOrCreateLeft", "Lorg/openxmlformats/schemas/wordprocessingml/x2006/main/CTBorder;", "getOrCreateTop", "getOrCreateRight", "getOrCreateBottom", "getOrCreateInsideH", "getOrCreateInsideV", "copyTableRows", "copyTableCells", "setWidth", "Lorg/apache/poi/xwpf/usermodel/XWPFTableCell;", "width", "Ljava/math/BigInteger;", "wColor", "", "getWColor", "(I)Ljava/lang/String;", "argb2rgb", "background", "argb", "setMargin", "margin", "Landroid/graphics/RectF;", "Lorg/openxmlformats/schemas/wordprocessingml/x2006/main/CTTblWidth;", "widthDp", "", "copyTableData", "removeParagraph", "Lorg/openxmlformats/schemas/wordprocessingml/x2006/main/CTTcBorders;", "color", "Lorg/openxmlformats/schemas/wordprocessingml/x2006/main/STBorder$Enum;", "getOrCreateRow", "Lorg/apache/poi/xwpf/usermodel/XWPFTableRow;", "index", "getOrCreateCell", "getOrCreateParagraph", "ntWord_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nTableWordController.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TableWordController.kt\ncom/samsung/android/support/senl/nt/word/word/controller/TableWordController\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,389:1\n208#1,8:391\n208#1,8:399\n208#1,8:410\n1#2:390\n1878#3,3:407\n*S KotlinDebug\n*F\n+ 1 TableWordController.kt\ncom/samsung/android/support/senl/nt/word/word/controller/TableWordController\n*L\n102#1:391,8\n191#1:399,8\n304#1:410,8\n267#1:407,3\n*E\n"})
public final class TableWordController extends ItemController<XWPFParagraph> {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TableWordController(@Nullable SpenBodyTextContext spenBodyTextContext, @NotNull SpenObjectBase objectBase, @NotNull OfficeView<?, ?> view, @NotNull SpenWPage spenWPage, @Nullable XWPFParagraph xWPFParagraph, boolean z) {
        super(spenBodyTextContext, objectBase, view, spenWPage, xWPFParagraph, z);
        Intrinsics.checkNotNullParameter(objectBase, "objectBase");
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(spenWPage, "spenWPage");
    }

    @ColorInt
    private final int argb2rgb(@ColorInt int background, @ColorInt int argb) {
        float fAlpha = Color.alpha(argb) / 255.0f;
        float f = 1.0f - fAlpha;
        return Color.rgb(MathKt.roundToInt((Color.red(argb) * fAlpha) + (Color.red(background) * f)), MathKt.roundToInt((Color.green(argb) * fAlpha) + (Color.green(background) * f)), MathKt.roundToInt((fAlpha * Color.blue(argb)) + (f * Color.blue(background))));
    }

    private final void clearBorders(CTTblBorders cTTblBorders) {
        CTBorder orCreateLeft = getOrCreateLeft(cTTblBorders);
        BigInteger ZERO = BigInteger.ZERO;
        Intrinsics.checkNotNullExpressionValue(ZERO, "ZERO");
        STBorder.Enum NONE = STBorder.NONE;
        Intrinsics.checkNotNullExpressionValue(NONE, "NONE");
        setBorder(orCreateLeft, ZERO, NONE, null);
        CTBorder orCreateTop = getOrCreateTop(cTTblBorders);
        Intrinsics.checkNotNullExpressionValue(ZERO, "ZERO");
        Intrinsics.checkNotNullExpressionValue(NONE, "NONE");
        setBorder(orCreateTop, ZERO, NONE, null);
        CTBorder orCreateRight = getOrCreateRight(cTTblBorders);
        Intrinsics.checkNotNullExpressionValue(ZERO, "ZERO");
        Intrinsics.checkNotNullExpressionValue(NONE, "NONE");
        setBorder(orCreateRight, ZERO, NONE, null);
        CTBorder orCreateBottom = getOrCreateBottom(cTTblBorders);
        Intrinsics.checkNotNullExpressionValue(ZERO, "ZERO");
        Intrinsics.checkNotNullExpressionValue(NONE, "NONE");
        setBorder(orCreateBottom, ZERO, NONE, null);
        CTBorder orCreateInsideH = getOrCreateInsideH(cTTblBorders);
        Intrinsics.checkNotNullExpressionValue(ZERO, "ZERO");
        Intrinsics.checkNotNullExpressionValue(NONE, "NONE");
        setBorder(orCreateInsideH, ZERO, NONE, null);
        CTBorder orCreateInsideV = getOrCreateInsideV(cTTblBorders);
        Intrinsics.checkNotNullExpressionValue(ZERO, "ZERO");
        Intrinsics.checkNotNullExpressionValue(NONE, "NONE");
        setBorder(orCreateInsideV, ZERO, NONE, null);
    }

    private final void copyTable(SpenObjectTable sTable, XWPFTable wTable) {
        setBorders(wTable, sTable.getBorderPath());
        copyTableCells(sTable, wTable);
        copyTableData(sTable, wTable);
    }

    private final void copyTableCells(SpenObjectTable sTable, XWPFTable wTable) {
        CTTblGridCol cTTblGridColAddNewGridCol;
        int columnsCount = sTable.getColumnsCount();
        BigInteger[] bigIntegerArr = new BigInteger[columnsCount];
        for (int i = 0; i < columnsCount; i++) {
            bigIntegerArr[i] = BigInteger.valueOf(MathKt.roundToLong(ConvertUtils.INSTANCE.dpToDxa(sTable.getColumnWidth(i))));
        }
        CTTbl cTTbl = wTable.getCTTbl();
        CTTblGrid tblGrid = cTTbl.getTblGrid();
        if (tblGrid == null) {
            tblGrid = cTTbl.addNewTblGrid();
        }
        int columnsCount2 = sTable.getColumnsCount();
        for (int i2 = 0; i2 < columnsCount2; i2++) {
            try {
                cTTblGridColAddNewGridCol = tblGrid.getGridColArray(i2);
            } catch (Exception unused) {
                cTTblGridColAddNewGridCol = tblGrid.addNewGridCol();
            }
            cTTblGridColAddNewGridCol.setW(bigIntegerArr[i2]);
        }
        int rowsCount = sTable.getRowsCount();
        for (int i4 = 0; i4 < rowsCount; i4++) {
            XWPFTableRow orCreateRow = getOrCreateRow(wTable, i4);
            int columnsCount3 = sTable.getColumnsCount();
            for (int i5 = 0; i5 < columnsCount3; i5++) {
                XWPFTableCell orCreateCell = getOrCreateCell(orCreateRow, i5);
                BigInteger bigInteger = bigIntegerArr[i5];
                Intrinsics.checkNotNullExpressionValue(bigInteger, "get(...)");
                setWidth(orCreateCell, bigInteger);
                int cellBackgroundColor = sTable.getCellBackgroundColor(i4, i5);
                int iAlpha = Color.alpha(cellBackgroundColor);
                orCreateCell.setColor(iAlpha != 0 ? iAlpha != 255 ? AbstractC2322a.m1624n("%06X", new Object[]{Integer.valueOf(argb2rgb(-1, cellBackgroundColor) & 16777215)}, 1, "format(...)") : AbstractC2322a.m1624n("%06X", new Object[]{Integer.valueOf(cellBackgroundColor & 16777215)}, 1, "format(...)") : null);
                setMargin(orCreateCell, sTable.getMargin(i4, i5));
                setBorders(orCreateCell, sTable.getCellBorderPath(i4, i5));
            }
        }
    }

    private final void copyTableData(SpenObjectTable sTable, XWPFTable wTable) {
        OfficeParams officeParams = this.mView.mDocParams;
        Intrinsics.checkNotNull(officeParams, "null cannot be cast to non-null type com.samsung.android.support.senl.nt.word.word.data.WordParams");
        WordParams wordParams = (WordParams) officeParams;
        int rowsCount = sTable.getRowsCount();
        for (int i = 0; i < rowsCount; i++) {
            XWPFTableRow orCreateRow = getOrCreateRow(wTable, i);
            int columnsCount = sTable.getColumnsCount();
            for (int i2 = 0; i2 < columnsCount; i2++) {
                SpenObjectTextBox contentObject = sTable.getContentObject(i, i2);
                String text = contentObject.getText();
                if (text != null) {
                    XWPFTableCell orCreateCell = getOrCreateCell(orCreateRow, i2);
                    ParagraphAttrToWordHelper paragraphAttrToWordHelper = new ParagraphAttrToWordHelper(wordParams, contentObject, this.mView);
                    int i4 = 0;
                    int i5 = 0;
                    for (Object obj : StringsKt__StringsKt.split$default(text, new String[]{"\n"}, false, 0, 6, (Object) null)) {
                        int i6 = i4 + 1;
                        if (i4 < 0) {
                            CollectionsKt.throwIndexOverflow();
                        }
                        int length = ((String) obj).length() + i5;
                        ParagraphAttrToWordHelper paragraphAttrToWordHelper2 = paragraphAttrToWordHelper;
                        new BodyTextWordController(this.mBodyTextContext, contentObject, this.mView, this.mSpenWPage, getOrCreateParagraph(orCreateCell, i4), i4, i5, length, paragraphAttrToWordHelper2, true).processItem();
                        i5 = length + 1;
                        paragraphAttrToWordHelper = paragraphAttrToWordHelper2;
                        i4 = i6;
                        orCreateCell = orCreateCell;
                    }
                }
            }
        }
    }

    private final void copyTableRows(SpenObjectTable sTable, XWPFTable wTable) {
        CTHeight cTHeightAddNewTrHeight;
        int rowsCount = sTable.getRowsCount();
        for (int i = 0; i < rowsCount; i++) {
            BigInteger bigIntegerValueOf = BigInteger.valueOf(MathKt.roundToLong(ConvertUtils.INSTANCE.dpToDxa(sTable.getRowHeight(i))));
            CTRow ctRow = getOrCreateRow(wTable, i).getCtRow();
            CTTrPr trPr = ctRow.getTrPr();
            if (trPr == null) {
                trPr = ctRow.addNewTrPr();
            }
            try {
                cTHeightAddNewTrHeight = trPr.getTrHeightArray(i);
            } catch (Exception unused) {
                cTHeightAddNewTrHeight = trPr.addNewTrHeight();
            }
            cTHeightAddNewTrHeight.setVal(bigIntegerValueOf);
        }
    }

    private final CTBorder getOrCreateBottom(CTTblBorders cTTblBorders) {
        CTBorder bottom = cTTblBorders.getBottom();
        if (bottom != null) {
            return bottom;
        }
        CTBorder cTBorderAddNewBottom = cTTblBorders.addNewBottom();
        Intrinsics.checkNotNullExpressionValue(cTBorderAddNewBottom, "addNewBottom(...)");
        return cTBorderAddNewBottom;
    }

    private final XWPFTableCell getOrCreateCell(XWPFTableRow xWPFTableRow, int i) {
        XWPFTableCell cell = xWPFTableRow.getCell(i);
        if (cell != null) {
            return cell;
        }
        XWPFTableCell xWPFTableCellCreateCell = xWPFTableRow.createCell();
        Intrinsics.checkNotNullExpressionValue(xWPFTableCellCreateCell, "createCell(...)");
        return xWPFTableCellCreateCell;
    }

    private final CTBorder getOrCreateInsideH(CTTblBorders cTTblBorders) {
        CTBorder insideH = cTTblBorders.getInsideH();
        if (insideH != null) {
            return insideH;
        }
        CTBorder cTBorderAddNewInsideH = cTTblBorders.addNewInsideH();
        Intrinsics.checkNotNullExpressionValue(cTBorderAddNewInsideH, "addNewInsideH(...)");
        return cTBorderAddNewInsideH;
    }

    private final CTBorder getOrCreateInsideV(CTTblBorders cTTblBorders) {
        CTBorder insideV = cTTblBorders.getInsideV();
        if (insideV != null) {
            return insideV;
        }
        CTBorder cTBorderAddNewInsideV = cTTblBorders.addNewInsideV();
        Intrinsics.checkNotNullExpressionValue(cTBorderAddNewInsideV, "addNewInsideV(...)");
        return cTBorderAddNewInsideV;
    }

    private final CTBorder getOrCreateLeft(CTTblBorders cTTblBorders) {
        CTBorder left = cTTblBorders.getLeft();
        if (left != null) {
            return left;
        }
        CTBorder cTBorderAddNewLeft = cTTblBorders.addNewLeft();
        Intrinsics.checkNotNullExpressionValue(cTBorderAddNewLeft, "addNewLeft(...)");
        return cTBorderAddNewLeft;
    }

    private final XWPFParagraph getOrCreateParagraph(XWPFTableCell xWPFTableCell, int i) {
        XWPFParagraph paragraphArray = xWPFTableCell.getParagraphArray(i);
        if (paragraphArray == null) {
            paragraphArray = xWPFTableCell.addParagraph();
        }
        paragraphArray.setIndentationLeft(0);
        paragraphArray.setIndentationRight(0);
        paragraphArray.setSpacingAfter(0);
        paragraphArray.setSpacingBefore(0);
        paragraphArray.setSpacingBetween(1.0d);
        Intrinsics.checkNotNull(paragraphArray);
        return paragraphArray;
    }

    private final CTBorder getOrCreateRight(CTTblBorders cTTblBorders) {
        CTBorder right = cTTblBorders.getRight();
        if (right != null) {
            return right;
        }
        CTBorder cTBorderAddNewRight = cTTblBorders.addNewRight();
        Intrinsics.checkNotNullExpressionValue(cTBorderAddNewRight, "addNewRight(...)");
        return cTBorderAddNewRight;
    }

    private final XWPFTableRow getOrCreateRow(XWPFTable xWPFTable, int i) {
        XWPFTableRow row = xWPFTable.getRow(i);
        if (row != null) {
            return row;
        }
        XWPFTableRow xWPFTableRowCreateRow = xWPFTable.createRow();
        Intrinsics.checkNotNullExpressionValue(xWPFTableRowCreateRow, "createRow(...)");
        return xWPFTableRowCreateRow;
    }

    private final CTBorder getOrCreateTop(CTTblBorders cTTblBorders) {
        CTBorder top = cTTblBorders.getTop();
        if (top != null) {
            return top;
        }
        CTBorder cTBorderAddNewTop = cTTblBorders.addNewTop();
        Intrinsics.checkNotNullExpressionValue(cTBorderAddNewTop, "addNewTop(...)");
        return cTBorderAddNewTop;
    }

    private final String getWColor(@ColorInt int i) {
        int iAlpha = Color.alpha(i);
        if (iAlpha != 0) {
            return iAlpha != 255 ? AbstractC2322a.m1624n("%06X", new Object[]{Integer.valueOf(argb2rgb(-1, i) & 16777215)}, 1, "format(...)") : AbstractC2322a.m1624n("%06X", new Object[]{Integer.valueOf(i & 16777215)}, 1, "format(...)");
        }
        return null;
    }

    private final XWPFTable insertTableBefore(XWPFDocument xWPFDocument, XWPFParagraph xWPFParagraph) {
        XWPFTable xWPFTableInsertNewTbl = xWPFDocument.insertNewTbl(xWPFParagraph.getCTP().newCursor());
        Intrinsics.checkNotNullExpressionValue(xWPFTableInsertNewTbl, "insertNewTbl(...)");
        return xWPFTableInsertNewTbl;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final XWPFParagraph paragraphOf(SpenObjectTable sTable) {
        if (!this.isObjectSpan) {
            OfficeElement officeelement = this.mElement;
            Intrinsics.checkNotNull(officeelement);
            return (XWPFParagraph) officeelement;
        }
        XWPFRun inlineImageRun = WordView.INSTANCE.getInlineImageRun(this.mView.objectSpanOfPage.indexOf(sTable));
        if (inlineImageRun == null) {
            OfficeElement officeelement2 = this.mElement;
            Intrinsics.checkNotNull(officeelement2);
            return (XWPFParagraph) officeelement2;
        }
        IRunBody parent = inlineImageRun.getParent();
        Intrinsics.checkNotNull(parent, "null cannot be cast to non-null type org.apache.poi.xwpf.usermodel.XWPFParagraph");
        return (XWPFParagraph) parent;
    }

    private final void removeParagraph(XWPFDocument xWPFDocument, XWPFParagraph xWPFParagraph) {
        xWPFDocument.removeBodyElement(xWPFDocument.getBodyElements().indexOf(xWPFParagraph));
    }

    private final void setBorder(CTTblBorders cTTblBorders, int i, SpenObjectTable.BorderStyle borderStyle) {
        float width = borderStyle.getWidth();
        int color = borderStyle.getColor();
        int iAlpha = Color.alpha(color);
        String strM1624n = iAlpha != 0 ? iAlpha != 255 ? AbstractC2322a.m1624n("%06X", new Object[]{Integer.valueOf(argb2rgb(-1, color) & 16777215)}, 1, "format(...)") : AbstractC2322a.m1624n("%06X", new Object[]{Integer.valueOf(color & 16777215)}, 1, "format(...)") : null;
        SpenObjectTable.Companion companion = SpenObjectTable.INSTANCE;
        if (i == companion.getBORDER_LEFT()) {
            setBorder(getOrCreateLeft(cTTblBorders), width, strM1624n);
            return;
        }
        if (i == companion.getBORDER_TOP()) {
            setBorder(getOrCreateTop(cTTblBorders), width, strM1624n);
            return;
        }
        if (i == companion.getBORDER_RIGHT()) {
            setBorder(getOrCreateRight(cTTblBorders), width, strM1624n);
            return;
        }
        if (i == companion.getBORDER_BOTTOM()) {
            setBorder(getOrCreateBottom(cTTblBorders), width, strM1624n);
        } else if (i == companion.getBORDER_ALL()) {
            setBorder(getOrCreateLeft(cTTblBorders), width, strM1624n);
            setBorder(getOrCreateTop(cTTblBorders), width, strM1624n);
            setBorder(getOrCreateRight(cTTblBorders), width, strM1624n);
            setBorder(getOrCreateBottom(cTTblBorders), width, strM1624n);
        }
    }

    private final void setBorders(XWPFTable xWPFTable, List<SpenObjectTable.BorderPath> list) {
        CTTbl cTTbl = xWPFTable.getCTTbl();
        CTTblPr tblPr = cTTbl.getTblPr();
        if (tblPr == null) {
            tblPr = cTTbl.addNewTblPr();
        }
        CTTblBorders tblBorders = tblPr.getTblBorders();
        if (tblBorders == null) {
            tblBorders = tblPr.addNewTblBorders();
        }
        Intrinsics.checkNotNull(tblBorders);
        clearBorders(tblBorders);
        if (list == null) {
            return;
        }
        for (SpenObjectTable.BorderPath borderPath : list) {
            setBorder(tblBorders, borderPath.getPosition(), borderPath.getStyle());
        }
    }

    private final void setMargin(XWPFTableCell xWPFTableCell, RectF rectF) {
        CTTc cTTc = xWPFTableCell.getCTTc();
        CTTcPr tcPr = cTTc.getTcPr();
        if (tcPr == null) {
            tcPr = cTTc.addNewTcPr();
        }
        CTTcMar tcMar = tcPr.getTcMar();
        if (tcMar == null) {
            tcMar = tcPr.addNewTcMar();
        }
        CTTblWidth left = tcMar.getLeft();
        if (left == null) {
            left = tcMar.addNewLeft();
        }
        Intrinsics.checkNotNull(left);
        setWidth(left, rectF.left);
        CTTblWidth top = tcMar.getTop();
        if (top == null) {
            top = tcMar.addNewTop();
        }
        Intrinsics.checkNotNull(top);
        setWidth(top, rectF.top);
        CTTblWidth right = tcMar.getRight();
        if (right == null) {
            right = tcMar.addNewRight();
        }
        Intrinsics.checkNotNull(right);
        setWidth(right, rectF.right);
        CTTblWidth bottom = tcMar.getBottom();
        if (bottom == null) {
            bottom = tcMar.addNewBottom();
        }
        Intrinsics.checkNotNull(bottom);
        setWidth(bottom, rectF.bottom);
    }

    private final void setWidth(XWPFTableCell xWPFTableCell, BigInteger bigInteger) {
        CTTc cTTc = xWPFTableCell.getCTTc();
        CTTcPr tcPr = cTTc.getTcPr();
        if (tcPr == null) {
            tcPr = cTTc.addNewTcPr();
        }
        CTTblWidth tcW = tcPr.getTcW();
        if (tcW == null) {
            tcW = tcPr.addNewTcW();
        }
        tcW.setW(bigInteger);
        tcW.setType(STTblWidth.DXA);
    }

    @Override // com.samsung.android.support.senl.p148nt.word.base.controller.ItemController
    public void processItem() {
        SpenObjectBase spenObjectBase = this.mObject;
        Intrinsics.checkNotNull(spenObjectBase, "null cannot be cast to non-null type com.samsung.android.sdk.pen.document.SpenObjectTable");
        SpenObjectTable spenObjectTable = (SpenObjectTable) spenObjectBase;
        XWPFParagraph xWPFParagraphParagraphOf = paragraphOf(spenObjectTable);
        XWPFDocument document = xWPFParagraphParagraphOf.getDocument();
        Intrinsics.checkNotNull(document);
        copyTable(spenObjectTable, insertTableBefore(document, xWPFParagraphParagraphOf));
        removeParagraph(document, xWPFParagraphParagraphOf);
    }

    private final CTBorder getOrCreateBottom(CTTcBorders cTTcBorders) {
        CTBorder bottom = cTTcBorders.getBottom();
        if (bottom != null) {
            return bottom;
        }
        CTBorder cTBorderAddNewBottom = cTTcBorders.addNewBottom();
        Intrinsics.checkNotNullExpressionValue(cTBorderAddNewBottom, "addNewBottom(...)");
        return cTBorderAddNewBottom;
    }

    private final CTBorder getOrCreateInsideH(CTTcBorders cTTcBorders) {
        CTBorder insideH = cTTcBorders.getInsideH();
        if (insideH != null) {
            return insideH;
        }
        CTBorder cTBorderAddNewInsideH = cTTcBorders.addNewInsideH();
        Intrinsics.checkNotNullExpressionValue(cTBorderAddNewInsideH, "addNewInsideH(...)");
        return cTBorderAddNewInsideH;
    }

    private final CTBorder getOrCreateInsideV(CTTcBorders cTTcBorders) {
        CTBorder insideV = cTTcBorders.getInsideV();
        if (insideV != null) {
            return insideV;
        }
        CTBorder cTBorderAddNewInsideV = cTTcBorders.addNewInsideV();
        Intrinsics.checkNotNullExpressionValue(cTBorderAddNewInsideV, "addNewInsideV(...)");
        return cTBorderAddNewInsideV;
    }

    private final CTBorder getOrCreateLeft(CTTcBorders cTTcBorders) {
        CTBorder left = cTTcBorders.getLeft();
        if (left != null) {
            return left;
        }
        CTBorder cTBorderAddNewLeft = cTTcBorders.addNewLeft();
        Intrinsics.checkNotNullExpressionValue(cTBorderAddNewLeft, "addNewLeft(...)");
        return cTBorderAddNewLeft;
    }

    private final CTBorder getOrCreateRight(CTTcBorders cTTcBorders) {
        CTBorder right = cTTcBorders.getRight();
        if (right != null) {
            return right;
        }
        CTBorder cTBorderAddNewRight = cTTcBorders.addNewRight();
        Intrinsics.checkNotNullExpressionValue(cTBorderAddNewRight, "addNewRight(...)");
        return cTBorderAddNewRight;
    }

    private final CTBorder getOrCreateTop(CTTcBorders cTTcBorders) {
        CTBorder top = cTTcBorders.getTop();
        if (top != null) {
            return top;
        }
        CTBorder cTBorderAddNewTop = cTTcBorders.addNewTop();
        Intrinsics.checkNotNullExpressionValue(cTBorderAddNewTop, "addNewTop(...)");
        return cTBorderAddNewTop;
    }

    private final void setWidth(CTTblWidth cTTblWidth, float f) {
        cTTblWidth.setW(BigInteger.valueOf(MathKt.roundToLong(ConvertUtils.INSTANCE.dpToDxa(f))));
        cTTblWidth.setType(STTblWidth.DXA);
    }

    private final void setBorders(XWPFTableCell xWPFTableCell, List<SpenObjectTable.BorderPath> list) {
        CTTc cTTc = xWPFTableCell.getCTTc();
        CTTcPr tcPr = cTTc.getTcPr();
        if (tcPr == null) {
            tcPr = cTTc.addNewTcPr();
        }
        CTTcBorders tcBorders = tcPr.getTcBorders();
        if (tcBorders == null) {
            tcBorders = tcPr.addNewTcBorders();
        }
        Intrinsics.checkNotNull(tcBorders);
        clearBorders(tcBorders);
        if (list == null) {
            return;
        }
        for (SpenObjectTable.BorderPath borderPath : list) {
            setBorder(tcBorders, borderPath.getPosition(), borderPath.getStyle());
        }
    }

    private final void clearBorders(CTTcBorders cTTcBorders) {
        CTBorder orCreateLeft = getOrCreateLeft(cTTcBorders);
        BigInteger ZERO = BigInteger.ZERO;
        Intrinsics.checkNotNullExpressionValue(ZERO, "ZERO");
        STBorder.Enum NONE = STBorder.NONE;
        Intrinsics.checkNotNullExpressionValue(NONE, "NONE");
        setBorder(orCreateLeft, ZERO, NONE, null);
        CTBorder orCreateTop = getOrCreateTop(cTTcBorders);
        Intrinsics.checkNotNullExpressionValue(ZERO, "ZERO");
        Intrinsics.checkNotNullExpressionValue(NONE, "NONE");
        setBorder(orCreateTop, ZERO, NONE, null);
        CTBorder orCreateRight = getOrCreateRight(cTTcBorders);
        Intrinsics.checkNotNullExpressionValue(ZERO, "ZERO");
        Intrinsics.checkNotNullExpressionValue(NONE, "NONE");
        setBorder(orCreateRight, ZERO, NONE, null);
        CTBorder orCreateBottom = getOrCreateBottom(cTTcBorders);
        Intrinsics.checkNotNullExpressionValue(ZERO, "ZERO");
        Intrinsics.checkNotNullExpressionValue(NONE, "NONE");
        setBorder(orCreateBottom, ZERO, NONE, null);
        CTBorder orCreateInsideH = getOrCreateInsideH(cTTcBorders);
        Intrinsics.checkNotNullExpressionValue(ZERO, "ZERO");
        Intrinsics.checkNotNullExpressionValue(NONE, "NONE");
        setBorder(orCreateInsideH, ZERO, NONE, null);
        CTBorder orCreateInsideV = getOrCreateInsideV(cTTcBorders);
        Intrinsics.checkNotNullExpressionValue(ZERO, "ZERO");
        Intrinsics.checkNotNullExpressionValue(NONE, "NONE");
        setBorder(orCreateInsideV, ZERO, NONE, null);
    }

    private final void setBorder(CTTcBorders cTTcBorders, int i, SpenObjectTable.BorderStyle borderStyle) {
        String strM1624n;
        float width = borderStyle.getWidth();
        int color = borderStyle.getColor();
        int iAlpha = Color.alpha(color);
        if (iAlpha == 0) {
            strM1624n = null;
        } else if (iAlpha != 255) {
            strM1624n = AbstractC2322a.m1624n("%06X", new Object[]{Integer.valueOf(argb2rgb(-1, color) & 16777215)}, 1, "format(...)");
        } else {
            strM1624n = AbstractC2322a.m1624n("%06X", new Object[]{Integer.valueOf(color & 16777215)}, 1, "format(...)");
        }
        SpenObjectTable.Companion companion = SpenObjectTable.INSTANCE;
        if (i == companion.getBORDER_LEFT()) {
            setBorder(getOrCreateLeft(cTTcBorders), width, strM1624n);
            return;
        }
        if (i == companion.getBORDER_TOP()) {
            setBorder(getOrCreateTop(cTTcBorders), width, strM1624n);
            return;
        }
        if (i == companion.getBORDER_RIGHT()) {
            setBorder(getOrCreateRight(cTTcBorders), width, strM1624n);
            return;
        }
        if (i == companion.getBORDER_BOTTOM()) {
            setBorder(getOrCreateBottom(cTTcBorders), width, strM1624n);
        } else if (i == companion.getBORDER_ALL()) {
            setBorder(getOrCreateLeft(cTTcBorders), width, strM1624n);
            setBorder(getOrCreateTop(cTTcBorders), width, strM1624n);
            setBorder(getOrCreateRight(cTTcBorders), width, strM1624n);
            setBorder(getOrCreateBottom(cTTcBorders), width, strM1624n);
        }
    }

    private final void setBorder(CTBorder cTBorder, float f, String str) {
        if (f > 0.0f && str != null) {
            BigInteger bigIntegerValueOf = BigInteger.valueOf(MathKt.roundToLong(ConvertUtils.INSTANCE.dpToPt(f) * 8.0d));
            Intrinsics.checkNotNull(bigIntegerValueOf);
            STBorder.Enum SINGLE = STBorder.SINGLE;
            Intrinsics.checkNotNullExpressionValue(SINGLE, "SINGLE");
            setBorder(cTBorder, bigIntegerValueOf, SINGLE, str);
            return;
        }
        BigInteger ZERO = BigInteger.ZERO;
        Intrinsics.checkNotNullExpressionValue(ZERO, "ZERO");
        STBorder.Enum NONE = STBorder.NONE;
        Intrinsics.checkNotNullExpressionValue(NONE, "NONE");
        setBorder(cTBorder, ZERO, NONE, null);
    }

    private final void setBorder(CTBorder cTBorder, BigInteger bigInteger, STBorder.Enum r32, String str) {
        cTBorder.setSz(bigInteger);
        cTBorder.setVal(r32);
        cTBorder.setColor(str);
    }
}
