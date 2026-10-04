package com.samsung.android.support.senl.p148nt.base.winset.app.dialog;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.view.Window;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;
import com.google.android.material.textfield.TextInputLayout;
import com.samsung.android.support.senl.p145cm.base.framework.view.InputMethodCompat;
import com.samsung.android.support.senl.p145cm.base.framework.view.ViewCompat;
import com.samsung.android.support.senl.p148nt.base.C8875R;
import com.samsung.android.support.senl.p148nt.base.common.samsunganalytices.CommonSamsungAnalytics;
import com.samsung.android.support.senl.p148nt.base.common.util.CharUtils;
import com.samsung.android.support.senl.p148nt.base.framework.support.Logger;
import com.samsung.android.support.senl.p148nt.base.winset.builder.AlertDialogBuilderForAppCompat;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p039I2.DialogInterfaceOnClickListenerC0140a;
import p054M1.DialogInterfaceOnShowListenerC0176c;
import p091W2.C0331a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0016\u0018\u0000 ,2\u00020\u0001:\u0001,B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J\u0010\u0010\u001a\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J\u0012\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0016J\u0012\u0010\u001f\u001a\u0004\u0018\u00010\u00052\u0006\u0010 \u001a\u00020!H\u0016J\u0012\u0010\"\u001a\u00020#2\b\u0010 \u001a\u0004\u0018\u00010!H\u0002J\u0018\u0010$\u001a\u00020\u00052\u0006\u0010 \u001a\u00020!2\u0006\u0010%\u001a\u00020#H\u0002J\u0010\u0010&\u001a\u00020\u00172\u0006\u0010'\u001a\u00020\u000bH\u0014J\u0006\u0010(\u001a\u00020\u0017J\u0010\u0010)\u001a\u00020\u00172\u0006\u0010*\u001a\u00020+H\u0004R\u0014\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0004@\u0004X\u0085\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0004@\u0004X\u0085\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\u0004\u0018\u00010\r8\u0004@\u0004X\u0085\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\u0004\u0018\u00010\u000f8\u0004@\u0004X\u0085\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\u0004\u0018\u00010\u00118\u0004@\u0004X\u0085\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001a\u0004\u0018\u00010\u00118\u0004@\u0004X\u0085\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0013\u001a\u0004\u0018\u00010\u00118\u0004@\u0004X\u0085\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0014\u001a\u00020\u00158\u0004@\u0004X\u0085\u000e¢\u0006\u0002\n\u0000¨\u0006-"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/winset/app/dialog/VerifyPasswordDialogFragment;", "Landroidx/fragment/app/DialogFragment;", "<init>", "()V", "mAlertDialog", "Landroidx/appcompat/app/AlertDialog;", "mEditText", "Landroid/widget/EditText;", "mTextInputLayout", "Lcom/google/android/material/textfield/TextInputLayout;", "mNotMatch", "", "mDoneClickListener", "Landroid/view/View$OnClickListener;", "mCancelClickListener", "Landroid/content/DialogInterface$OnClickListener;", "mTitle", "", "mInfoStr", "mHintStr", "mMaxLength", "", "onDismiss", "", "dialog", "Landroid/content/DialogInterface;", "onCancel", "onCreateDialog", "Landroid/app/Dialog;", "savedInstanceState", "Landroid/os/Bundle;", "createDialog", "context", "Landroid/content/Context;", "initLayout", "Landroid/view/View;", "initDialog", "customLayout", "positiveButtonEnable", "enable", "setNotMatchPassword", "verifyInputText", "s", "Landroid/text/Editable;", "Companion", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nVerifyPasswordDialogFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 VerifyPasswordDialogFragment.kt\ncom/samsung/android/support/senl/nt/base/winset/app/dialog/VerifyPasswordDialogFragment\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,214:1\n1#2:215\n*E\n"})
public class VerifyPasswordDialogFragment extends DialogFragment {
    private static final int BUTTON_STATE_ANIM_DURATION = 300;
    private static final float BUTTON_STATE_DISABLE_ALPHA = 0.4f;
    private static final float BUTTON_STATE_ENABLE_ALPHA = 1.0f;
    private static final int DOC_PASSWORD_MAX_LENGTH = 16;
    private static final float PASSWORD_HINT_TEXT_MAX_SIZE = 17.0f;

