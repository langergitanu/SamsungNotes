package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.ColorRes;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.appcompat.widget.ListPopupWindow;
import androidx.collection.AbstractC0622a;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.google.android.material.tabs.TabLayout;
import com.samsung.android.sdk.smp.common.constants.MarketingConstants;
import com.samsung.android.support.senl.p145cm.base.common.util.ResourceUtils;
import com.samsung.android.support.senl.p145cm.base.framework.sem.view.AiResultLayout;
import com.samsung.android.support.senl.p145cm.base.framework.view.ViewCompat;
import com.samsung.android.support.senl.p145cm.base.framework.view.WindowManagerCompat;
import com.samsung.android.support.senl.p148nt.base.common.p151ai.dialog.AiDisclaimerDialog;
import com.samsung.android.support.senl.p148nt.base.winset.accessibility.VoiceAssistantTTS;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.common.ViewUtil;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.common.AiConstants;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.presenter.AiMenuContract;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.presenter.AiMenuResultViewPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.p156sa.ComposerSA;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.p156sa.ComposerSAConstants;
import com.samsung.android.support.senl.p148nt.data.database.core.query.sqlbuilder.SQLKeyword;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.collections.AbstractC12991c;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class AiMenuResultTopView {
    static final int BTN_ID_CONTEXT = 1;
    static final int BTN_ID_DISCLAIMER = 4;
    static final int BTN_ID_SETTING = 2;
    static final int BTN_ID_STT = 100;
    static final int BTN_ID_SUMMARY = 3;
    private static final String TAG = Logger.createTag("AiMenuResultTopView", AiConstants.PREFIX_TAG);
    AiDisclaimerDialog mAiDisclaimerDialog;
    ViewGroup mButtonContainer;
    View mCloseBtn;
    View.OnLayoutChangeListener mContainerOnLayoutChangeListener;
    ImageView mContextBtn;
    Contract mContract;
    View mDisclaimerBtn;
    MorePopup mMorePopup;
    View mSTTContextBtn;
    View mSTTDisclaimerBtn;
    View mSTTDropdown;
    View mSTTEditCancelBtn;
    View mSTTEditDoneBtn;
    CheckBox mSTTSelectAllCheckBox;
    View mSTTSelectAllContainer;
    View mSTTSwitchBtn;
    ViewGroup mSTTTopContainer;
    ImageView mSTTTranslateBtn;
    View mSettingBtn;
    View mSummaryBtn;
    TabLayout mTabLayout;
    View mTitleContainer;
    ImageView mTitleIconView;
    View mTitleMenuContainer;
    TextView mTitleView;
    View mTopButtonContainer;
    View mTopContainer;
    View mTopTitleContainer;
    View mUnderTopContainer;
    Map<Integer, View> mAiBtnMap = new HashMap();
    private final List<View> mVisibleButtonList = new ArrayList();
    private int mOrientation = 1;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface Contract {
        void close();

        AiMenuResultBottomView getBottomView();

        int getCurrentItem();

        List<AiMenuContract.IAiActionResultView> getPageList();

        AiMenuResultViewPresenter getPresenter();

        boolean isNotAvailable();
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class MorePopup {
        private ListPopupWindow mListPopupWindow;
        private List<MenuItem> mMenuItems;

        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        public static final class MenuItem extends AbstractC12991c {
            private final int strId;

            public MenuItem(int i) {
                this.strId = i;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return obj != null && MenuItem.class == obj.getClass() && this.strId == ((MenuItem) obj).strId;
            }

            public int hashCode() {
                return Integer.hashCode(this.strId);
            }

            public int strId() {
                return this.strId;
            }

            public final String toString() {
                Object[] objArr = {Integer.valueOf(this.strId)};
                String[] strArrSplit = "strId".length() == 0 ? new String[0] : "strId".split(";");
                StringBuilder sb = new StringBuilder();
                sb.append(MenuItem.class.getSimpleName());
                sb.append("[");
                for (int i = 0; i < strArrSplit.length; i++) {
                    sb.append(strArrSplit[i]);
                    sb.append(MarketingConstants.REFERRER_DELIMITER_U003D);
                    sb.append(objArr[i]);
                    if (i != strArrSplit.length - 1) {
                        sb.append(SQLKeyword.COMMA);
                    }
                }
                sb.append("]");
                return sb.toString();
            }
        }

        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        public interface OnClickListener {
            void onItemClick(int i);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$updateMenu$0(OnClickListener onClickListener, AdapterView adapterView, View view, int i, long j) {
            onClickListener.onItemClick(i);
            hide();
        }

        public List<MenuItem> getMenuItems() {
            return this.mMenuItems;
        }

        public void hide() {
            ListPopupWindow listPopupWindow = this.mListPopupWindow;
            if (listPopupWindow == null || !listPopupWindow.isShowing()) {
                return;
            }
            this.mListPopupWindow.dismiss();
        }

        public void init(View view, OnClickListener onClickListener) {
            if (isInitialized()) {
                return;
            }
            updateMenu(view, onClickListener);
        }

        public boolean isInitialized() {
            return this.mListPopupWindow != null;
        }

        public void setMenuItems(List<MenuItem> list) {
            this.mMenuItems = list;
        }

        public void show() {
            ListPopupWindow listPopupWindow = this.mListPopupWindow;
            if (listPopupWindow == null || listPopupWindow.isShowing()) {
                return;
            }
            this.mListPopupWindow.setVerticalOffset((int) ((-r0.getHeight()) - ResourceUtils.convertDpToPixel(this.mListPopupWindow.getAnchorView().getContext(), 6.0f)));
            this.mListPopupWindow.show();
        }

        public void updateMenu(View view, final OnClickListener onClickListener) {
            Context context = view.getContext();
            ArrayAdapter<MenuItem> arrayAdapter = new ArrayAdapter<MenuItem>(context, C9086R.layout.comp_page_list_item_more_menu_item, this.mMenuItems) { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.view.AiMenuResultTopView.MorePopup.1
                @Override // android.widget.ArrayAdapter, android.widget.Adapter
                @NonNull
                public View getView(int i, @Nullable View view2, @NonNull ViewGroup viewGroup) {
                    if (view2 == null) {
                        view2 = LayoutInflater.from(viewGroup.getContext()).inflate(C9086R.layout.comp_page_list_item_more_menu_item, (ViewGroup) null);
                    }
                    ((TextView) view2.findViewById(C9086R.id.comp_page_list_item_more_menu_title)).setText(((MenuItem) MorePopup.this.mMenuItems.get(i)).strId());
                    return view2;
                }
            };
            ListPopupWindow listPopupWindow = new ListPopupWindow(view.getContext());
            this.mListPopupWindow = listPopupWindow;
            listPopupWindow.setAdapter(arrayAdapter);
            this.mListPopupWindow.setAnchorView(view);
            this.mListPopupWindow.setWidth(ViewUtil.measureContentWidth(context, arrayAdapter));
            this.mListPopupWindow.setModal(true);
            this.mListPopupWindow.setInputMethodMode(2);
            this.mListPopupWindow.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.view.f
                @Override // android.widget.AdapterView.OnItemClickListener
                public final void onItemClick(AdapterView adapterView, View view2, int i, long j) {
                    this.f6945a.lambda$updateMenu$0(onClickListener, adapterView, view2, i, j);
                }
            });
        }
    }

    public AiMenuResultTopView(Contract contract) {
        this.mContract = contract;
    }

    private int getViewWidth(ViewGroup.MarginLayoutParams marginLayoutParams, StringBuilder sb, int i) {
        int i2;
        int i4;
        int marginEnd = marginLayoutParams.getMarginEnd() + marginLayoutParams.getMarginStart() + marginLayoutParams.width;
        if (marginLayoutParams.getMarginStart() == 0 && (marginLayoutParams instanceof ConstraintLayout.LayoutParams) && (i4 = ((ConstraintLayout.LayoutParams) marginLayoutParams).goneStartMargin) != Integer.MIN_VALUE) {
            marginEnd += i4;
        }
        if (marginLayoutParams.getMarginEnd() == 0 && (marginLayoutParams instanceof ConstraintLayout.LayoutParams) && (i2 = ((ConstraintLayout.LayoutParams) marginLayoutParams).goneEndMargin) != Integer.MIN_VALUE) {
            marginEnd += i2;
        }
        AbstractC0622a.m1180z(sb, marginEnd, i, "\ncalc: ", "/");
        return marginEnd;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$init$0(View view) {
        Logger.m10999d(TAG, "onClick# setting");
        if (this.mContract.isNotAvailable()) {
            return;
        }
        AiMenuContract.IAiActionResultView iAiActionResultView = this.mContract.getPageList().get(this.mContract.getCurrentItem());
        if (iAiActionResultView instanceof AiMenuResultViewRecognizedHw) {
            ((AiMenuResultViewRecognizedHw) iAiActionResultView).showSettingDialog();
            ComposerSA.insertLog(ComposerSAConstants.SCREEN_DIALOGS_CTT_RESULT, ComposerSAConstants.EVENT_AI_CTT_SETTINGS);
        } else if (iAiActionResultView instanceof AiMenuResultViewOriginalHw) {
            ((AiMenuResultViewRecognizedHw) this.mContract.getPageList().get(1)).showSettingDialog();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$init$1(View view) {
        if (this.mContract.isNotAvailable()) {
            return;
        }
        AiDisclaimerDialog aiDisclaimerDialog = new AiDisclaimerDialog();
        this.mAiDisclaimerDialog = aiDisclaimerDialog;
        aiDisclaimerDialog.show(view.getContext(), !this.mContract.getPresenter().isCreateImageRunning(), view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$init$2(View view) {
        this.mContract.close();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$init$3(View view, int i, int i2, int i4, int i5, int i6, int i7, int i8, int i9) {
        if (i8 - i6 != i4 - i) {
            updateVisibilityByWidth();
        }
        final int i10 = i5 - i2;
        if (i9 - i7 != i10) {
            this.mUnderTopContainer.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.view.AiMenuResultTopView.2
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public void onGlobalLayout() {
                    AiMenuResultTopView.this.mUnderTopContainer.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                    AiMenuResultTopView.this.mUnderTopContainer.getLayoutParams().height = i10;
                    AiMenuResultTopView.this.mUnderTopContainer.requestLayout();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$makeMorePopup$4(View view) {
        MorePopup morePopup = this.mMorePopup;
        if (morePopup != null) {
            morePopup.show();
        }
    }

    private void setButtonVisibility(View view, int i) {
        view.setVisibility(i);
        if (i == 0) {
            this.mVisibleButtonList.add(view);
            if (view.isEnabled()) {
                view.setAlpha(1.0f);
            }
        }
    }

    private void setSTTButtonState(boolean z, float f) {
        ViewGroup viewGroup = this.mSTTTopContainer;
        if (viewGroup != null) {
            viewGroup.setEnabled(z);
            this.mSTTTopContainer.setAlpha(f);
            this.mSTTSwitchBtn.setEnabled(z);
            this.mSTTSwitchBtn.setAlpha(f);
            this.mSTTContextBtn.setEnabled(z);
            this.mSTTContextBtn.setAlpha(f);
            this.mSTTTranslateBtn.setEnabled(z);
            this.mSTTTranslateBtn.setAlpha(f);
            this.mSTTDisclaimerBtn.setEnabled(z);
            this.mSTTDisclaimerBtn.setAlpha(f);
        }
        setTabLayoutState(z);
    }

    private void setSTTButtonVisibility(int i) {
        ViewGroup viewGroup = this.mSTTTopContainer;
        if (viewGroup != null) {
            viewGroup.setVisibility(i);
            if (i == 0) {
                for (int i2 = 0; i2 < this.mSTTTopContainer.getChildCount(); i2++) {
                    View childAt = this.mSTTTopContainer.getChildAt(i2);
                    if (childAt.getVisibility() == 0) {
                        this.mVisibleButtonList.add(childAt);
                    }
                }
            }
        }
        TabLayout tabLayout = this.mTabLayout;
        if (tabLayout != null) {
            tabLayout.setVisibility(i);
        }
    }

    private void updateMargin() {
        ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) this.mContextBtn.getLayoutParams();
        if (this.mContextBtn.getVisibility() == 0 && this.mSettingBtn.getVisibility() == 0) {
            layoutParams.setMarginEnd(this.mTopContainer.getResources().getDimensionPixelSize(C9086R.dimen.ai_menu_result_top_button_end_margin));
        } else {
            layoutParams.setMarginEnd(0);
        }
        this.mContextBtn.setLayoutParams(layoutParams);
    }

    public void clear() {
        this.mTopContainer.removeOnLayoutChangeListener(this.mContainerOnLayoutChangeListener);
        MorePopup morePopup = this.mMorePopup;
        if (morePopup != null) {
            morePopup.hide();
            this.mMorePopup = null;
        }
    }

    public View getButton(int i) {
        return this.mAiBtnMap.get(Integer.valueOf(i));
    }

    public List<View> getButtonList(boolean z) {
        ArrayList arrayList = new ArrayList(this.mAiBtnMap.values());
        if (z) {
            arrayList.remove(this.mCloseBtn);
        }
        return arrayList;
    }

    public MorePopup getMorePopup() {
        return this.mMorePopup;
    }

    public void hideDialogs() {
        AiDisclaimerDialog aiDisclaimerDialog = this.mAiDisclaimerDialog;
        if (aiDisclaimerDialog != null) {
            aiDisclaimerDialog.hide();
        }
        AiMenuContract.IAiActionResultView iAiActionResultView = this.mContract.getPageList().get(this.mContract.getCurrentItem());
        if (iAiActionResultView instanceof AutoFormatOriginTextView) {
            ((AutoFormatOriginTextView) iAiActionResultView).hideTypeListPopup();
        }
    }

    public void init(View view, View view2) {
        this.mTopContainer = view;
        this.mUnderTopContainer = view2;
        this.mTopTitleContainer = view.findViewById(C9086R.id.ai_menu_result_top_title_container);
        this.mTitleMenuContainer = view.findViewById(C9086R.id.ai_menu_result_top_title_menu_container);
        this.mTitleView = (TextView) view.findViewById(C9086R.id.ai_menu_result_title);
        this.mTitleIconView = (ImageView) view.findViewById(C9086R.id.ai_menu_result_title_icon);
        this.mButtonContainer = (ViewGroup) view.findViewById(C9086R.id.ai_menu_result_top_menu_container);
        this.mContextBtn = (ImageView) view.findViewById(C9086R.id.ai_menu_result_context_btn);
        this.mSettingBtn = view.findViewById(C9086R.id.ai_menu_result_setting_btn);
        this.mSummaryBtn = view.findViewById(C9086R.id.ai_menu_result_summary_style_btn);
        this.mDisclaimerBtn = view.findViewById(C9086R.id.ai_menu_result_disclaimer_btn);
        this.mTopButtonContainer = view.findViewById(C9086R.id.ai_menu_result_top_button_container);
        this.mAiBtnMap.put(1, this.mContextBtn);
        this.mAiBtnMap.put(2, this.mSettingBtn);
        this.mAiBtnMap.put(3, this.mSummaryBtn);
        this.mAiBtnMap.put(4, this.mDisclaimerBtn);
        this.mCloseBtn = view.findViewById(C9086R.id.ai_menu_result_close_btn);
        initSTT(view);
        initTabLayout(view);
        setButtonsVisibility(null);
        setTopButtonState(true);
        if (this.mContract.getPresenter().getAutoFormat() != null) {
            this.mContextBtn.setImageResource(C9086R.drawable.ic_ai_menu_autoformat);
            ImageView imageView = this.mContextBtn;
            imageView.setTooltipText(imageView.getResources().getString(C9086R.string.ai_auto_format_name));
        } else {
            this.mContextBtn.setImageResource(C9086R.drawable.ic_ai_menu_toolbar_btn);
            ImageView imageView2 = this.mContextBtn;
            imageView2.setTooltipText(imageView2.getResources().getString(C9086R.string.ai_notes_assist));
        }
        this.mSettingBtn.setOnClickListener(new ViewOnClickListenerC9708d(this, 0));
        this.mDisclaimerBtn.setOnClickListener(new ViewOnClickListenerC9708d(this, 1));
        View view3 = this.mCloseBtn;
        if (view3 != null) {
            view3.setVisibility(0);
            this.mCloseBtn.setOnClickListener(new ViewOnClickListenerC9708d(this, 2));
            this.mCloseBtn.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.view.AiMenuResultTopView.1
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public void onGlobalLayout() {
                    AiMenuResultTopView.this.mCloseBtn.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                    AiMenuResultTopView.this.mCloseBtn.requestFocus();
                    if (VoiceAssistantTTS.isVoiceAssistantEnabled(AiMenuResultTopView.this.mCloseBtn.getContext())) {
                        ViewCompat.getInstance().requestAccessibilityFocus(AiMenuResultTopView.this.mCloseBtn);
                    }
                }
            });
        }
        if (this.mContainerOnLayoutChangeListener == null) {
            this.mContainerOnLayoutChangeListener = new ViewOnLayoutChangeListenerC9709e(this, 0);
        }
        this.mTopContainer.addOnLayoutChangeListener(this.mContainerOnLayoutChangeListener);
    }

    public void initSTT(View view) {
        this.mSTTTopContainer = (ViewGroup) view.findViewById(C9086R.id.ai_menu_result_stt_top_container);
        this.mSTTSwitchBtn = view.findViewById(C9086R.id.ai_menu_result_stt_switch_btn);
        this.mSTTContextBtn = view.findViewById(C9086R.id.ai_menu_result_stt_context_btn);
        this.mSTTTranslateBtn = (ImageView) view.findViewById(C9086R.id.ai_menu_result_stt_translate_btn);
        this.mSTTDisclaimerBtn = view.findViewById(C9086R.id.ai_menu_result_stt_disclaimer_btn);
        this.mSTTEditCancelBtn = view.findViewById(C9086R.id.ai_menu_result_stt_edit_cancel_btn);
        this.mSTTEditDoneBtn = view.findViewById(C9086R.id.ai_menu_result_stt_edit_done_btn);
        this.mSTTSelectAllContainer = view.findViewById(C9086R.id.ai_menu_result_stt_select_all);
        this.mSTTSelectAllCheckBox = (CheckBox) view.findViewById(C9086R.id.ai_menu_result_stt_select_all_checkbox);
        this.mTitleContainer = view.findViewById(C9086R.id.ai_menu_result_title_container);
        this.mSTTDropdown = view.findViewById(C9086R.id.ic_ai_menu_stt_dropdown);
    }

    public void initSTTTabLayout() {
        if (this.mTabLayout == null || isSTTTabLayoutInitialized()) {
            return;
        }
        this.mTabLayout.removeAllTabs();
        TabLayout tabLayout = this.mTabLayout;
        tabLayout.addTab(tabLayout.newTab().setText(C9086R.string.ai_transcript_title));
        TabLayout tabLayout2 = this.mTabLayout;
        tabLayout2.addTab(tabLayout2.newTab().setText(C9086R.string.ai_summary_title));
    }

    public void initSummaryOnDevice(int i) {
        this.mAiBtnMap.remove(Integer.valueOf(i));
    }

    public void initTabLayout(View view) {
        TabLayout tabLayout = (TabLayout) view.findViewById(C9086R.id.ai_menu_result_tab_layout);
        this.mTabLayout = tabLayout;
        tabLayout.seslSetSubTabStyle();
    }

    public boolean isSTTTabLayoutInitialized() {
        TabLayout tabLayout = this.mTabLayout;
        return tabLayout != null && tabLayout.getTabCount() == 2 && this.mTabLayout.getTabAt(0).getText().equals(this.mTabLayout.getContext().getString(C9086R.string.ai_transcript_title)) && this.mTabLayout.getTabAt(1).getText().equals(this.mTabLayout.getContext().getString(C9086R.string.ai_summary_title));
    }

    public void makeMorePopup(List<Integer> list, MorePopup.OnClickListener onClickListener) {
        MorePopup morePopup = this.mMorePopup;
        if (morePopup == null || !morePopup.isInitialized()) {
            this.mMorePopup = new MorePopup();
            ArrayList arrayList = new ArrayList();
            Iterator<Integer> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(new MorePopup.MenuItem(it.next().intValue()));
            }
            this.mMorePopup.setMenuItems(arrayList);
            this.mMorePopup.init(this.mSettingBtn, onClickListener);
            this.mSettingBtn.setOnClickListener(new ViewOnClickListenerC9708d(this, 3));
        }
    }

    public void minimizeView(int i, boolean z) {
        if (!z) {
            this.mTopTitleContainer.setPadding(0, 0, 0, 0);
            this.mTopButtonContainer.setVisibility(0);
        } else {
            if (i == AiResultLayout.INSTANCE.MODE_FLOATING()) {
                View view = this.mTopTitleContainer;
                view.setPadding(0, view.getResources().getDimensionPixelSize(C9086R.dimen.ai_result_title_top_padding_for_minimize), 0, this.mTopTitleContainer.getResources().getDimensionPixelSize(C9086R.dimen.ai_result_title_bottom_padding_for_minimize));
            }
            this.mTopButtonContainer.setVisibility(8);
        }
    }

    public void setAiDisclaimerDialog(AiDisclaimerDialog aiDisclaimerDialog) {
        this.mAiDisclaimerDialog = aiDisclaimerDialog;
    }

    public void setButtonsVisibility(@Nullable List<Integer> list) {
        int i;
        this.mVisibleButtonList.clear();
        this.mVisibleButtonList.add(this.mCloseBtn);
        Iterator<Map.Entry<Integer, View>> it = this.mAiBtnMap.entrySet().iterator();
        while (true) {
            i = 8;
            if (!it.hasNext()) {
                break;
            }
            Map.Entry<Integer, View> next = it.next();
            if (list == null || !list.contains(next.getKey())) {
                setButtonVisibility(next.getValue(), 8);
            } else {
                setButtonVisibility(next.getValue(), 0);
            }
        }
        if (list != null && list.contains(100)) {
            i = 0;
        }
        setSTTButtonVisibility(i);
        updateMargin();
        updateVisibilityByWidth();
    }

    public void setDisableSettingBtn() {
        View view = this.mSettingBtn;
        if (view == null) {
            return;
        }
        view.setEnabled(false);
        this.mSettingBtn.setAlpha(0.4f);
    }

    public void setMarginTabLayout(int i) {
        int iMax = Math.max(i, (int) ResourceUtils.convertDpToPixel(this.mTabLayout.getContext(), 24.0f));
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.mTabLayout.getLayoutParams();
        if (marginLayoutParams.leftMargin == iMax && marginLayoutParams.rightMargin == iMax) {
            return;
        }
        marginLayoutParams.setMarginStart(iMax);
        marginLayoutParams.setMarginEnd(iMax);
        this.mTabLayout.setLayoutParams(marginLayoutParams);
    }

    public void setOrientation(int i) {
        this.mOrientation = i;
    }

    public void setTabLayoutState(boolean z) {
        float f = z ? 1.0f : 0.4f;
        TabLayout tabLayout = this.mTabLayout;
        if (tabLayout != null) {
            tabLayout.setEnabled(z);
            this.mTabLayout.setAlpha(f);
            for (int i = 0; i < this.mTabLayout.getTabCount(); i++) {
                TabLayout.Tab tabAt = this.mTabLayout.getTabAt(i);
                if (tabAt != null) {
                    tabAt.view.setEnabled(z);
                }
            }
        }
    }

    public void setTitle(String str, @DrawableRes int i, @ColorRes Integer num) {
        this.mTitleView.setText(str);
        setTitleIcon(i, num);
    }

    public void setTitleIcon(@DrawableRes int i, @ColorRes Integer num) {
        this.mTitleIconView.setVisibility(0);
        if (num == null) {
            this.mTitleIconView.clearColorFilter();
        } else {
            this.mTitleIconView.setColorFilter(this.mTitleIconView.getResources().getColor(num.intValue(), null));
        }
        this.mTitleIconView.setImageResource(i);
    }

    public void setTopButtonState(boolean z) {
        if (this.mContextBtn == null) {
            return;
        }
        float f = z ? 1.0f : 0.4f;
        for (View view : this.mAiBtnMap.values()) {
            view.setEnabled(z);
            if (view.getAlpha() != 0.0f) {
                view.setAlpha(f);
            }
        }
        setSTTButtonState(z, f);
    }

    public void setVisibilityForSearchMode(boolean z) {
        View view = this.mSTTContextBtn;
        if (view != null) {
            if (z) {
                view.setVisibility(0);
            } else {
                view.setVisibility(8);
            }
        }
        TabLayout tabLayout = this.mTabLayout;
        if (tabLayout != null) {
            if (z) {
                tabLayout.setVisibility(0);
            } else {
                tabLayout.setVisibility(8);
            }
        }
    }

    public void updateMorePopupMenu(List<Integer> list, MorePopup.OnClickListener onClickListener) {
        ArrayList arrayList = new ArrayList();
        Iterator<Integer> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(new MorePopup.MenuItem(it.next().intValue()));
        }
        if (arrayList.size() == this.mMorePopup.getMenuItems().size()) {
            Iterator it2 = arrayList.iterator();
            while (it2.hasNext()) {
                if (!this.mMorePopup.getMenuItems().contains((MorePopup.MenuItem) it2.next())) {
                }
            }
            return;
        }
        this.mMorePopup.setMenuItems(arrayList);
        this.mMorePopup.updateMenu(this.mSettingBtn, onClickListener);
    }

    public void updateVisibilityByWidth() {
        if (this.mVisibleButtonList.size() <= 1) {
            return;
        }
        if (this.mOrientation != 2) {
            Iterator<View> it = this.mVisibleButtonList.iterator();
            while (it.hasNext()) {
                it.next().setVisibility(0);
            }
            return;
        }
        if (WindowManagerCompat.getInstance().getMultiWindowMode(this.mTopContainer.getResources().getConfiguration()) == 0) {
            return;
        }
        int width = (this.mTitleMenuContainer.getWidth() - this.mTitleMenuContainer.getPaddingRight()) - this.mTitleMenuContainer.getPaddingEnd();
        int width2 = width - this.mTitleIconView.getWidth();
        StringBuilder sb = new StringBuilder();
        sb.append("start: ");
        sb.append(width);
        sb.append("/");
        sb.append(width2);
        ArrayList arrayList = new ArrayList();
        ViewGroup viewGroup = this.mButtonContainer;
        if (this.mSTTTopContainer.getVisibility() == 0) {
            int width3 = width2 - this.mCloseBtn.getWidth();
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.mSTTTopContainer.getLayoutParams();
            width2 = width3 - marginLayoutParams.getMarginEnd();
            sb.append("\ncalc: ");
            sb.append(marginLayoutParams.getMarginEnd());
            sb.append("/");
            sb.append(width2);
            viewGroup = this.mSTTTopContainer;
        }
        for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = viewGroup.getChildAt(childCount);
            if (childAt.getVisibility() != 8) {
                if (width2 < 0) {
                    arrayList.add(childAt);
                } else {
                    width2 -= getViewWidth((ViewGroup.MarginLayoutParams) childAt.getLayoutParams(), sb, width2);
                    if (width2 < 0) {
                        arrayList.add(childAt);
                    }
                }
            }
        }
        if (arrayList.isEmpty()) {
            Iterator<View> it2 = this.mVisibleButtonList.iterator();
            while (it2.hasNext()) {
                it2.next().setVisibility(0);
            }
            return;
        }
        for (View view : this.mVisibleButtonList) {
            if (!arrayList.contains(view)) {
                view.setVisibility(0);
            }
        }
        Iterator it3 = arrayList.iterator();
        while (it3.hasNext()) {
            ((View) it3.next()).setVisibility(4);
        }
        Logger.m10999d(TAG, sb.toString());
    }

    public void setTitle(@StringRes int i, @DrawableRes int i2, @ColorRes Integer num) {
        this.mTitleView.setText(i);
        setTitleIcon(i2, num);
    }
}
