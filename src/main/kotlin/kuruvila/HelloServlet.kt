package kuruvila

import javax.servlet.http.HttpServlet
import javax.servlet.ServletException
import java.net.URISyntaxException
import java.io.IOException
import javax.servlet.http.HttpServletResponse
import javax.servlet.http.HttpServletRequest



class HelloServlet : HttpServlet() {
    @Throws(IOException::class, ServletException::class)
    public override fun doGet(req: HttpServletRequest, resp: HttpServletResponse) {
        resp.writer.println("Hello world")
    }
}