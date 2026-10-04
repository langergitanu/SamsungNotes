package com.samsung.android.support.senl.p148nt.composer.main.base.model.menu.toolbar.p154hw.setting.data;

import android.graphics.Color;
import androidx.appcompat.widget.AbstractC0541b;
import androidx.collection.AbstractC0622a;
import androidx.compose.runtime.AbstractC1974b;
import com.microsoft.identity.common.java.marker.PerfConstants;
import com.samsung.android.sdk.pen.SpenSettingUIPenInfo;
import com.samsung.android.sdk.pen.pen.SpenPen;
import com.samsung.android.sdk.pen.pen.SpenPenInfo;
import com.samsung.android.sdk.pen.pen.SpenPenManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.menu.toolbar.p154hw.setting.SPenVersion;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.menu.toolbar.p154hw.setting.constants.Default;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.menu.toolbar.p154hw.setting.migration.AbsMigrationPolicy;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.menu.toolbar.p154hw.setting.migration.LegacyVersionException;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.setting.HwSettingContract;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.CommonUtil;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import p258y.AbstractC14516b;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class SettingPenInfoData extends AbsMigrationPolicy<ArrayList<SpenSettingUIPenInfo>> {
    private static final String KEY_SETTING_PEN_INFO = "KEY_SETTING_PEN_INFO";
    private static final int PEN_INFO_ITEM_COUNT = 14;
    private static final int PEN_INFO_ITEM_COUNT_1_5 = 5;
    private static final int PEN_INFO_ITEM_COUNT_2_0 = 6;
    private static final String TAG = Logger.createTag("SettingPenInfoData");
    private ArrayList<SpenSettingUIPenInfo> mPenInfoList;
    private int mSelectedPenIndex;
    private String mSelectedPenName;
    private HwSettingContract.ISettingInfoManger mSettingInfoManager;

    public SettingPenInfoData(HwSettingContract.ISettingInfoManger iSettingInfoManger) {
        super("KEY_SETTING_PEN_INFO");
        this.mSelectedPenName = "";
        this.mSettingInfoManager = iSettingInfoManger;
        ArrayList<SpenSettingUIPenInfo> arrayList = new ArrayList<>();
        this.mPenInfoList = arrayList;
        super.restore(arrayList);
    }

    private int findIndexByPenName(String str) {
        if (Default.Pen.find(str) == null) {
            str = Default.DEFAULT_PEN.getDefault().name;
        }
        Logger.m11003i(TAG, "findIndexByPenName penName : " + str);
        return getPenInfoIndexByName(str);
    }

    private boolean loadData_2_0(ArrayList<SpenSettingUIPenInfo> arrayList, LegacyVersionException legacyVersionException) {
        String value = legacyVersionException.getValue();
        String str = TAG;
        Logger.m11003i(str, "loadData_2_0 buf = " + value);
        String[] strArrSplit = value.split(":");
        int i = Integer.parseInt(strArrSplit[0]);
        this.mSelectedPenIndex = Integer.parseInt(strArrSplit[1]);
        StringBuilder sbM778t = AbstractC0541b.m778t(i, "count = ", " ,  SelectedPenIndex = ");
        sbM778t.append(this.mSelectedPenIndex);
        Logger.m11003i(str, sbM778t.toString());
        arrayList.clear();
        for (int i2 = 0; i2 < i; i2++) {
            SpenSettingUIPenInfo spenSettingUIPenInfo = new SpenSettingUIPenInfo();
            int i4 = i2 * 6;
            spenSettingUIPenInfo.color = Integer.parseInt(strArrSplit[i4 + 2]);
            spenSettingUIPenInfo.isCurvable = Boolean.parseBoolean(strArrSplit[i4 + 4]);
            spenSettingUIPenInfo.name = strArrSplit[i4 + 5];
            spenSettingUIPenInfo.size = Float.parseFloat(strArrSplit[i4 + 6]);
            spenSettingUIPenInfo.sizeLevel = Integer.parseInt(strArrSplit[i4 + 7]);
            arrayList.add(spenSettingUIPenInfo);
            if (this.mSelectedPenIndex == i2) {
                this.mSelectedPenName = spenSettingUIPenInfo.name;
                Logger.m11003i(TAG, "mSelectedPenName : " + this.mSelectedPenName);
            }
        }
        getCandidatePenList(this.mSettingInfoManager.getPenManager());
        return true;
    }

    private void loadDefaultInfo(ArrayList<SpenSettingUIPenInfo> arrayList) {
        loadDefaultInfoList(arrayList);
    }

    private void loadDefaultInfoList(ArrayList<SpenSettingUIPenInfo> arrayList) {
        arrayList.clear();
        for (Default.Pen pen : Default.Pen.values()) {
            arrayList.add(pen.getDefault());
        }
        this.mSelectedPenIndex = Default.DEFAULT_PEN.ordinal();
    }

    private void loadPreferencePenInfoList(ArrayList<SpenSettingUIPenInfo> arrayList, String str) {
        String str2 = TAG;
        Logger.m11003i(str2, "loadPreferencePenInfoList buf = " + str);
        String[] strArrSplit = str.split(";");
        String[] strArrSplit2 = strArrSplit[0].split(":");
        int i = Integer.parseInt(strArrSplit2[0]);
        int i2 = Integer.parseInt(strArrSplit2[1]);
        AbstractC14516b.m15114b(i, i2, "penCount = ", " ,  SelectedPenIndex = ", str2);
        for (int i4 = 1; i4 <= i; i4++) {
            String[] strArrSplit3 = strArrSplit[i4].split(":");
            Default.Pen penFind = Default.Pen.find(strArrSplit3[3]);
            if (penFind != null) {
                int i5 = Integer.parseInt(strArrSplit3[0]);
                SpenSettingUIPenInfo spenSettingUIPenInfo = new SpenSettingUIPenInfo();
                spenSettingUIPenInfo.name = penFind.getDefault().name;
                spenSettingUIPenInfo.color = Integer.parseInt(strArrSplit3[1]);
                spenSettingUIPenInfo.isCurvable = Boolean.parseBoolean(strArrSplit3[2]);
                spenSettingUIPenInfo.size = Float.parseFloat(strArrSplit3[4]);
                spenSettingUIPenInfo.sizeLevel = Integer.parseInt(strArrSplit3[5]);
                spenSettingUIPenInfo.hsv[0] = Float.parseFloat(strArrSplit3[6]);
                spenSettingUIPenInfo.hsv[1] = Float.parseFloat(strArrSplit3[7]);
                spenSettingUIPenInfo.hsv[2] = Float.parseFloat(strArrSplit3[8]);
                int iHSVToColor = Color.HSVToColor(spenSettingUIPenInfo.hsv);
                int i6 = spenSettingUIPenInfo.color;
                if (i6 != iHSVToColor) {
                    Color.colorToHSV(i6, spenSettingUIPenInfo.hsv);
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

    private void logErrorVersion(LegacyVersionException legacyVersionException) {
        String strName = SPenVersion.Version.DEFAULT.name();
        String strName2 = legacyVersionException.getVersion().name();
        Logger.m11000e(TAG, "Migration failed from v" + strName + " to v" + strName2);
    }

    private SpenSettingUIPenInfo makePenInfo(SpenSettingUIPenInfo spenSettingUIPenInfo) {
        return new SpenSettingUIPenInfo(spenSettingUIPenInfo);
    }

    private void migrateByVersion(ArrayList<SpenSettingUIPenInfo> arrayList, LegacyVersionException legacyVersionException) {
        SPenVersion.Version version = legacyVersionException.getVersion();
        int iOrdinal = version.ordinal();
        Logger.m11003i(TAG, "migrateByVersion " + version.name());
        if (iOrdinal == SPenVersion.Version.V1_5.ordinal() || iOrdinal == SPenVersion.Version.V2_0.ordinal()) {
            relicsFromSPenSDK(arrayList, legacyVersionException);
            CommonUtil.convertPenInfoSize(this.mSettingInfoManager.getContext(), this.mSettingInfoManager.getWritingToolManager().getWNoteWidth(), this.mSettingInfoManager.getWritingToolManager().getWNoteHeight(), arrayList);
        } else if (iOrdinal == SPenVersion.Version.V3_0.ordinal()) {
            migratePenInfo_3_0(arrayList, legacyVersionException);
            CommonUtil.convertPenInfoSize(this.mSettingInfoManager.getContext(), this.mSettingInfoManager.getWritingToolManager().getWNoteWidth(), this.mSettingInfoManager.getWritingToolManager().getWNoteHeight(), arrayList);
        } else {
            arrayList.clear();
            loadPreference(arrayList, legacyVersionException.getValue());
            CommonUtil.convertPenInfoSize(this.mSettingInfoManager.getContext(), this.mSettingInfoManager.getWritingToolManager().getWNoteWidth(), this.mSettingInfoManager.getWritingToolManager().getWNoteHeight(), arrayList);
        }
    }

    private void migratePenInfo_3_0(ArrayList<SpenSettingUIPenInfo> arrayList, LegacyVersionException legacyVersionException) {
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
                    this.mSelectedPenIndex = i;
                }
            }
        } catch (IndexOutOfBoundsException e) {
            loadDefaultInfo(arrayList);
            logErrorVersion(legacyVersionException);
            Logger.m11000e(TAG, "updatePenInfoMigration fail " + e.getMessage());
        }
    }

    private void relicsFromSPenSDK(ArrayList<SpenSettingUIPenInfo> arrayList, LegacyVersionException legacyVersionException) {
        try {
            int iOrdinal = legacyVersionException.getVersion().ordinal();
            if (iOrdinal == SPenVersion.Version.V1_5.ordinal()) {
                loadData_1_5(arrayList, legacyVersionException);
            } else if (iOrdinal == SPenVersion.Version.V2_0.ordinal()) {
                loadData_2_0(arrayList, legacyVersionException);
            }
            this.mSelectedPenIndex = findIndexByPenName(this.mSelectedPenName);
            Logger.m11003i(TAG, " findIndexByPenName mSelectedPenIndex : " + this.mSelectedPenIndex);
        } catch (Exception e) {
            loadDefaultInfo(arrayList);
            logErrorVersion(legacyVersionException);
            Logger.m11000e(TAG, e.getMessage());
        }
    }

    private void savePenData() {
        super.saveData(getInfoString());
    }

    public void close() {
        ArrayList<SpenSettingUIPenInfo> arrayList = this.mPenInfoList;
        if (arrayList != null) {
            arrayList.clear();
            this.mPenInfoList = null;
        }
    }

    public void getCandidatePenList(SpenPenManager spenPenManager) {
        SpenPen spenPenCreatePen;
        ArrayList<SpenSettingUIPenInfo> arrayList = new ArrayList<>();
        if (spenPenManager == null) {
            return;
        }
        ArrayList arrayList2 = new ArrayList();
        List<SpenPenInfo> penInfoList = arrayList2;
        if (spenPenManager.getPenInfoList() != null) {
            arrayList2.clear();
            penInfoList = spenPenManager.getPenInfoList();
        }
        if (penInfoList == null) {
            Logger.m11000e(TAG, "Pen List is null!!");
            return;
        }
        int size = this.mPenInfoList.size();
        int i = this.mPenInfoList.get(this.mSelectedPenIndex).color;
        for (SpenPenInfo spenPenInfo : penInfoList) {
            boolean z = false;
            int i2 = 0;
            while (true) {
                if (i2 >= size) {
                    break;
                }
                SpenSettingUIPenInfo spenSettingUIPenInfo = this.mPenInfoList.get(i2);
                if (spenSettingUIPenInfo.name.equals(spenPenInfo.className)) {
                    arrayList.add(spenSettingUIPenInfo);
                    z = true;
                    break;
                }
                i2++;
            }
            if (!z) {
                try {
                    spenPenCreatePen = spenPenManager.createPen(spenPenInfo);
                } catch (Exception unused) {
                    Logger.m11000e(TAG, "getCandidatePenList() : fail to create penmanager#" + spenPenInfo.className);
                    spenPenCreatePen = null;
                }
                if (spenPenCreatePen != null) {
                    SpenSettingUIPenInfo spenSettingUIPenInfo2 = new SpenSettingUIPenInfo();
                    if (PerfConstants.CodeMarkerParameters.MARKER.equals(spenPenInfo.className)) {
                        spenSettingUIPenInfo2.color = (16777215 & i) | 2130706432;
                    } else if ("MagicPen".equals(spenPenInfo.className)) {
                        spenSettingUIPenInfo2.color = 2130706432;
                    } else {
                        spenSettingUIPenInfo2.color = i;
                    }
                    spenSettingUIPenInfo2.advancedSetting = "";
                    spenSettingUIPenInfo2.isCurvable = true;
                    spenSettingUIPenInfo2.name = spenPenInfo.className;
                    spenSettingUIPenInfo2.size = spenPenCreatePen.getSize();
                    arrayList.add(spenSettingUIPenInfo2);
                    spenPenManager.destroyPen(spenPenCreatePen);
                }
            }
        }
        this.mPenInfoList.clear();
        this.mPenInfoList = arrayList;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.model.menu.toolbar.p154hw.setting.migration.AbsMigrationPolicy
    public String getInfoString() {
        StringBuilder sbM1322o = AbstractC1974b.m1322o(this.mPenInfoList.size(), ":");
        sbM1322o.append(this.mSelectedPenIndex);
        sbM1322o.append(":");
        StringBuilder sb = new StringBuilder(AbstractC0622a.m1170p(this.mPenInfoList.get(this.mSelectedPenIndex).name, ":;", sbM1322o));
        StringBuilder sb2 = new StringBuilder();
        for (SpenSettingUIPenInfo spenSettingUIPenInfo : this.mPenInfoList) {
            sb2.append("14:" + spenSettingUIPenInfo.color + ":" + spenSettingUIPenInfo.isCurvable + ":" + spenSettingUIPenInfo.name + ":" + spenSettingUIPenInfo.size + ":" + spenSettingUIPenInfo.sizeLevel + ":" + spenSettingUIPenInfo.hsv[0] + ":" + spenSettingUIPenInfo.hsv[1] + ":" + spenSettingUIPenInfo.hsv[2] + ":" + spenSettingUIPenInfo.colorUIInfo + ":" + spenSettingUIPenInfo.isFixedWidth + ":" + spenSettingUIPenInfo.isFixedOpacity + ":" + spenSettingUIPenInfo.isAutoSizeEnabled + ":" + spenSettingUIPenInfo.fitRatio + ":;");
        }
        sb.append(sb2.toString());
        Logger.m11003i(TAG, "savePenData() buf = " + ((Object) sb2));
        return sb.toString();
    }

    public int getPenInfoIndexByName(String str) {
        ArrayList<SpenSettingUIPenInfo> arrayList = this.mPenInfoList;
        if (arrayList == null) {
            return -1;
        }
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            if (this.mPenInfoList.get(i).name.equals(str)) {
                return i;
            }
        }
        return -1;
    }

    public SpenSettingUIPenInfo getSettingPenInfoByIndex(int i) {
        return this.mPenInfoList.get(i);
    }

    public ArrayList<SpenSettingUIPenInfo> getSettingPenInfoList() {
        return new ArrayList<>(this.mPenInfoList);
    }

    public SpenSettingUIPenInfo getSettingPenInfoSelected() {
        int size = this.mPenInfoList.size();
        int i = this.mSelectedPenIndex;
        if (size <= i) {
            return null;
        }
        return this.mPenInfoList.get(i);
    }

    public int getSettingPenSelectedIndex() {
        return this.mSelectedPenIndex;
    }

    public boolean loadData_1_5(ArrayList<SpenSettingUIPenInfo> arrayList, LegacyVersionException legacyVersionException) {
        String value = legacyVersionException.getValue();
        String str = TAG;
        Logger.m11003i(str, "loadData_1_5 buf = " + value);
        String[] strArrSplit = value.split(":");
        int i = Integer.parseInt(strArrSplit[0]);
        this.mSelectedPenIndex = Integer.parseInt(strArrSplit[1]);
        StringBuilder sbM778t = AbstractC0541b.m778t(i, "count = ", " ,  SelectedPenIndex");
        sbM778t.append(this.mSelectedPenIndex);
        Logger.m11003i(str, sbM778t.toString());
        arrayList.clear();
        for (int i2 = 0; i2 < i; i2++) {
            SpenSettingUIPenInfo spenSettingUIPenInfo = new SpenSettingUIPenInfo();
            int i4 = i2 * 5;
            spenSettingUIPenInfo.color = Integer.parseInt(strArrSplit[i4 + 2]);
            spenSettingUIPenInfo.isCurvable = Boolean.parseBoolean(strArrSplit[i4 + 4]);
            spenSettingUIPenInfo.name = strArrSplit[i4 + 5];
            spenSettingUIPenInfo.size = Float.parseFloat(strArrSplit[i4 + 6]);
            arrayList.add(spenSettingUIPenInfo);
            if (this.mSelectedPenIndex == i2) {
                this.mSelectedPenName = spenSettingUIPenInfo.name;
                Logger.m11003i(TAG, "mSelectedPenName : " + this.mSelectedPenName);
            }
        }
        getCandidatePenList(this.mSettingInfoManager.getPenManager());
        return true;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.model.menu.toolbar.p154hw.setting.migration.AbsMigrationPolicy
    public boolean replace(String str) {
        this.mPenInfoList.clear();
        return super.replace(this.mPenInfoList, str);
    }

    public void setSettingPenInfo(SpenSettingUIPenInfo spenSettingUIPenInfo) {
        int penInfoIndexByName = getPenInfoIndexByName(spenSettingUIPenInfo.name);
        if (penInfoIndexByName < 0 || penInfoIndexByName >= this.mPenInfoList.size()) {
            return;
        }
        this.mSelectedPenIndex = penInfoIndexByName;
        this.mPenInfoList.set(penInfoIndexByName, makePenInfo(spenSettingUIPenInfo));
        savePenData();
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.model.menu.toolbar.p154hw.setting.migration.AbsMigrationPolicy
    public void loadDefault(ArrayList<SpenSettingUIPenInfo> arrayList) {
        loadDefaultInfo(arrayList);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.model.menu.toolbar.p154hw.setting.migration.AbsMigrationPolicy
    public void loadPreference(ArrayList<SpenSettingUIPenInfo> arrayList, String str) {
        loadPreferencePenInfoList(arrayList, str);
        this.mSelectedPenIndex = findIndexByPenName(this.mSelectedPenName);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.model.menu.toolbar.p154hw.setting.migration.AbsMigrationPolicy
    public void migrate(ArrayList<SpenSettingUIPenInfo> arrayList, LegacyVersionException legacyVersionException) {
        migrateByVersion(arrayList, legacyVersionException);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.model.menu.toolbar.p154hw.setting.migration.AbsMigrationPolicy
    public void store(ArrayList<SpenSettingUIPenInfo> arrayList) {
        savePenData();
    }
}
