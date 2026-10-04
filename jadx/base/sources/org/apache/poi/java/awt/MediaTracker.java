package org.apache.poi.java.awt;

import java.io.Serializable;

/* JADX INFO: loaded from: classes10.dex */
public class MediaTracker implements Serializable {
    public static final int ABORTED = 2;
    public static final int COMPLETE = 8;
    static final int DONE = 14;
    public static final int ERRORED = 4;
    public static final int LOADING = 1;
    private static final long serialVersionUID = -483174189758638095L;
    MediaEntry head;
    Component target;

    public MediaTracker(Component component) {
        this.target = component;
    }

    public void addImage(Image image, int i) throws Throwable {
        addImage(image, i, -1, -1);
    }

    public boolean checkAll() {
        return checkAll(false, true);
    }

    public boolean checkID(int i) {
        return checkID(i, false, true);
    }

    public synchronized Object[] getErrorsAny() {
        int i = 0;
        for (MediaEntry mediaEntry = this.head; mediaEntry != null; mediaEntry = mediaEntry.next) {
            if ((mediaEntry.getStatus(false, true) & 4) != 0) {
                i++;
            }
        }
        if (i == 0) {
            return null;
        }
        Object[] objArr = new Object[i];
        int i2 = 0;
        for (MediaEntry mediaEntry2 = this.head; mediaEntry2 != null; mediaEntry2 = mediaEntry2.next) {
            if ((mediaEntry2.getStatus(false, false) & 4) != 0) {
                objArr[i2] = mediaEntry2.getMedia();
                i2++;
            }
        }
        return objArr;
    }

    public synchronized Object[] getErrorsID(int i) {
        try {
            int i2 = 0;
            for (MediaEntry mediaEntry = this.head; mediaEntry != null; mediaEntry = mediaEntry.next) {
                if (mediaEntry.getID() == i && (mediaEntry.getStatus(false, true) & 4) != 0) {
                    i2++;
                }
            }
            if (i2 == 0) {
                return null;
            }
            Object[] objArr = new Object[i2];
            int i4 = 0;
            for (MediaEntry mediaEntry2 = this.head; mediaEntry2 != null; mediaEntry2 = mediaEntry2.next) {
                if (mediaEntry2.getID() == i && (mediaEntry2.getStatus(false, false) & 4) != 0) {
                    objArr[i4] = mediaEntry2.getMedia();
                    i4++;
                }
            }
            return objArr;
        } catch (Throwable th) {
            throw th;
        }
    }

    public synchronized boolean isErrorAny() {
        for (MediaEntry mediaEntry = this.head; mediaEntry != null; mediaEntry = mediaEntry.next) {
            if ((mediaEntry.getStatus(false, true) & 4) != 0) {
                return true;
            }
        }
        return false;
    }

    public synchronized boolean isErrorID(int i) {
        for (MediaEntry mediaEntry = this.head; mediaEntry != null; mediaEntry = mediaEntry.next) {
            if (mediaEntry.getID() == i && (mediaEntry.getStatus(false, true) & 4) != 0) {
                return true;
            }
        }
        return false;
    }

    public synchronized void removeImage(Image image) {
        try {
            MediaEntry mediaEntry = this.head;
            MediaEntry mediaEntry2 = null;
            while (mediaEntry != null) {
                MediaEntry mediaEntry3 = mediaEntry.next;
                if (mediaEntry.getMedia() == image) {
                    if (mediaEntry2 == null) {
                        this.head = mediaEntry3;
                    } else {
                        mediaEntry2.next = mediaEntry3;
                    }
                    mediaEntry.cancel();
                } else {
                    mediaEntry2 = mediaEntry;
                }
                mediaEntry = mediaEntry3;
            }
            notifyAll();
        } catch (Throwable th) {
            throw th;
        }
    }

    public synchronized void setDone() {
        notifyAll();
    }

    public int statusAll(boolean z) {
        return statusAll(z, true);
    }

    public int statusID(int i, boolean z) {
        return statusID(i, z, true);
    }

    public void waitForAll() {
        waitForAll(0L);
    }

    public void waitForID(int i) {
        waitForID(i, 0L);
    }

    private synchronized int statusAll(boolean z, boolean z2) {
        int status;
        status = 0;
        for (MediaEntry mediaEntry = this.head; mediaEntry != null; mediaEntry = mediaEntry.next) {
            status |= mediaEntry.getStatus(z, z2);
        }
        return status;
    }

