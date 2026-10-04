package org.apache.poi.java.awt;

import org.apache.poi.java.awt.event.AdjustmentListener;

/* JADX INFO: loaded from: classes10.dex */
public interface Adjustable {
    public static final int HORIZONTAL = 0;
    public static final int NO_ORIENTATION = 2;
    public static final int VERTICAL = 1;

    void addAdjustmentListener(AdjustmentListener adjustmentListener);

    int getBlockIncrement();

    int getMaximum();

    int getMinimum();

    int getOrientation();

    int getUnitIncrement();

    int getValue();

    int getVisibleAmount();

    void removeAdjustmentListener(AdjustmentListener adjustmentListener);

    void setBlockIncrement(int i);

    void setMaximum(int i);

    void setMinimum(int i);

    void setUnitIncrement(int i);

    void setValue(int i);

    void setVisibleAmount(int i);
}
