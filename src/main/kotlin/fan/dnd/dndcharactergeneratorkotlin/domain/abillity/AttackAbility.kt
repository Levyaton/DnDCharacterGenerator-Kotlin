package fan.dnd.dndcharactergeneratorkotlin.domain.abillity

import fan.dnd.dndcharactergeneratorkotlin.domain.enumeration.DamageType
import fan.dnd.dndcharactergeneratorkotlin.domain.enumeration.DiceType
import fan.dnd.dndcharactergeneratorkotlin.domain.enumeration.Distance
import fan.dnd.dndcharactergeneratorkotlin.domain.enumeration.StatName
import jakarta.persistence.Embeddable
import jakarta.persistence.EnumType
import jakarta.persistence.Enumerated
import org.apache.commons.lang3.builder.HashCodeBuilder

@Embeddable
class AttackAbility(
    name: String,
    description: String,
    useCount: Int,
    refreshRate: SkillRefreshRate,
    @Enumerated(EnumType.STRING)
    val distance: Distance,
    val savingThrow: StatName,
    @Enumerated(EnumType.STRING)
    val damageType: DamageType,
    @Enumerated(EnumType.STRING)
    val damageDice: DiceType,
    @Enumerated(EnumType.STRING)
    val difficultyDice: DiceType,
    @Enumerated(EnumType.STRING)
    val throwModifier: StatName,
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
