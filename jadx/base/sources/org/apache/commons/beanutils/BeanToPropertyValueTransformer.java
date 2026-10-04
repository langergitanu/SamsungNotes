package org.apache.commons.beanutils;

import androidx.collection.AbstractC0622a;
import java.lang.reflect.InvocationTargetException;
import org.apache.commons.collections.Transformer;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class BeanToPropertyValueTransformer implements Transformer {
    private final boolean ignoreNull;
    private final Log log;
    private final String propertyName;

    public BeanToPropertyValueTransformer(String str) {
        this(str, false);
    }

    public String getPropertyName() {
        return this.propertyName;
    }

    public boolean isIgnoreNull() {
        return this.ignoreNull;
    }

    @Override // org.apache.commons.collections.Transformer
    public Object transform(Object obj) {
        try {
            return PropertyUtils.getProperty(obj, this.propertyName);
        } catch (IllegalAccessException e) {
            throw new IllegalArgumentException("Unable to access the property provided.", e);
        } catch (IllegalArgumentException e2) {
            if (!this.ignoreNull) {
                throw new IllegalArgumentException("Problem during transformation. Null value encountered in property path...", e2);
            }
            this.log.warn("WARNING: Problem during transformation. Null value encountered in property path..." + e2);
            return null;
        } catch (NoSuchMethodException e3) {
            throw new IllegalArgumentException(AbstractC0622a.m1170p(this.propertyName, "]", new StringBuilder("No property found for name [")), e3);
        } catch (InvocationTargetException e5) {
            throw new IllegalArgumentException("Exception occurred in property's getter", e5);
        }
    }

    public BeanToPropertyValueTransformer(String str, boolean z) {
        this.log = LogFactory.getLog(getClass());
        if (str == null || str.length() <= 0) {
            throw new IllegalArgumentException("propertyName cannot be null or empty");
        }
        this.propertyName = str;
        this.ignoreNull = z;
    }
}
