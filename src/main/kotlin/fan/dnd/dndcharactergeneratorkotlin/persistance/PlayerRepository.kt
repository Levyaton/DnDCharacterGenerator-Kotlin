package fan.dnd.dndcharactergeneratorkotlin.persistance

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface PlayerRepository : JpaRepository<PlayerDao, Long> {
    fun findByName(name: String): PlayerDao
}