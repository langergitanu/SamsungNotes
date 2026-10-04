package org.apache.commons.beanutils;

import java.lang.reflect.InvocationTargetException;
import org.apache.commons.collections.Predicate;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class BeanPropertyValueEqualsPredicate implements Predicate {
    private final boolean ignoreNull;
    private final Log log;
    private final String propertyName;
    private final Object propertyValue;

    public BeanPropertyValueEqualsPredicate(String str, Object obj) {
        this(str, obj, false);
    }

    @Override // org.apache.commons.collections.Predicate
    public boolean evaluate(Object obj) {
        try {
            return evaluateValue(this.propertyValue, PropertyUtils.getProperty(obj, this.propertyName));
        } catch (IllegalAccessException e) {
            throw new IllegalArgumentException("Unable to access the property provided.", e);
        } catch (IllegalArgumentException e2) {
            if (!this.ignoreNull) {
                throw new IllegalArgumentException("Problem during evaluation. Null value encountered in property path...", e2);
            }
            this.log.warn("WARNING: Problem during evaluation. Null value encountered in property path..." + e2);
            return false;
        } catch (NoSuchMethodException e3) {
            throw new IllegalArgumentException("Property not found.", e3);
        } catch (InvocationTargetException e5) {
            throw new IllegalArgumentException("Exception occurred in property's getter", e5);
        }
    }

    public boolean evaluateValue(Object obj, Object obj2) {
        if (obj != obj2) {
            return obj != null && obj.equals(obj2);
        }
        return true;
    }

    public String getPropertyName() {
        return this.propertyName;
    }

    public Object getPropertyValue() {
        return this.propertyValue;
    }

    public boolean isIgnoreNull() {
        return this.ignoreNull;
    }

    public BeanPropertyValueEqualsPredicate(String str, Object obj, boolean z) {
        this.log = LogFactory.getLog(getClass());
        if (str == null || str.length() <= 0) {
            throw new IllegalArgumentException("propertyName cannot be null or empty");
        }
        this.propertyName = str;
        this.propertyValue = obj;
        this.ignoreNull = z;
    }
}
