package com.samsung.android.support.senl.p148nt.composer.main.base.widget.view;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import androidx.core.util.SeslFadingEdgeHelper;
import androidx.core.util.SeslFadingEdgeHelperImpl;
import com.samsung.android.sdk.composer.SpenComposer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m13885d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\u0018\u00002\u00020\u0001:\u0002!\"B\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\u0004\u0010\bB\u001b\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\u0004\u0010\u000bB#\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n\u0012\u0006\u0010\f\u001a\u00020\u0007¢\u0006\u0004\b\u0004\u0010\rJ\u0010\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0014J\u0010\u0010\u0018\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0014J\u000e\u0010\u0019\u001a\u00020\u00152\u0006\u0010\u001a\u001a\u00020\u001bJ\u0006\u0010\u001c\u001a\u00020\u0015J\u0010\u0010\u001d\u001a\u00020\u00152\b\u0010\u001e\u001a\u0004\u0018\u00010\u0013J\u000e\u0010\u001f\u001a\u00020\u00152\u0006\u0010 \u001a\u00020\u0007R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\b\u0018\u00010\u0011R\u00020\u0000X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006#"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/base/widget/view/SpenComposerWrapper;", "Lcom/samsung/android/sdk/composer/SpenComposer;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "createType", "", "(Landroid/content/Context;I)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "mFadingEdgeHelper", "Landroidx/core/util/SeslFadingEdgeHelper;", "mScrollInfoProvider", "Lcom/samsung/android/support/senl/nt/composer/main/base/widget/view/SpenComposerWrapper$ScrollInfoProvider;", "mFadingEdgeScrollInfoProvider", "Lcom/samsung/android/support/senl/nt/composer/main/base/widget/view/SpenComposerWrapper$IFadingEdgeScrollInfoProvider;", "onDraw", "", "canvas", "Landroid/graphics/Canvas;", "dispatchDraw", "setFadingEdgeEnabled", "enable", "", "initFadingEdgeHelper", "setFadingEdgeScrollInfoProvider", "fadingEdgeScrollInfoProvider", "setFadingEdgeColor", "color", "ScrollInfoProvider", "IFadingEdgeScrollInfoProvider", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class SpenComposerWrapper extends SpenComposer {

    @Nullable
    private SeslFadingEdgeHelper mFadingEdgeHelper;

    @Nullable
    private IFadingEdgeScrollInfoProvider mFadingEdgeScrollInfoProvider;

    @Nullable
    private ScrollInfoProvider mScrollInfoProvider;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&¨\u0006\u0005"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/base/widget/view/SpenComposerWrapper$IFadingEdgeScrollInfoProvider;", "", "computeVerticalScrollOffset", "", "computeVerticalScrollRange", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public interface IFadingEdgeScrollInfoProvider {
        int computeVerticalScrollOffset();

        int computeVerticalScrollRange();
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0005H\u0016J\b\u0010\u0007\u001a\u00020\u0005H\u0016J\b\u0010\b\u001a\u00020\tH\u0016J\b\u0010\n\u001a\u00020\u0005H\u0016¨\u0006\u000b"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/base/widget/view/SpenComposerWrapper$ScrollInfoProvider;", "Landroidx/core/util/SeslFadingEdgeHelper$ScrollInfoProvider;", "<init>", "(Lcom/samsung/android/support/senl/nt/composer/main/base/widget/view/SpenComposerWrapper;)V", "computeVerticalScrollOffset", "", "computeVerticalScrollRange", "computeVerticalScrollExtent", "shouldNormalizeFadingEdge", "", "getLastItemHeightIfVisible", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    @SourceDebugExtension({"SMAP\nSpenComposerWrapper.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SpenComposerWrapper.kt\ncom/samsung/android/support/senl/nt/composer/main/base/widget/view/SpenComposerWrapper$ScrollInfoProvider\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,91:1\n1#2:92\n*E\n"})
    public final class ScrollInfoProvider implements SeslFadingEdgeHelper.ScrollInfoProvider {
        public ScrollInfoProvider() {
        }

        @Override // androidx.core.util.SeslFadingEdgeHelper.ScrollInfoProvider
        public int computeVerticalScrollExtent() {
            return 0;
        }

        @Override // androidx.core.util.SeslFadingEdgeHelper.ScrollInfoProvider
        public int computeVerticalScrollOffset() {
            IFadingEdgeScrollInfoProvider iFadingEdgeScrollInfoProvider = SpenComposerWrapper.this.mFadingEdgeScrollInfoProvider;
            if (iFadingEdgeScrollInfoProvider != null) {
                return iFadingEdgeScrollInfoProvider.computeVerticalScrollOffset();
            }
            return 100;
        }

        @Override // androidx.core.util.SeslFadingEdgeHelper.ScrollInfoProvider
        public int computeVerticalScrollRange() {
            IFadingEdgeScrollInfoProvider iFadingEdgeScrollInfoProvider = SpenComposerWrapper.this.mFadingEdgeScrollInfoProvider;
            return iFadingEdgeScrollInfoProvider != null ? iFadingEdgeScrollInfoProvider.computeVerticalScrollRange() : SpenComposerWrapper.this.getHeight();
        }

        @Override // androidx.core.util.SeslFadingEdgeHelper.ScrollInfoProvider
        public int getLastItemHeightIfVisible() {
            return 0;
        }

        @Override // androidx.core.util.SeslFadingEdgeHelper.ScrollInfoProvider
        public boolean shouldNormalizeFadingEdge() {
            return false;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SpenComposerWrapper(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(@NotNull Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        super.dispatchDraw(canvas);
        SeslFadingEdgeHelper seslFadingEdgeHelper = this.mFadingEdgeHelper;
        if (seslFadingEdgeHelper == null || !seslFadingEdgeHelper.isFadingEdgeEnabled()) {
            return;
        }
        seslFadingEdgeHelper.renderFadingEffect(canvas, this.mScrollInfoProvider);
    }

    public final void initFadingEdgeHelper() {
        SeslFadingEdgeHelper seslFadingEdgeHelperCreateSeslFadingEdgeHelper = SeslFadingEdgeHelperImpl.createSeslFadingEdgeHelper(getContext());
        seslFadingEdgeHelperCreateSeslFadingEdgeHelper.setTargetView(this);
        this.mFadingEdgeHelper = seslFadingEdgeHelperCreateSeslFadingEdgeHelper;
        this.mScrollInfoProvider = new ScrollInfoProvider();
    }

    @Override // com.samsung.android.sdk.composer.SpenComposer, android.view.View
    public void onDraw(@NotNull Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        super.onDraw(canvas);
        SeslFadingEdgeHelper seslFadingEdgeHelper = this.mFadingEdgeHelper;
        if (seslFadingEdgeHelper == null || !seslFadingEdgeHelper.isFadingEdgeEnabled()) {
            return;
        }
        SeslFadingEdgeHelper seslFadingEdgeHelper2 = this.mFadingEdgeHelper;
        Intrinsics.checkNotNull(seslFadingEdgeHelper2);
        seslFadingEdgeHelper2.prepareFadingEffect(canvas, 0, 0, getWidth(), getBottom());
    }

    public final void setFadingEdgeColor(int color) {
        SeslFadingEdgeHelper seslFadingEdgeHelper = this.mFadingEdgeHelper;
        if (seslFadingEdgeHelper != null) {
            seslFadingEdgeHelper.setFadingEdgeColor(color);
        }
    }

    public final void setFadingEdgeEnabled(boolean enable) {
        if (this.mFadingEdgeHelper == null) {
            initFadingEdgeHelper();
        }
        SeslFadingEdgeHelper seslFadingEdgeHelper = this.mFadingEdgeHelper;
        if (seslFadingEdgeHelper != null) {
            seslFadingEdgeHelper.setFadingEdgeEnabled(enable);
        }
    }

    public final void setFadingEdgeScrollInfoProvider(@Nullable IFadingEdgeScrollInfoProvider fadingEdgeScrollInfoProvider) {
        this.mFadingEdgeScrollInfoProvider = fadingEdgeScrollInfoProvider;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SpenComposerWrapper(@NotNull Context context, int i) {
        super(context, i);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SpenComposerWrapper(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SpenComposerWrapper(@NotNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
    }
}
