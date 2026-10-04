package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.common;

import android.R;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import com.samsung.android.support.senl.p145cm.base.framework.p146os.SystemPropertiesCompat;
import com.samsung.android.support.senl.p148nt.base.common.cms.ExternalLinkUtil;
import com.samsung.android.support.senl.p148nt.base.framework.support.PolicyManager;
import com.samsung.android.support.senl.p148nt.base.winset.builder.AlertDialogBuilderForAppCompat;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.BackgroundColorUtil;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AiCommonNoticeDialog {
    protected static final String MARK1 = "#1";
    protected static final String MARK2 = "#2";
    protected static final String MARK3 = "#3";
    protected static final String MARK4 = "#4";
    boolean mIsKoreaModel;
    boolean mOkVisible;
    View.OnLayoutChangeListener mOnLayoutChangeListener;
    Button mPositive;
    ScrollView mScrollView;

    private void replaceAll(StringBuilder sb, String str, String str2) {
        int iIndexOf = sb.indexOf(str);
        while (iIndexOf != -1) {
            sb.replace(iIndexOf, str.length() + iIndexOf, str2);
            iIndexOf = sb.indexOf(str, str2.length() + iIndexOf);
        }
    }

    public abstract int getLayoutResource();

    public abstract int getMessageResource(boolean z);

    public abstract int getNotice2Resource(boolean z);

    public abstract int getNotice3Resource(boolean z);

    public abstract StringBuilder getNoticeMessage(Context context, boolean z);

    public abstract String getTag();

    public abstract int getTitleResource();

    public void show(final Context context, final Runnable runnable, final Runnable runnable2, boolean z) {
        int i;
        this.mIsKoreaModel = SystemPropertiesCompat.INSTANCE.getInstance().isKoreaModel();
        AlertDialogBuilderForAppCompat alertDialogBuilderForAppCompat = new AlertDialogBuilderForAppCompat(context);
        View viewInflate = LayoutInflater.from(context).inflate(getLayoutResource(), (ViewGroup) null);
        this.mScrollView = (ScrollView) viewInflate.findViewById(C9086R.id.scroll_layout);
        this.mOkVisible = !r0.canScrollVertically(1);
        StringBuilder noticeMessage = getNoticeMessage(context, z);
        final int iIndexOf = noticeMessage.indexOf(MARK1);
        final int iIndexOf2 = noticeMessage.indexOf(MARK2, iIndexOf + 1) - 2;
        int iIndexOf3 = noticeMessage.indexOf(MARK3);
        int i2 = iIndexOf3 - 4;
        int iIndexOf4 = noticeMessage.indexOf(MARK4, iIndexOf3 - 3) - 6;
        replaceAll(noticeMessage, MARK1, "");
        replaceAll(noticeMessage, MARK2, "");
        replaceAll(noticeMessage, MARK3, "");
        replaceAll(noticeMessage, MARK4, "");
        final SpannableString spannableString = new SpannableString(noticeMessage);
        if (iIndexOf == -1 || iIndexOf2 == -1) {
            i = -1;
        } else {
            spannableString.setSpan(new ClickableSpan() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.common.AiCommonNoticeDialog.1
                @Override // android.text.style.ClickableSpan
                public void onClick(@NonNull View view) {
                    Logger.m11003i(AiCommonNoticeDialog.this.getTag(), "onClick# spannableString : " + spannableString.toString().substring(iIndexOf, iIndexOf2));
                    try {
                        ExternalLinkUtil.linkPrivacyNotice(context.getApplicationContext());
                    } catch (ActivityNotFoundException e) {
                        Logger.m11001e(AiCommonNoticeDialog.this.getTag(), "ActivityNotFoundException", e);
                    }
                }
            }, iIndexOf, iIndexOf2, 0);
            spannableString.setSpan(new ForegroundColorSpan(context.getResources().getColor(C9086R.color.ftu_span_color)), iIndexOf, iIndexOf2, 0);
            spannableString.setSpan(ExternalLinkUtil.getLinkTypefaceSpan(), iIndexOf, iIndexOf2, 33);
            i = -1;
        }
        if (i2 != i && iIndexOf4 != i) {
            spannableString.setSpan(new ClickableSpan() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.common.AiCommonNoticeDialog.2
                @Override // android.text.style.ClickableSpan
                public void onClick(@NonNull View view) {
                    try {
                        ExternalLinkUtil.linkTermsAndCondition(context.getApplicationContext());
                    } catch (ActivityNotFoundException e) {
                        try {
                            Logger.m11001e(AiCommonNoticeDialog.this.getTag(), "ActivityNotFoundException", e);
                        } catch (ActivityNotFoundException e2) {
                            Logger.m11001e(AiCommonNoticeDialog.this.getTag(), "ActivityNotFoundException", e2);
                        }
                    }
                }
            }, i2, iIndexOf4, 0);
            spannableString.setSpan(new ForegroundColorSpan(context.getResources().getColor(C9086R.color.ftu_span_color)), i2, iIndexOf4, 0);
            spannableString.setSpan(ExternalLinkUtil.getLinkTypefaceSpan(), i2, iIndexOf4, 33);
        }
        alertDialogBuilderForAppCompat.setTitle(getTitleResource()).setPositiveButton(this.mOkVisible ? this.mIsKoreaModel ? C9086R.string.base_string_continue : C9086R.string.f6715OK : C9086R.string.base_string_more, (DialogInterface.OnClickListener) null).setNegativeButton(C9086R.string.base_string_cancel_type1, new DialogInterface.OnClickListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.common.AiCommonNoticeDialog.4
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i4) {
                Runnable runnable3 = runnable2;
                if (runnable3 != null) {
                    runnable3.run();
                }
            }
        }).setCancelable(true).setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.common.AiCommonNoticeDialog.3
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                Runnable runnable3 = runnable2;
                if (runnable3 != null) {
                    runnable3.run();
                }
            }
        });
        TextView textView = (TextView) viewInflate.findViewById(C9086R.id.ftu_message);
        StringBuilder sb = new StringBuilder();
        sb.append(context.getString(getMessageResource(z)));
        sb.append("\n");
        textView.setText(sb);
        TextView textView2 = (TextView) viewInflate.findViewById(C9086R.id.ftu_notice);
        textView2.setText(spannableString);
        final AlertDialog alertDialogCreate = alertDialogBuilderForAppCompat.create();
        alertDialogCreate.setView(viewInflate);
        BackgroundColorUtil.setBlurInfoPopup(alertDialogCreate.getContext(), alertDialogCreate.findViewById(R.id.content));
        alertDialogCreate.setOnShowListener(new DialogInterface.OnShowListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.common.AiCommonNoticeDialog.5
            @Override // android.content.DialogInterface.OnShowListener
            public void onShow(DialogInterface dialogInterface) {
                AiCommonNoticeDialog.this.mOkVisible = !r4.mScrollView.canScrollVertically(1);
                AiCommonNoticeDialog.this.mPositive = alertDialogCreate.getButton(-1);
                AiCommonNoticeDialog aiCommonNoticeDialog = AiCommonNoticeDialog.this;
                Button button = aiCommonNoticeDialog.mPositive;
                Resources resources = aiCommonNoticeDialog.mScrollView.getResources();
                AiCommonNoticeDialog aiCommonNoticeDialog2 = AiCommonNoticeDialog.this;
                button.setText(resources.getText(aiCommonNoticeDialog2.mOkVisible ? aiCommonNoticeDialog2.mIsKoreaModel ? C9086R.string.base_string_continue : C9086R.string.f6715OK : C9086R.string.base_string_more));
                if (AiCommonNoticeDialog.this.mOkVisible && PolicyManager.isEdmPolicyAiGrayout()) {
                    AiCommonNoticeDialog.this.mPositive.setEnabled(false);
                }
                AiCommonNoticeDialog.this.mPositive.setOnClickListener(new View.OnClickListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.common.AiCommonNoticeDialog.5.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        AlertDialog alertDialog;
                        DialogInterfaceOnShowListenerC92925 dialogInterfaceOnShowListenerC92925 = DialogInterfaceOnShowListenerC92925.this;
                        if (runnable == null || (alertDialog = alertDialogCreate) == null) {
                            return;
                        }
                        AiCommonNoticeDialog aiCommonNoticeDialog3 = AiCommonNoticeDialog.this;
                        if (aiCommonNoticeDialog3.mOkVisible) {
                            alertDialog.dismiss();
                            runnable.run();
                            return;
                        }
                        View childAt = aiCommonNoticeDialog3.mScrollView.getChildAt(r3.getChildCount() - 1);
                        if (childAt == null) {
                            return;
                        }
                        AiCommonNoticeDialog.this.mScrollView.smoothScrollBy(0, (AiCommonNoticeDialog.this.mScrollView.getPaddingBottom() + childAt.getBottom()) - (AiCommonNoticeDialog.this.mScrollView.getHeight() + AiCommonNoticeDialog.this.mScrollView.getScrollY()));
                    }
                });
            }
        });
        View.OnLayoutChangeListener onLayoutChangeListener = new View.OnLayoutChangeListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.common.AiCommonNoticeDialog.6
            @Override // android.view.View.OnLayoutChangeListener
            public void onLayoutChange(View view, int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11) {
                AiCommonNoticeDialog aiCommonNoticeDialog = AiCommonNoticeDialog.this;
                if (aiCommonNoticeDialog.mPositive == null) {
                    return;
                }
                aiCommonNoticeDialog.mOkVisible = !aiCommonNoticeDialog.mScrollView.canScrollVertically(1);
                AiCommonNoticeDialog aiCommonNoticeDialog2 = AiCommonNoticeDialog.this;
                aiCommonNoticeDialog2.mPositive.setText(aiCommonNoticeDialog2.mOkVisible ? aiCommonNoticeDialog2.mIsKoreaModel ? C9086R.string.base_string_continue : C9086R.string.f6715OK : C9086R.string.base_string_more);
                if (AiCommonNoticeDialog.this.mOkVisible && PolicyManager.isEdmPolicyAiGrayout()) {
                    AiCommonNoticeDialog.this.mPositive.setEnabled(false);
                }
            }
        };
        this.mOnLayoutChangeListener = onLayoutChangeListener;
        this.mScrollView.addOnLayoutChangeListener(onLayoutChangeListener);
        this.mScrollView.setOnScrollChangeListener(new View.OnScrollChangeListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.common.AiCommonNoticeDialog.7
            @Override // android.view.View.OnScrollChangeListener
            public void onScrollChange(View view, int i4, int i5, int i6, int i7) {
                if (alertDialogCreate == null) {
                    return;
                }
                AiCommonNoticeDialog.this.mOkVisible = !view.canScrollVertically(1);
                Button button = alertDialogCreate.getButton(-1);
                AiCommonNoticeDialog aiCommonNoticeDialog = AiCommonNoticeDialog.this;
                button.setText(aiCommonNoticeDialog.mOkVisible ? aiCommonNoticeDialog.mIsKoreaModel ? C9086R.string.base_string_continue : C9086R.string.f6715OK : C9086R.string.base_string_more);
                if (AiCommonNoticeDialog.this.mOkVisible && PolicyManager.isEdmPolicyAiGrayout()) {
                    AiCommonNoticeDialog.this.mPositive.setEnabled(false);
                }
            }
        });
        alertDialogBuilderForAppCompat.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.common.AiCommonNoticeDialog.8
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                View.OnLayoutChangeListener onLayoutChangeListener2;
                AiCommonNoticeDialog aiCommonNoticeDialog = AiCommonNoticeDialog.this;
                ScrollView scrollView = aiCommonNoticeDialog.mScrollView;
                if (scrollView == null || (onLayoutChangeListener2 = aiCommonNoticeDialog.mOnLayoutChangeListener) == null) {
                    return;
                }
                scrollView.removeOnLayoutChangeListener(onLayoutChangeListener2);
            }
        });
        alertDialogCreate.show();
        textView2.setMovementMethod(LinkMovementMethod.getInstance());
    }
}
