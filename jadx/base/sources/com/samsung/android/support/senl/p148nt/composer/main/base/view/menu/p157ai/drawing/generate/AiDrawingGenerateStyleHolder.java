package com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.p157ai.drawing.generate;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.samsung.android.support.senl.p145cm.base.framework.support.BaseUtils;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.drawing.common.AiDrawingUtil;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class AiDrawingGenerateStyleHolder extends RecyclerView.ViewHolder {
    private Contract mContract;
    private int mStyleIndex;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface Contract {
        void requestUpdateGenerateStyleIndex(int i);
    }

    public AiDrawingGenerateStyleHolder(@NonNull View view) {
        super(view);
    }

    @DrawableRes
    private int getStyleImageRes() {
        TypedArray imageStyleResources;
        if (BaseUtils.getApplicationContext() == null || (imageStyleResources = AiDrawingUtil.getImageStyleResources()) == null) {
            return 0;
        }
        int length = imageStyleResources.length();
        int i = this.mStyleIndex;
        if (length <= i) {
            return 0;
        }
        int resourceId = imageStyleResources.getResourceId(i, 0);
        imageStyleResources.recycle();
        return resourceId;
    }

    private String getStyleName() {
        Context applicationContext = BaseUtils.getApplicationContext();
        return applicationContext == null ? "" : AiDrawingUtil.getImageStyleNameList(applicationContext)[this.mStyleIndex];
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$updateItemLayout$0(View view) {
        Contract contract = this.mContract;
        if (contract == null) {
            return;
        }
        contract.requestUpdateGenerateStyleIndex(this.mStyleIndex);
    }

    private void updateContainer(boolean z) {
        View viewFindViewById = this.itemView.findViewById(C9086R.id.ai_drawing_generate_style_item_container);
        viewFindViewById.setSelected(z);
        ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) viewFindViewById.getLayoutParams();
        if (AiDrawingUtil.getLastRowStartIndex() == this.mStyleIndex) {
            layoutParams.startToStart = -1;
            layoutParams.endToEnd = 0;
        } else if (AiDrawingUtil.getLastRowEndIndex() == this.mStyleIndex) {
            layoutParams.startToStart = 0;
            layoutParams.endToEnd = -1;
        } else {
            layoutParams.startToStart = 0;
            layoutParams.endToEnd = 0;
        }
        viewFindViewById.setLayoutParams(layoutParams);
    }

    private void updateItemLayout(String str) {
        View viewFindViewById = this.itemView.findViewById(C9086R.id.ai_drawing_generate_style_item);
        viewFindViewById.setOnClickListener(new View.OnClickListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.ai.drawing.generate.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f7153a.lambda$updateItemLayout$0(view);
            }
        });
        viewFindViewById.setContentDescription(str);
    }

    @SuppressLint({"ResourceType"})
    private void updateStyleImage() {
        int styleImageRes = getStyleImageRes();
        if (styleImageRes <= 0) {
            return;
        }
        ((ImageView) this.itemView.findViewById(C9086R.id.ai_drawing_generate_style_item_image)).setImageResource(styleImageRes);
    }

    private void updateStyleName(String str) {
        ((TextView) this.itemView.findViewById(C9086R.id.ai_drawing_generate_style_item_name)).setText(str);
    }

    public void decorate(int i, boolean z) {
        this.mStyleIndex = i;
        String styleName = getStyleName();
        updateContainer(z);
        updateItemLayout(styleName);
        updateStyleName(styleName);
        updateStyleImage();
    }

    public void setContract(Contract contract) {
        this.mContract = contract;
    }
}
