package com.samsung.android.support.senl.addons.base.model.screen;

import com.samsung.android.support.senl.addons.base.model.common.IBaseModel;
import com.samsung.android.support.senl.addons.base.model.screen.rotation.IRotationMode;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m13885d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\bf\u0018\u0000 \b2\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u0005:\u0001\bJ\b\u0010\u0006\u001a\u00020\u0007H&¨\u0006\t"}, m13886d2 = {"Lcom/samsung/android/support/senl/addons/base/model/screen/IScreenModel;", "Lcom/samsung/android/support/senl/addons/base/model/common/IBaseModel;", "Lcom/samsung/android/support/senl/addons/base/model/screen/IWindowMode;", "Lcom/samsung/android/support/senl/addons/base/model/screen/IScreenMode;", "Lcom/samsung/android/support/senl/addons/base/model/screen/IOrientationMode;", "Lcom/samsung/android/support/senl/addons/base/model/screen/rotation/IRotationMode;", "getWindowType", "", "Companion", "ntAddons_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public interface IScreenModel extends IBaseModel, IWindowMode, IScreenMode, IOrientationMode, IRotationMode {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = Companion.$$INSTANCE;
    public static final int OBSV_SCREEN_MODEL_ORIENTATION_CHANGED = 2;
    public static final int OBSV_SCREEN_MODEL_SIZE_CHANGED = 1;
    public static final int OBSV_SCREEN_MODEL_WINDOW_TYPE_CHANGED = 3;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\b"}, m13886d2 = {"Lcom/samsung/android/support/senl/addons/base/model/screen/IScreenModel$Companion;", "", "<init>", "()V", "OBSV_SCREEN_MODEL_SIZE_CHANGED", "", "OBSV_SCREEN_MODEL_ORIENTATION_CHANGED", "OBSV_SCREEN_MODEL_WINDOW_TYPE_CHANGED", "ntAddons_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        public static final int OBSV_SCREEN_MODEL_ORIENTATION_CHANGED = 2;
        public static final int OBSV_SCREEN_MODEL_SIZE_CHANGED = 1;
        public static final int OBSV_SCREEN_MODEL_WINDOW_TYPE_CHANGED = 3;

        private Companion() {
        }
    }

    int getWindowType();
}
