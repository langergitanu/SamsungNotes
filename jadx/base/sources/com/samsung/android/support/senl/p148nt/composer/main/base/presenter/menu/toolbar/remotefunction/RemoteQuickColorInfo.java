package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.remotefunction;

import com.samsung.android.support.senl.p148nt.composer.main.base.model.menu.toolbar.p154hw.setting.data.SettingQuickColorData;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class RemoteQuickColorInfo {
    private static final String DIVIDE = ";";
    public SettingQuickColorData.HsvColor mHsvColor;
    public int mIndex;

    public RemoteQuickColorInfo(int i, float[] fArr) {
        this.mIndex = i;
        this.mHsvColor = new SettingQuickColorData.HsvColor(fArr);
    }

    public float[] getHsvColor() {
        return this.mHsvColor.getHsvColor();
    }

    public int getIndex() {
        return this.mIndex;
    }

    public String getString() {
        return this.mIndex + ";" + this.mHsvColor.getString();
    }

    public RemoteQuickColorInfo(String str) {
        this.mIndex = 0;
        String[] strArrSplit = str.split(";");
        this.mIndex = Integer.parseInt(strArrSplit[0]);
        this.mHsvColor = new SettingQuickColorData.HsvColor(strArrSplit[1]);
    }
}
