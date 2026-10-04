package org.apache.commons.collections;

import com.samsung.android.sdk.smp.common.constants.MarketingConstants;
import com.samsung.android.support.senl.p145cm.base.common.constants.Extension;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Properties;
import java.util.StringTokenizer;
import java.util.Vector;
import kotlin.collections.AbstractC12991c;
import org.apache.commons.lang3.BooleanUtils;
import org.apache.commons.lang3.SystemProperties;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class ExtendedProperties extends Hashtable {
    protected static final String END_TOKEN = "}";
    protected static final String START_TOKEN = "${";
    protected static String include = "include";
    protected String basePath;
    private ExtendedProperties defaults;
    protected String file;
    protected String fileSeparator;
    protected boolean isInitialized;
    protected ArrayList keysAsListed;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class PropertiesReader extends LineNumberReader {
        public PropertiesReader(Reader reader) {
            super(reader);
        }

        public String readProperty() throws IOException {
            StringBuffer stringBuffer = new StringBuffer();
            String line = readLine();
            while (line != null) {
                String strTrim = line.trim();
                if (strTrim.length() != 0 && strTrim.charAt(0) != '#') {
                    if (!ExtendedProperties.endsWithSlash(strTrim)) {
                        stringBuffer.append(strTrim);
                        return stringBuffer.toString();
                    }
                    stringBuffer.append(strTrim.substring(0, strTrim.length() - 1));
                }
                line = readLine();
            }
            return null;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class PropertiesTokenizer extends StringTokenizer {
        static final String DELIMITER = ",";

        public PropertiesTokenizer(String str) {
            super(str, ",");
        }

        @Override // java.util.StringTokenizer
        public boolean hasMoreTokens() {
            return super.hasMoreTokens();
        }

        @Override // java.util.StringTokenizer
        public String nextToken() {
            StringBuffer stringBuffer = new StringBuffer();
            while (true) {
                if (!hasMoreTokens()) {
                    break;
                }
                String strNextToken = super.nextToken();
                if (!ExtendedProperties.endsWithSlash(strNextToken)) {
                    stringBuffer.append(strNextToken);
                    break;
                }
                stringBuffer.append(strNextToken.substring(0, strNextToken.length() - 1));
                stringBuffer.append(",");
            }
            return stringBuffer.toString().trim();
        }
    }

    public ExtendedProperties() {
        try {
            this.fileSeparator = (String) AccessController.doPrivileged(new PrivilegedAction() { // from class: org.apache.commons.collections.ExtendedProperties.1
                @Override // java.security.PrivilegedAction
                public Object run() {
                    return System.getProperty(SystemProperties.FILE_SEPARATOR);
                }
            });
        } catch (SecurityException unused) {
            this.fileSeparator = File.separator;
        }
        this.isInitialized = false;
        this.keysAsListed = new ArrayList();
    }

    private void addPropertyDirect(String str, Object obj) {
        if (!containsKey(str)) {
            this.keysAsListed.add(str);
        }
        put(str, obj);
    }

    private void addPropertyInternal(String str, Object obj) {
        V v = get(str);
        if (v instanceof String) {
            Vector vector = new Vector(2);
            vector.add(v);
            vector.add(obj);
            put(str, vector);
            return;
        }
        if (v instanceof List) {
            ((List) v).add(obj);
            return;
        }
        if (!containsKey(str)) {
            this.keysAsListed.add(str);
        }
        put(str, obj);
    }

    public static ExtendedProperties convertProperties(Properties properties) {
        ExtendedProperties extendedProperties = new ExtendedProperties();
        Enumeration<?> enumerationPropertyNames = properties.propertyNames();
        while (enumerationPropertyNames.hasMoreElements()) {
            String str = (String) enumerationPropertyNames.nextElement();
            extendedProperties.setProperty(str, properties.getProperty(str));
        }
        return extendedProperties;
    }

    private static int countPreceding(String str, int i, char c) {
        int i2 = i - 1;
        int i4 = i2;
        while (i4 >= 0 && str.charAt(i4) == c) {
            i4--;
        }
        return i2 - i4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean endsWithSlash(String str) {
        return str.endsWith("\\") && countPreceding(str, str.length() - 1, '\\') % 2 == 0;
    }

    private static String escape(String str) {
        StringBuffer stringBuffer = new StringBuffer(str);
        int i = 0;
        while (i < stringBuffer.length()) {
            char cCharAt = stringBuffer.charAt(i);
            if (cCharAt == ',' || cCharAt == '\\') {
                stringBuffer.insert(i, '\\');
                i++;
            }
            i++;
        }
        return stringBuffer.toString();
    }

    private static String unescape(String str) {
        StringBuffer stringBuffer = new StringBuffer(str);
        int i = 0;
        while (i < stringBuffer.length() - 1) {
            char cCharAt = stringBuffer.charAt(i);
            int i2 = i + 1;
            char cCharAt2 = stringBuffer.charAt(i2);
            if (cCharAt == '\\' && cCharAt2 == '\\') {
                stringBuffer.deleteCharAt(i);
            }
            i = i2;
        }
        return stringBuffer.toString();
    }

    public void addProperty(String str, Object obj) {
        if (obj instanceof String) {
            String str2 = (String) obj;
            if (str2.indexOf(",") > 0) {
                PropertiesTokenizer propertiesTokenizer = new PropertiesTokenizer(str2);
                while (propertiesTokenizer.hasMoreTokens()) {
                    addPropertyInternal(str, unescape(propertiesTokenizer.nextToken()));
                }
            } else {
                addPropertyInternal(str, unescape(str2));
            }
        } else {
            addPropertyInternal(str, obj);
        }
        this.isInitialized = true;
    }

    public void clearProperty(String str) {
        if (containsKey(str)) {
            int i = 0;
            while (true) {
                if (i >= this.keysAsListed.size()) {
                    break;
                }
                if (this.keysAsListed.get(i).equals(str)) {
                    this.keysAsListed.remove(i);
                    break;
                }
                i++;
            }
            remove(str);
        }
    }

    public void combine(ExtendedProperties extendedProperties) {
        Iterator keys = extendedProperties.getKeys();
        while (keys.hasNext()) {
            String str = (String) keys.next();
            setProperty(str, extendedProperties.get(str));
        }
    }

    public void display() {
        Iterator keys = getKeys();
        while (keys.hasNext()) {
            String str = (String) keys.next();
            Object obj = get(str);
            PrintStream printStream = System.out;
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(str);
            stringBuffer.append(" => ");
            stringBuffer.append(obj);
            printStream.println(stringBuffer.toString());
        }
    }

    public boolean getBoolean(String str) {
        Boolean bool = getBoolean(str, (Boolean) null);
        if (bool != null) {
            return bool.booleanValue();
        }
        throw new NoSuchElementException(AbstractC12991c.m13990k("'", str, "' doesn't map to an existing object"));
    }

    public byte getByte(String str) {
        Byte b = getByte(str, (Byte) null);
        if (b != null) {
            return b.byteValue();
        }
        throw new NoSuchElementException(AbstractC12991c.m13990k("'", str, " doesn't map to an existing object"));
    }

    public double getDouble(String str) {
        Double d = getDouble(str, (Double) null);
        if (d != null) {
            return d.doubleValue();
        }
        throw new NoSuchElementException(AbstractC12991c.m13990k("'", str, "' doesn't map to an existing object"));
    }

    public float getFloat(String str) {
        Float f = getFloat(str, (Float) null);
        if (f != null) {
            return f.floatValue();
        }
        throw new NoSuchElementException(AbstractC12991c.m13990k("'", str, "' doesn't map to an existing object"));
    }

    public String getInclude() {
        return include;
    }

    public int getInt(String str) {
        return getInteger(str);
    }

    public int getInteger(String str) {
        Integer integer = getInteger(str, (Integer) null);
        if (integer != null) {
            return integer.intValue();
        }
        throw new NoSuchElementException(AbstractC12991c.m13990k("'", str, "' doesn't map to an existing object"));
    }

    public Iterator getKeys() {
        return this.keysAsListed.iterator();
    }

    public List getList(String str) {
        return getList(str, null);
    }

    public long getLong(String str) {
        Long l = getLong(str, (Long) null);
        if (l != null) {
            return l.longValue();
        }
        throw new NoSuchElementException(AbstractC12991c.m13990k("'", str, "' doesn't map to an existing object"));
    }

    public Properties getProperties(String str) {
        return getProperties(str, new Properties());
    }

    public Object getProperty(String str) {
        ExtendedProperties extendedProperties;
        V v = get(str);
        return (v != 0 || (extendedProperties = this.defaults) == null) ? v : extendedProperties.get(str);
    }

    public short getShort(String str) {
        Short sh = getShort(str, (Short) null);
        if (sh != null) {
            return sh.shortValue();
        }
        throw new NoSuchElementException(AbstractC12991c.m13990k("'", str, "' doesn't map to an existing object"));
    }

    public String getString(String str) {
        return getString(str, null);
    }

    public String[] getStringArray(String str) {
        List list;
        V v = get(str);
        if (v instanceof String) {
            Vector vector = new Vector(1);
            vector.add(v);
            list = vector;
        } else {
            if (!(v instanceof List)) {
                if (v != 0) {
                    throw new ClassCastException(AbstractC12991c.m13990k("'", str, "' doesn't map to a String/List object"));
                }
                ExtendedProperties extendedProperties = this.defaults;
                return extendedProperties != null ? extendedProperties.getStringArray(str) : new String[0];
            }
            list = (List) v;
        }
        int size = list.size();
        String[] strArr = new String[size];
        for (int i = 0; i < size; i++) {
            strArr[i] = (String) list.get(i);
        }
        return strArr;
    }

    public Vector getVector(String str) {
        return getVector(str, null);
    }

    public String interpolate(String str) {
        return interpolateHelper(str, null);
    }

    /* JADX WARN: Code restructure failed: missing block: B:32:0x00c6, code lost:
    
        r1.append(r9.substring(r3, r9.length()));
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x00d5, code lost:
    
        return r1.toString();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public String interpolateHelper(String str, List list) {
        int iIndexOf;
        List list2 = list;
        if (str == null) {
            return null;
        }
        if (list == null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(str);
            list2 = arrayList;
        }
        StringBuffer stringBuffer = new StringBuffer();
        int i = -1;
        while (true) {
            int i2 = i + 1;
            int iIndexOf2 = str.indexOf("${", i2);
            if (iIndexOf2 <= -1 || (iIndexOf = str.indexOf("}", iIndexOf2)) <= -1) {
                break;
            }
            stringBuffer.append(str.substring(i2, iIndexOf2));
            String strSubstring = str.substring(iIndexOf2 + 2, iIndexOf);
            if (list2.contains(strSubstring)) {
                String string = list2.remove(0).toString();
                list2.add(strSubstring);
                StringBuffer stringBuffer2 = new StringBuffer();
                Iterator it = list2.iterator();
                while (it.hasNext()) {
                    stringBuffer2.append(it.next());
                    if (it.hasNext()) {
                        stringBuffer2.append("->");
                    }
                }
                StringBuffer stringBuffer3 = new StringBuffer("infinite loop in property interpolation of ");
                stringBuffer3.append(string);
                stringBuffer3.append(": ");
                stringBuffer3.append(stringBuffer2.toString());
                throw new IllegalStateException(stringBuffer3.toString());
            }
            list2.add(strSubstring);
            Object property = getProperty(strSubstring);
            if (property != null) {
                stringBuffer.append(interpolateHelper(property.toString(), list2));
                list2.remove(list2.size() - 1);
            } else {
                ExtendedProperties extendedProperties = this.defaults;
                if (extendedProperties == null || extendedProperties.getString(strSubstring, null) == null) {
                    stringBuffer.append("${");
                    stringBuffer.append(strSubstring);
                    stringBuffer.append("}");
                } else {
                    stringBuffer.append(this.defaults.getString(strSubstring));
                }
            }
            i = iIndexOf;
        }
    }

    public boolean isInitialized() {
        return this.isInitialized;
    }

    public void load(InputStream inputStream) {
        load(inputStream, null);
    }

    public synchronized void save(OutputStream outputStream, String str) {
        if (outputStream == null) {
            return;
        }
        try {
            PrintWriter printWriter = new PrintWriter(outputStream);
            if (str != null) {
                printWriter.println(str);
            }
            Enumeration enumerationKeys = keys();
            while (enumerationKeys.hasMoreElements()) {
                String str2 = (String) enumerationKeys.nextElement();
                Object obj = get(str2);
                if (obj != null) {
                    if (obj instanceof String) {
                        StringBuffer stringBuffer = new StringBuffer();
                        stringBuffer.append(str2);
                        stringBuffer.append(MarketingConstants.REFERRER_DELIMITER_U003D);
                        stringBuffer.append(escape((String) obj));
                        printWriter.println(stringBuffer.toString());
                    } else if (obj instanceof List) {
                        for (String str3 : (List) obj) {
                            StringBuffer stringBuffer2 = new StringBuffer();
                            stringBuffer2.append(str2);
                            stringBuffer2.append(MarketingConstants.REFERRER_DELIMITER_U003D);
                            stringBuffer2.append(escape(str3));
                            printWriter.println(stringBuffer2.toString());
                        }
                    }
                }
                printWriter.println();
                printWriter.flush();
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public void setInclude(String str) {
        include = str;
    }

    public void setProperty(String str, Object obj) {
        clearProperty(str);
        addProperty(str, obj);
    }

    public ExtendedProperties subset(String str) {
        ExtendedProperties extendedProperties = new ExtendedProperties();
        Iterator keys = getKeys();
        boolean z = false;
        while (keys.hasNext()) {
            Object next = keys.next();
            if (next instanceof String) {
                String str2 = (String) next;
                if (str2.startsWith(str)) {
                    if (!z) {
                        z = true;
                    }
                    extendedProperties.addPropertyDirect(str2.length() == str.length() ? str : str2.substring(str.length() + 1), get(next));
                }
            }
        }
        if (z) {
            return extendedProperties;
        }
        return null;
    }

    public String testBoolean(String str) {
        String lowerCase = str.toLowerCase();
        String str2 = "true";
        if (!lowerCase.equals("true") && !lowerCase.equals("on") && !lowerCase.equals(BooleanUtils.YES)) {
            str2 = "false";
            if (!lowerCase.equals("false") && !lowerCase.equals("off") && !lowerCase.equals(BooleanUtils.f9757NO)) {
                return null;
            }
        }
        return str2;
    }

    public int getInt(String str, int i) {
        return getInteger(str, i);
    }

    public Iterator getKeys(String str) {
        Iterator keys = getKeys();
        ArrayList arrayList = new ArrayList();
        while (keys.hasNext()) {
            Object next = keys.next();
            if ((next instanceof String) && ((String) next).startsWith(str)) {
                arrayList.add(next);
            }
        }
        return arrayList.iterator();
    }

    public List getList(String str, List list) {
        V v = get(str);
        if (v instanceof List) {
            return new ArrayList((List) v);
        }
        if (v instanceof String) {
            ArrayList arrayList = new ArrayList(1);
            arrayList.add(v);
            put(str, arrayList);
            return arrayList;
        }
        if (v != 0) {
            throw new ClassCastException(AbstractC12991c.m13990k("'", str, "' doesn't map to a List object"));
        }
        ExtendedProperties extendedProperties = this.defaults;
        return extendedProperties != null ? extendedProperties.getList(str, list) : list == null ? new ArrayList() : list;
    }

    public Properties getProperties(String str, Properties properties) {
        String[] stringArray = getStringArray(str);
        Properties properties2 = new Properties(properties);
        for (String str2 : stringArray) {
            int iIndexOf = str2.indexOf(61);
            if (iIndexOf <= 0) {
                throw new IllegalArgumentException(AbstractC12991c.m13990k("'", str2, "' does not contain an equals sign"));
            }
            properties2.put(str2.substring(0, iIndexOf).trim(), str2.substring(iIndexOf + 1).trim());
        }
        return properties2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public String getString(String str, String str2) {
        V v = get(str);
        if (v instanceof String) {
            return interpolate((String) v);
        }
        if (v == 0) {
            ExtendedProperties extendedProperties = this.defaults;
            return extendedProperties != null ? interpolate(extendedProperties.getString(str, str2)) : interpolate(str2);
        }
        if (v instanceof List) {
            return interpolate((String) ((List) v).get(0));
        }
        throw new ClassCastException(AbstractC12991c.m13990k("'", str, "' doesn't map to a String object"));
    }

    public Vector getVector(String str, Vector vector) {
        V v = get(str);
        if (v instanceof List) {
            return new Vector((List) v);
        }
        if (v instanceof String) {
            Vector vector2 = new Vector(1);
            vector2.add(v);
            put(str, vector2);
            return vector2;
        }
        if (v != 0) {
            throw new ClassCastException(AbstractC12991c.m13990k("'", str, "' doesn't map to a Vector object"));
        }
        ExtendedProperties extendedProperties = this.defaults;
        return extendedProperties != null ? extendedProperties.getVector(str, vector) : vector == null ? new Vector() : vector;
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0036  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0014 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0032 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:72:? A[PHI: r0
      PHI (r0v2 org.apache.commons.collections.ExtendedProperties$PropertiesReader) = 
      (r0v1 org.apache.commons.collections.ExtendedProperties$PropertiesReader)
      (r0v3 org.apache.commons.collections.ExtendedProperties$PropertiesReader)
      (r0v4 org.apache.commons.collections.ExtendedProperties$PropertiesReader)
     binds: [B:9:0x0012, B:12:0x0021, B:10:0x0014] A[DONT_GENERATE, DONT_INLINE], SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized void load(InputStream inputStream, String str) {
        PropertiesReader propertiesReader;
        String property;
        File file;
        if (str != null) {
            try {
                propertiesReader = new PropertiesReader(new InputStreamReader(inputStream, str));
            } catch (UnsupportedEncodingException unused) {
                propertiesReader = null;
            }
            if (propertiesReader != null) {
                try {
                    propertiesReader = new PropertiesReader(new InputStreamReader(inputStream, "8859_1"));
                } catch (UnsupportedEncodingException unused2) {
                    propertiesReader = new PropertiesReader(new InputStreamReader(inputStream));
                }
                while (true) {
                    try {
                        property = propertiesReader.readProperty();
                        if (property != null) {
                            this.isInitialized = true;
                        } else {
                            int iIndexOf = property.indexOf(61);
                            if (iIndexOf > 0) {
                                String strTrim = property.substring(0, iIndexOf).trim();
                                String strTrim2 = property.substring(iIndexOf + 1).trim();
                                if (!"".equals(strTrim2)) {
                                    if (getInclude() == null || !strTrim.equalsIgnoreCase(getInclude())) {
                                        addProperty(strTrim, strTrim2);
                                    } else {
                                        if (strTrim2.startsWith(this.fileSeparator)) {
                                            file = new File(strTrim2);
                                        } else {
                                            StringBuffer stringBuffer = new StringBuffer();
                                            stringBuffer.append(Extension.DOT);
                                            stringBuffer.append(this.fileSeparator);
                                            if (strTrim2.startsWith(stringBuffer.toString())) {
                                                strTrim2 = strTrim2.substring(2);
                                            }
                                            StringBuffer stringBuffer2 = new StringBuffer();
                                            stringBuffer2.append(this.basePath);
                                            stringBuffer2.append(strTrim2);
                                            file = new File(stringBuffer2.toString());
                                        }
                                        if (file.exists() && file.canRead()) {
                                            load(new FileInputStream(file));
                                        }
                                    }
                                }
                            }
                        }
                    } catch (Throwable th) {
                        this.isInitialized = true;
                        throw th;
                    }
                }
            } else {
                while (true) {
                    property = propertiesReader.readProperty();
                    if (property != null) {
                    }
                }
            }
        } else {
            propertiesReader = null;
            if (propertiesReader != null) {
            }
        }
    }

    public ExtendedProperties(String str) {
        this(str, null);
    }

    public ExtendedProperties(String str, String str2) throws Throwable {
        try {
            this.fileSeparator = (String) AccessController.doPrivileged(new PrivilegedAction() { // from class: org.apache.commons.collections.ExtendedProperties.1
                @Override // java.security.PrivilegedAction
                public Object run() {
                    return System.getProperty(SystemProperties.FILE_SEPARATOR);
                }
            });
        } catch (SecurityException unused) {
            this.fileSeparator = File.separator;
        }
        this.isInitialized = false;
        this.keysAsListed = new ArrayList();
        this.file = str;
        String absolutePath = new File(str).getAbsolutePath();
        this.basePath = absolutePath;
        this.basePath = absolutePath.substring(0, absolutePath.lastIndexOf(this.fileSeparator) + 1);
        FileInputStream fileInputStream = null;
        try {
            FileInputStream fileInputStream2 = new FileInputStream(str);
            try {
                load(fileInputStream2);
                try {
                    fileInputStream2.close();
                } catch (IOException unused2) {
                }
                if (str2 != null) {
                    this.defaults = new ExtendedProperties(str2);
                }
            } catch (Throwable th) {
                th = th;
                fileInputStream = fileInputStream2;
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (IOException unused3) {
                    }
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public boolean getBoolean(String str, boolean z) {
        return getBoolean(str, new Boolean(z)).booleanValue();
    }

    public byte getByte(String str, byte b) {
        return getByte(str, new Byte(b)).byteValue();
    }

    public double getDouble(String str, double d) {
        return getDouble(str, new Double(d)).doubleValue();
    }

    public float getFloat(String str, float f) {
        return getFloat(str, new Float(f)).floatValue();
    }

    public int getInteger(String str, int i) {
        Integer integer = getInteger(str, (Integer) null);
        return integer == null ? i : integer.intValue();
    }

    public long getLong(String str, long j) {
        return getLong(str, new Long(j)).longValue();
    }

    public short getShort(String str, short s) {
        return getShort(str, new Short(s)).shortValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Boolean getBoolean(String str, Boolean bool) {
        V v = get(str);
        if (v instanceof Boolean) {
            return (Boolean) v;
        }
        if (v instanceof String) {
            Boolean bool2 = new Boolean(testBoolean((String) v));
            put(str, bool2);
            return bool2;
        }
        if (v == 0) {
            ExtendedProperties extendedProperties = this.defaults;
            return extendedProperties != null ? extendedProperties.getBoolean(str, bool) : bool;
        }
        throw new ClassCastException(AbstractC12991c.m13990k("'", str, "' doesn't map to a Boolean object"));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Byte getByte(String str, Byte b) {
        V v = get(str);
        if (v instanceof Byte) {
            return (Byte) v;
        }
        if (v instanceof String) {
            Byte b5 = new Byte((String) v);
            put(str, b5);
            return b5;
        }
        if (v == 0) {
            ExtendedProperties extendedProperties = this.defaults;
            return extendedProperties != null ? extendedProperties.getByte(str, b) : b;
        }
        throw new ClassCastException(AbstractC12991c.m13990k("'", str, "' doesn't map to a Byte object"));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Double getDouble(String str, Double d) {
        V v = get(str);
        if (v instanceof Double) {
            return (Double) v;
        }
        if (v instanceof String) {
            Double d2 = new Double((String) v);
            put(str, d2);
            return d2;
        }
        if (v == 0) {
            ExtendedProperties extendedProperties = this.defaults;
            return extendedProperties != null ? extendedProperties.getDouble(str, d) : d;
        }
        throw new ClassCastException(AbstractC12991c.m13990k("'", str, "' doesn't map to a Double object"));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Float getFloat(String str, Float f) {
        V v = get(str);
        if (v instanceof Float) {
            return (Float) v;
        }
        if (v instanceof String) {
            Float f4 = new Float((String) v);
            put(str, f4);
            return f4;
        }
        if (v == 0) {
            ExtendedProperties extendedProperties = this.defaults;
            return extendedProperties != null ? extendedProperties.getFloat(str, f) : f;
        }
        throw new ClassCastException(AbstractC12991c.m13990k("'", str, "' doesn't map to a Float object"));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Long getLong(String str, Long l) {
        V v = get(str);
        if (v instanceof Long) {
            return (Long) v;
        }
        if (v instanceof String) {
            Long l2 = new Long((String) v);
            put(str, l2);
            return l2;
        }
        if (v == 0) {
            ExtendedProperties extendedProperties = this.defaults;
            return extendedProperties != null ? extendedProperties.getLong(str, l) : l;
        }
        throw new ClassCastException(AbstractC12991c.m13990k("'", str, "' doesn't map to a Long object"));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Short getShort(String str, Short sh) {
        V v = get(str);
        if (v instanceof Short) {
            return (Short) v;
        }
        if (v instanceof String) {
            Short sh2 = new Short((String) v);
            put(str, sh2);
            return sh2;
        }
        if (v == 0) {
            ExtendedProperties extendedProperties = this.defaults;
            return extendedProperties != null ? extendedProperties.getShort(str, sh) : sh;
        }
        throw new ClassCastException(AbstractC12991c.m13990k("'", str, "' doesn't map to a Short object"));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Integer getInteger(String str, Integer num) {
        V v = get(str);
        if (v instanceof Integer) {
            return (Integer) v;
        }
        if (v instanceof String) {
            Integer num2 = new Integer((String) v);
            put(str, num2);
            return num2;
        }
        if (v == 0) {
            ExtendedProperties extendedProperties = this.defaults;
            return extendedProperties != null ? extendedProperties.getInteger(str, num) : num;
        }
        throw new ClassCastException(AbstractC12991c.m13990k("'", str, "' doesn't map to a Integer object"));
    }
}
