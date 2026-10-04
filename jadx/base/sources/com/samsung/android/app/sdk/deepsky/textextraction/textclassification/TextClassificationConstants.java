package com.samsung.android.app.sdk.deepsky.textextraction.textclassification;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000e\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0015"}, m13886d2 = {"Lcom/samsung/android/app/sdk/deepsky/textextraction/textclassification/TextClassificationConstants;", "", "()V", "ENTITIES", "", "ENTITY_EXTRAS_END", "ENTITY_EXTRAS_END_DEFAULT", "", "ENTITY_EXTRAS_START", "ENTITY_EXTRAS_START_DEFAULT", "ENTITY_EXTRAS_TEXT", "ENTITY_EXTRAS_TEXT_DEFAULT", "ENTITY_EXTRAS_TYPE", "ENTITY_EXTRAS_TYPE_DEFAULT", "ENTITY_INDEX", "EXTRA_KEY_LANGUAGE_TAG", "EXTRA_KEY_TEXT_SOURCE_TYPE_ID", "EXTRA_VALUE_TEXT_SOURCE_TYPE_ID_IMAGE", "IS_ACROSS_MULTIPLE_LINES_ENTITY_ENABLED", "IS_DUPLICATED_ENTITY_ENABLED", "IS_LOCALE_SPECIFIED_ENABLED", "deepsky-sdk-textextraction-8.0.19_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
public final class TextClassificationConstants {

    @NotNull
    public static final String ENTITIES = "entities";

    @NotNull
    public static final String ENTITY_EXTRAS_END = "end-index";
    public static final int ENTITY_EXTRAS_END_DEFAULT = 0;

    @NotNull
    public static final String ENTITY_EXTRAS_START = "start-index";
    public static final int ENTITY_EXTRAS_START_DEFAULT = 0;

    @NotNull
    public static final String ENTITY_EXTRAS_TEXT = "text";

    @NotNull
    public static final String ENTITY_EXTRAS_TEXT_DEFAULT = "";

    @NotNull
    public static final String ENTITY_EXTRAS_TYPE = "entity-type";

    @NotNull
    public static final String ENTITY_EXTRAS_TYPE_DEFAULT = "";

    @NotNull
    public static final String ENTITY_INDEX = "entity-index";

    @NotNull
    public static final String EXTRA_KEY_LANGUAGE_TAG = "language-tags";

    @NotNull
    public static final String EXTRA_KEY_TEXT_SOURCE_TYPE_ID = "text_source_type_id";

    @NotNull
    public static final String EXTRA_VALUE_TEXT_SOURCE_TYPE_ID_IMAGE = "image";

    @NotNull
    public static final TextClassificationConstants INSTANCE = new TextClassificationConstants();

    @NotNull
    public static final String IS_ACROSS_MULTIPLE_LINES_ENTITY_ENABLED = "is-across-multiple-lines-entity-enabled";

    @NotNull
    public static final String IS_DUPLICATED_ENTITY_ENABLED = "is-duplicated-entity-enabled";

    @NotNull
    public static final String IS_LOCALE_SPECIFIED_ENABLED = "is-locale-specified-enabled";

    private TextClassificationConstants() {
    }
}
