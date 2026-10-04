package com.samsung.android.support.senl.addons.brush.binding.adapter;

import android.content.Context;
import android.graphics.Rect;
import android.text.TextPaint;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.collection.AbstractC0622a;
import com.samsung.android.support.senl.addons.C7944R;
import com.samsung.android.support.senl.addons.base.utils.Logger;
import com.samsung.android.support.senl.addons.base.utils.PlatformUtil;
import com.samsung.android.support.senl.p145cm.base.common.util.ResourceUtils;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m13885d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\r"}, m13886d2 = {"Lcom/samsung/android/support/senl/addons/brush/binding/adapter/BADoneTextSize;", "", "<init>", "()V", SearchConstants.TargetContents.TAG, "", "MIN_DONE_TEXT_SIZE", "", "setDoneTextSize", "", "view", "Landroid/view/View;", "maxWidth", "ntAddons_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class BADoneTextSize {

    @NotNull
    public static final BADoneTextSize INSTANCE = new BADoneTextSize();

    @NotNull
    private static final String TAG = Logger.createBrushTag("BADoneTextSize");
    private static int MIN_DONE_TEXT_SIZE = 5;

    private BADoneTextSize() {
    }

    public final void setDoneTextSize(@Nullable View view, int maxWidth) {
        if (view instanceof Button) {
            Button button = (Button) view;
            int dimensionPixelSize = button.getResources().getDimensionPixelSize(C7944R.dimen.brush_sub_menu_done_text_size);
            Context context = button.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
            float f = dimensionPixelSize;
            PlatformUtil.applyTextSizeUntilLargeSize((TextView) view, ResourceUtils.convertPixelToSp(context, f));
            DisplayMetrics displayMetrics = button.getContext().getResources().getDisplayMetrics();
            Intrinsics.checkNotNullExpressionValue(displayMetrics, "getDisplayMetrics(...)");
            DisplayMetrics displayMetrics2 = button.getContext().getApplicationContext().getResources().getDisplayMetrics();
            Intrinsics.checkNotNullExpressionValue(displayMetrics2, "getDisplayMetrics(...)");
            int i = displayMetrics.widthPixels;
            int i2 = displayMetrics.heightPixels;
            if (i > i2) {
                i = i2;
            }
            float f4 = i;
            int i4 = displayMetrics2.widthPixels;
            int i5 = displayMetrics2.heightPixels;
            if (i4 > i5) {
                i4 = i5;
            }
            float f5 = f4 / i4;
            String string = button.getText().toString();
            TextPaint textPaint = new TextPaint(button.getPaint());
            textPaint.setTextSize(f);
            Rect rect = new Rect();
            textPaint.getTextBounds(string, 0, string.length(), rect);
            int dimensionPixelSize2 = button.getResources().getDimensionPixelSize(C7944R.dimen.brush_button_padding) * 2;
            String str = TAG;
            StringBuilder sbM1173s = AbstractC0622a.m1173s(rect.width(), rect.height(), "setDoneTextSize textWidth :  ", " , textHeight: ", " , maxWidth: ");
            sbM1173s.append(maxWidth);
            sbM1173s.append(" , ratio: ");
            sbM1173s.append(f5);
            Logger.m7100d(str, sbM1173s.toString());
            float f6 = f;
            for (int iWidth = rect.width() + dimensionPixelSize2; iWidth > 0 && maxWidth > 0 && iWidth >= maxWidth; iWidth = rect.width() + dimensionPixelSize2) {
                f6 -= 1.0f;
                textPaint.setTextSize(f6);
                textPaint.getTextBounds(string, 0, string.length(), rect);
            }
            if (Float.compare(f6, f) != 0) {
                int i6 = MIN_DONE_TEXT_SIZE;
                if (f6 < i6) {
                    f6 = i6;
                }
                button.setTextSize(0, f6);
                Logger.m7100d(TAG, "setDoneTextSize textSize: " + f6);
                button.requestLayout();
            }
        }
    }
}
