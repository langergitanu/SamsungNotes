package org.apache.poi.java.awt;

import java.lang.ref.WeakReference;
import java.lang.reflect.InvocationTargetException;
import java.security.AccessControlContext;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.EmptyStackException;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import org.apache.poi.java.awt.event.InvocationEvent;
import org.apache.poi.java.awt.event.MouseEvent;
import org.apache.poi.java.awt.event.PaintEvent;
import org.apache.poi.java.awt.peer.ComponentPeer;
import org.apache.poi.sun.awt.AWTAccessor;
import org.apache.poi.sun.awt.AWTAutoShutdown;
import org.apache.poi.sun.awt.AppContext;
import org.apache.poi.sun.awt.EventQueueItem;
import org.apache.poi.sun.awt.PeerEvent;
import org.apache.poi.sun.awt.SunToolkit;
import org.apache.poi.sun.awt.dnd.SunDropTargetEvent;
import org.apache.poi.sun.misc.JavaSecurityAccess;
import org.apache.poi.sun.misc.SharedSecrets;
import org.apache.poi.sun.util.logging.PlatformLogger;

/* JADX INFO: loaded from: classes10.dex */
public class EventQueue {
    private static final int CACHE_LENGTH = 5;
    private static final int DRAG = 3;
    private static final int HIGH_PRIORITY = 2;
    private static final int LOW_PRIORITY = 0;
    private static final int MOVE = 2;
    private static final int NORM_PRIORITY = 1;
    private static final int NUM_PRIORITIES = 4;
    private static final int PAINT = 0;
    private static final int PEER = 4;
    private static final int ULTIMATE_PRIORITY = 3;
    private static final int UPDATE = 1;
    private static volatile PlatformLogger eventLog;
    private static final JavaSecurityAccess javaSecurityAccess;
    private final AppContext appContext;
    private WeakReference currentEvent;
    private EventDispatchThread dispatchThread;
    private EventQueue nextQueue;
    private EventQueue previousQueue;
    private final Condition pushPopCond;
    private final Lock pushPopLock;
    private volatile int waitForID;
    private static final AtomicInteger threadInitNumber = new AtomicInteger(0);
    private static final Runnable dummyRunnable = new Runnable() { // from class: org.apache.poi.java.awt.EventQueue.1
        @Override // java.lang.Runnable
        public void run() {
        }
    };
    private Queue[] queues = new Queue[4];
    private final ThreadGroup threadGroup = Thread.currentThread().getThreadGroup();
    private final ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
    private long mostRecentEventTime = System.currentTimeMillis();
    private final String name = "AWT-EventQueue-" + threadInitNumber.getAndIncrement();

    static {
        AWTAccessor.setEventQueueAccessor(new AWTAccessor.EventQueueAccessor() { // from class: org.apache.poi.java.awt.EventQueue.2
            @Override // org.apache.poi.sun.awt.AWTAccessor.EventQueueAccessor
            public Thread getDispatchThread(EventQueue eventQueue) {
                return eventQueue.getDispatchThread();
            }

            @Override // org.apache.poi.sun.awt.AWTAccessor.EventQueueAccessor
            public long getMostRecentEventTime(EventQueue eventQueue) {
                return eventQueue.getMostRecentEventTimeImpl();
            }

            @Override // org.apache.poi.sun.awt.AWTAccessor.EventQueueAccessor
            public void invokeAndWait(Object obj, Runnable runnable) throws InvocationTargetException {
                EventQueue.invokeAndWait(obj, runnable);
            }

            @Override // org.apache.poi.sun.awt.AWTAccessor.EventQueueAccessor
            public boolean isDispatchThreadImpl(EventQueue eventQueue) {
                return eventQueue.isDispatchThreadImpl();
            }

            @Override // org.apache.poi.sun.awt.AWTAccessor.EventQueueAccessor
            public boolean noEvents(EventQueue eventQueue) {
                return eventQueue.noEvents();
            }

            @Override // org.apache.poi.sun.awt.AWTAccessor.EventQueueAccessor
            public void removeSourceEvents(EventQueue eventQueue, Object obj, boolean z) {
                eventQueue.removeSourceEvents(obj, z);
            }

            @Override // org.apache.poi.sun.awt.AWTAccessor.EventQueueAccessor
            public void wakeup(EventQueue eventQueue, boolean z) {
                eventQueue.wakeup(z);
            }
        });
        javaSecurityAccess = SharedSecrets.getJavaSecurityAccess();
    }

