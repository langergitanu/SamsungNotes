package com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.option.page.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.vector.shape.pathdata.VPathDataCmd;
import com.samsung.android.support.senl.p148nt.base.winset.view.setting.page.common.AbsPageScrollDirectionSettingsView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m13885d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0017B\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u001b\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0004\u0010\bB#\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\u000bJ\u000e\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\f\u001a\u00020\rJ\b\u0010\u0010\u001a\u00020\u0011H\u0016J\b\u0010\u0012\u001a\u00020\u0011H\u0016J\b\u0010\u0013\u001a\u00020\u0011H\u0016J\u0012\u0010\u0014\u001a\u00020\u000f2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0018"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/base/view/menu/option/page/widget/CompScrollDirectionSettingsView;", "Lcom/samsung/android/support/senl/nt/base/winset/view/setting/page/common/AbsPageScrollDirectionSettingsView;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "contract", "Lcom/samsung/android/support/senl/nt/composer/main/base/view/menu/option/page/widget/CompScrollDirectionSettingsView$Contract;", "setContract", "", "isVerticalScroll", "", "isSinglePage", "isTwoPageButtonVisible", "onClick", VPathDataCmd.RCurveTo, "Landroid/view/View;", "Contract", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class CompScrollDirectionSettingsView extends AbsPageScrollDirectionSettingsView {

    @Nullable
    private Contract contract;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&J\b\u0010\u0005\u001a\u00020\u0003H&J\u0012\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH&¨\u0006\n"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/base/view/menu/option/page/widget/CompScrollDirectionSettingsView$Contract;", "", "isVerticalScroll", "", "isSinglePage", "isTwoPageButtonVisible", "onClick", "", VPathDataCmd.RCurveTo, "Landroid/view/View;", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public interface Contract {
        boolean isSinglePage();

        boolean isTwoPageButtonVisible();

        boolean isVerticalScroll();

        void onClick(@Nullable View v);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CompScrollDirectionSettingsView(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    @Override // com.samsung.android.support.senl.p148nt.base.winset.view.setting.page.common.AbsPageScrollDirectionSettingsView
    public boolean isSinglePage() {
        Contract contract = this.contract;
        return contract != null && contract.isSinglePage();
    }

    @Override // com.samsung.android.support.senl.p148nt.base.winset.view.setting.page.common.AbsPageScrollDirectionSettingsView
    public boolean isTwoPageButtonVisible() {
        Contract contract = this.contract;
        return contract != null && contract.isTwoPageButtonVisible();
    }

    @Override // com.samsung.android.support.senl.p148nt.base.winset.view.setting.page.common.AbsPageScrollDirectionSettingsView
    public boolean isVerticalScroll() {
        Contract contract = this.contract;
        return contract != null && contract.isVerticalScroll();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(@Nullable View v) {
        Contract contract = this.contract;
        if (contract != null) {
            contract.onClick(v);
        }
    }

    public final void setContract(@NotNull Contract contract) {
        Intrinsics.checkNotNullParameter(contract, "contract");
        this.contract = contract;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CompScrollDirectionSettingsView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CompScrollDirectionSettingsView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
    }
}
