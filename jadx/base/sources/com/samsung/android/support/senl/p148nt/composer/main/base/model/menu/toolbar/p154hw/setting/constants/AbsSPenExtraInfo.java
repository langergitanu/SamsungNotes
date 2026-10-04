package com.samsung.android.support.senl.p148nt.composer.main.base.model.menu.toolbar.p154hw.setting.constants;

import androidx.annotation.DrawableRes;
import com.samsung.android.sdk.pen.SpenSettingUIPenInfo;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbsSPenExtraInfo extends SpenSettingUIPenInfo {
    public boolean isStraightType = false;
    public ArrayList<String> legacyNames;

    @DrawableRes
    public int penDrawableColorId;

    @DrawableRes
    public int penDrawableId;
    public int sizeLevelTablet;

    public boolean anyMatch(String str) {
        if (this.name.equals(str)) {
            return true;
        }
        ArrayList<String> arrayList = this.legacyNames;
        if (arrayList != null) {
            return arrayList.contains(str);
        }
        return false;
    }

    public void useSizeLevelTablet() {
        this.sizeLevel = this.sizeLevelTablet;
    }
}
