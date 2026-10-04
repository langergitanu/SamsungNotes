package org.apache.poi.java.awt;

import java.io.Serializable;
import org.apache.poi.java.awt.event.AdjustmentEvent;
import org.apache.poi.java.awt.event.AdjustmentListener;
import org.apache.poi.java.awt.peer.ScrollPanePeer;

/* JADX INFO: loaded from: classes10.dex */
class PeerFixer implements AdjustmentListener, Serializable {
    private static final long serialVersionUID = 7051237413532574756L;
    private ScrollPane scroller;

    public PeerFixer(ScrollPane scrollPane) {
        this.scroller = scrollPane;
    }

    public void adjustmentValueChanged(AdjustmentEvent adjustmentEvent) {
        Adjustable adjustable = adjustmentEvent.getAdjustable();
        int value = adjustmentEvent.getValue();
        ScrollPanePeer scrollPanePeer = this.scroller.peer;
        if (scrollPanePeer != null) {
            scrollPanePeer.setValue(adjustable, value);
        }
        Component component = this.scroller.getComponent(0);
        int orientation = adjustable.getOrientation();
        if (orientation == 0) {
            component.move(-value, component.getLocation().f10093y);
        } else {
            if (orientation != 1) {
                throw new IllegalArgumentException("Illegal adjustable orientation");
            }
            component.move(component.getLocation().f10092x, -value);
        }
    }
}
