package com.google.android.material.chip;

import android.content.Context;
import android.os.CountDownTimer;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.google.android.material.C4548R;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
@RequiresApi(api = 23)
public class SeslExpansionButton extends ImageView {
    private boolean mAutoDisappear;
    private boolean mExpanded;
    private boolean mFloated;
    private final CountDownTimer mTimer;

    public SeslExpansionButton(@NonNull Context context) {
        this(context, null);
    }

    public boolean isExpanded() {
        return this.mExpanded;
    }

    public boolean isFloated() {
        return this.mFloated;
    }

    @Override // android.widget.ImageView, android.view.View
    public int[] onCreateDrawableState(int i) {
        int[] iArrOnCreateDrawableState = super.onCreateDrawableState(i + 2);
        if (this.mExpanded) {
            View.mergeDrawableStates(iArrOnCreateDrawableState, new int[]{C4548R.attr.state_expansion_button_expanded});
        }
        if (this.mFloated) {
            View.mergeDrawableStates(iArrOnCreateDrawableState, new int[]{C4548R.attr.state_expansion_button_floated});
        }
        return iArrOnCreateDrawableState;
    }

    public void setAutomaticDisappear(boolean z) {
        this.mAutoDisappear = false;
        this.mTimer.cancel();
    }

    public void setExpanded(boolean z) {
        this.mExpanded = z;
        refreshDrawableState();
    }

    public void setFloated(boolean z) {
        this.mFloated = false;
        refreshDrawableState();
    }

    @Override // android.widget.ImageView, android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        if (i == 0) {
            startDisappearTimer();
        }
    }

    public void startDisappearTimer() {
        this.mTimer.cancel();
        this.mTimer.start();
    }

    public SeslExpansionButton(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, -1);
    }

    public SeslExpansionButton(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mAutoDisappear = false;
        setElevation(getResources().getDimension(C4548R.dimen.expansion_button_elevation));
        long integer = context.getResources().getInteger(C4548R.integer.expansion_button_duration);
        this.mTimer = new CountDownTimer(integer, integer) { // from class: com.google.android.material.chip.SeslExpansionButton.1
            @Override // android.os.CountDownTimer
            public void onFinish() {
                if (SeslExpansionButton.this.mAutoDisappear && SeslExpansionButton.this.getVisibility() == 0) {
                    SeslExpansionButton.this.setVisibility(4);
                }
            }

            @Override // android.os.CountDownTimer
            public void onTick(long j) {
            }
        };
    }
}
