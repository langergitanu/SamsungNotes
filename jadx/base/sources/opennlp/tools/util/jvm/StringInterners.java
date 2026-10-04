package opennlp.tools.util.jvm;

import androidx.appcompat.widget.AbstractC0541b;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class StringInterners {
    private static final StringInterner INTERNER;
    private static final Logger LOGGER;

    static {
        Logger logger = LoggerFactory.getLogger((Class<?>) StringInterners.class);
        LOGGER = logger;
        String property = System.getProperty("opennlp.interner.class", CHMStringInterner.class.getCanonicalName());
        try {
            INTERNER = (StringInterner) Class.forName(property).getDeclaredConstructor(null).newInstance(null);
            logger.debug("Using '{}' as String interner implementation.", property);
        } catch (Exception e) {
            throw new RuntimeException(AbstractC0541b.m774p("Could not load specified String interner implementation: '", property, "'. Reason: ", e.getLocalizedMessage()), e);
        }
    }

    public static String intern(String str) {
        if (str == null) {
            return null;
        }
        return INTERNER.intern(str);
    }
}
