package com.samsung.android.support.senl.addons.executor;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m13885d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\bf\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010J\u0012\u0010\u0002\u001a\u00020\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004H&J\u0012\u0010\u0005\u001a\u00020\u00002\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004H&J\u0012\u0010\u0007\u001a\u00020\u00002\b\u0010\b\u001a\u0004\u0018\u00010\u0004H&J\u0012\u0010\t\u001a\u00020\u00002\b\u0010\n\u001a\u0004\u0018\u00010\u0004H&J\u0012\u0010\u000b\u001a\u00020\u00002\b\u0010\f\u001a\u0004\u0018\u00010\u0004H&J\u0010\u0010\r\u001a\u00020\u00002\u0006\u0010\u000e\u001a\u00020\u000fH&¨\u0006\u0011"}, m13886d2 = {"Lcom/samsung/android/support/senl/addons/executor/IBrushExecuteIntentBuilder;", "Lcom/samsung/android/support/senl/addons/executor/IExecuteIntentBuilder;", "setInternalPath", "path", "", "setInputThumbnailPath", "inputThumbnailPath", "setInputPaintingDocPath", "inputPaintingDocPath", "setOutputThumbnailPath", "outputThumbnailPath", "setOutputPaintingDocPath", "outputPaintingDocPath", "setCloseCommand", "save", "", "Companion", "ntAddons_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public interface IBrushExecuteIntentBuilder extends IExecuteIntentBuilder {

    @NotNull
    public static final String ARG_BRUSH_INPUT_PAINTING_DOC_PATH = "brush_input_painting_doc_path";

    @NotNull
    public static final String ARG_BRUSH_INPUT_THUMBNAIL_PATH = "brush_input_thumbnail_path";

    @NotNull
    public static final String ARG_BRUSH_OUTPUT_PAINTING_DOC_PATH = "brush_output_painting_doc_path";

    @NotNull
    public static final String ARG_BRUSH_OUTPUT_THUMBNAIL_PATH = "brush_output_thumbnail_path";

    @NotNull
    public static final String ARG_INTERNAL_PATH = "internal_path";

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = Companion.$$INSTANCE;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\n"}, m13886d2 = {"Lcom/samsung/android/support/senl/addons/executor/IBrushExecuteIntentBuilder$Companion;", "", "<init>", "()V", "ARG_INTERNAL_PATH", "", "ARG_BRUSH_INPUT_THUMBNAIL_PATH", "ARG_BRUSH_OUTPUT_THUMBNAIL_PATH", "ARG_BRUSH_INPUT_PAINTING_DOC_PATH", "ARG_BRUSH_OUTPUT_PAINTING_DOC_PATH", "ntAddons_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();

        @NotNull
        public static final String ARG_BRUSH_INPUT_PAINTING_DOC_PATH = "brush_input_painting_doc_path";

        @NotNull
        public static final String ARG_BRUSH_INPUT_THUMBNAIL_PATH = "brush_input_thumbnail_path";

        @NotNull
        public static final String ARG_BRUSH_OUTPUT_PAINTING_DOC_PATH = "brush_output_painting_doc_path";

        @NotNull
        public static final String ARG_BRUSH_OUTPUT_THUMBNAIL_PATH = "brush_output_thumbnail_path";

        @NotNull
        public static final String ARG_INTERNAL_PATH = "internal_path";

        private Companion() {
        }
    }

    @NotNull
    IBrushExecuteIntentBuilder setCloseCommand(boolean save);

    @NotNull
    IBrushExecuteIntentBuilder setInputPaintingDocPath(@Nullable String inputPaintingDocPath);

    @NotNull
    IBrushExecuteIntentBuilder setInputThumbnailPath(@Nullable String inputThumbnailPath);

    @NotNull
    IBrushExecuteIntentBuilder setInternalPath(@Nullable String path);

    @NotNull
    IBrushExecuteIntentBuilder setOutputPaintingDocPath(@Nullable String outputPaintingDocPath);

    @NotNull
    IBrushExecuteIntentBuilder setOutputThumbnailPath(@Nullable String outputThumbnailPath);
}
