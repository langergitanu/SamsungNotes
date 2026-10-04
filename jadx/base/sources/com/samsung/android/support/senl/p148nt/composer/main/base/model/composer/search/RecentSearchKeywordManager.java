package com.samsung.android.support.senl.p148nt.composer.main.base.model.composer.search;

import androidx.collection.AbstractC0622a;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.ComposerCacheFileUtil;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class RecentSearchKeywordManager {
    private static final String TAG = Logger.createTag("RecentSearchKeywordManager");
    private String mCacheDirPath;
    private RecentSearchKeywords mRecentSearchKeywords;

    public RecentSearchKeywords getRecentSearchKeywords() {
        if (this.mRecentSearchKeywords == null && !load()) {
            this.mRecentSearchKeywords = new RecentSearchKeywords();
        }
        return this.mRecentSearchKeywords;
    }

    public boolean load() {
        Logger.m10999d(TAG, "load# start");
        long jCurrentTimeMillis = System.currentTimeMillis();
        File file = new File(this.mCacheDirPath);
        if (!file.exists()) {
            return false;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(file.getAbsolutePath());
        File file2 = new File(AbstractC0622a.m1170p(File.separator, ComposerCacheFileUtil.RECENT_SEARCH_KEYWORD_DAT, sb));
        if (!file2.exists()) {
            return false;
        }
        try {
            FileInputStream fileInputStream = new FileInputStream(file2);
            try {
                ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
                try {
                    RecentSearchKeywords recentSearchKeywords = (RecentSearchKeywords) objectInputStream.readObject();
                    this.mRecentSearchKeywords = recentSearchKeywords;
                    z = recentSearchKeywords != null;
                    objectInputStream.close();
                    fileInputStream.close();
                } finally {
                }
            } catch (Throwable th) {
                try {
                    fileInputStream.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
                throw th;
            }
        } catch (IOException | ClassNotFoundException e) {
            Logger.m11001e(TAG, e.getMessage(), e);
        }
        Logger.m10999d(TAG, "loadCache# end " + (System.currentTimeMillis() - jCurrentTimeMillis));
        return z;
    }

    public void save() {
        String str = TAG;
        Logger.m11003i(str, "save#");
        if (this.mRecentSearchKeywords == null) {
            return;
        }
        File file = new File(this.mCacheDirPath);
        if (!file.exists()) {
            Logger.m11000e(str, "save# cannot get the cacheDir");
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(file.getAbsolutePath());
        File file2 = new File(AbstractC0622a.m1170p(File.separator, ComposerCacheFileUtil.RECENT_SEARCH_KEYWORD_DAT, sb));
        if (!file2.exists()) {
            try {
                if (!file2.createNewFile()) {
                    return;
                }
            } catch (IOException e) {
                Logger.m11001e(TAG, e.getMessage(), e);
                return;
            }
        } else if (this.mRecentSearchKeywords.isEmpty()) {
            if (file2.delete()) {
                return;
            }
            Logger.m11000e(str, "save# dataFile delete error");
            return;
        }
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file2);
            try {
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
                try {
                    objectOutputStream.writeObject(this.mRecentSearchKeywords);
                    objectOutputStream.close();
                    fileOutputStream.close();
                } finally {
                }
            } finally {
            }
        } catch (IOException e2) {
            Logger.m11001e(TAG, e2.getMessage(), e2);
        }
    }

    public void setCacheDirPath(String str) {
        this.mCacheDirPath = str;
    }
}
