package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.view;

import android.app.Activity;
import android.content.Intent;
import android.os.Handler;
import android.text.InputFilter;
import android.text.Spanned;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import androidx.appcompat.widget.SearchView;
import com.samsung.android.support.senl.p145cm.base.common.util.ResourceUtils;
import com.samsung.android.support.senl.p145cm.base.framework.view.ViewCompat;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.base.widget.search.VoiceButtonHelper;
import com.samsung.android.support.senl.p148nt.base.winset.toast.ToastHandler;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.common.AiConstants;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.presenter.STTTabletLayoutAction;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.view.AiMenuResultTopView;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.ComposerRequestCode;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.voice.stt.ISTTWindow;
import com.samsung.android.support.senl.p148nt.stt.presenter.AiMenuSTTSearchListener;
import com.samsung.android.support.senl.p148nt.stt.presenter.STTPresenter;
import com.samsung.android.support.senl.p148nt.stt.presenter.STTSearchPresenter;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class AiMenuResultSTTSearchView implements AiMenuSTTSearchListener {
    private static final int MAX_SEARCH_TEXT = 50;
    private static final int SEARCH_DELAY = 300;
    private static final String TAG = Logger.createTag("AiMenuResultTopSTTSearchView", AiConstants.PREFIX_TAG);
    private View mBackBtn;
    private ImageView mBackwardBtn;
    private View mBottomSearchLayout;
    private ImageView mCloseBtn;
    private ImageView mForwardBtn;
    private Handler mHandler = new Handler();
    private AiMenuResultTopView.Contract mResultViewContract;
    private SearchView mSTTSearchView;
    private View.OnLayoutChangeListener mSearchLayoutOnLayoutChangeListener;
    private Runnable mSearchRunnable;
    private EditText mSearchText;
    private View mTopContainer;
    private View mTopSearchLayout;

    public AiMenuResultSTTSearchView(AiMenuResultTopView.Contract contract) {
        this.mResultViewContract = contract;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public STTSearchPresenter getSTTSearchPresenter() {
        AiMenuResultTopView.Contract contract = this.mResultViewContract;
        if (contract == null) {
            Logger.m11000e(TAG, "mContract = null");
            return null;
        }
        STTTabletLayoutAction sTTTabletLayoutAction = contract.getPresenter().getSTTTabletLayoutAction();
        if (sTTTabletLayoutAction == null) {
            Logger.m11000e(TAG, "sttTabletLayoutAction = null");
            return null;
        }
        ISTTWindow.IAIContract iAiSTTContract = sTTTabletLayoutAction.getIAiSTTContract();
        if (iAiSTTContract == null) {
            Logger.m11000e(TAG, "aiContract = null");
            return null;
        }
        STTPresenter sTTPresenter = iAiSTTContract.getSTTPresenter();
        if (sTTPresenter != null) {
            return sTTPresenter.getMSTTSearchPresenter();
        }
        Logger.m11000e(TAG, "sttPresenter = null");
        return null;
    }

    private void initButtons() {
        this.mForwardBtn = (ImageView) this.mBottomSearchLayout.findViewById(C9086R.id.stt_search_view_forward_btn);
        this.mBackwardBtn = (ImageView) this.mBottomSearchLayout.findViewById(C9086R.id.stt_search_view_backward_btn);
        this.mCloseBtn = (ImageView) this.mTopSearchLayout.findViewById(C9086R.id.ai_menu_result_top_stt_search_close_btn);
        this.mBackBtn = this.mTopSearchLayout.findViewById(C9086R.id.ai_menu_result_top_stt_search_back_btn);
        this.mForwardBtn.setEnabled(false);
        this.mBackwardBtn.setEnabled(false);
        ViewCompat.getInstance().setTooltipText(this.mForwardBtn);
        ViewCompat.getInstance().setTooltipText(this.mBackwardBtn);
        ViewCompat.getInstance().setTooltipText(this.mCloseBtn);
        this.mForwardBtn.setOnClickListener(new View.OnClickListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.view.AiMenuResultSTTSearchView.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AiMenuResultSTTSearchView.this.getSTTSearchPresenter() == null) {
                    return;
                }
                AiMenuResultSTTSearchView.this.getSTTSearchPresenter().searchForward();
                AiMenuResultSTTSearchView.this.updateMoveButton();
            }
        });
        this.mBackwardBtn.setOnClickListener(new View.OnClickListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.view.AiMenuResultSTTSearchView.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AiMenuResultSTTSearchView.this.getSTTSearchPresenter() == null) {
                    return;
                }
                AiMenuResultSTTSearchView.this.getSTTSearchPresenter().searchBackward();
                AiMenuResultSTTSearchView.this.updateMoveButton();
            }
        });
        this.mCloseBtn.setOnClickListener(new View.OnClickListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.view.AiMenuResultSTTSearchView.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AiMenuResultSTTSearchView.this.mResultViewContract != null) {
                    AiMenuResultSTTSearchView.this.mResultViewContract.close();
                }
            }
        });
        this.mBackBtn.setOnClickListener(new View.OnClickListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.view.AiMenuResultSTTSearchView.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AiMenuResultSTTSearchView.this.getSTTSearchPresenter() == null) {
                    return;
                }
                AiMenuResultSTTSearchView.this.getSTTSearchPresenter().onBackPressed();
            }
        });
    }

    private void initContainerViews(View view) {
        View viewFindViewById = view.findViewById(C9086R.id.ai_menu_result_top_container);
        this.mTopContainer = viewFindViewById;
        if (viewFindViewById == null) {
            return;
        }
        View viewFindViewById2 = view.findViewById(C9086R.id.stt_search_top_view_layout);
        this.mTopSearchLayout = viewFindViewById2;
        viewFindViewById2.setOnTouchListener(new View.OnTouchListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.view.AiMenuResultSTTSearchView.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view2, MotionEvent motionEvent) {
                return true;
            }
        });
        this.mTopSearchLayout.setOnHoverListener(new View.OnHoverListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.view.AiMenuResultSTTSearchView.2
            @Override // android.view.View.OnHoverListener
            public boolean onHover(View view2, MotionEvent motionEvent) {
                return true;
            }
        });
        this.mBottomSearchLayout = view.findViewById(C9086R.id.ai_menu_result_floating_bottom_search_view);
    }

    private void initSTTSearchCallbacks() {
        updateMoveButton(false, false);
        if (getSTTSearchPresenter() != null) {
            getSTTSearchPresenter().setAiMenuSTTSearchListener(this);
        }
    }

    private void initSearchText() {
        EditText editText = (EditText) this.mSTTSearchView.findViewById(C9086R.id.search_src_text);
        this.mSearchText = editText;
        editText.setPrivateImeOptions("disableImage=true;disableWritingToolkit=true");
        this.mSearchText.setFilters(new InputFilter[]{new InputFilter.LengthFilter(50) { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.view.AiMenuResultSTTSearchView.10
            @Override // android.text.InputFilter.LengthFilter, android.text.InputFilter
            public CharSequence filter(CharSequence charSequence, int i, int i2, Spanned spanned, int i4, int i5) {
                CharSequence charSequenceFilter = super.filter(charSequence, i, i2, spanned, i4, i5);
                if (charSequenceFilter != null) {
                    ToastHandler.show(AiMenuResultSTTSearchView.this.mResultViewContract.getPresenter().getActivity(), AiMenuResultSTTSearchView.this.mResultViewContract.getPresenter().getActivity().getResources().getString(C9086R.string.ss_maximum_number_of_characters_exceeded, 50), 1);
                }
                return charSequenceFilter;
            }
        }});
        this.mSearchText.setTextSize(2, 17.0f);
    }

    private void initSearchView() {
        SearchView searchView = (SearchView) this.mBottomSearchLayout.findViewById(C9086R.id.stt_search_view);
        this.mSTTSearchView = searchView;
        searchView.setFocusableInTouchMode(true);
        this.mSTTSearchView.seslGetAutoCompleteView().setOnTouchListener(new View.OnTouchListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.view.AiMenuResultSTTSearchView.3
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() != 0) {
                    return false;
                }
                if (!AiMenuResultSTTSearchView.this.mResultViewContract.getPresenter().isSTTSearchMode()) {
                    return true;
                }
                AiMenuResultSTTSearchView.this.mResultViewContract.getPresenter().getSoftInputManager().setTemporarySoftInputMode(16);
                return false;
            }
        });
        this.mSTTSearchView.setOnQueryTextFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.view.AiMenuResultSTTSearchView.4
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                AbstractC8014b.m7224z("onFocusChange# mSTTSearchView ", AiMenuResultSTTSearchView.TAG, z);
                if (!z) {
                    AiMenuResultSTTSearchView.this.mResultViewContract.getPresenter().getSoftInputManager().hide(false);
                }
                if (AiMenuResultSTTSearchView.this.getSTTSearchPresenter() == null) {
                    return;
                }
                AiMenuResultSTTSearchView.this.updateMoveButton();
            }
        });
        this.mSTTSearchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.view.AiMenuResultSTTSearchView.5
            @Override // androidx.appcompat.widget.SearchView.OnQueryTextListener
            public boolean onQueryTextChange(final String str) {
                AiMenuResultSTTSearchView.this.mHandler.removeCallbacks(AiMenuResultSTTSearchView.this.mSearchRunnable);
                AiMenuResultSTTSearchView.this.mSearchRunnable = new Runnable() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.view.AiMenuResultSTTSearchView.5.2
                    @Override // java.lang.Runnable
                    public void run() {
                        if (AiMenuResultSTTSearchView.this.getSTTSearchPresenter() == null) {
                            return;
                        }
                        AiMenuResultSTTSearchView.this.getSTTSearchPresenter().search(str);
                        AiMenuResultSTTSearchView.this.mSearchRunnable = null;
                        AiMenuResultSTTSearchView.this.updateMoveButton();
                    }
                };
                AiMenuResultSTTSearchView.this.mHandler.postDelayed(AiMenuResultSTTSearchView.this.mSearchRunnable, 300L);
                if (!TextUtils.isEmpty(str)) {
                    AiMenuResultSTTSearchView.this.setMoveButtonVisibility(0);
                    return false;
                }
                if (AiMenuResultSTTSearchView.this.getSTTSearchPresenter() == null) {
                    return false;
                }
                AiMenuResultSTTSearchView.this.getSTTSearchPresenter().clearSearchInfo();
                AiMenuResultSTTSearchView.this.setMoveButtonVisibility(8);
                return false;
            }

            @Override // androidx.appcompat.widget.SearchView.OnQueryTextListener
            public boolean onQueryTextSubmit(String str) {
                if (AiMenuResultSTTSearchView.this.getSTTSearchPresenter() == null) {
                    return false;
                }
                if (AiMenuResultSTTSearchView.this.mSearchRunnable == null) {
                    AiMenuResultSTTSearchView.this.getSTTSearchPresenter().searchForward();
                    AiMenuResultSTTSearchView.this.updateMoveButton();
                } else {
                    AiMenuResultSTTSearchView.this.mHandler.removeCallbacks(AiMenuResultSTTSearchView.this.mSearchRunnable);
                    AiMenuResultSTTSearchView.this.mSearchRunnable.run();
                    AiMenuResultSTTSearchView.this.mSearchRunnable = new Runnable() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.view.AiMenuResultSTTSearchView.5.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (AiMenuResultSTTSearchView.this.getSTTSearchPresenter() == null) {
                                return;
                            }
                            AiMenuResultSTTSearchView.this.getSTTSearchPresenter().searchForward();
                            AiMenuResultSTTSearchView.this.mSearchRunnable = null;
                            AiMenuResultSTTSearchView.this.updateMoveButton();
                        }
                    };
                    AiMenuResultSTTSearchView.this.mHandler.postDelayed(AiMenuResultSTTSearchView.this.mSearchRunnable, 300L);
                }
                return false;
            }
        });
        View viewFindViewById = this.mSTTSearchView.findViewById(C9086R.id.search_plate);
        ViewGroup.LayoutParams layoutParams = viewFindViewById.getLayoutParams();
        layoutParams.height = (int) ResourceUtils.convertDpToPixel(this.mSTTSearchView.getContext(), 52.0f);
        viewFindViewById.setLayoutParams(layoutParams);
    }

    private void initVoiceButton() {
        final Activity activity = this.mResultViewContract.getPresenter().getActivity();
        if (activity == null) {
            return;
        }
        VoiceButtonHelper.setSearchableInfo(this.mSTTSearchView, activity.getComponentName());
        VoiceButtonHelper.setVoiceButtonListener(this.mSTTSearchView, new View.OnClickListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.view.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f6939a.lambda$initVoiceButton$0(activity, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initVoiceButton$0(Activity activity, View view) {
        if (activity == null) {
            return;
        }
        boolean zIsSviEnabled = VoiceButtonHelper.isSviEnabled(this.mSTTSearchView);
        Intent intentMakeVoiceRecognizerIntent = VoiceButtonHelper.makeVoiceRecognizerIntent(zIsSviEnabled);
        this.mResultViewContract.getPresenter().getSoftInputManager().hide(this.mSTTSearchView);
        activity.startActivityForResult(intentMakeVoiceRecognizerIntent, (zIsSviEnabled ? ComposerRequestCode.SearchVoiceSTTSvi : ComposerRequestCode.SearchVoiceSTT).getId());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setMoveButtonVisibility(int i) {
        this.mForwardBtn.setVisibility(i);
        this.mBackwardBtn.setVisibility(i);
        this.mBottomSearchLayout.findViewById(C9086R.id.stt_search_view_divider).setVisibility(i);
    }

    public View getView() {
        return this.mSTTSearchView;
    }

    public void hideSearchView() {
        View view = this.mTopContainer;
        if (view == null || this.mBottomSearchLayout == null) {
            return;
        }
        View viewFindViewById = view.findViewById(C9086R.id.ai_menu_result_top_title_menu_container);
        if (viewFindViewById != null) {
            viewFindViewById.setVisibility(0);
        }
        this.mTopSearchLayout.setVisibility(8);
        this.mBottomSearchLayout.setVisibility(8);
        this.mSearchText.setText("");
        this.mSTTSearchView.onActionViewCollapsed();
        this.mSearchRunnable = null;
    }

    public void init(View view) {
        initContainerViews(view);
        initSearchView();
        initButtons();
        initSearchText();
        initVoiceButton();
        initSTTSearchCallbacks();
    }

    @Override // com.samsung.android.support.senl.p148nt.stt.presenter.AiMenuSTTSearchListener
    public void onResultViewMinimize(boolean z) {
        if (z) {
            this.mBottomSearchLayout.setVisibility(8);
        } else {
            this.mBottomSearchLayout.setVisibility(0);
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.stt.presenter.AiMenuSTTSearchListener
    public void onSearchDone() {
        updateMoveButton();
    }

    public void search(String str) {
        getSTTSearchPresenter().search(str);
    }

    public void searchForward() {
        getSTTSearchPresenter().searchForward();
    }

    public void searchLatest() {
        getSTTSearchPresenter().searchLatest();
    }

    public void searchPosition(int i) {
        getSTTSearchPresenter().searchPosition(i);
    }

    public void setVoiceSearchText(String str) {
        this.mSearchText.setText(str);
        this.mSearchText.setSelection(str.length());
    }

    public void showSearchView() {
        View view = this.mTopContainer;
        if (view == null || this.mBottomSearchLayout == null) {
            return;
        }
        View viewFindViewById = view.findViewById(C9086R.id.ai_menu_result_top_title_menu_container);
        if (viewFindViewById != null) {
            viewFindViewById.setVisibility(8);
        }
        this.mSTTSearchView.seslSetUpButtonVisibility(8);
        this.mTopSearchLayout.setVisibility(0);
        this.mBottomSearchLayout.setVisibility(0);
        setMoveButtonVisibility(8);
        this.mSTTSearchView.onActionViewExpanded();
    }

    public void showSearchViewComposerMode() {
        View view = this.mTopContainer;
        if (view == null) {
            return;
        }
        View viewFindViewById = view.findViewById(C9086R.id.ai_menu_result_top_title_menu_container);
        if (viewFindViewById != null) {
            viewFindViewById.setVisibility(8);
        }
        this.mTopSearchLayout.setVisibility(8);
    }

    public void updateMoveButton() {
        if (getSTTSearchPresenter() == null || this.mForwardBtn == null || this.mBackwardBtn == null) {
            return;
        }
        updateMoveButton(getSTTSearchPresenter().canForward(), getSTTSearchPresenter().canBackward());
    }

    public void search(String str, STTSearchPresenter.Callback callback) {
        getSTTSearchPresenter().search(str, callback);
    }

    private void updateMoveButton(boolean z, boolean z2) {
        this.mForwardBtn.setEnabled(z);
        this.mBackwardBtn.setEnabled(z2);
        this.mForwardBtn.setAlpha(z ? 1.0f : 0.4f);
        this.mBackwardBtn.setAlpha(z2 ? 1.0f : 0.4f);
    }
}
