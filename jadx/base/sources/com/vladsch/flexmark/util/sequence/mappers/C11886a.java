package com.vladsch.flexmark.util.sequence.mappers;

/* JADX INFO: renamed from: com.vladsch.flexmark.util.sequence.mappers.a */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public final /* synthetic */ class C11886a implements CharMapper {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f8421a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ CharMapper f8422b;

    /* JADX INFO: renamed from: c */
    public final /* synthetic */ CharMapper f8423c;

    public /* synthetic */ C11886a(CharMapper charMapper, CharMapper charMapper2, int i) {
        this.f8421a = i;
        this.f8422b = charMapper;
        this.f8423c = charMapper2;
    }

    @Override // com.vladsch.flexmark.util.sequence.mappers.CharMapper
    public final char map(char c) {
        switch (this.f8421a) {
            case 0:
                return this.f8422b.lambda$compose$1(this.f8423c, c);
            default:
                return this.f8422b.lambda$andThen$2(this.f8423c, c);
        }
    }
}
