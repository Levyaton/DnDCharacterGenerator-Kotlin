package fan.dnd.dndcharactergeneratorkotlin.service

import com.fasterxml.jackson.databind.ObjectMapper
import fan.dnd.dndcharactergeneratorkotlin.domain.enumeration.ClassName
import fan.dnd.dndcharactergeneratorkotlin.persistance.ClassNameDao
import fan.dnd.dndcharactergeneratorkotlin.persistance.ClassNameRepository
import fan.dnd.dndcharactergeneratorkotlin.persistance.SpellDao
import fan.dnd.dndcharactergeneratorkotlin.persistance.SpellRepository
import jakarta.annotation.PostConstruct
import jakarta.transaction.Transactional
import org.springframework.core.io.ResourceLoader
import org.springframework.stereotype.Service

@Service
class SpellService(
    private val objectMapper:  ObjectMapper,
    private val spellRepository: SpellRepository,
    private val resourceLoader: ResourceLoader, private val classNameRepository: ClassNameRepository,) {
    @PostConstruct
    @Transactional
    fun initializeSpells() {
        ClassName.entries.forEach {
            if(!classNameRepository.existsByName(it)) classNameRepository.save(ClassNameDao(it))
        }
        val spellsFromJson = loadSpellsFromJson()
        val spellsFromDb = spellRepository.findAll()
        if(spellsFromJson.size != spellsFromDb.size) {
            spellRepository.deleteAll()
            spellRepository.saveAll(spellsFromJson)
        }
    }

    private fun loadSpellsFromJson(): List<SpellDao> {
        val resource = resourceLoader.getResource("classpath:spells.json").inputStream.use {
            it.readBytes().toString(Charsets.UTF_8)
        }
        return objectMapper.readValue(resource, objectMapper.typeFactory.constructCollectionType(List::class.java, SpellDao::class.java))
    }
}