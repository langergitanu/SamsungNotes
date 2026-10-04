package org.apache.poi.sun.java2d;

import java.lang.ref.PhantomReference;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.security.AccessController;
import java.util.ArrayList;
import java.util.Hashtable;
import org.apache.poi.sun.security.action.GetPropertyAction;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class Disposer implements Runnable {
    public static final int PHANTOM = 1;
    public static final int WEAK = 0;
    private static ArrayList<DisposerRecord> deferredRecords;
    private static Disposer disposerInstance;
    public static volatile boolean pollingQueue;
    private static final ReferenceQueue queue = new ReferenceQueue();
    private static final Hashtable records = new Hashtable();
    public static int refType;

    static {
        refType = 1;
        String str = (String) AccessController.doPrivileged(new GetPropertyAction("org.apache.poi.sun.java2d.reftype"));
        if (str != null) {
            if (str.equals("weak")) {
                refType = 0;
                System.err.println("Using WEAK refs");
            } else {
                refType = 1;
                System.err.println("Using PHANTOM refs");
            }
        }
        disposerInstance = new Disposer();
        deferredRecords = null;
        pollingQueue = false;
    }

    public static void addObjectRecord(Object obj, DisposerRecord disposerRecord) {
        records.put(new WeakReference(obj, queue), disposerRecord);
    }

    public static void addRecord(Object obj, long j, long j2) {
        disposerInstance.add(obj, new DefaultDisposerRecord(j, j2));
    }

    public static void addReference(Reference reference, DisposerRecord disposerRecord) {
        records.put(reference, disposerRecord);
    }

    private static void clearDeferredRecords() {
        ArrayList<DisposerRecord> arrayList = deferredRecords;
        if (arrayList == null || arrayList.isEmpty()) {
            return;
        }
        for (int i = 0; i < deferredRecords.size(); i++) {
            try {
                deferredRecords.get(i).dispose();
            } catch (Exception unused) {
                System.out.println("Exception while disposing deferred rec.");
            }
        }
        deferredRecords.clear();
    }

    public static ReferenceQueue getQueue() {
        return queue;
    }

    public static void pollRemove() {
        if (pollingQueue) {
            return;
        }
        pollingQueue = true;
        int i = 0;
        int i2 = 0;
        while (true) {
            try {
                try {
                    Reference referencePoll = queue.poll();
                    if (referencePoll == null || i >= 10000 || i2 >= 100) {
                        break;
                    }
                    i++;
                    referencePoll.clear();
                    DisposerRecord disposerRecord = (DisposerRecord) records.remove(referencePoll);
                    if (disposerRecord instanceof PollDisposable) {
                        disposerRecord.dispose();
                    } else if (disposerRecord != null) {
                        i2++;
                        if (deferredRecords == null) {
                            deferredRecords = new ArrayList<>(5);
                        }
                        deferredRecords.add(disposerRecord);
                    }
                } catch (Exception unused) {
                    System.out.println("Exception while removing reference.");
                    pollingQueue = false;
                    return;
                }
            } catch (Throwable th) {
                pollingQueue = false;
                throw th;
            }
        }
        pollingQueue = false;
    }

    public synchronized void add(Object obj, DisposerRecord disposerRecord) {
        try {
            if (obj instanceof DisposerTarget) {
                obj = ((DisposerTarget) obj).getDisposerReferent();
            }
            records.put(refType == 1 ? new PhantomReference(obj, queue) : new WeakReference(obj, queue), disposerRecord);
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        while (true) {
            try {
                Reference referenceRemove = queue.remove();
                referenceRemove.clear();
                ((DisposerRecord) records.remove(referenceRemove)).dispose();
                clearDeferredRecords();
            } catch (Exception unused) {
                System.out.println("Exception while removing reference.");
            }
        }
    }

    public static void addRecord(Object obj, DisposerRecord disposerRecord) {
        disposerInstance.add(obj, disposerRecord);
    }
}
