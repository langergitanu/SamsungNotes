package com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.setting;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.core.view.ViewCompat;
import com.samsung.android.support.senl.p148nt.composer.C9086R;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class ViewGroupWrapperView {
    private final ViewGroup mWrapperView;

    public ViewGroupWrapperView(Context context, View view) {
        if (view.getParent() != null) {
            ((ViewGroup) view.getParent()).removeView(view);
        }
        if (view.getId() == -1) {
            view.setId(ViewCompat.generateViewId());
        }
        ViewGroup viewGroup = (ViewGroup) LayoutInflater.from(context).inflate(C9086R.layout.comp_hw_setting_view_wrapper, (ViewGroup) null);
        this.mWrapperView = viewGroup;
        ConstraintLayout constraintLayout = (ConstraintLayout) viewGroup.findViewById(C9086R.id.content_container);
        constraintLayout.addView(view);
        ConstraintSet constraintSet = new ConstraintSet();
        constraintSet.clone(constraintLayout);
        constraintSet.connect(view.getId(), 6, 0, 6);
        constraintSet.connect(view.getId(), 7, 0, 7);
        constraintSet.connect(view.getId(), 3, 0, 3);
        constraintSet.connect(view.getId(), 4, 0, 4);
        constraintSet.applyTo(constraintLayout);
    }

    public ViewGroup getView() {
        return this.mWrapperView;
    }
}
