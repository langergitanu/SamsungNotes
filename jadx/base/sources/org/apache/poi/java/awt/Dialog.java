package org.apache.poi.java.awt;

import androidx.appcompat.widget.AbstractC0541b;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.security.AccessControlException;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicLong;
import javax.accessibility.AccessibleContext;
import javax.accessibility.AccessibleRole;
import javax.accessibility.AccessibleState;
import javax.accessibility.AccessibleStateSet;
import org.apache.poi.java.awt.Window;
import org.apache.poi.java.awt.event.ComponentEvent;
import org.apache.poi.java.awt.event.InvocationEvent;
import org.apache.poi.java.awt.peer.DialogPeer;
import org.apache.poi.sun.awt.AppContext;
import org.apache.poi.sun.awt.SunToolkit;
import org.apache.poi.sun.awt.util.IdentityArrayList;
import org.apache.poi.sun.awt.util.IdentityLinkedList;
import org.apache.poi.sun.security.util.SecurityConstants;

/* JADX INFO: loaded from: classes10.dex */
public class Dialog extends Window {
    public static final ModalityType DEFAULT_MODALITY_TYPE;
    private static final String base = "dialog";
    static transient IdentityArrayList<Dialog> modalDialogs = null;
    private static int nameCounter = 0;
    private static final long serialVersionUID = 5920926903803293709L;
    transient IdentityArrayList<Window> blockedWindows;
    private transient boolean initialized;
    volatile transient boolean isInDispose;
    volatile transient boolean isInHide;
    boolean modal;
    private transient ModalEventFilter modalFilter;
    ModalityType modalityType;
    boolean resizable;
    private volatile transient SecondaryLoop secondaryLoop;
    String title;
    boolean undecorated;

