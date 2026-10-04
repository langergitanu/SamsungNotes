package com.adobe.internal.xmp.impl;

import com.adobe.internal.xmp.XMPDateTime;
import com.adobe.internal.xmp.XMPException;
import com.samsung.android.support.senl.p148nt.app.main.common.handoff.HandoffLaunchManager;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;
import java.util.SimpleTimeZone;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public final class ISO8601Converter {
    private ISO8601Converter() {
    }

    public static XMPDateTime parse(String str) {
        return parse(str, new XMPDateTimeImpl());
    }

    public static String render(XMPDateTime xMPDateTime) {
        StringBuffer stringBuffer = new StringBuffer();
        if (xMPDateTime.hasDate()) {
            DecimalFormat decimalFormat = new DecimalFormat("0000", new DecimalFormatSymbols(Locale.ENGLISH));
            stringBuffer.append(decimalFormat.format(xMPDateTime.getYear()));
            if (xMPDateTime.getMonth() == 0) {
                return stringBuffer.toString();
            }
            decimalFormat.applyPattern("'-'00");
            stringBuffer.append(decimalFormat.format(xMPDateTime.getMonth()));
            if (xMPDateTime.getDay() == 0) {
                return stringBuffer.toString();
            }
            stringBuffer.append(decimalFormat.format(xMPDateTime.getDay()));
            if (xMPDateTime.hasTime()) {
                stringBuffer.append('T');
                decimalFormat.applyPattern("00");
                stringBuffer.append(decimalFormat.format(xMPDateTime.getHour()));
                stringBuffer.append(':');
                stringBuffer.append(decimalFormat.format(xMPDateTime.getMinute()));
                if (xMPDateTime.getSecond() != 0 || xMPDateTime.getNanoSecond() != 0) {
                    double nanoSecond = (((double) xMPDateTime.getNanoSecond()) / 1.0E9d) + ((double) xMPDateTime.getSecond());
                    decimalFormat.applyPattern(":00.#########");
                    stringBuffer.append(decimalFormat.format(nanoSecond));
                }
                if (xMPDateTime.hasTimeZone()) {
                    int offset = xMPDateTime.getTimeZone().getOffset(xMPDateTime.getCalendar().getTimeInMillis());
                    if (offset == 0) {
                        stringBuffer.append('Z');
                    } else {
                        int i = offset / 3600000;
                        int iAbs = Math.abs((offset % 3600000) / 60000);
                        decimalFormat.applyPattern("+00;-00");
                        stringBuffer.append(decimalFormat.format(i));
                        decimalFormat.applyPattern(":00");
                        stringBuffer.append(decimalFormat.format(iAbs));
                    }
                }
            }
        }
        return stringBuffer.toString();
    }

    /* JADX WARN: Removed duplicated region for block: B:138:0x0224  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static XMPDateTime parse(String str, XMPDateTime xMPDateTime) throws XMPException {
        int i;
        int i2;
        int i4;
        if (str == null) {
            throw new XMPException("Parameter must not be null", 4);
        }
        if (str.length() == 0) {
            return xMPDateTime;
        }
        ParseState parseState = new ParseState(str);
        int iGatherInt = 0;
        if (parseState.m3011ch(0) == '-') {
            parseState.skip();
        }
        int iGatherInt2 = parseState.gatherInt("Invalid year in date string", HandoffLaunchManager.SYNC_PERMISSION_REQUEST_CODE);
        if (parseState.hasNext() && parseState.m3010ch() != '-') {
            throw new XMPException("Invalid date string, after year", 5);
        }
        if (parseState.m3011ch(0) == '-') {
            iGatherInt2 = -iGatherInt2;
        }
        xMPDateTime.setYear(iGatherInt2);
        if (parseState.hasNext()) {
            parseState.skip();
            int iGatherInt3 = parseState.gatherInt("Invalid month in date string", 12);
            if (parseState.hasNext() && parseState.m3010ch() != '-') {
                throw new XMPException("Invalid date string, after month", 5);
            }
            xMPDateTime.setMonth(iGatherInt3);
            if (parseState.hasNext()) {
                parseState.skip();
                int iGatherInt4 = parseState.gatherInt("Invalid day in date string", 31);
                if (parseState.hasNext() && parseState.m3010ch() != 'T') {
                    throw new XMPException("Invalid date string, after day", 5);
                }
                xMPDateTime.setDay(iGatherInt4);
                if (parseState.hasNext()) {
                    parseState.skip();
                    xMPDateTime.setHour(parseState.gatherInt("Invalid hour in date string", 23));
                    if (parseState.hasNext()) {
                        if (parseState.m3010ch() == ':') {
                            parseState.skip();
                            int iGatherInt5 = parseState.gatherInt("Invalid minute in date string", 59);
                            if (parseState.hasNext() && parseState.m3010ch() != ':' && parseState.m3010ch() != 'Z' && parseState.m3010ch() != '+' && parseState.m3010ch() != '-') {
                                throw new XMPException("Invalid date string, after minute", 5);
                            }
                            xMPDateTime.setMinute(iGatherInt5);
                        }
                        if (parseState.hasNext()) {
                            if (parseState.hasNext() && parseState.m3010ch() == ':') {
                                parseState.skip();
                                int iGatherInt6 = parseState.gatherInt("Invalid whole seconds in date string", 59);
                                if (parseState.hasNext() && parseState.m3010ch() != '.' && parseState.m3010ch() != 'Z' && parseState.m3010ch() != '+' && parseState.m3010ch() != '-') {
                                    throw new XMPException("Invalid date string, after whole seconds", 5);
                                }
                                xMPDateTime.setSecond(iGatherInt6);
                                if (parseState.m3010ch() == '.') {
                                    parseState.skip();
                                    int iPos = parseState.pos();
                                    int iGatherInt7 = parseState.gatherInt("Invalid fractional seconds in date string", 999999999);
                                    if (parseState.hasNext() && parseState.m3010ch() != 'Z' && parseState.m3010ch() != '+' && parseState.m3010ch() != '-') {
                                        throw new XMPException("Invalid date string, after fractional second", 5);
                                    }
                                    int iPos2 = parseState.pos() - iPos;
                                    while (iPos2 > 9) {
                                        iGatherInt7 /= 10;
                                        iPos2--;
                                    }
                                    while (iPos2 < 9) {
                                        iGatherInt7 *= 10;
                                        iPos2++;
                                    }
                                    xMPDateTime.setNanoSecond(iGatherInt7);
                                }
                            } else if (parseState.m3010ch() != 'Z' && parseState.m3010ch() != '+' && parseState.m3010ch() != '-') {
                                throw new XMPException("Invalid date string, after time", 5);
                            }
                            if (parseState.hasNext()) {
                                if (parseState.m3010ch() == 'Z') {
                                    parseState.skip();
                                } else {
                                    if (parseState.hasNext()) {
                                        if (parseState.m3010ch() == '+') {
                                            i = 1;
                                        } else {
                                            if (parseState.m3010ch() != '-') {
                                                throw new XMPException("Time zone must begin with 'Z', '+', or '-'", 5);
                                            }
                                            i = -1;
                                        }
                                        parseState.skip();
                                        int iGatherInt8 = parseState.gatherInt("Invalid time zone hour in date string", 23);
                                        if (parseState.hasNext()) {
                                            if (parseState.m3010ch() != ':') {
                                                throw new XMPException("Invalid date string, after time zone hour", 5);
                                            }
                                            parseState.skip();
                                            iGatherInt = parseState.gatherInt("Invalid time zone minute in date string", 59);
                                        }
                                        int i5 = i;
                                        i2 = iGatherInt;
                                        iGatherInt = iGatherInt8;
                                        i4 = i5;
                                    }
                                    xMPDateTime.setTimeZone(new SimpleTimeZone(((i2 * 60000) + (iGatherInt * 3600000)) * i4, ""));
                                    if (parseState.hasNext()) {
                                        throw new XMPException("Invalid date string, extra chars at end", 5);
                                    }
                                }
                                i2 = 0;
                                i4 = 0;
                                xMPDateTime.setTimeZone(new SimpleTimeZone(((i2 * 60000) + (iGatherInt * 3600000)) * i4, ""));
                                if (parseState.hasNext()) {
                                }
                            }
                        }
                    }
                }
            }
        }
        return xMPDateTime;
    }
}
