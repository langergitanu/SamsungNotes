package com.samsung.android.support.senl.p148nt.composer.main.base.model.composer.search;

import java.io.Serializable;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class RecentSearchKeywords implements Serializable {
    private static final int SIZE_LIMIT = 10;
    private static final long serialVersionUID = 1;
    private final LinkedList<RecentSearchKeywordInfo> mInfoList = new LinkedList<>();

    public void add(String str) {
        remove(str);
        this.mInfoList.addFirst(new RecentSearchKeywordInfo(str, System.currentTimeMillis()));
        if (this.mInfoList.size() > 10) {
            this.mInfoList.removeLast();
        }
    }

    public boolean contain(String str) {
        Iterator<RecentSearchKeywordInfo> it = this.mInfoList.iterator();
        while (it.hasNext()) {
            if (it.next().getKeyword().equals(str)) {
                return true;
            }
        }
        return false;
    }

    public List<RecentSearchKeywordInfo> getInfoList() {
        return this.mInfoList;
    }

    public boolean isEmpty() {
        return this.mInfoList.isEmpty();
    }

    public boolean remove(String str) {
        for (RecentSearchKeywordInfo recentSearchKeywordInfo : this.mInfoList) {
            if (recentSearchKeywordInfo.getKeyword().equals(str)) {
                this.mInfoList.remove(recentSearchKeywordInfo);
                return true;
            }
        }
        return false;
    }
}