    /* JADX INFO: renamed from: org.apache.poi.java.awt.Dialog$4 */
    public static /* synthetic */ class C139994 {
        static final /* synthetic */ int[] $SwitchMap$java$awt$Dialog$ModalityType;

        static {
            int[] iArr = new int[ModalityType.values().length];
            $SwitchMap$java$awt$Dialog$ModalityType = iArr;
            try {
                iArr[ModalityType.MODELESS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$java$awt$Dialog$ModalityType[ModalityType.DOCUMENT_MODAL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$java$awt$Dialog$ModalityType[ModalityType.APPLICATION_MODAL.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$java$awt$Dialog$ModalityType[ModalityType.TOOLKIT_MODAL.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public class AccessibleAWTDialog extends Window.AccessibleAWTWindow {
        private static final long serialVersionUID = 4837230331833941201L;

        public AccessibleAWTDialog() {
            super();
        }

        @Override // org.apache.poi.java.awt.Window.AccessibleAWTWindow, org.apache.poi.java.awt.Component.AccessibleAWTComponent
        public AccessibleRole getAccessibleRole() {
            return AccessibleRole.DIALOG;
        }

        @Override // org.apache.poi.java.awt.Window.AccessibleAWTWindow, org.apache.poi.java.awt.Component.AccessibleAWTComponent
        public AccessibleStateSet getAccessibleStateSet() {
            AccessibleStateSet accessibleStateSet = super.getAccessibleStateSet();
            if (Dialog.this.getFocusOwner() != null) {
                accessibleStateSet.add(AccessibleState.ACTIVE);
            }
            if (Dialog.this.isModal()) {
                accessibleStateSet.add(AccessibleState.MODAL);
            }
            if (Dialog.this.isResizable()) {
                accessibleStateSet.add(AccessibleState.RESIZABLE);
            }
            return accessibleStateSet;
        }
    }

    public enum ModalExclusionType {
        NO_EXCLUDE,
        APPLICATION_EXCLUDE,
        TOOLKIT_EXCLUDE
    }

    public enum ModalityType {
        MODELESS,
        DOCUMENT_MODAL,
        APPLICATION_MODAL,
        TOOLKIT_MODAL
    }

    static {
        Toolkit.loadLibraries();
        if (!GraphicsEnvironment.isHeadless()) {
            initIDs();
        }
        DEFAULT_MODALITY_TYPE = ModalityType.APPLICATION_MODAL;
        modalDialogs = new IdentityArrayList<>();
        nameCounter = 0;
    }

    public Dialog(Dialog dialog) {
        this(dialog, "", false);
    }

    private void checkModalityPermission(ModalityType modalityType) {
        SecurityManager securityManager;
        if (modalityType != ModalityType.TOOLKIT_MODAL || (securityManager = System.getSecurityManager()) == null) {
            return;
        }
        securityManager.checkPermission(SecurityConstants.AWT.TOOLKIT_MODALITY_PERMISSION);
    }

    public static void checkShouldBeBlocked(Window window) {
        synchronized (window.getTreeLock()) {
            int i = 0;
            while (true) {
                try {
                    if (i >= modalDialogs.size()) {
                        break;
                    }
                    Dialog dialog = (Dialog) modalDialogs.get(i);
                    if (dialog.shouldBlock(window)) {
                        dialog.blockWindow(window);
                        break;
                    }
                    i++;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    private boolean conditionalShow(Component component, AtomicLong atomicLong) throws Throwable {
        Throwable th;
        Dialog dialog;
        closeSplashScreen();
        synchronized (getTreeLock()) {
            try {
                try {
                    if (this.peer == null) {
                        try {
                            addNotify();
                        } catch (Throwable th2) {
                            th = th2;
                            throw th;
                        }
                    }
                    validateUnconditionally();
                    boolean z = false;
                    if (this.visible) {
                        toFront();
                        dialog = this;
                    } else {
                        this.visible = true;
                        if (isModal()) {
                            modalDialogs.add(this);
                            modalShow();
                        } else {
                            checkShouldBeBlocked(this);
                        }
                        if (component != null && atomicLong != null && isFocusable() && isEnabled() && !isModalBlocked()) {
                            atomicLong.set(Toolkit.getEventQueue().getMostRecentEventTimeEx());
                            KeyboardFocusManager.getCurrentKeyboardFocusManager().enqueueKeyEvents(atomicLong.get(), component);
                        }
                        mixOnShowing();
                        this.peer.setVisible(true);
                        if (isModalBlocked()) {
                            this.modalBlocker.toFront();
                        }
                        setLocationByPlatform(false);
                        for (int i = 0; i < this.ownedWindowList.size(); i++) {
                            Window window = this.ownedWindowList.elementAt(i).get();
                            if (window != null && window.showWithParent) {
                                window.show();
                                window.showWithParent = false;
                            }
                        }
                        Window.updateChildFocusableWindowState(this);
                        dialog = this;
                        dialog.createHierarchyEvents(1400, this, this.parent, 4L, Toolkit.enabledOnToolkit(32768L));
                        if (dialog.componentListener != null || (dialog.eventMask & 1) != 0 || Toolkit.enabledOnToolkit(1L)) {
                            Toolkit.getEventQueue().postEvent(new ComponentEvent(this, 102));
                        }
                        z = true;
                    }
                    if (z && (dialog.state & 1) == 0) {
                        postWindowEvent(200);
                        dialog.state |= 1;
                    }
                    return z;
                } catch (Throwable th3) {
                    th = th3;
                    th = th;
                    throw th;
                }
            } catch (Throwable th4) {
                th = th4;
                th = th;
                throw th;
            }
        }
    }

    private void hideAndDisposeHandler() {
        if (this.secondaryLoop != null) {
            this.secondaryLoop.exit();
            this.secondaryLoop = null;
        }
        this.isInHide = false;
    }

    private void hideAndDisposePreHandler() {
        this.isInHide = true;
        synchronized (getTreeLock()) {
            try {
                if (this.secondaryLoop != null) {
                    modalHide();
                    ModalEventFilter modalEventFilter = this.modalFilter;
                    if (modalEventFilter != null) {
                        modalEventFilter.disable();
                    }
                    modalDialogs.remove(this);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private static native void initIDs();

    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        GraphicsEnvironment.checkHeadless();
        ObjectInputStream.GetField fields = objectInputStream.readFields();
        ModalityType modalityType = (ModalityType) fields.get("modalityType", (Object) null);
        try {
            checkModalityPermission(modalityType);
        } catch (AccessControlException unused) {
            modalityType = DEFAULT_MODALITY_TYPE;
        }
        if (modalityType == null) {
            boolean z = fields.get("modal", false);
            this.modal = z;
            setModal(z);
        } else {
            this.modalityType = modalityType;
        }
        this.resizable = fields.get("resizable", true);
        this.undecorated = fields.get("undecorated", false);
        this.title = (String) fields.get("title", "");
        this.blockedWindows = new IdentityArrayList<>();
        SunToolkit.checkAndSetPolicy(this);
        this.initialized = true;
    }

    @Override // org.apache.poi.java.awt.Window, org.apache.poi.java.awt.Container, org.apache.poi.java.awt.Component
    public void addNotify() {
        synchronized (getTreeLock()) {
            try {
                Container container = this.parent;
                if (container != null && container.getPeer() == null) {
                    this.parent.addNotify();
                }
                if (this.peer == null) {
                    this.peer = getToolkit().createDialog(this);
                }
                super.addNotify();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void blockWindow(Window window) {
        if (window.isModalBlocked()) {
            return;
        }
        window.setModalBlocked(this, true, true);
        this.blockedWindows.add(window);
    }

    public void blockWindows(java.util.List<Window> list) {
        DialogPeer dialogPeer = this.peer;
        if (dialogPeer == null) {
            return;
        }
        Iterator<Window> it = list.iterator();
        while (it.hasNext()) {
            Window next = it.next();
            if (next.isModalBlocked()) {
                it.remove();
            } else {
                next.setModalBlocked(this, true, false);
            }
        }
        dialogPeer.blockWindows(list);
        this.blockedWindows.addAll(list);
    }

    @Override // org.apache.poi.java.awt.Window, org.apache.poi.java.awt.Component
    public String constructComponentName() {
        String string;
        synchronized (Dialog.class) {
            StringBuilder sb = new StringBuilder(base);
            int i = nameCounter;
            nameCounter = i + 1;
            sb.append(i);
            string = sb.toString();
        }
        return string;
    }

    @Override // org.apache.poi.java.awt.Window
    public void doDispose() {
        this.isInDispose = true;
        super.doDispose();
        hideAndDisposeHandler();
        this.isInDispose = false;
    }

    @Override // org.apache.poi.java.awt.Window, org.apache.poi.java.awt.Component
    public AccessibleContext getAccessibleContext() {
        if (this.accessibleContext == null) {
            this.accessibleContext = new AccessibleAWTDialog();
        }
        return this.accessibleContext;
    }

    public ModalityType getModalityType() {
        return this.modalityType;
    }

    public String getTitle() {
        return this.title;
    }

    @Override // org.apache.poi.java.awt.Window, org.apache.poi.java.awt.Component
    @Deprecated
    public void hide() {
        hideAndDisposePreHandler();
        super.hide();
        if (this.isInDispose) {
            return;
        }
        hideAndDisposeHandler();
    }

    public void interruptBlocking() {
        if (isModal()) {
            disposeImpl();
            return;
        }
        RuntimeException runtimeException = this.windowClosingException;
        if (runtimeException != null) {
            runtimeException.fillInStackTrace();
            this.windowClosingException.printStackTrace();
            this.windowClosingException = null;
        }
    }

    public boolean isModal() {
        return isModal_NoClientCode();
    }

    public final boolean isModal_NoClientCode() {
        return this.modalityType != ModalityType.MODELESS;
    }

    public boolean isResizable() {
        return this.resizable;
    }

    public boolean isUndecorated() {
        return this.undecorated;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0039  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void modalHide() {
        IdentityArrayList identityArrayList = new IdentityArrayList();
        int size = this.blockedWindows.size();
        for (int i = 0; i < size; i++) {
            Window window = (Window) this.blockedWindows.get(0);
            identityArrayList.add(window);
            unblockWindow(window);
        }
        for (int i2 = 0; i2 < size; i2++) {
            Window window2 = (Window) identityArrayList.get(i2);
            if (window2 instanceof Dialog) {
                Dialog dialog = (Dialog) window2;
                if (dialog.isModal_NoClientCode()) {
                    dialog.modalShow();
                } else {
                    checkShouldBeBlocked(window2);
                }
            }
        }
    }

    public void modalShow() {
        IdentityArrayList identityArrayList = new IdentityArrayList();
        for (Dialog dialog : modalDialogs) {
            if (dialog.shouldBlock(this)) {
                Window owner_NoClientCode = dialog;
                while (owner_NoClientCode != null && owner_NoClientCode != this) {
                    owner_NoClientCode = owner_NoClientCode.getOwner_NoClientCode();
                }
                if (owner_NoClientCode == this || !shouldBlock(dialog) || this.modalityType.compareTo(dialog.getModalityType()) < 0) {
                    identityArrayList.add(dialog);
                }
            }
        }
        for (int i = 0; i < identityArrayList.size(); i++) {
            Dialog dialog2 = (Dialog) identityArrayList.get(i);
            if (dialog2.isModalBlocked()) {
                Dialog modalBlocker = dialog2.getModalBlocker();
                if (!identityArrayList.contains(modalBlocker)) {
                    identityArrayList.add(i + 1, modalBlocker);
                }
            }
        }
        if (identityArrayList.size() > 0) {
            ((Dialog) identityArrayList.get(0)).blockWindow(this);
        }
        IdentityArrayList identityArrayList2 = new IdentityArrayList(identityArrayList);
        for (int i2 = 0; i2 < identityArrayList2.size(); i2++) {
            for (Window window : ((Window) identityArrayList2.get(i2)).getOwnedWindows_NoClientCode()) {
                identityArrayList2.add(window);
            }
        }
        java.util.List<Window> identityLinkedList = new IdentityLinkedList<>();
        for (Window window2 : Window.getAllUnblockedWindows()) {
            if (shouldBlock(window2) && !identityArrayList2.contains(window2)) {
                if (window2 instanceof Dialog) {
                    Dialog dialog3 = (Dialog) window2;
                    if (!dialog3.isModal_NoClientCode() || !dialog3.shouldBlock(this) || modalDialogs.indexOf(dialog3) <= modalDialogs.indexOf(this)) {
                    }
                }
                identityLinkedList.add(window2);
            }
        }
        blockWindows(identityLinkedList);
        if (isModalBlocked()) {
            return;
        }
        updateChildrenBlocking();
    }

    public final void modalityPopped() {
        Toolkit defaultToolkit = Toolkit.getDefaultToolkit();
        if (defaultToolkit instanceof SunToolkit) {
            ((SunToolkit) defaultToolkit).notifyModalityPopped(this);
        }
    }

    public final void modalityPushed() {
        Toolkit defaultToolkit = Toolkit.getDefaultToolkit();
        if (defaultToolkit instanceof SunToolkit) {
            ((SunToolkit) defaultToolkit).notifyModalityPushed(this);
        }
    }

    @Override // org.apache.poi.java.awt.Container, org.apache.poi.java.awt.Component
    public String paramString() {
        String str = super.paramString() + "," + this.modalityType;
        if (this.title == null) {
            return str;
        }
        StringBuilder sbM781w = AbstractC0541b.m781w(str, ",title=");
        sbM781w.append(this.title);
        return sbM781w.toString();
    }

    @Override // org.apache.poi.java.awt.Window, org.apache.poi.java.awt.Component
    public void setBackground(Color color) {
        synchronized (getTreeLock()) {
            if (color != null) {
                try {
                    if (color.getAlpha() < 255 && !isUndecorated()) {
                        throw new IllegalComponentStateException("The dialog is decorated");
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            super.setBackground(color);
        }
    }

    public void setModal(boolean z) {
        this.modal = z;
        setModalityType(z ? DEFAULT_MODALITY_TYPE : ModalityType.MODELESS);
    }

    public void setModalityType(ModalityType modalityType) {
        if (modalityType == null) {
            modalityType = ModalityType.MODELESS;
        }
        if (!Toolkit.getDefaultToolkit().isModalityTypeSupported(modalityType)) {
            modalityType = ModalityType.MODELESS;
        }
        if (this.modalityType == modalityType) {
            return;
        }
        checkModalityPermission(modalityType);
        this.modalityType = modalityType;
        this.modal = modalityType != ModalityType.MODELESS;
    }

    @Override // org.apache.poi.java.awt.Window
    public void setOpacity(float f) {
        synchronized (getTreeLock()) {
            if (f < 1.0f) {
                try {
                    if (!isUndecorated()) {
                        throw new IllegalComponentStateException("The dialog is decorated");
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
        synchronized (this) {
            try {
                this.resizable = z;
                DialogPeer dialogPeer = this.peer;
                if (dialogPeer != null) {
                    dialogPeer.setResizable(z);
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
    }

    @Override // org.apache.poi.java.awt.Window
    public void setShape(Shape shape) {
        synchronized (getTreeLock()) {
            if (shape != null) {
                try {
                    if (!isUndecorated()) {
                        throw new IllegalComponentStateException("The dialog is decorated");
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            super.setShape(shape);
        }
    }

    public void setTitle(String str) {
        String str2 = this.title;
        synchronized (this) {
            try {
                this.title = str;
                DialogPeer dialogPeer = this.peer;
                if (dialogPeer != null) {
                    dialogPeer.setTitle(str);
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
                    throw new IllegalComponentStateException("The dialog is displayable.");
                }
                if (!z) {
                    if (getOpacity() < 1.0f) {
                        throw new IllegalComponentStateException("The dialog is not opaque");
                    }
                    if (getShape() != null) {
                        throw new IllegalComponentStateException("The dialog does not have a default shape");
                    }
                    Color background = getBackground();
                    if (background != null && background.getAlpha() < 255) {
                        throw new IllegalComponentStateException("The dialog background color is not opaque");
                    }
                }
                this.undecorated = z;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.apache.poi.java.awt.Window, org.apache.poi.java.awt.Component
    public void setVisible(boolean z) {
        super.setVisible(z);
    }

    public boolean shouldBlock(Window window) {
        if (!isVisible_NoClientCode() || (!(window.isVisible_NoClientCode() || window.isInShow) || this.isInHide || window == this || !isModal_NoClientCode() || ((window instanceof Dialog) && ((Dialog) window).isInHide))) {
            return false;
        }
        for (Dialog modalBlocker = this; modalBlocker != null; modalBlocker = modalBlocker.getModalBlocker()) {
            Container parent_NoClientCode = window;
            while (parent_NoClientCode != null && parent_NoClientCode != modalBlocker) {
                parent_NoClientCode = parent_NoClientCode.getParent_NoClientCode();
            }
            if (parent_NoClientCode == modalBlocker) {
                return false;
            }
        }
        int i = C139994.$SwitchMap$java$awt$Dialog$ModalityType[this.modalityType.ordinal()];
        if (i != 2) {
            if (i == 3) {
                return !window.isModalExcluded(ModalExclusionType.APPLICATION_EXCLUDE) && this.appContext == window.appContext;
            }
            if (i != 4) {
                return false;
            }
            return !window.isModalExcluded(ModalExclusionType.TOOLKIT_EXCLUDE);
        }
        if (!window.isModalExcluded(ModalExclusionType.APPLICATION_EXCLUDE)) {
            return getDocumentRoot() == window.getDocumentRoot();
        }
        Container parent_NoClientCode2 = this;
        while (parent_NoClientCode2 != null && parent_NoClientCode2 != window) {
            parent_NoClientCode2 = parent_NoClientCode2.getParent_NoClientCode();
        }
        return parent_NoClientCode2 == window;
    }

    @Override // org.apache.poi.java.awt.Window, org.apache.poi.java.awt.Component
    @Deprecated
    public void show() throws Throwable {
        Component mostRecentFocusOwner;
        if (!this.initialized) {
            throw new IllegalStateException("The dialog component has not been initialized properly");
        }
        this.beforeFirstShow = false;
        Component component = null;
        if (!isModal()) {
            conditionalShow(null, null);
            return;
        }
        AppContext appContext = AppContext.getAppContext();
        AtomicLong atomicLong = new AtomicLong();
        try {
            mostRecentFocusOwner = getMostRecentFocusOwner();
        } catch (Throwable th) {
            th = th;
        }
        try {
            if (conditionalShow(mostRecentFocusOwner, atomicLong)) {
                this.modalFilter = ModalEventFilter.createFilterForDialog(this);
                Conditional conditional = new Conditional() { // from class: org.apache.poi.java.awt.Dialog.1
                    @Override // org.apache.poi.java.awt.Conditional
                    public boolean evaluate() {
                        return Dialog.this.windowClosingException == null;
                    }
                };
                if (this.modalityType == ModalityType.TOOLKIT_MODAL) {
                    for (AppContext appContext2 : AppContext.getAppContexts()) {
                        if (appContext2 != appContext) {
                            EventQueue eventQueue = (EventQueue) appContext2.get(AppContext.EVENT_QUEUE_KEY);
                            eventQueue.postEvent(new InvocationEvent(this, new Runnable() { // from class: org.apache.poi.java.awt.Dialog.2
                                @Override // java.lang.Runnable
                                public void run() {
                                }
                            }));
                            eventQueue.getDispatchThread().addEventFilter(this.modalFilter);
                        }
                    }
                }
                modalityPushed();
                try {
                    this.secondaryLoop = ((EventQueue) AccessController.doPrivileged(new PrivilegedAction<EventQueue>() { // from class: org.apache.poi.java.awt.Dialog.3
                        @Override // java.security.PrivilegedAction
                        public EventQueue run() {
                            return Toolkit.getDefaultToolkit().getSystemEventQueue();
                        }
                    })).createSecondaryLoop(conditional, this.modalFilter, 0L);
                    if (!this.secondaryLoop.enter()) {
                        this.secondaryLoop = null;
                    }
                    modalityPopped();
                    if (this.modalityType == ModalityType.TOOLKIT_MODAL) {
                        for (AppContext appContext3 : AppContext.getAppContexts()) {
                            if (appContext3 != appContext) {
                                ((EventQueue) appContext3.get(AppContext.EVENT_QUEUE_KEY)).getDispatchThread().removeEventFilter(this.modalFilter);
                            }
                        }
                    }
                    RuntimeException runtimeException = this.windowClosingException;
                    if (runtimeException != null) {
                        runtimeException.fillInStackTrace();
                        throw this.windowClosingException;
                    }
                } catch (Throwable th2) {
                    modalityPopped();
                    throw th2;
                }
            }
            if (mostRecentFocusOwner != null) {
                KeyboardFocusManager.getCurrentKeyboardFocusManager().dequeueKeyEvents(atomicLong.get(), mostRecentFocusOwner);
            }
        } catch (Throwable th3) {
            th = th3;
            component = mostRecentFocusOwner;
            if (component != null) {
                KeyboardFocusManager.getCurrentKeyboardFocusManager().dequeueKeyEvents(atomicLong.get(), component);
            }
            throw th;
        }
    }

    @Override // org.apache.poi.java.awt.Window
    public void toBack() {
        super.toBack();
        if (this.visible) {
            synchronized (getTreeLock()) {
                try {
                    Iterator it = this.blockedWindows.iterator();
                    while (it.hasNext()) {
                        ((Window) it.next()).toBack_NoClientCode();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    public void unblockWindow(Window window) {
        if (window.isModalBlocked() && this.blockedWindows.contains(window)) {
            this.blockedWindows.remove(window);
            window.setModalBlocked(this, false, true);
        }
    }

    public Dialog(Dialog dialog, String str) {
        this(dialog, str, false);
    }

    public Dialog(Dialog dialog, String str, boolean z) {
        this(dialog, str, z ? DEFAULT_MODALITY_TYPE : ModalityType.MODELESS);
    }

    public Dialog(Dialog dialog, String str, boolean z, GraphicsConfiguration graphicsConfiguration) {
        this(dialog, str, z ? DEFAULT_MODALITY_TYPE : ModalityType.MODELESS, graphicsConfiguration);
    }

    public Dialog(Frame frame) {
        this(frame, "", false);
    }

    public Dialog(Frame frame, String str) {
        this(frame, str, false);
    }

    public Dialog(Frame frame, String str, boolean z) {
        this(frame, str, z ? DEFAULT_MODALITY_TYPE : ModalityType.MODELESS);
    }

    public Dialog(Frame frame, String str, boolean z, GraphicsConfiguration graphicsConfiguration) {
        this(frame, str, z ? DEFAULT_MODALITY_TYPE : ModalityType.MODELESS, graphicsConfiguration);
    }

    public Dialog(Frame frame, boolean z) {
        this(frame, "", z);
    }

    public Dialog(Window window) {
        this(window, "", ModalityType.MODELESS);
    }

    public Dialog(Window window, String str) {
        this(window, str, ModalityType.MODELESS);
    }

    public Dialog(Window window, String str, ModalityType modalityType) {
        super(window);
        this.resizable = true;
        this.undecorated = false;
        this.initialized = false;
        this.blockedWindows = new IdentityArrayList<>();
        this.isInHide = false;
        this.isInDispose = false;
        if (window != null && !(window instanceof Frame) && !(window instanceof Dialog)) {
            throw new IllegalArgumentException("Wrong parent window");
        }
        this.title = str;
        setModalityType(modalityType);
        SunToolkit.checkAndSetPolicy(this);
        this.initialized = true;
    }

    public Dialog(Window window, String str, ModalityType modalityType, GraphicsConfiguration graphicsConfiguration) {
        super(window, graphicsConfiguration);
        this.resizable = true;
        this.undecorated = false;
        this.initialized = false;
        this.blockedWindows = new IdentityArrayList<>();
        this.isInHide = false;
        this.isInDispose = false;
        if (window != null && !(window instanceof Frame) && !(window instanceof Dialog)) {
            throw new IllegalArgumentException("wrong owner window");
        }
        this.title = str;
        setModalityType(modalityType);
        SunToolkit.checkAndSetPolicy(this);
        this.initialized = true;
    }

    public Dialog(Window window, ModalityType modalityType) {
        this(window, "", modalityType);
    }
}