    private synchronized int statusID(int i, boolean z, boolean z2) {
        int status;
        try {
            status = 0;
            for (MediaEntry mediaEntry = this.head; mediaEntry != null; mediaEntry = mediaEntry.next) {
                if (mediaEntry.getID() == i) {
                    status |= mediaEntry.getStatus(z, z2);
                }
            }
        } catch (Throwable th) {
            throw th;
        }
        return status;
    }

    public synchronized void addImage(Image image, int i, int i2, int i4) throws Throwable {
        try {
            try {
                this.head = MediaEntry.insert(this.head, new ImageMediaEntry(this, image, i, i2, i4));
            } catch (Throwable th) {
                th = th;
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            throw th;
        }
    }

    public boolean checkAll(boolean z) {
        return checkAll(z, true);
    }

    public boolean checkID(int i, boolean z) {
        return checkID(i, z, true);
    }

    public synchronized void removeImage(Image image, int i) {
        try {
            MediaEntry mediaEntry = this.head;
            MediaEntry mediaEntry2 = null;
            while (mediaEntry != null) {
                MediaEntry mediaEntry3 = mediaEntry.next;
                if (mediaEntry.getID() == i && mediaEntry.getMedia() == image) {
                    if (mediaEntry2 == null) {
                        this.head = mediaEntry3;
                    } else {
                        mediaEntry2.next = mediaEntry3;
                    }
                    mediaEntry.cancel();
                } else {
                    mediaEntry2 = mediaEntry;
                }
                mediaEntry = mediaEntry3;
            }
            notifyAll();
        } catch (Throwable th) {
            throw th;
        }
    }

    public synchronized boolean waitForAll(long j) {
        long jCurrentTimeMillis = System.currentTimeMillis() + j;
        boolean z = true;
        while (true) {
            int iStatusAll = statusAll(z, z);
            if ((iStatusAll & 1) == 0) {
                return iStatusAll == 8;
            }
            long j2 = 0;
            if (j != 0) {
                long jCurrentTimeMillis2 = jCurrentTimeMillis - System.currentTimeMillis();
                if (jCurrentTimeMillis2 <= 0) {
                    return false;
                }
                j2 = jCurrentTimeMillis2;
            }
            wait(j2);
            z = false;
        }
    }

    public synchronized boolean waitForID(int i, long j) {
        long jCurrentTimeMillis = System.currentTimeMillis() + j;
        boolean z = true;
        while (true) {
            int iStatusID = statusID(i, z, z);
            if ((iStatusID & 1) == 0) {
                return iStatusID == 8;
            }
            long j2 = 0;
            if (j != 0) {
                long jCurrentTimeMillis2 = jCurrentTimeMillis - System.currentTimeMillis();
                if (jCurrentTimeMillis2 <= 0) {
                    return false;
                }
                j2 = jCurrentTimeMillis2;
            }
            wait(j2);
            z = false;
        }
    }

    private synchronized boolean checkAll(boolean z, boolean z2) {
        boolean z3;
        z3 = true;
        for (MediaEntry mediaEntry = this.head; mediaEntry != null; mediaEntry = mediaEntry.next) {
            if ((mediaEntry.getStatus(z, z2) & 14) == 0) {
                z3 = false;
            }
        }
        return z3;
    }

    private synchronized boolean checkID(int i, boolean z, boolean z2) {
        boolean z3;
        try {
            z3 = true;
            for (MediaEntry mediaEntry = this.head; mediaEntry != null; mediaEntry = mediaEntry.next) {
                if (mediaEntry.getID() == i && (mediaEntry.getStatus(z, z2) & 14) == 0) {
                    z3 = false;
                }
            }
        } catch (Throwable th) {
            throw th;
        }
        return z3;
    }

    public synchronized void removeImage(Image image, int i, int i2, int i4) {
        try {
            MediaEntry mediaEntry = this.head;
            MediaEntry mediaEntry2 = null;
            while (mediaEntry != null) {
                MediaEntry mediaEntry3 = mediaEntry.next;
                if (mediaEntry.getID() == i && (mediaEntry instanceof ImageMediaEntry) && ((ImageMediaEntry) mediaEntry).matches(image, i2, i4)) {
                    if (mediaEntry2 == null) {
                        this.head = mediaEntry3;
                    } else {
                        mediaEntry2.next = mediaEntry3;
                    }
                    mediaEntry.cancel();
                } else {
                    mediaEntry2 = mediaEntry;
                }
                mediaEntry = mediaEntry3;
            }
            notifyAll();
        } catch (Throwable th) {
            throw th;
        }
    }
}
