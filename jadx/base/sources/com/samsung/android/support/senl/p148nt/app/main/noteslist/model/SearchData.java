package com.samsung.android.support.senl.p148nt.app.main.noteslist.model;

import android.content.ComponentName;
import androidx.annotation.NonNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public class SearchData {
    private String mSavedSearchQuery = null;
    private String mSavedText = "";
    private boolean mSkipQuery = false;
    private ComponentName mComponentName = null;

    public ComponentName getComponentName() {
        return this.mComponentName;
    }

    public String getSavedSearchQuery() {
        return this.mSavedSearchQuery;
    }

    @NonNull
    public String getSavedText() {
        return this.mSavedText;
    }

    public boolean getSkipQuery() {
        return this.mSkipQuery;
    }

    public SearchData setComponentName(ComponentName componentName) {
        this.mComponentName = componentName;
        return this;
    }

    public SearchData setSavedSearchQuery(String str) {
        this.mSavedSearchQuery = str;
        return this;
    }

    public SearchData setSavedText(@NonNull String str) {
        this.mSavedText = str;
        return this;
    }

    public SearchData setSkipQuery(boolean z) {
        this.mSkipQuery = z;
        return this;
    }
}
