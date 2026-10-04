package org.apache.commons.collections.functors;

import java.io.Serializable;
import org.apache.commons.collections.Factory;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class ConstantFactory implements Factory, Serializable {
    public static final Factory NULL_INSTANCE = new ConstantFactory(null);
    private static final long serialVersionUID = -3520677225766901240L;
    private final Object iConstant;

    public ConstantFactory(Object obj) {
        this.iConstant = obj;
    }

    public static Factory getInstance(Object obj) {
        return obj == null ? NULL_INSTANCE : new ConstantFactory(obj);
    }

    @Override // org.apache.commons.collections.Factory
    public Object create() {
        return this.iConstant;
    }

    public Object getConstant() {
        return this.iConstant;
    }
}
