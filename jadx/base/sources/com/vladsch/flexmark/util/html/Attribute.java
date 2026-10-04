package com.vladsch.flexmark.util.html;

import com.samsung.context.sdk.samsunganalytics.internal.policy.Constants;
import com.vladsch.flexmark.util.misc.Immutable;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public interface Attribute extends Immutable<Attribute, MutableAttribute> {
    public static final String ID_ATTR = "id";
    public static final String LINK_STATUS_ATTR = "Link Status";
    public static final String NAME_ATTR = "name";

    @Deprecated
    public static final char NUL = 0;
    public static final String STYLE_ATTR = "style";
    public static final String TARGET_ATTR = "target";
    public static final String TITLE_ATTR = "title";
    public static final Attribute NO_FOLLOW = AttributeImpl.m13363of(Constants.VALUE_LOG_TYPE_REL, "nofollow");
    public static final String CLASS_ATTR = "class";
    public static final Set<String> NON_RENDERING_WHEN_EMPTY = new HashSet(Arrays.asList(CLASS_ATTR, "id", "name", "style"));

    boolean containsValue(CharSequence charSequence);

    String getName();

    String getValue();

    char getValueListDelimiter();

    char getValueNameDelimiter();

    boolean isNonRendering();

    Attribute removeValue(CharSequence charSequence);

    Attribute replaceValue(CharSequence charSequence);

    Attribute setValue(CharSequence charSequence);
}
