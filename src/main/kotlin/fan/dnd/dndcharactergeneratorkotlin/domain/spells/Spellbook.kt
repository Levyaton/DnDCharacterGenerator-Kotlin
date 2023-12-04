package fan.dnd.dndcharactergeneratorkotlin.domain.spells

import fan.dnd.dndcharactergeneratorkotlin.service.SpellRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Component
class Spellbook {
    @Autowired
    lateinit var spells: SpellRepository
}