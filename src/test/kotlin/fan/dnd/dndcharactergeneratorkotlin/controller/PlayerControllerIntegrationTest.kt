package fan.dnd.dndcharactergeneratorkotlin.controller

import fan.dnd.dndcharactergeneratorkotlin.BaseIntegrationTest
import fan.dnd.dndcharactergeneratorkotlin.Given
import fan.dnd.dndcharactergeneratorkotlin.Then
import fan.dnd.dndcharactergeneratorkotlin.When
import fan.dnd.dndcharactergeneratorkotlin.domain.Player
import fan.dnd.dndcharactergeneratorkotlin.domain.enumeration.Language
import fan.dnd.dndcharactergeneratorkotlin.domain.Skill
import fan.dnd.dndcharactergeneratorkotlin.domain.enumeration.Weapon
import fan.dnd.dndcharactergeneratorkotlin.domain.abillity.Ability
import fan.dnd.dndcharactergeneratorkotlin.domain.enumeration.Armour
import fan.dnd.dndcharactergeneratorkotlin.domain.race.Race
import fan.dnd.dndcharactergeneratorkotlin.domain.spells.wizard.WizardSpellCantrip
import fan.dnd.dndcharactergeneratorkotlin.persistance.PlayerDao
import fan.dnd.dndcharactergeneratorkotlin.persistance.RaceDao
import io.kotest.assertions.assertSoftly
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test
import org.springframework.http.MediaType

class PlayerControllerIntegrationTest : BaseIntegrationTest() {

    @Test
    fun `When a new player is created, then they are stored in the DB`() {
        Given()
        val playerJson = """
               {
                 "gameName": "testGame",
                  "name": "John Doe",
                  "rolledIntelligence": 20,
                  "rolledWisdom": 12,
                  "rolledCharisma": 13,
                  "rolledStrength": 19,
                  "rolledDexterity": 4,
                  "rolledConstitution": 10,
                  "race": {
                    "type": "highElf",
                    "cantrip": "ACID_SPLASH",
                    "extraLanguage": "DWARVISH"
                  }
                }
                """.trimIndent()
        When("I create a player")
        httpClient.post().uri("player").contentType(MediaType.APPLICATION_JSON).bodyValue(playerJson).retrieve().toBodilessEntity().block()

        Then("I can find the player in the database")
        val playerDao: PlayerDao = playerRepository.findByGameNameAndName("testGame","John Doe")
        assertSoftly(playerDao){
            name shouldBe "John Doe"
            strength shouldBe 19
            dexterity shouldBe 4
            constitution shouldBe 10
            intelligence shouldBe 20
            wisdom shouldBe 12
            charisma shouldBe 13
            cantrips.size shouldBe 0
            spells.size shouldBe 0
            genericAbilities.size shouldBe 0
            damageAbilities.size shouldBe 0
            weaponProficiencies.size shouldBe 0
            armourProficiencies.size shouldBe 0
            proficiencies.size shouldBe 0
            languages.size shouldBe 0
        }
        val race = raceRepository.findById(playerDao.raceId).get()
        assertSoftly(race){
            this.raceName shouldBe Race.HIGH_ELF
            strength shouldBe 0
            dexterity shouldBe 2
            constitution shouldBe 0
            intelligence shouldBe 1
            wisdom shouldBe 0
            charisma shouldBe 0
            cantrips.size shouldBe 1
            cantrips.first() shouldBe WizardSpellCantrip.ACID_SPLASH.id
            spells.size shouldBe 0
            genericAbilities.size shouldBe 3
            assertSoftly(genericAbilities.toList().sortedBy { it.name }){
                this[0].name shouldBe "Fey Ancestry"
                this[0].description shouldBe "You have advantage on saving throws against being charmed, and magic can't put you to sleep."
                this[0].refreshRate shouldBe Ability.SkillRefreshRate.UNLIMITED
                this[0].useCount shouldBe Ability.UNLIMITED_USE_CONSTANT
                this[1].name shouldBe "Nightvision"
                this[1].description shouldBe "You can see in dim light within 60 feet of you as if it were bright light, and in darkness as if it were dim light. You can't discern color in darkness, only shades of gray."
                this[1].refreshRate shouldBe Ability.SkillRefreshRate.UNLIMITED
                this[1].useCount shouldBe Ability.UNLIMITED_USE_CONSTANT
                this[2].name shouldBe "Trance"
                this[2].description shouldBe "Elves don't need to sleep. Instead, they meditate deeply, remaining semiconscious, for 4 hours a day. (The Common word for such meditation is \"trance.\") While meditating, you can dream after a fashion; such dreams are actually mental exercises that have become reflexive through years of practice. After resting in this way, you gain the same benefit that a human does from 8 hours of sleep."
                this[2].refreshRate shouldBe Ability.SkillRefreshRate.UNLIMITED
                this[2].useCount shouldBe Ability.UNLIMITED_USE_CONSTANT
            }
            damageAbilities.size shouldBe 0
            weaponProficiencies shouldBe setOf(Weapon.LONGBOW, Weapon.SHORTSWORD, Weapon.SHORTBOW, Weapon.LONGSWORD)
            armourProficiencies.size shouldBe 0
            proficiencies shouldBe setOf(Skill.PERCEPTION)
            languages shouldBe setOf(Language.COMMON, Language.DWARVISH, Language.ELVISH)
        }
    }


    @Test
    fun `When a getPlayer is called, then the given player is correctly found and transformed`() {
        Given()

        val raceDao = db.createRaceDao()
        val playerDao = db.createPlayerDao(raceDao.id)

        When("I call getPlayer")
        val result = httpClient.get().uri("player/testGame/John Doe of Lancaster").retrieve().bodyToMono(Player::class.java).block()

        Then("I get the correct player")
        assertSoftly {  }
        assertSoftly(result!!){
            name shouldBe "John doe of Lancaster"
            strength shouldBe 18
            dexterity shouldBe 13
            constitution shouldBe 10
            intelligence shouldBe 13
            wisdom shouldBe 8
            charisma shouldBe 17
            cantrips.size shouldBe 1
            cantrips.first().name shouldBe "Dancing Lights"
            spells.size shouldBe 1
            spells.first().name shouldBe "Alarm"
            genericAbilities.size shouldBe 1
            genericAbilities.first().name shouldBe "Nightvision"
            damageAbilities.size shouldBe 1
            damageAbilities.first().name shouldBe "Dragonbreath"
            weaponProficiencies.size shouldBe 2
            weaponProficiencies shouldBe setOf(Weapon.BLOWGUN, Weapon.CLUB)
            armourProficiencies.size shouldBe 2
            armourProficiencies shouldBe setOf(Armour.BREASTPLATE, Armour.CHAIN_MAIL)
            proficiencies.size shouldBe 2
            proficiencies shouldBe setOf(Skill.PERCEPTION, Skill.ACROBATICS)
            languages.size shouldBe 1
            languages shouldBe setOf(Language.INFERNAL)
        }

    }
}
