package com.samsung.android.support.senl.p145cm.base.framework.widget;

import android.widget.PopupWindow;
import androidx.appcompat.widget.ListPopupWindow;
import com.samsung.android.support.senl.p145cm.base.framework.sem.widget.AbsListPopupWindowDelegation;
import com.samsung.android.support.senl.p145cm.base.framework.sem.widget.ListPopupWindowDelegation;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(m13885d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \n2\u00020\u0001:\u0001\nB\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\tR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, m13886d2 = {"Lcom/samsung/android/support/senl/cm/base/framework/widget/ListPopupWindowCompat;", "", "mImpl", "Lcom/samsung/android/support/senl/cm/base/framework/sem/widget/AbsListPopupWindowDelegation;", "<init>", "(Lcom/samsung/android/support/senl/cm/base/framework/sem/widget/AbsListPopupWindowDelegation;)V", "seslGetPopupWindow", "Landroid/widget/PopupWindow;", "listPopupWindow", "Landroidx/appcompat/widget/ListPopupWindow;", "Companion", "cmBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class ListPopupWindowCompat {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @Nullable
    private static ListPopupWindowCompat sInstance;

    @NotNull
    private final AbsListPopupWindowDelegation mImpl;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u00020\u00058FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0007\u0010\u0003\u001a\u0004\b\b\u0010\t¨\u0006\n"}, m13886d2 = {"Lcom/samsung/android/support/senl/cm/base/framework/widget/ListPopupWindowCompat$Companion;", "", "<init>", "()V", "sInstance", "Lcom/samsung/android/support/senl/cm/base/framework/widget/ListPopupWindowCompat;", "instance", "getInstance$annotations", "getInstance", "()Lcom/samsung/android/support/senl/cm/base/framework/widget/ListPopupWindowCompat;", "cmBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final ListPopupWindowCompat getInstance() {
            if (ListPopupWindowCompat.sInstance == null) {
                ListPopupWindowCompat.sInstance = new ListPopupWindowCompat(new ListPopupWindowDelegation());
            }
            ListPopupWindowCompat listPopupWindowCompat = ListPopupWindowCompat.sInstance;
            Intrinsics.checkNotNull(listPopupWindowCompat, "null cannot be cast to non-null type com.samsung.android.support.senl.cm.base.framework.widget.ListPopupWindowCompat");
            return listPopupWindowCompat;
        }

        private Companion() {
        }

        @JvmStatic
        public static /* synthetic */ void getInstance$annotations() {
        }
    }

    public ListPopupWindowCompat(@NotNull AbsListPopupWindowDelegation mImpl) {
        Intrinsics.checkNotNullParameter(mImpl, "mImpl");
        this.mImpl = mImpl;
    }

    @NotNull
    public static final ListPopupWindowCompat getInstance() {
        return INSTANCE.getInstance();
    }

    @Nullable
    public final PopupWindow seslGetPopupWindow(@NotNull ListPopupWindow listPopupWindow) {
        Intrinsics.checkNotNullParameter(listPopupWindow, "listPopupWindow");
        return this.mImpl.seslGetPopupWindow(listPopupWindow);
    }
}
