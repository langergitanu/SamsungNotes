package org.apache.poi.java.awt;

import org.apache.poi.java.awt.peer.ComponentPeer;

/* JADX INFO: loaded from: classes10.dex */
public class DefaultFocusTraversalPolicy extends ContainerOrderFocusTraversalPolicy {
    private static final long serialVersionUID = 8876966522510157497L;

    @Override // org.apache.poi.java.awt.ContainerOrderFocusTraversalPolicy
    public boolean accept(Component component) {
        if (component.isVisible() && component.isDisplayable() && component.isEnabled()) {
            if (!(component instanceof Window)) {
                for (Container parent = component.getParent(); parent != null; parent = parent.getParent()) {
                    if (!parent.isEnabled() && !parent.isLightweight()) {
                        return false;
                    }
                    if (parent instanceof Window) {
                        break;
                    }
                }
            }
            boolean zIsFocusable = component.isFocusable();
            if (component.isFocusTraversableOverridden()) {
                return zIsFocusable;
            }
            ComponentPeer peer = component.getPeer();
            if (peer != null && peer.isFocusable()) {
                return true;
            }
        }
        return false;
    }
}
