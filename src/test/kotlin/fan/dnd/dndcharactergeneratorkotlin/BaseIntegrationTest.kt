package fan.dnd.dndcharactergeneratorkotlin

import fan.dnd.dndcharactergeneratorkotlin.service.SpellService
import fan.dnd.dndcharactergeneratorkotlin.persistance.PlayerRepository
import fan.dnd.dndcharactergeneratorkotlin.persistance.RaceRepository
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.server.LocalServerPort
import org.springframework.test.context.ActiveProfiles
import org.springframework.web.reactive.function.client.WebClient

@ActiveProfiles("test")
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
abstract class BaseIntegrationTest: BaseTest() {
    @Autowired
    protected lateinit var db: TestDataBuilder
    @Autowired
    protected lateinit var playerRepository: PlayerRepository
    @Autowired
    protected lateinit var raceRepository: RaceRepository

    @Autowired
    protected lateinit var spellService: SpellService

    @LocalServerPort
    private val port: Int = 0

    lateinit var httpClient: WebClient

    @BeforeEach
    fun setUp() {
        tearDown()
        httpClient = WebClient.builder().baseUrl("http://localhost:$port/").build()
    }

    @AfterEach
    fun tearDown() {
        playerRepository.deleteAll()
    }

}
