package com.samsung.android.support.senl.addons.base.common;

import androidx.exifinterface.media.ExifInterface;
import com.samsung.android.support.senl.addons.base.common.IObservable;
import com.samsung.android.support.senl.addons.base.common.IObservable.Observer;
import com.sec.spp.push.Config;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m13885d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\b&\u0018\u0000 \u0018*\u0004\b\u0000\u0010\u0001*\u000e\b\u0001\u0010\u0002*\b\u0012\u0002\b\u0003\u0018\u00010\u00032\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\u0004:\u0002\u0018\u0019B\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00018\u0001H\u0016¢\u0006\u0002\u0010\fJ\u0017\u0010\r\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00018\u0001H\u0016¢\u0006\u0002\u0010\fJ\u0016\u0010\u000e\u001a\u00020\n2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u0010H\u0016J\u0017\u0010\u0011\u001a\u00020\n2\b\u0010\u0012\u001a\u0004\u0018\u00018\u0000H\u0016¢\u0006\u0002\u0010\u0013J\b\u0010\u0011\u001a\u00020\nH\u0016J\b\u0010\u0014\u001a\u00020\nH\u0016J2\u0010\u0015\u001a\u001e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0016R\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00002\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u0010H$J3\u0010\u0015\u001a\u001e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0016R\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00002\b\u0010\u0012\u001a\u0004\u0018\u00018\u0000H$¢\u0006\u0002\u0010\u0017J$\u0010\u0015\u001a\u001e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0016R\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0000H$R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001a"}, m13886d2 = {"Lcom/samsung/android/support/senl/addons/base/common/AbsObservable;", ExifInterface.LONGITUDE_EAST, "T", "Lcom/samsung/android/support/senl/addons/base/common/IObservable$Observer;", "Lcom/samsung/android/support/senl/addons/base/common/IObservable;", "<init>", "()V", "mObservable", "Ljava/beans/PropertyChangeSupport;", "addObserver", "", AbsObservable.OLD_VALUE, "(Lcom/samsung/android/support/senl/addons/base/common/IObservable$Observer;)V", "removeObserver", "notifyChangedData", "data", "Lcom/samsung/android/support/senl/addons/base/common/IObservable$InfoData;", "notifyChanged", "type", "(Ljava/lang/Object;)V", "release", "createInfo", "Lcom/samsung/android/support/senl/addons/base/common/AbsObservable$Info;", "(Ljava/lang/Object;)Lcom/samsung/android/support/senl/addons/base/common/AbsObservable$Info;", "Companion", "Info", "ntAddons_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public abstract class AbsObservable<E, T extends IObservable.Observer<?>> implements IObservable<E, T> {

    @NotNull
    private static final String OLD_VALUE = "observer";

    @NotNull
    private final PropertyChangeSupport mObservable = new PropertyChangeSupport(this);

    @NotNull
    public abstract AbsObservable<E, T>.Info<E, T> createInfo();

    @NotNull
    public abstract AbsObservable<E, T>.Info<E, T> createInfo(@NotNull IObservable.InfoData<E> data);

    @NotNull
    public abstract AbsObservable<E, T>.Info<E, T> createInfo(@Nullable E type);

    @Override // com.samsung.android.support.senl.addons.base.common.IObservable
    public void notifyChanged(@Nullable E type) {
        this.mObservable.firePropertyChange(String.valueOf(createInfo(type).getId()), OLD_VALUE, createInfo(type));
    }

    public void notifyChangedData(@NotNull IObservable.InfoData<E> data) {
        Intrinsics.checkNotNullParameter(data, "data");
        this.mObservable.firePropertyChange(String.valueOf(createInfo((IObservable.InfoData) data).getId()), OLD_VALUE, createInfo((IObservable.InfoData) data));
    }

    @Override // com.samsung.android.support.senl.addons.base.common.IObservable
    public void release() {
        PropertyChangeListener[] propertyChangeListeners = this.mObservable.getPropertyChangeListeners();
        Intrinsics.checkNotNullExpressionValue(propertyChangeListeners, "getPropertyChangeListeners(...)");
        for (PropertyChangeListener propertyChangeListener : propertyChangeListeners) {
            this.mObservable.removePropertyChangeListener(propertyChangeListener);
        }
    }

    @Override // com.samsung.android.support.senl.addons.base.common.IObservable
    public void addObserver(@Nullable T observer) {
        this.mObservable.addPropertyChangeListener(observer);
    }

    public void notifyChanged() {
        this.mObservable.firePropertyChange(String.valueOf(createInfo().getId()), OLD_VALUE, createInfo());
    }

    @Override // com.samsung.android.support.senl.addons.base.common.IObservable
    public void removeObserver(@Nullable T observer) {
        this.mObservable.removePropertyChangeListener(observer);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0096\u0004\u0018\u0000*\u0004\b\u0002\u0010\u0001*\u000e\b\u0003\u0010\u0002*\b\u0012\u0002\b\u0003\u0018\u00010\u00032\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\u0004B\u001f\b\u0016\u0012\u0014\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u0003\u0018\u00010\u0006¢\u0006\u0004\b\u0007\u0010\bB9\b\u0016\u0012\u0014\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u0003\u0018\u00010\u0006\u0012\b\u0010\t\u001a\u0004\u0018\u00018\u0002\u0012\u000e\u0010\n\u001a\n\u0012\u0004\u0012\u00028\u0002\u0018\u00010\u000b¢\u0006\u0004\b\u0007\u0010\fJ\u000f\u0010\u0014\u001a\u0004\u0018\u00018\u0002H\u0016¢\u0006\u0002\u0010\u0015J\n\u0010\u0016\u001a\u0004\u0018\u00010\u0013H\u0016R:\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u0003\u0018\u00010\u00062\u0014\u0010\r\u001a\u0010\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u0003\u0018\u00010\u0006@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0012\u0010\u0010\u001a\u0004\u0018\u00018\u0002X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0011R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0017"}, m13886d2 = {"Lcom/samsung/android/support/senl/addons/base/common/AbsObservable$Info;", "E2", "T2", "Lcom/samsung/android/support/senl/addons/base/common/IObservable$Observer;", "Lcom/samsung/android/support/senl/addons/base/common/IObservable$Info;", Config.NOTIFICATION_INTENT_SENDER, "Lcom/samsung/android/support/senl/addons/base/common/IObservable;", "<init>", "(Lcom/samsung/android/support/senl/addons/base/common/AbsObservable;Lcom/samsung/android/support/senl/addons/base/common/IObservable;)V", "type", "data", "Lcom/samsung/android/support/senl/addons/base/common/IObservable$InfoData;", "(Lcom/samsung/android/support/senl/addons/base/common/AbsObservable;Lcom/samsung/android/support/senl/addons/base/common/IObservable;Ljava/lang/Object;Lcom/samsung/android/support/senl/addons/base/common/IObservable$InfoData;)V", "value", "getSender", "()Lcom/samsung/android/support/senl/addons/base/common/IObservable;", "mType", "Ljava/lang/Object;", "mData", "", "getId", "()Ljava/lang/Object;", "getData", "ntAddons_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public class Info<E2, T2 extends IObservable.Observer<?>> implements IObservable.Info<E2, T2> {

        @Nullable
        private Object mData;

        @Nullable
        private E2 mType;

        @Nullable
        private IObservable<E2, T2> sender;

        public Info(@Nullable IObservable<E2, T2> iObservable) {
            this.mData = Boolean.FALSE;
            this.sender = iObservable;
        }

        @Override // com.samsung.android.support.senl.addons.base.common.IObservable.InfoData
        @Nullable
        /* JADX INFO: renamed from: getData, reason: from getter */
        public Object getMData() {
            return this.mData;
        }

        @Override // com.samsung.android.support.senl.addons.base.common.IObservable.InfoData
        @Nullable
        public E2 getId() {
            return this.mType;
        }

        @Override // com.samsung.android.support.senl.addons.base.common.IObservable.Info
        @Nullable
        public final IObservable<E2, T2> getSender() {
            return this.sender;
        }

        public Info(@Nullable IObservable<E2, T2> iObservable, @Nullable E2 e2, @Nullable IObservable.InfoData<E2> infoData) {
            this.mData = Boolean.FALSE;
            this.sender = iObservable;
            if (e2 != null) {
                this.mType = e2;
            } else {
                this.mType = infoData != null ? infoData.getId() : null;
                this.mData = infoData != null ? infoData.getMData() : null;
            }
        }
    }
}
