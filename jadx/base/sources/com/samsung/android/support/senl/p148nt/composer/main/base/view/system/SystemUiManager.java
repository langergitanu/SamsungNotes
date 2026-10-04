package com.samsung.android.support.senl.p148nt.composer.main.base.view.system;

import android.app.Activity;
import android.view.View;
import android.view.WindowManager;
import androidx.appcompat.widget.AbstractC0541b;
import com.samsung.android.support.senl.p145cm.base.framework.view.WindowManagerCompat;
import com.samsung.android.support.senl.p148nt.base.common.util.ContextUtils;
import com.samsung.android.support.senl.p148nt.base.common.util.SystemUi;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class SystemUiManager {
    private static final String TAG = Logger.createTag("SystemUiManager");
    private final IStatusBar mStatusBar;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface Contract {
        boolean isSearchMode();
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class EmptyStatusBar implements IStatusBar {
        @Override // com.samsung.android.support.senl.nt.composer.main.base.view.system.SystemUiManager.IStatusBar
        public void initStatusBar(Activity activity) {
        }

        @Override // com.samsung.android.support.senl.nt.composer.main.base.view.system.SystemUiManager.IStatusBar
        public void updateStatusBar(Activity activity) {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface IStatusBar {
        void initStatusBar(Activity activity);

        void updateStatusBar(Activity activity);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class StatusBar implements IStatusBar {
        Contract mContract;

        public StatusBar(Contract contract) {
            this.mContract = contract;
        }

        /* JADX WARN: Removed duplicated region for block: B:10:0x0076  */
        @Override // com.samsung.android.support.senl.nt.composer.main.base.view.system.SystemUiManager.IStatusBar
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void initStatusBar(Activity activity) {
            int i = 1;
            SystemUi.setStatusBarTheme(activity.getWindow(), !ContextUtils.isNightMode(activity));
            View decorView = activity.getWindow().getDecorView();
            WindowManagerCompat.getInstance().setResizeFullscreenWindowOnSoftInput(activity);
            int i2 = decorView.getResources().getConfiguration().orientation;
            String str = SystemUiManager.TAG;
            StringBuilder sbM778t = AbstractC0541b.m778t(i2, "initStatusBar# orientation : ", " / ");
            sbM778t.append(activity.getResources().getConfiguration().orientation);
            Logger.m10999d(str, sbM778t.toString());
            int rotation = ((WindowManager) activity.getSystemService("window")).getDefaultDisplay().getRotation();
            if (rotation == 0 || rotation == 2) {
                if (i2 == 2) {
                    Logger.m10999d(SystemUiManager.TAG, "initStatusBar#  change orientation : 1");
                } else {
                    i = i2;
                }
            } else if (i2 == 1) {
                Logger.m10999d(SystemUiManager.TAG, "initStatusBar#  change orientation : 2");
                i = 2;
            }
            WindowManagerCompat.getInstance().controllIndicatorBar(activity, i, this.mContract.isSearchMode());
        }

        @Override // com.samsung.android.support.senl.nt.composer.main.base.view.system.SystemUiManager.IStatusBar
        public void updateStatusBar(Activity activity) {
            WindowManagerCompat.getInstance().controllIndicatorBar(activity, activity.getResources().getConfiguration().orientation, this.mContract.isSearchMode());
        }
    }

    public SystemUiManager(boolean z, Contract contract) {
        if (z) {
            this.mStatusBar = new StatusBar(contract);
        } else {
            this.mStatusBar = new EmptyStatusBar();
        }
    }

    public IStatusBar getStatusBar() {
        return this.mStatusBar;
    }
}
