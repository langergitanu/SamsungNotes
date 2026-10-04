package com.samsung.android.support.senl.addons.base.model.screen.rotation;

import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m13885d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001:\u0001\u000eJ\b\u0010\u0002\u001a\u00020\u0003H&J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0003H&J\u0010\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\tH&J\u0010\u0010\n\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\tH&J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0005H&¨\u0006\u000f"}, m13886d2 = {"Lcom/samsung/android/support/senl/addons/base/model/screen/rotation/IRotationMode;", "Lcom/samsung/android/support/senl/addons/base/model/screen/rotation/IRotationInfo;", "getRotation", "", "setRotation", "", "degree", "addRotationChangeListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/samsung/android/support/senl/addons/base/model/screen/rotation/IRotationMode$OnRotationChangeListener;", "removeRotationChangeListener", "enableRotation", "", "enable", "OnRotationChangeListener", "ntAddons_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public interface IRotationMode extends IRotationInfo {

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&¨\u0006\u0006"}, m13886d2 = {"Lcom/samsung/android/support/senl/addons/base/model/screen/rotation/IRotationMode$OnRotationChangeListener;", "", "onRotationChanged", "", "action", "Lcom/samsung/android/support/senl/addons/base/model/screen/rotation/IRotationEvent;", "ntAddons_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public interface OnRotationChangeListener {
        void onRotationChanged(@Nullable IRotationEvent action);
    }

    boolean addRotationChangeListener(@NotNull OnRotationChangeListener listener);

    void enableRotation(boolean enable);

    int getRotation();

    boolean removeRotationChangeListener(@NotNull OnRotationChangeListener listener);

    boolean setRotation(int degree);
}
