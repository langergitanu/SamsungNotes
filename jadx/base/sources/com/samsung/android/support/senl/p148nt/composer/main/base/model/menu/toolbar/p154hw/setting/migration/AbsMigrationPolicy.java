package com.samsung.android.support.senl.p148nt.composer.main.base.model.menu.toolbar.p154hw.setting.migration;

import androidx.annotation.NonNull;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.menu.toolbar.p154hw.setting.SPenPreferenceResolver;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbsMigrationPolicy<T> {
    private static final String TAG = Logger.createTag("AbsMigrationPolicy");
    private boolean mIsSkipSave;
    private boolean mIsSupportMigration;
    private final String mPreferenceKey;

    public AbsMigrationPolicy(@NonNull String str) {
        this.mIsSkipSave = false;
        this.mIsSupportMigration = true;
        this.mPreferenceKey = str;
    }

    public void applySave() {
        this.mIsSkipSave = false;
    }

    public void blockSave() {
        this.mIsSkipSave = true;
    }

    public abstract String getInfoString();

    public String getPreferenceKey() {
        return this.mPreferenceKey;
    }

    public boolean isSkipSave() {
        return this.mIsSkipSave;
    }

    public abstract void loadDefault(T t);

    public abstract void loadPreference(T t, String str);

    public abstract void migrate(T t, LegacyVersionException legacyVersionException);

    public void migration(T t, LegacyVersionException legacyVersionException) {
        try {
            migrate(t, legacyVersionException);
            store(t);
        } catch (Exception e) {
            onException(t, e);
        }
    }

    public void onException(T t, Exception exc) {
        Logger.m11000e(TAG, "onException : " + exc.getMessage());
        loadDefault(t);
    }

    public boolean replace(T t, String str) {
        try {
            loadPreference(t, str);
            return true;
        } catch (IndexOutOfBoundsException e) {
            onException(t, e);
            return false;
        }
    }

    public abstract boolean replace(String str);

    public void restore(T t) {
        Logger.m11003i(TAG, "restore# PreferenceKey: " + getPreferenceKey());
        try {
            loadPreference(t, SPenPreferenceResolver.getLatestString(this.mPreferenceKey));
        } catch (LegacyVersionException e) {
            loadDefault(t);
            if (this.mIsSupportMigration) {
                migration(t, e);
            }
        } catch (ClassCastException e2) {
            e = e2;
            onException(t, e);
        } catch (IndexOutOfBoundsException e3) {
            e = e3;
            onException(t, e);
        } catch (NoSuchFieldException e5) {
            e = e5;
            onException(t, e);
        } catch (NumberFormatException e6) {
            e = e6;
            onException(t, e);
        }
    }

    public void saveData(String str) {
        if (this.mIsSkipSave) {
            return;
        }
        SPenPreferenceResolver.setString(getPreferenceKey(), str);
    }

    public abstract void store(T t);

    public void applySave(String str) {
        applySave();
        saveData(str);
    }

    public AbsMigrationPolicy(@NonNull String str, boolean z) {
        this(str);
        this.mIsSupportMigration = z;
    }
}
