package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.richtext.setting;

import android.graphics.Rect;
import android.graphics.RectF;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.samsung.android.sdk.pen.document.SpenObjectBase;
import com.samsung.android.sdk.pen.document.SpenObjectTable;
import com.samsung.android.sdk.pen.document.SpenObjectTextBox;
import com.samsung.android.support.senl.p148nt.base.composer.text.span.Alignment;
import com.samsung.android.support.senl.p148nt.base.composer.text.span.CellSpanStates;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.composer.RtChecker;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.composer.common.CellStyle;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.composer.common.TableStyle;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.composer.text.SpanStates;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.ComposerViewContract;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.ComposerViewPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.richtext.RtToolbarContract;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Objects;
import kotlin.Pair;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class RtTableAndCellStylePresenter implements ComposerViewContract.RtTableAndCellStyleContract {
    private static final String TAG = Logger.createTag("RtTableAndCellStylePresenter");
    private final ComposerViewPresenter mComposerViewPresenter;
    private boolean mIsClickedRows;
    private final RtToolbarContract.IPresenter mRtPresenter;
    private final SpanStates.IContract mSpanStatesContract = new SpanStates.IContract() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.toolbar.richtext.setting.RtTableAndCellStylePresenter.1
        @Override // com.samsung.android.support.senl.nt.composer.main.base.model.composer.text.SpanStates.IContract
        public boolean isSelectedBodyText() {
            return false;
        }

        @Override // com.samsung.android.support.senl.nt.composer.main.base.model.composer.text.SpanStates.IContract
        public boolean isSelectedTable() {
            return true;
        }
    };
    private SpenObjectTable mSpenObjectTable;
    private RectF mTableControllerRect;

    public RtTableAndCellStylePresenter(ComposerViewPresenter composerViewPresenter, RtToolbarContract.IPresenter iPresenter) {
        this.mComposerViewPresenter = composerViewPresenter;
        this.mRtPresenter = iPresenter;
    }

    private CellSpanStates applyFromSpanStatesToCellSpanStates(SpanStates spanStates, CellSpanStates cellSpanStates, SpenObjectTable spenObjectTable, int i, int i2) {
        if (cellSpanStates == null) {
            CellSpanStates cellSpanStates2 = new CellSpanStates();
            cellSpanStates2.setBoldValue(spanStates.getBold().getValue());
            cellSpanStates2.setItalicValue(spanStates.getItalic().getValue());
            cellSpanStates2.setUnderlineValue(spanStates.getUnderline().getValue());
            cellSpanStates2.setStrikethroughValue(spanStates.getStrikethrough().getValue());
            cellSpanStates2.setFontSizeValue(spanStates.getFontSize().getValue());
            cellSpanStates2.setForegroundColorValue(spanStates.getFontColor().getValue());
            SpenObjectTable.TableCell cell = spenObjectTable.getCell(i, i2);
            Objects.requireNonNull(cell);
            cellSpanStates2.setCellBGColorValue(cell.getBackgroundColor());
            cellSpanStates2.setAlignValue(spenObjectTable.getContentObject(i, i2).getTextAlignment());
            return cellSpanStates2;
        }
        if (cellSpanStates.isBoldEnabled() && cellSpanStates.isBoldValue() != spanStates.getBold().getValue()) {
            cellSpanStates.setBoldEnabled(false);
            spanStates.getBold().reset();
            cellSpanStates.setBoldValue(spanStates.getBold().getValue());
        }
        if (cellSpanStates.isItalicEnabled() && cellSpanStates.isItalicValue() != spanStates.getItalic().getValue()) {
            cellSpanStates.setItalicEnabled(false);
            spanStates.getItalic().reset();
            cellSpanStates.setItalicValue(spanStates.getItalic().getValue());
        }
        if (cellSpanStates.isUnderlineEnabled() && cellSpanStates.isUnderlineValue() != spanStates.getUnderline().getValue()) {
            cellSpanStates.setUnderlineEnabled(false);
            spanStates.getUnderline().reset();
            cellSpanStates.setUnderlineValue(spanStates.getUnderline().getValue());
        }
        if (cellSpanStates.isStrikethroughEnabled() && cellSpanStates.isStrikethroughValue() != spanStates.getStrikethrough().getValue()) {
            cellSpanStates.setStrikethroughEnabled(false);
            spanStates.getStrikethrough().reset();
            cellSpanStates.setStrikethroughValue(spanStates.getStrikethrough().getValue());
        }
        if (cellSpanStates.isForegroundColorEnabled() && cellSpanStates.getForegroundColorValue() != spanStates.getFontColor().getValue()) {
            cellSpanStates.setForegroundColorEnabled(false);
            spanStates.getFontColor().reset();
            cellSpanStates.setForegroundColorValue(spanStates.getFontColor().getDefaultValue());
        }
        if (cellSpanStates.isCellBGColorEnabled()) {
            int cellBGColorValue = cellSpanStates.getCellBGColorValue();
            SpenObjectTable.TableCell cell2 = spenObjectTable.getCell(i, i2);
            Objects.requireNonNull(cell2);
            if (cellBGColorValue != cell2.getBackgroundColor()) {
                cellSpanStates.setCellBGColorEnabled(false);
                cellSpanStates.setCellBGColorValue(0);
            }
        }
        if (cellSpanStates.isFontSizeEnabled() && cellSpanStates.getFontSizeValue() != spanStates.getFontSize().getValue()) {
            cellSpanStates.setFontSizeEnabled(false);
            cellSpanStates.setFontSizeValue(-1);
        }
        if (cellSpanStates.isAlignEnabled() && cellSpanStates.getAlignValue() != spenObjectTable.getContentObject(i, i2).getTextAlignment()) {
            cellSpanStates.setAlignEnabled(false);
            cellSpanStates.setAlignValue(Alignment.getDefaultAlign());
        }
        return cellSpanStates;
    }

    private ArrayList<Pair<Integer, Integer>> getAllCellPositions(SpenObjectTable spenObjectTable) {
        ArrayList<Pair<Integer, Integer>> arrayList = new ArrayList<>();
        int rowsCount = spenObjectTable.getRowsCount();
        int columnsCount = spenObjectTable.getColumnsCount();
        for (int i = 0; i < rowsCount; i++) {
            for (int i2 = 0; i2 < columnsCount; i2++) {
                arrayList.add(new Pair<>(Integer.valueOf(i), Integer.valueOf(i2)));
            }
        }
        return arrayList;
    }

    @NonNull
    private CellStyle getCellStyle(SpenObjectTable spenObjectTable, ArrayList<Pair<Integer, Integer>> arrayList) {
        SpenObjectTable spenObjectTable2;
        CellSpanStates cellSpanStatesApplyFromSpanStatesToCellSpanStates;
        RtTableAndCellStylePresenter rtTableAndCellStylePresenter;
        SpenObjectTable spenObjectTable3;
        RtChecker rtChecker = new RtChecker();
        CellStyle cellStyle = new CellStyle();
        SpanStates spanStatesBuild = new SpanStates.Builder(this.mSpanStatesContract).fontSize(this.mComposerViewPresenter.getTextManager().getFontSizeDelta(), 15).fontColor(this.mComposerViewPresenter.getActivity().getResources().getColor(C9086R.color.composer_light_font_color, null)).fontBgColor().bold().italic().underline().strikethrough().task().indent().align().textFormat().build();
        if (arrayList == null || arrayList.isEmpty()) {
            spenObjectTable2 = spenObjectTable;
            cellSpanStatesApplyFromSpanStatesToCellSpanStates = null;
        } else {
            CellSpanStates cellSpanStatesApplyFromSpanStatesToCellSpanStates2 = null;
            for (Pair<Integer, Integer> pair : arrayList) {
                if (cellSpanStatesApplyFromSpanStatesToCellSpanStates2 != null && cellSpanStatesApplyFromSpanStatesToCellSpanStates2.isAllDisabled()) {
                    break;
                }
                SpenObjectTextBox contentObject = spenObjectTable.getContentObject(pair.getFirst().intValue(), pair.getSecond().intValue());
                if (contentObject.getText() != null) {
                    SpanStates spanStates = (SpanStates) rtChecker.updateRtSpans(contentObject, 0, contentObject.getText().length(), spanStatesBuild);
                    spenObjectTable3 = spenObjectTable;
                    cellSpanStatesApplyFromSpanStatesToCellSpanStates2 = applyFromSpanStatesToCellSpanStates(spanStates, cellSpanStatesApplyFromSpanStatesToCellSpanStates2, spenObjectTable3, pair.getFirst().intValue(), pair.getSecond().intValue());
                    spanStatesBuild = spanStates;
                } else {
                    spenObjectTable3 = spenObjectTable;
                }
                spenObjectTable = spenObjectTable3;
            }
            spenObjectTable2 = spenObjectTable;
            cellSpanStatesApplyFromSpanStatesToCellSpanStates = cellSpanStatesApplyFromSpanStatesToCellSpanStates2;
        }
        if (cellSpanStatesApplyFromSpanStatesToCellSpanStates == null) {
            cellSpanStatesApplyFromSpanStatesToCellSpanStates = applyFromSpanStatesToCellSpanStates(spanStatesBuild, cellSpanStatesApplyFromSpanStatesToCellSpanStates, spenObjectTable2, 0, 0);
            rtTableAndCellStylePresenter = this;
        } else {
            rtTableAndCellStylePresenter = this;
        }
        cellStyle.setBold(cellSpanStatesApplyFromSpanStatesToCellSpanStates.isBoldValue());
        cellStyle.setItalic(cellSpanStatesApplyFromSpanStatesToCellSpanStates.isItalicValue());
        cellStyle.setUnderline(cellSpanStatesApplyFromSpanStatesToCellSpanStates.isUnderlineValue());
        cellStyle.setStrikethrough(cellSpanStatesApplyFromSpanStatesToCellSpanStates.isStrikethroughValue());
        cellStyle.setFontSize(rtTableAndCellStylePresenter.mComposerViewPresenter.getTextManager().getFontSizeDelta() + cellSpanStatesApplyFromSpanStatesToCellSpanStates.getFontSizeValue());
        cellStyle.setFontColor(cellSpanStatesApplyFromSpanStatesToCellSpanStates.getForegroundColorValue());
        cellStyle.setCellBgColor(cellSpanStatesApplyFromSpanStatesToCellSpanStates.getCellBGColorValue());
        cellStyle.setCellBgColorEnabled(cellSpanStatesApplyFromSpanStatesToCellSpanStates.isCellBGColorEnabled());
        cellStyle.setAlign(cellSpanStatesApplyFromSpanStatesToCellSpanStates.getAlignValue());
        return cellStyle;
    }

    private int getTableLineTypeFromBorder(SpenObjectTable spenObjectTable) {
        ArrayList<SpenObjectTable.BorderStyle> borderStyles = spenObjectTable.getBorderStyles();
        if (borderStyles == null || borderStyles.isEmpty() || borderStyles.get(0).getStartRadius() > 0.0f) {
            return 0;
        }
        if (borderStyles.get(1).getWidth() > 0.0f) {
            return borderStyles.get(0).getWidth() > 0.0f ? 1 : 3;
        }
        ArrayList<SpenObjectTable.BorderStyle> defaultCellBorderStyles = spenObjectTable.getDefaultCellBorderStyles();
        if (defaultCellBorderStyles != null && !defaultCellBorderStyles.isEmpty()) {
            return defaultCellBorderStyles.get(1).getWidth() > 0.0f ? 2 : 4;
        }
        return 0;
    }

    @NonNull
    private TableStyle getTableStyle(SpenObjectTable spenObjectTable) {
        CellStyle cellStyle = getCellStyle(spenObjectTable, getAllCellPositions(spenObjectTable));
        TableStyle tableStyle = new TableStyle();
        tableStyle.setCellStyle(cellStyle);
        tableStyle.setHighlightHeaderRow(spenObjectTable.getHeadingRowEnabled());
        tableStyle.setHighlightHeaderColumn(spenObjectTable.getHeadingColumnEnabled());
        tableStyle.setTableLineType(getTableLineTypeFromBorder(spenObjectTable));
        return tableStyle;
    }

    public void applyCellStyle(CellStyle cellStyle) {
        if (cellStyle.isUpdatedData()) {
            ArrayList<Pair<Integer, Integer>> selectedCellPositions = this.mSpenObjectTable.getSelectedCellPositions();
            if (selectedCellPositions == null || selectedCellPositions.isEmpty()) {
                Logger.m11000e(TAG, "applyCellStyle# list is empty ");
                return;
            }
            this.mComposerViewPresenter.getObjectManager().commitHistory();
            this.mComposerViewPresenter.getObjectManager().getTableManager().applyCellStyle(this.mSpenObjectTable, selectedCellPositions, cellStyle);
            this.mComposerViewPresenter.getObjectManager().commitHistory();
        }
    }

    public void applyTableStyle(TableStyle tableStyle) {
        Logger.m10999d(TAG, "applyTableStyle# tableStyle = " + tableStyle.toString());
        this.mComposerViewPresenter.getObjectManager().commitHistory();
        this.mComposerViewPresenter.getObjectManager().getTableManager().applyTableStyle(this.mSpenObjectTable, tableStyle);
        this.mComposerViewPresenter.getObjectManager().commitHistory();
    }

    @Nullable
    public RectF getSelectedCellRect(int i) {
        Rect rect = new Rect();
        this.mComposerViewPresenter.getView().getGlobalVisibleRect(rect);
        return this.mComposerViewPresenter.getObjectManager().getSelectedCellRect(this.mSpenObjectTable, this.mTableControllerRect, rect, this.mIsClickedRows, i);
    }

    public boolean isSelectedHeaderCells() {
        ArrayList<Pair<Integer, Integer>> selectedCellPositions = this.mSpenObjectTable.getSelectedCellPositions();
        if (selectedCellPositions == null || selectedCellPositions.isEmpty()) {
            Logger.m11000e(TAG, "isSelectedHeaderCells# list is empty ");
            return false;
        }
        if (this.mSpenObjectTable.getHeadingRowEnabled() && selectedCellPositions.size() == this.mSpenObjectTable.getColumnsCount()) {
            Iterator<Pair<Integer, Integer>> it = selectedCellPositions.iterator();
            while (it.hasNext()) {
                if (it.next().getFirst().intValue() != 0) {
                    return false;
                }
            }
            return true;
        }
        if (!this.mSpenObjectTable.getHeadingColumnEnabled() || selectedCellPositions.size() != this.mSpenObjectTable.getRowsCount()) {
            return false;
        }
        Iterator<Pair<Integer, Integer>> it2 = selectedCellPositions.iterator();
        while (it2.hasNext()) {
            if (it2.next().getSecond().intValue() != 0) {
                return false;
            }
        }
        return true;
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.composer.ComposerViewContract.RtTableAndCellStyleContract
    public void showTableCellSetting(SpenObjectBase spenObjectBase, RectF rectF, boolean z) {
        if (!(spenObjectBase instanceof SpenObjectTable)) {
            Logger.m11000e(TAG, "showTableCellSetting# type error " + spenObjectBase);
            return;
        }
        this.mSpenObjectTable = (SpenObjectTable) spenObjectBase;
        this.mTableControllerRect = rectF;
        this.mIsClickedRows = z;
        if (this.mRtPresenter.getView() != null) {
            RtToolbarContract.IView view = this.mRtPresenter.getView();
            SpenObjectTable spenObjectTable = this.mSpenObjectTable;
            view.showTableCellSetting(getCellStyle(spenObjectTable, spenObjectTable.getSelectedCellPositions()));
        }
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.composer.ComposerViewContract.RtTableAndCellStyleContract
    public void showTableSetting(SpenObjectBase spenObjectBase, RectF rectF, boolean z) {
        if (!(spenObjectBase instanceof SpenObjectTable)) {
            Logger.m11000e(TAG, "showTableSetting# type error " + spenObjectBase);
            return;
        }
        this.mSpenObjectTable = (SpenObjectTable) spenObjectBase;
        this.mTableControllerRect = rectF;
        this.mIsClickedRows = z;
        if (this.mRtPresenter.getView() != null) {
            this.mRtPresenter.getView().showTableSetting(getTableStyle(this.mSpenObjectTable));
        }
    }

    public void updateTable() {
        this.mComposerViewPresenter.getObjectManager().getSelectedObjectManager().clearSelection();
    }
}
