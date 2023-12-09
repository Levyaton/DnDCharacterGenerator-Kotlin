package fan.dnd.dndcharactergeneratorkotlin.controller

import fan.dnd.dndcharactergeneratorkotlin.BaseIntegrationTest
import fan.dnd.dndcharactergeneratorkotlin.Given
import fan.dnd.dndcharactergeneratorkotlin.Then
import fan.dnd.dndcharactergeneratorkotlin.When
import fan.dnd.dndcharactergeneratorkotlin.domain.Skill
import fan.dnd.dndcharactergeneratorkotlin.domain.Weapon
import fan.dnd.dndcharactergeneratorkotlin.domain.abillity.Ability
import fan.dnd.dndcharactergeneratorkotlin.persistance.PlayerDao
import io.kotest.assertions.assertSoftly
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders

class PlayerControllerIntegrationTest : BaseIntegrationTest() {

    @Test
    fun `When a new player is created, then they are stored in the DB`() {
        Given()
        val playerJson = """
               {
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

        Then("I can find the player in the database")
        val playerDao: PlayerDao = playerRepository.findByName("John Doe")
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
            this.raceName shouldBe "High Elf"
            strength shouldBe 0
            dexterity shouldBe 2
            constitution shouldBe 0
            intelligence shouldBe 1
            wisdom shouldBe 0
            charisma shouldBe 0
            cantrips.size shouldBe 1
            cantrips.first().name shouldBe "Acid Splash"
            spells.size shouldBe 0
            genericAbilities.size shouldBe 3
            assertSoftly(genericAbilities.sortedBy { it.name }){
                this[0].name shouldBe "Fey Ancestry"
                this[0].description shouldBe "You have advantage on saving throws against being charmed, and magic can't put you to sleep."
                this[0].refreshRate shouldBe Ability.SkillRefreshRate.DAY
                this[0].useCount shouldBe 1
                this[1].name shouldBe "Nightvision"
                this[1].description shouldBe "You can see in dim light within 60 feet of you as if it were bright light, and in darkness as if it were dim light. You can't discern color in darkness, only shades of gray."
                this[1].refreshRate shouldBe Ability.SkillRefreshRate.DAY
                this[1].useCount shouldBe 1
                this[2].name shouldBe "Trance"
                this[2].description shouldBe "Elves don't need to sleep. Instead, they meditate deeply, remaining semiconscious, for 4 hours a day. (The Common word for such meditation is \"trance.\") While meditating, you can dream after a fashion; such dreams are actually mental exercises that have become reflexive through years of practice. After resting in this way, you gain the same benefit that a human does from 8 hours of sleep."
                this[2].refreshRate shouldBe Ability.SkillRefreshRate.DAY
                this[2].useCount shouldBe 1
            }
            damageAbilities.size shouldBe 0
            weaponProficiencies shouldBe listOf(Weapon.LONGBOW, Weapon.SHORTSWORD, Weapon.SHORTBOW, Weapon.LONGSWORD)
            armourProficiencies.size shouldBe 0
            proficiencies shouldBe listOf(Skill.PERCEPTION)
            languages shouldBe listOf("Common", "Dwarvish", "Elvish")
        }
    }
}
