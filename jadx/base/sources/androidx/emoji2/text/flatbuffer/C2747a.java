package androidx.emoji2.text.flatbuffer;

import com.samsung.android.app.notes.widget.glance.setting.view.WidgetCreatorRecycleViewActivity;
import com.samsung.android.support.senl.p148nt.base.widget.setting.BaseWidgetSettingActivity;
import com.samsung.android.vexfwk.param.VexFwkBokehEffectParams;
import com.samsung.android.vexfwk.param.VexFwkImageEffectParams;
import com.samsung.android.vexfwk.param.VexFwkImageTaggerResult;
import com.samsung.android.vexfwk.param.VexFwkOcrResult;
import com.samsung.scsp.common.ContextFactory;
import com.samsung.scsp.framework.core.SContext;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.TimeZone;
import java.util.WeakHashMap;
import java.util.function.Supplier;
import opennlp.tools.namefind.BioCodec;
import org.apache.commons.lang3.function.Suppliers;
import org.apache.commons.logging.LogFactory;

/* JADX INFO: renamed from: androidx.emoji2.text.flatbuffer.a */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class C2747a implements Supplier {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f1505a;

    public /* synthetic */ C2747a(int i) {
        this.f1505a = i;
    }

    @Override // java.util.function.Supplier
    public final Object get() {
        switch (this.f1505a) {
            case 0:
                return Utf8Old.lambda$static$0();
            case 1:
                return WidgetCreatorRecycleViewActivity.onCreate$lambda$0();
            case 2:
                return Collections.EMPTY_LIST;
            case 3:
                return BaseWidgetSettingActivity.onCreate$lambda$0();
            case 4:
                return VexFwkBokehEffectParams.CREATOR;
            case 5:
                return VexFwkImageEffectParams.CREATOR;
            case 6:
                return VexFwkImageTaggerResult.CREATOR;
            case 7:
                return VexFwkOcrResult.CREATOR;
            case 8:
                return SContext.lambda$new$1();
            case 9:
                return ContextFactory.getApplicationContext();
            case 10:
                return new BioCodec();
            case 11:
                return new HashSet();
            case 12:
                return new LinkedHashSet();
            case 13:
                return new WeakHashMap();
            case 14:
                return Suppliers.lambda$static$0();
            case 15:
                return new StringBuilder();
            case 16:
                return TimeZone.getDefault();
            case 17:
                return LogFactory.lambda$newStandardFactory$32();
            case 18:
                return LogFactory.lambda$newStandardFactory$30();
            case 19:
                return LogFactory.lambda$newStandardFactory$31();
            case 20:
                return LogFactory.lambda$getFactory$12();
            case 21:
                return LogFactory.lambda$getFactory$3();
            case 22:
                return LogFactory.lambda$getFactory$5();
            case 23:
                return LogFactory.lambda$getFactory$10();
            case 24:
                return LogFactory.lambda$implementsLogFactory$23();
            case 25:
                return LogFactory.lambda$newStandardFactory$29();
            default:
                return new ArrayList();
        }
    }
}
