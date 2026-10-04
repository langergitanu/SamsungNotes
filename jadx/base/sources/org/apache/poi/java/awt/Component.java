package org.apache.poi.java.awt;

import androidx.appcompat.widget.AbstractC0541b;
import androidx.compose.p109ui.layout.LayoutKt;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.beans.Transient;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OptionalDataException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.security.AccessControlContext;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.Collections;
import java.util.EventListener;
import java.util.HashSet;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.Vector;
import java.util.WeakHashMap;
import javax.accessibility.Accessible;
import javax.accessibility.AccessibleComponent;
import javax.accessibility.AccessibleContext;
import javax.accessibility.AccessibleRole;
import javax.accessibility.AccessibleSelection;
import javax.accessibility.AccessibleState;
import javax.accessibility.AccessibleStateSet;
import javax.swing.JComponent;
import org.apache.poi.java.awt.BufferCapabilities;
import org.apache.poi.java.awt.GraphicsCallback;
import org.apache.poi.java.awt.dnd.DropTarget;
import org.apache.poi.java.awt.event.ComponentEvent;
import org.apache.poi.java.awt.event.ComponentListener;
import org.apache.poi.java.awt.event.FocusEvent;
import org.apache.poi.java.awt.event.FocusListener;
import org.apache.poi.java.awt.event.HierarchyBoundsListener;
import org.apache.poi.java.awt.event.HierarchyEvent;
import org.apache.poi.java.awt.event.HierarchyListener;
import org.apache.poi.java.awt.event.InputMethodEvent;
import org.apache.poi.java.awt.event.InputMethodListener;
import org.apache.poi.java.awt.event.KeyEvent;
import org.apache.poi.java.awt.event.KeyListener;
import org.apache.poi.java.awt.event.MouseEvent;
import org.apache.poi.java.awt.event.MouseListener;
import org.apache.poi.java.awt.event.MouseMotionListener;
import org.apache.poi.java.awt.event.MouseWheelEvent;
import org.apache.poi.java.awt.event.MouseWheelListener;
import org.apache.poi.java.awt.event.PaintEvent;
import org.apache.poi.java.awt.event.WindowEvent;
import org.apache.poi.java.awt.geom.AffineTransform;
import org.apache.poi.java.awt.im.InputMethodRequests;
import org.apache.poi.java.awt.image.BufferStrategy;
import org.apache.poi.java.awt.image.ColorModel;
import org.apache.poi.java.awt.image.ImageObserver;
import org.apache.poi.java.awt.image.ImageProducer;
import org.apache.poi.java.awt.image.VolatileImage;
import org.apache.poi.java.awt.peer.ComponentPeer;
import org.apache.poi.java.awt.peer.ContainerPeer;
import org.apache.poi.java.awt.peer.LightweightPeer;
import org.apache.poi.sun.awt.AWTAccessor;
import org.apache.poi.sun.awt.AppContext;
import org.apache.poi.sun.awt.CausedFocusEvent;
import org.apache.poi.sun.awt.EventQueueItem;
import org.apache.poi.sun.awt.RequestFocusController;
import org.apache.poi.sun.awt.SubRegionShowable;
import org.apache.poi.sun.awt.SunToolkit;
import org.apache.poi.sun.awt.WindowClosingListener;
import org.apache.poi.sun.awt.im.InputContext;
import org.apache.poi.sun.awt.image.VSyncedBSManager;
import org.apache.poi.sun.java2d.SunGraphics2D;
import org.apache.poi.sun.java2d.SunGraphicsEnvironment;
import org.apache.poi.sun.java2d.pipe.Region;
import org.apache.poi.sun.java2d.pipe.hw.ExtendedBufferCapabilities;
import org.apache.poi.sun.security.action.GetPropertyAction;
import org.apache.poi.sun.util.logging.PlatformLogger;
import sun.font.FontDesignMetrics;
import sun.font.FontManagerFactory;
import sun.font.SunFontManager;

/* JADX INFO: loaded from: classes10.dex */
public abstract class Component implements ImageObserver, MenuContainer, Serializable {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final float BOTTOM_ALIGNMENT = 1.0f;
    public static final float CENTER_ALIGNMENT = 0.5f;
    private static final int FOCUS_TRAVERSABLE_DEFAULT = 1;
    private static final int FOCUS_TRAVERSABLE_SET = 2;
    private static final int FOCUS_TRAVERSABLE_UNKNOWN = 0;
    public static final float LEFT_ALIGNMENT = 0.0f;
    public static final float RIGHT_ALIGNMENT = 1.0f;
    public static final float TOP_ALIGNMENT = 0.0f;
    static final String actionListenerK = "actionL";
    static final String adjustmentListenerK = "adjustmentL";
    private static final Class[] coalesceEventsParams;
    private static final Map<Class<?>, Boolean> coalesceMap;
    static final String componentListenerK = "componentL";
    static final String containerListenerK = "containerL";
    static final String focusListenerK = "focusL";
    static final String hierarchyBoundsListenerK = "hierarchyBoundsL";
    static final String hierarchyListenerK = "hierarchyL";
    static int incRate = 0;
    static final String inputMethodListenerK = "inputMethodL";
    static boolean isInc = false;
    static final String itemListenerK = "itemL";
    static final String keyListenerK = "keyL";
    static final String mouseListenerK = "mouseL";
    static final String mouseMotionListenerK = "mouseMotionL";
    static final String mouseWheelListenerK = "mouseWheelL";
    static final String ownedWindowK = "ownedL";
    private static RequestFocusController requestFocusController = null;
    private static final long serialVersionUID = -7644114512714619750L;
    static final String textListenerK = "textL";
    static final String windowFocusListenerK = "windowFocusL";
    static final String windowListenerK = "windowL";
    static final String windowStateListenerK = "windowStateL";
    Color background;
    transient boolean backgroundEraseDisabled;
    private PropertyChangeSupport changeSupport;
    transient ComponentListener componentListener;
    Cursor cursor;
    DropTarget dropTarget;
    transient EventQueueItem[] eventCache;
    transient FocusListener focusListener;
    Set[] focusTraversalKeys;
    Font font;
    Color foreground;
    int height;
    transient HierarchyBoundsListener hierarchyBoundsListener;
    transient HierarchyListener hierarchyListener;
    transient InputMethodListener inputMethodListener;
    transient KeyListener keyListener;
    Locale locale;
    Dimension maxSize;
    boolean maxSizeSet;
    Dimension minSize;
    boolean minSizeSet;
    transient MouseListener mouseListener;
    transient MouseMotionListener mouseMotionListener;
    transient MouseWheelListener mouseWheelListener;
    private String name;
    transient Container parent;
    transient ComponentPeer peer;
    Font peerFont;
    Vector popups;
    Dimension prefSize;
    boolean prefSizeSet;
    int width;

    /* JADX INFO: renamed from: x */
    int f10034x;

    /* JADX INFO: renamed from: y */
    int f10035y;
    private static final PlatformLogger log = PlatformLogger.getLogger("org.apache.poi.java.awt.Component");
    private static final PlatformLogger eventLog = PlatformLogger.getLogger("org.apache.poi.java.awt.event.Component");
    private static final PlatformLogger focusLog = PlatformLogger.getLogger("org.apache.poi.java.awt.focus.Component");
    private static final PlatformLogger mixingLog = PlatformLogger.getLogger("org.apache.poi.java.awt.mixing.Component");
    private static final String[] focusTraversalKeyPropertyNames = {"forwardFocusTraversalKeys", "backwardFocusTraversalKeys", "upCycleFocusTraversalKeys", "downCycleFocusTraversalKeys"};
    static final Object LOCK = new AWTTreeLock();
    private transient GraphicsConfiguration graphicsConfig = null;
    transient BufferStrategy bufferStrategy = null;
    boolean ignoreRepaint = false;
    boolean visible = true;
    boolean enabled = true;
    private volatile boolean valid = false;
    private boolean nameExplicitlySet = false;
    private boolean focusable = true;
    private int isFocusTraversableOverridden = 0;
    private boolean focusTraversalKeysEnabled = true;
    private volatile transient AccessControlContext acc = AccessController.getContext();
    transient ComponentOrientation componentOrientation = ComponentOrientation.UNKNOWN;
    boolean newEventsOnly = false;
    transient RuntimeException windowClosingException = null;
    long eventMask = 4096;
    private transient Object objectLock = new Object();
    boolean isPacked = false;
    private int boundsOp = 3;
    private transient Region compoundShape = null;
    private transient Region mixingCutoutRegion = null;
    private transient boolean isAddNotifyComplete = false;
    private transient boolean coalescingEnabled = checkCoalescing();
    private boolean autoFocusTransferOnDisposal = true;
    private int componentSerializedDataVersion = 4;
    AccessibleContext accessibleContext = null;
    transient AppContext appContext = AppContext.getAppContext();

    public static class AWTTreeLock {
    }

    public enum BaselineResizeBehavior {
        CONSTANT_ASCENT,
        CONSTANT_DESCENT,
        CENTER_OFFSET,
        OTHER
    }

    public class BltBufferStrategy extends BufferStrategy {
        protected VolatileImage[] backBuffers;
        protected BufferCapabilities caps;
        protected int height;
        private Insets insets;
        protected boolean validatedContents;
        protected int width;

        public BltBufferStrategy(int i, BufferCapabilities bufferCapabilities) {
            this.caps = bufferCapabilities;
            createBackBuffers(i - 1);
        }

        @Override // org.apache.poi.java.awt.image.BufferStrategy
        public boolean contentsLost() {
            VolatileImage[] volatileImageArr = this.backBuffers;
            if (volatileImageArr == null) {
                return false;
            }
            return volatileImageArr[volatileImageArr.length - 1].contentsLost();
        }

        @Override // org.apache.poi.java.awt.image.BufferStrategy
        public boolean contentsRestored() {
            return this.validatedContents;
        }

        public void createBackBuffers(int i) {
            if (i == 0) {
                this.backBuffers = null;
                return;
            }
            this.width = Component.this.getWidth();
            this.height = Component.this.getHeight();
            Insets insets_NoClientCode = Component.this.getInsets_NoClientCode();
            this.insets = insets_NoClientCode;
            int i2 = (this.width - insets_NoClientCode.left) - insets_NoClientCode.right;
            int i4 = (this.height - insets_NoClientCode.top) - insets_NoClientCode.bottom;
            int iMax = Math.max(1, i2);
            int iMax2 = Math.max(1, i4);
            if (this.backBuffers == null) {
                this.backBuffers = new VolatileImage[i];
            } else {
                for (int i5 = 0; i5 < i; i5++) {
                    VolatileImage volatileImage = this.backBuffers[i5];
                    if (volatileImage != null) {
                        volatileImage.flush();
                        this.backBuffers[i5] = null;
                    }
                }
            }
            for (int i6 = 0; i6 < i; i6++) {
                this.backBuffers[i6] = Component.this.createVolatileImage(iMax, iMax2);
            }
        }

        @Override // org.apache.poi.java.awt.image.BufferStrategy
        public void dispose() {
            VolatileImage[] volatileImageArr = this.backBuffers;
            if (volatileImageArr != null) {
                for (int length = volatileImageArr.length - 1; length >= 0; length--) {
                    VolatileImage volatileImage = this.backBuffers[length];
                    if (volatileImage != null) {
                        volatileImage.flush();
                        this.backBuffers[length] = null;
                    }
                }
            }
            Component component = Component.this;
            if (component.bufferStrategy == this) {
                component.bufferStrategy = null;
            }
        }

        public Image getBackBuffer() {
            Image[] imageArr = this.backBuffers;
            if (imageArr != null) {
                return imageArr[imageArr.length - 1];
            }
            return null;
        }

        @Override // org.apache.poi.java.awt.image.BufferStrategy
        public BufferCapabilities getCapabilities() {
            return this.caps;
        }

        @Override // org.apache.poi.java.awt.image.BufferStrategy
        public Graphics getDrawGraphics() {
            revalidate();
            Image backBuffer = getBackBuffer();
            if (backBuffer == null) {
                return Component.this.getGraphics();
            }
            SunGraphics2D graphics = backBuffer.getGraphics();
            Insets insets = this.insets;
            graphics.constrain(-insets.left, -insets.top, backBuffer.getWidth(null) + this.insets.left, backBuffer.getHeight(null) + this.insets.top);
            return graphics;
        }

        public void revalidate() {
            revalidate(true);
        }

        @Override // org.apache.poi.java.awt.image.BufferStrategy
        public void show() throws Throwable {
            Insets insets = this.insets;
            showSubRegion(insets.left, insets.top, this.width - insets.right, this.height - insets.bottom);
        }

        public void showSubRegion(int i, int i2, int i4, int i5) throws Throwable {
            Throwable th;
            int i6;
            Graphics graphics;
            if (this.backBuffers == null) {
                return;
            }
            Insets insets = this.insets;
            int i7 = insets.left;
            int i8 = i - i7;
            int i9 = i4 - i7;
            int i10 = insets.top;
            int i11 = i2 - i10;
            int i12 = i5 - i10;
            Graphics graphics_NoClientCode = Component.this.getGraphics_NoClientCode();
            if (graphics_NoClientCode == null) {
                return;
            }
            try {
                Insets insets2 = this.insets;
                graphics_NoClientCode.translate(insets2.left, insets2.top);
                i6 = 0;
                graphics = graphics_NoClientCode;
            } catch (Throwable th2) {
                th = th2;
            }
            while (true) {
                try {
                    Image[] imageArr = this.backBuffers;
                    if (i6 >= imageArr.length) {
                        break;
                    }
                    graphics.drawImage(imageArr[i6], i8, i11, i9, i12, i8, i11, i9, i12, null);
                    graphics.dispose();
                    graphics_NoClientCode = null;
                    graphics = this.backBuffers[i6].getGraphics();
                    i6++;
                } catch (Throwable th3) {
                    th = th3;
                    graphics_NoClientCode = graphics;
                }
                if (graphics_NoClientCode == null) {
                    throw th;
                }
                graphics_NoClientCode.dispose();
                throw th;
            }
            if (graphics != null) {
                graphics.dispose();
            }
        }

        public void revalidate(boolean z) {
            this.validatedContents = false;
            if (this.backBuffers == null) {
                return;
            }
            if (z) {
                Insets insets_NoClientCode = Component.this.getInsets_NoClientCode();
                if (Component.this.getWidth() != this.width || Component.this.getHeight() != this.height || !insets_NoClientCode.equals(this.insets)) {
                    createBackBuffers(this.backBuffers.length);
                    this.validatedContents = true;
                }
            }
            GraphicsConfiguration graphicsConfiguration_NoClientCode = Component.this.getGraphicsConfiguration_NoClientCode();
            VolatileImage[] volatileImageArr = this.backBuffers;
            int iValidate = volatileImageArr[volatileImageArr.length - 1].validate(graphicsConfiguration_NoClientCode);
            if (iValidate != 2) {
                if (iValidate == 1) {
                    this.validatedContents = true;
                }
            } else {
                if (z) {
                    createBackBuffers(this.backBuffers.length);
                    VolatileImage[] volatileImageArr2 = this.backBuffers;
                    volatileImageArr2[volatileImageArr2.length - 1].validate(graphicsConfiguration_NoClientCode);
                }
                this.validatedContents = true;
            }
        }
    }

    public class BltSubRegionBufferStrategy extends BltBufferStrategy implements SubRegionShowable {
        public BltSubRegionBufferStrategy(int i, BufferCapabilities bufferCapabilities) {
            super(i, bufferCapabilities);
        }

        public void show(int i, int i2, int i4, int i5) throws Throwable {
            showSubRegion(i, i2, i4, i5);
        }

        public boolean showIfNotLost(int i, int i2, int i4, int i5) throws Throwable {
            if (contentsLost()) {
                return false;
            }
            showSubRegion(i, i2, i4, i5);
            return !contentsLost();
        }
    }

    public static class DummyRequestFocusController implements RequestFocusController {
        private DummyRequestFocusController() {
        }

        public boolean acceptRequestFocus(Component component, Component component2, boolean z, boolean z2, CausedFocusEvent.Cause cause) {
            return true;
        }
    }

    public class FlipBufferStrategy extends BufferStrategy {
        protected BufferCapabilities caps;
        protected Image drawBuffer;
        protected VolatileImage drawVBuffer;
        int height;
        protected int numBuffers;
        protected boolean validatedContents;
        int width;

        public FlipBufferStrategy(int i, BufferCapabilities bufferCapabilities) {
            if (!(Component.this instanceof Window) && !(Component.this instanceof Canvas)) {
                throw new ClassCastException("Component must be a Canvas or Window");
            }
            this.numBuffers = i;
            this.caps = bufferCapabilities;
            createBuffers(i, bufferCapabilities);
        }

        private void updateInternalBuffers() {
            this.drawBuffer = getBackBuffer();
            this.drawVBuffer = null;
        }

        @Override // org.apache.poi.java.awt.image.BufferStrategy
        public boolean contentsLost() {
            VolatileImage volatileImage = this.drawVBuffer;
            if (volatileImage == null) {
                return false;
            }
            return volatileImage.contentsLost();
        }

        @Override // org.apache.poi.java.awt.image.BufferStrategy
        public boolean contentsRestored() {
            return this.validatedContents;
        }

        public void createBuffers(int i, BufferCapabilities bufferCapabilities) {
            if (i < 2) {
                throw new IllegalArgumentException("Number of buffers cannot be less than two");
            }
            if (Component.this.peer == null) {
                throw new IllegalStateException("Component must have a valid peer");
            }
            if (bufferCapabilities == null || !bufferCapabilities.isPageFlipping()) {
                throw new IllegalArgumentException("Page flipping capabilities must be specified");
            }
            this.width = Component.this.getWidth();
            this.height = Component.this.getHeight();
            if (this.drawBuffer != null) {
                this.drawBuffer = null;
                this.drawVBuffer = null;
                destroyBuffers();
            }
            Component.this.peer.createBuffers(i, bufferCapabilities);
            updateInternalBuffers();
        }

        public void destroyBuffers() {
            VSyncedBSManager.releaseVsync(this);
            ComponentPeer componentPeer = Component.this.peer;
            if (componentPeer == null) {
                throw new IllegalStateException("Component must have a valid peer");
            }
            componentPeer.destroyBuffers();
        }

        @Override // org.apache.poi.java.awt.image.BufferStrategy
        public void dispose() {
            Component component = Component.this;
            if (component.bufferStrategy == this) {
                component.bufferStrategy = null;
                if (component.peer != null) {
                    destroyBuffers();
                }
            }
        }

        public void flip(BufferCapabilities.FlipContents flipContents) {
            if (Component.this.peer == null) {
                throw new IllegalStateException("Component must have a valid peer");
            }
            Image backBuffer = getBackBuffer();
            if (backBuffer != null) {
                Component.this.peer.flip(0, 0, backBuffer.getWidth(null), backBuffer.getHeight(null), flipContents);
            }
        }

        public void flipSubRegion(int i, int i2, int i4, int i5, BufferCapabilities.FlipContents flipContents) {
            ComponentPeer componentPeer = Component.this.peer;
            if (componentPeer == null) {
                throw new IllegalStateException("Component must have a valid peer");
            }
            componentPeer.flip(i, i2, i4, i5, flipContents);
        }

        public Image getBackBuffer() {
            ComponentPeer componentPeer = Component.this.peer;
            if (componentPeer != null) {
                return componentPeer.getBackBuffer();
            }
            throw new IllegalStateException("Component must have a valid peer");
        }

