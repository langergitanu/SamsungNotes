package com.samsung.android.support.senl.p148nt.composer.main.base.view.dialog;

import android.R;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.text.InputFilter;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.google.android.material.textfield.TextInputLayout;
import com.samsung.android.sdk.pen.text.inputmethod.SpenInputEmojiUtil;
import com.samsung.android.support.senl.p145cm.base.framework.view.InputMethodCompat;
import com.samsung.android.support.senl.p145cm.base.framework.view.ViewCompat;
import com.samsung.android.support.senl.p145cm.base.framework.view.WindowManagerCompat;
import com.samsung.android.support.senl.p148nt.base.common.UserInputSkipper;
import com.samsung.android.support.senl.p148nt.base.common.util.CharUtils;
import com.samsung.android.support.senl.p148nt.base.common.util.ResourceUtils;
import com.samsung.android.support.senl.p148nt.base.winset.app.dialog.IEditDialogResult;
import com.samsung.android.support.senl.p148nt.base.winset.app.dialog.ITemplateEditDialogResult;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.constants.ChangeTemplateConstants;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.template.editor.TemplateEditorView;
import java.util.regex.Pattern;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class TemplateNameDialog extends DialogFragment {
    protected static final int BUTTON_STATE_ANIM_DURATION = 300;
    protected static final float BUTTON_STATE_DISABLE_ALPHA = 0.4f;
    protected static final int ERROR_TYPE_EMPTY = 3;
    protected static final int ERROR_TYPE_INVALID_CHARACTERS = 1;
    protected static final int ERROR_TYPE_MAXIMUM_CHARACTERS = 2;
    protected static final int ERROR_TYPE_NONE = 0;
    protected static final int ERROR_TYPE_NOT_CHANGED = 5;
    protected static final int ERROR_TYPE_PREPARING = 4;
    public static final int TITLE_MAX_LENGTH = 32;
    protected CharSequence EDITING;
    protected CharSequence EDIT_BOX_TEXT;
    protected AlertDialog mAlertDialog;
    protected Context mContext;
    protected int mCurrentTextHelpType;
    protected String mDeletePath;
    protected View mDialogView;
    protected EditText mInputText;
    protected Boolean mIsRename;
    protected String mPath;
    protected int mPositiveCheckErrorType;
    protected int mStringInfoErrorType;
    protected ITemplateEditDialogResult mTemplateEditDialogResult;
    protected TextInputLayout mTextInputLayout;
    protected String mText = null;
    protected String TAG_DIALOG_TYPE_RENAME = "template_name_dialog";
    private Boolean mIsDismissWithClick = Boolean.TRUE;
    private final DialogInterface.OnClickListener mPositiveClickListener = new DialogInterface.OnClickListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.dialog.TemplateNameDialog.1
        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            TemplateNameDialog.this.onPositiveButtonClick();
        }
    };
    private final DialogInterface.OnClickListener mNegativeClickListener = new DialogInterface.OnClickListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.dialog.TemplateNameDialog.2
        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            TemplateNameDialog.this.onNegativeButtonClick();
        }
    };
    private final TextView.OnEditorActionListener mEditorActionListener = new TextView.OnEditorActionListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.dialog.TemplateNameDialog.3
        @Override // android.widget.TextView.OnEditorActionListener
        public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
            if (keyEvent != null && (66 == keyEvent.getKeyCode() || 160 == keyEvent.getKeyCode())) {
                if (keyEvent.getAction() == 1) {
                    TemplateNameDialog.this.onPositiveButtonClick();
                }
                return true;
            }
            if (i != 6) {
                return false;
            }
            InputMethodCompat.getInstance().hideSoftInput(textView.getContext(), textView);
            return true;
        }
    };

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public class EditorInputFilter implements InputFilter {
        public EditorInputFilter() {
        }

        @Override // android.text.InputFilter
        public CharSequence filter(CharSequence charSequence, int i, int i2, Spanned spanned, int i4, int i5) {
            TemplateNameDialog.this.mStringInfoErrorType = 0;
            if (charSequence.toString().trim().length() == 0) {
                return null;
            }
            if ((((Object) spanned.subSequence(0, i4)) + charSequence.subSequence(i, i2).toString() + ((Object) spanned.subSequence(i5, spanned.length()))).equals(TemplateNameDialog.this.mText)) {
                TemplateNameDialog.this.mStringInfoErrorType = 5;
                return null;
            }
            if (Pattern.compile("[\\*/\\\\\\?:<>\\|\"]+").matcher(charSequence).find() || SpenInputEmojiUtil.hasEmojiString(charSequence)) {
                TemplateNameDialog.this.mStringInfoErrorType = 1;
                return spanned.subSequence(i4, i5);
            }
            while (i < i2) {
                if (Character.getType(charSequence.charAt(i)) == 19) {
                    TemplateNameDialog.this.mStringInfoErrorType = 1;
                    return spanned.subSequence(i4, i5);
                }
                i++;
            }
            return charSequence;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public class LimitLengthInputFilter extends InputFilter.LengthFilter {
        public LimitLengthInputFilter(int i) {
            super(i);
        }

        @Override // android.text.InputFilter.LengthFilter, android.text.InputFilter
        public CharSequence filter(CharSequence charSequence, int i, int i2, Spanned spanned, int i4, int i5) {
            CharSequence charSequenceFilter = super.filter(charSequence, i, i2, spanned, i4, i5);
            if (charSequenceFilter == null) {
                return charSequenceFilter;
            }
            TemplateNameDialog templateNameDialog = TemplateNameDialog.this;
            if (templateNameDialog.mStringInfoErrorType != 1) {
                templateNameDialog.mStringInfoErrorType = 2;
            }
            templateNameDialog.setMessageErrorType(templateNameDialog.mStringInfoErrorType);
            return !CharUtils.isValidByteSymbol(charSequenceFilter, charSequence) ? "" : charSequenceFilter;
        }
    }

    public TemplateNameDialog() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void afterHideSIPAction(final Runnable runnable) {
        if (!InputMethodCompat.getInstance().isInputMethodShown(this.mContext, this.mDialogView, InputMethodCompat.getInstance().isEnabledMobileKeyboard(this.mContext))) {
            runnable.run();
        } else {
            InputMethodCompat.getInstance().forceHideSoftInput(this.mContext);
            new Handler().postDelayed(new Runnable() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.dialog.TemplateNameDialog.4
                @Override // java.lang.Runnable
                public void run() {
                    runnable.run();
                }
            }, 300L);
        }
    }

    private void checkCurrentStatus(String str) {
        this.mPositiveCheckErrorType = 0;
        checkEmptyString(str);
    }

    private boolean isPositiveButtonEnable() {
        int i;
        int i2 = this.mPositiveCheckErrorType;
        return (i2 == 3 || i2 == 4 || (i = this.mStringInfoErrorType) == 1 || i == 5) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$show$0(DialogInterface dialogInterface) {
        onShowDialog();
        if (this.mIsDismissWithClick.booleanValue()) {
            return;
        }
        setClickWithoutDismissListener();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$show$1(DialogInterface dialogInterface) {
        ITemplateEditDialogResult iTemplateEditDialogResult = this.mTemplateEditDialogResult;
        if (iTemplateEditDialogResult != null) {
            iTemplateEditDialogResult.onEditDialogDismiss(this.mDeletePath);
            return;
        }
        Object obj = this.mContext;
        if (obj instanceof IEditDialogResult) {
            ((IEditDialogResult) obj).onEditDialogDismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onNegativeButtonClick() {
        UserInputSkipper.Tag tag = UserInputSkipper.Tag.Menu;
        if (UserInputSkipper.isValidEvent(tag)) {
            UserInputSkipper.setHoldingEventTime(300L, tag);
            EditText editText = this.mInputText;
            if (editText != null) {
                checkDialogStatus(editText.getText().toString());
            }
            this.mDeletePath = this.mPath;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onPositiveButtonClick() {
        UserInputSkipper.Tag tag = UserInputSkipper.Tag.Menu;
        if (UserInputSkipper.isValidEvent(tag)) {
            UserInputSkipper.setHoldingEventTime(300L, tag);
            EditText editText = this.mInputText;
            if (editText != null) {
                checkDialogStatus(editText.getText().toString());
            }
            if (this.mPositiveCheckErrorType != 0) {
                return;
            }
            afterHideSIPAction(new Runnable() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.dialog.TemplateNameDialog.9
                @Override // java.lang.Runnable
                public void run() {
                    TemplateNameDialog.this.sendResult();
                }
            });
        }
    }

    private void setErrorMessage(int i) {
        TextInputLayout textInputLayout = this.mTextInputLayout;
        if (textInputLayout == null || this.mContext == null) {
            return;
        }
        if (i != 0) {
            if (i == 1) {
                textInputLayout.setErrorEnabled(true);
                this.mTextInputLayout.setError(this.mContext.getString(C9086R.string.string_invalid_character));
                return;
            } else if (i == 2) {
                textInputLayout.setErrorEnabled(true);
                this.mTextInputLayout.setError(this.mContext.getString(C9086R.string.category_maximum_number_of_characters_exceeded, 32));
                return;
            } else if (i != 3) {
                if (i != 4) {
                    return;
                }
                textInputLayout.setErrorEnabled(true);
                this.mTextInputLayout.setError(this.mContext.getString(C9086R.string.dialog_preparing));
                return;
            }
        }
        textInputLayout.setErrorEnabled(false);
        this.mTextInputLayout.setError(null);
    }

    private void setSIPOptions(int i) {
        AlertDialog alertDialog = this.mAlertDialog;
        if (alertDialog == null || alertDialog.getWindow() == null || !(this.mContext instanceof Activity)) {
            return;
        }
        if (!WindowManagerCompat.getInstance().isMultiWindowMode((Activity) this.mContext) && ResourceUtils.isLargeHandsetLayout(this.mContext)) {
            this.mAlertDialog.getWindow().setSoftInputMode(21);
        } else if (i == 2 || WindowManagerCompat.getInstance().isMultiWindowMode((Activity) this.mContext)) {
            this.mAlertDialog.getWindow().setSoftInputMode(37);
        } else {
            this.mAlertDialog.getWindow().setSoftInputMode(21);
        }
    }

    public void checkDialogStatus(String str) {
        if (str == null) {
            str = "";
        }
        checkCurrentStatus(str);
        int i = this.mStringInfoErrorType;
        if (i != 0) {
            setMessageErrorType(i);
        } else {
            setMessageErrorType(this.mPositiveCheckErrorType);
        }
        positiveButtonEnable(isPositiveButtonEnable());
    }

    public void checkEmptyString(String str) {
        if (str.length() == 0 || TextUtils.isEmpty(str.trim().replace("'", "''"))) {
            this.mPositiveCheckErrorType = 3;
        }
    }

    public String getDefaultTitle() {
        return "";
    }

    public void initInputText() {
        ViewCompat.getInstance().setSemSetActionModeAutoFillEnabled(this.mInputText, false);
        this.mInputText.setImeOptions(268435462);
        this.mInputText.setPrivateImeOptions("inputType=PredictionOff");
        this.mInputText.setPrivateImeOptions("inputType=filename;disableImage=true");
        this.mInputText.setInputType(540673);
        if (this.mText == null) {
            this.mText = getDefaultTitle();
        }
        this.mInputText.setText(this.mText);
        this.mInputText.setSelection(0, this.mText.length());
        this.mInputText.setOnEditorActionListener(this.mEditorActionListener);
        this.mInputText.setFilters(new InputFilter[]{new EditorInputFilter(), new LimitLengthInputFilter(32)});
    }

    public void initRenameText(String str) {
        this.mText = str;
    }

    @Override // androidx.fragment.app.DialogFragment
    @NonNull
    public Dialog onCreateDialog(@Nullable Bundle bundle) {
        if (bundle != null) {
            this.mIsRename = Boolean.valueOf(bundle.getBoolean(ChangeTemplateConstants.KEY_TE_NAME_DIALOG_IS_RENAME));
            this.mText = bundle.getString(ChangeTemplateConstants.KEY_TE_NAME_DIALOG_EDITTEXT_TEXT);
            if (this.mContext == null) {
                this.mContext = requireContext();
            }
            if (this.mTemplateEditDialogResult == null) {
                Fragment parentFragment = getParentFragment();
                if (parentFragment instanceof TemplateEditorView) {
                    this.mTemplateEditDialogResult = ((TemplateEditorView) parentFragment).getMenuView().createTemplateEditDialogResult();
                }
            }
        }
        show();
        checkDialogStatus(this.mText);
        return this.mAlertDialog;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onSaveInstanceState(@NotNull Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putBoolean(ChangeTemplateConstants.KEY_TE_NAME_DIALOG_IS_RENAME, this.mIsRename.booleanValue());
        bundle.putString(ChangeTemplateConstants.KEY_TE_NAME_DIALOG_EDITTEXT_TEXT, this.mInputText.getText().toString());
    }

    public void onShowDialog() {
        setErrorMessage(this.mCurrentTextHelpType);
        this.mTextInputLayout.postDelayed(new Runnable() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.dialog.TemplateNameDialog.7
            @Override // java.lang.Runnable
            public void run() {
                TemplateNameDialog.this.mAlertDialog.setCanceledOnTouchOutside(true);
            }
        }, 100L);
        int i = this.mPositiveCheckErrorType;
        setButton((i == 3 || i == 4 || i == 5) ? false : true);
        this.mInputText.addTextChangedListener(new TextWatcher() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.dialog.TemplateNameDialog.8
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                TemplateNameDialog.this.checkDialogStatus(editable.toString());
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i2, int i4, int i5) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i2, int i4, int i5) {
                TemplateNameDialog.this.mTextInputLayout.setContentDescription(((Object) TemplateNameDialog.this.EDIT_BOX_TEXT) + "," + ((Object) charSequence) + "," + ((Object) TemplateNameDialog.this.EDITING));
            }
        });
    }

    public void positiveButtonEnable(boolean z) {
        AlertDialog alertDialog = this.mAlertDialog;
        if (alertDialog == null) {
            return;
        }
        alertDialog.getButton(-1).setEnabled(z);
        if (z) {
            this.mAlertDialog.getButton(-1).animate().alpha(1.0f).setDuration(300L).start();
        } else {
            this.mAlertDialog.getButton(-1).animate().alpha(0.4f).setDuration(300L).start();
        }
    }

    public void sendResult() {
        String strTextChecker = textChecker(this.mInputText.getText().toString());
        ITemplateEditDialogResult iTemplateEditDialogResult = this.mTemplateEditDialogResult;
        if (iTemplateEditDialogResult != null) {
            iTemplateEditDialogResult.onEditDialogResult(strTextChecker);
        } else {
            Object obj = this.mContext;
            if (obj instanceof ITemplateEditDialogResult) {
                ((ITemplateEditDialogResult) obj).onEditDialogResult(strTextChecker);
            }
        }
        this.mAlertDialog.dismiss();
    }

    public void setButton(boolean z) {
        this.mAlertDialog.getButton(-1).setEnabled(z);
        if (z) {
            this.mAlertDialog.getButton(-1).setAlpha(1.0f);
        } else {
            this.mAlertDialog.getButton(-1).setAlpha(0.4f);
        }
    }

    public void setClickWithoutDismissListener() {
        this.mAlertDialog.getButton(-1).setOnClickListener(new View.OnClickListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.dialog.TemplateNameDialog.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TemplateNameDialog.this.afterHideSIPAction(new Runnable() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.dialog.TemplateNameDialog.5.1
                    @Override // java.lang.Runnable
                    public void run() {
                        TemplateNameDialog.this.mAlertDialog.dismiss();
                        TemplateNameDialog.this.onPositiveButtonClick();
                    }
                });
            }
        });
        this.mAlertDialog.getButton(-2).setOnClickListener(new View.OnClickListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.dialog.TemplateNameDialog.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TemplateNameDialog.this.afterHideSIPAction(new Runnable() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.dialog.TemplateNameDialog.6.1
                    @Override // java.lang.Runnable
                    public void run() {
                        TemplateNameDialog.this.mAlertDialog.dismiss();
                    }
                });
            }
        });
    }

    public void setEditDialogResultListener(ITemplateEditDialogResult iTemplateEditDialogResult) {
        this.mTemplateEditDialogResult = iTemplateEditDialogResult;
    }

    public void setMessageErrorType(int i) {
        if (this.mTextInputLayout == null || this.mCurrentTextHelpType == i) {
            return;
        }
        setErrorMessage(i);
        this.mCurrentTextHelpType = i;
    }

    public void show() {
        this.EDIT_BOX_TEXT = "getText(R.string.text_edit_box)";
        this.EDITING = "getText(R.string.text_editing)";
        this.mCurrentTextHelpType = 0;
        this.mPositiveCheckErrorType = this.mIsRename.booleanValue() ? 5 : 0;
        this.mStringInfoErrorType = 0;
        View viewInflate = LayoutInflater.from(this.mContext).inflate(C9086R.layout.edit_dialog, (ViewGroup) null);
        this.mDialogView = viewInflate;
        this.mTextInputLayout = (TextInputLayout) viewInflate.findViewById(C9086R.id.text_input_layout);
        this.mInputText = (EditText) this.mDialogView.findViewById(C9086R.id.text_input_dialog);
        initInputText();
        AlertDialog alertDialogCreate = new AlertDialog.Builder(this.mContext).setView(this.mDialogView).setCancelable(false).setTitle(this.mContext.getString(C9086R.string.settings_template_change_rename_title)).setPositiveButton(this.mIsRename.booleanValue() ? this.mContext.getString(C9086R.string.base_string_rename_type1) : this.mContext.getString(C9086R.string.settings_template_change_rename_create_btn), this.mPositiveClickListener).setNegativeButton(this.mContext.getString(C9086R.string.dialog_cancel), this.mNegativeClickListener).create();
        this.mAlertDialog = alertDialogCreate;
        alertDialogCreate.setCanceledOnTouchOutside(false);
        this.mAlertDialog.setOnShowListener(new DialogInterfaceOnShowListenerC10242l(this, 2));
        setSIPOptions(this.mContext.getResources().getConfiguration().orientation);
        ResourceUtils.setBlurInfoPopup(this.mContext, this.mAlertDialog.findViewById(R.id.content));
        this.mAlertDialog.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.dialog.q
            @Override // android.content.DialogInterface.OnDismissListener
            public final void onDismiss(DialogInterface dialogInterface) {
                this.f7146a.lambda$show$1(dialogInterface);
            }
        });
        this.mInputText.requestFocus();
        this.mAlertDialog.show();
    }

    public String textChecker(String str) {
        return str.replace('\n', ' ').trim();
    }

    public TemplateNameDialog(Context context, String str, String str2, boolean z) {
        this.mContext = context;
        this.mIsRename = Boolean.valueOf(z);
        this.mPath = str2;
        initRenameText(str);
    }

    public void show(FragmentManager fragmentManager) {
        showNow(fragmentManager, this.TAG_DIALOG_TYPE_RENAME);
    }
}
