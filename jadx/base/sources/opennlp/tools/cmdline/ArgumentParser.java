package opennlp.tools.cmdline;

import androidx.appcompat.widget.AbstractC0541b;
import com.microsoft.identity.common.java.cache.CacheKeyValueDelegate;
import com.samsung.android.sdk.smp.common.constants.MarketingConstants;
import com.samsung.android.support.senl.p148nt.data.database.core.query.sqlbuilder.SQLKeyword;
import com.vladsch.flexmark.util.sequence.SequenceUtils;
import java.io.File;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.nio.charset.Charset;
import java.nio.charset.IllegalCharsetNameException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import kotlin.collections.AbstractC12991c;
import opennlp.tools.commons.Internal;
import org.apache.commons.beanutils.PropertyUtils;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
@Internal
public class ArgumentParser {
    private static final Map<Class<?>, ArgumentFactory> argumentFactories;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class Argument extends AbstractC12991c {
        private final String argument;
        private final String description;
        private final boolean optional;
        private final String value;

        public Argument(String str, String str2, String str3, boolean z) {
            this.argument = str;
            this.value = str2;
            this.description = str3;
            this.optional = z;
        }

        public String argument() {
            return this.argument;
        }

        public String description() {
            return this.description;
        }

        public final boolean equals(Object obj) {
            if (!(obj instanceof Argument)) {
                return false;
            }
            Argument argument = (Argument) obj;
            return this.optional == argument.optional && Objects.equals(this.argument, argument.argument) && Objects.equals(this.value, argument.value) && Objects.equals(this.description, argument.description);
        }

        public final int hashCode() {
            boolean z = this.optional;
            String str = this.argument;
            String str2 = this.value;
            String str3 = this.description;
            return Objects.hashCode(str3) + ((Objects.hashCode(str2) + ((Objects.hashCode(str) + (Boolean.hashCode(z) * 31)) * 31)) * 31);
        }

        public boolean optional() {
            return this.optional;
        }

        public final String toString() {
            Object[] objArr = {this.argument, this.value, this.description, Boolean.valueOf(this.optional)};
            String[] strArrSplit = "argument;value;description;optional".length() == 0 ? new String[0] : "argument;value;description;optional".split(";");
            StringBuilder sb = new StringBuilder();
            sb.append(Argument.class.getSimpleName());
            sb.append("[");
            for (int i = 0; i < strArrSplit.length; i++) {
                sb.append(strArrSplit[i]);
                sb.append(MarketingConstants.REFERRER_DELIMITER_U003D);
                sb.append(objArr[i]);
                if (i != strArrSplit.length - 1) {
                    sb.append(SQLKeyword.COMMA);
                }
            }
            sb.append("]");
            return sb.toString();
        }

        public String value() {
            return this.value;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface ArgumentFactory {
        public static final String INVALID_ARG = "Invalid argument: %s %s \n";

        Object parseArgument(Method method, String str, String str2);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class ArgumentProxy extends AbstractC12991c implements InvocationHandler {
        private final Map<String, Object> arguments;

        public /* synthetic */ ArgumentProxy(HashMap map) {
            this((Map<String, Object>) map);
        }

        public Map<String, Object> arguments() {
            return this.arguments;
        }

        public final boolean equals(Object obj) {
            return (obj instanceof ArgumentProxy) && Objects.equals(this.arguments, ((ArgumentProxy) obj).arguments);
        }

        public final int hashCode() {
            return Objects.hashCode(this.arguments);
        }

        @Override // java.lang.reflect.InvocationHandler
        public Object invoke(Object obj, Method method, Object[] objArr) {
            if (objArr == null) {
                return this.arguments.get(method.getName());
            }
            throw new IllegalStateException();
        }

        public final String toString() {
            Object[] objArr = {this.arguments};
            String[] strArrSplit = "arguments".length() == 0 ? new String[0] : "arguments".split(";");
            StringBuilder sb = new StringBuilder();
            sb.append(ArgumentProxy.class.getSimpleName());
            sb.append("[");
            for (int i = 0; i < strArrSplit.length; i++) {
                sb.append(strArrSplit[i]);
                sb.append(MarketingConstants.REFERRER_DELIMITER_U003D);
                sb.append(objArr[i]);
                if (i != strArrSplit.length - 1) {
                    sb.append(SQLKeyword.COMMA);
                }
            }
            sb.append("]");
            return sb.toString();
        }

        private ArgumentProxy(Map<String, Object> map) {
            this.arguments = map;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class BooleanArgumentFactory implements ArgumentFactory {
        public /* synthetic */ BooleanArgumentFactory(int i) {
            this();
        }

        @Override // opennlp.tools.cmdline.ArgumentParser.ArgumentFactory
        public Object parseArgument(Method method, String str, String str2) {
            return Boolean.valueOf(Boolean.parseBoolean(str2));
        }

        private BooleanArgumentFactory() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class CharsetArgumentFactory implements ArgumentFactory {
        public /* synthetic */ CharsetArgumentFactory(int i) {
            this();
        }

        @Override // opennlp.tools.cmdline.ArgumentParser.ArgumentFactory
        public Object parseArgument(Method method, String str, String str2) {
            try {
                if (OptionalParameter.DEFAULT_CHARSET.equals(str2)) {
                    return Charset.defaultCharset();
                }
                if (Charset.isSupported(str2)) {
                    return Charset.forName(str2);
                }
                throw new TerminateToolException(1, ("Invalid argument: " + str + " " + str2 + SequenceUtils.SPACE_EOL).concat("Encoding not supported on this platform."));
            } catch (IllegalCharsetNameException unused) {
                throw new TerminateToolException(1, AbstractC0541b.m775q("Invalid argument: ", str, " ", str2, SequenceUtils.SPACE_EOL).concat("Illegal encoding name."));
            }
        }

        private CharsetArgumentFactory() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class FileArgumentFactory implements ArgumentFactory {
        public /* synthetic */ FileArgumentFactory(int i) {
            this();
        }

        @Override // opennlp.tools.cmdline.ArgumentParser.ArgumentFactory
        public Object parseArgument(Method method, String str, String str2) {
            return new File(str2);
        }

        private FileArgumentFactory() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class IntegerArgumentFactory implements ArgumentFactory {
        public /* synthetic */ IntegerArgumentFactory(int i) {
            this();
        }

        @Override // opennlp.tools.cmdline.ArgumentParser.ArgumentFactory
        public Object parseArgument(Method method, String str, String str2) {
            try {
                return Integer.valueOf(Integer.parseInt(str2));
            } catch (NumberFormatException e) {
                throw new TerminateToolException(1, AbstractC0541b.m775q("Invalid argument: ", str, " ", str2, SequenceUtils.SPACE_EOL).concat("Value must be an integer!"), e);
            }
        }

        private IntegerArgumentFactory() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Retention(RetentionPolicy.RUNTIME)
    public @interface OptionalParameter {
        public static final String DEFAULT_CHARSET = "DEFAULT_CHARSET";

        String defaultValue() default "";
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Retention(RetentionPolicy.RUNTIME)
    public @interface ParameterDescription {
        String description() default "";

        String valueName();
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class StringArgumentFactory implements ArgumentFactory {
        public /* synthetic */ StringArgumentFactory(int i) {
            this();
        }

        private StringArgumentFactory() {
        }

        @Override // opennlp.tools.cmdline.ArgumentParser.ArgumentFactory
        public Object parseArgument(Method method, String str, String str2) {
            return str2;
        }
    }

    static {
        HashMap map = new HashMap();
        int i = 0;
        map.put(Integer.class, new IntegerArgumentFactory(i));
        map.put(Boolean.class, new BooleanArgumentFactory(i));
        map.put(String.class, new StringArgumentFactory(i));
        map.put(File.class, new FileArgumentFactory(i));
        map.put(Charset.class, new CharsetArgumentFactory(i));
        argumentFactories = Collections.unmodifiableMap(map);
    }

    private ArgumentParser() {
    }

    private static void checkProxyInterfaces(Class<?>... clsArr) {
        for (Class<?> cls : clsArr) {
            if (cls != null) {
                if (!cls.isInterface()) {
                    throw new IllegalArgumentException("proxy interface is not an interface!");
                }
                Method[] methods = cls.getMethods();
                if (methods.length == 0) {
                    throw new IllegalArgumentException("proxy interface must at least declare one method!");
                }
                for (Method method : methods) {
                    if (!method.getName().startsWith("get") && method.getName().length() > 3) {
                        throw new IllegalArgumentException(AbstractC0541b.m756B(method.getName(), " method name does not start with 'get'!"));
                    }
                    if (method.getParameterTypes().length != 0) {
                        throw new IllegalArgumentException(method.getName() + " method must have zero parameters but has " + method.getParameterTypes().length + "!");
                    }
                    Class<?> returnType = method.getReturnType();
                    Set<Class<?>> setKeySet = argumentFactories.keySet();
                    if (!setKeySet.contains(returnType)) {
                        throw new IllegalArgumentException(method.getName() + " method must have compatible return type! Got " + returnType + ", expected one of " + setKeySet);
                    }
                }
            }
        }
    }

    public static List<Argument> createArguments(Class<?>... clsArr) {
        checkProxyInterfaces(clsArr);
        HashSet hashSet = new HashSet();
        LinkedList linkedList = new LinkedList();
        for (Class<?> cls : clsArr) {
            if (cls != null) {
                for (Method method : cls.getMethods()) {
                    ParameterDescription parameterDescription = (ParameterDescription) method.getAnnotation(ParameterDescription.class);
                    OptionalParameter optionalParameter = (OptionalParameter) method.getAnnotation(OptionalParameter.class);
                    if (parameterDescription != null) {
                        String strMethodNameToParameter = methodNameToParameter(method.getName());
                        if (!hashSet.contains(strMethodNameToParameter)) {
                            hashSet.add(strMethodNameToParameter);
                            linkedList.add(new Argument(strMethodNameToParameter.substring(1), parameterDescription.valueName(), parameterDescription.description(), optionalParameter != null));
                        }
                    }
                }
            }
        }
        return linkedList;
    }

    public static <T> String createUsage(Class<T> cls) {
        return createUsage((Class<?>[]) new Class[]{cls});
    }

    public static <T> String[] filter(String[] strArr, Class<T> cls) {
        ArrayList arrayList = new ArrayList(strArr.length);
        for (Method method : cls.getMethods()) {
            String strMethodNameToParameter = methodNameToParameter(method.getName());
            if (-1 < CmdLineUtil.getParameterIndex(strMethodNameToParameter, strArr)) {
                arrayList.add(strMethodNameToParameter);
                String parameter = CmdLineUtil.getParameter(strMethodNameToParameter, strArr);
                if (parameter != null) {
                    arrayList.add(parameter);
                }
            }
        }
        return (String[]) arrayList.toArray(new String[0]);
    }

    private static String methodNameToParameter(String str) {
        char[] charArray = str.toCharArray();
        charArray[3] = Character.toLowerCase(charArray[3]);
        return AbstractC0541b.m772n(CacheKeyValueDelegate.CACHE_VALUE_SEPARATOR, new String(charArray).substring(3));
    }

    public static <T> T parse(String[] strArr, Class<T> cls) {
        Object argument;
        checkProxyInterfaces(cls);
        if (!validateArguments(strArr, cls)) {
            throw new IllegalArgumentException("Passed args must be valid!");
        }
        HashMap map = new HashMap();
        for (Method method : cls.getMethods()) {
            String strMethodNameToParameter = methodNameToParameter(method.getName());
            String parameter = CmdLineUtil.getParameter(strMethodNameToParameter, strArr);
            if (parameter == null) {
                OptionalParameter optionalParameter = (OptionalParameter) method.getAnnotation(OptionalParameter.class);
                if (optionalParameter.defaultValue().length() > 0) {
                    parameter = optionalParameter.defaultValue();
                }
            }
            Class<?> returnType = method.getReturnType();
            if (parameter != null) {
                ArgumentFactory argumentFactory = argumentFactories.get(returnType);
                if (argumentFactory == null) {
                    throw new IllegalStateException(AbstractC0541b.m768j(returnType, "factory for '", "' must not be null"));
                }
                argument = argumentFactory.parseArgument(method, strMethodNameToParameter, parameter);
            } else {
                argument = null;
            }
            map.put(method.getName(), argument);
        }
        return (T) Proxy.newProxyInstance(cls.getClassLoader(), new Class[]{cls}, new ArgumentProxy(map));
    }

    public static <T> boolean validateArguments(String[] strArr, Class<T> cls) {
        return validateArguments(strArr, (Class<?>[]) new Class[]{cls});
    }

    public static String validateArgumentsLoudly(String[] strArr, Class<?> cls) {
        return validateArgumentsLoudly(strArr, (Class<?>[]) new Class[]{cls});
    }

    public static String createUsage(Class<?>... clsArr) {
        checkProxyInterfaces(clsArr);
        HashSet hashSet = new HashSet();
        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        for (Class<?> cls : clsArr) {
            if (cls != null) {
                for (Method method : cls.getMethods()) {
                    ParameterDescription parameterDescription = (ParameterDescription) method.getAnnotation(ParameterDescription.class);
                    OptionalParameter optionalParameter = (OptionalParameter) method.getAnnotation(OptionalParameter.class);
                    if (parameterDescription != null) {
                        String strMethodNameToParameter = methodNameToParameter(method.getName());
                        if (!hashSet.contains(strMethodNameToParameter)) {
                            hashSet.add(strMethodNameToParameter);
                            if (optionalParameter != null) {
                                sb.append(PropertyUtils.INDEXED_DELIM);
                            }
                            sb.append(strMethodNameToParameter);
                            sb.append(' ');
                            sb.append(parameterDescription.valueName());
                            sb2.append('\t');
                            sb2.append(strMethodNameToParameter);
                            sb2.append(' ');
                            sb2.append(parameterDescription.valueName());
                            sb2.append('\n');
                            if (parameterDescription.description().length() > 0) {
                                sb2.append("\t\t");
                                sb2.append(parameterDescription.description());
                                sb2.append('\n');
                            }
                            if (optionalParameter != null) {
                                sb.append(PropertyUtils.INDEXED_DELIM2);
                            }
                            sb.append(' ');
                        }
                    }
                }
            }
        }
        if (sb.length() > 0) {
            sb.setLength(sb.length() - 1);
        }
        if (sb2.length() > 0) {
            sb2.setLength(sb2.length() - 1);
            sb.append("\n\nArguments description:\n");
            sb.append((CharSequence) sb2);
        }
        return sb.toString();
    }

    public static boolean validateArguments(String[] strArr, Class<?>... clsArr) {
        return validateArgumentsLoudly(strArr, clsArr) == null;
    }

    public static String validateArgumentsLoudly(String[] strArr, Class<?>... clsArr) {
        if (strArr.length % 2 != 0) {
            return "Number of parameters must be always be even";
        }
        ArrayList arrayList = new ArrayList(Arrays.asList(strArr));
        int i = 0;
        for (Class<?> cls : clsArr) {
            for (Method method : cls.getMethods()) {
                String strMethodNameToParameter = methodNameToParameter(method.getName());
                int parameterIndex = CmdLineUtil.getParameterIndex(strMethodNameToParameter, strArr);
                String parameter = CmdLineUtil.getParameter(strMethodNameToParameter, strArr);
                if (parameter != null) {
                    arrayList.remove(strMethodNameToParameter);
                    arrayList.remove(parameter);
                    i++;
                } else {
                    if (((OptionalParameter) method.getAnnotation(OptionalParameter.class)) == null) {
                        return -1 < parameterIndex ? AbstractC0541b.m772n("Missing mandatory parameter value: ", strMethodNameToParameter) : AbstractC0541b.m772n("Missing mandatory parameter: ", strMethodNameToParameter);
                    }
                    arrayList.remove(CacheKeyValueDelegate.CACHE_VALUE_SEPARATOR + strMethodNameToParameter);
                }
            }
        }
        if (strArr.length / 2 <= i) {
            return null;
        }
        return "Unrecognized parameters encountered: " + arrayList;
    }
}
