package fan.dnd.dndcharactergeneratorkotlin.domain.race.human

import fan.dnd.dndcharactergeneratorkotlin.domain.race.AbstractRace
import fan.dnd.dndcharactergeneratorkotlin.domain.race.Race

class Human : AbstractRace() {
    override fun raceName(): Race = Race.HUMAN
}
