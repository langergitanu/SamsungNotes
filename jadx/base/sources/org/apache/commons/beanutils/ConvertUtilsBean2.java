package org.apache.commons.beanutils;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class ConvertUtilsBean2 extends ConvertUtilsBean {
    @Override // org.apache.commons.beanutils.ConvertUtilsBean
    public String convert(Object obj) {
        return (String) convert(obj, String.class);
    }

    @Override // org.apache.commons.beanutils.ConvertUtilsBean
    public Object convert(String str, Class<?> cls) {
        return convert((Object) str, cls);
    }

    @Override // org.apache.commons.beanutils.ConvertUtilsBean
    public Object convert(String[] strArr, Class<?> cls) {
        return convert((Object) strArr, cls);
    }
}
