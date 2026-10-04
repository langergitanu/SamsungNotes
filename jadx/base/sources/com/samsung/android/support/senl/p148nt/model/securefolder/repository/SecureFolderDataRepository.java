package com.samsung.android.support.senl.p148nt.model.securefolder.repository;

import com.samsung.android.support.senl.p145cm.base.framework.content.SharedPreferencesCompat;
import java.util.Collection;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public class SecureFolderDataRepository {
    private static final String SECURE_FOLDER_MOVE_PREF_NAME = "MOVE_PREFERENCE";

    private static SharedPreferencesCompat getPreference() {
        return SharedPreferencesCompat.getInstance(SECURE_FOLDER_MOVE_PREF_NAME);
    }

    public void addDocumentUuid(String str, String str2) {
        getPreference().putString(str, str2);
    }

    public String getDocumentUuid(String str) {
        return getPreference().getString(str, "");
    }

    public void removeDocumentUuid(String str) {
        getPreference().remove(str);
    }

    public void removeDocumentUuids(Collection<String> collection) {
        SharedPreferencesCompat preference = getPreference();
        Iterator<String> it = collection.iterator();
        while (it.hasNext()) {
            preference.remove(it.next());
        }
    }
}
