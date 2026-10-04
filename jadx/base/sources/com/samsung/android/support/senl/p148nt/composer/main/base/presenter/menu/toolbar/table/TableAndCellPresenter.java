package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.table;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.RectF;
import android.text.TextUtils;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.samsung.android.sdk.pen.document.SpenObjectBase;
import com.samsung.android.sdk.pen.document.SpenObjectTable;
import com.samsung.android.sdk.pen.document.SpenObjectTextBox;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.composer.TableManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.ComposerViewContract;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.ComposerViewPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.contextmenu.ContextMenuConstants;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.contextmenu.ContextMenuCopy;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.contextmenu.ContextMenuCut;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.contextmenu.ContextMenuManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.contextmenu.ContextMenuPaste;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.table.TableAndCellContract;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import kotlin.Pair;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class TableAndCellPresenter implements ComposerViewContract.TableAndCellContract {
    public static final String TAG = "TableAndCellPresenter";
    private final ComposerViewPresenter mComposerViewPresenter;
    private final ContextMenuManager mContextMenuManager;
    private boolean mIsClickedRows;
    private boolean mIsSelectedAllCells;
    private SpenObjectTable mSpenObjectTable;
    private RectF mTableControllerRect;

    @Nullable
    private TableAndCellContract.IView mView;

    public TableAndCellPresenter(@NonNull ComposerViewPresenter composerViewPresenter, @NonNull ContextMenuManager contextMenuManager) {
        this.mComposerViewPresenter = composerViewPresenter;
        this.mContextMenuManager = contextMenuManager;
    }

    private void deleteTable() {
        this.mComposerViewPresenter.getObjectManager().getTableManager().deleteTable(this.mSpenObjectTable);
        this.mComposerViewPresenter.getObjectManager().commitHistory();
        this.mComposerViewPresenter.getObjectManager().getSelectedObjectManager().clearSelection();
    }

    private int getEditableRowsCount() {
        return this.mComposerViewPresenter.getObjectManager().getTableManager().getEditableRowsCount(this.mSpenObjectTable);
    }

    public void addCells(int i, boolean z, boolean z2) {
        int i2;
        List<Integer> sortedEditableList = getSortedEditableList(z);
        int iIntValue = sortedEditableList.get(z2 ? sortedEditableList.size() - 1 : 0).intValue();
        int editableRowsCount = z ? getEditableRowsCount() : this.mSpenObjectTable.getColumnsCount();
        if (editableRowsCount + i > 30) {
            StringBuilder sb = new StringBuilder("addCells# can not add row = ");
            sb.append(z);
            sb.append(" currCount = ");
            sb.append(editableRowsCount);
            sb.append(" countToAdd = ");
            AbstractC8014b.m7195A(sb, TAG, i);
            if (editableRowsCount >= 30) {
                return;
            } else {
                i = 30 - editableRowsCount;
            }
        }
        for (int i4 = 0; i4 < i; i4++) {
            if (!z) {
                float minColumnWidth = this.mSpenObjectTable.getMinColumnWidth(iIntValue);
                float maxColumnWidth = this.mSpenObjectTable.getMaxColumnWidth(iIntValue);
                if (z2) {
                    SpenObjectTable spenObjectTable = this.mSpenObjectTable;
                    spenObjectTable.insertColumnAfter(iIntValue, spenObjectTable.getColumnWidth(iIntValue));
                    i2 = iIntValue + 1;
                } else {
                    SpenObjectTable spenObjectTable2 = this.mSpenObjectTable;
                    spenObjectTable2.insertColumn(iIntValue, spenObjectTable2.getColumnWidth(iIntValue));
                    i2 = iIntValue;
                }
                float columnWidth = this.mSpenObjectTable.getColumnWidth(i2);
                this.mSpenObjectTable.setMinColumnWidth(i2, Math.min(minColumnWidth, columnWidth));
                this.mSpenObjectTable.setMaxColumnWidth(i2, Math.max(maxColumnWidth, columnWidth));
            } else if (z2) {
                SpenObjectTable spenObjectTable3 = this.mSpenObjectTable;
                spenObjectTable3.insertRowBelow(iIntValue, spenObjectTable3.getRowHeight(iIntValue));
            } else {
                SpenObjectTable spenObjectTable4 = this.mSpenObjectTable;
                spenObjectTable4.insertRow(iIntValue, spenObjectTable4.getRowHeight(iIntValue));
            }
        }
        int i5 = z ? iIntValue + 1 : 0;
        int i6 = z ? 0 : iIntValue + 1;
        this.mComposerViewPresenter.getObjectManager().commitHistory();
        ArrayList<Pair<Integer, Integer>> arrayList = new ArrayList<>();
        arrayList.add(new Pair<>(Integer.valueOf(i5), Integer.valueOf(i6)));
        this.mSpenObjectTable.selectCells(arrayList);
        this.mComposerViewPresenter.getObjectManager().getSelectedObjectManager().setFocusCell(i5, i6, true);
    }

    public void calculateCell(boolean z, boolean z2) {
        this.mComposerViewPresenter.getObjectManager().getTableManager().calculateCell(this.mSpenObjectTable, z, z2);
        this.mComposerViewPresenter.getObjectManager().getSelectedObjectManager().clearSelection();
    }

    public boolean canPaste() {
        return this.mContextMenuManager.getContextMenu(ContextMenuConstants.ContextMenuCode.CONTEXT_MENU_ID_PASTE.getId()).canShow();
    }

    public void copyCell() {
        ((ContextMenuCopy) this.mContextMenuManager.getContextMenu(ContextMenuConstants.ContextMenuCode.CONTEXT_MENU_ID_COPY.getId())).executeMenu();
    }

    public void cutCell() {
        ((ContextMenuCut) this.mContextMenuManager.getContextMenu(ContextMenuConstants.ContextMenuCode.CONTEXT_MENU_ID_CUT.getId())).executeMenu();
    }

    public void deleteCell() {
        this.mComposerViewPresenter.getObjectManager().commitHistory();
        if (this.mIsSelectedAllCells) {
            deleteTable();
            return;
        }
        List<Integer> sortedList = getSortedList();
        for (int size = sortedList.size() - 1; size >= 0; size--) {
            int iIntValue = sortedList.get(size).intValue();
            if (this.mIsClickedRows) {
                this.mSpenObjectTable.deleteRow(iIntValue);
            } else {
                this.mSpenObjectTable.deleteColumn(iIntValue);
            }
        }
        if (this.mIsClickedRows && getEditableRowsCount() == 0) {
            deleteTable();
            return;
        }
        if (this.mIsClickedRows) {
            int columnsCount = this.mSpenObjectTable.getColumnsCount();
            for (int i = 0; i < columnsCount; i++) {
                if (findCalculatedCell(i).hasCalculatedCell()) {
                    this.mComposerViewPresenter.getObjectManager().getTableManager().onTableChanged(this.mSpenObjectTable, i);
                }
            }
        } else {
            this.mComposerViewPresenter.getObjectManager().getTableManager().removeEmptyCalculateCell(this.mSpenObjectTable);
        }
        this.mComposerViewPresenter.getObjectManager().commitHistory();
        int iIntValue2 = sortedList.get(0).intValue();
        if (iIntValue2 == (this.mIsClickedRows ? this.mSpenObjectTable.getRowsCount() : this.mSpenObjectTable.getColumnsCount())) {
            iIntValue2--;
        }
        boolean z = this.mIsClickedRows;
        int i2 = z ? iIntValue2 : 0;
        int i4 = z ? 0 : iIntValue2;
        if (z && !this.mSpenObjectTable.isEditable(i2, i4)) {
            i2--;
        }
        ArrayList<Pair<Integer, Integer>> arrayList = new ArrayList<>();
        arrayList.add(new Pair<>(Integer.valueOf(i2), Integer.valueOf(i4)));
        this.mSpenObjectTable.selectCells(arrayList);
        this.mComposerViewPresenter.getObjectManager().getSelectedObjectManager().setFocusCell(i2, i4, true);
        SpenObjectTextBox contentObject = this.mSpenObjectTable.getContentObject(i2, i4);
        if (TextUtils.isEmpty(contentObject.getText())) {
            return;
        }
        contentObject.setCursorPosition(contentObject.getText().length());
    }

    public TableManager.Calculation findCalculatedCell() {
        ArrayList<Pair<Integer, Integer>> selectedCellPositions = this.mSpenObjectTable.getSelectedCellPositions();
        return selectedCellPositions == null ? new TableManager.Calculation() : findCalculatedCell(selectedCellPositions.get(0).getSecond().intValue());
    }

    public Context getActivity() {
        return this.mComposerViewPresenter.getActivity();
    }

    public View getAnchorView() {
        return this.mComposerViewPresenter.getView();
    }

    public int getCountToAddCells(boolean z) {
        return 30 - (z ? getEditableRowsCount() : this.mSpenObjectTable.getColumnsCount());
    }

    public TableManager.Calculation getCurrentCellCalculationType() {
        ArrayList<Pair<Integer, Integer>> selectedCellPositions = this.mSpenObjectTable.getSelectedCellPositions();
        if (selectedCellPositions == null) {
            return new TableManager.Calculation();
        }
        Logger.m10999d(TAG, "getCurrentCellCalculationType# select cell: " + this.mSpenObjectTable.getSelectedCellPositions());
        SpenObjectTable.TableCell cell = this.mSpenObjectTable.getCell(selectedCellPositions.get(0).getFirst().intValue(), selectedCellPositions.get(0).getSecond().intValue());
        if (cell != null && !cell.getEditable()) {
            int extraDataInt = this.mSpenObjectTable.getContentObject(selectedCellPositions.get(0).getFirst().intValue(), selectedCellPositions.get(0).getSecond().intValue()).getExtraDataInt(TableManager.Calculation.KEY_TABLE_CALCULATION_TYPE);
            if (extraDataInt == 1) {
                return new TableManager.Calculation(true, false);
            }
            if (extraDataInt == 2) {
                return new TableManager.Calculation(false, true);
            }
        }
        return new TableManager.Calculation();
    }

    @Nullable
    public RectF getSelectedCellRect(int i) {
        Rect rect = new Rect();
        this.mComposerViewPresenter.getView().getGlobalVisibleRect(rect);
        return this.mComposerViewPresenter.getObjectManager().getSelectedCellRect(this.mSpenObjectTable, this.mTableControllerRect, rect, this.mIsClickedRows, i);
    }

    public List<Integer> getSortedEditableList(boolean z) {
        ArrayList<Pair<Integer, Integer>> selectedCellPositions = this.mSpenObjectTable.getSelectedCellPositions();
        HashSet hashSet = new HashSet();
        for (Pair<Integer, Integer> pair : selectedCellPositions) {
            if (!z) {
                hashSet.add(pair.getSecond());
            } else if (this.mSpenObjectTable.isEditable(pair.getFirst().intValue(), 0)) {
                hashSet.add(pair.getFirst());
            }
        }
        ArrayList arrayList = new ArrayList(hashSet);
        Collections.sort(arrayList);
        return arrayList;
    }

    @NonNull
    public List<Integer> getSortedList() {
        ArrayList<Pair<Integer, Integer>> selectedCellPositions = this.mSpenObjectTable.getSelectedCellPositions();
        HashSet hashSet = new HashSet();
        for (Pair<Integer, Integer> pair : selectedCellPositions) {
            Integer first = this.mIsClickedRows ? pair.getFirst() : pair.getSecond();
            first.intValue();
            hashSet.add(first);
        }
        ArrayList arrayList = new ArrayList(hashSet);
        Collections.sort(arrayList);
        return arrayList;
    }

    public void hideSoftInputAndExecute(Runnable runnable) {
        this.mComposerViewPresenter.hideSoftInputAndExecute(runnable);
    }

    public boolean isCalculatable() {
        if (this.mIsClickedRows) {
            return false;
        }
        ArrayList<Pair<Integer, Integer>> selectedCellPositions = this.mSpenObjectTable.getSelectedCellPositions();
        if (selectedCellPositions == null || selectedCellPositions.size() != this.mSpenObjectTable.getRowsCount()) {
            Logger.m10999d(TAG, "isCalculatable# selected 2 or more columns");
            return false;
        }
        int i = 0;
        for (Pair<Integer, Integer> pair : selectedCellPositions) {
            SpenObjectTable.TableCell cell = this.mSpenObjectTable.getCell(pair.getFirst().intValue(), pair.getSecond().intValue());
            if (cell != null && cell.getEditable()) {
                if (this.mComposerViewPresenter.getObjectManager().getTableManager().isOnlyDigits(this.mSpenObjectTable.getContentObject(pair.getFirst().intValue(), pair.getSecond().intValue()).getText())) {
                    i++;
                }
            }
        }
        AbstractC0000a.m3D(i, "isCalculatable# hasOnlyNumberCellsCount : ", TAG);
        return i > 1;
    }

    public boolean isClickedRows() {
        return this.mIsClickedRows;
    }

    public boolean isResizableCell() {
        int columnsCount = this.mSpenObjectTable.getColumnsCount();
        if (columnsCount < 1) {
            return false;
        }
        float columnWidth = this.mSpenObjectTable.getColumnWidth(0);
        float f = columnWidth;
        for (int i = 1; i < columnsCount; i++) {
            float columnWidth2 = this.mSpenObjectTable.getColumnWidth(i);
            if (columnWidth2 != columnWidth) {
                Logger.m10999d(TAG, "isResizableCell# Each cell width are not the same.");
                return true;
            }
            if (i < 5) {
                f += columnWidth2;
            }
        }
        if (Math.round(f) == ((int) this.mComposerViewPresenter.getObjectManager().getSpenNoteObjectInserter().getInsertObjectMaxRect(this.mComposerViewPresenter.getObjectManager().getNote().getPage(0), true).width())) {
            return false;
        }
        Logger.m10999d(TAG, "isResizableCell# tableWidth and pageWidth are not the same.");
        return true;
    }

    public boolean isSelectedAllCells() {
        return this.mIsSelectedAllCells;
    }

    public void pasteCell() {
        ArrayList<Pair<Integer, Integer>> selectedCellPositions = this.mSpenObjectTable.getSelectedCellPositions();
        if (selectedCellPositions != null) {
            this.mComposerViewPresenter.getObjectManager().getSelectedObjectManager().setFocusCell(selectedCellPositions.get(0).getFirst().intValue(), selectedCellPositions.get(0).getSecond().intValue(), true);
        }
        ((ContextMenuPaste) this.mContextMenuManager.getContextMenu(ContextMenuConstants.ContextMenuCode.CONTEXT_MENU_ID_PASTE.getId())).executeMenu();
    }

    public void removeCalculatedCell(boolean z) {
        this.mComposerViewPresenter.getObjectManager().getTableManager().removeCalculateCell(this.mSpenObjectTable, z);
        this.mComposerViewPresenter.getObjectManager().getSelectedObjectManager().clearSelection();
    }

    public void resizeCell() {
        RectF insertObjectMaxRect = this.mComposerViewPresenter.getObjectManager().getSpenNoteObjectInserter().getInsertObjectMaxRect(this.mComposerViewPresenter.getObjectManager().getNote().getPage(0), true);
        int columnsCount = this.mSpenObjectTable.getColumnsCount();
        float fWidth = insertObjectMaxRect.width() / Math.min(columnsCount, 5);
        for (int i = 0; i < columnsCount; i++) {
            this.mSpenObjectTable.setColumnWidth(i, fWidth);
        }
        this.mSpenObjectTable.setRect(insertObjectMaxRect, false);
        this.mComposerViewPresenter.getObjectManager().commitHistory();
    }

    public void setView(TableAndCellContract.IView iView) {
        Logger.m10999d(TAG, "setView#");
        this.mView = iView;
    }

    public void showCalculateAddMenu() {
        TableAndCellContract.IView iView = this.mView;
        if (iView != null) {
            iView.showCalculateMenu(true);
        }
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.composer.ComposerViewContract.TableAndCellContract
    public void showCalculateRemoveMenu(SpenObjectBase spenObjectBase) {
        if (!(spenObjectBase instanceof SpenObjectTable)) {
            Logger.m11000e(TAG, "showCalculateRemoveMenu# type error " + spenObjectBase);
            return;
        }
        this.mSpenObjectTable = (SpenObjectTable) spenObjectBase;
        this.mTableControllerRect = null;
        this.mIsClickedRows = false;
        this.mIsSelectedAllCells = false;
        TableAndCellContract.IView iView = this.mView;
        if (iView != null) {
            iView.showCalculateMenu(false);
        }
    }

    public void showCellStyle() {
        this.mComposerViewPresenter.getRtTableAndCellStylePresenter().showTableCellSetting(this.mSpenObjectTable, this.mTableControllerRect, this.mIsClickedRows);
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.composer.ComposerViewContract.TableAndCellContract
    public void showMoreMenu(SpenObjectBase spenObjectBase, RectF rectF, boolean z, boolean z2) {
        if (!(spenObjectBase instanceof SpenObjectTable)) {
            Logger.m11000e(TAG, "showMoreMenu# type error " + spenObjectBase);
            return;
        }
        SpenObjectTable spenObjectTable = (SpenObjectTable) spenObjectBase;
        this.mSpenObjectTable = spenObjectTable;
        this.mTableControllerRect = rectF;
        this.mIsClickedRows = z2;
        ArrayList<Pair<Integer, Integer>> selectedCellPositions = spenObjectTable.getSelectedCellPositions();
        if (selectedCellPositions == null || selectedCellPositions.isEmpty()) {
            this.mIsSelectedAllCells = false;
        } else {
            this.mIsSelectedAllCells = this.mSpenObjectTable.getColumnsCount() * this.mSpenObjectTable.getRowsCount() == selectedCellPositions.size();
        }
        TableAndCellContract.IView iView = this.mView;
        if (iView != null) {
            iView.showMoreMenu(z);
        }
    }

    public void showTableStyle() {
        this.mComposerViewPresenter.getRtTableAndCellStylePresenter().showTableSetting(this.mSpenObjectTable, this.mTableControllerRect, this.mIsClickedRows);
    }

    private TableManager.Calculation findCalculatedCell(int i) {
        if (this.mComposerViewPresenter.getObjectManager().getTableManager().isUnsuitableForTableCalculation(this.mSpenObjectTable)) {
            return new TableManager.Calculation();
        }
        int rowsCount = this.mSpenObjectTable.getRowsCount() - 1;
        int i2 = 0;
        boolean z = false;
        boolean z2 = false;
        while (i2 < 2) {
            SpenObjectTable.TableCell cell = this.mSpenObjectTable.getCell(rowsCount, i);
            if (cell != null && !cell.getEditable()) {
                int extraDataInt = this.mSpenObjectTable.getContentObject(rowsCount, i).getExtraDataInt(TableManager.Calculation.KEY_TABLE_CALCULATION_TYPE);
                if (extraDataInt == 1) {
                    z = true;
                } else if (extraDataInt == 2) {
                    z2 = true;
                }
            }
            i2++;
            rowsCount--;
        }
        return new TableManager.Calculation(z, z2);
    }
}
