package com.fasterxml.jackson.core.format;

import androidx.glance.AbstractC2821a;
import com.fasterxml.jackson.core.JsonFactory;
import java.io.EOFException;
import java.io.InputStream;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public interface InputAccessor {
    boolean hasMoreBytes();

    byte nextByte();

    void reset();

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class Std implements InputAccessor {
        protected final byte[] _buffer;
        protected int _bufferedEnd;
        protected final int _bufferedStart;
        protected final InputStream _in;
        protected int _ptr;

        public Std(InputStream inputStream, byte[] bArr) {
            this._in = inputStream;
            this._buffer = bArr;
            this._bufferedStart = 0;
            this._ptr = 0;
            this._bufferedEnd = 0;
        }

        public DataFormatMatcher createMatcher(JsonFactory jsonFactory, MatchStrength matchStrength) {
            InputStream inputStream = this._in;
            byte[] bArr = this._buffer;
            int i = this._bufferedStart;
            return new DataFormatMatcher(inputStream, bArr, i, this._bufferedEnd - i, jsonFactory, matchStrength);
        }

        @Override // com.fasterxml.jackson.core.format.InputAccessor
        public boolean hasMoreBytes() {
            int i;
            int i2 = this._ptr;
            if (i2 < this._bufferedEnd) {
                return true;
            }
            InputStream inputStream = this._in;
            if (inputStream == null) {
                return false;
            }
            byte[] bArr = this._buffer;
            int length = bArr.length - i2;
            if (length < 1 || (i = inputStream.read(bArr, i2, length)) <= 0) {
                return false;
            }
            this._bufferedEnd += i;
            return true;
        }

        @Override // com.fasterxml.jackson.core.format.InputAccessor
        public byte nextByte() throws EOFException {
            if (this._ptr < this._bufferedEnd || hasMoreBytes()) {
                byte[] bArr = this._buffer;
                int i = this._ptr;
                this._ptr = i + 1;
                return bArr[i];
            }
            StringBuilder sb = new StringBuilder("Failed auto-detect: could not read more than ");
            sb.append(this._ptr);
            sb.append(" bytes (max buffer size: ");
            throw new EOFException(AbstractC2821a.m2223n(sb, ")", this._buffer.length));
        }

        @Override // com.fasterxml.jackson.core.format.InputAccessor
        public void reset() {
            this._ptr = this._bufferedStart;
        }

        public Std(byte[] bArr) {
            this._in = null;
            this._buffer = bArr;
            this._bufferedStart = 0;
            this._bufferedEnd = bArr.length;
        }

        public Std(byte[] bArr, int i, int i2) {
            this._in = null;
            this._buffer = bArr;
            this._ptr = i;
            this._bufferedStart = i;
            this._bufferedEnd = i + i2;
        }
    }
}
