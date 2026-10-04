package com.samsung.android.spen.libse;

import android.content.Context;
import com.samsung.android.spen.libinterface.DesktopModeManagerInterface;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class SeDesktopModeManager implements DesktopModeManagerInterface {
    Context mContext;

    public SeDesktopModeManager(Context context) {
        this.mContext = context;
    }

    @Override // com.samsung.android.spen.libinterface.DesktopModeManagerInterface
    public boolean isDesktopMode() {
        this.mContext.getResources().getConfiguration();
        return 1 == 1;
    }
}
