package kuruvila

import java.util.*
import javax.ws.rs.GET
import javax.ws.rs.Path
import javax.ws.rs.Produces
import javax.ws.rs.core.MediaType

@Path("/")
class HelloResource {

    @GET
    @Path("/hello")
    fun hello(): String {
        return "Hello There"
    }

    @GET
    @Path("/json")
    @Produces(MediaType.APPLICATION_JSON)
    fun json(): JsonResponse {
        val j = JsonResponse("Hello World")
        return j
    }
}

data class JsonResponse(val text: String)