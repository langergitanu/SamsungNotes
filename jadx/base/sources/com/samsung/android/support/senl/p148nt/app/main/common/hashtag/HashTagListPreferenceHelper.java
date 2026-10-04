package com.samsung.android.support.senl.p148nt.app.main.common.hashtag;

import androidx.annotation.NonNull;
import com.samsung.android.support.senl.p145cm.base.framework.content.SharedPreferencesCompat;
import com.samsung.android.support.senl.p148nt.app.common.NotesConstants;
import com.samsung.android.support.senl.p148nt.base.common.constants.Constants;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public class HashTagListPreferenceHelper {
    private static HashTagListPreferenceHelper mInstance;

    public static synchronized HashTagListPreferenceHelper getInstance() {
        try {
            if (mInstance == null) {
                mInstance = new HashTagListPreferenceHelper();
            }
        } catch (Throwable th) {
            throw th;
        }
        return mInstance;
    }

    @NonNull
    public Set<String> getSelectedTags() {
        Set<String> stringSet = SharedPreferencesCompat.getInstance(NotesConstants.PREF_NOTES_FRAGMENT).getStringSet(Constants.KEY_SELECTED_TAGS, new HashSet());
        if (stringSet == null) {
            stringSet = new HashSet<>();
            SharedPreferencesCompat.getInstance(NotesConstants.PREF_NOTES_FRAGMENT).putStringSet(Constants.KEY_SELECTED_TAGS, stringSet);
        }
        return new HashSet(stringSet);
    }

    public void setSelectedTags(Set<String> set) {
        if (set == null) {
            set = new HashSet<>();
        }
        SharedPreferencesCompat.getInstance(NotesConstants.PREF_NOTES_FRAGMENT).putStringSet(Constants.KEY_SELECTED_TAGS, set);
    }
}
