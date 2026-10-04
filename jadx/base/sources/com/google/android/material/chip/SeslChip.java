package com.google.android.material.chip;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.ContextThemeWrapper;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.google.android.material.C4548R;
import com.google.android.material.resources.TextAppearance;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
@RequiresApi(api = 23)
public class SeslChip extends Chip {
    private int mChipMinWidth;

    public SeslChip(Context context) {
        this(context, null);
    }

    private void setChipIconAlpha(int i) {
        Drawable chipIcon = getChipIcon();
        if (chipIcon == null) {
            return;
        }
        chipIcon.setAlpha(i);
    }

    private void setCloseIconAlpha(int i) {
        Drawable closeIcon = getCloseIcon();
        if (closeIcon == null) {
            return;
        }
        closeIcon.setAlpha(i);
    }

    private void setTextAlpha(int i) {
        ColorStateList textColor;
        ChipDrawable chipDrawable = (ChipDrawable) getChipDrawable();
        TextAppearance textAppearance = chipDrawable.getTextAppearance();
        if (textAppearance == null || (textColor = textAppearance.getTextColor()) == null) {
            return;
        }
        chipDrawable.setTextColor(textColor.withAlpha(i));
    }

    private void updateLayoutParamsWidth() {
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams != null) {
            layoutParams.width = getChipDrawable().getIntrinsicWidth() + ((int) getChipEndPadding());
            setLayoutParams(layoutParams);
        }
    }

    @Override // com.google.android.material.chip.Chip
    @Nullable
    public Drawable getBackgroundDrawable() {
        return getChipDrawable();
    }

    public int getChipMinWidth() {
        return this.mChipMinWidth;
    }

    @Override // android.widget.TextView
    public CharSequence getText() {
        return ((ChipDrawable) getChipDrawable()).getText();
    }

    public void refreshChip() {
        requestLayout();
    }

    public void setBackgroundAlpha(int i) {
        getChipDrawable().setAlpha(i);
    }

    @Override // com.google.android.material.chip.Chip
    public void setChipIconVisible(boolean z) {
        super.setChipIconVisible(z);
        updateLayoutParamsWidth();
    }

    public void setChipMinWidth(int i) {
        this.mChipMinWidth = i;
    }

    @Override // com.google.android.material.chip.Chip
    public void setCloseIconVisible(boolean z) {
        super.setCloseIconVisible(z);
        updateLayoutParamsWidth();
    }

    public void setInternalsAlpha(int i) {
        setTextAlpha(i);
        setCloseIconAlpha(i);
        setChipIconAlpha(i);
    }

    @Override // android.widget.TextView, android.view.View
    public void setSelected(boolean z) {
        super.setSelected(z);
        updateLayoutParamsWidth();
    }

    public void setSeslFullText(boolean z) {
        ((ChipDrawable) getChipDrawable()).setSeslFullText(z);
    }

    @Override // com.google.android.material.chip.Chip, android.widget.TextView
    public void setText(CharSequence charSequence, TextView.BufferType bufferType) {
        if (TextUtils.isEmpty(charSequence) && bufferType == TextView.BufferType.SPANNABLE) {
            return;
        }
        if (Build.VERSION.SDK_INT <= 28) {
            if (charSequence == null) {
                charSequence = "";
            }
            super.setText(charSequence, bufferType);
        } else {
            ChipDrawable chipDrawable = (ChipDrawable) getChipDrawable();
            if (chipDrawable == null) {
                super.setText(charSequence, bufferType);
            } else {
                chipDrawable.setText(charSequence);
                updateLayoutParamsWidth();
            }
        }
    }

    public SeslChip(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, C4548R.attr.chipStyle);
    }

    public SeslChip(Context context, AttributeSet attributeSet, int i) {
        super(new ContextThemeWrapper(context, C4548R.style.SeslPeoplePickerStyle), attributeSet, i);
        ChipDrawable chipDrawable = (ChipDrawable) getChipDrawable();
        if (chipDrawable != null) {
            if (Build.VERSION.SDK_INT >= 28) {
                chipDrawable.setShouldDrawText(true);
            }
            chipDrawable.setCloseIconTint(null);
            chipDrawable.setChipIconTint(null);
        }
    }

    @Override // com.google.android.material.chip.Chip
    public void setChipIconVisible(int i) {
        setChipIconVisible(getContext().getResources().getBoolean(i));
    }

    @Override // com.google.android.material.chip.Chip
    public void setCloseIconVisible(int i) {
        setCloseIconVisible(getContext().getResources().getBoolean(i));
    }
}
