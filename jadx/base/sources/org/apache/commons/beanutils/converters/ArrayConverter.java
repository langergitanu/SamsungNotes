package org.apache.commons.beanutils.converters;

import androidx.constraintlayout.motion.widget.AbstractC2322a;
import com.samsung.android.support.senl.p145cm.base.common.constants.Extension;
import com.samsung.android.support.senl.p148nt.data.database.core.query.sqlbuilder.SQLKeyword;
import java.io.IOException;
import java.io.StreamTokenizer;
import java.io.StringReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import opennlp.tools.parser.Parse;
import org.apache.commons.beanutils.ConversionException;
import org.apache.commons.beanutils.Converter;
import org.apache.commons.beanutils.PropertyUtils;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class ArrayConverter extends AbstractConverter {
    private char[] allowedChars;
    private int defaultSize;
    private final Class<?> defaultType;
    private char delimiter;
    private final Converter elementConverter;
    private boolean onlyFirstToString;

    public ArrayConverter(Class<?> cls, Converter converter) {
        this.delimiter = ',';
        this.allowedChars = new char[]{'.', '-'};
        this.onlyFirstToString = true;
        if (cls == null) {
            throw new IllegalArgumentException("Default type is missing");
        }
        if (!cls.isArray()) {
            throw new IllegalArgumentException("Default type must be an array.");
        }
        if (converter == null) {
            throw new IllegalArgumentException("Component Converter is missing.");
        }
        this.defaultType = cls;
        this.elementConverter = converter;
    }

    private List<String> parseElements(Class<?> cls, String str) {
        int iNextToken;
        if (log().isDebugEnabled()) {
            log().debug("Parsing elements, delimiter=[" + this.delimiter + "], value=[" + str + "]");
        }
        String strTrim = str.trim();
        if (strTrim.startsWith(Parse.BRACKET_LCB) && strTrim.endsWith("}")) {
            strTrim = AbstractC2322a.m1614d(1, 1, strTrim);
        }
        try {
            StreamTokenizer streamTokenizer = new StreamTokenizer(new StringReader(strTrim));
            char c = this.delimiter;
            streamTokenizer.whitespaceChars(c, c);
            streamTokenizer.ordinaryChars(48, 57);
            streamTokenizer.wordChars(48, 57);
            for (char c2 : this.allowedChars) {
                streamTokenizer.ordinaryChars(c2, c2);
                streamTokenizer.wordChars(c2, c2);
            }
            List<String> arrayList = null;
            while (true) {
                iNextToken = streamTokenizer.nextToken();
                if (iNextToken != -3 && iNextToken <= 0) {
                    break;
                }
                if (streamTokenizer.sval != null) {
                    if (arrayList == null) {
                        arrayList = new ArrayList<>();
                    }
                    arrayList.add(streamTokenizer.sval);
                }
            }
            if (iNextToken != -1) {
                throw new ConversionException("Encountered token of type " + iNextToken + " parsing elements to '" + toString(cls) + Extension.DOT);
            }
            if (arrayList == null) {
                arrayList = Collections.EMPTY_LIST;
            }
            if (log().isDebugEnabled()) {
                log().debug(arrayList.size() + " elements parsed");
            }
            return arrayList;
        } catch (IOException e) {
            throw new ConversionException("Error converting from String to '" + toString(cls) + "': " + e.getMessage(), e);
        }
    }

    public Collection<?> convertToCollection(Class<?> cls, Object obj) {
        if (obj instanceof Collection) {
            return (Collection) obj;
        }
        if (!(obj instanceof Number) && !(obj instanceof Boolean) && !(obj instanceof Date)) {
            return parseElements(cls, obj.toString());
        }
        ArrayList arrayList = new ArrayList(1);
        arrayList.add(obj);
        return arrayList;
    }

    @Override // org.apache.commons.beanutils.converters.AbstractConverter
    public String convertToString(Object obj) {
        Iterator<?> it;
        int length;
        Class<?> cls = obj.getClass();
        if (cls.isArray()) {
            length = Array.getLength(obj);
            it = null;
        } else {
            Collection<?> collectionConvertToCollection = convertToCollection(cls, obj);
            int size = collectionConvertToCollection.size();
            it = collectionConvertToCollection.iterator();
            length = size;
        }
        if (length == 0) {
            return (String) getDefault(String.class);
        }
        if (this.onlyFirstToString) {
            length = 1;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            if (i > 0) {
                sb.append(this.delimiter);
            }
            Object objConvert = this.elementConverter.convert(String.class, it == null ? Array.get(obj, i) : it.next());
            if (objConvert != null) {
                sb.append(objConvert);
            }
        }
        return sb.toString();
    }

    @Override // org.apache.commons.beanutils.converters.AbstractConverter
    public <T> T convertToType(Class<T> cls, Object obj) {
        Iterator<?> it;
        int length;
        if (!cls.isArray()) {
            throw new ConversionException(toString(getClass()) + " cannot handle conversion to '" + toString(cls) + "' (not an array).");
        }
        if (obj.getClass().isArray()) {
            length = Array.getLength(obj);
            it = null;
        } else {
            Collection<?> collectionConvertToCollection = convertToCollection(cls, obj);
            int size = collectionConvertToCollection.size();
            it = collectionConvertToCollection.iterator();
            length = size;
        }
        Class<?> componentType = cls.getComponentType();
        T t = (T) Array.newInstance(componentType, length);
        for (int i = 0; i < length; i++) {
            Array.set(t, i, this.elementConverter.convert(componentType, it == null ? Array.get(obj, i) : it.next()));
        }
        return t;
    }

    @Override // org.apache.commons.beanutils.converters.AbstractConverter
    public Object getDefault(Class<?> cls) {
        Object obj;
        if (cls.equals(String.class) || (obj = super.getDefault(cls)) == null) {
            return null;
        }
        return obj.getClass().equals(cls) ? obj : Array.newInstance(cls.getComponentType(), this.defaultSize);
    }

    @Override // org.apache.commons.beanutils.converters.AbstractConverter
    public Class<?> getDefaultType() {
        return this.defaultType;
    }

    public void setAllowedChars(char[] cArr) {
        this.allowedChars = cArr;
    }

    public void setDelimiter(char c) {
        this.delimiter = c;
    }

    public void setOnlyFirstToString(boolean z) {
        this.onlyFirstToString = z;
    }

    @Override // org.apache.commons.beanutils.converters.AbstractConverter
    public String toString() {
        return toString(getClass()) + "[UseDefault=" + isUseDefault() + SQLKeyword.COMMA + this.elementConverter.toString() + PropertyUtils.INDEXED_DELIM2;
    }

    public ArrayConverter(Class<?> cls, Converter converter, int i) {
        this(cls, converter);
        this.defaultSize = i;
        setDefaultValue(i >= 0 ? Array.newInstance(cls.getComponentType(), i) : null);
    }

    @Override // org.apache.commons.beanutils.converters.AbstractConverter
    public Object convertArray(Object obj) {
        return obj;
    }
}
