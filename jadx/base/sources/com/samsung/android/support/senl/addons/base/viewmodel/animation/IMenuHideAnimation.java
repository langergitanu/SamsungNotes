package com.samsung.android.support.senl.addons.base.viewmodel.animation;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m13885d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\bf\u0018\u0000 \u00042\u00020\u0001:\u0001\u0004J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0005"}, m13886d2 = {"Lcom/samsung/android/support/senl/addons/base/viewmodel/animation/IMenuHideAnimation;", "", "getAnimationType", "", "Companion", "ntAddons_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public interface IMenuHideAnimation {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = Companion.$$INSTANCE;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\t¨\u0006\r"}, m13886d2 = {"Lcom/samsung/android/support/senl/addons/base/viewmodel/animation/IMenuHideAnimation$Companion;", "", "<init>", "()V", "TYPE_ANIMATION_HIDE", "", "getTYPE_ANIMATION_HIDE", "()I", "setTYPE_ANIMATION_HIDE", "(I)V", "TYPE_ANIMATION_SHOW", "getTYPE_ANIMATION_SHOW", "setTYPE_ANIMATION_SHOW", "ntAddons_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        private static int TYPE_ANIMATION_HIDE = 1;
        private static int TYPE_ANIMATION_SHOW = 2;

        private Companion() {
        }

        public final int getTYPE_ANIMATION_HIDE() {
            return TYPE_ANIMATION_HIDE;
        }

        public final int getTYPE_ANIMATION_SHOW() {
            return TYPE_ANIMATION_SHOW;
        }

        public final void setTYPE_ANIMATION_HIDE(int i) {
            TYPE_ANIMATION_HIDE = i;
        }

        public final void setTYPE_ANIMATION_SHOW(int i) {
            TYPE_ANIMATION_SHOW = i;
        }
    }

    int getAnimationType();
}