    public EventQueue() {
        for (int i = 0; i < 4; i++) {
            this.queues[i] = new Queue();
        }
        AppContext appContext = AppContext.getAppContext();
        this.appContext = appContext;
        this.pushPopLock = (Lock) appContext.get(AppContext.EVENT_QUEUE_LOCK_KEY);
        this.pushPopCond = (Condition) appContext.get(AppContext.EVENT_QUEUE_COND_KEY);
    }

    private void cacheEQItem(EventQueueItem eventQueueItem) {
        AWTEvent aWTEvent = eventQueueItem.event;
        int iEventToCacheIndex = eventToCacheIndex(eventQueueItem.event);
        if (iEventToCacheIndex == -1 || !(eventQueueItem.event.getSource() instanceof Component)) {
            return;
        }
        Component component = (Component) eventQueueItem.event.getSource();
        if (component.eventCache == null) {
            component.eventCache = new EventQueueItem[5];
        }
        component.eventCache[iEventToCacheIndex] = eventQueueItem;
    }

    private boolean coalesceEvent(AWTEvent aWTEvent, int i) {
        return (aWTEvent.getSource() instanceof Component) && ((Component) aWTEvent.getSource()).isCoalescingEnabled() && coalesceOtherEvent(aWTEvent, i);
    }

    private boolean coalesceMouseEvent(MouseEvent mouseEvent) {
        EventQueueItem[] eventQueueItemArr;
        int iEventToCacheIndex;
        EventQueueItem eventQueueItem;
        if ((mouseEvent instanceof SunDropTargetEvent) || (eventQueueItemArr = ((Component) mouseEvent.getSource()).eventCache) == null || (iEventToCacheIndex = eventToCacheIndex(mouseEvent)) == -1 || (eventQueueItem = eventQueueItemArr[iEventToCacheIndex]) == null) {
            return false;
        }
        eventQueueItem.event = mouseEvent;
        return true;
    }

    private boolean coalesceOtherEvent(AWTEvent aWTEvent, int i) {
        AWTEvent aWTEventCoalesceEvents;
        int id = aWTEvent.getID();
        Component component = (Component) aWTEvent.getSource();
        for (EventQueueItem eventQueueItem = this.queues[i].head; eventQueueItem != null; eventQueueItem = eventQueueItem.next) {
            if (eventQueueItem.event.getSource() == component && eventQueueItem.event.getID() == id && (aWTEventCoalesceEvents = component.coalesceEvents(eventQueueItem.event, aWTEvent)) != null) {
                eventQueueItem.event = aWTEventCoalesceEvents;
                return true;
            }
        }
        return false;
    }

    private boolean coalescePaintEvent(PaintEvent paintEvent) {
        int iEventToCacheIndex;
        EventQueueItem eventQueueItem;
        PaintEvent paintEventMergePaintEvents;
        ComponentPeer componentPeer = ((Component) paintEvent.getSource()).peer;
        if (componentPeer != null) {
            componentPeer.coalescePaintEvent(paintEvent);
        }
        EventQueueItem[] eventQueueItemArr = ((Component) paintEvent.getSource()).eventCache;
        if (eventQueueItemArr == null || (iEventToCacheIndex = eventToCacheIndex(paintEvent)) == -1 || (eventQueueItem = eventQueueItemArr[iEventToCacheIndex]) == null || (paintEventMergePaintEvents = mergePaintEvents(paintEvent, (PaintEvent) eventQueueItem.event)) == null) {
            return false;
        }
        eventQueueItemArr[iEventToCacheIndex].event = paintEventMergePaintEvents;
        return true;
    }

