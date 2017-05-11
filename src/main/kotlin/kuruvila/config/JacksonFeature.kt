package kuruvila.config

import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider
import javax.ws.rs.core.Feature
import javax.ws.rs.core.FeatureContext


class JacksonFeature : Feature{
    override fun configure(context: FeatureContext): Boolean {
        context.register(JacksonJsonProvider())
        return true
    }
}