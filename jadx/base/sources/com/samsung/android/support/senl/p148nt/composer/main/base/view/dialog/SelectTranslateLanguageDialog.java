package com.samsung.android.support.senl.p148nt.composer.main.base.view.dialog;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.ActivityNotFoundException;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.samsung.android.app.sdk.deepsky.textextraction.languagepack.LangPackConfigConstants;
import com.samsung.android.support.senl.p145cm.base.common.util.ResourceUtils;
import com.samsung.android.support.senl.p145cm.base.framework.content.SharedPreferencesCompat;
import com.samsung.android.support.senl.p145cm.base.framework.view.InputMethodCompat;
import com.samsung.android.support.senl.p145cm.base.framework.view.WindowManagerCompat;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.base.common.constants.SettingsConstants;
import com.samsung.android.support.senl.p148nt.base.common.displaydata.ContentUtils;
import com.samsung.android.support.senl.p148nt.base.common.util.ButtonBackgroundUtils;
import com.samsung.android.support.senl.p148nt.base.winset.accessibility.VoiceAssistAsButton;
import com.samsung.android.support.senl.p148nt.base.winset.app.language.AiLanguageHelper;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class SelectTranslateLanguageDialog extends DialogFragment {
    public static final int RECENT_MAX_COUNT = 5;
    public static final String TAG = Logger.createTag("SelectTranslateLanguageDialog");
    private SelectTranslateLanguageAdapter mAdapter;
    private Contract mContract;
    private AlertDialog mDialog;
    private LinearLayout mItemMoreLanguageLayout;
    private List<AiLanguageHelper.Language> mLanguageList;
    private List<AiLanguageHelper.Language> mRecentList;
    private LinearLayout mSelectLanguageCancelButton;
    private TextView mSelectLanguageCancelTextView;
    private RecyclerView mSelectLanguageRecyclerView;
    private LinearLayout mSelectLanguageTranscribeButton;
    private TextView mSelectLanguageTranscribeTextView;
    private AiLanguageHelper.Language mSelectedLanguage;
    private Locale mSelectedLocale;
    private FrameLayout mSelectLanguageView = null;
    private BroadcastReceiver mAddBroadcastReceiver = null;
    private BroadcastReceiver mRemoveBroadcastReceiver = null;
    private boolean mIsFrom = false;
    private boolean mIsDisableTranslateStatus = false;
    private float mCenterX = 0.0f;
    private float mPosY = 0.0f;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface Contract {
        default void onAddLanguagesClick() {
        }

        void onCancel(boolean z);

        void setSelectedLocale(Locale locale);
    }

    private void addDivider() {
        this.mLanguageList.add(this.mRecentList.size(), new AiLanguageHelper.Language(false));
    }

    private void addRecentUsedList(String str) {
        if (this.mRecentList == null) {
            this.mRecentList = new ArrayList();
        }
        AiLanguageHelper.Language language = new AiLanguageHelper.Language(AiLanguageHelper.getLocale(str));
        if (this.mRecentList.contains(language)) {
            this.mRecentList.remove(language);
        }
        this.mRecentList.add(0, language);
        int size = this.mRecentList.size();
        HashSet hashSet = new HashSet();
        for (int i = 0; i < Math.min(5, size); i++) {
            hashSet.add(this.mRecentList.get(i).getLocale().toLanguageTag() + ContentUtils.HASH_SYMBOL + i);
        }
        Logger.m11003i(TAG, "addRecentUsedList: mRecentList size = " + hashSet.size() + " " + str);
        SharedPreferencesCompat.getInstance("Settings").putStringSet(this.mIsFrom ? SettingsConstants.RECENT_USED_FROM : SettingsConstants.RECENT_USED_TO, hashSet);
    }

    private void checkSelectedLanguage() {
        Locale locale;
        AiLanguageHelper.Language language = null;
        for (AiLanguageHelper.Language language2 : this.mLanguageList) {
            if (language2 != null && language2.getLocale() != null) {
                if (language2.equals(this.mSelectedLanguage)) {
                    return;
                }
                if ("en".equals(language2.getLocale().getLanguage()) || ((LangPackConfigConstants.LANGUAGE_CODE_ES.equals(language2.getLocale().getLanguage()) && (language == null || language.getLocale() == null || !"en".equals(language.getLocale().getLanguage()))) || language == null)) {
                    language = language2;
                }
            }
        }
        if (language != null) {
            this.mSelectedLanguage = language;
        } else {
            if (getActivity() == null || (locale = AiLanguageHelper.getLocale("es-ES")) == null) {
                return;
            }
            AiLanguageHelper.requestDownloadLanguagePack(getActivity(), locale);
        }
    }

    private int getAdjustY() {
        if (WindowManagerCompat.getInstance().getMultiWindowMode(getActivity().getResources().getConfiguration()) == 0) {
            return 0;
        }
        int navigationBarHeight = InputMethodCompat.getInstance().getNavigationBarHeight(getActivity().getApplicationContext());
        AbstractC0000a.m3D(navigationBarHeight, "getAdjustY# +NavigationBarHeight : ", TAG);
        return navigationBarHeight;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreateDialog$0(View view) {
        dismissAllowingStateLoss();
        Contract contract = this.mContract;
        if (contract != null) {
            contract.onCancel(this.mIsDisableTranslateStatus);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreateDialog$1(View view) {
        onMoreLanguageClick();
        this.mContract.onAddLanguagesClick();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreateDialog$2(View view) {
        AbstractC8014b.m7222x(new StringBuilder("click TranscribeButton# "), this.mIsDisableTranslateStatus, TAG);
        if (this.mIsDisableTranslateStatus) {
            return;
        }
        if (this.mContract == null || this.mAdapter.getSelectedLanguage() == null) {
            dismissAllowingStateLoss();
            return;
        }
        String languageTag = this.mAdapter.getSelectedLanguage().getLocale().toLanguageTag();
        this.mContract.setSelectedLocale(AiLanguageHelper.getLocale(languageTag));
        addRecentUsedList(languageTag);
        dismissAllowingStateLoss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreateDialog$3(Window window, DialogInterface dialogInterface) {
        LinearLayout linearLayout = this.mSelectLanguageTranscribeButton;
        if (linearLayout != null) {
            linearLayout.setOnClickListener(new ViewOnClickListenerC10245o(this, 0));
            if (window == null || this.mPosY == 0.0f) {
                return;
            }
            window.getDecorView().measure(0, 0);
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.x = (int) this.mCenterX;
            attributes.y = (((int) this.mPosY) - window.getDecorView().getMeasuredHeight()) + ((int) ResourceUtils.convertDpToPixel(window.getContext(), 6.0f)) + getAdjustY();
            Logger.m10999d(TAG, "onShow# params x : " + attributes.x + ", y : " + attributes.y);
            window.setAttributes(attributes);
            window.getDecorView().setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void refreshList() {
        if (this.mDialog == null || getActivity() == null) {
            return;
        }
        AiLanguageHelper.initTranslateConfig(new Runnable() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.dialog.SelectTranslateLanguageDialog.2
            @Override // java.lang.Runnable
            public void run() {
                if (SelectTranslateLanguageDialog.this.mDialog == null || SelectTranslateLanguageDialog.this.getActivity() == null) {
                    return;
                }
                SelectTranslateLanguageDialog.this.updateLanguageList();
                SelectTranslateLanguageDialog selectTranslateLanguageDialog = SelectTranslateLanguageDialog.this;
                selectTranslateLanguageDialog.mAdapter = new SelectTranslateLanguageAdapter(selectTranslateLanguageDialog.getActivity(), SelectTranslateLanguageDialog.this.mLanguageList, SelectTranslateLanguageDialog.this.mSelectedLanguage);
                SelectTranslateLanguageDialog.this.mSelectLanguageRecyclerView.setAdapter(SelectTranslateLanguageDialog.this.mAdapter);
            }
        });
    }

    private void setBroadcastReceiver() {
        this.mAddBroadcastReceiver = AiLanguageHelper.registerLanguagePackAddedReceiver(getActivity().getApplicationContext(), new AiLanguageHelper.LanguagePackAddedReceiver() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.dialog.SelectTranslateLanguageDialog.3
            @Override // com.samsung.android.support.senl.nt.base.winset.app.language.AiLanguageHelper.LanguagePackAddedReceiver, android.content.BroadcastReceiver
            public void onReceive(Context context, Intent intent) {
                if (context == null || intent == null || SelectTranslateLanguageDialog.this.mDialog == null) {
                    Logger.m10999d(SelectTranslateLanguageDialog.TAG, "LanguagePackAddedReceiver received but null");
                    return;
                }
                Logger.m10999d(SelectTranslateLanguageDialog.TAG, "LanguagePackAddedReceiver received" + intent.getStringExtra("locale"));
                SelectTranslateLanguageDialog.this.refreshList();
            }
        });
        this.mRemoveBroadcastReceiver = AiLanguageHelper.registerLanguagePackRemovedReceiver(getActivity().getApplicationContext(), new AiLanguageHelper.LanguagePackRemovedReceiver() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.dialog.SelectTranslateLanguageDialog.4
            @Override // com.samsung.android.support.senl.nt.base.winset.app.language.AiLanguageHelper.LanguagePackRemovedReceiver, android.content.BroadcastReceiver
            public void onReceive(Context context, Intent intent) {
                if (context == null || intent == null || SelectTranslateLanguageDialog.this.mDialog == null) {
                    Logger.m10999d(SelectTranslateLanguageDialog.TAG, "LanguagePackRemovedReceiver received but null");
                    return;
                }
                Logger.m10999d(SelectTranslateLanguageDialog.TAG, "LanguagePackRemovedReceiver received" + intent.getStringExtra("locale"));
                SelectTranslateLanguageDialog.this.refreshList();
            }
        });
    }

    private void setButtonStyle(View view) {
        if (view == null) {
            return;
        }
        view.setAccessibilityDelegate(new VoiceAssistAsButton());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateLanguageList() {
        List<AiLanguageHelper.Language> sourceLanguageList = AiLanguageHelper.getSourceLanguageList();
        this.mLanguageList = sourceLanguageList;
        Collections.sort(sourceLanguageList);
        Logger.m11003i(TAG, "updateLanguageList: mLanguageNameList size = " + this.mLanguageList.size());
        updateRecentUsedList();
        boolean z = this.mLanguageList.size() <= 1;
        this.mIsDisableTranslateStatus = z;
        LinearLayout linearLayout = this.mSelectLanguageTranscribeButton;
        if (linearLayout != null) {
            linearLayout.setAlpha(z ? 0.4f : 1.0f);
        }
    }

    private void updateRecentUsedList() {
        this.mRecentList = new ArrayList();
        Set<String> stringSet = SharedPreferencesCompat.getInstance("Settings").getStringSet(this.mIsFrom ? SettingsConstants.RECENT_USED_FROM : SettingsConstants.RECENT_USED_TO, new HashSet());
        if (stringSet == null) {
            Logger.m11003i(TAG, "updateRecentUsedList: invitations size empty");
            stringSet = new HashSet<>();
        }
        ArrayList arrayList = new ArrayList();
        Iterator<String> it = stringSet.iterator();
        while (it.hasNext()) {
            String[] strArrSplit = it.next().split(ContentUtils.HASH_SYMBOL);
            arrayList.add(new Pair(Integer.valueOf(Integer.parseInt(strArrSplit[1])), strArrSplit[0]));
        }
        Collections.sort(arrayList, new Comparator<Pair<Integer, String>>() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.dialog.SelectTranslateLanguageDialog.1
            @Override // java.util.Comparator
            public int compare(Pair<Integer, String> pair, Pair<Integer, String> pair2) {
                return Integer.compare(((Integer) pair.first).intValue(), ((Integer) pair2.first).intValue());
            }
        });
        for (int i = 0; i < arrayList.size(); i++) {
            AiLanguageHelper.Language language = new AiLanguageHelper.Language(AiLanguageHelper.getLocale((String) ((Pair) arrayList.get(i)).second));
            Iterator<AiLanguageHelper.Language> it2 = this.mLanguageList.iterator();
            int i2 = 0;
            while (true) {
                if (!it2.hasNext()) {
                    i2 = -1;
                    break;
                }
                AiLanguageHelper.Language next = it2.next();
                if (next.getIsData() && next.equals(language)) {
                    break;
                } else {
                    i2++;
                }
            }
            if (i2 != -1) {
                this.mLanguageList.remove(i2);
                List<AiLanguageHelper.Language> list = this.mRecentList;
                list.add(list.size(), language);
            }
        }
        if (!this.mRecentList.isEmpty()) {
            if (this.mLanguageList.isEmpty()) {
                this.mLanguageList.addAll(this.mRecentList);
            } else {
                this.mLanguageList.addAll(0, this.mRecentList);
            }
            addDivider();
        }
        Logger.m11003i(TAG, "updateRecentUsedList: mRecentList size = " + this.mRecentList.size());
    }

    @Override // androidx.fragment.app.DialogFragment
    @NonNull
    @SuppressLint({"DialogFragmentCallbacksDetector"})
    public Dialog onCreateDialog(@Nullable Bundle bundle) {
        Resources resources;
        int i;
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        if (this.mContract == null) {
            return builder.create();
        }
        this.mSelectLanguageView = (FrameLayout) getActivity().getLayoutInflater().inflate(C9086R.layout.select_translate_language_dialog_layout, (ViewGroup) null);
        View viewInflate = getActivity().getLayoutInflater().inflate(C9086R.layout.dialog_title, (ViewGroup) null);
        RecyclerView recyclerView = (RecyclerView) this.mSelectLanguageView.findViewById(C9086R.id.list_language);
        this.mSelectLanguageRecyclerView = recyclerView;
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        this.mItemMoreLanguageLayout = (LinearLayout) this.mSelectLanguageView.findViewById(C9086R.id.item_more_language_layout);
        this.mSelectLanguageTranscribeButton = (LinearLayout) this.mSelectLanguageView.findViewById(C9086R.id.select_language_transcribe_button);
        TextView textView = (TextView) this.mSelectLanguageView.findViewById(C9086R.id.select_language_transcribe_text);
        this.mSelectLanguageTranscribeTextView = textView;
        textView.setSelected(true);
        this.mSelectLanguageCancelButton = (LinearLayout) this.mSelectLanguageView.findViewById(C9086R.id.select_language_cancel_button);
        TextView textView2 = (TextView) this.mSelectLanguageView.findViewById(C9086R.id.select_language_cancel_text);
        this.mSelectLanguageCancelTextView = textView2;
        textView2.setSelected(true);
        if (ButtonBackgroundUtils.isShowButtonShapeEnabled(getActivity())) {
            this.mSelectLanguageTranscribeTextView.setTextColor(getActivity().getResources().getColor(C9086R.color.main_dialog_bg, null));
            this.mSelectLanguageTranscribeTextView.setBackgroundResource(C9086R.drawable.dialog_button_shape_bg);
            this.mSelectLanguageCancelTextView.setTextColor(getActivity().getResources().getColor(C9086R.color.main_dialog_bg, null));
            this.mSelectLanguageCancelTextView.setBackgroundResource(C9086R.drawable.dialog_button_shape_bg);
        }
        Locale locale = this.mSelectedLocale;
        if (locale != null) {
            this.mSelectedLanguage = new AiLanguageHelper.Language(AiLanguageHelper.getLocale(locale.toLanguageTag()));
            updateLanguageList();
            addRecentUsedList(this.mSelectedLocale.toLanguageTag());
            updateLanguageList();
            checkSelectedLanguage();
        } else {
            updateLanguageList();
        }
        SelectTranslateLanguageAdapter selectTranslateLanguageAdapter = new SelectTranslateLanguageAdapter(getActivity(), this.mLanguageList, this.mSelectedLanguage);
        this.mAdapter = selectTranslateLanguageAdapter;
        this.mSelectLanguageRecyclerView.setAdapter(selectTranslateLanguageAdapter);
        setBroadcastReceiver();
        TextView textView3 = (TextView) viewInflate.findViewById(C9086R.id.title_dialog);
        if (this.mIsFrom) {
            resources = getResources();
            i = C9086R.string.source_language;
        } else {
            resources = getResources();
            i = C9086R.string.target_language;
        }
        textView3.setText(resources.getString(i));
        builder.setCustomTitle(viewInflate);
        setButtonStyle(this.mItemMoreLanguageLayout);
        setButtonStyle(this.mSelectLanguageCancelButton);
        setButtonStyle(this.mSelectLanguageTranscribeButton);
        LinearLayout linearLayout = this.mSelectLanguageCancelButton;
        if (linearLayout != null) {
            linearLayout.setOnClickListener(new ViewOnClickListenerC10245o(this, 1));
        }
        LinearLayout linearLayout2 = this.mItemMoreLanguageLayout;
        if (linearLayout2 != null) {
            linearLayout2.setVisibility(0);
            this.mItemMoreLanguageLayout.setOnClickListener(new ViewOnClickListenerC10245o(this, 2));
        }
        builder.setView(this.mSelectLanguageView);
        AlertDialog alertDialogCreate = builder.create();
        this.mDialog = alertDialogCreate;
        Window window = alertDialogCreate.getWindow();
        if (window != null) {
            if (this.mPosY != 0.0f) {
                Logger.m10999d(TAG, "onCreateDialog# mCenterX : " + this.mCenterX + ", mTopY : " + this.mPosY);
                window.getDecorView().setVisibility(8);
            } else {
                WindowManager.LayoutParams attributes = window.getAttributes();
                attributes.x = (int) this.mCenterX;
                window.setAttributes(attributes);
            }
            if (getActivity() != null && (getActivity().getWindow().getAttributes().flags & 1024) != 0) {
                window.getDecorView().setSystemUiVisibility(4);
                window.setLayout(-1, -1);
            }
        }
        alertDialogCreate.setOnShowListener(new DialogInterfaceOnShowListenerC10246p(this, window, 0));
        return alertDialogCreate;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        Logger.m11003i(TAG, "onDestroy");
        this.mSelectLanguageTranscribeButton = null;
        if (this.mSelectLanguageView != null) {
            this.mSelectLanguageView = null;
        }
        this.mDialog = null;
        if (this.mAddBroadcastReceiver != null) {
            AiLanguageHelper.unregisterLanguagePackReceiver(getActivity().getApplicationContext(), this.mAddBroadcastReceiver);
            this.mAddBroadcastReceiver = null;
        }
        if (this.mRemoveBroadcastReceiver != null) {
            AiLanguageHelper.unregisterLanguagePackReceiver(getActivity().getApplicationContext(), this.mRemoveBroadcastReceiver);
            this.mRemoveBroadcastReceiver = null;
        }
        this.mCenterX = 0.0f;
        this.mPosY = 0.0f;
        super.onDestroy();
    }

    public void onMoreLanguageClick() {
        if (getActivity() == null) {
            dismissAllowingStateLoss();
            return;
        }
        try {
            AiLanguageHelper.setSelectTranslationLanguageActivity(getActivity(), C9086R.string.settings_notes_assist_language_pack_for_download, C9086R.string.settings_notes_assist_language_pack_for_download_description);
        } catch (ActivityNotFoundException e) {
            Logger.m11001e(TAG, "ActivityNotFoundException", e);
        }
        dismissAllowingStateLoss();
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        refreshList();
        if (this.mContract == null) {
            dismissAllowingStateLoss();
        }
    }

    public void setContract(boolean z, Locale locale, Contract contract) {
        setContract(z, locale, 0.0f, 0.0f, contract);
    }

    public void showAllowingStateLoss(FragmentManager fragmentManager, String str) {
        if (fragmentManager == null || fragmentManager.isDestroyed()) {
            return;
        }
        fragmentManager.beginTransaction().add(this, str).commitAllowingStateLoss();
    }

    public void setContract(boolean z, Locale locale, float f, float f4, Contract contract) {
        this.mIsFrom = z;
        this.mSelectedLocale = locale;
        this.mCenterX = f;
        this.mPosY = f4;
        this.mContract = contract;
    }
}
