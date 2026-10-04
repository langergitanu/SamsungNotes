package com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.list.common;

import android.app.Activity;
import android.os.Handler;
import android.text.InputFilter;
import android.text.Spanned;
import android.text.TextUtils;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import androidx.appcompat.widget.SearchView;
import com.samsung.android.support.senl.p148nt.base.winset.toast.ToastHandler;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.list.common.IBaseListContract;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.BackgroundColorUtil;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class ListSearchView {
    private static final String TAG = "ListSearchView";
    private final Activity mActivity;
    private final Handler mHandler = new Handler();
    private String mLastWord;
    private Runnable mRunnable;
    private EditText mSearchInputField;
    private final IBaseListContract.ISearchPresenter mSearchManager;
    private SearchView mSearchView;
    private View mSearchViewContainer;

    public ListSearchView(Activity activity, IBaseListContract.ISearchPresenter iSearchPresenter) {
        this.mActivity = activity;
        this.mSearchManager = iSearchPresenter;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void search(final String str) {
        if (this.mSearchViewContainer.getVisibility() != 0) {
            return;
        }
        this.mHandler.removeCallbacks(this.mRunnable);
        Runnable runnable = new Runnable() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.list.common.ListSearchView.4
            @Override // java.lang.Runnable
            public void run() {
                ListSearchView.this.mSearchManager.search(str);
            }
        };
        this.mRunnable = runnable;
        this.mHandler.postDelayed(runnable, 500L);
    }

    public View getKeyboardTargetView() {
        if (this.mSearchInputField.hasFocus()) {
            return this.mSearchInputField;
        }
        return null;
    }

    public EditText getPageSearchEditView() {
        if (this.mSearchViewContainer.getVisibility() == 0) {
            return this.mSearchInputField;
        }
        return null;
    }

    public View getSearchViewContainer() {
        return this.mSearchViewContainer;
    }

    public void hide() {
        Logger.m10999d(TAG, "hide# ");
        this.mSearchInputField.setText("");
        this.mHandler.removeCallbacks(this.mRunnable);
        this.mLastWord = "";
    }

    public void initSearchView(View view, View.OnFocusChangeListener onFocusChangeListener) {
        View viewFindViewById = view.findViewById(C9086R.id.comp_list_search_container);
        this.mSearchViewContainer = viewFindViewById;
        BackgroundColorUtil.updateAntiGreenishColor(viewFindViewById);
        SearchView searchView = (SearchView) this.mSearchViewContainer.findViewById(C9086R.id.comp_list_search);
        this.mSearchView = searchView;
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.list.common.ListSearchView.1
            @Override // androidx.appcompat.widget.SearchView.OnQueryTextListener
            public boolean onQueryTextChange(String str) {
                if (ListSearchView.this.mLastWord != null || !TextUtils.isEmpty(str)) {
                    ListSearchView.this.search(str);
                    ListSearchView.this.mLastWord = str;
                }
                if (!TextUtils.isEmpty(str)) {
                    return false;
                }
                ListSearchView.this.mSearchManager.onSearchCleared();
                return false;
            }

            @Override // androidx.appcompat.widget.SearchView.OnQueryTextListener
            public boolean onQueryTextSubmit(String str) {
                if (!str.equals(ListSearchView.this.mLastWord)) {
                    ListSearchView.this.mLastWord = str;
                    ListSearchView.this.search(str);
                }
                if (TextUtils.isEmpty(str)) {
                    return false;
                }
                ListSearchView.this.mSearchManager.submitSearchKeyword(str);
                return false;
            }
        });
        EditText editText = (EditText) this.mSearchView.findViewById(C9086R.id.search_src_text);
        this.mSearchInputField = editText;
        editText.setPrivateImeOptions("disableImage=true");
        this.mSearchInputField.setFilters(new InputFilter[]{new InputFilter.LengthFilter(199) { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.list.common.ListSearchView.2
            @Override // android.text.InputFilter.LengthFilter, android.text.InputFilter
            public CharSequence filter(CharSequence charSequence, int i, int i2, Spanned spanned, int i4, int i5) {
                CharSequence charSequenceFilter = super.filter(charSequence, i, i2, spanned, i4, i5);
                if (charSequenceFilter != null) {
                    ToastHandler.show(ListSearchView.this.mActivity, ListSearchView.this.mActivity.getResources().getString(C9086R.string.ss_maximum_number_of_characters_exceeded, 199), 1);
                }
                return charSequenceFilter;
            }
        }});
        this.mSearchInputField.setOnFocusChangeListener(onFocusChangeListener);
        ImageView imageViewSeslGetUpButton = this.mSearchView.seslGetUpButton();
        imageViewSeslGetUpButton.setVisibility(0);
        imageViewSeslGetUpButton.setOnClickListener(new View.OnClickListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.list.common.ListSearchView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                ListSearchView.this.mSearchManager.onNavigateUpClicked();
            }
        });
    }

    public void onClearSearchResult() {
        this.mLastWord = "";
    }

    public void onTouch(MotionEvent motionEvent) {
        new GestureDetector(this.mActivity, new GestureDetector.SimpleOnGestureListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.list.common.ListSearchView.5
            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onScroll(MotionEvent motionEvent2, MotionEvent motionEvent3, float f, float f4) {
                if (!ListSearchView.this.mSearchInputField.hasFocus() || Math.abs(f4) <= 20.0f) {
                    return false;
                }
                ListSearchView.this.mSearchManager.minimizeSoftInput(ListSearchView.this.mSearchInputField);
                return false;
            }
        }).onTouchEvent(motionEvent);
    }

    public void show(String str) {
        this.mSearchView.onActionViewExpanded();
        this.mSearchInputField.requestFocus();
        if (!TextUtils.isEmpty(str)) {
            this.mSearchInputField.setText(str);
            this.mSearchInputField.setSelection(str.length());
        }
        this.mSearchManager.showSoftInput(this.mSearchInputField);
    }
}
