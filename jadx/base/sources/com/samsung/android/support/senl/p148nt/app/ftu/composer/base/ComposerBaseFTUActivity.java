package com.samsung.android.support.senl.p148nt.app.ftu.composer.base;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.animation.PathInterpolatorCompat;
import androidx.viewpager.widget.ViewPager;
import com.samsung.android.app.notes.sync.coedit.sharecore.strategy.AbstractC6670b;
import com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.vector.shape.pathdata.VPathDataCmd;
import com.samsung.android.support.senl.p145cm.base.framework.view.WindowManagerCompat;
import com.samsung.android.support.senl.p148nt.app.C8003R;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.app.common.NotesConstants;
import com.samsung.android.support.senl.p148nt.app.common.log.MainLogger;
import com.samsung.android.support.senl.p148nt.app.common.widget.PagerBottomLayout;
import com.samsung.android.support.senl.p148nt.app.ftu.composer.base.adapter.ComposerFTUPagerAdapter;
import com.samsung.android.support.senl.p148nt.app.ftu.composer.common.CustomScroller;
import com.samsung.android.support.senl.p148nt.base.common.util.ContextUtils;
import com.samsung.android.support.senl.p148nt.base.common.util.SystemUi;
import com.samsung.android.support.senl.p148nt.base.winset.view.AbsViewPager;
import com.samsung.android.support.senl.p148nt.base.winset.view.lottie.LottieWithMessageLayout;
import java.lang.reflect.Field;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\b&\u0018\u0000 52\u00020\u00012\u00020\u0002:\u00015B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0014J\b\u0010\u0018\u001a\u00020\u0015H$J\b\u0010\u0019\u001a\u00020\u0015H\u0016J\b\u0010\u001a\u001a\u00020\u0015H\u0016J\u0010\u0010\u001b\u001a\u00020\u00152\b\u0010\u001c\u001a\u0004\u0018\u00010\bJ\b\u0010!\u001a\u00020\u0015H\u0002J\b\u0010\"\u001a\u00020\u0015H\u0004J\u0010\u0010#\u001a\u00020\u00152\u0006\u0010$\u001a\u00020%H\u0016J\b\u0010&\u001a\u00020\u0015H\u0014J\u0010\u0010'\u001a\u00020\u00152\u0006\u0010(\u001a\u00020\u0017H\u0014J\u0010\u0010)\u001a\u00020\u00152\u0006\u0010*\u001a\u00020+H\u0016J\b\u0010,\u001a\u00020\u0015H\u0016J\b\u0010-\u001a\u00020\u0015H\u0002J\u000e\u00100\u001a\u00020\u00152\u0006\u0010\u0012\u001a\u00020\u0011J\b\u00101\u001a\u00020\u0015H\u0002R\u0014\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0004@\u0004X\u0085\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0004@\u0004X\u0085\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\u0004\u0018\u00010\n8\u0004@\u0004X\u0085\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u000b\u001a\u00020\f8\u0004@\u0004X\u0085\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u0011@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0014\u0010\u001d\u001a\u0004\u0018\u00010\u001eX¤\u0004¢\u0006\u0006\u001a\u0004\b\u001f\u0010 R\u0014\u0010.\u001a\u00020\u00118BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b.\u0010\u0013R\u0014\u0010/\u001a\u00020\u00118BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b/\u0010\u0013R\u0014\u00102\u001a\u0004\u0018\u00010\u000fX¤\u0004¢\u0006\u0006\u001a\u0004\b3\u00104¨\u00066"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/app/ftu/composer/base/ComposerBaseFTUActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "Landroid/view/View$OnClickListener;", "<init>", "()V", "mPager", "Lcom/samsung/android/support/senl/nt/base/winset/view/AbsViewPager;", "mPagerAdapter", "Lcom/samsung/android/support/senl/nt/app/ftu/composer/base/adapter/ComposerFTUPagerAdapter;", "mPagerBottomLayout", "Lcom/samsung/android/support/senl/nt/app/common/widget/PagerBottomLayout;", "mCurPosition", "", "mToolType", "mFolderUuid", "", "value", "", "isLayoutLoaded", "()Z", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "setContentView", "initLayout", "initPager", "setPagerAdapter", "pagerAdapter", "pageContract", "Lcom/samsung/android/support/senl/nt/base/winset/view/lottie/LottieWithMessageLayout$Contract;", "getPageContract", "()Lcom/samsung/android/support/senl/nt/base/winset/view/lottie/LottieWithMessageLayout$Contract;", "initSystemUi", "updateBottomLayout", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "onResume", NotesConstants.DialogTag.ON_SAVE_INSTANCE_STATE, "outState", "onClick", VPathDataCmd.RCurveTo, "Landroid/view/View;", "onBackPressed", "onPressNextButton", "isFirstPage", "isLastPage", "onLayoutLoaded", "finishActivity", "tag", "getTag", "()Ljava/lang/String;", "Companion", "ntApp_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nComposerBaseFTUActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ComposerBaseFTUActivity.kt\ncom/samsung/android/support/senl/nt/app/ftu/composer/base/ComposerBaseFTUActivity\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,213:1\n1#2:214\n*E\n"})
public abstract class ComposerBaseFTUActivity extends AppCompatActivity implements View.OnClickListener {

