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
import android.widget.RadioGroup;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.samsung.android.sdk.pen.recogengine.SpenRecognizerAILanguages;
import com.samsung.android.sdk.pen.setting.patternpalette.ViewOnClickListenerC7602a;
import com.samsung.android.support.senl.p145cm.base.common.postprocessing.PostLaunchManager;
import com.samsung.android.support.senl.p145cm.base.common.util.ResourceUtils;
import com.samsung.android.support.senl.p145cm.base.framework.content.SharedPreferencesCompat;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.base.common.access.notelist.NoteListAccessHandler;
import com.samsung.android.support.senl.p148nt.base.common.constants.SettingsConstants;
import com.samsung.android.support.senl.p148nt.base.common.sync.RequestToSyncManager;
import com.samsung.android.support.senl.p148nt.base.common.util.DisplayLanguageUtils;
import com.samsung.android.support.senl.p148nt.base.winset.app.popover.PopOverActivityWrapper;
import com.samsung.android.support.senl.p148nt.base.winset.builder.AlertDialogBuilderForAppCompat;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.dialog.ConvertSettingDialogPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.dialog.DialogContract;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.CommonUtil;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.p156sa.ComposerSA;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.p156sa.ComposerSAConstants;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.dialog.ConvertSettingDialogFragment;
import com.samsung.android.support.senl.p148nt.model.collector.recognition.extractor.TextRecognitionLanguage;
import com.samsung.android.support.senl.p148nt.model.collector.recognition.extractor.TextRecognitionLanguageDownloadHelper;
import java.util.ArrayList;
import java.util.List;
import p039I2.DialogInterfaceOnClickListenerC0140a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class ConvertSettingDialogFragment extends DialogFragment {
    private static final String TAG = Logger.createTag("ConvertSettingDialogFragment");
    private String mCurrentLanguage;
    private int mInsertType;
    private boolean mIsCreated;
    private TextRecognitionLanguageDownloadHelper mLanguageDownloadHelper;
    private List<String> mLanguageList;
    private ConvertSettingDialogPresenter mPresenter;
    private RecognitionLanguageAdapter mRecognitionLanguageAdapter;
    private TextRecognitionLanguage mTextRecognitionLanguage;
    private View mView;
    private ViewTreeObserver.OnWindowFocusChangeListener mWindowFocusChangeListener;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class AddLanguageHolder extends RecyclerView.ViewHolder {
        public AddLanguageHolder(@NonNull View view) {
            super(view);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public class RecognitionLanguageAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
        private static final String ADD_LANGUAGE = "add language";
        private static final int TYPE_ADD_LANGUAGE = 1;
        private static final int TYPE_ITEM = 0;
        private final boolean mHasAddLanguage;
        private List<String> mLanguageList;
        private List<String> mLanguageListForDisplay;
        private String mSelectedLanguage;

        public RecognitionLanguageAdapter(boolean z) {
            this.mHasAddLanguage = z;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onBindViewHolder$0(View view) {
            Logger.m10999d(ConvertSettingDialogFragment.TAG, "onClick# add language");
            if (ConvertSettingDialogFragment.this.getPresenter() != null) {
                ConvertSettingDialogFragment.this.getPresenter().getWritingToolManager().getKeyguardPresenter().dismissKeyguard(ConvertSettingDialogFragment.this.getActivity(), new RunnableC10232b(ConvertSettingDialogFragment.this, 1));
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onBindViewHolder$1(View view) {
            this.mSelectedLanguage = this.mLanguageList.get(((Integer) view.getTag()).intValue());
            Logger.m10999d(ConvertSettingDialogFragment.TAG, "onClick(). selectedLanguage : " + this.mSelectedLanguage);
            notifyDataSetChanged();
            ComposerSA.insertLog(ComposerSAConstants.SCREEN_DIALOGS_TEXT_RECOGNITION, ComposerSAConstants.EVENT_DIALOGS_TEXT_RECOGNITION_SELECT_LANGUAGE);
        }

        public List<String> getAddableLanguageList() {
            ArrayList arrayList = new ArrayList();
            for (TextRecognitionLanguageDownloadHelper.LanguageInfo languageInfo : ConvertSettingDialogFragment.this.mLanguageDownloadHelper.getLanguageInfoList()) {
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
            List<String> list;
            return (this.mHasAddLanguage && (list = this.mLanguageList) != null && i == list.size() - 1 && ADD_LANGUAGE.equals(this.mLanguageList.get(i))) ? 1 : 0;
        }

        public String getSelectedLanguage() {
            return this.mSelectedLanguage;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
            if (getItemViewType(i) == 1) {
                final int i2 = 0;
                viewHolder.itemView.setOnClickListener(new View.OnClickListener(this) { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.dialog.g

                    /* JADX INFO: renamed from: b */
                    public final /* synthetic */ ConvertSettingDialogFragment.RecognitionLanguageAdapter f7125b;

                    {
                        this.f7125b = this;
                    }

                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        switch (i2) {
                            case 0:
                                this.f7125b.lambda$onBindViewHolder$0(view);
                                break;
                            default:
                                this.f7125b.lambda$onBindViewHolder$1(view);
                                break;
                        }
                    }
                });
                return;
            }
            ViewHolder viewHolder2 = (ViewHolder) viewHolder;
            viewHolder2.mSavedTypeButton.setText(this.mLanguageListForDisplay.get(i));
            viewHolder2.mSavedTypeButton.setChecked(this.mSelectedLanguage.equals(this.mLanguageList.get(i)));
            viewHolder.itemView.setTag(Integer.valueOf(i));
            final int i4 = 1;
            viewHolder.itemView.setOnClickListener(new View.OnClickListener(this) { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.dialog.g

                /* JADX INFO: renamed from: b */
                public final /* synthetic */ ConvertSettingDialogFragment.RecognitionLanguageAdapter f7125b;

                {
                    this.f7125b = this;
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    switch (i4) {
                        case 0:
                            this.f7125b.lambda$onBindViewHolder$0(view);
                            break;
                        default:
                            this.f7125b.lambda$onBindViewHolder$1(view);
                            break;
                    }
                }
            });
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        @NonNull
        public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
            return i == 1 ? new AddLanguageHolder(LayoutInflater.from(viewGroup.getContext()).inflate(C9086R.layout.comp_hw_toolbar_convert_add_language_item, viewGroup, false)) : new ViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(C9086R.layout.comp_hw_toolbar_convert_radio_item, viewGroup, false));
        }

        public void saveSelectedLanguage() {
            Logger.m10999d(ConvertSettingDialogFragment.TAG, "saveSelectedLanguage# " + this.mSelectedLanguage);
            SharedPreferencesCompat.getInstance("Settings").putString(SettingsConstants.SETTINGS_HANDWRITING_CONVERT_TO_TEXT_LANGUAGE, this.mSelectedLanguage);
            ConvertSettingDialogFragment.this.getPresenter().updateLanguage(this.mSelectedLanguage);
        }

        public void setLanguageList(String str, List<String> list) {
            this.mSelectedLanguage = str;
            ArrayList arrayList = new ArrayList(list);
            this.mLanguageList = arrayList;
            this.mLanguageListForDisplay = DisplayLanguageUtils.getDisplayNamesFromLanguageCodes(arrayList, getAddableLanguageList());
            if (this.mHasAddLanguage) {
                if (ConvertSettingDialogFragment.this.mLanguageDownloadHelper.canDownloadLanguage(ConvertSettingDialogFragment.this.getPresenter() != null && ConvertSettingDialogFragment.this.getPresenter().isFilteredByTranslationLanguageList())) {
                    this.mLanguageList.add(ADD_LANGUAGE);
                }
            }
            notifyDataSetChanged();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class ViewHolder extends RecyclerView.ViewHolder {
        RadioButton mSavedTypeButton;

        public ViewHolder(View view) {
            super(view);
            this.mSavedTypeButton = (RadioButton) view.findViewById(C9086R.id.radio_item);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addLanguage() {
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
        if (getPresenter() != null && getPresenter().isFilteredByTranslationLanguageList()) {
            intent.putExtra(SettingsConstants.KEY_LANGUAGE_LIST_FILTER, SettingsConstants.LANGUAGE_LIST_FILTER_TYPE_TRANSLATION);
        }
        PopOverActivityWrapper.startActivity(activity, intent, 5);
        ComposerSA.insertLog(ComposerSAConstants.SCREEN_DIALOGS_TEXT_RECOGNITION, ComposerSAConstants.EVENT_DIALOGS_TEXT_RECOGNITION_ADD_LANGUAGE);
    }

    private void init(boolean z) {
        this.mRecognitionLanguageAdapter = new RecognitionLanguageAdapter(z);
        initLanguage(getContext());
        this.mWindowFocusChangeListener = new ViewTreeObserverOnWindowFocusChangeListenerC10234d(this, 0);
    }

    private void initDoneButton(AlertDialog alertDialog, final boolean z) {
        alertDialog.setButton(-1, getString(C9086R.string.dialog_done), new DialogInterface.OnClickListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.dialog.f
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                this.f7122a.lambda$initDoneButton$8(z, dialogInterface, i);
            }
        });
    }

    private void initInsertType(boolean z) {
        if (z) {
            this.mView.findViewById(C9086R.id.insert_type_label).setVisibility(8);
            ((RadioGroup) this.mView.findViewById(C9086R.id.insert_type)).setVisibility(8);
            return;
        }
        RadioButton radioButton = (RadioButton) this.mView.findViewById(C9086R.id.body_text);
        radioButton.setOnClickListener(new ViewOnClickListenerC7602a(5));
        RadioButton radioButton2 = (RadioButton) this.mView.findViewById(C9086R.id.text_box);
        radioButton2.setOnClickListener(new ViewOnClickListenerC7602a(6));
        int i = this.mInsertType;
        if (i == 0) {
            radioButton2.setChecked(true);
        } else {
            if (i == 1) {
                radioButton.setChecked(true);
                return;
            }
            radioButton2.setChecked(true);
            AbstractC8014b.m7221w(new StringBuilder("unexpected insertType: "), TAG, this.mInsertType);
        }
    }

    private void initLanguage(Context context) {
        if (this.mTextRecognitionLanguage == null) {
            this.mTextRecognitionLanguage = new TextRecognitionLanguage(context);
        }
        if (this.mLanguageDownloadHelper == null) {
            TextRecognitionLanguageDownloadHelper textRecognitionLanguageDownloadHelper = new TextRecognitionLanguageDownloadHelper(context);
            this.mLanguageDownloadHelper = textRecognitionLanguageDownloadHelper;
            textRecognitionLanguageDownloadHelper.init(RequestToSyncManager.INSTANCE.isDataCallNotLimitedForApp());
        }
        updateLanguageList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$init$2(boolean z) {
        if (z && getDialog() != null && getDialog().isShowing()) {
            updateLayout();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initDoneButton$8(boolean z, DialogInterface dialogInterface, int i) {
        this.mRecognitionLanguageAdapter.saveSelectedLanguage();
        if (!z) {
            if (((RadioGroup) this.mView.findViewById(C9086R.id.insert_type)).getCheckedRadioButtonId() == C9086R.id.body_text) {
                this.mInsertType = 1;
            } else {
                this.mInsertType = 0;
            }
            SharedPreferencesCompat.getInstance("Settings").putInt(SettingsConstants.SETTINGS_HANDWRITING_RECOGNITION_INSERT_TYPE, this.mInsertType);
            AbstractC8014b.m7195A(new StringBuilder("Saved insertType = "), TAG, this.mInsertType);
        }
        dismissAllowingStateLoss();
        ComposerSA.insertLog(ComposerSAConstants.SCREEN_DIALOGS_TEXT_RECOGNITION, ComposerSAConstants.EVENT_DIALOGS_TEXT_RECOGNITION_DONE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ int lambda$loadLanguageList$4(String str, String str2) {
        if (this.mCurrentLanguage.equals(str)) {
            return -1;
        }
        if (this.mCurrentLanguage.equals(str2)) {
            return 1;
        }
        return str.compareTo(str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreateDialog$0(View view) {
        if (getPresenter() != null) {
            getPresenter().getWritingToolManager().getKeyguardPresenter().dismissKeyguard(getActivity(), new RunnableC10232b(this, 0));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$updateLanguageList$3(List list, String str) {
        return !list.contains(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$updateLayout$5() {
        updateLanguageList();
        if (getPresenter() == null || getPresenter().isBodyTextOnly()) {
            return;
        }
        this.mView.findViewById(C9086R.id.add_language_layout).setVisibility(this.mLanguageDownloadHelper.canDownloadLanguage(getPresenter() != null && getPresenter().isFilteredByTranslationLanguageList()) ? 0 : 8);
    }

    private void loadLanguageList() {
        this.mTextRecognitionLanguage.initTextRecognitionLanguage(false);
        List<String> languageListForTextRecognition = this.mTextRecognitionLanguage.getLanguageListForTextRecognition();
        this.mLanguageList = languageListForTextRecognition;
        if (languageListForTextRecognition == null || languageListForTextRecognition.isEmpty()) {
            Logger.m10999d(TAG, "loadLanguageList# language list is empty!!");
            return;
        }
        String str = TAG;
        Logger.m10999d(str, "loadLanguageList# language list size : " + this.mLanguageList.size());
        if (TextUtils.isEmpty(this.mCurrentLanguage) || !this.mLanguageList.contains(this.mCurrentLanguage)) {
            try {
                this.mCurrentLanguage = this.mTextRecognitionLanguage.getFirstLanguageForTextRecognition();
                Logger.m10999d(str, "loadLanguageList# update current language : " + this.mCurrentLanguage);
                SharedPreferencesCompat.getInstance("Settings").putString(SettingsConstants.SETTINGS_HANDWRITING_CONVERT_TO_TEXT_LANGUAGE, this.mCurrentLanguage);
            } catch (TextRecognitionLanguage.SupportedLanguageException e) {
                Logger.m11000e(TAG, "loadLanguageList# e : " + e.getMessage());
                return;
            }
        }
        this.mLanguageList.sort(new C10235e(this, 0));
    }

    private void updateLanguageList() {
        loadLanguageList();
        List<String> list = this.mLanguageList;
        if (list == null || list.isEmpty()) {
            return;
        }
        String selectedLanguage = this.mRecognitionLanguageAdapter.getSelectedLanguage();
        if (TextUtils.isEmpty(selectedLanguage)) {
            selectedLanguage = this.mCurrentLanguage;
        }
        if (getPresenter() != null && getPresenter().isFilteredByTranslationLanguageList()) {
            this.mLanguageList.removeIf(new C10233c(SpenRecognizerAILanguages.getAvailableLanguages(), 0));
        }
        this.mRecognitionLanguageAdapter.setLanguageList(selectedLanguage, this.mLanguageList);
    }

    private void updateLayout() {
        TextRecognitionLanguageDownloadHelper textRecognitionLanguageDownloadHelper = this.mLanguageDownloadHelper;
        if (textRecognitionLanguageDownloadHelper != null) {
            textRecognitionLanguageDownloadHelper.isInitFinished(new C10241k(this, 1));
        } else {
            updateLanguageList();
        }
    }

    public ConvertSettingDialogPresenter getPresenter() {
        DialogContract.IFragmentPresenterContainer iFragmentPresenterContainer;
        if (this.mPresenter == null && getActivity() != null && (iFragmentPresenterContainer = (DialogContract.IFragmentPresenterContainer) getActivity().getSupportFragmentManager().findFragmentByTag("Composer")) != null) {
            this.mPresenter = (ConvertSettingDialogPresenter) iFragmentPresenterContainer.getDialogFragmentPresenter(2);
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
        if (bundle != null) {
            this.mCurrentLanguage = bundle.getString("mLanguage");
            this.mInsertType = bundle.getInt("mInsertType");
        } else {
            this.mIsCreated = true;
            this.mCurrentLanguage = SharedPreferencesCompat.getInstance("Settings").getString(SettingsConstants.SETTINGS_HANDWRITING_CONVERT_TO_TEXT_LANGUAGE, null);
            this.mInsertType = SharedPreferencesCompat.getInstance("Settings").getInt(SettingsConstants.SETTINGS_HANDWRITING_RECOGNITION_INSERT_TYPE, 0);
        }
        boolean zIsBodyTextOnly = getPresenter() != null ? getPresenter().isBodyTextOnly() : false;
        if (zIsBodyTextOnly) {
            this.mInsertType = 1;
        }
        init(zIsBodyTextOnly);
        Logger.m10999d(TAG, "onCreateDialog(). mCurrentLanguage : " + this.mCurrentLanguage + ", mInsertType : " + this.mInsertType + ", isBodyTextOnly : " + zIsBodyTextOnly);
        View viewInflate = View.inflate(getContext(), C9086R.layout.comp_hw_toolbar_convert_setting, null);
        this.mView = viewInflate;
        viewInflate.getViewTreeObserver().addOnWindowFocusChangeListener(this.mWindowFocusChangeListener);
        RecyclerView recyclerView = (RecyclerView) this.mView.findViewById(C9086R.id.language_recyclerview_layout);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(this.mRecognitionLanguageAdapter);
        View viewFindViewById = this.mView.findViewById(C9086R.id.add_language_layout);
        if (zIsBodyTextOnly) {
            View viewFindViewById2 = this.mView.findViewById(C9086R.id.language_recyclerview_container);
            viewFindViewById2.setPadding(viewFindViewById2.getPaddingLeft(), viewFindViewById2.getPaddingTop(), viewFindViewById2.getPaddingRight(), (int) ResourceUtils.convertDpToPixel(this.mView.getContext(), 16.0f));
            viewFindViewById.setVisibility(8);
        } else {
            viewFindViewById.setOnClickListener(new ViewOnClickListenerC10239i(this, 2));
        }
        initInsertType(zIsBodyTextOnly);
        AlertDialog alertDialogCreate = new AlertDialogBuilderForAppCompat(getContext()).create();
        alertDialogCreate.setTitle(C9086R.string.hw_toolbar_convert_select_language);
        alertDialogCreate.setView(this.mView);
        alertDialogCreate.setButton(-2, getString(C9086R.string.dialog_cancel), new DialogInterfaceOnClickListenerC0140a(18));
        initDoneButton(alertDialogCreate, zIsBodyTextOnly);
        return alertDialogCreate;
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
        TextRecognitionLanguageDownloadHelper textRecognitionLanguageDownloadHelper = this.mLanguageDownloadHelper;
        if (textRecognitionLanguageDownloadHelper != null) {
            textRecognitionLanguageDownloadHelper.close();
            this.mLanguageDownloadHelper = null;
        }
        super.onDestroyView();
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        if (getPresenter() == null) {
            return;
        }
        if (this.mIsCreated) {
            updateLayout();
        } else {
            Logger.m11003i(TAG, "onResume# mIsCreated false");
            dismissAllowingStateLoss();
        }
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onSaveInstanceState(@NonNull Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString("mLanguage", this.mRecognitionLanguageAdapter.getSelectedLanguage());
        bundle.putInt("mInsertType", this.mInsertType);
    }
}
