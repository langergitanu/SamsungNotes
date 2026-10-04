package org.apache.commons.lang3.builder;

import java.util.Collection;
import org.apache.commons.lang3.ClassUtils;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class RecursiveToStringStyle extends ToStringStyle {
    private static final long serialVersionUID = 1;

    public boolean accept(Class<?> cls) {
        return true;
    }

    @Override // org.apache.commons.lang3.builder.ToStringStyle
    public void appendDetail(StringBuffer stringBuffer, String str, Collection<?> collection) {
        appendClassName(stringBuffer, collection);
        appendIdentityHashCode(stringBuffer, collection);
        appendDetail(stringBuffer, str, collection.toArray());
    }

    @Override // org.apache.commons.lang3.builder.ToStringStyle
    public void appendDetail(StringBuffer stringBuffer, String str, Object obj) {
        if (!ClassUtils.isPrimitiveWrapper(obj.getClass()) && !String.class.equals(obj.getClass()) && accept(obj.getClass())) {
            stringBuffer.append(ReflectionToStringBuilder.toString(obj, this));
        } else {
            super.appendDetail(stringBuffer, str, obj);
        }
    }
}
