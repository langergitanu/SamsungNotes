package org.apache.poi.java.awt;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import org.apache.poi.sun.util.logging.PlatformLogger;

/* JADX INFO: loaded from: classes10.dex */
public class ContainerOrderFocusTraversalPolicy extends FocusTraversalPolicy implements Serializable {
    private static final PlatformLogger log = PlatformLogger.getLogger("org.apache.poi.java.awt.ContainerOrderFocusTraversalPolicy");
    private static final long serialVersionUID = 486933713763926351L;
    private transient java.util.List cachedCycle;
    private transient Container cachedRoot;
    private final int FORWARD_TRAVERSAL = 0;
    private final int BACKWARD_TRAVERSAL = 1;
    private boolean implicitDownCycleTraversal = true;

    /* JADX WARN: Removed duplicated region for block: B:17:0x0031  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void enumerateCycle(Container container, java.util.List list) {
        if (container.isVisible() && container.isDisplayable()) {
            list.add(container);
            for (Component component : container.getComponents()) {
                if (component instanceof Container) {
                    Container container2 = (Container) component;
                    if (container2.isFocusCycleRoot() || container2.isFocusTraversalPolicyProvider()) {
                        list.add(component);
                    } else {
                        enumerateCycle(container2, list);
                    }
                }
            }
        }
    }

    private Component getComponentDownCycle(Component component, int i) {
        Component defaultComponent;
        PlatformLogger platformLogger;
        StringBuilder sb;
        String str;
        if (component instanceof Container) {
            Container container = (Container) component;
            if (container.isFocusCycleRoot()) {
                if (!getImplicitDownCycleTraversal()) {
                    return null;
                }
                defaultComponent = container.getFocusTraversalPolicy().getDefaultComponent(container);
                if (defaultComponent != null) {
                    platformLogger = log;
                    if (platformLogger.isLoggable(500)) {
                        sb = new StringBuilder("### Transfered focus down-cycle to ");
                        sb.append(defaultComponent);
                        str = " in the focus cycle root ";
                    }
                }
                return defaultComponent;
            }
            if (container.isFocusTraversalPolicyProvider()) {
                defaultComponent = i == 0 ? container.getFocusTraversalPolicy().getDefaultComponent(container) : container.getFocusTraversalPolicy().getLastComponent(container);
                if (defaultComponent != null) {
                    platformLogger = log;
                    if (platformLogger.isLoggable(500)) {
                        sb = new StringBuilder("### Transfered focus to ");
                        sb.append(defaultComponent);
                        str = " in the FTP provider ";
                    }
                }
                return defaultComponent;
            }
            sb.append(str);
            sb.append(container);
            platformLogger.fine(sb.toString());
            return defaultComponent;
        }
        return null;
    }

    private int getComponentIndex(java.util.List<Component> list, Component component) {
        return list.indexOf(component);
    }

    private java.util.List<Component> getFocusTraversalCycle(Container container) {
        ArrayList arrayList = new ArrayList();
        enumerateCycle(container, arrayList);
        return arrayList;
    }

    private Container getTopmostProvider(Container container, Component component) {
        Container parent = component.getParent();
        Container container2 = null;
        while (parent != container && parent != null) {
            if (parent.isFocusTraversalPolicyProvider()) {
                container2 = parent;
            }
            parent = parent.getParent();
        }
        if (parent == null) {
            return null;
        }
        return container2;
    }

    public boolean accept(Component component) {
        if (!component.canBeFocusOwner()) {
            return false;
        }
        if (component instanceof Window) {
            return true;
        }
        do {
            component = component.getParent();
            if (component == null) {
                return true;
            }
            if (!component.isEnabled() && !component.isLightweight()) {
                return false;
            }
        } while (!(component instanceof Window));
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:47:0x00c7 A[Catch: all -> 0x0076, TryCatch #0 {all -> 0x0076, blocks: (B:23:0x005e, B:25:0x0065, B:28:0x006d, B:30:0x0074, B:34:0x0079, B:36:0x007f, B:38:0x0085, B:39:0x009c, B:41:0x00a6, B:43:0x00ac, B:63:0x0122, B:45:0x00bd, B:47:0x00c7, B:48:0x00de, B:50:0x00e4, B:52:0x00ea, B:53:0x0101, B:54:0x0105, B:56:0x0107, B:58:0x010f, B:61:0x011c, B:65:0x0124, B:67:0x012a, B:68:0x0137, B:70:0x0139), top: B:76:0x005e }] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00e4 A[Catch: all -> 0x0076, TryCatch #0 {all -> 0x0076, blocks: (B:23:0x005e, B:25:0x0065, B:28:0x006d, B:30:0x0074, B:34:0x0079, B:36:0x007f, B:38:0x0085, B:39:0x009c, B:41:0x00a6, B:43:0x00ac, B:63:0x0122, B:45:0x00bd, B:47:0x00c7, B:48:0x00de, B:50:0x00e4, B:52:0x00ea, B:53:0x0101, B:54:0x0105, B:56:0x0107, B:58:0x010f, B:61:0x011c, B:65:0x0124, B:67:0x012a, B:68:0x0137, B:70:0x0139), top: B:76:0x005e }] */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0107 A[Catch: all -> 0x0076, LOOP:0: B:56:0x0107->B:80:?, LOOP_START, PHI: r1
      0x0107: PHI (r1v2 int) = (r1v1 int), (r1v3 int) binds: [B:49:0x00e2, B:80:?] A[DONT_GENERATE, DONT_INLINE], TryCatch #0 {all -> 0x0076, blocks: (B:23:0x005e, B:25:0x0065, B:28:0x006d, B:30:0x0074, B:34:0x0079, B:36:0x007f, B:38:0x0085, B:39:0x009c, B:41:0x00a6, B:43:0x00ac, B:63:0x0122, B:45:0x00bd, B:47:0x00c7, B:48:0x00de, B:50:0x00e4, B:52:0x00ea, B:53:0x0101, B:54:0x0105, B:56:0x0107, B:58:0x010f, B:61:0x011c, B:65:0x0124, B:67:0x012a, B:68:0x0137, B:70:0x0139), top: B:76:0x005e }] */
    @Override // org.apache.poi.java.awt.FocusTraversalPolicy
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Component getComponentAfter(Container container, Component component) {
        int componentIndex;
        Component firstComponent;
        Component componentDownCycle;
        PlatformLogger platformLogger = log;
        if (platformLogger.isLoggable(500)) {
            platformLogger.fine("### Searching in " + container + " for component after " + component);
        }
        if (container == null || component == null) {
            throw new IllegalArgumentException("aContainer and aComponent cannot be null");
        }
        if (!container.isFocusTraversalPolicyProvider() && !container.isFocusCycleRoot()) {
            throw new IllegalArgumentException("aContainer should be focus cycle root or focus traversal policy provider");
        }
        if (container.isFocusCycleRoot() && !component.isFocusCycleRoot(container)) {
            throw new IllegalArgumentException("aContainer is not a focus cycle root of aComponent");
        }
        synchronized (container.getTreeLock()) {
            try {
                if (container.isVisible() && container.isDisplayable()) {
                    Component componentDownCycle2 = getComponentDownCycle(component, 0);
                    if (componentDownCycle2 != null) {
                        return componentDownCycle2;
                    }
                    Container topmostProvider = getTopmostProvider(container, component);
                    if (topmostProvider == null) {
                        java.util.List<Component> focusTraversalCycle = getFocusTraversalCycle(container);
                        if (platformLogger.isLoggable(500)) {
                            platformLogger.fine("### Cycle is " + focusTraversalCycle + ", component is " + component);
                        }
                        componentIndex = getComponentIndex(focusTraversalCycle, component);
                        if (componentIndex >= 0) {
                            if (platformLogger.isLoggable(500)) {
                                platformLogger.fine("### Didn't find component " + component + " in a cycle " + container);
                            }
                            firstComponent = getFirstComponent(container);
                        } else {
                            do {
                                componentIndex++;
                                if (componentIndex < focusTraversalCycle.size()) {
                                    componentDownCycle = focusTraversalCycle.get(componentIndex);
                                    if (!accept(componentDownCycle)) {
                                        componentDownCycle = getComponentDownCycle(componentDownCycle, 0);
                                    }
                                } else {
                                    if (!container.isFocusCycleRoot()) {
                                        return null;
                                    }
                                    this.cachedRoot = container;
                                    this.cachedCycle = focusTraversalCycle;
                                    firstComponent = getFirstComponent(container);
                                    this.cachedRoot = null;
                                    this.cachedCycle = null;
                                }
                            } while (componentDownCycle == null);
                        }
                        return firstComponent;
                    }
                    if (platformLogger.isLoggable(500)) {
                        platformLogger.fine("### Asking FTP " + topmostProvider + " for component after " + component);
                    }
                    componentDownCycle = topmostProvider.getFocusTraversalPolicy().getComponentAfter(topmostProvider, component);
                    if (componentDownCycle == null) {
                        component = topmostProvider;
                        java.util.List<Component> focusTraversalCycle2 = getFocusTraversalCycle(container);
                        if (platformLogger.isLoggable(500)) {
                        }
                        componentIndex = getComponentIndex(focusTraversalCycle2, component);
                        if (componentIndex >= 0) {
                        }
                        return firstComponent;
                    }
                    if (platformLogger.isLoggable(500)) {
                        platformLogger.fine("### FTP returned " + componentDownCycle);
                    }
                    return componentDownCycle;
                }
                return null;
            } finally {
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:47:0x00ab A[Catch: all -> 0x0072, TryCatch #0 {all -> 0x0072, blocks: (B:21:0x003b, B:23:0x0042, B:26:0x004a, B:28:0x0052, B:30:0x005a, B:33:0x0075, B:35:0x007f, B:37:0x0085, B:38:0x0094, B:40:0x0096, B:42:0x009c, B:45:0x009f, B:47:0x00ab, B:48:0x00c2, B:50:0x00c8, B:52:0x00ce, B:53:0x00e5, B:54:0x00e9, B:56:0x00eb, B:58:0x00ef, B:60:0x00f7, B:62:0x00fe, B:64:0x0100, B:67:0x0107, B:69:0x010d, B:70:0x011a, B:72:0x011c), top: B:78:0x003b }] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00c8 A[Catch: all -> 0x0072, TryCatch #0 {all -> 0x0072, blocks: (B:21:0x003b, B:23:0x0042, B:26:0x004a, B:28:0x0052, B:30:0x005a, B:33:0x0075, B:35:0x007f, B:37:0x0085, B:38:0x0094, B:40:0x0096, B:42:0x009c, B:45:0x009f, B:47:0x00ab, B:48:0x00c2, B:50:0x00c8, B:52:0x00ce, B:53:0x00e5, B:54:0x00e9, B:56:0x00eb, B:58:0x00ef, B:60:0x00f7, B:62:0x00fe, B:64:0x0100, B:67:0x0107, B:69:0x010d, B:70:0x011a, B:72:0x011c), top: B:78:0x003b }] */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00eb A[Catch: all -> 0x0072, LOOP:0: B:56:0x00eb->B:82:?, LOOP_START, PHI: r1
      0x00eb: PHI (r1v2 int) = (r1v1 int), (r1v3 int) binds: [B:49:0x00c6, B:82:?] A[DONT_GENERATE, DONT_INLINE], TryCatch #0 {all -> 0x0072, blocks: (B:21:0x003b, B:23:0x0042, B:26:0x004a, B:28:0x0052, B:30:0x005a, B:33:0x0075, B:35:0x007f, B:37:0x0085, B:38:0x0094, B:40:0x0096, B:42:0x009c, B:45:0x009f, B:47:0x00ab, B:48:0x00c2, B:50:0x00c8, B:52:0x00ce, B:53:0x00e5, B:54:0x00e9, B:56:0x00eb, B:58:0x00ef, B:60:0x00f7, B:62:0x00fe, B:64:0x0100, B:67:0x0107, B:69:0x010d, B:70:0x011a, B:72:0x011c), top: B:78:0x003b }] */
    @Override // org.apache.poi.java.awt.FocusTraversalPolicy
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Component getComponentBefore(Container container, Component component) {
        PlatformLogger platformLogger;
        int componentIndex;
        Component lastComponent;
        Component componentBefore;
        Component componentDownCycle;
        if (container == null || component == null) {
            throw new IllegalArgumentException("aContainer and aComponent cannot be null");
        }
        if (!container.isFocusTraversalPolicyProvider() && !container.isFocusCycleRoot()) {
            throw new IllegalArgumentException("aContainer should be focus cycle root or focus traversal policy provider");
        }
        if (container.isFocusCycleRoot() && !component.isFocusCycleRoot(container)) {
            throw new IllegalArgumentException("aContainer is not a focus cycle root of aComponent");
        }
        synchronized (container.getTreeLock()) {
            try {
                if (container.isVisible() && container.isDisplayable()) {
                    Container topmostProvider = getTopmostProvider(container, component);
                    if (topmostProvider == null) {
                        java.util.List<Component> focusTraversalCycle = getFocusTraversalCycle(container);
                        platformLogger = log;
                        if (platformLogger.isLoggable(500)) {
                        }
                        componentIndex = getComponentIndex(focusTraversalCycle, component);
                        if (componentIndex >= 0) {
                        }
                        return lastComponent;
                    }
                    PlatformLogger platformLogger2 = log;
                    if (platformLogger2.isLoggable(500)) {
                        platformLogger2.fine("### Asking FTP " + topmostProvider + " for component after " + component);
                    }
                    componentBefore = topmostProvider.getFocusTraversalPolicy().getComponentBefore(topmostProvider, component);
                    if (componentBefore == null) {
                        if (accept(topmostProvider)) {
                            return topmostProvider;
                        }
                        component = topmostProvider;
                        java.util.List<Component> focusTraversalCycle2 = getFocusTraversalCycle(container);
                        platformLogger = log;
                        if (platformLogger.isLoggable(500)) {
                            platformLogger.fine("### Cycle is " + focusTraversalCycle2 + ", component is " + component);
                        }
                        componentIndex = getComponentIndex(focusTraversalCycle2, component);
                        if (componentIndex >= 0) {
                            if (platformLogger.isLoggable(500)) {
                                platformLogger.fine("### Didn't find component " + component + " in a cycle " + container);
                            }
                            lastComponent = getLastComponent(container);
                        } else {
                            do {
                                componentIndex--;
                                if (componentIndex >= 0) {
                                    componentBefore = focusTraversalCycle2.get(componentIndex);
                                    if (componentBefore != container && (componentDownCycle = getComponentDownCycle(componentBefore, 1)) != null) {
                                        return componentDownCycle;
                                    }
                                } else {
                                    if (!container.isFocusCycleRoot()) {
                                        return null;
                                    }
                                    this.cachedRoot = container;
                                    this.cachedCycle = focusTraversalCycle2;
                                    lastComponent = getLastComponent(container);
                                    this.cachedRoot = null;
                                    this.cachedCycle = null;
                                }
                            } while (!accept(componentBefore));
                        }
                        return lastComponent;
                    }
                    if (platformLogger2.isLoggable(500)) {
                        platformLogger2.fine("### FTP returned " + componentBefore);
                    }
                    return componentBefore;
                }
                return null;
            } finally {
            }
        }
    }

    @Override // org.apache.poi.java.awt.FocusTraversalPolicy
    public Component getDefaultComponent(Container container) {
        return getFirstComponent(container);
    }

    @Override // org.apache.poi.java.awt.FocusTraversalPolicy
    public Component getFirstComponent(Container container) {
        PlatformLogger platformLogger = log;
        if (platformLogger.isLoggable(500)) {
            platformLogger.fine("### Getting first component in " + container);
        }
        if (container == null) {
            throw new IllegalArgumentException("aContainer cannot be null");
        }
        synchronized (container.getTreeLock()) {
            try {
                if (container.isVisible() && container.isDisplayable()) {
                    java.util.List<Component> focusTraversalCycle = this.cachedRoot == container ? this.cachedCycle : getFocusTraversalCycle(container);
                    if (focusTraversalCycle.size() != 0) {
                        if (platformLogger.isLoggable(500)) {
                            platformLogger.fine("### Cycle is " + focusTraversalCycle);
                        }
                        Iterator<Component> it = focusTraversalCycle.iterator();
                        while (it.hasNext()) {
                            Component next = it.next();
                            if (!accept(next) && (next == container || (next = getComponentDownCycle(next, 0)) == null)) {
                            }
                            return next;
                        }
                        return null;
                    }
                    if (platformLogger.isLoggable(500)) {
                        platformLogger.fine("### Cycle is empty");
                    }
                }
                return null;
            } finally {
            }
        }
    }

    public boolean getImplicitDownCycleTraversal() {
        return this.implicitDownCycleTraversal;
    }

    @Override // org.apache.poi.java.awt.FocusTraversalPolicy
    public Component getLastComponent(Container container) {
        PlatformLogger platformLogger = log;
        if (platformLogger.isLoggable(500)) {
            platformLogger.fine("### Getting last component in " + container);
        }
        if (container == null) {
            throw new IllegalArgumentException("aContainer cannot be null");
        }
        synchronized (container.getTreeLock()) {
            try {
                if (container.isVisible() && container.isDisplayable()) {
                    java.util.List<Component> focusTraversalCycle = this.cachedRoot == container ? this.cachedCycle : getFocusTraversalCycle(container);
                    if (focusTraversalCycle.size() != 0) {
                        if (platformLogger.isLoggable(500)) {
                            platformLogger.fine("### Cycle is " + focusTraversalCycle);
                        }
                        for (int size = focusTraversalCycle.size() - 1; size >= 0; size--) {
                            Component component = focusTraversalCycle.get(size);
                            if (accept(component)) {
                                return component;
                            }
                            if ((component instanceof Container) && component != container) {
                                Container container2 = (Container) component;
                                if (container2.isFocusTraversalPolicyProvider()) {
                                    return container2.getFocusTraversalPolicy().getLastComponent(container2);
                                }
                            }
                        }
                        return null;
                    }
                    if (platformLogger.isLoggable(500)) {
                        platformLogger.fine("### Cycle is empty");
                    }
                }
                return null;
            } finally {
            }
        }
    }

    public void setImplicitDownCycleTraversal(boolean z) {
        this.implicitDownCycleTraversal = z;
    }
}
