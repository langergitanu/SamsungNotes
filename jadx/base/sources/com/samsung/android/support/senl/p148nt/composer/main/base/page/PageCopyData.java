package com.samsung.android.support.senl.p148nt.composer.main.base.page;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class PageCopyData implements Comparable<PageCopyData> {
    public static final String PAGE_COPY_BOOKMARK_KEY = "page_copy_bookmark_key";
    private int mIndex;
    private boolean mIsBookmarked;

    public PageCopyData(int i, boolean z) {
        this.mIndex = i;
        this.mIsBookmarked = z;
    }

    public boolean equals(Object obj) {
        return (obj instanceof PageCopyData) && compareTo((PageCopyData) obj) == 0;
    }

    public int getIndex() {
        return this.mIndex;
    }

    public int hashCode() {
        return super.hashCode();
    }

    public boolean isBookmarked() {
        return this.mIsBookmarked;
    }

    @Override // java.lang.Comparable
    public int compareTo(PageCopyData pageCopyData) {
        return Integer.compare(this.mIndex, pageCopyData.getIndex());
    }
}
