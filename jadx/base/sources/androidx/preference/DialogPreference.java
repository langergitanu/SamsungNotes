package androidx.preference;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.content.res.TypedArrayUtils;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@RequiresApi(23)
public abstract class DialogPreference extends Preference {
    private Drawable mDialogIcon;
    private int mDialogLayoutResId;
    private CharSequence mDialogMessage;
    private CharSequence mDialogTitle;
    private CharSequence mNegativeButtonText;
    private CharSequence mPositiveButtonText;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface TargetFragment {
        @Nullable
        <T extends Preference> T findPreference(@NonNull CharSequence charSequence);
    }

    public DialogPreference(@NonNull Context context, @Nullable AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C3711R.styleable.DialogPreference, i, i2);
        String string = TypedArrayUtils.getString(typedArrayObtainStyledAttributes, C3711R.styleable.DialogPreference_dialogTitle, C3711R.styleable.DialogPreference_android_dialogTitle);
        this.mDialogTitle = string;
        if (string == null) {
            this.mDialogTitle = getTitle();
        }
        this.mDialogMessage = TypedArrayUtils.getString(typedArrayObtainStyledAttributes, C3711R.styleable.DialogPreference_dialogMessage, C3711R.styleable.DialogPreference_android_dialogMessage);
        this.mDialogIcon = TypedArrayUtils.getDrawable(typedArrayObtainStyledAttributes, C3711R.styleable.DialogPreference_dialogIcon, C3711R.styleable.DialogPreference_android_dialogIcon);
        this.mPositiveButtonText = TypedArrayUtils.getString(typedArrayObtainStyledAttributes, C3711R.styleable.DialogPreference_positiveButtonText, C3711R.styleable.DialogPreference_android_positiveButtonText);
        this.mNegativeButtonText = TypedArrayUtils.getString(typedArrayObtainStyledAttributes, C3711R.styleable.DialogPreference_negativeButtonText, C3711R.styleable.DialogPreference_android_negativeButtonText);
        this.mDialogLayoutResId = TypedArrayUtils.getResourceId(typedArrayObtainStyledAttributes, C3711R.styleable.DialogPreference_dialogLayout, C3711R.styleable.DialogPreference_android_dialogLayout, 0);
        typedArrayObtainStyledAttributes.recycle();
    }

    @Nullable
    public Drawable getDialogIcon() {
        return this.mDialogIcon;
    }

    public int getDialogLayoutResource() {
        return this.mDialogLayoutResId;
    }

    @Nullable
    public CharSequence getDialogMessage() {
        return this.mDialogMessage;
    }

    @Nullable
    public CharSequence getDialogTitle() {
        return this.mDialogTitle;
    }

    @Nullable
    public CharSequence getNegativeButtonText() {
        return this.mNegativeButtonText;
    }

    @Nullable
    public CharSequence getPositiveButtonText() {
        return this.mPositiveButtonText;
    }

    @CallSuper
    public void onBindDialogView(View view) {
        int i;
        View viewFindViewById = view.findViewById(android.R.id.message);
        if (viewFindViewById != null) {
            CharSequence dialogMessage = getDialogMessage();
            if (TextUtils.isEmpty(dialogMessage)) {
                i = 8;
            } else {
                if (viewFindViewById instanceof TextView) {
                    ((TextView) viewFindViewById).setText(dialogMessage);
                }
                i = 0;
            }
            if (viewFindViewById.getVisibility() != i) {
                viewFindViewById.setVisibility(i);
            }
        }
    }

    @Override // androidx.preference.Preference
    public void onClick() {
        getPreferenceManager().showDialog(this);
    }

    public void setDialogIcon(@Nullable Drawable drawable) {
        this.mDialogIcon = drawable;
    }

    public void setDialogLayoutResource(int i) {
        this.mDialogLayoutResId = i;
    }

    public void setDialogMessage(@Nullable CharSequence charSequence) {
        this.mDialogMessage = charSequence;
    }

    public void setDialogTitle(@Nullable CharSequence charSequence) {
        this.mDialogTitle = charSequence;
    }

    public void setNegativeButtonText(@Nullable CharSequence charSequence) {
        this.mNegativeButtonText = charSequence;
    }

    public void setPositiveButtonText(@Nullable CharSequence charSequence) {
        this.mPositiveButtonText = charSequence;
    }

    public void setDialogIcon(int i) {
        this.mDialogIcon = AppCompatResources.getDrawable(getContext(), i);
    }

    public void setDialogMessage(int i) {
        setDialogMessage(getContext().getString(i));
    }

    public void setDialogTitle(int i) {
        setDialogTitle(getContext().getString(i));
    }

    public void setNegativeButtonText(int i) {
        setNegativeButtonText(getContext().getString(i));
    }

    public void setPositiveButtonText(int i) {
        setPositiveButtonText(getContext().getString(i));
    }

    public DialogPreference(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, 0);
    }

    public DialogPreference(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, TypedArrayUtils.getAttr(context, C3711R.attr.dialogPreferenceStyle, android.R.attr.dialogPreferenceStyle));
    }

    public DialogPreference(@NonNull Context context) {
        this(context, null);
    }

    public void onDialogClosed(boolean z) {
    }

    public void onPrepareDialogBuilder(AlertDialog.Builder builder) {
    }
}
