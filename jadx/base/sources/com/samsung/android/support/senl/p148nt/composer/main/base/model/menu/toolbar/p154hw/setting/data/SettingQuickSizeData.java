package com.samsung.android.support.senl.p148nt.composer.main.base.model.menu.toolbar.p154hw.setting.data;

import androidx.annotation.IntRange;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.menu.toolbar.p154hw.setting.constants.Default;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.menu.toolbar.p154hw.setting.migration.AbsMigrationPolicy;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.menu.toolbar.p154hw.setting.migration.LegacyVersionException;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class SettingQuickSizeData extends AbsMigrationPolicy<QuickSize[]> {
    private static final String DIVIDE = ";";
    private static final String KEY_SETTING_QUICK_SIZE = "KEY_SETTING_QUICK_SIZE";
    private static final int QUICK_SIZE_MAX = 3;
    private static final String TAG = Logger.createTag("SettingQuickSizeData");
    private final QuickSize[] mQuickSize;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class QuickSize {
        int mSize;

        public QuickSize(int i) {
            setSize(i);
        }

        public int getSize() {
            return this.mSize;
        }

        public String getString() {
            return Integer.toString(this.mSize);
        }

        public void setSize(int i) {
            this.mSize = i;
        }

        public void setSize(String str) {
            this.mSize = Integer.parseInt(str);
        }

        public QuickSize(String str) {
            setSize(str);
        }
    }

    public SettingQuickSizeData() {
        super(KEY_SETTING_QUICK_SIZE);
        QuickSize[] quickSizeArr = new QuickSize[3];
        this.mQuickSize = quickSizeArr;
        loadDefault(quickSizeArr);
        restore(quickSizeArr);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.model.menu.toolbar.p154hw.setting.migration.AbsMigrationPolicy
    public String getInfoString() {
        StringBuilder sb = new StringBuilder();
        for (QuickSize quickSize : this.mQuickSize) {
            sb.append(quickSize.getString());
            sb.append(";");
        }
        return sb.toString();
    }

    public int getSize(@IntRange(from = 0, m706to = 2) int i) {
        return this.mQuickSize[i].getSize();
    }

    public boolean isEquals(@IntRange(from = 0, m706to = 2) int i, int i2) {
        return this.mQuickSize[i].getSize() == i2;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.model.menu.toolbar.p154hw.setting.migration.AbsMigrationPolicy
    public boolean replace(String str) {
        return replace(this.mQuickSize, str);
    }

    public void setSize(@IntRange(from = 0, m706to = 2) int i, @IntRange(from = 0, m706to = 100) int i2) {
        this.mQuickSize[i].setSize(i2);
        saveData(getInfoString());
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.model.menu.toolbar.p154hw.setting.migration.AbsMigrationPolicy
    public void loadDefault(QuickSize[] quickSizeArr) {
        for (int i = 0; i < quickSizeArr.length; i++) {
            quickSizeArr[i] = new QuickSize(Default.QUICK_SIZE[i]);
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.model.menu.toolbar.p154hw.setting.migration.AbsMigrationPolicy
    public void loadPreference(QuickSize[] quickSizeArr, String str) {
        Logger.m11003i(TAG, "loadPreference : " + str);
        String[] strArrSplit = str.split(";");
        if (strArrSplit.length > quickSizeArr.length) {
            throw new IndexOutOfBoundsException("stored data is bigger then variable array");
        }
        for (int i = 0; i < strArrSplit.length; i++) {
            quickSizeArr[i] = new QuickSize(strArrSplit[i]);
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.model.menu.toolbar.p154hw.setting.migration.AbsMigrationPolicy
    public void migrate(QuickSize[] quickSizeArr, LegacyVersionException legacyVersionException) {
        loadPreference(quickSizeArr, legacyVersionException.getValue());
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.model.menu.toolbar.p154hw.setting.migration.AbsMigrationPolicy
    public void onException(QuickSize[] quickSizeArr, Exception exc) {
        loadDefault(quickSizeArr);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.model.menu.toolbar.p154hw.setting.migration.AbsMigrationPolicy
    public void store(QuickSize[] quickSizeArr) {
        saveData(getInfoString());
    }
}
