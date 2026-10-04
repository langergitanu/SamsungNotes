package com.samsung.android.support.senl.addons.brush.model.feature;

import com.samsung.android.support.senl.addons.base.utils.FileUtils;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m13885d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\bf\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, m13886d2 = {"Lcom/samsung/android/support/senl/addons/brush/model/feature/ISupportedFeature;", "", "Companion", "ntAddons_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public interface ISupportedFeature {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = Companion.$$INSTANCE;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u001a\u0010\r\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, m13886d2 = {"Lcom/samsung/android/support/senl/addons/brush/model/feature/ISupportedFeature$Companion;", "", "<init>", "()V", "SUPPORT_LOCK_ROTATION", "", "getSUPPORT_LOCK_ROTATION", "()Z", "setSUPPORT_LOCK_ROTATION", "(Z)V", "SUPPORT_FULL_SCREEN", "getSUPPORT_FULL_SCREEN", "setSUPPORT_FULL_SCREEN", "SAVE_ASYNC_SLEEP_TIME", "", "getSAVE_ASYNC_SLEEP_TIME", "()I", "setSAVE_ASYNC_SLEEP_TIME", "(I)V", "ntAddons_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class Companion {
        private static int SAVE_ASYNC_SLEEP_TIME;
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        private static boolean SUPPORT_LOCK_ROTATION = true;
        private static boolean SUPPORT_FULL_SCREEN = FileUtils.isExistedFile("/sdcard/notes_brush_full.cfg");

        private Companion() {
        }

        public final int getSAVE_ASYNC_SLEEP_TIME() {
            return SAVE_ASYNC_SLEEP_TIME;
        }

        public final boolean getSUPPORT_FULL_SCREEN() {
            return SUPPORT_FULL_SCREEN;
        }

        public final boolean getSUPPORT_LOCK_ROTATION() {
            return SUPPORT_LOCK_ROTATION;
        }

        public final void setSAVE_ASYNC_SLEEP_TIME(int i) {
            SAVE_ASYNC_SLEEP_TIME = i;
        }

        public final void setSUPPORT_FULL_SCREEN(boolean z) {
            SUPPORT_FULL_SCREEN = z;
        }

        public final void setSUPPORT_LOCK_ROTATION(boolean z) {
            SUPPORT_LOCK_ROTATION = z;
        }
    }
}
