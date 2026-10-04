package org.apache.commons.beanutils;

import java.lang.reflect.InvocationTargetException;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class ConvertingWrapDynaBean extends WrapDynaBean {
    private static final long serialVersionUID = 1;

    public ConvertingWrapDynaBean(Object obj) {
        super(obj);
    }

    @Override // org.apache.commons.beanutils.WrapDynaBean, org.apache.commons.beanutils.DynaBean
    public void set(String str, Object obj) {
        try {
            BeanUtils.copyProperty(this.instance, str, obj);
        } catch (InvocationTargetException e) {
            throw new IllegalArgumentException("Error setting property '" + str + "' nested exception - " + e.getTargetException());
        } catch (Throwable th) {
            throw new IllegalArgumentException("Error setting property '" + str + "', exception - " + th, th);
        }
    }
}
