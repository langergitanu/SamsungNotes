package com.samsung.android.support.senl.p148nt.composer.main.base.model.menu.toolbar.p154hw.setting.data;

import android.graphics.Color;
import androidx.annotation.IntRange;
import androidx.annotation.Size;
import com.samsung.android.support.senl.p145cm.base.framework.support.ColorCompat;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.menu.toolbar.p154hw.setting.SPenPreferenceResolver;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.menu.toolbar.p154hw.setting.SPenVersion;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.menu.toolbar.p154hw.setting.constants.Default;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.menu.toolbar.p154hw.setting.migration.AbsMigrationPolicy;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.menu.toolbar.p154hw.setting.migration.LegacyVersionException;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class SettingQuickColorData extends AbsMigrationPolicy<HsvColor[]> {
    private static final String DIVIDE = ";";
    private static final String KEY_SETTING_QUICK_COLOR_ = "KEY_SETTING_QUICK_COLOR_";
    private static final int QUICK_COLOR_MAX = 5;
    private static final String TAG = Logger.createTag("SettingQuickColorData");
    private final HsvColor[] mQuickColor;

    public SettingQuickColorData() {
        super(KEY_SETTING_QUICK_COLOR_, true);
        HsvColor[] hsvColorArr = new HsvColor[5];
        this.mQuickColor = hsvColorArr;
        loadDefault(hsvColorArr);
        restore(hsvColorArr);
    }

    private String loadLegacyData() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 3; i++) {
            try {
                SPenPreferenceResolver.getLatestString(getPreferenceKey() + i);
            } catch (LegacyVersionException e) {
                sb.append(e.getValue());
                sb.append(";");
            }
        }
        return sb.toString();
    }

    private int removeAlpha(int i) {
        return Color.rgb(Color.red(i), Color.green(i), Color.blue(i));
    }

    private void saveData() {
        saveData(getInfoString());
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.model.menu.toolbar.p154hw.setting.migration.AbsMigrationPolicy
    public String getInfoString() {
        StringBuilder sb = new StringBuilder();
        for (HsvColor hsvColor : this.mQuickColor) {
            sb.append(hsvColor.getString());
            sb.append(";");
        }
        return sb.toString();
    }

    public int getQuickColor(@IntRange(from = 0, m706to = 4) int i) {
        return this.mQuickColor[i].getColor();
    }

    public float[] getQuickHSVColor(@IntRange(from = 0, m706to = 4) int i) {
        return this.mQuickColor[i].mColor;
    }

    public boolean isEqualsExceptAlpha(@IntRange(from = 0, m706to = 4) int i, int i2) {
        return removeAlpha(this.mQuickColor[i].getColor()) == removeAlpha(i2);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.model.menu.toolbar.p154hw.setting.migration.AbsMigrationPolicy
    public boolean replace(String str) {
        return replace(this.mQuickColor, str);
    }

    public void setQuickHSVColor(@IntRange(from = 0, m706to = 4) int i, @Size(3) float[] fArr) {
        this.mQuickColor[i].setHSV(fArr);
        saveData();
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.model.menu.toolbar.p154hw.setting.migration.AbsMigrationPolicy
    public void loadDefault(HsvColor[] hsvColorArr) {
        for (int i = 0; i < hsvColorArr.length; i++) {
            hsvColorArr[i] = new HsvColor(Default.QUICK_COLOR[i]);
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.model.menu.toolbar.p154hw.setting.migration.AbsMigrationPolicy
    public void loadPreference(HsvColor[] hsvColorArr, String str) {
        Logger.m11003i(TAG, "loadPreference : " + str);
        String[] strArrSplit = str.split(";");
        if (strArrSplit.length > hsvColorArr.length) {
            throw new IndexOutOfBoundsException("stored data is bigger then variable array");
        }
        for (int i = 0; i < strArrSplit.length; i++) {
            hsvColorArr[i] = new HsvColor(strArrSplit[i]);
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.model.menu.toolbar.p154hw.setting.migration.AbsMigrationPolicy
    public void migrate(HsvColor[] hsvColorArr, LegacyVersionException legacyVersionException) {
        SPenVersion.Version version = legacyVersionException.getVersion();
        Logger.m11003i(TAG, "migrateByVersion " + version.name());
        loadPreference(hsvColorArr, legacyVersionException.getValue());
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.model.menu.toolbar.p154hw.setting.migration.AbsMigrationPolicy
    public void restore(HsvColor[] hsvColorArr) {
        String strLoadLegacyData;
        Logger.m11003i(TAG, "restore# PreferenceKey: " + getPreferenceKey());
        try {
            try {
                try {
                    strLoadLegacyData = SPenPreferenceResolver.getLatestString(getPreferenceKey());
                } catch (NoSuchFieldException e) {
                    e = e;
                    onException(hsvColorArr, e);
                }
            } catch (NoSuchFieldException unused) {
                strLoadLegacyData = loadLegacyData();
            }
            loadPreference(hsvColorArr, strLoadLegacyData);
        } catch (LegacyVersionException e2) {
            loadDefault(hsvColorArr);
            migration(hsvColorArr, e2);
        } catch (IndexOutOfBoundsException e3) {
            e = e3;
            onException(hsvColorArr, e);
        } catch (NumberFormatException e5) {
            e = e5;
            onException(hsvColorArr, e);
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.model.menu.toolbar.p154hw.setting.migration.AbsMigrationPolicy
    public void store(HsvColor[] hsvColorArr) {
        saveData();
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class HsvColor {
        private static final String DIVIDE_HSV = ":";
        private static final int HSV_COUNT = 3;
        private final float[] mColor;

        public HsvColor(String str) {
            float[] fArr = new float[3];
            this.mColor = fArr;
            String[] strArrSplit = str.split(":");
            if (fArr.length != strArrSplit.length) {
                throw new IndexOutOfBoundsException("Different data size");
            }
            for (int i = 0; i < 3; i++) {
                this.mColor[i] = Float.parseFloat(strArrSplit[i]);
            }
        }

        public int getColor() {
            return ColorCompat.HSVToColor(this.mColor);
        }

        public float[] getHsvColor() {
            return this.mColor;
        }

        public String getString() {
            StringBuilder sb = new StringBuilder();
            int i = 0;
            while (true) {
                float[] fArr = this.mColor;
                if (i >= fArr.length) {
                    return sb.toString();
                }
                sb.append(fArr[i]);
                sb.append(":");
                i++;
            }
        }

        public void setHSV(float[] fArr) {
            System.arraycopy(fArr, 0, this.mColor, 0, 3);
        }

        public HsvColor(int i) {
            float[] fArr = new float[3];
            this.mColor = fArr;
            ColorCompat.colorToHSV(i, fArr);
        }

        public HsvColor(float[] fArr) {
            this.mColor = new float[3];
            setHSV(fArr);
        }
    }
}
