package com.samsung.android.support.senl.addons.base.model.common;

import com.samsung.android.support.senl.addons.base.common.IObservable;
import com.samsung.android.support.senl.ntnl.coedit.constants.CoeditServiceConstants;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m13885d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0002\u0004\u0005¨\u0006\u0006"}, m13886d2 = {"Lcom/samsung/android/support/senl/addons/base/model/common/IBaseModel;", "Lcom/samsung/android/support/senl/addons/base/common/IObservable;", "", "Lcom/samsung/android/support/senl/addons/base/model/common/IBaseModel$Observer;", "Info", "Observer", "ntAddons_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public interface IBaseModel extends IObservable<Integer, Observer> {

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001¨\u0006\u0004"}, m13886d2 = {"Lcom/samsung/android/support/senl/addons/base/model/common/IBaseModel$Info;", "Lcom/samsung/android/support/senl/addons/base/common/IObservable$Info;", "", "Lcom/samsung/android/support/senl/addons/base/model/common/IBaseModel$Observer;", "ntAddons_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public interface Info extends IObservable.Info<Integer, Observer> {
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0000\b&\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0014\u0010\u0005\u001a\u0004\u0018\u00010\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016¨\u0006\b"}, m13886d2 = {"Lcom/samsung/android/support/senl/addons/base/model/common/IBaseModel$Observer;", "Lcom/samsung/android/support/senl/addons/base/common/IObservable$Observer;", "Lcom/samsung/android/support/senl/addons/base/model/common/IBaseModel$Info;", "<init>", "()V", "cast", CoeditServiceConstants.Element.NAME_OBJECT, "", "ntAddons_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static abstract class Observer extends IObservable.Observer<Info> {
        @Override // com.samsung.android.support.senl.addons.base.common.IObservable.Observer
        @Nullable
        public Info cast(@Nullable Object object) {
            if (object instanceof Info) {
                return (Info) object;
            }
            return null;
        }
    }
}
