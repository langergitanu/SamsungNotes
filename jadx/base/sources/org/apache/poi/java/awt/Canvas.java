package org.apache.poi.java.awt;

import javax.accessibility.Accessible;
import javax.accessibility.AccessibleContext;
import javax.accessibility.AccessibleRole;
import org.apache.poi.java.awt.Component;
import org.apache.poi.java.awt.image.BufferStrategy;
import org.apache.poi.java.awt.peer.CanvasPeer;

/* JADX INFO: loaded from: classes10.dex */
public class Canvas extends Component implements Accessible {
    private static final String base = "canvas";
    private static int nameCounter = 0;
    private static final long serialVersionUID = -2284879212465893870L;

    public class AccessibleAWTCanvas extends Component.AccessibleAWTComponent {
        private static final long serialVersionUID = -6325592262103146699L;

        public AccessibleAWTCanvas() {
            super();
        }

        @Override // org.apache.poi.java.awt.Component.AccessibleAWTComponent
        public AccessibleRole getAccessibleRole() {
            return AccessibleRole.CANVAS;
        }
    }

    public Canvas() {
    }

    @Override // org.apache.poi.java.awt.Component
    public void addNotify() {
        synchronized (getTreeLock()) {
            try {
                if (this.peer == null) {
                    this.peer = getToolkit().createCanvas(this);
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
        synchronized (Canvas.class) {
            StringBuilder sb = new StringBuilder(base);
            int i = nameCounter;
            nameCounter = i + 1;
            sb.append(i);
            string = sb.toString();
        }
        return string;
    }

    @Override // org.apache.poi.java.awt.Component
    public void createBufferStrategy(int i) {
        super.createBufferStrategy(i);
    }

    @Override // org.apache.poi.java.awt.Component
    public AccessibleContext getAccessibleContext() {
        if (this.accessibleContext == null) {
            this.accessibleContext = new AccessibleAWTCanvas();
        }
        return this.accessibleContext;
    }

    @Override // org.apache.poi.java.awt.Component
    public BufferStrategy getBufferStrategy() {
        return super.getBufferStrategy();
    }

    @Override // org.apache.poi.java.awt.Component
    public void paint(Graphics graphics) {
        graphics.clearRect(0, 0, this.width, this.height);
    }

    @Override // org.apache.poi.java.awt.Component
    public boolean postsOldMouseEvents() {
        return true;
    }

    @Override // org.apache.poi.java.awt.Component
    public void setGraphicsConfiguration(GraphicsConfiguration graphicsConfiguration) {
        synchronized (getTreeLock()) {
            try {
                CanvasPeer peer = getPeer();
                if (peer != null) {
                    graphicsConfiguration = peer.getAppropriateGraphicsConfiguration(graphicsConfiguration);
                }
                super.setGraphicsConfiguration(graphicsConfiguration);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.apache.poi.java.awt.Component
    public void update(Graphics graphics) {
        graphics.clearRect(0, 0, this.width, this.height);
        paint(graphics);
    }

    public Canvas(GraphicsConfiguration graphicsConfiguration) {
        this();
        setGraphicsConfiguration(graphicsConfiguration);
    }

    @Override // org.apache.poi.java.awt.Component
    public void createBufferStrategy(int i, BufferCapabilities bufferCapabilities) {
        super.createBufferStrategy(i, bufferCapabilities);
    }
}
