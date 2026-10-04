package uk.p245ac.p246ed.p247ph.snuggletex.definitions;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes11.dex */
public interface CommandOrEnvironment {
    int getArgumentCount();

    LaTeXMode getArgumentMode(int i);

    String getTeXName();

    boolean isAllowingOptionalArgument();
}
