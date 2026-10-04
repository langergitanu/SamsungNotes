package com.samsung.android.support.senl.p148nt.app.settings.advanced.hwr.dialog;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;
import com.samsung.android.support.senl.p145cm.base.framework.content.SharedPreferencesCompat;
import com.samsung.android.support.senl.p145cm.base.framework.support.BaseUtils;
import com.samsung.android.support.senl.p148nt.app.C8003R;
import com.samsung.android.support.senl.p148nt.base.common.constants.SettingsConstants;
import com.samsung.android.support.senl.p148nt.base.winset.builder.AlertDialogBuilderForAppCompat;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import com.samsung.android.support.senl.p148nt.model.collector.recognition.extractor.TextRecognitionLanguage;
import com.samsung.android.support.senl.p148nt.model.collector.recognition.extractor.TextRecognitionLanguageDownloadHelper;
import com.samsung.android.support.senl.p148nt.model.collector.util.RecognitionUtil;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p044K.C0158a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u001b2\u00020\u0001:\u0002\u001a\u001bB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u000eJ\u0012\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016J\u0006\u0010\u0016\u001a\u00020\u0010J\u0010\u0010\u0017\u001a\u00020\u00102\b\u0010\u0018\u001a\u0004\u0018\u00010\bJ\u0012\u0010\u0019\u001a\u00020\u00102\b\u0010\u0018\u001a\u0004\u0018\u00010\bH\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001c"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/app/settings/advanced/hwr/dialog/HWDBDownloadDialog;", "Landroidx/fragment/app/DialogFragment;", "<init>", "()V", "mPositiveButton", "Landroid/widget/Button;", "mNegativeButton", "mLanguageDownloadHelper", "Lcom/samsung/android/support/senl/nt/model/collector/recognition/extractor/TextRecognitionLanguageDownloadHelper;", "mProgressBar", "Landroid/widget/ProgressBar;", "mDownloadRequestLanguage", "", "mContract", "Lcom/samsung/android/support/senl/nt/app/settings/advanced/hwr/dialog/HWDBDownloadDialog$Contract;", "setContract", "", "contract", "onCreateDialog", "Landroid/app/Dialog;", "savedInstanceState", "Landroid/os/Bundle;", "requestDownload", "init", "helper", "initLanguageDownloadHelper", "Contract", "Companion", "ntApp_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nHWDBDownloadDialog.kt\nKotlin\n*S Kotlin\n*F\n+ 1 HWDBDownloadDialog.kt\ncom/samsung/android/support/senl/nt/app/settings/advanced/hwr/dialog/HWDBDownloadDialog\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,138:1\n1#2:139\n*E\n"})
public final class HWDBDownloadDialog extends DialogFragment {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    public static final String TAG = "HandwritingDownloadDialog";

    @Nullable
    private Contract mContract;

    @Nullable
    private String mDownloadRequestLanguage;

    @Nullable
    private TextRecognitionLanguageDownloadHelper mLanguageDownloadHelper;

    @Nullable
    private Button mNegativeButton;

    @Nullable
    private Button mPositiveButton;

