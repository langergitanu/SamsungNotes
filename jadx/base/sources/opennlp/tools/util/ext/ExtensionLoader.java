package opennlp.tools.util.ext;

import androidx.appcompat.widget.AbstractC0541b;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import opennlp.tools.commons.Internal;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
@Internal
public class ExtensionLoader {
    private ExtensionLoader() {
    }

    public static <T> T instantiateExtension(Class<T> cls, String str) {
        try {
            Class<?> cls2 = Class.forName(str);
            if (!cls.isAssignableFrom(cls2)) {
                throw new ExtensionNotLoadedException("Extension class '" + cls2.getName() + "' needs to have type: " + cls.getName());
            }
            try {
                return (T) cls2.getDeclaredConstructor(null).newInstance(null);
            } catch (IllegalAccessException e) {
                try {
                    Field declaredField = cls2.getDeclaredField("INSTANCE");
                    if (declaredField == null) {
                        throw new ExtensionNotLoadedException(e);
                    }
                    try {
                        return (T) declaredField.get(null);
                    } catch (IllegalAccessException | IllegalArgumentException e2) {
                        throw new ExtensionNotLoadedException(e2);
                    }
                } catch (NoSuchFieldException e3) {
                    e = e3;
                    throw new ExtensionNotLoadedException(e);
                } catch (SecurityException e5) {
                    e = e5;
                    throw new ExtensionNotLoadedException(e);
                }
            } catch (InstantiationException e6) {
                e = e6;
                throw new ExtensionNotLoadedException(e);
            } catch (NoSuchMethodException e7) {
                e = e7;
                throw new ExtensionNotLoadedException(e);
            } catch (InvocationTargetException e8) {
                throw new RuntimeException(e8);
            }
        } catch (ClassNotFoundException unused) {
            throw new ExtensionNotLoadedException(AbstractC0541b.m775q("Unable to find implementation for ", cls.getName(), ", the class or service ", str, " could not be located!"));
        }
    }
}
