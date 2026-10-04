package com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.table;

import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.table.TableAndCellContract;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.table.TableAndCellPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class TableAndCellMenu implements TableAndCellContract.IView {
    private static final String TAG = Logger.createTag("TableAndCellMenu");
    private final ViewGroup mMenuContainer;
    private final TableAndCellPresenter mPresenter;
    private final TableAndCellMoreMenu mTableAndCellMoreMenu;
    private final TableCalculateMenu mTableCalculateMenu;

    public TableAndCellMenu(ViewGroup viewGroup, TableAndCellPresenter tableAndCellPresenter) {
        this.mMenuContainer = viewGroup;
        this.mPresenter = tableAndCellPresenter;
        tableAndCellPresenter.setView(this);
        this.mTableAndCellMoreMenu = new TableAndCellMoreMenu(tableAndCellPresenter);
        this.mTableCalculateMenu = new TableCalculateMenu(tableAndCellPresenter);
    }

    public void onConfigurationChanged() {
        this.mMenuContainer.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.table.TableAndCellMenu.1
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                TableAndCellMenu.this.mMenuContainer.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                TableAndCellMenu.this.mTableAndCellMoreMenu.update();
                TableAndCellMenu.this.mTableCalculateMenu.update();
            }
        });
    }

    public void release() {
        this.mTableAndCellMoreMenu.hide();
        this.mTableCalculateMenu.hide();
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.toolbar.table.TableAndCellContract.IView
    public void showCalculateMenu(boolean z) {
        this.mTableCalculateMenu.show(z);
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.toolbar.table.TableAndCellContract.IView
    public void showMoreMenu(boolean z) {
        this.mTableAndCellMoreMenu.show(z);
    }
}
