package org.apache.poi.javax.imageio.metadata;

import androidx.appcompat.widget.AbstractC0541b;
import com.sun.imageio.plugins.common.StandardMetadataFormat;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.MissingResourceException;
import java.util.ResourceBundle;
import org.apache.poi.javax.imageio.ImageTypeSpecifier;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public abstract class IIOMetadataFormatImpl implements IIOMetadataFormat {
    private static IIOMetadataFormat standardFormat = null;
    public static final String standardMetadataFormatName = "javax_imageio_1.0";
    private String rootName;
    private String resourceBaseName = getClass().getName().concat("Resources");
    private HashMap elementMap = new HashMap();

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public class Attribute {
        String attrName;
        int dataType;
        List enumeratedValues;
        int listMaxLength;
        int listMinLength;
        String maxValue;
        String minValue;
        boolean required;
        int valueType = 1;
        String defaultValue = null;

        public Attribute() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public class Element {
        int childPolicy;
        String elementName;
        ObjectValue objectValue;
        int minChildren = 0;
        int maxChildren = 0;
        List childList = new ArrayList();
        List parentList = new ArrayList();
        List attrList = new ArrayList();
        Map attrMap = new HashMap();

        public Element() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public class ObjectValue {
        int valueType = 0;
        Class classType = null;
        Object defaultValue = null;
        List enumeratedValues = null;
        Comparable minValue = null;
        Comparable maxValue = null;
        int arrayMinLength = 0;
        int arrayMaxLength = 0;

        public ObjectValue() {
        }
    }

    public IIOMetadataFormatImpl(String str, int i) {
        if (str == null) {
            throw new IllegalArgumentException("rootName == null!");
        }
        if (i < 0 || i > 5 || i == 5) {
            throw new IllegalArgumentException("Invalid value for childPolicy!");
        }
        this.rootName = str;
        Element element = new Element();
        element.elementName = str;
        element.childPolicy = i;
        this.elementMap.put(str, element);
    }

    private static synchronized void createStandardFormat() {
        if (standardFormat == null) {
            standardFormat = new StandardMetadataFormat();
        }
    }

    private Attribute getAttribute(String str, String str2) {
        Attribute attribute = (Attribute) getElement(str).attrMap.get(str2);
        if (attribute != null) {
            return attribute;
        }
        throw new IllegalArgumentException(AbstractC0541b.m773o("No such attribute \"", str2, "\"!"));
    }

    private Element getElement(String str, boolean z) {
        if (z && str == null) {
            throw new IllegalArgumentException("element name is null!");
        }
        Element element = (Element) this.elementMap.get(str);
        if (z && element == null) {
            throw new IllegalArgumentException(AbstractC0541b.m772n("No such element: ", str));
        }
        return element;
    }

    private ObjectValue getObjectValue(String str) {
        ObjectValue objectValue = getElement(str).objectValue;
        if (objectValue != null) {
            return objectValue;
        }
        throw new IllegalArgumentException(AbstractC0541b.m773o("No object within element ", str, "!"));
    }

    private String getResource(String str, Locale locale) {
        ResourceBundle bundle;
        if (locale == null) {
            locale = Locale.getDefault();
        }
        try {
            try {
                bundle = ResourceBundle.getBundle(this.resourceBaseName, locale, (ClassLoader) AccessController.doPrivileged(new PrivilegedAction() { // from class: org.apache.poi.javax.imageio.metadata.IIOMetadataFormatImpl.1
                    @Override // java.security.PrivilegedAction
                    public Object run() {
                        return Thread.currentThread().getContextClassLoader();
                    }
                }));
            } catch (MissingResourceException unused) {
                bundle = ResourceBundle.getBundle(this.resourceBaseName, locale);
            }
            return bundle.getString(str);
        } catch (MissingResourceException unused2) {
            return null;
        }
    }

    public static IIOMetadataFormat getStandardFormatInstance() {
        createStandardFormat();
        return standardFormat;
    }

    public void addAttribute(String str, String str2, int i, boolean z, String str3) {
        Element element = getElement(str);
        if (str2 == null) {
            throw new IllegalArgumentException("attrName == null!");
        }
        if (i < 0 || i > 4) {
            throw new IllegalArgumentException("Invalid value for dataType!");
        }
        Attribute attribute = new Attribute();
        attribute.attrName = str2;
        attribute.valueType = 1;
        attribute.dataType = i;
        attribute.required = z;
        attribute.defaultValue = str3;
        element.attrList.add(str2);
        element.attrMap.put(str2, attribute);
    }

    public void addBooleanAttribute(String str, String str2, boolean z, boolean z2) {
        ArrayList arrayList = new ArrayList();
        String str3 = "TRUE";
        arrayList.add("TRUE");
        arrayList.add("FALSE");
        if (!z) {
            str3 = null;
        } else if (!z2) {
            str3 = "FALSE";
        }
        addAttribute(str, str2, 1, true, str3, (List<String>) arrayList);
    }

    public void addChildElement(String str, String str2) {
        Element element = getElement(str2);
        Element element2 = getElement(str);
        element.childList.add(str);
        element2.parentList.add(str2);
    }

    public void addElement(String str, String str2, int i) {
        Element element = getElement(str2);
        if (i < 0 || i > 5 || i == 5) {
            throw new IllegalArgumentException("Invalid value for childPolicy!");
        }
        Element element2 = new Element();
        element2.elementName = str;
        element2.childPolicy = i;
        element.childList.add(str);
        element2.parentList.add(str2);
        this.elementMap.put(str, element2);
    }

    public <T> void addObjectValue(String str, Class<T> cls, boolean z, T t) {
        Element element = getElement(str);
        ObjectValue objectValue = new ObjectValue();
        objectValue.valueType = 1;
        objectValue.classType = cls;
        objectValue.defaultValue = t;
        element.objectValue = objectValue;
    }

    @Override // org.apache.poi.javax.imageio.metadata.IIOMetadataFormat
    public abstract boolean canNodeAppear(String str, ImageTypeSpecifier imageTypeSpecifier);

    @Override // org.apache.poi.javax.imageio.metadata.IIOMetadataFormat
    public int getAttributeDataType(String str, String str2) {
        return getAttribute(str, str2).dataType;
    }

    @Override // org.apache.poi.javax.imageio.metadata.IIOMetadataFormat
    public String getAttributeDefaultValue(String str, String str2) {
        return getAttribute(str, str2).defaultValue;
    }

    @Override // org.apache.poi.javax.imageio.metadata.IIOMetadataFormat
    public String getAttributeDescription(String str, String str2, Locale locale) {
        Element element = getElement(str);
        if (str2 == null) {
            throw new IllegalArgumentException("attrName == null!");
        }
        if (((Attribute) element.attrMap.get(str2)) != null) {
            return getResource(AbstractC0541b.m757C(str, "/", str2), locale);
        }
        throw new IllegalArgumentException("No such attribute!");
    }

    @Override // org.apache.poi.javax.imageio.metadata.IIOMetadataFormat
    public String[] getAttributeEnumerations(String str, String str2) {
        Attribute attribute = getAttribute(str, str2);
        if (attribute.valueType != 16) {
            throw new IllegalArgumentException("Attribute not an enumeration!");
        }
        List list = attribute.enumeratedValues;
        list.iterator();
        return (String[]) list.toArray(new String[list.size()]);
    }

    @Override // org.apache.poi.javax.imageio.metadata.IIOMetadataFormat
    public int getAttributeListMaxLength(String str, String str2) {
        Attribute attribute = getAttribute(str, str2);
        if (attribute.valueType == 32) {
            return attribute.listMaxLength;
        }
        throw new IllegalArgumentException("Attribute not a list!");
    }

    @Override // org.apache.poi.javax.imageio.metadata.IIOMetadataFormat
    public int getAttributeListMinLength(String str, String str2) {
        Attribute attribute = getAttribute(str, str2);
        if (attribute.valueType == 32) {
            return attribute.listMinLength;
        }
        throw new IllegalArgumentException("Attribute not a list!");
    }

    @Override // org.apache.poi.javax.imageio.metadata.IIOMetadataFormat
    public String getAttributeMaxValue(String str, String str2) {
        Attribute attribute = getAttribute(str, str2);
        int i = attribute.valueType;
        if (i == 2 || i == 6 || i == 10 || i == 14) {
            return attribute.maxValue;
        }
        throw new IllegalArgumentException("Attribute not a range!");
    }

    @Override // org.apache.poi.javax.imageio.metadata.IIOMetadataFormat
    public String getAttributeMinValue(String str, String str2) {
        Attribute attribute = getAttribute(str, str2);
        int i = attribute.valueType;
        if (i == 2 || i == 6 || i == 10 || i == 14) {
            return attribute.minValue;
        }
        throw new IllegalArgumentException("Attribute not a range!");
    }

    @Override // org.apache.poi.javax.imageio.metadata.IIOMetadataFormat
    public String[] getAttributeNames(String str) {
        List list = getElement(str).attrList;
        return (String[]) list.toArray(new String[list.size()]);
    }

    @Override // org.apache.poi.javax.imageio.metadata.IIOMetadataFormat
    public int getAttributeValueType(String str, String str2) {
        return getAttribute(str, str2).valueType;
    }

    @Override // org.apache.poi.javax.imageio.metadata.IIOMetadataFormat
    public String[] getChildNames(String str) {
        Element element = getElement(str);
        if (element.childPolicy == 0) {
            return null;
        }
        return (String[]) element.childList.toArray(new String[0]);
    }

    @Override // org.apache.poi.javax.imageio.metadata.IIOMetadataFormat
    public int getChildPolicy(String str) {
        return getElement(str).childPolicy;
    }

    @Override // org.apache.poi.javax.imageio.metadata.IIOMetadataFormat
    public String getElementDescription(String str, Locale locale) {
        getElement(str);
        return getResource(str, locale);
    }

    @Override // org.apache.poi.javax.imageio.metadata.IIOMetadataFormat
    public int getElementMaxChildren(String str) {
        Element element = getElement(str);
        if (element.childPolicy == 5) {
            return element.maxChildren;
        }
        throw new IllegalArgumentException("Child policy not CHILD_POLICY_REPEAT!");
    }

    @Override // org.apache.poi.javax.imageio.metadata.IIOMetadataFormat
    public int getElementMinChildren(String str) {
        Element element = getElement(str);
        if (element.childPolicy == 5) {
            return element.minChildren;
        }
        throw new IllegalArgumentException("Child policy not CHILD_POLICY_REPEAT!");
    }

    @Override // org.apache.poi.javax.imageio.metadata.IIOMetadataFormat
    public int getObjectArrayMaxLength(String str) {
        ObjectValue objectValue = getObjectValue(str);
        if (objectValue.valueType == 32) {
            return objectValue.arrayMaxLength;
        }
        throw new IllegalArgumentException("Not a list!");
    }

    @Override // org.apache.poi.javax.imageio.metadata.IIOMetadataFormat
    public int getObjectArrayMinLength(String str) {
        ObjectValue objectValue = getObjectValue(str);
        if (objectValue.valueType == 32) {
            return objectValue.arrayMinLength;
        }
        throw new IllegalArgumentException("Not a list!");
    }

    @Override // org.apache.poi.javax.imageio.metadata.IIOMetadataFormat
    public Class<?> getObjectClass(String str) {
        return getObjectValue(str).classType;
    }

    @Override // org.apache.poi.javax.imageio.metadata.IIOMetadataFormat
    public Object getObjectDefaultValue(String str) {
        return getObjectValue(str).defaultValue;
    }

    @Override // org.apache.poi.javax.imageio.metadata.IIOMetadataFormat
    public Object[] getObjectEnumerations(String str) {
        ObjectValue objectValue = getObjectValue(str);
        if (objectValue.valueType != 16) {
            throw new IllegalArgumentException("Not an enumeration!");
        }
        List list = objectValue.enumeratedValues;
        return list.toArray(new Object[list.size()]);
    }

    @Override // org.apache.poi.javax.imageio.metadata.IIOMetadataFormat
    public Comparable<?> getObjectMaxValue(String str) {
        ObjectValue objectValue = getObjectValue(str);
        if ((objectValue.valueType & 2) == 2) {
            return objectValue.maxValue;
        }
        throw new IllegalArgumentException("Not a range!");
    }

    @Override // org.apache.poi.javax.imageio.metadata.IIOMetadataFormat
    public Comparable<?> getObjectMinValue(String str) {
        ObjectValue objectValue = getObjectValue(str);
        if ((objectValue.valueType & 2) == 2) {
            return objectValue.minValue;
        }
        throw new IllegalArgumentException("Not a range!");
    }

    @Override // org.apache.poi.javax.imageio.metadata.IIOMetadataFormat
    public int getObjectValueType(String str) {
        ObjectValue objectValue = getElement(str).objectValue;
        if (objectValue == null) {
            return 0;
        }
        return objectValue.valueType;
    }

    public String getResourceBaseName() {
        return this.resourceBaseName;
    }

    @Override // org.apache.poi.javax.imageio.metadata.IIOMetadataFormat
    public String getRootName() {
        return this.rootName;
    }

    @Override // org.apache.poi.javax.imageio.metadata.IIOMetadataFormat
    public boolean isAttributeRequired(String str, String str2) {
        return getAttribute(str, str2).required;
    }

    public void removeAttribute(String str, String str2) {
        Element element = getElement(str);
        element.attrList.remove(str2);
        element.attrMap.remove(str2);
    }

    public void removeElement(String str) {
        Element element = getElement(str, false);
        if (element != null) {
            Iterator it = element.parentList.iterator();
            while (it.hasNext()) {
                Element element2 = getElement((String) it.next(), false);
                if (element2 != null) {
                    element2.childList.remove(str);
                }
            }
            this.elementMap.remove(str);
        }
    }

    public void removeObjectValue(String str) {
        getElement(str).objectValue = null;
    }

    public void setResourceBaseName(String str) {
        if (str == null) {
            throw new IllegalArgumentException("resourceBaseName == null!");
        }
        this.resourceBaseName = str;
    }

    public <T> void addObjectValue(String str, Class<T> cls, boolean z, T t, List<? extends T> list) {
        Element element = getElement(str);
        if (list != null) {
            if (list.size() != 0) {
                for (T t2 : list) {
                    if (t2 != null) {
                        if (!cls.isInstance(t2)) {
                            throw new IllegalArgumentException("enumeratedValues contains a value not of class classType!");
                        }
                    } else {
                        throw new IllegalArgumentException("enumeratedValues contains a null!");
                    }
                }
                ObjectValue objectValue = new ObjectValue();
                objectValue.valueType = 16;
                objectValue.classType = cls;
                objectValue.defaultValue = t;
                objectValue.enumeratedValues = list;
                element.objectValue = objectValue;
                return;
            }
            throw new IllegalArgumentException("enumeratedValues is empty!");
        }
        throw new IllegalArgumentException("enumeratedValues == null!");
    }

    public void addElement(String str, String str2, int i, int i2) {
        Element element = getElement(str2);
        if (i < 0) {
            throw new IllegalArgumentException("minChildren < 0!");
        }
        if (i <= i2) {
            Element element2 = new Element();
            element2.elementName = str;
            element2.childPolicy = 5;
            element2.minChildren = i;
            element2.maxChildren = i2;
            element.childList.add(str);
            element2.parentList.add(str2);
            this.elementMap.put(str, element2);
            return;
        }
        throw new IllegalArgumentException("minChildren > maxChildren!");
    }

    private Element getElement(String str) {
        return getElement(str, true);
    }

    public IIOMetadataFormatImpl(String str, int i, int i2) {
        if (str == null) {
            throw new IllegalArgumentException("rootName == null!");
        }
        if (i < 0) {
            throw new IllegalArgumentException("minChildren < 0!");
        }
        if (i <= i2) {
            Element element = new Element();
            element.elementName = str;
            element.childPolicy = 5;
            element.minChildren = i;
            element.maxChildren = i2;
            this.rootName = str;
            this.elementMap.put(str, element);
            return;
        }
        throw new IllegalArgumentException("minChildren > maxChildren!");
    }

    public void addAttribute(String str, String str2, int i, boolean z, String str3, List<String> list) {
        Element element = getElement(str);
        if (str2 == null) {
            throw new IllegalArgumentException("attrName == null!");
        }
        if (i < 0 || i > 4) {
            throw new IllegalArgumentException("Invalid value for dataType!");
        }
        if (list != null) {
            if (list.size() != 0) {
                for (String str4 : list) {
                    if (str4 != null) {
                        if (!(str4 instanceof String)) {
                            throw new IllegalArgumentException("enumeratedValues contains a non-String value!");
                        }
                    } else {
                        throw new IllegalArgumentException("enumeratedValues contains a null!");
                    }
                }
                Attribute attribute = new Attribute();
                attribute.attrName = str2;
                attribute.valueType = 16;
                attribute.dataType = i;
                attribute.required = z;
                attribute.defaultValue = str3;
                attribute.enumeratedValues = list;
                element.attrList.add(str2);
                element.attrMap.put(str2, attribute);
                return;
            }
            throw new IllegalArgumentException("enumeratedValues is empty!");
        }
        throw new IllegalArgumentException("enumeratedValues == null!");
    }

    public <T extends Comparable<? super T>> void addObjectValue(String str, Class<T> cls, T t, Comparable<? super T> comparable, Comparable<? super T> comparable2, boolean z, boolean z2) {
        Element element = getElement(str);
        ObjectValue objectValue = new ObjectValue();
        objectValue.valueType = 2;
        if (z) {
            objectValue.valueType = 2 | 4;
        }
        if (z2) {
            objectValue.valueType |= 8;
        }
        objectValue.classType = cls;
        objectValue.defaultValue = t;
        objectValue.minValue = comparable;
        objectValue.maxValue = comparable2;
        element.objectValue = objectValue;
    }

    public void addAttribute(String str, String str2, int i, boolean z, String str3, String str4, String str5, boolean z2, boolean z3) {
        Element element = getElement(str);
        if (str2 == null) {
            throw new IllegalArgumentException("attrName == null!");
        }
        if (i >= 0 && i <= 4) {
            Attribute attribute = new Attribute();
            attribute.attrName = str2;
            attribute.valueType = 2;
            if (z2) {
                attribute.valueType = 2 | 4;
            }
            if (z3) {
                attribute.valueType |= 8;
            }
            attribute.dataType = i;
            attribute.required = z;
            attribute.defaultValue = str3;
            attribute.minValue = str4;
            attribute.maxValue = str5;
            element.attrList.add(str2);
            element.attrMap.put(str2, attribute);
            return;
        }
        throw new IllegalArgumentException("Invalid value for dataType!");
    }

    public void addObjectValue(String str, Class<?> cls, int i, int i2) {
        Element element = getElement(str);
        ObjectValue objectValue = new ObjectValue();
        objectValue.valueType = 32;
        objectValue.classType = cls;
        objectValue.arrayMinLength = i;
        objectValue.arrayMaxLength = i2;
        element.objectValue = objectValue;
    }

    public void addAttribute(String str, String str2, int i, boolean z, int i2, int i4) {
        Element element = getElement(str);
        if (str2 == null) {
            throw new IllegalArgumentException("attrName == null!");
        }
        if (i < 0 || i > 4) {
            throw new IllegalArgumentException("Invalid value for dataType!");
        }
        if (i2 >= 0 && i2 <= i4) {
            Attribute attribute = new Attribute();
            attribute.attrName = str2;
            attribute.valueType = 32;
            attribute.dataType = i;
            attribute.required = z;
            attribute.listMinLength = i2;
            attribute.listMaxLength = i4;
            element.attrList.add(str2);
            element.attrMap.put(str2, attribute);
            return;
        }
        throw new IllegalArgumentException("Invalid list bounds!");
    }
}
