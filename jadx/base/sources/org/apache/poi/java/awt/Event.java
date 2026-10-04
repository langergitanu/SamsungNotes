package org.apache.poi.java.awt;

import androidx.appcompat.widget.AbstractC0541b;
import java.io.Serializable;
import kotlin.jvm.internal.CharCompanionObject;
import org.apache.poi.java.awt.event.KeyEvent;

/* JADX INFO: loaded from: classes10.dex */
public class Event implements Serializable {
    public static final int ACTION_EVENT = 1001;
    public static final int ALT_MASK = 8;
    public static final int BACK_SPACE = 8;
    public static final int CTRL_MASK = 2;
    public static final int DELETE = 127;
    public static final int DOWN = 1005;
    public static final int END = 1001;
    public static final int ENTER = 10;
    public static final int ESCAPE = 27;

    /* JADX INFO: renamed from: F1 */
    public static final int f10036F1 = 1008;
    public static final int F10 = 1017;
    public static final int F11 = 1018;
    public static final int F12 = 1019;

    /* JADX INFO: renamed from: F2 */
    public static final int f10037F2 = 1009;

    /* JADX INFO: renamed from: F3 */
    public static final int f10038F3 = 1010;

    /* JADX INFO: renamed from: F4 */
    public static final int f10039F4 = 1011;

    /* JADX INFO: renamed from: F5 */
    public static final int f10040F5 = 1012;

    /* JADX INFO: renamed from: F6 */
    public static final int f10041F6 = 1013;

    /* JADX INFO: renamed from: F7 */
    public static final int f10042F7 = 1014;

    /* JADX INFO: renamed from: F8 */
    public static final int f10043F8 = 1015;

    /* JADX INFO: renamed from: F9 */
    public static final int f10044F9 = 1016;
    public static final int GOT_FOCUS = 1004;
    public static final int HOME = 1000;
    public static final int INSERT = 1025;
    public static final int KEY_ACTION = 403;
    public static final int KEY_ACTION_RELEASE = 404;
    private static final int KEY_EVENT = 400;
    public static final int KEY_PRESS = 401;
    public static final int KEY_RELEASE = 402;
    public static final int LEFT = 1006;
    public static final int LIST_DESELECT = 702;
    private static final int LIST_EVENT = 700;
    public static final int LIST_SELECT = 701;
    public static final int LOAD_FILE = 1002;
    public static final int LOST_FOCUS = 1005;
    public static final int META_MASK = 4;
    private static final int MISC_EVENT = 1000;
    public static final int MOUSE_DOWN = 501;
    public static final int MOUSE_DRAG = 506;
    public static final int MOUSE_ENTER = 504;
    private static final int MOUSE_EVENT = 500;
    public static final int MOUSE_EXIT = 505;
    public static final int MOUSE_MOVE = 503;
    public static final int MOUSE_UP = 502;
    public static final int NUM_LOCK = 1023;
    public static final int PAUSE = 1024;
    public static final int PGDN = 1003;
    public static final int PGUP = 1002;
    public static final int PRINT_SCREEN = 1020;
    public static final int RIGHT = 1007;
    public static final int SAVE_FILE = 1003;
    public static final int SCROLL_ABSOLUTE = 605;
    public static final int SCROLL_BEGIN = 606;
    public static final int SCROLL_END = 607;
    private static final int SCROLL_EVENT = 600;
    public static final int SCROLL_LINE_DOWN = 602;
    public static final int SCROLL_LINE_UP = 601;
    public static final int SCROLL_LOCK = 1021;
    public static final int SCROLL_PAGE_DOWN = 604;
    public static final int SCROLL_PAGE_UP = 603;
    public static final int SHIFT_MASK = 1;
    public static final int TAB = 9;

    /* JADX INFO: renamed from: UP */
    public static final int f10045UP = 1004;
    public static final int WINDOW_DEICONIFY = 204;
    public static final int WINDOW_DESTROY = 201;
    private static final int WINDOW_EVENT = 200;
    public static final int WINDOW_EXPOSE = 202;
    public static final int WINDOW_ICONIFY = 203;
    public static final int WINDOW_MOVED = 205;
    private static final long serialVersionUID = 5488922509400504703L;
    public Object arg;
    public int clickCount;
    private boolean consumed;
    private transient long data;
    public Event evt;

    /* JADX INFO: renamed from: id */
    public int f10046id;
    public int key;
    public int modifiers;
    public Object target;
    public long when;

    /* JADX INFO: renamed from: x */
    public int f10047x;

    /* JADX INFO: renamed from: y */
    public int f10048y;
    public static final int CAPS_LOCK = 1022;
    private static final int[][] actionKeyCodes = {new int[]{36, 1000}, new int[]{35, 1001}, new int[]{33, 1002}, new int[]{34, 1003}, new int[]{38, 1004}, new int[]{40, 1005}, new int[]{37, 1006}, new int[]{39, 1007}, new int[]{112, 1008}, new int[]{113, 1009}, new int[]{114, 1010}, new int[]{115, 1011}, new int[]{116, 1012}, new int[]{117, 1013}, new int[]{118, 1014}, new int[]{119, 1015}, new int[]{120, 1016}, new int[]{121, 1017}, new int[]{122, 1018}, new int[]{123, 1019}, new int[]{154, 1020}, new int[]{145, 1021}, new int[]{20, CAPS_LOCK}, new int[]{144, 1023}, new int[]{19, 1024}, new int[]{155, 1025}};

