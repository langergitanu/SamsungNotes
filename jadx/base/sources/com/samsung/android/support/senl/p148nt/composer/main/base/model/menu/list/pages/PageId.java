package com.samsung.android.support.senl.p148nt.composer.main.base.model.menu.list.pages;

import androidx.collection.AbstractC0622a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class PageId {
    private String mId;
    private String mSearchThumbnailPath;

    public PageId(String str) {
        this.mId = str;
        this.mSearchThumbnailPath = null;
    }

    public String getId() {
        return this.mId;
    }

    public String getSearchThumbnailPath() {
        return this.mSearchThumbnailPath;
    }

    public void setId(String str) {
        this.mId = str;
        this.mSearchThumbnailPath = null;
    }

    public void setSearchThumbnailPath(String str) {
        this.mSearchThumbnailPath = str;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("PageId{mId=");
        sb.append(this.mId);
        sb.append(", mSearchThumbnailPath='");
        return AbstractC0622a.m1170p(this.mSearchThumbnailPath, "'}", sb);
    }

    public PageId(String str, String str2) {
        this.mId = str;
        this.mSearchThumbnailPath = str2;
    }
}
