package org.apache.poi.java.awt;

import java.lang.reflect.Method;
import java.util.ArrayList;
import org.apache.poi.java.awt.EventFilter;
import org.apache.poi.sun.awt.EventQueueDelegate;
import org.apache.poi.sun.awt.ModalExclude;
import org.apache.poi.sun.awt.SunToolkit;
import org.apache.poi.sun.awt.dnd.SunDragSourceContextPeer;
import org.apache.poi.sun.util.logging.PlatformLogger;

/* JADX INFO: loaded from: classes10.dex */
class EventDispatchThread extends Thread {
    private static final int ANY_EVENT = -1;
    private static final PlatformLogger eventLog = PlatformLogger.getLogger("org.apache.poi.java.awt.event.EventDispatchThread");
    private volatile boolean doDispatch;
    private ArrayList<EventFilter> eventFilters;
    private EventQueue theQueue;

    public static class HierarchyEventFilter implements EventFilter {
        private Component modalComponent;

        public HierarchyEventFilter(Component component) {
            this.modalComponent = component;
        }

        @Override // org.apache.poi.java.awt.EventFilter
        public EventFilter.FilterAction acceptEvent(AWTEvent aWTEvent) {
            if (this.modalComponent != null) {
                int id = aWTEvent.getID();
                boolean z = false;
                boolean z2 = id >= 500 && id <= 507;
                boolean z3 = id >= 1001 && id <= 1001;
                boolean z4 = id == 201;
                if (Component.isInstanceOf(this.modalComponent, "javax.swing.JInternalFrame")) {
                    return z4 ? EventFilter.FilterAction.REJECT : EventFilter.FilterAction.ACCEPT;
                }
                if (z2 || z3 || z4) {
                    Object source = aWTEvent.getSource();
                    if (source instanceof ModalExclude) {
                        return EventFilter.FilterAction.ACCEPT;
                    }
                    if (source instanceof Component) {
                        Component parent = (Component) source;
                        if (this.modalComponent instanceof Container) {
                            while (true) {
                                if (parent != this.modalComponent && parent != null) {
                                    if ((parent instanceof Window) && SunToolkit.isModalExcluded((Window) parent)) {
                                        z = true;
                                        break;
                                    }
                                    parent = parent.getParent();
                                } else {
                                    break;
                                }
                            }
                        }
                        if (!z && parent != this.modalComponent) {
                            return EventFilter.FilterAction.REJECT;
                        }
                    }
                }
            }
            return EventFilter.FilterAction.ACCEPT;
        }
    }

    public EventDispatchThread(ThreadGroup threadGroup, String str, EventQueue eventQueue) {
        super(threadGroup, str);
        this.doDispatch = true;
        this.eventFilters = new ArrayList<>();
        setEventQueue(eventQueue);
    }

    private Conditional _macosxGetConditional(final Object obj) {
        try {
            return new Conditional() { // from class: org.apache.poi.java.awt.EventDispatchThread.2
                final Method evaluateMethod = Class.forName("sun.lwawt.macosx.EventDispatchAccess").getMethod("evaluate", null);

                @Override // org.apache.poi.java.awt.Conditional
                public boolean evaluate() {
                    try {
                        return ((Boolean) this.evaluateMethod.invoke(obj, null)).booleanValue();
                    } catch (Exception unused) {
                        return false;
                    }
                }
            };
        } catch (Exception unused) {
            return new Conditional() { // from class: org.apache.poi.java.awt.EventDispatchThread.3
                @Override // org.apache.poi.java.awt.Conditional
                public boolean evaluate() {
                    return false;
                }
            };
        }
    }

    private void processException(Throwable th) {
        PlatformLogger platformLogger = eventLog;
        if (platformLogger.isLoggable(500)) {
            platformLogger.fine("Processing exception: " + th);
        }
        getUncaughtExceptionHandler().uncaughtException(this, th);
    }

