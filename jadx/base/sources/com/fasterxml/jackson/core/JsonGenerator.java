package com.fasterxml.jackson.core;

import com.fasterxml.jackson.core.p128io.CharacterEscapes;
import java.io.Closeable;
import java.io.Flushable;
import java.io.InputStream;
import java.math.BigDecimal;
import java.math.BigInteger;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public abstract class JsonGenerator implements Closeable, Flushable, Versioned {
    protected PrettyPrinter _cfgPrettyPrinter;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public enum Feature {
        AUTO_CLOSE_TARGET(true),
        AUTO_CLOSE_JSON_CONTENT(true),
        QUOTE_FIELD_NAMES(true),
        QUOTE_NON_NUMERIC_NUMBERS(true),
        WRITE_NUMBERS_AS_STRINGS(false),
        FLUSH_PASSED_TO_STREAM(true),
        ESCAPE_NON_ASCII(false);

        private final boolean _defaultState;
        private final int _mask = 1 << ordinal();

        Feature(boolean z) {
            this._defaultState = z;
        }

        public static int collectDefaults() {
            int mask = 0;
            for (Feature feature : values()) {
                if (feature.enabledByDefault()) {
                    mask |= feature.getMask();
                }
            }
            return mask;
        }

        public boolean enabledByDefault() {
            return this._defaultState;
        }

        public int getMask() {
            return this._mask;
        }
    }

    public boolean canUseSchema(FormatSchema formatSchema) {
        return false;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public abstract void close();

    public final JsonGenerator configure(Feature feature, boolean z) {
        if (z) {
            enable(feature);
            return this;
        }
        disable(feature);
        return this;
    }

    public abstract void copyCurrentEvent(JsonParser jsonParser);

    public abstract void copyCurrentStructure(JsonParser jsonParser);

    public abstract JsonGenerator disable(Feature feature);

    public abstract JsonGenerator enable(Feature feature);

    @Override // java.io.Flushable
    public abstract void flush();

    public CharacterEscapes getCharacterEscapes() {
        return null;
    }

    public abstract ObjectCodec getCodec();

    public int getHighestEscapedChar() {
        return 0;
    }

    public abstract JsonStreamContext getOutputContext();

    public Object getOutputTarget() {
        return null;
    }

    public PrettyPrinter getPrettyPrinter() {
        return this._cfgPrettyPrinter;
    }

    public FormatSchema getSchema() {
        return null;
    }

    public abstract boolean isClosed();

    public abstract boolean isEnabled(Feature feature);

    public abstract JsonGenerator setCodec(ObjectCodec objectCodec);

    public JsonGenerator setPrettyPrinter(PrettyPrinter prettyPrinter) {
        this._cfgPrettyPrinter = prettyPrinter;
        return this;
    }

    public JsonGenerator setRootValueSeparator(SerializableString serializableString) {
        throw new UnsupportedOperationException();
    }

    public void setSchema(FormatSchema formatSchema) {
        throw new UnsupportedOperationException("Generator of type " + getClass().getName() + " does not support schema of type '" + formatSchema.getSchemaType() + "'");
    }

    public abstract JsonGenerator useDefaultPrettyPrinter();

    @Override // com.fasterxml.jackson.core.Versioned
    public abstract Version version();

    public final void writeArrayFieldStart(String str) {
        writeFieldName(str);
        writeStartArray();
    }

    public abstract int writeBinary(Base64Variant base64Variant, InputStream inputStream, int i);

    public abstract void writeBinary(Base64Variant base64Variant, byte[] bArr, int i, int i2);

    public void writeBinary(byte[] bArr, int i, int i2) {
        writeBinary(Base64Variants.getDefaultVariant(), bArr, i, i2);
    }

    public final void writeBinaryField(String str, byte[] bArr) {
        writeFieldName(str);
        writeBinary(bArr);
    }

    public abstract void writeBoolean(boolean z);

    public final void writeBooleanField(String str, boolean z) {
        writeFieldName(str);
        writeBoolean(z);
    }

    public abstract void writeEndArray();

    public abstract void writeEndObject();

    public abstract void writeFieldName(SerializableString serializableString);

    public abstract void writeFieldName(String str);

    public abstract void writeNull();

    public final void writeNullField(String str) {
        writeFieldName(str);
        writeNull();
    }

    public abstract void writeNumber(double d);

    public abstract void writeNumber(float f);

    public abstract void writeNumber(int i);

    public abstract void writeNumber(long j);

    public abstract void writeNumber(String str);

    public abstract void writeNumber(BigDecimal bigDecimal);

    public abstract void writeNumber(BigInteger bigInteger);

    public final void writeNumberField(String str, int i) {
        writeFieldName(str);
        writeNumber(i);
    }

    public abstract void writeObject(Object obj);

    public final void writeObjectField(String str, Object obj) {
        writeFieldName(str);
        writeObject(obj);
    }

    public final void writeObjectFieldStart(String str) {
        writeFieldName(str);
        writeStartObject();
    }

    public abstract void writeRaw(char c);

    public void writeRaw(SerializableString serializableString) {
        writeRaw(serializableString.getValue());
    }

    public abstract void writeRaw(String str);

    public abstract void writeRaw(String str, int i, int i2);

    public abstract void writeRaw(char[] cArr, int i, int i2);

    public abstract void writeRawUTF8String(byte[] bArr, int i, int i2);

    public abstract void writeRawValue(String str);

    public abstract void writeRawValue(String str, int i, int i2);

    public abstract void writeRawValue(char[] cArr, int i, int i2);

    public abstract void writeStartArray();

    public abstract void writeStartObject();

    public abstract void writeString(SerializableString serializableString);

    public abstract void writeString(String str);

    public abstract void writeString(char[] cArr, int i, int i2);

    public void writeStringField(String str, String str2) {
        writeFieldName(str);
        writeString(str2);
    }

    public abstract void writeTree(TreeNode treeNode);

    public abstract void writeUTF8String(byte[] bArr, int i, int i2);

    public void writeBinary(byte[] bArr) {
        writeBinary(Base64Variants.getDefaultVariant(), bArr, 0, bArr.length);
    }

    public int writeBinary(InputStream inputStream, int i) {
        return writeBinary(Base64Variants.getDefaultVariant(), inputStream, i);
    }

    public final void writeNumberField(String str, long j) {
        writeFieldName(str);
        writeNumber(j);
    }

    public final void writeNumberField(String str, double d) {
        writeFieldName(str);
        writeNumber(d);
    }

    public final void writeNumberField(String str, float f) {
        writeFieldName(str);
        writeNumber(f);
    }

    public final void writeNumberField(String str, BigDecimal bigDecimal) {
        writeFieldName(str);
        writeNumber(bigDecimal);
    }

    public JsonGenerator setCharacterEscapes(CharacterEscapes characterEscapes) {
        return this;
    }

    public JsonGenerator setHighestNonEscapedChar(int i) {
        return this;
    }
}
