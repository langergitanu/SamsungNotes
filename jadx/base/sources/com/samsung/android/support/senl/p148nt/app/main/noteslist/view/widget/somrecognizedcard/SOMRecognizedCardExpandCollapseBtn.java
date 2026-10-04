package com.samsung.android.support.senl.p148nt.app.main.noteslist.view.widget.somrecognizedcard;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.widget.FrameLayout;
import androidx.annotation.Nullable;
import androidx.core.view.animation.PathInterpolatorCompat;
import com.samsung.android.support.senl.p145cm.base.framework.view.ViewCompat;
import com.samsung.android.support.senl.p148nt.app.C8003R;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public class SOMRecognizedCardExpandCollapseBtn extends FrameLayout implements View.OnClickListener {
    private static final long BUTTON_ROTATE_DURATION = 300;
    private Contract mContract;
    private View mExpandCollapseBtn;
    private ViewPropertyAnimator mExpandCollapseBtnAnimator;
    private boolean mIsRecognizeRunning;
    private View mProgressView;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface Contract {
        void onClicked();
    }

    public SOMRecognizedCardExpandCollapseBtn(Context context) {
        super(context);
        this.mIsRecognizeRunning = true;
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(C8003R.layout.som_recognized_card_expand_collapse_btn, (ViewGroup) this, true);
        this.mExpandCollapseBtn = findViewById(C8003R.id.expand_collapse_btn);
        this.mProgressView = findViewById(C8003R.id.progress_view);
        this.mExpandCollapseBtn.setOnClickListener(this);
        updateRunningState(false);
    }

    private void updateDescription(boolean z) {
        String string = getResources().getString(z ? C8003R.string.expand : C8003R.string.collapse);
        this.mExpandCollapseBtn.setContentDescription(string);
        ViewCompat.getInstance().setTooltipText(this.mExpandCollapseBtn, string);
    }

    public void animateExpandCollapseBtn(boolean z) {
        ViewPropertyAnimator viewPropertyAnimator = this.mExpandCollapseBtnAnimator;
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.cancel();
        }
        ViewPropertyAnimator viewPropertyAnimatorRotation = this.mExpandCollapseBtn.animate().setInterpolator(PathInterpolatorCompat.create(0.22f, 0.25f, 0.0f, 1.0f)).setDuration(300L).rotation(z ? 180.0f : 0.0f);
        this.mExpandCollapseBtnAnimator = viewPropertyAnimatorRotation;
        viewPropertyAnimatorRotation.start();
        updateDescription(z);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Contract contract = this.mContract;
        if (contract == null) {
            return;
        }
        contract.onClicked();
    }

    public void setContract(Contract contract) {
        this.mContract = contract;
    }

    public void updateExpandCollapseBtn(boolean z) {
        this.mExpandCollapseBtn.setRotation(z ? 180.0f : 0.0f);
        updateDescription(z);
    }

    public void updateRunningState(boolean z) {
        if (this.mIsRecognizeRunning == z) {
            return;
        }
        this.mIsRecognizeRunning = z;
        if (z) {
            this.mProgressView.setVisibility(0);
            this.mExpandCollapseBtn.setVisibility(8);
        } else {
            this.mProgressView.setVisibility(8);
            this.mExpandCollapseBtn.setVisibility(0);
        }
    }

    public SOMRecognizedCardExpandCollapseBtn(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mIsRecognizeRunning = true;
        init(context);
    }

    public SOMRecognizedCardExpandCollapseBtn(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mIsRecognizeRunning = true;
        init(context);
    }
}
