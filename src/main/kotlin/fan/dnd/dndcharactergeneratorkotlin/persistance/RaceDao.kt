package fan.dnd.dndcharactergeneratorkotlin.persistance

import fan.dnd.dndcharactergeneratorkotlin.domain.enumeration.Armour
import fan.dnd.dndcharactergeneratorkotlin.domain.enumeration.Language
import fan.dnd.dndcharactergeneratorkotlin.domain.Skill
import fan.dnd.dndcharactergeneratorkotlin.domain.enumeration.Weapon
import fan.dnd.dndcharactergeneratorkotlin.domain.abillity.Ability
import fan.dnd.dndcharactergeneratorkotlin.domain.abillity.AttackAbility
import fan.dnd.dndcharactergeneratorkotlin.domain.race.Race
import jakarta.persistence.*

@Entity
class RaceDao(
    val raceName: Race,
    val strength: Int,
    val dexterity: Int,
    val constitution: Int,
    val intelligence: Int,
    val wisdom: Int,
    val charisma: Int,
    val speed: Int,
    val otherTraits: String,
    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "RaceCahtrips", joinColumns = [JoinColumn(name = "raceId")])
    val cantrips: Set<Int> = emptySet(),
    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "RaceSpells", joinColumns = [JoinColumn(name = "raceId")])
    val spells: Set<Int> = emptySet(),
    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "RaceGenericAbilities", joinColumns = [JoinColumn(name = "raceId")])
    val genericAbilities: Set<Ability>,
    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "RaceDamageAbilities", joinColumns = [JoinColumn(name = "raceId")])
    val damageAbilities: Set<AttackAbility>,
    val proficiencies: Set<Skill>,
    val languages: Set<Language>,
    val armourProficiencies: Set<Armour>,
    val weaponProficiencies: Set<Weapon>,

    ): IdAncestor()
