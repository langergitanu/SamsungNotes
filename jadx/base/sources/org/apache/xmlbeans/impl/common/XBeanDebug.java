package org.apache.xmlbeans.impl.common;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import kotlin.collections.AbstractC12991c;
import org.apache.xmlbeans.SystemProperties;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class XBeanDebug {
    public static final int TRACE_SCHEMA_LOADING = 1;
    static PrintStream _err = null;
    static /* synthetic */ Class class$org$apache$xmlbeans$impl$common$XBeanDebug = null;
    public static final String defaultProp = "";
    public static final String traceProp = "org.apache.xmlbeans.impl.debug";
    private static int _enabled = initializeBitsFromProperty();
    private static int _indent = 0;
    private static String _indentspace = "                                                                                ";

    public static /* synthetic */ Class class$(String str) throws Throwable {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e) {
            throw AbstractC12991c.m13994o(e);
        }
    }

    public static void disable(int i) {
        _enabled = (~i) & _enabled;
    }

    public static void enable(int i) {
        _enabled = i | _enabled;
    }

    private static int initializeBitsFromProperty() {
        return SystemProperties.getProperty(traceProp, "").indexOf("TRACE_SCHEMA_LOADING") >= 0 ? 1 : 0;
    }

    public static String log(String str) {
        log(str, null);
        return str;
    }

    public static Throwable logException(Throwable th) {
        log(th.getMessage(), th);
        return th;
    }

    public static String logStackTrace(String str) {
        log(str, new Throwable());
        return str;
    }

    public static boolean test(int i) {
        return (i & _enabled) != 0;
    }

    public static void trace(int i, String str, int i2) throws Throwable {
        if (test(i)) {
            Class clsClass$ = class$org$apache$xmlbeans$impl$common$XBeanDebug;
            if (clsClass$ == null) {
                clsClass$ = class$("org.apache.xmlbeans.impl.common.XBeanDebug");
                class$org$apache$xmlbeans$impl$common$XBeanDebug = clsClass$;
            }
            synchronized (clsClass$) {
                if (i2 < 0) {
                    try {
                        _indent += i2;
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                int i4 = _indent;
                String strSubstring = i4 < 0 ? "" : i4 > _indentspace.length() ? _indentspace : _indentspace.substring(0, _indent);
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append(Thread.currentThread().getName());
                stringBuffer.append(": ");
                stringBuffer.append(strSubstring);
                stringBuffer.append(str);
                stringBuffer.append("\n");
                System.err.print(stringBuffer.toString());
                if (i2 > 0) {
                    _indent += i2;
                }
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x003c A[Catch: all -> 0x002f, TRY_LEAVE, TryCatch #1 {, blocks: (B:4:0x0005, B:6:0x0009, B:11:0x0035, B:13:0x003c, B:10:0x0031), top: B:20:0x0005, inners: #0 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static synchronized String log(String str, Throwable th) {
        if (_err == null) {
            try {
                File fileCreateTempFile = File.createTempFile("xmlbeandebug", ".log");
                _err = new PrintStream(new FileOutputStream(fileCreateTempFile));
                PrintStream printStream = System.err;
                StringBuffer stringBuffer = new StringBuffer("Diagnostic XML Bean debug log file created: ");
                stringBuffer.append(fileCreateTempFile);
                printStream.println(stringBuffer.toString());
            } catch (IOException unused) {
                _err = System.err;
            }
            _err.println(str);
            if (th != null) {
                th.printStackTrace(_err);
            }
        } else {
            _err.println(str);
            if (th != null) {
            }
        }
        return str;
    }
}