        @Override // org.apache.poi.java.awt.image.BufferStrategy
        public BufferCapabilities getCapabilities() {
            return this.caps;
        }

        @Override // org.apache.poi.java.awt.image.BufferStrategy
        public Graphics getDrawGraphics() {
            revalidate();
            return this.drawBuffer.getGraphics();
        }

        public void revalidate() {
            revalidate(true);
        }

        @Override // org.apache.poi.java.awt.image.BufferStrategy
        public void show() {
            flip(this.caps.getFlipContents());
        }

        public void showSubRegion(int i, int i2, int i4, int i5) {
            flipSubRegion(i, i2, i4, i5, this.caps.getFlipContents());
        }

        public void revalidate(boolean z) {
            this.validatedContents = false;
            if (z && (Component.this.getWidth() != this.width || Component.this.getHeight() != this.height)) {
                try {
                    createBuffers(this.numBuffers, this.caps);
                } catch (AWTException unused) {
                }
                this.validatedContents = true;
            }
            updateInternalBuffers();
            if (this.drawVBuffer != null) {
                GraphicsConfiguration graphicsConfiguration_NoClientCode = Component.this.getGraphicsConfiguration_NoClientCode();
                int iValidate = this.drawVBuffer.validate(graphicsConfiguration_NoClientCode);
                if (iValidate == 2) {
                    try {
                        createBuffers(this.numBuffers, this.caps);
                    } catch (AWTException unused2) {
                    }
                    VolatileImage volatileImage = this.drawVBuffer;
                    if (volatileImage != null) {
                        volatileImage.validate(graphicsConfiguration_NoClientCode);
                    }
                } else if (iValidate != 1) {
                    return;
                }
                this.validatedContents = true;
            }
        }
    }

    public class FlipSubRegionBufferStrategy extends FlipBufferStrategy implements SubRegionShowable {
        public FlipSubRegionBufferStrategy(int i, BufferCapabilities bufferCapabilities) {
            super(i, bufferCapabilities);
        }

        public void show(int i, int i2, int i4, int i5) {
            showSubRegion(i, i2, i4, i5);
        }

        public boolean showIfNotLost(int i, int i2, int i4, int i5) {
            if (contentsLost()) {
                return false;
            }
            showSubRegion(i, i2, i4, i5);
            return !contentsLost();
        }
    }

    public class ProxyCapabilities extends ExtendedBufferCapabilities {
        private BufferCapabilities orig;

        /* JADX WARN: Illegal instructions before constructor call */
        private ProxyCapabilities(BufferCapabilities bufferCapabilities) {
            ImageCapabilities frontBufferCapabilities = bufferCapabilities.getFrontBufferCapabilities();
            ImageCapabilities backBufferCapabilities = bufferCapabilities.getBackBufferCapabilities();
            BufferCapabilities.FlipContents flipContents = bufferCapabilities.getFlipContents();
            BufferCapabilities.FlipContents flipContents2 = BufferCapabilities.FlipContents.BACKGROUND;
            super(frontBufferCapabilities, backBufferCapabilities, flipContents != flipContents2 ? BufferCapabilities.FlipContents.COPIED : flipContents2);
            this.orig = bufferCapabilities;
        }
    }

