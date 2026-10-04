package com.samsung.android.support.senl.ntnl.coedit.domain.operation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
@Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER})
public @interface NoteOpType {
    public static final int DELETE_CHARACTERS = 1;
    public static final int DELETE_ELEMENTS = 3;
    public static final int DELETE_OBJECT_SPAN = 8;
    public static final int INSERT_CHARACTERS = 0;
    public static final int INSERT_ELEMENTS = 2;
    public static final int INSERT_OBJECT_SPAN = 7;
    public static final int REPLACE_ATTRIBUTES = 5;
    public static final int RETAIN = 9;
    public static final int SET_ANNOTATIONS = 6;
    public static final int UNDEFINED = -1;
    public static final int UPDATE_ATTRIBUTES = 4;
}
