package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.listener;

import android.view.ActionMode;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import com.samsung.android.sdk.pen.view.contextmenu.SpenContextMenuListener;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.base.common.UserInputSkipper;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.info.DragAndDropInfo;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.contextmenu.ContextMenuContract;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class ContextMenuListenerImpl extends SpenContextMenuListener {
    private static final String TAG = Logger.createTag("ContextMenuListenerImpl");
    private final Set<String> mBlockContextMenuKeySet = new HashSet();
    private ContextMenuContract mContextMenuManager;
    private DragAndDropInfo mDragAndDropInfo;

    public void blockContextMenu(String str, boolean z) {
        Logger.m11003i(TAG, "blockContextMenu# " + str + ": " + z);
        if (z) {
            this.mBlockContextMenuKeySet.add(str);
        } else {
            this.mBlockContextMenuKeySet.remove(str);
        }
    }

    @Override // com.samsung.android.sdk.pen.view.contextmenu.SpenContextMenuListener
    public boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {
        this.mContextMenuManager.executeMenuItem(menuItem, true);
        return true;
    }

    @Override // com.samsung.android.sdk.pen.view.contextmenu.SpenContextMenuListener
    public boolean onCreateActionMode(ActionMode actionMode, Menu menu) {
        if (!UserInputSkipper.isValidEvent(UserInputSkipper.Tag.ContextMenu)) {
            Logger.m11003i(TAG, "onCreateActionMode# UserInputSkipper isValidEvent");
            return false;
        }
        if (!this.mBlockContextMenuKeySet.isEmpty()) {
            Logger.m11003i(TAG, "onCreateActionMode# mBlockShowKeySet is not empty");
            return false;
        }
        DragAndDropInfo dragAndDropInfo = this.mDragAndDropInfo;
        if (dragAndDropInfo != null && dragAndDropInfo.isEnabled()) {
            Logger.m11003i(TAG, "onCreateActionMode# DragAndDrop is enable");
            return false;
        }
        ContextMenuContract contextMenuContract = this.mContextMenuManager;
        if (contextMenuContract == null) {
            Logger.m11000e(TAG, "onCreateActionMode# mContextMenuManager is null");
            return false;
        }
        if (!contextMenuContract.createContextMenu(menu, true)) {
            Logger.m11003i(TAG, "onCreateActionMode# return false");
            return false;
        }
        boolean zCanShowContextMenu = this.mContextMenuManager.canShowContextMenu(menu);
        AbstractC8014b.m7224z("onCreateActionMode# show result : ", TAG, zCanShowContextMenu);
        return zCanShowContextMenu;
    }

    @Override // com.samsung.android.sdk.pen.view.contextmenu.SpenContextMenuListener
    public void onCreateContextMenu(ContextMenu contextMenu) {
        UserInputSkipper.setHoldingEventTime(700L, UserInputSkipper.Tag.ContextMenu);
        if (!this.mBlockContextMenuKeySet.isEmpty()) {
            Logger.m11003i(TAG, "onCreateContextMenu# mBlockShowKeySet is not empty");
            return;
        }
        DragAndDropInfo dragAndDropInfo = this.mDragAndDropInfo;
        if (dragAndDropInfo != null && dragAndDropInfo.isEnabled()) {
            Logger.m11003i(TAG, "onCreateContextMenu# DragAndDrop is enable");
            return;
        }
        ContextMenuContract contextMenuContract = this.mContextMenuManager;
        if (contextMenuContract == null) {
            Logger.m11000e(TAG, "onCreateContextMenu# mContextMenuManager is null");
        } else {
            contextMenuContract.createContextMenu(contextMenu, false);
            Logger.m11003i(TAG, "onCreateContextMenu# show : ");
        }
    }

    public boolean onPerformContextMenuAction(int i) {
        return this.mContextMenuManager.onPerformContextMenuAction(i);
    }

    public void setContextMenuManager(ContextMenuContract contextMenuContract) {
        this.mContextMenuManager = contextMenuContract;
    }

    public void setDragAndDropInfo(DragAndDropInfo dragAndDropInfo) {
        this.mDragAndDropInfo = dragAndDropInfo;
    }
}