    private boolean coalescePeerEvent(PeerEvent peerEvent) {
        int iEventToCacheIndex;
        EventQueueItem eventQueueItem;
        EventQueueItem[] eventQueueItemArr = ((Component) peerEvent.getSource()).eventCache;
        if (eventQueueItemArr != null && (iEventToCacheIndex = eventToCacheIndex(peerEvent)) != -1 && (eventQueueItem = eventQueueItemArr[iEventToCacheIndex]) != null) {
            PeerEvent peerEventCoalesceEvents = peerEvent.coalesceEvents(eventQueueItem.event);
            if (peerEventCoalesceEvents != null) {
                eventQueueItemArr[iEventToCacheIndex].event = peerEventCoalesceEvents;
                return true;
            }
            eventQueueItemArr[iEventToCacheIndex] = null;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void dispatchEventImpl(AWTEvent aWTEvent, Object obj) {
        aWTEvent.isPosted = true;
        if (aWTEvent instanceof ActiveEvent) {
            setCurrentEventAndMostRecentTimeImpl(aWTEvent);
            ((ActiveEvent) aWTEvent).dispatch();
            return;
        }
        if (obj instanceof Component) {
            ((Component) obj).dispatchEvent(aWTEvent);
            aWTEvent.dispatched();
            return;
        }
        if (obj instanceof MenuComponent) {
            ((MenuComponent) obj).dispatchEvent(aWTEvent);
            return;
        }
        if (obj instanceof TrayIcon) {
            ((TrayIcon) obj).dispatchEvent(aWTEvent);
            return;
        }
        if (obj instanceof AWTAutoShutdown) {
            if (noEvents()) {
                this.dispatchThread.stopDispatching();
            }
        } else if (getEventLog().isLoggable(500)) {
            getEventLog().fine("Unable to dispatch event: " + aWTEvent);
        }
    }

    private static int eventToCacheIndex(AWTEvent aWTEvent) {
        int id = aWTEvent.getID();
        if (id == 503) {
            return 2;
        }
        if (id == 506) {
            return 3;
        }
        if (id != 800) {
            return id != 801 ? -1 : 1;
        }
        return 0;
    }

    private static AccessControlContext getAccessControlContextFrom(Object obj) {
        if (obj instanceof Component) {
            return ((Component) obj).getAccessControlContext();
        }
        if (obj instanceof MenuComponent) {
            return ((MenuComponent) obj).getAccessControlContext();
        }
        if (obj instanceof TrayIcon) {
            return ((TrayIcon) obj).getAccessControlContext();
        }
        return null;
    }

    public static AWTEvent getCurrentEvent() {
        return Toolkit.getEventQueue().getCurrentEventImpl();
    }

    private AWTEvent getCurrentEventImpl() {
        this.pushPopLock.lock();
        try {
            return Thread.currentThread() == this.dispatchThread ? (AWTEvent) this.currentEvent.get() : null;
        } finally {
            this.pushPopLock.unlock();
        }
    }

    private static final PlatformLogger getEventLog() {
        if (eventLog == null) {
            eventLog = PlatformLogger.getLogger("org.apache.poi.java.awt.event.EventQueue");
        }
        return eventLog;
    }

    public static long getMostRecentEventTime() {
        return Toolkit.getEventQueue().getMostRecentEventTimeImpl();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long getMostRecentEventTimeImpl() {
        this.pushPopLock.lock();
        try {
            long jCurrentTimeMillis = Thread.currentThread() == this.dispatchThread ? this.mostRecentEventTime : System.currentTimeMillis();
            this.pushPopLock.unlock();
            return jCurrentTimeMillis;
        } catch (Throwable th) {
            this.pushPopLock.unlock();
            throw th;
        }
    }

    private static int getPriority(AWTEvent aWTEvent) {
        int id = aWTEvent.getID();
        return (id < 800 || id > 801) ? 1 : 0;
    }

    public static void invokeAndWait(Object obj, Runnable runnable) throws InvocationTargetException {
        if (isDispatchThread()) {
            throw new Error("Cannot call invokeAndWait from the event dispatcher thread");
        }
        Object obj2 = new Object() { // from class: org.apache.poi.java.awt.EventQueue.1AWTInvocationLock
        };
        AWTEvent invocationEvent = new InvocationEvent(obj, runnable, obj2, true);
        synchronized (obj2) {
            try {
                Toolkit.getEventQueue().postEvent(invocationEvent);
                while (!invocationEvent.isDispatched()) {
                    obj2.wait();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        Throwable throwable = invocationEvent.getThrowable();
        if (throwable != null) {
            throw new InvocationTargetException(throwable);
        }
    }

    public static void invokeLater(Runnable runnable) {
        Toolkit.getEventQueue().postEvent(new InvocationEvent(Toolkit.getDefaultToolkit(), runnable));
    }

    public static boolean isDispatchThread() {
        return Toolkit.getEventQueue().isDispatchThreadImpl();
    }

    private PaintEvent mergePaintEvents(PaintEvent paintEvent, PaintEvent paintEvent2) {
        Rectangle updateRect = paintEvent.getUpdateRect();
        Rectangle updateRect2 = paintEvent2.getUpdateRect();
        if (updateRect2.contains(updateRect)) {
            return paintEvent2;
        }
        if (updateRect.contains(updateRect2)) {
            return paintEvent;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean noEvents() {
        for (int i = 0; i < 4; i++) {
            if (this.queues[i].head != null) {
                return false;
            }
        }
        return true;
    }

    private final void postEventPrivate(AWTEvent aWTEvent) {
        aWTEvent.isPosted = true;
        this.pushPopLock.lock();
        try {
            EventQueue eventQueue = this.nextQueue;
            if (eventQueue != null) {
                eventQueue.postEventPrivate(aWTEvent);
            } else if (this.dispatchThread != null) {
                postEvent(aWTEvent, getPriority(aWTEvent));
            } else if (aWTEvent.getSource() != AWTAutoShutdown.getInstance()) {
                initDispatchThread();
                postEvent(aWTEvent, getPriority(aWTEvent));
            }
        } finally {
            this.pushPopLock.unlock();
        }
    }

    public static void setCurrentEventAndMostRecentTime(AWTEvent aWTEvent) {
        Toolkit.getEventQueue().setCurrentEventAndMostRecentTimeImpl(aWTEvent);
    }

    private void setCurrentEventAndMostRecentTimeImpl(AWTEvent aWTEvent) {
        this.pushPopLock.lock();
        try {
            if (Thread.currentThread() == this.dispatchThread) {
                this.currentEvent = new WeakReference(aWTEvent);
                this.mostRecentEventTime = Math.max(this.mostRecentEventTime, Long.MIN_VALUE);
            }
        } finally {
            this.pushPopLock.unlock();
        }
    }

    private void uncacheEQItem(EventQueueItem eventQueueItem) {
        EventQueueItem[] eventQueueItemArr;
        int iEventToCacheIndex = eventToCacheIndex(eventQueueItem.event);
        if (iEventToCacheIndex == -1 || !(eventQueueItem.event.getSource() instanceof Component) || (eventQueueItemArr = ((Component) eventQueueItem.event.getSource()).eventCache) == null) {
            return;
        }
        eventQueueItemArr[iEventToCacheIndex] = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wakeup(boolean z) {
        this.pushPopLock.lock();
        try {
            EventQueue eventQueue = this.nextQueue;
            if (eventQueue != null) {
                eventQueue.wakeup(z);
            } else if (this.dispatchThread != null) {
                this.pushPopCond.signalAll();
            } else if (!z) {
                initDispatchThread();
            }
            this.pushPopLock.unlock();
        } catch (Throwable th) {
            this.pushPopLock.unlock();
            throw th;
        }
    }

    public SecondaryLoop createSecondaryLoop() {
        return createSecondaryLoop(null, null, 0L);
    }

    public final boolean detachDispatchThread(EventDispatchThread eventDispatchThread, boolean z) {
        this.pushPopLock.lock();
        try {
            if (eventDispatchThread == this.dispatchThread) {
                if (z || peekEvent() == null) {
                    if (SunToolkit.isPostEventQueueEmpty()) {
                        this.dispatchThread = null;
                    }
                }
                this.pushPopLock.unlock();
                return false;
            }
            AWTAutoShutdown.getInstance().notifyThreadFree(eventDispatchThread);
            this.pushPopLock.unlock();
            return true;
        } catch (Throwable th) {
            this.pushPopLock.unlock();
            throw th;
        }
    }

    public void dispatchEvent(final AWTEvent aWTEvent) {
        final Object source = aWTEvent.getSource();
        final PrivilegedAction<Void> privilegedAction = new PrivilegedAction<Void>() { // from class: org.apache.poi.java.awt.EventQueue.3
            @Override // java.security.PrivilegedAction
            public Void run() {
                EventQueue.this.dispatchEventImpl(aWTEvent, source);
                return null;
            }
        };
        AccessControlContext context = AccessController.getContext();
        AccessControlContext accessControlContextFrom = getAccessControlContextFrom(source);
        final AccessControlContext accessControlContext = aWTEvent.getAccessControlContext();
        if (accessControlContextFrom == null) {
            javaSecurityAccess.doIntersectionPrivilege(privilegedAction, context, accessControlContext);
        } else {
            javaSecurityAccess.doIntersectionPrivilege(new PrivilegedAction<Void>() { // from class: org.apache.poi.java.awt.EventQueue.4
                @Override // java.security.PrivilegedAction
                public Void run() {
                    EventQueue.javaSecurityAccess.doIntersectionPrivilege(privilegedAction, accessControlContext);
                    return null;
                }
            }, context, accessControlContextFrom);
        }
    }

    public final EventDispatchThread getDispatchThread() {
        this.pushPopLock.lock();
        try {
            return this.dispatchThread;
        } finally {
            this.pushPopLock.unlock();
        }
    }

    public long getMostRecentEventTimeEx() {
        this.pushPopLock.lock();
        try {
            return this.mostRecentEventTime;
        } finally {
            this.pushPopLock.unlock();
        }
    }

    public AWTEvent getNextEvent() {
        while (true) {
            SunToolkit.flushPendingEvents(this.appContext);
            this.pushPopLock.lock();
            try {
                AWTEvent nextEventPrivate = getNextEventPrivate();
                if (nextEventPrivate != null) {
                    return nextEventPrivate;
                }
                AWTAutoShutdown.getInstance().notifyThreadFree(this.dispatchThread);
                this.pushPopCond.await();
                this.pushPopLock.unlock();
            } finally {
                this.pushPopLock.unlock();
            }
        }
    }

    public AWTEvent getNextEventPrivate() {
        for (int i = 3; i >= 0; i--) {
            Queue queue = this.queues[i];
            EventQueueItem eventQueueItem = queue.head;
            if (eventQueueItem != null) {
                queue.head = eventQueueItem.next;
                if (eventQueueItem.next == null) {
                    this.queues[i].tail = null;
                }
                uncacheEQItem(eventQueueItem);
                return eventQueueItem.event;
            }
        }
        return null;
    }

    public final void initDispatchThread() {
        this.pushPopLock.lock();
        try {
            if (this.dispatchThread == null && !this.threadGroup.isDestroyed() && !this.appContext.isDisposed()) {
                EventDispatchThread eventDispatchThread = (EventDispatchThread) AccessController.doPrivileged(new PrivilegedAction<EventDispatchThread>() { // from class: org.apache.poi.java.awt.EventQueue.5
                    @Override // java.security.PrivilegedAction
                    public EventDispatchThread run() {
                        EventDispatchThread eventDispatchThread2 = new EventDispatchThread(EventQueue.this.threadGroup, EventQueue.this.name, EventQueue.this);
                        eventDispatchThread2.setContextClassLoader(EventQueue.this.classLoader);
                        eventDispatchThread2.setPriority(6);
                        eventDispatchThread2.setDaemon(false);
                        AWTAutoShutdown.getInstance().notifyThreadBusy(eventDispatchThread2);
                        return eventDispatchThread2;
                    }
                });
                this.dispatchThread = eventDispatchThread;
                eventDispatchThread.start();
            }
        } finally {
            this.pushPopLock.unlock();
        }
    }

    public final boolean isDispatchThreadImpl() {
        this.pushPopLock.lock();
        try {
            EventQueue eventQueue = this;
            for (EventQueue eventQueue2 = this.nextQueue; eventQueue2 != null; eventQueue2 = eventQueue2.nextQueue) {
                eventQueue = eventQueue2;
            }
            boolean z = Thread.currentThread() == eventQueue.dispatchThread;
            this.pushPopLock.unlock();
            return z;
        } catch (Throwable th) {
            this.pushPopLock.unlock();
            throw th;
        }
    }

    public AWTEvent peekEvent() {
        this.pushPopLock.lock();
        for (int i = 3; i >= 0; i--) {
            try {
                EventQueueItem eventQueueItem = this.queues[i].head;
                if (eventQueueItem != null) {
                    return eventQueueItem.event;
                }
            } finally {
                this.pushPopLock.unlock();
            }
        }
        this.pushPopLock.unlock();
        return null;
    }

    public void pop() {
        if (getEventLog().isLoggable(500)) {
            getEventLog().fine("EventQueue.pop(" + this + ")");
        }
        this.pushPopLock.lock();
        EventQueue eventQueue = this;
        while (true) {
            try {
                EventQueue eventQueue2 = eventQueue.nextQueue;
                if (eventQueue2 == null) {
                    break;
                } else {
                    eventQueue = eventQueue2;
                }
            } finally {
                this.pushPopLock.unlock();
            }
        }
        EventQueue eventQueue3 = eventQueue.previousQueue;
        if (eventQueue3 == null) {
            throw new EmptyStackException();
        }
        eventQueue.previousQueue = null;
        eventQueue3.nextQueue = null;
        while (eventQueue.peekEvent() != null) {
            try {
                eventQueue3.postEventPrivate(eventQueue.getNextEventPrivate());
            } catch (InterruptedException e) {
                if (getEventLog().isLoggable(500)) {
                    getEventLog().fine("Interrupted pop", e);
                }
            }
        }
        EventDispatchThread eventDispatchThread = eventQueue.dispatchThread;
        if (eventDispatchThread != null && eventDispatchThread.getEventQueue() == this) {
            eventQueue3.dispatchThread = eventQueue.dispatchThread;
            eventQueue.dispatchThread.setEventQueue(eventQueue3);
        }
        AppContext appContext = this.appContext;
        Object obj = AppContext.EVENT_QUEUE_KEY;
        if (appContext.get(obj) == this) {
            this.appContext.put(obj, eventQueue3);
        }
        eventQueue.postEventPrivate(new InvocationEvent(eventQueue, dummyRunnable));
        this.pushPopCond.signalAll();
    }

    public void postEvent(AWTEvent aWTEvent) {
        SunToolkit.flushPendingEvents(this.appContext);
        postEventPrivate(aWTEvent);
    }

    public void push(EventQueue eventQueue) {
        if (getEventLog().isLoggable(500)) {
            getEventLog().fine("EventQueue.push(" + eventQueue + ")");
        }
        this.pushPopLock.lock();
        EventQueue eventQueue2 = this;
        while (true) {
            try {
                EventQueue eventQueue3 = eventQueue2.nextQueue;
                if (eventQueue3 == null) {
                    break;
                } else {
                    eventQueue2 = eventQueue3;
                }
            } catch (Throwable th) {
                this.pushPopLock.unlock();
                throw th;
            }
        }
        EventDispatchThread eventDispatchThread = eventQueue2.dispatchThread;
        if (eventDispatchThread != null && eventDispatchThread.getEventQueue() == this) {
            eventQueue.dispatchThread = eventQueue2.dispatchThread;
            eventQueue2.dispatchThread.setEventQueue(eventQueue);
        }
        while (eventQueue2.peekEvent() != null) {
            try {
                eventQueue.postEventPrivate(eventQueue2.getNextEventPrivate());
            } catch (InterruptedException e) {
                if (getEventLog().isLoggable(500)) {
                    getEventLog().fine("Interrupted push", e);
                }
            }
        }
        eventQueue2.postEventPrivate(new InvocationEvent(eventQueue2, dummyRunnable));
        eventQueue.previousQueue = eventQueue2;
        eventQueue2.nextQueue = eventQueue;
        AppContext appContext = this.appContext;
        Object obj = AppContext.EVENT_QUEUE_KEY;
        if (appContext.get(obj) == eventQueue2) {
            this.appContext.put(obj, eventQueue);
        }
        this.pushPopCond.signalAll();
        this.pushPopLock.unlock();
    }

    public final void removeSourceEvents(Object obj, boolean z) {
        SunToolkit.flushPendingEvents(this.appContext);
        this.pushPopLock.lock();
        for (int i = 0; i < 4; i++) {
            try {
                EventQueueItem eventQueueItem = null;
                for (EventQueueItem eventQueueItem2 = this.queues[i].head; eventQueueItem2 != null; eventQueueItem2 = eventQueueItem2.next) {
                    if (eventQueueItem2.event.getSource() != obj) {
                        eventQueueItem = eventQueueItem2;
                    } else {
                        if (!z) {
                            if (!(eventQueueItem2.event instanceof SequencedEvent) && !(eventQueueItem2.event instanceof SentEvent)) {
                                AWTEvent aWTEvent = eventQueueItem2.event;
                                AWTEvent aWTEvent2 = eventQueueItem2.event;
                                AWTEvent aWTEvent3 = eventQueueItem2.event;
                                AWTEvent aWTEvent4 = eventQueueItem2.event;
                            }
                            eventQueueItem = eventQueueItem2;
                        }
                        if (eventQueueItem2.event instanceof SequencedEvent) {
                            ((SequencedEvent) eventQueueItem2.event).dispose();
                        }
                        if (eventQueueItem2.event instanceof SentEvent) {
                            ((SentEvent) eventQueueItem2.event).dispose();
                        }
                        AWTEvent aWTEvent5 = eventQueueItem2.event;
                        if (eventQueueItem == null) {
                            this.queues[i].head = eventQueueItem2.next;
                        } else {
                            eventQueueItem.next = eventQueueItem2.next;
                        }
                        uncacheEQItem(eventQueueItem2);
                    }
                }
                this.queues[i].tail = eventQueueItem;
            } catch (Throwable th) {
                this.pushPopLock.unlock();
                throw th;
            }
        }
        this.pushPopLock.unlock();
    }

    public static void invokeAndWait(Runnable runnable) throws InvocationTargetException {
        invokeAndWait(Toolkit.getDefaultToolkit(), runnable);
    }

    private void postEvent(AWTEvent aWTEvent, int i) {
        if (coalesceEvent(aWTEvent, i)) {
            return;
        }
        EventQueueItem eventQueueItem = new EventQueueItem(aWTEvent);
        cacheEQItem(eventQueueItem);
        boolean z = aWTEvent.getID() == this.waitForID;
        Queue queue = this.queues[i];
        if (queue.head == null) {
            boolean zNoEvents = noEvents();
            Queue queue2 = this.queues[i];
            queue2.tail = eventQueueItem;
            queue2.head = eventQueueItem;
            if (zNoEvents) {
                if (aWTEvent.getSource() != AWTAutoShutdown.getInstance()) {
                    AWTAutoShutdown.getInstance().notifyThreadBusy(this.dispatchThread);
                }
            } else if (!z) {
                return;
            }
        } else {
            queue.tail.next = eventQueueItem;
            this.queues[i].tail = eventQueueItem;
            if (!z) {
                return;
            }
        }
        this.pushPopCond.signalAll();
    }

    public SecondaryLoop createSecondaryLoop(Conditional conditional, EventFilter eventFilter, long j) {
        this.pushPopLock.lock();
        try {
            EventQueue eventQueue = this.nextQueue;
            if (eventQueue != null) {
                SecondaryLoop secondaryLoopCreateSecondaryLoop = eventQueue.createSecondaryLoop(conditional, eventFilter, j);
                this.pushPopLock.unlock();
                return secondaryLoopCreateSecondaryLoop;
            }
            if (this.dispatchThread == null) {
                initDispatchThread();
            }
            WaitDispatchSupport waitDispatchSupport = new WaitDispatchSupport(this.dispatchThread, conditional, eventFilter, j);
            this.pushPopLock.unlock();
            return waitDispatchSupport;
        } catch (Throwable th) {
            this.pushPopLock.unlock();
            throw th;
        }
    }

    public AWTEvent getNextEvent(int i) {
        int i2;
        EventQueueItem eventQueueItem;
        EventQueueItem eventQueueItem2;
        loop0: while (true) {
            SunToolkit.flushPendingEvents(this.appContext);
            this.pushPopLock.lock();
            i2 = 0;
            while (i2 < 4) {
                try {
                    eventQueueItem = this.queues[i2].head;
                    eventQueueItem2 = null;
                    while (eventQueueItem != null) {
                        if (eventQueueItem.event.getID() == i) {
                            break loop0;
                        }
                        eventQueueItem2 = eventQueueItem;
                        eventQueueItem = eventQueueItem.next;
                    }
                    i2++;
                } catch (Throwable th) {
                    this.pushPopLock.unlock();
                    throw th;
                }
            }
            this.waitForID = i;
            this.pushPopCond.await();
            this.waitForID = 0;
            this.pushPopLock.unlock();
        }
        if (eventQueueItem2 == null) {
            this.queues[i2].head = eventQueueItem.next;
        } else {
            eventQueueItem2.next = eventQueueItem.next;
        }
        Queue queue = this.queues[i2];
        if (queue.tail == eventQueueItem) {
            queue.tail = eventQueueItem2;
        }
        uncacheEQItem(eventQueueItem);
        AWTEvent aWTEvent = eventQueueItem.event;
        this.pushPopLock.unlock();
        return aWTEvent;
    }

    public AWTEvent peekEvent(int i) {
        this.pushPopLock.lock();
        for (int i2 = 3; i2 >= 0; i2--) {
            try {
                for (EventQueueItem eventQueueItem = this.queues[i2].head; eventQueueItem != null; eventQueueItem = eventQueueItem.next) {
                    if (eventQueueItem.event.getID() == i) {
                        return eventQueueItem.event;
                    }
                }
            } finally {
                this.pushPopLock.unlock();
            }
        }
        this.pushPopLock.unlock();
        return null;
    }
}
