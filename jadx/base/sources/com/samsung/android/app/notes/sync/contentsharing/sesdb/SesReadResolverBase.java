package com.samsung.android.app.notes.sync.contentsharing.sesdb;

import android.content.ContentResolver;
import android.content.Context;
import android.database.ContentObserver;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import com.samsung.android.support.senl.p148nt.base.common.log.Debugger;
import java.util.ArrayList;
import java.util.Iterator;
import p086V.C0322h;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public class SesReadResolverBase extends ContentObserver {
    private static final String TAG = "SesReadResolverBase";
    protected static ArrayList<InterfaceC6699m> mSesDbObservers = new ArrayList<>();
    protected boolean isRegisteredInSesDb;
    protected ContentResolver mContentResolver;
    protected Uri mContentUri;
    protected Context mContext;

    public SesReadResolverBase() {
        super(new Handler(Looper.getMainLooper()));
        this.isRegisteredInSesDb = false;
        Context appContext = C0322h.m670a().f815a.getAppContext();
        this.mContext = appContext;
        this.mContentResolver = appContext.getContentResolver();
    }

    public void addContentObserver(InterfaceC6699m interfaceC6699m) {
        if (interfaceC6699m == null) {
            Debugger.m8615i(TAG, "addContentObserver : observer is null");
            return;
        }
        synchronized (mSesDbObservers) {
            try {
                Iterator<InterfaceC6699m> it = mSesDbObservers.iterator();
                while (it.hasNext()) {
                    if (it.next().equals(interfaceC6699m)) {
                        return;
                    }
                }
                mSesDbObservers.add(interfaceC6699m);
                Debugger.m8607d(TAG, "Added Ses DB observer - size : " + mSesDbObservers.size());
                if (!this.isRegisteredInSesDb) {
                    try {
                        this.mContentResolver.registerContentObserver(this.mContentUri, false, this);
                        this.isRegisteredInSesDb = true;
                    } catch (Exception e) {
                        Debugger.m8609e(TAG, "addContentObserver() : " + e.toString());
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // android.database.ContentObserver
    public void onChange(boolean z) {
        synchronized (mSesDbObservers) {
            try {
                if (!mSesDbObservers.isEmpty()) {
                    Iterator<InterfaceC6699m> it = mSesDbObservers.iterator();
                    while (it.hasNext()) {
                        it.next().onChange(z);
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x005c A[Catch: all -> 0x0044, DONT_GENERATE, TryCatch #0 {, blocks: (B:8:0x0013, B:10:0x0037, B:12:0x003b, B:18:0x005c, B:17:0x0047), top: B:22:0x0013, inners: #1 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void removeContentObserver(InterfaceC6699m interfaceC6699m) {
        if (interfaceC6699m == null) {
            Debugger.m8615i(TAG, "removeContentObserver : observer is null");
            return;
        }
        synchronized (mSesDbObservers) {
            mSesDbObservers.remove(interfaceC6699m);
            Debugger.m8607d(TAG, "Removed Ses DB observer - size : " + mSesDbObservers.size());
            if (mSesDbObservers.isEmpty()) {
                try {
                } catch (Exception e) {
                    Debugger.m8609e(TAG, "removeContentObserver() : " + e.toString());
                }
                if (this.isRegisteredInSesDb) {
                    this.mContentResolver.unregisterContentObserver(this);
                    this.isRegisteredInSesDb = false;
                }
            }
        }
    }
}
