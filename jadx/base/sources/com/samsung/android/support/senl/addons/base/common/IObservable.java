package com.samsung.android.support.senl.addons.base.common;

import androidx.exifinterface.media.ExifInterface;
import com.samsung.android.support.senl.ntnl.coedit.constants.CoeditServiceConstants;
import com.sec.spp.push.Config;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m13885d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u000b\bf\u0018\u0000*\u0004\b\u0000\u0010\u0001*\n\b\u0001\u0010\u0002*\u0004\u0018\u00010\u00032\u00020\u0004:\u0003\u000e\u000f\u0010J\u0017\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00018\u0001H&¢\u0006\u0002\u0010\bJ\u0017\u0010\t\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00018\u0001H&¢\u0006\u0002\u0010\bJ\u0017\u0010\n\u001a\u00020\u00062\b\u0010\u000b\u001a\u0004\u0018\u00018\u0000H&¢\u0006\u0002\u0010\fJ\b\u0010\r\u001a\u00020\u0006H&¨\u0006\u0011"}, m13886d2 = {"Lcom/samsung/android/support/senl/addons/base/common/IObservable;", ExifInterface.LONGITUDE_EAST, "T", "Ljava/beans/PropertyChangeListener;", "", "addObserver", "", "observer", "(Ljava/beans/PropertyChangeListener;)V", "removeObserver", "notifyChanged", "type", "(Ljava/lang/Object;)V", "release", "Info", "InfoData", "Observer", "ntAddons_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public interface IObservable<E, T extends PropertyChangeListener> {

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u0000*\u0004\b\u0002\u0010\u0001*\n\b\u0003\u0010\u0002*\u0004\u0018\u00010\u00032\b\u0012\u0004\u0012\u0002H\u00010\u0004R \u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u0003\u0018\u00010\u0006X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, m13886d2 = {"Lcom/samsung/android/support/senl/addons/base/common/IObservable$Info;", ExifInterface.LONGITUDE_EAST, "T", "Ljava/beans/PropertyChangeListener;", "Lcom/samsung/android/support/senl/addons/base/common/IObservable$InfoData;", Config.NOTIFICATION_INTENT_SENDER, "Lcom/samsung/android/support/senl/addons/base/common/IObservable;", "getSender", "()Lcom/samsung/android/support/senl/addons/base/common/IObservable;", "ntAddons_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public interface Info<E, T extends PropertyChangeListener> extends InfoData<E> {
        @Nullable
        IObservable<E, T> getSender();
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\bf\u0018\u0000*\u0004\b\u0002\u0010\u00012\u00020\u0002J\u000f\u0010\u0003\u001a\u0004\u0018\u00018\u0002H&¢\u0006\u0002\u0010\u0004J\n\u0010\u0005\u001a\u0004\u0018\u00010\u0002H&¨\u0006\u0006"}, m13886d2 = {"Lcom/samsung/android/support/senl/addons/base/common/IObservable$InfoData;", ExifInterface.LONGITUDE_EAST, "", "getId", "()Ljava/lang/Object;", "getData", "ntAddons_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public interface InfoData<E> {
        @Nullable
        /* JADX INFO: renamed from: getData */
        Object getMData();

        @Nullable
        E getId();
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b&\u0018\u0000*\u0012\b\u0002\u0010\u0001*\f\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0018\u00010\u00022\u00020\u0003B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u0015\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00028\u0002H&¢\u0006\u0002\u0010\tJ\u0017\u0010\n\u001a\u00028\u00022\b\u0010\u000b\u001a\u0004\u0018\u00010\fH$¢\u0006\u0002\u0010\rJ\u0010\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u0010H\u0016¨\u0006\u0011"}, m13886d2 = {"Lcom/samsung/android/support/senl/addons/base/common/IObservable$Observer;", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "Lcom/samsung/android/support/senl/addons/base/common/IObservable$Info;", "Ljava/beans/PropertyChangeListener;", "<init>", "()V", "onUpdate", "", "info", "(Lcom/samsung/android/support/senl/addons/base/common/IObservable$Info;)V", "cast", CoeditServiceConstants.Element.NAME_OBJECT, "", "(Ljava/lang/Object;)Lcom/samsung/android/support/senl/addons/base/common/IObservable$Info;", "propertyChange", "evt", "Ljava/beans/PropertyChangeEvent;", "ntAddons_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    @SourceDebugExtension({"SMAP\nIObservable.kt\nKotlin\n*S Kotlin\n*F\n+ 1 IObservable.kt\ncom/samsung/android/support/senl/addons/base/common/IObservable$Observer\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,30:1\n1#2:31\n*E\n"})
    public static abstract class Observer<V extends Info<?, ?>> implements PropertyChangeListener {
        public abstract V cast(@Nullable Object object);

        public abstract void onUpdate(V info);

        @Override // java.beans.PropertyChangeListener
        public void propertyChange(@NotNull PropertyChangeEvent evt) {
            Intrinsics.checkNotNullParameter(evt, "evt");
            Info infoCast = cast(evt.getNewValue());
            if (infoCast != null) {
                onUpdate(infoCast);
            }
        }
    }

    void addObserver(@Nullable T observer);

    void notifyChanged(@Nullable E type);

    void release();

    void removeObserver(@Nullable T observer);
}
