package fan.dnd.dndcharactergeneratorkotlin.persistance

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface RaceRepository : JpaRepository<RaceDao, Long> {

}