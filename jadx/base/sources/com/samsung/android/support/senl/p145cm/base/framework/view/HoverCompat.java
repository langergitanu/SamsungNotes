package com.samsung.android.support.senl.p145cm.base.framework.view;

import android.view.View;
import android.widget.AbsListView;
import com.samsung.android.support.senl.p145cm.base.framework.sem.view.AbsHoverCompatImplFactory;
import com.samsung.android.support.senl.p145cm.base.framework.sem.view.HoverCompatImplFactory;
import com.samsung.android.support.senl.p145cm.base.framework.support.DeviceInfo;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.util.Constants;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(m13885d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\r\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J,\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\tJ\u0018\u0010\u000f\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u000bJ\u001a\u0010\u0010\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\u0011\u001a\u0004\u0018\u00010\tJ\u001a\u0010\u0012\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\u000e\u001a\u0004\u0018\u00010\tJ\u0012\u0010\u0013\u001a\u0004\u0018\u00010\u00012\b\u0010\b\u001a\u0004\u0018\u00010\tJ\u0018\u0010\u0014\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u000bJ\u0010\u0010\u0015\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tJ\u0018\u0010\u0016\u001a\u00020\u00072\b\u0010\u0017\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u0019\u001a\u00020\u001aR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001c"}, m13886d2 = {"Lcom/samsung/android/support/senl/cm/base/framework/view/HoverCompat;", "", "mImpl", "Lcom/samsung/android/support/senl/cm/base/framework/sem/view/AbsHoverCompatImplFactory$IHoverCompatImpl;", "<init>", "(Lcom/samsung/android/support/senl/cm/base/framework/sem/view/AbsHoverCompatImplFactory$IHoverCompatImpl;)V", "setHoverPopup", "", "view", "Landroid/view/View;", "type", "", "text", "", "customView", "setPopupType", "setThumb", "hoverView", "setCustomView", "getHoverPopup", Constants.IntentExtraValue.SHOW, "dismiss", "setHoverScrollEnabled", "listView", "Landroid/widget/AbsListView;", "enable", "", "Companion", "cmBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class HoverCompat {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    public static final int TYPE_NONE = 0;
    public static final int TYPE_TOOLTIP = 1;
    public static final int TYPE_USER_CUSTOM = 3;
    public static final int TYPE_WIDGET_DEFAULT = 2;

    @Nullable
    private static HoverCompat mInstance;

    @NotNull
    private final AbsHoverCompatImplFactory.IHoverCompatImpl mImpl;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u000b\u001a\u00020\n8FX\u0087\u0004¢\u0006\f\u0012\u0004\b\f\u0010\u0003\u001a\u0004\b\r\u0010\u000e¨\u0006\u000f"}, m13886d2 = {"Lcom/samsung/android/support/senl/cm/base/framework/view/HoverCompat$Companion;", "", "<init>", "()V", "TYPE_NONE", "", "TYPE_TOOLTIP", "TYPE_WIDGET_DEFAULT", "TYPE_USER_CUSTOM", "mInstance", "Lcom/samsung/android/support/senl/cm/base/framework/view/HoverCompat;", "instance", "getInstance$annotations", "getInstance", "()Lcom/samsung/android/support/senl/cm/base/framework/view/HoverCompat;", "cmBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final synchronized HoverCompat getInstance() {
            HoverCompat hoverCompat;
            try {
                if (HoverCompat.mInstance == null) {
                    HoverCompat.mInstance = new HoverCompat(new HoverCompatImplFactory().create(DeviceInfo.getDeviceType()), null);
                }
                hoverCompat = HoverCompat.mInstance;
                Intrinsics.checkNotNull(hoverCompat, "null cannot be cast to non-null type com.samsung.android.support.senl.cm.base.framework.view.HoverCompat");
            } catch (Throwable th) {
                throw th;
            }
            return hoverCompat;
        }

        private Companion() {
        }

        @JvmStatic
        public static /* synthetic */ void getInstance$annotations() {
        }
    }

    public /* synthetic */ HoverCompat(AbsHoverCompatImplFactory.IHoverCompatImpl iHoverCompatImpl, DefaultConstructorMarker defaultConstructorMarker) {
        this(iHoverCompatImpl);
    }

    @NotNull
    public static final synchronized HoverCompat getInstance() {
        return INSTANCE.getInstance();
    }

    public final void dismiss(@Nullable View view) {
        this.mImpl.dismiss(view);
    }

    @Nullable
    public final Object getHoverPopup(@Nullable View view) {
        return this.mImpl.getHoverPopup(view);
    }

    public final void setCustomView(@Nullable View view, @Nullable View customView) {
        this.mImpl.setCustomView(view, customView);
    }

    public final void setHoverPopup(@Nullable View view, int type, @Nullable CharSequence text, @Nullable View customView) {
        if (type == 0 || type == 1) {
            this.mImpl.setPopupType(view, type);
        } else if (type == 2) {
            this.mImpl.setText(view, text);
        } else {
            if (type != 3) {
                return;
            }
            this.mImpl.setThumb(view, customView);
        }
    }

    public final void setHoverScrollEnabled(@Nullable AbsListView listView, boolean enable) {
        if (listView == null) {
            return;
        }
        this.mImpl.setHoverScrollEnabled(listView, enable);
    }

    public final void setPopupType(@Nullable View view, int type) {
        this.mImpl.setPopupType(view, type);
    }

    public final void setThumb(@Nullable View view, @Nullable View hoverView) {
        this.mImpl.setThumb(view, hoverView);
    }

    public final void show(@Nullable View view, int type) {
        this.mImpl.show(view, type);
    }

    private HoverCompat(AbsHoverCompatImplFactory.IHoverCompatImpl iHoverCompatImpl) {
        this.mImpl = iHoverCompatImpl;
    }
}
