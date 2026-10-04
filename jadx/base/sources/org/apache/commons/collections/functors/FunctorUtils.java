package org.apache.commons.collections.functors;

import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.Collection;
import java.util.Iterator;
import org.apache.commons.collections.Closure;
import org.apache.commons.collections.Predicate;
import org.apache.commons.collections.Transformer;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
class FunctorUtils {
    static final String UNSAFE_SERIALIZABLE_PROPERTY = "org.apache.commons.collections.enableUnsafeSerialization";

    private FunctorUtils() {
    }

    public static void checkUnsafeSerialization(Class cls) {
        String str;
        try {
            str = (String) AccessController.doPrivileged(new PrivilegedAction() { // from class: org.apache.commons.collections.functors.FunctorUtils.1
                @Override // java.security.PrivilegedAction
                public Object run() {
                    return System.getProperty(FunctorUtils.UNSAFE_SERIALIZABLE_PROPERTY);
                }
            });
        } catch (SecurityException unused) {
            str = null;
        }
        if ("true".equalsIgnoreCase(str)) {
            return;
        }
        StringBuffer stringBuffer = new StringBuffer("Serialization support for ");
        stringBuffer.append(cls.getName());
        stringBuffer.append(" is disabled for security reasons. To enable it set system property 'org.apache.commons.collections.enableUnsafeSerialization' to 'true', but you must ensure that your application does not de-serialize objects from untrusted sources.");
        throw new UnsupportedOperationException(stringBuffer.toString());
    }

    public static Predicate[] copy(Predicate[] predicateArr) {
        if (predicateArr == null) {
            return null;
        }
        return (Predicate[]) predicateArr.clone();
    }

    public static void validate(Predicate[] predicateArr) {
        if (predicateArr == null) {
            throw new IllegalArgumentException("The predicate array must not be null");
        }
        for (int i = 0; i < predicateArr.length; i++) {
            if (predicateArr[i] == null) {
                StringBuffer stringBuffer = new StringBuffer("The predicate array must not contain a null predicate, index ");
                stringBuffer.append(i);
                stringBuffer.append(" was null");
                throw new IllegalArgumentException(stringBuffer.toString());
            }
        }
    }

    public static Closure[] copy(Closure[] closureArr) {
        if (closureArr == null) {
            return null;
        }
        return (Closure[]) closureArr.clone();
    }

    public static Transformer[] copy(Transformer[] transformerArr) {
        if (transformerArr == null) {
            return null;
        }
        return (Transformer[]) transformerArr.clone();
    }

    public static Predicate[] validate(Collection collection) {
        if (collection != null) {
            Predicate[] predicateArr = new Predicate[collection.size()];
            Iterator it = collection.iterator();
            int i = 0;
            while (it.hasNext()) {
                Predicate predicate = (Predicate) it.next();
                predicateArr[i] = predicate;
                if (predicate == null) {
                    StringBuffer stringBuffer = new StringBuffer("The predicate collection must not contain a null predicate, index ");
                    stringBuffer.append(i);
                    stringBuffer.append(" was null");
                    throw new IllegalArgumentException(stringBuffer.toString());
                }
                i++;
            }
            return predicateArr;
        }
        throw new IllegalArgumentException("The predicate collection must not be null");
    }

    public static void validate(Closure[] closureArr) {
        if (closureArr != null) {
            for (int i = 0; i < closureArr.length; i++) {
                if (closureArr[i] == null) {
                    StringBuffer stringBuffer = new StringBuffer("The closure array must not contain a null closure, index ");
                    stringBuffer.append(i);
                    stringBuffer.append(" was null");
                    throw new IllegalArgumentException(stringBuffer.toString());
                }
            }
            return;
        }
        throw new IllegalArgumentException("The closure array must not be null");
    }

    public static void validate(Transformer[] transformerArr) {
        if (transformerArr != null) {
            for (int i = 0; i < transformerArr.length; i++) {
                if (transformerArr[i] == null) {
                    StringBuffer stringBuffer = new StringBuffer("The transformer array must not contain a null transformer, index ");
                    stringBuffer.append(i);
                    stringBuffer.append(" was null");
                    throw new IllegalArgumentException(stringBuffer.toString());
                }
            }
            return;
        }
        throw new IllegalArgumentException("The transformer array must not be null");
    }
}
