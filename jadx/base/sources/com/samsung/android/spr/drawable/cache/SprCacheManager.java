package com.samsung.android.spr.drawable.cache;

import android.graphics.Bitmap;
import android.util.Log;
import com.samsung.android.spr.drawable.document.debug.SprDebug;
import com.samsung.android.support.senl.p148nt.data.database.core.query.sqlbuilder.SQLKeyword;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class SprCacheManager {
    private ArrayList<SprCache> mCacheList = new ArrayList<>();
    private String mHashCode;
    private String mName;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class SprCache {
        public final Bitmap bitmap;
        public final int dpi;
        public final int height;
        public int refCount;
        public final int width;

        public SprCache(Bitmap bitmap, int i) {
            this.refCount = 0;
            this.bitmap = bitmap;
            this.width = bitmap.getWidth();
            this.height = bitmap.getHeight();
            this.dpi = i;
            this.refCount = 0;
        }

        public synchronized void lock() {
            this.refCount++;
        }

        public synchronized void unlock() {
            this.refCount--;
        }
    }

    public SprCacheManager(String str, int i) {
        this.mHashCode = null;
        this.mName = str;
        this.mHashCode = String.valueOf(i % 10000);
    }

    public void addCache(Bitmap bitmap, int i) {
        if (bitmap == null) {
            return;
        }
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        synchronized (this.mCacheList) {
            try {
                Iterator<SprCache> it = this.mCacheList.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        this.mCacheList.add(new SprCache(bitmap, i));
                        break;
                    }
                    SprCache next = it.next();
                    if (next.width != width || next.height != height || next.dpi != i) {
                    }
                }
            } finally {
            }
        }
    }

    public Bitmap getCache(int i, int i2, int i4) {
        Bitmap bitmap;
        synchronized (this.mCacheList) {
            try {
                Iterator<SprCache> it = this.mCacheList.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        bitmap = null;
                        break;
                    }
                    SprCache next = it.next();
                    if (next.width == i && next.height == i2 && next.dpi == i4) {
                        bitmap = next.bitmap;
                        break;
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return bitmap;
    }

    public void lock(Bitmap bitmap) {
        if (bitmap == null) {
            return;
        }
        synchronized (this.mCacheList) {
            try {
                Iterator<SprCache> it = this.mCacheList.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    SprCache next = it.next();
                    if (next.bitmap == bitmap) {
                        next.lock();
                        break;
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (SprDebug.IsDebug) {
            Log.d("SprDrawable", "-lock--------------------------");
            printDebug();
        }
    }

    public void printDebug() {
        synchronized (this.mCacheList) {
            try {
                Log.d("SprDrawable", this.mName + "(" + this.mHashCode + ") printDebug start");
                for (SprCache sprCache : this.mCacheList) {
                    Log.d("SprDrawable", this.mName + "(" + this.mHashCode + ")Cache (" + sprCache.width + SQLKeyword.COMMA + sprCache.height + "[" + sprCache.dpi + "]) " + sprCache.refCount);
                }
                Log.d("SprDrawable", this.mName + "(" + this.mHashCode + ") printDebug end");
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void unlock(Bitmap bitmap) {
        if (bitmap == null) {
            return;
        }
        synchronized (this.mCacheList) {
            try {
                Iterator<SprCache> it = this.mCacheList.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    SprCache next = it.next();
                    if (next.bitmap == bitmap) {
                        next.unlock();
                        if (next.refCount == 0) {
                            this.mCacheList.remove(next);
                        }
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (SprDebug.IsDebug) {
            Log.d("SprDrawable", "-unlock------------------------");
            printDebug();
        }
    }
}
