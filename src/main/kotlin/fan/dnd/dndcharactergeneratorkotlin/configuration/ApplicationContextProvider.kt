package fan.dnd.dndcharactergeneratorkotlin.configuration

import org.springframework.context.ApplicationContext
import org.springframework.context.ApplicationContextAware
import org.springframework.context.annotation.Configuration

@Configuration
class ApplicationContextProvider : ApplicationContextAware {
    companion object {
        private var context: ApplicationContext? = null

        fun <T> getBean(beanClass: Class<T>): T {
            return context!!.getBean(beanClass)
        }
    }

    override fun setApplicationContext(applicationContext: ApplicationContext) {
        context = applicationContext
    }
}
