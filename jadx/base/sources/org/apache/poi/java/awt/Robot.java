package org.apache.poi.java.awt;

import androidx.core.view.MotionEventCompat;
import java.io.PrintStream;
import java.lang.reflect.InvocationTargetException;
import java.util.Hashtable;
import org.apache.poi.java.awt.event.InputEvent;
import org.apache.poi.java.awt.image.BufferedImage;
import org.apache.poi.java.awt.image.ColorModel;
import org.apache.poi.java.awt.image.DataBufferInt;
import org.apache.poi.java.awt.image.DirectColorModel;
import org.apache.poi.java.awt.image.Raster;
import org.apache.poi.java.awt.image.WritableRaster;
import org.apache.poi.java.awt.peer.RobotPeer;
import org.apache.poi.sun.awt.ComponentFactory;
import org.apache.poi.sun.awt.SunToolkit;
import org.apache.poi.sun.awt.image.SunWritableRaster;
import org.apache.poi.sun.java2d.Disposer;
import org.apache.poi.sun.java2d.DisposerRecord;
import org.apache.poi.sun.security.util.SecurityConstants;

/* JADX INFO: loaded from: classes10.dex */
public class Robot {
    private static int LEGAL_BUTTON_MASK = 0;
    private static final int MAX_DELAY = 60000;
    private transient RobotDisposer disposer;
    private Point gdLoc;
    private RobotPeer peer;
    private boolean isAutoWaitForIdle = false;
    private int autoDelay = 0;
    private DirectColorModel screenCapCM = null;
    private transient Object anchor = new Object();

    public static class RobotDisposer implements DisposerRecord {
        private final RobotPeer peer;

        public RobotDisposer(RobotPeer robotPeer) {
            this.peer = robotPeer;
        }

        @Override // org.apache.poi.sun.java2d.DisposerRecord
        public void dispose() {
            RobotPeer robotPeer = this.peer;
            if (robotPeer != null) {
                robotPeer.dispose();
            }
        }
    }

    public Robot() throws AWTException {
        if (GraphicsEnvironment.isHeadless()) {
            throw new AWTException("headless environment");
        }
        init(GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice());
    }

    private void afterEvent() {
        autoWaitForIdle();
        autoDelay();
    }

    private void autoDelay() {
        delay(this.autoDelay);
    }

    private void autoWaitForIdle() {
        if (this.isAutoWaitForIdle) {
            waitForIdle();
        }
    }

    private void checkButtonsArgument(int i) {
        int i2 = LEGAL_BUTTON_MASK;
        if ((i | i2) != i2) {
            throw new IllegalArgumentException("Invalid combination of button flags");
        }
    }

    private void checkDelayArgument(int i) {
        if (i < 0 || i > 60000) {
            throw new IllegalArgumentException("Delay must be to 0 to 60,000ms");
        }
    }

    private void checkIsScreenDevice(GraphicsDevice graphicsDevice) {
        if (graphicsDevice == null || graphicsDevice.getType() != 0) {
            throw new IllegalArgumentException("not a valid screen device");
        }
    }

    private void checkKeycodeArgument(int i) {
        if (i == 0) {
            throw new IllegalArgumentException("Invalid key code");
        }
    }

    private void checkNotDispatchThread() {
        if (EventQueue.isDispatchThread()) {
            throw new IllegalThreadStateException("Cannot call method from the event dispatcher thread");
        }
    }

    private void checkRobotAllowed() {
        SecurityManager securityManager = System.getSecurityManager();
        if (securityManager != null) {
            securityManager.checkPermission(SecurityConstants.AWT.CREATE_ROBOT_PERMISSION);
        }
    }

    private static void checkScreenCaptureAllowed() {
        SecurityManager securityManager = System.getSecurityManager();
        if (securityManager != null) {
            securityManager.checkPermission(SecurityConstants.AWT.READ_DISPLAY_PIXELS_PERMISSION);
        }
    }

    private static void checkValidRect(Rectangle rectangle) {
        if (rectangle.width <= 0 || rectangle.height <= 0) {
            throw new IllegalArgumentException("Rectangle width and height must be > 0");
        }
    }

    private void init(GraphicsDevice graphicsDevice) {
        checkRobotAllowed();
        this.gdLoc = graphicsDevice.getDefaultConfiguration().getBounds().getLocation();
        Object defaultToolkit = Toolkit.getDefaultToolkit();
        if (defaultToolkit instanceof ComponentFactory) {
            RobotPeer robotPeerCreateRobot = ((ComponentFactory) defaultToolkit).createRobot(this, graphicsDevice);
            this.peer = robotPeerCreateRobot;
            RobotDisposer robotDisposer = new RobotDisposer(robotPeerCreateRobot);
            this.disposer = robotDisposer;
            Disposer.addRecord(this.anchor, robotDisposer);
        }
        initLegalButtonMask();
    }

