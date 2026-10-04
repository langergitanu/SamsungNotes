package com.samsung.android.support.senl.p145cm.base.framework.sem.view;

import android.app.Activity;
import android.view.View;
import com.samsung.android.support.senl.p148nt.base.common.mcf.handoff.common.HandoffConstant;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.util.Constants;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(m13885d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0016\u0018\u00002\u00020\u0001:\u0002\b\tB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\n"}, m13886d2 = {"Lcom/samsung/android/support/senl/cm/base/framework/sem/view/AbsAiResultViewOnSidePanelCompatImplFactory;", "", "<init>", "()V", "create", "Lcom/samsung/android/support/senl/cm/base/framework/sem/view/AbsAiResultViewOnSidePanelCompatImplFactory$IAiResultViewOnSidePanelCompatImpl;", HandoffConstant.KEY_DEVICE_TYPE, "", "IAiResultViewOnSidePanelCompatImpl", "AiResultViewOnSidePanelCompatPureImpl", "cmBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public class AbsAiResultViewOnSidePanelCompatImplFactory {

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&J\b\u0010\b\u001a\u00020\u0003H&¨\u0006\t"}, m13886d2 = {"Lcom/samsung/android/support/senl/cm/base/framework/sem/view/AbsAiResultViewOnSidePanelCompatImplFactory$IAiResultViewOnSidePanelCompatImpl;", "", "init", "", Constants.StringExtra.EXECUTE_TYPE_ACTIVITY, "Landroid/app/Activity;", "view", "Landroid/view/View;", "closeSidePanel", "cmBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public interface IAiResultViewOnSidePanelCompatImpl {
        void closeSidePanel();

        void init(@Nullable Activity activity, @Nullable View view);
    }

    @NotNull
    public IAiResultViewOnSidePanelCompatImpl create(int deviceType) {
        return new AiResultViewOnSidePanelCompatPureImpl();
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001c\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016J\b\u0010\n\u001a\u00020\u0005H\u0016¨\u0006\u000b"}, m13886d2 = {"Lcom/samsung/android/support/senl/cm/base/framework/sem/view/AbsAiResultViewOnSidePanelCompatImplFactory$AiResultViewOnSidePanelCompatPureImpl;", "Lcom/samsung/android/support/senl/cm/base/framework/sem/view/AbsAiResultViewOnSidePanelCompatImplFactory$IAiResultViewOnSidePanelCompatImpl;", "<init>", "()V", "init", "", Constants.StringExtra.EXECUTE_TYPE_ACTIVITY, "Landroid/app/Activity;", "view", "Landroid/view/View;", "closeSidePanel", "cmBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class AiResultViewOnSidePanelCompatPureImpl implements IAiResultViewOnSidePanelCompatImpl {
        @Override // com.samsung.android.support.senl.cm.base.framework.sem.view.AbsAiResultViewOnSidePanelCompatImplFactory.IAiResultViewOnSidePanelCompatImpl
        public void closeSidePanel() {
        }

        @Override // com.samsung.android.support.senl.cm.base.framework.sem.view.AbsAiResultViewOnSidePanelCompatImplFactory.IAiResultViewOnSidePanelCompatImpl
        public void init(@Nullable Activity activity, @Nullable View view) {
        }
    }
}
