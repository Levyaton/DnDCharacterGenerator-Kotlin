package fan.dnd.dndcharactergeneratorkotlin.domain

import fan.dnd.dndcharactergeneratorkotlin.domain.abillity.Ability
import fan.dnd.dndcharactergeneratorkotlin.domain.abillity.AttackAbility
import fan.dnd.dndcharactergeneratorkotlin.domain.race.AbstractRace
import fan.dnd.dndcharactergeneratorkotlin.domain.race.RaceCreator
import fan.dnd.dndcharactergeneratorkotlin.persistance.PlayerDao
import fan.dnd.dndcharactergeneratorkotlin.persistance.RaceDao
import fan.dnd.dndcharactergeneratorkotlin.persistance.SpellDao

class Player(race: RaceDao, player: PlayerDao) {
    val name: String = player.name
    val race: AbstractRace = RaceCreator.build(race)

    val initialRolls: InitialRolls = InitialRolls(
        player.strength,
        player.dexterity,
        player.constitution,
        player.intelligence,
        player.wisdom,
        player.charisma
    )

    val intelligence: Int = race.intelligence + player.intelligence
    val wisdom: Int = race.wisdom + player.wisdom
    val charisma: Int = race.charisma + player.charisma
    val strength: Int = race.strength + player.strength
    val dexterity: Int = race.dexterity + player.dexterity
    val constitution: Int = race.constitution + player.constitution

    val speed: Int = race.speed + player.speed

    val cantrips: Set<SpellDao> = race.cantrips + player.cantrips
    val spells: Set<SpellDao> = race.spells + player.spells
    val weaponProficiencies: Set<Weapon> = race.weaponProficiencies + player.weaponProficiencies
    val armourProficiencies: Set<Armour> = race.armourProficiencies + player.armourProficiencies
    val genericAbilities: Set<Ability> = race.genericAbilities + player.genericAbilities
    val damageAbilities: Set<AttackAbility> = race.damageAbilities + player.damageAbilities
    val proficiencies: Set<Skill> = race.proficiencies + player.proficiencies
    val languages: Set<Language> = race.languages + player.languages
}

class InitialRolls(
    val strength: Int,
    val dexterity: Int,
    val constitution: Int,
    val intelligence: Int,
    val wisdom: Int,
    val charisma: Int
)