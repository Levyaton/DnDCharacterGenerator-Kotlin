package fan.dnd.dndcharactergeneratorkotlin.domain.race.elf

import com.fasterxml.jackson.annotation.JsonTypeName
import fan.dnd.dndcharactergeneratorkotlin.domain.Stat
import fan.dnd.dndcharactergeneratorkotlin.domain.enumeration.Weapon
import fan.dnd.dndcharactergeneratorkotlin.domain.abillity.Ability
import fan.dnd.dndcharactergeneratorkotlin.domain.abillity.generic.MaskOfTheWild
import fan.dnd.dndcharactergeneratorkotlin.domain.race.Race

@JsonTypeName("woodElf")
class WoodElf : Elf() {
    override fun raceName(): Race = Race.WOOD_ELF
    override fun wisdom(): Stat = Stat.Wisdom(1)
    override fun speed(): Int = 35
    override fun genericAbilities(): Set<Ability> = setOf(MaskOfTheWild()) + super.genericAbilities()

    override fun weaponProficiencies(): Set<Weapon> = setOf(Weapon.LONGSWORD, Weapon.SHORTSWORD, Weapon.SHORTBOW, Weapon.LONGBOW)

}