    @NotNull
    private static final String KEY_IS_LAYOUT_LOADED = "key_is_layout_loaded";

    @NotNull
    private static final String KEY_POSITION = "key_position";
    private boolean isLayoutLoaded;

    @JvmField
    protected int mCurPosition;

    @Nullable
    private String mFolderUuid;

    @JvmField
    @Nullable
    protected AbsViewPager mPager;

    @JvmField
    @Nullable
    protected ComposerFTUPagerAdapter mPagerAdapter;

    @JvmField
    @Nullable
    protected PagerBottomLayout mPagerBottomLayout;
    private int mToolType;

    private final synchronized void finishActivity() {
        Intent intent = new Intent();
        intent.putExtra("tool_type", this.mToolType);
        intent.putExtra("category_id", this.mFolderUuid);
        setResult(-1, intent);
        finish();
    }

    private final void initSystemUi() {
        int color = getColor(C8003R.color.ftu_background_color);
        Window window = getWindow();
        Intrinsics.checkNotNullExpressionValue(window, "getWindow(...)");
        SystemUi.setWindowBackgroundColor(window, color);
        SystemUi.setStatusBarColor(this, 0);
        SystemUi.setNavigationBarTheme(this, color, !ContextUtils.isNightMode(this));
    }

    private final boolean isFirstPage() {
        AbsViewPager absViewPager = this.mPager;
        if (absViewPager == null) {
            return false;
        }
        Intrinsics.checkNotNull(absViewPager);
        return absViewPager.getCurrentItem() <= 0;
    }

    private final boolean isLastPage() {
        ComposerFTUPagerAdapter composerFTUPagerAdapter = this.mPagerAdapter;
        if (composerFTUPagerAdapter == null || this.mPager == null) {
            return false;
        }
        Intrinsics.checkNotNull(composerFTUPagerAdapter);
        int count = composerFTUPagerAdapter.getCount() - 1;
        AbsViewPager absViewPager = this.mPager;
        Intrinsics.checkNotNull(absViewPager);
        return count <= absViewPager.getCurrentItem();
    }

    private final void onPressNextButton() {
        AbstractC6670b.m4739D("onPressNextButton# isLastPage: ", getTag(), isLastPage());
        if (isLastPage()) {
            finishActivity();
            return;
        }
        AbsViewPager absViewPager = this.mPager;
        if (absViewPager != null) {
            absViewPager.setCurrentItem(absViewPager.getCurrentItem() + 1, true);
        }
    }

    @Nullable
    public abstract LottieWithMessageLayout.Contract getPageContract();

    @Nullable
    public abstract String getTag();

