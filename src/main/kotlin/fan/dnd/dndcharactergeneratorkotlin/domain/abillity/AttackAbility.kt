package fan.dnd.dndcharactergeneratorkotlin.domain.abillity

import fan.dnd.dndcharactergeneratorkotlin.domain.DamageType
import fan.dnd.dndcharactergeneratorkotlin.domain.DiceType
import fan.dnd.dndcharactergeneratorkotlin.domain.StatName

class AttackAbility(
    name: String,
    description: String,
    useCount: Int,
    refreshRate: SkillRefreshRate,
    val distance: String,
    val savingThrow: StatName,
    val damageType: DamageType,
    val damageDice: DiceType,
    final val difficultyDice: DiceType,
    final val throwModifier: StatName,
    final val addProficiencyBonus: Boolean
) : Ability(name, description, useCount, refreshRate) {

    val accuracyInfo: String = (difficultyDice.name + " + player " + throwModifier.name) + " modifier" + if (addProficiencyBonus) " + proficiency bonus" else ""
}
