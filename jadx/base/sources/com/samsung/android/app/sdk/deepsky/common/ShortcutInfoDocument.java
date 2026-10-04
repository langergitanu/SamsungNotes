package com.samsung.android.app.sdk.deepsky.common;

import android.app.appsearch.AppSearchSchema;
import android.app.appsearch.GenericDocument;
import android.content.ComponentName;
import android.content.Intent;
import android.content.LocusId;
import android.content.pm.Capability;
import android.content.pm.CapabilityParams;
import android.content.pm.ShortcutInfo;
import android.graphics.drawable.Icon;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.text.TextUtils;
import androidx.annotation.RequiresApi;
import androidx.appsearch.platformstorage.converter.AbstractC0566c;
import androidx.constraintlayout.motion.widget.AbstractC2322a;
import com.google.android.material.motion.AbstractC4744a;
import com.samsung.android.app.notes.widget.util.AbstractC7011a;
import com.samsung.android.sdk.smp.common.constants.MarketingConstants;
import com.samsung.android.settings.search.provider.SearchIndexablesContract;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.util.Constants;
import com.samsung.android.support.senl.p148nt.data.common.constants.ExternalDataConstants;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.p196io.CloseableKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@RequiresApi(33)
@Metadata(m13885d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0001\u0018\u0000 \u00052\u00020\u0001:\u0002\u0004\u0005B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0002\u0010\u0003¨\u0006\u0006"}, m13886d2 = {"Lcom/samsung/android/app/sdk/deepsky/common/ShortcutInfoDocument;", "Landroid/app/appsearch/GenericDocument;", ExternalDataConstants.DOCUMENT_TABLE_NAME, "(Landroid/app/appsearch/GenericDocument;)V", "Builder", "Companion", "deepsky-sdk-smartsuggestion-6.1.0_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
public final class ShortcutInfoDocument extends GenericDocument {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final String IS_DYNAMIC = "Dyn";

    @NotNull
    private static final String KEY_ACTIVITY = "activity";

    @NotNull
    private static final String KEY_CAPABILITY = "capability";

    @NotNull
    private static final String KEY_CAPABILITY_BINDINGS = "capabilityBindings";

    @NotNull
    private static final String KEY_CATEGORIES = "categories";

    @NotNull
    private static final String KEY_DISABLED_MESSAGE = "disabledMessage";

    @NotNull
    private static final String KEY_DISABLED_REASON = "disabledReason";

    @NotNull
    private static final String KEY_EXTRAS = "extras";

    @NotNull
    private static final String KEY_FLAGS = "flags";

    @NotNull
    private static final String KEY_ICON = "icon";

    @NotNull
    private static final String KEY_ICON_RES_ID = "iconResId";

    @NotNull
    private static final String KEY_INTENTS = "intents";

    @NotNull
    private static final String KEY_INTENT_PERSISTABLE_EXTRAS = "intentPersistableExtras";

    @NotNull
    private static final String KEY_LOCUS_ID = "locusId";

    @NotNull
    private static final String KEY_LONG_LABEL = "longLabel";

    @NotNull
    private static final String KEY_SHORT_LABEL = "shortLabel";

    @NotNull
    private static final String SCHEMA_TYPE = "shortcut-type";
    private static final int SCHEMA_VERSION = 3;

    @NotNull
    private static final AppSearchSchema schema;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\b\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\b\u001a\u00020\u00002\b\u0010\t\u001a\u0004\u0018\u00010\nJ\u000e\u0010\u000b\u001a\u00020\u00002\u0006\u0010\f\u001a\u00020\rJ\u0018\u0010\u000e\u001a\u00020\u00002\u0010\u0010\u000f\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u0010J\u0010\u0010\u0011\u001a\u00020\u00002\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013J\u000e\u0010\u0014\u001a\u00020\u00002\u0006\u0010\u0015\u001a\u00020\u0016J\u0010\u0010\u0017\u001a\u00020\u00002\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019J\u0010\u0010\u001a\u001a\u00020\u00002\b\u0010\u001b\u001a\u0004\u0018\u00010\u0003J\u000e\u0010\u001c\u001a\u00020\u00002\u0006\u0010\f\u001a\u00020\rJ\u000e\u0010\u001d\u001a\u00020\u00002\u0006\u0010\f\u001a\u00020\rJ\u0010\u0010\u001e\u001a\u00020\u00002\b\u0010\u001f\u001a\u0004\u0018\u00010 J\u001b\u0010!\u001a\u00020\u00002\u000e\u0010\"\u001a\n\u0012\u0004\u0012\u00020 \u0018\u00010#¢\u0006\u0002\u0010$J\u0010\u0010%\u001a\u00020\u00002\b\u0010&\u001a\u0004\u0018\u00010'J\u0010\u0010(\u001a\u00020\u00002\b\u0010)\u001a\u0004\u0018\u00010\u0013J\u0010\u0010*\u001a\u00020\u00002\b\u0010+\u001a\u0004\u0018\u00010\u0013J\u0012\u0010,\u001a\u0004\u0018\u00010-2\u0006\u0010\u0018\u001a\u00020\u0019H\u0002J\u000e\u0010.\u001a\u0004\u0018\u00010/*\u00020\rH\u0002J\u000e\u00100\u001a\u0004\u0018\u00010-*\u00020/H\u0002J\f\u00101\u001a\u00020\u0019*\u000202H\u0002¨\u00063"}, m13886d2 = {"Lcom/samsung/android/app/sdk/deepsky/common/ShortcutInfoDocument$Builder;", "Landroid/app/appsearch/GenericDocument$Builder;", "packageName", "", "id", "(Ljava/lang/String;Ljava/lang/String;)V", "build", "Lcom/samsung/android/app/sdk/deepsky/common/ShortcutInfoDocument;", "setActivity", "activity", "Landroid/content/ComponentName;", "setCapabilityBindings", "shortcutInfo", "Landroid/content/pm/ShortcutInfo;", "setCategories", ShortcutInfoDocument.KEY_CATEGORIES, "", "setDisabledMessage", ShortcutInfoDocument.KEY_DISABLED_MESSAGE, "", "setDisabledReason", ShortcutInfoDocument.KEY_DISABLED_REASON, "", "setExtras", ShortcutInfoDocument.KEY_EXTRAS, "Landroid/os/PersistableBundle;", "setFlags", ShortcutInfoDocument.KEY_FLAGS, "setIcon", "setIconResId", "setIntent", MarketingConstants.LINK_TYPE_INTENT, "Landroid/content/Intent;", "setIntents", ShortcutInfoDocument.KEY_INTENTS, "", "([Landroid/content/Intent;)Lcom/samsung/android/app/sdk/deepsky/common/ShortcutInfoDocument$Builder;", "setLocusId", ShortcutInfoDocument.KEY_LOCUS_ID, "Landroid/content/LocusId;", "setLongLabel", ShortcutInfoDocument.KEY_LONG_LABEL, "setShortLabel", ShortcutInfoDocument.KEY_SHORT_LABEL, "transformToByteArray", "", "getIcon", "Landroid/graphics/drawable/Icon;", "toBytes", "toPersistableBundle", "Landroid/os/Bundle;", "deepsky-sdk-smartsuggestion-6.1.0_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
    @SourceDebugExtension({"SMAP\nShortcutInfoDocument.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ShortcutInfoDocument.kt\ncom/samsung/android/app/sdk/deepsky/common/ShortcutInfoDocument$Builder\n+ 2 ArraysJVM.kt\nkotlin/collections/ArraysKt__ArraysJVMKt\n+ 3 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n+ 4 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,340:1\n37#2,2:341\n37#2,2:354\n37#2,2:360\n37#2,2:362\n13579#3,2:343\n11425#3:345\n11536#3,4:346\n11335#3:350\n11670#3,3:351\n1282#3,2:366\n1282#3,2:368\n1855#4:356\n1855#4,2:357\n1856#4:359\n1855#4,2:364\n*S KotlinDebug\n*F\n+ 1 ShortcutInfoDocument.kt\ncom/samsung/android/app/sdk/deepsky/common/ShortcutInfoDocument$Builder\n*L\n65#1:341,2\n92#1:354,2\n142#1:360,2\n143#1:362,2\n79#1:343,2\n84#1:345\n84#1:346,4\n92#1:350\n92#1:351,3\n189#1:366,2\n198#1:368,2\n135#1:356\n137#1:357,2\n135#1:359\n150#1:364,2\n*E\n"})
    public static final class Builder extends GenericDocument.Builder {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Builder(@NotNull String packageName, @NotNull String id) {
            super(packageName, id, ShortcutInfoDocument.SCHEMA_TYPE);
            Intrinsics.checkNotNullParameter(packageName, "packageName");
            Intrinsics.checkNotNullParameter(id, "id");
        }

        private final Icon getIcon(ShortcutInfo shortcutInfo) {
            Method method;
            try {
                Result.Companion companion = Result.INSTANCE;
                Method[] methods = shortcutInfo.getClass().getMethods();
                Intrinsics.checkNotNullExpressionValue(methods, "this::class.java.methods");
                int length = methods.length;
                int i = 0;
                while (true) {
                    if (i >= length) {
                        method = null;
                        break;
                    }
                    method = methods[i];
                    if (Intrinsics.areEqual(method.getName(), "getIcon")) {
                        break;
                    }
                    i++;
                }
                Object objInvoke = method != null ? method.invoke(shortcutInfo, null) : null;
                if (objInvoke instanceof Icon) {
                    return (Icon) objInvoke;
                }
                return null;
            } catch (Throwable th) {
                Result.Companion companion2 = Result.INSTANCE;
                Result.m22215constructorimpl(ResultKt.createFailure(th));
                return null;
            }
        }

        private final byte[] toBytes(Icon icon) {
            Method method;
            try {
                Result.Companion companion = Result.INSTANCE;
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                Method[] methods = Icon.class.getMethods();
                Intrinsics.checkNotNullExpressionValue(methods, "Icon::class.java.methods");
                int length = methods.length;
                int i = 0;
                while (true) {
                    if (i >= length) {
                        method = null;
                        break;
                    }
                    method = methods[i];
                    if (Intrinsics.areEqual(method.getName(), "writeToStream")) {
                        break;
                    }
                    i++;
                }
                if (method != null) {
                    method.invoke(icon, byteArrayOutputStream);
                }
                return byteArrayOutputStream.toByteArray();
            } catch (Throwable th) {
                Result.Companion companion2 = Result.INSTANCE;
                Result.m22215constructorimpl(ResultKt.createFailure(th));
                return null;
            }
        }

        private final PersistableBundle toPersistableBundle(Bundle bundle) {
            PersistableBundle persistableBundle = new PersistableBundle();
            Set<String> setKeySet = bundle.keySet();
            Intrinsics.checkNotNullExpressionValue(setKeySet, "keySet()");
            for (String str : setKeySet) {
                Object obj = bundle.get(str);
                if (obj != null) {
                    Intrinsics.checkNotNullExpressionValue(obj, "get(key) ?: return@forEach");
                    if (obj instanceof Boolean) {
                        persistableBundle.putBoolean(str, ((Boolean) obj).booleanValue());
                    } else if (obj instanceof boolean[]) {
                        persistableBundle.putBooleanArray(str, (boolean[]) obj);
                    } else if (obj instanceof Long) {
                        persistableBundle.putLong(str, ((Number) obj).longValue());
                    } else if (obj instanceof long[]) {
                        persistableBundle.putLongArray(str, (long[]) obj);
                    } else if (obj instanceof Double) {
                        persistableBundle.putDouble(str, ((Number) obj).doubleValue());
                    } else if (obj instanceof double[]) {
                        persistableBundle.putDoubleArray(str, (double[]) obj);
                    } else if (obj instanceof Integer) {
                        persistableBundle.putInt(str, ((Number) obj).intValue());
                    } else if (obj instanceof int[]) {
                        persistableBundle.putIntArray(str, (int[]) obj);
                    } else if (obj instanceof String) {
                        persistableBundle.putString(str, (String) obj);
                    } else if (obj instanceof Object[]) {
                        if (((Object[]) obj) instanceof String[]) {
                            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Array<kotlin.String>");
                            persistableBundle.putStringArray(str, (String[]) obj);
                        }
                    } else if (obj instanceof Bundle) {
                        persistableBundle.putPersistableBundle(str, toPersistableBundle((Bundle) obj));
                    }
                }
            }
            return persistableBundle;
        }

        private final byte[] transformToByteArray(PersistableBundle extras) {
            try {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                try {
                    new PersistableBundle(extras).writeToStream(byteArrayOutputStream);
                    byte[] byteArray = byteArrayOutputStream.toByteArray();
                    CloseableKt.closeFinally(byteArrayOutputStream, null);
                    return byteArray;
                } finally {
                }
            } catch (IOException unused) {
                return null;
            }
        }

        @NotNull
        public final Builder setActivity(@Nullable ComponentName activity) {
            if (activity != null) {
                setPropertyString(Constants.StringExtra.EXECUTE_TYPE_ACTIVITY, new String[]{activity.flattenToShortString()});
            }
            return this;
        }

        @NotNull
        public final Builder setCapabilityBindings(@NotNull ShortcutInfo shortcutInfo) {
            Intrinsics.checkNotNullParameter(shortcutInfo, "shortcutInfo");
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            List capabilities = shortcutInfo.getCapabilities();
            Intrinsics.checkNotNullExpressionValue(capabilities, "shortcutInfo.capabilities");
            Iterator it = capabilities.iterator();
            while (it.hasNext()) {
                Capability capabilityM5272b = AbstractC7011a.m5272b(it.next());
                String name = capabilityM5272b.getName();
                Intrinsics.checkNotNullExpressionValue(name, "capability.name");
                arrayList.add(name);
                List capabilityParams = shortcutInfo.getCapabilityParams(capabilityM5272b);
                Intrinsics.checkNotNullExpressionValue(capabilityParams, "shortcutInfo.getCapabilityParams(capability)");
                Iterator it2 = capabilityParams.iterator();
                while (it2.hasNext()) {
                    CapabilityParams capabilityParamsM5273c = AbstractC7011a.m5273c(it2.next());
                    arrayList2.add(AbstractC2322a.m1622l(capabilityM5272b.getName(), "/", capabilityParamsM5273c.getName(), "/", capabilityParamsM5273c.getValue()));
                }
            }
            if (!arrayList.isEmpty()) {
                String[] strArr = (String[]) arrayList.toArray(new String[0]);
                setPropertyString("capability", (String[]) Arrays.copyOf(strArr, strArr.length));
                String[] strArr2 = (String[]) arrayList2.toArray(new String[0]);
                setPropertyString("capabilityBindings", (String[]) Arrays.copyOf(strArr2, strArr2.length));
            }
            return this;
        }

        @NotNull
        public final Builder setCategories(@Nullable Set<String> categories) {
            if (categories != null) {
                Set<String> set = categories;
                if (!set.isEmpty()) {
                    String[] strArr = (String[]) set.toArray(new String[0]);
                    setPropertyString("categories", (String[]) Arrays.copyOf(strArr, strArr.length));
                }
            }
            return this;
        }

        @NotNull
        public final Builder setDisabledMessage(@Nullable CharSequence disabledMessage) {
            if (!TextUtils.isEmpty(disabledMessage)) {
                setPropertyString("disabledMessage", new String[]{String.valueOf(disabledMessage)});
            }
            return this;
        }

        @NotNull
        public final Builder setDisabledReason(int disabledReason) {
            setPropertyString("disabledReason", new String[]{String.valueOf(disabledReason)});
            return this;
        }

        @NotNull
        public final Builder setExtras(@Nullable PersistableBundle extras) {
            if (extras != null) {
                setPropertyBytes("extras", new byte[][]{transformToByteArray(extras)});
            }
            return this;
        }

        @NotNull
        public final Builder setFlags(@Nullable String flags) {
            if (flags != null) {
                setPropertyString("flags", new String[]{flags});
            }
            return this;
        }

        @NotNull
        public final Builder setIcon(@NotNull ShortcutInfo shortcutInfo) {
            Intrinsics.checkNotNullParameter(shortcutInfo, "shortcutInfo");
            Icon icon = getIcon(shortcutInfo);
            byte[] bytes = icon != null ? toBytes(icon) : null;
            if (bytes != null) {
                setPropertyBytes("icon", new byte[][]{bytes});
            }
            return this;
        }

        @NotNull
        public final Builder setIconResId(@NotNull ShortcutInfo shortcutInfo) {
            Intrinsics.checkNotNullParameter(shortcutInfo, "shortcutInfo");
            Icon icon = getIcon(shortcutInfo);
            if ((icon != null ? Integer.valueOf(icon.getResId()) : null) != null) {
                setPropertyLong(SearchIndexablesContract.BaseColumns.COLUMN_ICON_RESID, new long[]{r4.intValue()});
            }
            return this;
        }

        @NotNull
        public final Builder setIntent(@Nullable Intent intent) {
            if (intent != null) {
                setIntents(new Intent[]{intent});
            }
            return this;
        }

        @NotNull
        public final Builder setIntents(@Nullable Intent[] intents) {
            if (intents != null && intents.length != 0) {
                for (Intent intent : intents) {
                    Objects.requireNonNull(intent, "intents cannot contain null");
                    Objects.requireNonNull(intent.getAction(), "intent's action must be set");
                }
                int length = intents.length;
                byte[][] bArr = new byte[length][];
                ArrayList arrayList = new ArrayList(intents.length);
                int length2 = intents.length;
                int i = 0;
                int i2 = 0;
                while (i < length2) {
                    int i4 = i2 + 1;
                    Bundle extras = intents[i].getExtras();
                    bArr[i2] = extras == null ? new byte[0] : transformToByteArray(new PersistableBundle(toPersistableBundle(extras)));
                    arrayList.add(Unit.INSTANCE);
                    i++;
                    i2 = i4;
                }
                ArrayList arrayList2 = new ArrayList(intents.length);
                for (Intent intent2 : intents) {
                    arrayList2.add(intent2.toUri(0));
                }
                String[] strArr = (String[]) arrayList2.toArray(new String[0]);
                setPropertyString("intents", (String[]) Arrays.copyOf(strArr, strArr.length));
                setPropertyBytes("intentPersistableExtras", (byte[][]) Arrays.copyOf(bArr, length));
            }
            return this;
        }

        @NotNull
        public final Builder setLocusId(@Nullable LocusId locusId) {
            if (locusId != null) {
                setPropertyString("locusId", new String[]{locusId.getId()});
            }
            return this;
        }

        @NotNull
        public final Builder setLongLabel(@Nullable CharSequence longLabel) {
            if (!TextUtils.isEmpty(longLabel)) {
                setPropertyString("longLabel", new String[]{String.valueOf(longLabel)});
            }
            return this;
        }

        @NotNull
        public final Builder setShortLabel(@Nullable CharSequence shortLabel) {
            if (!TextUtils.isEmpty(shortLabel)) {
                setPropertyString("shortLabel", new String[]{String.valueOf(shortLabel)});
            }
            return this;
        }

        @NotNull
        public ShortcutInfoDocument build() {
            GenericDocument genericDocumentBuild = super.build();
            Intrinsics.checkNotNullExpressionValue(genericDocumentBuild, "super.build()");
            return new ShortcutInfoDocument(genericDocumentBuild);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0011\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001eR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082T¢\u0006\u0002\n\u0000R\u0011\u0010\u0017\u001a\u00020\u0018¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001a¨\u0006\u001f"}, m13886d2 = {"Lcom/samsung/android/app/sdk/deepsky/common/ShortcutInfoDocument$Companion;", "", "()V", "IS_DYNAMIC", "", "KEY_ACTIVITY", "KEY_CAPABILITY", "KEY_CAPABILITY_BINDINGS", "KEY_CATEGORIES", "KEY_DISABLED_MESSAGE", "KEY_DISABLED_REASON", "KEY_EXTRAS", "KEY_FLAGS", "KEY_ICON", "KEY_ICON_RES_ID", "KEY_INTENTS", "KEY_INTENT_PERSISTABLE_EXTRAS", "KEY_LOCUS_ID", "KEY_LONG_LABEL", "KEY_SHORT_LABEL", "SCHEMA_TYPE", "SCHEMA_VERSION", "", "schema", "Landroid/app/appsearch/AppSearchSchema;", "getSchema", "()Landroid/app/appsearch/AppSearchSchema;", "toGenericDocument", "Lcom/samsung/android/app/sdk/deepsky/common/ShortcutInfoDocument;", "shortcutInfo", "Landroid/content/pm/ShortcutInfo;", "deepsky-sdk-smartsuggestion-6.1.0_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final AppSearchSchema getSchema() {
            return ShortcutInfoDocument.schema;
        }

        @NotNull
        public final ShortcutInfoDocument toGenericDocument(@NotNull ShortcutInfo shortcutInfo) {
            Intrinsics.checkNotNullParameter(shortcutInfo, "shortcutInfo");
            String str = shortcutInfo.getPackage();
            Intrinsics.checkNotNullExpressionValue(str, "shortcutInfo.getPackage()");
            String id = shortcutInfo.getId();
            Intrinsics.checkNotNullExpressionValue(id, "shortcutInfo.id");
            return ((Builder) new Builder(str, id).setActivity(shortcutInfo.getActivity()).setShortLabel(shortcutInfo.getShortLabel()).setLongLabel(shortcutInfo.getLongLabel()).setDisabledMessage(shortcutInfo.getDisabledMessage()).setCategories(shortcutInfo.getCategories()).setIntents(shortcutInfo.getIntents()).setExtras(shortcutInfo.getExtras()).setCreationTimestampMillis(shortcutInfo.getLastChangedTimestamp())).setFlags(ShortcutInfoDocument.IS_DYNAMIC).setIcon(shortcutInfo).setIconResId(shortcutInfo).setDisabledReason(shortcutInfo.getDisabledReason()).setLocusId(shortcutInfo.getLocusId()).setCapabilityBindings(shortcutInfo).build();
        }

        private Companion() {
        }
    }

    static {
        AppSearchSchema appSearchSchemaBuild = AbstractC4744a.m3463c().addProperty(AbstractC0566c.m958f(AbstractC7018e.m5335o().setCardinality(2).setTokenizerType(1).setIndexingType(1).build())).addProperty(AbstractC0566c.m958f(AbstractC7018e.m5338r().setCardinality(2).setTokenizerType(1).setIndexingType(2).build())).addProperty(AbstractC0566c.m958f(AbstractC7018e.m5341u().setCardinality(2).setTokenizerType(1).setIndexingType(2).build())).addProperty(AbstractC0566c.m958f(AbstractC7018e.m5344x().setCardinality(2).setTokenizerType(0).setIndexingType(0).build())).addProperty(AbstractC0566c.m958f(AbstractC7018e.m5317A().setCardinality(1).setTokenizerType(1).setIndexingType(1).build())).addProperty(AbstractC0566c.m958f(AbstractC7018e.m5319C().setCardinality(1).setTokenizerType(0).setIndexingType(0).build())).addProperty(AbstractC0566c.m958f(AbstractC7018e.m5322b().setCardinality(1).build())).addProperty(AbstractC0566c.m958f(AbstractC7018e.m5320D().setCardinality(2).setTokenizerType(1).setIndexingType(1).build())).addProperty(AbstractC0566c.m958f(AbstractC7018e.m5329i().setCardinality(2).build())).addProperty(AbstractC0566c.m958f(AbstractC4744a.m3467g().setCardinality(1).setTokenizerType(1).setIndexingType(1).build())).addProperty(AbstractC0566c.m958f(AbstractC4744a.m3464d().setCardinality(2).build())).addProperty(AbstractC0566c.m958f(AbstractC4744a.m3465e().setCardinality(2).build())).addProperty(AbstractC0566c.m958f(AbstractC4744a.m3485y().setCardinality(3).setTokenizerType(1).setIndexingType(1).build())).addProperty(AbstractC0566c.m958f(AbstractC7018e.m5324d().setCardinality(1).setTokenizerType(1).setIndexingType(1).build())).addProperty(AbstractC0566c.m958f(AbstractC7018e.m5331k().setCardinality(1).setTokenizerType(1).setIndexingType(2).build())).build();
        Intrinsics.checkNotNullExpressionValue(appSearchSchemaBuild, "Builder(SCHEMA_TYPE)\n   …d()\n            ).build()");
        schema = appSearchSchemaBuild;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ShortcutInfoDocument(@NotNull GenericDocument document) {
        super(document);
        Intrinsics.checkNotNullParameter(document, "document");
    }
}
