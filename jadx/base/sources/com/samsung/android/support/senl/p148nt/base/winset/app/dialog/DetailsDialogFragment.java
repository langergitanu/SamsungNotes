package com.samsung.android.support.senl.p148nt.base.winset.app.dialog;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.format.DateFormat;
import android.text.format.DateUtils;
import android.text.style.UnderlineSpan;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.Button;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.widget.AbstractC0541b;
import androidx.fragment.app.DialogFragment;
import com.google.android.gms.common.data.AbstractC4539a;
import com.samsung.android.support.senl.p145cm.base.common.util.LocaleUtils;
import com.samsung.android.support.senl.p145cm.base.common.util.UnicodeUtils;
import com.samsung.android.support.senl.p148nt.base.C8875R;
import com.samsung.android.support.senl.p148nt.base.framework.support.Logger;
import com.samsung.android.support.senl.p148nt.base.winset.app.dialog.IDetailsDialog;
import com.samsung.android.support.senl.p148nt.base.winset.builder.AlertDialogBuilderForAppCompat;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.concurrent.ExecutorService;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public class DetailsDialogFragment extends DialogFragment implements IDetailsDialog {
    private static final String DEFAULT_SDOCX_FOLDER_UUID = "uncategorized:///";
    private static final String KEY_BODY_TEXT_WITHOUT_SPACES = "KEY_BODY_TEXT_WITHOUT_SPACES";
    private static final String KEY_BODY_TEXT_WITH_SPACES = "KEY_BODY_TEXT_WITH_SPACES";
    private static final String KEY_COVER_SUMMARY = "KEY_COVER_SUMMARY";
    private static final String KEY_DOC_PATH = "KEY_DOC_PATH";
    public static final String KEY_DOC_UUID = "KEY_DOC_UUID";
    private static final String KEY_FOLDER_UUID = "KEY_FOLDER_UUID";
    public static final String KEY_IS_FOLDER_SELECTED_ENABLE = "KEY_IS_FOLDER_SELECTED_ENABLE";
    private static final String KEY_MODIFIED_TIME = "KEY_MODIFIED_TIME";
    private static final String KEY_TITLE = "KEY_TITLE";
    private static final int NO_VALUE = -1;
    private static final int PROGRESS_DURATION = 1000;
    private static final String TAG = "DetailsDialogFragment";
    private LinearLayout mFolderPathLayout;
    private HorizontalScrollView mHorizontalScrollView;
    private boolean mIsFolderSelectedEnable;
    private long mModifiedTime;
    private View.OnClickListener mOnClickListener;
    private IDetailsDialog.OnDetailsDialogListener mOnDetailsDialogListener;
    private View mRootView;
    private long mStartTime;
    private final ExecutorService mExecutorService = AbstractC4539a.m3201k(TAG);
    private final Handler mHandler = new Handler(Looper.getMainLooper());
    private String mDocUuid = "";
    private String mDocPath = "";
    private String mFolderUuid = "";
    private String mTitle = "";
    private String mCoverSummary = "";
    private int mBodyTextWithoutSpaces = -1;
    private int mBodyTextWithSpaces = -1;

    private void addFolderPathView(String str, String str2, boolean z) {
        View viewInflate = LayoutInflater.from(getContext()).inflate(C8875R.layout.details_folderpath_item, (ViewGroup) this.mFolderPathLayout, false);
        viewInflate.findViewById(C8875R.id.folderpath_arrow).setVisibility(z ? 8 : 0);
        TextView textView = (TextView) viewInflate.findViewById(C8875R.id.folderpath_text);
        textView.setText(str2);
        textView.setTag(str);
        textView.setTooltipText(textView.getText());
        setAccessibility(textView);
        if (this.mIsFolderSelectedEnable) {
            textView.setOnClickListener(this.mOnClickListener);
            setTextUnderLine(textView);
        }
        this.mFolderPathLayout.addView(viewInflate);
    }

    private String convertFormattedDateTime(long j) {
        String strM773o;
        if (DateUtils.isToday(j)) {
            strM773o = DateFormat.getTimeFormat(getContext()).format(Long.valueOf(j));
            if (TextUtils.getLayoutDirectionFromLocale(Locale.getDefault()) == 1) {
                strM773o = AbstractC0541b.m773o("\u202a", strM773o, "\u202c");
            }
        } else {
            Locale locale = LocaleUtils.getLocale(getResources().getConfiguration());
            strM773o = new SimpleDateFormat(DateFormat.getBestDateTimePattern(locale, "yyyyMMMd, HH:mm"), locale).format(Long.valueOf(j));
        }
        return LocaleUtils.isRTLMode() ? AbstractC0541b.m772n(UnicodeUtils.RLM, strM773o) : strM773o;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getBodyText() {
        return getString(C8875R.string.details_number_of_characters, Integer.valueOf(this.mBodyTextWithoutSpaces), Integer.valueOf(this.mBodyTextWithSpaces));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideProgressView(final boolean z) {
        this.mHandler.postDelayed(new Runnable() { // from class: com.samsung.android.support.senl.nt.base.winset.app.dialog.DetailsDialogFragment.2
            @Override // java.lang.Runnable
            public void run() {
                if (!DetailsDialogFragment.this.isAdded() || DetailsDialogFragment.this.getContext() == null) {
                    return;
                }
                DetailsDialogFragment.this.mRootView.findViewById(C8875R.id.progress_circle).setVisibility(8);
                DetailsDialogFragment.this.mRootView.findViewById(C8875R.id.details_body_text_container).setVisibility(z ? 0 : 8);
            }
        }, z ? 0L : Math.max(0L, 1000 - (System.currentTimeMillis() - this.mStartTime)));
    }

    private void initView(View view) {
        IDetailsDialog.OnDetailsDialogListener onDetailsDialogListener;
        IDetailsDialog.FolderInfo folderInfo;
        if (getContext() == null) {
            return;
        }
        this.mRootView = view;
        if (!this.mTitle.isEmpty()) {
            setContainerView(C8875R.id.details_title_container, getResources().getString(C8875R.string.details_title), this.mTitle);
        }
        if (!this.mCoverSummary.isEmpty()) {
            setContainerView(C8875R.id.details_description_container, getResources().getString(C8875R.string.details_description), this.mCoverSummary);
        }
        setContainerView(C8875R.id.details_last_modified_container, getResources().getString(C8875R.string.details_last_modified), convertFormattedDateTime(this.mModifiedTime));
        if (!this.mFolderUuid.isEmpty() && (onDetailsDialogListener = this.mOnDetailsDialogListener) != null && (folderInfo = onDetailsDialogListener.getFolderInfo(this.mFolderUuid)) != null) {
            setFolderPathView(folderInfo);
        }
        if (this.mBodyTextWithoutSpaces == -1 || this.mBodyTextWithSpaces == -1) {
            setBodyTextView();
        } else {
            setContainerView(C8875R.id.details_body_text_container, getResources().getString(C8875R.string.details_number_of_characters_title), getBodyText());
        }
    }

    private void setAccessibility(TextView textView) {
        if (this.mIsFolderSelectedEnable) {
            textView.setAccessibilityDelegate(new View.AccessibilityDelegate() { // from class: com.samsung.android.support.senl.nt.base.winset.app.dialog.DetailsDialogFragment.5
                @Override // android.view.View.AccessibilityDelegate
                public void onInitializeAccessibilityNodeInfo(@NonNull View view, @NonNull AccessibilityNodeInfo accessibilityNodeInfo) {
                    super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfo);
                    accessibilityNodeInfo.setClassName(Button.class.getName());
                }
            });
        }
    }

    private void setBodyTextView() {
        showProgressView();
        this.mExecutorService.execute(new Runnable() { // from class: com.samsung.android.support.senl.nt.base.winset.app.dialog.DetailsDialogFragment.1
            @Override // java.lang.Runnable
            public void run() {
                if (DetailsDialogFragment.this.mDocPath.isEmpty() || DetailsDialogFragment.this.mOnDetailsDialogListener == null) {
                    DetailsDialogFragment.this.hideProgressView(false);
                    return;
                }
                Pair<Integer, Integer> bodyTextCount = DetailsDialogFragment.this.mOnDetailsDialogListener.getBodyTextCount(DetailsDialogFragment.this.mDocPath);
                if (bodyTextCount == null) {
                    DetailsDialogFragment.this.hideProgressView(false);
                    return;
                }
                DetailsDialogFragment.this.mBodyTextWithoutSpaces = ((Integer) bodyTextCount.first).intValue();
                DetailsDialogFragment.this.mBodyTextWithSpaces = ((Integer) bodyTextCount.second).intValue();
                DetailsDialogFragment.this.mHandler.post(new Runnable() { // from class: com.samsung.android.support.senl.nt.base.winset.app.dialog.DetailsDialogFragment.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (!DetailsDialogFragment.this.isAdded() || DetailsDialogFragment.this.getContext() == null) {
                            return;
                        }
                        DetailsDialogFragment detailsDialogFragment = DetailsDialogFragment.this;
                        detailsDialogFragment.setContainerView(C8875R.id.details_body_text_container, detailsDialogFragment.getResources().getString(C8875R.string.details_number_of_characters_title), DetailsDialogFragment.this.getBodyText());
                        DetailsDialogFragment.this.setContentViewTextColor(C8875R.id.details_body_text_container, false);
                        DetailsDialogFragment.this.hideProgressView(true);
                    }
                });
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setContainerView(int i, String str, String str2) {
        View viewFindViewById = this.mRootView.findViewById(i);
        TextView textView = (TextView) viewFindViewById.findViewById(C8875R.id.details_container_title);
        TextView textView2 = (TextView) viewFindViewById.findViewById(C8875R.id.details_container_content);
        textView.setText(str);
        textView2.setText(str2);
        viewFindViewById.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setContentViewTextColor(int i, boolean z) {
        TextView textView = (TextView) this.mRootView.findViewById(i).findViewById(C8875R.id.details_container_content);
        if (textView != null) {
            textView.setTextColor(getResources().getColor(z ? C8875R.color.details_container_loading_color : C8875R.color.details_container_content_color));
        }
    }

    private void setFolderPathView(IDetailsDialog.FolderInfo folderInfo) {
        this.mRootView.findViewById(C8875R.id.details_folderpath_container).setVisibility(0);
        HorizontalScrollView horizontalScrollView = (HorizontalScrollView) this.mRootView.findViewById(C8875R.id.folderpath_scrollview);
        this.mHorizontalScrollView = horizontalScrollView;
        horizontalScrollView.fullScroll(LocaleUtils.isRTLMode() ? 17 : 66);
        this.mFolderPathLayout = (LinearLayout) this.mRootView.findViewById(C8875R.id.folderpath_layout);
        this.mOnClickListener = new View.OnClickListener() { // from class: com.samsung.android.support.senl.nt.base.winset.app.dialog.DetailsDialogFragment.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String str = (String) view.getTag();
                Logger.m8697d(DetailsDialogFragment.TAG, "onClick# folderUuid : " + str);
                if (view.getId() == C8875R.id.folderpath_home) {
                    str = "uncategorized:///";
                }
                if (DetailsDialogFragment.this.mOnDetailsDialogListener != null) {
                    DetailsDialogFragment.this.mOnDetailsDialogListener.onFolderSelected(str);
                }
            }
        };
        TextView textView = (TextView) this.mRootView.findViewById(C8875R.id.folderpath_home);
        setAccessibility(textView);
        if (this.mIsFolderSelectedEnable) {
            textView.setOnClickListener(this.mOnClickListener);
            setTextUnderLine(textView);
        }
        updateCurrentPath(folderInfo);
    }

    private void setTextUnderLine(TextView textView) {
        SpannableString spannableString = new SpannableString(textView.getText());
        spannableString.setSpan(new UnderlineSpan(), 0, spannableString.length(), 0);
        textView.setText(spannableString);
    }

    private void showProgressView() {
        this.mStartTime = System.currentTimeMillis();
        this.mRootView.findViewById(C8875R.id.progress_circle).setVisibility(0);
        setContainerView(C8875R.id.details_body_text_container, getResources().getString(C8875R.string.details_number_of_characters_title), getString(C8875R.string.details_loading));
        setContentViewTextColor(C8875R.id.details_body_text_container, true);
    }

    private void updateCurrentPath(IDetailsDialog.FolderInfo folderInfo) {
        this.mFolderPathLayout.removeAllViews();
        if (folderInfo == null) {
            return;
        }
        updateParentPath(this.mOnDetailsDialogListener.getFolderInfo(folderInfo.getParentFolderUuid()));
        addFolderPathView(folderInfo.getFolderUuid(), folderInfo.getFolderDisplayName(), true);
        this.mFolderPathLayout.invalidate();
        this.mHandler.post(new Runnable() { // from class: com.samsung.android.support.senl.nt.base.winset.app.dialog.DetailsDialogFragment.4
            @Override // java.lang.Runnable
            public void run() {
                DetailsDialogFragment.this.mHorizontalScrollView.fullScroll(LocaleUtils.isRTLMode() ? 17 : 66);
            }
        });
    }

    private void updateParentPath(IDetailsDialog.FolderInfo folderInfo) {
        if (folderInfo == null || "uncategorized:///".equals(folderInfo.getFolderUuid())) {
            return;
        }
        updateParentPath(this.mOnDetailsDialogListener.getFolderInfo(folderInfo.getParentFolderUuid()));
        addFolderPathView(folderInfo.getFolderUuid(), folderInfo.getFolderDisplayName(), false);
    }

    @Override // androidx.fragment.app.DialogFragment
    @NonNull
    public Dialog onCreateDialog(@Nullable Bundle bundle) {
        if (bundle != null) {
            this.mDocUuid = bundle.getString(KEY_DOC_UUID);
            this.mDocPath = bundle.getString(KEY_DOC_PATH);
            this.mFolderUuid = bundle.getString(KEY_FOLDER_UUID);
            this.mTitle = bundle.getString(KEY_TITLE);
            this.mCoverSummary = bundle.getString(KEY_COVER_SUMMARY);
            this.mModifiedTime = bundle.getLong(KEY_MODIFIED_TIME);
            this.mBodyTextWithoutSpaces = bundle.getInt(KEY_BODY_TEXT_WITHOUT_SPACES);
            this.mBodyTextWithSpaces = bundle.getInt(KEY_BODY_TEXT_WITH_SPACES);
            this.mIsFolderSelectedEnable = bundle.getBoolean(KEY_IS_FOLDER_SELECTED_ENABLE);
        }
        View viewInflate = getLayoutInflater().inflate(C8875R.layout.details_layout, (ViewGroup) null);
        initView(viewInflate);
        AlertDialog alertDialogCreate = new AlertDialogBuilderForAppCompat(getActivity()).create();
        alertDialogCreate.setView(viewInflate);
        alertDialogCreate.setButton(-1, getString(C8875R.string.f6384OK), (DialogInterface.OnClickListener) null);
        alertDialogCreate.setCanceledOnTouchOutside(true);
        return alertDialogCreate;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.mExecutorService.shutdownNow();
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onSaveInstanceState(@NonNull Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString(KEY_DOC_UUID, this.mDocUuid);
        bundle.putString(KEY_DOC_PATH, this.mDocPath);
        bundle.putString(KEY_FOLDER_UUID, this.mFolderUuid);
        bundle.putString(KEY_TITLE, this.mTitle);
        bundle.putString(KEY_COVER_SUMMARY, this.mCoverSummary);
        bundle.putLong(KEY_MODIFIED_TIME, this.mModifiedTime);
        bundle.putInt(KEY_BODY_TEXT_WITHOUT_SPACES, this.mBodyTextWithoutSpaces);
        bundle.putInt(KEY_BODY_TEXT_WITH_SPACES, this.mBodyTextWithSpaces);
        bundle.putBoolean(KEY_IS_FOLDER_SELECTED_ENABLE, this.mIsFolderSelectedEnable);
    }

    @Override // com.samsung.android.support.senl.p148nt.base.winset.app.dialog.IDetailsDialog
    public void setDetailsDialogData(String str, String str2, String str3, String str4, String str5, long j) {
        this.mDocUuid = str;
        this.mDocPath = str2;
        this.mFolderUuid = str3;
        this.mTitle = str4;
        this.mCoverSummary = str5;
        this.mModifiedTime = j;
    }

    @Override // com.samsung.android.support.senl.p148nt.base.winset.app.dialog.IDetailsDialog
    public void setDetailsDialogListener(IDetailsDialog.OnDetailsDialogListener onDetailsDialogListener) {
        this.mOnDetailsDialogListener = onDetailsDialogListener;
    }

    @Override // com.samsung.android.support.senl.p148nt.base.winset.app.dialog.IDetailsDialog
    public void setIsFolderSelectedEnable(boolean z) {
        this.mIsFolderSelectedEnable = z;
    }
}
