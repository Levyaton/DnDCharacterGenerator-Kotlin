package fan.dnd.dndcharactergeneratorkotlin.domain.race.elf

import com.fasterxml.jackson.annotation.JsonTypeName
import fan.dnd.dndcharactergeneratorkotlin.domain.Stat
import fan.dnd.dndcharactergeneratorkotlin.domain.Stat.Charisma
import fan.dnd.dndcharactergeneratorkotlin.domain.Weapon
import fan.dnd.dndcharactergeneratorkotlin.domain.abillity.Ability
import fan.dnd.dndcharactergeneratorkotlin.domain.abillity.generic.Nightvision
import fan.dnd.dndcharactergeneratorkotlin.domain.abillity.generic.SuperiorNightvision
import fan.dnd.dndcharactergeneratorkotlin.domain.spells.warlock.WarlockSpell1level
import fan.dnd.dndcharactergeneratorkotlin.domain.spells.wizard.WizardSpell2level
import fan.dnd.dndcharactergeneratorkotlin.domain.spells.wizard.WizardSpellCantrip
import fan.dnd.dndcharactergeneratorkotlin.persistance.SpellDao

@JsonTypeName("drow")
class DarkElfDrow : Elf() {
    override fun genericAbilities(): Set<Ability> = setOf(SuperiorNightvision()) + super.genericAbilities().filter { it.name != Nightvision().name }
    override fun charisma(): Stat = Charisma(1)
    override fun cantrips(): Set<SpellDao> = setOf(spellbook.spells.findBySpellId(WizardSpellCantrip.DANCING_LIGHTS.id))
    override fun spells(): Set<SpellDao> = setOf(spellbook.spells.findBySpellId(WarlockSpell1level.FAERIE_FIRE.id), spellbook.spells.findBySpellId(
        WizardSpell2level.DARKNESS.id))
    override fun weaponProficiencies(): Set<Weapon> = setOf(Weapon.RAPIER, Weapon.SHORTSWORD, Weapon.HAND_CROSSBOW)

}
