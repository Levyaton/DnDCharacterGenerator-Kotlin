package fan.dnd.dndcharactergeneratorkotlin.persistance

import fan.dnd.dndcharactergeneratorkotlin.domain.enumeration.Armour
import fan.dnd.dndcharactergeneratorkotlin.domain.enumeration.Language
import fan.dnd.dndcharactergeneratorkotlin.domain.Skill
import fan.dnd.dndcharactergeneratorkotlin.domain.enumeration.Weapon
import fan.dnd.dndcharactergeneratorkotlin.domain.abillity.Ability
import fan.dnd.dndcharactergeneratorkotlin.domain.abillity.AttackAbility
import jakarta.persistence.*

@Entity
@Table(
    name = "PlayerDao",
    uniqueConstraints = [
        UniqueConstraint(columnNames = ["name", "gameName"])
    ]
)
class PlayerDao(
    val gameName: String,
    var speed: Int = 0,
    var name: String = "",
    var strength: Int = 0,
    var dexterity: Int = 0,
    var constitution: Int = 0,
    var intelligence: Int = 0,
    var wisdom: Int = 0,
    var charisma: Int = 0,

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "PlayerCantrips", joinColumns = [JoinColumn(name = "playerId")])
    val cantrips: MutableSet<Int>,

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "PlayerSpells", joinColumns = [JoinColumn(name = "playerId")])
    val spells: MutableSet<Int>,

    @ElementCollection(targetClass = Weapon::class, fetch = FetchType.EAGER)
     @Enumerated(EnumType.STRING) // or EnumType.ORDINAL
     @CollectionTable(name = "Weapons")
     @Column(name = "weaponProficiencies")
     val weaponProficiencies: MutableSet<Weapon>,

    @ElementCollection(targetClass = Armour::class, fetch = FetchType.EAGER)
     @Enumerated(EnumType.STRING) // or EnumType.ORDINAL
     @CollectionTable(name = "Armours")
     @Column(name = "armourProficiencies")
     val armourProficiencies: MutableSet<Armour>,

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "PlayerGenericAbilities", joinColumns = [JoinColumn(name = "playerId")])
    val genericAbilities: MutableSet<Ability>,

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "PlayerDamageAbilities", joinColumns = [JoinColumn(name = "playerId")])
    val damageAbilities: MutableSet<AttackAbility>,

    @ElementCollection(targetClass = Skill::class, fetch = FetchType.EAGER)
    @Enumerated(EnumType.STRING)
    @CollectionTable(name = "player_skills", joinColumns = [JoinColumn(name = "player_id")])
    @Column(name = "skill")
    val proficiencies: MutableSet<Skill>,

    @ElementCollection(targetClass = Language::class, fetch = FetchType.EAGER)
    @Enumerated(EnumType.STRING) // or EnumType.ORDINAL
    @CollectionTable(name = "Languages")
    @Column(name = "languages")
    val languages: MutableSet<Language>,

    val raceId: Long
): IdAncestor()
