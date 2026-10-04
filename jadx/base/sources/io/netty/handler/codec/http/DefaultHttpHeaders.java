package io.netty.handler.codec.http;

import io.netty.handler.codec.CharSequenceValueConverter;
import io.netty.handler.codec.DateFormatter;
import io.netty.handler.codec.DefaultHeaders;
import io.netty.handler.codec.DefaultHeadersImpl;
import io.netty.handler.codec.HeadersUtils;
import io.netty.handler.codec.ValueConverter;
import io.netty.util.AsciiString;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.apache.commons.beanutils.PropertyUtils;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public class DefaultHttpHeaders extends HttpHeaders {
    static final DefaultHeaders.NameValidator<CharSequence> HttpNameValidator = new DefaultHeaders.NameValidator<CharSequence>() { // from class: io.netty.handler.codec.http.DefaultHttpHeaders.1
        @Override // io.netty.handler.codec.DefaultHeaders.NameValidator
        public void validateName(CharSequence charSequence) {
            if (charSequence == null || charSequence.length() == 0) {
                throw new IllegalArgumentException("empty headers are not allowed [" + ((Object) charSequence) + PropertyUtils.INDEXED_DELIM2);
            }
            int iValidateToken = HttpHeaderValidationUtil.validateToken(charSequence);
            if (iValidateToken == -1) {
                return;
            }
            throw new IllegalArgumentException("a header name can only contain \"token\" characters, but found invalid character 0x" + Integer.toHexString(charSequence.charAt(iValidateToken)) + " at index " + iValidateToken + " of header '" + ((Object) charSequence) + "'.");
        }
    };
    private final DefaultHeaders<CharSequence, CharSequence, ?> headers;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class HeaderValueConverter extends CharSequenceValueConverter {
        static final HeaderValueConverter INSTANCE = new HeaderValueConverter();

        private HeaderValueConverter() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // io.netty.handler.codec.CharSequenceValueConverter, io.netty.handler.codec.ValueConverter
        public CharSequence convertObject(Object obj) {
            return obj instanceof CharSequence ? (CharSequence) obj : obj instanceof Date ? DateFormatter.format((Date) obj) : obj instanceof Calendar ? DateFormatter.format(((Calendar) obj).getTime()) : obj.toString();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class HeaderValueValidator implements DefaultHeaders.ValueValidator<CharSequence> {
        static final HeaderValueValidator INSTANCE = new HeaderValueValidator();

        private HeaderValueValidator() {
        }

        @Override // io.netty.handler.codec.DefaultHeaders.ValueValidator
        public void validate(CharSequence charSequence) {
            int iValidateValidHeaderValue = HttpHeaderValidationUtil.validateValidHeaderValue(charSequence);
            if (iValidateValidHeaderValue == -1) {
                return;
            }
            throw new IllegalArgumentException("a header value contains prohibited character 0x" + Integer.toHexString(charSequence.charAt(iValidateValidHeaderValue)) + " at index " + iValidateValidHeaderValue + '.');
        }
    }

    public DefaultHttpHeaders() {
        this(true);
    }

    public static DefaultHeaders.NameValidator<CharSequence> nameValidator(boolean z) {
        return z ? HttpNameValidator : DefaultHeaders.NameValidator.NOT_NULL;
    }

    public static ValueConverter<CharSequence> valueConverter() {
        return HeaderValueConverter.INSTANCE;
    }

    public static DefaultHeaders.ValueValidator<CharSequence> valueValidator(boolean z) {
        return z ? HeaderValueValidator.INSTANCE : DefaultHeaders.ValueValidator.NO_VALIDATION;
    }

    @Override // io.netty.handler.codec.http.HttpHeaders
    public HttpHeaders add(HttpHeaders httpHeaders) {
        if (!(httpHeaders instanceof DefaultHttpHeaders)) {
            return super.add(httpHeaders);
        }
        this.headers.add(((DefaultHttpHeaders) httpHeaders).headers);
        return this;
    }

    @Override // io.netty.handler.codec.http.HttpHeaders
    public HttpHeaders addInt(CharSequence charSequence, int i) {
        this.headers.addInt(charSequence, i);
        return this;
    }

    @Override // io.netty.handler.codec.http.HttpHeaders
    public HttpHeaders addShort(CharSequence charSequence, short s) {
        this.headers.addShort(charSequence, s);
        return this;
    }

    @Override // io.netty.handler.codec.http.HttpHeaders
    public HttpHeaders clear() {
        this.headers.clear();
        return this;
    }

    @Override // io.netty.handler.codec.http.HttpHeaders
    public boolean contains(String str) {
        return contains((CharSequence) str);
    }

    @Override // io.netty.handler.codec.http.HttpHeaders
    public HttpHeaders copy() {
        return new DefaultHttpHeaders((DefaultHeaders<CharSequence, CharSequence, ?>) this.headers.copy());
    }

    @Override // io.netty.handler.codec.http.HttpHeaders
    public List<Map.Entry<String, String>> entries() {
        if (isEmpty()) {
            return Collections.EMPTY_LIST;
        }
        ArrayList arrayList = new ArrayList(this.headers.size());
        Iterator<Map.Entry<String, String>> it = iterator();
        while (it.hasNext()) {
            arrayList.add(it.next());
        }
        return arrayList;
    }

    public boolean equals(Object obj) {
        return (obj instanceof DefaultHttpHeaders) && this.headers.equals(((DefaultHttpHeaders) obj).headers, AsciiString.CASE_SENSITIVE_HASHER);
    }

    @Override // io.netty.handler.codec.http.HttpHeaders
    public String get(String str) {
        return get((CharSequence) str);
    }

    @Override // io.netty.handler.codec.http.HttpHeaders
    public List<String> getAll(String str) {
        return getAll((CharSequence) str);
    }

    @Override // io.netty.handler.codec.http.HttpHeaders
    public Integer getInt(CharSequence charSequence) {
        return this.headers.getInt(charSequence);
    }

    @Override // io.netty.handler.codec.http.HttpHeaders
    public Short getShort(CharSequence charSequence) {
        return this.headers.getShort(charSequence);
    }

    @Override // io.netty.handler.codec.http.HttpHeaders
    public Long getTimeMillis(CharSequence charSequence) {
        return this.headers.getTimeMillis(charSequence);
    }

    public int hashCode() {
        return this.headers.hashCode(AsciiString.CASE_SENSITIVE_HASHER);
    }

    @Override // io.netty.handler.codec.http.HttpHeaders
    public boolean isEmpty() {
        return this.headers.isEmpty();
    }

    @Override // io.netty.handler.codec.http.HttpHeaders, java.lang.Iterable
    @Deprecated
    public Iterator<Map.Entry<String, String>> iterator() {
        return HeadersUtils.iteratorAsString(this.headers);
    }

    @Override // io.netty.handler.codec.http.HttpHeaders
    public Iterator<Map.Entry<CharSequence, CharSequence>> iteratorCharSequence() {
        return this.headers.iterator();
    }

    @Override // io.netty.handler.codec.http.HttpHeaders
    public Set<String> names() {
        return HeadersUtils.namesAsString(this.headers);
    }

    @Override // io.netty.handler.codec.http.HttpHeaders
    public HttpHeaders remove(String str) {
        this.headers.remove(str);
        return this;
    }

    @Override // io.netty.handler.codec.http.HttpHeaders
    public HttpHeaders set(HttpHeaders httpHeaders) {
        if (!(httpHeaders instanceof DefaultHttpHeaders)) {
            return super.set(httpHeaders);
        }
        this.headers.set(((DefaultHttpHeaders) httpHeaders).headers);
        return this;
    }

    @Override // io.netty.handler.codec.http.HttpHeaders
    public HttpHeaders setInt(CharSequence charSequence, int i) {
        this.headers.setInt(charSequence, i);
        return this;
    }

    @Override // io.netty.handler.codec.http.HttpHeaders
    public HttpHeaders setShort(CharSequence charSequence, short s) {
        this.headers.setShort(charSequence, s);
        return this;
    }

    @Override // io.netty.handler.codec.http.HttpHeaders
    public int size() {
        return this.headers.size();
    }

    @Override // io.netty.handler.codec.http.HttpHeaders
    public Iterator<CharSequence> valueCharSequenceIterator(CharSequence charSequence) {
        return this.headers.valueIterator(charSequence);
    }

    @Override // io.netty.handler.codec.http.HttpHeaders
    public Iterator<String> valueStringIterator(CharSequence charSequence) {
        final Iterator<CharSequence> itValueCharSequenceIterator = valueCharSequenceIterator(charSequence);
        return new Iterator<String>() { // from class: io.netty.handler.codec.http.DefaultHttpHeaders.2
            @Override // java.util.Iterator
            public boolean hasNext() {
                return itValueCharSequenceIterator.hasNext();
            }

            @Override // java.util.Iterator
            public void remove() {
                itValueCharSequenceIterator.remove();
            }

            @Override // java.util.Iterator
            public String next() {
                return ((CharSequence) itValueCharSequenceIterator.next()).toString();
            }
        };
    }

    public DefaultHttpHeaders(boolean z) {
        this(z, nameValidator(z));
    }

    @Override // io.netty.handler.codec.http.HttpHeaders
    public boolean contains(CharSequence charSequence) {
        return this.headers.contains(charSequence);
    }

    @Override // io.netty.handler.codec.http.HttpHeaders
    public String get(CharSequence charSequence) {
        return HeadersUtils.getAsString(this.headers, charSequence);
    }

    @Override // io.netty.handler.codec.http.HttpHeaders
    public List<String> getAll(CharSequence charSequence) {
        return HeadersUtils.getAllAsString(this.headers, charSequence);
    }

    @Override // io.netty.handler.codec.http.HttpHeaders
    public int getInt(CharSequence charSequence, int i) {
        return this.headers.getInt(charSequence, i);
    }

    @Override // io.netty.handler.codec.http.HttpHeaders
    public short getShort(CharSequence charSequence, short s) {
        return this.headers.getShort(charSequence, s);
    }

    @Override // io.netty.handler.codec.http.HttpHeaders
    public long getTimeMillis(CharSequence charSequence, long j) {
        return this.headers.getTimeMillis(charSequence, j);
    }

    @Override // io.netty.handler.codec.http.HttpHeaders
    public HttpHeaders remove(CharSequence charSequence) {
        this.headers.remove(charSequence);
        return this;
    }

    public DefaultHttpHeaders(boolean z, DefaultHeaders.NameValidator<CharSequence> nameValidator) {
        this(new DefaultHeadersImpl(AsciiString.CASE_INSENSITIVE_HASHER, HeaderValueConverter.INSTANCE, nameValidator, 16, valueValidator(z)));
    }

    @Override // io.netty.handler.codec.http.HttpHeaders
    public boolean contains(String str, String str2, boolean z) {
        return contains((CharSequence) str, (CharSequence) str2, z);
    }

    @Override // io.netty.handler.codec.http.HttpHeaders
    public HttpHeaders add(String str, Object obj) {
        this.headers.addObject(str, obj);
        return this;
    }

    @Override // io.netty.handler.codec.http.HttpHeaders
    public boolean contains(CharSequence charSequence, CharSequence charSequence2, boolean z) {
        return this.headers.contains(charSequence, charSequence2, z ? AsciiString.CASE_INSENSITIVE_HASHER : AsciiString.CASE_SENSITIVE_HASHER);
    }

    @Override // io.netty.handler.codec.http.HttpHeaders
    public HttpHeaders set(String str, Object obj) {
        this.headers.setObject(str, obj);
        return this;
    }

    @Override // io.netty.handler.codec.http.HttpHeaders
    public HttpHeaders add(CharSequence charSequence, Object obj) {
        this.headers.addObject(charSequence, obj);
        return this;
    }

    @Override // io.netty.handler.codec.http.HttpHeaders
    public HttpHeaders set(CharSequence charSequence, Object obj) {
        this.headers.setObject(charSequence, obj);
        return this;
    }

    public DefaultHttpHeaders(DefaultHeaders<CharSequence, CharSequence, ?> defaultHeaders) {
        this.headers = defaultHeaders;
    }

    @Override // io.netty.handler.codec.http.HttpHeaders
    public HttpHeaders add(String str, Iterable<?> iterable) {
        this.headers.addObject(str, iterable);
        return this;
    }

    @Override // io.netty.handler.codec.http.HttpHeaders
    public HttpHeaders set(String str, Iterable<?> iterable) {
        this.headers.setObject(str, iterable);
        return this;
    }

    @Override // io.netty.handler.codec.http.HttpHeaders
    public HttpHeaders add(CharSequence charSequence, Iterable<?> iterable) {
        this.headers.addObject(charSequence, iterable);
        return this;
    }

    @Override // io.netty.handler.codec.http.HttpHeaders
    public HttpHeaders set(CharSequence charSequence, Iterable<?> iterable) {
        this.headers.setObject(charSequence, iterable);
        return this;
    }
}
