package com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.item;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.ViewTreeObserver;
import com.samsung.android.support.senl.p145cm.base.common.postprocessing.PostLaunchManager;
import com.samsung.android.support.senl.p148nt.base.common.access.notelist.NoteListAccessHandler;
import com.samsung.android.support.senl.p148nt.base.common.constants.SettingsConstants;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.p156sa.ComposerSA;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.p156sa.ComposerSAConstants;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class HwToolbarCustomToolbarSetting extends HwToolbarItem {
    private static final String TAG = Logger.createTag("HwToolbarCustomToolbarSetting");
    private final Runnable mResetHwToolbarRunnable;

    public HwToolbarCustomToolbarSetting(View view, HwToolbarItemContract hwToolbarItemContract) {
        super(view, hwToolbarItemContract);
        this.mResetHwToolbarRunnable = new Runnable() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.hw.item.HwToolbarCustomToolbarSetting.1
            @Override // java.lang.Runnable
            public void run() {
                HwToolbarCustomToolbarSetting.this.mHwToolbarItemManager.updateToolbarItemList();
            }
        };
    }

    private void launchCustomizeSetting(Context context) {
        if (context == null) {
            Logger.m11000e(TAG, "launchCustomizeSetting# context is null.");
            return;
        }
        if (NoteListAccessHandler.getSettingsActivity() == null) {
            PostLaunchManager.getInstance().executeBaseLogic(1);
        }
        Intent intent = new Intent(context, NoteListAccessHandler.getSettingsActivity());
        intent.setAction("android.intent.action.EDIT");
        intent.putExtra(SettingsConstants.FRAGMENT_TYPE, 12);
        intent.putExtra(SettingsConstants.KEY_CALLEE, SettingsConstants.CALLEE_COMPOSER);
        if (!(context instanceof Activity)) {
            intent.addFlags(268435456);
        }
        context.startActivity(intent);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.item.HwToolbarItem
    public void clearControl() {
        this.mHwToolbarItemManager.clearContextMenu();
        this.mWritingToolManager.clearControl();
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.item.HwToolbarItem
    public void functionEnable(boolean z) {
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.item.HwToolbarItem
    public void onClick() {
        Logger.m10999d(TAG, "onClick# ");
        this.mView.getViewTreeObserver().addOnWindowFocusChangeListener(new ViewTreeObserver.OnWindowFocusChangeListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.hw.item.HwToolbarCustomToolbarSetting.2
            @Override // android.view.ViewTreeObserver.OnWindowFocusChangeListener
            public void onWindowFocusChanged(boolean z) {
                if (z) {
                    HwToolbarCustomToolbarSetting.this.mView.getViewTreeObserver().removeOnWindowFocusChangeListener(this);
                    HwToolbarCustomToolbarSetting hwToolbarCustomToolbarSetting = HwToolbarCustomToolbarSetting.this;
                    hwToolbarCustomToolbarSetting.mView.postDelayed(hwToolbarCustomToolbarSetting.mResetHwToolbarRunnable, 500L);
                }
            }
        });
        ComposerSA.insertLog("234", ComposerSAConstants.EVENT_CUSTOMIZE_TOOLBAR_FROM_TOOLBAR_MENU);
        launchCustomizeSetting(this.mView.getContext());
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.item.HwToolbarItem
    public void release() {
        super.release();
        this.mView.removeCallbacks(this.mResetHwToolbarRunnable);
    }
}
