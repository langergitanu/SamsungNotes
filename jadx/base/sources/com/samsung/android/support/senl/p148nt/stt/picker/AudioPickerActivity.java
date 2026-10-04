package com.samsung.android.support.senl.p148nt.stt.picker;

import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SeslProgressBar;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.FileProvider;
import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.samsung.android.support.senl.document.memoconverter.core.ConverterUtils;
import com.samsung.android.support.senl.p148nt.app.common.NotesConstants;
import com.samsung.android.support.senl.p148nt.base.common.util.ContentPickerUtils;
import com.samsung.android.support.senl.p148nt.data.common.utils.AbstractC11014a;
import com.samsung.android.support.senl.p148nt.stt.C11493R;
import com.samsung.android.support.senl.p148nt.stt.common.Logger;
import com.samsung.android.support.senl.p148nt.stt.picker.model.RecordingItem;
import com.samsung.android.support.senl.p148nt.stt.picker.presenter.AudioPickerSearchPresenter;
import com.samsung.android.support.senl.p148nt.stt.picker.presenter.CursorProvider;
import com.samsung.android.support.senl.p148nt.stt.picker.presenter.VoiceDataUpdater;
import com.samsung.android.support.senl.p148nt.stt.picker.view.AudioPickerListViewAdapter;
import com.samsung.android.support.senl.p148nt.stt.picker.view.AudioPickerListViewAdapterContract;
import com.samsung.android.support.senl.p148nt.stt.picker.view.AudioPickerSearchView;
import com.samsung.android.support.senl.p148nt.stt.picker.view.SearchFragment;
import com.samsung.android.support.senl.p148nt.stt.picker.view.listener.OffsetUpdateListener;
import com.samsung.android.support.senl.p148nt.stt.picker.view.listener.OnBackKeyListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.ArrayIteratorKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.p196io.CloseableKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(m13885d1 = {"\u0000Ì\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0015\u0018\u0000 u2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001uB\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u0012\u0010A\u001a\u00020B2\b\u0010C\u001a\u0004\u0018\u00010DH\u0014J\b\u0010E\u001a\u00020BH\u0002J\b\u0010F\u001a\u00020BH\u0002J\b\u0010G\u001a\u00020BH\u0014J\b\u0010H\u001a\u00020BH\u0002J\b\u0010I\u001a\u00020BH\u0002J\b\u0010J\u001a\u00020BH\u0002J\b\u0010K\u001a\u00020BH\u0002J\b\u0010L\u001a\u00020BH\u0002J\b\u0010M\u001a\u00020BH\u0002J\u0012\u0010N\u001a\u00020B2\b\u0010O\u001a\u0004\u0018\u00010PH\u0002J\b\u0010Q\u001a\u00020BH\u0002J\b\u0010R\u001a\u00020BH\u0002J\u0012\u0010S\u001a\u0004\u0018\u00010T2\u0006\u0010U\u001a\u00020TH\u0002J\b\u0010V\u001a\u00020BH\u0002J\b\u0010W\u001a\u00020BH\u0002J\u0006\u0010X\u001a\u00020BJ\b\u0010Y\u001a\u00020BH\u0002J\b\u0010Z\u001a\u00020BH\u0002J\u0010\u0010[\u001a\u00020@2\u0006\u0010\\\u001a\u00020\u001cH\u0002J\"\u0010]\u001a\u00020B2\u0006\u0010^\u001a\u00020\u001c2\u0006\u0010_\u001a\u00020\u001c2\b\u0010`\u001a\u0004\u0018\u00010aH\u0014J\u0010\u0010b\u001a\u00020B2\u0006\u0010c\u001a\u00020 H\u0016J\u0018\u0010d\u001a\u00020B2\u0006\u0010e\u001a\u00020\u001c2\u0006\u0010f\u001a\u00020\u001cH\u0016J\u0010\u0010g\u001a\u00020B2\u0006\u0010c\u001a\u00020 H\u0016J\b\u0010h\u001a\u00020BH\u0016J\b\u0010i\u001a\u00020BH\u0016J\u0010\u0010j\u001a\u00020B2\u0006\u0010k\u001a\u00020@H\u0016J\u0010\u0010l\u001a\u00020B2\u0006\u0010m\u001a\u00020TH\u0002J\b\u0010n\u001a\u00020BH\u0002J\u0012\u0010o\u001a\u00020B2\b\u0010C\u001a\u0004\u0018\u00010DH\u0002J\u0010\u0010p\u001a\u00020B2\u0006\u0010q\u001a\u00020DH\u0014J\u0010\u0010r\u001a\u00020T2\u0006\u0010s\u001a\u00020TH\u0002J\b\u0010t\u001a\u00020@H\u0016R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u000e\u0010\u001b\u001a\u00020\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001f\u001a\u0004\u0018\u00010 X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R,\u0010\"\u001a \u0012\u0004\u0012\u00020\u001c\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020 0$j\b\u0012\u0004\u0012\u00020 `%\u0018\u00010#X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010&\u001a\u0004\u0018\u00010'X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010*\u001a\u0004\u0018\u00010+X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010,\u001a\u0004\u0018\u00010-X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010.\u001a\u0004\u0018\u00010/X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00100\u001a\u0004\u0018\u000101X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00102\u001a\u0004\u0018\u000103X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00104\u001a\u0004\u0018\u000105X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00106\u001a\u0004\u0018\u000107X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00108\u001a\u0004\u0018\u000109X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010:\u001a\u0004\u0018\u00010;X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010<\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010=\u001a\u0004\u0018\u00010>X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010?\u001a\u00020@X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006v"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/stt/picker/AudioPickerActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "Lcom/samsung/android/support/senl/nt/stt/picker/view/AudioPickerListViewAdapterContract;", "Lcom/samsung/android/support/senl/nt/stt/picker/view/listener/OnBackKeyListener;", "<init>", "()V", "mListAudio", "Landroidx/recyclerview/widget/RecyclerView;", "mCollapsingToolbar", "Lcom/google/android/material/appbar/CollapsingToolbarLayout;", "mTitle", "Landroid/widget/TextView;", "getMTitle", "()Landroid/widget/TextView;", "setMTitle", "(Landroid/widget/TextView;)V", "mAppBarLayout", "Lcom/google/android/material/appbar/AppBarLayout;", "mVoiceRecorderButton", "mCallButton", "mNotesButton", "mAdapter", "Lcom/samsung/android/support/senl/nt/stt/picker/view/AudioPickerListViewAdapter;", "getMAdapter", "()Lcom/samsung/android/support/senl/nt/stt/picker/view/AudioPickerListViewAdapter;", "setMAdapter", "(Lcom/samsung/android/support/senl/nt/stt/picker/view/AudioPickerListViewAdapter;)V", "mRecordingMode", "", "mDoneButton", "Landroid/widget/FrameLayout;", "mSelectedItem", "Lcom/samsung/android/support/senl/nt/stt/picker/model/RecordingItem;", "mSelectedMode", "mAudioFileMap", "", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "mLinearLayoutManager", "Landroidx/recyclerview/widget/LinearLayoutManager;", "mCurrentSortType", "mCurrentSortOrder", "mCursorProvider", "Lcom/samsung/android/support/senl/nt/stt/picker/presenter/CursorProvider;", "mProgressBar", "Landroidx/appcompat/widget/SeslProgressBar;", "mAudioPickerSearchView", "Lcom/samsung/android/support/senl/nt/stt/picker/view/AudioPickerSearchView;", "mSearchButton", "Landroid/widget/ImageButton;", "mPikerListLayout", "Landroid/widget/LinearLayout;", "mToolbar", "Landroidx/appcompat/widget/Toolbar;", "mSearchFragment", "Lcom/samsung/android/support/senl/nt/stt/picker/view/SearchFragment;", "mSearchPresenter", "Lcom/samsung/android/support/senl/nt/stt/picker/presenter/AudioPickerSearchPresenter;", "mNoResultLayout", "Landroidx/core/widget/NestedScrollView;", "mNoResultText", "mOffsetUpdateListener", "Lcom/samsung/android/support/senl/nt/stt/picker/view/listener/OffsetUpdateListener;", "mIsSearchMode", "", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "initData", "clear", "onDestroy", "deleteShareFile", "initLayout", "initToolBar", "initDoneButton", "initSearchMode", "initSearchPresenter", "setVerticalView", "view", "Landroid/view/View;", "initRecyclerView", "initPickerList", "getApplicationLabel", "", "packageName", "initSearchFragment", "commitSearchFragment", "resetItemSelected", "updatePickerList", "setFocusToSelectItem", "isVisibleItemPosition", "position", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onAudioSelected", "recordingItem", "onUpdateSortItem", "sortType", "sortOrder", "onAudioPlay", "onBackPressed", "disableProgressBar", "updateNoResultView", "visible", "shareAudio", "filePath", "updateDoneButton", "restoreSavedInstance", NotesConstants.DialogTag.ON_SAVE_INSTANCE_STATE, "outState", "getFilePathToShare", "fileName", "onBackKeyDown", "Companion", "ntStt_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nAudioPickerActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AudioPickerActivity.kt\ncom/samsung/android/support/senl/nt/stt/picker/AudioPickerActivity\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,552:1\n1#2:553\n*E\n"})
public final class AudioPickerActivity extends AppCompatActivity implements AudioPickerListViewAdapterContract, OnBackKeyListener {

    @NotNull
    private static final String AUTHORITY = "com.samsung.android.app.notes.shareprovider";

    @NotNull
    private static final String KEY_IS_SEARCH_MODE = "recording_search_mode";

    @NotNull
    private static final String KEY_RECORDING_MODE = "recording_mode";

    @NotNull
    private static final String KEY_RECORDING_SELECTED = "recording_selected";

    @NotNull
    private static final String KEY_RECORDING_SELECTED_MODE = "recording_selected_mode";

    @NotNull
    private static final String KEY_RECORDING_SORT_BY = "recording_sort_by";

    @NotNull
    private static final String KEY_RECORDING_SORT_ORDER = "recording_sort_order";

    @NotNull
    private static final String PACKAGE_CALL = "com.samsung.android.incallui";

    @NotNull
    private static final String PACKAGE_VOICE_RECORDER = "com.sec.android.app.voicenote";

    @NotNull
    private static final String TAG = "AudioPickerActivity";

    @Nullable
    private AudioPickerListViewAdapter mAdapter;

    @Nullable
    private AppBarLayout mAppBarLayout;

    @Nullable
    private Map<Integer, ArrayList<RecordingItem>> mAudioFileMap;

    @Nullable
    private AudioPickerSearchView mAudioPickerSearchView;

    @Nullable
    private TextView mCallButton;

    @Nullable
    private CollapsingToolbarLayout mCollapsingToolbar;
    private int mCurrentSortOrder;
    private int mCurrentSortType;

    @Nullable
    private CursorProvider mCursorProvider;

    @Nullable
    private FrameLayout mDoneButton;
    private boolean mIsSearchMode;

    @Nullable
    private LinearLayoutManager mLinearLayoutManager;

    @Nullable
    private RecyclerView mListAudio;

    @Nullable
    private NestedScrollView mNoResultLayout;

    @Nullable
    private TextView mNoResultText;

    @Nullable
    private TextView mNotesButton;

    @Nullable
    private OffsetUpdateListener mOffsetUpdateListener;

    @Nullable
    private LinearLayout mPikerListLayout;

    @Nullable
    private SeslProgressBar mProgressBar;
    private int mRecordingMode;

    @Nullable
    private ImageButton mSearchButton;

    @Nullable
    private SearchFragment mSearchFragment;

    @Nullable
    private AudioPickerSearchPresenter mSearchPresenter;

    @Nullable
    private RecordingItem mSelectedItem;
    private int mSelectedMode;

    @Nullable
    private TextView mTitle;

    @Nullable
    private Toolbar mToolbar;

    @Nullable
    private TextView mVoiceRecorderButton;

    private final void clear() {
        VoiceDataUpdater companion = VoiceDataUpdater.INSTANCE.getInstance();
        Intrinsics.checkNotNull(companion);
        companion.clear();
        RecyclerView recyclerView = this.mListAudio;
        if (recyclerView != null) {
            Intrinsics.checkNotNull(recyclerView);
            recyclerView.clearOnScrollListeners();
            RecyclerView recyclerView2 = this.mListAudio;
            Intrinsics.checkNotNull(recyclerView2);
            recyclerView2.setAdapter(null);
        }
        this.mAdapter = null;
        this.mCursorProvider = null;
        this.mAudioFileMap = null;
        this.mListAudio = null;
        this.mAudioPickerSearchView = null;
        this.mCollapsingToolbar = null;
        this.mAppBarLayout = null;
        this.mDoneButton = null;
        this.mVoiceRecorderButton = null;
        this.mCallButton = null;
        this.mTitle = null;
        this.mToolbar = null;
        this.mPikerListLayout = null;
    }

    private final void commitSearchFragment() {
        if (getSupportFragmentManager().findFragmentByTag(SearchFragment.TAG) != null) {
            FragmentTransaction fragmentTransactionBeginTransaction = getSupportFragmentManager().beginTransaction();
            SearchFragment searchFragment = this.mSearchFragment;
            Intrinsics.checkNotNull(searchFragment);
            fragmentTransactionBeginTransaction.detach(searchFragment).commitNow();
            FragmentTransaction fragmentTransactionBeginTransaction2 = getSupportFragmentManager().beginTransaction();
            SearchFragment searchFragment2 = this.mSearchFragment;
            Intrinsics.checkNotNull(searchFragment2);
            fragmentTransactionBeginTransaction2.attach(searchFragment2).commitNow();
        } else {
            FragmentTransaction fragmentTransactionBeginTransaction3 = getSupportFragmentManager().beginTransaction();
            Intrinsics.checkNotNullExpressionValue(fragmentTransactionBeginTransaction3, "beginTransaction(...)");
            int i = C11493R.id.search_layout;
            SearchFragment searchFragment3 = this.mSearchFragment;
            Intrinsics.checkNotNull(searchFragment3);
            fragmentTransactionBeginTransaction3.replace(i, searchFragment3, SearchFragment.TAG);
            fragmentTransactionBeginTransaction3.commitAllowingStateLoss();
        }
        resetItemSelected();
        AudioPickerListViewAdapter audioPickerListViewAdapter = this.mAdapter;
        if (audioPickerListViewAdapter != null) {
            audioPickerListViewAdapter.resetPrevItemSelect();
        }
    }

    private final void deleteShareFile() {
        File file = new File(AbstractC11014a.m12320e(getFilesDir(), "/share/audioPiker"));
        if (file.exists()) {
            File[] fileArrListFiles = file.listFiles();
            if (fileArrListFiles != null) {
                Iterator it = ArrayIteratorKt.iterator(fileArrListFiles);
                while (it.hasNext()) {
                    ((File) it.next()).delete();
                }
            }
            file.delete();
        }
    }

    private final String getApplicationLabel(String packageName) {
        try {
            PackageManager packageManager = getPackageManager();
            Intrinsics.checkNotNullExpressionValue(packageManager, "getPackageManager(...)");
            ApplicationInfo applicationInfo = packageManager.getApplicationInfo(packageName, 128);
            Intrinsics.checkNotNullExpressionValue(applicationInfo, "getApplicationInfo(...)");
            return packageManager.getApplicationLabel(applicationInfo).toString();
        } catch (PackageManager.NameNotFoundException e) {
            Logger.m12711e(TAG, "getApplicationLabel() failed: " + e);
            return null;
        }
    }

    private final String getFilePathToShare(String fileName) {
        File file = new File(AbstractC11014a.m12320e(getFilesDir(), "/share/audioPiker"));
        if (!file.exists()) {
            file.mkdir();
        }
        return getFilesDir() + "/share/audioPiker/" + fileName;
    }

    private final void initData() {
        Map<Integer, ArrayList<RecordingItem>> map = this.mAudioFileMap;
        Intrinsics.checkNotNull(map);
        AudioPickerListViewAdapter audioPickerListViewAdapter = this.mAdapter;
        Intrinsics.checkNotNull(audioPickerListViewAdapter);
        CursorProvider cursorProvider = new CursorProvider(this, map, audioPickerListViewAdapter);
        this.mCursorProvider = cursorProvider;
        cursorProvider.registerObservers();
        VoiceDataUpdater.Companion companion = VoiceDataUpdater.INSTANCE;
        VoiceDataUpdater companion2 = companion.getInstance();
        Intrinsics.checkNotNull(companion2);
        companion2.setItemInfo(this.mAudioFileMap, this.mAdapter);
        VoiceDataUpdater companion3 = companion.getInstance();
        Intrinsics.checkNotNull(companion3);
        companion3.syncVoiceProviderWithMediaProvider();
    }

    private final void initDoneButton() {
        FrameLayout frameLayout = (FrameLayout) findViewById(C11493R.id.audio_picker_done_button);
        this.mDoneButton = frameLayout;
        if (frameLayout != null) {
            frameLayout.setOnClickListener(new ViewOnClickListenerC11506a(this, 0));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initDoneButton$lambda$2(AudioPickerActivity audioPickerActivity, View view) {
        String path;
        Logger.m12710d(TAG, "Done button clicked");
        Intent intent = new Intent();
        RecordingItem recordingItem = audioPickerActivity.mSelectedItem;
        intent.putExtra(ContentPickerUtils.MYFILES_EXTRA_URI, Uri.fromFile((recordingItem == null || (path = recordingItem.getPath()) == null) ? null : new File(path)));
        RecordingItem recordingItem2 = audioPickerActivity.mSelectedItem;
        if (recordingItem2 != null) {
            Intrinsics.checkNotNull(recordingItem2);
            intent.putExtra(ContentPickerUtils.AUDIO_PICKER_NAME, recordingItem2.getTitle());
            audioPickerActivity.setResult(-1, intent);
        }
        audioPickerActivity.finish();
    }

    private final void initLayout() {
        setContentView(C11493R.layout.activity_audio_picker);
        initToolBar();
        initDoneButton();
        initRecyclerView();
        initPickerList();
        this.mNoResultLayout = (NestedScrollView) findViewById(C11493R.id.no_result_layout);
        TextView textView = (TextView) findViewById(C11493R.id.no_result_text);
        this.mNoResultText = textView;
        setVerticalView(textView);
    }

    private final void initPickerList() {
        this.mVoiceRecorderButton = (TextView) findViewById(C11493R.id.voice_recorder_button);
        this.mCallButton = (TextView) findViewById(C11493R.id.call_button);
        this.mNotesButton = (TextView) findViewById(C11493R.id.notes_button);
        TextView textView = this.mVoiceRecorderButton;
        if (textView != null) {
            textView.setText(getApplicationLabel(PACKAGE_VOICE_RECORDER));
        }
        TextView textView2 = this.mCallButton;
        if (textView2 != null) {
            textView2.setText(getApplicationLabel(PACKAGE_CALL));
        }
        TextView textView3 = this.mNotesButton;
        if (textView3 != null) {
            textView3.setText(getText(C11493R.string.audio_picker_notes));
        }
        updatePickerList();
        TextView textView4 = this.mVoiceRecorderButton;
        if (textView4 != null) {
            textView4.setOnClickListener(new ViewOnClickListenerC11506a(this, 2));
        }
        TextView textView5 = this.mCallButton;
        if (textView5 != null) {
            textView5.setOnClickListener(new ViewOnClickListenerC11506a(this, 3));
        }
        TextView textView6 = this.mNotesButton;
        if (textView6 != null) {
            textView6.setOnClickListener(new ViewOnClickListenerC11506a(this, 4));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initPickerList$lambda$3(AudioPickerActivity audioPickerActivity, View view) {
        Logger.m12710d(TAG, "Voice recorder button clicked");
        if (audioPickerActivity.mAdapter == null || audioPickerActivity.mRecordingMode == 2) {
            return;
        }
        audioPickerActivity.mRecordingMode = 2;
        audioPickerActivity.updatePickerList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initPickerList$lambda$4(AudioPickerActivity audioPickerActivity, View view) {
        Logger.m12710d(TAG, "Call button clicked");
        if (audioPickerActivity.mAdapter == null || audioPickerActivity.mRecordingMode == 1) {
            return;
        }
        audioPickerActivity.mRecordingMode = 1;
        audioPickerActivity.updatePickerList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initPickerList$lambda$5(AudioPickerActivity audioPickerActivity, View view) {
        Logger.m12710d(TAG, "Notes button clicked");
        if (audioPickerActivity.mAdapter == null || audioPickerActivity.mRecordingMode == 0) {
            return;
        }
        audioPickerActivity.mRecordingMode = 0;
        audioPickerActivity.updatePickerList();
    }

    private final void initRecyclerView() {
        AudioPickerListViewAdapter audioPickerListViewAdapter;
        this.mProgressBar = (SeslProgressBar) findViewById(C11493R.id.progress_bar);
        HashMap map = new HashMap();
        this.mAudioFileMap = map;
        Intrinsics.checkNotNull(map);
        map.put(0, new ArrayList());
        Map<Integer, ArrayList<RecordingItem>> map2 = this.mAudioFileMap;
        Intrinsics.checkNotNull(map2);
        map2.put(1, new ArrayList<>());
        Map<Integer, ArrayList<RecordingItem>> map3 = this.mAudioFileMap;
        Intrinsics.checkNotNull(map3);
        map3.put(2, new ArrayList<>());
        Map<Integer, ArrayList<RecordingItem>> map4 = this.mAudioFileMap;
        Intrinsics.checkNotNull(map4);
        this.mAdapter = new AudioPickerListViewAdapter(this, this, map4);
        this.mListAudio = (RecyclerView) findViewById(C11493R.id.list_audio);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        this.mLinearLayoutManager = linearLayoutManager;
        RecyclerView recyclerView = this.mListAudio;
        if (recyclerView != null) {
            recyclerView.setLayoutManager(linearLayoutManager);
        }
        RecyclerView recyclerView2 = this.mListAudio;
        if (recyclerView2 != null) {
            recyclerView2.setAdapter(this.mAdapter);
        }
        AudioPickerListViewAdapter audioPickerListViewAdapter2 = this.mAdapter;
        if (audioPickerListViewAdapter2 != null) {
            audioPickerListViewAdapter2.setSortState(this.mCurrentSortType, this.mCurrentSortOrder);
        }
        AudioPickerListViewAdapter audioPickerListViewAdapter3 = this.mAdapter;
        if (audioPickerListViewAdapter3 != null) {
            audioPickerListViewAdapter3.setRecordingMode(this.mRecordingMode);
        }
        RecyclerView recyclerView3 = this.mListAudio;
        if (recyclerView3 != null) {
            recyclerView3.seslSetGoToTopEnabled(true);
        }
        RecordingItem recordingItem = this.mSelectedItem;
        if (recordingItem == null || (audioPickerListViewAdapter = this.mAdapter) == null) {
            return;
        }
        Intrinsics.checkNotNull(recordingItem);
        audioPickerListViewAdapter.setReInitItemSelect(recordingItem, this.mSelectedMode);
    }

    private final void initSearchFragment() {
        SearchFragment searchFragment = (SearchFragment) getSupportFragmentManager().findFragmentByTag(SearchFragment.TAG);
        this.mSearchFragment = searchFragment;
        if (searchFragment == null) {
            this.mSearchFragment = new SearchFragment();
        }
        SearchFragment searchFragment2 = this.mSearchFragment;
        if (searchFragment2 != null) {
            searchFragment2.setContract(this);
        }
        SearchFragment searchFragment3 = this.mSearchFragment;
        if (searchFragment3 != null) {
            CursorProvider cursorProvider = this.mCursorProvider;
            Intrinsics.checkNotNull(cursorProvider);
            searchFragment3.setCursorProvider(cursorProvider);
        }
        SearchFragment searchFragment4 = this.mSearchFragment;
        if (searchFragment4 != null) {
            AudioPickerSearchPresenter audioPickerSearchPresenter = this.mSearchPresenter;
            Intrinsics.checkNotNull(audioPickerSearchPresenter);
            searchFragment4.setPresenter(audioPickerSearchPresenter);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void initSearchMode() {
        AudioPickerSearchView audioPickerSearchView = this.mAudioPickerSearchView;
        if (audioPickerSearchView == null) {
            return;
        }
        Intrinsics.checkNotNull(audioPickerSearchView);
        audioPickerSearchView.setVisibility(0);
        AppBarLayout appBarLayout = this.mAppBarLayout;
        if (appBarLayout != null) {
            appBarLayout.setExpanded(false);
        }
        Toolbar toolbar = this.mToolbar;
        if (toolbar != null) {
            toolbar.setVisibility(4);
        }
        AudioPickerSearchView audioPickerSearchView2 = this.mAudioPickerSearchView;
        Intrinsics.checkNotNull(audioPickerSearchView2);
        audioPickerSearchView2.setIconified(false);
        AudioPickerSearchView audioPickerSearchView3 = this.mAudioPickerSearchView;
        Intrinsics.checkNotNull(audioPickerSearchView3);
        audioPickerSearchView3.initSearchData(getComponentName(), getResources().getString(C11493R.string.action_search));
        AudioPickerSearchView audioPickerSearchView4 = this.mAudioPickerSearchView;
        Intrinsics.checkNotNull(audioPickerSearchView4);
        audioPickerSearchView4.setOnBackKeyListener(this);
        AudioPickerSearchView audioPickerSearchView5 = this.mAudioPickerSearchView;
        Intrinsics.checkNotNull(audioPickerSearchView5);
        audioPickerSearchView5.setQuery("", false);
        LinearLayout linearLayout = this.mPikerListLayout;
        if (linearLayout != null) {
            linearLayout.setVisibility(8);
        }
        AudioPickerSearchPresenter audioPickerSearchPresenter = this.mSearchPresenter;
        if (audioPickerSearchPresenter != null) {
            AudioPickerSearchView audioPickerSearchView6 = this.mAudioPickerSearchView;
            Intrinsics.checkNotNull(audioPickerSearchView6);
            audioPickerSearchPresenter.setOnSearchListener(audioPickerSearchView6);
        }
        this.mIsSearchMode = true;
        NestedScrollView nestedScrollView = this.mNoResultLayout;
        if (nestedScrollView != null) {
            Intrinsics.checkNotNull(nestedScrollView);
            if (nestedScrollView.getVisibility() != 8) {
                NestedScrollView nestedScrollView2 = this.mNoResultLayout;
                Intrinsics.checkNotNull(nestedScrollView2);
                nestedScrollView2.setVisibility(8);
            }
        }
        if (this.mSearchFragment == null) {
            initSearchFragment();
        }
        commitSearchFragment();
    }

    private final void initSearchPresenter() {
        AudioPickerSearchPresenter audioPickerSearchPresenter = new AudioPickerSearchPresenter(this);
        this.mSearchPresenter = audioPickerSearchPresenter;
        audioPickerSearchPresenter.setContract(new AudioPickerSearchPresenter.ViewContract() { // from class: com.samsung.android.support.senl.nt.stt.picker.AudioPickerActivity.initSearchPresenter.1
            @Override // com.samsung.android.support.senl.nt.stt.picker.presenter.AudioPickerSearchPresenter.ViewContract
            public AudioPickerSearchView getSearchView() {
                return AudioPickerActivity.this.mAudioPickerSearchView;
            }

            @Override // com.samsung.android.support.senl.nt.stt.picker.presenter.AudioPickerSearchPresenter.ViewContract
            public boolean hasSearchView() {
                return AudioPickerActivity.this.mAudioPickerSearchView != null;
            }

            @Override // com.samsung.android.support.senl.nt.stt.picker.presenter.AudioPickerSearchPresenter.ViewContract
            public void resetItemSelected() {
                AudioPickerActivity.this.resetItemSelected();
            }

            @Override // com.samsung.android.support.senl.nt.stt.picker.presenter.AudioPickerSearchPresenter.ViewContract
            public void setVerticalView(View view) {
                AudioPickerActivity.this.setVerticalView(view);
            }
        });
    }

    private final void initToolBar() {
        this.mCollapsingToolbar = (CollapsingToolbarLayout) findViewById(C11493R.id.collapsing_toolbar);
        this.mTitle = (TextView) findViewById(C11493R.id.text_in_toolbar);
        this.mAppBarLayout = (AppBarLayout) findViewById(C11493R.id.appbar_layout);
        Editable editableNewEditable = Editable.Factory.getInstance().newEditable(getString(C11493R.string.select_audio_file));
        CollapsingToolbarLayout collapsingToolbarLayout = this.mCollapsingToolbar;
        if (collapsingToolbarLayout != null) {
            collapsingToolbarLayout.setTitle(editableNewEditable);
        }
        OffsetUpdateListener offsetUpdateListener = new OffsetUpdateListener(this, this.mTitle);
        this.mOffsetUpdateListener = offsetUpdateListener;
        AppBarLayout appBarLayout = this.mAppBarLayout;
        if (appBarLayout != null) {
            appBarLayout.addOnOffsetChangedListener((AppBarLayout.OnOffsetChangedListener) offsetUpdateListener);
        }
        this.mSearchButton = (ImageButton) findViewById(C11493R.id.search);
        this.mAudioPickerSearchView = (AudioPickerSearchView) findViewById(C11493R.id.search_view_container);
        this.mToolbar = (Toolbar) findViewById(C11493R.id.toolbar);
        this.mPikerListLayout = (LinearLayout) findViewById(C11493R.id.audio_picker_list_layout);
        ImageButton imageButton = this.mSearchButton;
        if (imageButton != null) {
            imageButton.setOnClickListener(new ViewOnClickListenerC11506a(this, 1));
        }
    }

    private final boolean isVisibleItemPosition(int position) {
        LinearLayoutManager linearLayoutManager = this.mLinearLayoutManager;
        Intrinsics.checkNotNull(linearLayoutManager);
        if (linearLayoutManager.findLastCompletelyVisibleItemPosition() < position) {
            return false;
        }
        LinearLayoutManager linearLayoutManager2 = this.mLinearLayoutManager;
        Intrinsics.checkNotNull(linearLayoutManager2);
        return linearLayoutManager2.findFirstCompletelyVisibleItemPosition() <= position;
    }

    private final void restoreSavedInstance(Bundle savedInstanceState) {
        if (savedInstanceState != null) {
            this.mRecordingMode = savedInstanceState.getInt(KEY_RECORDING_MODE);
            this.mSelectedMode = savedInstanceState.getInt(KEY_RECORDING_SELECTED_MODE);
            this.mSelectedItem = (RecordingItem) savedInstanceState.getParcelable(KEY_RECORDING_SELECTED);
            this.mCurrentSortType = savedInstanceState.getInt(KEY_RECORDING_SORT_BY);
            this.mCurrentSortOrder = savedInstanceState.getInt(KEY_RECORDING_SORT_ORDER);
            this.mIsSearchMode = savedInstanceState.getBoolean(KEY_IS_SEARCH_MODE);
        }
    }

    private final void setFocusToSelectItem() {
        Map<Integer, ArrayList<RecordingItem>> map = this.mAudioFileMap;
        if (map != null) {
            Intrinsics.checkNotNull(map);
            if (!map.containsKey(Integer.valueOf(this.mRecordingMode)) || this.mSelectedItem == null) {
                return;
            }
            Map<Integer, ArrayList<RecordingItem>> map2 = this.mAudioFileMap;
            Intrinsics.checkNotNull(map2);
            ArrayList<RecordingItem> arrayList = map2.get(Integer.valueOf(this.mRecordingMode));
            Intrinsics.checkNotNull(arrayList);
            RecordingItem recordingItem = this.mSelectedItem;
            Intrinsics.checkNotNull(recordingItem);
            int iIndexOf = arrayList.indexOf(recordingItem);
            if (iIndexOf < 0) {
                RecyclerView recyclerView = this.mListAudio;
                if (recyclerView != null) {
                    recyclerView.scrollToPosition(0);
                    return;
                }
                return;
            }
            if (isVisibleItemPosition(iIndexOf)) {
                RecyclerView recyclerView2 = this.mListAudio;
                if (recyclerView2 != null) {
                    recyclerView2.smoothScrollToPosition(iIndexOf);
                    return;
                }
                return;
            }
            RecyclerView recyclerView3 = this.mListAudio;
            if (recyclerView3 != null) {
                recyclerView3.scrollToPosition(iIndexOf);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setVerticalView(View view) {
        OffsetUpdateListener offsetUpdateListener = this.mOffsetUpdateListener;
        if (offsetUpdateListener == null) {
            return;
        }
        Intrinsics.checkNotNull(offsetUpdateListener);
        offsetUpdateListener.setVerticalView(view);
    }

    private final void shareAudio(String filePath) {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setDataAndType(FileProvider.getUriForFile(this, AUTHORITY, new File(filePath)), ConverterUtils.MIME_TYPE_AUDIO_ALL);
        intent.setFlags(1);
        startActivity(intent);
    }

    private final void updateDoneButton() {
        if (this.mSelectedItem != null) {
            FrameLayout frameLayout = this.mDoneButton;
            Intrinsics.checkNotNull(frameLayout);
            frameLayout.setVisibility(0);
        } else {
            FrameLayout frameLayout2 = this.mDoneButton;
            Intrinsics.checkNotNull(frameLayout2);
            frameLayout2.setVisibility(8);
        }
    }

    private final void updatePickerList() {
        updateDoneButton();
        int i = this.mRecordingMode;
        if (i == 0) {
            TextView textView = this.mNotesButton;
            if (textView != null) {
                textView.setSelected(true);
            }
            TextView textView2 = this.mCallButton;
            if (textView2 != null) {
                textView2.setSelected(false);
            }
            TextView textView3 = this.mVoiceRecorderButton;
            Intrinsics.checkNotNull(textView3);
            textView3.setSelected(false);
        } else if (i == 1) {
            TextView textView4 = this.mNotesButton;
            if (textView4 != null) {
                textView4.setSelected(false);
            }
            TextView textView5 = this.mCallButton;
            if (textView5 != null) {
                textView5.setSelected(true);
            }
            TextView textView6 = this.mVoiceRecorderButton;
            Intrinsics.checkNotNull(textView6);
            textView6.setSelected(false);
        } else if (i == 2) {
            TextView textView7 = this.mNotesButton;
            if (textView7 != null) {
                textView7.setSelected(false);
            }
            TextView textView8 = this.mCallButton;
            if (textView8 != null) {
                textView8.setSelected(false);
            }
            TextView textView9 = this.mVoiceRecorderButton;
            if (textView9 != null) {
                textView9.setSelected(true);
            }
        }
        AudioPickerListViewAdapter audioPickerListViewAdapter = this.mAdapter;
        if (audioPickerListViewAdapter != null) {
            audioPickerListViewAdapter.setRecordingMode(this.mRecordingMode);
        }
        AudioPickerListViewAdapter audioPickerListViewAdapter2 = this.mAdapter;
        if (audioPickerListViewAdapter2 != null) {
            audioPickerListViewAdapter2.sortItem(this.mCurrentSortType, this.mCurrentSortOrder);
        }
        setFocusToSelectItem();
    }

    @Override // com.samsung.android.support.senl.p148nt.stt.picker.view.AudioPickerListViewAdapterContract
    public void disableProgressBar() {
        SeslProgressBar seslProgressBar = this.mProgressBar;
        if (seslProgressBar != null) {
            Intrinsics.checkNotNull(seslProgressBar);
            if (seslProgressBar.getVisibility() == 0) {
                SeslProgressBar seslProgressBar2 = this.mProgressBar;
                Intrinsics.checkNotNull(seslProgressBar2);
                seslProgressBar2.setVisibility(8);
            }
        }
    }

    @Nullable
    public final AudioPickerListViewAdapter getMAdapter() {
        return this.mAdapter;
    }

    @Nullable
    public final TextView getMTitle() {
        return this.mTitle;
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        ArrayList<String> stringArrayListExtra;
        super.onActivityResult(requestCode, resultCode, data);
        if (data == null || resultCode != -1 || requestCode != 6 || this.mAudioPickerSearchView == null || (stringArrayListExtra = data.getStringArrayListExtra("android.speech.extra.RESULTS")) == null) {
            return;
        }
        String str = stringArrayListExtra.get(0);
        AudioPickerSearchView audioPickerSearchView = this.mAudioPickerSearchView;
        Intrinsics.checkNotNull(audioPickerSearchView);
        audioPickerSearchView.setQuery(str, true);
    }

    @Override // com.samsung.android.support.senl.p148nt.stt.picker.view.AudioPickerListViewAdapterContract
    public void onAudioPlay(@NotNull RecordingItem recordingItem) {
        Intrinsics.checkNotNullParameter(recordingItem, "recordingItem");
        Logger.m12710d(TAG, "Play audio");
        if (!recordingItem.getIsInternalPath()) {
            String path = recordingItem.getPath();
            Intrinsics.checkNotNull(path);
            shareAudio(path);
            return;
        }
        String path2 = recordingItem.getPath();
        Intrinsics.checkNotNull(path2);
        File file = new File(path2);
        String name = file.getName();
        Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
        String filePathToShare = getFilePathToShare(name);
        File file2 = new File(filePathToShare);
        if (!file2.exists()) {
            try {
                FileInputStream fileInputStream = new FileInputStream(file);
                try {
                    FileOutputStream fileOutputStream = new FileOutputStream(file2);
                    try {
                        byte[] bArr = new byte[(int) fileInputStream.getChannel().size()];
                        while (fileInputStream.read(bArr, 0, (int) fileInputStream.getChannel().size()) > 0) {
                            fileOutputStream.write(bArr);
                        }
                        Unit unit = Unit.INSTANCE;
                        CloseableKt.closeFinally(fileOutputStream, null);
                        CloseableKt.closeFinally(fileInputStream, null);
                    } finally {
                    }
                } finally {
                }
            } catch (Exception e) {
                e.printStackTrace();
                Logger.m12711e(TAG, "Copy file to share folder error");
            }
        }
        shareAudio(filePathToShare);
    }

    @Override // com.samsung.android.support.senl.p148nt.stt.picker.view.AudioPickerListViewAdapterContract
    public void onAudioSelected(@NotNull RecordingItem recordingItem) {
        Intrinsics.checkNotNullParameter(recordingItem, "recordingItem");
        Logger.m12710d(TAG, "Select audio");
        this.mSelectedItem = recordingItem;
        this.mSelectedMode = this.mRecordingMode;
        updateDoneButton();
        AudioPickerSearchView audioPickerSearchView = this.mAudioPickerSearchView;
        if (audioPickerSearchView != null) {
            Intrinsics.checkNotNull(audioPickerSearchView);
            if (audioPickerSearchView.getVisibility() == 0) {
                AudioPickerSearchPresenter audioPickerSearchPresenter = this.mSearchPresenter;
                Intrinsics.checkNotNull(audioPickerSearchPresenter);
                audioPickerSearchPresenter.hideSoftInput(false);
            }
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.stt.picker.view.listener.OnBackKeyListener
    public boolean onBackKeyDown() {
        AudioPickerSearchView audioPickerSearchView = this.mAudioPickerSearchView;
        if (audioPickerSearchView != null) {
            audioPickerSearchView.clearFocus();
        }
        AudioPickerSearchView audioPickerSearchView2 = this.mAudioPickerSearchView;
        if (audioPickerSearchView2 != null) {
            audioPickerSearchView2.setVisibility(8);
        }
        FragmentTransaction fragmentTransactionBeginTransaction = getSupportFragmentManager().beginTransaction();
        SearchFragment searchFragment = this.mSearchFragment;
        Intrinsics.checkNotNull(searchFragment);
        fragmentTransactionBeginTransaction.remove(searchFragment).commit();
        LinearLayout linearLayout = this.mPikerListLayout;
        if (linearLayout != null) {
            linearLayout.setVisibility(0);
        }
        Toolbar toolbar = this.mToolbar;
        if (toolbar != null) {
            toolbar.setVisibility(0);
        }
        setVerticalView(this.mNoResultText);
        this.mIsSearchMode = false;
        AudioPickerListViewAdapter audioPickerListViewAdapter = this.mAdapter;
        if (audioPickerListViewAdapter != null) {
            audioPickerListViewAdapter.notifyDataSetChanged();
        }
        AudioPickerListViewAdapter audioPickerListViewAdapter2 = this.mAdapter;
        if (audioPickerListViewAdapter2 != null && audioPickerListViewAdapter2.getItemCount() == 1) {
            updateNoResultView(true);
        }
        RecyclerView recyclerView = this.mListAudio;
        if (recyclerView != null) {
            recyclerView.scrollToPosition(0);
        }
        resetItemSelected();
        return true;
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        if (this.mIsSearchMode) {
            onBackKeyDown();
        } else {
            super.onBackPressed();
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getIntent().getIntExtra(ContentPickerUtils.AUDIO_PICKER_MODE, -1) == -1) {
            Logger.m12711e(TAG, "InvalidCreateCase");
            finish();
            return;
        }
        this.mRecordingMode = 2;
        this.mCurrentSortType = 2;
        this.mCurrentSortOrder = 5;
        restoreSavedInstance(savedInstanceState);
        initLayout();
        initData();
        initSearchPresenter();
        if (this.mIsSearchMode) {
            initSearchMode();
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        CursorProvider cursorProvider = this.mCursorProvider;
        if (cursorProvider != null) {
            Intrinsics.checkNotNull(cursorProvider);
            cursorProvider.unregisterObservers();
        }
        deleteShareFile();
        clear();
        Logger.m12710d(TAG, "onDestroy");
    }

    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onSaveInstanceState(@NotNull Bundle outState) {
        Intrinsics.checkNotNullParameter(outState, "outState");
        super.onSaveInstanceState(outState);
        Logger.m12710d(TAG, "onSaveInstanceState# ");
        outState.putInt(KEY_RECORDING_MODE, this.mRecordingMode);
        outState.putInt(KEY_RECORDING_SORT_BY, this.mCurrentSortType);
        outState.putInt(KEY_RECORDING_SORT_ORDER, this.mCurrentSortOrder);
        outState.putParcelable(KEY_RECORDING_SELECTED, this.mSelectedItem);
        outState.putInt(KEY_RECORDING_SELECTED_MODE, this.mSelectedMode);
        outState.putBoolean(KEY_IS_SEARCH_MODE, this.mIsSearchMode);
    }

    @Override // com.samsung.android.support.senl.p148nt.stt.picker.view.AudioPickerListViewAdapterContract
    public void onUpdateSortItem(int sortType, int sortOrder) {
        AudioPickerSearchView audioPickerSearchView = this.mAudioPickerSearchView;
        if (audioPickerSearchView != null) {
            Intrinsics.checkNotNull(audioPickerSearchView);
            if (audioPickerSearchView.getVisibility() == 0) {
                AudioPickerSearchPresenter audioPickerSearchPresenter = this.mSearchPresenter;
                Intrinsics.checkNotNull(audioPickerSearchPresenter);
                audioPickerSearchPresenter.updateSortItem(sortType, sortOrder);
                return;
            }
        }
        this.mCurrentSortType = sortType;
        this.mCurrentSortOrder = sortOrder;
        AudioPickerListViewAdapter audioPickerListViewAdapter = this.mAdapter;
        if (audioPickerListViewAdapter != null) {
            audioPickerListViewAdapter.sortItem(sortType, sortOrder);
        }
    }

    public final void resetItemSelected() {
        RecordingItem recordingItem = this.mSelectedItem;
        if (recordingItem != null) {
            if (recordingItem != null) {
                recordingItem.setSelected(false);
            }
            this.mSelectedItem = null;
        }
        updateDoneButton();
    }

    public final void setMAdapter(@Nullable AudioPickerListViewAdapter audioPickerListViewAdapter) {
        this.mAdapter = audioPickerListViewAdapter;
    }

    public final void setMTitle(@Nullable TextView textView) {
        this.mTitle = textView;
    }

    @Override // com.samsung.android.support.senl.p148nt.stt.picker.view.AudioPickerListViewAdapterContract
    public void updateNoResultView(boolean visible) {
        if (!visible || this.mIsSearchMode) {
            NestedScrollView nestedScrollView = this.mNoResultLayout;
            if (nestedScrollView != null) {
                Intrinsics.checkNotNull(nestedScrollView);
                if (nestedScrollView.getVisibility() != 8) {
                    NestedScrollView nestedScrollView2 = this.mNoResultLayout;
                    Intrinsics.checkNotNull(nestedScrollView2);
                    nestedScrollView2.setVisibility(8);
                }
            }
            RecyclerView recyclerView = this.mListAudio;
            if (recyclerView != null) {
                Intrinsics.checkNotNull(recyclerView);
                if (recyclerView.getVisibility() != 0) {
                    RecyclerView recyclerView2 = this.mListAudio;
                    Intrinsics.checkNotNull(recyclerView2);
                    recyclerView2.setVisibility(0);
                    return;
                }
                return;
            }
            return;
        }
        NestedScrollView nestedScrollView3 = this.mNoResultLayout;
        if (nestedScrollView3 != null) {
            Intrinsics.checkNotNull(nestedScrollView3);
            if (nestedScrollView3.getVisibility() != 0) {
                NestedScrollView nestedScrollView4 = this.mNoResultLayout;
                Intrinsics.checkNotNull(nestedScrollView4);
                nestedScrollView4.setVisibility(0);
            }
        }
        RecyclerView recyclerView3 = this.mListAudio;
        if (recyclerView3 != null) {
            Intrinsics.checkNotNull(recyclerView3);
            if (recyclerView3.getVisibility() != 8) {
                RecyclerView recyclerView4 = this.mListAudio;
                Intrinsics.checkNotNull(recyclerView4);
                recyclerView4.setVisibility(8);
            }
        }
    }
}
