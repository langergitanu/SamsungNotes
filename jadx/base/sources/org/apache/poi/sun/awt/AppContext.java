package org.apache.poi.sun.awt;

import androidx.constraintlayout.motion.widget.AbstractC2322a;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.lang.ref.SoftReference;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.IdentityHashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.Supplier;
import org.apache.poi.java.awt.EventQueue;
import org.apache.poi.java.awt.GraphicsEnvironment;
import org.apache.poi.java.awt.SystemTray;
import org.apache.poi.java.awt.Toolkit;
import org.apache.poi.java.awt.TrayIcon;
import org.apache.poi.java.awt.Window;
import org.apache.poi.java.awt.event.InvocationEvent;
import org.apache.poi.sun.misc.JavaAWTAccess;
import org.apache.poi.sun.misc.SharedSecrets;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public final class AppContext {
    public static final String DISPOSED_PROPERTY_NAME = "disposed";
    public static final String GUI_DISPOSED = "guidisposed";
    private final ClassLoader contextClassLoader;
    private final ThreadGroup threadGroup;
    public static final Object EVENT_QUEUE_KEY = new StringBuffer("EventQueue");
    public static final Object EVENT_QUEUE_LOCK_KEY = new StringBuilder("EventQueue.Lock");
    public static final Object EVENT_QUEUE_COND_KEY = new StringBuilder("EventQueue.Condition");
    private static final Map<ThreadGroup, AppContext> threadGroup2appContext = Collections.synchronizedMap(new IdentityHashMap());
    private static volatile AppContext mainAppContext = null;
    private static final Object getAppContextLock = new GetAppContextLock();
    private static final AtomicInteger numAppContexts = new AtomicInteger(0);
    private static final ThreadLocal<AppContext> threadAppContext = new ThreadLocal<>();
    private final Map<Object, Object> table = new HashMap();
    private PropertyChangeSupport changeSupport = null;
    private volatile State state = State.VALID;
    private long DISPOSAL_TIMEOUT = 5000;
    private long THREAD_INTERRUPT_TIMEOUT = 1000;
    private MostRecentKeyValue mostRecentKeyValue = null;
    private MostRecentKeyValue shadowMostRecentKeyValue = null;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class CreateThreadAction implements PrivilegedAction<Thread> {
        private final AppContext appContext;
        private final Runnable runnable;

        public CreateThreadAction(AppContext appContext, Runnable runnable) {
            this.appContext = appContext;
            this.runnable = runnable;
        }

        @Override // java.security.PrivilegedAction
        public Thread run() {
            Thread thread = new Thread(this.appContext.getThreadGroup(), this.runnable);
            thread.setContextClassLoader(this.appContext.getContextClassLoader());
            thread.setPriority(6);
            thread.setDaemon(true);
            return thread;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class GetAppContextLock {
        private GetAppContextLock() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class PostShutdownEventRunnable implements Runnable {
        private final AppContext appContext;

        public PostShutdownEventRunnable(AppContext appContext) {
            this.appContext = appContext;
        }

        @Override // java.lang.Runnable
        public void run() {
            EventQueue eventQueue = (EventQueue) this.appContext.get(AppContext.EVENT_QUEUE_KEY);
            if (eventQueue != null) {
                eventQueue.postEvent(AWTAutoShutdown.getShutdownEvent());
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public enum State {
        VALID,
        BEING_DISPOSED,
        DISPOSED
    }

    static {
        SharedSecrets.setJavaAWTAccess(new JavaAWTAccess() { // from class: org.apache.poi.sun.awt.AppContext.6
            private boolean hasRootThreadGroup(final AppContext appContext) {
                return ((Boolean) AccessController.doPrivileged(new PrivilegedAction<Boolean>() { // from class: org.apache.poi.sun.awt.AppContext.6.1
                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // java.security.PrivilegedAction
                    public Boolean run() {
                        return Boolean.valueOf(AppContext.access$800(appContext).getParent() == null);
                    }
                })).booleanValue();
            }

            @Override // org.apache.poi.sun.misc.JavaAWTAccess
            public Object getAppletContext() {
                if (AppContext.numAppContexts.get() == 0) {
                    return null;
                }
                AppContext appContextAccess$900 = AppContext.access$900();
                if (AppContext.numAppContexts.get() > 0 && appContextAccess$900 == null) {
                    appContextAccess$900 = AppContext.getAppContext();
                }
                if (appContextAccess$900 == null || AppContext.mainAppContext == appContextAccess$900 || (AppContext.mainAppContext == null && hasRootThreadGroup(appContextAccess$900))) {
                    return null;
                }
                return appContextAccess$900;
            }
        });
    }

    public AppContext(ThreadGroup threadGroup) {
        numAppContexts.incrementAndGet();
        this.threadGroup = threadGroup;
        threadGroup2appContext.put(threadGroup, this);
        this.contextClassLoader = (ClassLoader) AccessController.doPrivileged(new PrivilegedAction<ClassLoader>() { // from class: org.apache.poi.sun.awt.AppContext.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.security.PrivilegedAction
            public ClassLoader run() {
                return Thread.currentThread().getContextClassLoader();
            }
        });
        ReentrantLock reentrantLock = new ReentrantLock();
        put(EVENT_QUEUE_LOCK_KEY, reentrantLock);
        put(EVENT_QUEUE_COND_KEY, reentrantLock.newCondition());
    }

    public static final AppContext getAppContext() {
        if (numAppContexts.get() == 1 && mainAppContext != null) {
            return mainAppContext;
        }
        AppContext appContext = threadAppContext.get();
        return appContext == null ? (AppContext) AccessController.doPrivileged(new PrivilegedAction<AppContext>() { // from class: org.apache.poi.sun.awt.AppContext.3
            @Override // java.security.PrivilegedAction
            public AppContext run() {
                ThreadGroup threadGroup;
                ThreadGroup threadGroup2 = Thread.currentThread().getThreadGroup();
                synchronized (AppContext.getAppContextLock) {
                    try {
                        if (AppContext.numAppContexts.get() == 0) {
                            if (System.getProperty("javaplugin.version") == null && System.getProperty("javawebstart.version") == null) {
                                AppContext.initMainAppContext();
                            } else if (System.getProperty("javafx.version") != null && threadGroup2.getParent() != null) {
                                SunToolkit.createNewAppContext();
                            }
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                AppContext appContext2 = (AppContext) AppContext.threadGroup2appContext.get(threadGroup2);
                ThreadGroup parent = threadGroup2;
                while (appContext2 == null) {
                    parent = parent.getParent();
                    if (parent == null) {
                        SecurityManager securityManager = System.getSecurityManager();
                        if (securityManager == null || (threadGroup = securityManager.getThreadGroup()) == null) {
                            return null;
                        }
                        return (AppContext) AppContext.threadGroup2appContext.get(threadGroup);
                    }
                    appContext2 = (AppContext) AppContext.threadGroup2appContext.get(parent);
                }
                while (threadGroup2 != parent) {
                    AppContext.threadGroup2appContext.put(threadGroup2, appContext2);
                    threadGroup2 = threadGroup2.getParent();
                }
                AppContext.threadAppContext.set(appContext2);
                return appContext2;
            }
        }) : appContext;
    }

    public static Set<AppContext> getAppContexts() {
        HashSet hashSet;
        Map<ThreadGroup, AppContext> map = threadGroup2appContext;
        synchronized (map) {
            hashSet = new HashSet(map.values());
        }
        return hashSet;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final AppContext getExecutionAppContext() {
        System.getSecurityManager();
        return null;
    }

    public static <T> T getSoftReferenceValue(Object obj, Supplier<T> supplier) {
        T t;
        AppContext appContext = getAppContext();
        SoftReference softReference = (SoftReference) appContext.get(obj);
        if (softReference != null && (t = (T) softReference.get()) != null) {
            return t;
        }
        T t2 = supplier.get();
        appContext.put(obj, new SoftReference(t2));
        return t2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initMainAppContext() {
        AccessController.doPrivileged(new PrivilegedAction<Void>() { // from class: org.apache.poi.sun.awt.AppContext.2
            @Override // java.security.PrivilegedAction
            public Void run() {
                ThreadGroup threadGroup = Thread.currentThread().getThreadGroup();
                ThreadGroup parent = threadGroup.getParent();
                while (true) {
                    ThreadGroup threadGroup2 = parent;
                    ThreadGroup threadGroup3 = threadGroup;
                    threadGroup = threadGroup2;
                    if (threadGroup == null) {
                        AppContext unused = AppContext.mainAppContext = SunToolkit.createNewAppContext(threadGroup3);
                        return null;
                    }
                    parent = threadGroup.getParent();
                }
            }
        });
    }

    public static final boolean isMainContext(AppContext appContext) {
        return appContext != null && appContext == mainAppContext;
    }

    public static void stopEventDispatchThreads() {
        for (AppContext appContext : getAppContexts()) {
            if (!appContext.isDisposed()) {
                PostShutdownEventRunnable postShutdownEventRunnable = new PostShutdownEventRunnable(appContext);
                if (appContext != getAppContext()) {
                    ((Thread) AccessController.doPrivileged(new CreateThreadAction(appContext, postShutdownEventRunnable))).start();
                } else {
                    postShutdownEventRunnable.run();
                }
            }
        }
    }

    public synchronized void addPropertyChangeListener(String str, PropertyChangeListener propertyChangeListener) {
        if (propertyChangeListener == null) {
            return;
        }
        try {
            if (this.changeSupport == null) {
                this.changeSupport = new PropertyChangeSupport(this);
            }
            this.changeSupport.addPropertyChangeListener(str, propertyChangeListener);
        } catch (Throwable th) {
            throw th;
        }
    }

    public void dispose() {
        if (this.threadGroup.parentOf(Thread.currentThread().getThreadGroup())) {
            throw new IllegalThreadStateException("Current Thread is contained within AppContext to be disposed.");
        }
        synchronized (this) {
            try {
                if (this.state != State.VALID) {
                    return;
                }
                this.state = State.BEING_DISPOSED;
                final PropertyChangeSupport propertyChangeSupport = this.changeSupport;
                if (propertyChangeSupport != null) {
                    propertyChangeSupport.firePropertyChange(DISPOSED_PROPERTY_NAME, false, true);
                }
                final Object obj = new Object();
                Runnable runnable = new Runnable() { // from class: org.apache.poi.sun.awt.AppContext.4
                    @Override // java.lang.Runnable
                    public void run() {
                        for (Window window : Window.getOwnerlessWindows()) {
                            try {
                                window.dispose();
                            } catch (Throwable th) {
                                AppContext.access$700().finer("exception occurred while disposing app context", th);
                            }
                        }
                        AccessController.doPrivileged(new PrivilegedAction<Void>() { // from class: org.apache.poi.sun.awt.AppContext.4.1
                            @Override // java.security.PrivilegedAction
                            public Void run() {
                                if (GraphicsEnvironment.isHeadless() || !SystemTray.isSupported()) {
                                    return null;
                                }
                                SystemTray systemTray = SystemTray.getSystemTray();
                                for (TrayIcon trayIcon : systemTray.getTrayIcons()) {
                                    systemTray.remove(trayIcon);
                                }
                                return null;
                            }
                        });
                        PropertyChangeSupport propertyChangeSupport2 = propertyChangeSupport;
                        if (propertyChangeSupport2 != null) {
                            propertyChangeSupport2.firePropertyChange(AppContext.GUI_DISPOSED, false, true);
                        }
                        synchronized (obj) {
                            obj.notifyAll();
                        }
                    }
                };
                synchronized (obj) {
                    SunToolkit.postEvent(this, new InvocationEvent(Toolkit.getDefaultToolkit(), runnable));
                    try {
                        obj.wait(this.DISPOSAL_TIMEOUT);
                    } catch (InterruptedException unused) {
                    }
                }
                Runnable runnable2 = new Runnable() { // from class: org.apache.poi.sun.awt.AppContext.5
                    @Override // java.lang.Runnable
                    public void run() {
                        synchronized (obj) {
                            obj.notifyAll();
                        }
                    }
                };
                synchronized (obj) {
                    SunToolkit.postEvent(this, new InvocationEvent(Toolkit.getDefaultToolkit(), runnable2));
                    try {
                        obj.wait(this.DISPOSAL_TIMEOUT);
                    } catch (InterruptedException unused2) {
                    }
                }
                synchronized (this) {
                    this.state = State.DISPOSED;
                }
                this.threadGroup.interrupt();
                long jCurrentTimeMillis = System.currentTimeMillis() + this.THREAD_INTERRUPT_TIMEOUT;
                while (this.threadGroup.activeCount() > 0 && System.currentTimeMillis() < jCurrentTimeMillis) {
                    try {
                        Thread.sleep(10L);
                    } catch (InterruptedException unused3) {
                    }
                }
                this.threadGroup.stop();
                long jCurrentTimeMillis2 = System.currentTimeMillis() + this.THREAD_INTERRUPT_TIMEOUT;
                while (this.threadGroup.activeCount() > 0 && System.currentTimeMillis() < jCurrentTimeMillis2) {
                    try {
                        Thread.sleep(10L);
                    } catch (InterruptedException unused4) {
                    }
                }
                int iActiveGroupCount = this.threadGroup.activeGroupCount();
                if (iActiveGroupCount > 0) {
                    ThreadGroup[] threadGroupArr = new ThreadGroup[iActiveGroupCount];
                    int iEnumerate = this.threadGroup.enumerate(threadGroupArr);
                    for (int i = 0; i < iEnumerate; i++) {
                        threadGroup2appContext.remove(threadGroupArr[i]);
                    }
                }
                threadGroup2appContext.remove(this.threadGroup);
                threadAppContext.set(null);
                try {
                    this.threadGroup.destroy();
                } catch (IllegalThreadStateException unused5) {
                }
                synchronized (this.table) {
                    this.table.clear();
                }
                numAppContexts.decrementAndGet();
                this.mostRecentKeyValue = null;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public Object get(Object obj) {
        synchronized (this.table) {
            try {
                MostRecentKeyValue mostRecentKeyValue = this.mostRecentKeyValue;
                if (mostRecentKeyValue != null && mostRecentKeyValue.key == obj) {
                    return mostRecentKeyValue.value;
                }
                Object obj2 = this.table.get(obj);
                MostRecentKeyValue mostRecentKeyValue2 = this.mostRecentKeyValue;
                if (mostRecentKeyValue2 == null) {
                    this.mostRecentKeyValue = new MostRecentKeyValue(obj, obj2);
                    this.shadowMostRecentKeyValue = new MostRecentKeyValue(obj, obj2);
                } else {
                    this.shadowMostRecentKeyValue.setPair(obj, obj2);
                    this.mostRecentKeyValue = this.shadowMostRecentKeyValue;
                    this.shadowMostRecentKeyValue = mostRecentKeyValue2;
                }
                return obj2;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public ClassLoader getContextClassLoader() {
        return this.contextClassLoader;
    }

    public synchronized PropertyChangeListener[] getPropertyChangeListeners() {
        PropertyChangeSupport propertyChangeSupport = this.changeSupport;
        if (propertyChangeSupport == null) {
            return new PropertyChangeListener[0];
        }
        return propertyChangeSupport.getPropertyChangeListeners();
    }

    public ThreadGroup getThreadGroup() {
        return this.threadGroup;
    }

    public boolean isDisposed() {
        return this.state == State.DISPOSED;
    }

    public Object put(Object obj, Object obj2) {
        Object objPut;
        synchronized (this.table) {
            try {
                MostRecentKeyValue mostRecentKeyValue = this.mostRecentKeyValue;
                if (mostRecentKeyValue != null && mostRecentKeyValue.key == obj) {
                    mostRecentKeyValue.value = obj2;
                }
                objPut = this.table.put(obj, obj2);
            } catch (Throwable th) {
                throw th;
            }
        }
        return objPut;
    }

    public Object remove(Object obj) {
        Object objRemove;
        synchronized (this.table) {
            try {
                MostRecentKeyValue mostRecentKeyValue = this.mostRecentKeyValue;
                if (mostRecentKeyValue != null && mostRecentKeyValue.key == obj) {
                    mostRecentKeyValue.value = null;
                }
                objRemove = this.table.remove(obj);
            } catch (Throwable th) {
                throw th;
            }
        }
        return objRemove;
    }

    public synchronized void removePropertyChangeListener(String str, PropertyChangeListener propertyChangeListener) {
        if (propertyChangeListener != null) {
            PropertyChangeSupport propertyChangeSupport = this.changeSupport;
            if (propertyChangeSupport != null) {
                propertyChangeSupport.removePropertyChangeListener(str, propertyChangeListener);
            }
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        AbstractC2322a.m1635y(AppContext.class, sb, "[threadGroup=");
        sb.append(this.threadGroup.getName());
        sb.append("]");
        return sb.toString();
    }

    public synchronized PropertyChangeListener[] getPropertyChangeListeners(String str) {
        PropertyChangeSupport propertyChangeSupport = this.changeSupport;
        if (propertyChangeSupport == null) {
            return new PropertyChangeListener[0];
        }
        return propertyChangeSupport.getPropertyChangeListeners(str);
    }
}
