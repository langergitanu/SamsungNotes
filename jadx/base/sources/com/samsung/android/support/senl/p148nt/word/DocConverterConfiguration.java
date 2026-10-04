package com.samsung.android.support.senl.p148nt.word;

import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.share.DocConverterHelper;
import com.samsung.android.support.senl.p148nt.word.powerpoint.PowerPointController;
import com.samsung.android.support.senl.p148nt.word.word.WordController;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import org.apache.commons.lang3.function.C13849N;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(m13885d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0007¨\u0006\u0006"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/word/DocConverterConfiguration;", "", "<init>", "()V", "setup", "", "ntWord_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class DocConverterConfiguration {

    @NotNull
    public static final DocConverterConfiguration INSTANCE = new DocConverterConfiguration();

    private DocConverterConfiguration() {
    }

    @JvmStatic
    public static final void setup() {
        DocConverterHelper.setCreator(new C13849N(13));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DocConverterHelper setup$lambda$0() {
        DocConverter docConverter = new DocConverter();
        docConverter.setPowerPointController(new PowerPointController());
        docConverter.setWordController(new WordController());
        return docConverter;
    }
}
