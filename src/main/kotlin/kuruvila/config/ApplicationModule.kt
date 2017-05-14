package kuruvila.config

import com.fasterxml.jackson.databind.ObjectMapper
import com.google.inject.AbstractModule
import com.google.inject.Provides
import org.glassfish.jersey.server.mvc.mustache.MustacheMvcFeature

class ApplicationModule : AbstractModule() {
    override fun configure() {
    }

    @Provides fun objectMapper() : ObjectMapper{
        return ObjectMapper()
    }

}