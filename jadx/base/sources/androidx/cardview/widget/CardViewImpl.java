package androidx.cardview.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import androidx.annotation.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
interface CardViewImpl {
    ColorStateList getBackgroundColor(CardViewDelegate cardViewDelegate);

    float getElevation(CardViewDelegate cardViewDelegate);

    float getMaxElevation(CardViewDelegate cardViewDelegate);

    float getMinHeight(CardViewDelegate cardViewDelegate);

    float getMinWidth(CardViewDelegate cardViewDelegate);

    float getRadius(CardViewDelegate cardViewDelegate);

    void initStatic();

    void initialize(CardViewDelegate cardViewDelegate, Context context, ColorStateList colorStateList, float f, float f4, float f5);

    void onCompatPaddingChanged(CardViewDelegate cardViewDelegate);

    void onPreventCornerOverlapChanged(CardViewDelegate cardViewDelegate);

    void setBackgroundColor(CardViewDelegate cardViewDelegate, @Nullable ColorStateList colorStateList);

    void setElevation(CardViewDelegate cardViewDelegate, float f);

    void setMaxElevation(CardViewDelegate cardViewDelegate, float f);

    void setRadius(CardViewDelegate cardViewDelegate, float f);

    void updatePadding(CardViewDelegate cardViewDelegate);
}
