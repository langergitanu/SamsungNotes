package cz.msebera.android.httpclient.util;

import cz.msebera.android.httpclient.HeaderElement;
import cz.msebera.android.httpclient.HttpEntity;
import cz.msebera.android.httpclient.HttpResponse;
import cz.msebera.android.httpclient.NameValuePair;
import cz.msebera.android.httpclient.entity.ContentType;
import cz.msebera.android.httpclient.protocol.HTTP;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.nio.charset.UnsupportedCharsetException;
import opennlp.tools.formats.brat.AnnotationConfiguration;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public final class EntityUtils {
    private static final int DEFAULT_BUFFER_SIZE = 4096;

    private EntityUtils() {
    }

    public static void consume(HttpEntity httpEntity) {
        InputStream content;
        if (httpEntity == null || !httpEntity.isStreaming() || (content = httpEntity.getContent()) == null) {
            return;
        }
        content.close();
    }

    public static void consumeQuietly(HttpEntity httpEntity) {
        try {
            consume(httpEntity);
        } catch (IOException unused) {
        }
    }

    @Deprecated
    public static String getContentCharSet(HttpEntity httpEntity) {
        NameValuePair parameterByName;
        Args.notNull(httpEntity, AnnotationConfiguration.ENTITY_TYPE);
        if (httpEntity.getContentType() == null) {
            return null;
        }
        HeaderElement[] elements = httpEntity.getContentType().getElements();
        if (elements.length <= 0 || (parameterByName = elements[0].getParameterByName("charset")) == null) {
            return null;
        }
        return parameterByName.getValue();
    }

    @Deprecated
    public static String getContentMimeType(HttpEntity httpEntity) {
        Args.notNull(httpEntity, AnnotationConfiguration.ENTITY_TYPE);
        if (httpEntity.getContentType() == null) {
            return null;
        }
        HeaderElement[] elements = httpEntity.getContentType().getElements();
        if (elements.length > 0) {
            return elements[0].getName();
        }
        return null;
    }

    public static byte[] toByteArray(HttpEntity httpEntity) throws IOException {
        Args.notNull(httpEntity, AnnotationConfiguration.ENTITY_TYPE);
        InputStream content = httpEntity.getContent();
        if (content == null) {
            return null;
        }
        try {
            Args.check(httpEntity.getContentLength() <= 2147483647L, "HTTP entity too large to be buffered in memory");
            int contentLength = (int) httpEntity.getContentLength();
            if (contentLength < 0) {
                contentLength = 4096;
            }
            ByteArrayBuffer byteArrayBuffer = new ByteArrayBuffer(contentLength);
            byte[] bArr = new byte[4096];
            while (true) {
                int i = content.read(bArr);
                if (i == -1) {
                    byte[] byteArray = byteArrayBuffer.toByteArray();
                    content.close();
                    return byteArray;
                }
                byteArrayBuffer.append(bArr, 0, i);
            }
        } catch (Throwable th) {
            content.close();
            throw th;
        }
    }

    private static String toString(HttpEntity httpEntity, ContentType contentType) throws IOException {
        InputStream content = httpEntity.getContent();
        Charset charset = null;
        if (content == null) {
            return null;
        }
        try {
            Args.check(httpEntity.getContentLength() <= 2147483647L, "HTTP entity too large to be buffered in memory");
            int contentLength = (int) httpEntity.getContentLength();
            if (contentLength < 0) {
                contentLength = 4096;
            }
            if (contentType != null) {
                Charset charset2 = contentType.getCharset();
                if (charset2 == null) {
                    ContentType byMimeType = ContentType.getByMimeType(contentType.getMimeType());
                    if (byMimeType != null) {
                        charset = byMimeType.getCharset();
                    }
                } else {
                    charset = charset2;
                }
            }
            if (charset == null) {
                charset = HTTP.DEF_CONTENT_CHARSET;
            }
            InputStreamReader inputStreamReader = new InputStreamReader(content, charset);
            CharArrayBuffer charArrayBuffer = new CharArrayBuffer(contentLength);
            char[] cArr = new char[1024];
            while (true) {
                int i = inputStreamReader.read(cArr);
                if (i == -1) {
                    String string = charArrayBuffer.toString();
                    content.close();
                    return string;
                }
                charArrayBuffer.append(cArr, 0, i);
            }
        } catch (Throwable th) {
            content.close();
            throw th;
        }
    }

    public static void updateEntity(HttpResponse httpResponse, HttpEntity httpEntity) {
        Args.notNull(httpResponse, "Response");
        consume(httpResponse.getEntity());
        httpResponse.setEntity(httpEntity);
    }

    public static String toString(HttpEntity httpEntity, Charset charset) throws UnsupportedEncodingException {
        ContentType contentTypeWithCharset;
        Args.notNull(httpEntity, AnnotationConfiguration.ENTITY_TYPE);
        try {
            contentTypeWithCharset = ContentType.get(httpEntity);
        } catch (UnsupportedCharsetException e) {
            if (charset == null) {
                throw new UnsupportedEncodingException(e.getMessage());
            }
            contentTypeWithCharset = null;
        }
        if (contentTypeWithCharset != null) {
            if (contentTypeWithCharset.getCharset() == null) {
                contentTypeWithCharset = contentTypeWithCharset.withCharset(charset);
            }
        } else {
            contentTypeWithCharset = ContentType.DEFAULT_TEXT.withCharset(charset);
        }
        return toString(httpEntity, contentTypeWithCharset);
    }

    public static String toString(HttpEntity httpEntity, String str) {
        return toString(httpEntity, str != null ? Charset.forName(str) : null);
    }

    public static String toString(HttpEntity httpEntity) {
        Args.notNull(httpEntity, AnnotationConfiguration.ENTITY_TYPE);
        return toString(httpEntity, ContentType.get(httpEntity));
    }
}
