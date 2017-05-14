package kuruvila.config

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider
import javax.inject.Inject
import javax.ws.rs.core.Feature
import javax.ws.rs.core.FeatureContext


class JacksonFeature @Inject constructor(val objectMapper: ObjectMapper): Feature {

    override fun configure(context: FeatureContext): Boolean {
        context.register(JacksonJsonProvider(objectMapper))
        return true
    }
}