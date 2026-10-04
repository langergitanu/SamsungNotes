package org.apache.commons.beanutils;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
@Deprecated
public class DynaBeanMapDecorator extends BaseDynaBeanMapDecorator<Object> {
    public DynaBeanMapDecorator(DynaBean dynaBean) {
        super(dynaBean);
    }

    public DynaBeanMapDecorator(DynaBean dynaBean, boolean z) {
        super(dynaBean, z);
    }

    @Override // org.apache.commons.beanutils.BaseDynaBeanMapDecorator
    public Object convertKey(String str) {
        return str;
    }
}
