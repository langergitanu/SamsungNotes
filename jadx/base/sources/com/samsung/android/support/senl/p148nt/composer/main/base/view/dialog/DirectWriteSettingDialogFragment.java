package com.samsung.android.support.senl.p148nt.composer.main.base.view.dialog;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.constraintlayout.widget.Group;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.samsung.android.support.senl.p145cm.base.common.postprocessing.PostLaunchManager;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.base.common.access.notelist.NoteListAccessHandler;
import com.samsung.android.support.senl.p148nt.base.common.constants.SettingsConstants;
import com.samsung.android.support.senl.p148nt.base.common.sync.RequestToSyncManager;
import com.samsung.android.support.senl.p148nt.base.common.util.DisplayLanguageUtils;
import com.samsung.android.support.senl.p148nt.base.winset.app.popover.PopOverActivityWrapper;
import com.samsung.android.support.senl.p148nt.base.winset.builder.AlertDialogBuilderForAppCompat;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.menu.toolbar.directwrite.constants.DirectWriteConstant;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.dialog.DialogContract;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.dialog.DirectWriteSettingDialogPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.CommonUtil;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.dialog.DirectWriteSettingDialogFragment;
import com.samsung.android.support.senl.p148nt.model.collector.recognition.extractor.TextRecognitionLanguage;
import com.samsung.android.support.senl.p148nt.model.collector.recognition.extractor.TextRecognitionLanguageDownloadHelper;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import org.jetbrains.annotations.NotNull;
import p258y.AbstractC14516b;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class DirectWriteSettingDialogFragment extends DialogFragment {
    private static final String TAG = Logger.createTag("DirectWriteSettingDialogFragment");
    private String mCurrentLanguage;
    private String mDownloadRecommendLanguage = "";
    private int mInsertType;
    private TextRecognitionLanguageDownloadHelper mLanguageDownloadHelper;
    private DirectWriteSettingDialogPresenter mPresenter;
    private RecognitionLanguageAdapter mRecognitionLanguageAdapter;
    private View mView;
    private ViewTreeObserver.OnWindowFocusChangeListener mWindowFocusChangeListener;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface AdapterContract {
        void onCancel(String str);

        void onDownload(String str, DownloadListener downloadListener);

        void onDownloadCancel(String str);

        void onProgress(int i, int i2);

        void onSelectItem(int i);

        void onSuccess(String str);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class DownloadListener implements TextRecognitionLanguageDownloadHelper.DownloadListener {
        private static final String TAG = "DownloadListener";
        private final DownloadResultCallback mDownloadResultCallback;
        private final String mLocale;

        public DownloadListener(String str, DownloadResultCallback downloadResultCallback) {
            this.mLocale = str;
            this.mDownloadResultCallback = downloadResultCallback;
        }

        @Override // com.samsung.android.support.senl.nt.model.collector.recognition.extractor.TextRecognitionLanguageDownloadHelper.DownloadListener
        public void onComplete(int i) {
            if (i == 0) {
                this.mDownloadResultCallback.onSuccess(this.mLocale);
                return;
            }
            if (i == 1) {
                this.mDownloadResultCallback.onCancelled(this.mLocale);
            } else if (i != 2) {
                AbstractC8014b.m7217s(i, "unexpected status: ", TAG);
            } else {
                this.mDownloadResultCallback.onFailed(this.mLocale);
            }
        }

        @Override // com.samsung.android.support.senl.nt.model.collector.recognition.extractor.TextRecognitionLanguageDownloadHelper.DownloadListener
        public void onProgress(int i, int i2) {
            AbstractC14516b.m15114b(i, i2, "onProgress progress ", "  max ", TAG);
            this.mDownloadResultCallback.onProgress(i, i2);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface DownloadResultCallback {
        void onCancelled(String str);

        void onFailed(String str);

        void onProgress(int i, int i2);

        void onSuccess(String str);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface FragmentContract {
        void onDownload(String str, DownloadListener downloadListener);

        void onDownloadCancel(String str);

        void onDownloadSuccess(String str);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public class RecognitionLanguageAdapter extends RecyclerView.Adapter<ViewHolder> {
        private final FragmentContract mFragmentContract;
        private List<String> mLanguageList;
        private List<String> mLanguageListForDisplay;
        private String mSelectedLanguage;
        private String mDownloadLanguage = "";
        private boolean mIsDownloading = false;
        private int mDownloadingProgress = 0;

        public RecognitionLanguageAdapter(FragmentContract fragmentContract) {
            this.mFragmentContract = fragmentContract;
        }

        public void applySelectedLanguage() {
            AbstractC8014b.m7213o(new StringBuilder("saveSelectedLanguage# "), this.mSelectedLanguage, DirectWriteSettingDialogFragment.TAG);
            if (DirectWriteSettingDialogFragment.this.getPresenter().getLanguage().equals(this.mSelectedLanguage)) {
                return;
            }
            DirectWriteSettingDialogFragment.this.getPresenter().setLanguage(this.mSelectedLanguage);
            DirectWriteSettingDialogFragment.this.getPresenter().updateLanguage(this.mSelectedLanguage);
        }

        public List<String> getAddableLanguageList() {
            ArrayList arrayList = new ArrayList();
            for (TextRecognitionLanguageDownloadHelper.LanguageInfo languageInfo : DirectWriteSettingDialogFragment.this.mLanguageDownloadHelper.getLanguageInfoList()) {
                if (!this.mLanguageList.contains(languageInfo.getLocale())) {
                    arrayList.add(languageInfo.getLocale());
                }
            }
            return arrayList;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            List<String> list = this.mLanguageList;
            if (list == null) {
                return 0;
            }
            return list.size();
        }

        public String getSelectedLanguage() {
            return this.mSelectedLanguage;
        }

        public void setDownloadLanguage(String str) {
            this.mDownloadLanguage = str;
        }

        public void setLanguageList(String str, List<String> list) {
            this.mSelectedLanguage = str;
            this.mLanguageList = list;
            this.mLanguageListForDisplay = DisplayLanguageUtils.getDisplayNamesFromLanguageCodes(list, getAddableLanguageList());
            notifyDataSetChanged();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
            viewHolder.mLocale = this.mLanguageList.get(i);
            viewHolder.mLanguageRadioButton.setText(this.mLanguageListForDisplay.get(i));
            viewHolder.mLanguageRadioButton.setChecked(this.mSelectedLanguage.equals(this.mLanguageList.get(i)));
            if (!this.mDownloadLanguage.equals(this.mLanguageList.get(i))) {
                viewHolder.setNormalLayout();
            } else if (this.mIsDownloading) {
                viewHolder.setDownloadingLayout(this.mDownloadingProgress);
            } else {
                viewHolder.setDownloadReadyLayout();
            }
            viewHolder.mPosition = i;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        @NonNull
        public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
            return new ViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(C9086R.layout.comp_dw_toolbar_language_item, viewGroup, false), new AdapterContract() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.dialog.DirectWriteSettingDialogFragment.RecognitionLanguageAdapter.1
                @Override // com.samsung.android.support.senl.nt.composer.main.base.view.dialog.DirectWriteSettingDialogFragment.AdapterContract
                public void onCancel(String str) {
                    RecognitionLanguageAdapter.this.notifyDataSetChanged();
                    RecognitionLanguageAdapter.this.mIsDownloading = false;
                }

                @Override // com.samsung.android.support.senl.nt.composer.main.base.view.dialog.DirectWriteSettingDialogFragment.AdapterContract
                public void onDownload(String str, DownloadListener downloadListener) {
                    RecognitionLanguageAdapter.this.mFragmentContract.onDownload(str, downloadListener);
                    RecognitionLanguageAdapter.this.mIsDownloading = true;
                }

                @Override // com.samsung.android.support.senl.nt.composer.main.base.view.dialog.DirectWriteSettingDialogFragment.AdapterContract
                public void onDownloadCancel(String str) {
                    RecognitionLanguageAdapter.this.mFragmentContract.onDownloadCancel(str);
                    RecognitionLanguageAdapter.this.mIsDownloading = false;
                }

                @Override // com.samsung.android.support.senl.nt.composer.main.base.view.dialog.DirectWriteSettingDialogFragment.AdapterContract
                public void onProgress(int i2, int i4) {
                    RecognitionLanguageAdapter.this.mDownloadingProgress = i4;
                    RecognitionLanguageAdapter.this.notifyItemChanged(i2);
                }

                @Override // com.samsung.android.support.senl.nt.composer.main.base.view.dialog.DirectWriteSettingDialogFragment.AdapterContract
                public void onSelectItem(int i2) {
                    RecognitionLanguageAdapter recognitionLanguageAdapter = RecognitionLanguageAdapter.this;
                    recognitionLanguageAdapter.mSelectedLanguage = (String) recognitionLanguageAdapter.mLanguageList.get(i2);
                    AbstractC8014b.m7213o(new StringBuilder("onClick(). selectedLanguage : "), RecognitionLanguageAdapter.this.mSelectedLanguage, DirectWriteSettingDialogFragment.TAG);
                    RecognitionLanguageAdapter.this.notifyDataSetChanged();
                }

                @Override // com.samsung.android.support.senl.nt.composer.main.base.view.dialog.DirectWriteSettingDialogFragment.AdapterContract
                public void onSuccess(String str) {
                    RecognitionLanguageAdapter recognitionLanguageAdapter = RecognitionLanguageAdapter.this;
                    recognitionLanguageAdapter.mSelectedLanguage = recognitionLanguageAdapter.mDownloadLanguage;
                    RecognitionLanguageAdapter.this.mDownloadLanguage = "";
                    RecognitionLanguageAdapter.this.mIsDownloading = false;
                    RecognitionLanguageAdapter.this.notifyDataSetChanged();
                    RecognitionLanguageAdapter.this.mFragmentContract.onDownloadSuccess(str);
                }
            });
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class ViewHolder extends RecyclerView.ViewHolder {
        AdapterContract mAdapterContract;
        View mCancelButton;
        View mDownloadButton;
        public DownloadResultCallback mDownloadResultCallback;
        Group mDownloadingGroup;
        RadioButton mLanguageRadioButton;
        String mLocale;
        int mPosition;
        ProgressBar mProgressBar;

        public ViewHolder(View view, AdapterContract adapterContract) {
            super(view);
            this.mDownloadResultCallback = new DownloadResultCallback() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.dialog.DirectWriteSettingDialogFragment.ViewHolder.1
                @Override // com.samsung.android.support.senl.nt.composer.main.base.view.dialog.DirectWriteSettingDialogFragment.DownloadResultCallback
                public void onCancelled(String str) {
                    ViewHolder.this.mAdapterContract.onCancel(str);
                }

                @Override // com.samsung.android.support.senl.nt.composer.main.base.view.dialog.DirectWriteSettingDialogFragment.DownloadResultCallback
                public void onFailed(String str) {
                    ViewHolder.this.mAdapterContract.onCancel(str);
                }

                @Override // com.samsung.android.support.senl.nt.composer.main.base.view.dialog.DirectWriteSettingDialogFragment.DownloadResultCallback
                public void onProgress(int i, int i2) {
                    ViewHolder viewHolder = ViewHolder.this;
                    viewHolder.mAdapterContract.onProgress(viewHolder.mPosition, i);
                }

                @Override // com.samsung.android.support.senl.nt.composer.main.base.view.dialog.DirectWriteSettingDialogFragment.DownloadResultCallback
                public void onSuccess(String str) {
                    ViewHolder.this.mAdapterContract.onSuccess(str);
                }
            };
            this.mAdapterContract = adapterContract;
            this.mLanguageRadioButton = (RadioButton) view.findViewById(C9086R.id.radio_item);
            this.mDownloadingGroup = (Group) view.findViewById(C9086R.id.downloading_group);
            this.mDownloadButton = view.findViewById(C9086R.id.download_button);
            this.mProgressBar = (ProgressBar) view.findViewById(C9086R.id.progress_bar);
            this.mCancelButton = view.findViewById(C9086R.id.cancel_button);
            final int i = 0;
            this.mDownloadButton.setOnClickListener(new View.OnClickListener(this) { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.dialog.h

                /* JADX INFO: renamed from: b */
                public final /* synthetic */ DirectWriteSettingDialogFragment.ViewHolder f7127b;

                {
                    this.f7127b = this;
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    switch (i) {
                        case 0:
                            this.f7127b.lambda$new$0(view2);
                            break;
                        case 1:
                            this.f7127b.lambda$new$1(view2);
                            break;
                        default:
                            this.f7127b.lambda$new$2(view2);
                            break;
                    }
                }
            });
            final int i2 = 1;
            this.mCancelButton.setOnClickListener(new View.OnClickListener(this) { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.dialog.h

                /* JADX INFO: renamed from: b */
                public final /* synthetic */ DirectWriteSettingDialogFragment.ViewHolder f7127b;

                {
                    this.f7127b = this;
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    switch (i2) {
                        case 0:
                            this.f7127b.lambda$new$0(view2);
                            break;
                        case 1:
                            this.f7127b.lambda$new$1(view2);
                            break;
                        default:
                            this.f7127b.lambda$new$2(view2);
                            break;
                    }
                }
            });
            final int i4 = 2;
            view.setOnClickListener(new View.OnClickListener(this) { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.dialog.h

                /* JADX INFO: renamed from: b */
                public final /* synthetic */ DirectWriteSettingDialogFragment.ViewHolder f7127b;

                {
                    this.f7127b = this;
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    switch (i4) {
                        case 0:
                            this.f7127b.lambda$new$0(view2);
                            break;
                        case 1:
                            this.f7127b.lambda$new$1(view2);
                            break;
                        default:
                            this.f7127b.lambda$new$2(view2);
                            break;
                    }
                }
            });
        }

        private void cancelDownload() {
            this.mAdapterContract.onDownloadCancel(this.mLocale);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$new$0(View view) {
            startDownload();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$new$1(View view) {
            cancelDownload();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$new$2(View view) {
            if (this.mLanguageRadioButton.isEnabled()) {
                this.mAdapterContract.onSelectItem(this.mPosition);
            }
        }

        private void startDownload() {
            setDownloadingLayout(0);
            AdapterContract adapterContract = this.mAdapterContract;
            String str = this.mLocale;
            adapterContract.onDownload(str, new DownloadListener(str, this.mDownloadResultCallback));
        }

        private void updateProgress(int i) {
            this.mLanguageRadioButton.setText(String.format(Locale.getDefault(), "%s (%d%%)", DisplayLanguageUtils.getDisplayLanguageSystem(this.mLocale), Integer.valueOf(i)));
            this.mProgressBar.setProgress(i);
        }

        public void setDownloadReadyLayout() {
            this.mDownloadingGroup.setVisibility(8);
            this.mDownloadButton.setVisibility(0);
            this.mLanguageRadioButton.setEnabled(false);
        }

        public void setDownloadingLayout(int i) {
            updateProgress(i);
            this.mDownloadingGroup.setVisibility(0);
            this.mDownloadButton.setVisibility(8);
            this.mLanguageRadioButton.setEnabled(false);
        }

        public void setNormalLayout() {
            this.mDownloadingGroup.setVisibility(8);
            this.mDownloadButton.setVisibility(8);
            this.mLanguageRadioButton.setEnabled(true);
        }
    }

    private void init() {
        this.mRecognitionLanguageAdapter = new RecognitionLanguageAdapter(new FragmentContract() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.dialog.DirectWriteSettingDialogFragment.1
            @Override // com.samsung.android.support.senl.nt.composer.main.base.view.dialog.DirectWriteSettingDialogFragment.FragmentContract
            public void onDownload(String str, DownloadListener downloadListener) {
                DirectWriteSettingDialogFragment.this.mLanguageDownloadHelper.download(str, downloadListener);
            }

            @Override // com.samsung.android.support.senl.nt.composer.main.base.view.dialog.DirectWriteSettingDialogFragment.FragmentContract
            public void onDownloadCancel(String str) {
                DirectWriteSettingDialogFragment.this.mLanguageDownloadHelper.cancelDownload(str);
            }

            @Override // com.samsung.android.support.senl.nt.composer.main.base.view.dialog.DirectWriteSettingDialogFragment.FragmentContract
            public void onDownloadSuccess(String str) {
                DirectWriteSettingDialogFragment.this.mCurrentLanguage = str;
                DirectWriteSettingDialogFragment.this.mDownloadRecommendLanguage = "";
                DirectWriteSettingDialogFragment.this.getPresenter().setLanguageMatching(true);
            }
        });
        this.mWindowFocusChangeListener = new ViewTreeObserverOnWindowFocusChangeListenerC10234d(this, 1);
    }

    private void initLanguageDownloadHelper(Context context) {
        if (this.mLanguageDownloadHelper == null) {
            TextRecognitionLanguageDownloadHelper textRecognitionLanguageDownloadHelper = new TextRecognitionLanguageDownloadHelper(context);
            this.mLanguageDownloadHelper = textRecognitionLanguageDownloadHelper;
            textRecognitionLanguageDownloadHelper.init(RequestToSyncManager.INSTANCE.isDataCallNotLimitedForApp());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$createAlertDialog$2(DialogInterface dialogInterface, int i) {
        if (!getPresenter().isLanguageMatched()) {
            getPresenter().setLanguageMatching(true);
        }
        this.mRecognitionLanguageAdapter.applySelectedLanguage();
        if (((RadioGroup) this.mView.findViewById(C9086R.id.insert_type)).getCheckedRadioButtonId() == C9086R.id.body_text) {
            this.mInsertType = 0;
        } else {
            this.mInsertType = 1;
        }
        getPresenter().setTextType(this.mInsertType);
        Logger.m11003i(TAG, "Saved insertType = " + this.mInsertType);
        dismissAllowingStateLoss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$init$3(boolean z) {
        if (z && getDialog() != null && getDialog().isShowing()) {
            updateLanguageList();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initLayoutToAddLanguage$0(Activity activity) {
        if (NoteListAccessHandler.getSettingsActivity() == null) {
            PostLaunchManager.getInstance().executeBaseLogic(1);
        }
        Intent intent = new Intent(getContext(), NoteListAccessHandler.getSettingsActivity());
        intent.putExtra(SettingsConstants.FRAGMENT_TYPE, 11);
        intent.putExtra(SettingsConstants.KEY_CALLEE, SettingsConstants.CALLEE_COMPOSER);
        PopOverActivityWrapper.startActivity(activity, intent, 5);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initLayoutToAddLanguage$1(View view) {
        FragmentActivity activity = getActivity();
        if (CommonUtil.isNotAvailableActivity(activity)) {
            return;
        }
        this.mPresenter.getWritingToolManager().getKeyguardPresenter().dismissKeyguard(getActivity(), new RunnableC10244n(this, activity, 1));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onResume$4() {
        updateDownloadRecommendLanguage();
        updateLanguageList();
        this.mView.findViewById(C9086R.id.add_language_layout).setVisibility(this.mLanguageDownloadHelper.canDownloadLanguage() ? 0 : 8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ int lambda$updateLanguageList$5(String str, String str2) {
        if (this.mCurrentLanguage.equals(str)) {
            return -1;
        }
        if (this.mCurrentLanguage.equals(str2)) {
            return 1;
        }
        return str.compareTo(str2);
    }

    private String normalize(String str) {
        return str.replaceAll(DirectWriteConstant.IGNORE_CASE_IN_LANGUAGE, " ");
    }

    private void updateDownloadRecommendLanguage() {
        if (getPresenter().getKeyboardLanguage() == null) {
            return;
        }
        String strNormalize = normalize(getPresenter().getKeyboardLanguage());
        for (TextRecognitionLanguageDownloadHelper.LanguageInfo languageInfo : this.mLanguageDownloadHelper.getLanguageInfoList()) {
            if (normalize(languageInfo.getLocale()).contains(strNormalize)) {
                this.mDownloadRecommendLanguage = languageInfo.getLocale();
                return;
            }
        }
    }

    private void updateLanguageList() {
        TextRecognitionLanguage textRecognitionLanguage = new TextRecognitionLanguage(getContext());
        textRecognitionLanguage.initTextRecognitionLanguage(false);
        List<String> languageListForTextRecognition = textRecognitionLanguage.getLanguageListForTextRecognition();
        if (languageListForTextRecognition.isEmpty()) {
            Logger.m10999d(TAG, "updateLanguageList(). language list is empty!!");
            return;
        }
        String str = TAG;
        Logger.m10999d(str, "updateLanguageList(). language list size : " + languageListForTextRecognition.size());
        if (TextUtils.isEmpty(this.mCurrentLanguage) || !languageListForTextRecognition.contains(this.mCurrentLanguage)) {
            if (languageListForTextRecognition.contains(DirectWriteConstant.DEFAULT_RECOGNITION_LANGUAGE)) {
                this.mCurrentLanguage = DirectWriteConstant.DEFAULT_RECOGNITION_LANGUAGE;
            } else {
                try {
                    this.mCurrentLanguage = textRecognitionLanguage.getFirstLanguageForTextRecognition();
                } catch (TextRecognitionLanguage.SupportedLanguageException e) {
                    Logger.m11000e(TAG, "updateLanguageList " + e.getMessage());
                    return;
                }
            }
            this.mPresenter.setLanguage(this.mCurrentLanguage);
            getPresenter().updateLanguage(this.mCurrentLanguage);
            AbstractC8014b.m7213o(new StringBuilder("updateLanguageList(). Mismatched, update language by default : "), this.mCurrentLanguage, str);
        }
        languageListForTextRecognition.sort(new C10235e(this, 1));
        if (!this.mDownloadRecommendLanguage.isEmpty()) {
            languageListForTextRecognition.add(0, this.mDownloadRecommendLanguage);
            this.mRecognitionLanguageAdapter.setDownloadLanguage(this.mDownloadRecommendLanguage);
        }
        String selectedLanguage = this.mRecognitionLanguageAdapter.getSelectedLanguage();
        if (TextUtils.isEmpty(selectedLanguage)) {
            selectedLanguage = this.mCurrentLanguage;
        }
        this.mRecognitionLanguageAdapter.setLanguageList(selectedLanguage, languageListForTextRecognition);
    }

    @NotNull
    public AlertDialog createAlertDialog() {
        AlertDialog alertDialogCreate = new AlertDialogBuilderForAppCompat(getContext()).create();
        alertDialogCreate.setTitle(C9086R.string.hw_toolbar_convert_select_language);
        alertDialogCreate.setView(this.mView);
        alertDialogCreate.setButton(-2, getString(C9086R.string.dialog_cancel), (DialogInterface.OnClickListener) null);
        alertDialogCreate.setButton(-1, getString(C9086R.string.dialog_done), new DialogInterfaceOnClickListenerC10231a(this, 1));
        return alertDialogCreate;
    }

    public DirectWriteSettingDialogPresenter getPresenter() {
        DialogContract.IFragmentPresenterContainer iFragmentPresenterContainer;
        if (this.mPresenter == null && getActivity() != null && (iFragmentPresenterContainer = (DialogContract.IFragmentPresenterContainer) getActivity().getSupportFragmentManager().findFragmentByTag("Composer")) != null) {
            this.mPresenter = (DirectWriteSettingDialogPresenter) iFragmentPresenterContainer.getDialogFragmentPresenter(12);
        }
        if (this.mPresenter == null) {
            Logger.m10999d(TAG, "getPresenter()# Presenter is null. dismiss call");
            dismiss();
        }
        return this.mPresenter;
    }

    public void initLayoutButtons() {
        RadioButton radioButton = (RadioButton) this.mView.findViewById(C9086R.id.body_text);
        RadioButton radioButton2 = (RadioButton) this.mView.findViewById(C9086R.id.text_box);
        int i = this.mInsertType;
        if (i == 0) {
            radioButton.setChecked(true);
        } else {
            if (i == 1) {
                radioButton2.setChecked(true);
                return;
            }
            radioButton.setChecked(true);
            AbstractC8014b.m7221w(new StringBuilder("unexpected insertType: "), TAG, this.mInsertType);
        }
    }

    public void initLayoutToAddLanguage() {
        this.mView.findViewById(C9086R.id.add_language_layout).setOnClickListener(new ViewOnClickListenerC10239i(this, 3));
    }

    @Override // androidx.fragment.app.DialogFragment
    @NonNull
    public Dialog onCreateDialog(Bundle bundle) {
        init();
        if (getPresenter() == null) {
            Logger.m10999d(TAG, "onCreateDialog()# Presenter is null. return null");
            return super.onCreateDialog(bundle);
        }
        if (bundle != null) {
            this.mCurrentLanguage = bundle.getString("mLanguage");
            this.mInsertType = bundle.getInt("mInsertType");
        } else {
            this.mCurrentLanguage = getPresenter().getLanguage();
            this.mInsertType = getPresenter().getTextType();
        }
        Logger.m10999d(TAG, "onCreateDialog(). mCurrentLanguage : " + this.mCurrentLanguage + ", mInsertType : " + this.mInsertType);
        View viewInflate = View.inflate(getContext(), C9086R.layout.comp_dw_toolbar_setting_dialog, null);
        this.mView = viewInflate;
        viewInflate.getViewTreeObserver().addOnWindowFocusChangeListener(this.mWindowFocusChangeListener);
        RecyclerView recyclerView = (RecyclerView) this.mView.findViewById(C9086R.id.language_recyclerview_layout);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(this.mRecognitionLanguageAdapter);
        initLanguageDownloadHelper(getContext());
        initLayoutToAddLanguage();
        initLayoutButtons();
        return createAlertDialog();
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        View view = this.mView;
        if (view != null) {
            if (this.mWindowFocusChangeListener != null) {
                view.getViewTreeObserver().removeOnWindowFocusChangeListener(this.mWindowFocusChangeListener);
                this.mWindowFocusChangeListener = null;
            }
            this.mView = null;
        }
        super.onDestroyView();
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.mLanguageDownloadHelper == null || getPresenter().isLanguageMatched()) {
            updateLanguageList();
        } else {
            this.mLanguageDownloadHelper.isInitFinished(new C10241k(this, 2));
        }
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onSaveInstanceState(@NonNull Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString("mLanguage", this.mRecognitionLanguageAdapter.getSelectedLanguage());
        bundle.putInt("mInsertType", this.mInsertType);
    }
}
