package org.apache.poi.java.awt;

import org.apache.poi.sun.awt.AppContext;
import org.apache.poi.sun.awt.SunToolkit;

/* JADX INFO: loaded from: classes10.dex */
public abstract class GraphicsDevice {
    public static final int TYPE_IMAGE_BUFFER = 2;
    public static final int TYPE_PRINTER = 1;
    public static final int TYPE_RASTER_SCREEN = 0;
    private final Object fsAppContextLock = new Object();
    private AppContext fullScreenAppContext;
    private Window fullScreenWindow;
    private Rectangle windowedModeBounds;

    /* JADX INFO: renamed from: org.apache.poi.java.awt.GraphicsDevice$1 */
    public static /* synthetic */ class C140131 {
        static final /* synthetic */ int[] $SwitchMap$java$awt$GraphicsDevice$WindowTranslucency;

        static {
            int[] iArr = new int[WindowTranslucency.values().length];
            $SwitchMap$java$awt$GraphicsDevice$WindowTranslucency = iArr;
            try {
                iArr[WindowTranslucency.PERPIXEL_TRANSPARENT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$java$awt$GraphicsDevice$WindowTranslucency[WindowTranslucency.TRANSLUCENT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$java$awt$GraphicsDevice$WindowTranslucency[WindowTranslucency.PERPIXEL_TRANSLUCENT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public enum WindowTranslucency {
        PERPIXEL_TRANSPARENT,
        TRANSLUCENT,
        PERPIXEL_TRANSLUCENT
    }

    public static boolean isWindowOpacitySupported() {
        Toolkit defaultToolkit = Toolkit.getDefaultToolkit();
        if (defaultToolkit instanceof SunToolkit) {
            return ((SunToolkit) defaultToolkit).isWindowOpacitySupported();
        }
        return false;
    }

    public static boolean isWindowShapingSupported() {
        Toolkit defaultToolkit = Toolkit.getDefaultToolkit();
        if (defaultToolkit instanceof SunToolkit) {
            return ((SunToolkit) defaultToolkit).isWindowShapingSupported();
        }
        return false;
    }

    public int getAvailableAcceleratedMemory() {
        return -1;
    }

    public GraphicsConfiguration getBestConfiguration(GraphicsConfigTemplate graphicsConfigTemplate) {
        return graphicsConfigTemplate.getBestConfiguration(getConfigurations());
    }

    public abstract GraphicsConfiguration[] getConfigurations();

    public abstract GraphicsConfiguration getDefaultConfiguration();

    public DisplayMode getDisplayMode() {
        GraphicsConfiguration defaultConfiguration = getDefaultConfiguration();
        Rectangle bounds = defaultConfiguration.getBounds();
        return new DisplayMode(bounds.width, bounds.height, defaultConfiguration.getColorModel().getPixelSize(), 0);
    }

    public DisplayMode[] getDisplayModes() {
        return new DisplayMode[]{getDisplayMode()};
    }

    public Window getFullScreenWindow() {
        Window window;
        synchronized (this.fsAppContextLock) {
            try {
                window = this.fullScreenAppContext == AppContext.getAppContext() ? this.fullScreenWindow : null;
            } catch (Throwable th) {
                throw th;
            }
        }
        return window;
    }

    public abstract String getIDstring();

    public GraphicsConfiguration getTranslucencyCapableGC() {
        GraphicsConfiguration defaultConfiguration = getDefaultConfiguration();
        if (defaultConfiguration.isTranslucencyCapable()) {
            return defaultConfiguration;
        }
        GraphicsConfiguration[] configurations = getConfigurations();
        for (int i = 0; i < configurations.length; i++) {
            if (configurations[i].isTranslucencyCapable()) {
                return configurations[i];
            }
        }
        return null;
    }

    public abstract int getType();

    public boolean isDisplayChangeSupported() {
        return false;
    }

    public boolean isFullScreenSupported() {
        return false;
    }

    public boolean isWindowPerpixelTranslucencySupported() {
        Toolkit defaultToolkit = Toolkit.getDefaultToolkit();
        return (defaultToolkit instanceof SunToolkit) && ((SunToolkit) defaultToolkit).isWindowTranslucencySupported() && getTranslucencyCapableGC() != null;
    }

    public boolean isWindowTranslucencySupported(WindowTranslucency windowTranslucency) {
        int i = C140131.$SwitchMap$java$awt$GraphicsDevice$WindowTranslucency[windowTranslucency.ordinal()];
        if (i == 1) {
            return isWindowShapingSupported();
        }
        if (i == 2) {
            return isWindowOpacitySupported();
        }
        if (i != 3) {
            return false;
        }
        return isWindowPerpixelTranslucencySupported();
    }

    public void setDisplayMode(DisplayMode displayMode) {
        throw new UnsupportedOperationException("Cannot change display mode");
    }

    public void setFullScreenWindow(Window window) {
        Rectangle rectangle;
        AppContext appContext = null;
        if (window != null) {
            if (window.getShape() != null) {
                window.setShape(null);
            }
            if (window.getOpacity() < 1.0f) {
                window.setOpacity(1.0f);
            }
            if (!window.isOpaque()) {
                Color background = window.getBackground();
                window.setBackground(new Color(background.getRed(), background.getGreen(), background.getBlue(), 255));
            }
            GraphicsConfiguration graphicsConfiguration = window.getGraphicsConfiguration();
            if (graphicsConfiguration != null && graphicsConfiguration.getDevice() != this && graphicsConfiguration.getDevice().getFullScreenWindow() == window) {
                graphicsConfiguration.getDevice().setFullScreenWindow(null);
            }
        }
        Window window2 = this.fullScreenWindow;
        if (window2 != null && (rectangle = this.windowedModeBounds) != null) {
            if (rectangle.width == 0) {
                rectangle.width = 1;
            }
            if (rectangle.height == 0) {
                rectangle.height = 1;
            }
            window2.setBounds(rectangle);
        }
        synchronized (this.fsAppContextLock) {
            if (window != null) {
                try {
                    appContext = AppContext.getAppContext();
                } catch (Throwable th) {
                    throw th;
                }
            }
            this.fullScreenAppContext = appContext;
            this.fullScreenWindow = window;
        }
        if (window != null) {
            this.windowedModeBounds = window.getBounds();
            Rectangle bounds = getDefaultConfiguration().getBounds();
            this.fullScreenWindow.setBounds(bounds.f10094x, bounds.f10095y, bounds.width, bounds.height);
            this.fullScreenWindow.setVisible(true);
            this.fullScreenWindow.toFront();
        }
    }
}
