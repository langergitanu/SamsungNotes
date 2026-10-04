package com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.p157ai.drawing.common;

import android.content.Context;
import android.view.View;
import android.widget.PopupWindow;
import androidx.annotation.NonNull;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.p157ai.drawing.generate.AiDrawingRequestLayout;
import p047K3.ViewOnLayoutChangeListenerC0162a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class AiDrawingRequestPopup extends PopupWindow {
    public static final String TAG = "AiDrawingRequestPopup";
    private View mAnchorView;
    private AiDrawingRequestLayout.Contract mContract;
    private boolean mIsPortrait;
    private final AiDrawingRequestLayout mRequestLayout;

    public AiDrawingRequestPopup(Context context) {
        super((View) new AiDrawingRequestLayout(context), -2, -2, true);
        AiDrawingRequestLayout aiDrawingRequestLayout = (AiDrawingRequestLayout) getContentView();
        this.mRequestLayout = aiDrawingRequestLayout;
        aiDrawingRequestLayout.setContract(new AiDrawingRequestLayout.Contract() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.ai.drawing.common.AiDrawingRequestPopup.1
            @Override // com.samsung.android.support.senl.nt.composer.main.base.view.menu.ai.drawing.generate.AiDrawingRequestLayout.Contract
            public int getGenerateStyleIndex() {
                if (AiDrawingRequestPopup.this.mContract == null) {
                    return 0;
                }
                return AiDrawingRequestPopup.this.mContract.getGenerateStyleIndex();
            }

            @Override // com.samsung.android.support.senl.nt.composer.main.base.view.menu.ai.drawing.generate.AiDrawingRequestLayout.Contract
            public void requestExecuteCreateImage() {
                AiDrawingRequestPopup.this.dismiss();
                if (AiDrawingRequestPopup.this.mContract != null) {
                    AiDrawingRequestPopup.this.mContract.requestExecuteCreateImage();
                }
            }

            @Override // com.samsung.android.support.senl.nt.composer.main.base.view.menu.ai.drawing.generate.AiDrawingRequestLayout.Contract
            public void requestUpdateGenerateStyleIndex(int i) {
                if (AiDrawingRequestPopup.this.mContract != null) {
                    AiDrawingRequestPopup.this.mContract.requestUpdateGenerateStyleIndex(i);
                }
            }
        });
        aiDrawingRequestLayout.addOnLayoutChangeListener(new ViewOnLayoutChangeListenerC0162a(this, 5));
        setBackgroundDrawable(getContentView().getResources().getDrawable(C9086R.drawable.ai_drawing_request_layout_bg, null));
        setElevation(getContentView().getResources().getDimension(C9086R.dimen.ai_drawing_request_layout_elevation));
    }

    @NonNull
    private int[] getAnchorLocation() {
        this.mAnchorView.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
        this.mRequestLayout.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
        int[] iArr = new int[2];
        this.mAnchorView.getLocationInWindow(iArr);
        iArr[0] = ((this.mAnchorView.getMeasuredWidth() - this.mRequestLayout.getMeasuredWidth()) / 2) + iArr[0];
        iArr[1] = iArr[1] + ((int) getElevation());
        return iArr;
    }

    private boolean isPortrait() {
        return this.mAnchorView.getResources().getConfiguration().orientation == 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$0(View view, int i, int i2, int i4, int i5, int i6, int i7, int i8, int i9) {
        if (this.mIsPortrait != isPortrait()) {
            dismiss();
        }
    }

    public void setContract(AiDrawingRequestLayout.Contract contract) {
        Logger.m10999d(TAG, "setContract, " + hashCode());
        this.mContract = contract;
    }

    public void show(View view) {
        int i;
        this.mAnchorView = view;
        this.mRequestLayout.updateLayout("showAsDropDown", true);
        int[] anchorLocation = new int[2];
        boolean zIsPortrait = isPortrait();
        this.mIsPortrait = zIsPortrait;
        if (zIsPortrait) {
            anchorLocation[1] = (int) getElevation();
            i = 81;
        } else {
            anchorLocation = getAnchorLocation();
            i = 0;
        }
        showAtLocation(this.mAnchorView, i, anchorLocation[0], anchorLocation[1]);
    }
}
