package com.samsung.android.app.notes.sync.network.networkutils;

import androidx.appcompat.widget.AbstractC0541b;
import androidx.constraintlayout.motion.widget.AbstractC2322a;
import com.samsung.android.app.notes.sync.error.SyncException;
import com.samsung.android.app.notes.sync.network.C6844i;
import com.samsung.android.support.senl.p148nt.base.common.log.Debugger;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.net.SocketTimeoutException;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Locale;
import java.util.Map;
import java.util.Queue;
import javax.net.ssl.SSLHandshakeException;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGetHC4;
import org.apache.http.client.methods.HttpPostHC4;
import org.apache.http.client.methods.HttpRequestBaseHC4;
import org.apache.http.util.EntityUtils;
import org.json.JSONException;
import org.json.JSONObject;
import p001A.AbstractC0000a;

/* JADX INFO: renamed from: com.samsung.android.app.notes.sync.network.networkutils.e */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public abstract class AbstractC6854e {

    /* JADX INFO: renamed from: a */
    public static final Object f4283a = new Object();

    /* JADX INFO: renamed from: b */
    public static final HashMap f4284b = new HashMap();

    /* JADX WARN: Code restructure failed: missing block: B:104:0x031e, code lost:
    
        r10 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:119:0x0360, code lost:
    
        throw r10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:130:0x038a, code lost:
    
        r9 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:145:0x03cc, code lost:
    
        throw r9;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Not initialized variable reg: 7, insn: 0x00bf: MOVE (r4 I:??[OBJECT, ARRAY]) = (r7 I:??[OBJECT, ARRAY]) (LINE:192), block:B:21:0x00be */
    /* JADX WARN: Not initialized variable reg: 7, insn: 0x00cd: MOVE (r4 I:??[OBJECT, ARRAY]) = (r7 I:??[OBJECT, ARRAY]) (LINE:206), block:B:29:0x00cc */
    /* JADX WARN: Removed duplicated region for block: B:125:0x0367  */
    /* JADX WARN: Removed duplicated region for block: B:149:0x0323 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:157:0x03ae A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:166:0x0342 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:171:0x038f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:178:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:180:? A[SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r2v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v10 */
    /* JADX WARN: Type inference failed for: r2v11 */
    /* JADX WARN: Type inference failed for: r2v7, types: [com.samsung.android.app.notes.sync.network.networkutils.a] */
    /* JADX WARN: Type inference failed for: r2v9, types: [com.samsung.android.app.notes.sync.network.networkutils.a] */
    /* JADX INFO: renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void m5021a(String str, HttpRequestBaseHC4 httpRequestBaseHC4, InterfaceC6852c interfaceC6852c) throws Throwable {
        Closeable closeable;
        Collection collection;
        Collection collection2;
        C6850a c6850aM5016d = "NT$NetworkUtil_";
        Debugger.m8616s("NT$NetworkUtil_", "executeRequest [" + Thread.currentThread().getId() + "]");
        Collection collection3 = null;
        try {
            try {
                Debugger.m8616s("NT$NetworkUtil_" + str, httpRequestBaseHC4.hashCode() + " : " + str + " :  : " + httpRequestBaseHC4.getURI());
                c6850aM5016d = C6850a.m5016d();
            } catch (Throwable th) {
                th = th;
                closeable = null;
                collection3 = collection;
            }
            try {
                Object obj = f4283a;
                try {
                    synchronized (obj) {
                        try {
                            HashMap map = f4284b;
                            Queue queue = (Queue) map.get(str);
                            if (queue == null) {
                                try {
                                    LinkedList linkedList = new LinkedList();
                                    try {
                                        map.put(str, linkedList);
                                        queue = linkedList;
                                    } catch (Throwable th2) {
                                        th = th2;
                                        throw th;
                                    }
                                } catch (Throwable th3) {
                                    th = th3;
                                }
                            }
                            queue.add(httpRequestBaseHC4);
                            CloseableHttpResponse closeableHttpResponseM5019c = c6850aM5016d.m5019c(httpRequestBaseHC4);
                            Debugger.m8616s("NT$NetworkUtil_" + str, httpRequestBaseHC4.hashCode() + " : " + closeableHttpResponseM5019c.getStatusLine());
                            if (interfaceC6852c instanceof InterfaceC6853d) {
                                m5023c(closeableHttpResponseM5019c, (InterfaceC6853d) interfaceC6852c);
                            } else if (interfaceC6852c instanceof InterfaceC6851b) {
                                m5022b(closeableHttpResponseM5019c, (InterfaceC6851b) interfaceC6852c);
                            } else if (interfaceC6852c instanceof C6860k) {
                                m5025e(closeableHttpResponseM5019c, (C6860k) interfaceC6852c);
                            } else {
                                if (!(interfaceC6852c instanceof C6859j)) {
                                    throw new SyncException(315, "invalid response handler");
                                }
                                m5024d(closeableHttpResponseM5019c, (C6859j) interfaceC6852c);
                            }
                            synchronized (obj) {
                                try {
                                    queue.remove(httpRequestBaseHC4);
                                } finally {
                                }
                            }
                            try {
                                closeableHttpResponseM5019c.close();
                            } catch (Throwable th4) {
                                Debugger.m8609e("NT$NetworkUtil_", "response.close() : " + th4.getMessage());
                            }
                            try {
                                c6850aM5016d.m5018b();
                            } catch (Throwable th5) {
                                Debugger.m8609e("NT$NetworkUtil_", "httpSet.close() : " + th5.getMessage());
                            }
                            Debugger.m8616s("NT$NetworkUtil_", "executeRequest finish [" + Thread.currentThread().getId() + "]");
                        } catch (Throwable th6) {
                            th = th6;
                        }
                    }
                } catch (SyncException e) {
                    e = e;
                    closeable = null;
                    collection3 = collection2;
                    c6850aM5016d = c6850aM5016d;
                    try {
                        Debugger.m8616s("NT$NetworkUtil_" + str, httpRequestBaseHC4.hashCode() + " : " + httpRequestBaseHC4.getURI() + " - executeRequest PDM err" + e.getMessage());
                        if (e.getExceptionCode() != 322) {
                            throw e;
                        }
                        m5021a(str, httpRequestBaseHC4, interfaceC6852c);
                        synchronized (f4283a) {
                            if (collection3 != null) {
                                try {
                                    collection3.remove(httpRequestBaseHC4);
                                } finally {
                                    if (closeable != null) {
                                        try {
                                            closeable.close();
                                        } catch (Throwable th7) {
                                            Debugger.m8609e("NT$NetworkUtil_", "response.close() : " + th7.getMessage());
                                        }
                                    }
                                    if (c6850aM5016d == 0) {
                                        try {
                                            c6850aM5016d.m5018b();
                                            return;
                                        } catch (Throwable th8) {
                                            Debugger.m8609e("NT$NetworkUtil_", "httpSet.close() : " + th8.getMessage());
                                            return;
                                        }
                                    }
                                    return;
                                }
                            }
                        }
                        if (closeable != null) {
                        }
                        if (c6850aM5016d == 0) {
                        }
                    } catch (Throwable th9) {
                        th = th9;
                        synchronized (f4283a) {
                            if (collection3 != null) {
                                try {
                                    collection3.remove(httpRequestBaseHC4);
                                } finally {
                                    if (closeable != null) {
                                    }
                                    if (c6850aM5016d != 0) {
                                    }
                                }
                            }
                        }
                        if (closeable != null) {
                            try {
                                closeable.close();
                            } catch (Throwable th10) {
                                Debugger.m8609e("NT$NetworkUtil_", "response.close() : " + th10.getMessage());
                            }
                        }
                        if (c6850aM5016d != 0) {
                            throw th;
                        }
                        try {
                            c6850aM5016d.m5018b();
                            throw th;
                        } catch (Throwable th11) {
                            Debugger.m8609e("NT$NetworkUtil_", "httpSet.close() : " + th11.getMessage());
                            throw th;
                        }
                    }
                } catch (SocketTimeoutException e2) {
                    e = e2;
                    Debugger.m8609e("NT$NetworkUtil_" + str, "SocketTimeoutException " + e.toString());
                    Debugger.m8617s("NT$NetworkUtil_" + str, httpRequestBaseHC4.hashCode() + " : " + httpRequestBaseHC4.getURI() + " - executeRequest time-out err", e);
                    throw new SyncException(321, e);
                } catch (SSLHandshakeException e3) {
                    e = e3;
                    Debugger.m8609e("NT$NetworkUtil_" + str, "SSLHandshakeException " + e.toString());
                    throw new SyncException(315, e);
                } catch (Exception e5) {
                    e = e5;
                    if ("ZipHeaderError".equals(e.getMessage())) {
                        throw new SyncException(504, "ZipHeaderError");
                    }
                    Debugger.m8609e("NT$NetworkUtil_" + str, "Exception " + e.toString());
                    Debugger.m8617s("NT$NetworkUtil_" + str, httpRequestBaseHC4.hashCode() + " : " + httpRequestBaseHC4.getURI() + " - executeRequest err", e);
                    throw new SyncException(303, e);
                }
            } catch (SyncException e6) {
                e = e6;
                closeable = null;
                c6850aM5016d = c6850aM5016d;
            } catch (SocketTimeoutException e7) {
                e = e7;
            } catch (SSLHandshakeException e8) {
                e = e8;
            } catch (Exception e9) {
                e = e9;
            } catch (Throwable th12) {
                th = th12;
                closeable = null;
                synchronized (f4283a) {
                }
            }
        } catch (SyncException e10) {
            e = e10;
            closeable = null;
            c6850aM5016d = 0;
        } catch (SocketTimeoutException e11) {
            e = e11;
        } catch (SSLHandshakeException e12) {
            e = e12;
        } catch (Exception e13) {
            e = e13;
        } catch (Throwable th13) {
            th = th13;
            closeable = null;
            c6850aM5016d = 0;
        }
    }

    /* JADX WARN: Not initialized variable reg: 10, insn: 0x015a: MOVE (r15 I:??[OBJECT, ARRAY]) = (r10 I:??[OBJECT, ARRAY]) (LINE:347), block:B:47:0x0159 */
    /* JADX WARN: Removed duplicated region for block: B:105:0x0179 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00d4  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x01b1  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0193 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX INFO: renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void m5022b(CloseableHttpResponse closeableHttpResponse, InterfaceC6851b interfaceC6851b) throws Throwable {
        String string;
        int iOptInt;
        Throwable th;
        HttpEntity httpEntity;
        HttpEntity entity;
        InputStream inputStream;
        InputStream content;
        String lowerCase;
        HttpEntity httpEntity2;
        int statusCode = closeableHttpResponse.getStatusLine().getStatusCode();
        if (statusCode != 200) {
            StringBuilder sbM778t = AbstractC0541b.m778t(statusCode, "extractResponse[File]: status = ", " [");
            sbM778t.append(Thread.currentThread().getId());
            sbM778t.append("]");
            Debugger.m8609e("NT$NetworkUtil_", sbM778t.toString());
            if (statusCode != 400) {
                Debugger.m8609e("NT$NetworkUtil_", "There was a problem on the Backup Server. RESULT CODE: " + statusCode);
            }
            try {
                try {
                    string = EntityUtils.toString(closeableHttpResponse.getEntity());
                    try {
                        try {
                            iOptInt = new JSONObject(string).optInt("rcode");
                        } catch (SyncException e) {
                            throw e;
                        }
                    } catch (JSONException e2) {
                        Debugger.m8610e("NT$NetworkUtil_", "JSONObject err : ", e2);
                    } catch (Exception e3) {
                        Debugger.m8609e("NT$NetworkUtil_", "Exception err : " + e3.toString());
                    }
                } catch (IOException e5) {
                    e = e5;
                    string = null;
                    Debugger.m8609e("NT$NetworkUtil_", "IOException err : " + e.toString());
                    throw new SyncException(315, AbstractC2322a.m1616f(statusCode, "error status : ", ", response = ", string));
                }
            } catch (IOException e6) {
                e = e6;
                Debugger.m8609e("NT$NetworkUtil_", "IOException err : " + e.toString());
                throw new SyncException(315, AbstractC2322a.m1616f(statusCode, "error status : ", ", response = ", string));
            }
            if (iOptInt == 19008 || iOptInt == 19018) {
                throw new SyncException(315, "status error : " + statusCode + ", response =" + string);
            }
            if (iOptInt == 116411) {
                throw new SyncException(325, "status error : " + statusCode + ", response =" + string);
            }
            throw new SyncException(315, AbstractC2322a.m1616f(statusCode, "error status : ", ", response = ", string));
        }
        StringBuilder sbM778t2 = AbstractC0541b.m778t(statusCode, "extractResponse[File]: status = ", " [");
        sbM778t2.append(Thread.currentThread().getId());
        sbM778t2.append("]");
        Debugger.m8607d("NT$NetworkUtil_", sbM778t2.toString());
        Header firstHeader = closeableHttpResponse.getFirstHeader("Content-Type");
        if (firstHeader == null) {
            firstHeader = closeableHttpResponse.getFirstHeader("content-type");
        }
        try {
            if (firstHeader != null) {
                try {
                    if (closeableHttpResponse.getEntity() != null) {
                        content = closeableHttpResponse.getEntity().getContent();
                        if (content != null) {
                            try {
                                lowerCase = firstHeader.toString().toLowerCase(Locale.getDefault());
                                entity = closeableHttpResponse.getEntity();
                            } catch (IOException e7) {
                                e = e7;
                            } catch (Throwable th2) {
                                th = th2;
                                inputStream = content;
                                entity = null;
                                if (inputStream != null) {
                                    try {
                                        inputStream.close();
                                    } catch (IOException e8) {
                                        Debugger.m8609e("NT$NetworkUtil_", "InputStream close err " + e8.toString());
                                    }
                                }
                                if (entity != null) {
                                    Debugger.m8609e("NT$NetworkUtil_", "entity is null [" + Thread.currentThread().getId() + "]");
                                    throw th;
                                }
                                try {
                                    entity.consumeContent();
                                    throw th;
                                } catch (IOException e9) {
                                    Debugger.m8609e("NT$NetworkUtil_", "consumeContent err " + e9.toString());
                                    throw new SyncException(303, e9);
                                }
                            }
                            try {
                                Debugger.m8616s("NT$NetworkUtil_", "Header : " + lowerCase + " [" + Thread.currentThread().getId() + "]");
                                entity.getContentLength();
                                interfaceC6851b.mo5001a(firstHeader, content);
                                Debugger.m8616s("NT$NetworkUtil_", "extractResponse[File]: handleResponse out [" + Thread.currentThread().getId() + "]");
                                httpEntity2 = entity;
                            } catch (IOException e10) {
                                e = e10;
                            } catch (Throwable th3) {
                                th = th3;
                                inputStream = content;
                                if (inputStream != null) {
                                }
                                if (entity != null) {
                                }
                            }
                        } else {
                            httpEntity2 = null;
                        }
                    } else {
                        httpEntity2 = null;
                        content = null;
                    }
                    if (httpEntity2 != null) {
                        if (content != null) {
                            try {
                                content.close();
                            } catch (IOException e11) {
                                Debugger.m8609e("NT$NetworkUtil_", "InputStream close err " + e11.toString());
                            }
                        }
                        try {
                            httpEntity2.consumeContent();
                            Debugger.m8616s("NT$NetworkUtil_", "extractResponse[File] finish [" + Thread.currentThread().getId() + "]");
                            return;
                        } catch (IOException e12) {
                            Debugger.m8609e("NT$NetworkUtil_", "consumeContent err " + e12.toString());
                            throw new SyncException(303, e12);
                        }
                    }
                    try {
                        Debugger.m8609e("NT$NetworkUtil_", "can't download a file! [" + Thread.currentThread().getId() + "]");
                        throw new SyncException(303, "response err - header : " + firstHeader);
                    } catch (IOException e13) {
                        e = e13;
                    }
                } catch (IOException e14) {
                    e = e14;
                } catch (Throwable th4) {
                    th = th4;
                    inputStream = null;
                }
            }
            Debugger.m8609e("NT$NetworkUtil_", "handleResponse err " + e.toString());
            throw new SyncException(303, e);
        } catch (Throwable th5) {
            th = th5;
            entity = httpEntity;
        }
    }

    /* JADX INFO: renamed from: c */
    public static void m5023c(CloseableHttpResponse closeableHttpResponse, InterfaceC6853d interfaceC6853d) throws SyncException {
        int statusCode = closeableHttpResponse.getStatusLine().getStatusCode();
        StringBuilder sbM778t = AbstractC0541b.m778t(statusCode, "extractResponse[String]: status = ", " [");
        sbM778t.append(Thread.currentThread().getId());
        sbM778t.append("]");
        Debugger.m8615i("NT$NetworkUtil_", sbM778t.toString());
        HttpEntity entity = closeableHttpResponse.getEntity();
        try {
            try {
                String string = EntityUtils.toString(entity);
                Debugger.m8616s("NT$NetworkUtil_", string);
                if (entity != null) {
                    entity.consumeContent();
                    entity = null;
                }
                if (statusCode != 200 && statusCode != 400) {
                    Debugger.m8609e("NT$NetworkUtil_", "There was a problem on the Backup Server. RESULT CODE: " + statusCode);
                    throw new SyncException(315, "status error : " + statusCode + ", response =" + string);
                }
                Debugger.m8607d("NT$NetworkUtil_", "extractResponse[String]: handleResponse [" + Thread.currentThread().getId() + "]");
                interfaceC6853d.mo5000b(statusCode, string);
                if (m5027g(closeableHttpResponse).contains("application/json")) {
                    try {
                        int iOptInt = new JSONObject(string).optInt("rcode");
                        if (iOptInt == 19008 || iOptInt == 19018) {
                            Debugger.m8615i("NT$NetworkUtil_", "BAD_ACCESS_TOKEN : call accessTokenExpired");
                            throw new SyncException(315, "status error : " + statusCode + ", response =" + string);
                        }
                    } catch (JSONException e) {
                        Debugger.m8610e("NT$NetworkUtil_", "JSONObject err : ", e);
                        throw new SyncException(303, "status error : " + statusCode + ", response =" + string);
                    }
                }
                Debugger.m8607d("NT$NetworkUtil_", "extractResponse[String]: handleResponse out [" + Thread.currentThread().getId() + "]");
                if (entity != null) {
                    try {
                        entity.consumeContent();
                    } catch (IOException e2) {
                        Debugger.m8617s("NT$NetworkUtil_", "consumeContent err", e2);
                        throw new SyncException(303, e2);
                    }
                }
                Debugger.m8607d("NT$NetworkUtil_", "extractResponse[String] finish [" + Thread.currentThread().getId() + "]");
            } catch (IOException e3) {
                Debugger.m8617s("NT$NetworkUtil_", "extractResponse err", e3);
                throw new SyncException(303, "extractResponse err", e3);
            } catch (OutOfMemoryError e5) {
                Debugger.m8617s("NT$NetworkUtil_", "extractResponse err - Converting HTTPEntity to String returns out of Memory", e5);
                throw new SyncException(303, "extractResponse OutOfMemoryError", e5);
            }
        } catch (Throwable th) {
            if (entity != null) {
                try {
                    entity.consumeContent();
                } catch (IOException e6) {
                    Debugger.m8617s("NT$NetworkUtil_", "consumeContent err", e6);
                    throw new SyncException(303, e6);
                }
            }
            throw th;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x01fa A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0165  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x0232  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0214 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX INFO: renamed from: d */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void m5024d(CloseableHttpResponse closeableHttpResponse, C6859j c6859j) throws Throwable {
        HttpEntity httpEntity;
        InputStream content;
        String string;
        int iOptInt;
        C6862m c6862m = c6859j.f4298a;
        int statusCode = closeableHttpResponse.getStatusLine().getStatusCode();
        StringBuilder sbM778t = AbstractC0541b.m778t(statusCode, "extractResponse[File]: status = ", " [");
        sbM778t.append(Thread.currentThread().getId());
        sbM778t.append("]");
        Debugger.m8607d("NT$NetworkUtil_", sbM778t.toString());
        InputStream inputStream = null;
        String str = null;
        entity = null;
        entity = null;
        entity = null;
        entity = null;
        HttpEntity entity = null;
        if (statusCode != 200 && statusCode != 302) {
            if (statusCode != 400) {
                Debugger.m8609e("NT$NetworkUtil_", "There was a problem on the Backup Server. RESULT CODE: " + statusCode);
            }
            try {
                string = EntityUtils.toString(closeableHttpResponse.getEntity());
                try {
                    try {
                        Debugger.m8609e("NT$NetworkUtil_", "status error : " + statusCode + ", response =" + string);
                        try {
                            iOptInt = new JSONObject(string).optInt("rcode");
                        } catch (JSONException e) {
                            Debugger.m8610e("NT$NetworkUtil_", "JSONObject err : ", e);
                        }
                    } catch (IOException e2) {
                        e = e2;
                        str = string;
                        Debugger.m8609e("NT$NetworkUtil_", "IOException err : " + e.toString());
                        string = str;
                    }
                } catch (SyncException e3) {
                    throw e3;
                } catch (Exception e5) {
                    Debugger.m8609e("NT$NetworkUtil_", "Exception err : " + e5.toString());
                }
            } catch (IOException e6) {
                e = e6;
            }
            if (iOptInt == 19008 || iOptInt == 19018) {
                throw new SyncException(315, "status error : " + statusCode + ", response =" + string);
            }
            if (iOptInt == 116411) {
                throw new SyncException(325, "status error : " + statusCode + ", response =" + string);
            }
            C6863n c6863nM5039a = c6862m.m5039a();
            c6863nM5039a.f4336d = null;
            c6863nM5039a.f4333a = statusCode;
            c6863nM5039a.m5046b(null);
            C6865p c6865pM5045a = c6863nM5039a.m5045a();
            c6865pM5045a.m5050d();
            c6862m.f4327m = c6865pM5045a;
            SyncException syncException = new SyncException(315, AbstractC2322a.m1616f(statusCode, "status error : ", ", response =", string));
            syncException.setStatusCode(statusCode);
            throw syncException;
        }
        Header[] allHeaders = closeableHttpResponse.getAllHeaders();
        if (allHeaders != null) {
            try {
                if (closeableHttpResponse.getEntity() != null) {
                    content = closeableHttpResponse.getEntity().getContent();
                    if (content != null) {
                        try {
                            try {
                                entity = closeableHttpResponse.getEntity();
                                entity.getContentLength();
                                C6863n c6863nM5039a2 = c6862m.m5039a();
                                c6863nM5039a2.f4336d = content;
                                c6863nM5039a2.f4333a = statusCode;
                                c6863nM5039a2.m5046b(allHeaders);
                                C6865p c6865pM5045a2 = c6863nM5039a2.m5045a();
                                c6865pM5045a2.m5050d();
                                c6862m.f4327m = c6865pM5045a2;
                            } catch (IOException e7) {
                                e = e7;
                                Debugger.m8609e("NT$NetworkUtil_", "handleResponse err " + e.toString());
                                throw new SyncException(303, e);
                            }
                        } catch (Throwable th) {
                            th = th;
                            httpEntity = entity;
                            inputStream = content;
                            if (inputStream != null) {
                                try {
                                    inputStream.close();
                                } catch (IOException e8) {
                                    Debugger.m8609e("NT$NetworkUtil_", "InputStream close err " + e8.toString());
                                }
                            }
                            if (httpEntity != null) {
                                Debugger.m8609e("NT$NetworkUtil_", "entity is null [" + Thread.currentThread().getId() + "]");
                                throw th;
                            }
                            try {
                                httpEntity.consumeContent();
                                throw th;
                            } catch (IOException e9) {
                                Debugger.m8609e("NT$NetworkUtil_", "consumeContent err " + e9.toString());
                                throw new SyncException(303, e9);
                            }
                        }
                    }
                } else {
                    content = null;
                }
            } catch (IOException e10) {
                e = e10;
                content = null;
                Debugger.m8609e("NT$NetworkUtil_", "handleResponse err " + e.toString());
                throw new SyncException(303, e);
            } catch (Throwable th2) {
                th = th2;
                httpEntity = null;
                if (inputStream != null) {
                }
                if (httpEntity != null) {
                }
            }
        }
        if (entity == null) {
            Debugger.m8609e("NT$NetworkUtil_", "can't download a file! [" + Thread.currentThread().getId() + "]");
            throw new SyncException(303, "response err - entity is null!");
        }
        if (content != null) {
            try {
                content.close();
            } catch (IOException e11) {
                Debugger.m8609e("NT$NetworkUtil_", "InputStream close err " + e11.toString());
            }
        }
        try {
            entity.consumeContent();
            Debugger.m8616s("NT$NetworkUtil_", "extractResponse[File] finish [" + Thread.currentThread().getId() + "]");
        } catch (IOException e12) {
            Debugger.m8609e("NT$NetworkUtil_", "consumeContent err " + e12.toString());
            throw new SyncException(303, e12);
        }
    }

    /* JADX INFO: renamed from: e */
    public static void m5025e(CloseableHttpResponse closeableHttpResponse, C6860k c6860k) throws SyncException {
        int statusCode = closeableHttpResponse.getStatusLine().getStatusCode();
        StringBuilder sbM778t = AbstractC0541b.m778t(statusCode, "extractResponse[String]: status = ", " [");
        sbM778t.append(Thread.currentThread().getId());
        sbM778t.append("]");
        Debugger.m8607d("NT$NetworkUtil_", sbM778t.toString());
        HttpEntity entity = closeableHttpResponse.getEntity();
        try {
            try {
                Header[] allHeaders = closeableHttpResponse.getAllHeaders();
                String str = null;
                if (entity != null) {
                    String string = EntityUtils.toString(entity);
                    entity.consumeContent();
                    entity = null;
                    str = string;
                }
                c6860k.m5030c(statusCode, allHeaders, str);
                if (entity != null) {
                    try {
                        entity.consumeContent();
                    } catch (IOException e) {
                        Debugger.m8617s("NT$NetworkUtil_", "consumeContent err", e);
                        throw new SyncException(303, e);
                    }
                }
                Debugger.m8607d("NT$NetworkUtil_", "extractResponse[String] finish [" + Thread.currentThread().getId() + "]");
            } catch (Throwable th) {
                if (entity != null) {
                    try {
                        entity.consumeContent();
                    } catch (IOException e2) {
                        Debugger.m8617s("NT$NetworkUtil_", "consumeContent err", e2);
                        throw new SyncException(303, e2);
                    }
                }
                throw th;
            }
        } catch (IOException e3) {
            Debugger.m8617s("NT$NetworkUtil_", "extractResponse err", e3);
            throw new SyncException(303, "extractResponse err", e3);
        } catch (OutOfMemoryError e5) {
            Debugger.m8617s("NT$NetworkUtil_", "extractResponse err - Converting HTTPEntity to String returns out of Memory", e5);
            throw new SyncException(303, "extractResponse OutOfMemoryError", e5);
        }
    }

    /* JADX INFO: renamed from: f */
    public static void m5026f(String str, String str2, Map map, InterfaceC6852c interfaceC6852c) {
        HttpGetHC4 httpGetHC4 = new HttpGetHC4(str2);
        if (map != null) {
            for (Map.Entry entry : map.entrySet()) {
                httpGetHC4.addHeader((String) entry.getKey(), (String) entry.getValue());
            }
        }
        m5021a(str, httpGetHC4, interfaceC6852c);
    }

    /* JADX INFO: renamed from: g */
    public static String m5027g(CloseableHttpResponse closeableHttpResponse) {
        for (Header header : closeableHttpResponse.getAllHeaders()) {
            if (header.getName().equalsIgnoreCase("Content-Type")) {
                return header.getValue();
            }
        }
        return "";
    }

    /* JADX INFO: renamed from: h */
    public static void m5028h(String str, String str2, HashMap map, C6844i c6844i) throws Throwable {
        HttpPostHC4 httpPostHC4 = new HttpPostHC4(str2);
        for (Map.Entry entry : map.entrySet()) {
            httpPostHC4.addHeader((String) entry.getKey(), (String) entry.getValue());
        }
        m5021a(str, httpPostHC4, c6844i);
    }

    /* JADX INFO: renamed from: i */
    public static void m5029i(String str, String str2, HashMap map, HttpEntity httpEntity, C6844i c6844i) throws Throwable {
        String strM772n = AbstractC0541b.m772n("NT$NetworkUtil_", str);
        StringBuilder sbM15l = AbstractC0000a.m15l("postMultiPart - ", str2, "\nPayload : MultipartEntity, Size - ");
        sbM15l.append(httpEntity.getContentLength());
        Debugger.m8616s(strM772n, sbM15l.toString());
        HttpPostHC4 httpPostHC4 = new HttpPostHC4(str2);
        for (Map.Entry entry : map.entrySet()) {
            httpPostHC4.addHeader((String) entry.getKey(), (String) entry.getValue());
        }
        httpPostHC4.setEntity(httpEntity);
        m5021a(str, httpPostHC4, c6844i);
    }
}
