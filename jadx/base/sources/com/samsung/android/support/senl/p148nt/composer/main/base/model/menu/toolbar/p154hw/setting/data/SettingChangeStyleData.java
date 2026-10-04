package com.samsung.android.support.senl.p148nt.composer.main.base.model.menu.toolbar.p154hw.setting.data;

import android.graphics.Color;
import androidx.annotation.NonNull;
import com.samsung.android.sdk.pen.SpenSettingUIChangeStyleInfo;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.menu.toolbar.p154hw.setting.SPenPreferenceResolver;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.menu.toolbar.p154hw.setting.SPenVersion;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.menu.toolbar.p154hw.setting.constants.Default;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.menu.toolbar.p154hw.setting.migration.AbsMigrationPolicy;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.menu.toolbar.p154hw.setting.migration.LegacyVersionException;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class SettingChangeStyleData extends AbsMigrationPolicy<SpenSettingUIChangeStyleInfo> {
    private static final String KEY_SETTING_CHANGE_STYLE_INFO = "KEY_SETTING_HIGHLIGHTER_INFO";
    private static final String KEY_SETTING_CHANGE_STYLE_IS_BLANK_SHAPE = "KEY_SETTING_CHANGE_STYLE_IS_BLANK_SHAPE";
    private static final String KEY_SETTING_CHANGE_STYLE_TYPE = "KEY_SETTING_CHANGE_STYLE_TYPE";
    private static final String TAG = Logger.createTag("SettingChangeStyleData");
    private SpenSettingUIChangeStyleInfo mChangeStyleInfo;
    private ArrayList<ChangeStyleInfoChangeListener> mChangeStyleInfoChangeListener;
    private boolean mIsSelectionBlankShape;
    private int mIsSelectionType;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface ChangeStyleInfoChangeListener {
        void onChangeStyleInfoChanged(SpenSettingUIChangeStyleInfo spenSettingUIChangeStyleInfo);
    }

    public SettingChangeStyleData() {
        super(KEY_SETTING_CHANGE_STYLE_INFO);
        this.mChangeStyleInfoChangeListener = new ArrayList<>();
        SpenSettingUIChangeStyleInfo spenSettingUIChangeStyleInfo = new SpenSettingUIChangeStyleInfo();
        this.mChangeStyleInfo = spenSettingUIChangeStyleInfo;
        super.restore(spenSettingUIChangeStyleInfo);
        this.mIsSelectionType = SPenPreferenceResolver.getInt(KEY_SETTING_CHANGE_STYLE_TYPE, 0);
        this.mIsSelectionBlankShape = SPenPreferenceResolver.getBoolean(KEY_SETTING_CHANGE_STYLE_IS_BLANK_SHAPE, true);
    }

    private static void colorCorrection(int i, float[] fArr) {
        int i2 = i | (-16777216);
        if (i2 != Color.HSVToColor(fArr)) {
            Logger.m11003i(TAG, "Different with color and hsv");
            Color.colorToHSV(i2, fArr);
        }
    }

    public static void convertToSpenSettingChangeStyleInfo(SpenSettingUIChangeStyleInfo spenSettingUIChangeStyleInfo, String str) {
        String[] strArrSplit = str.split(":");
        spenSettingUIChangeStyleInfo.sizeLevel = Integer.parseInt(strArrSplit[0]);
        spenSettingUIChangeStyleInfo.color = Integer.parseInt(strArrSplit[1]);
        spenSettingUIChangeStyleInfo.fillColor = Integer.parseInt(strArrSplit[2]);
        spenSettingUIChangeStyleInfo.strokeColorUIInfo = Integer.parseInt(strArrSplit[3]);
        spenSettingUIChangeStyleInfo.fillColorUIInfo = Integer.parseInt(strArrSplit[4]);
        spenSettingUIChangeStyleInfo.strokeHSVColor[0] = Float.parseFloat(strArrSplit[5]);
        spenSettingUIChangeStyleInfo.strokeHSVColor[1] = Float.parseFloat(strArrSplit[6]);
        spenSettingUIChangeStyleInfo.strokeHSVColor[2] = Float.parseFloat(strArrSplit[7]);
        spenSettingUIChangeStyleInfo.fillHSVColor[0] = Float.parseFloat(strArrSplit[8]);
        spenSettingUIChangeStyleInfo.fillHSVColor[1] = Float.parseFloat(strArrSplit[9]);
        spenSettingUIChangeStyleInfo.fillHSVColor[2] = Float.parseFloat(strArrSplit[10]);
        colorCorrection(spenSettingUIChangeStyleInfo.color, spenSettingUIChangeStyleInfo.strokeHSVColor);
        colorCorrection(spenSettingUIChangeStyleInfo.fillColor, spenSettingUIChangeStyleInfo.fillHSVColor);
        String str2 = TAG;
        StringBuilder sb = new StringBuilder("ChangeStyle color: ");
        sb.append(spenSettingUIChangeStyleInfo.color);
        sb.append(":");
        AbstractC8014b.m7195A(sb, str2, spenSettingUIChangeStyleInfo.sizeLevel);
    }

    public static String convertToString(SpenSettingUIChangeStyleInfo spenSettingUIChangeStyleInfo) {
        return spenSettingUIChangeStyleInfo.sizeLevel + ":" + spenSettingUIChangeStyleInfo.color + ":" + spenSettingUIChangeStyleInfo.fillColor + ":" + spenSettingUIChangeStyleInfo.strokeColorUIInfo + ":" + spenSettingUIChangeStyleInfo.fillColorUIInfo + ":" + spenSettingUIChangeStyleInfo.strokeHSVColor[0] + ":" + spenSettingUIChangeStyleInfo.strokeHSVColor[1] + ":" + spenSettingUIChangeStyleInfo.strokeHSVColor[2] + ":" + spenSettingUIChangeStyleInfo.fillHSVColor[0] + ":" + spenSettingUIChangeStyleInfo.fillHSVColor[1] + ":" + spenSettingUIChangeStyleInfo.fillHSVColor[2];
    }

    private void migrateChangeStyleInfoUntil_4_1(SpenSettingUIChangeStyleInfo spenSettingUIChangeStyleInfo, String str) {
        String[] strArrSplit = str.split(":");
        spenSettingUIChangeStyleInfo.color = Integer.parseInt(strArrSplit[0]);
        spenSettingUIChangeStyleInfo.strokeHSVColor[0] = Float.parseFloat(strArrSplit[1]);
        spenSettingUIChangeStyleInfo.strokeHSVColor[1] = Float.parseFloat(strArrSplit[2]);
        spenSettingUIChangeStyleInfo.strokeHSVColor[2] = Float.parseFloat(strArrSplit[3]);
        spenSettingUIChangeStyleInfo.strokeColorUIInfo = Integer.parseInt(strArrSplit[4]);
        spenSettingUIChangeStyleInfo.sizeLevel = Integer.parseInt(strArrSplit[6]);
        colorCorrection(spenSettingUIChangeStyleInfo.color, spenSettingUIChangeStyleInfo.strokeHSVColor);
    }

    private void saveChangeStyleData() {
        if (this.mChangeStyleInfo == null) {
            return;
        }
        String infoString = getInfoString();
        AbstractC8014b.m7197C("saveChangeStyleData : ", infoString, TAG);
        ArrayList<ChangeStyleInfoChangeListener> arrayList = this.mChangeStyleInfoChangeListener;
        if (arrayList != null) {
            Iterator<ChangeStyleInfoChangeListener> it = arrayList.iterator();
            while (it.hasNext()) {
                it.next().onChangeStyleInfoChanged(this.mChangeStyleInfo);
            }
        }
        super.saveData(infoString);
    }

    public void close() {
        this.mChangeStyleInfo = null;
        ArrayList<ChangeStyleInfoChangeListener> arrayList = this.mChangeStyleInfoChangeListener;
        if (arrayList != null) {
            arrayList.clear();
            this.mChangeStyleInfoChangeListener = null;
        }
    }

    public SpenSettingUIChangeStyleInfo getChangeStyleInfo() {
        return this.mChangeStyleInfo;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.model.menu.toolbar.p154hw.setting.migration.AbsMigrationPolicy
    public String getInfoString() {
        return convertToString(this.mChangeStyleInfo);
    }

    public int getSelectionType() {
        AbstractC8014b.m7195A(new StringBuilder("getSelectionType : "), TAG, this.mIsSelectionType);
        return this.mIsSelectionType;
    }

    public boolean isSelectionBlankShape() {
        AbstractC8014b.m7222x(new StringBuilder("isSelectionBlankShape : "), this.mIsSelectionBlankShape, TAG);
        return this.mIsSelectionBlankShape;
    }

    public final void registerChangeStyleInfoChangeListener(ChangeStyleInfoChangeListener changeStyleInfoChangeListener) {
        this.mChangeStyleInfoChangeListener.add(changeStyleInfoChangeListener);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.model.menu.toolbar.p154hw.setting.migration.AbsMigrationPolicy
    public boolean replace(String str) {
        return super.replace(this.mChangeStyleInfo, str);
    }

    public void setChangeStyleInfo(@NonNull SpenSettingUIChangeStyleInfo spenSettingUIChangeStyleInfo) {
        this.mChangeStyleInfo.copy(spenSettingUIChangeStyleInfo);
        SpenSettingUIChangeStyleInfo spenSettingUIChangeStyleInfo2 = this.mChangeStyleInfo;
        spenSettingUIChangeStyleInfo2.type = 0;
        spenSettingUIChangeStyleInfo2.isBlankShape = true;
        saveChangeStyleData();
    }

    public void setSelectionBlankShape(boolean z) {
        AbstractC8014b.m7224z("setSelectionBlankShape : ", TAG, z);
        this.mIsSelectionBlankShape = z;
        SPenPreferenceResolver.setBoolean(KEY_SETTING_CHANGE_STYLE_IS_BLANK_SHAPE, z);
    }

    public void setSelectionType(int i) {
        AbstractC8014b.m7217s(i, "setSelectionType : ", TAG);
        this.mIsSelectionType = i;
        SPenPreferenceResolver.setInt(KEY_SETTING_CHANGE_STYLE_TYPE, i);
    }

    public void unregisterChangeStyleInfoChangeListener(ChangeStyleInfoChangeListener changeStyleInfoChangeListener) {
        ArrayList<ChangeStyleInfoChangeListener> arrayList = this.mChangeStyleInfoChangeListener;
        if (arrayList == null || changeStyleInfoChangeListener == null) {
            return;
        }
        arrayList.remove(changeStyleInfoChangeListener);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.model.menu.toolbar.p154hw.setting.migration.AbsMigrationPolicy
    public void loadDefault(SpenSettingUIChangeStyleInfo spenSettingUIChangeStyleInfo) {
        this.mIsSelectionType = 0;
        this.mIsSelectionBlankShape = true;
        spenSettingUIChangeStyleInfo.isBlankShape = true;
        spenSettingUIChangeStyleInfo.color = Default.CHANGE_STYLE_COLOR;
        spenSettingUIChangeStyleInfo.sizeLevel = 30;
        spenSettingUIChangeStyleInfo.fillColor = Default.CHANGE_STYLE_COLOR;
        colorCorrection(Default.CHANGE_STYLE_COLOR, spenSettingUIChangeStyleInfo.strokeHSVColor);
        colorCorrection(spenSettingUIChangeStyleInfo.fillColor, spenSettingUIChangeStyleInfo.fillHSVColor);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.model.menu.toolbar.p154hw.setting.migration.AbsMigrationPolicy
    public void loadPreference(SpenSettingUIChangeStyleInfo spenSettingUIChangeStyleInfo, String str) {
        convertToSpenSettingChangeStyleInfo(spenSettingUIChangeStyleInfo, str);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.model.menu.toolbar.p154hw.setting.migration.AbsMigrationPolicy
    public void migrate(SpenSettingUIChangeStyleInfo spenSettingUIChangeStyleInfo, LegacyVersionException legacyVersionException) {
        SPenVersion.Version version = legacyVersionException.getVersion();
        Logger.m11003i(TAG, "migrateByVersion " + version.name());
        if (version.ordinal() <= SPenVersion.Version.V4_1.ordinal()) {
            migrateChangeStyleInfoUntil_4_1(spenSettingUIChangeStyleInfo, legacyVersionException.getValue());
        } else {
            convertToSpenSettingChangeStyleInfo(spenSettingUIChangeStyleInfo, legacyVersionException.getValue());
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.model.menu.toolbar.p154hw.setting.migration.AbsMigrationPolicy
    public void store(SpenSettingUIChangeStyleInfo spenSettingUIChangeStyleInfo) {
        saveChangeStyleData();
    }
}
