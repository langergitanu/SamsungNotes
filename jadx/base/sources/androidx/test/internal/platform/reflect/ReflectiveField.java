package androidx.test.internal.platform.reflect;

import androidx.annotation.RestrictTo;
import java.lang.reflect.Field;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class ReflectiveField<T> {
    private final String className;
    private final Class<?> clazz;
    private Field field;
    private final String fieldName;
    private boolean initialized;

    public ReflectiveField(String str, String str2) {
        this.initialized = false;
        this.clazz = null;
        this.className = str;
        this.fieldName = str2;
    }

    private Class<?> getClazz() {
        Class<?> cls = this.clazz;
        return cls == null ? Class.forName(this.className) : cls;
    }

    private synchronized void initIfNecessary() {
        if (this.initialized) {
            return;
        }
        Field declaredField = getClazz().getDeclaredField(this.fieldName);
        this.field = declaredField;
        declaredField.setAccessible(true);
        this.initialized = true;
    }

    public T get(Object obj) throws ReflectionException {
        try {
            initIfNecessary();
            return (T) this.field.get(obj);
        } catch (ClassNotFoundException e) {
            throw new ReflectionException(e);
        } catch (IllegalAccessException e2) {
            throw new ReflectionException(e2);
        } catch (NoSuchFieldException e3) {
            throw new ReflectionException(e3);
        }
    }

    public ReflectiveField(Class<?> cls, String str) {
        this.initialized = false;
        this.clazz = cls;
        this.className = null;
        this.fieldName = str;
    }
}
