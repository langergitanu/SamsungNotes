package com.samsung.android.sdk.handwriting.resources;

import android.util.Log;
import androidx.appcompat.widget.AbstractC0541b;
import com.samsung.android.sdk.handwriting.HwrLanguageID;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
class HwrDownloadManager {
    private static final String TAG = "HwrDownloadManager";
    private Queue<String> mDownloadQ = new LinkedList();
    private ConcurrentHashMap<String, HwrLanguagePack> mLanguagePackMap;

    public HwrDownloadManager(ConcurrentHashMap<String, HwrLanguagePack> concurrentHashMap) {
        this.mLanguagePackMap = concurrentHashMap;
    }

    private void download(String str) {
        HwrLanguagePack hwrLanguagePack;
        ConcurrentHashMap<String, HwrLanguagePack> concurrentHashMap = this.mLanguagePackMap;
        if (concurrentHashMap == null || (hwrLanguagePack = concurrentHashMap.get(str)) == null) {
            return;
        }
        hwrLanguagePack.download();
    }

    private void removeFromQueue(String str, String str2) {
        if (this.mDownloadQ.contains(str)) {
            this.mDownloadQ.remove(str);
            Log.i(TAG, str2 + " Download: LanguageID  = " + HwrLanguageID.getID(str) + " is removed!");
        } else {
            StringBuilder sbM781w = AbstractC0541b.m781w(str2, " Download: LanguageID  = ");
            sbM781w.append(HwrLanguageID.getID(str));
            sbM781w.append(" is not contained download Q!");
            Log.i(TAG, sbM781w.toString());
        }
        StringBuilder sbM781w2 = AbstractC0541b.m781w(str2, " Download: LanguageID  = ");
        sbM781w2.append(HwrLanguageID.getID(str));
        sbM781w2.append(", Queue size = ");
        sbM781w2.append(this.mDownloadQ.size());
        Log.i(TAG, sbM781w2.toString());
        Log.i(TAG, str2 + " Download: Remaining Q = " + HwrLanguageID.getIDs(new ArrayList(this.mDownloadQ)));
    }

    public void cancelDownload(String str) {
        removeFromQueue(str, "Cancel");
    }

    public void close() {
        Queue<String> queue = this.mDownloadQ;
        if (queue != null) {
            queue.clear();
            this.mDownloadQ = null;
        }
        if (this.mLanguagePackMap != null) {
            this.mLanguagePackMap = null;
        }
    }

    public void finishDownload(String str) {
        removeFromQueue(str, "Finish");
        if (this.mDownloadQ.size() >= 1) {
            String strPeek = this.mDownloadQ.peek();
            Log.i(TAG, "Download language: " + HwrLanguageID.getID(strPeek));
            download(strPeek);
        }
    }

    public boolean isContainedInDownloadQ(String str) {
        Queue<String> queue = this.mDownloadQ;
        if (queue == null || queue.size() <= 0) {
            return false;
        }
        return this.mDownloadQ.contains(str);
    }

    public void requestDownload(String str) {
        this.mDownloadQ.add(str);
        Log.i(TAG, "Request Download: LanguageID  = " + HwrLanguageID.getID(str) + ", Queue size = " + this.mDownloadQ.size());
        StringBuilder sb = new StringBuilder("Request Download: Remaining Q = ");
        sb.append(HwrLanguageID.getIDs(new ArrayList(this.mDownloadQ)));
        Log.i(TAG, sb.toString());
        if (this.mDownloadQ.size() == 1) {
            Log.i(TAG, "Download language: " + HwrLanguageID.getID(str));
            download(str);
        }
    }
}
