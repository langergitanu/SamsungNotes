package com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.notestyle.cover;

import android.animation.TimeInterpolator;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputFilter;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.transition.AutoTransition;
import android.transition.TransitionManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.animation.PathInterpolator;
import android.widget.EditText;
import android.widget.LinearLayout;
import androidx.fragment.app.Fragment;
import com.google.android.material.tabs.TabLayout;
import com.samsung.android.support.senl.p148nt.base.common.UserInputSkipper;
import com.samsung.android.support.senl.p148nt.base.winset.toast.ToastHandler;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.notestyle.cover.CoverStyleFragment;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.notestyle.cover.presenter.CoverColorPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.notestyle.cover.presenter.CoverStickerPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.notestyle.cover.presenter.CoverStylePresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.notestyle.cover.presenter.CoverTemplatePresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.notestyle.cover.util.CoverStyleConstants;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.notestyle.cover.view.CoverStyleTabView;
import com.samsung.android.support.senl.p148nt.composer.main.cover.model.CoverData;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m13885d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000e\u0018\u0000 @2\u00020\u0001:\u0002?@B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0016J&\u0010\u001e\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\"2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0016J\u0010\u0010#\u001a\u00020\u001b2\u0006\u0010$\u001a\u00020\u0013H\u0002J\u0010\u0010%\u001a\u00020\u001b2\u0006\u0010$\u001a\u00020\u0013H\u0002J\u0010\u0010&\u001a\u00020\u001b2\u0006\u0010$\u001a\u00020\u0013H\u0002J\u0010\u0010'\u001a\u00020\u001b2\u0006\u0010$\u001a\u00020\u0013H\u0002J\u0010\u0010(\u001a\u00020\u001b2\u0006\u0010)\u001a\u00020*H\u0016J\u0010\u0010+\u001a\u00020\u001b2\u0006\u0010$\u001a\u00020\u0013H\u0002J\u0010\u0010,\u001a\u00020\u001b2\u0006\u0010$\u001a\u00020\u0013H\u0002J\b\u0010-\u001a\u00020\u001bH\u0002J\u0010\u0010.\u001a\u00020\u001b2\u0006\u0010/\u001a\u000200H\u0002J\u001e\u00101\u001a\u00020\u001b2\u0006\u00102\u001a\u0002032\u0006\u00104\u001a\u0002032\u0006\u00105\u001a\u000203J\u000e\u00106\u001a\u00020\u001b2\u0006\u00107\u001a\u000203J\u000e\u00108\u001a\u00020\u001b2\u0006\u00109\u001a\u00020\u0019J\u000e\u0010:\u001a\u00020\u001b2\u0006\u0010;\u001a\u00020\u0005J\u0010\u0010<\u001a\u00020\u001b2\b\u0010=\u001a\u0004\u0018\u00010\tJ\u0006\u0010>\u001a\u00020\u0019R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006A"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/base/view/menu/notestyle/cover/CoverStyleFragment;", "Landroidx/fragment/app/Fragment;", "<init>", "()V", "mContract", "Lcom/samsung/android/support/senl/nt/composer/main/base/view/menu/notestyle/cover/CoverStyleFragment$Contract;", "mContainer", "Landroid/widget/LinearLayout;", "mPresenter", "Lcom/samsung/android/support/senl/nt/composer/main/base/view/menu/notestyle/cover/presenter/CoverStylePresenter;", "mTemplatePresenter", "Lcom/samsung/android/support/senl/nt/composer/main/base/view/menu/notestyle/cover/presenter/CoverTemplatePresenter;", "mColorPresenter", "Lcom/samsung/android/support/senl/nt/composer/main/base/view/menu/notestyle/cover/presenter/CoverColorPresenter;", "mStickerPresenter", "Lcom/samsung/android/support/senl/nt/composer/main/base/view/menu/notestyle/cover/presenter/CoverStickerPresenter;", "mTabLayout", "Lcom/samsung/android/support/senl/nt/composer/main/base/view/menu/notestyle/cover/view/CoverStyleTabView;", "mCoverHeader", "Landroid/view/View;", "mStickerHeader", "mTitleContainer", "mTitleView", "Landroid/widget/EditText;", "mIsTitleVisible", "", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "initTemplatePresenter", "rootView", "initColorPresenter", "initStickerPresenter", "initTabLayout", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "initHeader", "initTitleView", "showMaxCharToast", "updateVisibility", "typeIndex", "", "updateCover", "templateUuid", "", "colorUuid", "stickerUuid", "setTitle", "title", "updateTitleVisibility", "isVisible", "setContract", "contract", "setPresenter", "presenter", "isTextTab", "Contract", "Companion", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class CoverStyleFragment extends Fragment {

    @NotNull
    public static final String TAG = "CoverStyleFragment";

    @Nullable
    private CoverColorPresenter mColorPresenter;

    @Nullable
    private LinearLayout mContainer;

    @Nullable
    private Contract mContract;

    @Nullable
    private View mCoverHeader;
    private boolean mIsTitleVisible;

    @Nullable
    private CoverStylePresenter mPresenter;

    @Nullable
    private View mStickerHeader;

    @Nullable
    private CoverStickerPresenter mStickerPresenter;

    @Nullable
    private CoverStyleTabView mTabLayout;

    @Nullable
    private CoverTemplatePresenter mTemplatePresenter;

    @Nullable
    private View mTitleContainer;

    @Nullable
    private EditText mTitleView;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&J\u0010\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0018\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u0007H&¨\u0006\u000b"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/base/view/menu/notestyle/cover/CoverStyleFragment$Contract;", "", "updateCoverPreview", "", "updateCreateBtn", "updateCoverAILayout", "visibility", "", "updateCoverSticker", "stickerPosition", "stickerPrevPosition", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public interface Contract {
        void updateCoverAILayout(int visibility);

        void updateCoverPreview();

        void updateCoverSticker(int stickerPosition, int stickerPrevPosition);

        void updateCreateBtn();
    }

    private final void initColorPresenter(View rootView) {
        Logger.m10999d(TAG, "initColorPresenter");
        if (this.mPresenter != null) {
            Context contextRequireContext = requireContext();
            Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
            CoverColorPresenter coverColorPresenter = new CoverColorPresenter(contextRequireContext);
            this.mColorPresenter = coverColorPresenter;
            coverColorPresenter.initialize(this.mPresenter, rootView);
            CoverColorPresenter coverColorPresenter2 = this.mColorPresenter;
            if (coverColorPresenter2 != null) {
                coverColorPresenter2.setContract(new CoverColorPresenter.Contract() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.notestyle.cover.CoverStyleFragment$initColorPresenter$1$1
                    @Override // com.samsung.android.support.senl.nt.composer.main.base.view.menu.notestyle.cover.presenter.CoverColorPresenter.Contract
                    public void onSelectColor(String colorUuid) {
                        Intrinsics.checkNotNullParameter(colorUuid, "colorUuid");
                        Logger.m10999d(CoverStyleFragment.TAG, "onSelectColor# colorUuid : " + colorUuid);
                        CoverTemplatePresenter coverTemplatePresenter = this.this$0.mTemplatePresenter;
                        if (coverTemplatePresenter != null) {
                            coverTemplatePresenter.updateSelectedColor(colorUuid);
                        }
                        CoverStyleFragment.Contract contract = this.this$0.mContract;
                        if (contract != null) {
                            contract.updateCoverPreview();
                        }
                        CoverStyleFragment.Contract contract2 = this.this$0.mContract;
                        if (contract2 != null) {
                            contract2.updateCreateBtn();
                        }
                    }
                });
            }
        }
    }

    private final void initHeader(View rootView) {
        this.mCoverHeader = rootView.findViewById(C9086R.id.cover_header);
        this.mStickerHeader = rootView.findViewById(C9086R.id.sticker_header);
    }

    private final void initStickerPresenter(View rootView) {
        Logger.m10999d(TAG, "initStickerPresenter");
        if (this.mPresenter != null) {
            Context contextRequireContext = requireContext();
            Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
            CoverStickerPresenter coverStickerPresenter = new CoverStickerPresenter(contextRequireContext);
            this.mStickerPresenter = coverStickerPresenter;
            coverStickerPresenter.initialize(this.mPresenter, rootView);
            CoverStickerPresenter coverStickerPresenter2 = this.mStickerPresenter;
            if (coverStickerPresenter2 != null) {
                coverStickerPresenter2.setContract(new CoverStickerPresenter.Contract() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.notestyle.cover.CoverStyleFragment$initStickerPresenter$1$1
                    @Override // com.samsung.android.support.senl.nt.composer.main.base.view.menu.notestyle.cover.presenter.CoverStickerPresenter.Contract
                    public void onSelectSticker(int stickerPosition, int stickerPrevPosition, String stickerUuid) {
                        Logger.m10999d(CoverStyleFragment.TAG, "onSelectSticker# stickerPosition : " + stickerPosition + ", stickerUuid : " + stickerUuid);
                        CoverStylePresenter coverStylePresenter = this.this$0.mPresenter;
                        if (coverStylePresenter != null) {
                            coverStylePresenter.setStickerUuid(stickerUuid);
                        }
                        CoverStyleFragment.Contract contract = this.this$0.mContract;
                        if (contract != null) {
                            contract.updateCoverPreview();
                        }
                        CoverStyleFragment.Contract contract2 = this.this$0.mContract;
                        if (contract2 != null) {
                            contract2.updateCoverSticker(stickerPosition, stickerPrevPosition);
                        }
                        CoverStyleFragment.Contract contract3 = this.this$0.mContract;
                        if (contract3 != null) {
                            contract3.updateCreateBtn();
                        }
                    }
                });
            }
            CoverStickerPresenter coverStickerPresenter3 = this.mStickerPresenter;
            if (coverStickerPresenter3 != null) {
                coverStickerPresenter3.updateSpanCount();
            }
        }
    }

    private final void initTabLayout(View rootView) {
        CoverStylePresenter coverStylePresenter;
        CoverData coverData;
        Logger.m10999d(TAG, "initTabLayout");
        if (this.mPresenter != null) {
            Context contextRequireContext = requireContext();
            Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
            View viewFindViewById = rootView.findViewById(C9086R.id.cover_tab_layout);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
            CoverStyleTabView coverStyleTabView = new CoverStyleTabView(contextRequireContext, (TabLayout) viewFindViewById);
            this.mTabLayout = coverStyleTabView;
            coverStyleTabView.setVisibility(0);
            CoverStyleTabView coverStyleTabView2 = this.mTabLayout;
            if (coverStyleTabView2 != null) {
                coverStyleTabView2.setTabRippleColor(null);
            }
            CoverStylePresenter coverStylePresenter2 = this.mPresenter;
            Intrinsics.checkNotNull(coverStylePresenter2);
            CoverStylePresenter coverStylePresenter3 = this.mPresenter;
            Intrinsics.checkNotNull(coverStylePresenter3);
            int typeIndex = coverStylePresenter2.getTypeIndex(coverStylePresenter3.getTemplateUuid());
            CoverStyleTabView coverStyleTabView3 = this.mTabLayout;
            if (coverStyleTabView3 != null) {
                coverStyleTabView3.setSelectedTab(typeIndex);
            }
            CoverStyleTabView coverStyleTabView4 = this.mTabLayout;
            if (coverStyleTabView4 != null) {
                coverStyleTabView4.setContract(new CoverStyleTabView.Contract() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.notestyle.cover.CoverStyleFragment$initTabLayout$1$1
                    @Override // com.samsung.android.support.senl.nt.composer.main.base.view.menu.notestyle.cover.view.CoverStyleTabView.Contract
                    public void onSelectTab(int position) {
                        CoverStylePresenter coverStylePresenter4;
                        CoverData coverData2;
                        CoverStickerPresenter coverStickerPresenter;
                        CoverData coverData3;
                        CoverStylePresenter coverStylePresenter5 = this.this$0.mPresenter;
                        String str = (coverStylePresenter5 == null || (coverData3 = coverStylePresenter5.getCoverData()) == null) ? null : coverData3.getSelectedTemplateList().get(position);
                        Logger.m10999d(CoverStyleFragment.TAG, "onSelectTab# position : " + position + " , selectedTemplate : " + str);
                        CoverStylePresenter coverStylePresenter6 = this.this$0.mPresenter;
                        if (coverStylePresenter6 != null) {
                            coverStylePresenter6.setTemplateUuid(str);
                        }
                        CoverTemplatePresenter coverTemplatePresenter = this.this$0.mTemplatePresenter;
                        if (coverTemplatePresenter != null) {
                            coverTemplatePresenter.updateSelectedType(position, str);
                        }
                        CoverStyleConstants.CoverType coverType = CoverStyleConstants.CoverType.TEXT;
                        if (position == coverType.ordinal() && (coverStickerPresenter = this.this$0.mStickerPresenter) != null) {
                            coverStickerPresenter.updateSpanCount();
                        }
                        this.this$0.updateVisibility(position);
                        CoverStyleFragment.Contract contract = this.this$0.mContract;
                        if (contract != null) {
                            contract.updateCoverPreview();
                        }
                        CoverStyleFragment.Contract contract2 = this.this$0.mContract;
                        if (contract2 != null) {
                            contract2.updateCoverAILayout((position != coverType.ordinal() || (coverStylePresenter4 = this.this$0.mPresenter) == null || (coverData2 = coverStylePresenter4.getCoverData()) == null || !coverData2.getAvailableAutoCover()) ? 8 : 0);
                        }
                    }
                });
            }
            Contract contract = this.mContract;
            if (contract != null) {
                contract.updateCoverAILayout((typeIndex != CoverStyleConstants.CoverType.TEXT.ordinal() || (coverStylePresenter = this.mPresenter) == null || (coverData = coverStylePresenter.getCoverData()) == null || !coverData.getAvailableAutoCover()) ? 8 : 0);
            }
        }
    }

    private final void initTemplatePresenter(View rootView) {
        Logger.m10999d(TAG, "initTemplatePresenter");
        if (this.mPresenter != null) {
            Context contextRequireContext = requireContext();
            Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
            CoverTemplatePresenter coverTemplatePresenter = new CoverTemplatePresenter(contextRequireContext);
            this.mTemplatePresenter = coverTemplatePresenter;
            coverTemplatePresenter.initialize(this.mPresenter, rootView);
            CoverTemplatePresenter coverTemplatePresenter2 = this.mTemplatePresenter;
            if (coverTemplatePresenter2 != null) {
                coverTemplatePresenter2.setContract(new CoverTemplatePresenter.Contract() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.notestyle.cover.CoverStyleFragment$initTemplatePresenter$1$1
                    @Override // com.samsung.android.support.senl.nt.composer.main.base.view.menu.notestyle.cover.presenter.CoverTemplatePresenter.Contract
                    public void onSelectTemplate(String templateUuid) {
                        Intrinsics.checkNotNullParameter(templateUuid, "templateUuid");
                        Logger.m10999d(CoverStyleFragment.TAG, "onSelectTemplate# templateUuid : " + templateUuid);
                        CoverStyleFragment.Contract contract = this.this$0.mContract;
                        if (contract != null) {
                            contract.updateCoverPreview();
                        }
                        CoverStyleFragment.Contract contract2 = this.this$0.mContract;
                        if (contract2 != null) {
                            contract2.updateCreateBtn();
                        }
                    }
                });
            }
        }
    }

    private final void initTitleView(View rootView) {
        CoverData coverData;
        CoverData coverData2;
        this.mTitleContainer = rootView.findViewById(C9086R.id.cover_title_container);
        EditText editText = (EditText) rootView.findViewById(C9086R.id.cover_title);
        this.mTitleView = editText;
        if (editText != null) {
            editText.addTextChangedListener(new TextWatcher() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.notestyle.cover.CoverStyleFragment.initTitleView.1
                @Override // android.text.TextWatcher
                public void afterTextChanged(Editable s) {
                    CoverStylePresenter coverStylePresenter = CoverStyleFragment.this.mPresenter;
                    if (coverStylePresenter != null) {
                        coverStylePresenter.setTitle(String.valueOf(s));
                    }
                }

                @Override // android.text.TextWatcher
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                }

                @Override // android.text.TextWatcher
                public void onTextChanged(CharSequence s, int start, int before, int count) {
                }
            });
        }
        EditText editText2 = this.mTitleView;
        if (editText2 != null) {
            editText2.setFilters(new InputFilter[]{new InputFilter.LengthFilter() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.notestyle.cover.CoverStyleFragment.initTitleView.2
                {
                    super(50);
                }

                @Override // android.text.InputFilter.LengthFilter, android.text.InputFilter
                public CharSequence filter(CharSequence source, int start, int end, Spanned dest, int dstart, int dend) {
                    Intrinsics.checkNotNullParameter(source, "source");
                    if (StringsKt.m14162r(source.toString(), "\n")) {
                        new Regex("\n").replace(source.toString(), " ");
                        end = source.length();
                    }
                    CharSequence charSequenceFilter = super.filter(source, start, end, dest, dstart, dend);
                    if (charSequenceFilter == null) {
                        return source;
                    }
                    CoverStyleFragment.this.showMaxCharToast();
                    return charSequenceFilter;
                }
            }});
        }
        CoverStylePresenter coverStylePresenter = this.mPresenter;
        String title = (coverStylePresenter == null || (coverData2 = coverStylePresenter.getCoverData()) == null) ? null : coverData2.getTitle();
        CoverStylePresenter coverStylePresenter2 = this.mPresenter;
        if (coverStylePresenter2 == null || (coverData = coverStylePresenter2.getCoverData()) == null || !coverData.getIsGeneratedTitle() || TextUtils.isEmpty(title)) {
            return;
        }
        EditText editText3 = this.mTitleView;
        if (editText3 != null) {
            editText3.setText(title);
        }
        CoverStyleTabView coverStyleTabView = this.mTabLayout;
        if (coverStyleTabView == null || coverStyleTabView.getSelectedTabPosition() != CoverStyleConstants.CoverType.TEXT.ordinal()) {
            return;
        }
        updateTitleVisibility(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showMaxCharToast() {
        UserInputSkipper.Tag tag = UserInputSkipper.Tag.Default;
        if (UserInputSkipper.isValidEvent(tag)) {
            Context contextRequireContext = requireContext();
            Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
            UserInputSkipper.setHoldingEventTime(1000L, tag);
            String string = contextRequireContext.getString(C9086R.string.composer_maximum_input, 50);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            ToastHandler.show(contextRequireContext, string, 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateVisibility(int typeIndex) {
        boolean z = typeIndex == CoverStyleConstants.CoverType.TEXT.ordinal();
        CoverColorPresenter coverColorPresenter = this.mColorPresenter;
        if (coverColorPresenter != null) {
            coverColorPresenter.setVisibility(z ? 0 : 8);
        }
        CoverStickerPresenter coverStickerPresenter = this.mStickerPresenter;
        if (coverStickerPresenter != null) {
            coverStickerPresenter.setVisibility(z ? 0 : 8);
        }
        View view = this.mCoverHeader;
        if (view != null) {
            view.setVisibility(z ? 0 : 8);
        }
        View view2 = this.mStickerHeader;
        if (view2 != null) {
            view2.setVisibility(z ? 0 : 8);
        }
        View view3 = this.mTitleContainer;
        if (view3 != null) {
            view3.setVisibility((z && this.mIsTitleVisible) ? 0 : 8);
        }
    }

    public final boolean isTextTab() {
        CoverStyleTabView coverStyleTabView = this.mTabLayout;
        return (coverStyleTabView == null || coverStyleTabView == null || coverStyleTabView.getSelectedTabPosition() != CoverStyleConstants.CoverType.TEXT.ordinal()) ? false : true;
    }

    @Override // androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(@NotNull Configuration newConfig) {
        Intrinsics.checkNotNullParameter(newConfig, "newConfig");
        super.onConfigurationChanged(newConfig);
        CoverStickerPresenter coverStickerPresenter = this.mStickerPresenter;
        if (coverStickerPresenter != null) {
            coverStickerPresenter.updateSpanCount();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Logger.m10999d(TAG, "onCreate");
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        Logger.m10999d(TAG, "onCreateView");
        View viewInflate = inflater.inflate(C9086R.layout.cover_style_layout, container, false);
        this.mContainer = (LinearLayout) viewInflate.findViewById(C9086R.id.cover_style_layout_container);
        Intrinsics.checkNotNull(viewInflate);
        initTemplatePresenter(viewInflate);
        initColorPresenter(viewInflate);
        initStickerPresenter(viewInflate);
        initTabLayout(viewInflate);
        initHeader(viewInflate);
        initTitleView(viewInflate);
        CoverStylePresenter coverStylePresenter = this.mPresenter;
        if (coverStylePresenter != null) {
            Intrinsics.checkNotNull(coverStylePresenter);
            CoverStylePresenter coverStylePresenter2 = this.mPresenter;
            Intrinsics.checkNotNull(coverStylePresenter2);
            updateVisibility(coverStylePresenter.getTypeIndex(coverStylePresenter2.getTemplateUuid()));
        }
        Contract contract = this.mContract;
        if (contract != null) {
            contract.updateCoverPreview();
        }
        return viewInflate;
    }

    public final void setContract(@NotNull Contract contract) {
        Intrinsics.checkNotNullParameter(contract, "contract");
        this.mContract = contract;
    }

    public final void setPresenter(@Nullable CoverStylePresenter presenter) {
        this.mPresenter = presenter;
    }

    public final void setTitle(@NotNull String title) {
        Intrinsics.checkNotNullParameter(title, "title");
        CoverStylePresenter coverStylePresenter = this.mPresenter;
        if (coverStylePresenter != null) {
            coverStylePresenter.setTitle(title);
        }
        EditText editText = this.mTitleView;
        if (editText != null) {
            editText.setText(title);
        }
        updateTitleVisibility(true);
    }

    public final void updateCover(@NotNull String templateUuid, @NotNull String colorUuid, @NotNull String stickerUuid) {
        Intrinsics.checkNotNullParameter(templateUuid, "templateUuid");
        Intrinsics.checkNotNullParameter(colorUuid, "colorUuid");
        Intrinsics.checkNotNullParameter(stickerUuid, "stickerUuid");
        Logger.m10999d(TAG, "updateCover");
        CoverStyleTabView coverStyleTabView = this.mTabLayout;
        if (coverStyleTabView != null) {
            coverStyleTabView.setSelectedTab(CoverStyleConstants.CoverType.TEXT.ordinal());
        }
        CoverTemplatePresenter coverTemplatePresenter = this.mTemplatePresenter;
        if (coverTemplatePresenter != null) {
            coverTemplatePresenter.updateSelectedTemplate(templateUuid, colorUuid);
        }
        CoverColorPresenter coverColorPresenter = this.mColorPresenter;
        if (coverColorPresenter != null) {
            coverColorPresenter.updateSelectedColor(colorUuid);
        }
        CoverStickerPresenter coverStickerPresenter = this.mStickerPresenter;
        if (coverStickerPresenter != null) {
            coverStickerPresenter.updateSelectedSticker(stickerUuid);
        }
    }

    public final void updateTitleVisibility(boolean isVisible) {
        this.mIsTitleVisible = isVisible;
        View view = this.mTitleContainer;
        if (view == null) {
            return;
        }
        ViewParent parent = view.getParent();
        ViewGroup viewGroup = parent instanceof ViewGroup ? (ViewGroup) parent : null;
        if (viewGroup == null) {
            return;
        }
        AutoTransition autoTransition = new AutoTransition();
        autoTransition.setDuration(400L);
        autoTransition.setInterpolator((TimeInterpolator) new PathInterpolator(0.22f, 0.25f, 0.0f, 1.0f));
        TransitionManager.beginDelayedTransition(viewGroup, autoTransition);
        view.setVisibility(isVisible ? 0 : 8);
    }
}
