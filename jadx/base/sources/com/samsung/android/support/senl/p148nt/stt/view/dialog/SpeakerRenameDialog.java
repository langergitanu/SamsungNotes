package com.samsung.android.support.senl.p148nt.stt.view.dialog;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.android.material.textfield.TextInputLayout;
import com.samsung.android.sdk.pen.setting.common.C7558c;
import com.samsung.android.sdk.pen.setting.common.ViewOnKeyListenerC7560e;
import com.samsung.android.support.senl.p148nt.app.common.NotesConstants;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.title.C10505d;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import com.samsung.android.support.senl.p148nt.data.common.utils.AbstractC11014a;
import com.samsung.android.support.senl.p148nt.stt.C11493R;
import com.samsung.android.support.senl.p148nt.stt.common.Logger;
import com.samsung.android.support.senl.p148nt.stt.common.constant.DialogConstant;
import com.samsung.android.support.senl.p148nt.stt.view.dialog.STTDialogFactory;
import com.samsung.android.support.senl.p148nt.stt.view.layout.WindowFocusLayout;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(m13885d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 32\u00020\u0001:\u00013B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0016J\u0010\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!H\u0002J\u001a\u0010\"\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0002J\b\u0010#\u001a\u00020\u001fH\u0002J\b\u0010$\u001a\u00020\u001fH\u0002J\b\u0010%\u001a\u00020\u001fH\u0002J\b\u0010&\u001a\u00020\u001fH\u0016J\u0010\u0010'\u001a\u00020\u001f2\u0006\u0010(\u001a\u00020)H\u0016J\b\u0010*\u001a\u00020\u001fH\u0016J\u0010\u0010+\u001a\u00020\u001f2\u0006\u0010,\u001a\u00020\u001dH\u0016J\u0012\u0010-\u001a\u00020\u001f2\b\u0010.\u001a\u0004\u0018\u00010\u0005H\u0016J\u0010\u0010/\u001a\u00020\u001f2\u0006\u00100\u001a\u00020\u0012H\u0014J\b\u00101\u001a\u00020\u001fH\u0016J\b\u00102\u001a\u00020\u001fH\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000¨\u00064"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/stt/view/dialog/SpeakerRenameDialog;", "Lcom/samsung/android/support/senl/nt/stt/view/dialog/AbsSTTDialogFragment;", "<init>", "()V", "mInterface", "Lcom/samsung/android/support/senl/nt/stt/view/dialog/STTDialogFactory$DialogResultListener;", "mInputView", "Landroid/widget/EditText;", "mOptionRadioGroup", "Landroid/widget/RadioGroup;", "mTvSaveButton", "Landroid/widget/TextView;", "mCancelButton", "Landroid/widget/LinearLayout;", "mSaveButton", "mOriginalSpeakerName", "", "mCheckedEditOption", "", "mPreviousName", "bNameChanged", "", "mIsAddNewSpeaker", "mDialog", "Landroid/app/AlertDialog;", "mInputErrorType", "onCreateDialog", "Landroid/app/Dialog;", "savedInstanceState", "Landroid/os/Bundle;", "initView", "", "renameView", "Lcom/samsung/android/support/senl/nt/stt/view/layout/WindowFocusLayout;", "setupInputView", "setInputViewListener", "setButtonClickListener", "invalidateTextAndSaveEnabled", "onStart", "onDismiss", "dialog", "Landroid/content/DialogInterface;", "onResume", NotesConstants.DialogTag.ON_SAVE_INSTANCE_STATE, "outState", "setDialogResultListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setInputErrorMessage", "type", "onPause", "executePositiveEvent", "Companion", "ntStt_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nSpeakerRenameDialog.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SpeakerRenameDialog.kt\ncom/samsung/android/support/senl/nt/stt/view/dialog/SpeakerRenameDialog\n+ 2 Strings.kt\nkotlin/text/StringsKt__StringsKt\n+ 3 _Maps.kt\nkotlin/collections/MapsKt___MapsKt\n*L\n1#1,322:1\n108#2:323\n80#2,22:324\n108#2:346\n80#2,22:347\n108#2:369\n80#2,22:370\n216#3,2:392\n*S KotlinDebug\n*F\n+ 1 SpeakerRenameDialog.kt\ncom/samsung/android/support/senl/nt/stt/view/dialog/SpeakerRenameDialog\n*L\n78#1:323\n78#1:324,22\n244#1:346\n244#1:347,22\n91#1:369\n91#1:370,22\n95#1:392,2\n*E\n"})
public final class SpeakerRenameDialog extends AbsSTTDialogFragment {

    @NotNull
    private static final String BUNDLE_NAME_CHANGED = "name_change";

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final String TAG = "SpeakerRenameDialog";
    private boolean bNameChanged;

    @Nullable
    private LinearLayout mCancelButton;

    @Nullable
    private AlertDialog mDialog;

    @Nullable
    private EditText mInputView;

    @Nullable
    private STTDialogFactory.DialogResultListener mInterface;
    private boolean mIsAddNewSpeaker;

    @Nullable
    private RadioGroup mOptionRadioGroup;

    @Nullable
    private String mOriginalSpeakerName;

    @Nullable
    private String mPreviousName;

    @Nullable
    private LinearLayout mSaveButton;

    @Nullable
    private TextView mTvSaveButton;
    private int mCheckedEditOption = -1;
    private int mInputErrorType = AbsSTTDialogFragment.getNONE_ERROR_TYPE();

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\fR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\r"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/stt/view/dialog/SpeakerRenameDialog$Companion;", "", "<init>", "()V", SearchConstants.TargetContents.TAG, "", "BUNDLE_NAME_CHANGED", "newInstance", "Lcom/samsung/android/support/senl/nt/stt/view/dialog/SpeakerRenameDialog;", "bundle", "Landroid/os/Bundle;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/samsung/android/support/senl/nt/stt/view/dialog/STTDialogFactory$DialogResultListener;", "ntStt_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final SpeakerRenameDialog newInstance(@Nullable Bundle bundle, @NotNull STTDialogFactory.DialogResultListener listener) {
            Intrinsics.checkNotNullParameter(listener, "listener");
            Logger.m12713i("SpeakerRenameDialog", "newInstance# listener : " + listener);
            SpeakerRenameDialog speakerRenameDialog = new SpeakerRenameDialog();
            speakerRenameDialog.setArguments(bundle);
            speakerRenameDialog.setDialogResultListener(listener);
            return speakerRenameDialog;
        }

        private Companion() {
        }
    }

    /* JADX INFO: renamed from: com.samsung.android.support.senl.nt.stt.view.dialog.SpeakerRenameDialog$setupInputView$2 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, m13886d2 = {"com/samsung/android/support/senl/nt/stt/view/dialog/SpeakerRenameDialog$setupInputView$2", "Lcom/samsung/android/support/senl/nt/stt/view/layout/WindowFocusLayout$OnWindowFocusChangeListener;", "onWindowFocusChanged", "", "hasFocus", "", "ntStt_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class C115542 implements WindowFocusLayout.OnWindowFocusChangeListener {
        public C115542() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void onWindowFocusChanged$lambda$0(SpeakerRenameDialog speakerRenameDialog) {
            if (speakerRenameDialog.mInputView == null) {
                return;
            }
            EditText editText = speakerRenameDialog.mInputView;
            Intrinsics.checkNotNull(editText);
            Object systemService = editText.getContext().getSystemService("input_method");
            Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
            ((InputMethodManager) systemService).showSoftInput(speakerRenameDialog.mInputView, 0);
        }

        @Override // com.samsung.android.support.senl.nt.stt.view.layout.WindowFocusLayout.OnWindowFocusChangeListener
        public void onWindowFocusChanged(boolean hasFocus) {
            if (hasFocus) {
                EditText editText = SpeakerRenameDialog.this.mInputView;
                Intrinsics.checkNotNull(editText);
                editText.postDelayed(new RunnableC11563i(SpeakerRenameDialog.this, 1), 50L);
            }
        }
    }

    private final void executePositiveEvent() {
        invalidateTextAndSaveEnabled();
        LinearLayout linearLayout = this.mSaveButton;
        Intrinsics.checkNotNull(linearLayout);
        if (linearLayout.isEnabled()) {
            LinearLayout linearLayout2 = this.mSaveButton;
            Intrinsics.checkNotNull(linearLayout2);
            linearLayout2.callOnClick();
        }
    }

    private final void initView(WindowFocusLayout renameView) {
        setMInputLayout((TextInputLayout) renameView.findViewById(C11493R.id.rename_input_wrapper));
        this.mInputView = (EditText) renameView.findViewById(C11493R.id.rename_input);
        this.mOptionRadioGroup = (RadioGroup) renameView.findViewById(C11493R.id.option_radio_group);
        this.mTvSaveButton = (TextView) renameView.findViewById(C11493R.id.tvSaveButton);
        this.mCancelButton = (LinearLayout) renameView.findViewById(C11493R.id.button_cancel);
        this.mSaveButton = (LinearLayout) renameView.findViewById(C11493R.id.button_ok);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void invalidateTextAndSaveEnabled() {
        EditText editText;
        if (this.mSaveButton == null || this.mTvSaveButton == null || (editText = this.mInputView) == null) {
            Logger.m12711e("SpeakerRenameDialog", "failed to invalidateTextAndSaveEnabled");
            return;
        }
        Intrinsics.checkNotNull(editText);
        String string = editText.getText().toString();
        int length = string.length() - 1;
        int i = 0;
        boolean z = false;
        while (i <= length) {
            boolean z2 = Intrinsics.compare((int) string.charAt(!z ? i : length), 32) <= 0;
            if (z) {
                if (!z2) {
                    break;
                } else {
                    length--;
                }
            } else if (z2) {
                i++;
            } else {
                z = true;
            }
        }
        String string2 = string.subSequence(i, length + 1).toString();
        boolean z3 = string2.length() > 0 && (!Intrinsics.areEqual(string2, this.mOriginalSpeakerName) || this.mIsAddNewSpeaker) && this.mCheckedEditOption != -1;
        LinearLayout linearLayout = this.mSaveButton;
        Intrinsics.checkNotNull(linearLayout);
        linearLayout.setEnabled(z3);
        LinearLayout linearLayout2 = this.mSaveButton;
        Intrinsics.checkNotNull(linearLayout2);
        linearLayout2.setFocusable(z3);
        LinearLayout linearLayout3 = this.mSaveButton;
        Intrinsics.checkNotNull(linearLayout3);
        linearLayout3.setAlpha(z3 ? 1.0f : 0.4f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateDialog$lambda$5(final SpeakerRenameDialog speakerRenameDialog, final Map map, DialogInterface dialogInterface) {
        Logger.m12713i("SpeakerRenameDialog", "onShow");
        final Bundle arguments = speakerRenameDialog.getArguments();
        Intrinsics.checkNotNull(arguments);
        final int i = arguments.getInt("request_code", -1);
        TextView textView = speakerRenameDialog.mTvSaveButton;
        Intrinsics.checkNotNull(textView);
        textView.setText(C11493R.string.base_string_rename_type1);
        LinearLayout linearLayout = speakerRenameDialog.mSaveButton;
        Intrinsics.checkNotNull(linearLayout);
        linearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.samsung.android.support.senl.nt.stt.view.dialog.j
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SpeakerRenameDialog.onCreateDialog$lambda$5$lambda$3(this.f7943a, i, map, arguments, view);
            }
        });
        LinearLayout linearLayout2 = speakerRenameDialog.mCancelButton;
        Intrinsics.checkNotNull(linearLayout2);
        linearLayout2.setOnClickListener(new ViewOnClickListenerC11565k(speakerRenameDialog, 0));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateDialog$lambda$5$lambda$3(SpeakerRenameDialog speakerRenameDialog, int i, Map map, Bundle bundle, View view) {
        String str;
        EditText editText = speakerRenameDialog.mInputView;
        Intrinsics.checkNotNull(editText);
        String string = editText.getText().toString();
        int length = string.length() - 1;
        int i2 = 0;
        boolean z = false;
        while (i2 <= length) {
            boolean z2 = Intrinsics.compare((int) string.charAt(!z ? i2 : length), 32) <= 0;
            if (z) {
                if (!z2) {
                    break;
                } else {
                    length--;
                }
            } else if (z2) {
                i2++;
            } else {
                z = true;
            }
        }
        String strM14139M = StringsKt.m14139M(string.subSequence(i2, length + 1).toString(), "\n", " ");
        Logger.m12713i("SpeakerRenameDialog", "SaveButton#OnClick. inputText : " + strM14139M);
        if (i != 2 || (str = speakerRenameDialog.mOriginalSpeakerName) == null || Intrinsics.areEqual(str, strM14139M)) {
            return;
        }
        if (map != null) {
            for (Map.Entry entry : map.entrySet()) {
                int iIntValue = ((Number) entry.getKey()).intValue();
                if (Intrinsics.areEqual((String) entry.getValue(), strM14139M)) {
                    AbstractC11014a.m12327l(iIntValue, "speakerId updated ", "SpeakerRenameDialog");
                    bundle.putInt(DialogConstant.BUNDLE_NEW_SPEAKER_ID, iIntValue);
                }
            }
        }
        bundle.putInt(DialogConstant.BUNDLE_SPEAKER_EDIT_OPTION, speakerRenameDialog.mCheckedEditOption);
        bundle.putString("name", strM14139M);
        bundle.putInt("result_code", i);
        STTDialogFactory.DialogResultListener dialogResultListener = speakerRenameDialog.mInterface;
        Intrinsics.checkNotNull(dialogResultListener);
        dialogResultListener.onDialogResult(speakerRenameDialog, bundle);
        speakerRenameDialog.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateDialog$lambda$5$lambda$4(SpeakerRenameDialog speakerRenameDialog, View view) {
        Logger.m12713i("SpeakerRenameDialog", "Cancel");
        speakerRenameDialog.dismiss();
    }

    private final void setButtonClickListener() {
        RadioGroup radioGroup = this.mOptionRadioGroup;
        Intrinsics.checkNotNull(radioGroup);
        radioGroup.check(C11493R.id.only_this_radio_button);
        this.mCheckedEditOption = 0;
        RadioGroup radioGroup2 = this.mOptionRadioGroup;
        Intrinsics.checkNotNull(radioGroup2);
        radioGroup2.setOnCheckedChangeListener(new C7558c(this, 5));
        LinearLayout linearLayout = this.mSaveButton;
        Intrinsics.checkNotNull(linearLayout);
        linearLayout.setOnClickListener(new ViewOnClickListenerC11565k(this, 1));
        LinearLayout linearLayout2 = this.mCancelButton;
        Intrinsics.checkNotNull(linearLayout2);
        linearLayout2.setOnClickListener(new ViewOnClickListenerC11565k(this, 2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setButtonClickListener$lambda$10(SpeakerRenameDialog speakerRenameDialog, View view) {
        Logger.m12713i("SpeakerRenameDialog", "SaveButton#OnClick. visible : " + speakerRenameDialog.isVisible());
        if (speakerRenameDialog.isVisible()) {
            speakerRenameDialog.dismissAllowingStateLoss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setButtonClickListener$lambda$11(SpeakerRenameDialog speakerRenameDialog, View view) {
        if (speakerRenameDialog.isVisible()) {
            speakerRenameDialog.dismissAllowingStateLoss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setButtonClickListener$lambda$9(SpeakerRenameDialog speakerRenameDialog, RadioGroup group, int i) {
        Intrinsics.checkNotNullParameter(group, "group");
        Logger.m12713i("SpeakerRenameDialog", "mOptionRadioGroup checkedId : " + i);
        speakerRenameDialog.mCheckedEditOption = i == C11493R.id.only_this_radio_button ? 0 : i == C11493R.id.all_radio_button ? 1 : -1;
        speakerRenameDialog.invalidateTextAndSaveEnabled();
    }

    private final void setInputViewListener() {
        EditText editText = this.mInputView;
        Intrinsics.checkNotNull(editText);
        editText.addTextChangedListener(new TextWatcher() { // from class: com.samsung.android.support.senl.nt.stt.view.dialog.SpeakerRenameDialog.setInputViewListener.1
            @Override // android.text.TextWatcher
            public synchronized void afterTextChanged(Editable s) {
                try {
                    Intrinsics.checkNotNullParameter(s, "s");
                    SpeakerRenameDialog.this.invalidateTextAndSaveEnabled();
                    if (!Intrinsics.areEqual(SpeakerRenameDialog.this.mPreviousName, s.toString()) && SpeakerRenameDialog.this.getMTotalLength() <= AbsSTTDialogFragment.getMAX_LENGTH()) {
                        TextInputLayout mInputLayout = SpeakerRenameDialog.this.getMInputLayout();
                        if (mInputLayout != null) {
                            mInputLayout.setErrorEnabled(false);
                        }
                        SpeakerRenameDialog.this.mInputErrorType = AbsSTTDialogFragment.getNONE_ERROR_TYPE();
                        EditText editText2 = SpeakerRenameDialog.this.mInputView;
                        Intrinsics.checkNotNull(editText2);
                        editText2.setBackgroundTintList(SpeakerRenameDialog.this.getResources().getColorStateList(C11493R.color.edit_background_tint_color, null));
                    }
                    SpeakerRenameDialog.this.mPreviousName = s.toString();
                } catch (Throwable th) {
                    throw th;
                }
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
        EditText editText2 = this.mInputView;
        Intrinsics.checkNotNull(editText2);
        editText2.setOnKeyListener(new ViewOnKeyListenerC7560e(this, 4));
        EditText editText3 = this.mInputView;
        Intrinsics.checkNotNull(editText3);
        editText3.setOnEditorActionListener(new C10505d(this, 1));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean setInputViewListener$lambda$7(SpeakerRenameDialog speakerRenameDialog, View view, int i, KeyEvent keyEvent) {
        Intrinsics.checkNotNullParameter(keyEvent, "keyEvent");
        if (keyEvent.getKeyCode() != 66) {
            return false;
        }
        speakerRenameDialog.executePositiveEvent();
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean setInputViewListener$lambda$8(SpeakerRenameDialog speakerRenameDialog, TextView textView, int i, KeyEvent keyEvent) {
        if (i != 6) {
            return false;
        }
        speakerRenameDialog.executePositiveEvent();
        return false;
    }

    private final void setupInputView(WindowFocusLayout renameView, Bundle savedInstanceState) {
        int length;
        TextInputLayout mInputLayout = getMInputLayout();
        Intrinsics.checkNotNull(mInputLayout);
        mInputLayout.setErrorEnabled(false);
        EditText editText = this.mInputView;
        Intrinsics.checkNotNull(editText);
        editText.setText(this.mOriginalSpeakerName);
        EditText editText2 = this.mInputView;
        Intrinsics.checkNotNull(editText2);
        editText2.setHint(this.mOriginalSpeakerName);
        String str = this.mOriginalSpeakerName;
        if (str != null) {
            Intrinsics.checkNotNull(str);
            if (str.length() > AbsSTTDialogFragment.getMAX_LENGTH()) {
                setInputErrorMessage(0);
            }
        }
        EditText editText3 = this.mInputView;
        Intrinsics.checkNotNull(editText3);
        editText3.setSelected(true);
        EditText editText4 = this.mInputView;
        Intrinsics.checkNotNull(editText4);
        editText4.setFocusable(true);
        EditText editText5 = this.mInputView;
        Intrinsics.checkNotNull(editText5);
        String str2 = this.mOriginalSpeakerName;
        if (str2 != null) {
            Intrinsics.checkNotNull(str2);
            length = str2.length();
        } else {
            length = 0;
        }
        editText5.setFilters(getNameFilter(true, length));
        EditText editText6 = this.mInputView;
        Intrinsics.checkNotNull(editText6);
        editText6.post(new RunnableC11563i(this, 0));
        if (savedInstanceState != null) {
            this.bNameChanged = savedInstanceState.getBoolean(BUNDLE_NAME_CHANGED, false);
        }
        renameView.setOnWindowFocusChangeListener(new C115542());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupInputView$lambda$6(SpeakerRenameDialog speakerRenameDialog) {
        EditText editText = speakerRenameDialog.mInputView;
        Intrinsics.checkNotNull(editText);
        editText.selectAll();
        EditText editText2 = speakerRenameDialog.mInputView;
        Intrinsics.checkNotNull(editText2);
        editText2.requestFocus();
    }

    @Override // androidx.fragment.app.DialogFragment
    @NotNull
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        Logger.m12713i("SpeakerRenameDialog", "onCreateDialog");
        FragmentActivity fragmentActivityRequireActivity = requireActivity();
        Intrinsics.checkNotNullExpressionValue(fragmentActivityRequireActivity, "requireActivity(...)");
        View viewInflate = fragmentActivityRequireActivity.getLayoutInflater().inflate(C11493R.layout.dialog_speaker_rename, (ViewGroup) null);
        Intrinsics.checkNotNull(viewInflate, "null cannot be cast to non-null type com.samsung.android.support.senl.nt.stt.view.layout.WindowFocusLayout");
        WindowFocusLayout windowFocusLayout = (WindowFocusLayout) viewInflate;
        initView(windowFocusLayout);
        Bundle arguments = getArguments();
        int i = arguments != null ? arguments.getInt("title_id", -1) : -1;
        this.mOriginalSpeakerName = arguments != null ? arguments.getString("name", null) : null;
        this.mIsAddNewSpeaker = arguments != null && arguments.getInt(DialogConstant.BUNDLE_POSITIVE_BTN_ID, -1) == C11493R.string.base_string_save_type1;
        AlertDialog.Builder builder = new AlertDialog.Builder(fragmentActivityRequireActivity);
        builder.setTitle(i);
        builder.setView(windowFocusLayout);
        setupInputView(windowFocusLayout, savedInstanceState);
        setButtonClickListener();
        AlertDialog alertDialogCreate = builder.create();
        this.mDialog = alertDialogCreate;
        Intrinsics.checkNotNull(alertDialogCreate);
        Window window = alertDialogCreate.getWindow();
        Intrinsics.checkNotNull(window);
        window.setSoftInputMode(16);
        if (this.mPreviousName == null) {
            EditText editText = this.mInputView;
            Intrinsics.checkNotNull(editText);
            this.mPreviousName = editText.getText().toString();
        }
        setInputViewListener();
        if (this.mInterface == null) {
            this.mInterface = STTDialogFactory.INSTANCE.getListenerByTag("SpeakerRenameDialog");
        }
        STTDialogFactory.DialogResultListener dialogResultListener = this.mInterface;
        Intrinsics.checkNotNull(dialogResultListener);
        Map<Integer, String> speakerNameMap = dialogResultListener.getSpeakerNameMap();
        if (speakerNameMap != null) {
            EditText editText2 = this.mInputView;
            Intrinsics.checkNotNull(editText2);
            String string = editText2.getText().toString();
            int length = string.length() - 1;
            int i2 = 0;
            boolean z = false;
            while (i2 <= length) {
                boolean z2 = Intrinsics.compare((int) string.charAt(!z ? i2 : length), 32) <= 0;
                if (z) {
                    if (!z2) {
                        break;
                    }
                    length--;
                } else if (z2) {
                    i2++;
                } else {
                    z = true;
                }
            }
            if (speakerNameMap.containsValue(string.subSequence(i2, length + 1).toString())) {
                LinearLayout linearLayout = this.mSaveButton;
                Intrinsics.checkNotNull(linearLayout);
                linearLayout.setEnabled(false);
                TextView textView = this.mTvSaveButton;
                Intrinsics.checkNotNull(textView);
                textView.setEnabled(false);
                LinearLayout linearLayout2 = this.mSaveButton;
                Intrinsics.checkNotNull(linearLayout2);
                linearLayout2.setAlpha(0.4f);
            }
        }
        alertDialogCreate.setOnShowListener(new DialogInterfaceOnShowListenerC11557c(this, speakerNameMap, 1));
        Intrinsics.checkNotNull(alertDialogCreate);
        return alertDialogCreate;
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public void onDismiss(@NotNull DialogInterface dialog) {
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        Logger.m12713i("SpeakerRenameDialog", "onDismiss#");
        STTDialogFactory.DialogResultListener dialogResultListener = this.mInterface;
        Intrinsics.checkNotNull(dialogResultListener);
        dialogResultListener.setShowing(false);
        super.onDismiss(dialog);
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        setIsKeyboardVisible();
        unregisterKeyBoardReceiver();
        super.onPause();
    }

    @Override // com.samsung.android.support.senl.p148nt.stt.view.dialog.AbsSTTDialogFragment, androidx.fragment.app.Fragment
    public void onResume() {
        int i;
        super.onResume();
        showHideSIP();
        if (!getShowsDialog() || (i = this.mInputErrorType) == -1) {
            return;
        }
        setInputErrorMessage(i);
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onSaveInstanceState(@NotNull Bundle outState) {
        Intrinsics.checkNotNullParameter(outState, "outState");
        outState.putBoolean(BUNDLE_NAME_CHANGED, this.bNameChanged);
        outState.putInt(AbsSTTDialogFragment.getBUNDLE_ERROR_TYPE(), this.mInputErrorType);
        super.onSaveInstanceState(outState);
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        STTDialogFactory.DialogResultListener dialogResultListener = this.mInterface;
        Intrinsics.checkNotNull(dialogResultListener);
        dialogResultListener.setShowing(true);
        invalidateTextAndSaveEnabled();
    }

    @Override // com.samsung.android.support.senl.p148nt.stt.view.dialog.AbsSTTDialogFragment
    public void setDialogResultListener(@Nullable STTDialogFactory.DialogResultListener listener) {
        Logger.m12713i("SpeakerRenameDialog", "setDialogResultListener# " + listener);
        this.mInterface = listener;
    }

    @Override // com.samsung.android.support.senl.p148nt.stt.view.dialog.AbsSTTDialogFragment
    public void setInputErrorMessage(int type) {
        super.setInputErrorMessage(type);
        if (getMInputLayout() == null || type != 0) {
            return;
        }
        this.mInputErrorType = 0;
    }
}
