package fan.dnd.dndcharactergeneratorkotlin.service

import com.fasterxml.jackson.core.JsonProcessingException
import com.fasterxml.jackson.databind.ObjectMapper
import fan.dnd.dndcharactergeneratorkotlin.controller.type.PlayerIn
import fan.dnd.dndcharactergeneratorkotlin.persistance.PlayerDao
import fan.dnd.dndcharactergeneratorkotlin.persistance.PlayerRepository
import fan.dnd.dndcharactergeneratorkotlin.persistance.RaceDao
import fan.dnd.dndcharactergeneratorkotlin.persistance.RaceRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.util.*

@Service
@Transactional
class PlayerService(
    val playerRepository: PlayerRepository,
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
            cantrips = race.cantrips(),
            spells = race.spells(),
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
                name = playerIn.name,
                speed = playerIn.race.speed(),
                strength = playerIn.rolledStrength + race.strength().value,
                intelligence = playerIn.rolledIntelligence + race.intelligence().value,
                charisma = playerIn.rolledCharisma + race.charisma().value,
                dexterity = playerIn.rolledDexterity + race.dexterity().value,
                constitution = playerIn.rolledConstitution + race.constitution().value,
                wisdom = playerIn.rolledWisdom + race.wisdom().value,
                armourProficiencies = race.armourProficiencies().toMutableSet(),
                weaponProficiencies = race.weaponProficiencies().toMutableSet(),
                genericAbilities = race.genericAbilities().toMutableSet(),
                damageAbilities = race.damageAbilities().toMutableSet(),
                proficiencies = race.proficiencies().toMutableSet(),
                languages = race.languages().toMutableSet(),
                cantrips = race.cantrips().toMutableSet(),
                spells = race.spells().toMutableSet(),
                raceId = raceDao.id,
            )
        )
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
