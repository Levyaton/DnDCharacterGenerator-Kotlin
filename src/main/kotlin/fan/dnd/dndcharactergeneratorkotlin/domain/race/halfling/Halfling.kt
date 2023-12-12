package fan.dnd.dndcharactergeneratorkotlin.domain.race.halfling

import fan.dnd.dndcharactergeneratorkotlin.domain.race.AbstractRace
import fan.dnd.dndcharactergeneratorkotlin.domain.race.Race

class Halfling : AbstractRace() {
    override fun raceName(): Race = Race.HALFLING
}
