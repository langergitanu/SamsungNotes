package com.samsung.android.support.senl.p148nt.composer.main.base.model.menu.toolbar.p154hw.setting.data;

import android.os.Handler;
import com.samsung.android.sdk.pen.setting.colorpalette.SpenHSVColor;
import com.samsung.android.support.senl.p145cm.base.framework.support.ColorCompat;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.menu.toolbar.p154hw.setting.migration.AbsMigrationPolicy;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.menu.toolbar.p154hw.setting.migration.LegacyVersionException;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.data.database.core.query.sqlbuilder.SQLKeyword;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class SettingColorRecentData extends AbsMigrationPolicy<LinkedHashMap<Integer, float[]>> {
    private static final String KEY_SETTING_COLOR_RECENT = "KEY_SETTING_COLOR_RECENT";
    private static final int RECENT_COLOR_CAPACITY = 8;
    private static final int RECENT_COLOR_SAVE_INTERVAL_MS = 500;
    private static final String TAG = Logger.createTag("SettingColorRecentData");
    Handler mHandler;
    LinkedHashMap<Integer, float[]> mLinkedHashMap;
    Runnable mRecentColorSaveRunnable;

    public SettingColorRecentData() {
        super(KEY_SETTING_COLOR_RECENT);
        LinkedHashMap<Integer, float[]> linkedHashMap = new LinkedHashMap<Integer, float[]>(8) { // from class: com.samsung.android.support.senl.nt.composer.main.base.model.menu.toolbar.hw.setting.data.SettingColorRecentData.1
            @Override // java.util.LinkedHashMap
            public boolean removeEldestEntry(Map.Entry<Integer, float[]> entry) {
                return size() > 8;
            }
        };
        this.mLinkedHashMap = linkedHashMap;
        super.restore(linkedHashMap);
        this.mHandler = new Handler();
        this.mRecentColorSaveRunnable = new Runnable() { // from class: com.samsung.android.support.senl.nt.composer.main.base.model.menu.toolbar.hw.setting.data.SettingColorRecentData.2
            @Override // java.lang.Runnable
            public void run() {
                SettingColorRecentData settingColorRecentData = SettingColorRecentData.this;
                settingColorRecentData.store(settingColorRecentData.mLinkedHashMap);
            }
        };
    }

    private void loadData(LinkedHashMap<Integer, float[]> linkedHashMap, String str) {
        AbstractC8014b.m7197C("loadData : ", str, TAG);
        if (str == null || str.isEmpty()) {
            return;
        }
        linkedHashMap.clear();
        String[] strArrSplit = str.split(";");
        for (int i = 0; i < strArrSplit.length; i += 3) {
            float[] fArr = {Float.parseFloat(strArrSplit[i]), Float.parseFloat(strArrSplit[i + 1]), Float.parseFloat(strArrSplit[i + 2])};
            linkedHashMap.put(Integer.valueOf(ColorCompat.HSVToColor(fArr)), fArr);
        }
    }

    public void addRecentColor(int i) {
        Logger.m11003i(TAG, "addRecentColor : " + Integer.toHexString(i));
        if (this.mLinkedHashMap.containsKey(Integer.valueOf(i))) {
            this.mLinkedHashMap.remove(Integer.valueOf(i));
        }
        float[] fArr = new float[3];
        ColorCompat.colorToHSV(i, fArr);
        this.mLinkedHashMap.put(Integer.valueOf(i), fArr);
        slackStore();
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.model.menu.toolbar.p154hw.setting.migration.AbsMigrationPolicy
    public String getInfoString() {
        return getInfoString(this.mLinkedHashMap);
    }

    public List<SpenHSVColor> getRecentColors() {
        ArrayList arrayList = new ArrayList();
        Iterator<Map.Entry<Integer, float[]>> it = this.mLinkedHashMap.entrySet().iterator();
        while (it.hasNext()) {
            arrayList.add(0, new SpenHSVColor(it.next().getValue()));
        }
        return arrayList;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.model.menu.toolbar.p154hw.setting.migration.AbsMigrationPolicy
    public boolean replace(String str) {
        this.mLinkedHashMap.clear();
        return super.replace(this.mLinkedHashMap, str);
    }

    public void slackStore() {
        this.mHandler.removeCallbacks(this.mRecentColorSaveRunnable);
        this.mHandler.postDelayed(this.mRecentColorSaveRunnable, 500L);
    }

    private String getInfoString(LinkedHashMap<Integer, float[]> linkedHashMap) {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<Integer, float[]> entry : linkedHashMap.entrySet()) {
            sb.append(entry.getValue()[0]);
            sb.append(SQLKeyword.DELIMITER);
            sb.append(entry.getValue()[1]);
            sb.append(SQLKeyword.DELIMITER);
            sb.append(entry.getValue()[2]);
            sb.append(SQLKeyword.DELIMITER);
        }
        return sb.toString();
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.model.menu.toolbar.p154hw.setting.migration.AbsMigrationPolicy
    public void loadDefault(LinkedHashMap<Integer, float[]> linkedHashMap) {
        linkedHashMap.clear();
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.model.menu.toolbar.p154hw.setting.migration.AbsMigrationPolicy
    public void loadPreference(LinkedHashMap<Integer, float[]> linkedHashMap, String str) {
        loadData(linkedHashMap, str);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.model.menu.toolbar.p154hw.setting.migration.AbsMigrationPolicy
    public void migrate(LinkedHashMap<Integer, float[]> linkedHashMap, LegacyVersionException legacyVersionException) {
        loadData(linkedHashMap, legacyVersionException.getValue());
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.model.menu.toolbar.p154hw.setting.migration.AbsMigrationPolicy
    public void store(LinkedHashMap<Integer, float[]> linkedHashMap) {
        String infoString = getInfoString(linkedHashMap);
        AbstractC8014b.m7197C("store : ", infoString, TAG);
        super.saveData(infoString);
    }
}