    static {
        Toolkit.loadLibraries();
        if (!GraphicsEnvironment.isHeadless()) {
            initIDs();
        }
        String str = (String) AccessController.doPrivileged(new GetPropertyAction("awt.image.incrementaldraw"));
        isInc = str == null || str.equals("true");
        String str2 = (String) AccessController.doPrivileged(new GetPropertyAction("awt.image.redrawrate"));
        incRate = str2 != null ? Integer.parseInt(str2) : 100;
        AWTAccessor.setComponentAccessor(new AWTAccessor.ComponentAccessor() { // from class: org.apache.poi.java.awt.Component.1
            @Override // org.apache.poi.sun.awt.AWTAccessor.ComponentAccessor
            public boolean canBeFocusOwner(Component component) {
                return component.canBeFocusOwner();
            }

            @Override // org.apache.poi.sun.awt.AWTAccessor.ComponentAccessor
            public AccessControlContext getAccessControlContext(Component component) {
                return component.getAccessControlContext();
            }

            @Override // org.apache.poi.sun.awt.AWTAccessor.ComponentAccessor
            public AppContext getAppContext(Component component) {
                return component.appContext;
            }

            @Override // org.apache.poi.sun.awt.AWTAccessor.ComponentAccessor
            public Color getBackground(Component component) {
                return component.background;
            }

            @Override // org.apache.poi.sun.awt.AWTAccessor.ComponentAccessor
            public boolean getBackgroundEraseDisabled(Component component) {
                return component.backgroundEraseDisabled;
            }

            @Override // org.apache.poi.sun.awt.AWTAccessor.ComponentAccessor
            public Rectangle getBounds(Component component) {
                return new Rectangle(component.f10034x, component.f10035y, component.width, component.height);
            }

            @Override // org.apache.poi.sun.awt.AWTAccessor.ComponentAccessor
            public Cursor getCursor(Component component) {
                return component.getCursor_NoClientCode();
            }

            @Override // org.apache.poi.sun.awt.AWTAccessor.ComponentAccessor
            public Font getFont(Component component) {
                return component.getFont_NoClientCode();
            }

            @Override // org.apache.poi.sun.awt.AWTAccessor.ComponentAccessor
            public Color getForeground(Component component) {
                return component.foreground;
            }

            @Override // org.apache.poi.sun.awt.AWTAccessor.ComponentAccessor
            public int getHeight(Component component) {
                return component.height;
            }

            @Override // org.apache.poi.sun.awt.AWTAccessor.ComponentAccessor
            public boolean getIgnoreRepaint(Component component) {
                return component.ignoreRepaint;
            }

            @Override // org.apache.poi.sun.awt.AWTAccessor.ComponentAccessor
            public Point getLocation(Component component) {
                return component.location_NoClientCode();
            }

            @Override // org.apache.poi.sun.awt.AWTAccessor.ComponentAccessor
            public Container getParent(Component component) {
                return component.getParent_NoClientCode();
            }

            @Override // org.apache.poi.sun.awt.AWTAccessor.ComponentAccessor
            public ComponentPeer getPeer(Component component) {
                return component.peer;
            }

            @Override // org.apache.poi.sun.awt.AWTAccessor.ComponentAccessor
            public int getWidth(Component component) {
                return component.width;
            }

            @Override // org.apache.poi.sun.awt.AWTAccessor.ComponentAccessor
            public int getX(Component component) {
                return component.f10034x;
            }

            @Override // org.apache.poi.sun.awt.AWTAccessor.ComponentAccessor
            public int getY(Component component) {
                return component.f10035y;
            }

            @Override // org.apache.poi.sun.awt.AWTAccessor.ComponentAccessor
            public boolean isDisplayable(Component component) {
                return component.peer != null;
            }

            @Override // org.apache.poi.sun.awt.AWTAccessor.ComponentAccessor
            public boolean isEnabled(Component component) {
                return component.isEnabledImpl();
            }

            @Override // org.apache.poi.sun.awt.AWTAccessor.ComponentAccessor
            public boolean isLightweight(Component component) {
                return component.peer instanceof LightweightPeer;
            }

            @Override // org.apache.poi.sun.awt.AWTAccessor.ComponentAccessor
            public boolean isVisible(Component component) {
                return component.isVisible_NoClientCode();
            }

            @Override // org.apache.poi.sun.awt.AWTAccessor.ComponentAccessor
            public void processEvent(Component component, AWTEvent aWTEvent) {
                component.processEvent(aWTEvent);
            }

            @Override // org.apache.poi.sun.awt.AWTAccessor.ComponentAccessor
            public boolean requestFocus(Component component, CausedFocusEvent.Cause cause) {
                return component.requestFocus(cause);
            }

            @Override // org.apache.poi.sun.awt.AWTAccessor.ComponentAccessor
            public void revalidateSynchronously(Component component) {
                component.revalidateSynchronously();
            }

            @Override // org.apache.poi.sun.awt.AWTAccessor.ComponentAccessor
            public void setAppContext(Component component, AppContext appContext) {
                component.appContext = appContext;
            }

            @Override // org.apache.poi.sun.awt.AWTAccessor.ComponentAccessor
            public void setBackground(Component component, Color color) {
                component.background = color;
            }

            @Override // org.apache.poi.sun.awt.AWTAccessor.ComponentAccessor
            public void setBackgroundEraseDisabled(Component component, boolean z) {
                component.backgroundEraseDisabled = z;
            }

            @Override // org.apache.poi.sun.awt.AWTAccessor.ComponentAccessor
            public void setGraphicsConfiguration(Component component, GraphicsConfiguration graphicsConfiguration) {
                component.setGraphicsConfiguration(graphicsConfiguration);
            }

            @Override // org.apache.poi.sun.awt.AWTAccessor.ComponentAccessor
            public void setLocation(Component component, int i, int i2) {
                component.f10034x = i;
                component.f10035y = i2;
            }

            @Override // org.apache.poi.sun.awt.AWTAccessor.ComponentAccessor
            public void setMixingCutoutShape(Component component, Shape shape) {
                Region region = shape != null ? Region.getInstance(shape, (AffineTransform) null) : null;
                synchronized (component.getTreeLock()) {
                    try {
                        boolean zIsNonOpaqueForMixing = component.isNonOpaqueForMixing();
                        component.mixingCutoutRegion = region;
                        boolean zIsNonOpaqueForMixing2 = component.isNonOpaqueForMixing();
                        if (component.isMixingNeeded()) {
                            if (!zIsNonOpaqueForMixing) {
                                component.mixOnHiding(component.isLightweight());
                            }
                            if (!zIsNonOpaqueForMixing2) {
                                component.mixOnShowing();
                            }
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            }

            @Override // org.apache.poi.sun.awt.AWTAccessor.ComponentAccessor
            public void setParent(Component component, Container container) {
                component.parent = container;
            }

            @Override // org.apache.poi.sun.awt.AWTAccessor.ComponentAccessor
            public void setPeer(Component component, ComponentPeer componentPeer) {
                component.peer = componentPeer;
            }

            @Override // org.apache.poi.sun.awt.AWTAccessor.ComponentAccessor
            public void setRequestFocusController(RequestFocusController requestFocusController2) {
                Component.setRequestFocusController(requestFocusController2);
            }

            @Override // org.apache.poi.sun.awt.AWTAccessor.ComponentAccessor
            public void setSize(Component component, int i, int i2) {
                component.width = i;
                component.height = i2;
            }
        });
        coalesceMap = new WeakHashMap();
        coalesceEventsParams = new Class[]{AWTEvent.class, AWTEvent.class};
        requestFocusController = new DummyRequestFocusController();
    }

    private final void applyCurrentShapeBelowMe() {
        checkTreeLock();
        Container container = getContainer();
        if (container == null || !container.isShowing()) {
            return;
        }
        container.recursiveApplyCurrentShape(getSiblingIndexBelow());
        Container container2 = container.getContainer();
        while (!container.isOpaque() && container2 != null) {
            container2.recursiveApplyCurrentShape(container.getSiblingIndexBelow());
            Container container3 = container2;
            container2 = container2.getContainer();
            container = container3;
        }
    }

    private Region calculateCurrentShape() {
        checkTreeLock();
        Region normalShape = getNormalShape();
        PlatformLogger platformLogger = mixingLog;
        if (platformLogger.isLoggable(500)) {
            platformLogger.fine("this = " + this + "; normalShape=" + normalShape);
        }
        if (getContainer() != null) {
            Component component = this;
            for (Container container = getContainer(); container != null; container = container.getContainer()) {
                for (int siblingIndexAbove = component.getSiblingIndexAbove(); siblingIndexAbove != -1; siblingIndexAbove--) {
                    Component component2 = container.getComponent(siblingIndexAbove);
                    if (component2.isLightweight() && component2.isShowing()) {
                        normalShape = normalShape.getDifference(component2.getOpaqueShape());
                    }
                }
                if (!container.isLightweight()) {
                    break;
                }
                normalShape = normalShape.getIntersection(container.getNormalShape());
                component = container;
            }
        }
        PlatformLogger platformLogger2 = mixingLog;
        if (platformLogger2.isLoggable(500)) {
            platformLogger2.fine("currentShape=" + normalShape);
        }
        return normalShape;
    }

    private boolean checkCoalescing() {
        boolean zBooleanValue;
        if (getClass().getClassLoader() == null) {
            return false;
        }
        final Class<?> cls = getClass();
        Map<Class<?>, Boolean> map = coalesceMap;
        synchronized (map) {
            try {
                Boolean bool = map.get(cls);
                if (bool == null) {
                    bool = (Boolean) AccessController.doPrivileged(new PrivilegedAction<Boolean>() { // from class: org.apache.poi.java.awt.Component.3
                        /* JADX WARN: Can't rename method to resolve collision */
                        @Override // java.security.PrivilegedAction
                        public Boolean run() {
                            return Boolean.valueOf(Component.isCoalesceEventsOverriden(cls));
                        }
                    });
                    map.put(cls, bool);
                }
                zBooleanValue = bool.booleanValue();
            } catch (Throwable th) {
                throw th;
            }
        }
        return zBooleanValue;
    }

    private void doSwingSerialization() {
        Package r02 = Package.getPackage("javax.swing");
        for (final Class<?> superclass = getClass(); superclass != null; superclass = superclass.getSuperclass()) {
            if (superclass.getPackage() == r02 && superclass.getClassLoader() == null) {
                Method[] methodArr = (Method[]) AccessController.doPrivileged(new PrivilegedAction() { // from class: org.apache.poi.java.awt.Component.4
                    @Override // java.security.PrivilegedAction
                    public Object run() {
                        return superclass.getDeclaredMethods();
                    }
                });
                for (int length = methodArr.length - 1; length >= 0; length--) {
                    final Method method = methodArr[length];
                    if (method.getName().equals("compWriteObjectNotify")) {
                        AccessController.doPrivileged(new PrivilegedAction() { // from class: org.apache.poi.java.awt.Component.5
                            @Override // java.security.PrivilegedAction
                            public Object run() {
                                method.setAccessible(true);
                                return null;
                            }
                        });
                        try {
                            method.invoke(this, null);
                            return;
                        } catch (IllegalAccessException | InvocationTargetException unused) {
                            return;
                        }
                    }
                }
            }
        }
    }

    private Region getAppliedShape() {
        checkTreeLock();
        return (this.compoundShape == null || isLightweight()) ? getNormalShape() : this.compoundShape;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Insets getInsets_NoClientCode() {
        ContainerPeer containerPeer = this.peer;
        return containerPeer instanceof ContainerPeer ? (Insets) containerPeer.getInsets().clone() : new Insets(0, 0, 0, 0);
    }

    private static native void initIDs();

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean isCoalesceEventsOverriden(Class<?> cls) {
        Class<? super Object> superclass = cls.getSuperclass();
        if (superclass == null) {
            return false;
        }
        if (superclass.getClassLoader() != null) {
            Map<Class<?>, Boolean> map = coalesceMap;
            Boolean bool = map.get(superclass);
            if (bool == null) {
                if (isCoalesceEventsOverriden(superclass)) {
                    map.put(superclass, Boolean.TRUE);
                    return true;
                }
            } else if (bool.booleanValue()) {
                return true;
            }
        }
        try {
            cls.getDeclaredMethod("coalesceEvents", coalesceEventsParams);
            return true;
        } catch (NoSuchMethodException unused) {
            return false;
        }
    }

    public static boolean isInstanceOf(Object obj, String str) {
        if (obj == null || str == null) {
            return false;
        }
        for (Class<?> superclass = obj.getClass(); superclass != null; superclass = superclass.getSuperclass()) {
            if (superclass.getName().equals(str)) {
                return true;
            }
        }
        return false;
    }

    private boolean isRequestFocusAccepted(boolean z, boolean z2, CausedFocusEvent.Cause cause) {
        if (!isFocusable() || !isVisible()) {
            PlatformLogger platformLogger = focusLog;
            if (platformLogger.isLoggable(300)) {
                platformLogger.finest("Not focusable or not visible");
            }
            return false;
        }
        if (this.peer == null) {
            PlatformLogger platformLogger2 = focusLog;
            if (platformLogger2.isLoggable(300)) {
                platformLogger2.finest("peer is null");
            }
            return false;
        }
        Window containingWindow = getContainingWindow();
        if (containingWindow == null || !containingWindow.isFocusableWindow()) {
            PlatformLogger platformLogger3 = focusLog;
            if (platformLogger3.isLoggable(300)) {
                platformLogger3.finest("Component doesn't have toplevel");
            }
            return false;
        }
        Component mostRecentFocusOwner = KeyboardFocusManager.getMostRecentFocusOwner(containingWindow);
        if (mostRecentFocusOwner == null && (mostRecentFocusOwner = KeyboardFocusManager.getCurrentKeyboardFocusManager().getFocusOwner()) != null && mostRecentFocusOwner.getContainingWindow() != containingWindow) {
            mostRecentFocusOwner = null;
        }
        Component component = mostRecentFocusOwner;
        if (component == this || component == null) {
            PlatformLogger platformLogger4 = focusLog;
            if (platformLogger4.isLoggable(300)) {
                platformLogger4.finest("focus owner is null or this");
            }
            return true;
        }
        if (CausedFocusEvent.Cause.ACTIVATION == cause) {
            PlatformLogger platformLogger5 = focusLog;
            if (platformLogger5.isLoggable(300)) {
                platformLogger5.finest("cause is activation");
            }
            return true;
        }
        boolean zAcceptRequestFocus = requestFocusController.acceptRequestFocus(component, this, z, z2, cause);
        PlatformLogger platformLogger6 = focusLog;
        if (platformLogger6.isLoggable(300)) {
            platformLogger6.finest("RequestFocusController returns {0}", new Object[]{Boolean.valueOf(zAcceptRequestFocus)});
        }
        return zAcceptRequestFocus;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Point location_NoClientCode() {
        return new Point(this.f10034x, this.f10035y);
    }

    private void notifyNewBounds(boolean z, boolean z2) {
        if (this.componentListener != null || (this.eventMask & 1) != 0 || Toolkit.enabledOnToolkit(1L)) {
            if (z) {
                Toolkit.getEventQueue().postEvent(new ComponentEvent(this, 101));
            }
            if (z2) {
                Toolkit.getEventQueue().postEvent(new ComponentEvent(this, 100));
                return;
            }
            return;
        }
        if (this instanceof Container) {
            Container container = (Container) this;
            if (container.countComponents() > 0) {
                boolean zEnabledOnToolkit = Toolkit.enabledOnToolkit(65536L);
                if (z) {
                    container.createChildHierarchyEvents(1402, 0L, zEnabledOnToolkit);
                }
                if (z2) {
                    container.createChildHierarchyEvents(1401, 0L, zEnabledOnToolkit);
                }
            }
        }
    }

    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        Object object;
        this.objectLock = new Object();
        this.acc = AccessController.getContext();
        objectInputStream.defaultReadObject();
        this.appContext = AppContext.getAppContext();
        this.coalescingEnabled = checkCoalescing();
        if (this.componentSerializedDataVersion < 4) {
            this.focusable = true;
            this.isFocusTraversableOverridden = 0;
            initializeFocusTraversalKeys();
            this.focusTraversalKeysEnabled = true;
        }
        while (true) {
            Object object2 = objectInputStream.readObject();
            if (object2 != null) {
                String strIntern = ((String) object2).intern();
                if (componentListenerK == strIntern) {
                    addComponentListener((ComponentListener) objectInputStream.readObject());
                } else if (focusListenerK == strIntern) {
                    addFocusListener((FocusListener) objectInputStream.readObject());
                } else if (keyListenerK == strIntern) {
                    addKeyListener((KeyListener) objectInputStream.readObject());
                } else if (mouseListenerK == strIntern) {
                    addMouseListener((MouseListener) objectInputStream.readObject());
                } else if (mouseMotionListenerK == strIntern) {
                    addMouseMotionListener((MouseMotionListener) objectInputStream.readObject());
                } else if (inputMethodListenerK == strIntern) {
                    addInputMethodListener((InputMethodListener) objectInputStream.readObject());
                } else {
                    objectInputStream.readObject();
                }
            } else {
                try {
                    break;
                } catch (OptionalDataException e) {
                    if (!e.eof) {
                        throw e;
                    }
                    object = null;
                }
            }
        }
        object = objectInputStream.readObject();
        this.componentOrientation = object != null ? (ComponentOrientation) object : ComponentOrientation.UNKNOWN;
        while (true) {
            try {
                Object object3 = objectInputStream.readObject();
                if (object3 != null) {
                    String strIntern2 = ((String) object3).intern();
                    if (hierarchyListenerK == strIntern2) {
                        HierarchyListener hierarchyListener = (HierarchyListener) objectInputStream.readObject();
                        addHierarchyListener(hierarchyListener);
                    } else if (hierarchyBoundsListenerK == strIntern2) {
                        HierarchyBoundsListener hierarchyBoundsListener = (HierarchyBoundsListener) objectInputStream.readObject();
                        addHierarchyBoundsListener(hierarchyBoundsListener);
                    } else {
                        objectInputStream.readObject();
                    }
                }
            } catch (OptionalDataException e2) {
                if (!e2.eof) {
                    throw e2;
                }
            }
            break;
        }
        while (true) {
            try {
                Object object4 = objectInputStream.readObject();
                if (object4 == null) {
                    break;
                }
                if (mouseWheelListenerK == ((String) object4).intern()) {
                    MouseWheelListener mouseWheelListener = (MouseWheelListener) objectInputStream.readObject();
                    addMouseWheelListener(mouseWheelListener);
                } else {
                    objectInputStream.readObject();
                }
            } catch (OptionalDataException e3) {
                if (!e3.eof) {
                    throw e3;
                }
            }
        }
        Vector vector = this.popups;
        if (vector != null) {
            int size = vector.size();
            for (int i = 0; i < size; i++) {
                ((PopupMenu) this.popups.elementAt(i)).parent = this;
            }
        }
    }

    private void repaintParentIfNeeded(int i, int i2, int i4, int i5) {
        if (this.parent != null && (this.peer instanceof LightweightPeer) && isShowing()) {
            this.parent.repaint(i, i2, i4, i5);
            repaint();
        }
    }

    private void reshapeNativePeer(int i, int i2, int i4, int i5, int i6) {
        int i7 = i;
        int i8 = i2;
        for (Container container = this.parent; container != null && (container.peer instanceof LightweightPeer); container = container.parent) {
            i7 += container.f10034x;
            i8 += container.f10035y;
        }
        this.peer.setBounds(i7, i8, i4, i5, i6);
    }

    public static synchronized void setRequestFocusController(RequestFocusController requestFocusController2) {
        if (requestFocusController2 == null) {
            requestFocusController2 = new DummyRequestFocusController();
            requestFocusController = requestFocusController2;
        } else {
            requestFocusController = requestFocusController2;
        }
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        doSwingSerialization();
        objectOutputStream.defaultWriteObject();
        AWTEventMulticaster.save(objectOutputStream, componentListenerK, this.componentListener);
        AWTEventMulticaster.save(objectOutputStream, focusListenerK, this.focusListener);
        AWTEventMulticaster.save(objectOutputStream, keyListenerK, this.keyListener);
        AWTEventMulticaster.save(objectOutputStream, mouseListenerK, this.mouseListener);
        AWTEventMulticaster.save(objectOutputStream, mouseMotionListenerK, this.mouseMotionListener);
        AWTEventMulticaster.save(objectOutputStream, inputMethodListenerK, this.inputMethodListener);
        objectOutputStream.writeObject(null);
        objectOutputStream.writeObject(this.componentOrientation);
        AWTEventMulticaster.save(objectOutputStream, hierarchyListenerK, this.hierarchyListener);
        AWTEventMulticaster.save(objectOutputStream, hierarchyBoundsListenerK, this.hierarchyBoundsListener);
        objectOutputStream.writeObject(null);
        AWTEventMulticaster.save(objectOutputStream, mouseWheelListenerK, this.mouseWheelListener);
        objectOutputStream.writeObject(null);
    }

    @Deprecated
    public boolean action(Event event, Object obj) {
        return false;
    }

    public void add(PopupMenu popupMenu) {
        synchronized (getTreeLock()) {
            try {
                MenuContainer menuContainer = popupMenu.parent;
                if (menuContainer != null) {
                    menuContainer.remove(popupMenu);
                }
                if (this.popups == null) {
                    this.popups = new Vector();
                }
                this.popups.addElement(popupMenu);
                popupMenu.parent = this;
                if (this.peer != null && popupMenu.peer == null) {
                    popupMenu.addNotify();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public synchronized void addComponentListener(ComponentListener componentListener) {
        if (componentListener == null) {
            return;
        }
        this.componentListener = AWTEventMulticaster.add(this.componentListener, componentListener);
        this.newEventsOnly = true;
    }

    public synchronized void addFocusListener(FocusListener focusListener) {
        if (focusListener == null) {
            return;
        }
        this.focusListener = AWTEventMulticaster.add(this.focusListener, focusListener);
        this.newEventsOnly = true;
        if (this.peer instanceof LightweightPeer) {
            this.parent.proxyEnableEvents(4L);
        }
    }

    public void addHierarchyBoundsListener(HierarchyBoundsListener hierarchyBoundsListener) {
        boolean z;
        if (hierarchyBoundsListener == null) {
            return;
        }
        synchronized (this) {
            try {
                HierarchyBoundsListener hierarchyBoundsListener2 = this.hierarchyBoundsListener;
                z = false;
                boolean z2 = hierarchyBoundsListener2 == null && (this.eventMask & 65536) == 0;
                HierarchyBoundsListener hierarchyBoundsListenerAdd = AWTEventMulticaster.add(hierarchyBoundsListener2, hierarchyBoundsListener);
                this.hierarchyBoundsListener = hierarchyBoundsListenerAdd;
                if (z2 && hierarchyBoundsListenerAdd != null) {
                    z = true;
                }
                this.newEventsOnly = true;
            } catch (Throwable th) {
                throw th;
            }
        }
        if (z) {
            synchronized (getTreeLock()) {
                adjustListeningChildrenOnParent(65536L, 1);
            }
        }
    }

    public void addHierarchyListener(HierarchyListener hierarchyListener) {
        boolean z;
        if (hierarchyListener == null) {
            return;
        }
        synchronized (this) {
            try {
                HierarchyListener hierarchyListener2 = this.hierarchyListener;
                z = false;
                boolean z2 = hierarchyListener2 == null && (this.eventMask & 32768) == 0;
                HierarchyListener hierarchyListenerAdd = AWTEventMulticaster.add(hierarchyListener2, hierarchyListener);
                this.hierarchyListener = hierarchyListenerAdd;
                if (z2 && hierarchyListenerAdd != null) {
                    z = true;
                }
                this.newEventsOnly = true;
            } catch (Throwable th) {
                throw th;
            }
        }
        if (z) {
            synchronized (getTreeLock()) {
                adjustListeningChildrenOnParent(32768L, 1);
            }
        }
    }

    public synchronized void addInputMethodListener(InputMethodListener inputMethodListener) {
        if (inputMethodListener == null) {
            return;
        }
        this.inputMethodListener = AWTEventMulticaster.add(this.inputMethodListener, inputMethodListener);
        this.newEventsOnly = true;
    }

    public synchronized void addKeyListener(KeyListener keyListener) {
        if (keyListener == null) {
            return;
        }
        this.keyListener = AWTEventMulticaster.add(this.keyListener, keyListener);
        this.newEventsOnly = true;
        if (this.peer instanceof LightweightPeer) {
            this.parent.proxyEnableEvents(8L);
        }
    }

    public synchronized void addMouseListener(MouseListener mouseListener) {
        if (mouseListener == null) {
            return;
        }
        this.mouseListener = AWTEventMulticaster.add(this.mouseListener, mouseListener);
        this.newEventsOnly = true;
        if (this.peer instanceof LightweightPeer) {
            this.parent.proxyEnableEvents(16L);
        }
    }

    public synchronized void addMouseMotionListener(MouseMotionListener mouseMotionListener) {
        if (mouseMotionListener == null) {
            return;
        }
        this.mouseMotionListener = AWTEventMulticaster.add(this.mouseMotionListener, mouseMotionListener);
        this.newEventsOnly = true;
        if (this.peer instanceof LightweightPeer) {
            this.parent.proxyEnableEvents(32L);
        }
    }

    public synchronized void addMouseWheelListener(MouseWheelListener mouseWheelListener) {
        if (mouseWheelListener == null) {
            return;
        }
        this.mouseWheelListener = AWTEventMulticaster.add(this.mouseWheelListener, mouseWheelListener);
        this.newEventsOnly = true;
        if (this.peer instanceof LightweightPeer) {
            this.parent.proxyEnableEvents(131072L);
        }
    }

    public void addNotify() throws Throwable {
        synchronized (getTreeLock()) {
            try {
                try {
                    ComponentPeer componentPeerCreateComponent = this.peer;
                    if (componentPeerCreateComponent == null || (componentPeerCreateComponent instanceof LightweightPeer)) {
                        if (componentPeerCreateComponent == null) {
                            componentPeerCreateComponent = getToolkit().createComponent(this);
                            this.peer = componentPeerCreateComponent;
                        }
                        Container container = this.parent;
                        if (container != null) {
                            long j = 16;
                            if (this.mouseListener == null && (this.eventMask & 16) == 0) {
                                j = 0;
                            }
                            if (this.mouseMotionListener != null || (this.eventMask & 32) != 0) {
                                j |= 32;
                            }
                            if (this.mouseWheelListener != null || (this.eventMask & 131072) != 0) {
                                j |= 131072;
                            }
                            if (this.focusListener != null || (this.eventMask & 4) != 0) {
                                j |= 4;
                            }
                            if (this.keyListener != null || (this.eventMask & 8) != 0) {
                                j |= 8;
                            }
                            if (j != 0) {
                                container.proxyEnableEvents(j);
                            }
                        }
                    } else {
                        Container container2 = getContainer();
                        if (container2 != null && container2.isLightweight()) {
                            relocateComponent();
                            if (!container2.isRecursivelyVisibleUpToHeavyweightContainer()) {
                                componentPeerCreateComponent.setVisible(false);
                            }
                        }
                    }
                    invalidate();
                    Vector vector = this.popups;
                    int size = vector != null ? vector.size() : 0;
                    for (int i = 0; i < size; i++) {
                        ((PopupMenu) this.popups.elementAt(i)).addNotify();
                    }
                    DropTarget dropTarget = this.dropTarget;
                    if (dropTarget != null) {
                        dropTarget.addNotify(componentPeerCreateComponent);
                    }
                    this.peerFont = getFont();
                    if (getContainer() != null && !this.isAddNotifyComplete) {
                        getContainer().increaseComponentCount(this);
                    }
                    updateZOrder();
                    if (!this.isAddNotifyComplete) {
                        mixOnShowing();
                    }
                    this.isAddNotifyComplete = true;
                    if (this.hierarchyListener != null || (this.eventMask & 32768) != 0 || Toolkit.enabledOnToolkit(32768L)) {
                        Container container3 = this.parent;
                        int i2 = isRecursivelyVisible() ? 4 : 0;
                        dispatchEvent(new HierarchyEvent(this, 1400, this, container3, i2 | 2));
                    }
                } catch (Throwable th) {
                    th = th;
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                throw th;
            }
        }
    }

    public void addPropertyChangeListener(PropertyChangeListener propertyChangeListener) {
        synchronized (getObjectLock()) {
            if (propertyChangeListener != null) {
                try {
                    if (this.changeSupport == null) {
                        this.changeSupport = new PropertyChangeSupport(this);
                    }
                    this.changeSupport.addPropertyChangeListener(propertyChangeListener);
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    public void adjustListeningChildrenOnParent(long j, int i) {
        Container container = this.parent;
        if (container != null) {
            container.adjustListeningChildren(j, i);
        }
    }

    public void applyComponentOrientation(ComponentOrientation componentOrientation) {
        componentOrientation.getClass();
        setComponentOrientation(componentOrientation);
    }

    public void applyCompoundShape(Region region) {
        ComponentPeer peer;
        checkTreeLock();
        if (!areBoundsValid()) {
            PlatformLogger platformLogger = mixingLog;
            if (platformLogger.isLoggable(500)) {
                platformLogger.fine("this = " + this + "; areBoundsValid = " + areBoundsValid());
                return;
            }
            return;
        }
        if (isLightweight() || (peer = getPeer()) == null) {
            return;
        }
        if (region.isEmpty()) {
            region = Region.EMPTY_REGION;
        }
        if (region.equals(getNormalShape())) {
            if (this.compoundShape == null) {
                return;
            }
            this.compoundShape = null;
            peer.applyShape((Region) null);
            return;
        }
        if (region.equals(getAppliedShape())) {
            return;
        }
        this.compoundShape = region;
        Point locationOnWindow = getLocationOnWindow();
        PlatformLogger platformLogger2 = mixingLog;
        if (platformLogger2.isLoggable(400)) {
            platformLogger2.fine("this = " + this + "; compAbsolute=" + locationOnWindow + "; shape=" + region);
        }
        peer.applyShape(region.getTranslatedRegion(-locationOnWindow.f10092x, -locationOnWindow.f10093y));
    }

    public void applyCurrentShape() {
        checkTreeLock();
        if (areBoundsValid()) {
            PlatformLogger platformLogger = mixingLog;
            if (platformLogger.isLoggable(500)) {
                platformLogger.fine("this = " + this);
            }
            applyCompoundShape(calculateCurrentShape());
            return;
        }
        PlatformLogger platformLogger2 = mixingLog;
        if (platformLogger2.isLoggable(500)) {
            platformLogger2.fine("this = " + this + "; areBoundsValid = " + areBoundsValid());
        }
    }

    public final boolean areBoundsValid() {
        Container container = getContainer();
        return container == null || container.isValid() || container.getLayout() == null;
    }

    public boolean areFocusTraversalKeysSet(int i) {
        if (i < 0 || i >= 3) {
            throw new IllegalArgumentException("invalid focus traversal key identifier");
        }
        Set[] setArr = this.focusTraversalKeys;
        return (setArr == null || setArr[i] == null) ? false : true;
    }

    public boolean areInputMethodsEnabled() {
        long j = this.eventMask;
        if ((4096 & j) != 0) {
            return ((j & 8) == 0 && this.keyListener == null) ? false : true;
        }
        return false;
    }

    @Deprecated
    public Rectangle bounds() {
        return new Rectangle(this.f10034x, this.f10035y, this.width, this.height);
    }

    public final boolean canBeFocusOwner() {
        return isEnabled() && isDisplayable() && isVisible() && isFocusable();
    }

    public final boolean canBeFocusOwnerRecursively() {
        if (!canBeFocusOwner()) {
            return false;
        }
        synchronized (getTreeLock()) {
            try {
                Container container = this.parent;
                if (container == null) {
                    return true;
                }
                return container.canContainFocusOwner(this);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void checkGD(String str) {
        GraphicsConfiguration graphicsConfiguration = this.graphicsConfig;
        if (graphicsConfiguration != null && !graphicsConfiguration.getDevice().getIDstring().equals(str)) {
            throw new IllegalArgumentException("adding a container to a container on a different GraphicsDevice");
        }
    }

    public int checkImage(Image image, int i, int i2, ImageObserver imageObserver) {
        ComponentPeer componentPeer = this.peer;
        if (componentPeer instanceof LightweightPeer) {
            Container container = this.parent;
            if (container != null) {
                return container.checkImage(image, i, i2, imageObserver);
            }
        } else if (componentPeer != null) {
            return componentPeer.checkImage(image, i, i2, imageObserver);
        }
        return getToolkit().checkImage(image, i, i2, imageObserver);
    }

    public final void checkTreeLock() {
        if (!Thread.holdsLock(getTreeLock())) {
            throw new IllegalStateException("This function should be called while holding treeLock");
        }
    }

    public boolean checkWindowClosingException() {
        RuntimeException runtimeException = this.windowClosingException;
        if (runtimeException == null) {
            return false;
        }
        if (this instanceof Dialog) {
            ((Dialog) this).interruptBlocking();
            return true;
        }
        runtimeException.fillInStackTrace();
        this.windowClosingException.printStackTrace();
        this.windowClosingException = null;
        return true;
    }

    public void clearMostRecentFocusOwnerOnHide() {
        KeyboardFocusManager.clearMostRecentFocusOwner(this);
    }

    public AWTEvent coalesceEvents(AWTEvent aWTEvent, AWTEvent aWTEvent2) {
        return null;
    }

    public String constructComponentName() {
        return null;
    }

    public boolean contains(int i, int i2) {
        return inside(i, i2);
    }

    public boolean containsFocus() {
        return isFocusOwner();
    }

    public int countHierarchyMembers() {
        return 1;
    }

    public void createBufferStrategy(int i) {
        if (i > 1) {
            try {
                createBufferStrategy(i, new BufferCapabilities(new ImageCapabilities(true), new ImageCapabilities(true), BufferCapabilities.FlipContents.UNDEFINED));
                return;
            } catch (AWTException unused) {
            }
        }
        try {
            createBufferStrategy(i, new BufferCapabilities(new ImageCapabilities(true), new ImageCapabilities(true), null));
        } catch (AWTException unused2) {
            try {
                createBufferStrategy(i, new BufferCapabilities(new ImageCapabilities(false), new ImageCapabilities(false), null));
            } catch (AWTException unused3) {
                throw new InternalError("Could not create a buffer strategy");
            }
        }
    }

    public int createHierarchyEvents(int i, Component component, Container container, long j, boolean z) {
        switch (i) {
            case 1400:
                if (this.hierarchyListener == null && (this.eventMask & 32768) == 0 && !z) {
                    return 0;
                }
                dispatchEvent(new HierarchyEvent(this, i, component, container, j));
                return 1;
            case 1401:
            case 1402:
                PlatformLogger platformLogger = eventLog;
                if (platformLogger.isLoggable(500) && j != 0) {
                    platformLogger.fine("Assertion (changeFlags == 0) failed");
                }
                if (this.hierarchyBoundsListener == null && (this.eventMask & 65536) == 0 && !z) {
                    return 0;
                }
                dispatchEvent(new HierarchyEvent(this, i, component, container));
                return 1;
            default:
                PlatformLogger platformLogger2 = eventLog;
                if (!platformLogger2.isLoggable(500)) {
                    return 0;
                }
                platformLogger2.fine("This code must never be reached");
                return 0;
        }
    }

    public Image createImage(int i, int i2) {
        ComponentPeer componentPeer = this.peer;
        if (!(componentPeer instanceof LightweightPeer)) {
            if (componentPeer != null) {
                return componentPeer.createImage(i, i2);
            }
            return null;
        }
        Container container = this.parent;
        if (container != null) {
            return container.createImage(i, i2);
        }
        return null;
    }

    public VolatileImage createVolatileImage(int i, int i2) {
        ComponentPeer componentPeer = this.peer;
        if (!(componentPeer instanceof LightweightPeer)) {
            if (componentPeer != null) {
                return componentPeer.createVolatileImage(i, i2);
            }
            return null;
        }
        Container container = this.parent;
        if (container != null) {
            return container.createVolatileImage(i, i2);
        }
        return null;
    }

    @Deprecated
    public void deliverEvent(Event event) {
        postEvent(event);
    }

    @Deprecated
    public void disable() {
        if (this.enabled) {
            KeyboardFocusManager.clearMostRecentFocusOwner(this);
            synchronized (getTreeLock()) {
                try {
                    this.enabled = false;
                    if (isFocusOwner() || (containsFocus() && !isLightweight())) {
                        if (KeyboardFocusManager.isAutoFocusTransferEnabled()) {
                            transferFocus(false);
                        }
                    }
                    ComponentPeer componentPeer = this.peer;
                    if (componentPeer != null) {
                        componentPeer.setEnabled(false);
                        if (this.visible) {
                            updateCursorImmediately();
                        }
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            AccessibleContext accessibleContext = this.accessibleContext;
            if (accessibleContext != null) {
                accessibleContext.firePropertyChange("AccessibleState", (Object) null, AccessibleState.ENABLED);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x001a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void disableEvents(long j) {
        long j2;
        synchronized (this) {
            j2 = 32768;
            if ((j & 32768) != 0) {
                try {
                    if (this.hierarchyListener != null || (this.eventMask & 32768) == 0) {
                        j2 = 0;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            if ((j & 65536) != 0 && this.hierarchyBoundsListener == null && (this.eventMask & 65536) != 0) {
                j2 |= 65536;
            }
            this.eventMask = (~j) & this.eventMask;
        }
        if (j2 != 0) {
            synchronized (getTreeLock()) {
                adjustListeningChildrenOnParent(j2, -1);
            }
        }
    }

    public final void dispatchEvent(AWTEvent aWTEvent) {
        dispatchEventImpl(aWTEvent);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void dispatchEventImpl(AWTEvent aWTEvent) {
        InputContext inputContext;
        ComponentPeer componentPeer;
        int id = aWTEvent.getID();
        AppContext appContext = this.appContext;
        if (appContext != null && !appContext.equals(AppContext.getAppContext())) {
            PlatformLogger platformLogger = eventLog;
            if (platformLogger.isLoggable(500)) {
                platformLogger.fine("Event " + aWTEvent + " is being dispatched on the wrong AppContext");
            }
        }
        PlatformLogger platformLogger2 = eventLog;
        if (platformLogger2.isLoggable(300)) {
            platformLogger2.finest("{0}", new Object[]{aWTEvent});
        }
        EventQueue.setCurrentEventAndMostRecentTime(aWTEvent);
        if (!aWTEvent.focusManagerIsDispatching) {
            if (aWTEvent.isPosted) {
                aWTEvent = KeyboardFocusManager.retargetFocusEvent(aWTEvent);
                aWTEvent.isPosted = true;
            }
            if (KeyboardFocusManager.getCurrentKeyboardFocusManager().dispatchEvent(aWTEvent)) {
                return;
            }
        }
        if (id != 507 || eventTypeEnabled(id) || (componentPeer = this.peer) == null || componentPeer.handlesWheelScrolling() || !dispatchMouseWheelToAncestor((MouseWheelEvent) aWTEvent)) {
            Toolkit defaultToolkit = Toolkit.getDefaultToolkit();
            defaultToolkit.notifyAWTEventListeners(aWTEvent);
            aWTEvent.isConsumed();
            if (!areInputMethodsEnabled() && id == 1004 && (inputContext = getInputContext()) != null && (inputContext instanceof InputContext)) {
                inputContext.disableNativeIM();
            }
            if (id != 201) {
                if (id == 401 || id == 402) {
                    Container container = (Container) (this instanceof Container ? this : this.parent);
                    if (container != null) {
                        container.preProcessKeyEvent((KeyEvent) aWTEvent);
                        if (aWTEvent.isConsumed()) {
                            PlatformLogger platformLogger3 = focusLog;
                            if (platformLogger3.isLoggable(300)) {
                                platformLogger3.finest("Pre-process consumed event");
                                return;
                            }
                            return;
                        }
                    }
                }
            } else if (defaultToolkit instanceof WindowClosingListener) {
                this.windowClosingException = ((WindowClosingListener) defaultToolkit).windowClosingNotify((WindowEvent) aWTEvent);
                if (checkWindowClosingException()) {
                    return;
                }
            }
            if (!this.newEventsOnly) {
                if (id != 507) {
                    Event eventConvertToOld = aWTEvent.convertToOld();
                    if (eventConvertToOld != null) {
                        int i = eventConvertToOld.key;
                        int i2 = eventConvertToOld.modifiers;
                        postEvent(eventConvertToOld);
                        if (eventConvertToOld.isConsumed()) {
                            aWTEvent.consume();
                        }
                        switch (eventConvertToOld.f10046id) {
                            case 401:
                            case 402:
                            case 403:
                            case 404:
                                if (eventConvertToOld.key != i) {
                                    ((KeyEvent) aWTEvent).setKeyChar(eventConvertToOld.getKeyEventChar());
                                }
                                int i4 = eventConvertToOld.modifiers;
                                if (i4 != i2) {
                                    ((KeyEvent) aWTEvent).setModifiers(i4);
                                }
                                break;
                        }
                    }
                } else {
                    autoProcessMouseWheel((MouseWheelEvent) aWTEvent);
                }
            } else if (eventEnabled(aWTEvent)) {
                processEvent(aWTEvent);
            }
            if (id == 201 && !aWTEvent.isConsumed() && (defaultToolkit instanceof WindowClosingListener)) {
                this.windowClosingException = ((WindowClosingListener) defaultToolkit).windowClosingDelivered((WindowEvent) aWTEvent);
                if (checkWindowClosingException()) {
                    return;
                }
            }
            ComponentPeer componentPeer2 = this.peer;
            if (componentPeer2 != null) {
                componentPeer2.handleEvent(aWTEvent);
            }
        }
    }

    public boolean dispatchMouseWheelToAncestor(MouseWheelEvent mouseWheelEvent) {
        int x = getX() + mouseWheelEvent.getX();
        int y2 = getY() + mouseWheelEvent.getY();
        PlatformLogger platformLogger = eventLog;
        if (platformLogger.isLoggable(300)) {
            platformLogger.finest("dispatchMouseWheelToAncestor");
            platformLogger.finest("orig event src is of " + mouseWheelEvent.getSource().getClass());
        }
        synchronized (getTreeLock()) {
            try {
                Container parent = getParent();
                while (parent != null && !parent.eventEnabled(mouseWheelEvent)) {
                    x += parent.getX();
                    y2 += parent.getY();
                    if (parent instanceof Window) {
                        break;
                    }
                    parent = parent.getParent();
                }
                int i = x;
                int i2 = y2;
                PlatformLogger platformLogger2 = eventLog;
                if (platformLogger2.isLoggable(300)) {
                    platformLogger2.finest("new event src is " + parent.getClass());
                }
                if (parent == null || !parent.eventEnabled(mouseWheelEvent)) {
                    return false;
                }
                MouseWheelEvent mouseWheelEvent2 = new MouseWheelEvent(parent, mouseWheelEvent.getID(), mouseWheelEvent.getWhen(), mouseWheelEvent.getModifiers(), i, i2, mouseWheelEvent.getXOnScreen(), mouseWheelEvent.getYOnScreen(), mouseWheelEvent.getClickCount(), mouseWheelEvent.isPopupTrigger(), mouseWheelEvent.getScrollType(), mouseWheelEvent.getScrollAmount(), mouseWheelEvent.getWheelRotation(), mouseWheelEvent.getPreciseWheelRotation());
                mouseWheelEvent.copyPrivateDataInto(mouseWheelEvent2);
                parent.dispatchEventToSelf(mouseWheelEvent2);
                if (mouseWheelEvent2.isConsumed()) {
                    mouseWheelEvent.consume();
                }
                return true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void doLayout() {
        layout();
    }

    @Deprecated
    public void enable() {
        if (this.enabled) {
            return;
        }
        synchronized (getTreeLock()) {
            try {
                this.enabled = true;
                ComponentPeer componentPeer = this.peer;
                if (componentPeer != null) {
                    componentPeer.setEnabled(true);
                    if (this.visible) {
                        updateCursorImmediately();
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        AccessibleContext accessibleContext = this.accessibleContext;
        if (accessibleContext != null) {
            accessibleContext.firePropertyChange("AccessibleState", (Object) null, AccessibleState.ENABLED);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x001a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void enableEvents(long j) {
        long j2;
        long j3;
        synchronized (this) {
            j2 = 32768;
            if ((j & 32768) != 0) {
                try {
                    if (this.hierarchyListener != null || (this.eventMask & 32768) != 0) {
                        j2 = 0;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            if ((j & 65536) != 0 && this.hierarchyBoundsListener == null && (this.eventMask & 65536) == 0) {
                j2 |= 65536;
            }
            j3 = j | this.eventMask;
            this.eventMask = j3;
            this.newEventsOnly = true;
        }
        if (this.peer instanceof LightweightPeer) {
            this.parent.proxyEnableEvents(j3);
        }
        if (j2 != 0) {
            synchronized (getTreeLock()) {
                adjustListeningChildrenOnParent(j2, 1);
            }
        }
    }

    public void enableInputMethods(boolean z) {
        long j;
        org.apache.poi.java.awt.im.InputContext inputContext;
        org.apache.poi.java.awt.im.InputContext inputContext2;
        long j2 = this.eventMask;
        if (!z) {
            if ((4096 & j2) != 0 && (inputContext = getInputContext()) != null) {
                inputContext.endComposition();
                inputContext.removeNotify(this);
            }
            j = this.eventMask & (-4097);
        } else {
            if ((j2 & 4096) != 0) {
                return;
            }
            if (isFocusOwner() && (inputContext2 = getInputContext()) != null) {
                inputContext2.dispatchEvent(new FocusEvent(this, 1004));
            }
            j = this.eventMask | 4096;
        }
        this.eventMask = j;
    }

    public boolean eventEnabled(AWTEvent aWTEvent) {
        return eventTypeEnabled(aWTEvent.f10031id);
    }

    public boolean eventTypeEnabled(int i) {
        if (i != 601) {
            if (i != 701) {
                if (i != 900) {
                    if (i != 1001) {
                        if (i != 1004 && i != 1005) {
                            if (i != 1100 && i != 1101) {
                                switch (i) {
                                    case 100:
                                    case 101:
                                    case 102:
                                    case 103:
                                        if ((this.eventMask & 1) != 0 || this.componentListener != null) {
                                            return true;
                                        }
                                        break;
                                    default:
                                        switch (i) {
                                            case 400:
                                            case 401:
                                            case 402:
                                                if ((this.eventMask & 8) != 0 || this.keyListener != null) {
                                                    return true;
                                                }
                                                break;
                                            default:
                                                switch (i) {
                                                    case 500:
                                                    case 501:
                                                    case 502:
                                                    case 504:
                                                    case 505:
                                                        if ((this.eventMask & 16) != 0 || this.mouseListener != null) {
                                                            return true;
                                                        }
                                                        break;
                                                    case 503:
                                                    case 506:
                                                        if ((this.eventMask & 32) != 0 || this.mouseMotionListener != null) {
                                                            return true;
                                                        }
                                                        break;
                                                    case 507:
                                                        if ((this.eventMask & 131072) != 0 || this.mouseWheelListener != null) {
                                                            return true;
                                                        }
                                                        break;
                                                    default:
                                                        switch (i) {
                                                            case 1400:
                                                                if ((this.eventMask & 32768) != 0 || this.hierarchyListener != null) {
                                                                    return true;
                                                                }
                                                                break;
                                                            case 1401:
                                                            case 1402:
                                                                if ((this.eventMask & 65536) != 0 || this.hierarchyBoundsListener != null) {
                                                                    return true;
                                                                }
                                                                break;
                                                        }
                                                        break;
                                                }
                                                break;
                                        }
                                        break;
                                }
                            } else if ((this.eventMask & 2048) != 0 || this.inputMethodListener != null) {
                                return true;
                            }
                        } else if ((this.eventMask & 4) != 0 || this.focusListener != null) {
                            return true;
                        }
                    } else if ((this.eventMask & 128) != 0) {
                        return true;
                    }
                } else if ((this.eventMask & 1024) != 0) {
                    return true;
                }
            } else if ((this.eventMask & 512) != 0) {
                return true;
            }
        } else if ((this.eventMask & 256) != 0) {
            return true;
        }
        return i > 1999;
    }

    public Component findUnderMouseInWindow(PointerInfo pointerInfo) {
        if (!isShowing()) {
            return null;
        }
        Window containingWindow = getContainingWindow();
        if (!Toolkit.getDefaultToolkit().getMouseInfoPeer().isWindowUnderMouse(containingWindow)) {
            return null;
        }
        Point pointPointRelativeToComponent = containingWindow.pointRelativeToComponent(pointerInfo.getLocation());
        return containingWindow.findComponentAt(pointPointRelativeToComponent.f10092x, pointPointRelativeToComponent.f10093y, true);
    }

    public void firePropertyChange(String str, byte b, byte b5) {
        if (this.changeSupport == null || b == b5) {
            return;
        }
        firePropertyChange(str, Byte.valueOf(b), Byte.valueOf(b5));
    }

    public final AccessControlContext getAccessControlContext() {
        if (this.acc != null) {
            return this.acc;
        }
        throw new SecurityException("Component is missing AccessControlContext");
    }

    public AccessibleContext getAccessibleContext() {
        return this.accessibleContext;
    }

    public int getAccessibleIndexInParent() {
        synchronized (getTreeLock()) {
            try {
                Container parent = getParent();
                if (parent != null && (parent instanceof Accessible)) {
                    int i = -1;
                    for (Component component : parent.getComponents()) {
                        if (component instanceof Accessible) {
                            i++;
                        }
                        if (equals(component)) {
                            return i;
                        }
                    }
                }
                return -1;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public AccessibleStateSet getAccessibleStateSet() {
        AccessibleStateSet accessibleStateSet;
        AccessibleContext accessibleContext;
        Accessible accessibleParent;
        AccessibleContext accessibleContext2;
        AccessibleSelection accessibleSelection;
        synchronized (getTreeLock()) {
            try {
                accessibleStateSet = new AccessibleStateSet();
                if (isEnabled()) {
                    accessibleStateSet.add(AccessibleState.ENABLED);
                }
                if (isFocusTraversable()) {
                    accessibleStateSet.add(AccessibleState.FOCUSABLE);
                }
                if (isVisible()) {
                    accessibleStateSet.add(AccessibleState.VISIBLE);
                }
                if (isShowing()) {
                    accessibleStateSet.add(AccessibleState.SHOWING);
                }
                if (isFocusOwner()) {
                    accessibleStateSet.add(AccessibleState.FOCUSED);
                }
                if ((this instanceof Accessible) && (accessibleContext = ((Accessible) this).getAccessibleContext()) != null && (accessibleParent = accessibleContext.getAccessibleParent()) != null && (accessibleContext2 = accessibleParent.getAccessibleContext()) != null && (accessibleSelection = accessibleContext2.getAccessibleSelection()) != null) {
                    accessibleStateSet.add(AccessibleState.SELECTABLE);
                    int accessibleIndexInParent = accessibleContext.getAccessibleIndexInParent();
                    if (accessibleIndexInParent >= 0 && accessibleSelection.isAccessibleChildSelected(accessibleIndexInParent)) {
                        accessibleStateSet.add(AccessibleState.SELECTED);
                    }
                }
                if (isInstanceOf(this, "javax.swing.JComponent") && ((JComponent) this).isOpaque()) {
                    accessibleStateSet.add(AccessibleState.OPAQUE);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return accessibleStateSet;
    }

    public float getAlignmentX() {
        return 0.5f;
    }

    public float getAlignmentY() {
        return 0.5f;
    }

    public Image getBackBuffer() {
        BufferStrategy bufferStrategy = this.bufferStrategy;
        if (bufferStrategy == null) {
            return null;
        }
        if (bufferStrategy instanceof BltBufferStrategy) {
            return ((BltBufferStrategy) bufferStrategy).getBackBuffer();
        }
        if (bufferStrategy instanceof FlipBufferStrategy) {
            return ((FlipBufferStrategy) bufferStrategy).getBackBuffer();
        }
        return null;
    }

    @Transient
    public Color getBackground() {
        Color color = this.background;
        if (color != null) {
            return color;
        }
        Container container = this.parent;
        if (container != null) {
            return container.getBackground();
        }
        return null;
    }

    public int getBaseline(int i, int i2) {
        if (i < 0 || i2 < 0) {
            throw new IllegalArgumentException("Width and height must be >= 0");
        }
        return -1;
    }

    public BaselineResizeBehavior getBaselineResizeBehavior() {
        return BaselineResizeBehavior.OTHER;
    }

    public Rectangle getBounds() {
        return bounds();
    }

    public int getBoundsOp() {
        return this.boundsOp;
    }

    public BufferStrategy getBufferStrategy() {
        return this.bufferStrategy;
    }

    public ColorModel getColorModel() {
        ComponentPeer componentPeer = this.peer;
        return (componentPeer == null || (componentPeer instanceof LightweightPeer)) ? GraphicsEnvironment.isHeadless() ? ColorModel.getRGBdefault() : getToolkit().getColorModel() : componentPeer.getColorModel();
    }

    public Component getComponentAt(int i, int i2) {
        return locate(i, i2);
    }

    public synchronized ComponentListener[] getComponentListeners() {
        return getListeners(ComponentListener.class);
    }

    public ComponentOrientation getComponentOrientation() {
        return this.componentOrientation;
    }

    public Container getContainer() {
        return getParent();
    }

    public Window getContainingWindow() {
        return SunToolkit.getContainingWindow(this);
    }

    public Cursor getCursor() {
        return getCursor_NoClientCode();
    }

    public final Cursor getCursor_NoClientCode() {
        Cursor cursor = this.cursor;
        if (cursor != null) {
            return cursor;
        }
        Container container = this.parent;
        return container != null ? container.getCursor_NoClientCode() : Cursor.getPredefinedCursor(0);
    }

    public synchronized DropTarget getDropTarget() {
        return this.dropTarget;
    }

    public Container getFocusCycleRootAncestor() {
        Container container = this.parent;
        while (container != null && !container.isFocusCycleRoot()) {
            container = container.parent;
        }
        return container;
    }

    public synchronized FocusListener[] getFocusListeners() {
        return getListeners(FocusListener.class);
    }

    public Set<AWTKeyStroke> getFocusTraversalKeys(int i) {
        if (i < 0 || i >= 3) {
            throw new IllegalArgumentException("invalid focus traversal key identifier");
        }
        return getFocusTraversalKeys_NoIDCheck(i);
    }

    public boolean getFocusTraversalKeysEnabled() {
        return this.focusTraversalKeysEnabled;
    }

    public final Set getFocusTraversalKeys_NoIDCheck(int i) {
        Set[] setArr = this.focusTraversalKeys;
        Set set = setArr != null ? setArr[i] : null;
        if (set != null) {
            return set;
        }
        Container container = this.parent;
        return container != null ? container.getFocusTraversalKeys(i) : KeyboardFocusManager.getCurrentKeyboardFocusManager().getDefaultFocusTraversalKeys(i);
    }

    @Override // org.apache.poi.java.awt.MenuContainer
    @Transient
    public Font getFont() {
        return getFont_NoClientCode();
    }

    public FontMetrics getFontMetrics(Font font) {
        ComponentPeer componentPeer;
        SunFontManager fontManagerFactory = FontManagerFactory.getInstance();
        return (!(fontManagerFactory instanceof SunFontManager) || !fontManagerFactory.usePlatformFontMetrics() || (componentPeer = this.peer) == null || (componentPeer instanceof LightweightPeer)) ? FontDesignMetrics.getMetrics(font) : componentPeer.getFontMetrics(font);
    }

    public final Font getFont_NoClientCode() {
        Font font = this.font;
        if (font != null) {
            return font;
        }
        Container container = this.parent;
        if (container != null) {
            return container.getFont_NoClientCode();
        }
        return null;
    }

    @Transient
    public Color getForeground() {
        Color color = this.foreground;
        if (color != null) {
            return color;
        }
        Container container = this.parent;
        if (container != null) {
            return container.getForeground();
        }
        return null;
    }

    public Graphics getGraphics() {
        Graphics graphics;
        ComponentPeer componentPeer = this.peer;
        if (!(componentPeer instanceof LightweightPeer)) {
            if (componentPeer != null) {
                return componentPeer.getGraphics();
            }
            return null;
        }
        Container container = this.parent;
        if (container == null || (graphics = container.getGraphics()) == null) {
            return null;
        }
        graphics.translate(this.f10034x, this.f10035y);
        graphics.setClip(0, 0, this.width, this.height);
        graphics.setFont(getFont());
        return graphics;
    }

    public GraphicsConfiguration getGraphicsConfiguration() {
        GraphicsConfiguration graphicsConfiguration_NoClientCode;
        synchronized (getTreeLock()) {
            graphicsConfiguration_NoClientCode = getGraphicsConfiguration_NoClientCode();
        }
        return graphicsConfiguration_NoClientCode;
    }

    public final GraphicsConfiguration getGraphicsConfiguration_NoClientCode() {
        return this.graphicsConfig;
    }

    public final Graphics getGraphics_NoClientCode() {
        Graphics graphics_NoClientCode;
        ComponentPeer componentPeer = this.peer;
        if (!(componentPeer instanceof LightweightPeer)) {
            if (componentPeer != null) {
                return componentPeer.getGraphics();
            }
            return null;
        }
        Container container = this.parent;
        if (container == null || (graphics_NoClientCode = container.getGraphics_NoClientCode()) == null) {
            return null;
        }
        graphics_NoClientCode.translate(this.f10034x, this.f10035y);
        graphics_NoClientCode.setClip(0, 0, this.width, this.height);
        graphics_NoClientCode.setFont(getFont_NoClientCode());
        return graphics_NoClientCode;
    }

    public final ComponentPeer getHWPeerAboveMe() {
        checkTreeLock();
        int siblingIndexAbove = getSiblingIndexAbove();
        for (Container container = getContainer(); container != null; container = container.getContainer()) {
            while (siblingIndexAbove > -1) {
                Component component = container.getComponent(siblingIndexAbove);
                if (component != null && component.isDisplayable() && !component.isLightweight()) {
                    return component.getPeer();
                }
                siblingIndexAbove--;
            }
            if (!container.isLightweight()) {
                return null;
            }
            siblingIndexAbove = container.getSiblingIndexAbove();
        }
        return null;
    }

    public int getHeight() {
        return this.height;
    }

    public synchronized HierarchyBoundsListener[] getHierarchyBoundsListeners() {
        return getListeners(HierarchyBoundsListener.class);
    }

    public synchronized HierarchyListener[] getHierarchyListeners() {
        return getListeners(HierarchyListener.class);
    }

    public boolean getIgnoreRepaint() {
        return this.ignoreRepaint;
    }

    public org.apache.poi.java.awt.im.InputContext getInputContext() {
        Container container = this.parent;
        if (container == null) {
            return null;
        }
        return container.getInputContext();
    }

    public synchronized InputMethodListener[] getInputMethodListeners() {
        return getListeners(InputMethodListener.class);
    }

    public InputMethodRequests getInputMethodRequests() {
        return null;
    }

    public synchronized KeyListener[] getKeyListeners() {
        return getListeners(KeyListener.class);
    }

    public <T extends EventListener> T[] getListeners(Class<T> cls) {
        ComponentListener componentListener;
        if (cls == ComponentListener.class) {
            componentListener = this.componentListener;
        } else if (cls == FocusListener.class) {
            componentListener = this.focusListener;
        } else if (cls == HierarchyListener.class) {
            componentListener = this.hierarchyListener;
        } else if (cls == HierarchyBoundsListener.class) {
            componentListener = this.hierarchyBoundsListener;
        } else if (cls == KeyListener.class) {
            componentListener = this.keyListener;
        } else if (cls == MouseListener.class) {
            componentListener = this.mouseListener;
        } else if (cls == MouseMotionListener.class) {
            componentListener = this.mouseMotionListener;
        } else if (cls == MouseWheelListener.class) {
            componentListener = this.mouseWheelListener;
        } else if (cls == InputMethodListener.class) {
            componentListener = this.inputMethodListener;
        } else {
            if (cls == PropertyChangeListener.class) {
                return getPropertyChangeListeners();
            }
            componentListener = null;
        }
        return (T[]) AWTEventMulticaster.getListeners(componentListener, cls);
    }

    public Locale getLocale() {
        Locale locale = this.locale;
        if (locale != null) {
            return locale;
        }
        Container container = this.parent;
        if (container != null) {
            return container.getLocale();
        }
        throw new IllegalComponentStateException("This component must have a parent in order to determine its locale");
    }

    public Point getLocation() {
        return location();
    }

    public Point getLocationOnScreen() {
        Point locationOnScreen_NoTreeLock;
        synchronized (getTreeLock()) {
            locationOnScreen_NoTreeLock = getLocationOnScreen_NoTreeLock();
        }
        return locationOnScreen_NoTreeLock;
    }

    public final Point getLocationOnScreen_NoTreeLock() {
        if (this.peer == null || !isShowing()) {
            throw new IllegalComponentStateException("component must be showing on the screen to determine its location");
        }
        ComponentPeer componentPeer = this.peer;
        if (!(componentPeer instanceof LightweightPeer)) {
            return componentPeer.getLocationOnScreen();
        }
        Container nativeContainer = getNativeContainer();
        Point locationOnScreen = nativeContainer.peer.getLocationOnScreen();
        for (Component parent = this; parent != nativeContainer; parent = parent.getParent()) {
            locationOnScreen.f10092x += parent.f10034x;
            locationOnScreen.f10093y += parent.f10035y;
        }
        return locationOnScreen;
    }

    public Point getLocationOnWindow() {
        checkTreeLock();
        Point location = getLocation();
        for (Container container = getContainer(); container != null && !(container instanceof Window); container = container.getContainer()) {
            location.f10092x = container.getX() + location.f10092x;
            location.f10093y = container.getY() + location.f10093y;
        }
        return location;
    }

    public Dimension getMaximumSize() {
        return isMaximumSizeSet() ? new Dimension(this.maxSize) : new Dimension(LayoutKt.LargeDimension, LayoutKt.LargeDimension);
    }

    public Dimension getMinimumSize() {
        return minimumSize();
    }

    public synchronized MouseListener[] getMouseListeners() {
        return getListeners(MouseListener.class);
    }

    public synchronized MouseMotionListener[] getMouseMotionListeners() {
        return getListeners(MouseMotionListener.class);
    }

    public Point getMousePosition() {
        if (GraphicsEnvironment.isHeadless()) {
            throw new HeadlessException();
        }
        PointerInfo pointerInfo = (PointerInfo) AccessController.doPrivileged(new PrivilegedAction() { // from class: org.apache.poi.java.awt.Component.2
            @Override // java.security.PrivilegedAction
            public Object run() {
                return MouseInfo.getPointerInfo();
            }
        });
        synchronized (getTreeLock()) {
            try {
                if (!isSameOrAncestorOf(findUnderMouseInWindow(pointerInfo), true)) {
                    return null;
                }
                return pointRelativeToComponent(pointerInfo.getLocation());
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public synchronized MouseWheelListener[] getMouseWheelListeners() {
        return getListeners(MouseWheelListener.class);
    }

    public String getName() {
        if (this.name == null && !this.nameExplicitlySet) {
            synchronized (getObjectLock()) {
                try {
                    if (this.name == null && !this.nameExplicitlySet) {
                        this.name = constructComponentName();
                    }
                } finally {
                }
            }
        }
        return this.name;
    }

    public Container getNativeContainer() {
        Container parent_NoClientCode = this.parent;
        while (parent_NoClientCode != null && (parent_NoClientCode.peer instanceof LightweightPeer)) {
            parent_NoClientCode = parent_NoClientCode.getParent_NoClientCode();
        }
        return parent_NoClientCode;
    }

    public final Component getNextFocusCandidate() {
        throw null;
    }

    public final Region getNormalShape() {
        checkTreeLock();
        Point locationOnWindow = getLocationOnWindow();
        return Region.getInstanceXYWH(locationOnWindow.f10092x, locationOnWindow.f10093y, getWidth(), getHeight());
    }

    public Object getObjectLock() {
        return this.objectLock;
    }

    public Region getOpaqueShape() {
        checkTreeLock();
        Region region = this.mixingCutoutRegion;
        return region != null ? region : getNormalShape();
    }

    public Container getParent() {
        return getParent_NoClientCode();
    }

    public final Container getParent_NoClientCode() {
        return this.parent;
    }

    @Deprecated
    public ComponentPeer getPeer() {
        return this.peer;
    }

    public Dimension getPreferredSize() {
        return preferredSize();
    }

    public PropertyChangeListener[] getPropertyChangeListeners() {
        PropertyChangeListener[] propertyChangeListeners;
        synchronized (getObjectLock()) {
            try {
                PropertyChangeSupport propertyChangeSupport = this.changeSupport;
                propertyChangeListeners = propertyChangeSupport == null ? new PropertyChangeListener[0] : propertyChangeSupport.getPropertyChangeListeners();
            } catch (Throwable th) {
                throw th;
            }
        }
        return propertyChangeListeners;
    }

    public final int getSiblingIndexAbove() {
        int componentZOrder;
        checkTreeLock();
        if (getContainer() != null && r0.getComponentZOrder(this) - 1 >= 0) {
            return componentZOrder;
        }
        return -1;
    }

    public final int getSiblingIndexBelow() {
        int componentZOrder;
        checkTreeLock();
        Container container = getContainer();
        if (container != null && (componentZOrder = container.getComponentZOrder(this) + 1) < container.getComponentCount()) {
            return componentZOrder;
        }
        return -1;
    }

    public Dimension getSize() {
        return size();
    }

    public Toolkit getToolkit() {
        return getToolkitImpl();
    }

    public final Toolkit getToolkitImpl() {
        ComponentPeer componentPeer = this.peer;
        if (componentPeer != null && !(componentPeer instanceof LightweightPeer)) {
            return componentPeer.getToolkit();
        }
        Container container = this.parent;
        return container != null ? container.getToolkitImpl() : Toolkit.getDefaultToolkit();
    }

    public Container getTraversalRoot() {
        return getFocusCycleRootAncestor();
    }

    public final Object getTreeLock() {
        return LOCK;
    }

    public int getWidth() {
        return this.width;
    }

    public int getX() {
        return this.f10034x;
    }

    public int getY() {
        return this.f10035y;
    }

    @Deprecated
    public boolean gotFocus(Event event, Object obj) {
        return false;
    }

    @Deprecated
    public boolean handleEvent(Event event) {
        int i = event.f10046id;
        if (i == 1001) {
            return action(event, event.arg);
        }
        if (i == 1004) {
            return gotFocus(event, event.arg);
        }
        if (i == 1005) {
            return lostFocus(event, event.arg);
        }
        switch (i) {
            case 401:
            case 403:
                return keyDown(event, event.key);
            case 402:
            case 404:
                return keyUp(event, event.key);
            default:
                switch (i) {
                    case 501:
                        return mouseDown(event, event.f10047x, event.f10048y);
                    case 502:
                        return mouseUp(event, event.f10047x, event.f10048y);
                    case 503:
                        return mouseMove(event, event.f10047x, event.f10048y);
                    case 504:
                        return mouseEnter(event, event.f10047x, event.f10048y);
                    case 505:
                        return mouseExit(event, event.f10047x, event.f10048y);
                    case 506:
                        return mouseDrag(event, event.f10047x, event.f10048y);
                    default:
                        return false;
                }
        }
    }

    public boolean hasFocus() {
        return KeyboardFocusManager.getCurrentKeyboardFocusManager().getFocusOwner() == this;
    }

    @Deprecated
    public void hide() throws Throwable {
        Component component;
        this.isPacked = false;
        if (this.visible) {
            clearCurrentFocusCycleRootOnHide();
            clearMostRecentFocusOwnerOnHide();
            synchronized (getTreeLock()) {
                try {
                    try {
                        this.visible = false;
                        mixOnHiding(isLightweight());
                        if (containsFocus() && KeyboardFocusManager.isAutoFocusTransferEnabled()) {
                            transferFocus(true);
                        }
                        ComponentPeer componentPeer = this.peer;
                        if (componentPeer != null) {
                            componentPeer.setVisible(false);
                            component = this;
                            component.createHierarchyEvents(1400, this, this.parent, 4L, Toolkit.enabledOnToolkit(32768L));
                            if (componentPeer instanceof LightweightPeer) {
                                repaint();
                            }
                            updateCursorImmediately();
                        } else {
                            component = this;
                        }
                        if (component.componentListener != null || (component.eventMask & 1) != 0 || Toolkit.enabledOnToolkit(1L)) {
                            Toolkit.getEventQueue().postEvent(new ComponentEvent(this, 103));
                        }
                        Container container = component.parent;
                        if (container != null) {
                            container.invalidate();
                        }
                    } catch (Throwable th) {
                        th = th;
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    throw th;
                }
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:4:0x0005  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean imageUpdate(Image image, int i, int i2, int i4, int i5, int i6) {
        int i7;
        if ((i & 48) == 0) {
            if ((i & 8) == 0 || !isInc) {
                i7 = -1;
            } else {
                i7 = incRate;
                if (i7 < 0) {
                    i7 = 0;
                }
            }
        }
        if (i7 >= 0) {
            repaint(i7, 0, 0, this.width, this.height);
        }
        return (i & 160) == 0;
    }

    public void initializeFocusTraversalKeys() {
        this.focusTraversalKeys = new Set[3];
    }

    @Deprecated
    public boolean inside(int i, int i2) {
        return i >= 0 && i < this.width && i2 >= 0 && i2 < this.height;
    }

    public void invalidate() {
        synchronized (getTreeLock()) {
            try {
                this.valid = false;
                if (!isPreferredSizeSet()) {
                    this.prefSize = null;
                }
                if (!isMinimumSizeSet()) {
                    this.minSize = null;
                }
                if (!isMaximumSizeSet()) {
                    this.maxSize = null;
                }
                invalidateParent();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void invalidateIfValid() {
        if (isValid()) {
            invalidate();
        }
    }

    public void invalidateParent() {
        Container container = this.parent;
        if (container != null) {
            container.invalidateIfValid();
        }
    }

    public boolean isAutoFocusTransferOnDisposal() {
        return this.autoFocusTransferOnDisposal;
    }

    public boolean isBackgroundSet() {
        return this.background != null;
    }

    public final boolean isCoalescingEnabled() {
        return this.coalescingEnabled;
    }

    public boolean isCursorSet() {
        return this.cursor != null;
    }

    public boolean isDisplayable() {
        return getPeer() != null;
    }

    public boolean isDoubleBuffered() {
        return false;
    }

    public boolean isEnabled() {
        return isEnabledImpl();
    }

    public final boolean isEnabledImpl() {
        return this.enabled;
    }

    public boolean isFocusCycleRoot(Container container) {
        return getFocusCycleRootAncestor() == container;
    }

    public boolean isFocusOwner() {
        return hasFocus();
    }

    @Deprecated
    public boolean isFocusTraversable() {
        if (this.isFocusTraversableOverridden == 0) {
            this.isFocusTraversableOverridden = 1;
        }
        return this.focusable;
    }

    public final boolean isFocusTraversableOverridden() {
        return this.isFocusTraversableOverridden != 1;
    }

    public boolean isFocusable() {
        return isFocusTraversable();
    }

    public boolean isFontSet() {
        return this.font != null;
    }

    public boolean isForegroundSet() {
        return this.foreground != null;
    }

    public boolean isLightweight() {
        return getPeer() instanceof LightweightPeer;
    }

    public boolean isMaximumSizeSet() {
        return this.maxSizeSet;
    }

    public boolean isMinimumSizeSet() {
        return this.minSizeSet;
    }

    public final boolean isMixingNeeded() {
        if (SunToolkit.getSunAwtDisableMixing()) {
            PlatformLogger platformLogger = mixingLog;
            if (platformLogger.isLoggable(300)) {
                platformLogger.finest("this = " + this + "; Mixing disabled via sun.awt.disableMixing");
            }
            return false;
        }
        if (!areBoundsValid()) {
            PlatformLogger platformLogger2 = mixingLog;
            if (platformLogger2.isLoggable(500)) {
                platformLogger2.fine("this = " + this + "; areBoundsValid = " + areBoundsValid());
            }
            return false;
        }
        Window containingWindow = getContainingWindow();
        if (containingWindow == null) {
            PlatformLogger platformLogger3 = mixingLog;
            if (platformLogger3.isLoggable(500)) {
                platformLogger3.fine("this = " + this + "; containing window is null");
            }
            return false;
        }
        if (containingWindow.hasHeavyweightDescendants() && containingWindow.hasLightweightDescendants() && !containingWindow.isDisposing()) {
            return true;
        }
        PlatformLogger platformLogger4 = mixingLog;
        if (platformLogger4.isLoggable(500)) {
            platformLogger4.fine("containing window = " + containingWindow + "; has h/w descendants = " + containingWindow.hasHeavyweightDescendants() + "; has l/w descendants = " + containingWindow.hasLightweightDescendants() + "; disposing = " + containingWindow.isDisposing());
        }
        return false;
    }

    public final boolean isNonOpaqueForMixing() {
        Region region = this.mixingCutoutRegion;
        return region != null && region.isEmpty();
    }

    public boolean isOpaque() {
        if (getPeer() == null) {
            return false;
        }
        return !isLightweight();
    }

    public boolean isPreferredSizeSet() {
        return this.prefSizeSet;
    }

    public boolean isRecursivelyVisible() {
        if (!this.visible) {
            return false;
        }
        Container container = this.parent;
        return container == null || container.isRecursivelyVisible();
    }

    public boolean isSameOrAncestorOf(Component component, boolean z) {
        return component == this;
    }

    public boolean isShowing() {
        if (!this.visible || this.peer == null) {
            return false;
        }
        Container container = this.parent;
        return container == null || container.isShowing();
    }

    public boolean isValid() {
        return this.peer != null && this.valid;
    }

    @Transient
    public boolean isVisible() {
        return isVisible_NoClientCode();
    }

    public final boolean isVisible_NoClientCode() {
        return this.visible;
    }

    @Deprecated
    public boolean keyDown(Event event, int i) {
        return false;
    }

    @Deprecated
    public boolean keyUp(Event event, int i) {
        return false;
    }

    public void lightweightPaint(Graphics graphics) {
        paint(graphics);
    }

    public void lightweightPrint(Graphics graphics) {
        print(graphics);
    }

    public void list() {
        list(System.out, 0);
    }

    @Deprecated
    public Component locate(int i, int i2) {
        if (contains(i, i2)) {
            return this;
        }
        return null;
    }

    @Deprecated
    public Point location() {
        return location_NoClientCode();
    }

    @Deprecated
    public boolean lostFocus(Event event, Object obj) {
        return false;
    }

    @Deprecated
    public Dimension minimumSize() {
        Dimension minimumSize;
        Dimension dimension = this.minSize;
        if (dimension == null || (!isMinimumSizeSet() && !isValid())) {
            synchronized (getTreeLock()) {
                try {
                    ComponentPeer componentPeer = this.peer;
                    minimumSize = componentPeer != null ? componentPeer.getMinimumSize() : size();
                    this.minSize = minimumSize;
                } catch (Throwable th) {
                    throw th;
                }
            }
            dimension = minimumSize;
        }
        return new Dimension(dimension);
    }

    public void mixOnHiding(boolean z) {
        synchronized (getTreeLock()) {
            try {
                PlatformLogger platformLogger = mixingLog;
                if (platformLogger.isLoggable(500)) {
                    platformLogger.fine("this = " + this + "; isLightweight = " + z);
                }
                if (isMixingNeeded() && z) {
                    applyCurrentShapeBelowMe();
                }
            } finally {
            }
        }
    }

    public void mixOnReshaping() {
        synchronized (getTreeLock()) {
            try {
                PlatformLogger platformLogger = mixingLog;
                if (platformLogger.isLoggable(500)) {
                    platformLogger.fine("this = " + this);
                }
                if (isMixingNeeded()) {
                    if (isLightweight()) {
                        applyCurrentShapeBelowMe();
                    } else {
                        applyCurrentShape();
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void mixOnShowing() {
        synchronized (getTreeLock()) {
            try {
                PlatformLogger platformLogger = mixingLog;
                if (platformLogger.isLoggable(500)) {
                    platformLogger.fine("this = " + this);
                }
                if (isMixingNeeded()) {
                    if (isLightweight()) {
                        subtractAndApplyShapeBelowMe();
                    } else {
                        applyCurrentShape();
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void mixOnZOrderChanging(int i, int i2) {
        synchronized (getTreeLock()) {
            boolean z = i2 < i;
            try {
                Container container = getContainer();
                PlatformLogger platformLogger = mixingLog;
                if (platformLogger.isLoggable(500)) {
                    platformLogger.fine("this = " + this + "; oldZorder=" + i + "; newZorder=" + i2 + "; parent=" + container);
                }
                if (isMixingNeeded()) {
                    if (isLightweight()) {
                        if (z) {
                            if (container != null && isShowing()) {
                                container.recursiveSubtractAndApplyShape(getOpaqueShape(), getSiblingIndexBelow(), i);
                            }
                        } else if (container != null) {
                            container.recursiveApplyCurrentShape(i, i2);
                        }
                    } else if (z) {
                        applyCurrentShape();
                    } else if (container != null) {
                        Region appliedShape = getAppliedShape();
                        while (i < i2) {
                            Component component = container.getComponent(i);
                            if (component.isLightweight() && component.isShowing()) {
                                appliedShape = appliedShape.getDifference(component.getOpaqueShape());
                            }
                            i++;
                        }
                        applyCompoundShape(appliedShape);
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Deprecated
    public boolean mouseDown(Event event, int i, int i2) {
        return false;
    }

    @Deprecated
    public boolean mouseDrag(Event event, int i, int i2) {
        return false;
    }

    @Deprecated
    public boolean mouseEnter(Event event, int i, int i2) {
        return false;
    }

    @Deprecated
    public boolean mouseExit(Event event, int i, int i2) {
        return false;
    }

    @Deprecated
    public boolean mouseMove(Event event, int i, int i2) {
        return false;
    }

    @Deprecated
    public boolean mouseUp(Event event, int i, int i2) {
        return false;
    }

    @Deprecated
    public void move(int i, int i2) {
        synchronized (getTreeLock()) {
            setBoundsOp(1);
            setBounds(i, i2, this.width, this.height);
        }
    }

    @Deprecated
    public void nextFocus() {
        transferFocus(false);
    }

    public int numListening(long j) {
        PlatformLogger platformLogger = eventLog;
        if (platformLogger.isLoggable(500) && j != 32768 && j != 65536) {
            platformLogger.fine("Assertion failed");
        }
        if (j == 32768 && (this.hierarchyListener != null || (this.eventMask & 32768) != 0)) {
            return 1;
        }
        if (j == 65536) {
            return (this.hierarchyBoundsListener == null && (this.eventMask & 65536) == 0) ? 0 : 1;
        }
        return 0;
    }

    public void paintAll(Graphics graphics) {
        if (isShowing()) {
            GraphicsCallback.PeerPaintCallback.getInstance().runOneComponent(this, new Rectangle(0, 0, this.width, this.height), graphics, graphics.getClip(), 3);
        }
    }

    public String paramString() {
        String name = getName();
        StringBuilder sb = new StringBuilder();
        if (name == null) {
            name = "";
        }
        sb.append(name);
        sb.append(",");
        sb.append(this.f10034x);
        sb.append(",");
        sb.append(this.f10035y);
        sb.append(",");
        sb.append(this.width);
        sb.append("x");
        sb.append(this.height);
        String string = sb.toString();
        if (!isValid()) {
            string = AbstractC0541b.m756B(string, ",invalid");
        }
        if (!this.visible) {
            string = AbstractC0541b.m756B(string, ",hidden");
        }
        return !this.enabled ? AbstractC0541b.m756B(string, ",disabled") : string;
    }

    public Point pointRelativeToComponent(Point point) {
        Point locationOnScreen = getLocationOnScreen();
        return new Point(point.f10092x - locationOnScreen.f10092x, point.f10093y - locationOnScreen.f10093y);
    }

    @Override // org.apache.poi.java.awt.MenuContainer
    @Deprecated
    public boolean postEvent(Event event) {
        if (handleEvent(event)) {
            event.consume();
            return true;
        }
        Container container = this.parent;
        int i = event.f10047x;
        int i2 = event.f10048y;
        if (container == null) {
            return false;
        }
        event.translate(this.f10034x, this.f10035y);
        if (container.postEvent(event)) {
            event.consume();
            return true;
        }
        event.f10047x = i;
        event.f10048y = i2;
        return false;
    }

    public boolean postsOldMouseEvents() {
        return false;
    }

    @Deprecated
    public Dimension preferredSize() {
        Dimension preferredSize;
        Dimension dimension = this.prefSize;
        if (dimension == null || (!isPreferredSizeSet() && !isValid())) {
            synchronized (getTreeLock()) {
                try {
                    ComponentPeer componentPeer = this.peer;
                    preferredSize = componentPeer != null ? componentPeer.getPreferredSize() : getMinimumSize();
                    this.prefSize = preferredSize;
                } catch (Throwable th) {
                    throw th;
                }
            }
            dimension = preferredSize;
        }
        return new Dimension(dimension);
    }

    public boolean prepareImage(Image image, int i, int i2, ImageObserver imageObserver) {
        ComponentPeer componentPeer = this.peer;
        if (componentPeer instanceof LightweightPeer) {
            Container container = this.parent;
            if (container != null) {
                return container.prepareImage(image, i, i2, imageObserver);
            }
        } else if (componentPeer != null) {
            return componentPeer.prepareImage(image, i, i2, imageObserver);
        }
        return getToolkit().prepareImage(image, i, i2, imageObserver);
    }

    public void print(Graphics graphics) {
        paint(graphics);
    }

    public void printAll(Graphics graphics) {
        if (isShowing()) {
            GraphicsCallback.PeerPrintCallback.getInstance().runOneComponent(this, new Rectangle(0, 0, this.width, this.height), graphics, graphics.getClip(), 3);
        }
    }

    public void processComponentEvent(ComponentEvent componentEvent) {
        ComponentListener componentListener = this.componentListener;
        if (componentListener != null) {
            switch (componentEvent.getID()) {
                case 100:
                    componentListener.componentMoved(componentEvent);
                    break;
                case 101:
                    componentListener.componentResized(componentEvent);
                    break;
                case 102:
                    componentListener.componentShown(componentEvent);
                    break;
                case 103:
                    componentListener.componentHidden(componentEvent);
                    break;
            }
        }
    }

    public void processFocusEvent(FocusEvent focusEvent) {
        FocusListener focusListener = this.focusListener;
        if (focusListener != null) {
            int id = focusEvent.getID();
            if (id == 1004) {
                focusListener.focusGained(focusEvent);
            } else {
                if (id != 1005) {
                    return;
                }
                focusListener.focusLost(focusEvent);
            }
        }
    }

    public void processHierarchyBoundsEvent(HierarchyEvent hierarchyEvent) {
        HierarchyBoundsListener hierarchyBoundsListener = this.hierarchyBoundsListener;
        if (hierarchyBoundsListener != null) {
            int id = hierarchyEvent.getID();
            if (id == 1401) {
                hierarchyBoundsListener.ancestorMoved(hierarchyEvent);
            } else {
                if (id != 1402) {
                    return;
                }
                hierarchyBoundsListener.ancestorResized(hierarchyEvent);
            }
        }
    }

    public void processHierarchyEvent(HierarchyEvent hierarchyEvent) {
        HierarchyListener hierarchyListener = this.hierarchyListener;
        if (hierarchyListener == null || hierarchyEvent.getID() != 1400) {
            return;
        }
        hierarchyListener.hierarchyChanged(hierarchyEvent);
    }

    public void processInputMethodEvent(InputMethodEvent inputMethodEvent) {
        InputMethodListener inputMethodListener = this.inputMethodListener;
        if (inputMethodListener != null) {
            int id = inputMethodEvent.getID();
            if (id == 1100) {
                inputMethodListener.inputMethodTextChanged(inputMethodEvent);
            } else {
                if (id != 1101) {
                    return;
                }
                inputMethodListener.caretPositionChanged(inputMethodEvent);
            }
        }
    }

    public void processKeyEvent(KeyEvent keyEvent) {
        KeyListener keyListener = this.keyListener;
        if (keyListener != null) {
            switch (keyEvent.getID()) {
                case 400:
                    keyListener.keyTyped(keyEvent);
                    break;
                case 401:
                    keyListener.keyPressed(keyEvent);
                    break;
                case 402:
                    keyListener.keyReleased(keyEvent);
                    break;
            }
        }
    }

    public void processMouseEvent(MouseEvent mouseEvent) {
        MouseListener mouseListener = this.mouseListener;
        if (mouseListener != null) {
            switch (mouseEvent.getID()) {
                case 500:
                    mouseListener.mouseClicked(mouseEvent);
                    break;
                case 501:
                    mouseListener.mousePressed(mouseEvent);
                    break;
                case 502:
                    mouseListener.mouseReleased(mouseEvent);
                    break;
                case 504:
                    mouseListener.mouseEntered(mouseEvent);
                    break;
                case 505:
                    mouseListener.mouseExited(mouseEvent);
                    break;
            }
        }
    }

    public void processMouseMotionEvent(MouseEvent mouseEvent) {
        MouseMotionListener mouseMotionListener = this.mouseMotionListener;
        if (mouseMotionListener != null) {
            int id = mouseEvent.getID();
            if (id == 503) {
                mouseMotionListener.mouseMoved(mouseEvent);
            } else {
                if (id != 506) {
                    return;
                }
                mouseMotionListener.mouseDragged(mouseEvent);
            }
        }
    }

    public void processMouseWheelEvent(MouseWheelEvent mouseWheelEvent) {
        MouseWheelListener mouseWheelListener = this.mouseWheelListener;
        if (mouseWheelListener == null || mouseWheelEvent.getID() != 507) {
            return;
        }
        mouseWheelListener.mouseWheelMoved(mouseWheelEvent);
    }

    public final void relocateComponent() {
        synchronized (getTreeLock()) {
            try {
                if (this.peer != null) {
                    int i = this.f10034x;
                    int i2 = this.f10035y;
                    int i4 = i;
                    int i5 = i2;
                    for (Container container = getContainer(); container != null && container.isLightweight(); container = container.getContainer()) {
                        i4 += container.f10034x;
                        i5 += container.f10035y;
                    }
                    this.peer.setBounds(i4, i5, this.width, this.height, 1);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.apache.poi.java.awt.MenuContainer
    public void remove(MenuComponent menuComponent) {
        int iIndexOf;
        synchronized (getTreeLock()) {
            try {
                Vector vector = this.popups;
                if (vector != null && (iIndexOf = vector.indexOf(menuComponent)) >= 0) {
                    PopupMenu popupMenu = (PopupMenu) menuComponent;
                    if (popupMenu.peer != null) {
                        popupMenu.removeNotify();
                    }
                    popupMenu.parent = null;
                    this.popups.removeElementAt(iIndexOf);
                    if (this.popups.size() == 0) {
                        this.popups = null;
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public synchronized void removeComponentListener(ComponentListener componentListener) {
        if (componentListener == null) {
            return;
        }
        this.componentListener = AWTEventMulticaster.remove(this.componentListener, componentListener);
    }

    public synchronized void removeFocusListener(FocusListener focusListener) {
        if (focusListener == null) {
            return;
        }
        this.focusListener = AWTEventMulticaster.remove(this.focusListener, focusListener);
    }

    public void removeHierarchyBoundsListener(HierarchyBoundsListener hierarchyBoundsListener) {
        boolean z;
        if (hierarchyBoundsListener == null) {
            return;
        }
        synchronized (this) {
            try {
                HierarchyBoundsListener hierarchyBoundsListener2 = this.hierarchyBoundsListener;
                z = false;
                boolean z2 = hierarchyBoundsListener2 != null && (this.eventMask & 65536) == 0;
                HierarchyBoundsListener hierarchyBoundsListenerRemove = AWTEventMulticaster.remove(hierarchyBoundsListener2, hierarchyBoundsListener);
                this.hierarchyBoundsListener = hierarchyBoundsListenerRemove;
                if (z2 && hierarchyBoundsListenerRemove == null) {
                    z = true;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (z) {
            synchronized (getTreeLock()) {
                adjustListeningChildrenOnParent(65536L, -1);
            }
        }
    }

    public void removeHierarchyListener(HierarchyListener hierarchyListener) {
        boolean z;
        if (hierarchyListener == null) {
            return;
        }
        synchronized (this) {
            try {
                HierarchyListener hierarchyListener2 = this.hierarchyListener;
                z = false;
                boolean z2 = hierarchyListener2 != null && (this.eventMask & 32768) == 0;
                HierarchyListener hierarchyListenerRemove = AWTEventMulticaster.remove(hierarchyListener2, hierarchyListener);
                this.hierarchyListener = hierarchyListenerRemove;
                if (z2 && hierarchyListenerRemove == null) {
                    z = true;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (z) {
            synchronized (getTreeLock()) {
                adjustListeningChildrenOnParent(32768L, -1);
            }
        }
    }

    public synchronized void removeInputMethodListener(InputMethodListener inputMethodListener) {
        if (inputMethodListener == null) {
            return;
        }
        this.inputMethodListener = AWTEventMulticaster.remove(this.inputMethodListener, inputMethodListener);
    }

    public synchronized void removeKeyListener(KeyListener keyListener) {
        if (keyListener == null) {
            return;
        }
        this.keyListener = AWTEventMulticaster.remove(this.keyListener, keyListener);
    }

    public synchronized void removeMouseListener(MouseListener mouseListener) {
        if (mouseListener == null) {
            return;
        }
        this.mouseListener = AWTEventMulticaster.remove(this.mouseListener, mouseListener);
    }

    public synchronized void removeMouseMotionListener(MouseMotionListener mouseMotionListener) {
        if (mouseMotionListener == null) {
            return;
        }
        this.mouseMotionListener = AWTEventMulticaster.remove(this.mouseMotionListener, mouseMotionListener);
    }

    public synchronized void removeMouseWheelListener(MouseWheelListener mouseWheelListener) {
        if (mouseWheelListener == null) {
            return;
        }
        this.mouseWheelListener = AWTEventMulticaster.remove(this.mouseWheelListener, mouseWheelListener);
    }

    public void removeNotify() throws Throwable {
        org.apache.poi.java.awt.im.InputContext inputContext;
        KeyboardFocusManager.clearMostRecentFocusOwner(this);
        if (KeyboardFocusManager.getCurrentKeyboardFocusManager().getPermanentFocusOwner() == this) {
            KeyboardFocusManager.getCurrentKeyboardFocusManager().setGlobalPermanentFocusOwner(null);
        }
        synchronized (getTreeLock()) {
            try {
                try {
                    if (isFocusOwner() && KeyboardFocusManager.isAutoFocusTransferEnabledFor(this)) {
                        transferFocus(true);
                    }
                    if (getContainer() != null && this.isAddNotifyComplete) {
                        getContainer().decreaseComponentCount(this);
                    }
                    Vector vector = this.popups;
                    int size = vector != null ? vector.size() : 0;
                    for (int i = 0; i < size; i++) {
                        ((PopupMenu) this.popups.elementAt(i)).removeNotify();
                    }
                    if ((this.eventMask & 4096) != 0 && (inputContext = getInputContext()) != null) {
                        inputContext.removeNotify(this);
                    }
                    ComponentPeer componentPeer = this.peer;
                    if (componentPeer != null) {
                        boolean zIsLightweight = isLightweight();
                        BufferStrategy bufferStrategy = this.bufferStrategy;
                        if (bufferStrategy instanceof FlipBufferStrategy) {
                            ((FlipBufferStrategy) bufferStrategy).destroyBuffers();
                        }
                        DropTarget dropTarget = this.dropTarget;
                        if (dropTarget != null) {
                            dropTarget.removeNotify(this.peer);
                        }
                        if (this.visible) {
                            componentPeer.setVisible(false);
                        }
                        this.peer = null;
                        this.peerFont = null;
                        Toolkit.getEventQueue().removeSourceEvents(this, false);
                        KeyboardFocusManager.getCurrentKeyboardFocusManager().discardKeyEvents(this);
                        componentPeer.dispose();
                        mixOnHiding(zIsLightweight);
                        this.isAddNotifyComplete = false;
                        this.compoundShape = null;
                    }
                    if (this.hierarchyListener != null || (this.eventMask & 32768) != 0 || Toolkit.enabledOnToolkit(32768L)) {
                        Container container = this.parent;
                        int i2 = isRecursivelyVisible() ? 4 : 0;
                        dispatchEvent(new HierarchyEvent(this, 1400, this, container, i2 | 2));
                    }
                } catch (Throwable th) {
                    th = th;
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                throw th;
            }
        }
    }

    public void removePropertyChangeListener(PropertyChangeListener propertyChangeListener) {
        synchronized (getObjectLock()) {
            if (propertyChangeListener != null) {
                PropertyChangeSupport propertyChangeSupport = this.changeSupport;
                if (propertyChangeSupport != null) {
                    propertyChangeSupport.removePropertyChangeListener(propertyChangeListener);
                }
            }
        }
    }

    public void repaint() {
        repaint(0L, 0, 0, this.width, this.height);
    }

    public void requestFocus() {
        requestFocusHelper(false, true);
    }

    public final boolean requestFocusHelper(boolean z, boolean z2) {
        return requestFocusHelper(z, z2, CausedFocusEvent.Cause.UNKNOWN);
    }

    public boolean requestFocusInWindow() {
        return requestFocusHelper(false, false);
    }

    @Deprecated
    public void reshape(int i, int i2, int i4, int i5) {
        synchronized (getTreeLock()) {
            try {
                setBoundsOp(3);
                int i6 = this.width;
                boolean z = true;
                boolean z2 = (i6 == i4 && this.height == i5) ? false : true;
                int i7 = this.f10034x;
                boolean z3 = (i7 == i && this.f10035y == i2) ? false : true;
                if (z2 || z3) {
                    int i8 = this.f10035y;
                    int i9 = this.height;
                    this.f10034x = i;
                    this.f10035y = i2;
                    this.width = i4;
                    this.height = i5;
                    if (z2) {
                        this.isPacked = false;
                    }
                    mixOnReshaping();
                    ComponentPeer componentPeer = this.peer;
                    if (componentPeer != null) {
                        if (!(componentPeer instanceof LightweightPeer)) {
                            reshapeNativePeer(i, i2, i4, i5, getBoundsOp());
                            z2 = (i6 == this.width && i9 == this.height) ? false : true;
                            z3 = (i7 == this.f10034x && i8 == this.f10035y) ? false : true;
                            if (this instanceof Window) {
                                z = false;
                            }
                        }
                        if (z2) {
                            invalidate();
                        }
                        Container container = this.parent;
                        if (container != null) {
                            container.invalidateIfValid();
                        }
                    }
                    if (z) {
                        notifyNewBounds(z2, z3);
                    }
                    repaintParentIfNeeded(i7, i8, i6, i9);
                }
                setBoundsOp(5);
            } catch (Throwable th) {
                setBoundsOp(5);
                throw th;
            }
        }
    }

    @Deprecated
    public void resize(int i, int i2) {
        synchronized (getTreeLock()) {
            setBoundsOp(2);
            setBounds(this.f10034x, this.f10035y, i, i2);
        }
    }

    public void revalidate() {
        revalidateSynchronously();
    }

    public final void revalidateSynchronously() {
        synchronized (getTreeLock()) {
            try {
                invalidate();
                Container container = getContainer();
                if (container == null) {
                    validate();
                } else {
                    while (!container.isValidateRoot() && container.getContainer() != null) {
                        container = container.getContainer();
                    }
                    container.validate();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void setAutoFocusTransferOnDisposal(boolean z) {
        this.autoFocusTransferOnDisposal = z;
    }

    public void setBackground(Color color) {
        Color color2 = this.background;
        ComponentPeer componentPeer = this.peer;
        this.background = color;
        if (componentPeer != null && (color = getBackground()) != null) {
            componentPeer.setBackground(color);
        }
        firePropertyChange("background", color2, color);
    }

    public void setBounds(int i, int i2, int i4, int i5) {
        reshape(i, i2, i4, i5);
    }

    public void setBoundsOp(int i) {
        if (i == 5) {
            this.boundsOp = 3;
        } else if (this.boundsOp == 3) {
            this.boundsOp = i;
        }
    }

    public void setComponentOrientation(ComponentOrientation componentOrientation) {
        ComponentOrientation componentOrientation2 = this.componentOrientation;
        this.componentOrientation = componentOrientation;
        firePropertyChange("componentOrientation", componentOrientation2, componentOrientation);
        invalidateIfValid();
    }

    public void setCursor(Cursor cursor) {
        this.cursor = cursor;
        updateCursorImmediately();
    }

    public synchronized void setDropTarget(DropTarget dropTarget) {
        try {
            DropTarget dropTarget2 = this.dropTarget;
            if (dropTarget != dropTarget2 && (dropTarget2 == null || !dropTarget2.equals(dropTarget))) {
                DropTarget dropTarget3 = this.dropTarget;
                if (dropTarget3 != null) {
                    ComponentPeer componentPeer = this.peer;
                    if (componentPeer != null) {
                        dropTarget3.removeNotify(componentPeer);
                    }
                    DropTarget dropTarget4 = this.dropTarget;
                    this.dropTarget = null;
                    try {
                        dropTarget4.setComponent((Component) null);
                    } catch (IllegalArgumentException unused) {
                    }
                }
                this.dropTarget = dropTarget;
                if (dropTarget != null) {
                    try {
                        dropTarget.setComponent(this);
                        ComponentPeer componentPeer2 = this.peer;
                        if (componentPeer2 != null) {
                            this.dropTarget.addNotify(componentPeer2);
                        }
                    } catch (IllegalArgumentException unused2) {
                        if (dropTarget3 != null) {
                            try {
                                dropTarget3.setComponent(this);
                                ComponentPeer componentPeer3 = this.peer;
                                if (componentPeer3 != null) {
                                    this.dropTarget.addNotify(componentPeer3);
                                }
                            } catch (IllegalArgumentException unused3) {
                            }
                        }
                    }
                }
            }
        } finally {
        }
    }

    public void setEnabled(boolean z) {
        enable(z);
    }

    public void setFocusTraversalKeys(int i, Set<? extends AWTKeyStroke> set) {
        if (i < 0 || i >= 3) {
            throw new IllegalArgumentException("invalid focus traversal key identifier");
        }
        setFocusTraversalKeys_NoIDCheck(i, set);
    }

    public void setFocusTraversalKeysEnabled(boolean z) {
        boolean z2;
        synchronized (this) {
            z2 = this.focusTraversalKeysEnabled;
            this.focusTraversalKeysEnabled = z;
        }
        firePropertyChange("focusTraversalKeysEnabled", z2, z);
    }

    public final void setFocusTraversalKeys_NoIDCheck(int i, Set<? extends AWTKeyStroke> set) {
        Set set2;
        synchronized (this) {
            try {
                if (this.focusTraversalKeys == null) {
                    initializeFocusTraversalKeys();
                }
                if (set != null) {
                    for (AWTKeyStroke aWTKeyStroke : set) {
                        if (aWTKeyStroke == null) {
                            throw new IllegalArgumentException("cannot set null focus traversal key");
                        }
                        if (!(aWTKeyStroke instanceof AWTKeyStroke)) {
                            throw new IllegalArgumentException("object is expected to be AWTKeyStroke");
                        }
                        AWTKeyStroke aWTKeyStroke2 = aWTKeyStroke;
                        if (aWTKeyStroke2.getKeyChar() != 65535) {
                            throw new IllegalArgumentException("focus traversal keys cannot map to KEY_TYPED events");
                        }
                        for (int i2 = 0; i2 < this.focusTraversalKeys.length; i2++) {
                            if (i2 != i && getFocusTraversalKeys_NoIDCheck(i2).contains(aWTKeyStroke2)) {
                                throw new IllegalArgumentException("focus traversal keys must be unique for a Component");
                            }
                        }
                    }
                }
                Set[] setArr = this.focusTraversalKeys;
                set2 = setArr[i];
                setArr[i] = set != null ? Collections.unmodifiableSet(new HashSet(set)) : null;
            } catch (Throwable th) {
                throw th;
            }
        }
        firePropertyChange(focusTraversalKeyPropertyNames[i], set2, set);
    }

    public void setFocusable(boolean z) {
        boolean z2;
        synchronized (this) {
            z2 = this.focusable;
            this.focusable = z;
        }
        this.isFocusTraversableOverridden = 2;
        firePropertyChange("focusable", z2, z);
        if (!z2 || z) {
            return;
        }
        if (isFocusOwner() && KeyboardFocusManager.isAutoFocusTransferEnabled()) {
            transferFocus(true);
        }
        KeyboardFocusManager.clearMostRecentFocusOwner(this);
    }

    public void setFont(Font font) {
        Font font2;
        Object font3;
        synchronized (getTreeLock()) {
            try {
                synchronized (this) {
                    font2 = this.font;
                    this.font = font;
                }
                ComponentPeer componentPeer = this.peer;
                if (componentPeer != null) {
                    font3 = getFont();
                    if (font3 != null) {
                        componentPeer.setFont(font3);
                        this.peerFont = font3;
                    }
                } else {
                    font3 = font;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        firePropertyChange("font", font2, font);
        if (font3 != font2) {
            if (font2 == null || !font2.equals(font3)) {
                invalidateIfValid();
            }
        }
    }

    public void setForeground(Color color) {
        Color color2 = this.foreground;
        ComponentPeer componentPeer = this.peer;
        this.foreground = color;
        if (componentPeer != null && (color = getForeground()) != null) {
            componentPeer.setForeground(color);
        }
        firePropertyChange("foreground", color2, color);
    }

    public void setGraphicsConfiguration(GraphicsConfiguration graphicsConfiguration) {
        synchronized (getTreeLock()) {
            try {
                if (updateGraphicsData(graphicsConfiguration)) {
                    removeNotify();
                    addNotify();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void setIgnoreRepaint(boolean z) {
        this.ignoreRepaint = z;
    }

    public void setLocale(Locale locale) {
        Locale locale2 = this.locale;
        this.locale = locale;
        firePropertyChange("locale", locale2, locale);
        invalidateIfValid();
    }

    public void setLocation(int i, int i2) {
        move(i, i2);
    }

    public void setMaximumSize(Dimension dimension) {
        Dimension dimension2 = this.maxSizeSet ? this.maxSize : null;
        this.maxSize = dimension;
        this.maxSizeSet = dimension != null;
        firePropertyChange("maximumSize", dimension2, dimension);
    }

    public void setMinimumSize(Dimension dimension) {
        Dimension dimension2 = this.minSizeSet ? this.minSize : null;
        this.minSize = dimension;
        this.minSizeSet = dimension != null;
        firePropertyChange("minimumSize", dimension2, dimension);
    }

    public void setName(String str) {
        String str2;
        synchronized (getObjectLock()) {
            str2 = this.name;
            this.name = str;
            this.nameExplicitlySet = true;
        }
        firePropertyChange("name", str2, str);
    }

    public void setPreferredSize(Dimension dimension) {
        Dimension dimension2 = this.prefSizeSet ? this.prefSize : null;
        this.prefSize = dimension;
        this.prefSizeSet = dimension != null;
        firePropertyChange("preferredSize", dimension2, dimension);
    }

    public void setSize(int i, int i2) {
        resize(i, i2);
    }

    public void setVisible(boolean z) throws Throwable {
        show(z);
    }

    @Deprecated
    public void show() throws Throwable {
        Component component;
        if (this.visible) {
            return;
        }
        synchronized (getTreeLock()) {
            try {
                try {
                    this.visible = true;
                    mixOnShowing();
                    ComponentPeer componentPeer = this.peer;
                    if (componentPeer != null) {
                        componentPeer.setVisible(true);
                        component = this;
                        component.createHierarchyEvents(1400, this, this.parent, 4L, Toolkit.enabledOnToolkit(32768L));
                        if (componentPeer instanceof LightweightPeer) {
                            repaint();
                        }
                        updateCursorImmediately();
                    } else {
                        component = this;
                    }
                    if (component.componentListener != null || (component.eventMask & 1) != 0 || Toolkit.enabledOnToolkit(1L)) {
                        Toolkit.getEventQueue().postEvent(new ComponentEvent(this, 102));
                    }
                    Container container = component.parent;
                    if (container != null) {
                        container.invalidate();
                    }
                } catch (Throwable th) {
                    th = th;
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                throw th;
            }
        }
    }

    @Deprecated
    public Dimension size() {
        return new Dimension(this.width, this.height);
    }

    public final void subtractAndApplyShape(Region region) {
        checkTreeLock();
        PlatformLogger platformLogger = mixingLog;
        if (platformLogger.isLoggable(500)) {
            platformLogger.fine("this = " + this + "; s=" + region);
        }
        applyCompoundShape(getAppliedShape().getDifference(region));
    }

    public final void subtractAndApplyShapeBelowMe() {
        checkTreeLock();
        Container container = getContainer();
        if (container == null || !isShowing()) {
            return;
        }
        Region opaqueShape = getOpaqueShape();
        container.recursiveSubtractAndApplyShape(opaqueShape, getSiblingIndexBelow());
        Container container2 = container.getContainer();
        while (!container.isOpaque() && container2 != null) {
            container2.recursiveSubtractAndApplyShape(opaqueShape, container.getSiblingIndexBelow());
            Container container3 = container2;
            container2 = container2.getContainer();
            container = container3;
        }
    }

    public String toString() {
        return getClass().getName() + "[" + paramString() + "]";
    }

    public void transferFocus() {
        nextFocus();
    }

    public void transferFocusBackward() {
        transferFocusBackward(false);
    }

    public void transferFocusUpCycle() {
        Component defaultComponent;
        Container focusCycleRootAncestor = getFocusCycleRootAncestor();
        while (focusCycleRootAncestor != null && (!focusCycleRootAncestor.isShowing() || !focusCycleRootAncestor.isFocusable() || !focusCycleRootAncestor.isEnabled())) {
            focusCycleRootAncestor = focusCycleRootAncestor.getFocusCycleRootAncestor();
        }
        if (focusCycleRootAncestor != null) {
            Container focusCycleRootAncestor2 = focusCycleRootAncestor.getFocusCycleRootAncestor();
            KeyboardFocusManager currentKeyboardFocusManager = KeyboardFocusManager.getCurrentKeyboardFocusManager();
            if (focusCycleRootAncestor2 == null) {
                focusCycleRootAncestor2 = focusCycleRootAncestor;
            }
            currentKeyboardFocusManager.setGlobalCurrentFocusCycleRoot(focusCycleRootAncestor2);
            focusCycleRootAncestor.requestFocus(CausedFocusEvent.Cause.TRAVERSAL_UP);
            return;
        }
        Window containingWindow = getContainingWindow();
        if (containingWindow == null || (defaultComponent = containingWindow.getFocusTraversalPolicy().getDefaultComponent(containingWindow)) == null) {
            return;
        }
        KeyboardFocusManager.getCurrentKeyboardFocusManager().setGlobalCurrentFocusCycleRoot(containingWindow);
        defaultComponent.requestFocus(CausedFocusEvent.Cause.TRAVERSAL_UP);
    }

    public void update(Graphics graphics) {
        paint(graphics);
    }

    public final void updateCursorImmediately() {
        ComponentPeer peer;
        ComponentPeer componentPeer = this.peer;
        if (!(componentPeer instanceof LightweightPeer)) {
            if (componentPeer != null) {
                componentPeer.updateCursorImmediately();
            }
        } else {
            Container nativeContainer = getNativeContainer();
            if (nativeContainer == null || (peer = nativeContainer.getPeer()) == null) {
                return;
            }
            peer.updateCursorImmediately();
        }
    }

    public boolean updateGraphicsData(GraphicsConfiguration graphicsConfiguration) {
        checkTreeLock();
        this.graphicsConfig = graphicsConfiguration;
        ComponentPeer peer = getPeer();
        if (peer != null) {
            return peer.updateGraphicsData(graphicsConfiguration);
        }
        return false;
    }

    public void updateZOrder() {
        this.peer.setZOrder(getHWPeerAboveMe());
    }

    public void validate() {
        synchronized (getTreeLock()) {
            try {
                ComponentPeer componentPeer = this.peer;
                boolean zIsValid = isValid();
                if (!zIsValid && componentPeer != null) {
                    Font font = getFont();
                    Font font2 = this.peerFont;
                    if (font != font2 && (font2 == null || !font2.equals(font))) {
                        componentPeer.setFont(font);
                        this.peerFont = font;
                    }
                    componentPeer.layout();
                }
                this.valid = true;
                if (!zIsValid) {
                    mixOnValidating();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void addPropertyChangeListener(String str, PropertyChangeListener propertyChangeListener) {
        synchronized (getObjectLock()) {
            if (propertyChangeListener != null) {
                try {
                    if (this.changeSupport == null) {
                        this.changeSupport = new PropertyChangeSupport(this);
                    }
                    this.changeSupport.addPropertyChangeListener(str, propertyChangeListener);
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    public int checkImage(Image image, ImageObserver imageObserver) {
        return checkImage(image, -1, -1, imageObserver);
    }

    public boolean contains(Point point) {
        return contains(point.f10092x, point.f10093y);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v3, types: [org.apache.poi.java.awt.BufferCapabilities] */
    /* JADX WARN: Type inference failed for: r4v4 */
    /* JADX WARN: Type inference failed for: r4v5 */
    /* JADX WARN: Type inference failed for: r4v6 */
    public void createBufferStrategy(int i, BufferCapabilities bufferCapabilities) {
        if (i < 1) {
            throw new IllegalArgumentException("Number of buffers must be at least 1");
        }
        if (bufferCapabilities == null) {
            throw new IllegalArgumentException("No capabilities specified");
        }
        BufferStrategy bufferStrategy = this.bufferStrategy;
        if (bufferStrategy != null) {
            bufferStrategy.dispose();
        }
        if (i == 1) {
            this.bufferStrategy = new SingleBufferStrategy(bufferCapabilities);
            return;
        }
        SunGraphicsEnvironment localGraphicsEnvironment = GraphicsEnvironment.getLocalGraphicsEnvironment();
        boolean zIsPageFlipping = bufferCapabilities.isPageFlipping();
        ?? proxyCapabilities = bufferCapabilities;
        if (!zIsPageFlipping) {
            proxyCapabilities = bufferCapabilities;
            if (localGraphicsEnvironment.isFlipStrategyPreferred(this.peer)) {
                proxyCapabilities = new ProxyCapabilities(bufferCapabilities);
            }
        }
        if (proxyCapabilities.isPageFlipping()) {
            this.bufferStrategy = new FlipSubRegionBufferStrategy(i, proxyCapabilities);
        } else {
            this.bufferStrategy = new BltSubRegionBufferStrategy(i, proxyCapabilities);
        }
    }

    public Image createImage(ImageProducer imageProducer) {
        ComponentPeer componentPeer = this.peer;
        return (componentPeer == null || (componentPeer instanceof LightweightPeer)) ? getToolkit().createImage(imageProducer) : componentPeer.createImage(imageProducer);
    }

    public VolatileImage createVolatileImage(int i, int i2, ImageCapabilities imageCapabilities) {
        return createVolatileImage(i, i2);
    }

    @Deprecated
    public void enable(boolean z) {
        if (z) {
            enable();
        } else {
            disable();
        }
    }

    public void firePropertyChange(String str, char c, char c2) {
        if (this.changeSupport == null || c == c2) {
            return;
        }
        firePropertyChange(str, new Character(c), new Character(c2));
    }

    public Rectangle getBounds(Rectangle rectangle) {
        if (rectangle == null) {
            return new Rectangle(getX(), getY(), getWidth(), getHeight());
        }
        rectangle.setBounds(getX(), getY(), getWidth(), getHeight());
        return rectangle;
    }

    public Component getComponentAt(Point point) {
        return getComponentAt(point.f10092x, point.f10093y);
    }

    public Point getLocation(Point point) {
        if (point == null) {
            return new Point(getX(), getY());
        }
        point.setLocation(getX(), getY());
        return point;
    }

    public PropertyChangeListener[] getPropertyChangeListeners(String str) {
        PropertyChangeListener[] propertyChangeListeners;
        synchronized (getObjectLock()) {
            try {
                PropertyChangeSupport propertyChangeSupport = this.changeSupport;
                propertyChangeListeners = propertyChangeSupport == null ? new PropertyChangeListener[0] : propertyChangeSupport.getPropertyChangeListeners(str);
            } catch (Throwable th) {
                throw th;
            }
        }
        return propertyChangeListeners;
    }

    public Dimension getSize(Dimension dimension) {
        if (dimension == null) {
            return new Dimension(getWidth(), getHeight());
        }
        dimension.setSize(getWidth(), getHeight());
        return dimension;
    }

    public void list(PrintStream printStream) {
        list(printStream, 0);
    }

    public boolean prepareImage(Image image, ImageObserver imageObserver) {
        return prepareImage(image, -1, -1, imageObserver);
    }

    public void removePropertyChangeListener(String str, PropertyChangeListener propertyChangeListener) {
        synchronized (getObjectLock()) {
            if (propertyChangeListener != null) {
                PropertyChangeSupport propertyChangeSupport = this.changeSupport;
                if (propertyChangeSupport != null) {
                    propertyChangeSupport.removePropertyChangeListener(str, propertyChangeListener);
                }
            }
        }
    }

    public void repaint(int i, int i2, int i4, int i5) {
        repaint(0L, i, i2, i4, i5);
    }

    public boolean requestFocus(CausedFocusEvent.Cause cause) {
        return requestFocusHelper(false, true, cause);
    }

    public final boolean requestFocusHelper(boolean z, boolean z2, CausedFocusEvent.Cause cause) {
        PlatformLogger platformLogger;
        String str;
        if (!isRequestFocusAccepted(z, z2, cause)) {
            PlatformLogger platformLogger2 = focusLog;
            if (platformLogger2.isLoggable(300)) {
                platformLogger2.finest("requestFocus is not accepted");
            }
            return false;
        }
        KeyboardFocusManager.setMostRecentFocusOwner(this);
        for (Component component = this; component != null && !(component instanceof Window); component = component.parent) {
            if (!component.isVisible()) {
                PlatformLogger platformLogger3 = focusLog;
                if (platformLogger3.isLoggable(300)) {
                    platformLogger3.finest("component is recurively invisible");
                }
                return false;
            }
        }
        Component nativeContainer = this.peer instanceof LightweightPeer ? getNativeContainer() : this;
        if (nativeContainer == null || !nativeContainer.isVisible()) {
            PlatformLogger platformLogger4 = focusLog;
            if (platformLogger4.isLoggable(300)) {
                platformLogger4.finest("Component is not a part of visible hierarchy");
            }
            return false;
        }
        ComponentPeer componentPeer = nativeContainer.peer;
        if (componentPeer == null) {
            PlatformLogger platformLogger5 = focusLog;
            if (platformLogger5.isLoggable(300)) {
                platformLogger5.finest("Peer is null");
            }
            return false;
        }
        long mostRecentEventTime = EventQueue.getMostRecentEventTime();
        boolean zRequestFocus = componentPeer.requestFocus(this, z, z2, mostRecentEventTime, cause);
        if (!zRequestFocus) {
            KeyboardFocusManager.getCurrentKeyboardFocusManager(this.appContext).dequeueKeyEvents(mostRecentEventTime, this);
            platformLogger = focusLog;
            if (platformLogger.isLoggable(300)) {
                str = "Peer request failed";
                platformLogger.finest(str);
                return zRequestFocus;
            }
            return zRequestFocus;
        }
        platformLogger = focusLog;
        if (platformLogger.isLoggable(300)) {
            str = "Pass for " + this;
            platformLogger.finest(str);
            return zRequestFocus;
        }
        return zRequestFocus;
    }

    public boolean requestFocusInWindow(CausedFocusEvent.Cause cause) {
        return requestFocusHelper(false, false, cause);
    }

    @Deprecated
    public void resize(Dimension dimension) {
        setSize(dimension.width, dimension.height);
    }

    public void setBounds(Rectangle rectangle) {
        setBounds(rectangle.f10094x, rectangle.f10095y, rectangle.width, rectangle.height);
    }

    public void setLocation(Point point) {
        setLocation(point.f10092x, point.f10093y);
    }

    public void setSize(Dimension dimension) {
        resize(dimension);
    }

    @Deprecated
    public void show(boolean z) throws Throwable {
        if (z) {
            show();
        } else {
            hide();
        }
    }

    public boolean transferFocus(boolean z) {
        PlatformLogger platformLogger = focusLog;
        if (platformLogger.isLoggable(400)) {
            platformLogger.finer("clearOnFailure = " + z);
        }
        Component nextFocusCandidate = getNextFocusCandidate();
        boolean zRequestFocusInWindow = (nextFocusCandidate == null || nextFocusCandidate.isFocusOwner() || nextFocusCandidate == this) ? false : nextFocusCandidate.requestFocusInWindow(CausedFocusEvent.Cause.TRAVERSAL_FORWARD);
        if (z && !zRequestFocusInWindow) {
            if (platformLogger.isLoggable(400)) {
                platformLogger.finer("clear global focus owner");
            }
            KeyboardFocusManager.getCurrentKeyboardFocusManager().clearGlobalFocusOwner();
        }
        if (platformLogger.isLoggable(400)) {
            platformLogger.finer("returning result: " + zRequestFocusInWindow);
        }
        return zRequestFocusInWindow;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0034  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean transferFocusBackward(boolean z) {
        boolean zRequestFocusInWindow;
        Container traversalRoot = getTraversalRoot();
        Component component = this;
        while (traversalRoot != null && (!traversalRoot.isShowing() || !traversalRoot.canBeFocusOwner())) {
            component = traversalRoot;
            traversalRoot = traversalRoot.getFocusCycleRootAncestor();
        }
        if (traversalRoot == null) {
            zRequestFocusInWindow = false;
        } else {
            FocusTraversalPolicy focusTraversalPolicy = traversalRoot.getFocusTraversalPolicy();
            Component componentBefore = focusTraversalPolicy.getComponentBefore(traversalRoot, component);
            if (componentBefore == null) {
                componentBefore = focusTraversalPolicy.getDefaultComponent(traversalRoot);
            }
            if (componentBefore != null) {
                zRequestFocusInWindow = componentBefore.requestFocusInWindow(CausedFocusEvent.Cause.TRAVERSAL_BACKWARD);
            }
        }
        if (z && !zRequestFocusInWindow) {
            PlatformLogger platformLogger = focusLog;
            if (platformLogger.isLoggable(400)) {
                platformLogger.finer("clear global focus owner");
            }
            KeyboardFocusManager.getCurrentKeyboardFocusManager().clearGlobalFocusOwner();
        }
        PlatformLogger platformLogger2 = focusLog;
        if (platformLogger2.isLoggable(400)) {
            platformLogger2.finer("returning result: " + zRequestFocusInWindow);
        }
        return zRequestFocusInWindow;
    }

    public void firePropertyChange(String str, double d, double d2) {
        if (this.changeSupport == null || d == d2) {
            return;
        }
        firePropertyChange(str, Double.valueOf(d), Double.valueOf(d2));
    }

    public void list(PrintStream printStream, int i) {
        for (int i2 = 0; i2 < i; i2++) {
            printStream.print(" ");
        }
        printStream.println(this);
    }

    public void repaint(long j) {
        repaint(j, 0, 0, this.width, this.height);
    }

    public boolean requestFocus(boolean z) {
        return requestFocusHelper(z, true);
    }

    public boolean requestFocusInWindow(boolean z) {
        return requestFocusHelper(z, false);
    }

    public void firePropertyChange(String str, float f, float f4) {
        if (this.changeSupport == null || f == f4) {
            return;
        }
        firePropertyChange(str, Float.valueOf(f), Float.valueOf(f4));
    }

    public void list(PrintWriter printWriter) {
        list(printWriter, 0);
    }

    public void repaint(long j, int i, int i2, int i4, int i5) {
        if (!(this.peer instanceof LightweightPeer)) {
            if (!isVisible() || this.peer == null || i4 <= 0 || i5 <= 0) {
                return;
            }
            SunToolkit.postEvent(SunToolkit.targetToAppContext(this), new PaintEvent(this, 801, new Rectangle(i, i2, i4, i5)));
            return;
        }
        Container container = this.parent;
        if (container != null) {
            if (i < 0) {
                i4 += i;
                i = 0;
            }
            if (i2 < 0) {
                i5 += i2;
                i2 = 0;
            }
            int i6 = this.width;
            int i7 = i4 > i6 ? i6 : i4;
            int i8 = this.height;
            int i9 = i5 > i8 ? i8 : i5;
            if (i7 <= 0 || i9 <= 0) {
                return;
            }
            container.repaint(j, this.f10034x + i, this.f10035y + i2, i7, i9);
        }
    }

    public boolean requestFocus(boolean z, CausedFocusEvent.Cause cause) {
        return requestFocusHelper(z, true, cause);
    }

    public boolean requestFocusInWindow(boolean z, CausedFocusEvent.Cause cause) {
        return requestFocusHelper(z, false, cause);
    }

    public void firePropertyChange(String str, int i, int i2) {
        PropertyChangeSupport propertyChangeSupport = this.changeSupport;
        if (propertyChangeSupport == null || i == i2) {
            return;
        }
        propertyChangeSupport.firePropertyChange(str, i, i2);
    }

    public void list(PrintWriter printWriter, int i) {
        for (int i2 = 0; i2 < i; i2++) {
            printWriter.print(" ");
        }
        printWriter.println(this);
    }

    public void firePropertyChange(String str, long j, long j2) {
        if (this.changeSupport == null || j == j2) {
            return;
        }
        firePropertyChange(str, Long.valueOf(j), Long.valueOf(j2));
    }

    public void firePropertyChange(String str, Object obj, Object obj2) {
        PropertyChangeSupport propertyChangeSupport;
        synchronized (getObjectLock()) {
            propertyChangeSupport = this.changeSupport;
        }
        if (propertyChangeSupport != null) {
            if (obj == null || obj2 == null || !obj.equals(obj2)) {
                propertyChangeSupport.firePropertyChange(str, obj, obj2);
            }
        }
    }

    public void firePropertyChange(String str, short s, short s2) {
        if (this.changeSupport == null || s == s2) {
            return;
        }
        firePropertyChange(str, Short.valueOf(s), Short.valueOf(s2));
    }

    public void firePropertyChange(String str, boolean z, boolean z2) {
        PropertyChangeSupport propertyChangeSupport = this.changeSupport;
        if (propertyChangeSupport == null || z == z2) {
            return;
        }
        propertyChangeSupport.firePropertyChange(str, z, z2);
    }

    public abstract class AccessibleAWTComponent extends AccessibleContext implements Serializable, AccessibleComponent {
        private static final long serialVersionUID = 642321655757800191L;
        protected ComponentListener accessibleAWTComponentHandler = null;
        protected FocusListener accessibleAWTFocusHandler = null;

        public class AccessibleAWTFocusHandler implements FocusListener {
            public AccessibleAWTFocusHandler() {
            }

            public void focusGained(FocusEvent focusEvent) {
                AccessibleContext accessibleContext = Component.this.accessibleContext;
                if (accessibleContext != null) {
                    accessibleContext.firePropertyChange("AccessibleState", (Object) null, AccessibleState.FOCUSED);
                }
            }

            public void focusLost(FocusEvent focusEvent) {
                AccessibleContext accessibleContext = Component.this.accessibleContext;
                if (accessibleContext != null) {
                    accessibleContext.firePropertyChange("AccessibleState", AccessibleState.FOCUSED, (Object) null);
                }
            }
        }

        public AccessibleAWTComponent() {
        }

        public void addFocusListener(FocusListener focusListener) {
            Component.this.addFocusListener(focusListener);
        }

        public void addPropertyChangeListener(PropertyChangeListener propertyChangeListener) {
            if (this.accessibleAWTComponentHandler == null) {
                AccessibleAWTComponentHandler accessibleAWTComponentHandler = new AccessibleAWTComponentHandler();
                this.accessibleAWTComponentHandler = accessibleAWTComponentHandler;
                Component.this.addComponentListener(accessibleAWTComponentHandler);
            }
            if (this.accessibleAWTFocusHandler == null) {
                AccessibleAWTFocusHandler accessibleAWTFocusHandler = new AccessibleAWTFocusHandler();
                this.accessibleAWTFocusHandler = accessibleAWTFocusHandler;
                Component.this.addFocusListener(accessibleAWTFocusHandler);
            }
            super.addPropertyChangeListener(propertyChangeListener);
        }

        public boolean contains(Point point) {
            return Component.this.contains(point);
        }

        public Accessible getAccessibleAt(Point point) {
            return null;
        }

        public Accessible getAccessibleChild(int i) {
            return null;
        }

        public int getAccessibleChildrenCount() {
            return 0;
        }

        public String getAccessibleDescription() {
            return this.accessibleDescription;
        }

        public int getAccessibleIndexInParent() {
            return Component.this.getAccessibleIndexInParent();
        }

        public String getAccessibleName() {
            return this.accessibleName;
        }

        public Accessible getAccessibleParent() {
            if (this.accessibleParent != null) {
                return this.accessibleParent;
            }
            Accessible parent = Component.this.getParent();
            if (parent instanceof Accessible) {
                return parent;
            }
            return null;
        }

        public AccessibleRole getAccessibleRole() {
            return AccessibleRole.AWT_COMPONENT;
        }

        public AccessibleStateSet getAccessibleStateSet() {
            return Component.this.getAccessibleStateSet();
        }

        public Color getBackground() {
            return Component.this.getBackground();
        }

        public Rectangle getBounds() {
            return Component.this.getBounds();
        }

        public Cursor getCursor() {
            return Component.this.getCursor();
        }

        public Font getFont() {
            return Component.this.getFont();
        }

        public FontMetrics getFontMetrics(Font font) {
            if (font == null) {
                return null;
            }
            return Component.this.getFontMetrics(font);
        }

        public Color getForeground() {
            return Component.this.getForeground();
        }

        public Locale getLocale() {
            return Component.this.getLocale();
        }

        public Point getLocation() {
            return Component.this.getLocation();
        }

        public Point getLocationOnScreen() {
            synchronized (Component.this.getTreeLock()) {
                try {
                    if (!Component.this.isShowing()) {
                        return null;
                    }
                    return Component.this.getLocationOnScreen();
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        public Dimension getSize() {
            return Component.this.getSize();
        }

        public boolean isEnabled() {
            return Component.this.isEnabled();
        }

        public boolean isFocusTraversable() {
            return Component.this.isFocusTraversable();
        }

        public boolean isShowing() {
            return Component.this.isShowing();
        }

        public boolean isVisible() {
            return Component.this.isVisible();
        }

        public void removeFocusListener(FocusListener focusListener) {
            Component.this.removeFocusListener(focusListener);
        }

        public void removePropertyChangeListener(PropertyChangeListener propertyChangeListener) {
            ComponentListener componentListener = this.accessibleAWTComponentHandler;
            if (componentListener != null) {
                Component.this.removeComponentListener(componentListener);
                this.accessibleAWTComponentHandler = null;
            }
            FocusListener focusListener = this.accessibleAWTFocusHandler;
            if (focusListener != null) {
                Component.this.removeFocusListener(focusListener);
                this.accessibleAWTFocusHandler = null;
            }
            super.removePropertyChangeListener(propertyChangeListener);
        }

        public void requestFocus() {
            Component.this.requestFocus();
        }

        public void setBackground(Color color) {
            Component.this.setBackground(color);
        }

        public void setBounds(Rectangle rectangle) {
            Component.this.setBounds(rectangle);
        }

        public void setCursor(Cursor cursor) {
            Component.this.setCursor(cursor);
        }

        public void setEnabled(boolean z) {
            AccessibleContext accessibleContext;
            boolean zIsEnabled = Component.this.isEnabled();
            Component.this.setEnabled(z);
            if (z == zIsEnabled || (accessibleContext = Component.this.accessibleContext) == null) {
                return;
            }
            if (z) {
                accessibleContext.firePropertyChange("AccessibleState", (Object) null, AccessibleState.ENABLED);
            } else {
                accessibleContext.firePropertyChange("AccessibleState", AccessibleState.ENABLED, (Object) null);
            }
        }

        public void setFont(Font font) {
            Component.this.setFont(font);
        }

        public void setForeground(Color color) {
            Component.this.setForeground(color);
        }

        public void setLocation(Point point) {
            Component.this.setLocation(point);
        }

        public void setSize(Dimension dimension) {
            Component.this.setSize(dimension);
        }

        public void setVisible(boolean z) throws Throwable {
            AccessibleContext accessibleContext;
            boolean zIsVisible = Component.this.isVisible();
            Component.this.setVisible(z);
            if (z == zIsVisible || (accessibleContext = Component.this.accessibleContext) == null) {
                return;
            }
            if (z) {
                accessibleContext.firePropertyChange("AccessibleState", (Object) null, AccessibleState.VISIBLE);
            } else {
                accessibleContext.firePropertyChange("AccessibleState", AccessibleState.VISIBLE, (Object) null);
            }
        }

        public AccessibleComponent getAccessibleComponent() {
            return this;
        }

        public class AccessibleAWTComponentHandler implements ComponentListener {
            public AccessibleAWTComponentHandler() {
            }

            public void componentHidden(ComponentEvent componentEvent) {
                AccessibleContext accessibleContext = Component.this.accessibleContext;
                if (accessibleContext != null) {
                    accessibleContext.firePropertyChange("AccessibleState", AccessibleState.VISIBLE, (Object) null);
                }
            }

            public void componentShown(ComponentEvent componentEvent) {
                AccessibleContext accessibleContext = Component.this.accessibleContext;
                if (accessibleContext != null) {
                    accessibleContext.firePropertyChange("AccessibleState", (Object) null, AccessibleState.VISIBLE);
                }
            }

            public void componentMoved(ComponentEvent componentEvent) {
            }

            public void componentResized(ComponentEvent componentEvent) {
            }
        }
    }

    public class SingleBufferStrategy extends BufferStrategy {
        private BufferCapabilities caps;

        public SingleBufferStrategy(BufferCapabilities bufferCapabilities) {
            this.caps = bufferCapabilities;
        }

        @Override // org.apache.poi.java.awt.image.BufferStrategy
        public boolean contentsLost() {
            return false;
        }

        @Override // org.apache.poi.java.awt.image.BufferStrategy
        public boolean contentsRestored() {
            return false;
        }

        @Override // org.apache.poi.java.awt.image.BufferStrategy
        public BufferCapabilities getCapabilities() {
            return this.caps;
        }

        @Override // org.apache.poi.java.awt.image.BufferStrategy
        public Graphics getDrawGraphics() {
            return Component.this.getGraphics();
        }

        @Override // org.apache.poi.java.awt.image.BufferStrategy
        public void show() {
        }
    }

    public void clearCurrentFocusCycleRootOnHide() {
    }

    @Deprecated
    public void layout() {
    }

    public void mixOnValidating() {
    }

    public void autoProcessMouseWheel(MouseWheelEvent mouseWheelEvent) {
    }

    public void paint(Graphics graphics) {
    }

    public void paintHeavyweightComponents(Graphics graphics) {
    }

    public void printHeavyweightComponents(Graphics graphics) {
    }

    public void processEvent(AWTEvent aWTEvent) {
    }
}
