package org.apache.poi.java.awt;

import androidx.appcompat.widget.AbstractC0541b;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OptionalDataException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Vector;
import javax.accessibility.AccessibleContext;
import javax.accessibility.AccessibleRole;
import javax.accessibility.AccessibleState;
import javax.accessibility.AccessibleStateSet;
import org.apache.poi.java.awt.Window;
import org.apache.poi.java.awt.event.KeyEvent;
import org.apache.poi.java.awt.peer.FramePeer;
import org.apache.poi.sun.awt.AWTAccessor;
import org.apache.poi.sun.awt.SunToolkit;

/* JADX INFO: loaded from: classes10.dex */
public class Frame extends Window implements MenuContainer {

    @Deprecated
    public static final int CROSSHAIR_CURSOR = 1;

    @Deprecated
    public static final int DEFAULT_CURSOR = 0;

    @Deprecated
    public static final int E_RESIZE_CURSOR = 11;

    @Deprecated
    public static final int HAND_CURSOR = 12;
    public static final int ICONIFIED = 1;
    public static final int MAXIMIZED_BOTH = 6;
    public static final int MAXIMIZED_HORIZ = 2;
    public static final int MAXIMIZED_VERT = 4;

    @Deprecated
    public static final int MOVE_CURSOR = 13;

    @Deprecated
    public static final int NE_RESIZE_CURSOR = 7;
    public static final int NORMAL = 0;

    @Deprecated
    public static final int NW_RESIZE_CURSOR = 6;

    @Deprecated
    public static final int N_RESIZE_CURSOR = 8;

    @Deprecated
    public static final int SE_RESIZE_CURSOR = 5;

    @Deprecated
    public static final int SW_RESIZE_CURSOR = 4;

    @Deprecated
    public static final int S_RESIZE_CURSOR = 9;

    @Deprecated
    public static final int TEXT_CURSOR = 2;

    @Deprecated
    public static final int WAIT_CURSOR = 3;

    @Deprecated
    public static final int W_RESIZE_CURSOR = 10;
    private static final String base = "frame";
    private static int nameCounter = 0;
    private static final long serialVersionUID = 2673458971256075116L;
    private int frameSerializedDataVersion;
    Rectangle maximizedBounds;
    boolean mbManagement;
    MenuBar menuBar;
    Vector ownedWindows;
    boolean resizable;
    private int state;
    String title;
    boolean undecorated;

    public class AccessibleAWTFrame extends Window.AccessibleAWTWindow {
        private static final long serialVersionUID = -6172960752956030250L;

        public AccessibleAWTFrame() {
            super();
        }

        @Override // org.apache.poi.java.awt.Window.AccessibleAWTWindow, org.apache.poi.java.awt.Component.AccessibleAWTComponent
        public AccessibleRole getAccessibleRole() {
            return AccessibleRole.FRAME;
        }

        @Override // org.apache.poi.java.awt.Window.AccessibleAWTWindow, org.apache.poi.java.awt.Component.AccessibleAWTComponent
        public AccessibleStateSet getAccessibleStateSet() {
            AccessibleStateSet accessibleStateSet = super.getAccessibleStateSet();
            if (Frame.this.getFocusOwner() != null) {
                accessibleStateSet.add(AccessibleState.ACTIVE);
            }
            if (Frame.this.isResizable()) {
                accessibleStateSet.add(AccessibleState.RESIZABLE);
            }
            return accessibleStateSet;
        }
    }

    static {
        Toolkit.loadLibraries();
        if (!GraphicsEnvironment.isHeadless()) {
            initIDs();
        }
        AWTAccessor.setFrameAccessor(new AWTAccessor.FrameAccessor() { // from class: org.apache.poi.java.awt.Frame.1
            @Override // org.apache.poi.sun.awt.AWTAccessor.FrameAccessor
            public int getExtendedState(Frame frame) {
                int i;
                synchronized (frame.getObjectLock()) {
                    i = frame.state;
                }
                return i;
            }

            @Override // org.apache.poi.sun.awt.AWTAccessor.FrameAccessor
            public Rectangle getMaximizedBounds(Frame frame) {
                Rectangle rectangle;
                synchronized (frame.getObjectLock()) {
                    rectangle = frame.maximizedBounds;
                }
                return rectangle;
            }

            @Override // org.apache.poi.sun.awt.AWTAccessor.FrameAccessor
            public void setExtendedState(Frame frame, int i) {
                synchronized (frame.getObjectLock()) {
                    frame.state = i;
                }
            }
        });
    }

