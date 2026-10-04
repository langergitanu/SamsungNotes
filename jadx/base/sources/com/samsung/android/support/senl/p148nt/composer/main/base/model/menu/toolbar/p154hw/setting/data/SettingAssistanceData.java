package com.samsung.android.support.senl.p148nt.composer.main.base.model.menu.toolbar.p154hw.setting.data;

import androidx.appcompat.widget.AbstractC0541b;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.menu.toolbar.p154hw.setting.migration.AbsMigrationPolicy;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.menu.toolbar.p154hw.setting.migration.LegacyVersionException;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class SettingAssistanceData extends AbsMigrationPolicy<Integer[]> {
    private static final String DIVIDE = ";";
    private static final String KEY_SETTING_ASSISTANCE = "KEY_SETTING_ASSISTANCE";
    private static final String TAG = Logger.createTag("SettingHwAssistanceData");
    private Integer[] mOptionArray;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public enum Index {
        Guideline,
        AlignLetters,
        FixShapeLetters
    }

    public SettingAssistanceData() {
        super(KEY_SETTING_ASSISTANCE);
        Integer[] numArr = new Integer[Index.values().length];
        this.mOptionArray = numArr;
        loadDefault(numArr);
        super.restore(this.mOptionArray);
    }

    private void saveData() {
        saveData(getInfoString());
    }

    public boolean getAlignLettersEnabled() {
        return this.mOptionArray[Index.AlignLetters.ordinal()].intValue() == 1;
    }

    public boolean getFixShapeLettersEnabled() {
        return this.mOptionArray[Index.FixShapeLetters.ordinal()].intValue() == 1;
    }

    public boolean getGuidelineEnable() {
        return this.mOptionArray[Index.Guideline.ordinal()].intValue() == 1;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.model.menu.toolbar.p154hw.setting.migration.AbsMigrationPolicy
    public String getInfoString() {
        StringBuilder sb = new StringBuilder();
        for (Integer num : this.mOptionArray) {
            sb.append(num.intValue());
            sb.append(";");
        }
        return sb.toString();
    }

    public boolean hasEnableOption() {
        return getAlignLettersEnabled() || getFixShapeLettersEnabled();
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.model.menu.toolbar.p154hw.setting.migration.AbsMigrationPolicy
    public boolean replace(String str) {
        return replace(this.mOptionArray, str);
    }

    public void setAlignLettersEnabled(boolean z) {
        this.mOptionArray[Index.AlignLetters.ordinal()] = Integer.valueOf(z ? 1 : 0);
        saveData();
    }

    public void setFixShapeLettersEnabled(boolean z) {
        this.mOptionArray[Index.FixShapeLetters.ordinal()] = Integer.valueOf(z ? 1 : 0);
        saveData();
    }

    public void setGuideLineEnable(boolean z) {
        this.mOptionArray[Index.Guideline.ordinal()] = Integer.valueOf(z ? 1 : 0);
        saveData();
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.model.menu.toolbar.p154hw.setting.migration.AbsMigrationPolicy
    public void loadDefault(Integer[] numArr) {
        this.mOptionArray[Index.Guideline.ordinal()] = 1;
        this.mOptionArray[Index.AlignLetters.ordinal()] = 1;
        this.mOptionArray[Index.FixShapeLetters.ordinal()] = 1;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.model.menu.toolbar.p154hw.setting.migration.AbsMigrationPolicy
    public void loadPreference(Integer[] numArr, String str) {
        String str2 = TAG;
        Logger.m11003i(str2, "loadPreference : " + str);
        String[] strArrSplit = str.split(";");
        if (strArrSplit.length != Index.values().length) {
            StringBuilder sbM781w = AbstractC0541b.m781w(str2, "# save data mismatched ");
            sbM781w.append(strArrSplit.length);
            sbM781w.append(" ");
            sbM781w.append(Index.values().length);
            throw new IndexOutOfBoundsException(sbM781w.toString());
        }
        for (Index index : Index.values()) {
            numArr[index.ordinal()] = Integer.valueOf(Integer.parseInt(strArrSplit[index.ordinal()]));
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.model.menu.toolbar.p154hw.setting.migration.AbsMigrationPolicy
    public void migrate(Integer[] numArr, LegacyVersionException legacyVersionException) {
        loadPreference(numArr, legacyVersionException.getValue());
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.model.menu.toolbar.p154hw.setting.migration.AbsMigrationPolicy
    public void store(Integer[] numArr) {
        saveData();
    }
}