    private static synchronized void initLegalButtonMask() {
        try {
            if (LEGAL_BUTTON_MASK != 0) {
                return;
            }
            int i = 0;
            if (Toolkit.getDefaultToolkit().areExtraMouseButtonsEnabled() && (Toolkit.getDefaultToolkit() instanceof SunToolkit)) {
                int numberOfButtons = ((SunToolkit) Toolkit.getDefaultToolkit()).getNumberOfButtons();
                int maskForButton = 0;
                while (i < numberOfButtons) {
                    i++;
                    maskForButton |= InputEvent.getMaskForButton(i);
                }
                i = maskForButton;
            }
            LEGAL_BUTTON_MASK = i | 7196;
        } catch (Throwable th) {
            throw th;
        }
    }

    public synchronized BufferedImage createScreenCapture(Rectangle rectangle) {
        WritableRaster writableRasterCreatePackedRaster;
        try {
            checkScreenCaptureAllowed();
            Rectangle rectangle2 = new Rectangle(rectangle);
            Point point = this.gdLoc;
            rectangle2.translate(point.f10092x, point.f10093y);
            checkValidRect(rectangle2);
            if (this.screenCapCM == null) {
                this.screenCapCM = new DirectColorModel(24, 16711680, MotionEventCompat.ACTION_POINTER_INDEX_MASK, 255);
            }
            Toolkit.getDefaultToolkit().sync();
            int[] rGBPixels = this.peer.getRGBPixels(rectangle2);
            DataBufferInt dataBufferInt = new DataBufferInt(rGBPixels, rGBPixels.length);
            int[] iArr = {this.screenCapCM.getRedMask(), this.screenCapCM.getGreenMask(), this.screenCapCM.getBlueMask()};
            int i = rectangle2.width;
            writableRasterCreatePackedRaster = Raster.createPackedRaster(dataBufferInt, i, rectangle2.height, i, iArr, (Point) null);
            SunWritableRaster.makeTrackable(dataBufferInt);
        } catch (Throwable th) {
            throw th;
        }
        return new BufferedImage((ColorModel) this.screenCapCM, writableRasterCreatePackedRaster, false, (Hashtable<?, ?>) null);
    }

    public synchronized void delay(int i) {
        checkDelayArgument(i);
        try {
            Thread.sleep(i);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public synchronized int getAutoDelay() {
        return this.autoDelay;
    }

    public synchronized Color getPixelColor(int i, int i2) {
        RobotPeer robotPeer;
        Point point;
        robotPeer = this.peer;
        point = this.gdLoc;
        return new Color(robotPeer.getRGBPixel(point.f10092x + i, point.f10093y + i2));
    }

    public synchronized boolean isAutoWaitForIdle() {
        return this.isAutoWaitForIdle;
    }

    public synchronized void keyPress(int i) {
        checkKeycodeArgument(i);
        this.peer.keyPress(i);
        afterEvent();
    }

    public synchronized void keyRelease(int i) {
        checkKeycodeArgument(i);
        this.peer.keyRelease(i);
        afterEvent();
    }

    public synchronized void mouseMove(int i, int i2) {
        RobotPeer robotPeer = this.peer;
        Point point = this.gdLoc;
        robotPeer.mouseMove(point.f10092x + i, point.f10093y + i2);
        afterEvent();
    }

    public synchronized void mousePress(int i) {
        checkButtonsArgument(i);
        this.peer.mousePress(i);
        afterEvent();
    }

    public synchronized void mouseRelease(int i) {
        checkButtonsArgument(i);
        this.peer.mouseRelease(i);
        afterEvent();
    }

    public synchronized void mouseWheel(int i) {
        this.peer.mouseWheel(i);
        afterEvent();
    }

    public synchronized void setAutoDelay(int i) {
        checkDelayArgument(i);
        this.autoDelay = i;
    }

    public synchronized void setAutoWaitForIdle(boolean z) {
        this.isAutoWaitForIdle = z;
    }

    public synchronized String toString() {
        return getClass().getName() + "[ " + ("autoDelay = " + getAutoDelay() + ", autoWaitForIdle = " + isAutoWaitForIdle()) + " ]";
    }

    public synchronized void waitForIdle() {
        PrintStream printStream;
        String str;
        checkNotDispatchThread();
        try {
            try {
                SunToolkit.flushPendingEvents();
                EventQueue.invokeAndWait(new Runnable() { // from class: org.apache.poi.java.awt.Robot.1
                    @Override // java.lang.Runnable
                    public void run() {
                    }
                });
            } catch (InterruptedException e) {
                e = e;
                printStream = System.err;
                str = "Robot.waitForIdle, non-fatal exception caught:";
                printStream.println(str);
                e.printStackTrace();
            }
        } catch (InvocationTargetException e2) {
            e = e2;
            printStream = System.err;
            str = "Robot.waitForIdle, non-fatal exception caught:";
            printStream.println(str);
            e.printStackTrace();
        }
    }

    public Robot(GraphicsDevice graphicsDevice) {
        checkIsScreenDevice(graphicsDevice);
        init(graphicsDevice);
    }
}
