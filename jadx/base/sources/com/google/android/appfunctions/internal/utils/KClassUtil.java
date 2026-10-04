package com.google.android.appfunctions.internal.utils;

import androidx.annotation.RestrictTo;
import androidx.appcompat.widget.AbstractC0541b;
import com.samsung.android.support.senl.p145cm.base.common.constants.Extension;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(m13885d1 = {"\u0000\u0016\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u001a+\u0010\u0000\u001a\u0002H\u0001\"\b\b\u0000\u0010\u0001*\u00020\u0002*\b\u0012\u0004\u0012\u0002H\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005H\u0007¢\u0006\u0002\u0010\u0006¨\u0006\u0007"}, m13886d2 = {"findImpl", "T", "", "Ljava/lang/Class;", "suffix", "", "(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Object;", "java.com.google.android.libraries.llm.appfunctions.appfunctions_common_appfunctions_common"}, m13887k = 2, m13888mv = {2, 0, 0}, m13890xi = 48)
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
@JvmName(name = "KClassUtil")
public final class KClassUtil {
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    @NotNull
    public static final <T> T findImpl(@NotNull Class<T> cls, @NotNull String suffix) {
        Intrinsics.checkNotNullParameter(cls, "<this>");
        Intrinsics.checkNotNullParameter(suffix, "suffix");
        String packageName = cls.getPackageName();
        String canonicalName = cls.getCanonicalName();
        if (canonicalName == null) {
            throw new IllegalArgumentException("Required value was null.");
        }
        String strSubstring = canonicalName.substring(packageName.length() + 1);
        Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
        String strM756B = AbstractC0541b.m756B(strSubstring, suffix);
        try {
            Class<?> cls2 = Class.forName(packageName + Extension.DOT + strM756B, true, cls.getClassLoader());
            Intrinsics.checkNotNull(cls2, "null cannot be cast to non-null type java.lang.Class<T of com.google.android.appfunctions.internal.utils.KClassUtil.findImpl>");
            return (T) cls2.getDeclaredConstructor(null).newInstance(null);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(AbstractC0541b.m775q("Cannot find implementation for ", cls.getCanonicalName(), ". ", strM756B, " does not exist. Is AppFunction annotation processor correctly configured?"), e);
        } catch (IllegalAccessException e2) {
            throw new RuntimeException(AbstractC0541b.m772n("Cannot access the constructor ", cls.getCanonicalName()), e2);
        } catch (InstantiationException e3) {
            throw new RuntimeException(AbstractC0541b.m772n("Failed to create an instance of ", cls.getCanonicalName()), e3);
        }
    }

    public static /* synthetic */ Object findImpl$default(Class cls, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = "_Impl";
        }
        return findImpl(cls, str);
    }
}
