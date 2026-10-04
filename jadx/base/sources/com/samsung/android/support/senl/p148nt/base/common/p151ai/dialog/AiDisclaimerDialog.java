package com.samsung.android.support.senl.p148nt.base.common.p151ai.dialog;

import android.R;
import android.app.Dialog;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.view.KeyEvent;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;
import com.samsung.android.support.senl.p148nt.app.common.NotesConstants;
import com.samsung.android.support.senl.p148nt.base.C8875R;
import com.samsung.android.support.senl.p148nt.base.common.cms.ExternalLinkUtil;
import com.samsung.android.support.senl.p148nt.base.common.util.ResourceUtils;
import com.samsung.android.support.senl.p148nt.base.framework.support.Logger;
import com.samsung.android.support.senl.p148nt.base.winset.builder.AlertDialogBuilderForAppCompat;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.util.Constants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p039I2.DialogInterfaceOnClickListenerC0140a;
import p054M1.DialogInterfaceOnKeyListenerC0175b;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u00142\u00020\u0001:\u0002\u0013\u0014B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0002J \u0010\u000b\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\b\u0010\r\u001a\u0004\u0018\u00010\u000eJ\u0006\u0010\u000f\u001a\u00020\fJ\u0018\u0010\u0010\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\r\u001a\u0004\u0018\u00010\u000eJ\u001c\u0010\u0011\u001a\u00020\f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u00052\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0015"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/common/ai/dialog/AiDisclaimerDialog;", "", "<init>", "()V", "mAlertDialog", "Landroidx/appcompat/app/AlertDialog;", "getDialog", "context", "Landroid/content/Context;", "isTextStyleOutPut", "", Constants.IntentExtraValue.SHOW, "", "view", "Landroid/view/View;", "hide", "showSTTMessage", "setAnchor", "alertDialog", DisclaimerDialogFragment.TAG, "Companion", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class AiDisclaimerDialog {

    @NotNull
    private static final String IS_TEXT_STYLE = "IS_TEXT_STYLE";

    @NotNull
    private static final String TAG = "AiDisclaimerDialog";

    @Nullable
    private AlertDialog mAlertDialog;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\t\b\u0016¢\u0006\u0004\b\u0004\u0010\u0006J\u0012\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016J\b\u0010\u000b\u001a\u00020\fH\u0016J\u0010\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\nH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0010"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/common/ai/dialog/AiDisclaimerDialog$DisclaimerDialogFragment;", "Landroidx/fragment/app/DialogFragment;", "mIsTextStyleOutPut", "", "<init>", "(Z)V", "()V", "onCreateDialog", "Landroid/app/Dialog;", "savedInstanceState", "Landroid/os/Bundle;", "onStart", "", NotesConstants.DialogTag.ON_SAVE_INSTANCE_STATE, "outState", "Companion", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class DisclaimerDialogFragment extends DialogFragment {

        @NotNull
        public static final String TAG = "DisclaimerDialogFragment";
        private boolean mIsTextStyleOutPut;

        public DisclaimerDialogFragment(boolean z) {
            this.mIsTextStyleOutPut = z;
        }

        @Override // androidx.fragment.app.DialogFragment
        @NotNull
        public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
            if (savedInstanceState != null) {
                this.mIsTextStyleOutPut = savedInstanceState.getBoolean(AiDisclaimerDialog.IS_TEXT_STYLE, false);
            }
            AiDisclaimerDialog aiDisclaimerDialog = new AiDisclaimerDialog();
            Context contextRequireContext = requireContext();
            Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
            return aiDisclaimerDialog.getDialog(contextRequireContext, this.mIsTextStyleOutPut);
        }

        @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
        public void onSaveInstanceState(@NotNull Bundle outState) {
            Intrinsics.checkNotNullParameter(outState, "outState");
            super.onSaveInstanceState(outState);
            outState.putBoolean(AiDisclaimerDialog.IS_TEXT_STYLE, this.mIsTextStyleOutPut);
        }

        @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
        public void onStart() {
            super.onStart();
            Dialog dialog = getDialog();
            TextView textView = dialog != null ? (TextView) dialog.findViewById(R.id.message) : null;
            if (textView != null) {
                textView.setMovementMethod(LinkMovementMethod.getInstance());
            }
        }

        public DisclaimerDialogFragment() {
            this(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final AlertDialog getDialog(final Context context, boolean isTextStyleOutPut) {
        StringBuilder sb = new StringBuilder();
        sb.append(context.getString(isTextStyleOutPut ? C8875R.string.ai_intelligence_text_information_dialog_message : C8875R.string.ai_intelligence_content_information_dialog_message, "1", "2"));
        final int iIndexOf = sb.indexOf("1");
        int i = iIndexOf + 1;
        int iIndexOf2 = sb.indexOf("2", i);
        final int i2 = iIndexOf2 - 1;
        sb.replace(iIndexOf, i, "");
        sb.replace(i2, iIndexOf2, "");
        final SpannableString spannableString = new SpannableString(sb);
        spannableString.setSpan(new ClickableSpan() { // from class: com.samsung.android.support.senl.nt.base.common.ai.dialog.AiDisclaimerDialog.getDialog.1
            @Override // android.text.style.ClickableSpan
            public void onClick(View widget) {
                Intrinsics.checkNotNullParameter(widget, "widget");
                String string = spannableString.toString();
                Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
                String strSubstring = string.substring(iIndexOf, i2);
                Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
                Logger.m8697d(AiDisclaimerDialog.TAG, "onClick# spannableString : " + strSubstring);
                try {
                    ExternalLinkUtil.linkTermsAndCondition(context);
                } catch (ActivityNotFoundException e) {
                    Logger.m8699e(AiDisclaimerDialog.TAG, "ActivityNotFoundException", e);
                }
            }
        }, iIndexOf, i2, 0);
        spannableString.setSpan(new ForegroundColorSpan(context.getColor(C8875R.color.disclaimer_notice_link_color)), iIndexOf, i2, 34);
        spannableString.setSpan(ExternalLinkUtil.getLinkTypefaceSpan(), iIndexOf, i2, 34);
        AlertDialogBuilderForAppCompat alertDialogBuilderForAppCompat = new AlertDialogBuilderForAppCompat(context, 0, 2, null);
        alertDialogBuilderForAppCompat.setMessage(spannableString);
        alertDialogBuilderForAppCompat.setCancelable(false);
        alertDialogBuilderForAppCompat.setPositiveButton(C8875R.string.f6384OK, new DialogInterfaceOnClickListenerC0140a(8));
        AlertDialog alertDialogCreate = alertDialogBuilderForAppCompat.create();
        alertDialogCreate.setOnKeyListener(new DialogInterfaceOnKeyListenerC0175b(1));
        ResourceUtils.setBlurInfoPopup(context, alertDialogCreate.getListView());
        alertDialogCreate.setCanceledOnTouchOutside(true);
        return alertDialogCreate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getDialog$lambda$0(DialogInterface dialogInterface, int i) {
        Logger.m8697d(TAG, "onClick");
        dialogInterface.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean getDialog$lambda$1(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
        if (i != 4 || keyEvent.getAction() != 1) {
            return false;
        }
        dialogInterface.dismiss();
        return false;
    }

    private final void setAnchor(AlertDialog alertDialog, View view) {
        if (view != null) {
            int[] iArr = new int[2];
            view.getLocationInWindow(iArr);
            if (alertDialog != null) {
                alertDialog.semSetAnchor(iArr[0], view.getResources().getDimensionPixelSize(C8875R.dimen.ai_disclaimer_dialog_margin_bottom) + iArr[1]);
            }
        }
    }

    public final void hide() {
        AlertDialog alertDialog = this.mAlertDialog;
        if (alertDialog != null) {
            Intrinsics.checkNotNull(alertDialog);
            alertDialog.dismiss();
        }
    }

    public final void show(@NotNull Context context, boolean isTextStyleOutPut, @Nullable View view) {
        Intrinsics.checkNotNullParameter(context, "context");
        AlertDialog dialog = getDialog(context, isTextStyleOutPut);
        this.mAlertDialog = dialog;
        if (dialog != null) {
            dialog.show();
        }
        AlertDialog alertDialog = this.mAlertDialog;
        if (alertDialog != null) {
            alertDialog.setOnDismissListener(new DialogInterfaceOnDismissListenerC8880a(this, 0));
        }
        AlertDialog alertDialog2 = this.mAlertDialog;
        TextView textView = alertDialog2 != null ? (TextView) alertDialog2.findViewById(R.id.message) : null;
        if (textView != null) {
            textView.setMovementMethod(LinkMovementMethod.getInstance());
        }
        setAnchor(this.mAlertDialog, view);
    }

    public final void showSTTMessage(@NotNull Context context, @Nullable View view) {
        Intrinsics.checkNotNullParameter(context, "context");
        AlertDialog dialog = getDialog(context, true);
        this.mAlertDialog = dialog;
        if (dialog != null) {
            dialog.setMessage(context.getString(C8875R.string.ai_intelligence_information_stt_dialog_message));
        }
        AlertDialog alertDialog = this.mAlertDialog;
        if (alertDialog != null) {
            alertDialog.show();
        }
        AlertDialog alertDialog2 = this.mAlertDialog;
        if (alertDialog2 != null) {
            alertDialog2.setOnDismissListener(new DialogInterfaceOnDismissListenerC8880a(this, 1));
        }
        setAnchor(this.mAlertDialog, view);
    }
}
