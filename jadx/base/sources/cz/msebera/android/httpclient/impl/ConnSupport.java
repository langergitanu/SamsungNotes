package cz.msebera.android.httpclient.impl;

import cz.msebera.android.httpclient.config.ConnectionConfig;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;
import java.nio.charset.CodingErrorAction;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public final class ConnSupport {
    public static CharsetDecoder createDecoder(ConnectionConfig connectionConfig) {
        if (connectionConfig == null) {
            return null;
        }
        Charset charset = connectionConfig.getCharset();
        CodingErrorAction malformedInputAction = connectionConfig.getMalformedInputAction();
        CodingErrorAction unmappableInputAction = connectionConfig.getUnmappableInputAction();
        if (charset == null) {
            return null;
        }
        CharsetDecoder charsetDecoderNewDecoder = charset.newDecoder();
        if (malformedInputAction == null) {
            malformedInputAction = CodingErrorAction.REPORT;
        }
        CharsetDecoder charsetDecoderOnMalformedInput = charsetDecoderNewDecoder.onMalformedInput(malformedInputAction);
        if (unmappableInputAction == null) {
            unmappableInputAction = CodingErrorAction.REPORT;
        }
        return charsetDecoderOnMalformedInput.onUnmappableCharacter(unmappableInputAction);
    }

    public static CharsetEncoder createEncoder(ConnectionConfig connectionConfig) {
        Charset charset;
        if (connectionConfig == null || (charset = connectionConfig.getCharset()) == null) {
            return null;
        }
        CodingErrorAction malformedInputAction = connectionConfig.getMalformedInputAction();
        CodingErrorAction unmappableInputAction = connectionConfig.getUnmappableInputAction();
        CharsetEncoder charsetEncoderNewEncoder = charset.newEncoder();
        if (malformedInputAction == null) {
            malformedInputAction = CodingErrorAction.REPORT;
        }
        CharsetEncoder charsetEncoderOnMalformedInput = charsetEncoderNewEncoder.onMalformedInput(malformedInputAction);
        if (unmappableInputAction == null) {
            unmappableInputAction = CodingErrorAction.REPORT;
        }
        return charsetEncoderOnMalformedInput.onUnmappableCharacter(unmappableInputAction);
    }
}
