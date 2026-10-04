package com.samsung.android.support.senl.addons.base.binding.binder;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.util.Xml;
import com.samsung.android.support.senl.addons.base.utils.Logger;
import com.samsung.android.support.senl.p148nt.composer.main.cover.model.CoverData;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.p196io.CloseableKt;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m13885d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001:\u000278B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001c\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u00142\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019J0\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u00142\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00192\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0002J<\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u001f\u001a\u00020 2\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00150\u00142\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00150\u00142\u0006\u0010\u001b\u001a\u00020\u001cH\u0002J.\u0010#\u001a\u00020\u001e2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u001f\u001a\u00020 2\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00150\u00142\u0006\u0010\u001b\u001a\u00020\u001cH\u0002JD\u0010$\u001a\u00020\u001e2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u001f\u001a\u00020 2\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00150\u00142\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00150\u00142\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u001cH\u0002JL\u0010%\u001a\u00020\u001e2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010&\u001a\u00020\u00052\f\u0010'\u001a\b\u0012\u0004\u0012\u00020\u00150\u00142\f\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00150\u00142\u0006\u0010)\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u001cH\u0002JL\u0010*\u001a\u00020\u001e2\u0006\u0010\u0016\u001a\u00020\u00172\f\u0010'\u001a\b\u0012\u0004\u0012\u00020\u00150\u00142\f\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00150\u00142\u0006\u0010)\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010+\u001a\u00020,H\u0002J`\u0010-\u001a\u00020\u001e2\u0006\u0010\u0016\u001a\u00020\u00172\f\u0010'\u001a\b\u0012\u0004\u0012\u00020\u00150\u00142\f\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00150\u00142\u0006\u0010)\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u001c2\n\u0010.\u001a\u00060/j\u0002`02\u0006\u0010\u001f\u001a\u0002012\u0006\u00102\u001a\u000203H\u0002J\u0018\u00104\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u0002012\u0006\u00102\u001a\u000203H\u0002J&\u00105\u001a\u00020\u001e2\u0006\u00102\u001a\u0002032\u0006\u0010\u001f\u001a\u0002012\f\u00106\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u00069"}, m13886d2 = {"Lcom/samsung/android/support/senl/addons/base/binding/binder/BindingParser;", "", "<init>", "()V", SearchConstants.TargetContents.TAG, "", "NAME_SPACE_ANDROID", "ATTR_ID_NAME", "DELIMITER_RESOURCE_ID", "TAG_INNER_LAYOUT", "TAG_VIEWSTUB", "ATTR_LAYOUT_NAME", "BIND_TAG", "TAG_VIEW", "TAG_INCLUDE", "TAG_VIEWMODEL", "TAG_BIND", "ATTR_PROPERTY", "ATTR_BINDID", "parseBinding", "", "Lcom/samsung/android/support/senl/addons/base/binding/binder/IViewBind;", "context", "Landroid/content/Context;", "layoutId", "", "linkedResId", "keyGenerator", "Lcom/samsung/android/support/senl/addons/base/binding/binder/BindingParser$ViewKeyGenerator;", "parseInclude", "", "parser", "Landroid/content/res/XmlResourceParser;", "binds", "includes", "parseViewStub", "parseView", "parseViewAttribute", "target", "outV", "outInclude", "rootResId", "parseViewAttributeFromBuffer", "bufferedReader", "Ljava/io/BufferedReader;", "parseViewAttributeTag", "stringBuilder", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "Lorg/xmlpull/v1/XmlPullParser;", "data", "Lcom/samsung/android/support/senl/addons/base/binding/binder/BindingParser$ParseData;", "releaseParseViewAttribute", "makeBindCommand", "out", "ViewKeyGenerator", "ParseData", "ntAddons_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class BindingParser {

    @NotNull
    private static final String ATTR_BINDID = "bindId";

    @NotNull
    private static final String ATTR_ID_NAME = "id";

    @NotNull
    private static final String ATTR_LAYOUT_NAME = "layout";

    @NotNull
    private static final String ATTR_PROPERTY = "property";

    @NotNull
    private static final String BIND_TAG = "bind";

    @NotNull
    private static final String DELIMITER_RESOURCE_ID = "@";

    @NotNull
    private static final String NAME_SPACE_ANDROID = "http://schemas.android.com/apk/res/android";

    @NotNull
    private static final String TAG_BIND = "Bind";

    @NotNull
    private static final String TAG_INCLUDE = "Include";

    @NotNull
    private static final String TAG_INNER_LAYOUT = "include";

    @NotNull
    private static final String TAG_VIEW = "View";

    @NotNull
    private static final String TAG_VIEWMODEL = "ViewModel";

    @NotNull
    private static final String TAG_VIEWSTUB = "ViewStub";

    @NotNull
    public static final BindingParser INSTANCE = new BindingParser();

    @NotNull
    private static final String TAG = Logger.createTag("BindingParser");

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u000e\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000fR\u001a\u0010\u0013\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0007\"\u0004\b\u0015\u0010\tR\u001a\u0010\u0016\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0007\"\u0004\b\u0018\u0010\t¨\u0006\u0019"}, m13886d2 = {"Lcom/samsung/android/support/senl/addons/base/binding/binder/BindingParser$ParseData;", "", "<init>", "()V", "mType", "", "getMType", "()Ljava/lang/String;", "setMType", "(Ljava/lang/String;)V", "mViewId", "", "getMViewId", "()I", "setMViewId", "(I)V", "mViewKey", "getMViewKey", "setMViewKey", "mVmId", "getMVmId", "setMVmId", "mName", "getMName", "setMName", "ntAddons_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class ParseData {
        private int mViewId;

        @NotNull
        private String mType = "";
        private int mViewKey = -1;

        @NotNull
        private String mVmId = "";

        @NotNull
        private String mName = "";

        @NotNull
        public final String getMName() {
            return this.mName;
        }

        @NotNull
        public final String getMType() {
            return this.mType;
        }

        public final int getMViewId() {
            return this.mViewId;
        }

        public final int getMViewKey() {
            return this.mViewKey;
        }

        @NotNull
        public final String getMVmId() {
            return this.mVmId;
        }

        public final void setMName(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.mName = str;
        }

        public final void setMType(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.mType = str;
        }

        public final void setMViewId(int i) {
            this.mViewId = i;
        }

        public final void setMViewKey(int i) {
            this.mViewKey = i;
        }

        public final void setMVmId(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.mVmId = str;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0006\u001a\u00020\u0005R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0007"}, m13886d2 = {"Lcom/samsung/android/support/senl/addons/base/binding/binder/BindingParser$ViewKeyGenerator;", "", "<init>", "()V", "mKey", "", CoverData.KEY_GENERATE_COVER, "ntAddons_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class ViewKeyGenerator {
        private int mKey = -1;

        public final int generate() {
            int i = this.mKey + 1;
            this.mKey = i;
            return i;
        }
    }

    private BindingParser() {
    }

    private final void makeBindCommand(ParseData data, XmlPullParser parser, List<IViewBind> out) {
        String attributeValue = parser.getAttributeValue(null, ATTR_PROPERTY);
        String attributeValue2 = parser.getAttributeValue(null, ATTR_BINDID);
        Intrinsics.checkNotNull(attributeValue);
        out.add(new ViewBind(attributeValue, data.getMViewId(), data.getMViewKey(), data.getMVmId(), attributeValue2));
    }

    private final void parseInclude(Context context, XmlResourceParser parser, List<IViewBind> binds, List<IViewBind> includes, ViewKeyGenerator keyGenerator) {
        int i;
        String attributeValue = parser.getAttributeValue(null, "layout");
        Intrinsics.checkNotNull(attributeValue);
        String strSubstring = attributeValue.substring(1);
        Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
        int i2 = Integer.parseInt(strSubstring);
        String attributeValue2 = parser.getAttributeValue(NAME_SPACE_ANDROID, "id");
        if (attributeValue2 != null) {
            String strSubstring2 = attributeValue2.substring(1);
            Intrinsics.checkNotNullExpressionValue(strSubstring2, "substring(...)");
            i = Integer.parseInt(strSubstring2);
        } else {
            i = 0;
        }
        ArrayList arrayList = new ArrayList();
        Iterator<IViewBind> it = includes.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            IViewBind next = it.next();
            if (next.getMViewId() == i) {
                arrayList.add(next);
                break;
            }
        }
        int size = arrayList.size();
        if (size > 0) {
            Logger.m7100d(TAG, "found bind infor for include : " + size);
            includes.removeAll(arrayList);
        }
        List<IViewBind> binding = parseBinding(context, i2, i, keyGenerator);
        List<IViewBind> list = binding;
        if (list.isEmpty()) {
            return;
        }
        if (size > 0 && i != 0) {
            binds.add(new IncludeBind(i, binding, arrayList));
            return;
        }
        Logger.m7105w(TAG, "could not generated include bind" + i);
        binds.addAll(list);
    }

    private final void parseView(Context context, XmlResourceParser parser, List<IViewBind> binds, List<IViewBind> includes, int linkedResId, ViewKeyGenerator keyGenerator) {
        String attributeValue = parser.getAttributeValue(NAME_SPACE_ANDROID, "id");
        if (attributeValue == null || !StringsKt.m14145S(attributeValue, "@")) {
            return;
        }
        String name = parser.getName();
        int attributeCount = parser.getAttributeCount();
        String strSubstring = attributeValue.substring(1);
        Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
        int i = Integer.parseInt(strSubstring);
        Logger.m7100d(TAG, "parse view : " + name + " : attr = " + attributeCount);
        for (int i2 = 0; i2 < attributeCount; i2++) {
            if (Intrinsics.areEqual(BIND_TAG, parser.getAttributeName(i2))) {
                String attributeValue2 = parser.getAttributeValue(i2);
                Intrinsics.checkNotNull(attributeValue2);
                parseViewAttribute(context, attributeValue2, binds, includes, i, linkedResId, keyGenerator);
                return;
            }
        }
    }

    private final void parseViewAttribute(Context context, String target, List<IViewBind> outV, List<IViewBind> outInclude, int rootResId, int linkedResId, ViewKeyGenerator keyGenerator) {
        String packageName = context.getPackageName();
        Resources resources = context.getResources();
        try {
            InputStream inputStreamOpenRawResource = resources.openRawResource(resources.getIdentifier(target, "raw", packageName));
            try {
                InputStreamReader inputStreamReader = new InputStreamReader(inputStreamOpenRawResource);
                try {
                    BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                    try {
                        INSTANCE.parseViewAttributeFromBuffer(context, outV, outInclude, rootResId, linkedResId, keyGenerator, bufferedReader);
                        Unit unit = Unit.INSTANCE;
                        CloseableKt.closeFinally(bufferedReader, null);
                        CloseableKt.closeFinally(inputStreamReader, null);
                        CloseableKt.closeFinally(inputStreamOpenRawResource, null);
                    } finally {
                    }
                } finally {
                }
            } finally {
            }
        } catch (IOException e) {
            Logger.m7101e(TAG, "error : " + e.getMessage());
        } catch (XmlPullParserException e2) {
            Logger.m7101e(TAG, "error : " + e2.getMessage());
        }
    }

    private final void parseViewAttributeFromBuffer(Context context, List<IViewBind> outV, List<IViewBind> outInclude, int rootResId, int linkedResId, ViewKeyGenerator keyGenerator, BufferedReader bufferedReader) throws XmlPullParserException, IOException {
        StringBuilder sb = new StringBuilder();
        XmlPullParser xmlPullParserNewPullParser = Xml.newPullParser();
        xmlPullParserNewPullParser.setInput(bufferedReader);
        ParseData parseData = new ParseData();
        for (int eventType = xmlPullParserNewPullParser.getEventType(); eventType != 1; eventType = xmlPullParserNewPullParser.next()) {
            if (eventType == 2) {
                Intrinsics.checkNotNull(xmlPullParserNewPullParser);
                parseViewAttributeTag(context, outV, outInclude, rootResId, linkedResId, keyGenerator, sb, xmlPullParserNewPullParser, parseData);
            } else if (eventType == 3) {
                Intrinsics.checkNotNull(xmlPullParserNewPullParser);
                releaseParseViewAttribute(xmlPullParserNewPullParser, parseData);
            }
        }
        Logger.m7100d(TAG, sb.toString());
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    private final void parseViewAttributeTag(Context context, List<IViewBind> outV, List<IViewBind> outInclude, int rootResId, int linkedResId, ViewKeyGenerator keyGenerator, StringBuilder stringBuilder, XmlPullParser parser, ParseData data) {
        String name = parser.getName();
        Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
        data.setMName(name);
        String mName = data.getMName();
        switch (mName.hashCode()) {
            case -687739768:
                if (!mName.equals(TAG_INCLUDE)) {
                    return;
                }
                break;
            case 2070621:
                if (mName.equals(TAG_BIND) && data.getMViewId() != 0) {
                    if (Intrinsics.areEqual(TAG_VIEW, data.getMType())) {
                        makeBindCommand(data, parser, outV);
                        return;
                    } else {
                        if (Intrinsics.areEqual(TAG_INCLUDE, data.getMType())) {
                            makeBindCommand(data, parser, outInclude);
                            return;
                        }
                        return;
                    }
                }
                return;
            case 2666181:
                if (!mName.equals(TAG_VIEW)) {
                    return;
                }
                break;
            case 414175076:
                if (mName.equals(TAG_VIEWMODEL)) {
                    String attributeValue = parser.getAttributeValue(null, "id");
                    Intrinsics.checkNotNullExpressionValue(attributeValue, "getAttributeValue(...)");
                    data.setMVmId(attributeValue);
                    return;
                }
                return;
            default:
                return;
        }
        data.setMViewId(context.getResources().getIdentifier(parser.getAttributeValue(null, "id"), "id", context.getPackageName()));
        if (data.getMViewId() == rootResId && linkedResId != 0) {
            stringBuilder.append("root view id is changed to parent : ");
            stringBuilder.append(data.getMViewId());
            stringBuilder.append('/');
            stringBuilder.append(rootResId);
            stringBuilder.append('/');
            stringBuilder.append(linkedResId);
            stringBuilder.append('|');
            data.setMViewId(linkedResId);
        }
        data.setMViewKey(keyGenerator.generate());
        data.setMType(data.getMName());
        stringBuilder.append("view : ");
        stringBuilder.append(data.getMViewId());
        stringBuilder.append('/');
        stringBuilder.append(data.getMViewKey());
        stringBuilder.append('/');
        stringBuilder.append(data.getMType());
        stringBuilder.append('|');
    }

    private final void parseViewStub(Context context, XmlResourceParser parser, List<IViewBind> binds, ViewKeyGenerator keyGenerator) {
        String attributeValue = parser.getAttributeValue(NAME_SPACE_ANDROID, "layout");
        Intrinsics.checkNotNull(attributeValue);
        String strSubstring = attributeValue.substring(1);
        Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
        List<IViewBind> binding = parseBinding(context, Integer.parseInt(strSubstring), 0, keyGenerator);
        if (binding.isEmpty()) {
            return;
        }
        String attributeValue2 = parser.getAttributeValue(NAME_SPACE_ANDROID, "id");
        if (attributeValue2 != null) {
            String strSubstring2 = attributeValue2.substring(1);
            Intrinsics.checkNotNullExpressionValue(strSubstring2, "substring(...)");
            binds.add(new ViewStubBind(Integer.parseInt(strSubstring2), binding.size()));
        } else {
            Logger.m7105w(TAG, "could not generated viewstub bind");
        }
        binds.addAll(binding);
    }

    private final void releaseParseViewAttribute(XmlPullParser parser, ParseData data) {
        String name = parser.getName();
        Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
        data.setMName(name);
        if (Intrinsics.areEqual(TAG_VIEW, data.getMName())) {
            data.setMViewId(0);
        } else if (Intrinsics.areEqual(TAG_VIEWMODEL, data.getMName())) {
            data.setMVmId("");
        }
    }

    @NotNull
    public final List<IViewBind> parseBinding(@NotNull Context context, int layoutId) {
        Intrinsics.checkNotNullParameter(context, "context");
        return parseBinding(context, layoutId, 0, null);
    }

    private final List<IViewBind> parseBinding(Context context, int layoutId, int linkedResId, ViewKeyGenerator keyGenerator) {
        Context context2;
        ViewKeyGenerator viewKeyGenerator;
        int i;
        if (keyGenerator == null) {
            keyGenerator = new ViewKeyGenerator();
        }
        ViewKeyGenerator viewKeyGenerator2 = keyGenerator;
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        XmlResourceParser layout = context.getResources().getLayout(layoutId);
        Intrinsics.checkNotNullExpressionValue(layout, "getLayout(...)");
        try {
            int eventType = layout.getEventType();
            while (eventType != 1) {
                if (eventType != 2) {
                    context2 = context;
                } else {
                    String name = layout.getName();
                    if (Intrinsics.areEqual(TAG_INNER_LAYOUT, name)) {
                        context2 = context;
                        parseInclude(context2, layout, arrayList, arrayList2, viewKeyGenerator2);
                    } else {
                        context2 = context;
                        if (Intrinsics.areEqual(TAG_VIEWSTUB, name)) {
                            parseViewStub(context2, layout, arrayList, viewKeyGenerator2);
                        } else {
                            viewKeyGenerator = viewKeyGenerator2;
                            i = linkedResId;
                            parseView(context2, layout, arrayList, arrayList2, i, viewKeyGenerator);
                            eventType = layout.next();
                            context = context2;
                            linkedResId = i;
                            viewKeyGenerator2 = viewKeyGenerator;
                        }
                    }
                }
                viewKeyGenerator = viewKeyGenerator2;
                i = linkedResId;
                eventType = layout.next();
                context = context2;
                linkedResId = i;
                viewKeyGenerator2 = viewKeyGenerator;
            }
        } catch (IOException e) {
            Logger.m7101e(TAG, "error : " + e.getMessage());
        } catch (XmlPullParserException e2) {
            Logger.m7101e(TAG, "error : " + e2.getMessage());
        }
        return arrayList;
    }
}
