package org.apache.commons.beanutils;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class DynaBeanPropertyMapDecorator extends BaseDynaBeanMapDecorator<String> {
    public DynaBeanPropertyMapDecorator(DynaBean dynaBean) {
        super(dynaBean);
    }

    @Override // org.apache.commons.beanutils.BaseDynaBeanMapDecorator
    public String convertKey(String str) {
        return str;
    }

    public DynaBeanPropertyMapDecorator(DynaBean dynaBean, boolean z) {
        super(dynaBean, z);
    }
}
