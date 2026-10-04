package com.samsung.android.support.senl.p148nt.composer.main.base.model.menu.list.pages;

import androidx.appcompat.widget.AbstractC0541b;
import com.samsung.android.support.senl.p148nt.composer.main.base.page.PageInfo;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class BookmarkModel {
    private static final String TAG = Logger.createTag("BookmarkModel");
    private final HashMap<String, BookmarkData> mMap = new HashMap<>();
    private final List<IBookmarkUpdateListener> mListenerList = new ArrayList();

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class BookmarkData {
        private int mIndex;
        private boolean mIsBookmarked;
        private boolean mIsDeleted = false;

        public BookmarkData(int i, boolean z) {
            this.mIndex = i;
            this.mIsBookmarked = z;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface IBookmarkUpdateListener {
        void onBookmarkPageUpdated(String str, int i, boolean z);

        void onBookmarkUpdated(String str, int i, boolean z, boolean z2);
    }

    private void notifyPageUpdated(String str, int i, boolean z) {
        Iterator<IBookmarkUpdateListener> it = this.mListenerList.iterator();
        while (it.hasNext()) {
            it.next().onBookmarkPageUpdated(str, i, z);
        }
    }

    private void notifyUpdated(String str, int i, boolean z, boolean z2) {
        Iterator<IBookmarkUpdateListener> it = this.mListenerList.iterator();
        while (it.hasNext()) {
            it.next().onBookmarkUpdated(str, i, z, z2);
        }
    }

    public void addListener(IBookmarkUpdateListener iBookmarkUpdateListener) {
        this.mListenerList.add(iBookmarkUpdateListener);
    }

    public void clear() {
        this.mMap.clear();
    }

    public boolean hasBookmarkedPage() {
        Iterator<Map.Entry<String, BookmarkData>> it = this.mMap.entrySet().iterator();
        while (it.hasNext()) {
            BookmarkData value = it.next().getValue();
            if (value.mIsBookmarked && !value.mIsDeleted) {
                return true;
            }
        }
        return false;
    }

    public boolean isBookmarked(String str) {
        BookmarkData bookmarkData = this.mMap.get(str);
        return bookmarkData != null && bookmarkData.mIsBookmarked;
    }

    public void update(PageInfo pageInfo) {
        boolean z;
        String pageId = pageInfo.getPageId();
        int pageIndex = pageInfo.getPageIndex();
        BookmarkData bookmarkData = this.mMap.get(pageId);
        boolean z2 = true;
        if (bookmarkData != null) {
            z2 = true ^ bookmarkData.mIsBookmarked;
            z = bookmarkData.mIsDeleted;
        } else {
            z = false;
        }
        update(pageId, pageIndex, z2, z, false);
    }

    public boolean updateDeletedInfo(String str, boolean z) {
        BookmarkData bookmarkData = this.mMap.get(str);
        if (bookmarkData == null) {
            return false;
        }
        if (z == bookmarkData.mIsDeleted) {
            return true;
        }
        bookmarkData.mIsDeleted = z;
        notifyPageUpdated(str, bookmarkData.mIndex, z);
        return true;
    }

    public void update(String str, int i, boolean z, boolean z2, boolean z3) {
        BookmarkData bookmarkData = this.mMap.get(str);
        if (bookmarkData != null) {
            if (bookmarkData.mIndex == i && bookmarkData.mIsBookmarked == z) {
                return;
            }
            bookmarkData.mIndex = i;
            bookmarkData.mIsBookmarked = z;
            bookmarkData.mIsDeleted = z2;
        } else {
            BookmarkData bookmarkData2 = new BookmarkData(i, z);
            bookmarkData2.mIsDeleted = z2;
            this.mMap.put(str, bookmarkData2);
        }
        String str2 = TAG;
        StringBuilder sbM780v = AbstractC0541b.m780v("update# pageId / index / isBookmarked / isDeleted = ", i, str, " / ", " / ");
        sbM780v.append(z);
        sbM780v.append(" / ");
        sbM780v.append(z2);
        Logger.m11003i(str2, sbM780v.toString());
        notifyUpdated(str, i, z, z3);
    }
}
