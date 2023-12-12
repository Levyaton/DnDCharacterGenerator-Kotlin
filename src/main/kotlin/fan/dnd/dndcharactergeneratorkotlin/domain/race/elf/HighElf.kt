package fan.dnd.dndcharactergeneratorkotlin.domain.race.elf

import com.fasterxml.jackson.annotation.JsonTypeName
import fan.dnd.dndcharactergeneratorkotlin.domain.enumeration.Language
import fan.dnd.dndcharactergeneratorkotlin.domain.Stat
import fan.dnd.dndcharactergeneratorkotlin.domain.spells.wizard.WizardSpellCantrip
import fan.dnd.dndcharactergeneratorkotlin.domain.enumeration.Weapon
import fan.dnd.dndcharactergeneratorkotlin.domain.race.Race

@JsonTypeName("highElf")
class HighElf(val cantrip: WizardSpellCantrip, val extraLanguage: Language) : Elf() {
    override fun raceName(): Race = Race.HIGH_ELF
    override fun intelligence(): Stat = Stat.Intelligence(1)
    override fun languages(): Set<Language> =  setOf(extraLanguage) + super.languages()
    override fun cantrips(): Set<Int> = setOf(cantrip.id)
    override fun weaponProficiencies(): Set<Weapon> = setOf(Weapon.LONGSWORD, Weapon.SHORTSWORD, Weapon.SHORTBOW, Weapon.LONGBOW)

}