    public Frame() {
        this("");
    }

    public static Frame[] getFrames() {
        Window[] windows = Window.getWindows();
        int i = 0;
        for (Window window : windows) {
            if (window instanceof Frame) {
                i++;
            }
        }
        Frame[] frameArr = new Frame[i];
        int i2 = 0;
        for (Window window2 : windows) {
            if (window2 instanceof Frame) {
                frameArr[i2] = (Frame) window2;
                i2++;
            }
        }
        return frameArr;
    }

    private void init(String str, GraphicsConfiguration graphicsConfiguration) {
        this.title = str;
        SunToolkit.checkAndSetPolicy(this);
    }

    private static native void initIDs();

    private boolean isFrameStateSupported(int i) {
        if (getToolkit().isFrameStateSupported(i)) {
            return true;
        }
        if ((i & 1) != 0 && !getToolkit().isFrameStateSupported(1)) {
            return false;
        }
        return getToolkit().isFrameStateSupported(i & (-2));
    }

    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        objectInputStream.defaultReadObject();
        try {
            Image image = (Image) objectInputStream.readObject();
            if (this.icons == null) {
                ArrayList arrayList = new ArrayList();
                this.icons = arrayList;
                arrayList.add(image);
            }
        } catch (OptionalDataException e) {
            if (!e.eof) {
                throw e;
            }
        }
        MenuBar menuBar = this.menuBar;
        if (menuBar != null) {
            menuBar.parent = this;
        }
        if (this.ownedWindows != null) {
            for (int i = 0; i < this.ownedWindows.size(); i++) {
                connectOwnedWindow((Window) this.ownedWindows.elementAt(i));
            }
            this.ownedWindows = null;
        }
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        java.util.List<Image> list = this.icons;
        if (list != null && list.size() > 0) {
            Image image = this.icons.get(0);
            if (image instanceof Serializable) {
                objectOutputStream.writeObject(image);
                return;
            }
        }
        objectOutputStream.writeObject(null);
    }

    @Override // org.apache.poi.java.awt.Window, org.apache.poi.java.awt.Container, org.apache.poi.java.awt.Component
    public void addNotify() {
        synchronized (getTreeLock()) {
            try {
                if (this.peer == null) {
                    this.peer = getToolkit().createFrame(this);
                }
                FramePeer framePeer = this.peer;
                MenuBar menuBar = this.menuBar;
                if (menuBar != null) {
                    this.mbManagement = true;
                    menuBar.addNotify();
                    framePeer.setMenuBar(menuBar);
                }
                framePeer.setMaximizedBounds(this.maximizedBounds);
                super.addNotify();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.apache.poi.java.awt.Window, org.apache.poi.java.awt.Component
    public String constructComponentName() {
        String string;
        synchronized (Frame.class) {
            StringBuilder sb = new StringBuilder("frame");
            int i = nameCounter;
            nameCounter = i + 1;
            sb.append(i);
            string = sb.toString();
        }
        return string;
    }

    @Override // org.apache.poi.java.awt.Window, org.apache.poi.java.awt.Component
    public AccessibleContext getAccessibleContext() {
        if (this.accessibleContext == null) {
            this.accessibleContext = new AccessibleAWTFrame();
        }
        return this.accessibleContext;
    }

    @Deprecated
    public int getCursorType() {
        return getCursor().getType();
    }

    public int getExtendedState() {
        int i;
        synchronized (getObjectLock()) {
            i = this.state;
        }
        return i;
    }

    public Image getIconImage() {
        java.util.List<Image> list = this.icons;
        if (list == null || list.size() <= 0) {
            return null;
        }
        return list.get(0);
    }

    public Rectangle getMaximizedBounds() {
        Rectangle rectangle;
        synchronized (getObjectLock()) {
            rectangle = this.maximizedBounds;
        }
        return rectangle;
    }

    public MenuBar getMenuBar() {
        return this.menuBar;
    }

    public synchronized int getState() {
        return (getExtendedState() & 1) == 0 ? 0 : 1;
    }

    public String getTitle() {
        return this.title;
    }

    public boolean isResizable() {
        return this.resizable;
    }

    public boolean isUndecorated() {
        return this.undecorated;
    }

    @Override // org.apache.poi.java.awt.Container, org.apache.poi.java.awt.Component
    public String paramString() {
        String str;
        String strParamString = super.paramString();
        if (this.title != null) {
            StringBuilder sbM781w = AbstractC0541b.m781w(strParamString, ",title=");
            sbM781w.append(this.title);
            strParamString = sbM781w.toString();
        }
        if (this.resizable) {
            strParamString = AbstractC0541b.m756B(strParamString, ",resizable");
        }
        int extendedState = getExtendedState();
        if (extendedState == 0) {
            str = ",normal";
        } else {
            if ((extendedState & 1) != 0) {
                strParamString = AbstractC0541b.m756B(strParamString, ",iconified");
            }
            if ((extendedState & 6) == 6) {
                str = ",maximized";
            } else if ((extendedState & 2) != 0) {
                str = ",maximized_horiz";
            } else {
                if ((extendedState & 4) == 0) {
                    return strParamString;
                }
                str = ",maximized_vert";
            }
        }
        return AbstractC0541b.m756B(strParamString, str);
    }

    @Override // org.apache.poi.java.awt.Window, org.apache.poi.java.awt.Container
    public void postProcessKeyEvent(KeyEvent keyEvent) {
        MenuBar menuBar = this.menuBar;
        if (menuBar == null || !menuBar.handleShortcut(keyEvent)) {
            super.postProcessKeyEvent(keyEvent);
        } else {
            keyEvent.consume();
        }
    }

    @Override // org.apache.poi.java.awt.Component, org.apache.poi.java.awt.MenuContainer
    public void remove(MenuComponent menuComponent) {
        if (menuComponent == null) {
            return;
        }
        synchronized (getTreeLock()) {
            try {
                if (menuComponent == this.menuBar) {
                    this.menuBar = null;
                    FramePeer framePeer = this.peer;
                    if (framePeer != null) {
                        this.mbManagement = true;
                        invalidateIfValid();
                        framePeer.setMenuBar((MenuBar) null);
                        menuComponent.removeNotify();
                    }
                    menuComponent.parent = null;
                } else {
                    super.remove(menuComponent);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.apache.poi.java.awt.Window, org.apache.poi.java.awt.Container, org.apache.poi.java.awt.Component
    public void removeNotify() {
        synchronized (getTreeLock()) {
            try {
                FramePeer framePeer = this.peer;
                if (framePeer != null) {
                    getState();
                    if (this.menuBar != null) {
                        this.mbManagement = true;
                        framePeer.setMenuBar((MenuBar) null);
                        this.menuBar.removeNotify();
                    }
                }
                super.removeNotify();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.apache.poi.java.awt.Window, org.apache.poi.java.awt.Component
    public void setBackground(Color color) {
        synchronized (getTreeLock()) {
            if (color != null) {
                try {
                    if (color.getAlpha() < 255 && !isUndecorated()) {
                        throw new IllegalComponentStateException("The frame is decorated");
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            super.setBackground(color);
        }
    }

    @Deprecated
    public void setCursor(int i) {
        if (i < 0 || i > 13) {
            throw new IllegalArgumentException("illegal cursor type");
        }
        setCursor(Cursor.getPredefinedCursor(i));
    }

    public void setExtendedState(int i) {
        if (isFrameStateSupported(i)) {
            synchronized (getObjectLock()) {
                this.state = i;
            }
            FramePeer framePeer = this.peer;
            if (framePeer != null) {
                framePeer.setState(i);
            }
        }
    }

    @Override // org.apache.poi.java.awt.Window
    public void setIconImage(Image image) {
        super.setIconImage(image);
    }

    public void setMaximizedBounds(Rectangle rectangle) {
        synchronized (getObjectLock()) {
            this.maximizedBounds = rectangle;
        }
        FramePeer framePeer = this.peer;
        if (framePeer != null) {
            framePeer.setMaximizedBounds(rectangle);
        }
    }

    public void setMenuBar(MenuBar menuBar) {
        MenuContainer menuContainer;
        synchronized (getTreeLock()) {
            try {
                if (this.menuBar != menuBar) {
                    if (menuBar != null && (menuContainer = menuBar.parent) != null) {
                        menuContainer.remove(menuBar);
                    }
                    MenuBar menuBar2 = this.menuBar;
                    if (menuBar2 != null) {
                        remove(menuBar2);
                    }
                    this.menuBar = menuBar;
                    if (menuBar != null) {
                        menuBar.parent = this;
                        FramePeer framePeer = this.peer;
                        if (framePeer != null) {
                            this.mbManagement = true;
                            menuBar.addNotify();
                            invalidateIfValid();
                            framePeer.setMenuBar(this.menuBar);
                        }
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.apache.poi.java.awt.Window
    public void setOpacity(float f) {
        synchronized (getTreeLock()) {
            if (f < 1.0f) {
                try {
                    if (!isUndecorated()) {
                        throw new IllegalComponentStateException("The frame is decorated");
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            super.setOpacity(f);
        }
    }

    public void setResizable(boolean z) {
        boolean z2;
        boolean z3 = this.resizable;
        synchronized (this) {
            try {
                this.resizable = z;
                FramePeer framePeer = this.peer;
                if (framePeer != null) {
                    framePeer.setResizable(z);
                    z2 = true;
                } else {
                    z2 = false;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (z2) {
            invalidateIfValid();
        }
        firePropertyChange("resizable", z3, z);
    }

    @Override // org.apache.poi.java.awt.Window
    public void setShape(Shape shape) {
        synchronized (getTreeLock()) {
            if (shape != null) {
                try {
                    if (!isUndecorated()) {
                        throw new IllegalComponentStateException("The frame is decorated");
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            super.setShape(shape);
        }
    }

    public synchronized void setState(int i) {
        try {
            int extendedState = getExtendedState();
            if (i == 1 && (extendedState & 1) == 0) {
                setExtendedState(extendedState | 1);
            } else if (i == 0 && (extendedState & 1) != 0) {
                setExtendedState(extendedState & (-2));
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public void setTitle(String str) {
        String str2 = this.title;
        if (str == null) {
            str = "";
        }
        synchronized (this) {
            try {
                this.title = str;
                FramePeer framePeer = this.peer;
                if (framePeer != null) {
                    framePeer.setTitle(str);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        firePropertyChange("title", str2, str);
    }

    public void setUndecorated(boolean z) {
        synchronized (getTreeLock()) {
            try {
                if (isDisplayable()) {
                    throw new IllegalComponentStateException("The frame is displayable.");
                }
                if (!z) {
                    if (getOpacity() < 1.0f) {
                        throw new IllegalComponentStateException("The frame is not opaque");
                    }
                    if (getShape() != null) {
                        throw new IllegalComponentStateException("The frame does not have a default shape");
                    }
                    Color background = getBackground();
                    if (background != null && background.getAlpha() < 255) {
                        throw new IllegalComponentStateException("The frame background color is not opaque");
                    }
                }
                this.undecorated = z;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public Frame(String str) {
        this.title = "Untitled";
        this.resizable = true;
        this.undecorated = false;
        this.mbManagement = false;
        this.state = 0;
        this.frameSerializedDataVersion = 1;
        init(str, null);
    }

    public Frame(String str, GraphicsConfiguration graphicsConfiguration) {
        super(graphicsConfiguration);
        this.title = "Untitled";
        this.resizable = true;
        this.undecorated = false;
        this.mbManagement = false;
        this.state = 0;
        this.frameSerializedDataVersion = 1;
        init(str, graphicsConfiguration);
    }

    public Frame(GraphicsConfiguration graphicsConfiguration) {
        this("", graphicsConfiguration);
    }
}
