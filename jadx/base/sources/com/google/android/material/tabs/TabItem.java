package com.google.android.material.tabs;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import androidx.appcompat.widget.TintTypedArray;
import com.google.android.material.C4548R;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public class TabItem extends View {
    public final int customLayout;
    public final Drawable icon;
    public CharSequence mSubText;
    public final CharSequence text;

    public TabItem(Context context) {
        this(context, null);
    }

    public TabItem(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TintTypedArray tintTypedArrayObtainStyledAttributes = TintTypedArray.obtainStyledAttributes(context, attributeSet, C4548R.styleable.TabItem);
        this.text = tintTypedArrayObtainStyledAttributes.getText(C4548R.styleable.TabItem_android_text);
        this.icon = tintTypedArrayObtainStyledAttributes.getDrawable(C4548R.styleable.TabItem_android_icon);
        this.customLayout = tintTypedArrayObtainStyledAttributes.getResourceId(C4548R.styleable.TabItem_android_layout, 0);
        tintTypedArrayObtainStyledAttributes.recycle();
    }
}
