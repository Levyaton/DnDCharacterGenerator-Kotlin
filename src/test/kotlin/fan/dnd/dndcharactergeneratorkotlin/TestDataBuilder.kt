package fan.dnd.dndcharactergeneratorkotlin

import fan.dnd.dndcharactergeneratorkotlin.domain.Skill
import fan.dnd.dndcharactergeneratorkotlin.domain.abillity.Ability
import fan.dnd.dndcharactergeneratorkotlin.domain.abillity.AttackAbility
import fan.dnd.dndcharactergeneratorkotlin.domain.abillity.attack.Dragonbreath
import fan.dnd.dndcharactergeneratorkotlin.domain.abillity.generic.FeyAncestry
import fan.dnd.dndcharactergeneratorkotlin.domain.abillity.generic.Nightvision
import fan.dnd.dndcharactergeneratorkotlin.domain.abillity.generic.Trance
import fan.dnd.dndcharactergeneratorkotlin.domain.enumeration.*
import fan.dnd.dndcharactergeneratorkotlin.domain.race.AbstractRace
import fan.dnd.dndcharactergeneratorkotlin.domain.race.Race
import fan.dnd.dndcharactergeneratorkotlin.domain.race.elf.HighElf
import fan.dnd.dndcharactergeneratorkotlin.domain.spells.SpellBook
import fan.dnd.dndcharactergeneratorkotlin.domain.spells.wizard.WizardSpell1level
import fan.dnd.dndcharactergeneratorkotlin.domain.spells.wizard.WizardSpellCantrip
import fan.dnd.dndcharactergeneratorkotlin.persistance.*
import fan.dnd.dndcharactergeneratorkotlin.service.SpellService
import jakarta.persistence.*
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import org.springframework.transaction.annotation.Propagation
import org.springframework.transaction.annotation.Transactional
import java.nio.file.WatchKey

@Component
@Transactional(propagation = Propagation.REQUIRES_NEW)
class TestDataBuilder {
    @Autowired
    lateinit var playerRepository: PlayerRepository

    @Autowired
    lateinit var raceRepository: RaceRepository

    @Autowired
    lateinit var spellRepository: SpellRepository

    fun createRaceDao(
        race: AbstractRace = HighElf(WizardSpellCantrip.DANCING_LIGHTS, Language.DWARVISH)
    ) = raceRepository.save(
        RaceDao(
            race.raceName(),
            race.strength().value,
            race.dexterity().value,
            race.constitution().value,
            race.intelligence().value,
            race.wisdom().value,
            race.charisma().value,
            race.speed(),
            race.otherTraits(),
            race.cantrips(),
            race.spells(),
            race.genericAbilities(),
            race.damageAbilities(),
            race.proficiencies(),
            race.languages(),
            race.armourProficiencies(),
            race.weaponProficiencies()
        )
    )

    fun createPlayerDao(
        raceId: Long,
        gameName: String = "testGame",
        speed: Int = 0,
        name: String = "John Doe of Lancaster",
        strength: Int = 18,
        dexterity: Int = 13,
        constitution: Int = 10,
        intelligence: Int = 13,
        wisdom: Int = 8,
        charisma: Int = 17,
        cantrips: MutableSet<SpellDao> = mutableSetOf(spellRepository.findBySpellId(WizardSpellCantrip.DANCING_LIGHTS.id)),
        spells: MutableSet<SpellDao> = mutableSetOf(spellRepository.findBySpellId(WizardSpell1level.ALARM.id)),
        weaponProficiencies: MutableSet<Weapon> = mutableSetOf(Weapon.BLOWGUN, Weapon.CLUB),
        armourProficiencies: MutableSet<Armour> = mutableSetOf(Armour.BREASTPLATE, Armour.CHAIN_MAIL),
        genericAbilities: MutableSet<Ability> = mutableSetOf(Nightvision()),
        damageAbilities: MutableSet<AttackAbility> = mutableSetOf(
            Dragonbreath(
                StatName.DEXTERITY,
                DamageType.FIRE,
                Distance.FIFTEEN_FEET_CONE
            )
        ),
        proficiencies: MutableSet<Skill> = mutableSetOf(Skill.PERCEPTION, Skill.ACROBATICS),
        languages: MutableSet<Language> = mutableSetOf(Language.INFERNAL)
    ) = playerRepository.save(
        PlayerDao(
            gameName = gameName,
            speed = speed,
            name = name,
            strength = strength,
            dexterity = dexterity,
            constitution = constitution,
            intelligence = intelligence,
            wisdom = wisdom,
            charisma = charisma,
            cantrips = cantrips.map { it.spellId }.toMutableSet(),
            spells = spells.map { it.spellId }.toMutableSet(),
            weaponProficiencies = weaponProficiencies,
            armourProficiencies = armourProficiencies,
            genericAbilities = genericAbilities,
            damageAbilities = damageAbilities,
            proficiencies = proficiencies,
            languages = languages,
            raceId = raceId
        )
    )
}