    public void initLayout() {
        initPager();
        initSystemUi();
    }

    public void initPager() {
        this.mPager = (AbsViewPager) findViewById(C8003R.id.ftu_viewpager);
        this.mPagerBottomLayout = (PagerBottomLayout) findViewById(C8003R.id.ftu_bottom_layout);
        AbsViewPager absViewPager = this.mPager;
        if (absViewPager != null) {
            absViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() { // from class: com.samsung.android.support.senl.nt.app.ftu.composer.base.ComposerBaseFTUActivity.initPager.1
                private float pageOffset;

                public final float getPageOffset() {
                    return this.pageOffset;
                }

                @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
                public void onPageScrollStateChanged(int state) {
                }

                @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
                public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                    PagerBottomLayout pagerBottomLayout;
                    float f = this.pageOffset;
                    if (((f < 0.5f && 0.5f < positionOffset) || (positionOffset < 0.5f && 0.5f < f)) && (pagerBottomLayout = ComposerBaseFTUActivity.this.mPagerBottomLayout) != null) {
                        pagerBottomLayout.invalidateIndicator();
                    }
                    this.pageOffset = positionOffset;
                }

                @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
                public void onPageSelected(int position) {
                    ComposerBaseFTUActivity composerBaseFTUActivity = ComposerBaseFTUActivity.this;
                    int i = composerBaseFTUActivity.mCurPosition;
                    composerBaseFTUActivity.mCurPosition = position;
                    AbstractC8014b.m7200b(i, ComposerBaseFTUActivity.this.mCurPosition, "onPageSelected# prevPosition: ", " -> ", composerBaseFTUActivity.getTag());
                    ComposerFTUPagerAdapter composerFTUPagerAdapter = ComposerBaseFTUActivity.this.mPagerAdapter;
                    if (composerFTUPagerAdapter != null) {
                        composerFTUPagerAdapter.onPageSelected(position);
                    }
                    ComposerBaseFTUActivity.this.updateBottomLayout();
                }

                public final void setPageOffset(float f) {
                    this.pageOffset = f;
                }
            });
        }
        PagerBottomLayout pagerBottomLayout = this.mPagerBottomLayout;
        if (pagerBottomLayout != null) {
            pagerBottomLayout.setupWithViewPager(this.mPager, true);
        }
        PagerBottomLayout pagerBottomLayout2 = this.mPagerBottomLayout;
        if (pagerBottomLayout2 != null) {
            pagerBottomLayout2.setOnClickListener(this);
        }
        try {
            Field declaredField = ViewPager.class.getDeclaredField("mScroller");
            declaredField.setAccessible(true);
            declaredField.set(this.mPager, new CustomScroller(this, PathInterpolatorCompat.create(0.22f, 0.25f, 0.0f, 1.0f)));
        } catch (IllegalAccessException e) {
            MainLogger.m7255e(getTag(), "initLayout# : " + e);
        } catch (NoSuchFieldException e2) {
            MainLogger.m7255e(getTag(), "initLayout# : " + e2);
        }
    }

    /* JADX INFO: renamed from: isLayoutLoaded, reason: from getter */
    public final boolean getIsLayoutLoaded() {
        return this.isLayoutLoaded;
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        AbstractC6670b.m4739D("onBackPressed# isFirstPage: ", getTag(), isFirstPage());
        if (isFirstPage()) {
            setResult(0);
            super.onBackPressed();
        } else {
            AbsViewPager absViewPager = this.mPager;
            if (absViewPager != null) {
                absViewPager.setCurrentItem(absViewPager.getCurrentItem() - 1, true);
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(@NotNull View v) {
        Intrinsics.checkNotNullParameter(v, "v");
        int id = v.getId();
        if (id == C8003R.id.pager_next_button) {
            onPressNextButton();
        } else if (id == C8003R.id.pager_back_button) {
            onBackPressed();
        } else {
            AbstractC8014b.m7201c(id, "unexpected viewId: ", getTag());
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.activity.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(@NotNull Configuration newConfig) {
        Intrinsics.checkNotNullParameter(newConfig, "newConfig");
        MainLogger.m7258i(getTag(), "onConfigurationChanged()");
        super.onConfigurationChanged(newConfig);
        WindowManagerCompat.controllIndicatorBar$default(WindowManagerCompat.INSTANCE.getInstance(), this, getResources().getConfiguration().orientation, false, 4, null);
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle savedInstanceState) {
        MainLogger.m7258i(getTag(), "onCreate()");
        super.onCreate(savedInstanceState);
        if (savedInstanceState != null) {
            this.mCurPosition = savedInstanceState.getInt(KEY_POSITION, 0);
            this.mToolType = savedInstanceState.getInt("tool_type", 1);
            this.mFolderUuid = savedInstanceState.getString("category_id");
            this.isLayoutLoaded = savedInstanceState.getBoolean(KEY_IS_LAYOUT_LOADED, false);
        } else {
            this.mToolType = getIntent().getIntExtra("tool_type", 1);
            this.mFolderUuid = getIntent().getStringExtra("category_id");
        }
        setContentView();
        initLayout();
        updateBottomLayout();
        WindowManagerCompat.controllIndicatorBar$default(WindowManagerCompat.INSTANCE.getInstance(), this, getResources().getConfiguration().orientation, false, 4, null);
    }

    public final void onLayoutLoaded(boolean isLayoutLoaded) {
        this.isLayoutLoaded = isLayoutLoaded;
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        MainLogger.m7258i(getTag(), "onResume()");
        super.onResume();
        ComposerFTUPagerAdapter composerFTUPagerAdapter = this.mPagerAdapter;
        if (composerFTUPagerAdapter != null) {
            composerFTUPagerAdapter.onPageSelected(this.mCurPosition);
        }
        AbsViewPager absViewPager = this.mPager;
        if (absViewPager != null) {
            absViewPager.setCurrentItem(this.mCurPosition);
        }
        PagerBottomLayout pagerBottomLayout = this.mPagerBottomLayout;
        if (pagerBottomLayout != null) {
            pagerBottomLayout.invalidate();
        }
    }

    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onSaveInstanceState(@NotNull Bundle outState) {
        Intrinsics.checkNotNullParameter(outState, "outState");
        super.onSaveInstanceState(outState);
        outState.putInt(KEY_POSITION, this.mCurPosition);
        outState.putInt("tool_type", this.mToolType);
        outState.putString("category_id", this.mFolderUuid);
        outState.putBoolean(KEY_IS_LAYOUT_LOADED, this.isLayoutLoaded);
    }

    public abstract void setContentView();

    public final void setPagerAdapter(@Nullable ComposerFTUPagerAdapter pagerAdapter) {
        this.mPagerAdapter = pagerAdapter;
        if (pagerAdapter == null || this.mPager == null) {
            return;
        }
        if (pagerAdapter != null) {
            pagerAdapter.setContract(new ComposerFTUPagerAdapter.Contract() { // from class: com.samsung.android.support.senl.nt.app.ftu.composer.base.ComposerBaseFTUActivity.setPagerAdapter.1
                @Override // com.samsung.android.support.senl.nt.app.ftu.composer.base.adapter.ComposerFTUPagerAdapter.Contract
                public boolean isLayoutLoaded() {
                    return ComposerBaseFTUActivity.this.getIsLayoutLoaded();
                }
            }, getPageContract());
        }
        AbsViewPager absViewPager = this.mPager;
        Intrinsics.checkNotNull(absViewPager);
        absViewPager.setAdapter(this.mPagerAdapter);
    }

    public final void updateBottomLayout() {
        PagerBottomLayout pagerBottomLayout = this.mPagerBottomLayout;
        if (pagerBottomLayout != null) {
            pagerBottomLayout.updateLayout(isFirstPage(), isLastPage());
        }
    }
}
