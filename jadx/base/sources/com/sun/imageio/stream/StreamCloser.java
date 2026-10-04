package com.sun.imageio.stream;

import java.io.IOException;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.Set;
import java.util.WeakHashMap;
import org.apache.poi.javax.imageio.stream.ImageInputStream;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class StreamCloser {
    private static Thread streamCloser;
    private static WeakHashMap<CloseAction, Object> toCloseQueue;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class CloseAction {
        private ImageInputStream iis;

        public void performAction() {
            ImageInputStream imageInputStream = this.iis;
            if (imageInputStream != null) {
                imageInputStream.close();
            }
        }

        private CloseAction(ImageInputStream imageInputStream) {
            this.iis = imageInputStream;
        }
    }

    public static void addToQueue(CloseAction closeAction) {
        synchronized (StreamCloser.class) {
            try {
                if (toCloseQueue == null) {
                    toCloseQueue = new WeakHashMap<>();
                }
                toCloseQueue.put(closeAction, null);
                if (streamCloser == null) {
                    final Runnable runnable = new Runnable() { // from class: com.sun.imageio.stream.StreamCloser.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (StreamCloser.toCloseQueue != null) {
                                synchronized (StreamCloser.class) {
                                    Set setKeySet = StreamCloser.toCloseQueue.keySet();
                                    for (CloseAction closeAction2 : (CloseAction[]) setKeySet.toArray(new CloseAction[setKeySet.size()])) {
                                        if (closeAction2 != null) {
                                            try {
                                                closeAction2.performAction();
                                            } catch (IOException unused) {
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    };
                    AccessController.doPrivileged(new PrivilegedAction() { // from class: com.sun.imageio.stream.StreamCloser.2
                        @Override // java.security.PrivilegedAction
                        public Object run() {
                            ThreadGroup threadGroup = Thread.currentThread().getThreadGroup();
                            ThreadGroup threadGroup2 = threadGroup;
                            while (threadGroup != null) {
                                threadGroup2 = threadGroup;
                                threadGroup = threadGroup.getParent();
                            }
                            Thread unused = StreamCloser.streamCloser = new Thread(threadGroup2, runnable);
                            StreamCloser.streamCloser.setContextClassLoader(null);
                            Runtime.getRuntime().addShutdownHook(StreamCloser.streamCloser);
                            return null;
                        }
                    });
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static CloseAction createCloseAction(ImageInputStream imageInputStream) {
        return new CloseAction(imageInputStream);
    }

    public static void removeFromQueue(CloseAction closeAction) {
        synchronized (StreamCloser.class) {
            try {
                WeakHashMap<CloseAction, Object> weakHashMap = toCloseQueue;
                if (weakHashMap != null) {
                    weakHashMap.remove(closeAction);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
