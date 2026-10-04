package com.vladsch.flexmark.util.misc;

import com.samsung.android.support.senl.p148nt.app.main.noteslist.presenter.C8416h;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class TemplateUtil {
    public static final Resolver NULL_RESOLVER = new C8416h(18);

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface Resolver {
        String resolve(String[] strArr);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ String lambda$static$0(String[] strArr) {
        return null;
    }

    public static String resolveRefs(CharSequence charSequence, Pattern pattern, Resolver resolver) {
        if (charSequence == null) {
            return "";
        }
        Matcher matcher = pattern.matcher(charSequence);
        if (!matcher.find()) {
            return charSequence.toString();
        }
        StringBuffer stringBuffer = new StringBuffer();
        do {
            int iGroupCount = matcher.groupCount() + 1;
            String[] strArr = new String[iGroupCount];
            for (int i = 0; i < iGroupCount; i++) {
                strArr[i] = matcher.group(i);
            }
            String strResolve = resolver.resolve(strArr);
            matcher.appendReplacement(stringBuffer, strResolve == null ? "" : strResolve.replace("\\", "\\\\").replace("$", "\\$"));
        } while (matcher.find());
        matcher.appendTail(stringBuffer);
        return stringBuffer.toString();
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class MappedResolver implements Resolver {
        protected final Map<String, String> resolved;

        public MappedResolver(Map<String, String> map) {
            this.resolved = map;
        }

        public Map<String, String> getMMap() {
            return this.resolved;
        }

        @Override // com.vladsch.flexmark.util.misc.TemplateUtil.Resolver
        public String resolve(String[] strArr) {
            if (strArr.length > 2) {
                return null;
            }
            return this.resolved.get(strArr[1]);
        }

        public MappedResolver set(String str, String str2) {
            this.resolved.put(str, str2);
            return this;
        }

        public MappedResolver() {
            this(new HashMap());
        }
    }
}
