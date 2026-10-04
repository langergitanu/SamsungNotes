package com.samsung.android.support.senl.p148nt.app.main.noteslist.search.view;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.LinearGradient;
import android.graphics.PointF;
import android.graphics.Shader;
import android.text.Editable;
import android.text.InputFilter;
import android.text.Layout;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.PopupMenu;
import androidx.annotation.NonNull;
import androidx.appcompat.widget.SearchView;
import com.samsung.android.sdk.pen.setting.C7522c;
import com.samsung.android.sdk.pen.setting.common.ViewOnKeyListenerC7560e;
import com.samsung.android.support.senl.p148nt.app.C8003R;
import com.samsung.android.support.senl.p148nt.app.common.samsunganalytics.NotesSAConstants;
import com.samsung.android.support.senl.p148nt.app.main.common.view.AbsFragment;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.model.SearchData;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.presenter.helper.SearchHelper;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.presenter.search.util.SearchSALoggingUtil;
import com.samsung.android.support.senl.p148nt.base.common.samsunganalytices.CommonSamsungAnalytics;
import com.samsung.android.support.senl.p148nt.base.widget.search.VoiceButtonHelper;
import com.samsung.android.support.senl.p148nt.base.winset.toast.ToastHandler;
import p066P2.RunnableC0202d;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public class NotesSearchView extends SearchView {
    private final Context mContext;
    private boolean mInit;
    private boolean mIsCollapsing;
    private OnSearchCloseClickListener mOnSearchCloseClickListener;
    private OnSearchEnterClickListener mOnSearchEnterClickListener;
    private OnSearchMoreClickListener mOnSearchMoreClickListener;
    private OnSearchTextChangedListener mOnSearchTextChangedListener;
    private OnSearchVoiceClickListener mOnSearchVoiceClickListener;
    private EditText mSearchBox;
    private int mSearchCallerMode;
    private SearchData mSearchData;
    private int[] mSearchHintColors;
    private float[] mSearchHintPositions;
    private Shader mShader;
    private TextWatcher mTextWatcher;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface OnSearchCloseClickListener {
        void onSearchCloseClick();
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface OnSearchEnterClickListener {
        void onSearchEnterClick();
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface OnSearchMoreClickListener {
        boolean onSearchMoreClick(MenuItem menuItem);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface OnSearchTextChangedListener {
        void onSearchCursorChanged(PointF pointF);

        void onSearchStateChanged(boolean z);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface OnSearchVoiceClickListener {
        void onSearchVoiceClick(boolean z);
    }

    public NotesSearchView(Context context) {
        super(context);
        this.mInit = false;
        this.mIsCollapsing = false;
        this.mContext = context;
        init();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void applyShader() {
        this.mSearchBox.post(new RunnableC8559d(this, 1));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearShader() {
        this.mSearchBox.post(new RunnableC8559d(this, 0));
    }

    private void init() {
        if (this.mSearchBox != null || this.mInit) {
            return;
        }
        this.mSearchHintColors = this.mContext.getResources().getIntArray(C8003R.array.search_hint_text_color_array);
        this.mSearchHintPositions = new float[]{0.0f, 0.4f, 0.8f, 1.0f};
        int i = 1;
        setSaveEnabled(true);
        findViewById(C8003R.id.search_close_btn).setContentDescription(getResources().getString(C8003R.string.search_clear_button_description));
        findViewById(C8003R.id.search_close_btn).setOnClickListener(new ViewOnClickListenerC8558c(this, i));
        findViewById(C8003R.id.search_voice_btn).setOnClickListener(new ViewOnClickListenerC8558c(this, 2));
        this.mSearchBox = (EditText) findViewById(C8003R.id.search_src_text);
        updateTextSize();
        updateSearchText();
        this.mSearchBox.setFilters(new InputFilter[]{new InputFilter.LengthFilter(199) { // from class: com.samsung.android.support.senl.nt.app.main.noteslist.search.view.NotesSearchView.1
            @Override // android.text.InputFilter.LengthFilter, android.text.InputFilter
            public CharSequence filter(CharSequence charSequence, int i2, int i4, Spanned spanned, int i5, int i6) {
                CharSequence charSequenceFilter = super.filter(charSequence, i2, i4, spanned, i5, i6);
                if (charSequenceFilter != null && (NotesSearchView.this.mContext instanceof Activity)) {
                    String string = NotesSearchView.this.getResources().getString(C8003R.string.ss_maximum_number_of_characters_exceeded, 199);
                    if (NotesSearchView.this.mSearchCallerMode == 27) {
                        ToastHandler.showToastOnFlipCoverScreen(NotesSearchView.this.mContext, string, 1);
                        return charSequenceFilter;
                    }
                    ToastHandler.show(NotesSearchView.this.mContext, string, 1);
                }
                return charSequenceFilter;
            }
        }});
        this.mSearchBox.setOnKeyListener(new ViewOnKeyListenerC7560e(this, i));
        setImeOptions(268435459);
        this.mSearchBox.setPrivateImeOptions("disableImage=true");
        this.mInit = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$applyShader$3() {
        this.mSearchBox.setHintTextColor(this.mContext.getResources().getColor(C8003R.color.search_hint_text_color, null));
        if (this.mShader == null) {
            this.mShader = new LinearGradient(0.0f, 0.0f, this.mSearchBox.getPaint().measureText(this.mSearchBox.getHint().toString()), this.mSearchBox.getMeasuredHeight(), this.mSearchHintColors, this.mSearchHintPositions, Shader.TileMode.CLAMP);
        }
        this.mSearchBox.getPaint().setShader(this.mShader);
        this.mSearchBox.invalidate();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$clearShader$4() {
        this.mSearchBox.getPaint().setShader(null);
        this.mSearchBox.invalidate();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$init$0(View view) {
        if (this.mOnSearchCloseClickListener != null) {
            SearchSALoggingUtil.INSTANCE.updateSearchSALogging(this.mSearchData.getSavedText(), false);
            this.mOnSearchCloseClickListener.onSearchCloseClick();
            setSearchBoxText("");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$init$1(View view) {
        OnSearchVoiceClickListener onSearchVoiceClickListener = this.mOnSearchVoiceClickListener;
        if (onSearchVoiceClickListener != null) {
            onSearchVoiceClickListener.onSearchVoiceClick(VoiceButtonHelper.isSviEnabled(this));
            CommonSamsungAnalytics.insertLog("221", NotesSAConstants.EVENT_SEARCH_VOICE_BUTTON);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean lambda$init$2(View view, int i, KeyEvent keyEvent) {
        if (keyEvent.getAction() != 0) {
            return false;
        }
        if (i != 66 && i != 160) {
            return false;
        }
        this.mSearchBox.clearFocus();
        this.mOnSearchEnterClickListener.onSearchEnterClick();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$postQuery$5(CharSequence charSequence, boolean z) {
        setQuery(charSequence, z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean lambda$setOverFlowMenu$7(MenuItem menuItem) {
        return this.mOnSearchMoreClickListener.onSearchMoreClick(menuItem);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setSearchMoreVisibility$6(View view) {
        setOverFlowMenu(view).show();
    }

    private void setComponentName() {
        VoiceButtonHelper.setSearchableInfo(this, this.mSearchData.getComponentName());
    }

    private PopupMenu setOverFlowMenu(View view) {
        PopupMenu popupMenu = new PopupMenu(this.mContext, view, 8388613);
        popupMenu.getMenuInflater().inflate(C8003R.menu.search_settings_popup_menu, popupMenu.getMenu());
        popupMenu.setOnMenuItemClickListener(new C7522c(this, 1));
        return popupMenu;
    }

    private void updateSearchText() {
        if (SearchHelper.isSemanticSearchEffectRequired()) {
            applyGradientText();
        } else {
            this.mSearchBox.setHintTextColor(this.mContext.getResources().getColor(C8003R.color.search_hint_text_color, null));
        }
    }

    private void updateTextSize() {
        EditText editText = this.mSearchBox;
        if (editText != null) {
            editText.setTextAppearance(C8003R.style.RobotoMediumStyle);
            this.mSearchBox.setTextSize(2, 15.0f);
        }
    }

    public void applyGradientText() {
        EditText editText = this.mSearchBox;
        if (editText == null) {
            return;
        }
        TextWatcher textWatcher = this.mTextWatcher;
        if (textWatcher != null) {
            editText.removeTextChangedListener(textWatcher);
        }
        if (this.mTextWatcher == null) {
            this.mTextWatcher = new TextWatcher() { // from class: com.samsung.android.support.senl.nt.app.main.noteslist.search.view.NotesSearchView.2
                @Override // android.text.TextWatcher
                public void afterTextChanged(Editable editable) {
                    int selectionStart;
                    Layout layout;
                    if (NotesSearchView.this.mOnSearchTextChangedListener == null || (selectionStart = NotesSearchView.this.mSearchBox.getSelectionStart()) < 0 || (layout = NotesSearchView.this.mSearchBox.getLayout()) == null) {
                        return;
                    }
                    int lineForOffset = layout.getLineForOffset(selectionStart);
                    float primaryHorizontal = layout.getPrimaryHorizontal(selectionStart);
                    int lineBottom = layout.getLineBottom(lineForOffset);
                    int[] iArr = new int[2];
                    NotesSearchView.this.mSearchBox.getLocationOnScreen(iArr);
                    NotesSearchView.this.mOnSearchTextChangedListener.onSearchCursorChanged(new PointF(Math.min(iArr[0] + primaryHorizontal, NotesSearchView.this.mSearchBox.getWidth() + r2), iArr[1] + lineBottom));
                }

                @Override // android.text.TextWatcher
                public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i4) {
                    if (charSequence.length() != 0 || i4 <= 0) {
                        return;
                    }
                    NotesSearchView.this.clearShader();
                    if (NotesSearchView.this.mOnSearchTextChangedListener != null) {
                        NotesSearchView.this.mOnSearchTextChangedListener.onSearchStateChanged(true);
                    }
                }

                @Override // android.text.TextWatcher
                public void onTextChanged(CharSequence charSequence, int i, int i2, int i4) {
                    if (NotesSearchView.this.mSearchBox.getText().length() == 0) {
                        NotesSearchView.this.applyShader();
                        if (NotesSearchView.this.mOnSearchTextChangedListener != null) {
                            NotesSearchView.this.mOnSearchTextChangedListener.onSearchStateChanged(false);
                        }
                    }
                }
            };
        }
        this.mSearchBox.addTextChangedListener(this.mTextWatcher);
        if (this.mSearchBox.getText().length() == 0) {
            applyShader();
        }
    }

    public void clearSearchData() {
        SearchData searchData = this.mSearchData;
        if (searchData != null) {
            searchData.setSavedSearchQuery(null).setSavedText("").setSkipQuery(false);
        }
    }

    public String getSavedSearchQuery() {
        return this.mSearchData.getSavedSearchQuery();
    }

    @NonNull
    public String getSavedText() {
        return this.mSearchData.getSavedText();
    }

    @NonNull
    public String getSearchBoxText() {
        Editable text;
        EditText editText = this.mSearchBox;
        return (editText == null || (text = editText.getText()) == null) ? "" : text.toString();
    }

    public boolean getSkipQuery() {
        return this.mSearchData.getSkipQuery();
    }

    public void initSearchData(AbsFragment absFragment, String str) {
        setQueryHint(new SpannableStringBuilder(str));
        SearchData searchData = this.mSearchData;
        if (searchData == null) {
            this.mSearchData = new SearchData().setSavedSearchQuery(null).setSavedText("").setSkipQuery(false).setComponentName(absFragment.getActivity().getComponentName());
        } else {
            searchData.setSkipQuery(false);
        }
        setComponentName();
    }

    public boolean isCollapsing() {
        return this.mIsCollapsing;
    }

    @Override // androidx.appcompat.widget.SearchView, androidx.appcompat.view.CollapsibleActionView
    public void onActionViewCollapsed() {
        this.mIsCollapsing = true;
        super.onActionViewCollapsed();
    }

    @Override // androidx.appcompat.widget.SearchView, androidx.appcompat.view.CollapsibleActionView
    public void onActionViewExpanded() {
        this.mIsCollapsing = false;
        super.onActionViewExpanded();
    }

    @Override // androidx.appcompat.widget.SearchView, android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        updateTextSize();
        updateSearchText();
    }

    public void postQuery(CharSequence charSequence, boolean z) {
        post(new RunnableC0202d(this, charSequence, z, 2));
    }

    public void setOnSearchCloseClickListener(OnSearchCloseClickListener onSearchCloseClickListener) {
        this.mOnSearchCloseClickListener = onSearchCloseClickListener;
    }

    public void setOnSearchEnterClickListener(OnSearchEnterClickListener onSearchEnterClickListener) {
        this.mOnSearchEnterClickListener = onSearchEnterClickListener;
    }

    public void setOnSearchMoreClickListener(OnSearchMoreClickListener onSearchMoreClickListener) {
        this.mOnSearchMoreClickListener = onSearchMoreClickListener;
    }

    public void setOnSearchTextChangedListener(OnSearchTextChangedListener onSearchTextChangedListener) {
        this.mOnSearchTextChangedListener = onSearchTextChangedListener;
    }

    public void setOnSearchVoiceClickListener(OnSearchVoiceClickListener onSearchVoiceClickListener) {
        this.mOnSearchVoiceClickListener = onSearchVoiceClickListener;
    }

    public void setSavedSearchQuery(String str) {
        this.mSearchData.setSavedSearchQuery(str);
    }

    public void setSavedText(@NonNull String str) {
        this.mSearchData.setSavedText(str);
    }

    public void setSearchBoxText(String str) {
        EditText editText = this.mSearchBox;
        if (editText != null) {
            editText.setText(str);
        }
    }

    public void setSearchCallerMode(int i) {
        this.mSearchCallerMode = i;
    }

    public void setSearchMoreVisibility(boolean z) {
        seslSetOverflowMenuButtonVisibility(z ? 0 : 8);
        seslSetOnOverflowMenuButtonClickListener(new ViewOnClickListenerC8558c(this, 0));
    }

    public void setSkipQuery(boolean z) {
        this.mSearchData.setSkipQuery(z);
    }

    public NotesSearchView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mInit = false;
        this.mIsCollapsing = false;
        this.mContext = context;
        init();
    }

    public NotesSearchView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mInit = false;
        this.mIsCollapsing = false;
        this.mContext = context;
        init();
    }
}
