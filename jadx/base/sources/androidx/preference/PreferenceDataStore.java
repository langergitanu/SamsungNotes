package androidx.preference;

import androidx.annotation.Nullable;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
public abstract class PreferenceDataStore {
    public void putBoolean(String str, boolean z) {
        throw new UnsupportedOperationException("Not implemented on this data store");
    }

    public void putFloat(String str, float f) {
        throw new UnsupportedOperationException("Not implemented on this data store");
    }

    public void putInt(String str, int i) {
        throw new UnsupportedOperationException("Not implemented on this data store");
    }

    public void putLong(String str, long j) {
        throw new UnsupportedOperationException("Not implemented on this data store");
    }

    public void putString(String str, @Nullable String str2) {
        throw new UnsupportedOperationException("Not implemented on this data store");
    }

    public void putStringSet(String str, @Nullable Set<String> set) {
        throw new UnsupportedOperationException("Not implemented on this data store");
    }

    public boolean getBoolean(String str, boolean z) {
        return z;
    }

    public float getFloat(String str, float f) {
        return f;
    }

    public int getInt(String str, int i) {
        return i;
    }

    public long getLong(String str, long j) {
        return j;
    }

    @Nullable
    public String getString(String str, @Nullable String str2) {
        return str2;
    }

    @Nullable
    public Set<String> getStringSet(String str, @Nullable Set<String> set) {
        return set;
    }
}
