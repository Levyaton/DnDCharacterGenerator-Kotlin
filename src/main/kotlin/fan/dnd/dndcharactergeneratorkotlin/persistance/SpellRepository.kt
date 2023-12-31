package fan.dnd.dndcharactergeneratorkotlin.persistance;

import fan.dnd.dndcharactergeneratorkotlin.domain.enumeration.ClassName
import org.springframework.data.jpa.repository.JpaRepository

interface SpellRepository : JpaRepository<SpellDao, Long> {
    fun findByClazzContaining(clazz: ClassName): Set<SpellDao>
    fun findBySpellId(spellId: Int): SpellDao
    fun getSpellByLevel(level: String): Set<SpellDao>
    fun getSpellByClazzContainingAndLevel(clazz: ClassName, level: String): Set<SpellDao>


}