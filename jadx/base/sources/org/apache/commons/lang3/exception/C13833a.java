package org.apache.commons.lang3.exception;

import android.content.Context;
import com.samsung.scsp.framework.core.util.DeviceUtil;
import com.vladsch.flexmark.util.builder.BuilderBase;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.StringJoiner;
import java.util.function.Function;
import java.util.stream.Stream;
import org.apache.commons.lang3.reflect.MethodUtils;
import org.apache.commons.lang3.text.StrBuilder;
import org.apache.commons.lang3.tuple.Pair;
import org.apache.commons.logging.impl.Slf4jLogFactory;

/* JADX INFO: renamed from: org.apache.commons.lang3.exception.a */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public final /* synthetic */ class C13833a implements Function {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f9823a;

    public /* synthetic */ C13833a(int i) {
        this.f9823a = i;
    }

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        switch (this.f9823a) {
            case 0:
                return ((Pair) obj).getValue();
            case 1:
                return (String) ((Pair) obj).getKey();
            case 2:
                return String.valueOf((Class) obj);
            case 3:
                return ((Method) obj).toString();
            case 4:
                return MethodUtils.lambda$getMatchingMethod$4((Integer) obj);
            case 5:
                return ((Class) obj).getDeclaredMethods();
            case 6:
                return Stream.of((Object[]) obj);
            case 7:
                return ((StringBuilder) obj).toString();
            case 8:
                return ((StringJoiner) obj).toString();
            case 9:
                return StrBuilder.lambda$toCharArray$3(((Integer) obj).intValue());
            case 10:
                return StrBuilder.lambda$toCharArray$2(((Integer) obj).intValue());
            case 11:
                return Slf4jLogFactory.lambda$getInstance$0((String) obj);
            case 12:
                return (CharSequence) ((Map.Entry) obj).getValue();
            case 13:
                return (CharSequence) ((Map.Entry) obj).getKey();
            case 14:
                return DeviceUtil.lambda$static$0((Context) obj);
            default:
                return BuilderBase.lambda$addExtensionApiPoint$0((Class) obj);
        }
    }
}
