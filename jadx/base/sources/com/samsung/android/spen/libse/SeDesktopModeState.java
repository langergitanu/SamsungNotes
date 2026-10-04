package com.samsung.android.spen.libse;

import android.content.Context;
import com.samsung.android.desktopmode.SemDesktopModeManager;
import com.samsung.android.desktopmode.SemDesktopModeState;
import com.samsung.android.spen.libinterface.DesktopModeStateInterface;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class SeDesktopModeState implements DesktopModeStateInterface {
    SemDesktopModeState mDesktopModeState;

    public SeDesktopModeState(Context context) {
        this.mDesktopModeState = ((SemDesktopModeManager) context.getApplicationContext().getSystemService("desktopmode")).getDesktopModeState();
    }

    @Override // com.samsung.android.spen.libinterface.DesktopModeStateInterface
    public int getDisplayType() {
        return this.mDesktopModeState.getDisplayType();
    }

    @Override // com.samsung.android.spen.libinterface.DesktopModeStateInterface
    public int getDisplayTypeDualConstant() {
        return 102;
    }

    @Override // com.samsung.android.spen.libinterface.DesktopModeStateInterface
    public int getDisplayTypeStandaloneConstant() {
        return 101;
    }

    @Override // com.samsung.android.spen.libinterface.DesktopModeStateInterface
    public int getEnabled() {
        return this.mDesktopModeState.getEnabled();
    }

    @Override // com.samsung.android.spen.libinterface.DesktopModeStateInterface
    public int getEnabledConstant() {
        return 4;
    }
}
