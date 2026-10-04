package com.samsung.android.support.senl.p148nt.base.common.util;

import androidx.appcompat.widget.AbstractC0541b;
import com.samsung.android.support.senl.p148nt.data.common.utils.AbstractC11014a;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.collections.AbstractC12991c;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u0016B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\tH\u0002J\u0016\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\tJ\u001e\u0010\n\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u0007J\u000e\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0007J\u0010\u0010\u0010\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007J\u0010\u0010\u0011\u001a\u00020\t2\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007J\u0010\u0010\u0012\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007J\u0010\u0010\u0013\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007J\u000e\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\u0017"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/common/util/DynamicTemplateUuidUtil;", "", "<init>", "()V", "isCompatibleNote", "", "uuid", "", "version", "", "getPostFixForUuid", "templateType", "templateIndex", "type", "index", "getPostFixFromUuid", "isPostFixContained", "getVersionFromUuid", "getTypeFromUuid", "getIndexFromUuid", "getInfo", "Lcom/samsung/android/support/senl/nt/base/common/util/DynamicTemplateUuidUtil$Info;", "Info", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nDynamicTemplateUuidUtil.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DynamicTemplateUuidUtil.kt\ncom/samsung/android/support/senl/nt/base/common/util/DynamicTemplateUuidUtil\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,83:1\n774#2:84\n865#2,2:85\n774#2:87\n865#2,2:88\n774#2:90\n865#2,2:91\n774#2:93\n865#2,2:94\n*S KotlinDebug\n*F\n+ 1 DynamicTemplateUuidUtil.kt\ncom/samsung/android/support/senl/nt/base/common/util/DynamicTemplateUuidUtil\n*L\n35#1:84\n35#1:85,2\n48#1:87\n48#1:88,2\n59#1:90\n59#1:91,2\n70#1:93\n70#1:94,2\n*E\n"})
public final class DynamicTemplateUuidUtil {

    @NotNull
    public static final DynamicTemplateUuidUtil INSTANCE = new DynamicTemplateUuidUtil();

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\f¨\u0006\u000e"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/common/util/DynamicTemplateUuidUtil$Info;", "", "version", "", "type", "", "index", "<init>", "(ILjava/lang/String;Ljava/lang/String;)V", "getVersion", "()I", "getType", "()Ljava/lang/String;", "getIndex", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class Info {

        @NotNull
        private final String index;

        @NotNull
        private final String type;
        private final int version;

        public Info(int i, @NotNull String type, @NotNull String index) {
            Intrinsics.checkNotNullParameter(type, "type");
            Intrinsics.checkNotNullParameter(index, "index");
            this.version = i;
            this.type = type;
            this.index = index;
        }

        @NotNull
        public final String getIndex() {
            return this.index;
        }

        @NotNull
        public final String getType() {
            return this.type;
        }

        public final int getVersion() {
            return this.version;
        }
    }

    private DynamicTemplateUuidUtil() {
    }

    private final boolean isCompatibleNote(int version) {
        return 1 <= version && version < 2;
    }

    @NotNull
    public final String getIndexFromUuid(@Nullable String uuid) {
        if (uuid == null || !INSTANCE.isPostFixContained(uuid)) {
            return "";
        }
        String strSubstring = uuid.substring(StringsKt.m14129C("_DYNAMIC_TEMPLATE", 0, 6, uuid));
        Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
        List listM13999t = AbstractC12991c.m13999t(0, "_", strSubstring);
        ArrayList arrayList = new ArrayList();
        for (Object obj : listM13999t) {
            if (((String) obj).length() > 0) {
                arrayList.add(obj);
            }
        }
        return (String) arrayList.get(4);
    }

    @NotNull
    public final Info getInfo(@NotNull String uuid) {
        Intrinsics.checkNotNullParameter(uuid, "uuid");
        return !isPostFixContained(uuid) ? new Info(-1, "", "") : new Info(getVersionFromUuid(uuid), getTypeFromUuid(uuid), getIndexFromUuid(uuid));
    }

    @NotNull
    public final String getPostFixForUuid(int templateType, int templateIndex) {
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        return AbstractC11014a.m12323h(new Object[]{"_DYNAMIC_TEMPLATE", 1, Integer.valueOf(templateType), Integer.valueOf(templateIndex)}, 4, Locale.getDefault(), "%s_%03d_%02d_%03d", "format(...)");
    }

    @NotNull
    public final String getPostFixFromUuid(@NotNull String uuid) {
        Intrinsics.checkNotNullParameter(uuid, "uuid");
        if (!isPostFixContained(uuid)) {
            return "";
        }
        String strSubstring = uuid.substring(StringsKt.m14129C("_DYNAMIC_TEMPLATE", 0, 6, uuid));
        Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
        List listM13999t = AbstractC12991c.m13999t(0, "_", strSubstring);
        ArrayList arrayList = new ArrayList();
        for (Object obj : listM13999t) {
            if (((String) obj).length() > 0) {
                arrayList.add(obj);
            }
        }
        return AbstractC0541b.m772n("_", CollectionsKt.m13955n(arrayList.subList(0, 5), "_", null, null, null, 62));
    }

    @NotNull
    public final String getTypeFromUuid(@Nullable String uuid) {
        if (uuid == null || !INSTANCE.isPostFixContained(uuid)) {
            return "";
        }
        String strSubstring = uuid.substring(StringsKt.m14129C("_DYNAMIC_TEMPLATE", 0, 6, uuid));
        Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
        List listM13999t = AbstractC12991c.m13999t(0, "_", strSubstring);
        ArrayList arrayList = new ArrayList();
        for (Object obj : listM13999t) {
            if (((String) obj).length() > 0) {
                arrayList.add(obj);
            }
        }
        return (String) arrayList.get(3);
    }

    public final int getVersionFromUuid(@Nullable String uuid) {
        if (uuid == null || !INSTANCE.isPostFixContained(uuid)) {
            return -1;
        }
        String strSubstring = uuid.substring(StringsKt.m14129C("_DYNAMIC_TEMPLATE", 0, 6, uuid));
        Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
        List listM13999t = AbstractC12991c.m13999t(0, "_", strSubstring);
        ArrayList arrayList = new ArrayList();
        for (Object obj : listM13999t) {
            if (((String) obj).length() > 0) {
                arrayList.add(obj);
            }
        }
        return Integer.parseInt((String) arrayList.get(2));
    }

    public final boolean isPostFixContained(@Nullable String uuid) {
        return uuid != null && StringsKt.m14162r(uuid, "_DYNAMIC_TEMPLATE");
    }

    public final boolean isCompatibleNote(@Nullable String uuid) {
        return isCompatibleNote(getVersionFromUuid(uuid));
    }

    @NotNull
    public final String getPostFixForUuid(int version, @NotNull String type, @NotNull String index) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(index, "index");
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        return AbstractC11014a.m12323h(new Object[]{"_DYNAMIC_TEMPLATE", Integer.valueOf(version), type, index}, 4, Locale.getDefault(), "%s_%03d_%s_%s", "format(...)");
    }
}