    static {
        Toolkit.loadLibraries();
        if (GraphicsEnvironment.isHeadless()) {
            return;
        }
        initIDs();
    }

    public Event(Object obj, int i, Object obj2) {
        this(obj, 0L, i, 0, 0, 0, 0, obj2);
    }

    public static int getOldEventKey(KeyEvent keyEvent) {
        int keyCode = keyEvent.getKeyCode();
        int i = 0;
        while (true) {
            int[][] iArr = actionKeyCodes;
            if (i >= iArr.length) {
                return keyEvent.getKeyChar();
            }
            int[] iArr2 = iArr[i];
            if (iArr2[0] == keyCode) {
                return iArr2[1];
            }
            i++;
        }
    }

    private static native void initIDs();

    public void consume() {
        switch (this.f10046id) {
            case 401:
            case 402:
            case 403:
            case 404:
                this.consumed = true;
                break;
        }
    }

    public boolean controlDown() {
        return (this.modifiers & 2) != 0;
    }

    public char getKeyEventChar() {
        int i = 0;
        while (true) {
            int[][] iArr = actionKeyCodes;
            if (i >= iArr.length) {
                return (char) this.key;
            }
            if (iArr[i][1] == this.key) {
                return CharCompanionObject.MAX_VALUE;
            }
            i++;
        }
    }

    public boolean isConsumed() {
        return this.consumed;
    }

    public boolean metaDown() {
        return (this.modifiers & 4) != 0;
    }

    public String paramString() {
        String string = "id=" + this.f10046id + ",x=" + this.f10047x + ",y=" + this.f10048y;
        if (this.key != 0) {
            StringBuilder sbM781w = AbstractC0541b.m781w(string, ",key=");
            sbM781w.append(this.key);
            string = sbM781w.toString();
        }
        if (shiftDown()) {
            string = AbstractC0541b.m756B(string, ",shift");
        }
        if (controlDown()) {
            string = AbstractC0541b.m756B(string, ",control");
        }
        if (metaDown()) {
            string = AbstractC0541b.m756B(string, ",meta");
        }
        if (this.target != null) {
            StringBuilder sbM781w2 = AbstractC0541b.m781w(string, ",target=");
            sbM781w2.append(this.target);
            string = sbM781w2.toString();
        }
        if (this.arg == null) {
            return string;
        }
        StringBuilder sbM781w3 = AbstractC0541b.m781w(string, ",arg=");
        sbM781w3.append(this.arg);
        return sbM781w3.toString();
    }

    public boolean shiftDown() {
        return (this.modifiers & 1) != 0;
    }

    public String toString() {
        return getClass().getName() + "[" + paramString() + "]";
    }

    public void translate(int i, int i2) {
        this.f10047x += i;
        this.f10048y += i2;
    }

    public Event(Object obj, long j, int i, int i2, int i4, int i5, int i6) {
        this(obj, j, i, i2, i4, i5, i6, null);
    }

    /*  JADX ERROR: UnsupportedOperationException in pass: RegionMakerVisitor
        java.lang.UnsupportedOperationException
        	at java.base/java.util.Collections$UnmodifiableCollection.add(Collections.java:1092)
        	at jadx.core.dex.visitors.regions.maker.SwitchRegionMaker$1.leaveRegion(SwitchRegionMaker.java:390)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:70)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverse(DepthRegionTraversal.java:23)
        	at jadx.core.dex.visitors.regions.maker.SwitchRegionMaker.insertBreaksForCase(SwitchRegionMaker.java:370)
        	at jadx.core.dex.visitors.regions.maker.SwitchRegionMaker.insertBreaks(SwitchRegionMaker.java:85)
        	at jadx.core.dex.visitors.regions.PostProcessRegions.leaveRegion(PostProcessRegions.java:33)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:70)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
        	at java.base/java.util.Collections$UnmodifiableCollection.forEach(Collections.java:1117)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverse(DepthRegionTraversal.java:19)
        	at jadx.core.dex.visitors.regions.PostProcessRegions.process(PostProcessRegions.java:23)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:31)
        */
    public Event(java.lang.Object r2, long r3, int r5, int r6, int r7, int r8, int r9, java.lang.Object r10) {
        /*
            r1 = this;
            r1.<init>()
            r0 = 0
            r1.consumed = r0
            r1.target = r2
            r1.when = r3
            r1.f10046id = r5
            r1.f10047x = r6
            r1.f10048y = r7
            r1.key = r8
            r1.modifiers = r9
            r1.arg = r10
            r2 = 0
            r1.data = r2
            r1.clickCount = r0
            r2 = 201(0xc9, float:2.82E-43)
            if (r5 == r2) goto L33
            r2 = 1001(0x3e9, float:1.403E-42)
            if (r5 == r2) goto L33
            r2 = 701(0x2bd, float:9.82E-43)
            if (r5 == r2) goto L33
            r2 = 702(0x2be, float:9.84E-43)
            if (r5 == r2) goto L33
            switch(r5) {
                case 203: goto L33;
                case 204: goto L33;
                case 205: goto L33;
                default: goto L2f;
            }
        L2f:
            switch(r5) {
                case 601: goto L33;
                case 602: goto L33;
                case 603: goto L33;
                case 604: goto L33;
                case 605: goto L33;
                case 606: goto L33;
                case 607: goto L33;
                default: goto L32;
            }
        L32:
            return
        L33:
            r2 = 1
            r1.consumed = r2
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.poi.java.awt.Event.<init>(java.lang.Object, long, int, int, int, int, int, java.lang.Object):void");
    }
}
