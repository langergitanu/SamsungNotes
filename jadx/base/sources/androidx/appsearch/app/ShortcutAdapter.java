package androidx.appsearch.app;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.appsearch.safeparcel.GenericDocumentParcel;
import androidx.core.content.p110pm.ShortcutInfoCompat;
import androidx.core.util.Preconditions;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@RequiresApi(api = 21)
@ExperimentalAppSearchApi
public class ShortcutAdapter {
    private static final String APPSEARCH_GENERIC_DOC_PARCEL_NAME_IN_BUNDLE = "appsearch_generic_doc_parcel";

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static final String DEFAULT_DATABASE = "__shortcut_adapter_db__";
    public static final String DEFAULT_NAMESPACE = "__shortcut_adapter_ns__";
    private static final String FIELD_NAME = "name";
    private static final String NAMESPACE_CHECK_ERROR_MESSAGE = "Namespace of the document does not match androidx.appsearch.app.ShortcutAdapter.DEFAULT_NAMESPACE.Please use androidx.appsearch.app.ShortcutAdapter.DEFAULT_NAMESPACE as the namespace of the document if it will be used to create a shortcut.";
    private static final String SCHEME_APPSEARCH = "appsearch";

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @RequiresApi(33)
    public static class Api33Impl {
        private Api33Impl() {
        }

        @DoNotInline
        public static <T> T getParcelableFromBundle(Bundle bundle, String str, Class<T> cls) {
            Preconditions.checkNotNull(bundle);
            Preconditions.checkNotNull(str);
            Preconditions.checkNotNull(cls);
            return (T) bundle.getParcelable(str, cls);
        }
    }

    private ShortcutAdapter() {
    }

    public static ShortcutInfoCompat.Builder createShortcutBuilderFromDocument(Context context, Object obj) {
        Preconditions.checkNotNull(context);
        Preconditions.checkNotNull(obj);
        GenericDocument genericDocumentFromDocumentClass = GenericDocument.fromDocumentClass(obj);
        if (!DEFAULT_NAMESPACE.equals(genericDocumentFromDocumentClass.getNamespace())) {
            throw new IllegalArgumentException(NAMESPACE_CHECK_ERROR_MESSAGE);
        }
        String propertyString = genericDocumentFromDocumentClass.getPropertyString("name");
        Bundle bundle = new Bundle();
        bundle.putParcelable(APPSEARCH_GENERIC_DOC_PARCEL_NAME_IN_BUNDLE, genericDocumentFromDocumentClass.getDocumentParcel());
        ShortcutInfoCompat.Builder builder = new ShortcutInfoCompat.Builder(context, genericDocumentFromDocumentClass.getId());
        if (TextUtils.isEmpty(propertyString)) {
            propertyString = genericDocumentFromDocumentClass.getId();
        }
        return builder.setShortLabel(propertyString).setIntent(new Intent("android.intent.action.VIEW", getDocumentUri(genericDocumentFromDocumentClass))).setExcludedFromSurfaces(1).setTransientExtras(bundle);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static GenericDocument extractDocument(ShortcutInfoCompat shortcutInfoCompat) {
        Preconditions.checkNotNull(shortcutInfoCompat);
        Bundle transientExtras = shortcutInfoCompat.getTransientExtras();
        if (transientExtras == null) {
            return null;
        }
        GenericDocumentParcel genericDocumentParcel = Build.VERSION.SDK_INT >= 33 ? (GenericDocumentParcel) Api33Impl.getParcelableFromBundle(transientExtras, APPSEARCH_GENERIC_DOC_PARCEL_NAME_IN_BUNDLE, GenericDocumentParcel.class) : (GenericDocumentParcel) transientExtras.getParcelable(APPSEARCH_GENERIC_DOC_PARCEL_NAME_IN_BUNDLE);
        if (genericDocumentParcel == null) {
            return null;
        }
        return new GenericDocument(genericDocumentParcel);
    }

    public static Uri getDocumentUri(Object obj) {
        Preconditions.checkNotNull(obj);
        return getDocumentUri(GenericDocument.fromDocumentClass(obj));
    }

    private static Uri getDocumentUri(GenericDocument genericDocument) {
        Preconditions.checkNotNull(genericDocument);
        return getDocumentUri(genericDocument.getId());
    }

    public static Uri getDocumentUri(String str) {
        Preconditions.checkNotNull(str);
        return new Uri.Builder().scheme(SCHEME_APPSEARCH).authority(DEFAULT_DATABASE).path("__shortcut_adapter_ns__/" + str).build();
    }
}
