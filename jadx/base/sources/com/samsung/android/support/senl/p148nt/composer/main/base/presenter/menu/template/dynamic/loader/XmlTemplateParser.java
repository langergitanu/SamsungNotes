package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.template.dynamic.loader;

import android.graphics.Color;
import com.samsung.android.support.senl.p148nt.data.database.core.sync.FolderNodeItem;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m13885d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007J\u0010\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\nH\u0002J\u0012\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u0007H\u0002J\u0012\u0010\u000e\u001a\u00020\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0007H\u0002J\u0012\u0010\u0010\u001a\u00020\f2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0007H\u0002J\u0012\u0010\u0012\u001a\u00020\f2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0007H\u0002J\u0012\u0010\u0014\u001a\u00020\f2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0007H\u0002J\u0012\u0010\u0016\u001a\u00020\f2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0007H\u0002J\u0012\u0010\u0018\u001a\u00020\f2\b\u0010\u0019\u001a\u0004\u0018\u00010\u0007H\u0002J0\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u00072\b\u0010\u001d\u001a\u0004\u0018\u00010\u00072\b\u0010\u001e\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\u001f\u001a\u00020\fH\u0002J\u0012\u0010 \u001a\u00020\f2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0007H\u0002J\u0010\u0010!\u001a\u00020\"2\u0006\u0010\t\u001a\u00020\nH\u0002J\u0010\u0010#\u001a\u00020$2\u0006\u0010\t\u001a\u00020\nH\u0002J\u0010\u0010%\u001a\u00020&2\u0006\u0010\t\u001a\u00020\nH\u0002J\u0010\u0010'\u001a\u00020&2\u0006\u0010\t\u001a\u00020\nH\u0002J\u0010\u0010(\u001a\u00020)2\u0006\u0010\t\u001a\u00020\nH\u0002J\u0010\u0010*\u001a\u00020+2\u0006\u0010\t\u001a\u00020\nH\u0002J\u0010\u0010,\u001a\u00020&2\u0006\u0010\t\u001a\u00020\nH\u0002J\u001a\u0010-\u001a\u00020.2\b\u0010/\u001a\u0004\u0018\u00010.2\u0006\u0010\t\u001a\u00020\nH\u0002¨\u00060"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/menu/template/dynamic/loader/XmlTemplateParser;", "", "<init>", "()V", "parseXmlString", "Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/menu/template/dynamic/loader/Template;", "xmlString", "", "parse", "parser", "Lorg/xmlpull/v1/XmlPullParser;", "parseColor", "", "colorString", "parseTextAlignment", "textAlignment", "parseTextStyle", "textStyle", "parseMaskType", "maskType", "parseDisplayType", "displayType", "parseParagraphType", "paragraphType", "parseGravity", "gravity", "parseBorderShape", "Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/menu/template/dynamic/loader/BorderShape;", "borderPosition", "borderType", "borderThickness", "borderColor", "parseBorderType", "parseImage", "Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/menu/template/dynamic/loader/Image;", "parseGeneratedImage", "Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/menu/template/dynamic/loader/GeneratedImage;", "parseBodyTextBox", "Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/menu/template/dynamic/loader/TextBox;", "parseTextBox", "parseDateTextBox", "Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/menu/template/dynamic/loader/DateTextBox;", "parseDayOfWeekTextBox", "Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/menu/template/dynamic/loader/DayOfWeekTextBox;", "parseGeneratedTextBox", "parsePage", "Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/menu/template/dynamic/loader/Page;", "currentPage", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nXmlTemplateParser.kt\nKotlin\n*S Kotlin\n*F\n+ 1 XmlTemplateParser.kt\ncom/samsung/android/support/senl/nt/composer/main/base/presenter/menu/template/dynamic/loader/XmlTemplateParser\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 Color.kt\nandroidx/core/graphics/ColorKt\n+ 4 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,432:1\n1#2:433\n439#3:434\n1869#4,2:435\n*S KotlinDebug\n*F\n+ 1 XmlTemplateParser.kt\ncom/samsung/android/support/senl/nt/composer/main/base/presenter/menu/template/dynamic/loader/XmlTemplateParser\n*L\n160#1:434\n249#1:435,2\n*E\n"})
public final class XmlTemplateParser {
    /*  JADX ERROR: JadxRuntimeException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Failed to find switch 'out' block (already processed)
        	at jadx.core.dex.visitors.regions.maker.SwitchRegionMaker.calcSwitchOut(SwitchRegionMaker.java:217)
        	at jadx.core.dex.visitors.regions.maker.SwitchRegionMaker.process(SwitchRegionMaker.java:68)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:112)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:66)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:102)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:106)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:66)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:125)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:89)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:66)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeMthRegion(RegionMaker.java:48)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:25)
        */
    private final com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.template.dynamic.loader.Template parse(org.xmlpull.v1.XmlPullParser r17) {
        /*
            Method dump skipped, instruction units count: 498
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.template.dynamic.loader.XmlTemplateParser.parse(org.xmlpull.v1.XmlPullParser):com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.template.dynamic.loader.Template");
    }

    private final TextBox parseBodyTextBox(XmlPullParser parser) {
        Integer intOrNull;
        Integer intOrNull2;
        Integer intOrNull3;
        Integer intOrNull4;
        Integer intOrNull5;
        String attributeValue = parser.getAttributeValue(null, "id");
        String str = attributeValue == null ? "" : attributeValue;
        String attributeValue2 = parser.getAttributeValue(null, "left");
        int iIntValue = (attributeValue2 == null || (intOrNull5 = StringsKt.toIntOrNull(attributeValue2)) == null) ? 0 : intOrNull5.intValue();
        String attributeValue3 = parser.getAttributeValue(null, "top");
        int iIntValue2 = (attributeValue3 == null || (intOrNull4 = StringsKt.toIntOrNull(attributeValue3)) == null) ? 0 : intOrNull4.intValue();
        String attributeValue4 = parser.getAttributeValue(null, "width");
        int iIntValue3 = (attributeValue4 == null || (intOrNull3 = StringsKt.toIntOrNull(attributeValue4)) == null) ? 0 : intOrNull3.intValue();
        String attributeValue5 = parser.getAttributeValue(null, "height");
        int iIntValue4 = (attributeValue5 == null || (intOrNull2 = StringsKt.toIntOrNull(attributeValue5)) == null) ? 0 : intOrNull2.intValue();
        String attributeValue6 = parser.getAttributeValue(null, "fontSize");
        int iIntValue5 = (attributeValue6 == null || (intOrNull = StringsKt.toIntOrNull(attributeValue6)) == null) ? 14 : intOrNull.intValue();
        int color = parseColor(parser.getAttributeValue(null, "fontColor"));
        int textAlignment = parseTextAlignment(parser.getAttributeValue(null, "textAlignment"));
        int textStyle = parseTextStyle(parser.getAttributeValue(null, "textStyle"));
        String attributeValue7 = parser.getAttributeValue(null, "text");
        String str2 = attributeValue7 == null ? "" : attributeValue7;
        String attributeValue8 = parser.getAttributeValue(null, "editable");
        boolean z = attributeValue8 != null ? Boolean.parseBoolean(attributeValue8) : true;
        String attributeValue9 = parser.getAttributeValue(null, "linedPaperEnabled");
        return new TextBox(str, iIntValue, iIntValue2, iIntValue3, iIntValue4, parseBorderShape(parser.getAttributeValue(null, "borderPosition"), parser.getAttributeValue(null, "borderType"), parser.getAttributeValue(null, "borderThickness"), parseColor(parser.getAttributeValue(null, "borderColor"))), iIntValue5, color, textAlignment, textStyle, false, z, str2, attributeValue9 != null ? Boolean.parseBoolean(attributeValue9) : false, parseColor(parser.getAttributeValue(null, "linedPagerColor")), 0, 0, 99328, null);
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:13:0x003d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final BorderShape parseBorderShape(String borderPosition, String borderType, String borderThickness, int borderColor) {
        List listSplit$default;
        Float floatOrNull;
        BorderShape borderShape = new BorderShape(false, false, false, false, parseBorderType(borderType), (borderThickness == null || (floatOrNull = StringsKt.toFloatOrNull(borderThickness)) == null) ? 0.0f : floatOrNull.floatValue(), borderColor, 15, null);
        if (borderPosition != null) {
            String lowerCase = borderPosition.toLowerCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
            listSplit$default = lowerCase != null ? StringsKt__StringsKt.split$default(lowerCase, new String[]{"|"}, false, 0, 6, (Object) null) : null;
        }
        if (listSplit$default != null) {
            Iterator it = listSplit$default.iterator();
            while (it.hasNext()) {
                String lowerCase2 = ((String) it.next()).toLowerCase(Locale.ROOT);
                Intrinsics.checkNotNullExpressionValue(lowerCase2, "toLowerCase(...)");
                String string = StringsKt.trim((CharSequence) lowerCase2).toString();
                switch (string.hashCode()) {
                    case -1383228885:
                        if (string.equals("bottom")) {
                            borderShape.setBottom(true);
                        }
                        break;
                    case 115029:
                        if (string.equals("top")) {
                            borderShape.setTop(true);
                        }
                        break;
                    case 3317767:
                        if (string.equals("left")) {
                            borderShape.setLeft(true);
                        }
                        break;
                    case 108511772:
                        if (string.equals("right")) {
                            borderShape.setRight(true);
                        }
                        break;
                }
            }
        }
        return borderShape;
    }

    public static /* synthetic */ BorderShape parseBorderShape$default(XmlTemplateParser xmlTemplateParser, String str, String str2, String str3, int i, int i2, Object obj) {
        if ((i2 & 8) != 0) {
            i = 0;
        }
        return xmlTemplateParser.parseBorderShape(str, str2, str3, i);
    }

    private final int parseBorderType(String borderType) {
        if (borderType == null) {
            return 0;
        }
        String lowerCase = borderType.toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        int iHashCode = lowerCase.hashCode();
        if (iHashCode != 3075986) {
            if (iHashCode == 109618859) {
                lowerCase.equals("solid");
            } else if (iHashCode == 779475781 && lowerCase.equals("doubleline")) {
                return 2;
            }
        } else if (lowerCase.equals("dash")) {
            return 1;
        }
        return 0;
    }

    private final int parseColor(String colorString) {
        if (colorString != null) {
            try {
                return Color.parseColor(colorString);
            } catch (IllegalArgumentException unused) {
            }
        }
        return -16777216;
    }

    private final DateTextBox parseDateTextBox(XmlPullParser parser) {
        Integer intOrNull;
        Integer intOrNull2;
        Integer intOrNull3;
        Integer intOrNull4;
        Integer intOrNull5;
        String attributeValue = parser.getAttributeValue(null, "id");
        String str = attributeValue == null ? "" : attributeValue;
        String attributeValue2 = parser.getAttributeValue(null, "left");
        int iIntValue = 0;
        int iIntValue2 = (attributeValue2 == null || (intOrNull5 = StringsKt.toIntOrNull(attributeValue2)) == null) ? 0 : intOrNull5.intValue();
        String attributeValue3 = parser.getAttributeValue(null, "top");
        int iIntValue3 = (attributeValue3 == null || (intOrNull4 = StringsKt.toIntOrNull(attributeValue3)) == null) ? 0 : intOrNull4.intValue();
        String attributeValue4 = parser.getAttributeValue(null, "width");
        int iIntValue4 = (attributeValue4 == null || (intOrNull3 = StringsKt.toIntOrNull(attributeValue4)) == null) ? 0 : intOrNull3.intValue();
        String attributeValue5 = parser.getAttributeValue(null, "height");
        int iIntValue5 = (attributeValue5 == null || (intOrNull2 = StringsKt.toIntOrNull(attributeValue5)) == null) ? 0 : intOrNull2.intValue();
        String attributeValue6 = parser.getAttributeValue(null, "fontSize");
        if (attributeValue6 != null && (intOrNull = StringsKt.toIntOrNull(attributeValue6)) != null) {
            iIntValue = intOrNull.intValue();
        }
        int i = iIntValue;
        int color = parseColor(parser.getAttributeValue(null, "fontColor"));
        int textAlignment = parseTextAlignment(parser.getAttributeValue(null, "textAlignment"));
        int textStyle = parseTextStyle(parser.getAttributeValue(null, "textStyle"));
        String attributeValue7 = parser.getAttributeValue(null, "format");
        String str2 = attributeValue7 == null ? "" : attributeValue7;
        String attributeValue8 = parser.getAttributeValue(null, "targetId");
        return new DateTextBox(str, iIntValue2, iIntValue3, iIntValue4, iIntValue5, parseBorderShape(parser.getAttributeValue(null, "borderPosition"), parser.getAttributeValue(null, "borderType"), parser.getAttributeValue(null, "borderThickness"), parseColor(parser.getAttributeValue(null, "borderColor"))), i, color, textAlignment, textStyle, str2, attributeValue8 == null ? "" : attributeValue8);
    }

    private final DayOfWeekTextBox parseDayOfWeekTextBox(XmlPullParser parser) {
        Integer intOrNull;
        Integer intOrNull2;
        Integer intOrNull3;
        Integer intOrNull4;
        Integer intOrNull5;
        String attributeValue = parser.getAttributeValue(null, "id");
        String str = attributeValue == null ? "" : attributeValue;
        String attributeValue2 = parser.getAttributeValue(null, "left");
        int iIntValue = 0;
        int iIntValue2 = (attributeValue2 == null || (intOrNull5 = StringsKt.toIntOrNull(attributeValue2)) == null) ? 0 : intOrNull5.intValue();
        String attributeValue3 = parser.getAttributeValue(null, "top");
        int iIntValue3 = (attributeValue3 == null || (intOrNull4 = StringsKt.toIntOrNull(attributeValue3)) == null) ? 0 : intOrNull4.intValue();
        String attributeValue4 = parser.getAttributeValue(null, "width");
        int iIntValue4 = (attributeValue4 == null || (intOrNull3 = StringsKt.toIntOrNull(attributeValue4)) == null) ? 0 : intOrNull3.intValue();
        String attributeValue5 = parser.getAttributeValue(null, "height");
        int iIntValue5 = (attributeValue5 == null || (intOrNull2 = StringsKt.toIntOrNull(attributeValue5)) == null) ? 0 : intOrNull2.intValue();
        String attributeValue6 = parser.getAttributeValue(null, "fontSize");
        if (attributeValue6 != null && (intOrNull = StringsKt.toIntOrNull(attributeValue6)) != null) {
            iIntValue = intOrNull.intValue();
        }
        int i = iIntValue;
        int color = parseColor(parser.getAttributeValue(null, "fontColor"));
        int textAlignment = parseTextAlignment(parser.getAttributeValue(null, "textAlignment"));
        int textStyle = parseTextStyle(parser.getAttributeValue(null, "textStyle"));
        int displayType = parseDisplayType(parser.getAttributeValue(null, "displayType"));
        String attributeValue7 = parser.getAttributeValue(null, "targetId");
        return new DayOfWeekTextBox(str, iIntValue2, iIntValue3, iIntValue4, iIntValue5, parseBorderShape(parser.getAttributeValue(null, "borderPosition"), parser.getAttributeValue(null, "borderType"), parser.getAttributeValue(null, "borderThickness"), parseColor(parser.getAttributeValue(null, "borderColor"))), i, color, textAlignment, textStyle, displayType, attributeValue7 == null ? "" : attributeValue7);
    }

    private final int parseDisplayType(String displayType) {
        if (displayType == null) {
            return 0;
        }
        String lowerCase = displayType.toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        return (!Intrinsics.areEqual(lowerCase, "default") && Intrinsics.areEqual(lowerCase, "todayis")) ? 1 : 0;
    }

    private final GeneratedImage parseGeneratedImage(XmlPullParser parser) {
        Integer intOrNull;
        Integer intOrNull2;
        Integer intOrNull3;
        Integer intOrNull4;
        Integer intOrNull5;
        Integer intOrNull6;
        Integer intOrNull7;
        Integer intOrNull8;
        String attributeValue = parser.getAttributeValue(null, "id");
        String str = attributeValue == null ? "" : attributeValue;
        String attributeValue2 = parser.getAttributeValue(null, "left");
        int iIntValue = 0;
        int iIntValue2 = (attributeValue2 == null || (intOrNull8 = StringsKt.toIntOrNull(attributeValue2)) == null) ? 0 : intOrNull8.intValue();
        String attributeValue3 = parser.getAttributeValue(null, "top");
        int iIntValue3 = (attributeValue3 == null || (intOrNull7 = StringsKt.toIntOrNull(attributeValue3)) == null) ? 0 : intOrNull7.intValue();
        String attributeValue4 = parser.getAttributeValue(null, "width");
        int iIntValue4 = (attributeValue4 == null || (intOrNull6 = StringsKt.toIntOrNull(attributeValue4)) == null) ? 0 : intOrNull6.intValue();
        String attributeValue5 = parser.getAttributeValue(null, "height");
        int iIntValue5 = (attributeValue5 == null || (intOrNull5 = StringsKt.toIntOrNull(attributeValue5)) == null) ? 0 : intOrNull5.intValue();
        String attributeValue6 = parser.getAttributeValue(null, "src");
        String str2 = attributeValue6 == null ? "" : attributeValue6;
        String attributeValue7 = parser.getAttributeValue(null, "marginLeft");
        int iIntValue6 = (attributeValue7 == null || (intOrNull4 = StringsKt.toIntOrNull(attributeValue7)) == null) ? 0 : intOrNull4.intValue();
        String attributeValue8 = parser.getAttributeValue(null, "marginRight");
        int iIntValue7 = (attributeValue8 == null || (intOrNull3 = StringsKt.toIntOrNull(attributeValue8)) == null) ? 0 : intOrNull3.intValue();
        String attributeValue9 = parser.getAttributeValue(null, "marginTop");
        int iIntValue8 = (attributeValue9 == null || (intOrNull2 = StringsKt.toIntOrNull(attributeValue9)) == null) ? 0 : intOrNull2.intValue();
        String attributeValue10 = parser.getAttributeValue(null, "marginBottom");
        if (attributeValue10 != null && (intOrNull = StringsKt.toIntOrNull(attributeValue10)) != null) {
            iIntValue = intOrNull.intValue();
        }
        int i = iIntValue;
        int maskType = parseMaskType(parser.getAttributeValue(null, "maskType"));
        String attributeValue11 = parser.getAttributeValue(null, "text");
        return new GeneratedImage(str, iIntValue2, iIntValue3, iIntValue4, iIntValue5, iIntValue6, iIntValue7, iIntValue8, i, parseBorderShape(parser.getAttributeValue(null, "borderPosition"), parser.getAttributeValue(null, "borderType"), parser.getAttributeValue(null, "borderThickness"), parseColor(parser.getAttributeValue(null, "borderColor"))), str2, true, maskType, attributeValue11 == null ? "" : attributeValue11);
    }

    private final TextBox parseGeneratedTextBox(XmlPullParser parser) {
        Integer intOrNull;
        Integer intOrNull2;
        Integer intOrNull3;
        Integer intOrNull4;
        Integer intOrNull5;
        String attributeValue = parser.getAttributeValue(null, "id");
        if (attributeValue == null) {
            attributeValue = "";
        }
        String str = attributeValue;
        String attributeValue2 = parser.getAttributeValue(null, "left");
        int iIntValue = 0;
        int iIntValue2 = (attributeValue2 == null || (intOrNull5 = StringsKt.toIntOrNull(attributeValue2)) == null) ? 0 : intOrNull5.intValue();
        String attributeValue3 = parser.getAttributeValue(null, "top");
        int iIntValue3 = (attributeValue3 == null || (intOrNull4 = StringsKt.toIntOrNull(attributeValue3)) == null) ? 0 : intOrNull4.intValue();
        String attributeValue4 = parser.getAttributeValue(null, "width");
        int iIntValue4 = (attributeValue4 == null || (intOrNull3 = StringsKt.toIntOrNull(attributeValue4)) == null) ? 0 : intOrNull3.intValue();
        String attributeValue5 = parser.getAttributeValue(null, "height");
        int iIntValue5 = (attributeValue5 == null || (intOrNull2 = StringsKt.toIntOrNull(attributeValue5)) == null) ? 0 : intOrNull2.intValue();
        String attributeValue6 = parser.getAttributeValue(null, "fontSize");
        if (attributeValue6 != null && (intOrNull = StringsKt.toIntOrNull(attributeValue6)) != null) {
            iIntValue = intOrNull.intValue();
        }
        return new TextBox(str, iIntValue2, iIntValue3, iIntValue4, iIntValue5, parseBorderShape(parser.getAttributeValue(null, "borderPosition"), parser.getAttributeValue(null, "borderType"), parser.getAttributeValue(null, "borderThickness"), parseColor(parser.getAttributeValue(null, "borderColor"))), iIntValue, parseColor(parser.getAttributeValue(null, "fontColor")), parseTextAlignment(parser.getAttributeValue(null, "textAlignment")), parseTextStyle(parser.getAttributeValue(null, "textStyle")), true, false, null, false, 0, 0, 0, 129024, null);
    }

    private final int parseGravity(String gravity) {
        if (gravity == null) {
            return 0;
        }
        String lowerCase = gravity.toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        int iHashCode = lowerCase.hashCode();
        if (iHashCode != -1383228885) {
            if (iHashCode != -1364013995) {
                if (iHashCode == 115029) {
                    lowerCase.equals("top");
                }
            } else if (lowerCase.equals("center")) {
                return 2;
            }
        } else if (lowerCase.equals("bottom")) {
            return 1;
        }
        return 0;
    }

    private final Image parseImage(XmlPullParser parser) {
        Integer intOrNull;
        Integer intOrNull2;
        Integer intOrNull3;
        Integer intOrNull4;
        Integer intOrNull5;
        Integer intOrNull6;
        Integer intOrNull7;
        Integer intOrNull8;
        String attributeValue = parser.getAttributeValue(null, "id");
        String str = attributeValue == null ? "" : attributeValue;
        String attributeValue2 = parser.getAttributeValue(null, "left");
        int iIntValue = 0;
        int iIntValue2 = (attributeValue2 == null || (intOrNull8 = StringsKt.toIntOrNull(attributeValue2)) == null) ? 0 : intOrNull8.intValue();
        String attributeValue3 = parser.getAttributeValue(null, "top");
        int iIntValue3 = (attributeValue3 == null || (intOrNull7 = StringsKt.toIntOrNull(attributeValue3)) == null) ? 0 : intOrNull7.intValue();
        String attributeValue4 = parser.getAttributeValue(null, "width");
        int iIntValue4 = (attributeValue4 == null || (intOrNull6 = StringsKt.toIntOrNull(attributeValue4)) == null) ? 0 : intOrNull6.intValue();
        String attributeValue5 = parser.getAttributeValue(null, "height");
        int iIntValue5 = (attributeValue5 == null || (intOrNull5 = StringsKt.toIntOrNull(attributeValue5)) == null) ? 0 : intOrNull5.intValue();
        String attributeValue6 = parser.getAttributeValue(null, "src");
        String str2 = attributeValue6 == null ? "" : attributeValue6;
        String attributeValue7 = parser.getAttributeValue(null, "marginLeft");
        int iIntValue6 = (attributeValue7 == null || (intOrNull4 = StringsKt.toIntOrNull(attributeValue7)) == null) ? 0 : intOrNull4.intValue();
        String attributeValue8 = parser.getAttributeValue(null, "marginRight");
        int iIntValue7 = (attributeValue8 == null || (intOrNull3 = StringsKt.toIntOrNull(attributeValue8)) == null) ? 0 : intOrNull3.intValue();
        String attributeValue9 = parser.getAttributeValue(null, "marginTop");
        int iIntValue8 = (attributeValue9 == null || (intOrNull2 = StringsKt.toIntOrNull(attributeValue9)) == null) ? 0 : intOrNull2.intValue();
        String attributeValue10 = parser.getAttributeValue(null, "marginBottom");
        if (attributeValue10 != null && (intOrNull = StringsKt.toIntOrNull(attributeValue10)) != null) {
            iIntValue = intOrNull.intValue();
        }
        int i = iIntValue;
        int maskType = parseMaskType(parser.getAttributeValue(null, "maskType"));
        String attributeValue11 = parser.getAttributeValue(null, "text");
        return new Image(str, iIntValue2, iIntValue3, iIntValue4, iIntValue5, iIntValue6, iIntValue7, iIntValue8, i, parseBorderShape(parser.getAttributeValue(null, "borderPosition"), parser.getAttributeValue(null, "borderType"), parser.getAttributeValue(null, "borderThickness"), parseColor(parser.getAttributeValue(null, "borderColor"))), str2, false, maskType, attributeValue11 == null ? "" : attributeValue11, 2048, null);
    }

    private final int parseMaskType(String maskType) {
        if (maskType == null) {
            return 0;
        }
        String lowerCase = maskType.toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        if (Intrinsics.areEqual(lowerCase, "clipped")) {
            return 1;
        }
        return Intrinsics.areEqual(lowerCase, "rounded") ? 2 : 0;
    }

    private final Page parsePage(Page currentPage, XmlPullParser parser) {
        Integer intOrNull;
        Integer intOrNull2;
        String attributeValue = parser.getAttributeValue(null, "id");
        if (attributeValue == null) {
            attributeValue = "";
        }
        String attributeValue2 = parser.getAttributeValue(null, "width");
        int iIntValue = 0;
        int iIntValue2 = (attributeValue2 == null || (intOrNull2 = StringsKt.toIntOrNull(attributeValue2)) == null) ? 0 : intOrNull2.intValue();
        String attributeValue3 = parser.getAttributeValue(null, "height");
        if (attributeValue3 != null && (intOrNull = StringsKt.toIntOrNull(attributeValue3)) != null) {
            iIntValue = intOrNull.intValue();
        }
        String attributeValue4 = parser.getAttributeValue(null, "background");
        return new Page(attributeValue, iIntValue2, iIntValue, attributeValue4 != null ? attributeValue4 : "", new ArrayList());
    }

    private final int parseParagraphType(String paragraphType) {
        if (paragraphType == null) {
            return 0;
        }
        String lowerCase = paragraphType.toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        return Intrinsics.areEqual(lowerCase, "task") ? 1 : 0;
    }

    private final int parseTextAlignment(String textAlignment) {
        if (textAlignment == null) {
            return -1;
        }
        String lowerCase = textAlignment.toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        int iHashCode = lowerCase.hashCode();
        if (iHashCode != -1364013995) {
            if (iHashCode != 3317767) {
                if (iHashCode == 108511772 && lowerCase.equals("right")) {
                    return 1;
                }
            } else if (lowerCase.equals("left")) {
                return 0;
            }
        } else if (lowerCase.equals("center")) {
            return 2;
        }
        return -1;
    }

    private final TextBox parseTextBox(XmlPullParser parser) {
        Integer intOrNull;
        Integer intOrNull2;
        Integer intOrNull3;
        Integer intOrNull4;
        Integer intOrNull5;
        String attributeValue = parser.getAttributeValue(null, "id");
        String str = attributeValue == null ? "" : attributeValue;
        String attributeValue2 = parser.getAttributeValue(null, "left");
        int iIntValue = (attributeValue2 == null || (intOrNull5 = StringsKt.toIntOrNull(attributeValue2)) == null) ? 0 : intOrNull5.intValue();
        String attributeValue3 = parser.getAttributeValue(null, "top");
        int iIntValue2 = (attributeValue3 == null || (intOrNull4 = StringsKt.toIntOrNull(attributeValue3)) == null) ? 0 : intOrNull4.intValue();
        String attributeValue4 = parser.getAttributeValue(null, "width");
        int iIntValue3 = (attributeValue4 == null || (intOrNull3 = StringsKt.toIntOrNull(attributeValue4)) == null) ? 0 : intOrNull3.intValue();
        String attributeValue5 = parser.getAttributeValue(null, "height");
        int iIntValue4 = (attributeValue5 == null || (intOrNull2 = StringsKt.toIntOrNull(attributeValue5)) == null) ? 0 : intOrNull2.intValue();
        String attributeValue6 = parser.getAttributeValue(null, "fontSize");
        int iIntValue5 = (attributeValue6 == null || (intOrNull = StringsKt.toIntOrNull(attributeValue6)) == null) ? 0 : intOrNull.intValue();
        int color = parseColor(parser.getAttributeValue(null, "fontColor"));
        int textAlignment = parseTextAlignment(parser.getAttributeValue(null, "textAlignment"));
        int textStyle = parseTextStyle(parser.getAttributeValue(null, "textStyle"));
        String attributeValue7 = parser.getAttributeValue(null, "text");
        String str2 = attributeValue7 == null ? "" : attributeValue7;
        String attributeValue8 = parser.getAttributeValue(null, "editable");
        boolean z = attributeValue8 != null ? Boolean.parseBoolean(attributeValue8) : true;
        String attributeValue9 = parser.getAttributeValue(null, "linedPaperEnabled");
        return new TextBox(str, iIntValue, iIntValue2, iIntValue3, iIntValue4, parseBorderShape(parser.getAttributeValue(null, "borderPosition"), parser.getAttributeValue(null, "borderType"), parser.getAttributeValue(null, "borderThickness"), parseColor(parser.getAttributeValue(null, "borderColor"))), iIntValue5, color, textAlignment, textStyle, false, z, str2, attributeValue9 != null ? Boolean.parseBoolean(attributeValue9) : false, parseColor(parser.getAttributeValue(null, "linedPagerColor")), parseParagraphType(parser.getAttributeValue(null, "paragraphType")), parseGravity(parser.getAttributeValue(null, "gravity")), 1024, null);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:21:0x003c A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final int parseTextStyle(String textStyle) {
        if (textStyle != null) {
            String lowerCase = textStyle.toLowerCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
            switch (lowerCase.hashCode()) {
                case -1178781136:
                    return !lowerCase.equals("italic") ? 0 : 2;
                case -1039745817:
                    lowerCase.equals(FolderNodeItem.SYNC_WDOC_FOLDER_NODE_STATE_NORMAL);
                case 3029637:
                    if (lowerCase.equals("bold")) {
                        return 1;
                    }
                    break;
                case 74759413:
                    if (lowerCase.equals("bolditalic")) {
                        return 3;
                    }
                    break;
            }
        } else {
            return 0;
        }
    }

    @NotNull
    public final Template parseXmlString(@NotNull String xmlString) throws XmlPullParserException {
        Intrinsics.checkNotNullParameter(xmlString, "xmlString");
        XmlPullParser xmlPullParserNewPullParser = XmlPullParserFactory.newInstance().newPullParser();
        xmlPullParserNewPullParser.setInput(new StringReader(xmlString));
        Intrinsics.checkNotNull(xmlPullParserNewPullParser);
        return parse(xmlPullParserNewPullParser);
    }
}
