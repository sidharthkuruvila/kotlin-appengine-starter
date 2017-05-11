package kuruvila.resource

import kuruvila.service.HelloService
import javax.inject.Inject
import javax.ws.rs.GET
import javax.ws.rs.Path
import javax.ws.rs.Produces
import javax.ws.rs.core.MediaType

@Path("/")
class HelloResource @Inject constructor(val service: HelloService){

    @GET
    @Path("/hello")
    fun hello(): String {
        return service.hello()
    }

    @GET
    @Path("/json")
    @Produces(MediaType.APPLICATION_JSON)
    fun json(): JsonResponse {
        val j = JsonResponse(service.hello())
        return j
    }
}

data class JsonResponse(val text: String)