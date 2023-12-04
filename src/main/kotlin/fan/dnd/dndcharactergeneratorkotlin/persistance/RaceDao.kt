package fan.dnd.dndcharactergeneratorkotlin.persistance

import fan.dnd.dndcharactergeneratorkotlin.domain.Armour
import fan.dnd.dndcharactergeneratorkotlin.domain.Language
import fan.dnd.dndcharactergeneratorkotlin.domain.Skill
import fan.dnd.dndcharactergeneratorkotlin.domain.Weapon
import fan.dnd.dndcharactergeneratorkotlin.domain.abillity.Ability
import jakarta.persistence.*

@Entity
class RaceDao(
    val raceName: String,
    val strength: Int,
    val dexterity: Int,
    val constitution: Int,
    val intelligence: Int,
    val wisdom: Int,
    val charisma: Int,
    val speed: Int,
    val otherTraits: String,
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
        name = "RaceCantrips",
        joinColumns = [JoinColumn(name = "raceId")],
        inverseJoinColumns = [JoinColumn(name = "spellId")]
    )
    val cantrips: Set<SpellDao> = emptySet(),

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
        name = "RaceSpells",
        joinColumns = [JoinColumn(name = "raceId")],
        inverseJoinColumns = [JoinColumn(name = "spellId")]
    )
    val spells: Set<SpellDao> = emptySet(),
    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "RaceGenericAbilities", joinColumns = [JoinColumn(name = "raceId")])
    val genericAbilities: Set<Ability>,
    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "RaceDamageAbilities", joinColumns = [JoinColumn(name = "raceId")])
    val damageAbilities: Set<Ability>,
    val proficiencies: Set<Skill>,
    val languages: Set<Language>,
    val armourProficiencies: Set<Armour>,
    val weaponProficiencies: Set<Weapon>,

): IdAncestor()
