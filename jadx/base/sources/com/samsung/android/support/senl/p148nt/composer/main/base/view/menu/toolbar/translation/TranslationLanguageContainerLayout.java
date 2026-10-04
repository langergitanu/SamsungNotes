package com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.translation;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import androidx.annotation.Nullable;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.common.AbsToolbarContainerLayout;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class TranslationLanguageContainerLayout extends AbsToolbarContainerLayout {
    private static final String PREF_KEY_TRANSLATION_LANGUAGE_TOOLBAR_X = "translation_language_toolbar_pos_x";
    private static final String PREF_KEY_TRANSLATION_LANGUAGE_TOOLBAR_Y = "translation_language_toolbar_pos_y";
    private static final String TAG = Logger.createTag("TranslationLanguageContainerLayout");

    public TranslationLanguageContainerLayout(Context context) {
        super(context);
        init(context);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.common.AbsToolbarContainerLayout, com.samsung.android.support.senl.p148nt.base.winset.view.floater.FloatLayout
    public void dispatchLongPress(MotionEvent motionEvent) {
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.common.AbsToolbarContainerLayout
    public String getChildName() {
        return getClass().getSimpleName();
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.common.AbsToolbarContainerLayout
    public void init(Context context) {
        super.init(context);
        this.pref_key_toolbar_x = PREF_KEY_TRANSLATION_LANGUAGE_TOOLBAR_X;
        this.pref_key_toolbar_y = PREF_KEY_TRANSLATION_LANGUAGE_TOOLBAR_Y;
        this.mInitialPositionX = 0.95f;
        this.mInitialPositionY = 0.1f;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.common.AbsToolbarContainerLayout
    public boolean isShowing() {
        boolean z = getVisibility() == 0;
        Logger.m11003i(TAG, "isShowing visibility " + getVisibility());
        return z;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.common.AbsToolbarContainerLayout, com.samsung.android.support.senl.p148nt.base.winset.view.floater.FloatLayout, androidx.constraintlayout.widget.ConstraintLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i4, int i5) {
        super.onLayout(z, i, i2, i4, i5);
        if (z) {
            setEndEdgeSize(i4 - i);
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.common.AbsToolbarContainerLayout, com.samsung.android.support.senl.p148nt.base.winset.view.floater.IFloater
    public void onLongPress() {
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.common.AbsToolbarContainerLayout, android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        AbstractC8014b.m7217s(i, "setVisibility ", TAG);
    }

    public TranslationLanguageContainerLayout(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context);
    }

    public TranslationLanguageContainerLayout(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(context);
    }
}
