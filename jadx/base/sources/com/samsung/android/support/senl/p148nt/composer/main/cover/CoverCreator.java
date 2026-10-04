package com.samsung.android.support.senl.p148nt.composer.main.cover;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Handler;
import android.os.Looper;
import android.text.InputFilter;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.style.UnderlineSpan;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.EditText;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.res.ResourcesCompat;
import androidx.glance.AbstractC2821a;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;
import com.airbnb.lottie.LottieAnimationView;
import com.google.android.material.tabs.TabLayout;
import com.samsung.android.app.notes.widget.glance.single.setting.view.ViewOnTouchListenerC7005f;
import com.samsung.android.support.senl.p145cm.base.framework.feature.CscFeature;
import com.samsung.android.support.senl.p145cm.base.framework.view.InputMethodCompat;
import com.samsung.android.support.senl.p145cm.base.framework.view.ViewCompat;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.base.common.ApplicationManager;
import com.samsung.android.support.senl.p148nt.base.common.UserInputSkipper;
import com.samsung.android.support.senl.p148nt.base.common.access.widgetaccess.WidgetAccessHandler;
import com.samsung.android.support.senl.p148nt.base.common.util.DisplayUtils;
import com.samsung.android.support.senl.p148nt.base.common.util.FontUtils;
import com.samsung.android.support.senl.p148nt.base.winset.accessibility.VoiceAssistantTTS;
import com.samsung.android.support.senl.p148nt.base.winset.toast.ToastHandler;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.common.AiCommonUtil;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.cover.AiCoverDataCreator;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.cover.AiCoverDataCreatorManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.FeatureInfo;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.p156sa.ComposerSA;
import com.samsung.android.support.senl.p148nt.composer.main.cover.adapter.BadgeListAdapter;
import com.samsung.android.support.senl.p148nt.composer.main.cover.adapter.ColorListAdapter;
import com.samsung.android.support.senl.p148nt.composer.main.cover.adapter.StyleListAdapter;
import com.samsung.android.support.senl.p148nt.composer.main.cover.adapter.TemplateListAdapter;
import com.samsung.android.support.senl.p148nt.composer.main.cover.adapter.TypeListAdapter;
import com.samsung.android.support.senl.p148nt.composer.main.cover.model.CoverData;
import com.samsung.android.support.senl.p148nt.composer.main.cover.presenter.CoverEditorPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.cover.presenter.CoverEditorUtils;
import com.samsung.android.support.senl.p148nt.composer.main.cover.presenter.CoverStickerPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.cover.util.CoverStickerUtils;
import com.samsung.android.support.senl.p148nt.composer.main.cover.view.CoverItemDecoration;
import com.samsung.android.support.senl.p148nt.composer.main.cover.view.CoverTabView;
import com.samsung.android.support.senl.p148nt.composer.main.cover.view.VIResultView;
import com.samsung.android.support.senl.p148nt.data.common.constants.CoverStickerConstants;
import com.samsung.android.support.senl.p148nt.data.database.core.document.entity.NotesDocumentCoverEntity;
import com.samsung.android.support.senl.p148nt.data.repository.NotesDataRepositoryFactory;
import com.samsung.android.support.senl.p148nt.model.assist.llm.p166sa.AssistSAConstants;
import com.samsung.android.support.senl.p148nt.model.document.save.CoverThumbnailCreator;
import p001A.AbstractC0000a;
import p012C1.RunnableC0050f;
import p035H2.RunnableC0116a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class CoverCreator implements View.OnClickListener, View.OnFocusChangeListener {
    private static final float AUTO_DISABLE = 0.4f;
    private static final float AUTO_ENABLE = 1.0f;
    private static final String CATEGORY_COLLAPSE = "collapse";
    private static final String CATEGORY_EXPAND = "expand";
    private static final float COVER_TEMPLATE_ALPHA = 1.0f;
    private static final float COVER_TEMPLATE_TEXT_ALPHA = 0.4f;
    private static final float COVER_TYPE_PAGE_ALPHA = 0.4f;
    private static final float COVER_TYPE_PAGE_SCALE = 0.2f;
    private static final int MAX_SUMMARY_CHAR = 200;
    public static final int MAX_TITLE_CHAR = 50;
    private static final boolean SUPPORT_GENERATE_COVER_BUTTON = false;
    private static final String TAG = Logger.createCoverTag("CoverCreator");
    private final Activity mActivity;
    private RecyclerView mBadgeRecyclerView;
    private ColorListAdapter mColorListAdapter;
    private RecyclerView mColorRecyclerView;
    private ViewTreeObserver.OnGlobalLayoutListener mContainerLayoutListener;
    private ViewGroup mContainerView;
    private Contract mContract;
    private final Handler mHandler = new Handler(Looper.getMainLooper());
    private final CoverEditorPresenter mPresenter;
    private ViewGroup mRootView;
    private CoverStickerPresenter mStickerPresenter;
    private RecyclerView mStyleRecyclerView;
    private EditText mSummaryView;
    private CoverTabView mTabLayout;
    private TemplateListAdapter mTemplateListAdapter;
    private RecyclerView mTemplateRecyclerView;
    private EditText mTitleView;
    private TypeListAdapter mTypeListAdapter;
    private ViewPager2 mTypeViewPager;

    /* JADX INFO: renamed from: com.samsung.android.support.senl.nt.composer.main.cover.CoverCreator$10 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public class C1091210 implements VIResultView.AnimContract {
        final /* synthetic */ VIResultView val$border;

        public C1091210(VIResultView vIResultView) {
            this.val$border = vIResultView;
        }

        @Override // com.samsung.android.support.senl.nt.composer.main.cover.view.VIResultView.AnimContract
        public void onEnd() {
            this.val$border.setVisibility(8);
        }

        @Override // com.samsung.android.support.senl.nt.composer.main.cover.view.VIResultView.AnimContract
        public void onStart() {
        }
    }

    /* JADX INFO: renamed from: com.samsung.android.support.senl.nt.composer.main.cover.CoverCreator$7 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public class AnimationAnimationListenerC109187 implements Animation.AnimationListener {
        final /* synthetic */ Runnable val$endAction;
        final /* synthetic */ Runnable val$startAction;

        public AnimationAnimationListenerC109187(Runnable runnable, Runnable runnable2) {
            this.val$startAction = runnable;
            this.val$endAction = runnable2;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            Runnable runnable = this.val$endAction;
            if (runnable != null) {
                runnable.run();
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            Runnable runnable = this.val$startAction;
            if (runnable != null) {
                runnable.run();
            }
        }
    }

    /* JADX INFO: renamed from: com.samsung.android.support.senl.nt.composer.main.cover.CoverCreator$8 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public class AnimationAnimationListenerC109198 implements Animation.AnimationListener {
        final /* synthetic */ Runnable val$endAction;
        final /* synthetic */ Runnable val$startAction;

        public AnimationAnimationListenerC109198(Runnable runnable, Runnable runnable2) {
            this.val$startAction = runnable;
            this.val$endAction = runnable2;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            Runnable runnable = this.val$endAction;
            if (runnable != null) {
                runnable.run();
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            Runnable runnable = this.val$startAction;
            if (runnable != null) {
                runnable.run();
            }
        }
    }

    /* JADX INFO: renamed from: com.samsung.android.support.senl.nt.composer.main.cover.CoverCreator$9 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public class C109209 implements AiCoverDataCreator.ProcessCallback {
        public C109209() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onCompleted$1() {
            CoverCreator.this.setProgressView(8);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onFailed$2(String str) {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            ToastHandler.show(CoverCreator.this.mActivity, str, 1);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onStart$0() {
            CoverCreator.this.setProgressView(0);
        }

        @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.cover.AiCoverDataCreator.Callback
        public void onCompleted(String str, String str2, String str3) {
            Logger.m10999d(CoverCreator.TAG, "requestCoverGenerate#onCompleted");
            Context appContext = ApplicationManager.getInstance().getAppContext();
            String randomTemplate = CoverEditorUtils.getRandomTemplate();
            String randomColor = CoverEditorUtils.getRandomColor();
            CoverCreator.this.mPresenter.setTitle(str);
            CoverCreator.this.mPresenter.setSummary(str2);
            if (CscFeature.INSTANCE.getInstance().isChinaAiFeature()) {
                CoverCreator.this.mPresenter.setState(4);
                CoverCreator.this.mPresenter.setTitle(CoverEditorUtils.getAiGeneratedLabelText(appContext, str, CoverCreator.this.mPresenter.getState()));
                CoverCreator.this.mPresenter.setSummary(CoverEditorUtils.getAiGeneratedLabelText(appContext, str2, CoverCreator.this.mPresenter.getState()));
            }
            CoverEditorUtils.savePreviewJpg(appContext, str2, str3, randomTemplate, randomColor, CoverCreator.this.mPresenter.getCoverData().getNoteUuid(), CoverCreator.this.mPresenter.getCoverData().getState());
            CoverCreator.this.mPresenter.setCategoryUuid(str3);
            CoverCreator.this.mPresenter.setTemplateUuid(randomTemplate);
            CoverCreator.this.mPresenter.setColorId(randomColor);
            CoverCreator.this.onCompleteAndUpdateView();
            CoverCreator.this.startPreviewAnimation(0, new RunnableC10938e(this, 1), null);
            CoverCreator.this.setAvailableAutoCover(true);
            CoverCreator.this.mPresenter.setGenerateState(0);
        }

        @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.cover.AiCoverDataCreator.Callback
        public void onFailed(String str) {
            if ("RESTRICTED_USER_ERROR".equals(str)) {
                return;
            }
            final String errorMessage = AiCoverDataCreator.getErrorMessage(str);
            Logger.m10999d(CoverCreator.TAG, "requestCoverGenerate#onFailed : " + errorMessage);
            if (AiCoverDataCreator.isSafetyFilterError(str) && CoverCreator.this.mContract != null) {
                NotesDocumentCoverEntity entity = NotesDataRepositoryFactory.newInstance(CoverCreator.this.mActivity).createDocumentCoverRepository().getEntity(CoverCreator.this.getCoverData().getNoteUuid());
                if (entity == null) {
                    CoverCreator.this.mContract.setCoverEnable(false);
                } else {
                    CoverCreator.this.mContract.setCoverEnable(entity.getIsEnabled() == 1);
                }
            }
            CoverCreator.this.setAvailableAutoCover(true);
            CoverCreator.this.setProgressView(8);
            CoverCreator.this.mPresenter.setGenerateState(0);
            CoverCreator.this.mHandler.post(new Runnable() { // from class: com.samsung.android.support.senl.nt.composer.main.cover.f
                @Override // java.lang.Runnable
                public final void run() {
                    this.f7340a.lambda$onFailed$2(errorMessage);
                }
            });
        }

        @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.cover.AiCoverDataCreator.ProcessCallback
        public void onStart() {
            Logger.m10999d(CoverCreator.TAG, "requestCoverGenerate#onStart");
            ComposerSA.insertLog(AssistSAConstants.SCREEN_NOTE_STYLE_COMPOSER, AssistSAConstants.EVENT_COMPOSER_SUGGEST_NEW_COVER, "b");
            CoverCreator.this.setAvailableAutoCover(false);
            CoverCreator.this.startPreviewAnimation(8, null, new RunnableC10938e(this, 0));
            CoverCreator.this.mPresenter.setGenerateState(1);
            if (CoverCreator.this.mTitleView != null) {
                CoverCreator.this.mPresenter.setTitle(CoverCreator.this.mTitleView.getText().toString());
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface Contract {
        void setCoverEnable(boolean z);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public enum ThumbnailType {
        RECT,
        SQUARE
    }

    public CoverCreator(Activity activity, View view, String str) {
        this.mActivity = activity;
        this.mRootView = (ViewGroup) view.findViewById(C9086R.id.cover_view_container);
        this.mPresenter = new CoverEditorPresenter(activity, this.mRootView, str);
        initNewView();
    }

    private int getTypeIndex(String str) {
        if (this.mPresenter.getCoverData().isEnabled()) {
            return CoverEditorUtils.getTemplateTypeIndex(str);
        }
        return 0;
    }

    private void hideCategoryList(final View view, final BadgeListAdapter badgeListAdapter) {
        this.mBadgeRecyclerView.clearAnimation();
        Animation animationLoadAnimation = AnimationUtils.loadAnimation(this.mRootView.getContext(), C9086R.anim.cover_color_item_hide);
        animationLoadAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.samsung.android.support.senl.nt.composer.main.cover.CoverCreator.6
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                view.setTag(CoverCreator.CATEGORY_COLLAPSE);
                badgeListAdapter.setAnimOption(-1);
                CoverCreator.this.mBadgeRecyclerView.setVisibility(8);
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                badgeListAdapter.setAnimOption(2);
                badgeListAdapter.notifyDataSetChanged();
                CoverCreator.this.showRecommendBtnAnim();
            }
        });
        this.mBadgeRecyclerView.setAnimation(animationLoadAnimation);
        animationLoadAnimation.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideRecommendBtnAnim() {
        FeatureInfo.isAiFeatureEnabled();
    }

    private void initBadgeContainer(String str) {
        ImageView imageView = (ImageView) this.mRootView.findViewById(C9086R.id.edit_badge);
        imageView.setImageDrawable(CoverEditorUtils.getCategoryDrawable(this.mRootView.getContext(), str));
        imageView.setTag(str);
    }

    private void initCategoryAdapter() {
        RecyclerView recyclerView = (RecyclerView) this.mRootView.findViewById(C9086R.id.badge_recyclerview);
        this.mBadgeRecyclerView = recyclerView;
        recyclerView.addItemDecoration(new CoverItemDecoration(this.mActivity.getResources().getDimensionPixelSize(C9086R.dimen.cover_editor_badge_list_margin)));
        this.mBadgeRecyclerView.setLayoutManager(new LinearLayoutManager(this.mRootView.getContext(), 0, false));
        BadgeListAdapter badgeListAdapter = new BadgeListAdapter(CoverData.createCategoryList(), TextUtils.isEmpty(this.mPresenter.getCoverData().getCategoryUuid()) ? CoverEditorUtils.getDefaultCategory() : this.mPresenter.getCoverData().getCategoryUuid(), this.mRootView.findViewById(C9086R.id.edit_badge));
        this.mBadgeRecyclerView.setAdapter(badgeListAdapter);
        this.mBadgeRecyclerView.scrollToPosition(badgeListAdapter.getSelectedPosition());
        badgeListAdapter.setPreviewContract(new C10921a(this));
    }

    private void initColorAdapter() {
        RecyclerView recyclerView = (RecyclerView) this.mRootView.findViewById(C9086R.id.style_recyclerview);
        this.mStyleRecyclerView = recyclerView;
        recyclerView.addItemDecoration(new CoverItemDecoration(this.mActivity.getResources().getDimensionPixelSize(C9086R.dimen.cover_editor_style_list_margin)));
        this.mStyleRecyclerView.setLayoutManager(new LinearLayoutManager(this.mRootView.getContext(), 0, false));
        StyleListAdapter styleListAdapter = new StyleListAdapter(CoverData.createBgColorIds(), TextUtils.isEmpty(this.mPresenter.getCoverData().getColorId()) ? CoverEditorUtils.getDefaultBackgroundColor() : this.mPresenter.getCoverData().getColorId(), this.mRootView.findViewById(C9086R.id.edit_preview));
        this.mStyleRecyclerView.setAdapter(styleListAdapter);
        this.mStyleRecyclerView.scrollToPosition(styleListAdapter.getSelectedPosition());
        styleListAdapter.setPreviewContract(new C10921a(this));
    }

    private void initColorListAdapter(String str) {
        this.mColorListAdapter = new ColorListAdapter(CoverEditorUtils.createColorList(), str);
        RecyclerView recyclerView = (RecyclerView) this.mRootView.findViewById(C9086R.id.color_recyclerview);
        this.mColorRecyclerView = recyclerView;
        recyclerView.addItemDecoration(new CoverItemDecoration(this.mActivity.getResources().getDimensionPixelSize(C9086R.dimen.cover_editor_new_color_item_margin_horizontal)));
        this.mColorRecyclerView.setLayoutManager(new LinearLayoutManager(this.mRootView.getContext(), 0, false));
        this.mColorRecyclerView.setAdapter(this.mColorListAdapter);
        this.mColorRecyclerView.setItemAnimator(null);
        this.mColorRecyclerView.scrollToPosition(this.mColorListAdapter.getSelectedPosition());
        this.mColorListAdapter.setColorContract(new C10921a(this));
    }

    private void initNewView() {
        String defaultTemplate = TextUtils.isEmpty(this.mPresenter.getCoverData().getTemplateUuid()) ? CoverEditorUtils.getDefaultTemplate() : this.mPresenter.getCoverData().getTemplateUuid();
        String defaultBackgroundColor = TextUtils.isEmpty(this.mPresenter.getCoverData().getColorId()) ? CoverEditorUtils.getDefaultBackgroundColor() : this.mPresenter.getCoverData().getColorId();
        String defaultCategory = TextUtils.isEmpty(this.mPresenter.getCoverData().getCategoryUuid()) ? CoverEditorUtils.getDefaultCategory() : this.mPresenter.getCoverData().getCategoryUuid();
        int typeIndex = getTypeIndex(defaultTemplate);
        String str = TAG;
        StringBuilder sb = new StringBuilder("initNewView# state : ");
        sb.append(this.mPresenter.getCoverData().getState());
        sb.append(", uuid : ");
        sb.append(this.mPresenter.getCoverData().getNoteUuid());
        sb.append(", categoryUuid : ");
        sb.append(defaultCategory);
        sb.append(", templateUuid : ");
        AbstractC2821a.m2207B(sb, defaultTemplate, ", colorUuid : ", defaultBackgroundColor, ", typeIndex : ");
        AbstractC8014b.m7221w(sb, str, typeIndex);
        if (this.mPresenter.getCoverData().getSelectedTemplateList() == null) {
            this.mPresenter.setSelectedTemplateList(CoverEditorUtils.createSelectedTemplateList());
            this.mPresenter.setSelectedTemplateUuid(typeIndex, defaultTemplate);
        }
        initTemplateListAdapter(defaultTemplate, defaultBackgroundColor, typeIndex);
        initColorListAdapter(defaultBackgroundColor);
        initTypeListAdapter(typeIndex);
        initStickerPresenter(defaultCategory);
        initTabLayout();
        updateVisibility(typeIndex);
        updateSpan();
    }

    private void initStickerPresenter(String str) {
        CoverStickerPresenter coverStickerPresenter = new CoverStickerPresenter(this.mRootView, str);
        this.mStickerPresenter = coverStickerPresenter;
        coverStickerPresenter.setContract(new CoverStickerPresenter.Contract() { // from class: com.samsung.android.support.senl.nt.composer.main.cover.CoverCreator.2
            @Override // com.samsung.android.support.senl.nt.composer.main.cover.presenter.CoverStickerPresenter.Contract
            public void onDownloadedCoverSticker() {
                CoverCreator.this.mTypeListAdapter.updateDownloadedSticker();
            }

            @Override // com.samsung.android.support.senl.nt.composer.main.cover.presenter.CoverStickerPresenter.Contract
            public void onSelectSticker(int i, int i2, String str2) {
                Logger.m10999d(CoverCreator.TAG, "onSelectSticker# stickerPosition : " + i + ", stickerUuid : " + str2);
                CoverCreator.this.mPresenter.setCategoryUuid(str2);
                CoverCreator.this.mTypeListAdapter.updateSelectedSticker(i, i2);
            }
        });
    }

    private void initTabLayout() {
        CoverTabView coverTabView = new CoverTabView(this.mRootView.getContext(), (TabLayout) this.mRootView.findViewById(C9086R.id.template_tab_layout));
        this.mTabLayout = coverTabView;
        coverTabView.setContract(new C10921a(this));
    }

    private void initTemplateListAdapter(String str, String str2, int i) {
        this.mTemplateListAdapter = new TemplateListAdapter(CoverEditorUtils.createTemplateMap(), str, i, str2);
        RecyclerView recyclerView = (RecyclerView) this.mRootView.findViewById(C9086R.id.template_recyclerview);
        this.mTemplateRecyclerView = recyclerView;
        recyclerView.setLayoutManager(new GridLayoutManager(this.mRootView.getContext(), 4));
        this.mTemplateRecyclerView.setAdapter(this.mTemplateListAdapter);
        this.mTemplateRecyclerView.setItemAnimator(null);
        this.mTemplateListAdapter.setTemplateContract(new C10921a(this));
    }

    private void initTypeListAdapter(int i) {
        this.mTypeListAdapter = new TypeListAdapter(CoverEditorUtils.createTypeList(), this.mPresenter.getCoverData(), i);
        ViewPager2 viewPager2 = (ViewPager2) this.mRootView.findViewById(C9086R.id.type_view_pager);
        this.mTypeViewPager = viewPager2;
        viewPager2.setAdapter(this.mTypeListAdapter);
        this.mTypeViewPager.setCurrentItem(i, false);
        this.mTypeViewPager.setOffscreenPageLimit(3);
        updateTypeViewPager();
        this.mTypeViewPager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() { // from class: com.samsung.android.support.senl.nt.composer.main.cover.CoverCreator.1
            @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
            public void onPageSelected(int i2) {
                super.onPageSelected(i2);
                AbstractC0000a.m3D(i2, "onPageSelected# position : ", CoverCreator.TAG);
                CoverCreator.this.mPresenter.setEnabled(i2 != 0);
                CoverCreator.this.mTypeListAdapter.updateSelectedType(i2);
                CoverCreator coverCreator = CoverCreator.this;
                coverCreator.updateSelectedType(i2, coverCreator.mPresenter.getCoverData().getSelectedTemplateList().get(i2));
                float f = i2 == 0 ? 0.4f : 1.0f;
                CoverCreator.this.mTemplateRecyclerView.setAlpha(f);
                if (i2 == 3) {
                    CoverCreator.this.mColorRecyclerView.setAlpha(f);
                }
            }
        });
        this.mTypeListAdapter.setTypeContract(new C10921a(this));
    }

    private void initView() {
        FeatureInfo.isAiFeatureEnabled();
        this.mRootView.findViewById(C9086R.id.cover_recommend_btn).setVisibility(8);
        EditText editText = (EditText) this.mRootView.findViewById(C9086R.id.edit_title);
        this.mTitleView = editText;
        editText.setHintTextColor(this.mRootView.getContext().getColor(C9086R.color.cover_edit_title_text_hint_color));
        FontUtils.setFont(this.mTitleView, "Roboto_Medium");
        EditText editText2 = (EditText) this.mRootView.findViewById(C9086R.id.edit_summary);
        this.mSummaryView = editText2;
        editText2.setVisibility(0);
        FontUtils.setFont(this.mSummaryView, "Roboto_Medium");
        this.mTitleView.setText(this.mPresenter.getCoverData().getTitle());
        String summary = this.mPresenter.getCoverData().getSummary();
        this.mSummaryView.setText(summary);
        if (!TextUtils.isEmpty(summary)) {
            this.mSummaryView.setBackground(new ColorDrawable(0));
        }
        String defaultCategory = TextUtils.isEmpty(this.mPresenter.getCoverData().getCategoryUuid()) ? CoverEditorUtils.getDefaultCategory() : this.mPresenter.getCoverData().getCategoryUuid();
        String defaultTemplate = TextUtils.isEmpty(this.mPresenter.getCoverData().getTemplateUuid()) ? CoverEditorUtils.getDefaultTemplate() : this.mPresenter.getCoverData().getTemplateUuid();
        String defaultBackgroundColor = TextUtils.isEmpty(this.mPresenter.getCoverData().getColorId()) ? CoverEditorUtils.getDefaultBackgroundColor() : this.mPresenter.getCoverData().getColorId();
        String str = TAG;
        StringBuilder sb = new StringBuilder("initView# state : ");
        sb.append(this.mPresenter.getCoverData().getState());
        sb.append(", uuid : ");
        sb.append(this.mPresenter.getCoverData().getNoteUuid());
        sb.append(", categoryUuid : ");
        sb.append(defaultCategory);
        sb.append(", templateUuid : ");
        AbstractC2821a.m2207B(sb, defaultTemplate, ", colorId : ", defaultBackgroundColor, ", generateState : ");
        sb.append(this.mPresenter.getCoverData().getGenerateState());
        Logger.m10999d(str, sb.toString());
        initBadgeContainer(defaultCategory);
        this.mRootView.findViewById(C9086R.id.edit_preview).setTag(defaultBackgroundColor);
        if (this.mPresenter.getCoverData().getGenerateState() == 1) {
            setProgressView(0);
        } else {
            this.mPresenter.setBackgroundTemplate(this.mRootView.getContext(), this.mRootView, defaultTemplate, defaultBackgroundColor);
            setBadgeBackground(this.mRootView, defaultCategory);
        }
        this.mPresenter.setTemplateColor(this.mRootView.getContext(), defaultBackgroundColor);
        CoverEditorPresenter coverEditorPresenter = this.mPresenter;
        coverEditorPresenter.setSelectedTemplate(coverEditorPresenter.getTemplateIdx(defaultTemplate));
        initCategoryAdapter();
        initColorAdapter();
        setViewListener();
        setViewToolTipText();
        setEditorMaxLengthFilter();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$generateDefaultCoverForNotEnoughContents$14() {
        setProgressView(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initCategoryAdapter$7(String str) {
        this.mRootView.findViewById(C9086R.id.edit_summary).clearFocus();
        this.mPresenter.getCoverData().setCategoryUuid(str);
        setBadgeBackground(this.mRootView, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initColorAdapter$8(String str) {
        AbstractC8014b.m7196B("onSelectBackground# colorId : ", str, TAG);
        this.mRootView.findViewById(C9086R.id.edit_summary).clearFocus();
        this.mPresenter.setColorId(str);
        this.mPresenter.setBackgroundTemplate(this.mRootView.getContext(), this.mRootView, this.mPresenter.getSelectedTemplateUuid(), str);
        this.mPresenter.setTemplateColor(this.mRootView.getContext(), str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initColorListAdapter$4(int i, String str) {
        Logger.m10999d(TAG, "onSelectColor# position : " + i + ", colorUuid : " + str);
        this.mPresenter.setColorId(str);
        this.mTypeListAdapter.updateSelectedColor();
        this.mTemplateListAdapter.updateSelectedColor(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initTabLayout$5(int i) {
        updateVisibility(3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initTemplateListAdapter$3(int i, String str) {
        Logger.m10999d(TAG, "onSelectTemplate# position : " + i + ", templateUuid : " + str);
        this.mPresenter.setSelectedTemplateUuid(CoverEditorUtils.getTemplateTypeIndex(str), str);
        this.mPresenter.setTemplateUuid(str);
        this.mTypeListAdapter.updateSelectedTemplate(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initTypeListAdapter$1(int i) {
        AbstractC0000a.m3D(i, "onSelectType# position : ", TAG);
        this.mTypeViewPager.setCurrentItem(i, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setAvailableAutoCover$10(boolean z) {
        boolean z2 = z && this.mPresenter.getCoverData().getExtractStr().length() > 100;
        Logger.m10999d(TAG, "setAvailableAutoCover# isAvailable : " + z + ", activate : " + z2);
        this.mPresenter.setAvailableAutoCover(z2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setProgressView$9(int i) {
        View viewFindViewById = this.mRootView.findViewById(C9086R.id.cover_progress_container);
        if (viewFindViewById == null || viewFindViewById.getVisibility() == i) {
            return;
        }
        viewFindViewById.setVisibility(i);
        LottieAnimationView lottieAnimationView = (LottieAnimationView) this.mRootView.findViewById(C9086R.id.cover_progress);
        if (i == 0) {
            lottieAnimationView.playAnimation();
        } else {
            lottieAnimationView.cancelAnimation();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$setViewListener$6(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() != 0) {
            return false;
        }
        view.getParent().requestDisallowInterceptTouchEvent(true);
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$updateSpan$0() {
        Context context = this.mRootView.getContext();
        int measuredWidth = this.mContainerView.getMeasuredWidth();
        this.mTemplateRecyclerView.setLayoutManager(new GridLayoutManager(context, CoverEditorUtils.getSpanCount(context, measuredWidth, 0)));
        this.mStickerPresenter.updateStickerSpan(measuredWidth);
        this.mContainerView.getViewTreeObserver().removeOnGlobalLayoutListener(this.mContainerLayoutListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$updateTypeViewPager$2(float f, View view, float f4) {
        view.setTranslationX((-f) * f4);
        view.setAlpha(1.0f - (Math.abs(f4) * 0.4f));
        view.setScaleX(1.0f - (Math.abs(f4) * 0.2f));
        view.setScaleY(1.0f - (Math.abs(f4) * 0.2f));
        updateTemplateAlpha(view.getId(), f4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onCompleteAndUpdateView() {
        Logger.m10999d(TAG, "onCompleteAndUpdateView#");
        String templateUuid = this.mPresenter.getCoverData().getTemplateUuid();
        String colorId = this.mPresenter.getCoverData().getColorId();
        this.mTypeListAdapter.updateSelectedTemplate(templateUuid);
        this.mTemplateListAdapter.updateSelectedTemplate(templateUuid, colorId);
        this.mColorListAdapter.updateSelectedColor(colorId);
        this.mColorRecyclerView.scrollToPosition(this.mColorListAdapter.getSelectedPosition());
        this.mStickerPresenter.updateSelectedSticker(CoverStickerUtils.getStickerIndex(this.mPresenter.getCoverData().getCategoryUuid()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void requestCoverGenerate() {
        AiCoverDataCreatorManager.getInstance().requestCreateCoverData(this.mPresenter.getCoverData().getNoteUuid(), this.mPresenter.getCoverData().getExtractStr(), new C109209());
    }

    private void setBadgeBackground(View view, String str) {
        ((ConstraintLayout) view.findViewById(C9086R.id.edit_preview)).findViewById(C9086R.id.badge_container).setVisibility(str.equals(CoverStickerConstants.Category.NONE.UUID) ? 8 : 0);
    }

    private void setEditorMaxLengthFilter() {
        this.mTitleView.setFilters(new InputFilter[]{new InputFilter.LengthFilter(50) { // from class: com.samsung.android.support.senl.nt.composer.main.cover.CoverCreator.3
            @Override // android.text.InputFilter.LengthFilter, android.text.InputFilter
            public CharSequence filter(CharSequence charSequence, int i, int i2, Spanned spanned, int i4, int i5) {
                if (charSequence.toString().contains("\n")) {
                    charSequence.toString().replaceAll("\n", " ");
                    i2 = charSequence.length();
                }
                CharSequence charSequenceFilter = super.filter(charSequence, i, i2, spanned, i4, i5);
                if (charSequenceFilter == null) {
                    return charSequence;
                }
                CoverCreator.this.showMaxCharToast(50);
                return charSequenceFilter;
            }
        }});
        this.mSummaryView.setFilters(new InputFilter[]{new InputFilter.LengthFilter(200) { // from class: com.samsung.android.support.senl.nt.composer.main.cover.CoverCreator.4
            @Override // android.text.InputFilter.LengthFilter, android.text.InputFilter
            public CharSequence filter(CharSequence charSequence, int i, int i2, Spanned spanned, int i4, int i5) {
                CharSequence charSequenceFilter = super.filter(charSequence, i, i2, spanned, i4, i5);
                if (charSequenceFilter != null) {
                    CoverCreator.this.showMaxCharToast(200);
                }
                return charSequenceFilter;
            }
        }});
    }

    private void setViewListener() {
        this.mRootView.findViewById(C9086R.id.badge_icon).setOnClickListener(this);
        this.mRootView.findViewById(C9086R.id.cover_recommend_btn).setOnClickListener(this);
        this.mSummaryView.setOnFocusChangeListener(this);
        this.mSummaryView.setOnTouchListener(new ViewOnTouchListenerC7005f(19));
        this.mPresenter.setTemplateViewListener(this);
    }

    private void setViewToolTipText() {
        ViewCompat.getInstance().setTooltipText(this.mRootView.findViewById(C9086R.id.badge_icon));
        this.mPresenter.setTemplateViewToolTip(this.mActivity);
    }

    private void showCategoryList(final View view, final BadgeListAdapter badgeListAdapter) {
        this.mBadgeRecyclerView.clearAnimation();
        this.mBadgeRecyclerView.setVisibility(0);
        Animation animationLoadAnimation = AnimationUtils.loadAnimation(this.mRootView.getContext(), C9086R.anim.cover_color_item_show);
        animationLoadAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.samsung.android.support.senl.nt.composer.main.cover.CoverCreator.5
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                view.setTag(CoverCreator.CATEGORY_EXPAND);
                badgeListAdapter.setAnimOption(-1);
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                badgeListAdapter.setAnimOption(1);
                badgeListAdapter.notifyDataSetChanged();
                CoverCreator.this.hideRecommendBtnAnim();
            }
        });
        this.mBadgeRecyclerView.setAnimation(animationLoadAnimation);
        animationLoadAnimation.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showMaxCharToast(int i) {
        UserInputSkipper.Tag tag = UserInputSkipper.Tag.Default;
        if (UserInputSkipper.isValidEvent(tag)) {
            UserInputSkipper.setHoldingEventTime(1000L, tag);
            Activity activity = this.mActivity;
            ToastHandler.show(activity, activity.getString(C9086R.string.composer_maximum_input, Integer.valueOf(i)), 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showRecommendBtnAnim() {
        FeatureInfo.isAiFeatureEnabled();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startPreviewAnimation(int i, Runnable runnable, Runnable runnable2) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateSelectedType(int i, String str) {
        this.mPresenter.setTemplateUuid(str);
        this.mTemplateListAdapter.updateSelectedType(i, str);
        updateVisibility(i);
    }

    private void updateSpan() {
        ViewGroup viewGroup = (ViewGroup) this.mRootView.findViewById(C9086R.id.cover_editor_new_container);
        this.mContainerView = viewGroup;
        if (viewGroup == null) {
            return;
        }
        this.mContainerLayoutListener = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.samsung.android.support.senl.nt.composer.main.cover.d
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public final void onGlobalLayout() {
                this.f7337a.lambda$updateSpan$0();
            }
        };
        viewGroup.getViewTreeObserver().addOnGlobalLayoutListener(this.mContainerLayoutListener);
    }

    private void updateTemplateAlpha(int i, float f) {
        float fAbs;
        float fAbs2;
        if (i != this.mTypeViewPager.getCurrentItem()) {
            return;
        }
        if (i == 0) {
            fAbs2 = (Math.abs(f) * 0.6f) + 0.4f;
        } else if (i != 1 || f <= 0.0f) {
            float fAbs3 = Math.abs(f);
            fAbs = fAbs3 * 1.0f;
            fAbs2 = 1.0f - fAbs;
        } else {
            fAbs = Math.abs(f) * 0.4f;
            fAbs2 = 1.0f - fAbs;
        }
        this.mTemplateRecyclerView.setAlpha(fAbs2);
        if (i == 3) {
            this.mColorRecyclerView.setAlpha(fAbs2);
        }
    }

    private void updateVisibility(int i) {
        if (i != 3) {
            this.mTabLayout.setVisibility(8);
            this.mColorRecyclerView.setVisibility(8);
            this.mStickerPresenter.setVisibility(8);
            this.mTemplateRecyclerView.setVisibility(0);
            return;
        }
        this.mTabLayout.setVisibility(0);
        boolean z = this.mTabLayout.getSelectedTabPosition() == 0;
        this.mColorRecyclerView.setVisibility(z ? 0 : 8);
        this.mTemplateRecyclerView.setVisibility(z ? 0 : 8);
        this.mStickerPresenter.setVisibility(z ? 8 : 0);
    }

    public void cancelCoverGenerate() {
        AiCoverDataCreatorManager.getInstance().cancelCreateCover(this.mPresenter.getCoverData().getNoteUuid());
    }

    public void generateDefaultCoverForNotEnoughContents() {
        String summaryUnderMaxChar = AiCoverDataCreator.parseSummaryUnderMaxChar(this.mPresenter.getCoverData().getExtractStr());
        String defaultCategory = CoverEditorUtils.getDefaultCategory();
        String randomTemplate = CoverEditorUtils.getRandomTemplate();
        String randomColor = CoverEditorUtils.getRandomColor();
        CoverEditorUtils.savePreviewJpg(ApplicationManager.getInstance().getAppContext(), summaryUnderMaxChar, defaultCategory, randomTemplate, randomColor, this.mPresenter.getCoverData().getNoteUuid(), this.mPresenter.getCoverData().getState());
        this.mPresenter.setSummary(summaryUnderMaxChar);
        this.mPresenter.setCategoryUuid(defaultCategory);
        this.mPresenter.setTemplateUuid(randomTemplate);
        this.mPresenter.setColorId(randomColor);
        onCompleteAndUpdateView();
        startPreviewAnimation(0, new RunnableC10935b(this, 0), null);
    }

    public CoverData getCoverData() {
        return this.mPresenter.getCoverData();
    }

    public int getSummarySelection() {
        return -1;
    }

    public int getTabPosition() {
        CoverTabView coverTabView = this.mTabLayout;
        if (coverTabView != null) {
            return coverTabView.getSelectedTabPosition();
        }
        return 0;
    }

    public int getTitleSelection() {
        return -1;
    }

    public String getTitleViewText() {
        EditText editText = this.mTitleView;
        return editText == null ? "" : String.valueOf(editText.getText());
    }

    public boolean isCoverEnabled() {
        return this.mPresenter.getCoverData().isEnabled();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        Logger.m10999d(TAG, "onClick# view : " + view.getTag());
        String strValueOf = String.valueOf(this.mRootView.findViewById(C9086R.id.edit_preview).getTag());
        String strValueOf2 = String.valueOf(this.mRootView.findViewById(C9086R.id.edit_badge).getTag());
        if (id == C9086R.id.badge_icon) {
            BadgeListAdapter badgeListAdapter = (BadgeListAdapter) this.mBadgeRecyclerView.getAdapter();
            if (badgeListAdapter == null) {
                return;
            }
            if (view.getTag() == null || view.getTag().equals(CATEGORY_COLLAPSE)) {
                showCategoryList(view, badgeListAdapter);
                VoiceAssistantTTS.getInstance().sendTalkBackMessage(view.getContext().getResources().getString(C9086R.string.change_template_list_expanded));
            } else if (view.getTag().equals(CATEGORY_EXPAND)) {
                hideCategoryList(view, badgeListAdapter);
                VoiceAssistantTTS.getInstance().sendTalkBackMessage(view.getContext().getResources().getString(C9086R.string.change_template_list_collapsed));
            }
        } else if (id == C9086R.id.cover_recommend_btn) {
            onClickGenerateMenu();
        } else if (id == C9086R.id.cover_template_type1) {
            this.mPresenter.onClickTemplate(this.mActivity, this.mRootView, 0, strValueOf);
        } else if (id == C9086R.id.cover_template_type2) {
            this.mPresenter.onClickTemplate(this.mActivity, this.mRootView, 1, strValueOf);
        } else if (id == C9086R.id.cover_template_type3) {
            this.mPresenter.onClickTemplate(this.mActivity, this.mRootView, 2, strValueOf);
        } else if (id == C9086R.id.cover_template_type4) {
            this.mPresenter.onClickTemplate(this.mActivity, this.mRootView, 3, strValueOf);
        } else if (id == C9086R.id.cover_template_type5) {
            this.mPresenter.onClickTemplate(this.mActivity, this.mRootView, 4, strValueOf);
        }
        setBadgeBackground(this.mRootView, strValueOf2);
    }

    public void onClickGenerateMenu() {
        UserInputSkipper.Tag tag = UserInputSkipper.Tag.Menu;
        if (UserInputSkipper.isValidEvent(tag)) {
            UserInputSkipper.setHoldingEventTime(1000L, tag);
            if (this.mActivity == null) {
                Logger.m11000e(TAG, "onClickGenerateMenu# activity is null");
                return;
            }
            if (this.mPresenter.getCoverData().getGenerateState() == 1) {
                Logger.m10999d(TAG, "onClickGenerateMenu# generating a cover");
            } else if (this.mPresenter.getCoverData().getAvailableAutoCover()) {
                AiCommonUtil.executeActionByServer(this.mActivity, new RunnableC10935b(this, 1));
            } else {
                Logger.m10999d(TAG, "onClickGenerateMenu# Generate cover not available");
                generateDefaultCoverForNotEnoughContents();
            }
        }
    }

    public void onConfigurationChanged(ViewGroup viewGroup) {
        this.mRootView = viewGroup;
        this.mPresenter.init(viewGroup);
        initNewView();
    }

    @Override // android.view.View.OnFocusChangeListener
    public void onFocusChange(View view, boolean z) {
        SpannableString spannableString = new SpannableString(this.mSummaryView.getText());
        if (view.getId() == C9086R.id.edit_summary) {
            AbstractC8014b.m7220v("onFocusChange# hasFocus : ", TAG, z);
            if (z) {
                int selectionEnd = this.mSummaryView.getSelectionEnd();
                spannableString.setSpan(new UnderlineSpan(), 0, spannableString.length(), 0);
                this.mSummaryView.setText(spannableString);
                this.mSummaryView.setSelection(selectionEnd);
                this.mSummaryView.setBackground(ResourcesCompat.getDrawable(this.mActivity.getResources(), C9086R.drawable.cover_editor_preview_edit_summary_background, null));
                return;
            }
            for (UnderlineSpan underlineSpan : (UnderlineSpan[]) spannableString.getSpans(0, spannableString.length(), UnderlineSpan.class)) {
                spannableString.removeSpan(underlineSpan);
            }
            this.mSummaryView.setText(spannableString);
            if (TextUtils.isEmpty(spannableString)) {
                return;
            }
            this.mSummaryView.setBackground(new ColorDrawable(0));
        }
    }

    public void saveCoverData(String str) {
        this.mPresenter.saveCoverData(getTitleViewText(), this.mPresenter.getCoverData().getSummary(), str);
        if (WidgetAccessHandler.getWidgetAccessContract() != null) {
            WidgetAccessHandler.getWidgetAccessContract().sendUpdateUuidWidgetBroadcast(this.mActivity.getBaseContext(), this.mPresenter.getCoverData().getNoteUuid());
        }
    }

    public void savePreviewJpgWithView() {
        Logger.m10999d(TAG, "savePreviewJpgWithView");
        CoverEditorUtils.savePreviewJpg(this.mActivity, this.mPresenter.getCoverData().getSummary(), this.mPresenter.getCoverData().getCategoryUuid(), this.mPresenter.getCoverData().getTemplateUuid(), this.mPresenter.getCoverData().getColorId(), CoverThumbnailCreator.COVER_PATH_PREFIX + this.mPresenter.getCoverData().getNoteUuid(), this.mPresenter.getCoverData().getState());
    }

    public void setAvailableAutoCover(boolean z) {
        this.mHandler.post(new RunnableC0116a(17, this, z));
    }

    public void setContract(Contract contract) {
        this.mContract = contract;
    }

    public void setProgressView(int i) {
        this.mHandler.post(new RunnableC0050f(this, i, 23));
    }

    public void setSummaryFocus(int i) {
        if (this.mSummaryView != null) {
            AbstractC0000a.m3D(i, "setSummaryFocus# position : ", TAG);
            this.mSummaryView.requestFocus();
            this.mSummaryView.setSelection(i);
            InputMethodCompat.getInstance().showSoftInput(this.mRootView.getContext(), this.mSummaryView);
        }
    }

    public void setTabPosition(int i) {
        if (this.mTabLayout == null || this.mTypeViewPager.getCurrentItem() != 3) {
            return;
        }
        this.mTabLayout.setSelectedTab(i);
    }

    public void setTitleFocus(int i) {
        EditText editText = this.mTitleView;
        if (editText != null) {
            editText.requestFocus();
            this.mTitleView.setSelection(i);
            InputMethodCompat.getInstance().showSoftInput(this.mRootView.getContext(), this.mTitleView);
        }
    }

    public void updateCoverEnable(String str, boolean z) {
    }

    public void updateCoverEntity() {
        this.mPresenter.updateCoverEntity(this.mActivity);
    }

    public void updateTypeViewPager() {
        int spaceForFlexibleSpacing = this.mRootView.getMeasuredWidth() <= 0 ? this.mActivity.getResources().getDisplayMetrics().widthPixels - (DisplayUtils.getSpaceForFlexibleSpacing(this.mRootView.getContext()) * 2) : this.mRootView.getMeasuredWidth();
        if (this.mActivity.getResources().getConfiguration().orientation == 2) {
            spaceForFlexibleSpacing /= 2;
        }
        TypedValue typedValue = new TypedValue();
        this.mActivity.getResources().getValue(C9086R.dimen.cover_editor_new_type_view_page_width_percent, typedValue, true);
        float f = typedValue.getFloat();
        this.mActivity.getResources().getValue(C9086R.dimen.cover_editor_new_type_view_page_margin_horizontal_percent, typedValue, true);
        float f4 = spaceForFlexibleSpacing;
        float f5 = 1.0f - f;
        final float f6 = ((f4 * f5) + (((f5 / 2.0f) * f4) * 0.1f)) - (f4 * typedValue.getFloat());
        this.mTypeViewPager.setPageTransformer(new ViewPager2.PageTransformer() { // from class: com.samsung.android.support.senl.nt.composer.main.cover.c
            @Override // androidx.viewpager2.widget.ViewPager2.PageTransformer
            public final void transformPage(View view, float f7) {
                this.f7335a.lambda$updateTypeViewPager$2(f6, view, f7);
            }
        });
    }

    public CoverCreator(Activity activity, View view, CoverData coverData) {
        this.mActivity = activity;
        this.mRootView = (ViewGroup) view.findViewById(C9086R.id.cover_view_container);
        this.mPresenter = new CoverEditorPresenter(this.mRootView, coverData);
        initNewView();
    }
}
