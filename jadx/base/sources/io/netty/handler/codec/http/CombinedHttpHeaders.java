package io.netty.handler.codec.http;

import io.netty.handler.codec.DefaultHeaders;
import io.netty.handler.codec.Headers;
import io.netty.handler.codec.ValueConverter;
import io.netty.util.AsciiString;
import io.netty.util.HashingStrategy;
import io.netty.util.internal.StringUtil;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public class CombinedHttpHeaders extends DefaultHttpHeaders {

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class CombinedHttpHeadersImpl extends DefaultHeaders<CharSequence, CharSequence, CombinedHttpHeadersImpl> {
        private static final int VALUE_LENGTH_ESTIMATE = 10;
        private CsvValueEscaper<CharSequence> charSequenceEscaper;
        private CsvValueEscaper<Object> objectEscaper;

        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        public interface CsvValueEscaper<T> {
            CharSequence escape(CharSequence charSequence, T t);
        }

        public CombinedHttpHeadersImpl(HashingStrategy<CharSequence> hashingStrategy, ValueConverter<CharSequence> valueConverter, DefaultHeaders.NameValidator<CharSequence> nameValidator, DefaultHeaders.ValueValidator<CharSequence> valueValidator) {
            super(hashingStrategy, valueConverter, nameValidator, 16, valueValidator);
        }

        private CombinedHttpHeadersImpl addEscapedValue(CharSequence charSequence, CharSequence charSequence2) {
            CharSequence charSequence3 = get(charSequence);
            if (charSequence3 == null || cannotBeCombined(charSequence)) {
                super.add(charSequence, charSequence2);
                return this;
            }
            set(charSequence, commaSeparateEscapedValues(charSequence3, charSequence2));
            return this;
        }

        private static boolean cannotBeCombined(CharSequence charSequence) {
            return HttpHeaderNames.SET_COOKIE.contentEqualsIgnoreCase(charSequence);
        }

        private CsvValueEscaper<CharSequence> charSequenceEscaper() {
            if (this.charSequenceEscaper == null) {
                this.charSequenceEscaper = new CsvValueEscaper<CharSequence>() { // from class: io.netty.handler.codec.http.CombinedHttpHeaders.CombinedHttpHeadersImpl.2
                    @Override // io.netty.handler.codec.http.CombinedHttpHeaders.CombinedHttpHeadersImpl.CsvValueEscaper
                    public CharSequence escape(CharSequence charSequence, CharSequence charSequence2) {
                        return StringUtil.escapeCsv(charSequence2, true);
                    }
                };
            }
            return this.charSequenceEscaper;
        }

        private static <T> CharSequence commaSeparate(CharSequence charSequence, CsvValueEscaper<T> csvValueEscaper, T... tArr) {
            StringBuilder sb = new StringBuilder(tArr.length * 10);
            if (tArr.length > 0) {
                int length = tArr.length - 1;
                for (int i = 0; i < length; i++) {
                    sb.append(csvValueEscaper.escape(charSequence, tArr[i]));
                    sb.append(',');
                }
                sb.append(csvValueEscaper.escape(charSequence, tArr[length]));
            }
            return sb;
        }

        private static CharSequence commaSeparateEscapedValues(CharSequence charSequence, CharSequence charSequence2) {
            StringBuilder sb = new StringBuilder(charSequence2.length() + charSequence.length() + 1);
            sb.append(charSequence);
            sb.append(',');
            sb.append(charSequence2);
            return sb;
        }

        private CsvValueEscaper<Object> objectEscaper() {
            if (this.objectEscaper == null) {
                this.objectEscaper = new CsvValueEscaper<Object>() { // from class: io.netty.handler.codec.http.CombinedHttpHeaders.CombinedHttpHeadersImpl.1
                    @Override // io.netty.handler.codec.http.CombinedHttpHeaders.CombinedHttpHeadersImpl.CsvValueEscaper
                    public CharSequence escape(CharSequence charSequence, Object obj) {
                        try {
                            return StringUtil.escapeCsv((CharSequence) CombinedHttpHeadersImpl.this.valueConverter().convertObject(obj), true);
                        } catch (IllegalArgumentException e) {
                            throw new IllegalArgumentException("Failed to convert object value for header '" + ((Object) charSequence) + '\'', e);
                        }
                    }
                };
            }
            return this.objectEscaper;
        }

        @Override // io.netty.handler.codec.DefaultHeaders, io.netty.handler.codec.Headers
        public /* bridge */ /* synthetic */ Headers add(Headers headers) {
            return add((Headers<? extends CharSequence, ? extends CharSequence, ?>) headers);
        }

        @Override // io.netty.handler.codec.DefaultHeaders, io.netty.handler.codec.Headers
        public /* bridge */ /* synthetic */ Headers addObject(Object obj, Iterable iterable) {
            return addObject((CharSequence) obj, (Iterable<?>) iterable);
        }

        @Override // io.netty.handler.codec.DefaultHeaders, io.netty.handler.codec.Headers
        public /* bridge */ /* synthetic */ Headers set(Headers headers) {
            return set((Headers<? extends CharSequence, ? extends CharSequence, ?>) headers);
        }

        @Override // io.netty.handler.codec.DefaultHeaders, io.netty.handler.codec.Headers
        public /* bridge */ /* synthetic */ Headers setAll(Headers headers) {
            return setAll((Headers<? extends CharSequence, ? extends CharSequence, ?>) headers);
        }

        @Override // io.netty.handler.codec.DefaultHeaders, io.netty.handler.codec.Headers
        public /* bridge */ /* synthetic */ Headers setObject(Object obj, Iterable iterable) {
            return setObject((CharSequence) obj, (Iterable<?>) iterable);
        }

        @Override // io.netty.handler.codec.DefaultHeaders, io.netty.handler.codec.Headers
        public /* bridge */ /* synthetic */ Headers add(Object obj, Iterable iterable) {
            return add((CharSequence) obj, (Iterable<? extends CharSequence>) iterable);
        }

        @Override // io.netty.handler.codec.DefaultHeaders, io.netty.handler.codec.Headers
        public List<CharSequence> getAll(CharSequence charSequence) {
            List<CharSequence> all = super.getAll(charSequence);
            if (all.isEmpty() || cannotBeCombined(charSequence)) {
                return all;
            }
            if (all.size() == 1) {
                return StringUtil.unescapeCsvFields(all.get(0));
            }
            throw new IllegalStateException("CombinedHttpHeaders should only have one value");
        }

        @Override // io.netty.handler.codec.DefaultHeaders, io.netty.handler.codec.Headers
        public /* bridge */ /* synthetic */ Headers set(Object obj, Iterable iterable) {
            return set((CharSequence) obj, (Iterable<? extends CharSequence>) iterable);
        }

        @Override // io.netty.handler.codec.DefaultHeaders, io.netty.handler.codec.Headers
        public CombinedHttpHeadersImpl setAll(Headers<? extends CharSequence, ? extends CharSequence, ?> headers) {
            if (headers == this) {
                return this;
            }
            Iterator<? extends CharSequence> it = headers.names().iterator();
            while (it.hasNext()) {
                remove(it.next());
            }
            return add(headers);
        }

        @Override // io.netty.handler.codec.DefaultHeaders
        public Iterator<CharSequence> valueIterator(CharSequence charSequence) {
            Iterator<CharSequence> itValueIterator = super.valueIterator(charSequence);
            if (!itValueIterator.hasNext() || cannotBeCombined(charSequence)) {
                return itValueIterator;
            }
            Iterator<CharSequence> it = StringUtil.unescapeCsvFields(itValueIterator.next()).iterator();
            if (itValueIterator.hasNext()) {
                throw new IllegalStateException("CombinedHttpHeaders should only have one value");
            }
            return it;
        }

        @Override // io.netty.handler.codec.DefaultHeaders, io.netty.handler.codec.Headers
        public CombinedHttpHeadersImpl addObject(CharSequence charSequence, Object obj) {
            return addEscapedValue(charSequence, commaSeparate(charSequence, objectEscaper(), obj));
        }

        @Override // io.netty.handler.codec.DefaultHeaders, io.netty.handler.codec.Headers
        public CombinedHttpHeadersImpl set(Headers<? extends CharSequence, ? extends CharSequence, ?> headers) {
            if (headers == this) {
                return this;
            }
            clear();
            return add(headers);
        }

        @Override // io.netty.handler.codec.DefaultHeaders, io.netty.handler.codec.Headers
        public CombinedHttpHeadersImpl setObject(CharSequence charSequence, Object obj) {
            set(charSequence, commaSeparate(charSequence, objectEscaper(), obj));
            return this;
        }

        @Override // io.netty.handler.codec.DefaultHeaders, io.netty.handler.codec.Headers
        public CombinedHttpHeadersImpl add(Headers<? extends CharSequence, ? extends CharSequence, ?> headers) {
            if (headers != this) {
                if (headers instanceof CombinedHttpHeadersImpl) {
                    if (isEmpty()) {
                        addImpl(headers);
                        return this;
                    }
                    for (Map.Entry<? extends CharSequence, ? extends CharSequence> entry : headers) {
                        addEscapedValue(entry.getKey(), entry.getValue());
                    }
                } else {
                    for (Map.Entry<? extends CharSequence, ? extends CharSequence> entry2 : headers) {
                        add(entry2.getKey(), entry2.getValue());
                    }
                }
                return this;
            }
            throw new IllegalArgumentException("can't add to itself.");
        }

        public CombinedHttpHeadersImpl addObject(CharSequence charSequence, Iterable<?> iterable) {
            return addEscapedValue(charSequence, commaSeparate(charSequence, objectEscaper(), iterable));
        }

        @Override // io.netty.handler.codec.DefaultHeaders, io.netty.handler.codec.Headers
        public CombinedHttpHeadersImpl setObject(CharSequence charSequence, Object... objArr) {
            set(charSequence, commaSeparate(charSequence, objectEscaper(), objArr));
            return this;
        }

        private static <T> CharSequence commaSeparate(CharSequence charSequence, CsvValueEscaper<T> csvValueEscaper, Iterable<? extends T> iterable) {
            StringBuilder sb = iterable instanceof Collection ? new StringBuilder(((Collection) iterable).size() * 10) : new StringBuilder();
            Iterator<? extends T> it = iterable.iterator();
            if (it.hasNext()) {
                T next = it.next();
                while (it.hasNext()) {
                    sb.append(csvValueEscaper.escape(charSequence, next));
                    sb.append(',');
                    next = it.next();
                }
                sb.append(csvValueEscaper.escape(charSequence, next));
            }
            return sb;
        }

        @Override // io.netty.handler.codec.DefaultHeaders, io.netty.handler.codec.Headers
        public CombinedHttpHeadersImpl addObject(CharSequence charSequence, Object... objArr) {
            return addEscapedValue(charSequence, commaSeparate(charSequence, objectEscaper(), objArr));
        }

        @Override // io.netty.handler.codec.DefaultHeaders, io.netty.handler.codec.Headers
        public CombinedHttpHeadersImpl set(CharSequence charSequence, CharSequence... charSequenceArr) {
            set(charSequence, commaSeparate(charSequence, charSequenceEscaper(), charSequenceArr));
            return this;
        }

        public CombinedHttpHeadersImpl setObject(CharSequence charSequence, Iterable<?> iterable) {
            set(charSequence, commaSeparate(charSequence, objectEscaper(), iterable));
            return this;
        }

        public CombinedHttpHeadersImpl set(CharSequence charSequence, Iterable<? extends CharSequence> iterable) {
            set(charSequence, commaSeparate(charSequence, charSequenceEscaper(), iterable));
            return this;
        }

        @Override // io.netty.handler.codec.DefaultHeaders, io.netty.handler.codec.Headers
        public CombinedHttpHeadersImpl add(CharSequence charSequence, CharSequence charSequence2) {
            return addEscapedValue(charSequence, charSequenceEscaper().escape(charSequence, charSequence2));
        }

        @Override // io.netty.handler.codec.DefaultHeaders, io.netty.handler.codec.Headers
        public CombinedHttpHeadersImpl add(CharSequence charSequence, CharSequence... charSequenceArr) {
            return addEscapedValue(charSequence, commaSeparate(charSequence, charSequenceEscaper(), charSequenceArr));
        }

        public CombinedHttpHeadersImpl add(CharSequence charSequence, Iterable<? extends CharSequence> iterable) {
            return addEscapedValue(charSequence, commaSeparate(charSequence, charSequenceEscaper(), iterable));
        }
    }

    public CombinedHttpHeaders(boolean z) {
        super(new CombinedHttpHeadersImpl(AsciiString.CASE_INSENSITIVE_HASHER, DefaultHttpHeaders.valueConverter(), DefaultHttpHeaders.nameValidator(z), DefaultHttpHeaders.valueValidator(z)));
    }

    @Override // io.netty.handler.codec.http.HttpHeaders
    public boolean containsValue(CharSequence charSequence, CharSequence charSequence2, boolean z) {
        return super.containsValue(charSequence, StringUtil.trimOws(charSequence2), z);
    }
}
