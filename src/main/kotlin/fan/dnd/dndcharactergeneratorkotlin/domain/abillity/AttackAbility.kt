package fan.dnd.dndcharactergeneratorkotlin.domain.abillity

import fan.dnd.dndcharactergeneratorkotlin.domain.DamageType
import fan.dnd.dndcharactergeneratorkotlin.domain.DiceType
import fan.dnd.dndcharactergeneratorkotlin.domain.StatName
import jakarta.persistence.Embeddable
import org.apache.commons.lang3.builder.HashCodeBuilder

@Embeddable
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

    override fun equals(other: Any?): Boolean = this.hashCode() == other.hashCode()
    override fun hashCode(): Int = HashCodeBuilder()
        .append(super.hashCode())
        .append(distance)
        .append(savingThrow)
        .append(damageType)
        .append(damageDice)
        .append(difficultyDice)
        .append(throwModifier)
        .append(addProficiencyBonus)
        .toHashCode()

}
