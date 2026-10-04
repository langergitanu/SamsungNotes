package com.samsung.android.support.senl.p148nt.composer.main.base.page;

import android.graphics.Bitmap;
import androidx.annotation.NonNull;
import androidx.appcompat.widget.AbstractC0541b;
import androidx.collection.AbstractC0622a;
import com.samsung.android.sdk.pen.document.SpenObjectTextBox;
import com.samsung.android.sdk.pen.worddoc.SpenWNote;
import com.samsung.android.sdk.pen.worddoc.SpenWPage;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.base.common.NoteCaptureControl;
import com.samsung.android.support.senl.p148nt.base.common.util.ImageUtils;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.ComposerCacheFileUtil;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class PageManager {
    private static final String TAG = Logger.createTag("PageManager");
    private String mCacheDirPath;
    private float mDefaultThumbnailWidth;
    private DocPageInfo mDocPageInfo;
    private List<PageInfo> mPageList;
    private SpenWNote.PageMode mPageMode;
    private String mThumbnailCacheDirPath;
    private float mThumbnailRatio;
    private final AtomicBoolean mIsDestroyed = new AtomicBoolean(false);
    private final Object mLock = new Object();
    private boolean mBlockingInsert = false;
    private boolean mSkipToSaveCache = false;
    private boolean mBlockingNotiToInsert = false;
    private final List<OnPageUpdateListener> mListeners = new ArrayList(2);

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface OnPageUpdateListener {
        public static final int TYPE_MOVE_PAGE = 2;
        public static final int TYPE_UPDATE_PAGE = 1;
        public static final int TYPE_UPDATE_PAGE_COUNT = 3;

        void onDeletedPages(List<Integer> list, PageUpdateState pageUpdateState);

        void onInsertedPages(PageUpdateState pageUpdateState);

        void onUpdatePage(int i, int i2, int i4, PageUpdateState pageUpdateState);
    }

    public PageManager(String str, String str2, int i, float f) {
        setCacheDirPath(str, str2);
        updateThumbnailRatio(i, f);
        Logger.m11003i(TAG, "PageManager, cacheDir : " + this.mCacheDirPath + ", mThumbnailCacheDirPath : " + str2);
    }

    private PageInfo createPageInfo(int i, SpenWPage spenWPage) {
        PageInfo pageInfo = new PageInfo(i, spenWPage.getWidth(), spenWPage.getHeight(), null, spenWPage.getId(), false, spenWPage.getModifiedTime());
        pageInfo.setThumbnailRatio(this.mThumbnailRatio);
        pageInfo.setDirty(true);
        pageInfo.setThumbnailFilePath(makeThumbnailFilePath(pageInfo.getPageId()));
        return pageInfo;
    }

    private boolean loadCache() {
        FileInputStream fileInputStream;
        ObjectInputStream objectInputStream;
        DocPageInfo docPageInfo;
        String str = TAG;
        Logger.m10999d(str, "loadCache# start");
        long jCurrentTimeMillis = System.currentTimeMillis();
        File parentFile = new File(this.mCacheDirPath).getParentFile();
        boolean z = false;
        if (parentFile == null) {
            return false;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(parentFile.getAbsolutePath());
        File file = new File(AbstractC0622a.m1170p(File.separator, ComposerCacheFileUtil.PAGE_CACHE_INFO_DAT, sb));
        if (!file.exists()) {
            return false;
        }
        try {
            fileInputStream = new FileInputStream(file);
            try {
                objectInputStream = new ObjectInputStream(fileInputStream);
                try {
                    docPageInfo = (DocPageInfo) objectInputStream.readObject();
                    this.mDocPageInfo = docPageInfo;
                } finally {
                }
            } catch (Throwable th) {
                fileInputStream.close();
                throw th;
            }
        } catch (IOException | ClassNotFoundException e) {
            Logger.m11001e(TAG, e.getMessage(), e);
        }
        if (docPageInfo == null) {
            objectInputStream.close();
            fileInputStream.close();
            return false;
        }
        docPageInfo.init();
        Logger.m11003i(str, this.mDocPageInfo.toString());
        this.mDocPageInfo.clearPositionAfterDays();
        z = true;
        objectInputStream.close();
        fileInputStream.close();
        Logger.m10999d(TAG, "loadCache# end " + (System.currentTimeMillis() - jCurrentTimeMillis));
        return z;
        try {
            fileInputStream.close();
        } catch (Throwable th2) {
            th.addSuppressed(th2);
        }
        throw th;
    }

    private String makeThumbnailFilePath(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(this.mThumbnailCacheDirPath);
        return AbstractC0622a.m1170p(File.separator, str, sb);
    }

    private void notifyDataInserted(@NonNull PageUpdateState pageUpdateState) {
        Logger.m10999d(TAG, "notifyDataInserted# ");
        Iterator<OnPageUpdateListener> it = this.mListeners.iterator();
        while (it.hasNext()) {
            it.next().onInsertedPages(pageUpdateState);
        }
    }

    private String saveThumbnail(NoteCaptureControl noteCaptureControl, SpenWNote spenWNote, SpenWPage spenWPage, SpenObjectTextBox spenObjectTextBox, int i, float f) throws Exception {
        if (this.mPageMode == SpenWNote.PageMode.SINGLE) {
            return null;
        }
        String str = TAG;
        Logger.m10999d(str, "saveThumbnail#");
        noteCaptureControl.setWNote(spenWNote);
        noteCaptureControl.setContents(spenWPage, spenObjectTextBox, i);
        noteCaptureControl.setColorTheme(this.mDocPageInfo.isEnabledDarkTheme() ? 1 : 0);
        Bitmap bitmapCapturePage = noteCaptureControl.capturePage(f);
        Logger.m10999d(str, "saveThumbnail# capture done");
        String strMakeThumbnailFilePath = makeThumbnailFilePath(spenWPage.getId());
        if (ImageUtils.makeJpg(bitmapCapturePage, strMakeThumbnailFilePath, 100, true)) {
            return strMakeThumbnailFilePath;
        }
        throw new Exception("fail to make thumbnail");
    }

    public void add(PageInfo pageInfo) {
        Logger.m10999d(TAG, "add# " + pageInfo);
        pageInfo.setThumbnailRatio(this.mThumbnailRatio);
        synchronized (this.mLock) {
            this.mPageList.add(pageInfo);
        }
    }

    public void addListener(OnPageUpdateListener onPageUpdateListener) {
        if (this.mListeners.contains(onPageUpdateListener)) {
            return;
        }
        this.mListeners.add(onPageUpdateListener);
    }

    public void clearData(SpenWNote spenWNote) {
        saveCacheToFile(spenWNote);
        this.mPageList.clear();
        notifyDataSetChanged(3, 0, 0);
    }

    public float getDefaultThumbnailWidth() {
        return this.mDefaultThumbnailWidth;
    }

    public DocPageInfo getDocPageInfo() {
        return this.mDocPageInfo;
    }

    public int getPageCount() {
        List<PageInfo> list = this.mPageList;
        if (list == null) {
            return -1;
        }
        return list.size();
    }

    public int getPageCountExcludedDummy() {
        if (this.mPageList == null) {
            return -1;
        }
        return r0.size() - 1;
    }

    public PageInfo getPageInfo(int i) {
        PageInfo pageInfo;
        synchronized (this.mLock) {
            pageInfo = this.mPageList.get(i);
        }
        return pageInfo;
    }

    public List<PageInfo> getPageList() {
        return this.mPageList;
    }

    public float getThumbnailRatio() {
        return this.mThumbnailRatio;
    }

    public int indexOf(String str) {
        if (str == null) {
            return -1;
        }
        int size = this.mPageList.size();
        for (int i = 0; i < size; i++) {
            if (str.equals(this.mPageList.get(i).getPageId())) {
                return i;
            }
        }
        return -1;
    }

    public void init(int i, SpenWNote.PageMode pageMode) {
        init(i, pageMode, false);
    }

    public void initPageInfoList(SpenWNote spenWNote) {
        boolean z;
        String strValueOf = String.valueOf(hashCode());
        String str = TAG;
        Logger.startTime(strValueOf, str, "initPageInfoList# start");
        synchronized (this.mLock) {
            try {
                int size = this.mPageList.size();
                if (size == spenWNote.getPageCount()) {
                    Logger.endTime(String.valueOf(hashCode()), str, "initPageInfoList# return");
                    return;
                }
                if (size > 0) {
                    this.mPageList.clear();
                    z = true;
                } else {
                    z = false;
                }
                ArrayList<SpenWPage> pageList = spenWNote.getPageList();
                int size2 = pageList.size();
                if (z) {
                    Logger.m11002f(str, "initPageInfoList# in: " + size + " note: " + size2);
                }
                for (int i = 0; i < size2 && !this.mIsDestroyed.get(); i++) {
                    this.mPageList.add(createPageInfo(i, pageList.get(i)));
                }
                Logger.endTime(String.valueOf(hashCode()), TAG, "initPageInfoList# end");
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void insert(PageInfo pageInfo, int i, PageUpdateState pageUpdateState) {
        ArrayList arrayList = new ArrayList(1);
        arrayList.add(pageInfo);
        ArrayList arrayList2 = new ArrayList(1);
        arrayList2.add(Integer.valueOf(i));
        insert(arrayList, arrayList2, pageUpdateState);
    }

    public boolean isDestroyed() {
        return this.mIsDestroyed.get();
    }

    public boolean isSkipToSaveCache() {
        return this.mSkipToSaveCache;
    }

    public void move(int i, int i2) {
        AbstractC8014b.m7216r(i, i2, "move# ", " -> ", TAG);
        synchronized (this.mLock) {
            try {
                if (i < i2) {
                    PageInfo pageInfoRemove = this.mPageList.remove(i);
                    if (i2 == this.mPageList.size()) {
                        this.mPageList.add(pageInfoRemove);
                    } else {
                        this.mPageList.add(i2, pageInfoRemove);
                    }
                } else {
                    this.mPageList.add(i2, this.mPageList.remove(i));
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        notifyDataSetChanged(2, i, i2);
    }

    public void notifyDataRemoved(List<Integer> list, @NonNull PageUpdateState pageUpdateState) {
        Logger.m10999d(TAG, "notifyDataRemoved# ");
        Iterator<OnPageUpdateListener> it = this.mListeners.iterator();
        while (it.hasNext()) {
            it.next().onDeletedPages(list, pageUpdateState);
        }
    }

    public void notifyDataSetChanged(int i, int i2, int i4) {
        notifyDataSetChanged(i, i2, i4, new PageUpdateState());
    }

    public void remove(List<String> list, PageUpdateState pageUpdateState) {
        ArrayList arrayList = new ArrayList(list.size());
        synchronized (this.mLock) {
            try {
                ArrayList arrayList2 = new ArrayList(1);
                for (String str : list) {
                    int i = 0;
                    while (true) {
                        if (i >= this.mPageList.size()) {
                            break;
                        }
                        if (this.mPageList.get(i).getPageId().equals(str)) {
                            arrayList.add(Integer.valueOf(i));
                            break;
                        }
                        i++;
                    }
                    if (i < this.mPageList.size()) {
                        this.mPageList.remove(i);
                    } else {
                        arrayList2.add(str);
                    }
                }
                if (!arrayList2.isEmpty()) {
                    Logger.m10999d(TAG, "remove# not found : " + arrayList2);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (arrayList.isEmpty()) {
            Logger.m11000e(TAG, "remove# None ");
        } else {
            notifyDataRemoved(arrayList, pageUpdateState);
        }
    }

    public void saveCacheToFile(SpenWNote spenWNote) {
        FileOutputStream fileOutputStream;
        ObjectOutputStream objectOutputStream;
        String str = TAG;
        Logger.m11003i(str, "saveCache#");
        if (this.mSkipToSaveCache) {
            Logger.m11003i(str, "saveCache# skip");
            return;
        }
        File parentFile = new File(this.mCacheDirPath).getParentFile();
        if (parentFile == null) {
            Logger.m11000e(str, "saveCache# cannot get the cacheDir");
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(parentFile.getAbsolutePath());
        File file = new File(AbstractC0622a.m1170p(File.separator, ComposerCacheFileUtil.PAGE_CACHE_INFO_DAT, sb));
        if (!file.exists()) {
            try {
                if (!file.createNewFile()) {
                    return;
                }
            } catch (IOException e) {
                Logger.m11001e(TAG, e.getMessage(), e);
                return;
            }
        }
        this.mDocPageInfo.setTotalPageCount(spenWNote.getPageCount());
        try {
            fileOutputStream = new FileOutputStream(file);
            try {
                objectOutputStream = new ObjectOutputStream(fileOutputStream);
            } finally {
            }
        } catch (IOException e2) {
            Logger.m11001e(TAG, e2.getMessage(), e2);
        }
        try {
            objectOutputStream.writeObject(this.mDocPageInfo.copy());
            objectOutputStream.close();
            fileOutputStream.close();
            Logger.m11003i(TAG, "saveCache# " + this.mDocPageInfo.toString());
        } finally {
        }
    }

    public void setBlockNotiToInsert(boolean z) {
        AbstractC8014b.m7224z("setBlockNotiToInsert# ", TAG, z);
        this.mBlockingNotiToInsert = z;
    }

    public void setBlockToInsert(boolean z) {
        AbstractC8014b.m7224z("setBlockToInsert# ", TAG, z);
        this.mBlockingInsert = z;
    }

    public void setCacheDirPath(String str, String str2) {
        this.mCacheDirPath = str;
        this.mThumbnailCacheDirPath = str2;
    }

    public void setDestroyFlag() {
        this.mIsDestroyed.set(true);
    }

    public void setSkipToSaveCache(boolean z) {
        this.mSkipToSaveCache = z;
    }

    public void setThumbnail(NoteCaptureControl noteCaptureControl, SpenWNote spenWNote, SpenWPage spenWPage, SpenObjectTextBox spenObjectTextBox, int i, boolean z) throws Exception {
        long jCurrentTimeMillis = System.currentTimeMillis();
        String str = TAG;
        Logger.m10999d(str, "setThumbnail# start " + i);
        if (isDestroyed()) {
            AbstractC0000a.m3D(i, "setThumbnail# destroyed ", str);
            return;
        }
        Logger.m10999d(str, "setThumbnail# getInfo " + i);
        PageInfo pageInfo = getPageInfo(i);
        AbstractC0000a.m3D(i, "setThumbnail# getInfo end ", str);
        String strSaveThumbnail = saveThumbnail(noteCaptureControl, spenWNote, spenWPage, spenObjectTextBox, i, this.mThumbnailRatio);
        if (strSaveThumbnail != null) {
            pageInfo.setThumbnailFilePath(strSaveThumbnail);
            pageInfo.setPageModifiedTime(spenWPage.getModifiedTime());
            pageInfo.setDirty(false);
            if (z) {
                notifyDataSetChanged(1, i, i);
            }
        }
        StringBuilder sbM778t = AbstractC0541b.m778t(i, "setThumbnail# end ", " ");
        sbM778t.append(System.currentTimeMillis() - jCurrentTimeMillis);
        Logger.m10999d(str, sbM778t.toString());
    }

    public void updatePageInfo(SpenWNote.Orientation orientation) {
        if (orientation == SpenWNote.Orientation.LANDSCAPE_NEW && this.mDocPageInfo.getPageLayoutColumn() == 2) {
            this.mDocPageInfo.setPageLayoutColumn(1);
            Logger.m11003i(TAG, "updatePageInfo# column 1");
        }
    }

    public void updateThumbnailRatio(int i, float f) {
        this.mDefaultThumbnailWidth = f;
        this.mThumbnailRatio = f / i;
    }

    public void init(int i, SpenWNote.PageMode pageMode, boolean z) {
        if (!z || !loadCache()) {
            this.mDocPageInfo = new DocPageInfo(i, this.mDocPageInfo);
        }
        this.mPageMode = pageMode;
        if (pageMode == SpenWNote.PageMode.SINGLE) {
            this.mDocPageInfo.loadPageLayoutDefaultForSingle();
        }
        this.mPageList = new ArrayList(i);
    }

    public void notifyDataSetChanged(int i, int i2, int i4, @NonNull PageUpdateState pageUpdateState) {
        AbstractC8014b.m7221w(AbstractC0622a.m1173s(i, i2, "notifyDataSetChanged# ", " ", " - "), TAG, i4);
        Iterator<OnPageUpdateListener> it = this.mListeners.iterator();
        while (it.hasNext()) {
            it.next().onUpdatePage(i, i2, i4, pageUpdateState);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class PageUpdateState {
        List<String> pageIdList;
        boolean thread;

        public PageUpdateState() {
            this.pageIdList = new ArrayList();
            this.thread = false;
        }

        @NonNull
        public List<String> getPageIdList() {
            return this.pageIdList;
        }

        public boolean isThread() {
            return this.thread;
        }

        public PageUpdateState(boolean z) {
            this.pageIdList = new ArrayList();
            this.thread = z;
        }

        public PageUpdateState(boolean z, String str) {
            this(z);
            this.pageIdList.add(str);
        }

        public PageUpdateState(boolean z, List<String> list) {
            this(z);
            this.pageIdList.addAll(list);
        }
    }

    public PageInfo getPageInfo(String str) {
        synchronized (this.mLock) {
            try {
                for (PageInfo pageInfo : this.mPageList) {
                    if (str.equals(pageInfo.getPageId())) {
                        return pageInfo;
                    }
                }
                return null;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void insert(List<PageInfo> list, List<Integer> list2, PageUpdateState pageUpdateState) {
        if (this.mBlockingInsert) {
            Logger.m11003i(TAG, "insert# blocking");
            return;
        }
        Logger.m10999d(TAG, "insert# " + list2 + " current: " + this.mPageList.size() + " new: " + list.size());
        synchronized (this.mLock) {
            for (int i = 0; i < list.size(); i++) {
                try {
                    int iIntValue = list2.get(i).intValue();
                    PageInfo pageInfo = list.get(i);
                    pageInfo.setThumbnailRatio(this.mThumbnailRatio);
                    if (iIntValue >= this.mPageList.size()) {
                        this.mPageList.add(pageInfo);
                    } else {
                        this.mPageList.add(iIntValue, pageInfo);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        if (this.mBlockingNotiToInsert) {
            return;
        }
        notifyDataInserted(pageUpdateState);
    }
}
