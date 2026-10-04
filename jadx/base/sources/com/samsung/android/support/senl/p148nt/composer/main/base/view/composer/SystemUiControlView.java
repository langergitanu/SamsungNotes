package com.samsung.android.support.senl.p148nt.composer.main.base.view.composer;

import android.app.Activity;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import com.samsung.android.support.senl.p148nt.base.common.util.SystemUi;
import com.samsung.android.support.senl.p148nt.base.winset.view.toolbar.CustomToolbarFragment;
import com.samsung.android.support.senl.p148nt.base.winset.view.toolbar.ICustomToolbar;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class SystemUiControlView {
    private static final String TAG = "SystemUiControlView";

    public ICustomToolbar getCustomAppToolbar(Activity activity) {
        Fragment fragmentFindFragmentByTag = ((AppCompatActivity) activity).getSupportFragmentManager().findFragmentByTag("Composer");
        if (fragmentFindFragmentByTag != null && fragmentFindFragmentByTag.isAdded() && (fragmentFindFragmentByTag instanceof CustomToolbarFragment)) {
            return ((CustomToolbarFragment) fragmentFindFragmentByTag).getSupportedToolbar();
        }
        Logger.m11000e(TAG, "getCustomAppToolbar null# ");
        return null;
    }

    public void updateToShowHideStatusBar(Activity activity, boolean z) {
        SystemUi.setHideStatusBarModeEnable(activity, z);
    }
}
