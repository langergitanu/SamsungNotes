package com.samsung.android.support.senl.p148nt.composer.main.base.model.composer.search;

import java.io.Serializable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class RecentSearchKeywordInfo implements Serializable {
    private static final long serialVersionUID = 1;
    private final String mKeyword;
    private final long mTime;

    public RecentSearchKeywordInfo(String str, long j) {
        this.mKeyword = str;
        this.mTime = j;
    }

    public String getKeyword() {
        return this.mKeyword;
    }

    public long getTime() {
        return this.mTime;
    }
}
