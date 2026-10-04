package androidx.preference;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.SeekBar;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@RequiresApi(23)
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
class SeslSeekBarDialogPreference extends DialogPreference {
    private final Drawable mMyIcon;

    public SeslSeekBarDialogPreference(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        createActionButtons();
        this.mMyIcon = getDialogIcon();
        setDialogIcon((Drawable) null);
    }

    public static SeekBar getSeekBar(View view) {
        return (SeekBar) view.findViewById(C3711R.id.seekbar);
    }

    public void createActionButtons() {
        setPositiveButtonText(android.R.string.ok);
        setNegativeButtonText(android.R.string.cancel);
    }

    @Override // androidx.preference.DialogPreference
    public void onBindDialogView(View view) {
        super.onBindDialogView(view);
        ImageView imageView = (ImageView) view.findViewById(C3711R.id.icon);
        Drawable drawable = this.mMyIcon;
        if (drawable != null) {
            imageView.setImageDrawable(drawable);
        } else {
            imageView.setVisibility(8);
        }
    }

    public SeslSeekBarDialogPreference(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, 0);
    }

    public SeslSeekBarDialogPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, C3711R.attr.seekBarDialogPreferenceStyle);
    }

    public SeslSeekBarDialogPreference(Context context) {
        this(context, null);
    }
}
