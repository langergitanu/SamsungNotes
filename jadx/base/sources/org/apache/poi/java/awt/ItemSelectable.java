package org.apache.poi.java.awt;

import org.apache.poi.java.awt.event.ItemListener;

/* JADX INFO: loaded from: classes10.dex */
public interface ItemSelectable {
    void addItemListener(ItemListener itemListener);

    Object[] getSelectedObjects();

    void removeItemListener(ItemListener itemListener);
}
