package kuruvila.config

import com.google.inject.AbstractModule
import com.google.inject.Guice
import com.google.inject.servlet.ServletModule
import com.squarespace.jersey2.guice.JerseyGuiceModule
import com.squarespace.jersey2.guice.JerseyGuiceUtils
import javax.servlet.ServletContextEvent
import javax.servlet.ServletContextListener


class JerseyGuiceServletContextListener : ServletContextListener {
    override fun contextInitialized(sce: ServletContextEvent?) {
        val modules = arrayListOf(
                JerseyGuiceModule("__HK2_Generated_0"),
                ServletModule())

        modules.add(object : AbstractModule() {
            override fun configure() {
                // ...
            }
        })

        val injector = Guice.createInjector(modules)
        JerseyGuiceUtils.install(injector)
    }

    override fun contextDestroyed(sce: ServletContextEvent?) {
    }

}