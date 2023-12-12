package fan.dnd.dndcharactergeneratorkotlin.controller

import com.fasterxml.jackson.databind.ObjectMapper
import fan.dnd.dndcharactergeneratorkotlin.controller.type.PlayerIn
import fan.dnd.dndcharactergeneratorkotlin.service.PlayerService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/player")
class PlayerController(
    val playerService: PlayerService,
    val objectMapper: ObjectMapper
) {
    @PostMapping
    fun createPlayer(@RequestBody player: PlayerIn): ResponseEntity<String> {
        return ResponseEntity(objectMapper.writeValueAsString(playerService.createPlayer(player)), HttpStatus.CREATED)
    }

    @GetMapping("/{gameName}/{playerName}")
    fun getPlayer(@PathVariable gameName: String, @PathVariable playerName: String): ResponseEntity<String> = ResponseEntity.ok(objectMapper.writeValueAsString(playerService.getPlayer(gameName, playerName)))


    @PutMapping("/{id}")
    fun updatePlayer(@PathVariable id: Long, @RequestBody player: PlayerIn): ResponseEntity<String> {
        playerService.updatePlayer(id, player)
        return ResponseEntity.ok("Success")
    }

    @DeleteMapping("/{id}")
    fun deletePlayer(@PathVariable id: Long): ResponseEntity<Void> {
        playerService.deletePlayer(id)
        return ResponseEntity.noContent().build()
    }
}
