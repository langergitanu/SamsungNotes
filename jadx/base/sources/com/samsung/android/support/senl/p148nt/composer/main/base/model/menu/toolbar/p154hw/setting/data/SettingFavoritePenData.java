package com.samsung.android.support.senl.p148nt.composer.main.base.model.menu.toolbar.p154hw.setting.data;

import android.content.SharedPreferences;
import android.graphics.Color;
import androidx.constraintlayout.motion.widget.AbstractC2322a;
import com.samsung.android.sdk.pen.SpenSettingUIPenInfo;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.menu.toolbar.p154hw.setting.SPenPreferenceResolver;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.menu.toolbar.p154hw.setting.SPenVersion;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.menu.toolbar.p154hw.setting.constants.AbsSPenExtraInfo;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.menu.toolbar.p154hw.setting.constants.Default;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.menu.toolbar.p154hw.setting.migration.AbsMigrationPolicy;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.menu.toolbar.p154hw.setting.migration.LegacyVersionException;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.setting.HwSettingContract;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.CommonUtil;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.p156sa.ComposerSA;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.p156sa.HWToolbarSAConstants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class SettingFavoritePenData extends AbsMigrationPolicy<ArrayList<SpenSettingUIPenInfo>> {
    private static final String KEY_SETTING_FAVORITEPEN_INFO = "KEY_SETTING_FAVORITEPEN_INFO";
    private static final int MAX_COUNT_FAVORITEPEN_INFO = 45;
    private static final String TAG = Logger.createTag("SettingFavoritePenData");
    private final ArrayList<FavoritePenInfoChangeListener> mFavoritePenInfoChangeListener;
    private final ArrayList<SpenSettingUIPenInfo> mFavoritePenInfoList;
    private SharedPreferences.OnSharedPreferenceChangeListener mOnSharedPreferenceChangeListener;
    private final HwSettingContract.ISettingInfoManger mSettingInfoManager;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface FavoritePenInfoChangeListener {
        void onFavoriteIndexChanged(int i);

        void onFavoritePenInfoChanged(ArrayList<SpenSettingUIPenInfo> arrayList);
    }

    public SettingFavoritePenData(HwSettingContract.ISettingInfoManger iSettingInfoManger) {
        super(KEY_SETTING_FAVORITEPEN_INFO);
        this.mSettingInfoManager = iSettingInfoManger;
        this.mFavoritePenInfoChangeListener = new ArrayList<>();
        ArrayList<SpenSettingUIPenInfo> arrayList = new ArrayList<>();
        this.mFavoritePenInfoList = arrayList;
        registerOnSharedPreferenceChangeListener();
        super.restore(arrayList);
    }

    private void loadFavoritePenData(ArrayList<SpenSettingUIPenInfo> arrayList, String str) {
        Logger.m11003i(TAG, "loadFavoritePenData buf = " + str);
        String[] strArrSplit = str.split(";");
        int i = Integer.parseInt(strArrSplit[0]);
        for (int i2 = 1; i2 <= i; i2++) {
            String[] strArrSplit2 = strArrSplit[i2].split(":");
            AbsSPenExtraInfo absSPenExtraInfoFindSPenInfo = Default.findSPenInfo(strArrSplit2[2]);
            if (absSPenExtraInfoFindSPenInfo != null) {
                SpenSettingUIPenInfo spenSettingUIPenInfo = new SpenSettingUIPenInfo();
                spenSettingUIPenInfo.name = absSPenExtraInfoFindSPenInfo.name;
                spenSettingUIPenInfo.color = Integer.parseInt(strArrSplit2[0]);
                spenSettingUIPenInfo.isCurvable = Boolean.parseBoolean(strArrSplit2[1]);
                spenSettingUIPenInfo.size = Float.parseFloat(strArrSplit2[3]);
                spenSettingUIPenInfo.sizeLevel = Integer.parseInt(strArrSplit2[4]);
                spenSettingUIPenInfo.hsv[0] = Float.parseFloat(strArrSplit2[5]);
                spenSettingUIPenInfo.hsv[1] = Float.parseFloat(strArrSplit2[6]);
                spenSettingUIPenInfo.hsv[2] = Float.parseFloat(strArrSplit2[7]);
                if ((spenSettingUIPenInfo.color | (-16777216)) != Color.HSVToColor(spenSettingUIPenInfo.hsv)) {
                    Color.colorToHSV(spenSettingUIPenInfo.color, spenSettingUIPenInfo.hsv);
                }
                if (strArrSplit2.length > 8) {
                    spenSettingUIPenInfo.colorUIInfo = Integer.parseInt(strArrSplit2[8]);
                }
                if (strArrSplit2.length > 9) {
                    spenSettingUIPenInfo.isFixedWidth = Boolean.parseBoolean(strArrSplit2[9]);
                }
                if (strArrSplit2.length > 12) {
                    spenSettingUIPenInfo.isFixedOpacity = Boolean.parseBoolean(strArrSplit2[10]);
                    spenSettingUIPenInfo.isAutoSizeEnabled = Boolean.parseBoolean(strArrSplit2[11]);
                    spenSettingUIPenInfo.fitRatio = Float.parseFloat(strArrSplit2[12]);
                }
                arrayList.add(spenSettingUIPenInfo);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyFavoritePenInfoChanged() {
        Logger.m11003i(TAG, "notifyFavoritePenInfoChanged# ListenerSize : " + this.mFavoritePenInfoChangeListener.size() + " FavoriteListSize : " + this.mFavoritePenInfoList.size());
        Iterator<FavoritePenInfoChangeListener> it = this.mFavoritePenInfoChangeListener.iterator();
        while (it.hasNext()) {
            it.next().onFavoritePenInfoChanged(this.mFavoritePenInfoList);
        }
    }

    private void registerOnSharedPreferenceChangeListener() {
        if (this.mOnSharedPreferenceChangeListener == null) {
            this.mOnSharedPreferenceChangeListener = new SharedPreferences.OnSharedPreferenceChangeListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.model.menu.toolbar.hw.setting.data.SettingFavoritePenData.1
                @Override // android.content.SharedPreferences.OnSharedPreferenceChangeListener
                public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String str) {
                    if (str.equals(SettingFavoritePenData.this.getPreferenceKey())) {
                        Logger.m11003i(SettingFavoritePenData.TAG, "onSharedPreferenceChanged#");
                        SettingFavoritePenData.this.mFavoritePenInfoList.clear();
                        SettingFavoritePenData settingFavoritePenData = SettingFavoritePenData.this;
                        settingFavoritePenData.restore(settingFavoritePenData.mFavoritePenInfoList);
                        SettingFavoritePenData.this.notifyFavoritePenInfoChanged();
                    }
                }
            };
        }
        SPenPreferenceResolver.registerOnSharedPreferenceChangeListener(this.mOnSharedPreferenceChangeListener);
    }

    private boolean saveFavoritePenData() {
        String infoString = getInfoString();
        AbstractC8014b.m7197C("saveFavoritePenData() buf = ", infoString, TAG);
        super.saveData(infoString);
        if (isSkipSave()) {
            notifyFavoritePenInfoChanged();
        }
        ComposerSA.insertStatusLog(HWToolbarSAConstants.EVENT_STATUS_NUMBER_OF_FAVORITE_PENS, this.mFavoritePenInfoList.size());
        return true;
    }

    public boolean canAddFavoriteInfo() {
        return this.mFavoritePenInfoList.size() < 45;
    }

    public void close() {
        SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener = this.mOnSharedPreferenceChangeListener;
        if (onSharedPreferenceChangeListener == null) {
            return;
        }
        SPenPreferenceResolver.unregisterOnSharedPreferenceChangeListener(onSharedPreferenceChangeListener);
        this.mOnSharedPreferenceChangeListener = null;
    }

    public SpenSettingUIPenInfo getFavoriteInfoByIndex(int i) {
        if (i >= 0 && i < this.mFavoritePenInfoList.size()) {
            return this.mFavoritePenInfoList.get(i);
        }
        Logger.m11000e(TAG, "getFavoriteInfoByIndex mFavoritePenInfoList.size() : " + this.mFavoritePenInfoList.size() + ", index : " + i);
        return null;
    }

    public ArrayList<SpenSettingUIPenInfo> getFavoriteList() {
        return new ArrayList<>(this.mFavoritePenInfoList);
    }

    public int getFavoriteListIndex(SpenSettingUIPenInfo spenSettingUIPenInfo) {
        int size = this.mFavoritePenInfoList.size();
        for (int i = 0; i < size; i++) {
            if (CommonUtil.comparePenInfo(this.mFavoritePenInfoList.get(i), spenSettingUIPenInfo)) {
                return i;
            }
        }
        return -1;
    }

    public int getFavoriteMaxCount() {
        return 45;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.model.menu.toolbar.p154hw.setting.migration.AbsMigrationPolicy
    public String getInfoString() {
        StringBuilder sb = new StringBuilder(AbstractC2322a.m1615e(this.mFavoritePenInfoList.size(), ";"));
        for (SpenSettingUIPenInfo spenSettingUIPenInfo : this.mFavoritePenInfoList) {
            sb.append(spenSettingUIPenInfo.color + ":" + spenSettingUIPenInfo.isCurvable + ":" + spenSettingUIPenInfo.name + ":" + spenSettingUIPenInfo.size + ":" + spenSettingUIPenInfo.sizeLevel + ":" + spenSettingUIPenInfo.hsv[0] + ":" + spenSettingUIPenInfo.hsv[1] + ":" + spenSettingUIPenInfo.hsv[2] + ":" + spenSettingUIPenInfo.colorUIInfo + ":" + spenSettingUIPenInfo.isFixedWidth + ":" + spenSettingUIPenInfo.isFixedOpacity + ":" + spenSettingUIPenInfo.isAutoSizeEnabled + ":" + spenSettingUIPenInfo.fitRatio + ":;");
        }
        return sb.toString();
    }

    public boolean isHighlighterInfo(SpenSettingUIPenInfo spenSettingUIPenInfo) {
        return Default.Highlighter.find(spenSettingUIPenInfo.name) != null;
    }

    public boolean isThereFavoriteInfo(SpenSettingUIPenInfo spenSettingUIPenInfo) {
        int size = this.mFavoritePenInfoList.size();
        for (int i = 0; i < size; i++) {
            if (CommonUtil.comparePenInfo(this.mFavoritePenInfoList.get(i), spenSettingUIPenInfo)) {
                return true;
            }
        }
        return false;
    }

    public void notifyFavoriteIndexChanged(int i) {
        Iterator<FavoritePenInfoChangeListener> it = this.mFavoritePenInfoChangeListener.iterator();
        while (it.hasNext()) {
            it.next().onFavoriteIndexChanged(i);
        }
    }

    public final void registerFavoriteInfoChangeListener(FavoritePenInfoChangeListener favoritePenInfoChangeListener) {
        String str = TAG;
        Logger.m11003i(str, "registerFavoriteInfoChangeListener#");
        if (this.mFavoritePenInfoChangeListener.contains(favoritePenInfoChangeListener)) {
            Logger.m11003i(str, "registerFavoriteInfoChangeListener# already registered");
        } else {
            this.mFavoritePenInfoChangeListener.add(favoritePenInfoChangeListener);
        }
    }

    public boolean removeFavoriteInfo(SpenSettingUIPenInfo spenSettingUIPenInfo) {
        if (spenSettingUIPenInfo == null) {
            return false;
        }
        int size = this.mFavoritePenInfoList.size();
        for (int i = 0; i < size; i++) {
            if (CommonUtil.comparePenInfo(this.mFavoritePenInfoList.get(i), spenSettingUIPenInfo)) {
                this.mFavoritePenInfoList.remove(i);
                return saveFavoritePenData();
            }
        }
        Logger.m11000e(TAG, "removeFavoriteInfo : There is no SpenSettingUIPenInfo data in FavoritePenInfoList!!");
        return false;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.model.menu.toolbar.p154hw.setting.migration.AbsMigrationPolicy
    public boolean replace(String str) {
        this.mFavoritePenInfoList.clear();
        return super.replace(this.mFavoritePenInfoList, str);
    }

    public boolean setFavoriteInfo(SpenSettingUIPenInfo spenSettingUIPenInfo, SpenSettingUIPenInfo spenSettingUIPenInfo2) {
        if (spenSettingUIPenInfo2 == null) {
            return false;
        }
        int size = this.mFavoritePenInfoList.size();
        for (int i = 0; i < size; i++) {
            if (CommonUtil.comparePenInfo(this.mFavoritePenInfoList.get(i), spenSettingUIPenInfo2)) {
                Logger.m11000e(TAG, "setFavoriteInfo : Duplicated SpenSettingUIPenInfo!!");
                return false;
            }
        }
        if (spenSettingUIPenInfo == null) {
            this.mFavoritePenInfoList.add(new SpenSettingUIPenInfo(spenSettingUIPenInfo2));
            saveFavoritePenData();
            return true;
        }
        for (int i2 = 0; i2 < size; i2++) {
            if (CommonUtil.comparePenInfo(this.mFavoritePenInfoList.get(i2), spenSettingUIPenInfo)) {
                this.mFavoritePenInfoList.remove(i2);
                this.mFavoritePenInfoList.add(i2, spenSettingUIPenInfo2);
                return saveFavoritePenData();
            }
        }
        return true;
    }

    public void setFavoriteList(List<SpenSettingUIPenInfo> list) {
        this.mFavoritePenInfoList.clear();
        if (list != null) {
            this.mFavoritePenInfoList.addAll(list);
        }
        saveFavoritePenData();
    }

    public void unregisterFavoriteInfoChangeListener(FavoritePenInfoChangeListener favoritePenInfoChangeListener) {
        if (favoritePenInfoChangeListener == null) {
            return;
        }
        Logger.m11003i(TAG, "unregisterFavoriteInfoChangeListener#");
        this.mFavoritePenInfoChangeListener.remove(favoritePenInfoChangeListener);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.model.menu.toolbar.p154hw.setting.migration.AbsMigrationPolicy
    public void loadDefault(ArrayList<SpenSettingUIPenInfo> arrayList) {
        arrayList.clear();
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.model.menu.toolbar.p154hw.setting.migration.AbsMigrationPolicy
    public void loadPreference(ArrayList<SpenSettingUIPenInfo> arrayList, String str) {
        loadFavoritePenData(arrayList, str);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.model.menu.toolbar.p154hw.setting.migration.AbsMigrationPolicy
    public void migrate(ArrayList<SpenSettingUIPenInfo> arrayList, LegacyVersionException legacyVersionException) {
        SPenVersion.Version version = legacyVersionException.getVersion();
        Logger.m11003i(TAG, "migrateByVersion " + version.name());
        loadFavoritePenData(arrayList, legacyVersionException.getValue());
        if (version.ordinal() <= SPenVersion.Version.V4_0.ordinal()) {
            CommonUtil.convertPenInfoSize(this.mSettingInfoManager.getContext(), this.mSettingInfoManager.getWritingToolManager().getWNoteWidth(), this.mSettingInfoManager.getWritingToolManager().getWNoteHeight(), arrayList);
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.model.menu.toolbar.p154hw.setting.migration.AbsMigrationPolicy
    public void store(ArrayList<SpenSettingUIPenInfo> arrayList) {
        saveFavoritePenData();
    }
}
