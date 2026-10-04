package org.junit.runners.model;

import java.lang.reflect.Modifier;
import java.util.List;
import org.junit.runners.model.FrameworkMember;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes11.dex */
public abstract class FrameworkMember<T extends FrameworkMember<T>> implements Annotatable {
    public abstract Class<?> getDeclaringClass();

    public abstract int getModifiers();

    public abstract String getName();

    public abstract Class<?> getType();

    public T handlePossibleBridgeMethod(List<T> list) {
        for (int size = list.size() - 1; size >= 0; size--) {
            T t = list.get(size);
            if (isShadowedBy(t)) {
                if (!t.isBridgeMethod()) {
                    return null;
                }
                list.remove(size);
                return t;
            }
        }
        return this;
    }

    public abstract boolean isBridgeMethod();

    public boolean isPublic() {
        return Modifier.isPublic(getModifiers());
    }

    public abstract boolean isShadowedBy(T t);

    public boolean isStatic() {
        return Modifier.isStatic(getModifiers());
    }
}
