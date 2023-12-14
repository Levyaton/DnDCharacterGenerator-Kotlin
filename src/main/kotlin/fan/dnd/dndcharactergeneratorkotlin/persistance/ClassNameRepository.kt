package fan.dnd.dndcharactergeneratorkotlin.persistance

import fan.dnd.dndcharactergeneratorkotlin.domain.enumeration.ClassName
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ClassNameRepository : JpaRepository<ClassNameDao, Long>{
    fun findByName(name: ClassName): ClassNameDao?
    fun existsByName(name: ClassName): Boolean
}