    public void addEventFilter(EventFilter eventFilter) {
        eventLog.finest("adding the event filter: " + eventFilter);
        synchronized (this.eventFilters) {
            try {
                if (!this.eventFilters.contains(eventFilter)) {
                    if (eventFilter instanceof ModalEventFilter) {
                        ModalEventFilter modalEventFilter = (ModalEventFilter) eventFilter;
                        int i = 0;
                        while (i < this.eventFilters.size()) {
                            EventFilter eventFilter2 = this.eventFilters.get(i);
                            if ((eventFilter2 instanceof ModalEventFilter) && ((ModalEventFilter) eventFilter2).compareTo(modalEventFilter) > 0) {
                                break;
                            } else {
                                i++;
                            }
                        }
                        this.eventFilters.add(i, eventFilter);
                    } else {
                        this.eventFilters.add(eventFilter);
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public synchronized EventQueue getEventQueue() {
        return this.theQueue;
    }

    public void pumpEvents(int i, Conditional conditional) {
        pumpEventsForHierarchy(i, conditional, null);
    }

    public void pumpEventsForFilter(int i, Conditional conditional, EventFilter eventFilter) {
        addEventFilter(eventFilter);
        this.doDispatch = true;
        while (this.doDispatch && !isInterrupted() && conditional.evaluate()) {
            pumpOneEventForFilters(i);
        }
        removeEventFilter(eventFilter);
    }

    public void pumpEventsForHierarchy(int i, Conditional conditional, Component component) {
        pumpEventsForFilter(i, conditional, new HierarchyEventFilter(component));
    }

    public void pumpOneEventForFilters(int i) {
        EventQueue eventQueue;
        EventQueueDelegate.Delegate delegate;
        AWTEvent nextEvent;
        boolean z;
        boolean z2;
        do {
            try {
                eventQueue = getEventQueue();
                delegate = EventQueueDelegate.getDelegate();
                nextEvent = (delegate == null || i != -1) ? i == -1 ? eventQueue.getNextEvent() : eventQueue.getNextEvent(i) : delegate.getNextEvent(eventQueue);
                synchronized (this.eventFilters) {
                    try {
                        z = true;
                        for (int size = this.eventFilters.size() - 1; size >= 0; size--) {
                            EventFilter.FilterAction filterActionAcceptEvent = this.eventFilters.get(size).acceptEvent(nextEvent);
                            if (filterActionAcceptEvent == EventFilter.FilterAction.REJECT) {
                                z2 = false;
                                break;
                            } else {
                                if (filterActionAcceptEvent == EventFilter.FilterAction.ACCEPT_IMMEDIATELY) {
                                    break;
                                }
                            }
                        }
                        z2 = true;
                    } finally {
                    }
                }
                if (!z2 || !SunDragSourceContextPeer.checkEvent(nextEvent)) {
                    z = false;
                }
                if (!z) {
                    nextEvent.consume();
                }
            } catch (InterruptedException unused) {
                this.doDispatch = false;
                return;
            } catch (ThreadDeath e) {
                this.doDispatch = false;
                throw e;
            } catch (Throwable th) {
                processException(th);
                return;
            }
        } while (!z);
        PlatformLogger platformLogger = eventLog;
        if (platformLogger.isLoggable(300)) {
            platformLogger.finest("Dispatching: " + nextEvent);
        }
        Object objBeforeDispatch = delegate != null ? delegate.beforeDispatch(nextEvent) : null;
        eventQueue.dispatchEvent(nextEvent);
        if (delegate != null) {
            delegate.afterDispatch(nextEvent, objBeforeDispatch);
        }
    }

    public void removeEventFilter(EventFilter eventFilter) {
        eventLog.finest("removing the event filter: " + eventFilter);
        synchronized (this.eventFilters) {
            this.eventFilters.remove(eventFilter);
        }
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        boolean z;
        boolean zDetachDispatchThread;
        EventQueue eventQueue;
        do {
            z = true;
            try {
                pumpEvents(new Conditional() { // from class: org.apache.poi.java.awt.EventDispatchThread.1
                    @Override // org.apache.poi.java.awt.Conditional
                    public boolean evaluate() {
                        return true;
                    }
                });
                eventQueue = getEventQueue();
                if (this.doDispatch && !isInterrupted()) {
                    z = false;
                }
            } finally {
                if (zDetachDispatchThread) {
                }
            }
        } while (!eventQueue.detachDispatchThread(this, z));
    }

    public synchronized void setEventQueue(EventQueue eventQueue) {
        this.theQueue = eventQueue;
    }

    public void stopDispatching() {
        this.doDispatch = false;
    }

    public void pumpEvents(Conditional conditional) {
        pumpEvents(-1, conditional);
    }

    public void pumpEventsForFilter(Conditional conditional, EventFilter eventFilter) {
        pumpEventsForFilter(-1, conditional, eventFilter);
    }

    public void pumpEventsForHierarchy(Conditional conditional, Component component) {
        pumpEventsForHierarchy(-1, conditional, component);
    }
}
