package com.samsung.android.support.senl.addons.base.binding.binder;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import kotlin.Metadata;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m13885d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\b&\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0014\u0010\u0005\u001a\u0004\u0018\u00010\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0002H\u0016J\u0014\u0010\u0007\u001a\u0004\u0018\u00010\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0002H\u0016¨\u0006\b"}, m13886d2 = {"Lcom/samsung/android/support/senl/addons/base/binding/binder/AbsStringExecuteBinding;", "Lcom/samsung/android/support/senl/addons/base/binding/binder/AbsExecuteBinding;", "", "<init>", "()V", "convertStringToData", "data", "convertStringToRes", "ntAddons_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nAbsStringExecuteBinding.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AbsStringExecuteBinding.kt\ncom/samsung/android/support/senl/addons/base/binding/binder/AbsStringExecuteBinding\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,15:1\n1#2:16\n*E\n"})
public abstract class AbsStringExecuteBinding extends AbsExecuteBinding<String> {
    @Override // com.samsung.android.support.senl.addons.base.binding.binder.AbsExecuteBinding
    @Nullable
    public String convertStringToData(@Nullable String data) {
        return data;
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x002f  */
    @Override // com.samsung.android.support.senl.addons.base.binding.binder.AbsExecuteBinding
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public String convertStringToRes(@Nullable String data) {
        Integer numValueOf;
        int resId;
        Resources resources;
        View view = getView();
        Context context = view != null ? view.getContext() : null;
        if (context == null) {
            resId = 0;
        } else {
            if (data == null) {
                numValueOf = null;
                if (numValueOf != null && numValueOf.intValue() == 0) {
                    return "";
                }
                if (numValueOf != null) {
                    int iIntValue = numValueOf.intValue();
                    if (context != null && (resources = context.getResources()) != null) {
                        return resources.getString(iIntValue);
                    }
                }
                return null;
            }
            resId = AbsExecuteBinding.INSTANCE.getResId(context, "string", data);
        }
        numValueOf = Integer.valueOf(resId);
        if (numValueOf != null) {
            return "";
        }
        if (numValueOf != null) {
        }
        return null;
    }
}
