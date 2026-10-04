package androidx.appcompat.widget;

import android.content.Context;
import android.util.AttributeSet;
import androidx.annotation.RequiresApi;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@RequiresApi(23)
public class SeslToggleSwitch extends SwitchCompat {
    private OnBeforeCheckedChangeListener mOnBeforeListener;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface OnBeforeCheckedChangeListener {
        boolean onBeforeCheckedChanged(SeslToggleSwitch seslToggleSwitch, boolean z);
    }

    public SeslToggleSwitch(Context context) {
        super(context);
    }

    @Override // androidx.appcompat.widget.SwitchCompat, android.widget.CompoundButton, android.widget.Checkable
    public void setChecked(boolean z) {
        OnBeforeCheckedChangeListener onBeforeCheckedChangeListener = this.mOnBeforeListener;
        if (onBeforeCheckedChangeListener == null || !onBeforeCheckedChangeListener.onBeforeCheckedChanged(this, z)) {
            super.setChecked(z);
        }
    }

    public void setCheckedInternal(boolean z) {
        super.setChecked(z);
    }

    public void setOnBeforeCheckedChangeListener(OnBeforeCheckedChangeListener onBeforeCheckedChangeListener) {
        this.mOnBeforeListener = onBeforeCheckedChangeListener;
    }

    public SeslToggleSwitch(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public SeslToggleSwitch(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}
