package org.apache.poi.java.awt;

import javax.accessibility.Accessible;
import javax.accessibility.AccessibleContext;
import javax.accessibility.AccessibleRole;
import org.apache.poi.java.awt.Container;

/* JADX INFO: loaded from: classes10.dex */
public class Panel extends Container implements Accessible {
    private static final String base = "panel";
    private static int nameCounter = 0;
    private static final long serialVersionUID = -2728009084054400034L;

    public class AccessibleAWTPanel extends Container.AccessibleAWTContainer {
        private static final long serialVersionUID = -6409552226660031050L;

        public AccessibleAWTPanel() {
            super();
        }

        @Override // org.apache.poi.java.awt.Component.AccessibleAWTComponent
        public AccessibleRole getAccessibleRole() {
            return AccessibleRole.PANEL;
        }
    }

    public Panel() {
        this(new FlowLayout());
    }

    @Override // org.apache.poi.java.awt.Container, org.apache.poi.java.awt.Component
    public void addNotify() {
        synchronized (getTreeLock()) {
            try {
                if (this.peer == null) {
                    this.peer = getToolkit().createPanel(this);
                }
                super.addNotify();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.apache.poi.java.awt.Component
    public String constructComponentName() {
        String string;
        synchronized (Panel.class) {
            StringBuilder sb = new StringBuilder(base);
            int i = nameCounter;
            nameCounter = i + 1;
            sb.append(i);
            string = sb.toString();
        }
        return string;
    }

    @Override // org.apache.poi.java.awt.Component
    public AccessibleContext getAccessibleContext() {
        if (this.accessibleContext == null) {
            this.accessibleContext = new AccessibleAWTPanel();
        }
        return this.accessibleContext;
    }

    public Panel(LayoutManager layoutManager) {
        setLayout(layoutManager);
    }
}
