package org.apache.commons.beanutils;

import java.lang.reflect.InvocationTargetException;
import org.apache.commons.collections.Predicate;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class BeanPredicate implements Predicate {
    private final Log log = LogFactory.getLog(getClass());
    private Predicate predicate;
    private String propertyName;

    public BeanPredicate(String str, Predicate predicate) {
        this.propertyName = str;
        this.predicate = predicate;
    }

    @Override // org.apache.commons.collections.Predicate
    public boolean evaluate(Object obj) {
        try {
            return this.predicate.evaluate(PropertyUtils.getProperty(obj, this.propertyName));
        } catch (IllegalAccessException e) {
            this.log.error("Unable to access the property provided.", e);
            throw new IllegalArgumentException("Unable to access the property provided.");
        } catch (IllegalArgumentException e2) {
            this.log.error("ERROR: Problem during evaluation.", e2);
            throw e2;
        } catch (NoSuchMethodException e3) {
            this.log.error("Property not found.", e3);
            throw new IllegalArgumentException("Property not found.");
        } catch (InvocationTargetException e5) {
            this.log.error("Exception occurred in property's getter", e5);
            throw new IllegalArgumentException("Exception occurred in property's getter");
        }
    }

    public Predicate getPredicate() {
        return this.predicate;
    }

    public String getPropertyName() {
        return this.propertyName;
    }

    public void setPredicate(Predicate predicate) {
        this.predicate = predicate;
    }

    public void setPropertyName(String str) {
        this.propertyName = str;
    }
}
