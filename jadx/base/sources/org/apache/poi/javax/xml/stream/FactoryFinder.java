package org.apache.poi.javax.xml.stream;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.Properties;
import kotlin.collections.AbstractC12991c;
import p258y.AbstractC14516b;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
class FactoryFinder {
    static /* synthetic */ Class class$javax$xml$stream$FactoryFinder = null;
    private static boolean debug = false;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static abstract class ClassLoaderFinder {
        private ClassLoaderFinder() {
        }

        public abstract ClassLoader getContextClassLoader();
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class ClassLoaderFinderConcrete extends ClassLoaderFinder {
        public ClassLoaderFinderConcrete() {
            super();
        }

        @Override // org.apache.poi.javax.xml.stream.FactoryFinder.ClassLoaderFinder
        public ClassLoader getContextClassLoader() {
            return Thread.currentThread().getContextClassLoader();
        }
    }

    static {
        try {
            debug = System.getProperty("xml.stream.debug") != null;
        } catch (Exception unused) {
        }
    }

    public static /* synthetic */ Class class$(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e) {
            throw new NoClassDefFoundError(e.getMessage());
        }
    }

    private static void debugPrintln(String str) {
        if (debug) {
            PrintStream printStream = System.err;
            StringBuffer stringBuffer = new StringBuffer("STREAM: ");
            stringBuffer.append(str);
            printStream.println(stringBuffer.toString());
        }
    }

    public static Object find(String str) {
        return find(str, null);
    }

    private static ClassLoader findClassLoader() {
        try {
            StringBuffer stringBuffer = new StringBuffer();
            Class clsClass$ = class$javax$xml$stream$FactoryFinder;
            if (clsClass$ == null) {
                clsClass$ = class$("org.apache.poi.javax.xml.stream.FactoryFinder");
                class$javax$xml$stream$FactoryFinder = clsClass$;
            }
            stringBuffer.append(clsClass$.getName());
            stringBuffer.append("$ClassLoaderFinderConcrete");
            return ((ClassLoaderFinder) Class.forName(stringBuffer.toString()).newInstance()).getContextClassLoader();
        } catch (ClassNotFoundException unused) {
            Class clsClass$2 = class$javax$xml$stream$FactoryFinder;
            if (clsClass$2 == null) {
                clsClass$2 = class$("org.apache.poi.javax.xml.stream.FactoryFinder");
                class$javax$xml$stream$FactoryFinder = clsClass$2;
            }
            return clsClass$2.getClassLoader();
        } catch (Exception e) {
            throw new FactoryConfigurationError(e.toString(), e);
        } catch (LinkageError unused2) {
            Class clsClass$3 = class$javax$xml$stream$FactoryFinder;
            if (clsClass$3 == null) {
                clsClass$3 = class$("org.apache.poi.javax.xml.stream.FactoryFinder");
                class$javax$xml$stream$FactoryFinder = clsClass$3;
            }
            return clsClass$3.getClassLoader();
        }
    }

    private static Object newInstance(String str, ClassLoader classLoader) {
        try {
            return (classLoader == null ? Class.forName(str) : classLoader.loadClass(str)).newInstance();
        } catch (ClassNotFoundException e) {
            throw new FactoryConfigurationError(AbstractC12991c.m13990k("Provider ", str, " not found"), e);
        } catch (Exception e2) {
            StringBuffer stringBuffer = new StringBuffer("Provider ");
            stringBuffer.append(str);
            stringBuffer.append(" could not be instantiated: ");
            stringBuffer.append(e2);
            throw new FactoryConfigurationError(stringBuffer.toString(), e2);
        }
    }

    public static Object find(String str, String str2) {
        return find(str, str2, findClassLoader());
    }

    public static Object find(String str, String str2, ClassLoader classLoader) {
        InputStream resourceAsStream;
        try {
            String property = System.getProperty(str);
            if (property != null) {
                debugPrintln("found system property".concat(property));
                return newInstance(property, classLoader);
            }
        } catch (SecurityException unused) {
        }
        try {
            String property2 = System.getProperty("java.home");
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(property2);
            String str3 = File.separator;
            stringBuffer.append(str3);
            stringBuffer.append("lib");
            stringBuffer.append(str3);
            stringBuffer.append("jaxp.properties");
            File file = new File(stringBuffer.toString());
            if (file.exists()) {
                Properties properties = new Properties();
                properties.load(new FileInputStream(file));
                String property3 = properties.getProperty(str);
                if (property3 != null && property3.length() > 0) {
                    debugPrintln("found java.home property ".concat(property3));
                    return newInstance(property3, classLoader);
                }
            }
        } catch (Exception e) {
            if (debug) {
                e.printStackTrace();
            }
        }
        String strM15113a = AbstractC14516b.m15113a("META-INF/services/", str);
        try {
            if (classLoader == null) {
                resourceAsStream = ClassLoader.getSystemResourceAsStream(strM15113a);
            } else {
                resourceAsStream = classLoader.getResourceAsStream(strM15113a);
            }
            if (resourceAsStream != null) {
                StringBuffer stringBuffer2 = new StringBuffer("found ");
                stringBuffer2.append(strM15113a);
                debugPrintln(stringBuffer2.toString());
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(resourceAsStream, "UTF-8"));
                String line = bufferedReader.readLine();
                bufferedReader.close();
                if (line != null && !"".equals(line)) {
                    debugPrintln("loaded from services: ".concat(line));
                    return newInstance(line, classLoader);
                }
            }
        } catch (Exception e2) {
            if (debug) {
                e2.printStackTrace();
            }
        }
        if (str2 != null) {
            debugPrintln("loaded from fallback value: ".concat(str2));
            return newInstance(str2, classLoader);
        }
        throw new FactoryConfigurationError(AbstractC12991c.m13990k("Provider for ", str, " cannot be found"), (Exception) null);
    }
}
