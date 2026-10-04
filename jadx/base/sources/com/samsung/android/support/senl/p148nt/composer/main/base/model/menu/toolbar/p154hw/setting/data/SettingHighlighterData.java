package com.samsung.android.support.senl.p148nt.composer.main.base.model.menu.toolbar.p154hw.setting.data;

import android.graphics.Color;
import androidx.collection.AbstractC0622a;
import androidx.compose.runtime.AbstractC1974b;
import com.samsung.android.sdk.pen.SpenSettingUIPenInfo;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.menu.toolbar.p154hw.setting.SPenPreferenceResolver;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.menu.toolbar.p154hw.setting.SPenVersion;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.menu.toolbar.p154hw.setting.constants.Default;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.menu.toolbar.p154hw.setting.migration.AbsMigrationPolicy;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.menu.toolbar.p154hw.setting.migration.LegacyVersionException;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.setting.HwSettingContract;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.CommonUtil;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import java.util.ArrayList;
import java.util.HashMap;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class SettingHighlighterData extends AbsMigrationPolicy<ArrayList<SpenSettingUIPenInfo>> {
    private static final String KEY_SETTING_HIGHLIGHTER_PEN_INFO = "KEY_SETTING_HIGHLIGHTER_PEN_INFO";
    private static final String LEGACY_KEY_INFO_BEFORE_SEPARATE_PEN_AND_HIGHLIGHTER = "KEY_SETTING_PEN_INFO";
    private static final int PEN_INFO_ITEM_COUNT = 14;
    private static final String TAG = Logger.createTag("SettingHighlighterData");
    private ArrayList<SpenSettingUIPenInfo> mPenInfoList;
    private int mSelectedHighlighterIndex;
    private String mSelectedPenName;
    private HwSettingContract.ISettingInfoManger mSettingInfoManger;

    public SettingHighlighterData(HwSettingContract.ISettingInfoManger iSettingInfoManger) {
        super(KEY_SETTING_HIGHLIGHTER_PEN_INFO);
        this.mSelectedPenName = "";
        this.mSettingInfoManger = iSettingInfoManger;
        ArrayList<SpenSettingUIPenInfo> arrayList = new ArrayList<>();
        this.mPenInfoList = arrayList;
        restore(arrayList);
    }

    private int getSelectedIndex(String str) {
        return Integer.parseInt(str.split(";")[0].split(":")[1]);
    }

    private void loadDefaultInfo(ArrayList<SpenSettingUIPenInfo> arrayList) {
        loadDefaultInfoList(arrayList);
    }

    private void loadDefaultInfoList(ArrayList<SpenSettingUIPenInfo> arrayList) {
        arrayList.clear();
        for (Default.Highlighter highlighter : Default.Highlighter.values()) {
            arrayList.add(highlighter.getDefault());
        }
        this.mSelectedHighlighterIndex = Default.DEFAULT_HIGHLIGHTER.ordinal();
    }

    private String loadHighlighterFromPenData() {
        return SPenPreferenceResolver.getLatestString(SPenVersion.Version.V3_0, "KEY_SETTING_PEN_INFO");
    }

    private void loadPreferencePenInfoList(ArrayList<SpenSettingUIPenInfo> arrayList, String str) {
        Logger.m11003i(TAG, "loadPreferencePenInfoList buf = " + str);
        String[] strArrSplit = str.split(";");
        String[] strArrSplit2 = strArrSplit[0].split(":");
        int i = Integer.parseInt(strArrSplit2[0]);
        int i2 = Integer.parseInt(strArrSplit2[1]);
        for (int i4 = 1; i4 <= i; i4++) {
            String[] strArrSplit3 = strArrSplit[i4].split(":");
            Default.Highlighter highlighterFind = Default.Highlighter.find(strArrSplit3[3]);
            if (highlighterFind != null) {
                int i5 = Integer.parseInt(strArrSplit3[0]);
                SpenSettingUIPenInfo spenSettingUIPenInfo = new SpenSettingUIPenInfo();
                spenSettingUIPenInfo.name = highlighterFind.getDefault().name;
                spenSettingUIPenInfo.color = Integer.parseInt(strArrSplit3[1]);
                spenSettingUIPenInfo.isCurvable = Boolean.parseBoolean(strArrSplit3[2]);
                spenSettingUIPenInfo.size = Float.parseFloat(strArrSplit3[4]);
                spenSettingUIPenInfo.sizeLevel = Integer.parseInt(strArrSplit3[5]);
                spenSettingUIPenInfo.hsv[0] = Float.parseFloat(strArrSplit3[6]);
                spenSettingUIPenInfo.hsv[1] = Float.parseFloat(strArrSplit3[7]);
                spenSettingUIPenInfo.hsv[2] = Float.parseFloat(strArrSplit3[8]);
                if ((spenSettingUIPenInfo.color | (-16777216)) != Color.HSVToColor(spenSettingUIPenInfo.hsv)) {
                    Color.colorToHSV(spenSettingUIPenInfo.color, spenSettingUIPenInfo.hsv);
                }
                if (i5 >= 10) {
                    spenSettingUIPenInfo.colorUIInfo = Integer.parseInt(strArrSplit3[9]);
                }
                if (i5 >= 11) {
                    spenSettingUIPenInfo.isFixedWidth = Boolean.parseBoolean(strArrSplit3[10]);
                }
                if (i5 >= 14) {
                    spenSettingUIPenInfo.isFixedOpacity = Boolean.parseBoolean(strArrSplit3[11]);
                    spenSettingUIPenInfo.isAutoSizeEnabled = Boolean.parseBoolean(strArrSplit3[12]);
                    spenSettingUIPenInfo.fitRatio = Float.parseFloat(strArrSplit3[13]);
                }
                if (i2 == i4 - 1) {
                    this.mSelectedPenName = spenSettingUIPenInfo.name;
                }
                arrayList.add(spenSettingUIPenInfo);
            }
        }
    }

    private SpenSettingUIPenInfo makeHighlighterInfo(SpenSettingUIPenInfo spenSettingUIPenInfo) {
        return new SpenSettingUIPenInfo(spenSettingUIPenInfo);
    }

    private void migrateHighlighter_3_0(ArrayList<SpenSettingUIPenInfo> arrayList, LegacyVersionException legacyVersionException) {
        try {
            ArrayList<SpenSettingUIPenInfo> arrayList2 = new ArrayList<>();
            HashMap map = new HashMap();
            loadPreferencePenInfoList(arrayList2, legacyVersionException.getValue());
            for (SpenSettingUIPenInfo spenSettingUIPenInfo : arrayList2) {
                map.put(spenSettingUIPenInfo.name, spenSettingUIPenInfo);
            }
            ArrayList arrayList3 = (ArrayList) arrayList.clone();
            arrayList.clear();
            for (int i = 0; i < arrayList3.size(); i++) {
                SpenSettingUIPenInfo spenSettingUIPenInfo2 = (SpenSettingUIPenInfo) arrayList3.get(i);
                if (map.containsKey(spenSettingUIPenInfo2.name)) {
                    arrayList.add((SpenSettingUIPenInfo) map.get(spenSettingUIPenInfo2.name));
                } else {
                    arrayList.add(spenSettingUIPenInfo2);
                }
                if (spenSettingUIPenInfo2.name.equals(this.mSelectedPenName)) {
                    this.mSelectedHighlighterIndex = i;
                }
            }
        } catch (Exception unused) {
            loadDefaultInfo(arrayList);
            Logger.m11000e(TAG, "updateHighlighterInfoMigration fail");
        }
    }

    private void saveHighlighterData() {
        super.saveData(getInfoString());
    }

    public void close() {
        ArrayList<SpenSettingUIPenInfo> arrayList = this.mPenInfoList;
        if (arrayList != null) {
            arrayList.clear();
            this.mPenInfoList = null;
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.model.menu.toolbar.p154hw.setting.migration.AbsMigrationPolicy
    public String getInfoString() {
        StringBuilder sbM1322o = AbstractC1974b.m1322o(this.mPenInfoList.size(), ":");
        sbM1322o.append(this.mSelectedHighlighterIndex);
        sbM1322o.append(":");
        StringBuilder sb = new StringBuilder(AbstractC0622a.m1170p(this.mPenInfoList.get(this.mSelectedHighlighterIndex).name, ":;", sbM1322o));
        for (SpenSettingUIPenInfo spenSettingUIPenInfo : this.mPenInfoList) {
            sb.append("14:" + spenSettingUIPenInfo.color + ":" + spenSettingUIPenInfo.isCurvable + ":" + spenSettingUIPenInfo.name + ":" + spenSettingUIPenInfo.size + ":" + spenSettingUIPenInfo.sizeLevel + ":" + spenSettingUIPenInfo.hsv[0] + ":" + spenSettingUIPenInfo.hsv[1] + ":" + spenSettingUIPenInfo.hsv[2] + ":" + spenSettingUIPenInfo.colorUIInfo + ":" + spenSettingUIPenInfo.isFixedWidth + ":" + spenSettingUIPenInfo.isFixedOpacity + ":" + spenSettingUIPenInfo.isAutoSizeEnabled + ":" + spenSettingUIPenInfo.fitRatio + ":;");
        }
        String string = sb.toString();
        AbstractC8014b.m7197C("getInfoString : ", string, TAG);
        return string;
    }

    public ArrayList<SpenSettingUIPenInfo> getSettingHighlighterInfoList() {
        return new ArrayList<>(this.mPenInfoList);
    }

    public SpenSettingUIPenInfo getSettingHighlighterInfoSelected() {
        return this.mPenInfoList.get(this.mSelectedHighlighterIndex);
    }

    public int getSettingHighlighterSelectedIndex() {
        return this.mSelectedHighlighterIndex;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.model.menu.toolbar.p154hw.setting.migration.AbsMigrationPolicy
    public boolean replace(String str) {
        this.mPenInfoList.clear();
        return super.replace(this.mPenInfoList, str);
    }

    public void setSettingHighlighterInfo(SpenSettingUIPenInfo spenSettingUIPenInfo) {
        int size = this.mPenInfoList.size();
        for (int i = 0; i < size; i++) {
            if (this.mPenInfoList.get(i).name.equals(spenSettingUIPenInfo.name)) {
                this.mSelectedHighlighterIndex = i;
                this.mPenInfoList.set(i, makeHighlighterInfo(spenSettingUIPenInfo));
                saveHighlighterData();
                return;
            }
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.model.menu.toolbar.p154hw.setting.migration.AbsMigrationPolicy
    public void loadDefault(ArrayList<SpenSettingUIPenInfo> arrayList) {
        loadDefaultInfo(arrayList);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.model.menu.toolbar.p154hw.setting.migration.AbsMigrationPolicy
    public void loadPreference(ArrayList<SpenSettingUIPenInfo> arrayList, String str) {
        loadPreferencePenInfoList(arrayList, str);
        this.mSelectedHighlighterIndex = getSelectedIndex(str);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.model.menu.toolbar.p154hw.setting.migration.AbsMigrationPolicy
    public void migrate(ArrayList<SpenSettingUIPenInfo> arrayList, LegacyVersionException legacyVersionException) {
        SPenVersion.Version version = legacyVersionException.getVersion();
        int iOrdinal = version.ordinal();
        Logger.m11003i(TAG, "migrateByVersion " + version.name());
        if (iOrdinal == SPenVersion.Version.V1_5.ordinal() || iOrdinal == SPenVersion.Version.V2_0.ordinal() || iOrdinal == SPenVersion.Version.V3_0.ordinal()) {
            migrateHighlighter_3_0(arrayList, legacyVersionException);
            CommonUtil.convertPenInfoSize(this.mSettingInfoManger.getContext(), this.mSettingInfoManger.getWritingToolManager().getWNoteWidth(), this.mSettingInfoManger.getWritingToolManager().getWNoteHeight(), arrayList);
        } else {
            arrayList.clear();
            loadPreference(arrayList, legacyVersionException.getValue());
            CommonUtil.convertPenInfoSize(this.mSettingInfoManger.getContext(), this.mSettingInfoManger.getWritingToolManager().getWNoteWidth(), this.mSettingInfoManger.getWritingToolManager().getWNoteHeight(), arrayList);
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.model.menu.toolbar.p154hw.setting.migration.AbsMigrationPolicy
    public void restore(ArrayList<SpenSettingUIPenInfo> arrayList) {
        String strLoadHighlighterFromPenData;
        Logger.m11003i(TAG, "restore# PreferenceKey: " + getPreferenceKey());
        try {
            try {
                try {
                    strLoadHighlighterFromPenData = SPenPreferenceResolver.getLatestString(getPreferenceKey());
                } catch (NoSuchFieldException e) {
                    e = e;
                    super.onException(arrayList, e);
                }
            } catch (NoSuchFieldException unused) {
                strLoadHighlighterFromPenData = loadHighlighterFromPenData();
            }
            loadPreference(arrayList, strLoadHighlighterFromPenData);
        } catch (LegacyVersionException e2) {
            loadDefault(arrayList);
            super.migration(arrayList, e2);
        } catch (IndexOutOfBoundsException e3) {
            e = e3;
            super.onException(arrayList, e);
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.model.menu.toolbar.p154hw.setting.migration.AbsMigrationPolicy
    public void store(ArrayList<SpenSettingUIPenInfo> arrayList) {
        saveHighlighterData();
    }
}
