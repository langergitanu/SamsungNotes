package org.apache.poi.java.awt;

import org.apache.poi.java.awt.peer.ComponentPeer;
import org.apache.poi.java.awt.peer.LightweightPeer;
import org.apache.poi.sun.awt.SunGraphicsCallback;

/* JADX INFO: loaded from: classes10.dex */
abstract class GraphicsCallback extends SunGraphicsCallback {

    public static final class PaintAllCallback extends GraphicsCallback {
        private static PaintAllCallback instance = new PaintAllCallback();

        private PaintAllCallback() {
        }

        public static PaintAllCallback getInstance() {
            return instance;
        }

        public void run(Component component, Graphics graphics) {
            component.paintAll(graphics);
        }
    }

    public static final class PaintCallback extends GraphicsCallback {
        private static PaintCallback instance = new PaintCallback();

        private PaintCallback() {
        }

        public static PaintCallback getInstance() {
            return instance;
        }

        public void run(Component component, Graphics graphics) {
            component.paint(graphics);
        }
    }

    public static final class PaintHeavyweightComponentsCallback extends GraphicsCallback {
        private static PaintHeavyweightComponentsCallback instance = new PaintHeavyweightComponentsCallback();

        private PaintHeavyweightComponentsCallback() {
        }

        public static PaintHeavyweightComponentsCallback getInstance() {
            return instance;
        }

        public void run(Component component, Graphics graphics) {
            if (component.peer instanceof LightweightPeer) {
                component.paintHeavyweightComponents(graphics);
            } else {
                component.paintAll(graphics);
            }
        }
    }

    public static final class PeerPaintCallback extends GraphicsCallback {
        private static PeerPaintCallback instance = new PeerPaintCallback();

        private PeerPaintCallback() {
        }

        public static PeerPaintCallback getInstance() {
            return instance;
        }

        public void run(Component component, Graphics graphics) {
            component.validate();
            ComponentPeer componentPeer = component.peer;
            if (componentPeer instanceof LightweightPeer) {
                component.lightweightPaint(graphics);
            } else {
                componentPeer.paint(graphics);
            }
        }
    }
}
