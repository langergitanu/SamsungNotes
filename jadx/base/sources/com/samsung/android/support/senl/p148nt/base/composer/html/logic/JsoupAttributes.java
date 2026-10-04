package com.samsung.android.support.senl.p148nt.base.composer.html.logic;

import android.graphics.Color;
import com.samsung.android.support.senl.p148nt.data.database.core.query.sqlbuilder.SQLKeyword;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.StringsKt;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;
import org.apache.commons.beanutils.PropertyUtils;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jsoup.nodes.Element;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\t\n\u0002\u0010\u0007\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0010\b\u0082\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u001a\u00102\u001a\u0004\u0018\u00010\t2\u0006\u00103\u001a\u00020\t2\u0006\u00104\u001a\u00020\tH\u0002J\u0012\u00105\u001a\u0004\u0018\u00010\t2\u0006\u00106\u001a\u00020\tH\u0002J\t\u00107\u001a\u00020\u0003HÆ\u0003J\u0013\u00108\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u00109\u001a\u00020-2\b\u0010:\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010;\u001a\u00020!HÖ\u0001J\t\u0010<\u001a\u00020\tHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0013\u0010\b\u001a\u0004\u0018\u00010\t8F¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0017\u0010\f\u001a\b\u0012\u0004\u0012\u00020\t0\r8F¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\u0010\u001a\u0004\u0018\u00010\t8F¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u000bR\u0013\u0010\u0012\u001a\u0004\u0018\u00010\t8F¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u000bR\u0013\u0010\u0014\u001a\u0004\u0018\u00010\t8F¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u000bR\u0011\u0010\u0016\u001a\u00020\u00178F¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019R\u0013\u0010\u001a\u001a\u0004\u0018\u00010\t8F¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u000bR\u0013\u0010\u001c\u001a\u0004\u0018\u00010\t8F¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u000bR\u0013\u0010\u001e\u001a\u0004\u0018\u00010\t8F¢\u0006\u0006\u001a\u0004\b\u001f\u0010\u000bR\u0011\u0010 \u001a\u00020!8F¢\u0006\u0006\u001a\u0004\b\"\u0010#R\u0011\u0010$\u001a\u00020!8F¢\u0006\u0006\u001a\u0004\b%\u0010#R\u0011\u0010&\u001a\u00020!8F¢\u0006\u0006\u001a\u0004\b'\u0010#R\u0013\u0010(\u001a\u0004\u0018\u00010\t8F¢\u0006\u0006\u001a\u0004\b)\u0010\u000bR\u0013\u0010*\u001a\u0004\u0018\u00010\t8F¢\u0006\u0006\u001a\u0004\b+\u0010\u000bR\u0011\u0010,\u001a\u00020-8F¢\u0006\u0006\u001a\u0004\b,\u0010.R\u0011\u0010/\u001a\u00020-8F¢\u0006\u0006\u001a\u0004\b/\u0010.R\u0013\u00100\u001a\u0004\u0018\u00010\t8F¢\u0006\u0006\u001a\u0004\b1\u0010\u000b¨\u0006="}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/composer/html/logic/JsoupAttributes;", "", "element", "Lorg/jsoup/nodes/Element;", "<init>", "(Lorg/jsoup/nodes/Element;)V", "getElement", "()Lorg/jsoup/nodes/Element;", "id", "", "getId", "()Ljava/lang/String;", "classes", "", "getClasses", "()Ljava/util/List;", "textColor", "getTextColor", "backgroundColor", "getBackgroundColor", "textAlign", "getTextAlign", "textSize", "", "getTextSize", "()F", "href", "getHref", "src", "getSrc", "alt", "getAlt", "start", "", "getStart", "()I", "colSpan", "getColSpan", "rowSpan", "getRowSpan", "name", "getName", "value", "getValue", "isChecked", "", "()Z", "isDisabled", "forAttr", "getForAttr", "extractStyleProperty", "styleString", "propertyName", "normalizeColor", "color", "component1", "copy", "equals", "other", "hashCode", "toString", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nHtmlParser.kt\nKotlin\n*S Kotlin\n*F\n+ 1 HtmlParser.kt\ncom/samsung/android/support/senl/nt/base/composer/html/logic/JsoupAttributes\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 Color.kt\nandroidx/core/graphics/ColorKt\n*L\n1#1,566:1\n1#2:567\n439#3:568\n*S KotlinDebug\n*F\n+ 1 HtmlParser.kt\ncom/samsung/android/support/senl/nt/base/composer/html/logic/JsoupAttributes\n*L\n264#1:568\n*E\n"})
final /* data */ class JsoupAttributes {

    @NotNull
    private final Element element;

    public JsoupAttributes(@NotNull Element element) {
        Intrinsics.checkNotNullParameter(element, "element");
        this.element = element;
    }

    public static /* synthetic */ JsoupAttributes copy$default(JsoupAttributes jsoupAttributes, Element element, int i, Object obj) {
        if ((i & 1) != 0) {
            element = jsoupAttributes.element;
        }
        return jsoupAttributes.copy(element);
    }

    private final String extractStyleProperty(String styleString, String propertyName) {
        Iterator it = StringsKt__StringsKt.split$default((CharSequence) styleString, new char[]{SQLKeyword.DELIMITER}, false, 0, 6, (Object) null).iterator();
        while (it.hasNext()) {
            List listSplit$default = StringsKt__StringsKt.split$default((CharSequence) ((String) it.next()), new char[]{':'}, false, 2, 2, (Object) null);
            if (listSplit$default.size() == 2) {
                String string = StringsKt.trim((CharSequence) listSplit$default.get(0)).toString();
                String string2 = StringsKt.trim((CharSequence) listSplit$default.get(1)).toString();
                if (StringsKt__StringsJVMKt.equals(string, propertyName, true)) {
                    return string2;
                }
            }
        }
        return null;
    }

    private final String normalizeColor(String color) {
        List listSplit$default;
        int size;
        String lowerCase = StringsKt.trim((CharSequence) color).toString().toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        if (!StringsKt.m14145S(lowerCase, "rgb")) {
            try {
                Color.parseColor(color);
                return color;
            } catch (IllegalArgumentException unused) {
                return null;
            }
        }
        try {
            listSplit$default = StringsKt__StringsKt.split$default((CharSequence) StringsKt__StringsKt.substringBefore$default(StringsKt__StringsKt.substringAfter$default(lowerCase, PropertyUtils.MAPPED_DELIM, (String) null, 2, (Object) null), PropertyUtils.MAPPED_DELIM2, (String) null, 2, (Object) null), new char[]{','}, false, 0, 6, (Object) null);
            size = listSplit$default.size();
        } catch (Exception unused2) {
        }
        if (size == 3) {
            int i = Integer.parseInt(StringsKt.trim((CharSequence) listSplit$default.get(0)).toString());
            int i2 = Integer.parseInt(StringsKt.trim((CharSequence) listSplit$default.get(1)).toString());
            int i4 = Integer.parseInt(StringsKt.trim((CharSequence) listSplit$default.get(2)).toString());
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String str = String.format("#%02x%02x%02x", Arrays.copyOf(new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i4)}, 3));
            Intrinsics.checkNotNullExpressionValue(str, "format(...)");
            return str;
        }
        if (size == 4) {
            int i5 = Integer.parseInt(StringsKt.trim((CharSequence) listSplit$default.get(0)).toString());
            int i6 = Integer.parseInt(StringsKt.trim((CharSequence) listSplit$default.get(1)).toString());
            int i7 = Integer.parseInt(StringsKt.trim((CharSequence) listSplit$default.get(2)).toString());
            int i8 = (int) (Float.parseFloat(StringsKt.trim((CharSequence) listSplit$default.get(3)).toString()) * 255);
            StringCompanionObject stringCompanionObject2 = StringCompanionObject.INSTANCE;
            String str2 = String.format("#%02x%02x%02x%02x", Arrays.copyOf(new Object[]{Integer.valueOf(i8), Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i7)}, 4));
            Intrinsics.checkNotNullExpressionValue(str2, "format(...)");
            return str2;
        }
        return null;
    }

    @NotNull
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Element getElement() {
        return this.element;
    }

    @NotNull
    public final JsoupAttributes copy(@NotNull Element element) {
        Intrinsics.checkNotNullParameter(element, "element");
        return new JsoupAttributes(element);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof JsoupAttributes) && Intrinsics.areEqual(this.element, ((JsoupAttributes) other).element);
    }

    @Nullable
    public final String getAlt() {
        String strAttr = this.element.attr("alt");
        Intrinsics.checkNotNull(strAttr);
        if (StringsKt.isBlank(strAttr)) {
            return null;
        }
        return strAttr;
    }

    @Nullable
    public final String getBackgroundColor() {
        String strExtractStyleProperty;
        String strAttr = this.element.attr("style");
        Intrinsics.checkNotNull(strAttr);
        if (StringsKt.isBlank(strAttr)) {
            strAttr = null;
        }
        if (strAttr == null || (strExtractStyleProperty = extractStyleProperty(strAttr, "background-color")) == null) {
            return null;
        }
        return normalizeColor(strExtractStyleProperty);
    }

    @NotNull
    public final List<String> getClasses() {
        Set<String> setClassNames = this.element.classNames();
        Intrinsics.checkNotNullExpressionValue(setClassNames, "classNames(...)");
        return CollectionsKt.toList(setClassNames);
    }

    public final int getColSpan() {
        String strAttr = this.element.attr("colspan");
        Intrinsics.checkNotNullExpressionValue(strAttr, "attr(...)");
        Integer intOrNull = StringsKt.toIntOrNull(strAttr);
        if (intOrNull != null) {
            return intOrNull.intValue();
        }
        return 1;
    }

    @NotNull
    public final Element getElement() {
        return this.element;
    }

    @Nullable
    public final String getForAttr() {
        String strAttr = this.element.attr("for");
        Intrinsics.checkNotNull(strAttr);
        if (StringsKt.isBlank(strAttr)) {
            return null;
        }
        return strAttr;
    }

    @Nullable
    public final String getHref() {
        String strAttr = this.element.attr("href");
        Intrinsics.checkNotNull(strAttr);
        if (StringsKt.isBlank(strAttr)) {
            return null;
        }
        return strAttr;
    }

    @Nullable
    public final String getId() {
        String strM14987id = this.element.m14987id();
        Intrinsics.checkNotNull(strM14987id);
        if (StringsKt.isBlank(strM14987id)) {
            return null;
        }
        return strM14987id;
    }

    @Nullable
    public final String getName() {
        String strAttr = this.element.attr("name");
        Intrinsics.checkNotNull(strAttr);
        if (StringsKt.isBlank(strAttr)) {
            return null;
        }
        return strAttr;
    }

    public final int getRowSpan() {
        String strAttr = this.element.attr("rowspan");
        Intrinsics.checkNotNullExpressionValue(strAttr, "attr(...)");
        Integer intOrNull = StringsKt.toIntOrNull(strAttr);
        if (intOrNull != null) {
            return intOrNull.intValue();
        }
        return 1;
    }

    @Nullable
    public final String getSrc() {
        String strAttr = this.element.attr("src");
        Intrinsics.checkNotNull(strAttr);
        if (StringsKt.isBlank(strAttr)) {
            return null;
        }
        return strAttr;
    }

    public final int getStart() {
        String strAttr = this.element.attr("start");
        Intrinsics.checkNotNullExpressionValue(strAttr, "attr(...)");
        Integer intOrNull = StringsKt.toIntOrNull(strAttr);
        if (intOrNull != null) {
            return intOrNull.intValue();
        }
        return 1;
    }

    @Nullable
    public final String getTextAlign() {
        String strExtractStyleProperty;
        String strAttr = this.element.attr("style");
        Intrinsics.checkNotNull(strAttr);
        if (StringsKt.isBlank(strAttr)) {
            strAttr = null;
        }
        if (strAttr != null && (strExtractStyleProperty = extractStyleProperty(strAttr, "text-align")) != null) {
            return strExtractStyleProperty;
        }
        String strAttr2 = this.element.attr("align");
        Intrinsics.checkNotNull(strAttr2);
        if (StringsKt.isBlank(strAttr2)) {
            return null;
        }
        return strAttr2;
    }

    @Nullable
    public final String getTextColor() {
        String strExtractStyleProperty;
        String strAttr = this.element.attr("style");
        Intrinsics.checkNotNull(strAttr);
        if (StringsKt.isBlank(strAttr)) {
            strAttr = null;
        }
        if (strAttr == null || (strExtractStyleProperty = extractStyleProperty(strAttr, "color")) == null) {
            return null;
        }
        return normalizeColor(strExtractStyleProperty);
    }

    public final float getTextSize() {
        String strExtractStyleProperty;
        Float floatOrNull;
        String strAttr = this.element.attr("style");
        Intrinsics.checkNotNull(strAttr);
        if (StringsKt.isBlank(strAttr)) {
            strAttr = null;
        }
        if (strAttr == null || (strExtractStyleProperty = extractStyleProperty(strAttr, "font-size")) == null || (floatOrNull = StringsKt.toFloatOrNull(strExtractStyleProperty)) == null) {
            return 15.0f;
        }
        return floatOrNull.floatValue();
    }

    @Nullable
    public final String getValue() {
        String strAttr = this.element.attr("value");
        Intrinsics.checkNotNull(strAttr);
        if (StringsKt.isBlank(strAttr)) {
            return null;
        }
        return strAttr;
    }

    public int hashCode() {
        return this.element.hashCode();
    }

    public final boolean isChecked() {
        return this.element.hasAttr("checked");
    }

    public final boolean isDisabled() {
        return this.element.hasAttr("disabled");
    }

    @NotNull
    public String toString() {
        return "JsoupAttributes(element=" + this.element + ")";
    }
}
