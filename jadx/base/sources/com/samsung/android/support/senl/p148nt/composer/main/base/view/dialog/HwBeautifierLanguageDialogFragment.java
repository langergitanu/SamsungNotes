package com.samsung.android.support.senl.p148nt.composer.main.base.view.dialog;

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
import android.widget.RadioButton;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.samsung.android.sdk.pen.recogengine.SpenRecognizerAILanguages;
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
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.dialog.HwBeautifierLanguageDialogPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.CommonUtil;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.model.collector.recognition.extractor.TextRecognitionLanguage;
import com.samsung.android.support.senl.p148nt.model.collector.recognition.extractor.TextRecognitionLanguageDownloadHelper;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class HwBeautifierLanguageDialogFragment extends DialogFragment {
    private static final String TAG = Logger.createTag("HwBeautifierLanguageDialogFragment");
    private String mCurrentLanguage;
    private boolean mIsCreated;
    private TextRecognitionLanguageDownloadHelper mLanguageDownloadHelper;
    private HwBeautifierLanguageDialogPresenter mPresenter;
    private RecognitionLanguageAdapter mRecognitionLanguageAdapter;
    private View mView;
    private ViewTreeObserver.OnWindowFocusChangeListener mWindowFocusChangeListener;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface AdapterContract {
        void onSelectItem(int i);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public class AddLanguageHolder extends RecyclerView.ViewHolder {

        /* JADX INFO: renamed from: a */
        public static final /* synthetic */ int f7111a = 0;

        public AddLanguageHolder(@NonNull View view) {
            super(view);
            view.setOnClickListener(new ViewOnClickListenerC10239i(this, 0));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$new$0(View view) {
            HwBeautifierLanguageDialogFragment.this.mPresenter.getWritingToolManager().getKeyguardPresenter().dismissKeyguard(HwBeautifierLanguageDialogFragment.this.getActivity(), new RunnableC10240j(HwBeautifierLanguageDialogFragment.this, 0));
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public class RecognitionLanguageAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
        private static final String ADD_LANGUAGE = "add language";
        private static final int TYPE_ADD_LANGUAGE = 1;
        private static final int TYPE_ITEM = 0;
        private List<String> mLanguageList;
        private List<String> mLanguageListForDisplay;
        private String mSelectedLanguage;

        public /* synthetic */ RecognitionLanguageAdapter(HwBeautifierLanguageDialogFragment hwBeautifierLanguageDialogFragment, int i) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onCreateViewHolder$0(int i) {
            this.mSelectedLanguage = this.mLanguageList.get(i);
            Logger.m10999d(HwBeautifierLanguageDialogFragment.TAG, "onClick(). selectedLanguage : " + this.mSelectedLanguage);
            notifyDataSetChanged();
        }

        public void applySelectedLanguage() {
            AbstractC8014b.m7213o(new StringBuilder("saveSelectedLanguage# "), this.mSelectedLanguage, HwBeautifierLanguageDialogFragment.TAG);
            if (this.mSelectedLanguage.equals(HwBeautifierLanguageDialogFragment.this.getPresenter().getLanguage())) {
                return;
            }
            HwBeautifierLanguageDialogFragment.this.getPresenter().setLanguage(this.mSelectedLanguage);
        }

        public List<String> getAddableLanguageList() {
            ArrayList arrayList = new ArrayList();
            for (TextRecognitionLanguageDownloadHelper.LanguageInfo languageInfo : HwBeautifierLanguageDialogFragment.this.mLanguageDownloadHelper.getLanguageInfoListForAiLanguage()) {
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

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemViewType(int i) {
            List<String> list = this.mLanguageList;
            return (list != null && i == list.size() - 1 && ADD_LANGUAGE.equals(this.mLanguageList.get(i))) ? 1 : 0;
        }

        public String getSelectedLanguage() {
            return this.mSelectedLanguage;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
            if (getItemViewType(i) == 1) {
                return;
            }
            ViewHolder viewHolder2 = (ViewHolder) viewHolder;
            viewHolder2.mLanguageRadioButton.setText(this.mLanguageListForDisplay.get(i));
            viewHolder2.mLanguageRadioButton.setChecked(this.mSelectedLanguage.equals(this.mLanguageList.get(i)));
            viewHolder2.mPosition = i;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        @NonNull
        public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
            return i == 1 ? HwBeautifierLanguageDialogFragment.this.new AddLanguageHolder(LayoutInflater.from(viewGroup.getContext()).inflate(C9086R.layout.comp_hw_toolbar_convert_add_language_item, viewGroup, false)) : new ViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(C9086R.layout.comp_hw_toolbar_convert_radio_item, viewGroup, false), new C10241k(this, 0));
        }

        public void setLanguageList(String str, List<String> list) {
            this.mSelectedLanguage = str;
            List<String> list2 = this.mLanguageList;
            boolean z = false;
            if (list2 != null) {
                if (list2.size() != list.size()) {
                    z = true;
                    break;
                }
                Iterator<String> it = list.iterator();
                while (it.hasNext()) {
                    if (!this.mLanguageList.contains(it.next())) {
                        z = true;
                        break;
                    }
                }
            }
            this.mLanguageList = list;
            this.mLanguageListForDisplay = DisplayLanguageUtils.getDisplayNamesFromLanguageCodes(list, getAddableLanguageList());
            if (HwBeautifierLanguageDialogFragment.this.mLanguageDownloadHelper.canDownloadLanguage(true)) {
                this.mLanguageList.add(ADD_LANGUAGE);
                this.mLanguageListForDisplay.add(ADD_LANGUAGE);
            }
            if (z) {
                notifyDataSetChanged();
            }
        }

        private RecognitionLanguageAdapter() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class ViewHolder extends RecyclerView.ViewHolder {
        AdapterContract mAdapterContract;
        RadioButton mLanguageRadioButton;
        int mPosition;

        public ViewHolder(View view, AdapterContract adapterContract) {
            super(view);
            this.mAdapterContract = adapterContract;
            this.mLanguageRadioButton = (RadioButton) view.findViewById(C9086R.id.radio_item);
            view.setOnClickListener(new ViewOnClickListenerC10239i(this, 1));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$new$0(View view) {
            if (this.mLanguageRadioButton.isEnabled()) {
                this.mAdapterContract.onSelectItem(this.mPosition);
            }
        }
    }

    private void init() {
        this.mRecognitionLanguageAdapter = new RecognitionLanguageAdapter(this, 0);
        this.mWindowFocusChangeListener = new ViewTreeObserverOnWindowFocusChangeListenerC10234d(this, 2);
    }

    private void initLanguageDownloadHelper(Context context) {
        if (this.mLanguageDownloadHelper == null) {
            TextRecognitionLanguageDownloadHelper textRecognitionLanguageDownloadHelper = new TextRecognitionLanguageDownloadHelper(context);
            this.mLanguageDownloadHelper = textRecognitionLanguageDownloadHelper;
            textRecognitionLanguageDownloadHelper.init(RequestToSyncManager.INSTANCE.isDataCallNotLimitedForApp());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$createAlertDialog$0(DialogInterface dialogInterface, int i) {
        this.mRecognitionLanguageAdapter.applySelectedLanguage();
        dismissAllowingStateLoss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$init$1(boolean z) {
        if (z && getDialog() != null && getDialog().isShowing()) {
            updateLanguageList();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$updateLanguageList$2(List list, String str) {
        return !list.contains(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ int lambda$updateLanguageList$3(String str, String str2) {
        if (this.mCurrentLanguage.equals(str)) {
            return -1;
        }
        if (this.mCurrentLanguage.equals(str2)) {
            return 1;
        }
        return str.compareTo(str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void openLanguageDownloader() {
        Logger.m10999d(TAG, "openLanguageDownloader#");
        FragmentActivity activity = getActivity();
        if (CommonUtil.isNotAvailableActivity(activity)) {
            return;
        }
        if (NoteListAccessHandler.getSettingsActivity() == null) {
            PostLaunchManager.getInstance().executeBaseLogic(1);
        }
        Intent intent = new Intent(getContext(), NoteListAccessHandler.getSettingsActivity());
        intent.putExtra(SettingsConstants.FRAGMENT_TYPE, 11);
        intent.putExtra(SettingsConstants.KEY_CALLEE, SettingsConstants.CALLEE_COMPOSER);
        intent.putExtra(SettingsConstants.KEY_LANGUAGE_LIST_FILTER, SettingsConstants.LANGUAGE_LIST_FILTER_TYPE_TRANSLATION);
        PopOverActivityWrapper.startActivity(activity, intent, 5);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateLanguageList() {
        TextRecognitionLanguage textRecognitionLanguage = new TextRecognitionLanguage(getContext());
        textRecognitionLanguage.initTextRecognitionLanguage(false);
        List<String> languageListForTextRecognition = textRecognitionLanguage.getLanguageListForTextRecognition();
        if (languageListForTextRecognition.isEmpty()) {
            Logger.m10999d(TAG, "updateLanguageList(). language list is empty!!");
            return;
        }
        if (this.mLanguageDownloadHelper != null) {
            languageListForTextRecognition.removeIf(new C10233c(SpenRecognizerAILanguages.getAvailableLanguages(), 1));
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
                    Logger.m11000e(TAG, "updateLanguageList " + e);
                    return;
                }
            }
            this.mPresenter.setLanguage(this.mCurrentLanguage);
            AbstractC8014b.m7213o(new StringBuilder("updateLanguageList(). Mismatched, update language by default : "), this.mCurrentLanguage, str);
        }
        languageListForTextRecognition.sort(new C10235e(this, 2));
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
        alertDialogCreate.setButton(-1, getString(C9086R.string.dialog_done), new DialogInterfaceOnClickListenerC10231a(this, 2));
        return alertDialogCreate;
    }

    public HwBeautifierLanguageDialogPresenter getPresenter() {
        DialogContract.IFragmentPresenterContainer iFragmentPresenterContainer;
        if (this.mPresenter == null && getActivity() != null && (iFragmentPresenterContainer = (DialogContract.IFragmentPresenterContainer) getActivity().getSupportFragmentManager().findFragmentByTag("Composer")) != null) {
            this.mPresenter = (HwBeautifierLanguageDialogPresenter) iFragmentPresenterContainer.getDialogFragmentPresenter(15);
        }
        if (this.mPresenter == null) {
            Logger.m10999d(TAG, "getPresenter()# Presenter is null. dismiss call");
            dismiss();
        }
        return this.mPresenter;
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
        } else {
            this.mCurrentLanguage = getPresenter().getLanguage();
            this.mIsCreated = true;
        }
        Logger.m10999d(TAG, "onCreateDialog(). mCurrentLanguage : " + this.mCurrentLanguage);
        View viewInflate = View.inflate(getContext(), C9086R.layout.comp_hw_toolbar_beautifier_language_setting, null);
        this.mView = viewInflate;
        viewInflate.getViewTreeObserver().addOnWindowFocusChangeListener(this.mWindowFocusChangeListener);
        RecyclerView recyclerView = (RecyclerView) this.mView.findViewById(C9086R.id.language_recyclerview_layout);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(this.mRecognitionLanguageAdapter);
        initLanguageDownloadHelper(getContext());
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
        if (!this.mIsCreated) {
            Logger.m11003i(TAG, "onResume# mIsCreated false");
            dismissAllowingStateLoss();
            return;
        }
        TextRecognitionLanguageDownloadHelper textRecognitionLanguageDownloadHelper = this.mLanguageDownloadHelper;
        if (textRecognitionLanguageDownloadHelper != null) {
            textRecognitionLanguageDownloadHelper.isInitFinished(new C10241k(this, 3));
        } else {
            updateLanguageList();
        }
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onSaveInstanceState(@NonNull Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString("mLanguage", this.mRecognitionLanguageAdapter.getSelectedLanguage());
    }
}
