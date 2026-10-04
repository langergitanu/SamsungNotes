package androidx.appcompat.widget;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.appcompat.C0419R;
import androidx.appcompat.util.SeslMisc;
import androidx.core.content.res.ResourcesCompat;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@RequiresApi(23)
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class SeslDropDownItemTextView extends SeslCheckedTextView {
    private static final int FONT_WEIGHT_REGULAR = 400;
    private static final int FONT_WEIGHT_SEMIBOLD = 600;
    private static final String TAG = "SeslDropDownItemTextView";

    public SeslDropDownItemTextView(Context context) {
        this(context, null);
    }

    @Override // androidx.appcompat.widget.SeslCheckedTextView, android.widget.Checkable
    public void setChecked(boolean z) {
        Context context;
        super.setChecked(z);
        if (Build.VERSION.SDK_INT >= 34) {
            setTypeface(Typeface.create(Typeface.create("sec", 0), z ? 600 : 400, false));
        } else {
            setTypeface(Typeface.create("sec-roboto-light", z ? 1 : 0));
        }
        if (z && (context = getContext()) != null && getCurrentTextColor() == -65281) {
            String str = TAG;
            Log.w(str, "text color reload!");
            ColorStateList colorStateList = ResourcesCompat.getColorStateList(context.getResources(), SeslMisc.isLightTheme(context) ? C0419R.color.sesl_spinner_dropdown_text_color_light : C0419R.color.sesl_spinner_dropdown_text_color_dark, context.getTheme());
            if (colorStateList != null) {
                setTextColor(colorStateList);
            } else {
                Log.w(str, "Didn't set SeslDropDownItemTextView text color!!");
            }
        }
    }

    public SeslDropDownItemTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.textViewStyle);
    }

    public SeslDropDownItemTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Resources resources = context.getResources();
        setMaxWidth(resources.getDisplayMetrics().widthPixels - (resources.getDimensionPixelSize(C0419R.dimen.sesl_menu_popup_offset_horizontal) * 2));
    }
}
