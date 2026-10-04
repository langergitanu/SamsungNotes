package org.apache.poi.javax.imageio.metadata;

import java.util.Locale;
import org.apache.poi.javax.imageio.ImageTypeSpecifier;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public interface IIOMetadataFormat {
    public static final int CHILD_POLICY_ALL = 1;
    public static final int CHILD_POLICY_CHOICE = 3;
    public static final int CHILD_POLICY_EMPTY = 0;
    public static final int CHILD_POLICY_MAX = 5;
    public static final int CHILD_POLICY_REPEAT = 5;
    public static final int CHILD_POLICY_SEQUENCE = 4;
    public static final int CHILD_POLICY_SOME = 2;
    public static final int DATATYPE_BOOLEAN = 1;
    public static final int DATATYPE_DOUBLE = 4;
    public static final int DATATYPE_FLOAT = 3;
    public static final int DATATYPE_INTEGER = 2;
    public static final int DATATYPE_STRING = 0;
    public static final int VALUE_ARBITRARY = 1;
    public static final int VALUE_ENUMERATION = 16;
    public static final int VALUE_LIST = 32;
    public static final int VALUE_NONE = 0;
    public static final int VALUE_RANGE = 2;
    public static final int VALUE_RANGE_MAX_INCLUSIVE = 10;
    public static final int VALUE_RANGE_MAX_INCLUSIVE_MASK = 8;
    public static final int VALUE_RANGE_MIN_INCLUSIVE = 6;
    public static final int VALUE_RANGE_MIN_INCLUSIVE_MASK = 4;
    public static final int VALUE_RANGE_MIN_MAX_INCLUSIVE = 14;

    boolean canNodeAppear(String str, ImageTypeSpecifier imageTypeSpecifier);

    int getAttributeDataType(String str, String str2);

    String getAttributeDefaultValue(String str, String str2);

    String getAttributeDescription(String str, String str2, Locale locale);

    String[] getAttributeEnumerations(String str, String str2);

    int getAttributeListMaxLength(String str, String str2);

    int getAttributeListMinLength(String str, String str2);

    String getAttributeMaxValue(String str, String str2);

    String getAttributeMinValue(String str, String str2);

    String[] getAttributeNames(String str);

    int getAttributeValueType(String str, String str2);

    String[] getChildNames(String str);

    int getChildPolicy(String str);

    String getElementDescription(String str, Locale locale);

    int getElementMaxChildren(String str);

    int getElementMinChildren(String str);

    int getObjectArrayMaxLength(String str);

    int getObjectArrayMinLength(String str);

    Class<?> getObjectClass(String str);

    Object getObjectDefaultValue(String str);

    Object[] getObjectEnumerations(String str);

    Comparable<?> getObjectMaxValue(String str);

    Comparable<?> getObjectMinValue(String str);

    int getObjectValueType(String str);

    String getRootName();

    boolean isAttributeRequired(String str, String str2);
}
