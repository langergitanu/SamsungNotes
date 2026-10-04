package com.samsung.android.support.senl.p145cm.base.framework.content;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(m13885d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u0000 \b2\u00020\u0001:\u0001\bB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\t"}, m13886d2 = {"Lcom/samsung/android/support/senl/cm/base/framework/content/TypedArrayCompat;", "", "<init>", "()V", "obtainTypedArray", "Landroid/content/res/TypedArray;", "id", "", "Companion", "cmBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class TypedArrayCompat {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @Nullable
    private static Context mApplicatoinContext;

    @Nullable
    private static TypedArrayCompat mInstance;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0005R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u000b\u001a\u00020\n8F¢\u0006\u0006\u001a\u0004\b\f\u0010\r¨\u0006\u000e"}, m13886d2 = {"Lcom/samsung/android/support/senl/cm/base/framework/content/TypedArrayCompat$Companion;", "", "<init>", "()V", "mApplicatoinContext", "Landroid/content/Context;", "setApplicationContext", "", "context", "mInstance", "Lcom/samsung/android/support/senl/cm/base/framework/content/TypedArrayCompat;", "instance", "getInstance", "()Lcom/samsung/android/support/senl/cm/base/framework/content/TypedArrayCompat;", "cmBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    @SuppressLint({"StaticFieldLeak"})
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final synchronized TypedArrayCompat getInstance() {
            TypedArrayCompat typedArrayCompat;
            try {
                if (TypedArrayCompat.mInstance == null) {
                    TypedArrayCompat.mInstance = new TypedArrayCompat();
                }
                typedArrayCompat = TypedArrayCompat.mInstance;
                Intrinsics.checkNotNull(typedArrayCompat, "null cannot be cast to non-null type com.samsung.android.support.senl.cm.base.framework.content.TypedArrayCompat");
            } catch (Throwable th) {
                throw th;
            }
            return typedArrayCompat;
        }

        public final void setApplicationContext(@NotNull Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            TypedArrayCompat.mApplicatoinContext = context;
        }

        private Companion() {
        }
    }

    @Nullable
    public final TypedArray obtainTypedArray(int id) {
        Resources resources;
        Context context = mApplicatoinContext;
        if (context == null || (resources = context.getResources()) == null) {
            return null;
        }
        return resources.obtainTypedArray(id);
    }
}
