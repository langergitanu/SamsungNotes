package io.netty.handler.codec.http;

import io.netty.util.CharsetUtil;
import java.nio.charset.Charset;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public final class HttpConstants {
    public static final byte COLON = 58;
    public static final byte COMMA = 44;

    /* JADX INFO: renamed from: CR */
    public static final byte f8888CR = 13;
    public static final Charset DEFAULT_CHARSET = CharsetUtil.UTF_8;
    public static final byte DOUBLE_QUOTE = 34;
    public static final byte EQUALS = 61;

    /* JADX INFO: renamed from: HT */
    public static final byte f8889HT = 9;

    /* JADX INFO: renamed from: LF */
    public static final byte f8890LF = 10;
    public static final byte SEMICOLON = 59;

    /* JADX INFO: renamed from: SP */
    public static final byte f8891SP = 32;
    public static final char SP_CHAR = ' ';

    private HttpConstants() {
    }
}
