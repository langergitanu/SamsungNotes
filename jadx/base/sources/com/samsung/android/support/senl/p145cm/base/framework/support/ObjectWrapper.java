package com.samsung.android.support.senl.p145cm.base.framework.support;

import com.samsung.android.support.senl.ntnl.coedit.constants.CoeditServiceConstants;
import kotlin.Metadata;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(m13885d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0007\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\u0003\u001a\u00028\u0000¢\u0006\u0004\b\u0004\u0010\u0005R\u0013\u0010\u0003\u001a\u00028\u0000¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007¨\u0006\t"}, m13886d2 = {"Lcom/samsung/android/support/senl/cm/base/framework/support/ObjectWrapper;", "T", "", CoeditServiceConstants.Element.NAME_OBJECT, "<init>", "(Ljava/lang/Object;)V", "getObject", "()Ljava/lang/Object;", "Ljava/lang/Object;", "cmBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class ObjectWrapper<T> {
    private final T object;

    public ObjectWrapper(T t) {
        this.object = t;
    }

    public final T getObject() {
        return this.object;
    }
}
