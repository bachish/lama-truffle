// CheckStyle: start generated
package com.truffle.lama;

import com.oracle.truffle.api.TruffleLanguage.Registration;
import com.oracle.truffle.api.dsl.GeneratedBy;
import com.oracle.truffle.api.provider.TruffleLanguageProvider;
import java.util.Collection;
import java.util.List;

@GeneratedBy(LamaLanguage.class)
@Registration(id = "lml", name = "Lama")
public final class LamaLanguageProvider extends TruffleLanguageProvider {

    @Override
    protected String getLanguageClassName() {
        return "com.truffle.lama.LamaLanguage";
    }

    @Override
    protected Object create() {
        return new LamaLanguage();
    }

    @Override
    protected Collection<String> getServicesClassNames() {
        return List.of();
    }

    @Override
    protected List<?> createFileTypeDetectors() {
        return List.of();
    }

    @Override
    protected List<String> getInternalResourceIds() {
        return List.of();
    }

    @Override
    protected Object createInternalResource(String resourceId) {
        throw new IllegalArgumentException(String.format("Unsupported internal resource id %s, supported ids are ", resourceId));
    }

}
