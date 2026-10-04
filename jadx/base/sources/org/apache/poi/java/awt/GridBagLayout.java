package org.apache.poi.java.awt;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Hashtable;
import org.apache.poi.java.awt.Component;

/* JADX INFO: loaded from: classes10.dex */
public class GridBagLayout implements LayoutManager2, Serializable {
    static final int EMPIRICMULTIPLIER = 2;
    protected static final int MAXGRIDSIZE = 512;
    protected static final int MINSIZE = 1;
    protected static final int PREFERREDSIZE = 2;
    static final long serialVersionUID = 8838754796412211005L;
    public double[] columnWeights;
    public int[] columnWidths;
    private Component componentAdjusting;
    protected GridBagLayoutInfo layoutInfo;
    public int[] rowHeights;
    public double[] rowWeights;
    transient boolean rightToLeft = false;
    protected Hashtable<Component, GridBagConstraints> comptable = new Hashtable<>();
    protected GridBagConstraints defaultConstraints = new GridBagConstraints();

    /* JADX INFO: renamed from: org.apache.poi.java.awt.GridBagLayout$1 */
    public static /* synthetic */ class C140151 {
        static final /* synthetic */ int[] $SwitchMap$java$awt$Component$BaselineResizeBehavior;

        static {
            int[] iArr = new int[Component.BaselineResizeBehavior.values().length];
            $SwitchMap$java$awt$Component$BaselineResizeBehavior = iArr;
            try {
                iArr[Component.BaselineResizeBehavior.CONSTANT_ASCENT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$java$awt$Component$BaselineResizeBehavior[Component.BaselineResizeBehavior.CENTER_OFFSET.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$java$awt$Component$BaselineResizeBehavior[Component.BaselineResizeBehavior.OTHER.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    private void alignAboveBaseline(GridBagConstraints gridBagConstraints, Rectangle rectangle, int i, int i2) {
        if (!this.layoutInfo.hasBaseline(gridBagConstraints.tempY)) {
            centerVertically(gridBagConstraints, rectangle, i2);
            return;
        }
        int i4 = this.layoutInfo.hasConstantDescent(gridBagConstraints.tempY) ? (i2 + i) - this.layoutInfo.maxDescent[gridBagConstraints.tempY] : this.layoutInfo.maxAscent[gridBagConstraints.tempY] + i;
        if (gridBagConstraints.isVerticallyResizable()) {
            int i5 = i + gridBagConstraints.insets.top;
            rectangle.f10095y = i5;
            rectangle.height = i4 - i5;
        } else {
            int i6 = gridBagConstraints.minHeight + gridBagConstraints.ipady;
            rectangle.height = i6;
            rectangle.f10095y = i4 - i6;
        }
    }

    private void alignBelowBaseline(GridBagConstraints gridBagConstraints, Rectangle rectangle, int i, int i2) {
        if (!this.layoutInfo.hasBaseline(gridBagConstraints.tempY)) {
            centerVertically(gridBagConstraints, rectangle, i2);
            return;
        }
        rectangle.f10095y = this.layoutInfo.hasConstantDescent(gridBagConstraints.tempY) ? (i + i2) - this.layoutInfo.maxDescent[gridBagConstraints.tempY] : this.layoutInfo.maxAscent[gridBagConstraints.tempY] + i;
        if (gridBagConstraints.isVerticallyResizable()) {
            rectangle.height = ((i + i2) - rectangle.f10095y) - gridBagConstraints.insets.bottom;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x00b1  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void alignOnBaseline(GridBagConstraints gridBagConstraints, Rectangle rectangle, int i, int i2) {
        boolean z;
        int baseline = gridBagConstraints.ascent;
        if (baseline < 0) {
            centerVertically(gridBagConstraints, rectangle, i2);
            return;
        }
        if (gridBagConstraints.baselineResizeBehavior == Component.BaselineResizeBehavior.CONSTANT_DESCENT) {
            int i4 = (((i2 + i) - this.layoutInfo.maxDescent[(gridBagConstraints.tempY + gridBagConstraints.tempHeight) - 1]) + gridBagConstraints.descent) - gridBagConstraints.insets.bottom;
            if (gridBagConstraints.isVerticallyResizable()) {
                rectangle.height = (i4 - i) - gridBagConstraints.insets.top;
                return;
            }
            int i5 = gridBagConstraints.minHeight;
            rectangle.f10095y = i4 - i5;
            rectangle.height = i5;
            return;
        }
        int i6 = this.layoutInfo.hasConstantDescent(gridBagConstraints.tempY) ? i2 - this.layoutInfo.maxDescent[gridBagConstraints.tempY] : this.layoutInfo.maxAscent[gridBagConstraints.tempY];
        if (gridBagConstraints.baselineResizeBehavior == Component.BaselineResizeBehavior.OTHER) {
            baseline = this.componentAdjusting.getBaseline(rectangle.width, rectangle.height);
            if (baseline >= 0) {
                baseline += gridBagConstraints.insets.top;
            }
            if (baseline < 0 || baseline > i6) {
                z = false;
                if (!z) {
                    baseline = gridBagConstraints.ascent;
                    rectangle.width = gridBagConstraints.minWidth;
                    rectangle.height = gridBagConstraints.minHeight;
                }
            } else {
                int i7 = rectangle.height - baseline;
                Insets insets = gridBagConstraints.insets;
                if ((i7 - insets.top) + i6 > i2 - insets.bottom) {
                    if (gridBagConstraints.isVerticallyResizable()) {
                        int baseline2 = this.componentAdjusting.getBaseline(rectangle.width, ((i2 - gridBagConstraints.insets.bottom) - i6) + baseline);
                        if (baseline2 >= 0) {
                            baseline2 += gridBagConstraints.insets.top;
                        }
                        if (baseline2 >= 0 && baseline2 <= baseline) {
                            rectangle.height = ((i2 - gridBagConstraints.insets.bottom) - i6) + baseline;
                            baseline = baseline2;
                        }
                    }
                    z = false;
                    if (!z) {
                    }
                }
                z = true;
                if (!z) {
                }
            }
        }
        int i8 = i + i6;
        rectangle.f10095y = (i8 - baseline) + gridBagConstraints.insets.top;
        if (gridBagConstraints.isVerticallyResizable()) {
            int i9 = C140151.$SwitchMap$java$awt$Component$BaselineResizeBehavior[gridBagConstraints.baselineResizeBehavior.ordinal()];
            if (i9 == 1) {
                rectangle.height = Math.max(gridBagConstraints.minHeight, ((i + i2) - rectangle.f10095y) - gridBagConstraints.insets.bottom);
                return;
            }
            if (i9 != 2) {
                return;
            }
            int i10 = rectangle.f10095y;
            Insets insets2 = gridBagConstraints.insets;
            int iMin = Math.min((i10 - i) - insets2.top, (((i + i2) - i10) - gridBagConstraints.minHeight) - insets2.bottom);
            int i11 = iMin + iMin;
            if (i11 > 0 && (((gridBagConstraints.minHeight + gridBagConstraints.centerPadding) + i11) / 2) + gridBagConstraints.centerOffset != i6) {
                i11--;
            }
            int i12 = gridBagConstraints.minHeight + i11;
            rectangle.height = i12;
            rectangle.f10095y = (i8 - ((i12 + gridBagConstraints.centerPadding) / 2)) - gridBagConstraints.centerOffset;
        }
    }

    private boolean calculateBaseline(Component component, GridBagConstraints gridBagConstraints, Dimension dimension) {
        int i = gridBagConstraints.anchor;
        if (i != 256 && i != 512 && i != 768) {
            gridBagConstraints.ascent = -1;
            return false;
        }
        int i2 = dimension.width + gridBagConstraints.ipadx;
        int i4 = dimension.height + gridBagConstraints.ipady;
        int baseline = component.getBaseline(i2, i4);
        gridBagConstraints.ascent = baseline;
        if (baseline >= 0) {
            Insets insets = gridBagConstraints.insets;
            gridBagConstraints.descent = (i4 - baseline) + insets.bottom;
            gridBagConstraints.ascent = insets.top + baseline;
            Component.BaselineResizeBehavior baselineResizeBehavior = component.getBaselineResizeBehavior();
            gridBagConstraints.baselineResizeBehavior = baselineResizeBehavior;
            gridBagConstraints.centerPadding = 0;
            if (baselineResizeBehavior == Component.BaselineResizeBehavior.CENTER_OFFSET) {
                int baseline2 = component.getBaseline(i2, i4 + 1);
                int i5 = baseline - (i4 / 2);
                gridBagConstraints.centerOffset = i5;
                if (i4 % 2 == 0) {
                    if (baseline != baseline2) {
                        gridBagConstraints.centerPadding = 1;
                    }
                } else if (baseline == baseline2) {
                    gridBagConstraints.centerOffset = i5 - 1;
                    gridBagConstraints.centerPadding = 1;
                }
            }
        }
        return true;
    }

    private void centerVertically(GridBagConstraints gridBagConstraints, Rectangle rectangle, int i) {
        if (gridBagConstraints.isVerticallyResizable()) {
            return;
        }
        int i2 = rectangle.f10095y;
        Insets insets = gridBagConstraints.insets;
        rectangle.f10095y = Math.max(0, ((((i - insets.top) - insets.bottom) - gridBagConstraints.minHeight) - gridBagConstraints.ipady) / 2) + i2;
    }

    private long[] preInitMaximumArraySizes(Container container) {
        Component[] components = container.getComponents();
        int i = 0;
        int iMax = 0;
        int iMax2 = 0;
        while (true) {
            if (i >= components.length) {
                return new long[]{iMax, iMax2};
            }
            Component component = components[i];
            if (component.isVisible()) {
                GridBagConstraints gridBagConstraintsLookupConstraints = lookupConstraints(component);
                int i2 = gridBagConstraintsLookupConstraints.gridx;
                int i4 = gridBagConstraintsLookupConstraints.gridy;
                int i5 = gridBagConstraintsLookupConstraints.gridwidth;
                int i6 = gridBagConstraintsLookupConstraints.gridheight;
                if (i2 < 0) {
                    iMax2++;
                    i2 = iMax2;
                }
                if (i4 < 0) {
                    iMax++;
                    i4 = iMax;
                }
                if (i5 <= 0) {
                    i5 = 1;
                }
                iMax = Math.max(i4 + (i6 > 0 ? i6 : 1), iMax);
                iMax2 = Math.max(i2 + i5, iMax2);
            }
            i++;
        }
    }

    private void removeConstraints(Component component) {
        this.comptable.remove(component);
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x004c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void AdjustForGravity(GridBagConstraints gridBagConstraints, Rectangle rectangle) {
        int i;
        int i2 = rectangle.f10095y;
        int i4 = rectangle.height;
        boolean z = this.rightToLeft;
        int i5 = rectangle.f10094x;
        rectangle.f10094x = !z ? i5 + gridBagConstraints.insets.left : i5 - (rectangle.width - gridBagConstraints.insets.right);
        int i6 = rectangle.width;
        Insets insets = gridBagConstraints.insets;
        int i7 = i6 - (insets.left + insets.right);
        rectangle.width = i7;
        int i8 = insets.top;
        int i9 = i2 + i8;
        rectangle.f10095y = i9;
        int i10 = i4 - (i8 + insets.bottom);
        rectangle.height = i10;
        int i11 = gridBagConstraints.fill;
        int i12 = 0;
        if (i11 == 2 || i11 == 1) {
            i = 0;
        } else {
            int i13 = gridBagConstraints.minWidth;
            int i14 = gridBagConstraints.ipadx;
            if (i7 > i13 + i14) {
                i = i7 - (i13 + i14);
                rectangle.width = i13 + i14;
            }
        }
        if (i11 != 3 && i11 != 1) {
            int i15 = gridBagConstraints.minHeight;
            int i16 = gridBagConstraints.ipady;
            if (i10 > i15 + i16) {
                i12 = i10 - (i15 + i16);
                rectangle.height = i15 + i16;
            }
        }
        int i17 = gridBagConstraints.anchor;
        if (i17 == 256) {
            rectangle.f10094x = (i / 2) + rectangle.f10094x;
            alignOnBaseline(gridBagConstraints, rectangle, i2, i4);
            return;
        }
        if (i17 == 512) {
            if (z) {
                rectangle.f10094x += i;
            }
            alignOnBaseline(gridBagConstraints, rectangle, i2, i4);
            return;
        }
        if (i17 == 768) {
            if (!z) {
                rectangle.f10094x += i;
            }
            alignOnBaseline(gridBagConstraints, rectangle, i2, i4);
            return;
        }
        if (i17 == 1024) {
            rectangle.f10094x = (i / 2) + rectangle.f10094x;
            alignAboveBaseline(gridBagConstraints, rectangle, i2, i4);
            return;
        }
        if (i17 == 1280) {
            if (z) {
                rectangle.f10094x += i;
            }
            alignAboveBaseline(gridBagConstraints, rectangle, i2, i4);
            return;
        }
        if (i17 == 1536) {
            if (!z) {
                rectangle.f10094x += i;
            }
            alignAboveBaseline(gridBagConstraints, rectangle, i2, i4);
            return;
        }
        if (i17 == 1792) {
            rectangle.f10094x = (i / 2) + rectangle.f10094x;
            alignBelowBaseline(gridBagConstraints, rectangle, i2, i4);
            return;
        }
        if (i17 == 2048) {
            if (z) {
                rectangle.f10094x += i;
            }
            alignBelowBaseline(gridBagConstraints, rectangle, i2, i4);
            return;
        }
        if (i17 == 2304) {
            if (!z) {
                rectangle.f10094x += i;
            }
            alignBelowBaseline(gridBagConstraints, rectangle, i2, i4);
            return;
        }
        switch (i17) {
            case 10:
                rectangle.f10094x = (i / 2) + rectangle.f10094x;
                rectangle.f10095y = (i12 / 2) + i9;
                return;
            case 11:
            case 19:
                rectangle.f10094x = (i / 2) + rectangle.f10094x;
                return;
            case 12:
                rectangle.f10094x += i;
                return;
            case 13:
                rectangle.f10094x += i;
                rectangle.f10095y = (i12 / 2) + i9;
                return;
            case 14:
                rectangle.f10094x += i;
                rectangle.f10095y = i9 + i12;
                return;
            case 15:
            case 20:
                rectangle.f10094x = (i / 2) + rectangle.f10094x;
                rectangle.f10095y = i9 + i12;
                return;
            case 16:
                rectangle.f10095y = i9 + i12;
                return;
            case 17:
                rectangle.f10095y = (i12 / 2) + i9;
                return;
            case 18:
                return;
            case 21:
                if (z) {
                    rectangle.f10094x += i;
                }
                rectangle.f10095y = (i12 / 2) + i9;
                return;
            case 22:
                if (!z) {
                    rectangle.f10094x += i;
                }
                rectangle.f10095y = (i12 / 2) + i9;
                return;
            case 23:
                if (z) {
                    rectangle.f10094x += i;
                    return;
                }
                return;
            case 24:
                if (z) {
                    return;
                }
                rectangle.f10094x += i;
                return;
            case 25:
                if (z) {
                    rectangle.f10094x += i;
                }
                rectangle.f10095y = i9 + i12;
                return;
            case 26:
                if (!z) {
                    rectangle.f10094x += i;
                }
                rectangle.f10095y = i9 + i12;
                return;
            default:
                throw new IllegalArgumentException("illegal anchor value");
        }
    }

    public void ArrangeGrid(Container container) {
        double d;
        int i;
        int i2;
        int i4;
        int[] iArr;
        int[] iArr2;
        Insets insets = container.getInsets();
        Component[] components = container.getComponents();
        Rectangle rectangle = new Rectangle();
        this.rightToLeft = !container.getComponentOrientation().isLeftToRight();
        if (components.length == 0 && (((iArr = this.columnWidths) == null || iArr.length == 0) && ((iArr2 = this.rowHeights) == null || iArr2.length == 0))) {
            return;
        }
        char c = 2;
        GridBagLayoutInfo layoutInfo = getLayoutInfo(container, 2);
        Dimension minSize = getMinSize(container, layoutInfo);
        if (container.width < minSize.width || container.height < minSize.height) {
            layoutInfo = getLayoutInfo(container, 1);
            minSize = getMinSize(container, layoutInfo);
        }
        this.layoutInfo = layoutInfo;
        int i5 = minSize.width;
        rectangle.width = i5;
        rectangle.height = minSize.height;
        int i6 = container.width - i5;
        double d2 = 0.0d;
        if (i6 != 0) {
            double d3 = 0.0d;
            for (int i7 = 0; i7 < layoutInfo.width; i7++) {
                d3 += layoutInfo.weightX[i7];
            }
            if (d3 > 0.0d) {
                int i8 = 0;
                while (i8 < layoutInfo.width) {
                    char c2 = c;
                    int i9 = (int) ((((double) i6) * layoutInfo.weightX[i8]) / d3);
                    int[] iArr3 = layoutInfo.minWidth;
                    int i10 = iArr3[i8] + i9;
                    iArr3[i8] = i10;
                    double d4 = d2;
                    int i11 = rectangle.width + i9;
                    rectangle.width = i11;
                    if (i10 < 0) {
                        rectangle.width = i11 - i10;
                        iArr3[i8] = 0;
                    }
                    i8++;
                    c = c2;
                    d2 = d4;
                }
            }
            d = d2;
            i = container.width - rectangle.width;
        } else {
            d = 0.0d;
            i = 0;
        }
        int i12 = container.height - rectangle.height;
        if (i12 != 0) {
            double d5 = d;
            for (int i13 = 0; i13 < layoutInfo.height; i13++) {
                d5 += layoutInfo.weightY[i13];
            }
            if (d5 > d) {
                for (int i14 = 0; i14 < layoutInfo.height; i14++) {
                    int i15 = (int) ((((double) i12) * layoutInfo.weightY[i14]) / d5);
                    int[] iArr4 = layoutInfo.minHeight;
                    int i16 = iArr4[i14] + i15;
                    iArr4[i14] = i16;
                    int i17 = rectangle.height + i15;
                    rectangle.height = i17;
                    if (i16 < 0) {
                        rectangle.height = i17 - i16;
                        iArr4[i14] = 0;
                    }
                }
            }
            i2 = container.height - rectangle.height;
        } else {
            i2 = 0;
        }
        int i18 = i / 2;
        layoutInfo.startx = insets.left + i18;
        layoutInfo.starty = (i2 / 2) + insets.top;
        for (Component component : components) {
            if (component.isVisible()) {
                GridBagConstraints gridBagConstraintsLookupConstraints = lookupConstraints(component);
                if (this.rightToLeft) {
                    rectangle.f10094x = container.width - (insets.right + i18);
                    for (int i19 = 0; i19 < gridBagConstraintsLookupConstraints.tempX; i19++) {
                        rectangle.f10094x -= layoutInfo.minWidth[i19];
                    }
                } else {
                    rectangle.f10094x = layoutInfo.startx;
                    for (int i20 = 0; i20 < gridBagConstraintsLookupConstraints.tempX; i20++) {
                        rectangle.f10094x += layoutInfo.minWidth[i20];
                    }
                }
                rectangle.f10095y = layoutInfo.starty;
                for (int i21 = 0; i21 < gridBagConstraintsLookupConstraints.tempY; i21++) {
                    rectangle.f10095y += layoutInfo.minHeight[i21];
                }
                rectangle.width = 0;
                for (int i22 = gridBagConstraintsLookupConstraints.tempX; i22 < gridBagConstraintsLookupConstraints.tempX + gridBagConstraintsLookupConstraints.tempWidth; i22++) {
                    rectangle.width += layoutInfo.minWidth[i22];
                }
                rectangle.height = 0;
                for (int i23 = gridBagConstraintsLookupConstraints.tempY; i23 < gridBagConstraintsLookupConstraints.tempY + gridBagConstraintsLookupConstraints.tempHeight; i23++) {
                    rectangle.height += layoutInfo.minHeight[i23];
                }
                this.componentAdjusting = component;
                adjustForGravity(gridBagConstraintsLookupConstraints, rectangle);
                int i24 = rectangle.f10094x;
                if (i24 < 0) {
                    rectangle.width += i24;
                    rectangle.f10094x = 0;
                }
                int i25 = rectangle.f10095y;
                if (i25 < 0) {
                    rectangle.height += i25;
                    rectangle.f10095y = 0;
                }
                int i26 = rectangle.width;
                if (i26 <= 0 || (i4 = rectangle.height) <= 0) {
                    component.setBounds(0, 0, 0, 0);
                } else {
                    int i27 = component.f10034x;
                    int i28 = rectangle.f10094x;
                    if (i27 != i28 || component.f10035y != rectangle.f10095y || component.width != i26 || component.height != i4) {
                        component.setBounds(i28, rectangle.f10095y, i26, i4);
                    }
                }
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:304:0x04da, code lost:
    
        if (r7 != 2304) goto L305;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:326:0x053c A[Catch: all -> 0x003c, TryCatch #0 {all -> 0x003c, blocks: (B:4:0x0007, B:8:0x0024, B:12:0x0032, B:14:0x0036, B:17:0x003f, B:19:0x0043, B:20:0x0048, B:21:0x0054, B:23:0x0057, B:90:0x0126, B:26:0x0063, B:29:0x0073, B:42:0x0096, B:44:0x009a, B:45:0x00a3, B:58:0x00cc, B:61:0x00d1, B:66:0x00da, B:69:0x00e3, B:72:0x00ef, B:75:0x00fb, B:78:0x010b, B:80:0x010f, B:86:0x011e, B:74:0x00f6, B:51:0x00b4, B:53:0x00b8, B:54:0x00c1, B:91:0x012e, B:93:0x0134, B:95:0x0137, B:96:0x0138, B:98:0x013c, B:100:0x013f, B:101:0x0140, B:103:0x014e, B:106:0x0165, B:108:0x016a, B:216:0x0343, B:111:0x017e, B:121:0x01a4, B:127:0x01c0, B:129:0x01c4, B:130:0x01cd, B:151:0x021a, B:156:0x022d, B:160:0x023d, B:162:0x0248, B:165:0x0250, B:166:0x0255, B:168:0x0259, B:180:0x0278, B:201:0x02aa, B:202:0x02ca, B:203:0x02e9, B:207:0x02f0, B:212:0x031e, B:214:0x0324, B:215:0x0335, B:208:0x0303, B:210:0x0309, B:211:0x0316, B:175:0x026e, B:136:0x01e4, B:141:0x01f4, B:143:0x01f8, B:144:0x0201, B:217:0x0351, B:219:0x0367, B:220:0x036c, B:222:0x0370, B:223:0x0377, B:225:0x037b, B:226:0x0387, B:228:0x038b, B:233:0x03a1, B:235:0x03a4, B:344:0x059c, B:238:0x03b4, B:240:0x03bc, B:242:0x03c5, B:245:0x03d2, B:247:0x03d8, B:248:0x03e1, B:252:0x03e9, B:253:0x03fc, B:254:0x0406, B:256:0x0417, B:258:0x0421, B:260:0x0427, B:261:0x0433, B:265:0x043b, B:266:0x0455, B:272:0x046a, B:274:0x046e, B:276:0x0475, B:279:0x0481, B:281:0x0487, B:282:0x0490, B:286:0x0498, B:287:0x04ab, B:289:0x04b6, B:326:0x053c, B:327:0x0549, B:329:0x054d, B:331:0x0557, B:333:0x055d, B:334:0x0566, B:338:0x056e, B:339:0x0587, B:307:0x04e1, B:308:0x04ef, B:310:0x04f4, B:313:0x0509, B:315:0x050d, B:317:0x0512, B:318:0x051a, B:320:0x0520, B:321:0x0527, B:346:0x05a9, B:11:0x0030, B:7:0x0022), top: B:350:0x0007 }] */
    /* JADX WARN: Removed duplicated region for block: B:329:0x054d A[Catch: all -> 0x003c, LOOP:21: B:328:0x054b->B:329:0x054d, LOOP_END, TryCatch #0 {all -> 0x003c, blocks: (B:4:0x0007, B:8:0x0024, B:12:0x0032, B:14:0x0036, B:17:0x003f, B:19:0x0043, B:20:0x0048, B:21:0x0054, B:23:0x0057, B:90:0x0126, B:26:0x0063, B:29:0x0073, B:42:0x0096, B:44:0x009a, B:45:0x00a3, B:58:0x00cc, B:61:0x00d1, B:66:0x00da, B:69:0x00e3, B:72:0x00ef, B:75:0x00fb, B:78:0x010b, B:80:0x010f, B:86:0x011e, B:74:0x00f6, B:51:0x00b4, B:53:0x00b8, B:54:0x00c1, B:91:0x012e, B:93:0x0134, B:95:0x0137, B:96:0x0138, B:98:0x013c, B:100:0x013f, B:101:0x0140, B:103:0x014e, B:106:0x0165, B:108:0x016a, B:216:0x0343, B:111:0x017e, B:121:0x01a4, B:127:0x01c0, B:129:0x01c4, B:130:0x01cd, B:151:0x021a, B:156:0x022d, B:160:0x023d, B:162:0x0248, B:165:0x0250, B:166:0x0255, B:168:0x0259, B:180:0x0278, B:201:0x02aa, B:202:0x02ca, B:203:0x02e9, B:207:0x02f0, B:212:0x031e, B:214:0x0324, B:215:0x0335, B:208:0x0303, B:210:0x0309, B:211:0x0316, B:175:0x026e, B:136:0x01e4, B:141:0x01f4, B:143:0x01f8, B:144:0x0201, B:217:0x0351, B:219:0x0367, B:220:0x036c, B:222:0x0370, B:223:0x0377, B:225:0x037b, B:226:0x0387, B:228:0x038b, B:233:0x03a1, B:235:0x03a4, B:344:0x059c, B:238:0x03b4, B:240:0x03bc, B:242:0x03c5, B:245:0x03d2, B:247:0x03d8, B:248:0x03e1, B:252:0x03e9, B:253:0x03fc, B:254:0x0406, B:256:0x0417, B:258:0x0421, B:260:0x0427, B:261:0x0433, B:265:0x043b, B:266:0x0455, B:272:0x046a, B:274:0x046e, B:276:0x0475, B:279:0x0481, B:281:0x0487, B:282:0x0490, B:286:0x0498, B:287:0x04ab, B:289:0x04b6, B:326:0x053c, B:327:0x0549, B:329:0x054d, B:331:0x0557, B:333:0x055d, B:334:0x0566, B:338:0x056e, B:339:0x0587, B:307:0x04e1, B:308:0x04ef, B:310:0x04f4, B:313:0x0509, B:315:0x050d, B:317:0x0512, B:318:0x051a, B:320:0x0520, B:321:0x0527, B:346:0x05a9, B:11:0x0030, B:7:0x0022), top: B:350:0x0007 }] */
    /* JADX WARN: Removed duplicated region for block: B:331:0x0557 A[Catch: all -> 0x003c, TryCatch #0 {all -> 0x003c, blocks: (B:4:0x0007, B:8:0x0024, B:12:0x0032, B:14:0x0036, B:17:0x003f, B:19:0x0043, B:20:0x0048, B:21:0x0054, B:23:0x0057, B:90:0x0126, B:26:0x0063, B:29:0x0073, B:42:0x0096, B:44:0x009a, B:45:0x00a3, B:58:0x00cc, B:61:0x00d1, B:66:0x00da, B:69:0x00e3, B:72:0x00ef, B:75:0x00fb, B:78:0x010b, B:80:0x010f, B:86:0x011e, B:74:0x00f6, B:51:0x00b4, B:53:0x00b8, B:54:0x00c1, B:91:0x012e, B:93:0x0134, B:95:0x0137, B:96:0x0138, B:98:0x013c, B:100:0x013f, B:101:0x0140, B:103:0x014e, B:106:0x0165, B:108:0x016a, B:216:0x0343, B:111:0x017e, B:121:0x01a4, B:127:0x01c0, B:129:0x01c4, B:130:0x01cd, B:151:0x021a, B:156:0x022d, B:160:0x023d, B:162:0x0248, B:165:0x0250, B:166:0x0255, B:168:0x0259, B:180:0x0278, B:201:0x02aa, B:202:0x02ca, B:203:0x02e9, B:207:0x02f0, B:212:0x031e, B:214:0x0324, B:215:0x0335, B:208:0x0303, B:210:0x0309, B:211:0x0316, B:175:0x026e, B:136:0x01e4, B:141:0x01f4, B:143:0x01f8, B:144:0x0201, B:217:0x0351, B:219:0x0367, B:220:0x036c, B:222:0x0370, B:223:0x0377, B:225:0x037b, B:226:0x0387, B:228:0x038b, B:233:0x03a1, B:235:0x03a4, B:344:0x059c, B:238:0x03b4, B:240:0x03bc, B:242:0x03c5, B:245:0x03d2, B:247:0x03d8, B:248:0x03e1, B:252:0x03e9, B:253:0x03fc, B:254:0x0406, B:256:0x0417, B:258:0x0421, B:260:0x0427, B:261:0x0433, B:265:0x043b, B:266:0x0455, B:272:0x046a, B:274:0x046e, B:276:0x0475, B:279:0x0481, B:281:0x0487, B:282:0x0490, B:286:0x0498, B:287:0x04ab, B:289:0x04b6, B:326:0x053c, B:327:0x0549, B:329:0x054d, B:331:0x0557, B:333:0x055d, B:334:0x0566, B:338:0x056e, B:339:0x0587, B:307:0x04e1, B:308:0x04ef, B:310:0x04f4, B:313:0x0509, B:315:0x050d, B:317:0x0512, B:318:0x051a, B:320:0x0520, B:321:0x0527, B:346:0x05a9, B:11:0x0030, B:7:0x0022), top: B:350:0x0007 }] */
    /* JADX WARN: Removed duplicated region for block: B:379:0x059c A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public GridBagLayoutInfo GetLayoutInfo(Container container, int i) {
        GridBagLayoutInfo gridBagLayoutInfo;
        int[] iArr;
        int[] iArr2;
        short[] sArr;
        int[] iArr3;
        int i2;
        int i4;
        GridBagConstraints gridBagConstraints;
        double d;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int[] iArr4;
        int[] iArr5;
        boolean z;
        int i11;
        int i12;
        int i13;
        int[] iArr6;
        int i14;
        short[] sArr2;
        int i15;
        int i16;
        int i17;
        int i18;
        synchronized (container.getTreeLock()) {
            try {
                Component[] components = container.getComponents();
                long[] jArrPreInitMaximumArraySizes = preInitMaximumArraySizes(container);
                long j = jArrPreInitMaximumArraySizes[0];
                int iMax = j * 2 > 2147483647L ? Integer.MAX_VALUE : ((int) j) * 2;
                int i19 = 1;
                long j2 = jArrPreInitMaximumArraySizes[1];
                int iMax2 = 2 * j2 > 2147483647L ? Integer.MAX_VALUE : ((int) j2) * 2;
                int[] iArr7 = this.rowHeights;
                if (iArr7 != null) {
                    iMax = Math.max(iMax, iArr7.length);
                }
                int[] iArr8 = this.columnWidths;
                if (iArr8 != null) {
                    iMax2 = Math.max(iMax2, iArr8.length);
                }
                int[] iArr9 = new int[iMax];
                int[] iArr10 = new int[iMax2];
                int i20 = 0;
                int length = 0;
                int length2 = 0;
                int i21 = 0;
                int i22 = -1;
                int i23 = -1;
                while (i20 < components.length) {
                    Component component = components[i20];
                    if (component.isVisible()) {
                        GridBagConstraints gridBagConstraintsLookupConstraints = lookupConstraints(component);
                        i18 = i19;
                        int i24 = gridBagConstraintsLookupConstraints.gridx;
                        int i25 = gridBagConstraintsLookupConstraints.gridy;
                        int i26 = gridBagConstraintsLookupConstraints.gridwidth;
                        if (i26 <= 0) {
                            i26 = i18;
                        }
                        int i27 = i25;
                        int i28 = gridBagConstraintsLookupConstraints.gridheight;
                        if (i28 <= 0) {
                            i28 = i18;
                        }
                        if (i24 < 0 && i27 < 0) {
                            if (i22 >= 0) {
                                i27 = i22;
                            } else if (i23 >= 0) {
                                i24 = i23;
                            } else {
                                i27 = 0;
                            }
                        }
                        int i29 = i28;
                        int i30 = i24;
                        int i31 = i26;
                        if (i24 < 0) {
                            int iMax3 = 0;
                            for (int i32 = i27; i32 < i27 + i29; i32++) {
                                iMax3 = Math.max(iMax3, iArr9[i32]);
                            }
                            int i33 = (iMax3 - i30) - 1;
                            i30 = i33 < 0 ? 0 : i33;
                        } else if (i27 < 0) {
                            int iMax4 = 0;
                            for (int i34 = i30; i34 < i30 + i31; i34++) {
                                iMax4 = Math.max(iMax4, iArr10[i34]);
                            }
                            int i35 = (iMax4 - i27) - 1;
                            i27 = i35 < 0 ? 0 : i35;
                        }
                        int i36 = i30 + i31;
                        if (length < i36) {
                            length = i36;
                        }
                        int i37 = i27 + i29;
                        if (length2 < i37) {
                            length2 = i37;
                        }
                        for (int i38 = i30; i38 < i36; i38++) {
                            iArr10[i38] = i37;
                        }
                        for (int i39 = i27; i39 < i37; i39++) {
                            iArr9[i39] = i36;
                        }
                        Dimension preferredSize = i == 2 ? component.getPreferredSize() : component.getMinimumSize();
                        gridBagConstraintsLookupConstraints.minWidth = preferredSize.width;
                        gridBagConstraintsLookupConstraints.minHeight = preferredSize.height;
                        if (calculateBaseline(component, gridBagConstraintsLookupConstraints, preferredSize)) {
                            i21 = i18;
                        }
                        int i40 = gridBagConstraintsLookupConstraints.gridheight;
                        if (i40 == 0 && gridBagConstraintsLookupConstraints.gridwidth == 0) {
                            i22 = -1;
                            i23 = -1;
                        }
                        if (i40 == 0 && i22 < 0) {
                            i23 = i36;
                        } else if (gridBagConstraintsLookupConstraints.gridwidth == 0 && i23 < 0) {
                            i22 = i37;
                        }
                    } else {
                        i18 = i19;
                    }
                    i20++;
                    i19 = i18;
                }
                boolean z2 = i19;
                int[] iArr11 = this.columnWidths;
                if (iArr11 != null && length < iArr11.length) {
                    length = iArr11.length;
                }
                int[] iArr12 = this.rowHeights;
                if (iArr12 != null && length2 < iArr12.length) {
                    length2 = iArr12.length;
                }
                gridBagLayoutInfo = new GridBagLayoutInfo(length, length2);
                Arrays.fill(iArr9, 0);
                Arrays.fill(iArr10, 0);
                if (i21 != 0) {
                    iArr = new int[length2];
                    gridBagLayoutInfo.maxAscent = iArr;
                    iArr2 = new int[length2];
                    gridBagLayoutInfo.maxDescent = iArr2;
                    sArr = new short[length2];
                    gridBagLayoutInfo.baselineType = sArr;
                    gridBagLayoutInfo.hasBaseline = z2;
                } else {
                    iArr = null;
                    iArr2 = null;
                    sArr = null;
                }
                int i41 = 0;
                int i42 = -1;
                int i43 = -1;
                while (true) {
                    iArr3 = iArr;
                    if (i41 >= components.length) {
                        break;
                    }
                    Component component2 = components[i41];
                    if (component2.isVisible()) {
                        GridBagConstraints gridBagConstraintsLookupConstraints2 = lookupConstraints(component2);
                        int i44 = gridBagConstraintsLookupConstraints2.gridx;
                        int i45 = gridBagConstraintsLookupConstraints2.gridy;
                        int i46 = gridBagConstraintsLookupConstraints2.gridwidth;
                        int i47 = gridBagConstraintsLookupConstraints2.gridheight;
                        if (i44 < 0 && i45 < 0) {
                            if (i42 >= 0) {
                                i45 = i42;
                            } else if (i43 >= 0) {
                                i44 = i43;
                            } else {
                                i45 = 0;
                            }
                        }
                        if (i44 < 0) {
                            if (i47 <= 0) {
                                int i48 = (gridBagLayoutInfo.height - i45) + i47;
                                iArr4 = iArr9;
                                i10 = i48 < 1 ? 1 : i48;
                            } else {
                                i10 = i47;
                                iArr4 = iArr9;
                            }
                            iArr5 = iArr10;
                            int iMax5 = 0;
                            for (int i49 = i45; i49 < i45 + i10; i49++) {
                                iMax5 = Math.max(iMax5, iArr4[i49]);
                            }
                            z = true;
                            i11 = (iMax5 - i44) - 1;
                            i12 = i45;
                            i13 = i46;
                            if (i11 < 0) {
                                i11 = 0;
                            }
                        } else {
                            i10 = i47;
                            iArr4 = iArr9;
                            iArr5 = iArr10;
                            z = true;
                            if (i45 < 0) {
                                if (i46 <= 0) {
                                    int i50 = (gridBagLayoutInfo.width - i44) + i46;
                                    i46 = i50 < 1 ? 1 : i50;
                                }
                                int iMax6 = 0;
                                for (int i51 = i44; i51 < i44 + i46; i51++) {
                                    iMax6 = Math.max(iMax6, iArr5[i51]);
                                }
                                z = true;
                                int i52 = (iMax6 - i45) - 1;
                                if (i52 < 0) {
                                    i11 = i44;
                                    i13 = i46;
                                    i12 = 0;
                                } else {
                                    i12 = i52;
                                    i11 = i44;
                                }
                            } else {
                                i11 = i44;
                                i12 = i45;
                            }
                            i13 = i46;
                        }
                        if (i13 <= 0) {
                            i14 = (gridBagLayoutInfo.width - i11) + i13;
                            iArr6 = iArr2;
                            if (i14 < 1) {
                                i14 = 1;
                            }
                        } else {
                            iArr6 = iArr2;
                            i14 = i13;
                        }
                        if (i10 <= 0) {
                            i15 = (gridBagLayoutInfo.height - i12) + i10;
                            sArr2 = sArr;
                            if (i15 < 1) {
                                i15 = 1;
                            }
                        } else {
                            sArr2 = sArr;
                            i15 = i10;
                        }
                        int i53 = i11 + i14;
                        i16 = i41;
                        int i54 = i12 + i15;
                        int i55 = i42;
                        for (int i56 = i11; i56 < i53; i56++) {
                            iArr5[i56] = i54;
                        }
                        for (int i57 = i12; i57 < i54; i57++) {
                            iArr4[i57] = i53;
                        }
                        int i58 = gridBagConstraintsLookupConstraints2.gridheight;
                        if (i58 == 0) {
                            i17 = i53;
                            if (gridBagConstraintsLookupConstraints2.gridwidth == 0) {
                                i43 = -1;
                                i55 = -1;
                            }
                        } else {
                            i17 = i53;
                        }
                        if (i58 != 0 || i55 >= 0) {
                            i42 = (gridBagConstraintsLookupConstraints2.gridwidth != 0 || i43 >= 0) ? i55 : i54;
                        } else {
                            i42 = i55;
                            i43 = i17;
                        }
                        gridBagConstraintsLookupConstraints2.tempX = i11;
                        gridBagConstraintsLookupConstraints2.tempY = i12;
                        gridBagConstraintsLookupConstraints2.tempWidth = i14;
                        gridBagConstraintsLookupConstraints2.tempHeight = i15;
                        int i59 = gridBagConstraintsLookupConstraints2.anchor;
                        if (i21 != 0) {
                            if (i59 == 256 || i59 == 512 || i59 == 768) {
                                int i60 = gridBagConstraintsLookupConstraints2.ascent;
                                if (i60 >= 0) {
                                    if (i15 == 1) {
                                        iArr3[i12] = Math.max(iArr3[i12], i60);
                                        iArr6[i12] = Math.max(iArr6[i12], gridBagConstraintsLookupConstraints2.descent);
                                    } else if (gridBagConstraintsLookupConstraints2.baselineResizeBehavior == Component.BaselineResizeBehavior.CONSTANT_DESCENT) {
                                        int i61 = i54 - 1;
                                        iArr6[i61] = Math.max(iArr6[i61], gridBagConstraintsLookupConstraints2.descent);
                                    } else {
                                        iArr3[i12] = Math.max(iArr3[i12], i60);
                                    }
                                    Component.BaselineResizeBehavior baselineResizeBehavior = gridBagConstraintsLookupConstraints2.baselineResizeBehavior;
                                    if (baselineResizeBehavior == Component.BaselineResizeBehavior.CONSTANT_DESCENT) {
                                        int i62 = i54 - 1;
                                        sArr2[i62] = (short) ((1 << baselineResizeBehavior.ordinal()) | sArr2[i62]);
                                    } else {
                                        sArr2[i12] = (short) ((1 << baselineResizeBehavior.ordinal()) | sArr2[i12]);
                                    }
                                }
                            } else if (i59 == 1024 || i59 == 1280 || i59 == 1536) {
                                iArr3[i12] = Math.max(iArr3[i12], gridBagConstraintsLookupConstraints2.minHeight + gridBagConstraintsLookupConstraints2.insets.top + gridBagConstraintsLookupConstraints2.ipady);
                                iArr6[i12] = Math.max(iArr6[i12], gridBagConstraintsLookupConstraints2.insets.bottom);
                            } else if (i59 == 1792 || i59 == 2048 || i59 == 2304) {
                                iArr6[i12] = Math.max(iArr6[i12], gridBagConstraintsLookupConstraints2.minHeight + gridBagConstraintsLookupConstraints2.insets.bottom + gridBagConstraintsLookupConstraints2.ipady);
                                iArr3[i12] = Math.max(iArr3[i12], gridBagConstraintsLookupConstraints2.insets.top);
                            }
                        }
                    } else {
                        iArr4 = iArr9;
                        iArr5 = iArr10;
                        iArr6 = iArr2;
                        sArr2 = sArr;
                        i16 = i41;
                    }
                    i41 = i16 + 1;
                    iArr = iArr3;
                    sArr = sArr2;
                    iArr2 = iArr6;
                    iArr9 = iArr4;
                    iArr10 = iArr5;
                }
                int[] iArr13 = iArr2;
                gridBagLayoutInfo.weightX = new double[iMax2];
                gridBagLayoutInfo.weightY = new double[iMax];
                int[] iArr14 = new int[iMax2];
                gridBagLayoutInfo.minWidth = iArr14;
                gridBagLayoutInfo.minHeight = new int[iMax];
                int[] iArr15 = this.columnWidths;
                if (iArr15 != null) {
                    System.arraycopy(iArr15, 0, iArr14, 0, iArr15.length);
                }
                int[] iArr16 = this.rowHeights;
                if (iArr16 != null) {
                    System.arraycopy(iArr16, 0, gridBagLayoutInfo.minHeight, 0, iArr16.length);
                }
                double[] dArr = this.columnWeights;
                if (dArr != null) {
                    double[] dArr2 = gridBagLayoutInfo.weightX;
                    System.arraycopy(dArr, 0, dArr2, 0, Math.min(dArr2.length, dArr.length));
                }
                double[] dArr3 = this.rowWeights;
                if (dArr3 != null) {
                    double[] dArr4 = gridBagLayoutInfo.weightY;
                    i2 = 0;
                    System.arraycopy(dArr3, 0, dArr4, 0, Math.min(dArr4.length, dArr3.length));
                } else {
                    i2 = 0;
                }
                int i63 = Integer.MAX_VALUE;
                for (int i64 = 1; i64 != i63; i64 = i4) {
                    i4 = i63;
                    int i65 = i2;
                    while (i65 < components.length) {
                        Component component3 = components[i65];
                        if (component3.isVisible()) {
                            GridBagConstraints gridBagConstraintsLookupConstraints3 = lookupConstraints(component3);
                            int i66 = gridBagConstraintsLookupConstraints3.tempWidth;
                            if (i66 == i64) {
                                int i67 = gridBagConstraintsLookupConstraints3.tempX;
                                int i68 = i66 + i67;
                                d = 0.0d;
                                double d2 = gridBagConstraintsLookupConstraints3.weightx;
                                while (i67 < i68) {
                                    d2 -= gridBagLayoutInfo.weightX[i67];
                                    i67++;
                                }
                                if (d2 > 0.0d) {
                                    double d3 = 0.0d;
                                    for (int i69 = gridBagConstraintsLookupConstraints3.tempX; i69 < i68; i69++) {
                                        d3 += gridBagLayoutInfo.weightX[i69];
                                    }
                                    for (int i70 = gridBagConstraintsLookupConstraints3.tempX; d3 > 0.0d && i70 < i68; i70++) {
                                        double[] dArr5 = gridBagLayoutInfo.weightX;
                                        double d4 = dArr5[i70];
                                        double d5 = (d4 * d2) / d3;
                                        dArr5[i70] = d4 + d5;
                                        d2 -= d5;
                                        d3 -= d4;
                                    }
                                    double[] dArr6 = gridBagLayoutInfo.weightX;
                                    int i71 = i68 - 1;
                                    dArr6[i71] = dArr6[i71] + d2;
                                }
                                int i72 = gridBagConstraintsLookupConstraints3.minWidth + gridBagConstraintsLookupConstraints3.ipadx;
                                Insets insets = gridBagConstraintsLookupConstraints3.insets;
                                int i73 = i72 + insets.left + insets.right;
                                for (int i74 = gridBagConstraintsLookupConstraints3.tempX; i74 < i68; i74++) {
                                    i73 -= gridBagLayoutInfo.minWidth[i74];
                                }
                                if (i73 > 0) {
                                    double d6 = 0.0d;
                                    for (int i75 = gridBagConstraintsLookupConstraints3.tempX; i75 < i68; i75++) {
                                        d6 += gridBagLayoutInfo.weightX[i75];
                                    }
                                    int i76 = gridBagConstraintsLookupConstraints3.tempX;
                                    while (d6 > 0.0d && i76 < i68) {
                                        double d7 = gridBagLayoutInfo.weightX[i76];
                                        GridBagConstraints gridBagConstraints2 = gridBagConstraintsLookupConstraints3;
                                        int i77 = (int) ((((double) i73) * d7) / d6);
                                        int[] iArr17 = gridBagLayoutInfo.minWidth;
                                        iArr17[i76] = iArr17[i76] + i77;
                                        i73 -= i77;
                                        d6 -= d7;
                                        i76++;
                                        gridBagConstraintsLookupConstraints3 = gridBagConstraints2;
                                    }
                                    gridBagConstraints = gridBagConstraintsLookupConstraints3;
                                    int[] iArr18 = gridBagLayoutInfo.minWidth;
                                    int i78 = i68 - 1;
                                    iArr18[i78] = iArr18[i78] + i73;
                                } else {
                                    gridBagConstraints = gridBagConstraintsLookupConstraints3;
                                }
                            } else {
                                gridBagConstraints = gridBagConstraintsLookupConstraints3;
                                d = 0.0d;
                                if (i66 > i64 && i66 < i4) {
                                    i4 = i66;
                                }
                            }
                            int i79 = gridBagConstraints.tempHeight;
                            if (i79 == i64) {
                                int i80 = gridBagConstraints.tempY;
                                int i81 = i79 + i80;
                                double d8 = gridBagConstraints.weighty;
                                while (i80 < i81) {
                                    d8 -= gridBagLayoutInfo.weightY[i80];
                                    i80++;
                                }
                                if (d8 > d) {
                                    double d9 = d;
                                    for (int i82 = gridBagConstraints.tempY; i82 < i81; i82++) {
                                        d9 += gridBagLayoutInfo.weightY[i82];
                                    }
                                    for (int i83 = gridBagConstraints.tempY; d9 > d && i83 < i81; i83++) {
                                        double[] dArr7 = gridBagLayoutInfo.weightY;
                                        double d10 = dArr7[i83];
                                        double d11 = (d10 * d8) / d9;
                                        dArr7[i83] = d10 + d11;
                                        d8 -= d11;
                                        d9 -= d10;
                                    }
                                    double[] dArr8 = gridBagLayoutInfo.weightY;
                                    int i84 = i81 - 1;
                                    dArr8[i84] = dArr8[i84] + d8;
                                }
                                if (i21 != 0) {
                                    int i85 = gridBagConstraints.anchor;
                                    if (i85 != 256 && i85 != 512) {
                                        if (i85 != 768) {
                                            if (i85 == 1024 || i85 == 1280 || i85 == 1536) {
                                                i8 = gridBagConstraints.insets.top + gridBagConstraints.minHeight + gridBagConstraints.ipady;
                                                i9 = iArr13[gridBagConstraints.tempY];
                                            } else {
                                                if (i85 == 1792 || i85 == 2048) {
                                                }
                                                i8 = iArr3[gridBagConstraints.tempY] + gridBagConstraints.minHeight + gridBagConstraints.insets.bottom;
                                                i9 = gridBagConstraints.ipady;
                                            }
                                            i6 = i8 + i9;
                                            i5 = -1;
                                        }
                                        if (i6 == i5) {
                                            int i86 = gridBagConstraints.minHeight + gridBagConstraints.ipady;
                                            Insets insets2 = gridBagConstraints.insets;
                                            i6 = i86 + insets2.top + insets2.bottom;
                                        }
                                        for (i7 = gridBagConstraints.tempY; i7 < i81; i7++) {
                                            i6 -= gridBagLayoutInfo.minHeight[i7];
                                        }
                                        if (i6 > 0) {
                                            double d12 = d;
                                            for (int i87 = gridBagConstraints.tempY; i87 < i81; i87++) {
                                                d12 += gridBagLayoutInfo.weightY[i87];
                                            }
                                            int i88 = gridBagConstraints.tempY;
                                            while (d12 > d && i88 < i81) {
                                                double d13 = gridBagLayoutInfo.weightY[i88];
                                                int i89 = i88;
                                                int i90 = (int) ((((double) i6) * d13) / d12);
                                                int[] iArr19 = gridBagLayoutInfo.minHeight;
                                                iArr19[i89] = iArr19[i89] + i90;
                                                i6 -= i90;
                                                d12 -= d13;
                                                i88 = i89 + 1;
                                            }
                                            int[] iArr20 = gridBagLayoutInfo.minHeight;
                                            int i91 = i81 - 1;
                                            iArr20[i91] = iArr20[i91] + i6;
                                        }
                                    }
                                    int i92 = gridBagConstraints.ascent;
                                    if (i92 >= 0) {
                                        if (gridBagConstraints.tempHeight == 1) {
                                            int i93 = gridBagConstraints.tempY;
                                            i6 = iArr13[i93] + iArr3[i93];
                                            i5 = -1;
                                            if (i6 == i5) {
                                            }
                                            while (i7 < i81) {
                                            }
                                            if (i6 > 0) {
                                            }
                                        } else if (gridBagConstraints.baselineResizeBehavior != Component.BaselineResizeBehavior.CONSTANT_DESCENT) {
                                            i8 = iArr3[gridBagConstraints.tempY];
                                            i9 = gridBagConstraints.descent;
                                            i6 = i8 + i9;
                                            i5 = -1;
                                            if (i6 == i5) {
                                            }
                                            while (i7 < i81) {
                                            }
                                            if (i6 > 0) {
                                            }
                                        } else {
                                            i6 = i92 + iArr13[(gridBagConstraints.tempY + r8) - 1];
                                        }
                                    }
                                    i5 = -1;
                                    if (i6 == i5) {
                                    }
                                    while (i7 < i81) {
                                    }
                                    if (i6 > 0) {
                                    }
                                }
                                i6 = -1;
                                i5 = -1;
                                if (i6 == i5) {
                                }
                                while (i7 < i81) {
                                }
                                if (i6 > 0) {
                                }
                            } else if (i79 > i64 && i79 < i4) {
                                i4 = i79;
                            }
                        }
                        i65++;
                        i63 = Integer.MAX_VALUE;
                        i2 = 0;
                    }
                }
            } finally {
            }
        }
        return gridBagLayoutInfo;
    }

    public Dimension GetMinSize(Container container, GridBagLayoutInfo gridBagLayoutInfo) {
        Dimension dimension = new Dimension();
        Insets insets = container.getInsets();
        int i = 0;
        for (int i2 = 0; i2 < gridBagLayoutInfo.width; i2++) {
            i += gridBagLayoutInfo.minWidth[i2];
        }
        dimension.width = i + insets.left + insets.right;
        int i4 = 0;
        for (int i5 = 0; i5 < gridBagLayoutInfo.height; i5++) {
            i4 += gridBagLayoutInfo.minHeight[i5];
        }
        dimension.height = i4 + insets.top + insets.bottom;
        return dimension;
    }

    @Override // org.apache.poi.java.awt.LayoutManager
    public void addLayoutComponent(String str, Component component) {
    }

    public void adjustForGravity(GridBagConstraints gridBagConstraints, Rectangle rectangle) {
        AdjustForGravity(gridBagConstraints, rectangle);
    }

    public void arrangeGrid(Container container) {
        ArrangeGrid(container);
    }

    public GridBagConstraints getConstraints(Component component) {
        GridBagConstraints gridBagConstraints = this.comptable.get(component);
        if (gridBagConstraints == null) {
            setConstraints(component, this.defaultConstraints);
            gridBagConstraints = this.comptable.get(component);
        }
        return (GridBagConstraints) gridBagConstraints.clone();
    }

    @Override // org.apache.poi.java.awt.LayoutManager2
    public float getLayoutAlignmentX(Container container) {
        return 0.5f;
    }

    @Override // org.apache.poi.java.awt.LayoutManager2
    public float getLayoutAlignmentY(Container container) {
        return 0.5f;
    }

    public int[][] getLayoutDimensions() {
        GridBagLayoutInfo gridBagLayoutInfo = this.layoutInfo;
        if (gridBagLayoutInfo == null) {
            return (int[][]) Array.newInstance((Class<?>) Integer.TYPE, 2, 0);
        }
        int i = gridBagLayoutInfo.width;
        int[][] iArr = {new int[i], new int[gridBagLayoutInfo.height]};
        System.arraycopy(gridBagLayoutInfo.minWidth, 0, iArr[0], 0, i);
        GridBagLayoutInfo gridBagLayoutInfo2 = this.layoutInfo;
        System.arraycopy(gridBagLayoutInfo2.minHeight, 0, iArr[1], 0, gridBagLayoutInfo2.height);
        return iArr;
    }

    public GridBagLayoutInfo getLayoutInfo(Container container, int i) {
        return GetLayoutInfo(container, i);
    }

    public Point getLayoutOrigin() {
        Point point = new Point(0, 0);
        GridBagLayoutInfo gridBagLayoutInfo = this.layoutInfo;
        if (gridBagLayoutInfo != null) {
            point.f10092x = gridBagLayoutInfo.startx;
            point.f10093y = gridBagLayoutInfo.starty;
        }
        return point;
    }

    public double[][] getLayoutWeights() {
        GridBagLayoutInfo gridBagLayoutInfo = this.layoutInfo;
        if (gridBagLayoutInfo == null) {
            return (double[][]) Array.newInstance((Class<?>) Double.TYPE, 2, 0);
        }
        int i = gridBagLayoutInfo.width;
        double[][] dArr = {new double[i], new double[gridBagLayoutInfo.height]};
        System.arraycopy(gridBagLayoutInfo.weightX, 0, dArr[0], 0, i);
        GridBagLayoutInfo gridBagLayoutInfo2 = this.layoutInfo;
        System.arraycopy(gridBagLayoutInfo2.weightY, 0, dArr[1], 0, gridBagLayoutInfo2.height);
        return dArr;
    }

    public Dimension getMinSize(Container container, GridBagLayoutInfo gridBagLayoutInfo) {
        return GetMinSize(container, gridBagLayoutInfo);
    }

    @Override // org.apache.poi.java.awt.LayoutManager
    public void layoutContainer(Container container) {
        arrangeGrid(container);
    }

    public Point location(int i, int i2) {
        int i4;
        int i5 = 0;
        Point point = new Point(0, 0);
        GridBagLayoutInfo gridBagLayoutInfo = this.layoutInfo;
        if (gridBagLayoutInfo == null) {
            return point;
        }
        int i6 = gridBagLayoutInfo.startx;
        if (this.rightToLeft) {
            int i7 = gridBagLayoutInfo.width - 1;
            while (i7 >= 0 && i6 <= i) {
                i6 += this.layoutInfo.minWidth[i7];
                i7--;
            }
            i4 = i7 + 1;
        } else {
            i4 = 0;
            while (true) {
                GridBagLayoutInfo gridBagLayoutInfo2 = this.layoutInfo;
                if (i4 >= gridBagLayoutInfo2.width || (i6 = i6 + gridBagLayoutInfo2.minWidth[i4]) > i) {
                    break;
                }
                i4++;
            }
        }
        point.f10092x = i4;
        int i8 = this.layoutInfo.starty;
        while (true) {
            GridBagLayoutInfo gridBagLayoutInfo3 = this.layoutInfo;
            if (i5 >= gridBagLayoutInfo3.height || (i8 = i8 + gridBagLayoutInfo3.minHeight[i5]) > i2) {
                break;
            }
            i5++;
        }
        point.f10093y = i5;
        return point;
    }

    public GridBagConstraints lookupConstraints(Component component) {
        GridBagConstraints gridBagConstraints = this.comptable.get(component);
        if (gridBagConstraints != null) {
            return gridBagConstraints;
        }
        setConstraints(component, this.defaultConstraints);
        return this.comptable.get(component);
    }

    @Override // org.apache.poi.java.awt.LayoutManager2
    public Dimension maximumLayoutSize(Container container) {
        return new Dimension(Integer.MAX_VALUE, Integer.MAX_VALUE);
    }

    @Override // org.apache.poi.java.awt.LayoutManager
    public Dimension minimumLayoutSize(Container container) {
        return getMinSize(container, getLayoutInfo(container, 1));
    }

    @Override // org.apache.poi.java.awt.LayoutManager
    public Dimension preferredLayoutSize(Container container) {
        return getMinSize(container, getLayoutInfo(container, 2));
    }

    @Override // org.apache.poi.java.awt.LayoutManager
    public void removeLayoutComponent(Component component) {
        removeConstraints(component);
    }

    public void setConstraints(Component component, GridBagConstraints gridBagConstraints) {
        this.comptable.put(component, (GridBagConstraints) gridBagConstraints.clone());
    }

    public String toString() {
        return getClass().getName();
    }

    @Override // org.apache.poi.java.awt.LayoutManager2
    public void addLayoutComponent(Component component, Object obj) {
        if (obj instanceof GridBagConstraints) {
            setConstraints(component, (GridBagConstraints) obj);
        } else if (obj != null) {
            throw new IllegalArgumentException("cannot add to layout: constraints must be a GridBagConstraint");
        }
    }

    @Override // org.apache.poi.java.awt.LayoutManager2
    public void invalidateLayout(Container container) {
    }
}
