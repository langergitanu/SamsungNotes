package com.samsung.android.support.senl.p148nt.app.sync.contractimpl;

import android.content.Context;
import com.samsung.android.support.senl.p148nt.app.sync.p150ui.dialog.NetworkConnectionFailedHelper;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public class AppInfoContractImpl {
    private final Context mAppContext;

    public AppInfoContractImpl(Context context) {
        this.mAppContext = context;
    }

    public Context getAppContext() {
        return this.mAppContext;
    }

    public String getCurrentTaskPacakageName(Context context) {
        return NetworkConnectionFailedHelper.getInstance().getCurrentTaskPacakageName(context);
    }

    public void reConnectedToMobile(Context context) {
        NetworkConnectionFailedHelper.getInstance().reConnectedToMobile(context);
    }

    public void reConnectedToWAN(Context context) {
        NetworkConnectionFailedHelper.getInstance().reConnectedToWAN(context);
    }

    public int updateCurrentType(Context context, int i) {
        return NetworkConnectionFailedHelper.getInstance().updateCurrentType(context, i);
    }
}
