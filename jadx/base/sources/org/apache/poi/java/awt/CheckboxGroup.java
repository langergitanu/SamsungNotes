package org.apache.poi.java.awt;

import java.io.Serializable;

/* JADX INFO: loaded from: classes10.dex */
public class CheckboxGroup implements Serializable {
    private static final long serialVersionUID = 3729780091441768983L;
    Checkbox selectedCheckbox = null;

    @Deprecated
    public Checkbox getCurrent() {
        return this.selectedCheckbox;
    }

    public Checkbox getSelectedCheckbox() {
        return getCurrent();
    }

    @Deprecated
    public synchronized void setCurrent(Checkbox checkbox) {
        Checkbox checkbox2;
        if (checkbox == null) {
            checkbox2 = this.selectedCheckbox;
            this.selectedCheckbox = checkbox;
            if (checkbox2 != null) {
                checkbox2.setState(false);
            }
            if (checkbox != null) {
                checkbox.setStateInternal(true);
            }
            return;
        }
        if (checkbox.group != this) {
            return;
        }
        checkbox2 = this.selectedCheckbox;
        this.selectedCheckbox = checkbox;
        if (checkbox2 != null && checkbox2 != checkbox && checkbox2.group == this) {
            checkbox2.setState(false);
        }
        if (checkbox != null && checkbox2 != checkbox && !checkbox.getState()) {
            checkbox.setStateInternal(true);
        }
        return;
    }

    public void setSelectedCheckbox(Checkbox checkbox) {
        setCurrent(checkbox);
    }

    public String toString() {
        return getClass().getName() + "[selectedCheckbox=" + this.selectedCheckbox + "]";
    }
}
