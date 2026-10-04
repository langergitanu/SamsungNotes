package org.apache.commons.lang3.exception;

import com.samsung.android.sdk.smp.common.constants.MarketingConstants;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.presenter.stt.summarize.C9478c;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.apache.commons.lang3.Strings;
import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.commons.lang3.tuple.Pair;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class DefaultExceptionContext implements ExceptionContext, Serializable {
    private static final long serialVersionUID = 20110706;
    private final List<Pair<String, Object>> contextValues = new ArrayList();

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$getContextValues$0(String str, Pair pair) {
        return Strings.f9764CS.equals(str, (String) pair.getKey());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$getFirstContextValue$1(String str, Pair pair) {
        return Strings.f9764CS.equals(str, (String) pair.getKey());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$setContextValue$2(String str, Pair pair) {
        return Strings.f9764CS.equals(str, (String) pair.getKey());
    }

    private Stream<Pair<String, Object>> stream() {
        return this.contextValues.stream();
    }

    @Override // org.apache.commons.lang3.exception.ExceptionContext
    public List<Pair<String, Object>> getContextEntries() {
        return this.contextValues;
    }

    @Override // org.apache.commons.lang3.exception.ExceptionContext
    public Set<String> getContextLabels() {
        return (Set) stream().map(new C13833a(1)).collect(Collectors.toSet());
    }

    @Override // org.apache.commons.lang3.exception.ExceptionContext
    public List<Object> getContextValues(String str) {
        return (List) stream().filter(new C9478c(str, 5)).map(new C13833a(0)).collect(Collectors.toList());
    }

    @Override // org.apache.commons.lang3.exception.ExceptionContext
    public Object getFirstContextValue(String str) {
        return stream().filter(new C9478c(str, 7)).findFirst().map(new C13833a(0)).orElse(null);
    }

    @Override // org.apache.commons.lang3.exception.ExceptionContext
    public String getFormattedExceptionMessage(String str) {
        StringBuilder sb = new StringBuilder(256);
        if (str != null) {
            sb.append(str);
        }
        if (!this.contextValues.isEmpty()) {
            if (sb.length() > 0) {
                sb.append('\n');
            }
            sb.append("Exception Context:\n");
            int i = 0;
            for (Pair<String, Object> pair : this.contextValues) {
                sb.append("\t[");
                i++;
                sb.append(i);
                sb.append(':');
                sb.append(pair.getKey());
                sb.append(MarketingConstants.REFERRER_DELIMITER_U003D);
                try {
                    sb.append(Objects.toString(pair.getValue()));
                } catch (Exception e) {
                    sb.append("Exception thrown on toString(): ");
                    sb.append(ExceptionUtils.getStackTrace(e));
                }
                sb.append("]\n");
            }
            sb.append("---------------------------------");
        }
        return sb.toString();
    }

    @Override // org.apache.commons.lang3.exception.ExceptionContext
    public DefaultExceptionContext addContextValue(String str, Object obj) {
        this.contextValues.add(new ImmutablePair(str, obj));
        return this;
    }

    @Override // org.apache.commons.lang3.exception.ExceptionContext
    public DefaultExceptionContext setContextValue(String str, Object obj) {
        this.contextValues.removeIf(new C9478c(str, 6));
        addContextValue(str, obj);
        return this;
    }
}
