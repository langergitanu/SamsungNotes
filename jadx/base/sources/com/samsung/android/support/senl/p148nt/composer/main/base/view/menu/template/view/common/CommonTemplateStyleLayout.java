package com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.template.view.common;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.AlertDialog;
import androidx.core.content.ContextCompat;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.google.android.material.tabs.TabLayout;
import com.samsung.android.sdk.mobileservice.profile.Profile;
import com.samsung.android.sdk.smp.common.constants.MarketingConstants;
import com.samsung.android.support.senl.p148nt.app.common.NotesConstants;
import com.samsung.android.support.senl.p148nt.base.common.util.ButtonBackgroundUtils;
import com.samsung.android.support.senl.p148nt.base.winset.view.AbsViewPager;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.option.RunnableC9844c;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.p156sa.ComposerSA;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.p156sa.SortPageSAConstants;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.notestyle.common.Constant;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.template.util.TemplateConstants;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.template.util.p158sa.SAConstants;
import com.samsung.android.support.senl.p148nt.model.assist.llm.p166sa.AssistSAConstants;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p039I2.DialogInterfaceOnClickListenerC0140a;
import p046K2.DialogInterfaceOnClickListenerC0161a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m13885d1 = {"\u0000\u008a\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 Y2\u00020\u0001:\u0003WXYB\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u001b\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0004\u0010\bB#\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\u000bB\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\f\u001a\u00020\r¢\u0006\u0004\b\u0004\u0010\u000eJ\u0010\u0010'\u001a\u00020&2\u0006\u0010\u0002\u001a\u00020\u0003H\u0002J\u0006\u0010(\u001a\u00020&J\u0006\u0010)\u001a\u00020&J\u000e\u0010*\u001a\u00020&2\u0006\u0010+\u001a\u00020,J\u000e\u00103\u001a\u00020&2\u0006\u00104\u001a\u000205J\u0006\u00106\u001a\u00020\rJ\u0006\u00107\u001a\u00020\rJ\u0006\u00108\u001a\u00020&J\u000e\u00109\u001a\u00020&2\u0006\u0010:\u001a\u00020\nJ\u000e\u0010;\u001a\u00020&2\u0006\u0010:\u001a\u00020\nJ\u0010\u0010<\u001a\u00020&2\u0006\u0010:\u001a\u00020\nH\u0002J\u0010\u0010=\u001a\u00020&2\u0006\u0010:\u001a\u00020\nH\u0002J\u0010\u0010>\u001a\u00020&2\u0006\u0010:\u001a\u00020\nH\u0002J\u001a\u0010?\u001a\u00020&2\b\u0010@\u001a\u0004\u0018\u00010\u001b2\u0006\u0010A\u001a\u00020\rH\u0002J\u0006\u0010B\u001a\u00020&J\u000e\u0010C\u001a\u00020&2\u0006\u0010D\u001a\u00020!J\u000e\u0010E\u001a\u00020&2\u0006\u0010F\u001a\u00020#J\u000e\u0010G\u001a\u00020\n2\u0006\u0010H\u001a\u00020\nJ\b\u0010I\u001a\u00020&H\u0002J\b\u0010J\u001a\u00020KH\u0002J\b\u0010L\u001a\u00020&H\u0002J\b\u0010M\u001a\u00020&H\u0002J\b\u0010N\u001a\u00020\nH\u0002J\u0010\u0010O\u001a\u00020&2\u0006\u0010P\u001a\u00020\nH\u0002J\b\u0010Q\u001a\u00020&H\u0002J\b\u0010R\u001a\u00020&H\u0002J\b\u0010S\u001a\u00020&H\u0002J\u0012\u0010T\u001a\u00020&2\b\u0010U\u001a\u0004\u0018\u00010VH\u0014R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u001e\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u001fR\u0010\u0010 \u001a\u0004\u0018\u00010!X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\"\u001a\u0004\u0018\u00010#X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010$\u001a\n\u0012\u0004\u0012\u00020&\u0018\u00010%X\u0082\u000e¢\u0006\u0002\n\u0000R$\u0010.\u001a\u00020\n2\u0006\u0010-\u001a\u00020\n8F@BX\u0086\u000e¢\u0006\f\u001a\u0004\b/\u00100\"\u0004\b1\u00102¨\u0006Z"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/base/view/menu/template/view/common/CommonTemplateStyleLayout;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "isSettings", "", "(Landroid/content/Context;Z)V", "mViewPager", "Lcom/samsung/android/support/senl/nt/base/winset/view/AbsViewPager;", "mCategoryTab", "Lcom/google/android/material/tabs/TabLayout;", "mScrollView", "Landroid/view/View;", "mEditTab", "mSelectedAllBtn", "Landroid/widget/CheckBox;", "mSelectedInfo", "Landroid/widget/TextView;", "mRenameBtn", "Landroid/widget/ImageButton;", "mDeleteBtn", "mDoneBtn", "mCurrentPage", "Ljava/lang/Integer;", "mContract", "Lcom/samsung/android/support/senl/nt/composer/main/base/view/menu/template/view/common/CommonTemplateStyleLayout$Contract;", "mCallback", "Lcom/samsung/android/support/senl/nt/composer/main/base/view/menu/template/view/common/CommonTemplateStyleLayout$Callback;", "mLayoutReadyListener", "Lkotlin/Function0;", "", "init", "calculateTabWidth", "initPage", NotesConstants.DialogTag.ON_SAVE_INSTANCE_STATE, "outState", "Landroid/os/Bundle;", "value", "currentPage", "getCurrentPage", "()I", "setCurrentPage", "(I)V", "setAdapter", "pagerAdapter", "Landroidx/viewpager/widget/PagerAdapter;", "isEditMode", "setEditMode", "releaseEditMode", "onAllItemClicked", "itemCount", "onItemClicked", "updateSelectAllStates", "updateSelectedInfo", "invalidateEditTab", "updateButton", MarketingConstants.BUTTON, "isEnabled", "updatePagerHeight", "setContract", "contract", "setCallback", Profile.PhoneNumberData.TYPE_CALLBACK, "getPagerHeight", "pageIndex", "requestShowDeleteDialog", "getDeleteDialogText", "", "requestShowRenameDialog", "requestDeleteSelectedTemplate", "getDefaultCurrentPage", "onPageChanged", "position", "logRenameSA", "logDeleteSA", "logDoneSA", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "Contract", "Callback", "Companion", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
@SuppressLint({"ViewConstructor"})
public final class CommonTemplateStyleLayout extends FrameLayout {

    @NotNull
    public static final String TAG = "TemplateStyleLayout";
    private boolean isSettings;

    @Nullable
    private Callback mCallback;

    @Nullable
    private TabLayout mCategoryTab;

    @Nullable
    private Contract mContract;

    @Nullable
    private Integer mCurrentPage;

    @Nullable
    private ImageButton mDeleteBtn;

    @Nullable
    private TextView mDoneBtn;

    @Nullable
    private View mEditTab;

    @Nullable
    private Function0<Unit> mLayoutReadyListener;

    @Nullable
    private ImageButton mRenameBtn;

    @Nullable
    private View mScrollView;

    @Nullable
    private CheckBox mSelectedAllBtn;

    @Nullable
    private TextView mSelectedInfo;

    @Nullable
    private AbsViewPager mViewPager;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\bæ\u0080\u0001\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/base/view/menu/template/view/common/CommonTemplateStyleLayout$Callback;", "", "onPageChanged", "", "position", "", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public interface Callback {
        void onPageChanged(int position);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H&J\b\u0010\u0005\u001a\u00020\u0003H&J\b\u0010\u0006\u001a\u00020\u0003H&J\b\u0010\u0007\u001a\u00020\u0003H&J\b\u0010\b\u001a\u00020\tH&J\b\u0010\n\u001a\u00020\tH&J\u0010\u0010\u000b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\rH&J\b\u0010\u000e\u001a\u00020\tH&J\u0010\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\rH&J\u0010\u0010\u0011\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\rH&J\b\u0010\u0012\u001a\u00020\u0013H&¨\u0006\u0014"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/base/view/menu/template/view/common/CommonTemplateStyleLayout$Contract;", "", "getPagerHeight", "", "pageIndex", "getDefaultCurrentPage", "getSelectedItemCount", "getItemCount", "requestShowRenameDialog", "", "requestDeleteSelectedTemplate", "requestSetEnableCallBack", "isEnabled", "", "onChangeMode", "requestSelectAllItems", "isSelected", "enableConfirmBtn", "getCaller", "Lcom/samsung/android/support/senl/nt/composer/main/base/view/menu/notestyle/common/Constant$Type;", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public interface Contract {
        void enableConfirmBtn(boolean isEnabled);

        @NotNull
        Constant.Type getCaller();

        int getDefaultCurrentPage();

        int getItemCount();

        int getPagerHeight(int pageIndex);

        int getSelectedItemCount();

        void onChangeMode();

        void requestDeleteSelectedTemplate();

        int requestSelectAllItems(boolean isSelected);

        void requestSetEnableCallBack(boolean isEnabled);

        void requestShowRenameDialog();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CommonTemplateStyleLayout(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        init(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void calculateTabWidth$lambda$6(CommonTemplateStyleLayout commonTemplateStyleLayout) {
        View view;
        TabLayout tabLayout = commonTemplateStyleLayout.mCategoryTab;
        if (tabLayout == null || (view = commonTemplateStyleLayout.mScrollView) == null) {
            return;
        }
        int measuredWidth = view.getMeasuredWidth();
        int tabCount = tabLayout.getTabCount();
        if (tabCount == 0 || measuredWidth == 0) {
            return;
        }
        View childAt = tabLayout.getChildAt(0);
        ViewGroup viewGroup = childAt instanceof ViewGroup ? (ViewGroup) childAt : null;
        if (viewGroup == null) {
            return;
        }
        int dimensionPixelSize = commonTemplateStyleLayout.getContext().getResources().getDimensionPixelSize(C9086R.dimen.change_template_tab_margin_start_end);
        int dimensionPixelSize2 = commonTemplateStyleLayout.getContext().getResources().getDimensionPixelSize(C9086R.dimen.change_template_category_tab_margin_start_end);
        int[] iArr = new int[tabCount];
        int i = 0;
        for (int i2 = 0; i2 < tabCount; i2++) {
            View childAt2 = viewGroup.getChildAt(i2);
            childAt2.measure(0, 0);
            TextView textView = (TextView) childAt2.findViewById(C9086R.id.title);
            if (textView == null) {
                return;
            }
            int iCoerceAtLeast = RangesKt.coerceAtLeast(childAt2.getMeasuredWidth(), (dimensionPixelSize * 2) + textView.getMeasuredWidth());
            iArr[i2] = iCoerceAtLeast;
            i += iCoerceAtLeast;
        }
        if ((dimensionPixelSize2 * 2) + i < measuredWidth) {
            tabLayout.setTabMode(1);
            for (int i4 = 0; i4 < tabCount; i4++) {
                ViewGroup.LayoutParams layoutParams = viewGroup.getChildAt(i4).getLayoutParams();
                LinearLayout.LayoutParams layoutParams2 = layoutParams instanceof LinearLayout.LayoutParams ? (LinearLayout.LayoutParams) layoutParams : null;
                if (layoutParams2 != null) {
                    layoutParams2.width = iArr[i4];
                    if (i4 == 0) {
                        layoutParams2.setMarginStart(dimensionPixelSize2);
                    } else if (i4 == tabCount - 1) {
                        layoutParams2.setMarginEnd(dimensionPixelSize2);
                    }
                }
            }
        } else {
            tabLayout.setTabMode(0);
            for (int i5 = 0; i5 < tabCount; i5++) {
                View childAt3 = viewGroup.getChildAt(i5);
                ViewGroup.LayoutParams layoutParams3 = childAt3.getLayoutParams();
                LinearLayout.LayoutParams layoutParams4 = layoutParams3 instanceof LinearLayout.LayoutParams ? (LinearLayout.LayoutParams) layoutParams3 : null;
                if (layoutParams4 != null) {
                    TextView textView2 = (TextView) childAt3.findViewById(C9086R.id.title);
                    layoutParams4.width = (dimensionPixelSize * 2) + (textView2 != null ? textView2.getMeasuredWidth() : 0);
                    childAt3.setLayoutParams(layoutParams4);
                }
            }
            int i6 = tabCount - 1;
            if (tabLayout.getSelectedTabPosition() == i6) {
                tabLayout.post(new RunnableC9844c(tabLayout, viewGroup.getChildAt(i6), 22));
            }
        }
        tabLayout.requestLayout();
        Function0<Unit> function0 = commonTemplateStyleLayout.mLayoutReadyListener;
        if (function0 != null) {
            function0.invoke();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void calculateTabWidth$lambda$6$lambda$5(TabLayout tabLayout, View view) {
        tabLayout.smoothScrollTo(view.getRight(), 0);
    }

    private final int getDefaultCurrentPage() {
        Contract contract = this.mContract;
        if (contract != null) {
            return contract.getDefaultCurrentPage();
        }
        return 0;
    }

    private final String getDeleteDialogText() {
        Contract contract = this.mContract;
        int selectedItemCount = contract != null ? contract.getSelectedItemCount() : 0;
        String quantityString = getContext().getResources().getQuantityString(C9086R.plurals.change_template_delete_dialog_body_text, selectedItemCount, Integer.valueOf(selectedItemCount));
        Intrinsics.checkNotNullExpressionValue(quantityString, "getQuantityString(...)");
        return quantityString;
    }

    private final void init(Context context) {
        LayoutInflater.from(context).inflate(C9086R.layout.change_template_style_layout, (ViewGroup) this, true);
        AbsViewPager absViewPager = (AbsViewPager) findViewById(C9086R.id.comp_template_view_pager);
        if (absViewPager == null) {
            return;
        }
        this.mViewPager = absViewPager;
        absViewPager.setPagingEnabled(false);
        AbsViewPager absViewPager2 = this.mViewPager;
        if (absViewPager2 != null) {
            absViewPager2.addOnPageChangeListener(new ViewPager.OnPageChangeListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.template.view.common.CommonTemplateStyleLayout.init.1
                @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
                public void onPageScrollStateChanged(int i) {
                }

                @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
                public void onPageScrolled(int i, float v, int i12) {
                }

                @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
                public void onPageSelected(int position) {
                    if (CommonTemplateStyleLayout.this.getCurrentPage() == position) {
                        return;
                    }
                    CommonTemplateStyleLayout.this.setCurrentPage(position);
                    CommonTemplateStyleLayout.this.onPageChanged(position);
                }
            });
        }
        TabLayout tabLayout = (TabLayout) findViewById(C9086R.id.comp_template_tab_layout);
        this.mCategoryTab = tabLayout;
        if (tabLayout != null) {
            tabLayout.setupWithViewPager(this.mViewPager);
        }
        TabLayout tabLayout2 = this.mCategoryTab;
        if (tabLayout2 != null) {
            tabLayout2.seslSetSubTabStyle();
        }
        this.mScrollView = findViewById(C9086R.id.comp_template_view_pager_container_scroll_view);
        LinearLayout linearLayout = (LinearLayout) findViewById(C9086R.id.view_pager_container);
        if (this.isSettings && linearLayout != null) {
            linearLayout.setBackgroundResource(C9086R.drawable.page_template_layout_bg);
        }
        View viewFindViewById = findViewById(C9086R.id.comp_template_edit_tab_layout);
        this.mEditTab = viewFindViewById;
        if (viewFindViewById != null) {
            viewFindViewById.setVisibility(8);
        }
        CheckBox checkBox = (CheckBox) findViewById(C9086R.id.select_all_checkbox);
        this.mSelectedAllBtn = checkBox;
        if (checkBox != null) {
            final int i = 0;
            checkBox.setOnClickListener(new View.OnClickListener(this) { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.template.view.common.a

                /* JADX INFO: renamed from: b */
                public final /* synthetic */ CommonTemplateStyleLayout f7186b;

                {
                    this.f7186b = this;
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    switch (i) {
                        case 0:
                            CommonTemplateStyleLayout.init$lambda$0(this.f7186b, view);
                            break;
                        case 1:
                            CommonTemplateStyleLayout.init$lambda$1(this.f7186b, view);
                            break;
                        case 2:
                            CommonTemplateStyleLayout.init$lambda$2(this.f7186b, view);
                            break;
                        default:
                            CommonTemplateStyleLayout.init$lambda$4$lambda$3(this.f7186b, view);
                            break;
                    }
                }
            });
        }
        this.mSelectedInfo = (TextView) findViewById(C9086R.id.selected_template_info);
        ImageButton imageButton = (ImageButton) findViewById(C9086R.id.rename);
        this.mRenameBtn = imageButton;
        if (imageButton != null) {
            final int i2 = 1;
            imageButton.setOnClickListener(new View.OnClickListener(this) { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.template.view.common.a

                /* JADX INFO: renamed from: b */
                public final /* synthetic */ CommonTemplateStyleLayout f7186b;

                {
                    this.f7186b = this;
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    switch (i2) {
                        case 0:
                            CommonTemplateStyleLayout.init$lambda$0(this.f7186b, view);
                            break;
                        case 1:
                            CommonTemplateStyleLayout.init$lambda$1(this.f7186b, view);
                            break;
                        case 2:
                            CommonTemplateStyleLayout.init$lambda$2(this.f7186b, view);
                            break;
                        default:
                            CommonTemplateStyleLayout.init$lambda$4$lambda$3(this.f7186b, view);
                            break;
                    }
                }
            });
        }
        ImageButton imageButton2 = (ImageButton) findViewById(C9086R.id.delete);
        this.mDeleteBtn = imageButton2;
        if (imageButton2 != null) {
            final int i4 = 2;
            imageButton2.setOnClickListener(new View.OnClickListener(this) { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.template.view.common.a

                /* JADX INFO: renamed from: b */
                public final /* synthetic */ CommonTemplateStyleLayout f7186b;

                {
                    this.f7186b = this;
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    switch (i4) {
                        case 0:
                            CommonTemplateStyleLayout.init$lambda$0(this.f7186b, view);
                            break;
                        case 1:
                            CommonTemplateStyleLayout.init$lambda$1(this.f7186b, view);
                            break;
                        case 2:
                            CommonTemplateStyleLayout.init$lambda$2(this.f7186b, view);
                            break;
                        default:
                            CommonTemplateStyleLayout.init$lambda$4$lambda$3(this.f7186b, view);
                            break;
                    }
                }
            });
        }
        TextView textView = (TextView) findViewById(C9086R.id.done);
        this.mDoneBtn = textView;
        if (textView != null) {
            final int i5 = 3;
            textView.setOnClickListener(new View.OnClickListener(this) { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.template.view.common.a

                /* JADX INFO: renamed from: b */
                public final /* synthetic */ CommonTemplateStyleLayout f7186b;

                {
                    this.f7186b = this;
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    switch (i5) {
                        case 0:
                            CommonTemplateStyleLayout.init$lambda$0(this.f7186b, view);
                            break;
                        case 1:
                            CommonTemplateStyleLayout.init$lambda$1(this.f7186b, view);
                            break;
                        case 2:
                            CommonTemplateStyleLayout.init$lambda$2(this.f7186b, view);
                            break;
                        default:
                            CommonTemplateStyleLayout.init$lambda$4$lambda$3(this.f7186b, view);
                            break;
                    }
                }
            });
            if (ButtonBackgroundUtils.isShowButtonShapeEnabled(context)) {
                textView.setBackground(context.getResources().getDrawable(C9086R.drawable.note_style_edit_done_btn_highlight_bg));
                textView.setTextColor(ContextCompat.getColor(context, C9086R.color.note_style_layout_bg));
            } else {
                textView.setBackground(context.getResources().getDrawable(C9086R.drawable.note_style_edit_done_btn_default_bg));
                textView.setTextColor(ContextCompat.getColor(context, C9086R.color.notes_title_color));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void init$lambda$0(CommonTemplateStyleLayout commonTemplateStyleLayout, View view) {
        Integer numValueOf;
        CheckBox checkBox = commonTemplateStyleLayout.mSelectedAllBtn;
        if (checkBox != null) {
            Intrinsics.checkNotNull(checkBox);
            checkBox.setSelected(!checkBox.isSelected());
        }
        Contract contract = commonTemplateStyleLayout.mContract;
        if (contract != null) {
            CheckBox checkBox2 = commonTemplateStyleLayout.mSelectedAllBtn;
            Intrinsics.checkNotNull(checkBox2);
            numValueOf = Integer.valueOf(contract.requestSelectAllItems(checkBox2.isSelected()));
        } else {
            numValueOf = null;
        }
        Intrinsics.checkNotNull(numValueOf);
        commonTemplateStyleLayout.onAllItemClicked(numValueOf.intValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void init$lambda$1(CommonTemplateStyleLayout commonTemplateStyleLayout, View view) {
        commonTemplateStyleLayout.requestShowRenameDialog();
        commonTemplateStyleLayout.logRenameSA();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void init$lambda$2(CommonTemplateStyleLayout commonTemplateStyleLayout, View view) {
        commonTemplateStyleLayout.requestShowDeleteDialog();
        commonTemplateStyleLayout.logDeleteSA();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void init$lambda$4$lambda$3(CommonTemplateStyleLayout commonTemplateStyleLayout, View view) {
        commonTemplateStyleLayout.releaseEditMode();
        commonTemplateStyleLayout.logDoneSA();
    }

    private final void invalidateEditTab(int itemCount) {
        if (itemCount == 0) {
            updateButton(this.mRenameBtn, false);
            updateButton(this.mDeleteBtn, false);
        } else if (itemCount != 1) {
            updateButton(this.mRenameBtn, false);
            updateButton(this.mDeleteBtn, true);
        } else {
            updateButton(this.mRenameBtn, true);
            updateButton(this.mDeleteBtn, true);
        }
    }

    private final void logDeleteSA() {
        Contract contract = this.mContract;
        Constant.Type caller = contract != null ? contract.getCaller() : null;
        Intrinsics.checkNotNull(caller);
        if (caller == Constant.Type.SETTINGS) {
            ComposerSA.insertLog("510", SAConstants.EVENT_DELETE_TEMPLATE);
            return;
        }
        if (caller == Constant.Type.CREATE_NOTE) {
            ComposerSA.insertLog("101", "NTST0013");
        } else if (caller == Constant.Type.STYLE_CHANGE) {
            ComposerSA.insertLog("411", SAConstants.EVENT_DELETE_TEMPLATE);
        } else if (caller == Constant.Type.TEMPLATE_PICKER) {
            ComposerSA.insertLog("504", SortPageSAConstants.SORTPAGE_EVENT_DELETE_TEMPLATE);
        }
    }

    private final void logDoneSA() {
        Contract contract = this.mContract;
        Constant.Type caller = contract != null ? contract.getCaller() : null;
        Intrinsics.checkNotNull(caller);
        if (caller == Constant.Type.SETTINGS) {
            ComposerSA.insertLog("510", SAConstants.EVENT_EDIT_DONE_TEMPLATE);
            return;
        }
        if (caller == Constant.Type.CREATE_NOTE) {
            ComposerSA.insertLog("101", AssistSAConstants.EVENT_FAB_DONE_TEMPLATE);
        } else if (caller == Constant.Type.STYLE_CHANGE) {
            ComposerSA.insertLog("411", SAConstants.EVENT_EDIT_DONE_TEMPLATE);
        } else if (caller == Constant.Type.TEMPLATE_PICKER) {
            ComposerSA.insertLog("504", SortPageSAConstants.SORTPATE_EVENT_DONE_TEMPLATE);
        }
    }

    private final void logRenameSA() {
        Contract contract = this.mContract;
        Constant.Type caller = contract != null ? contract.getCaller() : null;
        Intrinsics.checkNotNull(caller);
        if (caller == Constant.Type.SETTINGS) {
            ComposerSA.insertLog("510", "3560");
            return;
        }
        if (caller == Constant.Type.CREATE_NOTE) {
            ComposerSA.insertLog("101", "NTST0013");
        } else if (caller == Constant.Type.STYLE_CHANGE) {
            ComposerSA.insertLog("411", SAConstants.EVENT_PAGE_STYLE_RENAME_TEMPLATE);
        } else if (caller == Constant.Type.TEMPLATE_PICKER) {
            ComposerSA.insertLog("504", SortPageSAConstants.SORTPAGE_EVENT_RENAME_TEMPLATE);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onPageChanged(int position) {
        Callback callback = this.mCallback;
        if (callback != null) {
            callback.onPageChanged(position);
        }
    }

    private final void requestDeleteSelectedTemplate() {
        Contract contract = this.mContract;
        if (contract != null) {
            contract.requestDeleteSelectedTemplate();
        }
    }

    private final void requestShowDeleteDialog() {
        Contract contract = this.mContract;
        if ((contract != null ? Integer.valueOf(contract.getSelectedItemCount()) : null) != null) {
            Contract contract2 = this.mContract;
            if (contract2 == null || contract2.getSelectedItemCount() != 0) {
                AlertDialog alertDialogCreate = new AlertDialog.Builder(getContext()).setCancelable(false).setPositiveButton(getContext().getString(C9086R.string.dialog_delete), new DialogInterfaceOnClickListenerC0161a(this, 13)).setNegativeButton(getContext().getString(C9086R.string.dialog_cancel), new DialogInterfaceOnClickListenerC0140a(22)).setMessage(getDeleteDialogText()).create();
                Intrinsics.checkNotNullExpressionValue(alertDialogCreate, "create(...)");
                alertDialogCreate.setCanceledOnTouchOutside(false);
                alertDialogCreate.show();
                alertDialogCreate.getButton(-1).setTextColor(getContext().getColor(C9086R.color.change_template_delete_dialog_delete_text_color));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void requestShowDeleteDialog$lambda$8(CommonTemplateStyleLayout commonTemplateStyleLayout, DialogInterface dialogInterface, int i) {
        commonTemplateStyleLayout.releaseEditMode();
        commonTemplateStyleLayout.requestDeleteSelectedTemplate();
        commonTemplateStyleLayout.updatePagerHeight();
    }

    private final void requestShowRenameDialog() {
        Contract contract = this.mContract;
        if (contract != null) {
            contract.requestShowRenameDialog();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setCurrentPage(int i) {
        this.mCurrentPage = Integer.valueOf(i);
    }

    private final void updateButton(ImageButton button, boolean isEnabled) {
        if (button != null) {
            button.setEnabled(isEnabled);
        }
        if (button != null) {
            button.setAlpha(isEnabled ? 1.0f : 0.0f);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void updatePagerHeight$lambda$7(CommonTemplateStyleLayout commonTemplateStyleLayout) {
        AbsViewPager absViewPager;
        AbsViewPager absViewPager2 = commonTemplateStyleLayout.mViewPager;
        int pagerHeight = commonTemplateStyleLayout.getPagerHeight(absViewPager2 != null ? absViewPager2.getCurrentItem() : 0);
        if (pagerHeight > 0) {
            AbsViewPager absViewPager3 = commonTemplateStyleLayout.mViewPager;
            if ((absViewPager3 == null || absViewPager3.getMeasuredHeight() != pagerHeight) && (absViewPager = commonTemplateStyleLayout.mViewPager) != null) {
                Intrinsics.checkNotNull(absViewPager);
                ViewGroup.LayoutParams layoutParams = absViewPager.getLayoutParams();
                layoutParams.height = pagerHeight;
                AbsViewPager absViewPager4 = commonTemplateStyleLayout.mViewPager;
                Intrinsics.checkNotNull(absViewPager4);
                absViewPager4.setLayoutParams(layoutParams);
            }
        }
    }

    private final void updateSelectAllStates(int itemCount) {
        CheckBox checkBox = this.mSelectedAllBtn;
        if (checkBox != null) {
            Contract contract = this.mContract;
            Integer numValueOf = contract != null ? Integer.valueOf(contract.getItemCount()) : null;
            Intrinsics.checkNotNull(numValueOf);
            checkBox.setChecked(itemCount == numValueOf.intValue());
        }
        CheckBox checkBox2 = this.mSelectedAllBtn;
        if (checkBox2 != null) {
            Contract contract2 = this.mContract;
            Integer numValueOf2 = contract2 != null ? Integer.valueOf(contract2.getItemCount()) : null;
            Intrinsics.checkNotNull(numValueOf2);
            checkBox2.setSelected(itemCount == numValueOf2.intValue());
        }
    }

    private final void updateSelectedInfo(int itemCount) {
        String string = getContext().getResources().getString(C9086R.string.selected_check_info, Integer.valueOf(itemCount));
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        TextView textView = this.mSelectedInfo;
        if (textView != null) {
            textView.setText(string);
        }
    }

    public final void calculateTabWidth() {
        TabLayout tabLayout = this.mCategoryTab;
        if (tabLayout != null) {
            tabLayout.post(new RunnableC10452b(this, 0));
        }
    }

    public final int getCurrentPage() {
        if (this.mCurrentPage == null) {
            this.mCurrentPage = Integer.valueOf(getDefaultCurrentPage());
        }
        Integer num = this.mCurrentPage;
        Intrinsics.checkNotNull(num);
        return num.intValue();
    }

    public final int getPagerHeight(int pageIndex) {
        Contract contract = this.mContract;
        if (contract != null) {
            return contract.getPagerHeight(pageIndex);
        }
        return 0;
    }

    public final void initPage() {
        AbsViewPager absViewPager = this.mViewPager;
        if (absViewPager != null) {
            absViewPager.setCurrentItem(getCurrentPage());
        }
    }

    public final boolean isEditMode() {
        View view = this.mEditTab;
        return view != null && view.getVisibility() == 0;
    }

    public final void onAllItemClicked(int itemCount) {
        invalidateEditTab(itemCount);
        updateSelectedInfo(itemCount);
    }

    @Override // android.view.View
    public void onConfigurationChanged(@Nullable Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        calculateTabWidth();
        updatePagerHeight();
    }

    public final void onItemClicked(int itemCount) {
        invalidateEditTab(itemCount);
        updateSelectedInfo(itemCount);
        updateSelectAllStates(itemCount);
    }

    public final void onSaveInstanceState(@NotNull Bundle outState) {
        Intrinsics.checkNotNullParameter(outState, "outState");
        outState.putInt(TemplateConstants.KEY_CURRENT_PAGE, getCurrentPage());
    }

    public final void releaseEditMode() {
        View view = this.mEditTab;
        if (view != null) {
            view.setVisibility(8);
        }
        TabLayout tabLayout = this.mCategoryTab;
        if (tabLayout != null) {
            tabLayout.setVisibility(0);
        }
        Contract contract = this.mContract;
        if (contract != null) {
            contract.onChangeMode();
        }
        Contract contract2 = this.mContract;
        if (contract2 != null) {
            contract2.requestSetEnableCallBack(false);
        }
        Contract contract3 = this.mContract;
        if (contract3 != null) {
            contract3.enableConfirmBtn(true);
        }
    }

    public final void setAdapter(@NotNull PagerAdapter pagerAdapter) {
        Intrinsics.checkNotNullParameter(pagerAdapter, "pagerAdapter");
        AbsViewPager absViewPager = this.mViewPager;
        if (absViewPager != null) {
            absViewPager.setAdapter(pagerAdapter);
        }
    }

    public final void setCallback(@NotNull Callback callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.mCallback = callback;
    }

    public final void setContract(@NotNull Contract contract) {
        Intrinsics.checkNotNullParameter(contract, "contract");
        this.mContract = contract;
    }

    public final boolean setEditMode() {
        View view = this.mEditTab;
        if (view != null) {
            view.setVisibility(0);
        }
        TabLayout tabLayout = this.mCategoryTab;
        if (tabLayout != null) {
            tabLayout.setVisibility(8);
        }
        CheckBox checkBox = this.mSelectedAllBtn;
        if (checkBox != null) {
            checkBox.setSelected(false);
        }
        onItemClicked(0);
        Contract contract = this.mContract;
        if (contract != null) {
            contract.requestSetEnableCallBack(true);
        }
        Contract contract2 = this.mContract;
        if (contract2 != null) {
            contract2.enableConfirmBtn(false);
        }
        return true;
    }

    public final void updatePagerHeight() {
        AbsViewPager absViewPager = this.mViewPager;
        if (absViewPager != null) {
            absViewPager.post(new RunnableC10452b(this, 1));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CommonTemplateStyleLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        init(context);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CommonTemplateStyleLayout(@NotNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        init(context);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CommonTemplateStyleLayout(@NotNull Context context, boolean z) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.isSettings = z;
        init(context);
    }
}
