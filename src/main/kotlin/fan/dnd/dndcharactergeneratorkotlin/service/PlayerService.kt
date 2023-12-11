package fan.dnd.dndcharactergeneratorkotlin.service

import com.fasterxml.jackson.core.JsonProcessingException
import fan.dnd.dndcharactergeneratorkotlin.controller.type.PlayerIn
import fan.dnd.dndcharactergeneratorkotlin.domain.Player
import fan.dnd.dndcharactergeneratorkotlin.persistance.*
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.util.*

@Service
@Transactional
class PlayerService(
    val playerRepository: PlayerRepository,
    val spellRepository: SpellRepository,
    val raceRepository: RaceRepository,
) {

    @Throws(JsonProcessingException::class)
    fun createPlayer(playerIn: PlayerIn): PlayerDao {
        val race = playerIn.race
        val raceDao = raceRepository.save(RaceDao(
            raceName = race.raceName(),
            strength = race.strength().value,
            dexterity = race.dexterity().value,
            constitution = race.constitution().value,
            intelligence = race.intelligence().value,
            charisma = race.charisma().value,
            wisdom = race.wisdom().value,
            cantrips = race.cantrips().map { spellRepository.findBySpellId(it) }.toSet(),
            spells = race.spells().map { spellRepository.findBySpellId(it) }.toSet(),
            armourProficiencies = race.armourProficiencies(),
            weaponProficiencies = race.weaponProficiencies(),
            genericAbilities = race.genericAbilities(),
            damageAbilities = race.damageAbilities(),
            proficiencies = race.proficiencies(),
            languages = race.languages(),
            otherTraits = race.otherTraits(),
            speed = race.speed(),
        ))

       return playerRepository.save(
            PlayerDao(
                gameName = playerIn.gameName,
                name = playerIn.name,
                speed = 0,
                strength = playerIn.rolledStrength,
                intelligence = playerIn.rolledIntelligence,
                charisma = playerIn.rolledCharisma,
                dexterity = playerIn.rolledDexterity,
                constitution = playerIn.rolledConstitution,
                wisdom = playerIn.rolledWisdom,
                armourProficiencies = mutableSetOf(),
                weaponProficiencies = mutableSetOf(),
                genericAbilities = mutableSetOf(),
                damageAbilities = mutableSetOf(),
                proficiencies = mutableSetOf(),
                languages = mutableSetOf(),
                cantrips = mutableSetOf(),
                spells = mutableSetOf(),
                raceId = raceDao.id,
            )
        )
    }

    fun getPlayer(gameName: String, playerName: String): Player {
        val playerDao = playerRepository.findByGameNameAndName(gameName, playerName)
        val raceDao = raceRepository.findById(playerDao.raceId).get()
        return Player(player = playerDao, race = raceDao)
    }

    fun getPlayerById(id: Long): PlayerDao = playerRepository.findById(id).get()

    fun updatePlayer(id: Long, playerIn: PlayerIn) {
        //TODO
    }

    fun deletePlayer(id: Long) {
        val playerDao = getPlayerById(id)
        raceRepository.deleteById(playerDao.raceId)
        playerRepository.deleteById(id)
    }
}
