package fan.dnd.dndcharactergeneratorkotlin.domain.race.changling

import fan.dnd.dndcharactergeneratorkotlin.domain.Stat
import fan.dnd.dndcharactergeneratorkotlin.domain.race.AbstractRace


class Changeling internal constructor(private val selectedStat: ModifierInput) : AbstractRace() {

    private var dexMod = 0
    private var intMod = 0

    init {
        when(selectedStat){
            ModifierInput.DEXTERITY -> dexMod = 1
            ModifierInput.INTELLIGENCE -> intMod = 1
        }
    }

    override fun raceName(): String = this.javaClass.name

    override fun dexterity(): Stat = Stat.Dexterity(dexMod)
    override fun intelligence(): Stat = Stat.Intelligence(intMod)
    override fun charisma(): Stat = Stat.Charisma(2)
    enum class ModifierInput {
        DEXTERITY,
        INTELLIGENCE
    }
}
