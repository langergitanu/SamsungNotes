package com.samsung.android.support.senl.p148nt.word.powerpoint.controller;

import androidx.glance.AbstractC2821a;
import com.samsung.android.sdk.composer.text.SpenBodyTextContext;
import com.samsung.android.sdk.pen.document.SpenObjectBase;
import com.samsung.android.sdk.pen.document.SpenObjectTable;
import com.samsung.android.sdk.pen.document.SpenObjectTextBox;
import com.samsung.android.sdk.pen.worddoc.SpenWPage;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.presenter.somrecognize.common.Constant;
import com.samsung.android.support.senl.p148nt.word.base.OfficeView;
import com.samsung.android.support.senl.p148nt.word.base.controller.ItemController;
import com.samsung.android.support.senl.p148nt.word.data.OfficeParams;
import com.samsung.android.support.senl.p148nt.word.powerpoint.data.PowerPointParams;
import com.samsung.android.support.senl.p148nt.word.powerpoint.utils.ParagraphAttrToPPTHelper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import kotlin.Metadata;
import kotlin.collections.AbstractC12991c;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.apache.poi.java.awt.Color;
import org.apache.poi.java.awt.geom.Rectangle2D;
import org.apache.poi.p226sl.usermodel.TableCell;
import org.apache.poi.xslf.usermodel.XSLFSlide;
import org.apache.poi.xslf.usermodel.XSLFTable;
import org.apache.poi.xslf.usermodel.XSLFTableCell;
import org.apache.poi.xslf.usermodel.XSLFTableRow;
import org.apache.poi.xslf.usermodel.XSLFTextParagraph;
import org.apache.poi.xslf.usermodel.XSLFTextRun;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(m13885d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001B;\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u000e\u0010\u0007\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\f\u0010\rJ\b\u0010\u000e\u001a\u00020\u000fH\u0016Jb\u0010\u0010\u001a\u00020\u000f2\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0013\u001a\u00020\u00142\"\u0010\u0015\u001a\u001e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00170\u0016j\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u0017`\u00182\"\u0010\u0019\u001a\u001e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u001a0\u0016j\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u001a`\u0018H\u0002J@\u0010\u001b\u001a\u001e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00170\u0016j\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u0017`\u00182\u001a\u0010\u001c\u001a\u0016\u0012\u0004\u0012\u00020\u001e\u0018\u00010\u001dj\n\u0012\u0004\u0012\u00020\u001e\u0018\u0001`\u001fH\u0002J\u001e\u0010 \u001a\u00020\u000f*\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0017H\u0002J\u0010\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u001aH\u0002¨\u0006$"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/word/powerpoint/controller/TablePPTController;", "Lcom/samsung/android/support/senl/nt/word/base/controller/ItemController;", "Lorg/apache/poi/xslf/usermodel/XSLFSlide;", "bodyTextContext", "Lcom/samsung/android/sdk/composer/text/SpenBodyTextContext;", "objectBase", "Lcom/samsung/android/sdk/pen/document/SpenObjectBase;", "view", "Lcom/samsung/android/support/senl/nt/word/base/OfficeView;", "spenWPage", "Lcom/samsung/android/sdk/pen/worddoc/SpenWPage;", "slide", "<init>", "(Lcom/samsung/android/sdk/composer/text/SpenBodyTextContext;Lcom/samsung/android/sdk/pen/document/SpenObjectBase;Lcom/samsung/android/support/senl/nt/word/base/OfficeView;Lcom/samsung/android/sdk/pen/worddoc/SpenWPage;Lorg/apache/poi/xslf/usermodel/XSLFSlide;)V", "processItem", "", "setBorderTable", "tableCell", "Lorg/apache/poi/xslf/usermodel/XSLFTableCell;", "position", "Lorg/apache/poi/sl/usermodel/TableCell$BorderEdge;", "style", "Ljava/util/HashMap;", "Lcom/samsung/android/sdk/pen/document/SpenObjectTable$BorderStyle;", "Lkotlin/collections/HashMap;", "checkBorders", "", "reOrganizationTableBorderPath", "borderPaths", "Ljava/util/ArrayList;", "Lcom/samsung/android/sdk/pen/document/SpenObjectTable$BorderPath;", "Lkotlin/collections/ArrayList;", "setBorderFormat", "intToColor", "Lorg/apache/poi/java/awt/Color;", "color", "ntWord_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nTablePPTController.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TablePPTController.kt\ncom/samsung/android/support/senl/nt/word/powerpoint/controller/TablePPTController\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 ArraysJVM.kt\nkotlin/collections/ArraysKt__ArraysJVMKt\n*L\n1#1,178:1\n739#2,9:179\n37#3:188\n36#3,3:189\n*S KotlinDebug\n*F\n+ 1 TablePPTController.kt\ncom/samsung/android/support/senl/nt/word/powerpoint/controller/TablePPTController\n*L\n54#1:179,9\n54#1:188\n54#1:189,3\n*E\n"})
public final class TablePPTController extends ItemController<XSLFSlide> {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TablePPTController(@Nullable SpenBodyTextContext spenBodyTextContext, @NotNull SpenObjectBase objectBase, @NotNull OfficeView<?, ?> view, @NotNull SpenWPage spenWPage, @Nullable XSLFSlide xSLFSlide) {
        super(spenBodyTextContext, objectBase, view, spenWPage, xSLFSlide, true);
        Intrinsics.checkNotNullParameter(objectBase, "objectBase");
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(spenWPage, "spenWPage");
    }

    private final Color intToColor(int color) {
        return new Color((color >> 16) & 255, (color >> 8) & 255, color & 255, (color >> 24) & 255);
    }

    private final HashMap<TableCell.BorderEdge, SpenObjectTable.BorderStyle> reOrganizationTableBorderPath(ArrayList<SpenObjectTable.BorderPath> borderPaths) {
        HashMap<TableCell.BorderEdge, SpenObjectTable.BorderStyle> map = new HashMap<>();
        if (borderPaths != null && !borderPaths.isEmpty()) {
            Iterator<SpenObjectTable.BorderPath> it = borderPaths.iterator();
            Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
            while (it.hasNext()) {
                SpenObjectTable.BorderPath next = it.next();
                Intrinsics.checkNotNullExpressionValue(next, "next(...)");
                SpenObjectTable.BorderPath borderPath = next;
                int position = borderPath.getPosition();
                SpenObjectTable.Companion companion = SpenObjectTable.INSTANCE;
                if (position == companion.getBORDER_LEFT()) {
                    map.put(TableCell.BorderEdge.left, borderPath.getStyle());
                } else if (position == companion.getBORDER_TOP()) {
                    map.put(TableCell.BorderEdge.top, borderPath.getStyle());
                } else if (position == companion.getBORDER_BOTTOM()) {
                    map.put(TableCell.BorderEdge.bottom, borderPath.getStyle());
                } else if (position == companion.getBORDER_RIGHT()) {
                    map.put(TableCell.BorderEdge.right, borderPath.getStyle());
                } else if (position == companion.getBORDER_ALL()) {
                    map.put(TableCell.BorderEdge.left, borderPath.getStyle());
                    map.put(TableCell.BorderEdge.top, borderPath.getStyle());
                    map.put(TableCell.BorderEdge.right, borderPath.getStyle());
                    map.put(TableCell.BorderEdge.bottom, borderPath.getStyle());
                }
            }
        }
        return map;
    }

    private final void setBorderFormat(XSLFTableCell xSLFTableCell, TableCell.BorderEdge borderEdge, SpenObjectTable.BorderStyle borderStyle) {
        if (borderStyle != null) {
            xSLFTableCell.setBorderColor(borderEdge, intToColor(borderStyle.getColor()));
            xSLFTableCell.setBorderWidth(borderEdge, borderStyle.getWidth());
        }
    }

    private final void setBorderTable(XSLFTableCell tableCell, TableCell.BorderEdge position, HashMap<TableCell.BorderEdge, SpenObjectTable.BorderStyle> style, HashMap<TableCell.BorderEdge, Integer> checkBorders) {
        SpenObjectTable.BorderStyle borderStyle = style.get(position);
        if (borderStyle == null || borderStyle.getWidth() == 0.0f || borderStyle.getColor() == 0) {
            return;
        }
        if (tableCell != null) {
            setBorderFormat(tableCell, position, borderStyle);
        }
        checkBorders.put(position, 1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:100:0x01e5  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x0212  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x0219 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:118:0x022f  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x0236 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:124:0x024b  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x024d  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x0256  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x0261 A[LOOP:1: B:26:0x0084->B:130:0x0261, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:137:0x026e A[EDGE_INSN: B:137:0x026e->B:131:0x026e BREAK  A[LOOP:1: B:26:0x0084->B:130:0x0261], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00cc  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00d8  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00de  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00e3  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00e6  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00f5  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00fb  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0169  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x016e  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x0178  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x018a  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x018f  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x01bd  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x01c5  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x01c9  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x01d8  */
    @Override // com.samsung.android.support.senl.p148nt.word.base.controller.ItemController
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void processItem() {
        SpenObjectTable spenObjectTable;
        XSLFTable xSLFTable;
        int i;
        double d;
        int i2;
        HashMap<TableCell.BorderEdge, SpenObjectTable.BorderStyle> map;
        String[] strArr;
        XSLFTableCell xSLFTableCellAddCell;
        HashMap<TableCell.BorderEdge, SpenObjectTable.BorderStyle> map2;
        int cellBackgroundColor;
        HashMap<TableCell.BorderEdge, SpenObjectTable.BorderStyle> mapReOrganizationTableBorderPath;
        TableCell.BorderEdge borderEdge;
        Integer num;
        TableCell.BorderEdge borderEdge2;
        Integer num2;
        TableCell.BorderEdge borderEdge3;
        Integer num3;
        Integer num4;
        int i4;
        XSLFTextParagraph xSLFTextParagraphAddNewTextParagraph;
        String[] strArr2;
        XSLFTextRun xSLFTextRunAddNewTextRun;
        String str;
        List<XSLFTextRun> textRuns;
        int i5;
        List listM13999t;
        List listEmptyList;
        Double dValueOf = Double.valueOf(50.0d);
        SpenObjectBase spenObjectBase = this.mObject;
        if (spenObjectBase == null || spenObjectBase.getType() != 22) {
            return;
        }
        XSLFSlide xSLFSlide = (XSLFSlide) this.mElement;
        XSLFTable xSLFTableCreateTable = xSLFSlide != null ? xSLFSlide.createTable() : null;
        SpenObjectBase spenObjectBase2 = this.mObject;
        Intrinsics.checkNotNull(spenObjectBase2, "null cannot be cast to non-null type com.samsung.android.sdk.pen.document.SpenObjectTable");
        SpenObjectTable spenObjectTable2 = (SpenObjectTable) spenObjectBase2;
        calculateSize();
        OfficeView.INSTANCE.increaseElementId();
        double dWidth = this.width / ((double) spenObjectTable2.getRect().width());
        if (xSLFTableCreateTable != null) {
            spenObjectTable = spenObjectTable2;
            xSLFTableCreateTable.setAnchor(new Rectangle2D.Double(this.left, this.top, this.width, this.height));
        } else {
            spenObjectTable = spenObjectTable2;
        }
        HashMap<TableCell.BorderEdge, SpenObjectTable.BorderStyle> mapReOrganizationTableBorderPath2 = reOrganizationTableBorderPath(spenObjectTable.getBorderPath());
        int i6 = 1;
        int rowsCount = spenObjectTable.getRowsCount() - 1;
        if (rowsCount < 0) {
            return;
        }
        int i7 = 0;
        int i8 = 0;
        while (true) {
            XSLFTableRow xSLFTableRowAddRow = xSLFTableCreateTable != null ? xSLFTableCreateTable.addRow() : null;
            SpenObjectTable spenObjectTable3 = spenObjectTable;
            if (xSLFTableCreateTable != null) {
                xSLFTableCreateTable.setRowHeight(i8, ((double) spenObjectTable3.getRowHeight(i8)) * dWidth);
            }
            int columnsCount = spenObjectTable3.getColumnsCount() - i6;
            if (columnsCount >= 0) {
                int i9 = i7;
                while (true) {
                    HashMap<TableCell.BorderEdge, Integer> map3 = new HashMap<>();
                    SpenObjectTextBox contentObject = spenObjectTable3.getContentObject(i8, i9);
                    String text = contentObject.getText();
                    d = dWidth;
                    if (text != null && (listM13999t = AbstractC12991c.m13999t(i7, "\n", text)) != null) {
                        if (listM13999t.isEmpty()) {
                            listEmptyList = CollectionsKt.emptyList();
                            if (listEmptyList == null) {
                            }
                        } else {
                            ListIterator listIterator = listM13999t.listIterator(listM13999t.size());
                            while (listIterator.hasPrevious()) {
                                if (((String) listIterator.previous()).length() != 0) {
                                    listEmptyList = AbstractC12991c.m14000u(listIterator, 1, listM13999t);
                                    break;
                                }
                            }
                            listEmptyList = CollectionsKt.emptyList();
                            if (listEmptyList == null) {
                                strArr = (String[]) listEmptyList.toArray(new String[0]);
                                xSLFTableCellAddCell = xSLFTableRowAddRow == null ? xSLFTableRowAddRow.addCell() : null;
                                if (xSLFTableCreateTable == null) {
                                    map2 = mapReOrganizationTableBorderPath2;
                                    i = rowsCount;
                                    xSLFTableCreateTable.setColumnWidth(i9, ((double) spenObjectTable3.getColumnWidth(i9)) * d);
                                } else {
                                    map2 = mapReOrganizationTableBorderPath2;
                                    i = rowsCount;
                                }
                                if (strArr != null) {
                                    if (!(strArr.length == 0)) {
                                        OfficeParams officeParams = this.mView.mDocParams;
                                        Intrinsics.checkNotNull(officeParams, "null cannot be cast to non-null type com.samsung.android.support.senl.nt.word.powerpoint.data.PowerPointParams");
                                        ParagraphAttrToPPTHelper paragraphAttrToPPTHelper = new ParagraphAttrToPPTHelper((PowerPointParams) officeParams, contentObject, this.mView);
                                        int length = strArr.length;
                                        int i10 = 0;
                                        int iM2212c = 0;
                                        while (i10 < length) {
                                            XSLFTable xSLFTable2 = xSLFTableCreateTable;
                                            int length2 = strArr[i10].length() + iM2212c;
                                            if (xSLFTableCellAddCell != null) {
                                                i4 = length;
                                                xSLFTextParagraphAddNewTextParagraph = xSLFTableCellAddCell.addNewTextParagraph();
                                            } else {
                                                i4 = length;
                                                xSLFTextParagraphAddNewTextParagraph = null;
                                            }
                                            if (paragraphAttrToPPTHelper.haveSpan()) {
                                                paragraphAttrToPPTHelper.addRunToParagraph(xSLFTextParagraphAddNewTextParagraph, iM2212c, length2);
                                                strArr2 = strArr;
                                            } else {
                                                if (xSLFTextParagraphAddNewTextParagraph != null) {
                                                    strArr2 = strArr;
                                                    xSLFTextRunAddNewTextRun = xSLFTextParagraphAddNewTextParagraph.addNewTextRun();
                                                } else {
                                                    strArr2 = strArr;
                                                    xSLFTextRunAddNewTextRun = null;
                                                }
                                                if (xSLFTextRunAddNewTextRun != null) {
                                                    xSLFTextRunAddNewTextRun.setFontSize(dValueOf);
                                                }
                                                if (xSLFTextRunAddNewTextRun != null) {
                                                    String strSubstring = text.substring(iM2212c, length2);
                                                    str = text;
                                                    Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
                                                    xSLFTextRunAddNewTextRun.setText(strSubstring);
                                                }
                                                textRuns = xSLFTextParagraphAddNewTextParagraph == null ? xSLFTextParagraphAddNewTextParagraph.getTextRuns() : null;
                                                Intrinsics.checkNotNull(textRuns);
                                                if (textRuns.isEmpty()) {
                                                    XSLFTextRun xSLFTextRunAddNewTextRun2 = xSLFTextParagraphAddNewTextParagraph.addNewTextRun();
                                                    xSLFTextRunAddNewTextRun2.setFontSize(dValueOf);
                                                    xSLFTextRunAddNewTextRun2.setText(Constant.WHITE_SPACE_FOR_LINK_ICON);
                                                }
                                                if (paragraphAttrToPPTHelper.haveSpenTextParagraph()) {
                                                    i5 = 1;
                                                } else {
                                                    i5 = 1;
                                                    paragraphAttrToPPTHelper.addSpenTextParagraph(i10, xSLFTextParagraphAddNewTextParagraph, true);
                                                }
                                                iM2212c = AbstractC2821a.m2212c(i5, iM2212c, strArr2[i10]);
                                                i10++;
                                                length = i4;
                                                xSLFTableCreateTable = xSLFTable2;
                                                strArr = strArr2;
                                                text = str;
                                            }
                                            str = text;
                                            if (xSLFTextParagraphAddNewTextParagraph == null) {
                                            }
                                            Intrinsics.checkNotNull(textRuns);
                                            if (textRuns.isEmpty()) {
                                            }
                                            if (paragraphAttrToPPTHelper.haveSpenTextParagraph()) {
                                            }
                                            iM2212c = AbstractC2821a.m2212c(i5, iM2212c, strArr2[i10]);
                                            i10++;
                                            length = i4;
                                            xSLFTableCreateTable = xSLFTable2;
                                            strArr = strArr2;
                                            text = str;
                                        }
                                    }
                                }
                                xSLFTable = xSLFTableCreateTable;
                                cellBackgroundColor = spenObjectTable3.getCellBackgroundColor(i8, i9);
                                if (cellBackgroundColor != 0 && xSLFTableCellAddCell != null) {
                                    xSLFTableCellAddCell.setFillColor(intToColor(cellBackgroundColor));
                                }
                                mapReOrganizationTableBorderPath = reOrganizationTableBorderPath(spenObjectTable3.getCellBorderPath(i8, i9));
                                if (i8 != 0) {
                                    map = map2;
                                    setBorderTable(xSLFTableCellAddCell, TableCell.BorderEdge.top, map, map3);
                                } else {
                                    map = map2;
                                }
                                if (i9 == 0) {
                                    setBorderTable(xSLFTableCellAddCell, TableCell.BorderEdge.left, map, map3);
                                }
                                if (i8 == spenObjectTable3.getRowsCount() - 1) {
                                    setBorderTable(xSLFTableCellAddCell, TableCell.BorderEdge.bottom, map, map3);
                                }
                                if (i9 == spenObjectTable3.getColumnsCount() - 1) {
                                    setBorderTable(xSLFTableCellAddCell, TableCell.BorderEdge.right, map, map3);
                                }
                                borderEdge = TableCell.BorderEdge.top;
                                num = map3.get(borderEdge);
                                if ((num != null || num.intValue() != 1) && xSLFTableCellAddCell != null) {
                                    setBorderFormat(xSLFTableCellAddCell, borderEdge, mapReOrganizationTableBorderPath.get(borderEdge));
                                }
                                borderEdge2 = TableCell.BorderEdge.left;
                                num2 = map3.get(borderEdge2);
                                if ((num2 == null || num2.intValue() != 1) && xSLFTableCellAddCell != null) {
                                    setBorderFormat(xSLFTableCellAddCell, borderEdge2, mapReOrganizationTableBorderPath.get(borderEdge2));
                                }
                                borderEdge3 = TableCell.BorderEdge.right;
                                num3 = map3.get(borderEdge3);
                                if ((num3 == null || num3.intValue() != 1) && xSLFTableCellAddCell != null) {
                                    setBorderFormat(xSLFTableCellAddCell, borderEdge3, mapReOrganizationTableBorderPath.get(borderEdge3));
                                }
                                TableCell.BorderEdge borderEdge4 = TableCell.BorderEdge.bottom;
                                num4 = map3.get(borderEdge4);
                                if (num4 != null) {
                                    i2 = 1;
                                    if (num4.intValue() != 1) {
                                    }
                                    if (i9 != columnsCount) {
                                        break;
                                    }
                                    i9++;
                                    mapReOrganizationTableBorderPath2 = map;
                                    dWidth = d;
                                    rowsCount = i;
                                    xSLFTableCreateTable = xSLFTable;
                                    i7 = 0;
                                } else {
                                    i2 = 1;
                                }
                                if (xSLFTableCellAddCell != null) {
                                    setBorderFormat(xSLFTableCellAddCell, borderEdge4, mapReOrganizationTableBorderPath.get(borderEdge4));
                                }
                                if (i9 != columnsCount) {
                                }
                            }
                        }
                    }
                    strArr = null;
                    if (xSLFTableRowAddRow == null) {
                    }
                    if (xSLFTableCreateTable == null) {
                    }
                    if (strArr != null) {
                    }
                    xSLFTable = xSLFTableCreateTable;
                    cellBackgroundColor = spenObjectTable3.getCellBackgroundColor(i8, i9);
                    if (cellBackgroundColor != 0) {
                        xSLFTableCellAddCell.setFillColor(intToColor(cellBackgroundColor));
                    }
                    mapReOrganizationTableBorderPath = reOrganizationTableBorderPath(spenObjectTable3.getCellBorderPath(i8, i9));
                    if (i8 != 0) {
                    }
                    if (i9 == 0) {
                    }
                    if (i8 == spenObjectTable3.getRowsCount() - 1) {
                    }
                    if (i9 == spenObjectTable3.getColumnsCount() - 1) {
                    }
                    borderEdge = TableCell.BorderEdge.top;
                    num = map3.get(borderEdge);
                    if (num != null) {
                        setBorderFormat(xSLFTableCellAddCell, borderEdge, mapReOrganizationTableBorderPath.get(borderEdge));
                        borderEdge2 = TableCell.BorderEdge.left;
                        num2 = map3.get(borderEdge2);
                        if (num2 == null) {
                            setBorderFormat(xSLFTableCellAddCell, borderEdge2, mapReOrganizationTableBorderPath.get(borderEdge2));
                            borderEdge3 = TableCell.BorderEdge.right;
                            num3 = map3.get(borderEdge3);
                            if (num3 == null) {
                                setBorderFormat(xSLFTableCellAddCell, borderEdge3, mapReOrganizationTableBorderPath.get(borderEdge3));
                                TableCell.BorderEdge borderEdge42 = TableCell.BorderEdge.bottom;
                                num4 = map3.get(borderEdge42);
                                if (num4 != null) {
                                }
                                if (xSLFTableCellAddCell != null) {
                                }
                                if (i9 != columnsCount) {
                                }
                            } else {
                                setBorderFormat(xSLFTableCellAddCell, borderEdge3, mapReOrganizationTableBorderPath.get(borderEdge3));
                                TableCell.BorderEdge borderEdge422 = TableCell.BorderEdge.bottom;
                                num4 = map3.get(borderEdge422);
                                if (num4 != null) {
                                }
                                if (xSLFTableCellAddCell != null) {
                                }
                                if (i9 != columnsCount) {
                                }
                            }
                        } else {
                            setBorderFormat(xSLFTableCellAddCell, borderEdge2, mapReOrganizationTableBorderPath.get(borderEdge2));
                            borderEdge3 = TableCell.BorderEdge.right;
                            num3 = map3.get(borderEdge3);
                            if (num3 == null) {
                            }
                        }
                    } else {
                        setBorderFormat(xSLFTableCellAddCell, borderEdge, mapReOrganizationTableBorderPath.get(borderEdge));
                        borderEdge2 = TableCell.BorderEdge.left;
                        num2 = map3.get(borderEdge2);
                        if (num2 == null) {
                        }
                    }
                }
            } else {
                xSLFTable = xSLFTableCreateTable;
                i = rowsCount;
                d = dWidth;
                i2 = i6;
                map = mapReOrganizationTableBorderPath2;
            }
            int i11 = i;
            if (i8 == i11) {
                return;
            }
            i8++;
            mapReOrganizationTableBorderPath2 = map;
            i6 = i2;
            spenObjectTable = spenObjectTable3;
            dWidth = d;
            i7 = 0;
            rowsCount = i11;
            xSLFTableCreateTable = xSLFTable;
        }
    }
}
