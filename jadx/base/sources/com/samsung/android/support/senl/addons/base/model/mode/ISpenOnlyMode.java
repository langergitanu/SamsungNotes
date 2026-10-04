package com.samsung.android.support.senl.addons.base.model.mode;

import com.samsung.android.support.senl.addons.base.model.common.IBaseModel;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m13885d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u0000 \u00072\u00020\u0001:\u0001\u0007J\b\u0010\u0002\u001a\u00020\u0003H&J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0003H&¨\u0006\b"}, m13886d2 = {"Lcom/samsung/android/support/senl/addons/base/model/mode/ISpenOnlyMode;", "Lcom/samsung/android/support/senl/addons/base/model/common/IBaseModel;", "getSpenOnlyMode", "", "setSpenOnlyMode", "", "enable", "Companion", "ntAddons_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public interface ISpenOnlyMode extends IBaseModel {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = Companion.$$INSTANCE;
    public static final int OBSV_PROPERTY_SPEN_MODE_CHANGED = 401;
    public static final int OBSV_PROPERTY_SPEN_MODE_UPDATED = 403;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, m13886d2 = {"Lcom/samsung/android/support/senl/addons/base/model/mode/ISpenOnlyMode$Companion;", "", "<init>", "()V", "OBSV_PROPERTY_SPEN_MODE_CHANGED", "", "OBSV_PROPERTY_SPEN_MODE_UPDATED", "ntAddons_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        public static final int OBSV_PROPERTY_SPEN_MODE_CHANGED = 401;
        public static final int OBSV_PROPERTY_SPEN_MODE_UPDATED = 403;

        private Companion() {
        }
    }

    boolean getSpenOnlyMode();

    void setSpenOnlyMode(boolean enable);
}
