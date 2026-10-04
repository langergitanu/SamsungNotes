package com.microsoft.identity.common;

import android.content.Context;
import com.microsoft.identity.common.internal.cache.SharedPreferencesFileManager;
import com.microsoft.identity.common.internal.util.AbstractSharedPrefNameValueStorage;
import com.microsoft.identity.common.java.constants.SpotbugsWarning;
import com.microsoft.identity.common.java.util.ported.Predicate;
import edu.umd.cs.findbugs.annotations.Nullable;
import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import java.util.Iterator;
import java.util.Map;
import lombok.NonNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class SharedPreferenceStringStorage extends AbstractSharedPrefNameValueStorage<String> {
    @SuppressFBWarnings(justification = "Lombok inserts nullchecks", value = {SpotbugsWarning.RCN_REDUNDANT_NULLCHECK_WOULD_HAVE_BEEN_A_NPE})
    public SharedPreferenceStringStorage(@NonNull Context context, @NonNull String str) {
        super(SharedPreferencesFileManager.getSharedPreferences(context, str, null));
        if (context == null) {
            throw new NullPointerException("context is marked non-null but is null");
        }
        if (str == null) {
            throw new NullPointerException("sharedPrefFileName is marked non-null but is null");
        }
    }

    @Override // com.microsoft.identity.common.java.interfaces.INameValueStorage
    @NonNull
    public Map<String, String> getAll() {
        return this.mManager.getAll();
    }

    @Override // com.microsoft.identity.common.java.interfaces.INameValueStorage
    public Iterator<Map.Entry<String, String>> getAllFilteredByKey(Predicate<String> predicate) {
        return this.mManager.getAllFilteredByKey(predicate);
    }

    @Override // com.microsoft.identity.common.java.interfaces.INameValueStorage
    public String get(@NonNull String str) {
        if (str != null) {
            return this.mManager.getString(str);
        }
        throw new NullPointerException("name is marked non-null but is null");
    }

    @Override // com.microsoft.identity.common.java.interfaces.INameValueStorage
    public void put(@NonNull String str, @Nullable String str2) {
        if (str == null) {
            throw new NullPointerException("name is marked non-null but is null");
        }
        this.mManager.putString(str, str2);
    }
}
