package com.samsung.android.support.senl.p148nt.stt.picker.presenter;

import android.app.Activity;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.RecyclerView;
import com.samsung.android.support.senl.p145cm.base.framework.p146os.SystemPropertiesCompat;
import com.samsung.android.support.senl.p145cm.base.framework.view.InputMethodCompat;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.contextmenu.RunnableC9767a;
import com.samsung.android.support.senl.p148nt.stt.common.Logger;
import com.samsung.android.support.senl.p148nt.stt.picker.presenter.AudioPickerSearchPresenter;
import com.samsung.android.support.senl.p148nt.stt.picker.view.AudioPickerSearchView;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.collections.AbstractC12991c;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(m13885d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0006\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0002+1\u0018\u0000 52\u00020\u0001:\u0003567B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0007J\u000e\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\tJ\u000e\u0010\u0011\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\u0013J\u0018\u0010\u0014\u001a\u00020\r2\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0017\u001a\u00020\u0018J\u0016\u0010\u0019\u001a\u00020\r2\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001bJ\u000e\u0010\u001d\u001a\u00020\r2\u0006\u0010\u001e\u001a\u00020\u001fJ\u000e\u0010 \u001a\u00020\r2\u0006\u0010\u001e\u001a\u00020\u001fJ\u0006\u0010!\u001a\u00020\rJ\u0010\u0010\"\u001a\u00020\r2\b\u0010#\u001a\u0004\u0018\u00010$J\u0006\u0010%\u001a\u00020\u0016J\u000e\u0010-\u001a\u00020\r2\u0006\u0010.\u001a\u00020\u0018J\b\u0010/\u001a\u00020\rH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020'X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020)X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010*\u001a\u00020+X\u0082\u0004¢\u0006\u0004\n\u0002\u0010,R\u0010\u00100\u001a\u000201X\u0082\u0004¢\u0006\u0004\n\u0002\u00102R\u000e\u00103\u001a\u000204X\u0082\u0004¢\u0006\u0002\n\u0000¨\u00068"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/stt/picker/presenter/AudioPickerSearchPresenter;", "", "mActivity", "Landroid/app/Activity;", "<init>", "(Landroid/app/Activity;)V", "mViewContract", "Lcom/samsung/android/support/senl/nt/stt/picker/presenter/AudioPickerSearchPresenter$ViewContract;", "mPresenterContract", "Lcom/samsung/android/support/senl/nt/stt/picker/presenter/AudioPickerSearchPresenter$PresenterContract;", "mHandler", "Landroid/os/Handler;", "setContract", "", "viewContract", "setPresenterContract", "presenterContract", "setOnSearchListener", "notesSearchView", "Lcom/samsung/android/support/senl/nt/stt/picker/view/AudioPickerSearchView;", "requestSearch", "query", "", "submit", "", "updateSortItem", "sortType", "", "sortOrder", "removeOnScrollListener", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "addOnScrollListener", "resetItemSelected", "setVerticalView", "view", "Landroid/view/View;", "getSearchTag", "mScrollListener", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "mSearchTextListener", "Landroidx/appcompat/widget/SearchView$OnQueryTextListener;", "mOnSearchVoiceClickListener", "com/samsung/android/support/senl/nt/stt/picker/presenter/AudioPickerSearchPresenter$mOnSearchVoiceClickListener$1", "Lcom/samsung/android/support/senl/nt/stt/picker/presenter/AudioPickerSearchPresenter$mOnSearchVoiceClickListener$1;", "hideSoftInput", "useHideConcept", "minimizeSoftInput", "mOnSearchEnterClickListener", "com/samsung/android/support/senl/nt/stt/picker/presenter/AudioPickerSearchPresenter$mOnSearchEnterClickListener$1", "Lcom/samsung/android/support/senl/nt/stt/picker/presenter/AudioPickerSearchPresenter$mOnSearchEnterClickListener$1;", "mMinimiseRunnable", "Ljava/lang/Runnable;", "Companion", "ViewContract", "PresenterContract", "ntStt_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class AudioPickerSearchPresenter {
    public static final int REQUEST_SPEECH_TO_TEXT = 6;

    @NotNull
    private static final String TAG = "AudioPickerSearchPresenter";

    @NotNull
    private final Activity mActivity;

    @NotNull
    private final Handler mHandler;

    @NotNull
    private final Runnable mMinimiseRunnable;

    @NotNull
    private final AudioPickerSearchPresenter$mOnSearchEnterClickListener$1 mOnSearchEnterClickListener;

    @NotNull
    private final AudioPickerSearchPresenter$mOnSearchVoiceClickListener$1 mOnSearchVoiceClickListener;

    @Nullable
    private PresenterContract mPresenterContract;

    @NotNull
    private final RecyclerView.OnScrollListener mScrollListener;

    @NotNull
    private final SearchView.OnQueryTextListener mSearchTextListener;

    @Nullable
    private ViewContract mViewContract;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0005H&J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0005H&J\u0018\u0010\u000b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\rH&¨\u0006\u000f"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/stt/picker/presenter/AudioPickerSearchPresenter$PresenterContract;", "", "onQueryTextSubmit", "", "query", "", "onQueryTextChange", "newText", "onSearchEnterClick", "", "searchString", "updateSortItem", "sortType", "", "sortOrder", "ntStt_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public interface PresenterContract {
        boolean onQueryTextChange(@NotNull String newText);

        boolean onQueryTextSubmit(@NotNull String query);

        void onSearchEnterClick(@NotNull String searchString);

        void updateSortItem(int sortType, int sortOrder);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\b\u001a\u00020\tH&J\u0012\u0010\n\u001a\u00020\t2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH&R\u0014\u0010\u0004\u001a\u0004\u0018\u00010\u0005X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\r"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/stt/picker/presenter/AudioPickerSearchPresenter$ViewContract;", "", "hasSearchView", "", "searchView", "Lcom/samsung/android/support/senl/nt/stt/picker/view/AudioPickerSearchView;", "getSearchView", "()Lcom/samsung/android/support/senl/nt/stt/picker/view/AudioPickerSearchView;", "resetItemSelected", "", "setVerticalView", "view", "Landroid/view/View;", "ntStt_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public interface ViewContract {
        @Nullable
        AudioPickerSearchView getSearchView();

        boolean hasSearchView();

        void resetItemSelected();

        void setVerticalView(@Nullable View view);
    }

    /* JADX WARN: Type inference failed for: r2v4, types: [com.samsung.android.support.senl.nt.stt.picker.presenter.AudioPickerSearchPresenter$mOnSearchVoiceClickListener$1] */
    /* JADX WARN: Type inference failed for: r2v5, types: [com.samsung.android.support.senl.nt.stt.picker.presenter.AudioPickerSearchPresenter$mOnSearchEnterClickListener$1] */
    public AudioPickerSearchPresenter(@NotNull Activity mActivity) {
        Intrinsics.checkNotNullParameter(mActivity, "mActivity");
        this.mActivity = mActivity;
        Looper looperMyLooper = Looper.myLooper();
        Intrinsics.checkNotNull(looperMyLooper);
        this.mHandler = new Handler(looperMyLooper);
        this.mScrollListener = new RecyclerView.OnScrollListener() { // from class: com.samsung.android.support.senl.nt.stt.picker.presenter.AudioPickerSearchPresenter$mScrollListener$1
            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
                super.onScrollStateChanged(recyclerView, newState);
                if (newState != 1) {
                    return;
                }
                this.this$0.hideSoftInput(true);
            }
        };
        this.mSearchTextListener = new SearchView.OnQueryTextListener() { // from class: com.samsung.android.support.senl.nt.stt.picker.presenter.AudioPickerSearchPresenter$mSearchTextListener$1
            @Override // androidx.appcompat.widget.SearchView.OnQueryTextListener
            public boolean onQueryTextChange(String newText) {
                Intrinsics.checkNotNullParameter(newText, "newText");
                if (this.this$0.mViewContract != null) {
                    AudioPickerSearchPresenter.ViewContract viewContract = this.this$0.mViewContract;
                    Intrinsics.checkNotNull(viewContract);
                    if (!viewContract.hasSearchView()) {
                        return true;
                    }
                }
                if (this.this$0.mPresenterContract == null) {
                    return true;
                }
                Logger.m12710d("AudioPickerSearchPresenter", "onQueryTextChange");
                AudioPickerSearchPresenter.PresenterContract presenterContract = this.this$0.mPresenterContract;
                Intrinsics.checkNotNull(presenterContract);
                return presenterContract.onQueryTextChange(newText);
            }

            @Override // androidx.appcompat.widget.SearchView.OnQueryTextListener
            public boolean onQueryTextSubmit(String query) {
                Intrinsics.checkNotNullParameter(query, "query");
                Logger.m12710d("AudioPickerSearchPresenter", "onQueryTextSubmit");
                if (this.this$0.mViewContract != null) {
                    AudioPickerSearchPresenter.ViewContract viewContract = this.this$0.mViewContract;
                    Intrinsics.checkNotNull(viewContract);
                    if (viewContract.hasSearchView()) {
                        AudioPickerSearchPresenter.ViewContract viewContract2 = this.this$0.mViewContract;
                        Intrinsics.checkNotNull(viewContract2);
                        AudioPickerSearchView searchView = viewContract2.getSearchView();
                        Intrinsics.checkNotNull(searchView);
                        searchView.clearFocus();
                    }
                }
                if (this.this$0.mPresenterContract == null) {
                    return false;
                }
                AudioPickerSearchPresenter.PresenterContract presenterContract = this.this$0.mPresenterContract;
                Intrinsics.checkNotNull(presenterContract);
                return presenterContract.onQueryTextSubmit(query);
            }
        };
        this.mOnSearchVoiceClickListener = new AudioPickerSearchView.OnSearchVoiceClickListener() { // from class: com.samsung.android.support.senl.nt.stt.picker.presenter.AudioPickerSearchPresenter$mOnSearchVoiceClickListener$1
            @Override // com.samsung.android.support.senl.nt.stt.picker.view.AudioPickerSearchView.OnSearchVoiceClickListener
            public void onSearchVoiceClick() {
                try {
                    Logger.m12713i("AudioPickerSearchPresenter", "onSearchVoiceClick");
                    this.this$0.hideSoftInput(false);
                    Intent intent = new Intent("android.speech.action.RECOGNIZE_SPEECH");
                    intent.putExtra("android.speech.extra.LANGUAGE_MODEL", "free_form");
                    intent.putExtra("android.speech.extra.LANGUAGE", Locale.getDefault());
                    this.this$0.mActivity.startActivityForResult(intent, 6);
                } catch (Exception e) {
                    AbstractC12991c.m14005z("Exception : ", e.getMessage(), "AudioPickerSearchPresenter");
                }
            }
        };
        this.mOnSearchEnterClickListener = new AudioPickerSearchView.OnSearchEnterClickListener() { // from class: com.samsung.android.support.senl.nt.stt.picker.presenter.AudioPickerSearchPresenter$mOnSearchEnterClickListener$1
            @Override // com.samsung.android.support.senl.nt.stt.picker.view.AudioPickerSearchView.OnSearchEnterClickListener
            public void onSearchEnterClick(String searchString) {
                Intrinsics.checkNotNullParameter(searchString, "searchString");
                if (this.this$0.mViewContract == null || this.this$0.mPresenterContract == null) {
                    return;
                }
                AudioPickerSearchPresenter.ViewContract viewContract = this.this$0.mViewContract;
                AudioPickerSearchView searchView = viewContract != null ? viewContract.getSearchView() : null;
                Intrinsics.checkNotNull(searchView);
                searchView.clearFocus();
                AudioPickerSearchPresenter.PresenterContract presenterContract = this.this$0.mPresenterContract;
                if (presenterContract != null) {
                    presenterContract.onSearchEnterClick(searchString);
                }
            }
        };
        this.mMinimiseRunnable = new RunnableC9767a(this, 25);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void mMinimiseRunnable$lambda$0(AudioPickerSearchPresenter audioPickerSearchPresenter) {
        if (SystemPropertiesCompat.INSTANCE.getInstance().isUSAModel()) {
            InputMethodCompat companion = InputMethodCompat.INSTANCE.getInstance();
            Activity activity = audioPickerSearchPresenter.mActivity;
            ViewContract viewContract = audioPickerSearchPresenter.mViewContract;
            companion.minimizeSoftInput(activity, viewContract != null ? viewContract.getSearchView() : null, true);
        }
    }

    private final void minimizeSoftInput() {
        this.mHandler.removeCallbacks(this.mMinimiseRunnable);
        this.mHandler.post(this.mMinimiseRunnable);
    }

    public final void addOnScrollListener(@NotNull RecyclerView recyclerView) {
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        recyclerView.addOnScrollListener(this.mScrollListener);
    }

    @NotNull
    public final String getSearchTag() {
        AudioPickerSearchView searchView;
        ViewContract viewContract;
        AudioPickerSearchView searchView2;
        ViewContract viewContract2 = this.mViewContract;
        if (viewContract2 != null && !viewContract2.hasSearchView() && (viewContract = this.mViewContract) != null && (searchView2 = viewContract.getSearchView()) != null && searchView2.getVisibility() == 0) {
            return "";
        }
        Logger.m12713i(TAG, "getSearchTag");
        ViewContract viewContract3 = this.mViewContract;
        return String.valueOf((viewContract3 == null || (searchView = viewContract3.getSearchView()) == null) ? null : searchView.getQuery());
    }

    public final void hideSoftInput(boolean useHideConcept) {
        Logger.m12713i(TAG, "hideSoftInput : " + useHideConcept);
        Object systemService = this.mActivity.getSystemService("input_method");
        InputMethodManager inputMethodManager = systemService instanceof InputMethodManager ? (InputMethodManager) systemService : null;
        if (inputMethodManager == null) {
            return;
        }
        ViewContract viewContract = this.mViewContract;
        AudioPickerSearchView searchView = viewContract != null ? viewContract.getSearchView() : null;
        if (!useHideConcept) {
            InputMethodCompat.INSTANCE.getInstance().hideSoftInput(this.mActivity.getApplicationContext(), searchView);
            if (searchView != null) {
                searchView.clearFocus();
                return;
            }
            return;
        }
        if (SystemPropertiesCompat.INSTANCE.getInstance().isUSAModel() && inputMethodManager.isActive()) {
            minimizeSoftInput();
            return;
        }
        InputMethodCompat.INSTANCE.getInstance().hideSoftInput(this.mActivity.getApplicationContext(), searchView);
        if (searchView != null) {
            searchView.clearFocus();
        }
    }

    public final void removeOnScrollListener(@NotNull RecyclerView recyclerView) {
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        recyclerView.removeOnScrollListener(this.mScrollListener);
    }

    public final void requestSearch(@Nullable String query, boolean submit) {
        AudioPickerSearchView searchView;
        ViewContract viewContract;
        AudioPickerSearchView searchView2;
        ViewContract viewContract2 = this.mViewContract;
        if (viewContract2 == null) {
            return;
        }
        Intrinsics.checkNotNull(viewContract2);
        if (viewContract2.hasSearchView() || (viewContract = this.mViewContract) == null || (searchView2 = viewContract.getSearchView()) == null || searchView2.getVisibility() != 0) {
            Logger.m12713i(TAG, "requestSearch#query " + query);
            ViewContract viewContract3 = this.mViewContract;
            if (viewContract3 == null || (searchView = viewContract3.getSearchView()) == null) {
                return;
            }
            searchView.setQuery(query, submit);
        }
    }

    public final void resetItemSelected() {
        ViewContract viewContract = this.mViewContract;
        if (viewContract == null) {
            return;
        }
        Intrinsics.checkNotNull(viewContract);
        viewContract.resetItemSelected();
    }

    public final void setContract(@NotNull ViewContract viewContract) {
        Intrinsics.checkNotNullParameter(viewContract, "viewContract");
        this.mViewContract = viewContract;
    }

    public final void setOnSearchListener(@NotNull AudioPickerSearchView notesSearchView) {
        Intrinsics.checkNotNullParameter(notesSearchView, "notesSearchView");
        notesSearchView.setOnQueryTextListener(this.mSearchTextListener);
        notesSearchView.setOnSearchVoiceClickListener(this.mOnSearchVoiceClickListener);
        notesSearchView.setOnSearchEnterClickListener(this.mOnSearchEnterClickListener);
    }

    public final void setPresenterContract(@NotNull PresenterContract presenterContract) {
        Intrinsics.checkNotNullParameter(presenterContract, "presenterContract");
        this.mPresenterContract = presenterContract;
    }

    public final void setVerticalView(@Nullable View view) {
        ViewContract viewContract = this.mViewContract;
        if (viewContract == null) {
            return;
        }
        Intrinsics.checkNotNull(viewContract);
        viewContract.setVerticalView(view);
    }

    public final void updateSortItem(int sortType, int sortOrder) {
        PresenterContract presenterContract = this.mPresenterContract;
        if (presenterContract != null) {
            presenterContract.updateSortItem(sortType, sortOrder);
        }
    }
}
