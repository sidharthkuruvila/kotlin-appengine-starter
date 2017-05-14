package kuruvila.config

import com.fasterxml.jackson.databind.ObjectMapper
import com.google.inject.AbstractModule
import com.google.inject.Provides

class ApplicationModule : AbstractModule() {
    override fun configure() {
    }

    @Provides fun objectMapper() : ObjectMapper{
        return ObjectMapper()
    }

}