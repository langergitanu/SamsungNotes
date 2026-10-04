package com.samsung.android.support.senl.p145cm.base.spenwrapper.common;

import java.util.ArrayList;
import java.util.Collection;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.SourceDebugExtension;
import org.apache.xmlbeans.XmlErrorCodes;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(m13885d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001e\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J2\u0010\u0004\u001a\u0016\u0012\u0004\u0012\u0002H\u0006\u0018\u00010\u0005j\n\u0012\u0004\u0012\u0002H\u0006\u0018\u0001`\u0007\"\u0004\b\u0000\u0010\u00062\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u0002H\u0006\u0018\u00010\tH\u0007¨\u0006\n"}, m13886d2 = {"Lcom/samsung/android/support/senl/cm/base/spenwrapper/common/CollectionHelper;", "", "<init>", "()V", "toArrayList", "Ljava/util/ArrayList;", "T", "Lkotlin/collections/ArrayList;", XmlErrorCodes.LIST, "", "cmBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nCollectionHelper.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CollectionHelper.kt\ncom/samsung/android/support/senl/cm/base/spenwrapper/common/CollectionHelper\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,12:1\n1#2:13\n*E\n"})
public final class CollectionHelper {

    @NotNull
    public static final CollectionHelper INSTANCE = new CollectionHelper();

    private CollectionHelper() {
    }

    @JvmStatic
    @Nullable
    public static final <T> ArrayList<T> toArrayList(@Nullable Collection<? extends T> list) {
        if (list instanceof ArrayList) {
            return (ArrayList) list;
        }
        if (list != null) {
            return new ArrayList<>(list);
        }
        return null;
    }
}
