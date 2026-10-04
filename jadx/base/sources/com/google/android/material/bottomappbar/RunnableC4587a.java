package com.google.android.material.bottomappbar;

import android.view.View;
import com.google.android.material.internal.ViewUtils;
import com.samsung.android.sdk.pen.setting.quicktool.SpenCurvedSwitchLayout;
import com.samsung.android.sdk.pen.setting.quicktool.SpenQTPenItemVisibilityController;
import com.samsung.android.support.senl.p148nt.app.main.folder.view.mode.ManageSyncMode;
import com.samsung.android.support.senl.p148nt.app.settings.importnotes.folderlist.adapter.ImportFolderAdapter;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.quicktool.docking.QTCurvedSwitchLayout;

/* JADX INFO: renamed from: com.google.android.material.bottomappbar.a */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class RunnableC4587a implements Runnable {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f2238a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ View f2239b;

    public /* synthetic */ RunnableC4587a(View view, int i) {
        this.f2238a = i;
        this.f2239b = view;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f2238a) {
            case 0:
                this.f2239b.requestLayout();
                break;
            case 1:
                ViewUtils.requestFocusAndShowKeyboard(this.f2239b, false);
                break;
            case 2:
                this.f2239b.sendAccessibilityEvent(8);
                break;
            case 3:
                SpenCurvedSwitchLayout.updateImageThumbContainer$lambda$3(this.f2239b);
                break;
            case 4:
                this.f2239b.setVisibility(8);
                break;
            case 5:
                SpenQTPenItemVisibilityController.startScaleUpVisibleAnimator$lambda$7(this.f2239b);
                break;
            case 6:
                this.f2239b.setVisibility(0);
                break;
            case 7:
                this.f2239b.requestLayout();
                break;
            case 8:
                this.f2239b.requestLayout();
                break;
            case 9:
                ManageSyncMode.lambda$onOptionsItemSelected$0(this.f2239b);
                break;
            case 10:
                this.f2239b.setPressed(false);
                break;
            case 11:
                ImportFolderAdapter.mFolderClickListener$lambda$5$lambda$3(this.f2239b);
                break;
            default:
                QTCurvedSwitchLayout.updateImageThumbContainer$lambda$3(this.f2239b);
                break;
        }
    }
}
