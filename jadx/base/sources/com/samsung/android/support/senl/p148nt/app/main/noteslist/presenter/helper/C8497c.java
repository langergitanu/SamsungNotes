package com.samsung.android.support.senl.p148nt.app.main.noteslist.presenter.helper;

import android.view.MenuItem;
import androidx.appcompat.widget.PopupMenu;
import com.samsung.android.support.senl.p148nt.app.common.dialog.RestoreConfirmDialogFragment;

/* JADX INFO: renamed from: com.samsung.android.support.senl.nt.app.main.noteslist.presenter.helper.c */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class C8497c implements PopupMenu.OnDismissListener, PopupMenu.OnMenuItemClickListener, RestoreConfirmDialogFragment.DialogListener {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ Object f6199a;

    public /* synthetic */ C8497c(Object obj) {
        this.f6199a = obj;
    }

    @Override // androidx.appcompat.widget.PopupMenu.OnDismissListener
    public void onDismiss(PopupMenu popupMenu) {
        ((DragAndDropHelper) this.f6199a).lambda$showPopupMenuWithDragAction$1(popupMenu);
    }

    @Override // androidx.appcompat.widget.PopupMenu.OnMenuItemClickListener
    public boolean onMenuItemClick(MenuItem menuItem) {
        return ((DragAndDropHelper) this.f6199a).lambda$createPopupMenu$0(menuItem);
    }

    @Override // com.samsung.android.support.senl.nt.app.common.dialog.RestoreConfirmDialogFragment.DialogListener
    public void onPositiveButton(String str) {
        ((DialogHelper) this.f6199a).lambda$new$0(str);
    }
}
