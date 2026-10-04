package com.samsung.android.support.senl.addons.base.model.screen;

import android.util.Size;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.samsung.android.app.notes.sync.coedit.sharecore.strategy.AbstractC6670b;
import com.samsung.android.support.senl.addons.base.model.common.AbsBaseModel;
import com.samsung.android.support.senl.addons.base.model.screen.rotation.IRotationMode;
import com.samsung.android.support.senl.addons.base.model.screen.rotation.RotationEvent;
import com.samsung.android.support.senl.addons.base.utils.Logger;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m13885d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b!\b&\u0018\u0000 :2\u00020\u00012\u00020\u0002:\u0001:B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0016J\u0010\u0010\u001b\u001a\u00020\u00112\u0006\u0010\u001c\u001a\u00020\bH\u0016J\b\u0010\u001d\u001a\u00020\bH\u0016J\u0010\u0010\u001e\u001a\u00020\u00182\u0006\u0010\u001f\u001a\u00020\u0006H\u0002J\b\u0010 \u001a\u00020\u0006H\u0016J\u0010\u0010!\u001a\u00020\u00182\u0006\u0010\"\u001a\u00020\u0006H\u0016J\u0010\u0010#\u001a\u00020\u00182\u0006\u0010$\u001a\u00020\fH\u0002J\b\u0010%\u001a\u00020\fH\u0016J\b\u0010&\u001a\u00020\u0006H\u0016J\u0010\u0010'\u001a\u00020\u00182\u0006\u0010(\u001a\u00020\u0006H\u0016J\b\u0010)\u001a\u00020\u0006H\u0016J\u0010\u0010*\u001a\u00020\u00112\u0006\u0010\u001c\u001a\u00020\bH\u0016J\b\u0010+\u001a\u00020\bH\u0016J\u0010\u0010,\u001a\u00020\u00182\u0006\u0010$\u001a\u00020\fH\u0002J\b\u0010-\u001a\u00020\fH\u0016J\u0010\u0010.\u001a\u00020\u00112\u0006\u0010\u001c\u001a\u00020\bH\u0016J\b\u0010/\u001a\u00020\bH\u0016J\u0010\u00100\u001a\u00020\u00112\u0006\u00101\u001a\u00020\u0006H\u0016J\b\u00102\u001a\u00020\u0018H\u0004J\b\u00103\u001a\u00020\u0006H\u0016J\u0010\u00104\u001a\u00020\u00112\u0006\u00105\u001a\u00020\u0015H\u0016J\u0010\u00106\u001a\u00020\u00112\u0006\u00105\u001a\u00020\u0015H\u0016J\b\u00107\u001a\u00020\u0018H\u0014J\u0010\u00108\u001a\u00020\u00182\u0006\u00109\u001a\u00020\u0011H\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u0013\u001a\u0012\u0012\u0004\u0012\u00020\u00150\u0014j\b\u0012\u0004\u0012\u00020\u0015`\u0016X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006;"}, m13886d2 = {"Lcom/samsung/android/support/senl/addons/base/model/screen/AbsScreenModel;", "Lcom/samsung/android/support/senl/addons/base/model/common/AbsBaseModel;", "Lcom/samsung/android/support/senl/addons/base/model/screen/IScreenModel;", "<init>", "()V", "mOrientation", "", "mDeviceScreenSize", "Landroid/util/Size;", "mDeviceScreenResolution", "mContentScreenSize", "mContentResolution", "", "mWindowType", "mWindowSize", "mWindowResolution", "mEnabledRotation", "", "mRotationInfo", "mRotationListeners", "Ljava/util/ArrayList;", "Lcom/samsung/android/support/senl/addons/base/model/screen/rotation/IRotationMode$OnRotationChangeListener;", "Lkotlin/collections/ArrayList;", "updateScreenData", "", "data", "Lcom/samsung/android/support/senl/addons/base/model/screen/IScreenData;", "setScreenSize", "size", "getScreenSize", "setScreenResolution", "densityDpi", "getScreenResolution", "setOrientation", "orientation", "setContentResolution", "dpi", "getContentResolution", "getOrientation", "setWindowType", "windowType", "getWindowType", "setWindowSize", "getWindowSize", "setWindowResolution", "getWindowResolution", "setContentScreenSize", "getContentScreenSize", "setRotation", "degree", "rotate", "getRotation", "addRotationChangeListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "removeRotationChangeListener", "close", "enableRotation", "enable", "Companion", "ntAddons_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public abstract class AbsScreenModel extends AbsBaseModel implements IScreenModel {

    @NotNull
    private static final String TAG = Logger.createTag("AbsScreenModel");
    private int mDeviceScreenResolution;
    private boolean mEnabledRotation;
    private int mOrientation;
    private int mRotationInfo;

    @NotNull
    private Size mDeviceScreenSize = new Size(0, 0);

    @NotNull
    private Size mContentScreenSize = new Size(0, 0);
    private float mContentResolution = 3.0f;
    private int mWindowType = -1;

    @NotNull
    private Size mWindowSize = new Size(0, 0);
    private float mWindowResolution = 3.0f;

    @NotNull
    private final ArrayList<IRotationMode.OnRotationChangeListener> mRotationListeners = new ArrayList<>();

    private final void setContentResolution(float dpi) {
        if (this.mContentResolution == dpi) {
            return;
        }
        this.mContentResolution = dpi;
        Logger.m7100d(TAG, "setContentResolution : " + dpi);
    }

    private final void setScreenResolution(int densityDpi) {
        if (this.mDeviceScreenResolution != densityDpi) {
            this.mDeviceScreenResolution = densityDpi;
            AbstractC6670b.m4761v(densityDpi, "setScreenResolution : ", TAG);
        }
    }

    private final void setWindowResolution(float dpi) {
        if (this.mWindowResolution == dpi) {
            return;
        }
        this.mWindowResolution = dpi;
        Logger.m7100d(TAG, "setWindowResolution : " + dpi);
    }

    @Override // com.samsung.android.support.senl.addons.base.model.screen.rotation.IRotationMode
    public boolean addRotationChangeListener(@NotNull IRotationMode.OnRotationChangeListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        return this.mRotationListeners.add(listener);
    }

    public void close() {
        this.mRotationListeners.clear();
    }

    @Override // com.samsung.android.support.senl.addons.base.model.screen.rotation.IRotationMode
    public void enableRotation(boolean enable) {
        if (!enable) {
            setRotation(0);
        }
        this.mEnabledRotation = enable;
    }

    @Override // com.samsung.android.support.senl.addons.base.model.screen.IScreenData
    /* JADX INFO: renamed from: getContentResolution, reason: from getter */
    public float getMContentResolution() {
        return this.mContentResolution;
    }

    @Override // com.samsung.android.support.senl.addons.base.model.screen.IScreenData
    @NotNull
    /* JADX INFO: renamed from: getContentScreenSize, reason: from getter */
    public Size getMContentScreenSize() {
        return this.mContentScreenSize;
    }

    @Override // com.samsung.android.support.senl.addons.base.model.screen.IOrientationMode
    /* JADX INFO: renamed from: getOrientation, reason: from getter */
    public int getMOrientation() {
        return this.mOrientation;
    }

    @Override // com.samsung.android.support.senl.addons.base.model.screen.rotation.IRotationMode
    /* JADX INFO: renamed from: getRotation, reason: from getter */
    public int getMRotationInfo() {
        return this.mRotationInfo;
    }

    @Override // com.samsung.android.support.senl.addons.base.model.screen.IScreenData
    /* JADX INFO: renamed from: getScreenResolution, reason: from getter */
    public int getMDeviceScreenResolution() {
        return this.mDeviceScreenResolution;
    }

    @Override // com.samsung.android.support.senl.addons.base.model.screen.IScreenData
    @NotNull
    /* JADX INFO: renamed from: getScreenSize, reason: from getter */
    public Size getMDeviceScreenSize() {
        return this.mDeviceScreenSize;
    }

    @Override // com.samsung.android.support.senl.addons.base.model.screen.IScreenData
    /* JADX INFO: renamed from: getWindowResolution, reason: from getter */
    public float getMWindowResolution() {
        return this.mWindowResolution;
    }

    @Override // com.samsung.android.support.senl.addons.base.model.screen.IScreenData
    @NotNull
    /* JADX INFO: renamed from: getWindowSize, reason: from getter */
    public Size getMWindowSize() {
        return this.mWindowSize;
    }

    @Override // com.samsung.android.support.senl.addons.base.model.screen.IScreenModel
    /* JADX INFO: renamed from: getWindowType, reason: from getter */
    public int getMWindowType() {
        return this.mWindowType;
    }

    @Override // com.samsung.android.support.senl.addons.base.model.screen.rotation.IRotationMode
    public boolean removeRotationChangeListener(@NotNull IRotationMode.OnRotationChangeListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        return this.mRotationListeners.remove(listener);
    }

    public final void rotate() {
        RotationEvent rotationEvent = new RotationEvent(this.mRotationInfo);
        Iterator<IRotationMode.OnRotationChangeListener> it = this.mRotationListeners.iterator();
        Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
        while (it.hasNext()) {
            IRotationMode.OnRotationChangeListener next = it.next();
            Intrinsics.checkNotNullExpressionValue(next, "next(...)");
            next.onRotationChanged(rotationEvent);
        }
    }

    public boolean setContentScreenSize(@NotNull Size size) {
        Intrinsics.checkNotNullParameter(size, "size");
        if (Intrinsics.areEqual(this.mContentScreenSize, size)) {
            return false;
        }
        this.mContentScreenSize = size;
        Logger.m7100d(TAG, "setContentScreenSize : " + size);
        return true;
    }

    @Override // com.samsung.android.support.senl.addons.base.model.screen.IOrientationMode
    public void setOrientation(int orientation) {
        if (this.mOrientation != orientation) {
            this.mOrientation = orientation;
            notifyChanged(2);
            AbstractC6670b.m4761v(this.mOrientation, "setOrientation : ", TAG);
        }
    }

    @Override // com.samsung.android.support.senl.addons.base.model.screen.rotation.IRotationMode
    public boolean setRotation(int degree) {
        if (!this.mEnabledRotation || this.mRotationInfo == degree) {
            return false;
        }
        AbstractC6670b.m4761v(degree, "changed rotation : ", TAG);
        this.mRotationInfo = degree;
        rotate();
        return true;
    }

    public boolean setScreenSize(@NotNull Size size) {
        Intrinsics.checkNotNullParameter(size, "size");
        if (Intrinsics.areEqual(this.mDeviceScreenSize, size)) {
            return false;
        }
        this.mDeviceScreenSize = size;
        Logger.m7100d(TAG, "setScreenSize : " + size);
        return true;
    }

    public boolean setWindowSize(@NotNull Size size) {
        Intrinsics.checkNotNullParameter(size, "size");
        if (Intrinsics.areEqual(this.mWindowSize, size)) {
            return false;
        }
        this.mWindowSize = size;
        Logger.m7100d(TAG, "setWindowSize : " + size);
        return true;
    }

    public void setWindowType(int windowType) {
        if (this.mWindowType != windowType) {
            this.mWindowType = windowType;
            Logger.m7100d(TAG, "setWindowType : " + windowType);
            notifyChanged(3);
        }
    }

    @Override // com.samsung.android.support.senl.addons.base.model.screen.IScreenMode
    public void updateScreenData(@NotNull IScreenData data) {
        Intrinsics.checkNotNullParameter(data, "data");
        boolean windowSize = setWindowSize(data.getMWindowSize());
        setWindowResolution(data.getMWindowResolution());
        boolean screenSize = windowSize | setScreenSize(data.getMDeviceScreenSize());
        setScreenResolution(data.getMDeviceScreenResolution());
        boolean contentScreenSize = screenSize | setContentScreenSize(data.getMContentScreenSize());
        setContentResolution(data.getMContentResolution());
        if (contentScreenSize) {
            notifyChanged(1);
        }
    }
}