    @Nullable
    private ProgressBar mProgressBar;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\bH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\t"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/app/settings/advanced/hwr/dialog/HWDBDownloadDialog$Companion;", "", "<init>", "()V", SearchConstants.TargetContents.TAG, "", "getLanguage", "context", "Landroid/content/Context;", "ntApp_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final String getLanguage(Context context) {
            Logger.m10999d(HWDBDownloadDialog.TAG, "getLanguage# currentLanguage is null");
            TextRecognitionLanguage textRecognitionLanguage = new TextRecognitionLanguage(context);
            textRecognitionLanguage.initTextRecognitionLanguage(false);
            String strFindDefaultLocaleLanguageInRecognizerList = textRecognitionLanguage.findDefaultLocaleLanguageInRecognizerList();
            Logger.m10999d(HWDBDownloadDialog.TAG, "getLanguage# current language : " + strFindDefaultLocaleLanguageInRecognizerList);
            Intrinsics.checkNotNull(strFindDefaultLocaleLanguageInRecognizerList);
            return strFindDefaultLocaleLanguageInRecognizerList;
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0004"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/app/settings/advanced/hwr/dialog/HWDBDownloadDialog$Contract;", "", "onDownloadCompleted", "", "ntApp_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public interface Contract {
        void onDownloadCompleted();
    }

    private final void initLanguageDownloadHelper(TextRecognitionLanguageDownloadHelper helper) {
        this.mLanguageDownloadHelper = helper;
        if (helper == null) {
            TextRecognitionLanguageDownloadHelper textRecognitionLanguageDownloadHelper = new TextRecognitionLanguageDownloadHelper(BaseUtils.getApplicationContext());
            this.mLanguageDownloadHelper = textRecognitionLanguageDownloadHelper;
            Intrinsics.checkNotNull(textRecognitionLanguageDownloadHelper);
            textRecognitionLanguageDownloadHelper.init(C0158a.m407a().m414e());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateDialog$lambda$2(final HWDBDownloadDialog hWDBDownloadDialog, AlertDialog alertDialog, DialogInterface dialogInterface) {
        hWDBDownloadDialog.mNegativeButton = (Button) alertDialog.findViewById(C8003R.id.negativeButton);
        Button button = (Button) alertDialog.findViewById(C8003R.id.positiveButton);
        hWDBDownloadDialog.mPositiveButton = button;
        if (button != null) {
            final int i = 0;
            button.setOnClickListener(new View.OnClickListener(hWDBDownloadDialog) { // from class: com.samsung.android.support.senl.nt.app.settings.advanced.hwr.dialog.a

                /* JADX INFO: renamed from: b */
                public final /* synthetic */ HWDBDownloadDialog f6283b;

                {
                    this.f6283b = hWDBDownloadDialog;
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    switch (i) {
                        case 0:
                            this.f6283b.requestDownload();
                            break;
                        default:
                            HWDBDownloadDialog.onCreateDialog$lambda$2$lambda$1(this.f6283b, view);
                            break;
                    }
                }
            });
        }
        Button button2 = hWDBDownloadDialog.mPositiveButton;
        if (button2 != null) {
            button2.setText(hWDBDownloadDialog.getString(C8003R.string.download));
        }
        Button button3 = hWDBDownloadDialog.mNegativeButton;
        if (button3 != null) {
            button3.setText(hWDBDownloadDialog.getString(C8003R.string.dialog_cancel));
        }
        Button button4 = hWDBDownloadDialog.mNegativeButton;
        if (button4 != null) {
            final int i2 = 1;
            button4.setOnClickListener(new View.OnClickListener(hWDBDownloadDialog) { // from class: com.samsung.android.support.senl.nt.app.settings.advanced.hwr.dialog.a

                /* JADX INFO: renamed from: b */
                public final /* synthetic */ HWDBDownloadDialog f6283b;

                {
                    this.f6283b = hWDBDownloadDialog;
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    switch (i2) {
                        case 0:
                            this.f6283b.requestDownload();
                            break;
                        default:
                            HWDBDownloadDialog.onCreateDialog$lambda$2$lambda$1(this.f6283b, view);
                            break;
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateDialog$lambda$2$lambda$1(HWDBDownloadDialog hWDBDownloadDialog, View view) {
        TextRecognitionLanguageDownloadHelper textRecognitionLanguageDownloadHelper = hWDBDownloadDialog.mLanguageDownloadHelper;
        if (textRecognitionLanguageDownloadHelper != null && hWDBDownloadDialog.mDownloadRequestLanguage != null) {
            Intrinsics.checkNotNull(textRecognitionLanguageDownloadHelper);
            textRecognitionLanguageDownloadHelper.cancelDownload(hWDBDownloadDialog.mDownloadRequestLanguage);
        }
        hWDBDownloadDialog.dismiss();
    }

    public final void init(@Nullable TextRecognitionLanguageDownloadHelper helper) {
        initLanguageDownloadHelper(helper);
    }

    @Override // androidx.fragment.app.DialogFragment
    @NotNull
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        final AlertDialog alertDialogCreate = new AlertDialogBuilderForAppCompat(getActivity(), 0, 2, null).setView(C8003R.layout.settings_hwr_download_dialog_layout).setCancelable(true).create();
        Intrinsics.checkNotNullExpressionValue(alertDialogCreate, "create(...)");
        alertDialogCreate.setCanceledOnTouchOutside(false);
        alertDialogCreate.setOnShowListener(new DialogInterface.OnShowListener() { // from class: com.samsung.android.support.senl.nt.app.settings.advanced.hwr.dialog.b
            @Override // android.content.DialogInterface.OnShowListener
            public final void onShow(DialogInterface dialogInterface) {
                HWDBDownloadDialog.onCreateDialog$lambda$2(this.f6284a, alertDialogCreate, dialogInterface);
            }
        });
        return alertDialogCreate;
    }

    public final void requestDownload() {
        TextRecognitionLanguageDownloadHelper textRecognitionLanguageDownloadHelper;
        AlertDialog alertDialog = (AlertDialog) getDialog();
        if (alertDialog == null) {
            return;
        }
        this.mProgressBar = (ProgressBar) alertDialog.findViewById(C8003R.id.progress_bar);
        View viewFindViewById = alertDialog.findViewById(C8003R.id.downloading_text);
        if (viewFindViewById != null) {
            viewFindViewById.setVisibility(8);
        }
        ProgressBar progressBar = this.mProgressBar;
        if (progressBar != null) {
            progressBar.setVisibility(0);
        }
        Button button = this.mPositiveButton;
        if (button != null) {
            button.setVisibility(8);
        }
        Button button2 = this.mNegativeButton;
        if (button2 != null) {
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
            layoutParams.weight = 2.0f;
            button2.setLayoutParams(layoutParams);
        }
        View viewFindViewById2 = alertDialog.findViewById(C8003R.id.divider_view);
        if (viewFindViewById2 != null) {
            viewFindViewById2.setVisibility(8);
        }
        TextView textView = (TextView) alertDialog.findViewById(C8003R.id.downloadTitle);
        if (textView != null) {
            textView.setVisibility(0);
        }
        TextRecognitionLanguageDownloadHelper textRecognitionLanguageDownloadHelper2 = this.mLanguageDownloadHelper;
        String strFindDefaultLanguage = textRecognitionLanguageDownloadHelper2 != null ? textRecognitionLanguageDownloadHelper2.findDefaultLanguage() : null;
        this.mDownloadRequestLanguage = strFindDefaultLanguage;
        if (strFindDefaultLanguage == null || (textRecognitionLanguageDownloadHelper = this.mLanguageDownloadHelper) == null) {
            return;
        }
        textRecognitionLanguageDownloadHelper.download(strFindDefaultLanguage, new TextRecognitionLanguageDownloadHelper.DownloadListener() { // from class: com.samsung.android.support.senl.nt.app.settings.advanced.hwr.dialog.HWDBDownloadDialog.requestDownload.2
            @Override // com.samsung.android.support.senl.nt.model.collector.recognition.extractor.TextRecognitionLanguageDownloadHelper.DownloadListener
            public void onComplete(int status) {
                HWDBDownloadDialog.this.dismiss();
                if (status == 0) {
                    RecognitionUtil.setHWRLanguage(HWDBDownloadDialog.this.mDownloadRequestLanguage);
                    SharedPreferencesCompat.INSTANCE.getInstance("Settings").putString(SettingsConstants.SETTINGS_HANDWRITING_CONVERT_TO_TEXT_LANGUAGE, RecognitionUtil.getHWRLanguage(BaseUtils.getContext()));
                    Contract contract = HWDBDownloadDialog.this.mContract;
                    if (contract != null) {
                        contract.onDownloadCompleted();
                    }
                }
            }

            @Override // com.samsung.android.support.senl.nt.model.collector.recognition.extractor.TextRecognitionLanguageDownloadHelper.DownloadListener
            public void onProgress(int progress, int max) {
                if (HWDBDownloadDialog.this.mProgressBar != null) {
                    ProgressBar progressBar2 = HWDBDownloadDialog.this.mProgressBar;
                    Intrinsics.checkNotNull(progressBar2);
                    progressBar2.setMax(max);
                    ProgressBar progressBar3 = HWDBDownloadDialog.this.mProgressBar;
                    Intrinsics.checkNotNull(progressBar3);
                    progressBar3.setProgress(progress);
                }
            }
        });
    }

    public final void setContract(@NotNull Contract contract) {
        Intrinsics.checkNotNullParameter(contract, "contract");
        this.mContract = contract;
    }
}