    @NotNull
    public static final String TAG = "VerifyPasswordDialogFragment";

    @JvmField
    @Nullable
    protected AlertDialog mAlertDialog;

    @JvmField
    @Nullable
    protected DialogInterface.OnClickListener mCancelClickListener;

    @JvmField
    @Nullable
    protected View.OnClickListener mDoneClickListener;

    @JvmField
    @Nullable
    protected EditText mEditText;

    @JvmField
    @Nullable
    protected String mHintStr;

    @JvmField
    @Nullable
    protected String mInfoStr;

    @JvmField
    protected int mMaxLength = 16;
    private boolean mNotMatch;

    @Nullable
    private TextInputLayout mTextInputLayout;

    @JvmField
    @Nullable
    protected String mTitle;

    private final AlertDialog initDialog(Context context, View customLayout) {
        AlertDialog alertDialogCreate = new AlertDialogBuilderForAppCompat(context, 0, 2, null).create();
        alertDialogCreate.setView(customLayout);
        alertDialogCreate.setCancelable(false);
        alertDialogCreate.setButton(-1, context.getString(C8875R.string.dialog_done), new DialogInterfaceOnClickListenerC0140a(13));
        alertDialogCreate.setButton(-2, context.getString(C8875R.string.dialog_cancel), this.mCancelClickListener);
        alertDialogCreate.setCanceledOnTouchOutside(false);
        alertDialogCreate.setTitle(this.mTitle);
        alertDialogCreate.setOnShowListener(new DialogInterfaceOnShowListenerC0176c(this, 5));
        Window window = alertDialogCreate.getWindow();
        if (window != null) {
            window.setSoftInputMode(37);
        }
        return alertDialogCreate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initDialog$lambda$2(DialogInterface dialogInterface, int i) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initDialog$lambda$4(VerifyPasswordDialogFragment verifyPasswordDialogFragment, DialogInterface dialogInterface) {
        Editable editableText;
        Button button;
        AlertDialog alertDialog = verifyPasswordDialogFragment.mAlertDialog;
        if (alertDialog != null && (button = alertDialog.getButton(-1)) != null) {
            button.setOnClickListener(verifyPasswordDialogFragment.mDoneClickListener);
        }
        EditText editText = verifyPasswordDialogFragment.mEditText;
        if (editText == null || (editableText = editText.getEditableText()) == null) {
            return;
        }
        verifyPasswordDialogFragment.verifyInputText(editableText);
    }

    private final View initLayout(Context context) {
        View viewInflate = LayoutInflater.from(context).inflate(C8875R.layout.verify_password_dialog_layout, (ViewGroup) null);
        ((TextView) viewInflate.findViewById(C8875R.id.info_text)).setText(this.mInfoStr);
        TextInputLayout textInputLayout = (TextInputLayout) viewInflate.findViewById(C8875R.id.edit_layout);
        this.mTextInputLayout = textInputLayout;
        if (textInputLayout != null) {
            textInputLayout.setPasswordVisibilityToggleEnabled(false);
        }
        EditText editText = (EditText) viewInflate.findViewById(C8875R.id.edit_password);
        this.mEditText = editText;
        if (editText != null) {
            editText.setFilters(new InputFilter[]{new InputFilter.LengthFilter(this.mMaxLength)});
        }
        ViewCompat.INSTANCE.getInstance().setSemSetActionModeAutoFillEnabled(this.mEditText, false);
        EditText editText2 = this.mEditText;
        if (editText2 != null) {
            editText2.addTextChangedListener(new TextWatcher() { // from class: com.samsung.android.support.senl.nt.base.winset.app.dialog.VerifyPasswordDialogFragment.initLayout.1
                @Override // android.text.TextWatcher
                public void afterTextChanged(Editable s) {
                    Intrinsics.checkNotNullParameter(s, "s");
                    VerifyPasswordDialogFragment.this.verifyInputText(s);
                }

                @Override // android.text.TextWatcher
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                    Intrinsics.checkNotNullParameter(s, "s");
                }

                @Override // android.text.TextWatcher
                public void onTextChanged(CharSequence s, int start, int before, int count) {
                    Intrinsics.checkNotNullParameter(s, "s");
                }
            });
        }
        EditText editText3 = this.mEditText;
        if (editText3 != null) {
            editText3.setTransformationMethod(RemoveNewLinePasswordTransformationMethod.INSTANCE.getInstance());
        }
        EditText editText4 = this.mEditText;
        if (editText4 != null) {
            editText4.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.samsung.android.support.senl.nt.base.winset.app.dialog.VerifyPasswordDialogFragment.initLayout.2
                private final void callOnclickPositive() {
                    AlertDialog alertDialog = VerifyPasswordDialogFragment.this.mAlertDialog;
                    Button button = alertDialog != null ? alertDialog.getButton(-1) : null;
                    if (button != null) {
                        button.callOnClick();
                    }
                }

                @Override // android.widget.TextView.OnEditorActionListener
                public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                    Intrinsics.checkNotNullParameter(v, "v");
                    if (event != null && (66 == event.getKeyCode() || 160 == event.getKeyCode())) {
                        if (event.getAction() == 1) {
                            callOnclickPositive();
                        }
                        return true;
                    }
                    if (actionId != 6) {
                        return false;
                    }
                    callOnclickPositive();
                    return true;
                }
            });
        }
        EditText editText5 = this.mEditText;
        if (editText5 != null) {
            editText5.setHint(this.mHintStr);
        }
        EditText editText6 = this.mEditText;
        CharUtils.applyTextSizeUntilLargeSize(editText6 != null ? editText6.getContext() : null, this.mEditText, PASSWORD_HINT_TEXT_MAX_SIZE);
        ((CheckBox) viewInflate.findViewById(C8875R.id.show_pwd_check)).setOnCheckedChangeListener(new C0331a(this, 9));
        Intrinsics.checkNotNull(viewInflate);
        return viewInflate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initLayout$lambda$1(VerifyPasswordDialogFragment verifyPasswordDialogFragment, CompoundButton buttonView, boolean z) {
        Intrinsics.checkNotNullParameter(buttonView, "buttonView");
        if (z) {
            CommonSamsungAnalytics.INSTANCE.insertLog("715", "7151", "0");
            EditText editText = verifyPasswordDialogFragment.mEditText;
            if (editText != null) {
                editText.setTransformationMethod(RemoveNewLineTransformationMethod.INSTANCE.getInstance());
            }
        } else {
            CommonSamsungAnalytics.INSTANCE.insertLog("715", "7151", "1");
            EditText editText2 = verifyPasswordDialogFragment.mEditText;
            if (editText2 != null) {
                editText2.setTransformationMethod(RemoveNewLinePasswordTransformationMethod.INSTANCE.getInstance());
            }
        }
        EditText editText3 = verifyPasswordDialogFragment.mEditText;
        if (editText3 != null) {
            int length = editText3.length();
            EditText editText4 = verifyPasswordDialogFragment.mEditText;
            if (editText4 != null) {
                editText4.setSelection(length);
            }
        }
    }

    @Nullable
    public AlertDialog createDialog(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return initDialog(context, initLayout(context));
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnCancelListener
    public void onCancel(@NotNull DialogInterface dialog) {
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        super.onCancel(dialog);
    }

    @Override // androidx.fragment.app.DialogFragment
    @NotNull
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        AlertDialog alertDialogCreateDialog = createDialog(contextRequireContext);
        this.mAlertDialog = alertDialogCreateDialog;
        Intrinsics.checkNotNull(alertDialogCreateDialog);
        return alertDialogCreateDialog;
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public void onDismiss(@NotNull DialogInterface dialog) {
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        super.onDismiss(dialog);
        if (getContext() != null) {
            InputMethodCompat.INSTANCE.getInstance().forceHideSoftInput(getContext());
        }
    }

    public void positiveButtonEnable(boolean enable) {
        ViewPropertyAnimator viewPropertyAnimatorAnimate;
        ViewPropertyAnimator viewPropertyAnimatorAlpha;
        ViewPropertyAnimator duration;
        ViewPropertyAnimator viewPropertyAnimatorAnimate2;
        ViewPropertyAnimator viewPropertyAnimatorAlpha2;
        ViewPropertyAnimator duration2;
        AlertDialog alertDialog = this.mAlertDialog;
        if (alertDialog == null) {
            return;
        }
        Button button = alertDialog != null ? alertDialog.getButton(-1) : null;
        if (button != null) {
            button.setEnabled(enable);
        }
        if (enable) {
            if (button == null || (viewPropertyAnimatorAnimate2 = button.animate()) == null || (viewPropertyAnimatorAlpha2 = viewPropertyAnimatorAnimate2.alpha(1.0f)) == null || (duration2 = viewPropertyAnimatorAlpha2.setDuration(300L)) == null) {
                return;
            }
            duration2.start();
            return;
        }
        if (button == null || (viewPropertyAnimatorAnimate = button.animate()) == null || (viewPropertyAnimatorAlpha = viewPropertyAnimatorAnimate.alpha(0.4f)) == null || (duration = viewPropertyAnimatorAlpha.setDuration(300L)) == null) {
            return;
        }
        duration.start();
    }

    public final void setNotMatchPassword() {
        Resources resources;
        this.mNotMatch = true;
        TextInputLayout textInputLayout = this.mTextInputLayout;
        if (textInputLayout != null) {
            textInputLayout.setError((textInputLayout == null || (resources = textInputLayout.getResources()) == null) ? null : resources.getString(C8875R.string.convert_dialog_unlock_incorrect_password));
        }
        TextInputLayout textInputLayout2 = this.mTextInputLayout;
        if (textInputLayout2 != null) {
            textInputLayout2.setErrorEnabled(true);
        }
        EditText editText = this.mEditText;
        if (editText != null) {
            editText.setText((CharSequence) null);
        }
        Logger.m8697d(TAG, "SpenInvalidPasswordException");
    }

    public final void verifyInputText(@NotNull Editable s) {
        Resources resources;
        Intrinsics.checkNotNullParameter(s, "s");
        int length = s.toString().length();
        positiveButtonEnable(length > 0);
        if (this.mNotMatch) {
            this.mNotMatch = false;
            return;
        }
        if (length < this.mMaxLength) {
            TextInputLayout textInputLayout = this.mTextInputLayout;
            if (textInputLayout != null) {
                textInputLayout.setError("");
            }
            TextInputLayout textInputLayout2 = this.mTextInputLayout;
            if (textInputLayout2 != null) {
                textInputLayout2.setErrorEnabled(false);
                return;
            }
            return;
        }
        TextInputLayout textInputLayout3 = this.mTextInputLayout;
        if (textInputLayout3 != null) {
            EditText editText = this.mEditText;
            textInputLayout3.setError((editText == null || (resources = editText.getResources()) == null) ? null : resources.getString(C8875R.string.category_maximum_number_of_characters_exceeded, Integer.valueOf(this.mMaxLength)));
        }
        TextInputLayout textInputLayout4 = this.mTextInputLayout;
        if (textInputLayout4 != null) {
            textInputLayout4.setErrorEnabled(true);
        }
    }
}
