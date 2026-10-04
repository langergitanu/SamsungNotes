package com.samsung.android.support.senl.p148nt.app.main.common.dialog;

import android.R;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler;
import android.text.InputFilter;
import android.text.Spanned;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import com.google.android.material.textfield.TextInputLayout;
import com.samsung.android.sdk.pen.text.inputmethod.SpenInputEmojiUtil;
import com.samsung.android.support.senl.p145cm.base.framework.view.InputMethodCompat;
import com.samsung.android.support.senl.p145cm.base.framework.view.ViewCompat;
import com.samsung.android.support.senl.p145cm.base.framework.view.WindowManagerCompat;
import com.samsung.android.support.senl.p148nt.app.C8003R;
import com.samsung.android.support.senl.p148nt.app.common.NotesConstants;
import com.samsung.android.support.senl.p148nt.app.common.samsunganalytics.NotesSAConstants;
import com.samsung.android.support.senl.p148nt.base.common.UserInputSkipper;
import com.samsung.android.support.senl.p148nt.base.common.samsunganalytices.CommonSamsungAnalytics;
import com.samsung.android.support.senl.p148nt.base.common.util.CharUtils;
import com.samsung.android.support.senl.p148nt.base.common.util.ResourceUtils;
import com.samsung.android.support.senl.p148nt.base.winset.app.dialog.HashTagHelper;
import com.samsung.android.support.senl.p148nt.base.winset.app.dialog.IEditDialogResult;
import com.samsung.android.support.senl.p148nt.base.winset.builder.AlertDialogBuilderForAppCompat;
import com.samsung.android.support.senl.p148nt.base.winset.view.AbsDialogFragment;
import java.util.regex.Pattern;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public class NameDialogFragment extends AbsDialogFragment {
    protected static final int BUTTON_STATE_ANIM_DURATION = 300;
    protected static final float BUTTON_STATE_DISABLE_ALPHA = 0.4f;
    protected static final int ERROR_TYPE_ALREADY_IN_USE = 5;
    protected static final int ERROR_TYPE_EMPTY = 6;
    protected static final int ERROR_TYPE_INVALID_CHARACTERS = 1;
    protected static final int ERROR_TYPE_INVALID_CHARACTERS_TAGS = 2;
    protected static final int ERROR_TYPE_MAXIMUM_CHARACTERS = 3;
    protected static final int ERROR_TYPE_MAXIMUM_CHARACTERS_TAGS = 4;
    protected static final int ERROR_TYPE_NONE = 0;
    protected static final int ERROR_TYPE_PREPARING = 7;
    protected CharSequence EDITING;
    protected CharSequence EDIT_BOX_TEXT;
    protected AlertDialog mAlertDialog;
    protected AlertDialogBuilderForAppCompat mAlertDialogBuilder;
    protected int mCurrentTextHelpType;
    protected int mDialogType;
    protected View mDialogView;
    protected IEditDialogResult mEditDialogResultListener;
    protected EditText mInputText;
    protected int mPositiveCheckErrorType;
    protected int mStringInfoErrorType;
    protected TextInputLayout mTextInputLayout;
    protected String mEditModeInitString = null;
    protected String mText = null;
    private Boolean mIsDismissWithClick = Boolean.TRUE;
    private final DialogInterface.OnClickListener mPositiveClickListener = new DialogInterface.OnClickListener() { // from class: com.samsung.android.support.senl.nt.app.main.common.dialog.NameDialogFragment.1
        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            NameDialogFragment.this.onPositiveButtonClick();
        }
    };
    private final DialogInterface.OnClickListener mNegativeClickListener = new DialogInterface.OnClickListener() { // from class: com.samsung.android.support.senl.nt.app.main.common.dialog.NameDialogFragment.2
        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            NameDialogFragment.this.negativeClickSALog();
        }
    };
    private final TextView.OnEditorActionListener mEditorActionListener = new TextView.OnEditorActionListener() { // from class: com.samsung.android.support.senl.nt.app.main.common.dialog.NameDialogFragment.3
        @Override // android.widget.TextView.OnEditorActionListener
        public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
            if (keyEvent != null && (66 == keyEvent.getKeyCode() || 160 == keyEvent.getKeyCode())) {
                if (keyEvent.getAction() == 1) {
                    NameDialogFragment.this.onPositiveButtonClick();
                }
                return true;
            }
            if (i != 6) {
                return false;
            }
            InputMethodCompat.getInstance().hideSoftInput(NameDialogFragment.this.getContext(), textView);
            return true;
        }
    };

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public class EditorInputFilter implements InputFilter {
        public EditorInputFilter() {
        }

        @Override // android.text.InputFilter
        public CharSequence filter(CharSequence charSequence, int i, int i2, Spanned spanned, int i4, int i5) {
            NameDialogFragment.this.mStringInfoErrorType = 0;
            if (charSequence.toString().trim().length() == 0) {
                return null;
            }
            if (Pattern.compile("[\\*/\\\\\\?:<>\\|\"]+").matcher(charSequence).find() || SpenInputEmojiUtil.hasEmojiString(charSequence)) {
                NameDialogFragment.this.mStringInfoErrorType = 1;
                return spanned.subSequence(i4, i5);
            }
            while (i < i2) {
                if (Character.getType(charSequence.charAt(i)) == 19) {
                    NameDialogFragment.this.mStringInfoErrorType = 1;
                    return spanned.subSequence(i4, i5);
                }
                i++;
            }
            return charSequence;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public class LimitLengthInputFilter extends InputFilter.LengthFilter {
        boolean isHashTag;

        public LimitLengthInputFilter(int i) {
            super(i);
            this.isHashTag = false;
            if (i == NameDialogFragment.this.getResources().getInteger(C8003R.integer.tag_input_max)) {
                this.isHashTag = true;
            }
        }

        @Override // android.text.InputFilter.LengthFilter, android.text.InputFilter
        public CharSequence filter(CharSequence charSequence, int i, int i2, Spanned spanned, int i4, int i5) {
            CharSequence charSequence2 = charSequence;
            if (this.isHashTag) {
                String strRemoveExceptLetterOrDigit = HashTagHelper.removeExceptLetterOrDigit(charSequence.toString());
                i2 = strRemoveExceptLetterOrDigit.length();
                charSequence2 = strRemoveExceptLetterOrDigit;
            }
            CharSequence charSequence3 = charSequence2;
            CharSequence charSequenceFilter = super.filter(charSequence3, i, i2, spanned, i4, i5);
            if (charSequenceFilter == null) {
                return charSequenceFilter;
            }
            NameDialogFragment nameDialogFragment = NameDialogFragment.this;
            if (nameDialogFragment.mStringInfoErrorType != 1) {
                if (this.isHashTag) {
                    nameDialogFragment.mStringInfoErrorType = 4;
                } else {
                    nameDialogFragment.mStringInfoErrorType = 3;
                }
            }
            nameDialogFragment.setMessageErrorType(nameDialogFragment.mStringInfoErrorType);
            return !CharUtils.isValidByteSymbol(charSequenceFilter, charSequence3) ? "" : charSequenceFilter;
        }
    }

    public NameDialogFragment() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void afterHideSIPAction(final Runnable runnable) {
        if (!InputMethodCompat.getInstance().isInputMethodShown(getContext(), this.mDialogView, InputMethodCompat.getInstance().isEnabledMobileKeyboard(getContext()))) {
            runnable.run();
        } else {
            InputMethodCompat.getInstance().forceHideSoftInput(getContext());
            new Handler().postDelayed(new Runnable() { // from class: com.samsung.android.support.senl.nt.app.main.common.dialog.NameDialogFragment.5
                @Override // java.lang.Runnable
                public void run() {
                    runnable.run();
                }
            }, 300L);
        }
    }

    private String getDialogPositiveButtonString() {
        int i = this.mDialogType;
        if (i != 1) {
            if (i != 2) {
                if (i != 3) {
                    if (i != 6) {
                        if (i != 7) {
                            if (i != 8) {
                                return null;
                            }
                        }
                    }
                }
            }
            return getString(C8003R.string.rename);
        }
        return getString(C8003R.string.gcs_group_dialog_add_next_button);
    }

    private int getDialogTitle() {
        int i = this.mDialogType;
        if (i != 1) {
            if (i == 2) {
                return C8003R.string.rename_category;
            }
            if (i != 3) {
                if (i == 6) {
                    return C8003R.string.tag_dialog_rename_title;
                }
                if (i == 7) {
                    return C8003R.string.action_add_gcs_group;
                }
                if (i != 8) {
                    return -1;
                }
                return C8003R.string.gcs_group_dialog_rename_title;
            }
        }
        return C8003R.string.add_category;
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
            positiveClickSALog();
            afterHideSIPAction(new Runnable() { // from class: com.samsung.android.support.senl.nt.app.main.common.dialog.NameDialogFragment.9
                @Override // java.lang.Runnable
                public void run() {
                    NameDialogFragment.this.sendResult();
                }
            });
        }
    }

    private void setErrorMessage(int i) {
        if (this.mTextInputLayout == null || getContext() == null) {
            return;
        }
        switch (i) {
            case 0:
            case 6:
                this.mTextInputLayout.setErrorEnabled(false);
                this.mTextInputLayout.setError(null);
                break;
            case 1:
                this.mTextInputLayout.setErrorEnabled(true);
                this.mTextInputLayout.setError(getString(C8003R.string.string_invalid_character));
                break;
            case 2:
                this.mTextInputLayout.setErrorEnabled(true);
                this.mTextInputLayout.setError(getString(C8003R.string.string_tags_invalid_character));
                break;
            case 3:
                this.mTextInputLayout.setErrorEnabled(true);
                this.mTextInputLayout.setError(getString(C8003R.string.category_maximum_number_of_characters_exceeded, 30));
                break;
            case 4:
                this.mTextInputLayout.setErrorEnabled(true);
                this.mTextInputLayout.setError(getString(C8003R.string.category_maximum_number_of_characters_exceeded, Integer.valueOf(getResources().getInteger(C8003R.integer.tag_input_max))));
                break;
            case 5:
                this.mTextInputLayout.setErrorEnabled(true);
                this.mTextInputLayout.setError(getString(C8003R.string.folder_already_in_use));
                break;
            case 7:
                this.mTextInputLayout.setErrorEnabled(true);
                this.mTextInputLayout.setError(getString(C8003R.string.dialog_preparing));
                break;
        }
    }

    private void setSIPOptions(int i) {
        if (this.mAlertDialog == null) {
            return;
        }
        if (!WindowManagerCompat.getInstance().isMultiWindowMode(getActivity()) && ResourceUtils.isLargeHandsetLayout(getContext())) {
            this.mAlertDialog.getWindow().setSoftInputMode(21);
        } else if (i == 2 || WindowManagerCompat.getInstance().isMultiWindowMode(getActivity())) {
            this.mAlertDialog.getWindow().setSoftInputMode(37);
        } else {
            this.mAlertDialog.getWindow().setSoftInputMode(21);
        }
    }

    public void checkDialogStatus(String str) {
    }

    public void checkEmptyString(String str) {
        if (str.length() == 0 || TextUtils.isEmpty(str.trim().replace("'", "''"))) {
            this.mPositiveCheckErrorType = 6;
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
    }

    public void initRenameText(String str) {
        this.mText = str;
        this.mEditModeInitString = str;
    }

    public boolean isPreModificationName() {
        String str = this.mEditModeInitString;
        return str != null && str.equals(this.mInputText.getText().toString());
    }

    public void negativeClickSALog() {
        int i = this.mDialogType;
        if (i == 3 || i == 1) {
            CommonSamsungAnalytics.insertLog(NotesSAConstants.SCREEN_MANAGE_FOLDERS, "7041");
        } else if (i == 2) {
            CommonSamsungAnalytics.insertLog(NotesSAConstants.SCREEN_MANAGE_FOLDERS, "7051");
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.base.winset.view.AbsDialogFragment, androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(@NonNull Configuration configuration) {
        setSIPOptions(configuration.orientation);
        super.onConfigurationChanged(configuration);
    }

    @Override // androidx.fragment.app.DialogFragment
    @NotNull
    public Dialog onCreateDialog(Bundle bundle) {
        super.onCreateDialog(bundle);
        this.EDIT_BOX_TEXT = getText(C8003R.string.text_edit_box);
        this.EDITING = getText(C8003R.string.text_editing);
        if (bundle != null) {
            this.mEditModeInitString = bundle.getString(NotesConstants.DialogTag.KEY_EDIT_MODE_INIT_STRING);
            this.mText = bundle.getString(NotesConstants.DialogTag.KEY_INPUT_TEXT_STRING);
            this.mCurrentTextHelpType = bundle.getInt(NotesConstants.DialogTag.KEY_CURRENT_TEXT_HELP_TYPE);
            this.mPositiveCheckErrorType = bundle.getInt(NotesConstants.DialogTag.KEY_POSITIVE_CHECK_ERROR_TYPE);
            this.mStringInfoErrorType = bundle.getInt(NotesConstants.DialogTag.KEY_STRING_INFO_ERROR_TYPE);
            this.mDialogType = bundle.getInt(NotesConstants.DialogTag.KEY_DIALOG_TYPE);
        } else {
            this.mCurrentTextHelpType = 0;
            this.mPositiveCheckErrorType = 0;
            this.mStringInfoErrorType = 0;
        }
        View viewInflate = LayoutInflater.from(getContext()).inflate(C8003R.layout.edit_dialog, (ViewGroup) null);
        this.mDialogView = viewInflate;
        this.mTextInputLayout = (TextInputLayout) viewInflate.findViewById(C8003R.id.text_input_layout);
        this.mInputText = (EditText) this.mDialogView.findViewById(C8003R.id.text_input_dialog);
        int i = this.mDialogType;
        if (i == 1 || i == 3) {
            this.mDialogView.findViewById(C8003R.id.category_color_palette_divider).setVisibility(0);
            this.mDialogView.findViewById(C8003R.id.category_color_palette).setVisibility(0);
        }
        initInputText();
        AlertDialogBuilderForAppCompat alertDialogBuilderForAppCompat = new AlertDialogBuilderForAppCompat(getActivity());
        this.mAlertDialogBuilder = alertDialogBuilderForAppCompat;
        AlertDialog alertDialogCreate = alertDialogBuilderForAppCompat.create();
        this.mAlertDialog = alertDialogCreate;
        alertDialogCreate.setView(this.mDialogView);
        this.mAlertDialog.setCancelable(false);
        String dialogPositiveButtonString = getDialogPositiveButtonString();
        if (dialogPositiveButtonString != null) {
            this.mAlertDialog.setButton(-1, dialogPositiveButtonString, this.mPositiveClickListener);
        }
        this.mAlertDialog.setButton(-2, getString(C8003R.string.dialog_cancel), this.mNegativeClickListener);
        this.mAlertDialog.setCanceledOnTouchOutside(false);
        this.mAlertDialog.setTitle(getDialogTitle());
        this.mAlertDialog.setOnShowListener(new DialogInterface.OnShowListener() { // from class: com.samsung.android.support.senl.nt.app.main.common.dialog.NameDialogFragment.4
            @Override // android.content.DialogInterface.OnShowListener
            public void onShow(DialogInterface dialogInterface) {
                if (NameDialogFragment.this.isAdded()) {
                    NameDialogFragment.this.onShowDialog();
                    if (NameDialogFragment.this.mIsDismissWithClick.booleanValue()) {
                        return;
                    }
                    NameDialogFragment.this.setClickWithoutDismissListener();
                }
            }
        });
        setSIPOptions(getResources().getConfiguration().orientation);
        ResourceUtils.setBlurInfoPopup(getContext(), this.mAlertDialog.findViewById(R.id.content));
        return this.mAlertDialog;
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public void onDismiss(@NotNull DialogInterface dialogInterface) {
        super.onDismiss(dialogInterface);
        IEditDialogResult iEditDialogResult = this.mEditDialogResultListener;
        if (iEditDialogResult != null) {
            iEditDialogResult.onEditDialogDismiss();
        } else if (getParentFragment() instanceof IEditDialogResult) {
            ((IEditDialogResult) getParentFragment()).onEditDialogDismiss();
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.base.winset.view.AbsDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onSaveInstanceState(@NotNull Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString(NotesConstants.DialogTag.KEY_EDIT_MODE_INIT_STRING, this.mEditModeInitString);
        bundle.putString(NotesConstants.DialogTag.KEY_INPUT_TEXT_STRING, this.mInputText.getText().toString());
        bundle.putInt(NotesConstants.DialogTag.KEY_CURRENT_TEXT_HELP_TYPE, this.mCurrentTextHelpType);
        bundle.putInt(NotesConstants.DialogTag.KEY_POSITIVE_CHECK_ERROR_TYPE, this.mPositiveCheckErrorType);
        bundle.putInt(NotesConstants.DialogTag.KEY_STRING_INFO_ERROR_TYPE, this.mStringInfoErrorType);
        bundle.putInt(NotesConstants.DialogTag.KEY_DIALOG_TYPE, this.mDialogType);
    }

    public void onShowDialog() {
        setErrorMessage(this.mCurrentTextHelpType);
        this.mTextInputLayout.postDelayed(new Runnable() { // from class: com.samsung.android.support.senl.nt.app.main.common.dialog.NameDialogFragment.8
            @Override // java.lang.Runnable
            public void run() {
                NameDialogFragment.this.mAlertDialog.setCanceledOnTouchOutside(true);
            }
        }, 100L);
    }

    @Override // com.samsung.android.support.senl.p148nt.base.winset.view.AbsDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        this.mInputText.requestFocus();
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

    public void positiveClickSALog() {
        int i = this.mDialogType;
        if (i == 3 || i == 1) {
            CommonSamsungAnalytics.insertLog(NotesSAConstants.SCREEN_MANAGE_FOLDERS, "7042");
        } else if (i == 2) {
            CommonSamsungAnalytics.insertLog(NotesSAConstants.SCREEN_MANAGE_FOLDERS, "7052");
        }
    }

    public void sendResult() {
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
        this.mAlertDialog.getButton(-1).setOnClickListener(new View.OnClickListener() { // from class: com.samsung.android.support.senl.nt.app.main.common.dialog.NameDialogFragment.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                NameDialogFragment.this.afterHideSIPAction(new Runnable() { // from class: com.samsung.android.support.senl.nt.app.main.common.dialog.NameDialogFragment.6.1
                    @Override // java.lang.Runnable
                    public void run() {
                        NameDialogFragment.this.dismiss();
                        NameDialogFragment.this.onPositiveButtonClick();
                    }
                });
            }
        });
        this.mAlertDialog.getButton(-2).setOnClickListener(new View.OnClickListener() { // from class: com.samsung.android.support.senl.nt.app.main.common.dialog.NameDialogFragment.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                NameDialogFragment.this.negativeClickSALog();
                NameDialogFragment.this.afterHideSIPAction(new Runnable() { // from class: com.samsung.android.support.senl.nt.app.main.common.dialog.NameDialogFragment.7.1
                    @Override // java.lang.Runnable
                    public void run() {
                        NameDialogFragment.this.dismiss();
                    }
                });
            }
        });
    }

    public void setDismissAfterHideSIP(boolean z) {
        this.mIsDismissWithClick = Boolean.valueOf(!z);
    }

    public void setEditDialogResultListener(IEditDialogResult iEditDialogResult) {
        this.mEditDialogResultListener = iEditDialogResult;
    }

    public void setInputText(String str) {
        if (this.mInputText == null || str == null || str.length() <= 0) {
            return;
        }
        this.mInputText.setText(str);
    }

    public void setMessageErrorType(int i) {
        if (this.mTextInputLayout == null || this.mCurrentTextHelpType == i) {
            return;
        }
        setErrorMessage(i);
        this.mCurrentTextHelpType = i;
    }

    public String textChecker(String str) {
        return str.replace('\n', ' ').trim();
    }

    public NameDialogFragment(String str) {
        initRenameText(str);
    }
}
