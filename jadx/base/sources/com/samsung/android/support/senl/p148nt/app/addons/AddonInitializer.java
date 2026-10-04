package com.samsung.android.support.senl.p148nt.app.addons;

import android.content.Context;
import com.samsung.android.support.senl.addons.base.utils.PlatformUtil;
import com.samsung.android.support.senl.p145cm.base.framework.support.BaseUtils;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0007¨\u0006\u0006"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/app/addons/AddonInitializer;", "", "<init>", "()V", "initialize", "", "ntApp_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nAddonInitializer.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AddonInitializer.kt\ncom/samsung/android/support/senl/nt/app/addons/AddonInitializer\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,12:1\n1#2:13\n*E\n"})
public final class AddonInitializer {

    @NotNull
    public static final AddonInitializer INSTANCE = new AddonInitializer();

    private AddonInitializer() {
    }

    @JvmStatic
    public static final void initialize() {
        Context applicationContext = BaseUtils.getApplicationContext();
        if (applicationContext != null) {
            PlatformUtil.setDelegate(new PlatformUtilImpl(applicationContext));
        }
    }
}
