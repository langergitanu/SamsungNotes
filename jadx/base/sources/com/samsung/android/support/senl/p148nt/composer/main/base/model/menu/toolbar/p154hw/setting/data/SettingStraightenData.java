package com.samsung.android.support.senl.p148nt.composer.main.base.model.menu.toolbar.p154hw.setting.data;

import com.samsung.android.support.senl.p148nt.composer.main.base.model.menu.toolbar.p154hw.setting.migration.AbsMigrationPolicy;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.menu.toolbar.p154hw.setting.migration.LegacyVersionException;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class SettingStraightenData extends AbsMigrationPolicy<Integer[]> {
    private static final String DIVIDE = ";";
    private static final String KEY_SETTING_STRAIGHTEN = "KEY_SETTING_STRAIGHTEN";
    private static final String TAG = Logger.createTag("SettingStraightenData");
    private Integer[] mOptionArray;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public enum Index {
        Straighten,
        AlignLetters,
        EvenlySpaceWords,
        FixShapeLetters
    }

    public SettingStraightenData() {
        super(KEY_SETTING_STRAIGHTEN);
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

    public boolean getEvenlySpaceWordsEnabled() {
        return this.mOptionArray[Index.EvenlySpaceWords.ordinal()].intValue() == 1;
    }

    public boolean getFixShapeLettersEnabled() {
        return this.mOptionArray[Index.FixShapeLetters.ordinal()].intValue() == 1;
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

    public boolean getStraightenEnabled() {
        return this.mOptionArray[Index.Straighten.ordinal()].intValue() == 1;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.model.menu.toolbar.p154hw.setting.migration.AbsMigrationPolicy
    public boolean replace(String str) {
        return replace(this.mOptionArray, str);
    }

    public void set(SettingStraightenData settingStraightenData) {
        setStraightenEnabled(settingStraightenData.getStraightenEnabled());
        setAlignLettersEnabled(settingStraightenData.getAlignLettersEnabled());
        setEvenlySpaceWordsEnabled(settingStraightenData.getEvenlySpaceWordsEnabled());
        setFixShapeLettersEnabled(settingStraightenData.getFixShapeLettersEnabled());
    }

    public void setAlignLettersEnabled(boolean z) {
        this.mOptionArray[Index.AlignLetters.ordinal()] = Integer.valueOf(z ? 1 : 0);
        saveData();
    }

    public void setEvenlySpaceWordsEnabled(boolean z) {
        this.mOptionArray[Index.EvenlySpaceWords.ordinal()] = Integer.valueOf(z ? 1 : 0);
        saveData();
    }

    public void setFixShapeLettersEnabled(boolean z) {
        this.mOptionArray[Index.FixShapeLetters.ordinal()] = Integer.valueOf(z ? 1 : 0);
        saveData();
    }

    public void setStraightenEnabled(boolean z) {
        this.mOptionArray[Index.Straighten.ordinal()] = Integer.valueOf(z ? 1 : 0);
        saveData();
    }

    /* JADX INFO: renamed from: clone, reason: merged with bridge method [inline-methods] */
    public SettingStraightenData m22190clone() {
        return new SettingStraightenData(this.mOptionArray);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.model.menu.toolbar.p154hw.setting.migration.AbsMigrationPolicy
    public void loadDefault(Integer[] numArr) {
        this.mOptionArray[Index.Straighten.ordinal()] = 1;
        this.mOptionArray[Index.AlignLetters.ordinal()] = 1;
        this.mOptionArray[Index.EvenlySpaceWords.ordinal()] = 1;
        this.mOptionArray[Index.FixShapeLetters.ordinal()] = 1;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.model.menu.toolbar.p154hw.setting.migration.AbsMigrationPolicy
    public void loadPreference(Integer[] numArr, String str) {
        Logger.m11003i(TAG, "loadPreference : " + str);
        String[] strArrSplit = str.split(";");
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

    private SettingStraightenData(Integer[] numArr) {
        super(KEY_SETTING_STRAIGHTEN);
        this.mOptionArray = new Integer[Index.values().length];
        this.mOptionArray = (Integer[]) numArr.clone();
    }
}
