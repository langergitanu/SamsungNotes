package org.apache.poi.java.awt;

/* JADX INFO: loaded from: classes10.dex */
abstract class MediaEntry {
    static final int ABORTED = 2;
    static final int COMPLETE = 8;
    static final int DONE = 14;
    static final int ERRORED = 4;
    static final int LOADING = 1;
    static final int LOADSTARTED = 13;

    /* JADX INFO: renamed from: ID */
    int f10056ID;
    boolean cancelled;
    MediaEntry next;
    int status;
    MediaTracker tracker;

    public MediaEntry(MediaTracker mediaTracker, int i) {
        this.tracker = mediaTracker;
        this.f10056ID = i;
    }

    public static MediaEntry insert(MediaEntry mediaEntry, MediaEntry mediaEntry2) {
        MediaEntry mediaEntry3 = null;
        MediaEntry mediaEntry4 = mediaEntry;
        while (mediaEntry4 != null && mediaEntry4.f10056ID <= mediaEntry2.f10056ID) {
            mediaEntry3 = mediaEntry4;
            mediaEntry4 = mediaEntry4.next;
        }
        mediaEntry2.next = mediaEntry4;
        if (mediaEntry3 == null) {
            return mediaEntry2;
        }
        mediaEntry3.next = mediaEntry2;
        return mediaEntry;
    }

    public void cancel() {
        this.cancelled = true;
    }

    public int getID() {
        return this.f10056ID;
    }

    public abstract Object getMedia();

    public synchronized int getStatus(boolean z, boolean z2) {
        if (z) {
            try {
                int i = this.status;
                if ((i & 13) == 0) {
                    this.status = (i & (-3)) | 1;
                    startLoad();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return this.status;
    }

    public void setStatus(int i) {
        synchronized (this) {
            this.status = i;
        }
        this.tracker.setDone();
    }

    public abstract void startLoad();
}
