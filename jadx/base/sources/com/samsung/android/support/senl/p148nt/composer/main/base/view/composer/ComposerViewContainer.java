package com.samsung.android.support.senl.p148nt.composer.main.base.view.composer;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import androidx.collection.AbstractC0622a;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.ComposerConstants;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.data.database.core.query.sqlbuilder.SQLKeyword;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class ComposerViewContainer extends RelativeLayout {
    private static final String TAG = Logger.createTag("ComposerViewContainer");

    public ComposerViewContainer(Context context) {
        super(context);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void clearFocus() {
        View viewFindFocus = findFocus();
        if (ComposerConstants.SPEN_COMPOSER_VIEW_TAG.equals(viewFindFocus.getTag())) {
            int height = getHeight();
            int height2 = viewFindFocus.getHeight();
            if (height <= 0 && height2 > 0) {
                Logger.m11000e(TAG, "clearFocus# spenComposer focus true. " + height2 + SQLKeyword.COMMA + height);
                return;
            }
        }
        super.clearFocus();
    }

    @Override // android.widget.RelativeLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i4, int i5) {
        if (i5 - i2 > 0) {
            super.onLayout(z, i, i2, i4, i5);
            return;
        }
        String str = TAG;
        StringBuilder sbM1173s = AbstractC0622a.m1173s(i5, i2, "onLayout# bottom - top ", " - ", ", focus: ");
        sbM1173s.append(hasFocus());
        Logger.m11000e(str, sbM1173s.toString());
    }

    public ComposerViewContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public ComposerViewContainer(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public ComposerViewContainer(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
    }
}
