package com.samsung.android.support.senl.p148nt.composer.main.base.model.composer;

import android.content.res.TypedArray;
import android.graphics.Point;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AbstractC0541b;
import androidx.collection.AbstractC0622a;
import androidx.compose.runtime.AbstractC1974b;
import androidx.core.content.ContextCompat;
import androidx.exifinterface.media.ExifInterface;
import com.samsung.android.sdk.composer.view.zoomScroller.ISpenNoteZoomScroller;
import com.samsung.android.sdk.pen.document.SpenObjectTable;
import com.samsung.android.sdk.pen.document.SpenObjectTextBox;
import com.samsung.android.sdk.pen.document.textspan.SpenAlignmentParagraph;
import com.samsung.android.sdk.pen.document.textspan.SpenBoldSpan;
import com.samsung.android.sdk.pen.document.textspan.SpenFontSizeSpan;
import com.samsung.android.sdk.pen.document.textspan.SpenForegroundColorSpan;
import com.samsung.android.sdk.pen.document.textspan.SpenItalicSpan;
import com.samsung.android.sdk.pen.document.textspan.SpenStrikethroughSpan;
import com.samsung.android.sdk.pen.document.textspan.SpenUnderlineSpan;
import com.samsung.android.sdk.pen.worddoc.SpenWNote;
import com.samsung.android.sdk.pen.worddoc.SpenWPage;
import com.samsung.android.support.senl.p145cm.base.framework.content.TypedArrayCompat;
import com.samsung.android.support.senl.p145cm.base.framework.support.BaseUtils;
import com.samsung.android.support.senl.p148nt.base.composer.table.TableHelper;
import com.samsung.android.support.senl.p148nt.base.composer.text.common.TextUtil;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.composer.TextManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.composer.common.CellStyle;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.composer.common.TableStyle;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.composer.object.IObjectInserter;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.composer.object.ObjectInserterObjectSpan;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.composer.object.ObjectSpanHelper;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.composer.object.ObjectTextBoxData;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.composer.object.ObjectTextFactory;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.composer.text.span.TableCellAlign;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.composer.text.span.TableCellFontSize;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;
import kotlin.Pair;
import kotlin.Triple;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class TableManager implements TextManager.OnTableChangeListener {
    public static final int MAXIMUM_COLUMN = 30;
    public static final int MAXIMUM_ROW = 30;
    public static final int MAX_COLUMN_COUNT_IN_ONE_PAGE = 5;
    private static final String TAG = Logger.createTag("TableManager");
    private final IObjectInserter mIObjectInserter;
    private final SpenWNote mNote;
    private final TextManager mTextManager;

    public TableManager(SpenWNote spenWNote, TextManager textManager, IObjectInserter iObjectInserter) {
        this.mNote = spenWNote;
        this.mTextManager = textManager;
        textManager.setTableChangeListener(this);
        this.mIObjectInserter = iObjectInserter;
    }

    private Triple<Integer, Integer, SpenObjectTextBox> addCalculateCell(SpenObjectTable spenObjectTable, int i, int i2, String str) {
        SpenObjectTable spenObjectTable2;
        if (isUnsuitableForTableCalculation(spenObjectTable)) {
            return null;
        }
        int rowsCount = spenObjectTable.getRowsCount();
        int i4 = rowsCount - 2;
        for (int i5 = i4; i5 < rowsCount; i5++) {
            if (spenObjectTable.getContentObject(i5, i).getExtraDataInt(Calculation.KEY_TABLE_CALCULATION_TYPE) == i2) {
                return null;
            }
        }
        int i6 = i4;
        while (i6 < rowsCount && (spenObjectTable.isEditable(i6, i) || spenObjectTable.getContentObject(i6, i).getExtraDataInt(Calculation.KEY_TABLE_CALCULATION_TYPE) != 0)) {
            i6++;
        }
        if (i6 >= rowsCount) {
            int i7 = i6 - 1;
            spenObjectTable.insertRowBelow(i7, spenObjectTable.getRowHeight(i7));
            int columnsCount = spenObjectTable.getColumnsCount();
            for (int i8 = 0; i8 < columnsCount; i8++) {
                spenObjectTable.setEditable(i6, i8, false);
                spenObjectTable.getContentObject(i6, i8).removeExtraDataInt(Calculation.KEY_TABLE_CALCULATION_TYPE);
            }
            spenObjectTable2 = spenObjectTable;
            spenObjectTable2.setCellsBackgroundColor(i6, 0, i6, columnsCount - 1, spenObjectTable.getHeadingBackgroundColor());
        } else {
            spenObjectTable2 = spenObjectTable;
        }
        spenObjectTable2.getContentObject(i6, i).setExtraDataInt(Calculation.KEY_TABLE_CALCULATION_TYPE, i2);
        SpenObjectTextBox newTextBoxInTableCell = getNewTextBoxInTableCell();
        newTextBoxInTableCell.copy(spenObjectTable2.getContentObject(i6, i));
        int length = str.length();
        newTextBoxInTableCell.setText(str);
        newTextBoxInTableCell.appendTextSpan(new SpenBoldSpan(0, length, 1, true));
        newTextBoxInTableCell.appendTextSpan(new SpenItalicSpan(0, length, 1, false));
        newTextBoxInTableCell.appendTextSpan(new SpenUnderlineSpan(0, length, 1, false));
        newTextBoxInTableCell.appendTextSpan(new SpenStrikethroughSpan(0, length, 1, false));
        newTextBoxInTableCell.appendTextSpan(new SpenForegroundColorSpan(0, length, 3, this.mTextManager.getDefaultFontColor()));
        newTextBoxInTableCell.setExtraDataInt(Calculation.KEY_TABLE_CALCULATION_TYPE, i2);
        Logger.m10999d(TAG, "addCalculateCell# " + i2 + ": " + str);
        return new Triple<>(Integer.valueOf(i6), Integer.valueOf(i), newTextBoxInTableCell);
    }

    private void addTable(SpenWPage spenWPage, SpenObjectTable spenObjectTable, boolean z) {
        ObjectInserterObjectSpan.ObjectSpanOptions objectSpanOptions = new ObjectInserterObjectSpan.ObjectSpanOptions();
        objectSpanOptions.animationEnabled(true);
        this.mIObjectInserter.setHwMode(z);
        this.mIObjectInserter.insertObject(spenWPage, spenObjectTable, null, objectSpanOptions, true);
        this.mNote.selectObject(spenObjectTable);
    }

    private float getCellMinWidth(float f) {
        return f / 5.0f;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:155:0x017b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private int getHeaderTextColor(int i) {
        TypedArray typedArrayObtainTypedArray;
        boolean z;
        TypedArray typedArrayObtainTypedArray2;
        boolean zIsTerminated;
        boolean zIsTerminated2;
        boolean zIsTerminated3;
        boolean zIsTerminated4;
        try {
            TypedArrayCompat.Companion companion = TypedArrayCompat.INSTANCE;
            typedArrayObtainTypedArray = companion.getInstance().obtainTypedArray(C9086R.array.table_header_color_set);
            z = false;
            try {
                typedArrayObtainTypedArray2 = companion.getInstance().obtainTypedArray(C9086R.array.table_header_text_color_set);
            } finally {
            }
        } catch (Exception unused) {
            Logger.m10999d(TAG, "getHeaderTextColor# can't find color.");
        }
        try {
            int length = typedArrayObtainTypedArray.length() - 1;
            for (int i2 = 0; i2 < length; i2++) {
                if (i == typedArrayObtainTypedArray.getColor(i2, 0)) {
                    int color = typedArrayObtainTypedArray2.getColor(i2, 0);
                    if (typedArrayObtainTypedArray2 instanceof AutoCloseable) {
                        typedArrayObtainTypedArray2.close();
                    } else if (typedArrayObtainTypedArray2 instanceof ExecutorService) {
                        ExecutorService executorService = (ExecutorService) typedArrayObtainTypedArray2;
                        if (executorService != ForkJoinPool.commonPool() && !(zIsTerminated3 = executorService.isTerminated())) {
                            executorService.shutdown();
                            boolean z2 = false;
                            while (!zIsTerminated3) {
                                try {
                                    zIsTerminated3 = executorService.awaitTermination(1L, TimeUnit.DAYS);
                                } catch (InterruptedException unused2) {
                                    if (!z2) {
                                        executorService.shutdownNow();
                                        z2 = true;
                                    }
                                }
                            }
                            if (z2) {
                                Thread.currentThread().interrupt();
                            }
                        }
                    } else {
                        typedArrayObtainTypedArray2.recycle();
                    }
                    if (typedArrayObtainTypedArray instanceof AutoCloseable) {
                        typedArrayObtainTypedArray.close();
                    } else if (typedArrayObtainTypedArray instanceof ExecutorService) {
                        ExecutorService executorService2 = (ExecutorService) typedArrayObtainTypedArray;
                        if (executorService2 != ForkJoinPool.commonPool() && !(zIsTerminated4 = executorService2.isTerminated())) {
                            executorService2.shutdown();
                            while (!zIsTerminated4) {
                                try {
                                    zIsTerminated4 = executorService2.awaitTermination(1L, TimeUnit.DAYS);
                                } catch (InterruptedException unused3) {
                                    if (!z) {
                                        executorService2.shutdownNow();
                                        z = true;
                                    }
                                }
                            }
                            if (z) {
                                Thread.currentThread().interrupt();
                            }
                        }
                    } else {
                        typedArrayObtainTypedArray.recycle();
                    }
                    return color;
                }
            }
            if (typedArrayObtainTypedArray2 != 0) {
                if (typedArrayObtainTypedArray2 instanceof AutoCloseable) {
                    typedArrayObtainTypedArray2.close();
                } else if (typedArrayObtainTypedArray2 instanceof ExecutorService) {
                    ExecutorService executorService3 = (ExecutorService) typedArrayObtainTypedArray2;
                    if (executorService3 != ForkJoinPool.commonPool() && !(zIsTerminated2 = executorService3.isTerminated())) {
                        executorService3.shutdown();
                        boolean z3 = false;
                        while (!zIsTerminated2) {
                            try {
                                zIsTerminated2 = executorService3.awaitTermination(1L, TimeUnit.DAYS);
                            } catch (InterruptedException unused4) {
                                if (!z3) {
                                    executorService3.shutdownNow();
                                    z3 = true;
                                }
                            }
                        }
                        if (z3) {
                            Thread.currentThread().interrupt();
                        }
                    }
                } else {
                    typedArrayObtainTypedArray2.recycle();
                }
            }
            if (typedArrayObtainTypedArray instanceof AutoCloseable) {
                typedArrayObtainTypedArray.close();
            } else if (typedArrayObtainTypedArray instanceof ExecutorService) {
                ExecutorService executorService4 = (ExecutorService) typedArrayObtainTypedArray;
                if (executorService4 != ForkJoinPool.commonPool() && !(zIsTerminated = executorService4.isTerminated())) {
                    executorService4.shutdown();
                    while (!zIsTerminated) {
                        try {
                            zIsTerminated = executorService4.awaitTermination(1L, TimeUnit.DAYS);
                        } catch (InterruptedException unused5) {
                            if (!z) {
                                executorService4.shutdownNow();
                                z = true;
                            }
                        }
                    }
                    if (z) {
                        Thread.currentThread().interrupt();
                    }
                }
            } else {
                typedArrayObtainTypedArray.recycle();
            }
            return BaseUtils.getContext().getResources().getColor(C9086R.color.composer_light_font_color, null);
        } finally {
            if (typedArrayObtainTypedArray2 != 0) {
                try {
                } catch (Throwable th) {
                }
            }
        }
    }

    private void initCellMinMaxWidth(SpenObjectTable spenObjectTable, float f) {
        float cellMinWidth = getCellMinWidth(f);
        for (int i = 0; i < spenObjectTable.getColumnsCount(); i++) {
            if (spenObjectTable.getColumnWidth(i) < cellMinWidth) {
                spenObjectTable.setColumnWidth(i, cellMinWidth);
            }
            spenObjectTable.setMinColumnWidth(i, cellMinWidth);
            spenObjectTable.setMaxColumnWidth(i, f);
        }
    }

    private void removeCalculateCell(SpenObjectTable spenObjectTable, int i, int i2) {
        if (isUnsuitableForTableCalculation(spenObjectTable)) {
            return;
        }
        int rowsCount = spenObjectTable.getRowsCount() - 1;
        int i4 = 0;
        while (i4 < 2) {
            SpenObjectTextBox contentObject = spenObjectTable.getContentObject(rowsCount, i);
            if (!spenObjectTable.isEditable(rowsCount, i) && contentObject.getExtraDataInt(Calculation.KEY_TABLE_CALCULATION_TYPE) == i2) {
                String str = TAG;
                StringBuilder sbM778t = AbstractC0541b.m778t(i2, "removeCalculateCell# type: ", ", value: ");
                sbM778t.append(contentObject.getText());
                Logger.m10999d(str, sbM778t.toString());
                int columnsCount = spenObjectTable.getColumnsCount();
                boolean z = true;
                for (int i5 = 0; i5 < columnsCount; i5++) {
                    if (i5 != i) {
                        String text = spenObjectTable.getContentObject(rowsCount, i5).getText();
                        z = text == null || text.isEmpty();
                        if (!z) {
                            break;
                        }
                    }
                }
                if (z) {
                    spenObjectTable.deleteRow(rowsCount);
                } else {
                    contentObject.setText("");
                    contentObject.setExtraDataInt(Calculation.KEY_TABLE_CALCULATION_TYPE, 0);
                }
            }
            i4++;
            rowsCount--;
        }
    }

    private void removeUneditableCells(SpenObjectTable spenObjectTable) {
        for (int rowsCount = spenObjectTable.getRowsCount() - 1; rowsCount >= 0; rowsCount--) {
            SpenObjectTable.TableCell cell = spenObjectTable.getCell(rowsCount, 0);
            if (cell != null && !cell.getEditable()) {
                spenObjectTable.deleteRow(rowsCount);
            }
        }
    }

    private void updateHeaderTextBox(TableStyle tableStyle, SpenObjectTextBox spenObjectTextBox, boolean z, int i) {
        int length = spenObjectTextBox.getText().length();
        if (z) {
            spenObjectTextBox.appendTextSpan(new SpenBoldSpan(0, length, 1, true));
            spenObjectTextBox.appendTextSpan(new SpenItalicSpan(0, length, 1, false));
            spenObjectTextBox.appendTextSpan(new SpenUnderlineSpan(0, length, 1, false));
            spenObjectTextBox.appendTextSpan(new SpenStrikethroughSpan(0, length, 1, false));
            spenObjectTextBox.appendTextSpan(new SpenForegroundColorSpan(0, length, 3, i));
            return;
        }
        if (!tableStyle.isUpdatedData(1)) {
            spenObjectTextBox.appendTextSpan(new SpenBoldSpan(0, length, 1, false));
        }
        if (tableStyle.isUpdatedData(64)) {
            return;
        }
        spenObjectTextBox.appendTextSpan(new SpenForegroundColorSpan(0, length, 3, this.mTextManager.getDefaultFontColor()));
    }

    private void updateTableHeader(TableStyle tableStyle, SpenObjectTable spenObjectTable) {
        int headerTextColor;
        if (tableStyle.isUpdatedData(256) || tableStyle.isUpdatedData(512)) {
            headerTextColor = getHeaderTextColor(spenObjectTable.getHeadingBackgroundColor());
            updateHeaderTextBox(tableStyle, spenObjectTable.getContentObject(0, 0), tableStyle.getIsHighlightHeaderRow() || tableStyle.getIsHighlightHeaderColumn(), headerTextColor);
        } else {
            headerTextColor = 0;
        }
        if (tableStyle.isUpdatedData(256)) {
            spenObjectTable.setHeadingRowEnabled(tableStyle.getIsHighlightHeaderRow());
            for (int i = 1; i < spenObjectTable.getColumnsCount(); i++) {
                updateHeaderTextBox(tableStyle, spenObjectTable.getContentObject(0, i), tableStyle.getIsHighlightHeaderRow(), headerTextColor);
            }
        }
        if (tableStyle.isUpdatedData(512)) {
            spenObjectTable.setHeadingColumnEnabled(tableStyle.getIsHighlightHeaderColumn());
            for (int i2 = 1; i2 < spenObjectTable.getRowsCount(); i2++) {
                updateHeaderTextBox(tableStyle, spenObjectTable.getContentObject(i2, 0), tableStyle.getIsHighlightHeaderColumn(), headerTextColor);
            }
        }
    }

    private void updateTableLineType(TableStyle tableStyle, SpenObjectTable spenObjectTable, int i) {
        if (tableStyle.isUpdatedData(1024)) {
            SpenObjectTable.BorderStyle borderStyle = new SpenObjectTable.BorderStyle();
            borderStyle.setColor(i);
            borderStyle.setWidth(BaseUtils.getContext().getResources().getDimensionPixelSize(C9086R.dimen.table_border_line_thickness));
            SpenObjectTable.BorderStyle borderStyle2 = new SpenObjectTable.BorderStyle();
            borderStyle2.setColor(0);
            borderStyle2.setWidth(0.0f);
            int tableLineType = tableStyle.getTableLineType();
            if (tableLineType == 0) {
                TableHelper.setAllRoundBorderStyle(spenObjectTable, borderStyle);
                return;
            }
            if (tableLineType == 1) {
                SpenObjectTable.Companion companion = SpenObjectTable.INSTANCE;
                spenObjectTable.setBorderStyle(borderStyle, companion.getBORDER_ALL());
                spenObjectTable.setDefaultCellBorderStyle(borderStyle, companion.getBORDER_ALL());
            } else {
                if (tableLineType == 3) {
                    SpenObjectTable.Companion companion2 = SpenObjectTable.INSTANCE;
                    spenObjectTable.setBorderStyle(borderStyle, companion2.getBORDER_TOP() | companion2.getBORDER_BOTTOM());
                    spenObjectTable.setBorderStyle(borderStyle2, companion2.getBORDER_LEFT() | companion2.getBORDER_RIGHT());
                    spenObjectTable.setDefaultCellBorderStyle(borderStyle2, companion2.getBORDER_ALL());
                    return;
                }
                SpenObjectTable.Companion companion3 = SpenObjectTable.INSTANCE;
                spenObjectTable.setBorderStyle(borderStyle2, companion3.getBORDER_ALL());
                if (tableLineType != 2) {
                    spenObjectTable.setDefaultCellBorderStyle(borderStyle2, companion3.getBORDER_ALL());
                } else {
                    spenObjectTable.setDefaultCellBorderStyle(borderStyle, companion3.getBORDER_TOP() | companion3.getBORDER_BOTTOM());
                    spenObjectTable.setDefaultCellBorderStyle(borderStyle2, companion3.getBORDER_LEFT() | companion3.getBORDER_RIGHT());
                }
            }
        }
    }

    private void updateTextBoxInCell(SpenObjectTextBox spenObjectTextBox, CellStyle cellStyle) {
        if (spenObjectTextBox.getText() == null) {
            spenObjectTextBox.copy(getNewTextBoxInTableCell());
        }
        int length = spenObjectTextBox.getText().length();
        if (cellStyle.isUpdatedData(1)) {
            spenObjectTextBox.appendTextSpan(new SpenBoldSpan(0, length, 1, cellStyle.getIsBold()));
        }
        if (cellStyle.isUpdatedData(2)) {
            spenObjectTextBox.appendTextSpan(new SpenItalicSpan(0, length, 1, cellStyle.getIsItalic()));
        }
        if (cellStyle.isUpdatedData(4)) {
            spenObjectTextBox.appendTextSpan(new SpenUnderlineSpan(0, length, 1, cellStyle.getIsUnderline()));
        }
        if (cellStyle.isUpdatedData(8)) {
            spenObjectTextBox.appendTextSpan(new SpenStrikethroughSpan(0, length, 1, cellStyle.getIsStrikethrough()));
        }
        if (cellStyle.isUpdatedData(32)) {
            spenObjectTextBox.appendTextSpan(new SpenFontSizeSpan(0, length, 1, cellStyle.getFontSize() - this.mTextManager.getFontSizeDelta()));
        }
        if (cellStyle.isUpdatedData(64)) {
            spenObjectTextBox.appendTextSpan(new SpenForegroundColorSpan(0, length, 3, cellStyle.getFontColor()));
        }
        if (cellStyle.isUpdatedData(16)) {
            int[] paragraphIndex = TextUtil.getParagraphIndex(spenObjectTextBox, TextUtil.getCursor(spenObjectTextBox));
            spenObjectTextBox.appendTextParagraph(new SpenAlignmentParagraph(paragraphIndex[0], paragraphIndex[1], cellStyle.getAlign()));
        }
    }

    public void applyCellStyle(SpenObjectTable spenObjectTable, ArrayList<Pair<Integer, Integer>> arrayList, CellStyle cellStyle) {
        for (Pair<Integer, Integer> pair : arrayList) {
            updateTextBoxInCell(spenObjectTable.getContentObject(pair.getFirst().intValue(), pair.getSecond().intValue()), cellStyle);
        }
        if (cellStyle.isUpdatedData(128)) {
            Pair<Integer, Integer> pair2 = arrayList.get(0);
            Pair pair3 = (Pair) AbstractC1974b.m1313f(1, arrayList);
            spenObjectTable.setCellsBackgroundColor(pair2.getFirst().intValue(), pair2.getSecond().intValue(), ((Integer) pair3.getFirst()).intValue(), ((Integer) pair3.getSecond()).intValue(), cellStyle.getCellBgColor());
        }
    }

    public void applyTableStyle(SpenObjectTable spenObjectTable, TableStyle tableStyle) {
        SpenObjectTable spenObjectTable2;
        Logger.m10999d(TAG, "applyTableStyle# tableStyle = " + tableStyle.toString());
        for (int i = 0; i < spenObjectTable.getRowsCount(); i++) {
            for (int i2 = 0; i2 < spenObjectTable.getColumnsCount(); i2++) {
                updateTextBoxInCell(spenObjectTable.getContentObject(i, i2), tableStyle.getCellStyle());
            }
        }
        if (tableStyle.isUpdatedData(2048)) {
            spenObjectTable2 = spenObjectTable;
            spenObjectTable2.setCellsBackgroundColor(0, 0, spenObjectTable.getRowsCount() - 1, spenObjectTable.getColumnsCount() - 1, tableStyle.getTableBgColor());
            spenObjectTable2.setHeadingBackgroundColor(TableHelper.getHeaderColor(tableStyle.getTableBgColor()));
        } else {
            spenObjectTable2 = spenObjectTable;
        }
        updateTableLineType(tableStyle, spenObjectTable2, ContextCompat.getColor(BaseUtils.getContext(), C9086R.color.table_border_line_color));
        updateTableHeader(tableStyle, spenObjectTable2);
        Logger.m10999d(TAG, "applyTableStyle# done.");
    }

    public void calculateCell(SpenObjectTable spenObjectTable, boolean z, boolean z2) {
        ArrayList<Pair<Integer, Integer>> selectedCellPositions;
        Triple<Integer, Integer, SpenObjectTextBox> tripleAddCalculateCell;
        Triple<Integer, Integer, SpenObjectTextBox> tripleAddCalculateCell2;
        Logger.m10999d(TAG, "calculateCell# Sum : " + z + ", Average : " + z2);
        if (isUnsuitableForTableCalculation(spenObjectTable) || (selectedCellPositions = spenObjectTable.getSelectedCellPositions()) == null) {
            return;
        }
        this.mNote.commitHistory();
        int iIntValue = selectedCellPositions.get(0).getSecond().intValue();
        Calculation calculationCalculateCell = calculateCell(spenObjectTable, iIntValue);
        if (!z) {
            removeCalculateCell(spenObjectTable, iIntValue, 1);
        }
        if (!z2) {
            removeCalculateCell(spenObjectTable, iIntValue, 2);
        }
        ArrayList arrayList = new ArrayList();
        if (z && (tripleAddCalculateCell2 = addCalculateCell(spenObjectTable, iIntValue, 1, calculationCalculateCell.getSum())) != null) {
            arrayList.add(tripleAddCalculateCell2);
        }
        if (z2 && (tripleAddCalculateCell = addCalculateCell(spenObjectTable, iIntValue, 2, calculationCalculateCell.getAverage())) != null) {
            arrayList.add(tripleAddCalculateCell);
        }
        if (!arrayList.isEmpty()) {
            this.mTextManager.getSpenNoteTextManager().setTableCellsContent(spenObjectTable, arrayList, true);
        }
        this.mNote.commitHistory();
    }

    public void createTable(SpenWPage spenWPage, RectF rectF, int i, int i2, boolean z) {
        Logger.m10999d(TAG, "createTable# pageIndex=" + this.mNote.getPageIndex(spenWPage) + ", row=" + i + ", column=" + i2);
        float fWidth = rectF.width();
        SpenObjectTextBox newTextBoxInTableCell = getNewTextBoxInTableCell();
        newTextBoxInTableCell.setText(ExifInterface.GPS_MEASUREMENT_IN_PROGRESS);
        float fHeight = this.mTextManager.getSpenNoteTextManager().getTextBoxMeasuredRect(newTextBoxInTableCell).height();
        if (i2 > 5) {
            rectF.right = (getCellMinWidth(fWidth) * i2) + rectF.left;
        }
        SpenObjectTable spenObjectTable = new SpenObjectTable(new PointF(rectF.left, rectF.top), i, i2, fHeight, rectF.width() / i2, fWidth);
        for (int i4 = 0; i4 < i; i4++) {
            for (int i5 = 0; i5 < i2; i5++) {
                spenObjectTable.getContentObject(i4, i5).copy(getNewTextBoxInTableCell());
            }
        }
        initCellMinMaxWidth(spenObjectTable, fWidth);
        TableStyle tableStyle = new TableStyle();
        tableStyle.loadData();
        spenObjectTable.setHeadingBackgroundColor(TableHelper.getHeaderColor(tableStyle.getTableBgColor()));
        applyTableStyle(spenObjectTable, tableStyle);
        addTable(spenWPage, spenObjectTable, z);
    }

    public void deleteTable(SpenObjectTable spenObjectTable) {
        ObjectSpanHelper objectSpanHelper = new ObjectSpanHelper(this.mNote);
        ArrayList arrayList = new ArrayList();
        arrayList.add(spenObjectTable);
        this.mTextManager.getSpenNoteTextManager().removeObjectSpan(objectSpanHelper.findObjectSpan(arrayList).get(0), true, true);
    }

    public int getEditableRowsCount(SpenObjectTable spenObjectTable) {
        int rowsCount = spenObjectTable.getRowsCount();
        int iMin = Math.min(rowsCount, 2);
        for (int i = 0; i < iMin && !spenObjectTable.isEditable(rowsCount - 1, 0); i++) {
            rowsCount--;
        }
        return rowsCount;
    }

    public SpenObjectTextBox getNewTextBoxInTableCell() {
        return (SpenObjectTextBox) ObjectTextFactory.newTableCellTextBox(new ObjectTextBoxData(TableCellFontSize.INSTANCE.getStoredValue(), TableCellAlign.INSTANCE.getStoredValue(), this.mTextManager.getDefaultFontColor()));
    }

    @Nullable
    public RectF getSelectedCellRect(SpenObjectTable spenObjectTable, RectF rectF, Rect rect, boolean z, int i, ISpenNoteZoomScroller iSpenNoteZoomScroller) {
        ArrayList<Pair<Integer, Integer>> selectedCellPositions;
        float fWidth;
        if (spenObjectTable == null || (selectedCellPositions = spenObjectTable.getSelectedCellPositions()) == null || selectedCellPositions.isEmpty()) {
            return null;
        }
        RectF rect2 = spenObjectTable.getRect();
        Point offset = this.mNote.getPage(spenObjectTable.getPageIndex()).getOffset();
        rect2.offset(offset.x, offset.y);
        float dimensionPixelOffset = BaseUtils.getContext().getResources().getDimensionPixelOffset(C9086R.dimen.table_more_menu_margin_top);
        if (z) {
            rect2.offset(0.0f, (spenObjectTable.getContentObject(((Integer) ((Pair) AbstractC1974b.m1313f(1, selectedCellPositions)).getFirst()).intValue(), 0).getRect().bottom - spenObjectTable.getRect().top) + dimensionPixelOffset);
        } else {
            if (rectF == null) {
                float f = spenObjectTable.getContentObject(0, ((Integer) ((Pair) AbstractC1974b.m1313f(1, selectedCellPositions)).getSecond()).intValue()).getRect().right;
                float f4 = spenObjectTable.getContentObject(0, selectedCellPositions.get(0).getSecond().intValue()).getRect().left;
                fWidth = (spenObjectTable.getScrollX() + AbstractC0622a.m1155a(f, f4, 2.0f, f4)) - spenObjectTable.getRect().left;
            } else {
                fWidth = ((rectF.width() / 2.0f) + rectF.left) - spenObjectTable.getRect().left;
            }
            rect2.offset(fWidth, rect2.height() + dimensionPixelOffset);
        }
        RectF rectFConvertContentRectIntoViewRect = iSpenNoteZoomScroller.convertContentRectIntoViewRect(rect2);
        if (rectFConvertContentRectIntoViewRect == null) {
            return null;
        }
        rectFConvertContentRectIntoViewRect.offset(-(z ? 0.0f : i / 2.0f), 0.0f);
        rectFConvertContentRectIntoViewRect.offset(rect.left, rect.top);
        return rectFConvertContentRectIntoViewRect;
    }

    public boolean isOnlyDigits(String str) {
        return (str == null || str.isEmpty() || !str.matches("^\\s*[+-]?(?:\\d{1,3}(?:,\\d{3})*|\\d+)(\\.\\d+)?\\s*$")) ? false : true;
    }

    public boolean isUnsuitableForTableCalculation(SpenObjectTable spenObjectTable) {
        return spenObjectTable.getRowsCount() < 2;
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.model.composer.TextManager.OnTableChangeListener
    public void onTableChanged(SpenObjectTable spenObjectTable, int i) {
        if (isUnsuitableForTableCalculation(spenObjectTable)) {
            return;
        }
        AbstractC0000a.m3D(i, "onTableChanged# update calculated cell. columnIndex: ", TAG);
        Calculation calculationCalculateCell = calculateCell(spenObjectTable, i);
        if (!calculationCalculateCell.hasCalculatedCell()) {
            removeCalculateCell(spenObjectTable, i, 1);
            removeCalculateCell(spenObjectTable, i, 2);
            return;
        }
        int rowsCount = spenObjectTable.getRowsCount() - 1;
        int i2 = 0;
        while (i2 < 2) {
            SpenObjectTable.TableCell cell = spenObjectTable.getCell(rowsCount, i);
            if (cell != null && !cell.getEditable()) {
                int extraDataInt = spenObjectTable.getContentObject(rowsCount, i).getExtraDataInt(Calculation.KEY_TABLE_CALCULATION_TYPE);
                if (extraDataInt == 1) {
                    spenObjectTable.getContentObject(rowsCount, i).setText(calculationCalculateCell.getSum());
                } else if (extraDataInt == 2) {
                    spenObjectTable.getContentObject(rowsCount, i).setText(calculationCalculateCell.getAverage());
                }
            }
            i2++;
            rowsCount--;
        }
    }

    public void pasteCellsInTable(SpenObjectTable spenObjectTable, SpenObjectTable spenObjectTable2) {
        ArrayList<Pair<Integer, Integer>> selectedCellPositions = spenObjectTable2.getSelectedCellPositions();
        if (selectedCellPositions == null || selectedCellPositions.isEmpty()) {
            Logger.m11000e(TAG, "pasteCellsInTable# fail");
            return;
        }
        int iIntValue = selectedCellPositions.get(0).getFirst().intValue();
        int iIntValue2 = selectedCellPositions.get(0).getSecond().intValue();
        removeUneditableCells(spenObjectTable);
        SpenObjectTable.TableCell tableCell = null;
        for (int i = 0; i < spenObjectTable.getColumnsCount(); i++) {
            for (int i2 = 0; i2 < spenObjectTable.getRowsCount(); i2++) {
                int i4 = iIntValue + i2;
                int i5 = iIntValue2 + i;
                SpenObjectTable.TableCell cell = spenObjectTable2.getCell(i4, i5);
                if (cell != null && !cell.getEditable()) {
                    int editableRowsCount = getEditableRowsCount(spenObjectTable2);
                    if (editableRowsCount > i4 || editableRowsCount >= 30) {
                        break;
                    }
                    int i6 = i4 - 1;
                    spenObjectTable2.insertRowBelow(i6, spenObjectTable2.getRowHeight(i6));
                    cell = spenObjectTable2.getCell(i4, i5);
                }
                if (cell == null && tableCell != null) {
                    if (spenObjectTable2.getRowsCount() <= i4 && spenObjectTable2.getRowsCount() < 30) {
                        int i7 = i4 - 1;
                        spenObjectTable2.insertRowBelow(i7, spenObjectTable2.getRowHeight(i7));
                        cell = spenObjectTable2.getCell(i4, i5);
                    } else if (spenObjectTable2.getColumnsCount() <= i5 && spenObjectTable2.getColumnsCount() < 30) {
                        int i8 = i5 - 1;
                        spenObjectTable2.insertColumnAfter(i8, spenObjectTable2.getColumnWidth(i8));
                        float minColumnWidth = spenObjectTable2.getMinColumnWidth(i8);
                        float maxColumnWidth = spenObjectTable2.getMaxColumnWidth(i8);
                        float columnWidth = spenObjectTable2.getColumnWidth(i5);
                        spenObjectTable2.setMinColumnWidth(i5, Math.min(minColumnWidth, columnWidth));
                        spenObjectTable2.setMaxColumnWidth(i5, Math.max(maxColumnWidth, columnWidth));
                        cell = spenObjectTable2.getCell(i4, i5);
                    }
                }
                if (cell != null) {
                    boolean z = isOnlyDigits(spenObjectTable2.getContentObject(i4, i5).getText()) || isOnlyDigits(spenObjectTable.getContentObject(i2, i).getText());
                    spenObjectTable2.setCellBackgroundColor(spenObjectTable.getCellBackgroundColor(i2, i), i4, i5);
                    spenObjectTable2.setContentText(spenObjectTable.getContentObject(i2, i), i4, i5);
                    if (z) {
                        onTableChanged(spenObjectTable2, i5);
                    }
                    tableCell = cell;
                }
            }
        }
    }

    public void pasteTable(SpenWPage spenWPage, RectF rectF, SpenObjectTable spenObjectTable, boolean z) {
        removeEmptyCalculateCell(spenObjectTable);
        int columnsCount = spenObjectTable.getColumnsCount();
        float fWidth = rectF.width();
        float cellMinWidth = getCellMinWidth(fWidth);
        for (int i = 0; i < columnsCount; i++) {
            if (spenObjectTable.getColumnWidth(i) < cellMinWidth) {
                spenObjectTable.setColumnWidth(i, cellMinWidth);
            } else if (spenObjectTable.getColumnWidth(i) > fWidth) {
                spenObjectTable.setColumnWidth(i, fWidth);
            }
            spenObjectTable.setMinColumnWidth(i, cellMinWidth);
            spenObjectTable.setMaxColumnWidth(i, fWidth);
        }
        spenObjectTable.setMaxWidth(rectF.width());
        addTable(spenWPage, spenObjectTable, z);
    }

    public void removeEmptyCalculateCell(SpenObjectTable spenObjectTable) {
        if (isUnsuitableForTableCalculation(spenObjectTable)) {
            return;
        }
        int rowsCount = spenObjectTable.getRowsCount() - 1;
        int i = 0;
        while (i < 2) {
            if (!spenObjectTable.isEditable(rowsCount, 0)) {
                int columnsCount = spenObjectTable.getColumnsCount();
                boolean z = true;
                for (int i2 = 0; i2 < columnsCount; i2++) {
                    String text = spenObjectTable.getContentObject(rowsCount, i2).getText();
                    z = text == null || text.isEmpty();
                    if (!z) {
                        break;
                    }
                }
                if (z) {
                    spenObjectTable.deleteRow(rowsCount);
                }
            }
            i++;
            rowsCount--;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class Calculation {
        public static final int AVERAGE = 2;
        public static final String KEY_TABLE_CALCULATION_TYPE = "KEY_TABLE_CALCULATION_TYPE";
        public static final int NONE = 0;
        public static final int SUM = 1;
        public static final int TABLE_AVAILABLE_CAL_COUNT = 2;
        public final DecimalFormat NUMBER_FORMAT;
        private float average;
        private boolean hasAverage;
        private boolean hasSum;
        private float sum;

        public Calculation() {
            this.NUMBER_FORMAT = new DecimalFormat("#.##");
            this.hasSum = false;
            this.hasAverage = false;
        }

        public String getAverage() {
            return this.NUMBER_FORMAT.format(this.average);
        }

        public String getSum() {
            return this.NUMBER_FORMAT.format(this.sum);
        }

        public boolean hasAverage() {
            return this.hasAverage;
        }

        public boolean hasCalculatedCell() {
            return this.hasSum || this.hasAverage;
        }

        public boolean hasSum() {
            return this.hasSum;
        }

        public Calculation(boolean z, boolean z2) {
            this.NUMBER_FORMAT = new DecimalFormat("#.##");
            this.hasSum = z;
            this.hasAverage = z2;
        }

        public Calculation(float f, float f4) {
            this.NUMBER_FORMAT = new DecimalFormat("#.##");
            this.sum = f;
            this.average = f4;
            this.hasSum = true;
            this.hasAverage = true;
        }
    }

    private Calculation calculateCell(SpenObjectTable spenObjectTable, int i) {
        String text;
        int rowsCount = spenObjectTable.getRowsCount();
        float f = 0.0f;
        boolean z = false;
        int i2 = 0;
        for (int i4 = 0; i4 < rowsCount; i4++) {
            SpenObjectTable.TableCell cell = spenObjectTable.getCell(i4, i);
            if (cell != null && cell.getEditable() && (text = spenObjectTable.getContentObject(i4, i).getText()) != null && isOnlyDigits(text)) {
                i2++;
                z = true;
                f = Float.parseFloat(text.replace(",", "").replace("٠", "0").replace("١", "1").replace("٢", "2").replace("٣", "3").replace("٤", "4").replace("٥", "5").replace("٦", "6").replace("٧", "7").replace("٨", "8").replace("٩", "9")) + f;
            }
        }
        return z ? new Calculation(f, f / i2) : new Calculation();
    }

    public void removeCalculateCell(SpenObjectTable spenObjectTable, boolean z) {
        Logger.m10999d(TAG, "removeCalculateCell# Remove ".concat(z ? "Sum" : "Average"));
        ArrayList<Pair<Integer, Integer>> selectedCellPositions = spenObjectTable.getSelectedCellPositions();
        if (selectedCellPositions == null || isUnsuitableForTableCalculation(spenObjectTable)) {
            return;
        }
        this.mNote.commitHistory();
        removeCalculateCell(spenObjectTable, selectedCellPositions.get(0).getSecond().intValue(), z ? 1 : 2);
        this.mNote.commitHistory();
    }
}
