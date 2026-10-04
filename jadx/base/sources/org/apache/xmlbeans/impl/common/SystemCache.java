package org.apache.xmlbeans.impl.common;

import java.lang.ref.SoftReference;
import kotlin.collections.AbstractC12991c;
import org.apache.xmlbeans.SchemaTypeLoader;
import org.apache.xmlbeans.SystemProperties;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class SystemCache {
    private static SystemCache INSTANCE;
    private ThreadLocal tl_saxLoaders = new ThreadLocal();

    static {
        Object objNewInstance;
        INSTANCE = new SystemCache();
        String property = SystemProperties.getProperty("xmlbean.systemcacheimpl");
        if (property != null) {
            try {
                objNewInstance = Class.forName(property).newInstance();
                if (!(objNewInstance instanceof SystemCache)) {
                    StringBuffer stringBuffer = new StringBuffer("Value for system property \"xmlbean.systemcacheimpl\" points to a class (");
                    stringBuffer.append(property);
                    stringBuffer.append(") which does not derive from SystemCache");
                    throw new ClassCastException(stringBuffer.toString());
                }
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(AbstractC12991c.m13990k("Cache class ", property, " specified by \"xmlbean.systemcacheimpl\" was not found."), e);
            } catch (IllegalAccessException e2) {
                throw new RuntimeException(AbstractC12991c.m13990k("Could not instantiate class ", property, " as specified by \"xmlbean.systemcacheimpl\". A public empty constructor may be missing."), e2);
            } catch (InstantiationException e3) {
                throw new RuntimeException(AbstractC12991c.m13990k("Could not instantiate class ", property, " as specified by \"xmlbean.systemcacheimpl\". An empty constructor may be missing."), e3);
            }
        } else {
            objNewInstance = null;
        }
        if (objNewInstance != null) {
            INSTANCE = (SystemCache) objNewInstance;
        }
    }

    public static final SystemCache get() {
        return INSTANCE;
    }

    public static final synchronized void set(SystemCache systemCache) {
        INSTANCE = systemCache;
    }

    public SchemaTypeLoader getFromTypeLoaderCache(ClassLoader classLoader) {
        return null;
    }

    public Object getSaxLoader() {
        SoftReference softReference = (SoftReference) this.tl_saxLoaders.get();
        if (softReference == null) {
            return null;
        }
        return softReference.get();
    }

    public void setSaxLoader(Object obj) {
        this.tl_saxLoaders.set(new SoftReference(obj));
    }

    public void addToTypeLoaderCache(SchemaTypeLoader schemaTypeLoader, ClassLoader classLoader) {
    }
}
