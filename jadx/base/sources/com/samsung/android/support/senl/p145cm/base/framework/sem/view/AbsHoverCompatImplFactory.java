package com.samsung.android.support.senl.p145cm.base.framework.sem.view;

import android.view.View;
import android.widget.AbsListView;
import com.samsung.android.support.senl.p148nt.base.common.mcf.handoff.common.HandoffConstant;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.util.Constants;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(m13885d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b&\u0018\u00002\u00020\u0001:\u0002\b\tB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\n"}, m13886d2 = {"Lcom/samsung/android/support/senl/cm/base/framework/sem/view/AbsHoverCompatImplFactory;", "", "<init>", "()V", "create", "Lcom/samsung/android/support/senl/cm/base/framework/sem/view/AbsHoverCompatImplFactory$IHoverCompatImpl;", HandoffConstant.KEY_DEVICE_TYPE, "", "IHoverCompatImpl", "HoverCompatPureImpl", "cmBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public abstract class AbsHoverCompatImplFactory {

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\bf\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017J\u001a\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\u001c\u0010\b\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\t\u001a\u0004\u0018\u00010\nH&J\u001c\u0010\u000b\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\f\u001a\u0004\u0018\u00010\u0005H&J\u001c\u0010\r\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u000e\u001a\u0004\u0018\u00010\u0005H&J\u0014\u0010\u000f\u001a\u0004\u0018\u00010\u00012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\u001a\u0010\u0010\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0012\u0010\u0011\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\u001a\u0010\u0012\u001a\u00020\u00032\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0015\u001a\u00020\u0016H&¨\u0006\u0018"}, m13886d2 = {"Lcom/samsung/android/support/senl/cm/base/framework/sem/view/AbsHoverCompatImplFactory$IHoverCompatImpl;", "", "setPopupType", "", "view", "Landroid/view/View;", "type", "", "setText", "text", "", "setThumb", "hoverView", "setCustomView", "customView", "getHoverPopup", Constants.IntentExtraValue.SHOW, "dismiss", "setHoverScrollEnabled", "listView", "Landroid/widget/AbsListView;", "enable", "", "Companion", "cmBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public interface IHoverCompatImpl {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        @NotNull
        public static final Companion INSTANCE = Companion.$$INSTANCE;
        public static final int TYPE_NONE = 0;
        public static final int TYPE_TOOLTIP = 1;
        public static final int TYPE_USER_CUSTOM = 3;
        public static final int TYPE_WIDGET_DEFAULT = 2;

        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        @Metadata(m13885d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\t"}, m13886d2 = {"Lcom/samsung/android/support/senl/cm/base/framework/sem/view/AbsHoverCompatImplFactory$IHoverCompatImpl$Companion;", "", "<init>", "()V", "TYPE_NONE", "", "TYPE_TOOLTIP", "TYPE_WIDGET_DEFAULT", "TYPE_USER_CUSTOM", "cmBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
        public static final class Companion {
            static final /* synthetic */ Companion $$INSTANCE = new Companion();
            public static final int TYPE_NONE = 0;
            public static final int TYPE_TOOLTIP = 1;
            public static final int TYPE_USER_CUSTOM = 3;
            public static final int TYPE_WIDGET_DEFAULT = 2;

            private Companion() {
            }
        }

        void dismiss(@Nullable View view);

        @Nullable
        Object getHoverPopup(@Nullable View view);

        void setCustomView(@Nullable View view, @Nullable View customView);

        void setHoverScrollEnabled(@Nullable AbsListView listView, boolean enable);

        void setPopupType(@Nullable View view, int type);

        void setText(@Nullable View view, @Nullable CharSequence text);

        void setThumb(@Nullable View view, @Nullable View hoverView);

        void show(@Nullable View view, int type);
    }

    @NotNull
    public IHoverCompatImpl create(int deviceType) {
        return new HoverCompatPureImpl();
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\u001c\u0010\n\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016J\u001c\u0010\r\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\u000e\u001a\u0004\u0018\u00010\u0007H\u0016J\u001c\u0010\u000f\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\u0010\u001a\u0004\u0018\u00010\u0007H\u0016J\u0014\u0010\u0011\u001a\u0004\u0018\u00010\u00122\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\u001a\u0010\u0013\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\u0012\u0010\u0014\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\u001a\u0010\u0015\u001a\u00020\u00052\b\u0010\u0016\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0016¨\u0006\u001a"}, m13886d2 = {"Lcom/samsung/android/support/senl/cm/base/framework/sem/view/AbsHoverCompatImplFactory$HoverCompatPureImpl;", "Lcom/samsung/android/support/senl/cm/base/framework/sem/view/AbsHoverCompatImplFactory$IHoverCompatImpl;", "<init>", "()V", "setPopupType", "", "view", "Landroid/view/View;", "type", "", "setText", "text", "", "setThumb", "hoverView", "setCustomView", "customView", "getHoverPopup", "", Constants.IntentExtraValue.SHOW, "dismiss", "setHoverScrollEnabled", "listView", "Landroid/widget/AbsListView;", "enable", "", "cmBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class HoverCompatPureImpl implements IHoverCompatImpl {
        @Override // com.samsung.android.support.senl.cm.base.framework.sem.view.AbsHoverCompatImplFactory.IHoverCompatImpl
        @Nullable
        public Object getHoverPopup(@Nullable View view) {
            return null;
        }

        @Override // com.samsung.android.support.senl.cm.base.framework.sem.view.AbsHoverCompatImplFactory.IHoverCompatImpl
        public void dismiss(@Nullable View view) {
        }

        @Override // com.samsung.android.support.senl.cm.base.framework.sem.view.AbsHoverCompatImplFactory.IHoverCompatImpl
        public void setCustomView(@Nullable View view, @Nullable View customView) {
        }

        @Override // com.samsung.android.support.senl.cm.base.framework.sem.view.AbsHoverCompatImplFactory.IHoverCompatImpl
        public void setHoverScrollEnabled(@Nullable AbsListView listView, boolean enable) {
        }

        @Override // com.samsung.android.support.senl.cm.base.framework.sem.view.AbsHoverCompatImplFactory.IHoverCompatImpl
        public void setPopupType(@Nullable View view, int type) {
        }

        @Override // com.samsung.android.support.senl.cm.base.framework.sem.view.AbsHoverCompatImplFactory.IHoverCompatImpl
        public void setText(@Nullable View view, @Nullable CharSequence text) {
        }

        @Override // com.samsung.android.support.senl.cm.base.framework.sem.view.AbsHoverCompatImplFactory.IHoverCompatImpl
        public void setThumb(@Nullable View view, @Nullable View hoverView) {
        }

        @Override // com.samsung.android.support.senl.cm.base.framework.sem.view.AbsHoverCompatImplFactory.IHoverCompatImpl
        public void show(@Nullable View view, int type) {
        }
    }
}
