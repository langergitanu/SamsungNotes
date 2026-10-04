package androidx.appsearch.app;

import androidx.annotation.AnyThread;
import androidx.annotation.RestrictTo;
import androidx.appcompat.widget.AbstractC0541b;
import androidx.appsearch.exceptions.AppSearchException;
import androidx.core.util.Preconditions;
import com.samsung.android.support.senl.p145cm.base.common.constants.Extension;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@AnyThread
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public final class DocumentClassFactoryRegistry {
    private static final String GEN_CLASS_PREFIX = "$$__AppSearch__";
    private static volatile DocumentClassFactoryRegistry sInstance;
    private final Map<Class<?>, DocumentClassFactory<?>> mFactories = new HashMap();

    private DocumentClassFactoryRegistry() {
    }

    public static DocumentClassFactoryRegistry getInstance() {
        if (sInstance == null) {
            synchronized (DocumentClassFactoryRegistry.class) {
                try {
                    if (sInstance == null) {
                        sInstance = new DocumentClassFactoryRegistry();
                    }
                } finally {
                }
            }
        }
        return sInstance;
    }

    private DocumentClassFactory<?> loadFactoryByReflection(Class<?> cls) throws AppSearchException {
        String str;
        Package r02 = cls.getPackage();
        String canonicalName = cls.getCanonicalName();
        if (canonicalName == null) {
            throw new AppSearchException(2, AbstractC0541b.m768j(cls, "Failed to find simple name for document class \"", "\". Perhaps it is anonymous?"));
        }
        if (r02 != null) {
            str = r02.getName() + Extension.DOT;
            canonicalName = canonicalName.substring(str.length()).replace(Extension.DOT, "$$__");
        } else {
            str = "";
        }
        String strM757C = AbstractC0541b.m757C(str, GEN_CLASS_PREFIX, canonicalName);
        try {
            try {
                return (DocumentClassFactory) Class.forName(strM757C).getDeclaredConstructor(null).newInstance(null);
            } catch (Exception e) {
                throw new AppSearchException(2, AbstractC0541b.m773o("Failed to construct document class converter \"", strM757C, "\""), e);
            }
        } catch (ClassNotFoundException e2) {
            Class<? super Object> superclass = cls.getSuperclass();
            Class<?>[] interfaces = cls.getInterfaces();
            Class<? super Object> cls2 = superclass != Object.class ? superclass : null;
            int length = interfaces.length;
            if (cls2 != null) {
                length++;
            }
            if (length == 1) {
                return cls2 != null ? loadFactoryByReflection(cls2) : loadFactoryByReflection(interfaces[0]);
            }
            String strM773o = AbstractC0541b.m773o("Failed to find document class converter \"", strM757C, "\". Perhaps the annotation processor was not run or the class was proguarded out?");
            if (length > 1) {
                strM773o = AbstractC0541b.m756B(strM773o, " Or, this class may not have been annotated with @Document, and there is an ambiguity to determine a unique @Document annotated parent class/interface.");
            }
            throw new AppSearchException(2, strM773o, e2);
        }
    }

    public <T> DocumentClassFactory<T> getOrCreateFactory(Class<T> cls) {
        DocumentClassFactory<T> documentClassFactory;
        Preconditions.checkNotNull(cls);
        synchronized (this) {
            documentClassFactory = (DocumentClassFactory) this.mFactories.get(cls);
        }
        if (documentClassFactory != null) {
            return documentClassFactory;
        }
        DocumentClassFactory<?> documentClassFactory2 = (DocumentClassFactory<T>) loadFactoryByReflection(cls);
        synchronized (this) {
            try {
                DocumentClassFactory<?> documentClassFactory3 = this.mFactories.get(cls);
                if (documentClassFactory3 == null) {
                    this.mFactories.put((Class<?>) cls, documentClassFactory2);
                } else {
                    documentClassFactory2 = (DocumentClassFactory<T>) documentClassFactory3;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return (DocumentClassFactory<T>) documentClassFactory2;
    }

    public <T> DocumentClassFactory<T> getOrCreateFactory(T t) {
        Preconditions.checkNotNull(t);
        return getOrCreateFactory((Class) t.getClass());
    }
}
