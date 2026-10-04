package com.samsung.android.support.senl.p148nt.composer.main.base.model.menu.toolbar.directwrite;

import android.os.Bundle;
import androidx.annotation.NonNull;
import com.samsung.android.support.senl.p145cm.base.framework.content.SharedPreferencesCompat;
import java.util.NoSuchElementException;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
abstract class AbsStoredData<T> implements ISaveInstance {
    private T defaultValue;
    private String preferenceKey;
    SharedPreferencesCompat sharedPreferencesCompat = SharedPreferencesCompat.getInstance("Composer");

    public AbsStoredData(String str, T t) {
        this.preferenceKey = str;
        this.defaultValue = t;
    }

    public T getStoredValue() {
        SharedPreferencesCompat sharedPreferencesCompat = SharedPreferencesCompat.getInstance("Composer");
        T t = this.defaultValue;
        if (t instanceof Integer) {
            return (T) Integer.valueOf(sharedPreferencesCompat.getInt(this.preferenceKey, ((Integer) t).intValue()));
        }
        if (t instanceof Boolean) {
            return (T) Boolean.valueOf(sharedPreferencesCompat.getBoolean(this.preferenceKey, ((Boolean) t).booleanValue()));
        }
        if (t instanceof String) {
            return (T) sharedPreferencesCompat.getString(this.preferenceKey, (String) t);
        }
        throw new NoSuchElementException("not support type of stored");
    }

    public T getValue() {
        try {
            return getStoredValue();
        } catch (NoSuchElementException unused) {
            return this.defaultValue;
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.model.menu.toolbar.directwrite.ISaveInstance
    public void onSaveInstanceState(@NonNull Bundle bundle) {
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.model.menu.toolbar.directwrite.ISaveInstance
    public void restoreState(Bundle bundle) {
    }

    public void setValue(T t) {
        storeValue(t);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void storeValue(T t) {
        if (t instanceof Integer) {
            this.sharedPreferencesCompat.putInt(this.preferenceKey, ((Integer) t).intValue());
        } else if (t instanceof Boolean) {
            this.sharedPreferencesCompat.putBoolean(this.preferenceKey, ((Boolean) t).booleanValue());
        } else if (t instanceof String) {
            this.sharedPreferencesCompat.putString(this.preferenceKey, (String) t);
        }
    }
}
